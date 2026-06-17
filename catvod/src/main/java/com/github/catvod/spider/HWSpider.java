package com.github.catvod.spider;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.CryptoUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import java.util.Arrays;
import java.util.Base64;
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
import org.json.JSONTokener;

/**
 * HWSpider - China Unicom (Huawei) IPTV spider.
 *
 * Auth flow: EDS-based 3-step (similar to CTC, uses "Reserved" as 7th field).
 * Category structure: SDMS root + EPG waterfall categories + SDK zones.
 * Uses ConcurrentHashMap (unbounded) for caching, same as ZTESpider.
 */
public class HWSpider extends Spider {

    // ── Auth params ──────────────────────────────────────────────
    private static final long AUTH_TTL = 600000;

    private String edsServer = "27.223.126.136:8082";
    private String encryptKey = "";
    private String userId = "";
    private String stbId = "";
    private String mac = "";
    private String stbType = "";
    private String stbVersion = "V83321337.1005";
    private String interfaceSuffix = "CU";
    private String lastActiveFastIp = "";

    // ── SDMS params ──────────────────────────────────────────────
    private String sdmsHost = "124.132.253.193";
    private int sdmsPort = 86;
    private String imgHost = "124.132.253.193";
    private int imgPort = 85;
    private String sdmsSearchHost = "124.132.253.193";
    private int sdmsSearchPort = 81;
    private String sdmsSearchTime = "1541756249247";
    private String sdmsSearchRiddle = "5660c2fc967f0026ec138dcc36fff8d5";
    private String topCatId = "10000100000000090000000000013994";

    // ── Runtime state ────────────────────────────────────────────
    private boolean authed = false;
    private volatile String localIp = "127.0.0.1";
    private long authTime = 0;
    private volatile boolean heartbeatRunning = false;
    private Thread heartbeatThread;
    private CookieManager cookieManager;
    private String epgHost;

    // ── Caches ───────────────────────────────────────────────────
    private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    // ── Search index ─────────────────────────────────────────────
    private final ConcurrentHashMap<String, String> searchIndex = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> pinyinIndex = new ConcurrentHashMap<>();
    private volatile boolean searchIndexBuilt = false;
    private String indexTimestamp = "";
    private String indexFilePath;
    private String indexIconUri = "";

    // ── Content provider name mapping ────────────────────────────
    private static final Map<String, String> PREFIX_NAMES = new HashMap<>();
    private static final Map<String, String> CODE_TRANSFORMS = new HashMap<>();
    private static final Map<String, String> ZONE_DEFAULT_SUB = new HashMap<>();

    static {
        PREFIX_NAMES.put("JIECHENG", "华视网聚");
        PREFIX_NAMES.put("JIECHENGHUASHI", "华视网聚");
        PREFIX_NAMES.put("JIECHENGHUASHIU", "华视网聚");
        PREFIX_NAMES.put("YUESHITONG", "悦视通");
        PREFIX_NAMES.put("MGTV", "芒果TV");
        PREFIX_NAMES.put("MGTV_HKPRO", "芒果TV");
        PREFIX_NAMES.put("MGTV_XY", "芒果TV");
        PREFIX_NAMES.put("MGTV_SERIES", "芒果TV");
        PREFIX_NAMES.put("GUOQY", "爱奇艺");
        PREFIX_NAMES.put("GUOQY_ser", "爱奇艺");
        PREFIX_NAMES.put("GUOQY_pro", "爱奇艺");
        PREFIX_NAMES.put("GUOQY_u_pro", "爱奇艺");
        PREFIX_NAMES.put("GUOQYPROGM", "爱奇艺");
        PREFIX_NAMES.put("BESTV", "百视通");
        PREFIX_NAMES.put("BESTVWIN", "百视通");
        PREFIX_NAMES.put("BESTVLOC", "百视通");
        PREFIX_NAMES.put("BLBLP", "哔哩哔哩");
        PREFIX_NAMES.put("BLBLU", "哔哩哔哩");
        PREFIX_NAMES.put("HUASH", "华数");
        PREFIX_NAMES.put("HUASHUNM", "华数");
        PREFIX_NAMES.put("WLXH", "未来电视");
        PREFIX_NAMES.put("WLXHAcc", "未来电视");
        PREFIX_NAMES.put("WLXHAPROGM", "未来电视");
        PREFIX_NAMES.put("JIZR", "腾讯视频");
        PREFIX_NAMES.put("JIZRpcmzc", "腾讯视频");
        PREFIX_NAMES.put("JIZRsc", "腾讯视频");
        PREFIX_NAMES.put("JIZDL", "腾讯视频");
        PREFIX_NAMES.put("WOKAN", "搜狐视频");
        PREFIX_NAMES.put("WOKANU", "搜狐视频");
        PREFIX_NAMES.put("YANHUA", "岩华");
        PREFIX_NAMES.put("senyucp", "森宇股份");
        PREFIX_NAMES.put("senyuPROGM", "森宇股份");
        PREFIX_NAMES.put("XHUANW", "广州欢网");
        PREFIX_NAMES.put("XHUANWANG", "广州欢网");
        PREFIX_NAMES.put("ZhongL", "中录文化");
        PREFIX_NAMES.put("BAOBAO", "宝宝巴士");
        PREFIX_NAMES.put("PUXIN", "普信文化");
        PREFIX_NAMES.put("LIZHI", "荔枝TV");
        PREFIX_NAMES.put("XINGYUN", "杭州漫视");
        PREFIX_NAMES.put("SHIY", "视园");
        PREFIX_NAMES.put("SHIY_S", "视园");
        PREFIX_NAMES.put("YZZHSER", "悦众智合");
        PREFIX_NAMES.put("YHYKMLT", "优酷");
        PREFIX_NAMES.put("JZTX", "极智");
        PREFIX_NAMES.put("JLTM", "极光");
        PREFIX_NAMES.put("SHUNYUAN", "顺源");
        PREFIX_NAMES.put("YJYUAN", "艺佳");
        PREFIX_NAMES.put("YJYDJ000", "艺佳电竞");
        PREFIX_NAMES.put("YJY002", "艺佳院线2");
        PREFIX_NAMES.put("YJY004", "艺佳院线4");
        PREFIX_NAMES.put("YJY001", "艺佳院线1");
        PREFIX_NAMES.put("YJY003", "艺佳院线3");
        PREFIX_NAMES.put("YJY009", "艺佳院线9");
        PREFIX_NAMES.put("DUOCAIXI", "多彩戏");
        PREFIX_NAMES.put("TJTV", "天津电视");
        PREFIX_NAMES.put("SHENZHEN", "深圳");
        PREFIX_NAMES.put("dogtv", "DogTV");
        PREFIX_NAMES.put("chengyu", "成语");
        PREFIX_NAMES.put("XSGQ0000", "学生");
        PREFIX_NAMES.put("SDGDYPROGM", "山东广电");
        PREFIX_NAMES.put("YUNWEPROGM", "运维");
        PREFIX_NAMES.put("YUNWEI", "运维");
        PREFIX_NAMES.put("2110MAMS", "宣传片");
        PREFIX_NAMES.put("2110MPROGM", "宣传片");
        PREFIX_NAMES.put("21100001", "宣传片");
        PREFIX_NAMES.put("PR", "推荐位");

        CODE_TRANSFORMS.put("YHYKMLT", "YHYKQTS");
        CODE_TRANSFORMS.put("JZTX_", "JZTQ_");
        CODE_TRANSFORMS.put("GUOQY_ser_", "GUOQY_pro_");

        ZONE_DEFAULT_SUB.put("1032", "1032007");
        ZONE_DEFAULT_SUB.put("1035", "1035006");
        ZONE_DEFAULT_SUB.put("1024", "1024014");
        ZONE_DEFAULT_SUB.put("1025", "1025004");
    }

    // ═══════════════════════════════════════════════════════════════
    // init
    // ═══════════════════════════════════════════════════════════════

    @Override
    public void init(android.content.Context context, String extJsonStr) {
        try {
            // Set up index file path
            indexFilePath = context.getCacheDir() + "/hw_search_index.txt";

            // Parse configuration (先解密 ext)
            if (extJsonStr != null && !extJsonStr.isEmpty()) {
                extJsonStr = CryptoUtil.unwrap(extJsonStr);
                if (extJsonStr.trim().startsWith("{")) {
                    parseJsonExt(new JSONObject(extJsonStr));
                } else {
                    parseLegacyExt(extJsonStr);
                }
            }

            // Pre-load search index from file
            if (indexFilePath != null) {
                loadSearchIndex();
            }

            // CookieManager for EPG session cookies
            cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);

            // Background initialization
            new Thread(new Runnable() {
                @Override
                public void run() {
                    detectLocalIp();
                    login();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJsonExt(JSONObject ext) {
        try {
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
            if (ext.has("sdmsHost")) this.sdmsHost = ext.getString("sdmsHost");
            if (ext.has("sdmsPort")) this.sdmsPort = ext.optInt("sdmsPort", this.sdmsPort);
            if (ext.has("imgHost")) this.imgHost = ext.getString("imgHost");
            if (ext.has("imgPort")) this.imgPort = ext.optInt("imgPort", this.imgPort);
            if (ext.has("sdmsSearchHost")) this.sdmsSearchHost = ext.getString("sdmsSearchHost");
            if (ext.has("sdmsSearchPort")) this.sdmsSearchPort = ext.optInt("sdmsSearchPort", this.sdmsSearchPort);
            if (ext.has("sdmsSearchTime")) this.sdmsSearchTime = ext.getString("sdmsSearchTime");
            if (ext.has("sdmsSearchRiddle")) this.sdmsSearchRiddle = ext.getString("sdmsSearchRiddle");
            if (ext.has("topCatId")) this.topCatId = ext.getString("topCatId");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseLegacyExt(String raw) {
        String[] parts = raw.split("\\$");
        if (parts.length >= 1) this.encryptKey = parts[0];
        if (parts.length >= 2) this.userId = parts[1];
        if (parts.length >= 3) this.stbId = parts[2];
        if (parts.length >= 4) this.mac = parts[3];
        if (parts.length >= 5) this.stbType = parts[4];
    }

    // ═══════════════════════════════════════════════════════════════
    // Auth: EDS-based 3-step login (HW variant)
    // ═══════════════════════════════════════════════════════════════

    private synchronized boolean login() {
        try {
            // Step 1: GET EDS AuthenticationURL — captures epgHost
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
            // HW uses "Reserved" as the 7th field, with "$CTC" suffix
            long randomNum = (long) (Math.random() * 9.0E7d) + 10000000L;
            String rawAuth = String.format("%d$%s$%s$%s$%s$%s$Reserved$CTC",
                randomNum, encryptToken, this.userId, this.stbId, this.localIp, this.mac);
            String authenticator = desEncrypt(rawAuth, this.encryptKey);

            String step3Url = String.format(
                "http://%s/EPG/jsp/ValidAuthenticationHW%s.jsp", host, this.interfaceSuffix);
            String step3Data = "UserID=" + URLEncoder.encode(this.userId, "UTF-8")
                + "&Lang=0&SupportHD=1"
                + "&NetUserID=SDIPTVPPPOE@sdiptv"
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
            startHeartbeat();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean ensureAlive() {
        String currentFastIp = getLocalIpFast();
        boolean networkChanged = !currentFastIp.equals(this.lastActiveFastIp);
        if (networkChanged) {
            SpiderDebug.log("HWSpider network changed! Old=" + this.lastActiveFastIp + ", New=" + currentFastIp);
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
        }, "HW-Heartbeat");
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
                ? Integer.parseInt(this.edsServer.split(":")[1]) : 8082;
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

            // Get SDMS root categories
            JSONArray rootCats = getRootCategories();
            if (rootCats != null) {
                for (int i = 0; i < rootCats.length(); i++) {
                    JSONObject cat = rootCats.getJSONObject(i);
                    String id = cat.optString("primaryid", cat.optString("id", ""));
                    String name = cat.optString("name", "");
                    if (id.isEmpty() || name.isEmpty()) continue;

                    JSONObject cls = new JSONObject();
                    cls.put("type_id", id);
                    cls.put("type_name", name);
                    classes.put(cls);

                    if (filter) {
                        JSONArray subCats = getCategories(id);
                        if (subCats != null && subCats.length() > 0) {
                            JSONArray subList = new JSONArray();
                            JSONObject all = new JSONObject();
                            all.put("n", "全部");
                            all.put("v", "");
                            subList.put(all);
                            for (int j = 0; j < subCats.length(); j++) {
                                JSONObject sub = subCats.getJSONObject(j);
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
                                filters.put(id, filterArr);
                            }
                        }
                    }
                }
            }

            // Add EPG categories (if authed and epgHost is known)
            if (this.authed && this.epgHost != null) {
                JSONArray epgRootCats = getEpgCategories("10000100000000090000000000013994");
                if (epgRootCats != null) {
                    for (int i = 0; i < epgRootCats.length(); i++) {
                        JSONObject cat = epgRootCats.getJSONObject(i);
                        String recTypeId = cat.optString("recTypeId", "");
                        String catName = cat.optString("typeName", "");
                        if (recTypeId.isEmpty() || catName.isEmpty()) continue;

                        JSONObject cls = new JSONObject();
                        cls.put("type_id", "epgcat_" + recTypeId);
                        cls.put("type_name", catName);
                        classes.put(cls);

                        if (filter) {
                            JSONArray subCats = getEpgCategories(recTypeId);
                            if (subCats != null && subCats.length() > 0) {
                                JSONArray subList = new JSONArray();
                                JSONObject all = new JSONObject();
                                all.put("n", "全部");
                                all.put("v", "");
                                subList.put(all);
                                for (int j = 0; j < subCats.length(); j++) {
                                    JSONObject sub = subCats.getJSONObject(j);
                                    String subId = sub.optString("recTypeId", "");
                                    String subName = sub.optString("typeName", "");
                                    if (subId.isEmpty() || subName.isEmpty()) continue;
                                    JSONObject item = new JSONObject();
                                    item.put("n", subName);
                                    item.put("v", subId);
                                    subList.put(item);
                                }
                                if (subList.length() > 1) {
                                    JSONArray filterArr = new JSONArray();
                                    JSONObject filterObj = new JSONObject();
                                    filterObj.put("key", "epgsub");
                                    filterObj.put("name", "分类");
                                    filterObj.put("value", subList);
                                    filterArr.put(filterObj);
                                    filters.put("epgcat_" + recTypeId, filterArr);
                                }
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
            loadIndexIcon();
            loadSearchIndex();
            if (!searchIndex.isEmpty()) {
                searchIndexBuilt = true;
            }

            return result.toString();
        } catch (Exception e) {
            return "{\"class\":[]}";
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // homeVideoContent — home page video list
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String homeVideoContent() {
        try {
            JSONObject result = new JSONObject();
            JSONArray list = new JSONArray();

            // Index update entry
            JSONObject update = new JSONObject();
            update.put("vod_id", "__update_index__");
            update.put("vod_name", "🔄更新搜索索引");
            update.put("vod_pic", this.indexIconUri);
            StringBuilder sb = new StringBuilder();
            sb.append(this.searchIndex.size()).append("部");
            if (!this.indexTimestamp.isEmpty()) {
                sb.append(" ").append(this.indexTimestamp);
            }
            update.put("vod_remarks", sb.toString());
            list.put(update);

            // Recommendations
            JSONObject progs = getPrograms("1001016022", 1);
            if (progs != null) {
                JSONArray items = progs.optJSONArray("list");
                if (items != null) {
                    int limit = Math.min(items.length(), 12);
                    for (int i = 0; i < limit; i++) {
                        JSONObject item = items.getJSONObject(i);
                        JSONObject vod = new JSONObject();
                        vod.put("vod_id", item.optString("code", ""));
                        vod.put("vod_name", item.optString("name", ""));
                        vod.put("vod_pic", fixImageUrl(
                            item.optString("fileurl", item.optString("poster", ""))));
                        vod.put("vod_remarks", getPrefix(item.optString("code", "")));
                        list.put(vod);
                    }
                }
            }

            result.put("list", list);
            return result.toString();
        } catch (Exception e) {
            return "{\"list\":[]}";
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
            int pageCount = 1;

            if (tid.startsWith("epgcat_")) {
                // EPG category
                String catId = tid.substring(7);
                String epgsub = (extend != null) ? extend.get("epgsub") : null;
                if (epgsub != null && !epgsub.isEmpty()) {
                    catId = epgsub;
                }

                JSONObject vodList = getEpgVodList(catId, (page - 1) * 20, 20);
                if (vodList != null) {
                    JSONArray arr = vodList.optJSONArray("arr");
                    int totalCount = vodList.optInt("countTotal", 0);
                    pageCount = Math.max(1, (totalCount + 19) / 20);

                    if (arr != null) {
                        for (int i = 0; i < arr.length(); i++) {
                            try {
                                JSONObject item = arr.getJSONObject(i);
                                String vodId = item.optString("vodId", "");
                                String vodName = item.optString("vodName", "");
                                if (vodName.isEmpty()) continue;

                                String isSitcom = item.optString("isSitcom", "0");
                                String seriesFlag = item.optString("seriesflag", "0");
                                String code = item.optString("code", "");
                                String picPath = item.optString("picPath", "");
                                String remarks = "";

                                if ("1".equals(isSitcom) || "1".equals(seriesFlag)) {
                                    JSONArray children = item.optJSONArray("childrenList");
                                    int epCount = children != null ? children.length() : 0;
                                    remarks = epCount > 0 ? epCount + "集" : "连续剧";
                                }

                                JSONObject vod = new JSONObject();
                                vod.put("vod_id", "epg_" + vodId + "_" + catId + "_" + code);
                                vod.put("vod_name", vodName);
                                vod.put("vod_pic", fixEpgImageUrl(picPath));
                                vod.put("vod_remarks", remarks);
                                list.put(vod);
                            } catch (Exception ignored) {
                            }
                        }
                    }
                }
            } else {
                // SDMS category
                String sub = (extend != null) ? extend.get("sub") : null;

                // Apply ZONE_DEFAULT_SUB if no explicit sub
                if (sub == null || sub.isEmpty()) {
                    if (ZONE_DEFAULT_SUB.containsKey(tid)) {
                        sub = ZONE_DEFAULT_SUB.get(tid);
                    }
                }

                if (sub == null || sub.isEmpty()) {
                    // Root category: show its own programs
                    JSONObject progs = getPrograms(tid, page);
                    if (progs != null) {
                        pageCount = progs.optInt("pagecount", 1);
                        JSONArray items = progs.optJSONArray("list");
                        if (items != null) {
                            for (int i = 0; i < items.length(); i++) {
                                JSONObject item = items.getJSONObject(i);
                                String code = item.optString("code", "");
                                String prefix = getPrefix(code);
                                if ("1".equals(item.optString("seriesflag", "0"))) {
                                    prefix = prefix + " 连续剧";
                                }
                                JSONObject vod = new JSONObject();
                                vod.put("vod_id", code);
                                vod.put("vod_name", item.optString("name", ""));
                                vod.put("vod_pic", fixImageUrl(
                                    item.optString("fileurl", item.optString("poster", ""))));
                                vod.put("vod_remarks", prefix);
                                list.put(vod);
                            }
                        }
                    }

                    // Fallback: try sub-categories
                    if (list.length() == 0) {
                        JSONArray subCats = getCategories(tid);
                        if (subCats != null) {
                            for (int i = 0; i < subCats.length() && list.length() == 0; i++) {
                                JSONObject cat = subCats.getJSONObject(i);
                                String subId = cat.optString(
                                    "primaryid", cat.optString("id", ""));
                                if (subId.isEmpty()) continue;

                                JSONObject subProgs = getPrograms(subId, page);
                                if (subProgs != null) {
                                    pageCount = subProgs.optInt("pagecount", 1);
                                    JSONArray subItems = subProgs.optJSONArray("list");
                                    if (subItems != null) {
                                        for (int j = 0; j < subItems.length(); j++) {
                                            JSONObject item = subItems.getJSONObject(j);
                                            String code = item.optString("code", "");
                                            String prefix = getPrefix(code);
                                            if ("1".equals(item.optString("seriesflag", "0"))) {
                                                prefix = prefix + " 连续剧";
                                            }
                                            JSONObject vod = new JSONObject();
                                            vod.put("vod_id", code);
                                            vod.put("vod_name", item.optString("name", ""));
                                            vod.put("vod_pic", fixImageUrl(
                                                item.optString("fileurl",
                                                    item.optString("poster", ""))));
                                            vod.put("vod_remarks", prefix);
                                            list.put(vod);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    // Sub-category: show sub's programs
                    JSONObject progs = getPrograms(sub, page);
                    if (progs != null) {
                        pageCount = progs.optInt("pagecount", 1);
                        JSONArray items = progs.optJSONArray("list");
                        if (items != null) {
                            for (int i = 0; i < items.length(); i++) {
                                JSONObject item = items.getJSONObject(i);
                                String code = item.optString("code", "");
                                String prefix = getPrefix(code);
                                if ("1".equals(item.optString("seriesflag", "0"))) {
                                    prefix = prefix + " 连续剧";
                                }
                                JSONObject vod = new JSONObject();
                                vod.put("vod_id", code);
                                vod.put("vod_name", item.optString("name", ""));
                                vod.put("vod_pic", fixImageUrl(
                                    item.optString("fileurl", item.optString("poster", ""))));
                                vod.put("vod_remarks", prefix);
                                list.put(vod);
                            }
                        }
                    }
                }
            }

            result.put("page", page);
            result.put("pagecount", pageCount);
            result.put("list", list);
            return result.toString();
        } catch (Exception e) {
            return "{\"list\":[]}";
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
                    vod.put("vod_pic", this.indexIconUri);
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
            if (id.startsWith("epg_")) {
                return buildEpgDetail(id.substring(4));
            }
            if (id.startsWith("epgm_")) {
                return buildEpgMergedDetail(id.substring(5));
            }
            if (id.startsWith("epglist_")) {
                return buildEpgListDetail(id.substring(8));
            }

            JSONObject vod = new JSONObject();
            vod.put("vod_id", id);
            vod.put("vod_name", id);
            vod.put("vod_play_from", "华为IPTV");

            JSONObject detail = getDetail(id);
            if (detail == null) {
                vod.put("vod_play_url", "播放$hk_" + id);
                return vod;
            }

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
            if (series == null || series.length() == 0) {
                vod.put("vod_play_url", "播放$hk_" + id);
                return vod;
            }

            StringBuilder playUrl = new StringBuilder();
            for (int i = 0; i < series.length(); i++) {
                JSONObject ep = series.getJSONObject(i);
                if (i > 0) playUrl.append("#");
                playUrl.append(ep.optString("name", "第" + (i + 1) + "集"));
                playUrl.append("$hk_").append(ep.optString("code", ""));
            }
            vod.put("vod_play_url", playUrl.toString());
            return vod;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Build detail for a single EPG item.
     * ID format: epg_{vodId}_{typeId}_{code}
     */
    private JSONObject buildEpgDetail(String id) {
        try {
            String[] parts = id.split("_", 3);
            String vodId = parts.length >= 1 ? parts[0] : "";
            String typeId = parts.length >= 2 ? parts[1] : "";
            String code = parts.length >= 3 ? parts[2] : "";

            JSONObject vod = new JSONObject();
            vod.put("vod_id", "epg_" + id);
            vod.put("vod_name", id);
            vod.put("vod_play_from", "华为IPTV");

            // Try to get detail from SDMS using the code
            boolean hasDetail = false;
            if (!code.isEmpty()) {
                JSONObject detail = getDetail(code);
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

                    // Build series episodes if available
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
                    hasDetail = true;
                }
            }

            // Also try EPG vod list for metadata
            if (!hasDetail && !typeId.isEmpty()) {
                JSONObject vodList = getEpgVodList(typeId, 0, 500);
                if (vodList != null) {
                    JSONArray arr = vodList.optJSONArray("arr");
                    if (arr != null) {
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject item = arr.getJSONObject(i);
                            if (vodId.equals(item.optString("vodId", ""))) {
                                vod.put("vod_name", item.optString("vodName", id));
                                String picPath = item.optString("picPath", "");
                                if (!picPath.isEmpty()) {
                                    vod.put("vod_pic", fixEpgImageUrl(picPath));
                                }
                                break;
                            }
                        }
                    }
                }
            }

            vod.put("vod_play_url", "播放$epg_" + id);
            return vod;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Build detail for an EPG list view (shows all episodes of a category).
     * ID format: epglist_{typeId}
     */
    private JSONObject buildEpgListDetail(String id) {
        try {
            // id is the typeId/categoryId for EPG
            JSONObject vod = new JSONObject();
            vod.put("vod_id", "epglist_" + id);
            vod.put("vod_name", "EPG列表");
            vod.put("vod_play_from", "华为IPTV");

            // Get EPG vod list for this category
            JSONObject vodList = getEpgVodList(id, 0, 500);
            if (vodList == null) {
                vod.put("vod_play_url", "播放$epglist_" + id);
                return vod;
            }

            JSONArray arr = vodList.optJSONArray("arr");
            if (arr == null || arr.length() == 0) {
                vod.put("vod_play_url", "播放$epglist_" + id);
                return vod;
            }

            // Use first item for metadata
            JSONObject firstItem = arr.getJSONObject(0);
            vod.put("vod_name", firstItem.optString("vodName", "EPG列表"));
            String picPath = firstItem.optString("picPath", "");
            if (!picPath.isEmpty()) {
                vod.put("vod_pic", fixEpgImageUrl(picPath));
            }

            // Build merged groups of episodes
            JSONArray builtList = buildEpgVodList(arr, id);

            if (builtList.length() == 0) {
                vod.put("vod_play_url", "播放$epglist_" + id);
                return vod;
            }

            // Generate play URLs from the built list
            StringBuilder playUrl = new StringBuilder();
            for (int i = 0; i < builtList.length(); i++) {
                JSONObject item = builtList.getJSONObject(i);
                String itemId = item.optString("vod_id", "");
                String itemName = item.optString("vod_name", "");
                if (itemId.isEmpty()) continue;
                if (i > 0) playUrl.append("#");
                playUrl.append(itemName);
                playUrl.append("$").append(itemId);
            }
            vod.put("vod_play_url", playUrl.toString());
            return vod;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Build detail for merged EPG items.
     * ID format: epgm_{typeId}_{vodId1,vodId2,...}
     */
    private JSONObject buildEpgMergedDetail(String id) {
        try {
            String[] parts = id.split("_", 2);
            String typeId = parts.length >= 1 ? parts[0] : "";
            String[] vodIds = (parts.length >= 2 ? parts[1] : "").split(",");

            JSONObject vod = new JSONObject();
            vod.put("vod_id", "epgm_" + id);
            vod.put("vod_play_from", "华为IPTV");

            String firstVodId = vodIds.length > 0 ? vodIds[0] : "";
            String code = "";

            if (!firstVodId.isEmpty() && !typeId.isEmpty()) {
                JSONObject vodList = getEpgVodList(typeId, 0, 500);
                if (vodList != null) {
                    JSONArray arr = vodList.optJSONArray("arr");
                    if (arr != null) {
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject item = arr.getJSONObject(i);
                            if (firstVodId.equals(item.optString("vodId", ""))) {
                                vod.put("vod_name", item.optString("vodName", ""));
                                String picPath = item.optString("picPath", "");
                                if (!picPath.isEmpty()) {
                                    vod.put("vod_pic", fixEpgImageUrl(picPath));
                                }
                                code = item.optString("code", "");
                                break;
                            }
                        }
                    }
                }
            }

            // Get SDMS detail from the code
            if (!code.isEmpty()) {
                JSONObject detail = getDetail(code);
                if (detail != null) {
                    if (!vod.has("vod_name") || vod.optString("vod_name", "").isEmpty()) {
                        vod.put("vod_name", detail.optString("name", ""));
                    }
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
                }
            }

            // Build episode list
            StringBuilder playUrl = new StringBuilder();
            for (int i = 0; i < vodIds.length; i++) {
                if (i > 0) playUrl.append("#");
                playUrl.append("第").append(i + 1).append("集");
                playUrl.append("$epg_").append(vodIds[i]).append("_").append(typeId);
            }
            vod.put("vod_play_url", playUrl.toString());
            return vod;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Build a single EPG vod item for display in a list.
     */
    private JSONObject buildEpgVodItem(JSONObject item, String typeId) {
        try {
            String picPath = item.optString("picPath", "");
            String seriesFlag = item.optString("seriesflag", "0");
            String isSitcom = item.optString("isSitcom", "0");
            String code = item.optString("code", "");
            String vodId = item.optString("vodId", "");
            String rootTypeId = item.optString("TYPEID", item.optString("rootTypeId", typeId));
            String vodName = item.optString("vodName", "");

            String remarks;
            if ("1".equals(isSitcom) || "1".equals(seriesFlag)) {
                JSONArray children = item.optJSONArray("childrenList");
                int epCount = children != null ? children.length() : item.optInt("sitcomNum", 0);
                if (epCount > 0) {
                    remarks = getPrefix(code) + " 连续剧" + epCount + "集";
                } else {
                    remarks = getPrefix(code) + " 连续剧";
                }
            } else {
                remarks = getPrefix(code);
            }

            return new JSONObject()
                .put("vod_id", "epg_" + vodId + "_" + rootTypeId + "_" + code)
                .put("vod_name", vodName)
                .put("vod_pic", fixEpgImageUrl(picPath))
                .put("vod_remarks", remarks);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Build a merged EPG vod list, grouping series together.
     */
    private JSONArray buildEpgVodList(JSONArray items, String typeId) {
        try {
            JSONArray result = new JSONArray();
            LinkedHashMap<String, List<JSONObject>> groups = new LinkedHashMap<>();

            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                String isSitcom = item.optString("isSitcom", "0");
                String seriesFlag = item.optString("seriesflag", "0");
                String vodName = item.optString("vodName", "");
                String vodId = item.optString("vodId", "");

                if ("1".equals(isSitcom) || "1".equals(seriesFlag)) {
                    String key = "__sitcom__" + vodId;
                    if (!groups.containsKey(key)) {
                        groups.put(key, new ArrayList<JSONObject>());
                    }
                    groups.get(key).add(item);
                } else {
                    if (!groups.containsKey(vodName)) {
                        groups.put(vodName, new ArrayList<JSONObject>());
                    }
                    groups.get(vodName).add(item);
                }
            }

            for (Map.Entry<String, List<JSONObject>> entry : groups.entrySet()) {
                List<JSONObject> group = entry.getValue();
                if (group.size() == 1) {
                    JSONObject built = buildEpgVodItem(group.get(0), typeId);
                    if (built != null) result.put(built);
                } else {
                    JSONObject first = group.get(0);
                    String vodName = first.optString("vodName", "");
                    String rootTypeId = first.optString("TYPEID",
                        first.optString("rootTypeId", typeId));
                    String code = first.optString("code", "");
                    String picPath = first.optString("picPath", "");

                    StringBuilder ids = new StringBuilder();
                    for (JSONObject item : group) {
                        if (ids.length() > 0) ids.append(",");
                        ids.append(item.optString("vodId", ""));
                    }

                    result.put(new JSONObject()
                        .put("vod_id", "epgm_" + rootTypeId + "_" + ids.toString())
                        .put("vod_name", vodName)
                        .put("vod_pic", fixEpgImageUrl(picPath))
                        .put("vod_remarks", getPrefix(code) + " " + group.size() + "集"));
                }
            }
            return result;
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // searchContent
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String searchContent(String key, boolean quick) {
        try {
            JSONArray list = new JSONArray();
            String lowerKey = key.toLowerCase();
            boolean isAscii = lowerKey.matches("^[a-z0-9]+$");

            // Local index search
            if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                    if (entry.getKey().contains(lowerKey)) {
                        String code = entry.getValue();
                        String name = entry.getKey();
                        JSONObject vod = new JSONObject();
                        vod.put("vod_id", code);
                        vod.put("vod_name", name);
                        vod.put("vod_pic", getSearchPic(code));
                        vod.put("vod_remarks", getPrefix(code));
                        list.put(vod);
                        if (list.length() >= 50) break;
                    }
                }

                // Pinyin index search (ASCII-only queries)
                if (isAscii && list.length() < 50) {
                    for (Map.Entry<String, String> entry : this.pinyinIndex.entrySet()) {
                        if (entry.getKey().contains(lowerKey)) {
                            String name = entry.getValue();
                            String code = this.searchIndex.get(name);
                            if (code == null || code.isEmpty()) continue;

                            // Deduplicate
                            boolean dup = false;
                            for (int i = 0; i < list.length(); i++) {
                                if (list.getJSONObject(i).optString("vod_id", "").equals(code)) {
                                    dup = true;
                                    break;
                                }
                            }
                            if (dup) continue;

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

            // EPG search
            if (this.epgHost != null) {
                JSONArray epgResults = searchEpg(key);
                for (int i = 0; i < epgResults.length() && list.length() < 80; i++) {
                    try {
                        JSONObject item = epgResults.getJSONObject(i);
                        String code = item.optString("code", "");
                        String vodName = item.optString("vodName", "");
                        if (vodName.isEmpty()) continue;

                        String vodId = item.optString("vodId", "");
                        String typeId = item.optString("TYPEID",
                            item.optString("rootTypeId", ""));
                        String picPath = item.optString("picPath", "");
                        String seriesFlag = item.optString("seriesflag", "0");
                        String prefix;
                        if ("1".equals(seriesFlag)) {
                            prefix = getPrefix(code) + " 连续剧";
                        } else {
                            prefix = getPrefix(code);
                        }

                        JSONObject vod = new JSONObject();
                        vod.put("vod_id", "epg_" + vodId + "_" + typeId + "_" + code);
                        vod.put("vod_name", vodName);
                        vod.put("vod_pic", fixEpgImageUrl(picPath));
                        vod.put("vod_remarks", prefix);
                        list.put(vod);
                    } catch (Exception ignored) {
                    }
                }
            }

            // Online search (SDMS search)
            if (!this.searchIndexBuilt || this.searchIndex.isEmpty()) {
                JSONArray onlineResults = searchOnline(key);
                for (int i = 0; i < onlineResults.length() && list.length() < 80; i++) {
                    try {
                        JSONObject item = onlineResults.getJSONObject(i);
                        String code = item.optString("code",
                            item.optString("telecomcode", ""));
                        String name = item.optString("name", "");
                        if (code.isEmpty() || name.isEmpty()) continue;

                        String prefix = getPrefix(code);
                        if ("1".equals(item.optString("seriesflag", "0"))) {
                            prefix = prefix + " 连续剧";
                        }

                        JSONObject vod = new JSONObject();
                        vod.put("vod_id", code);
                        vod.put("vod_name", name);
                        vod.put("vod_pic", fixImageUrl(
                            item.optString("fileurl", item.optString("poster", ""))));
                        vod.put("vod_remarks", prefix);
                        list.put(vod);
                    } catch (Exception ignored) {
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

    private boolean isSdk(String code) {
        return getPrefix(code).equals("极光");
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
                            searchIndexBuilt = false;
                            buildSearchIndex();
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
                            buildSearchIndex();
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
            if (id.startsWith("hk_")) {
                realCode = id.substring(3);
            } else if (id.startsWith("epg_")) {
                realCode = id.substring(4);
            }

            // SDK content — needs parser
            String codeForCheck = realCode.contains("_")
                ? realCode.split("_")[realCode.split("_").length - 1] : realCode;
            if (isSdk(codeForCheck)) {
                JSONObject result = new JSONObject();
                result.put("parse", 1);
                result.put("url", "");
                result.put("msg", "SDK节目: " + getPrefix(codeForCheck));
                return result.toString();
            }

            ensureAlive();
            String playUrl = null;

            if (id.startsWith("epg_")) {
                // EPG play: parse vodId, typeId, optional code
                String[] parts = realCode.split("_");
                String progId = parts.length >= 1 ? parts[0] : "";
                String typeId = parts.length >= 2 ? parts[1] : "";
                String code = parts.length >= 3 ? parts[2] : "";

                playUrl = getPlayUrlEpg(progId, typeId);
                if (playUrl == null && !code.isEmpty()) {
                    playUrl = getPlayUrlHk(code);
                }
            } else {
                playUrl = getPlayUrlHk(realCode);
            }

            // Retry after re-auth
            if (playUrl == null) {
                stopHeartbeat();
                this.authed = false;
                this.cookieManager.getCookieStore().removeAll();
                if (login()) {
                    if (id.startsWith("epg_")) {
                        String[] parts = realCode.split("_");
                        String progId = parts.length >= 1 ? parts[0] : "";
                        String typeId = parts.length >= 2 ? parts[1] : "";
                        String code = parts.length >= 3 ? parts[2] : "";
                        playUrl = getPlayUrlEpg(progId, typeId);
                        if (playUrl == null && !code.isEmpty()) {
                            playUrl = getPlayUrlHk(code);
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
            if (playUrl == null) {
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
                        "http://%s/EPG/jsp/defaulttrans2/en/datajsp/geturlhwNew.jsp?code=%s",
                        this.epgHost, URLEncoder.encode(c, "UTF-8"));
                    String res = httpGet(url);
                    if (res != null) {
                        String trimmed = res.trim();
                        if (trimmed.startsWith("rtsp://") || trimmed.startsWith("http://")) {
                            return trimmed;
                        }
                        Matcher m = Pattern.compile("(rtsp://[^\\s\"<>\\']+)").matcher(trimmed);
                        if (m.find()) return m.group(1).trim();
                    }
                } catch (Exception ignored) {
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    private String getPlayUrlEpg(String progId, String typeId) {
        if (!this.authed || this.epgHost == null) return null;

        try {
            HashMap<String, String> params = new HashMap<>();
            params.put("PROGID", progId);
            params.put("TYPEID", typeId);
            params.put("PLAYTYPE", "1");
            params.put("CONTENTTYPE", "10");
            params.put("BUSINESSTYPE", "1");
            params.put("ONECEPRICE", "0");

            JSONObject resp = epgGetJson(
                "/EPG/jsp/defaulttrans2/en/datajsp/play_getVodPlayUrl.jsp", params);
            if (resp != null && resp.optBoolean("isSucess", false)) {
                String url = resp.optString("url", "");
                if (!url.isEmpty()) return url;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // Search index building
    // ═══════════════════════════════════════════════════════════════

    private void buildSearchIndex() {
        loadSearchIndex();

        try {
            JSONArray rootCats = getRootCategories();
            ExecutorService pool = Executors.newFixedThreadPool(6);
            int latchCount = (rootCats != null ? rootCats.length() : 0)
                + ZONE_DEFAULT_SUB.size();
            final CountDownLatch latch = new CountDownLatch(latchCount);

            if (rootCats != null) {
                for (int i = 0; i < rootCats.length(); i++) {
                    try {
                        JSONObject cat = rootCats.getJSONObject(i);
                        final String catId = cat.optString(
                            "primaryid", cat.optString("id", ""));
                        if (catId.isEmpty()) {
                            latch.countDown();
                            continue;
                        }
                        pool.submit(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    indexCategoryRecursive(catId, 0);
                                } finally {
                                    latch.countDown();
                                }
                            }
                        });
                    } catch (Exception e) {
                        latch.countDown();
                    }
                }
            }

            for (final String zoneId : ZONE_DEFAULT_SUB.keySet()) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            indexCategoryRecursive(zoneId, 0);
                        } finally {
                            latch.countDown();
                        }
                    }
                });
            }

            latch.await(15, TimeUnit.MINUTES);
            pool.shutdown();
        } catch (Exception ignored) {
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
                    String subId = cat.optString(
                        "primaryid", cat.optString("id", ""));
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
            if (!file.exists()) return;

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                parseIndexLine(line);
            }
            reader.close();
        } catch (Exception ignored) {
        }
    }

    private void parseIndexLine(String line) {
        int tabIdx = line.indexOf('\t');
        if (tabIdx <= 0) return;
        String key = line.substring(0, tabIdx);
        String value = line.substring(tabIdx + 1);

        if ("__timestamp__".equals(key)) {
            this.indexTimestamp = value;
            return;
        }
        if ("__pinyin__".equals(key)) {
            int tab2 = value.indexOf('\t');
            if (tab2 > 0) {
                String py = value.substring(0, tab2);
                String name = value.substring(tab2 + 1);
                if (!py.isEmpty() && !name.isEmpty()) {
                    this.pinyinIndex.put(py, name);
                }
            }
            return;
        }
        if (!key.isEmpty() && !value.isEmpty()) {
            this.searchIndex.put(key, value);
        }
    }

    private void saveSearchIndex() {
        if (this.indexFilePath == null || this.searchIndex.isEmpty()) return;

        try {
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sb.append("__timestamp__\t");
            sb.append(sdf.format(new Date()));
            sb.append('\n');

            for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                sb.append(entry.getKey());
                sb.append('\t');
                sb.append(entry.getValue());
                sb.append('\n');
            }

            FileOutputStream fos = new FileOutputStream(this.indexFilePath);
            fos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (Exception ignored) {
        }
    }

    private void loadIndexIcon() {
        if (!this.indexIconUri.isEmpty()) return;
        try {
            InputStream is = getClass().getResourceAsStream("/res/ICON.png");
            if (is != null) {
                int available = is.available();
                byte[] buf = new byte[available];
                int total = 0;
                while (total < available) {
                    int n = is.read(buf, total, available - total);
                    if (n <= 0) break;
                    total += n;
                }
                is.close();
                if (total > 0) {
                    byte[] data = Arrays.copyOf(buf, total);
                    String b64 = Base64.getEncoder().encodeToString(data);
                    this.indexIconUri = "data:image/png;base64," + b64;
                }
            }
        } catch (Exception ignored) {
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // SDMS data fetching
    // ═══════════════════════════════════════════════════════════════

    private JSONArray getRootCategories() {
        if (this.cache.containsKey("root_cats")) {
            return (JSONArray) this.cache.get("root_cats");
        }
        try {
            JSONArray categories = getCategories("1001");
            if (categories == null) return null;

            JSONArray result = new JSONArray();
            for (int i = 0; i < categories.length(); i++) {
                JSONObject cat = categories.getJSONObject(i);
                String name = cat.optString("name", "");
                String count = cat.optString("programCount", "0");
                if (!name.contains("弃用") && !name.startsWith("老")
                    && !name.startsWith("原") && !"0".equals(count)) {
                    result.put(cat);
                }
            }
            if (result.length() > 0) {
                this.cache.put("root_cats", result);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONArray getCategories(String categoryId) {
        String key = "cat_" + categoryId;
        if (this.cache.containsKey(key)) {
            return (JSONArray) this.cache.get(key);
        }
        try {
            String url = sdmsCategoryPath(categoryId);
            String res = httpGet(url);
            if (res == null) return null;
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
        String key = "prog_" + categoryId + "_" + page;
        if (this.cache.containsKey(key)) {
            return (JSONObject) this.cache.get(key);
        }
        try {
            String url = sdmsProgramPath(categoryId, page);
            String res = httpGet(url);
            if (res == null) return null;
            JSONObject jsonp = parseJsonp(res);
            if (jsonp != null) {
                this.cache.put(key, jsonp);
            }
            return jsonp;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject getDetail(String code) {
        String key = "detail_" + code;
        if (this.cache.containsKey(key)) {
            return (JSONObject) this.cache.get(key);
        }
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
            String url = sdmsDetailPath(code)
                + "?hkMac=" + this.mac.replace(":", "")
                + "&hkIp=" + this.localIp
                + "&hkUserId=" + this.userId;
            String res = httpGet(url);
            if (res == null) { this.cache.put(key, ""); return ""; }
            JSONObject jsonp = parseJsonp(res);
            if (jsonp == null) { this.cache.put(key, ""); return ""; }

            JSONArray pictures = jsonp.optJSONArray("picturelist");
            if (pictures != null) {
                for (int i = 0; i < pictures.length(); i++) {
                    JSONObject pic = pictures.getJSONObject(i);
                    if ("2".equals(pic.optString("type"))) {
                        String picUrl = fixImageUrl(pic.optString("fileurl", ""));
                        if (!picUrl.isEmpty()) {
                            this.cache.put(key, picUrl);
                            return picUrl;
                        }
                    }
                }
            }
            this.cache.put(key, "");
        } catch (Exception ignored) {
        }
        return "";
    }

    // ── EPG data fetching ────────────────────────────────────────

    private JSONArray getEpgCategories(String recTypeId) {
        String key = "epgcat_" + recTypeId;
        if (this.cache.containsKey(key)) {
            return (JSONArray) this.cache.get(key);
        }
        try {
            HashMap<String, String> params = new HashMap<>();
            params.put("recTypeId", recTypeId);
            String res = epgGet(
                "/EPG/jsp/defaulttrans2/en/datajsp/waterfall_getTypeListData.jsp", params);
            if (res == null) return null;

            Object nextVal = new JSONTokener(res).nextValue();
            if (nextVal instanceof JSONArray) {
                JSONArray arr = (JSONArray) nextVal;
                this.cache.put(key, arr);
                return arr;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    private JSONObject getEpgVodList(String recTypeId, int start, int length) {
        String key = "epgvod_" + recTypeId + "_" + start;
        if (this.cache.containsKey(key)) {
            return (JSONObject) this.cache.get(key);
        }
        try {
            HashMap<String, String> params = new HashMap<>();
            params.put("recTypeId", recTypeId);
            params.put("STATION", String.valueOf(start));
            params.put("LENGTH", String.valueOf(length));
            params.put("subLength", "200");
            JSONObject resp = epgGetJson(
                "/EPG/jsp/defaulttrans2/en/datajsp/vod_ListData.jsp", params);
            if (resp != null) {
                this.cache.put(key, resp);
            }
            return resp;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONArray searchEpg(String keyword) {
        try {
            HashMap<String, String> params = new HashMap<>();
            params.put("CONDITION", keyword);
            JSONObject resp = epgGetJson(
                "/EPG/jsp/defaulttrans2/en/datajsp/vod_searchResult.jsp", params);
            if (resp == null) return new JSONArray();
            return resp.optJSONArray("filmList");
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    private JSONArray searchOnline(String keyword) {
        try {
            String url = String.format(
                "http://%s:%d/cms/programIptv_searchByNameWithSearchTypeByJsonp.do"
                + "?time=%s&riddle=%s&vo.pageid=1&vo.pagecount=50"
                + "&vo.providerid=MAS&vo.name=%s&vo.searchtypeid=&callback=res",
                this.sdmsSearchHost, this.sdmsSearchPort,
                this.sdmsSearchTime, this.sdmsSearchRiddle,
                URLEncoder.encode(keyword, "UTF-8"));
            String res = httpGet(url);
            if (res == null) return new JSONArray();

            int start = res.indexOf('(');
            int end = res.lastIndexOf(')');
            if (start <= 0 || end <= start) return new JSONArray();

            return new JSONObject(res.substring(start + 1, end)).optJSONArray("list");
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    // ── EPG HTTP helpers ─────────────────────────────────────────

    private String epgGet(String path, Map<String, String> params) {
        try {
            StringBuilder url = new StringBuilder("http://" + this.epgHost + path);
            if (params != null && !params.isEmpty()) {
                url.append("?");
                boolean first = true;
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if (!first) url.append("&");
                    url.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    url.append("=");
                    url.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    first = false;
                }
            }
            return httpGet(url.toString());
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject epgGetJson(String path, Map<String, String> params) {
        String res = epgGet(path, params);
        if (res == null) return null;
        try {
            return new JSONObject(res);
        } catch (Exception e) {
            return null;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // SDMS path building
    // ═══════════════════════════════════════════════════════════════

    private String sdmsCategoryPath(String id) {
        StringBuilder sb = new StringBuilder(String.format(
            "http://%s:%d/staticData/data/categorylist/",
            this.sdmsHost, this.sdmsPort));
        for (int i = 1; i <= id.length(); i += 3) {
            sb.append(id, 0, i);
            sb.append("/");
        }
        sb.append("C").append(id).append(".js");
        return sb.toString();
    }

    private String sdmsProgramPath(String id, int page) {
        StringBuilder sb = new StringBuilder(String.format(
            "http://%s:%d/staticData/data/programlist/",
            this.sdmsHost, this.sdmsPort));
        for (int i = 1; i <= id.length(); i += 3) {
            sb.append(id, 0, i);
            sb.append("/");
        }
        sb.append("P").append(id).append("_").append(page).append(".js");
        return sb.toString();
    }

    private String sdmsDetailPath(String code) {
        return String.format("http://%s:%d/staticData/data/detail/%s/D%s.js",
            this.sdmsHost, this.sdmsPort,
            code.substring(code.length() - 1), code);
    }

    // ═══════════════════════════════════════════════════════════════
    // Utility methods
    // ═══════════════════════════════════════════════════════════════

    private String getPrefix(String code) {
        if (code == null || code.isEmpty()) return "";

        String best;
        if (code.contains("_")) {
            best = code.split("_")[0];
        } else {
            // Find longest matching prefix
            List<String> sortedKeys = new ArrayList<>(PREFIX_NAMES.keySet());
            Collections.sort(sortedKeys, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return Integer.compare(b.length(), a.length());
                }
            });

            best = "";
            for (String key : sortedKeys) {
                if (code.startsWith(key)) {
                    best = key;
                    break;
                }
            }

            if (best.isEmpty()) {
                best = code.length() >= 8 ? code.substring(0, 8) : code;
            }
        }

        return PREFIX_NAMES.getOrDefault(best, best);
    }

    private String fixImageUrl(String url) {
        if (url == null || url.isEmpty()) return "";
        if (url.startsWith("//")) return "http:" + url;

        // Replace hardcoded host with configured host
        if (url.startsWith("http://124.132.253.193:85/")) {
            return url.replace("http://124.132.253.193:85/",
                String.format("http://%s:%d/", this.imgHost, this.imgPort));
        }

        if (url.startsWith("/data") || url.startsWith("/pic")) {
            return String.format("http://%s:%d", this.imgHost, this.imgPort) + url;
        }

        if (!url.startsWith("http")) {
            return String.format("http://%s:%d/", this.imgHost, this.imgPort) + url;
        }

        return url;
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
     * GET request that captures the resolved epgHost from the URL.
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

            if (code == 200 || code == 302) {
                // Capture epgHost from resolved URL
                if (this.epgHost == null) {
                    int port = resolvedUrl.getPort();
                    String portStr = (port > 0 && port != 80) ? ":" + port : "";
                    this.epgHost = resolvedUrl.getHost() + portStr;
                }

                if (code == 200) {
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) sb.append(line);
                    in.close();
                    conn.disconnect();
                    return sb.toString();
                }
            }

            conn.disconnect();
            return null;
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

    // ═══════════════════════════════════════════════════════════════
    // destroy
    // ═══════════════════════════════════════════════════════════════

    @Override
    public void destroy() {
        stopHeartbeat();
        this.authed = false;
        this.cache.clear();
        super.destroy();
    }
}
