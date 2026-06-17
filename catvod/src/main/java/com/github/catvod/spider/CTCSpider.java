package com.github.catvod.spider;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.CryptoUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * CTCSpider - China Telecom IPTV spider.
 *
 * Auth flow: EDS-based 3-step authentication.
 * Category structure: SDMS root IDs with Haikan (HK) category management.
 * Caching: LRU maps (500 general, 2000 program cache).
 */
public class CTCSpider extends Spider {

    // ── Auth params ──────────────────────────────────────────────
    private static final long AUTH_TTL = 600000;

    private String edsServer = "150.138.19.165:33200";
    private String encryptKey = "";
    private String userId = "";
    private String stbId = "";
    private String mac = "";
    private String stbType = "";
    private String stbVersion = "V83321337.1005";
    private String interfaceSuffix = "CTC";
    private String netUserId = "SDIPTVPPPOE@sdiptv";
    private String lastActiveFastIp = "";

    // ── SDMS params ──────────────────────────────────────────────
    private String sdmsHost = "150.138.11.129";
    private int sdmsStaticPort = 86;
    private int sdmsSearchPort = 81;
    private String shicBase = "http://150.139.139.136:18000/sddx-tv-portal/api/v1";

    // ── Runtime state ────────────────────────────────────────────
    private volatile boolean authed = false;
    private volatile String localIp = "127.0.0.1";
    private long authTime = 0;
    private volatile boolean heartbeatRunning = false;
    private Thread heartbeatThread;
    private CookieManager cookieManager;
    private String epgHost;
    private String indexFilePath;

    // ── Caches ───────────────────────────────────────────────────
    private final Map<String, Object> cache = createLRU(500);
    private final Map<String, JSONObject> programCache = createLRU(2000);

    // ── Search index ─────────────────────────────────────────────
    private final ConcurrentHashMap<String, String> searchIndex = new ConcurrentHashMap<>();
    private volatile boolean searchIndexBuilt = false;
    private volatile boolean searchIndexBuilding = false;
    private String indexTimestamp = "";

    // ── Preloaded recommendations ────────────────────────────────
    private volatile JSONArray preloadedRecList = null;

    // ── HK category management ───────────────────────────────────
    private static final Map<String, String> HK_SUB_PREFIX_MAP = new HashMap<>();
    private static final String[] SDMS_ROOT_IDS = {
        "1020", "1052", "1043", "1036", "1054", "1067", "1045", "1044",
        "1048", "1062", "1061", "1073", "1074", "1079", "1056", "1039",
        "1035", "1041", "1059", "1049", "1050", "1053", "1063", "1066", "1051"
    };

    private static final String[] HK_HIDDEN_CATEGORIES = {
        "海看应用商城", "智慧广电", "旅游视野测试", "奇艺专区",
        "腾讯专区", "优酷专区", "CNTV4", "地市专区_联通", "海看科教"
    };
    private static final String[] HK_MERGE_CATEGORIES = {
        "本地", "视博云电竞", "灯塔", "地市专区_电信3.0", "专享客户", "短视频"
    };
    private static final String[][] HK_EXPAND_ORDER = {
        {"海看专区", "海看专区"},
        {"海看专享", "海看专享"},
        {"CNTV2", "CNTV2"},
        {"高清20分类", "高清20分类"}
    };
    private static final String[] HK_SUB_SORT_LAST_1020 = {
        "动画明星", "75周年中老年优秀作品展播", "百视通SP专区",
        "付费单片", "海看乐玩", "海看爱宠", "海看广场舞",
        "山东新闻专区", "我们的小康2020", "海看枫龄"
    };

    private static final String[] NON_VOD_CODES = {
        "DCFLine1", "DCFLine2", "DCFLine3", "DCFLine4", "DCFLine5"
    };

    // ── Content provider naming ──────────────────────────────────
    private static final Map<String, String> PREFIX_NAMES = new HashMap<>();
    private static final Map<String, String> CODE_TRANSFORMS = new HashMap<>();
    private static final List<String> SDK_PREFIXES = new ArrayList<>();
    private static final List<String> _PREFIX_ORDER = new ArrayList<>();

    static {
        // ── HK sub prefix map ──
        HK_SUB_PREFIX_MAP.put("1054", "EPG");

        // ── SDK prefixes ──
        SDK_PREFIXES.add("JLTM");

        // ── Prefix display order ──
        String[] prefixOrder = {
            "JIECHENGHUASHIU", "JIECHENGHUASHI", "JIECHENG",
            "YUESHITONG",
            "MGTV_HKPRO", "MGTV_XY", "MGTV_SERIES", "MGTV_HK", "MGTV",
            "GUOQY_ser_", "GUOQY_ser", "GUOQY_pro", "GUOQY",
            "BESTVWIN", "BESTVLOC", "BESTV",
            "BLBLP0", "BLBLP", "BLBLU",
            "HUASHUNM", "HUASH",
            "WLXHAcc", "WLXH",
            "JIZRpcmzc", "JIZDL", "JIZRsc", "JIZR",
            "WOKANU", "WOKAN",
            "YANHUA", "senyucp",
            "XHUANWANGseri", "XHUANWANG", "XHUANW",
            "ZhongL", "BAOBAO", "PUXIN", "LIZHI", "XINGYUN",
            "SHIY_S", "SHIY",
            "YZZHSER",
            "YHYKMLT", "YHYKMDX", "YHYKQTS",
            "JZTXs", "JZTX_mzc", "JZTX_", "JZTX000005", "JZTX", "JZTQ",
            "JLTM",
            "JHTZff", "JHTZ",
            "SZLT04", "ser", "2110MAMS", "YUNWEI", "PR"
        };
        for (String p : prefixOrder) {
            _PREFIX_ORDER.add(p);
        }

        // ── Prefix name mapping ──
        PREFIX_NAMES.put("JIECHENG", "华视网聚");
        PREFIX_NAMES.put("JIECHENGHUASHI", "华视网聚");
        PREFIX_NAMES.put("JIECHENGHUASHIU", "华视网聚");
        PREFIX_NAMES.put("YUESHITONG", "悦视通");
        PREFIX_NAMES.put("MGTV", "芒果TV");
        PREFIX_NAMES.put("MGTV_HKPRO", "芒果TV");
        PREFIX_NAMES.put("MGTV_XY", "芒果TV");
        PREFIX_NAMES.put("MGTV_SERIES", "芒果TV");
        PREFIX_NAMES.put("MGTV_HK", "芒果TV");
        PREFIX_NAMES.put("GUOQY", "爱奇艺");
        PREFIX_NAMES.put("GUOQY_ser", "爱奇艺");
        PREFIX_NAMES.put("GUOQY_pro", "爱奇艺");
        PREFIX_NAMES.put("GUOQY_ser_", "爱奇艺");
        PREFIX_NAMES.put("BESTV", "百视通");
        PREFIX_NAMES.put("BESTVWIN", "百视通");
        PREFIX_NAMES.put("BESTVLOC", "百视通");
        PREFIX_NAMES.put("BLBLP0", "哔哩哔哩");
        PREFIX_NAMES.put("BLBLP", "哔哩哔哩");
        PREFIX_NAMES.put("BLBLU", "哔哩哔哩");
        PREFIX_NAMES.put("HUASH", "华数");
        PREFIX_NAMES.put("HUASHUNM", "华数");
        PREFIX_NAMES.put("WLXH", "未来电视");
        PREFIX_NAMES.put("WLXHAcc", "未来电视");
        PREFIX_NAMES.put("JIZR", "腾讯视频");
        PREFIX_NAMES.put("JIZRpcmzc", "腾讯视频");
        PREFIX_NAMES.put("JIZDL", "腾讯视频");
        PREFIX_NAMES.put("JIZRsc", "腾讯视频");
        PREFIX_NAMES.put("WOKAN", "搜狐视频");
        PREFIX_NAMES.put("WOKANU", "搜狐视频");
        PREFIX_NAMES.put("YANHUA", "岩华");
        PREFIX_NAMES.put("senyucp", "森宇股份");
        PREFIX_NAMES.put("XHUANW", "广州欢网");
        PREFIX_NAMES.put("XHUANWANG", "广州欢网");
        PREFIX_NAMES.put("XHUANWANGseri", "广州欢网");
        PREFIX_NAMES.put("XHUANWANGprog", "广州欢网");
        PREFIX_NAMES.put("ZhongL", "中录文化");
        PREFIX_NAMES.put("BAOBAO", "宝宝巴士");
        PREFIX_NAMES.put("PUXIN", "普信文化");
        PREFIX_NAMES.put("LIZHI", "荔枝TV");
        PREFIX_NAMES.put("XINGYUN", "杭州漫视");
        PREFIX_NAMES.put("SHIY", "视园");
        PREFIX_NAMES.put("SHIY_S", "视园");
        PREFIX_NAMES.put("YZZHSER", "悦众智合");
        PREFIX_NAMES.put("YHYKMLT", "优酷");
        PREFIX_NAMES.put("YHYKMDX", "优酷");
        PREFIX_NAMES.put("YHYKQTS", "优酷");
        PREFIX_NAMES.put("JZTX", "极智");
        PREFIX_NAMES.put("JZTXs", "极智");
        PREFIX_NAMES.put("JZTX_", "极智");
        PREFIX_NAMES.put("JZTX_mzc", "极智");
        PREFIX_NAMES.put("JZTX000005", "极智");
        PREFIX_NAMES.put("JZTQ", "极光");
        PREFIX_NAMES.put("JLTM", "极光");
        PREFIX_NAMES.put("JHTZ", "极光");
        PREFIX_NAMES.put("JHTZff", "极光");
        PREFIX_NAMES.put("SZLT04", "数字联通");
        PREFIX_NAMES.put("ser", "其他");
        PREFIX_NAMES.put("JOYU", "聚鱼");
        PREFIX_NAMES.put("2110MAMS", "宣传片");
        PREFIX_NAMES.put("YUNWEI", "运维");
        PREFIX_NAMES.put("PR", "推荐位");
        PREFIX_NAMES.put("BSTSDDX0", "百视通");
        PREFIX_NAMES.put("SWWLJT01", "视博云");
        PREFIX_NAMES.put("YJYDJ000", "电竞");
        PREFIX_NAMES.put("YJY008", "银行");
        PREFIX_NAMES.put("XSGQ0000", "选手");
        PREFIX_NAMES.put("NFWLqqmu", "南方");
        PREFIX_NAMES.put("umai", "合智");

        // ── Code transforms ──
        CODE_TRANSFORMS.put("YHYKMLT", "YHYKQTS");
        CODE_TRANSFORMS.put("JZTX_", "JZTQ_");
        CODE_TRANSFORMS.put("GUOQY_ser_", "GUOQY_pro_");
    }

    // ═══════════════════════════════════════════════════════════════
    // LRU cache factory
    // ═══════════════════════════════════════════════════════════════

    @SuppressWarnings("serial")
    private static <K, V> Map<K, V> createLRU(final int maxSize) {
        return Collections.synchronizedMap(new LinkedHashMap<K, V>(maxSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxSize;
            }
        });
    }

    // ═══════════════════════════════════════════════════════════════
    // init
    // ═══════════════════════════════════════════════════════════════

    @Override
    public void init(android.content.Context context, String extJsonStr) {
        try { super.init(context, extJsonStr); } catch (Exception ignored) {}
        if (extJsonStr != null && !extJsonStr.isEmpty()) {
            // 先尝试解密 ext（格式: "1:<hex>"）
            extJsonStr = CryptoUtil.unwrap(extJsonStr);
            try {
                if (extJsonStr.startsWith("{")) {
                    JSONObject ext = new JSONObject(extJsonStr);
                    if (ext.has("edsServer")) this.edsServer = ext.getString("edsServer");
                    if (ext.has("encryptKey")) this.encryptKey = ext.getString("encryptKey");
                    if (ext.has("key")) this.encryptKey = ext.getString("key");
                    if (ext.has("userId")) this.userId = ext.getString("userId");
                    if (ext.has("user_id")) this.userId = ext.getString("user_id");
                    if (ext.has("stbId")) this.stbId = ext.getString("stbId");
                    if (ext.has("stb_id")) this.stbId = ext.getString("stb_id");
                    if (ext.has("mac")) this.mac = ext.getString("mac");
                    if (ext.has("stbType")) this.stbType = ext.getString("stbType");
                    if (ext.has("stb_type")) this.stbType = ext.getString("stb_type");
                    if (ext.has("stbVersion")) this.stbVersion = ext.getString("stbVersion");
                    if (ext.has("interfaceSuffix")) this.interfaceSuffix = ext.getString("interfaceSuffix");
                    if (ext.has("netUserId")) this.netUserId = ext.getString("netUserId");
                    if (ext.has("sdmsHost")) this.sdmsHost = ext.getString("sdmsHost");
                    if (ext.has("sdmsStaticPort")) this.sdmsStaticPort = ext.optInt("sdmsStaticPort", this.sdmsStaticPort);
                    if (ext.has("sdmsSearchPort")) this.sdmsSearchPort = ext.optInt("sdmsSearchPort", this.sdmsSearchPort);
                    if (ext.has("shicBase")) this.shicBase = ext.getString("shicBase");
                } else if (extJsonStr.contains("$")) {
                    String[] parts = extJsonStr.split("\\$");
                    if (parts.length >= 1 && !parts[0].isEmpty()) this.encryptKey = parts[0];
                    if (parts.length >= 2 && !parts[1].isEmpty()) this.userId = parts[1];
                    if (parts.length >= 3 && !parts[2].isEmpty()) this.stbId = parts[2];
                    if (parts.length >= 4 && !parts[3].isEmpty()) this.mac = parts[3];
                    if (parts.length >= 5 && !parts[4].isEmpty()) this.stbType = parts[4];
                }
            } catch (Exception ignored) {
            }
        }

        try {
            this.indexFilePath = context.getCacheDir() + "/ctc_search_index.txt";
        } catch (Exception ignored) {
        }

        // CookieManager setup for EPG session cookies
        cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        // Background initialization
        new Thread(new Runnable() {
            @Override
            public void run() {
                searchIndexBuilding = true;
                detectLocalIp();
                login();
                loadSearchIndex();
                searchIndexBuilt = true;
                searchIndexBuilding = false;
                preloadRecommendations();
            }
        }).start();
    }

    // ═══════════════════════════════════════════════════════════════
    // Auth: EDS-based 3-step login
    // ═══════════════════════════════════════════════════════════════

    private synchronized boolean login() {
        try {
            SpiderDebug.log("CTC login edsServer=" + this.edsServer + " userId=" + this.userId);

            // Step 1: Get EDS authentication redirect — extracts epgHost
            httpGetFullUrl(String.format(
                "http://%s/EDS/jsp/AuthenticationURL?UserID=%s&Action=Login&FCCSupport=1",
                this.edsServer, URLEncoder.encode(this.userId, "UTF-8")));

            String host = this.epgHost;
            if (host == null || host.isEmpty()) {
                return false;
            }

            // Step 2: Login to HW auth JSP — get EncryptToken
            String step2Url = String.format(
                "http://%s/EPG/jsp/authLoginHW%s.jsp", host, this.interfaceSuffix);
            String step2Data = "UserID=" + URLEncoder.encode(this.userId, "UTF-8") + "&VIP=";
            String step2Result = httpPost(step2Url, step2Data);
            if (step2Result == null) {
                return false;
            }

            Matcher m = Pattern.compile("EncryptToken\\s*=\\s*\"([^\"]+)\"").matcher(step2Result);
            if (!m.find()) {
                return false;
            }
            String encryptToken = m.group(1);

            // Step 3: Validate authentication
            long randomNum = (long) (Math.random() * 9.0E7d) + 10000000L;
            String rawAuth = String.format("%d$%s$%s$%s$%s$%s$$CTC",
                randomNum, encryptToken, this.userId, this.stbId, this.localIp, this.mac);
            String authenticator = desEncrypt(rawAuth, this.encryptKey);

            String step3Url = String.format(
                "http://%s/EPG/jsp/ValidAuthenticationHW%s.jsp", host, this.interfaceSuffix);
            String step3Data = "UserID=" + URLEncoder.encode(this.userId, "UTF-8")
                + "&Lang=0&SupportHD=1"
                + "&NetUserID=" + URLEncoder.encode(this.netUserId, "UTF-8")
                + "&Authenticator=" + URLEncoder.encode(authenticator, "UTF-8")
                + "&STBType=" + URLEncoder.encode(this.stbType, "UTF-8")
                + "&STBVersion=" + URLEncoder.encode(this.stbVersion, "UTF-8")
                + "&conntype=dhcp"
                + "&STBID=" + URLEncoder.encode(this.stbId, "UTF-8")
                + "&templateName=&areaId="
                + "&userToken=" + URLEncoder.encode(encryptToken, "UTF-8")
                + "&userGroupId=&productPackageId="
                + "&mac=" + URLEncoder.encode(this.mac, "UTF-8")
                + "&UserField="
                + "&SoftwareVersion=" + URLEncoder.encode(this.stbVersion, "UTF-8")
                + "&IsSmartStb=undefined&desktopId=undefined&stbmaker=&VIP=";
            httpPost(step3Url, step3Data);

            this.authed = true;
            this.authTime = System.currentTimeMillis();
            SpiderDebug.log("CTC login success, epgHost=" + this.epgHost);
            startHeartbeat();
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    private boolean ensureAlive() {
        String currentFastIp = getLocalIpFast();
        boolean networkChanged = !currentFastIp.equals(this.lastActiveFastIp);
        if (networkChanged) {
            SpiderDebug.log("CTCSpider network changed! Old=" + this.lastActiveFastIp + ", New=" + currentFastIp);
            this.lastActiveFastIp = currentFastIp;
            this.localIp = "127.0.0.1"; // Force re-detection
        }

        if (this.authed && !networkChanged && System.currentTimeMillis() - this.authTime < AUTH_TTL) {
            return true;
        }
        stopHeartbeat();
        this.authed = false;
        this.cookieManager.getCookieStore().removeAll();
        return login();
    }

    private void startHeartbeat() {
        if (this.heartbeatRunning) return;
        this.heartbeatRunning = true;
        this.heartbeatThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (heartbeatRunning && authed) {
                    try {
                        Thread.sleep(300000L);
                        if (!heartbeatRunning) return;
                        if (System.currentTimeMillis() - authTime >= AUTH_TTL) {
                            stopHeartbeat();
                            authed = false;
                            cookieManager.getCookieStore().removeAll();
                            if (!login()) {
                                heartbeatRunning = false;
                                return;
                            }
                        }
                    } catch (Exception e) {
                        heartbeatRunning = false;
                        return;
                    }
                }
            }
        }, "CTC-Heartbeat");
        this.heartbeatThread.setDaemon(true);
        this.heartbeatThread.start();
    }

    private void stopHeartbeat() {
        this.heartbeatRunning = false;
        if (this.heartbeatThread != null) {
            this.heartbeatThread.interrupt();
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // DES encrypt
    // ═══════════════════════════════════════════════════════════════

    private String desEncrypt(String str, String key) {
        while (key.length() < 8) {
            key = key + "0";
        }
        try {
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
            byte[] srcBytes = str.getBytes(StandardCharsets.UTF_8);
            int length = ((srcBytes.length / 8) + 1) * 8;
            byte[] paddingBytes = new byte[length];
            System.arraycopy(srcBytes, 0, paddingBytes, 0, srcBytes.length);
            for (int i = srcBytes.length; i < length; i++) {
                paddingBytes[i] = (byte) (length - srcBytes.length);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher.doFinal(paddingBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : encrypted) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            return "";
        }
    }

    private void detectLocalIp() {
        try {
            String ip = this.edsServer.split(":")[0];
            int port = this.edsServer.contains(":")
                ? Integer.parseInt(this.edsServer.split(":")[1]) : 33200;
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 3000);
            this.localIp = socket.getLocalAddress().getHostAddress();
            socket.close();
        } catch (Exception ignored) {
        }
    }

    private String getLocalIpFast() {
        try {
            for (java.util.Enumeration<java.net.NetworkInterface> en = java.net.NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                java.net.NetworkInterface intf = en.nextElement();
                for (java.util.Enumeration<java.net.InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    java.net.InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception ex) {}
        return "127.0.0.1";
    }

    // ═══════════════════════════════════════════════════════════════
    // homeContent — category tree
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String homeContent(boolean filter) {
        try {
            JSONObject result = new JSONObject();
            JSONArray classes = new JSONArray();
            JSONObject filters = new JSONObject();

            // Iterate SDMS root IDs to build the category tree
            for (String rootId : SDMS_ROOT_IDS) {
                JSONArray subCats = getCategories(rootId);
                if (subCats == null || subCats.length() == 0) continue;

                // Get the root category name from the first-level category list
                String rootName = "分类" + rootId;

                // For root 1020, apply HK category management
                if ("1020".equals(rootId)) {
                    List<JSONObject> managedCats = manageHKCategories(subCats);
                    // Add the root "1020" itself as a class
                    JSONObject cls = new JSONObject();
                    cls.put("type_id", rootId);
                    cls.put("type_name", rootName);
                    classes.put(cls);

                    if (filter && managedCats.size() > 0) {
                        JSONArray subList = new JSONArray();
                        JSONObject all = new JSONObject();
                        all.put("n", "全部");
                        all.put("v", "");
                        subList.put(all);

                        // Apply special sort: items matching HK_SUB_SORT_LAST_1020 go last
                        Collections.sort(managedCats, new Comparator<JSONObject>() {
                            @Override
                            public int compare(JSONObject a, JSONObject b) {
                                String nameA = a.optString("name", "");
                                String nameB = b.optString("name", "");
                                boolean lastA = false, lastB = false;
                                for (String s : HK_SUB_SORT_LAST_1020) {
                                    if (nameA.contains(s)) lastA = true;
                                    if (nameB.contains(s)) lastB = true;
                                }
                                if (lastA != lastB) return lastA ? 1 : -1;
                                return 0;
                            }
                        });

                        for (JSONObject sub : managedCats) {
                            String subId = sub.optString("primaryid", sub.optString("id", ""));
                            String subName = sub.optString("name", "");
                            if (subId.isEmpty() || subName.isEmpty()) continue;
                            JSONObject item = new JSONObject();
                            item.put("n", subName);
                            item.put("v", subId);
                            subList.put(item);
                        }

                        if (subList.length() > 1) {
                            JSONArray filterArr = new JSONArray();
                            JSONObject filterObj = new JSONObject();
                            filterObj.put("key", "sub");
                            filterObj.put("name", "分类");
                            filterObj.put("value", subList);
                            filterArr.put(filterObj);
                            filters.put(rootId, filterArr);
                        }
                    }
                    continue;
                }

                // For other root IDs: add each sub-category as a class
                for (int j = 0; j < subCats.length(); j++) {
                    JSONObject sub = subCats.getJSONObject(j);
                    String subId = sub.optString("primaryid", sub.optString("id", ""));
                    String subName = sub.optString("name", "");
                    if (subId.isEmpty() || subName.isEmpty()) continue;

                    JSONObject cls = new JSONObject();
                    cls.put("type_id", subId);
                    cls.put("type_name", subName);
                    classes.put(cls);

                    if (filter) {
                        JSONArray grandSubs = getCategories(subId);
                        if (grandSubs != null && grandSubs.length() > 0) {
                            JSONArray subList = new JSONArray();
                            JSONObject all = new JSONObject();
                            all.put("n", "全部");
                            all.put("v", "");
                            subList.put(all);
                            for (int k = 0; k < grandSubs.length(); k++) {
                                JSONObject gs = grandSubs.getJSONObject(k);
                                String gsId = gs.optString("primaryid", gs.optString("id", ""));
                                String gsName = gs.optString("name", "");
                                if (gsId.isEmpty() || gsName.isEmpty()) continue;
                                JSONObject item = new JSONObject();
                                item.put("n", gsName);
                                item.put("v", gsId);
                                subList.put(item);
                            }
                            if (subList.length() > 1) {
                                JSONArray filterArr = new JSONArray();
                                JSONObject filterObj = new JSONObject();
                                filterObj.put("key", "sub");
                                filterObj.put("name", "分类");
                                filterObj.put("value", subList);
                                filterArr.put(filterObj);
                                filters.put(subId, filterArr);
                            }
                        }
                    }
                }
            }

            result.put("class", classes);
            if (filter && filters.length() > 0) {
                result.put("filters", filters);
            }

            // Load existing search index
            loadSearchIndex();
            if (!searchIndex.isEmpty() && !searchIndexBuilt) {
                searchIndexBuilt = true;
            }

            // Start background index building if needed
            if (!searchIndexBuilt && !searchIndexBuilding) {
                searchIndexBuilding = true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        buildSearchIndex(false);
                        searchIndexBuilding = false;
                    }
                }).start();
            }

            return result.toString();
        } catch (Exception e) {
            return "{\"class\":[]}";
        }
    }

    /**
     * Apply HK category management rules: remove hidden, flatten merged,
     * expand designated categories.
     */
    private List<JSONObject> manageHKCategories(JSONArray subCats) {
        List<JSONObject> result = new ArrayList<>();
        if (subCats == null) return result;

        for (int i = 0; i < subCats.length(); i++) {
            try {
                JSONObject cat = subCats.getJSONObject(i);
                String name = cat.optString("name", "");

                // Skip hidden categories
                if (isHiddenCategory(name)) continue;

                // Expand: promote children to same level
                boolean expanded = false;
                for (String[] pair : HK_EXPAND_ORDER) {
                    if (pair[0].equals(name)) {
                        String catId = cat.optString("primaryid", cat.optString("id", ""));
                        if (!catId.isEmpty()) {
                            JSONArray children = getCategories(catId);
                            if (children != null) {
                                for (int j = 0; j < children.length(); j++) {
                                    try {
                                        JSONObject child = children.getJSONObject(j);
                                        String childName = child.optString("name", "");
                                        if (!isHiddenCategory(childName)) {
                                            result.add(child);
                                        }
                                    } catch (Exception ignored) {
                                    }
                                }
                            }
                        }
                        expanded = true;
                        break;
                    }
                }
                if (expanded) continue;

                // Merge: flatten children (add children directly, skip parent)
                if (isMergeCategory(name)) {
                    String catId = cat.optString("primaryid", cat.optString("id", ""));
                    if (!catId.isEmpty()) {
                        JSONArray children = getCategories(catId);
                        if (children != null) {
                            for (int j = 0; j < children.length(); j++) {
                                try {
                                    result.add(children.getJSONObject(j));
                                } catch (Exception ignored) {
                                }
                            }
                        }
                    }
                    continue;
                }

                // Normal: add as-is
                result.add(cat);
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    private boolean isHiddenCategory(String name) {
        for (String h : HK_HIDDEN_CATEGORIES) {
            if (h.equals(name)) return true;
        }
        return false;
    }

    private boolean isMergeCategory(String name) {
        for (String m : HK_MERGE_CATEGORIES) {
            if (m.equals(name)) return true;
        }
        return false;
    }

    // ═══════════════════════════════════════════════════════════════
    // homeVideoContent — home page video list
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String homeVideoContent() {
        try {
            JSONObject result = new JSONObject();
            result.put("list", buildRecList());
            return result.toString();
        } catch (Exception e) {
            return "{\"list\":[]}";
        }
    }

    private JSONArray buildRecList() {
        JSONArray list = new JSONArray();
        try {
            JSONObject update = new JSONObject();
            update.put("vod_id", "__update_index__");
            update.put("vod_name", "更新搜索索引");
            update.put("vod_pic", "");
            StringBuilder sb = new StringBuilder();
            sb.append(this.searchIndex.size()).append("部");
            if (!this.indexTimestamp.isEmpty()) {
                sb.append(" ").append(this.indexTimestamp);
            }
            update.put("vod_remarks", sb.toString());
            list.put(update);
        } catch (Exception ignored) {
        }

        if (this.preloadedRecList != null) {
            for (int i = 1; i < this.preloadedRecList.length(); i++) {
                try {
                    list.put(this.preloadedRecList.getJSONObject(i));
                } catch (Exception ignored) {
                }
            }
        } else {
            Set<String> added = new HashSet<>();
            String[] recCats = {"1020005023", "1020009013", "1020002001", "1020008020"};
            for (String catId : recCats) {
                try {
                    JSONObject progs = getPrograms(catId, 1);
                    if (progs != null) {
                        addHomeItems(progs, list, added, 5);
                    }
                } catch (Exception ignored) {
                }
                if (list.length() >= 21) break;
            }
        }
        return list;
    }

    private void addHomeItems(JSONObject programs, JSONArray list, Set<String> added, int max) {
        JSONArray items = programs.optJSONArray("list");
        if (items == null) return;

        int count = 0;
        for (int i = 0; i < items.length() && count < max; i++) {
            try {
                JSONObject item = items.getJSONObject(i);
                String code = item.optString("code", item.optString("telecomcode", ""));
                if (added.contains(code)) continue;
                added.add(code);

                String name = item.optString("name", "");
                if (name.isEmpty()) continue;

                String pic = fixImageUrl(item.optString("fileurl", item.optString("poster", "")));
                String seriesFlag = item.optString("seriesflag", "0");
                String remarks = "1".equals(seriesFlag)
                    ? getPrefix(code) + " 连续剧" : getPrefix(code);

                JSONObject vod = new JSONObject();
                vod.put("vod_id", code);
                vod.put("vod_name", name);
                vod.put("vod_pic", pic);
                vod.put("vod_remarks", remarks);
                list.put(vod);
                count++;
            } catch (Exception ignored) {
            }
        }
    }

    private void preloadRecommendations() {
        try {
            JSONArray list = new JSONArray();

            JSONObject update = new JSONObject();
            update.put("vod_id", "__update_index__");
            update.put("vod_name", "更新搜索索引");
            update.put("vod_pic", "");
            StringBuilder sb = new StringBuilder();
            sb.append(this.searchIndex.size()).append("部");
            if (!this.indexTimestamp.isEmpty()) {
                sb.append(" ").append(this.indexTimestamp);
            }
            update.put("vod_remarks", sb.toString());
            list.put(update);

            Set<String> added = new HashSet<>();
            String[] recCats = {"1020005023", "1020009013", "1020002001", "1020008020"};
            for (String catId : recCats) {
                try {
                    JSONObject progs = getPrograms(catId, 1);
                    if (progs != null) {
                        addHomeItems(progs, list, added, 5);
                    }
                } catch (Exception ignored) {
                }
                if (list.length() >= 21) break;
            }

            if (list.length() > 1) {
                this.preloadedRecList = list;
            }
        } catch (Exception ignored) {
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // categoryContent
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String categoryContent(String tid, String pg, boolean filter,
                                  HashMap<String, String> extend) {
        try {
            JSONObject result = new JSONObject();
            JSONArray list = new JSONArray();
            int page = Integer.parseInt(pg);

            String sub = (extend != null) ? extend.get("sub") : null;
            String catId = (sub != null && !sub.isEmpty()) ? sub : tid;
            boolean isRoot = (sub == null || sub.isEmpty() || sub.equals(tid));

            collectPrograms(catId, page, 20, list);

            if (list.length() == 0 && isRoot) {
                // Try sub-categories
                JSONArray subCats = getCategories(catId);
                if (subCats != null && subCats.length() > 0) {
                    for (int i = 0; i < subCats.length() && list.length() < 200; i++) {
                        try {
                            String subId = subCats.getJSONObject(i)
                                .optString("primaryid", "");
                            if (!subId.isEmpty()) {
                                collectPrograms(subId, 1, 20, list);
                            }
                        } catch (Exception ignored) {
                        }
                    }
                }
            }

            JSONObject progs = getPrograms(catId, page);
            int pageCount = (progs != null) ? progs.optInt("pagecount", 1) : 1;

            result.put("page", page);
            result.put("pagecount", pageCount);
            result.put("list", list);
            return result.toString();
        } catch (Exception e) {
            return "{\"list\":[]}";
        }
    }

    private void collectPrograms(String catId, int page, int count, JSONArray list) {
        JSONObject progs = getPrograms(catId, page);
        if (progs == null) return;

        JSONArray items = progs.optJSONArray("list");
        if (items == null) return;

        for (int i = 0; i < items.length(); i++) {
            try {
                JSONObject item = items.getJSONObject(i);
                String code = item.optString("code", item.optString("telecomcode", ""));
                String name = item.optString("name", "");
                if (name.isEmpty()) continue;

                String pic = fixImageUrl(item.optString("fileurl", item.optString("poster", "")));
                String seriesFlag = item.optString("seriesflag", "0");
                String remarks = "1".equals(seriesFlag)
                    ? getPrefix(code) + " 连续剧" : getPrefix(code);

                JSONObject vod = new JSONObject();
                vod.put("vod_id", code);
                vod.put("vod_name", name);
                vod.put("vod_pic", pic);
                vod.put("vod_remarks", remarks);
                list.put(vod);
            } catch (Exception ignored) {
            }
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // detailContent
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String detailContent(List<String> ids) {
        try {
            JSONArray list = new JSONArray();
            for (String id : ids) {
                if ("__update_index__".equals(id)) {
                    JSONObject vod = new JSONObject();
                    vod.put("vod_id", "__update_index__");
                    vod.put("vod_name", "更新搜索索引");
                    vod.put("vod_pic", "");
                    vod.put("vod_play_from", "索引管理");
                    vod.put("vod_content",
                        "当前索引: " + this.searchIndex.size() + " 部影片\n" +
                        "索引日期: " + (this.indexTimestamp.isEmpty() ? "未知" : this.indexTimestamp) + "\n\n" +
                        "点击下方\"播放\"按钮开始全量更新索引\n" +
                        "更新完成后自动保存，下次启动无需重新拉取");
                    vod.put("vod_play_url", "开始更新索引$__start_update__");
                    list.put(vod);
                } else {
                    JSONObject detail = buildDetail(id);
                    if (detail != null) {
                        list.put(detail);
                    }
                }
            }
            JSONObject result = new JSONObject();
            result.put("list", list);
            return result.toString();
        } catch (Exception e) {
            return "{\"list\":[]}";
        }
    }

    private JSONObject buildDetail(String id) {
        try {
            String realCode = id.startsWith("vsp_") ? id.substring(4) :
                             id.startsWith("hk_")  ? id.substring(3) : id;

            if (id.startsWith("vsp_")) {
                return buildVspDetail(realCode);
            }

            JSONObject vod = new JSONObject();
            vod.put("vod_id", id);
            vod.put("vod_name", id);
            vod.put("vod_play_from", "电信IPTV");

            JSONObject detail = getDetail(realCode);
            if (detail != null) {
                vod.put("vod_name", detail.optString("name", id));
                vod.put("vod_year", detail.optString("releaseyear", ""));
                vod.put("vod_area", detail.optString("originalcountry", ""));
                vod.put("vod_actor", detail.optString("actordisplay", ""));
                vod.put("vod_director", detail.optString("director", ""));
                vod.put("vod_content", detail.optString("description", ""));

                JSONArray pictures = detail.optJSONArray("picturelist");
                if (pictures != null) {
                    for (int i = 0; i < pictures.length(); i++) {
                        JSONObject pic = pictures.getJSONObject(i);
                        if ("2".equals(pic.optString("type"))
                            && !pic.optString("fileurl", "").isEmpty()) {
                            vod.put("vod_pic", fixImageUrl(pic.optString("fileurl")));
                            break;
                        }
                    }
                }

                JSONArray series = detail.optJSONArray("serieslist");
                if (series != null && series.length() > 0) {
                    StringBuilder playUrl = new StringBuilder();
                    for (int i = 0; i < series.length(); i++) {
                        JSONObject ep = series.getJSONObject(i);
                        if (i > 0) playUrl.append("#");
                        playUrl.append(ep.optString("name", "第" + (i + 1) + "集"));
                        playUrl.append("$hk_").append(ep.optString("code", ""));
                    }
                    vod.put("vod_play_url", playUrl.toString());
                    return vod;
                }
            }

            vod.put("vod_play_url", "播放$hk_" + realCode);
            return vod;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject buildVspDetail(String id) {
        try {
            JSONObject vod = new JSONObject();
            vod.put("vod_id", "vsp_" + id);
            vod.put("vod_name", id);
            vod.put("vod_play_from", "电信IPTV");

            JSONObject vspDetail = getVspVodDetail(id);
            if (vspDetail == null) {
                vod.put("vod_play_url", "播放$vsp_" + id);
                return vod;
            }

            JSONObject vd = vspDetail.optJSONObject("VODDetail");
            if (vd == null) {
                vod.put("vod_play_url", "播放$vsp_" + id);
                return vod;
            }

            vod.put("vod_name", vd.optString("name", id));
            vod.put("vod_year", vd.optString("releaseyear", ""));
            vod.put("vod_area", vd.optString("originalcountry", ""));
            vod.put("vod_actor", actorsToString(vd.opt("actors")));
            vod.put("vod_director", vd.optString("director", ""));
            vod.put("vod_content", vd.optString("description", ""));

            String poster = vd.optString("posterUrl", vd.optString("picPath", ""));
            if (!poster.isEmpty()) {
                vod.put("vod_pic", fixEpgImageUrl(poster));
            }

            String vodType = vd.optString("VODType", "0");
            if ("1".equals(vodType) || "2".equals(vodType)) {
                JSONObject eps = getVspEpisodeList(id, 0, 200);
                if (eps != null) {
                    JSONArray episodes = eps.optJSONArray("episodes");
                    if (episodes != null && episodes.length() > 0) {
                        StringBuilder playUrl = new StringBuilder();
                        for (int i = 0; i < episodes.length(); i++) {
                            JSONObject ep = episodes.getJSONObject(i);
                            JSONObject vodObj = ep.optJSONObject("VOD");
                            if (vodObj != null) ep = vodObj;
                            String epId = ep.optString("ID", "");
                            if (i > 0) playUrl.append("#");
                            playUrl.append(ep.optString("name", "第" + (i + 1) + "集"));
                            playUrl.append("$vsp_").append(epId);
                        }
                        vod.put("vod_play_url", playUrl.toString());
                        return vod;
                    }
                }
            }

            JSONArray mediaFiles = vd.optJSONArray("mediaFiles");
            if (mediaFiles != null && mediaFiles.length() > 0) {
                vod.put("vod_play_url", "播放$vsp_" + id);
                return vod;
            }

            String code = vd.optString("code", "");
            if (!code.isEmpty() && !code.matches("^\\d+$")) {
                vod.put("vod_play_url", "播放$hk_" + code);
                return vod;
            }

            vod.put("vod_play_url", "播放$vsp_" + id);
            return vod;
        } catch (Exception e) {
            return null;
        }
    }

    private String actorsToString(Object obj) {
        if (obj == null) return "";
        if (obj instanceof String) return (String) obj;
        if (!(obj instanceof JSONArray)) return obj.toString();

        JSONArray arr = (JSONArray) obj;
        StringBuilder sb = new StringBuilder();
        int limit = Math.min(arr.length(), 8);
        for (int i = 0; i < limit; i++) {
            try {
                Object item = arr.get(i);
                String name = item instanceof JSONObject
                    ? ((JSONObject) item).optString("name", "")
                    : item.toString();
                if (!name.isEmpty()) {
                    if (sb.length() > 0) sb.append(", ");
                    sb.append(name);
                }
            } catch (Exception ignored) {
            }
        }
        return sb.toString();
    }

    // ═══════════════════════════════════════════════════════════════
    // searchContent
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String searchContent(String key, boolean quick) {
        try {
            if (!this.authed) {
                synchronized (this) {
                    login();
                }
            }

            JSONArray list = new JSONArray();
            String lowerKey = key.toLowerCase();
            Set<String> added = new HashSet<>();

            // Local index search
            if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                    if (entry.getKey().contains(lowerKey)) {
                        String code = entry.getValue();
                        String name = entry.getKey();
                        if (!added.contains(code)) {
                            added.add(code);
                            JSONObject vod = new JSONObject();
                            vod.put("vod_id", code);
                            vod.put("vod_name", name);
                            vod.put("vod_pic", getSearchPic(code));
                            vod.put("vod_remarks", getPrefix(code));
                            list.put(vod);

                            if (list.length() >= 50) break;
                        }
                    }
                }
            }

            // Online search supplement
            if (list.length() < 50) {
                try {
                    String url = this.shicBase
                        + "/vod/search/searchResultNew?userId="
                        + URLEncoder.encode(this.userId, "UTF-8")
                        + "&keyword=" + URLEncoder.encode(key, "UTF-8")
                        + "&pageNo=1&pageSize=50&isIntensive=-1&programType=";
                    String res = httpGet(url);
                    if (res != null) {
                        JSONObject obj = new JSONObject(res);
                        JSONArray items = obj.optJSONObject("response")
                            .optJSONObject("responseBody")
                            .optJSONArray("list");
                        if (items != null) {
                            for (int i = 0; i < items.length() && list.length() < 80; i++) {
                                try {
                                    JSONObject item = items.getJSONObject(i);
                                    String code = item.optString("code", "");
                                    String name = item.optString("name", "");
                                    if (code.isEmpty() || name.isEmpty()) continue;
                                    if ("1".equals(item.optString("idType", ""))) continue;
                                    if (!isPlayable(code)) continue;
                                    if (added.contains(code)) continue;

                                    added.add(code);
                                    String picUrl = item.optString("posterUrl",
                                        item.optString("picPath", ""));
                                    if (picUrl.startsWith("//")) picUrl = "http:" + picUrl;

                                    String seriesFlag = item.optString("seriesflag", "0");
                                    String remarks = "1".equals(seriesFlag)
                                        ? getPrefix(code) + " 连续剧" : getPrefix(code);

                                    JSONObject vod = new JSONObject();
                                    vod.put("vod_id", code);
                                    vod.put("vod_name", name);
                                    vod.put("vod_pic", picUrl);
                                    vod.put("vod_remarks", remarks);
                                    list.put(vod);
                                } catch (Exception ignored) {
                                }
                            }
                        }
                    }
                } catch (Exception ignored) {
                }
            }

            JSONObject result = new JSONObject();
            result.put("list", list);
            return result.toString();
        } catch (Exception e) {
            return "{\"list\":[]}";
        }
    }

    private boolean isSdk(String code) {
        for (String prefix : SDK_PREFIXES) {
            if (code.startsWith(prefix)) return true;
        }
        return false;
    }

    private boolean isNonVod(String code) {
        for (String nv : NON_VOD_CODES) {
            if (nv.equals(code)) return true;
        }
        return false;
    }

    private boolean isPlayable(String code) {
        if (code == null || code.isEmpty()) return false;
        if (code.matches("^\\d+$")) return true;
        return !isSdk(code) && !isNonVod(code);
    }

    // ═══════════════════════════════════════════════════════════════
    // playerContent — play URL resolution + index update trigger
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String playerContent(String flag, String id, List<String> vipFlags) {
        try {
            // Index update trigger
            if ("__start_update__".equals(id)) {
                if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            buildSearchIndex(true);
                        }
                    }).start();
                    JSONObject result = new JSONObject();
                    result.put("parse", 0);
                    result.put("url", "");
                    result.put("msg", "索引更新已启动，当前" + this.searchIndex.size()
                        + "部，更新后自动保存");
                    return result.toString();
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            buildSearchIndex(false);
                        }
                    }).start();
                    JSONObject result = new JSONObject();
                    result.put("parse", 0);
                    result.put("url", "");
                    result.put("msg", "索引更新已启动，请稍候...返回首页可查看进度");
                    return result.toString();
                }
            }

            String realCode = id;
            String type = "";

            if (id.startsWith("vsp_")) {
                realCode = id.substring(4);
                type = "vsp";
            } else if (id.startsWith("hk_")) {
                realCode = id.substring(3);
                type = "hk";
            }

            // SDK content — needs parser
            if (isSdk(realCode)) {
                JSONObject result = new JSONObject();
                result.put("parse", 1);
                result.put("url", "");
                result.put("msg", "SDK节目: " + getPrefix(realCode));
                return result.toString();
            }

            ensureAlive();
            String playUrl = null;

            if ("vsp".equals(type)) {
                String mediaId = resolveMediaId(realCode);
                if (!mediaId.isEmpty()) {
                    playUrl = getVspPlayUrl(realCode, mediaId);
                }

                // Try first episode if no mediaId
                if ((playUrl == null || playUrl.isEmpty())) {
                    JSONObject eps = getVspEpisodeList(realCode, 0, 1);
                    if (eps != null) {
                        JSONArray episodes = eps.optJSONArray("episodes");
                        if (episodes != null && episodes.length() > 0) {
                            JSONObject ep = episodes.getJSONObject(0);
                            JSONObject vodObj = ep.optJSONObject("VOD");
                            if (vodObj != null) ep = vodObj;
                            String epId = ep.optString("ID", "");
                            if (!epId.isEmpty()) {
                                String epMediaId = resolveMediaId(epId);
                                if (!epMediaId.isEmpty()) {
                                    playUrl = getVspPlayUrl(epId, epMediaId);
                                }
                            }
                        }
                    }
                }

                // Fallback to HK code
                if ((playUrl == null || playUrl.isEmpty())) {
                    JSONObject vd = getVspVodDetail(realCode);
                    if (vd != null) {
                        JSONObject vdObj = vd.optJSONObject("VODDetail");
                        if (vdObj != null) {
                            String code = vdObj.optString("code", "");
                            if (!code.isEmpty() && !code.matches("^\\d+$")) {
                                playUrl = getPlayUrlHk(code);
                                if (playUrl == null) {
                                    playUrl = getPlayUrlEncrypt(code, "");
                                }
                            }
                        }
                    }
                }
            } else {
                // HK code or pure-digit VSP code
                if (realCode.matches("^\\d+$")) {
                    String mediaId = resolveMediaId(realCode);
                    if (!mediaId.isEmpty()) {
                        playUrl = getVspPlayUrl(realCode, mediaId);
                    }
                    if (playUrl == null) {
                        playUrl = getPlayUrlHk(realCode);
                    }
                } else {
                    playUrl = getPlayUrlHk(realCode);
                    if (playUrl == null) {
                        // Try series children
                        JSONObject detail = getDetail(realCode);
                        if (detail != null) {
                            JSONArray series = detail.optJSONArray("serieslist");
                            if (series != null && series.length() > 0) {
                                for (int i = 0; i < series.length(); i++) {
                                    String childCode = series.getJSONObject(i)
                                        .optString("code", "");
                                    if (!childCode.isEmpty()) {
                                        playUrl = getPlayUrlHk(childCode);
                                        if (playUrl != null) break;
                                    }
                                }
                            }
                        }
                    }
                }

                if (playUrl == null) {
                    playUrl = getPlayUrlEncrypt(realCode, "");
                }
            }

            // Retry after re-auth
            if (playUrl == null || playUrl.isEmpty()) {
                stopHeartbeat();
                this.authed = false;
                this.cookieManager.getCookieStore().removeAll();
                if (login()) {
                    if ("vsp".equals(type)) {
                        String mediaId = resolveMediaId(realCode);
                        if (!mediaId.isEmpty()) {
                            playUrl = getVspPlayUrl(realCode, mediaId);
                        }
                    } else {
                        playUrl = getPlayUrlHk(realCode);
                    }
                }
            }

            JSONObject result = new JSONObject();
            result.put("parse", 0);
            result.put("url", playUrl != null ? playUrl : "");
            result.put("header", "");
            if (playUrl == null || playUrl.isEmpty()) {
                result.put("msg", "未获取到播放链接");
            }
            return result.toString();
        } catch (Exception e) {
            return "{\"parse\":0,\"url\":\"\"}";
        }
    }

    private String convertCode(String code) {
        for (Map.Entry<String, String> entry : CODE_TRANSFORMS.entrySet()) {
            if (code.startsWith(entry.getKey())) {
                return code.replace(entry.getKey(), entry.getValue());
            }
        }
        return code;
    }

    private String getPlayUrlHk(String code) {
        if (!this.authed || this.epgHost == null) return null;

        try {
            List<String> codes = new ArrayList<>();
            String converted = convertCode(code);
            if (!converted.equals(code)) {
                codes.add(converted);
            }
            codes.add(code);

            for (String c : codes) {
                try {
                    String url = String.format(
                        "http://%s/EPG/jsp/SDGDEPG/datajsp/geturlhwNew.jsp?code=%s",
                        this.epgHost, URLEncoder.encode(c, "UTF-8"));
                    String res = httpGet(url);
                    if (res != null) {
                        String trimmed = res.trim();
                        if (!trimmed.isEmpty()
                            && !trimmed.toLowerCase().contains("no data")) {
                            try {
                                JSONObject obj = new JSONObject(trimmed);
                                String pu = obj.optString("playUrl", "");
                                if (pu.contains("^")) {
                                    pu = pu.substring(pu.lastIndexOf("^") + 1);
                                }
                                if (!pu.isEmpty()
                                    && (pu.contains("http") || pu.contains("rtsp"))) {
                                    return pu;
                                }
                            } catch (Exception ex) {
                                if (trimmed.startsWith("rtsp://")
                                    || trimmed.startsWith("http")) {
                                    return trimmed;
                                }
                            }
                        }
                    }
                } catch (Exception ignored) {
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    private String getPlayUrlEncrypt(String code, String categoryId) {
        if (!this.authed || this.epgHost == null) return null;

        try {
            String url = String.format(
                "http://%s/EPG/jsp/SDGDEPG/app/player/views/encrypt.jsp",
                this.epgHost);
            String data = "code=" + URLEncoder.encode(code, "UTF-8")
                + "&categoryid=" + URLEncoder.encode(
                    categoryId != null ? categoryId : "", "UTF-8");
            String res = httpPost(url, data);
            if (res == null) return null;

            Matcher m = Pattern.compile("(rtsp://[^\\s\"<>\\']+)").matcher(res);
            if (m.find()) return m.group(1);

            m = Pattern.compile("(http://[^\\s\"<>\\']+\\.m3u8[^\\s\"<>\\']*)").matcher(res);
            if (m.find()) return m.group(1);

            m = Pattern.compile("playUrl[\"\\s]*[=:][\"\\s]*([^\"<>\\s]+)").matcher(res);
            if (m.find()) return m.group(1);
        } catch (Exception ignored) {
        }
        return null;
    }

    // ── VSP (Video Service Platform) ─────────────────────────────

    private JSONObject getVspVodDetail(String vodId) {
        try {
            ensureAlive();
            JSONObject req = new JSONObject();
            req.put("VODID", vodId);
            return vspPost("/VSP/V3/QueryVOD", req);
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject getVspEpisodeList(String vodId, int offset, int count) {
        try {
            ensureAlive();
            JSONObject req = new JSONObject();
            req.put("VODID", vodId);
            req.put("offset", String.valueOf(offset));
            req.put("count", String.valueOf(count));
            return vspPost("/VSP/V3/QueryEpisodeList", req);
        } catch (Exception e) {
            return null;
        }
    }

    private String getVspPlayUrl(String vodId, String mediaId) {
        try {
            ensureAlive();
            JSONObject req = new JSONObject();
            req.put("VODID", vodId);
            req.put("mediaID", mediaId);
            JSONObject checkLock = new JSONObject();
            checkLock.put("checkType", "0");
            req.put("checkLock", checkLock);

            JSONObject resp = vspPost("/VSP/V3/PlayVOD", req);
            if (resp != null) {
                JSONObject r = resp.optJSONObject("result");
                if (r != null && "000000000".equals(r.optString("retCode", ""))) {
                    return resp.optString("playURL", "");
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    private String resolveMediaId(String vodId) {
        try {
            JSONObject detail = getVspVodDetail(vodId);
            if (detail != null) {
                JSONObject vd = detail.optJSONObject("VODDetail");
                if (vd != null) {
                    JSONArray mediaFiles = vd.optJSONArray("mediaFiles");
                    if (mediaFiles != null && mediaFiles.length() > 0) {
                        return mediaFiles.getJSONObject(0).optString("ID", "");
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return "";
    }

    private JSONObject vspPost(String path, JSONObject body) {
        if (!this.authed || this.epgHost == null) return null;
        try {
            String url = "http://" + this.epgHost + path;
            if (!url.contains("?")) {
                url += "?from=throughMSAAccess";
            }
            String res = httpPostJson(url, body.toString());
            if (res == null) return null;
            return new JSONObject(res);
        } catch (Exception ignored) {
            return null;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // SDMS data fetching
    // ═══════════════════════════════════════════════════════════════

    private JSONArray getCategories(String categoryId) {
        String key = "cat_" + categoryId;
        Object obj = this.cache.get(key);
        if (obj != null) return (JSONArray) obj;

        try {
            String url = sdmsCategoryPath(categoryId);
            String res = httpGet(url);
            if (res == null) {
                SpiderDebug.log("CTC getCategories null response, url=" + url);
                return null;
            }
            JSONObject jsonp = parseJsonp(res);
            if (jsonp == null) return null;
            JSONArray arr = jsonp.optJSONArray("categoryList");
            if (arr != null) {
                this.cache.put(key, arr);
            }
            return arr;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject getPrograms(String categoryId, int page) {
        String key = categoryId + "_" + page;
        JSONObject cached = this.programCache.get(key);
        if (cached != null) return cached;

        try {
            String url = sdmsProgramPath(categoryId, page);
            String res = httpGet(url);
            if (res == null) return null;
            JSONObject jsonp = parseJsonp(res);
            if (jsonp != null) {
                this.programCache.put(key, jsonp);
            }
            return jsonp;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject getDetail(String code) {
        String key = "detail_" + code;
        Object obj = this.cache.get(key);
        if (obj != null) return (JSONObject) obj;

        try {
            String url = sdmsDetailPath(code)
                + "?hkMac=" + this.mac.replace(":", "")
                + "&hkIp=" + this.localIp
                + "&hkUserId=" + this.userId;
            String res = httpGet(url);
            if (res == null) return null;
            JSONObject jsonp = parseJsonp(res);
            if (jsonp == null) return null;

            JSONArray series = jsonp.optJSONArray("serieslist");
            if (series != null) {
                for (int i = 0; i < series.length(); i++) {
                    JSONObject ep = series.getJSONObject(i);
                    ep.put("fileurl", fixImageUrl(ep.optString("fileurl", "")));
                }
            }
            this.cache.put(key, jsonp);
            return jsonp;
        } catch (Exception e) {
            return null;
        }
    }

    private String getSearchPic(String code) {
        String key = "spic_" + code;
        Object obj = this.cache.get(key);
        if (obj instanceof String) return (String) obj;

        try {
            JSONObject detail = getDetail(code);
            if (detail == null) {
                this.cache.put(key, "");
                return "";
            }

            JSONArray pictures = detail.optJSONArray("picturelist");
            String fallback = "";
            if (pictures != null) {
                for (int i = 0; i < pictures.length(); i++) {
                    JSONObject pic = pictures.getJSONObject(i);
                    String url = fixImageUrl(pic.optString("fileurl", ""));
                    if (!url.isEmpty()) {
                        if ("2".equals(pic.optString("type"))) {
                            this.cache.put(key, url);
                            return url;
                        }
                        if (fallback.isEmpty()) {
                            fallback = url;
                        }
                    }
                }
            }

            if (!fallback.isEmpty()) {
                this.cache.put(key, fallback);
                return fallback;
            }

            String logo = fixImageUrl(detail.optString("logo", ""));
            if (!logo.isEmpty()) {
                this.cache.put(key, logo);
                return logo;
            }

            this.cache.put(key, "");
        } catch (Exception ignored) {
        }
        return "";
    }

    // ═══════════════════════════════════════════════════════════════
    // Search index building
    // ═══════════════════════════════════════════════════════════════

    private void buildSearchIndex(boolean forceRebuild) {
        if (forceRebuild) {
            this.searchIndex.clear();
        } else {
            loadSearchIndex();
            if (!this.searchIndex.isEmpty()) {
                this.searchIndexBuilt = true;
                return;
            }
        }

        SpiderDebug.log("CTC buildSearchIndex starting, force=" + forceRebuild
            + ", rootIds=" + SDMS_ROOT_IDS.length);

        try {
            ExecutorService pool = Executors.newFixedThreadPool(4);
            final CountDownLatch latch = new CountDownLatch(SDMS_ROOT_IDS.length);

            for (final String rootId : SDMS_ROOT_IDS) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            indexCategoryRecursive(rootId, 0);
                        } finally {
                            latch.countDown();
                        }
                    }
                });
            }

            latch.await(10, TimeUnit.MINUTES);
            pool.shutdown();
            this.searchIndexBuilt = true;
            SpiderDebug.log("CTC buildSearchIndex done, count=" + this.searchIndex.size());
        } catch (Exception e) {
            this.searchIndexBuilt = true;
        } finally {
            this.searchIndexBuilt = true;
            saveSearchIndex();
        }
    }

    private void indexCategoryRecursive(String catId, int depth) {
        if (depth > 10) return;
        indexCategory(catId);
        JSONArray subCats = getCategories(catId);
        if (subCats != null) {
            for (int i = 0; i < subCats.length(); i++) {
                try {
                    JSONObject cat = subCats.getJSONObject(i);
                    String subId = cat.optString("primaryid", cat.optString("id", ""));
                    if (!subId.isEmpty() && !subId.equals(catId)) {
                        indexCategoryRecursive(subId, depth + 1);
                    }
                } catch (Exception ignored) {
                }
            }
        }
    }

    private void indexCategory(String catId) {
        for (int page = 1; page <= 50; page++) {
            try {
                JSONObject progs = getPrograms(catId, page);
                if (progs == null) return;
                JSONArray items = progs.optJSONArray("list");
                if (items == null || items.length() == 0) return;

                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    String code = item.optString("code", item.optString("telecomcode", ""));
                    String name = item.optString("name", "");
                    if (!code.isEmpty() && !name.isEmpty()) {
                        this.searchIndex.putIfAbsent(name.toLowerCase(), code);
                    }
                }

                if (page >= progs.optInt("pagecount", 1)) return;
            } catch (Exception e) {
                return;
            }
        }
    }

    private void loadSearchIndex() {
        if (this.indexFilePath == null) return;
        try {
            File file = new File(this.indexFilePath);
            if (!file.exists() || file.length() == 0) return;

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                int tabIdx = line.indexOf('\t');
                if (tabIdx > 0) {
                    String key = line.substring(0, tabIdx);
                    String value = line.substring(tabIdx + 1);
                    if ("__timestamp__".equals(key)) {
                        this.indexTimestamp = value;
                    } else if (!key.isEmpty() && !value.isEmpty() && !key.startsWith("__")) {
                        this.searchIndex.put(key, value);
                    }
                }
            }
            reader.close();
            SpiderDebug.log("CTC loadSearchIndex count=" + this.searchIndex.size());
        } catch (Exception e) {
            SpiderDebug.log("CTC loadSearchIndex error: " + e.getMessage());
        }
    }

    private void saveSearchIndex() {
        if (this.indexFilePath == null || this.searchIndex.isEmpty()) return;

        try {
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            File tmpFile = new File(this.indexFilePath + ".tmp");
            OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(tmpFile), StandardCharsets.UTF_8);
            writer.write("__timestamp__\t" + dateStr + "\n");
            for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                writer.write(entry.getKey());
                writer.write('\t');
                writer.write(entry.getValue());
                writer.write('\n');
            }
            writer.flush();
            writer.close();

            File dest = new File(this.indexFilePath);
            if (dest.exists()) dest.delete();

            if (!tmpFile.renameTo(dest)) {
                // Fallback: copy bytes
                FileInputStream fis = new FileInputStream(tmpFile);
                FileOutputStream fos = new FileOutputStream(dest);
                byte[] buf = new byte[8192];
                int n;
                while ((n = fis.read(buf)) > 0) {
                    fos.write(buf, 0, n);
                }
                fis.close();
                fos.close();
                tmpFile.delete();
            }
        } catch (Exception e) {
            SpiderDebug.log("CTC saveSearchIndex error: " + e.getMessage());
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // SDMS path building
    // ═══════════════════════════════════════════════════════════════

    private String sdmsCategoryPath(String id) {
        StringBuilder sb = new StringBuilder(String.format(
            "http://%s:%d/staticData/js/data/categorylist/",
            this.sdmsHost, this.sdmsStaticPort));
        for (int i = 1; i <= id.length(); i += 3) {
            sb.append(id, 0, i);
            sb.append("/");
        }
        sb.append("C").append(id).append(".js");
        return sb.toString();
    }

    private String sdmsProgramPath(String id, int page) {
        StringBuilder sb = new StringBuilder(String.format(
            "http://%s:%d/staticData/js/data/programlist/",
            this.sdmsHost, this.sdmsStaticPort));
        for (int i = 1; i <= id.length(); i += 3) {
            sb.append(id, 0, i);
            sb.append("/");
        }
        sb.append("P").append(id).append("_").append(page).append(".js");
        return sb.toString();
    }

    private String sdmsDetailPath(String code) {
        return String.format("http://%s:%d/staticData/js/data/detail/%s/D%s.js",
            this.sdmsHost, this.sdmsStaticPort,
            code.substring(code.length() - 1), code);
    }

    // ═══════════════════════════════════════════════════════════════
    // Utility methods
    // ═══════════════════════════════════════════════════════════════

    private String getPrefix(String code) {
        if (code == null || code.isEmpty() || code.matches("^\\d+$")) return "";

        String best = "";
        for (String prefix : _PREFIX_ORDER) {
            if (code.startsWith(prefix)) {
                best = prefix;
                break;
            }
        }

        if (best.isEmpty() && code.contains("_")) {
            best = code.split("_")[0];
        }

        if (best.isEmpty()) {
            best = code.length() >= 8 ? code.substring(0, 8) : code;
        }

        return PREFIX_NAMES.getOrDefault(best, best);
    }

    private String fixImageUrl(String url) {
        if (url == null || url.isEmpty()) return "";
        if (url.startsWith("//")) return "http:" + url;
        if (url.startsWith("/data") || url.startsWith("/pic")) {
            return String.format("http://%s:%d", this.sdmsHost, this.sdmsStaticPort) + url;
        }
        if (!url.startsWith("http")) {
            return String.format("http://%s:%d/", this.sdmsHost, this.sdmsStaticPort) + url;
        }
        return url.replace("tsnm-hk.snctv.cn", this.sdmsHost);
    }

    private String fixEpgImageUrl(String url) {
        if (url == null || url.isEmpty()) return "";
        if (url.startsWith("http")) return url;
        if (this.epgHost == null) return url;
        return String.format("http://%s/EPG/jsp/defaulttrans2/en/%s", this.epgHost, url);
    }

    private JSONObject parseJsonp(String str) {
        if (str == null || str.trim().isEmpty()) return null;
        String s = str.trim();
        if (s.endsWith(";")) s = s.substring(0, s.length() - 1).trim();

        int start = s.indexOf('(');
        int end = s.lastIndexOf(')');
        if (start > 0 && end > start) {
            try {
                return new JSONObject(s.substring(start + 1, end));
            } catch (Exception ignored) {
            }
        }
        try {
            return new JSONObject(s);
        } catch (Exception ignored) {
        }
        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // HTTP helpers
    // ═══════════════════════════════════════════════════════════════

    private String httpGet(String urlStr) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("User-Agent",
                "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0");
            if (conn.getResponseCode() != 200) {
                conn.disconnect();
                return null;
            }
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) sb.append(line);
            in.close();
            conn.disconnect();
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * GET request that also captures the resolved epgHost from the redirect URL.
     */
    private String httpGetFullUrl(String urlStr) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("User-Agent",
                "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0");

            int code = conn.getResponseCode();
            URL resolvedUrl = conn.getURL();

            // Capture epgHost from resolved URL
            if (this.epgHost == null) {
                int port = resolvedUrl.getPort();
                String portStr = (port > 0 && port != 80) ? ":" + port : "";
                this.epgHost = resolvedUrl.getHost() + portStr;
            }

            if (code != 200) {
                conn.disconnect();
                return null;
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) sb.append(line);
            in.close();
            conn.disconnect();
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private String httpPost(String urlStr, String data) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("User-Agent",
                "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0");

            if (data != null && !data.isEmpty()) {
                byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
                conn.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                conn.getOutputStream().write(bytes);
                conn.getOutputStream().flush();
                conn.getOutputStream().close();
            }

            if (conn.getResponseCode() != 200) {
                conn.disconnect();
                return null;
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) sb.append(line);
            in.close();
            conn.disconnect();
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private String httpPostJson(String urlStr, String jsonData) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("User-Agent",
                "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0");

            if (jsonData != null) {
                byte[] bytes = jsonData.getBytes(StandardCharsets.UTF_8);
                conn.getOutputStream().write(bytes);
                conn.getOutputStream().flush();
                conn.getOutputStream().close();
            }

            if (conn.getResponseCode() != 200) {
                conn.disconnect();
                return null;
            }

            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) sb.append(line);
            in.close();
            conn.disconnect();
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // destroy
    // ═══════════════════════════════════════════════════════════════

    @Override
    public void destroy() {
        stopHeartbeat();
        this.authed = false;
        this.cache.clear();
        this.programCache.clear();
        super.destroy();
    }
}
