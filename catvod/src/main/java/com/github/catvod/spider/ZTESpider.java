package com.github.catvod.spider;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.CryptoUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.json.JSONException;
import org.json.JSONObject;

public class ZTESpider extends Spider {

    // ── Auth params ──────────────────────────────────────────────
    private String easIp = "124.132.240.38";
    private String easPort = "8080";
    private String encryptKey = "";
    private String userId = "";
    private String stbId = "";
    private String mac = "";
    private String model = "";
    private String customStr = "$CTC";

    // ── SDMS params ──────────────────────────────────────────────
    private String sdmsHost = "124.132.253.193";
    private int sdmsPort = 86;
    private String imgHost = "usnm-hk.snctv.cn";
    private int imgPort = 85;
    private String sdmsSearchHost = "124.132.253.193";
    private int sdmsSearchPort = 81;
    private String sdmsSearchTime = "1541756249247";
    private String sdmsSearchRiddle = "5660c2fc967f0026ec138dcc36fff8d5";

    // ── Runtime state ────────────────────────────────────────────
    private String base;
    private String epgHost;
    private String userToken;
    private String localIp = "127.0.0.1";
    private boolean authed = false;
    private long authTime = 0;
    private String lastActiveFastIp = "";
    private static final long AUTH_TTL = 600000;
    private volatile boolean heartbeatRunning = false;
    private Thread heartbeatThread;
    private CookieManager cookieManager;

    // ── Search index ─────────────────────────────────────────────
    private final ConcurrentHashMap<String, String> searchIndex = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> pinyinIndex = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Set<String>> actorIndex = new ConcurrentHashMap<>();
    private volatile boolean searchIndexBuilt = false;
    private String indexTimestamp = "";
    private String indexFilePath;
    private String indexIconUri = "";

    // ── Cache ────────────────────────────────────────────────────
    private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    // ── Content provider name mapping ────────────────────────────
    private static final Map<String, String> PREFIX_NAMES = new HashMap<>();
    private static final Map<String, String> CODE_TRANSFORMS = new HashMap<>();

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
        PREFIX_NAMES.put("YHYKQTS", "优酷");
        PREFIX_NAMES.put("JZTX", "腾讯视频");
        PREFIX_NAMES.put("JZTQ", "腾讯视频");
        PREFIX_NAMES.put("JLTM", "极光");
        PREFIX_NAMES.put("XHUANWAN", "广州欢网");
        PREFIX_NAMES.put("LIZHI202", "荔枝TV");
        PREFIX_NAMES.put("SHENZHEN", "深圳悦道");
        PREFIX_NAMES.put("YUNWEPROGM", "云味");
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
        PREFIX_NAMES.put("SDGD", "山东广电");
        PREFIX_NAMES.put("YUNWEPROGM", "运维");
        PREFIX_NAMES.put("YUNWEI", "运维");
        PREFIX_NAMES.put("2110MAMS", "宣传片");
        PREFIX_NAMES.put("2110MPROGM", "宣传片");
        PREFIX_NAMES.put("21100001", "宣传片");
        PREFIX_NAMES.put("PR", "推荐位");

        CODE_TRANSFORMS.put("YHYKMLT", "YHYKQTS");
        CODE_TRANSFORMS.put("JZTX", "JZTQ");
        CODE_TRANSFORMS.put("GUOQY_ser_", "GUOQY_pro_");
    }

    // ── VOD categories ──────────────────────────────────────────
    private static final String[][] VOD_ROOT_CATS = {
        {"电影", "190V07"},
        {"电视剧", "190V06"},
        {"动画", "190V05"},
        {"娱乐", "190V04"},
        {"纪实", "190V03"},
        {"新闻", "190V08"},
        {"财经", "190V0X"},
        {"军事", "190V0R"},
        {"农业", "190V0W"},
        {"体育", "190V02"},
        {"生活", "190V01"},
        {"音乐", "190V09"},
        {"戏曲", "190V0Y"},
        {"法治", "190V00"},
        {"科教专区", "190V0N"},
        {"爱4K专区", "190V0Q"},
        {"爱4K精彩专题", "190V0D"},
        {"央视4K", "190V0C"},
        {"新闻专区", "190V0U"},
        {"爱看精彩", "190V0Z"},
    };

    private static final String[] VOD_HIDE_CATS = {
        "决胜小康", "新闻专区2019", "EPG3.0点播推荐",
        "EPG3.0爱看精品推荐", "极致版应急EPG", "测试栏目（福建）",
    };

    // ═══════════════════════════════════════════════════════════════
    // init
    // ═══════════════════════════════════════════════════════════════

    @Override
    public void init(android.content.Context context, String extJsonStr) {
        try {
            SpiderDebug.log("ZTESpider init ext前80=" + (extJsonStr != null ? extJsonStr.substring(0, Math.min(80, extJsonStr.length())) : "null"));

            // 索引文件路径
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                indexFilePath = new File(filesDir, "zte_search_index.txt").getAbsolutePath();
            }

            // 先尝试解密 ext（格式: "1:<hex>"）
            extJsonStr = CryptoUtil.unwrap(extJsonStr);
            SpiderDebug.log("ZTESpider init after unwrap=" + (extJsonStr != null ? extJsonStr.substring(0, Math.min(80, extJsonStr.length())) : "null"));

            // 兼容三种格式：JSON、加密JSON(1:hex)、旧版 $ 分隔
            if (extJsonStr.trim().startsWith("{")) {
                SpiderDebug.log("ZTESpider init -> JSON");
                parseJsonExt(new JSONObject(extJsonStr));
            } else {
                SpiderDebug.log("ZTESpider init -> legacy, raw=" + extJsonStr);
                parseLegacyExt(extJsonStr);
            }
            SpiderDebug.log("ZTESpider init done eKey=" + this.encryptKey + " uid=" + this.userId);

            // 预加载索引
            if (indexFilePath != null && !searchIndexBuilt) {
                loadSearchIndex();
            }

            // CookieManager — 管理 EPG 会话 Cookie
            cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    detectLocalIp();
                    login();
                }
            }).start();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
    }

    private void parseJsonExt(JSONObject ext) {
        try {
            if (ext.has("easIp")) this.easIp = ext.getString("easIp");
            if (ext.has("easPort")) this.easPort = ext.getString("easPort");
            if (ext.has("encryptKey")) this.encryptKey = ext.getString("encryptKey");
            if (ext.has("userId")) this.userId = ext.getString("userId");
            if (ext.has("stbId")) this.stbId = ext.getString("stbId");
            if (ext.has("mac")) this.mac = ext.getString("mac");
            if (ext.has("model")) this.model = ext.getString("model");
            if (ext.has("customStr")) this.customStr = ext.getString("customStr");
            if (ext.has("sdmsHost")) this.sdmsHost = ext.getString("sdmsHost");
            if (ext.has("sdmsPort")) this.sdmsPort = ext.getInt("sdmsPort");
            if (ext.has("imgHost")) this.imgHost = ext.getString("imgHost");
            if (ext.has("imgPort")) this.imgPort = ext.getInt("imgPort");
            if (ext.has("sdmsSearchHost")) this.sdmsSearchHost = ext.getString("sdmsSearchHost");
            if (ext.has("sdmsSearchPort")) this.sdmsSearchPort = ext.getInt("sdmsSearchPort");
            if (ext.has("sdmsSearchTime")) this.sdmsSearchTime = ext.getString("sdmsSearchTime");
            if (ext.has("sdmsSearchRiddle")) this.sdmsSearchRiddle = ext.getString("sdmsSearchRiddle");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseLegacyExt(String raw) {
        String[] parts = raw.split("\\$");
        if (parts.length >= 1) this.encryptKey = parts[0];
        if (parts.length >= 2) this.userId = parts[1];
        if (parts.length >= 3) this.stbId = parts[2];
        if (parts.length >= 4) this.mac = parts[3];
        if (parts.length >= 5) this.model = parts[4];
        if (parts.length >= 6 && !parts[5].isEmpty()) this.customStr = parts[5];
    }

    // ═══════════════════════════════════════════════════════════════
    // 3-step auth
    // ═══════════════════════════════════════════════════════════════

    private synchronized boolean login() {
        try {
            // 确保 localIp 已检测（可能还未被异步线程设置）
            if ("127.0.0.1".equals(this.localIp)) {
                detectLocalIp();
            }

            String getUrl = "http://" + this.easIp + ":" + this.easPort
                    + "/iptvepg/platform/getencrypttoken.jsp?UserID=" + this.userId
                    + "&Action=Login&TerminalFlag=1&TerminalOsType=0&STBID=&stbtype=";
            String handshakeResult = httpGet(getUrl);
            if (handshakeResult == null) return false;

            Matcher matcher = Pattern.compile("GetAuthInfo\\('(.*?)'\\)").matcher(handshakeResult);
            if (!matcher.find()) return false;
            String challengeCode = matcher.group(1);

            Matcher matcher2 = Pattern.compile("<form\\s+action=\"http://([^/]+):\\d+/iptvepg/platform/auth\\.jsp").matcher(handshakeResult);
            if (!matcher2.find()) return false;
            this.epgHost = matcher2.group(1);
            this.base = "http://" + this.epgHost + ":8080";

            long randomNum = (long) (Math.random() * 9.0E7d) + 10000000L;
            String rawAuthStr = String.format("%d$%s$%s$%s$%s$%s$%s",
                    randomNum, challengeCode, this.userId, this.stbId, this.localIp, this.mac, this.customStr);
            String authenticator = desEncrypt(rawAuthStr, this.encryptKey);

            String authPostUrl = this.base + "/iptvepg/platform/auth.jsp?easip=" + this.easIp + "&ipVersion=4&networkid=1";
            String authPostData = "UserID=" + URLEncoder.encode(this.userId, "UTF-8")
                    + "&Authenticator=" + URLEncoder.encode(authenticator, "UTF-8")
                    + "&StbIP=" + URLEncoder.encode(this.localIp, "UTF-8");

            String authResult = httpPost(authPostUrl, authPostData);
            if (authResult == null) return false;

            Matcher matcher3 = Pattern.compile("jsSetConfig\\('UserToken','([^']+)'").matcher(authResult);
            if (matcher3.find()) {
                this.userToken = matcher3.group(1);
            } else {
                Matcher matcher4 = Pattern.compile("UserToken=([A-Za-z0-9_\\-.]+)").matcher(authResult);
                if (!matcher4.find()) return false;
                this.userToken = matcher4.group(1);
            }

            Matcher matcher5 = Pattern.compile("window\\.location\\s*=\\s*'(http[^']+)'").matcher(authResult);
            if (matcher5.find()) {
                httpGet(matcher5.group(1));
            }

            String portalUrl = this.base + "/iptvepg/function/funcportalauth.jsp";
            String portalData = "UserToken=" + URLEncoder.encode(this.userToken, "UTF-8")
                    + "&UserID=" + URLEncoder.encode(this.userId, "UTF-8")
                    + "&STBID=" + URLEncoder.encode(this.stbId, "UTF-8")
                    + "&stbinfo=&prmid=&easip=" + URLEncoder.encode(this.easIp, "UTF-8")
                    + "&networkid=1&stbtype=" + URLEncoder.encode(this.model, "UTF-8") + "&drmsupplier=";
            String portalResult = httpPost(portalUrl, portalData);
            if (portalResult != null && (portalResult.contains("errorHandler") || portalResult.contains("ErrorCode"))) {
                return false;
            }

            httpGet(this.base + "/iptvepg/function/frame.jsp");
            httpPost(this.base + "/iptvepg/function/frameset_judger.jsp", "picturetype=1%2C3%2C5");
            httpGet(this.base + "/iptvepg/frame205/channel_start.jsp?tempno=-1");

            this.authed = true;
            this.authTime = System.currentTimeMillis();
            startHeartbeat();
            SpiderDebug.log("ZTESpider login ok base=" + this.base);
            return true;
        } catch (Exception e) {
            SpiderDebug.log(e);
            return false;
        }
    }

    private boolean ensureAlive() {
        String currentFastIp = getLocalIpFast();
        boolean networkChanged = !currentFastIp.equals(this.lastActiveFastIp);
        if (networkChanged) {
            SpiderDebug.log("ZTESpider network changed! Old=" + this.lastActiveFastIp + ", New=" + currentFastIp);
            this.lastActiveFastIp = currentFastIp;
            this.localIp = "127.0.0.1"; // Force re-detection
        }

        if (this.authed && !networkChanged && System.currentTimeMillis() - this.authTime < AUTH_TTL) {
            return true;
        }
        SpiderDebug.log("ZTESpider re-login");
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
                            login();
                        } else {
                            httpGet(base + "/iptvepg/heartbeat.jsp");
                        }
                    } catch (Exception e) {
                        heartbeatRunning = false;
                        return;
                    }
                }
            }
        }, "ZTE-Heartbeat");
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

    // ═══════════════════════════════════════════════════════════════
    // homeContent — 首页分类（SDK专区 + 海看 + VOD）
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String homeContent(boolean filter) {
        try {
            JSONObject result = new JSONObject();
            JSONArray classes = new JSONArray();
            JSONObject filters = new JSONObject();

            // 腾讯专区
            JSONObject tencent = new JSONObject();
            tencent.put("type_id", "sdk_tencent");
            tencent.put("type_name", "腾讯专区");
            classes.put(tencent);
            if (filter) {
                JSONArray sdkSubs = new JSONArray();
                sdkSubs.put(createSdkSubFilter("全部视频", "1032007"));
                sdkSubs.put(createSdkSubFilter("电视剧", "1032002"));
                sdkSubs.put(createSdkSubFilter("电影", "1032001"));
                sdkSubs.put(createSdkSubFilter("综艺", "1032004"));
                sdkSubs.put(createSdkSubFilter("动漫", "1032005"));
                sdkSubs.put(createSdkSubFilter("少儿", "1032003"));
                sdkSubs.put(createSdkSubFilter("纪实", "1032006"));
                JSONArray filterArr = new JSONArray();
                JSONObject filterObj = new JSONObject();
                filterObj.put("key", "sdkcat");
                filterObj.put("name", "分类");
                filterObj.put("value", sdkSubs);
                filterArr.put(filterObj);
                filters.put("sdk_tencent", filterArr);
            }

            // 优酷专区
            JSONObject youku = new JSONObject();
            youku.put("type_id", "sdk_youku");
            youku.put("type_name", "优酷专区");
            classes.put(youku);
            if (filter) {
                JSONArray sdkSubs = new JSONArray();
                sdkSubs.put(createSdkSubFilter("全部视频", "1035006"));
                sdkSubs.put(createSdkSubFilter("电视剧", "1035002"));
                sdkSubs.put(createSdkSubFilter("电影", "1035001"));
                sdkSubs.put(createSdkSubFilter("纪实", "1035004"));
                JSONArray filterArr = new JSONArray();
                JSONObject filterObj = new JSONObject();
                filterObj.put("key", "sdkcat");
                filterObj.put("name", "分类");
                filterObj.put("value", sdkSubs);
                filterArr.put(filterObj);
                filters.put("sdk_youku", filterArr);
            }

            // SDMS 根分类（海看）
            JSONArray rootCats = getRootCategories();
            String firstId = "";
            String firstName = "";
            if (rootCats != null) {
                for (int i = 0; i < rootCats.length(); i++) {
                    JSONObject cat = rootCats.getJSONObject(i);
                    String id = cat.optString("primaryid", cat.optString("id", ""));
                    String name = cat.optString("name", "");
                    if (id.isEmpty() || name.isEmpty()) continue;
                    if (name.contains("付费")) {
                        if (firstId.isEmpty()) {
                            firstId = id;
                            firstName = name;
                        }
                        continue;
                    }

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

            // 如果第一个分类被跳过了（含"付费"），补上
            if (!firstId.isEmpty()) {
                JSONObject cls = new JSONObject();
                cls.put("type_id", firstId);
                cls.put("type_name", firstName);
                classes.put(cls);
                if (filter) {
                    JSONArray subCats = getCategories(firstId);
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
                            filters.put(firstId, filterArr);
                        }
                    }
                }
            }

            // VOD 分类（中兴IPTV点播）
            for (String[] colCode : VOD_ROOT_CATS) {
                String name = colCode[0];
                String code = colCode[1];
                JSONObject cls = new JSONObject();
                cls.put("type_id", "ztevod_" + code);
                cls.put("type_name", "VOD" + name);
                classes.put(cls);

                if (filter && this.authed) {
                    JSONArray subCols = fetchVodColumns(code, 2);
                    if (subCols != null && subCols.length() > 0) {
                        JSONArray subList = new JSONArray();
                        JSONObject all = new JSONObject();
                        all.put("n", "全部");
                        all.put("v", "");
                        subList.put(all);
                        for (int j = 0; j < subCols.length(); j++) {
                            JSONObject col = subCols.getJSONObject(j);
                            String colName = col.optString("columnname", "");
                            String colCode2 = col.optString("columncode", "");
                            if (colName.isEmpty() || colCode2.isEmpty()) continue;
                            boolean hide = false;
                            for (String h : VOD_HIDE_CATS) {
                                if (colName.contains(h)) { hide = true; break; }
                            }
                            if (hide) continue;
                            JSONObject item = new JSONObject();
                            item.put("n", colName);
                            item.put("v", colCode2);
                            subList.put(item);
                        }
                        if (subList.length() > 1) {
                            JSONArray filterArr = new JSONArray();
                            JSONObject filterObj = new JSONObject();
                            filterObj.put("key", "vodcol");
                            filterObj.put("name", "分类");
                            filterObj.put("value", subList);
                            filterArr.put(filterObj);
                            filters.put("ztevod_" + code, filterArr);
                        }
                    }
                }
            }

            result.put("class", classes);
            if (filter && filters.length() > 0) {
                result.put("filters", filters);
            }

            // 加载已有索引（首次进首页自动从文件恢复）
            loadSearchIndex();
            loadIndexIcon();
            if (!searchIndex.isEmpty()) {
                searchIndexBuilt = true;
            }

            return result.toString();
        } catch (Exception e) {
            return "{\"class\":[]}";
        }
    }

    private JSONObject createSdkSubFilter(String name, String id) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("n", name);
            obj.put("v", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // ═══════════════════════════════════════════════════════════════
    // homeVideoContent — 首页推荐 + 索引更新入口
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String homeVideoContent() {
        try {
            JSONObject result = new JSONObject();
            JSONArray list = new JSONArray();

            // 索引更新入口
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

            // 从推荐栏目获取
            JSONObject programs = getPrograms("1001016022", 1);
            if (programs != null) {
                JSONArray items = programs.optJSONArray("list");
                if (items != null) {
                    int max = Math.min(items.length(), 12);
                    for (int i = 0; i < max; i++) {
                        JSONObject item = items.getJSONObject(i);
                        JSONObject vod = new JSONObject();
                        vod.put("vod_id", item.optString("code", ""));
                        vod.put("vod_name", item.optString("name", ""));
                        vod.put("vod_pic", fixImageUrl(item.optString("fileurl", item.optString("poster", ""))));
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
    // categoryContent — 分类列表
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String categoryContent(String tid, String pg, boolean filter, HashMap<String, String> extend) {
        ensureAlive();
        try {
            int page = Integer.parseInt(pg);
            JSONArray list = new JSONArray();
            int pageCount = 1;

            if (tid.startsWith("sdk_")) {
                // SDK 专区
                String sdkCat = extend != null ? extend.get("sdkcat") : null;
                if (sdkCat == null || sdkCat.isEmpty()) {
                    if ("sdk_tencent".equals(tid)) sdkCat = "1032007";
                    else if ("sdk_youku".equals(tid)) sdkCat = "1035006";
                }
                if (sdkCat != null && !sdkCat.isEmpty()) {
                    for (int p = page; p <= 50; p++) {
                        JSONObject progs = getPrograms(sdkCat, p);
                        if (progs == null) break;
                        JSONArray items = progs.optJSONArray("list");
                        if (items == null || items.length() == 0) break;
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject item = items.getJSONObject(i);
                            String code = item.optString("code", "");
                            String prefix = getPrefix(code);
                            if ("1".equals(item.optString("seriesflag", "0"))) prefix = prefix + " 连续剧";
                            JSONObject vod = new JSONObject();
                            vod.put("vod_id", code);
                            vod.put("vod_name", item.optString("name", ""));
                            vod.put("vod_pic", fixImageUrl(item.optString("fileurl", item.optString("poster", ""))));
                            vod.put("vod_remarks", prefix);
                            list.put(vod);
                        }
                        if (p >= progs.optInt("pagecount", 1)) {
                            pageCount = progs.optInt("pagecount", 1);
                            break;
                        }
                    }
                }
            } else if (tid.startsWith("ztevod_")) {
                // VOD 点播分类
                String colCode = tid.substring(7);
                String vodCol = extend != null ? extend.get("vodcol") : null;
                String catId = (vodCol != null && !vodCol.isEmpty()) ? vodCol : colCode;
                for (int p = page; p <= 20; p++) {
                    JSONObject vodPage = fetchVodPage(catId, p, 50);
                    if (vodPage == null) break;
                    JSONArray items = vodPage.optJSONArray("vodData");
                    if (items == null || items.length() == 0) break;
                    int totalCount = vodPage.optInt("totalCount", 0);
                    for (int i = 0; i < items.length(); i++) {
                        JSONObject item = items.getJSONObject(i);
                        String pid = item.optString("programId", "");
                        String tcode = item.optString("telecomcode", "");
                        String name = item.optString("programName", "");
                        if (pid.isEmpty() && tcode.isEmpty()) continue;
                        String vodId = "ztevod|" + pid + "|" + tcode;
                        JSONObject vod = new JSONObject();
                        vod.put("vod_id", vodId);
                        vod.put("vod_name", name);
                        vod.put("vod_pic", fixVodImageUrl(item.optString("normalposter", "")));
                        vod.put("vod_remarks", "VOD");
                        list.put(vod);
                    }
                    pageCount = Math.max(1, (totalCount + 49) / 50);
                    break;
                }
            } else {
                // SDMS 普通分类
                String subCat = extend != null ? extend.get("sub") : null;
                String catId = (subCat != null && !subCat.isEmpty()) ? subCat : tid;
                JSONObject progs = getPrograms(catId, page);
                if (progs != null) {
                    pageCount = progs.optInt("pagecount", 1);
                    JSONArray items = progs.optJSONArray("list");
                    if (items != null && items.length() > 0) {
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject item = items.getJSONObject(i);
                            String code = item.optString("code", "");
                            String prefix = getPrefix(code);
                            if ("1".equals(item.optString("seriesflag", "0"))) prefix = prefix + " 连续剧";
                            JSONObject vod = new JSONObject();
                            vod.put("vod_id", code);
                            vod.put("vod_name", item.optString("name", ""));
                            vod.put("vod_pic", fixImageUrl(item.optString("fileurl", item.optString("poster", ""))));
                            vod.put("vod_remarks", prefix);
                            list.put(vod);
                        }
                    }
                }
                // 无内容时尝试第一个子分类
                if (list.length() == 0) {
                    JSONArray subCats = getCategories(catId);
                    if (subCats != null) {
                        for (int i = 0; i < subCats.length() && list.length() == 0; i++) {
                            JSONObject cat = subCats.getJSONObject(i);
                            String subId = cat.optString("primaryid", cat.optString("name", ""));
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
                                        if ("1".equals(item.optString("seriesflag", "0"))) prefix = prefix + " 连续剧";
                                        JSONObject vod = new JSONObject();
                                        vod.put("vod_id", code);
                                        vod.put("vod_name", item.optString("name", ""));
                                        vod.put("vod_pic", fixImageUrl(item.optString("fileurl", item.optString("poster", ""))));
                                        vod.put("vod_remarks", prefix);
                                        list.put(vod);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            JSONObject result = new JSONObject();
            result.put("page", page);
            result.put("pagecount", pageCount);
            result.put("list", list);
            return result.toString();
        } catch (Exception e) {
            return "{\"list\":[]}";
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // detailContent — 详情 + 索引管理
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
                    vod.put("vod_content", "当前索引: " + this.searchIndex.size() + " 部影片\n"
                            + "索引日期: " + (this.indexTimestamp.isEmpty() ? "未知" : this.indexTimestamp)
                            + "\n\n点击下方\"播放\"按钮开始全量更新索引\n更新完成后自动保存，下次启动无需重新拉取");
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
            if (id.startsWith("ztevod|")) {
                return buildZteVodDetail(id);
            }

            JSONObject detail = getDetail(id);
            JSONObject vod = new JSONObject();
            vod.put("vod_id", id);
            vod.put("vod_name", id);
            vod.put("vod_play_from", "海看IPTV");

            if (detail == null) {
                vod.put("vod_play_url", "播放$hk_" + id);
                return vod;
            }

            vod.put("vod_name", detail.optString("name", id));
            vod.put("vod_year", detail.optString("releaseyear", ""));
            vod.put("vod_area", detail.optString("originalcountry", ""));
            String actorsVod = detail.optString("actordisplay", "");
            vod.put("vod_actor", actorsVod);
            indexActors(actorsVod, id, detail.optString("name", ""));
            vod.put("vod_director", detail.optString("director", ""));
            vod.put("vod_content", detail.optString("description", ""));

            JSONArray pictures = detail.optJSONArray("picturelist");
            if (pictures != null) {
                for (int i = 0; i < pictures.length(); i++) {
                    JSONObject pic = pictures.getJSONObject(i);
                    if ("2".equals(pic.optString("type")) && !pic.optString("fileurl", "").isEmpty()) {
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

    private JSONObject buildZteVodDetail(String id) {
        try {
            String[] parts = id.substring(7).split("\\|", -1);
            String pid = parts.length >= 1 ? parts[0] : "";
            String tcode = parts.length >= 2 ? parts[1] : "";
            if (tcode.isEmpty()) tcode = pid;

            JSONObject vod = new JSONObject();
            vod.put("vod_id", id);
            vod.put("vod_name", id);
            vod.put("vod_play_from", "中兴IPTV");

            JSONObject detail = getDetail(tcode);
            if (detail == null && !pid.isEmpty() && !pid.equals(tcode)) {
                detail = getDetail(pid);
            }

            if (detail == null) {
                vod.put("vod_play_url", "播放$zte|" + tcode + "|" + pid);
                return vod;
            }

            vod.put("vod_name", detail.optString("name", id));
            vod.put("vod_year", detail.optString("releaseyear", ""));
            vod.put("vod_area", detail.optString("originalcountry", ""));
            String actorsVod = detail.optString("actordisplay", "");
            vod.put("vod_actor", actorsVod);
            indexActors(actorsVod, id, detail.optString("name", ""));
            vod.put("vod_director", detail.optString("director", ""));
            vod.put("vod_content", detail.optString("description", ""));

            JSONArray pictures = detail.optJSONArray("picturelist");
            if (pictures != null) {
                for (int i = 0; i < pictures.length(); i++) {
                    JSONObject pic = pictures.getJSONObject(i);
                    if ("2".equals(pic.optString("type")) && !pic.optString("fileurl", "").isEmpty()) {
                        vod.put("vod_pic", fixVodImageUrl(pic.optString("fileurl")));
                        break;
                    }
                }
            }

            JSONArray series = detail.optJSONArray("serieslist");
            if (series == null || series.length() == 0) {
                vod.put("vod_play_url", "播放$zte|" + tcode + "|" + pid);
                return vod;
            }

            StringBuilder playUrl = new StringBuilder();
            for (int i = 0; i < series.length(); i++) {
                JSONObject ep = series.getJSONObject(i);
                if (i > 0) playUrl.append("#");
                playUrl.append(ep.optString("name", "第" + (i + 1) + "集"));
                playUrl.append("$zte|").append(ep.optString("code", "")).append("|").append(pid);
            }
            vod.put("vod_play_url", playUrl.toString());
            return vod;
        } catch (Exception e) {
            return null;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // searchContent — 搜索（本地索引 + 拼音 + 在线）
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String searchContent(String key, boolean quick) {
        ensureAlive();
        try {
            JSONArray list = new JSONArray();
            String lowerKey = key.toLowerCase();
            boolean isAscii = lowerKey.matches("^[a-z0-9]+$");

            // 本地索引搜索
            if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = this.searchIndex.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> entry = it.next();
                    if (!entry.getKey().contains(lowerKey)) continue;

                    String code = entry.getValue();
                    String name = entry.getKey();
                    String pic = "";

                    if (code.startsWith("ztevod|")) {
                        String[] parts = code.substring(7).split("\\|", -1);
                        String pid = parts[0];
                        Object cached = cache.get("spic_vod_" + pid);
                        if (cached instanceof String && !((String) cached).isEmpty()) {
                            pic = (String) cached;
                        } else if (parts.length >= 3 && !parts[2].isEmpty()) {
                            pic = fixVodImageUrl(parts[2]);
                        }
                        if (pic.isEmpty()) {
                            pic = getVodSearchPic(pid);
                        }
                    } else {
                        Object cached = cache.get("spic_" + code);
                        if (cached instanceof String && !((String) cached).isEmpty()) {
                            pic = (String) cached;
                        }
                        if (pic.isEmpty()) {
                            pic = getSearchPic(code);
                        }
                    }

                    String prefix;
                    if (code.startsWith("ztevod|")) {
                        prefix = "VOD";
                    } else {
                        prefix = getPrefix(code);
                    }

                    if (pic.isEmpty() && !this.indexIconUri.isEmpty()) pic = this.indexIconUri;
                    JSONObject vod = new JSONObject();
                    vod.put("vod_id", code);
                    vod.put("vod_name", name);
                    vod.put("vod_pic", pic);
                    vod.put("vod_remarks", prefix);
                    list.put(vod);
                }

                // 拼音索引
                if (isAscii) {
                    for (Map.Entry<String, String> entry : this.pinyinIndex.entrySet()) {
                        if (!entry.getKey().contains(lowerKey)) continue;
                        String name = entry.getValue();
                        String code = this.searchIndex.get(name);
                        if (code == null || code.isEmpty()) continue;
                        boolean dup = false;
                        for (int i = 0; i < list.length(); i++) {
                            if (list.getJSONObject(i).optString("vod_name", "").equals(name)) {
                                dup = true;
                                break;
                            }
                        }
                        if (dup) continue;
                        String pic = "";
                        if (code.startsWith("ztevod|")) {
                            String[] parts = code.substring(7).split("\\|", -1);
                            String pid = parts[0];
                            Object cached = cache.get("spic_vod_" + pid);
                            if (cached instanceof String && !((String) cached).isEmpty()) {
                                pic = (String) cached;
                            } else if (parts.length >= 3 && !parts[2].isEmpty()) {
                                pic = fixVodImageUrl(parts[2]);
                            }
                            if (pic.isEmpty()) {
                                pic = getVodSearchPic(pid);
                            }
                        } else {
                            Object cached = cache.get("spic_" + code);
                            if (cached instanceof String && !((String) cached).isEmpty()) {
                                pic = (String) cached;
                            }
                            if (pic.isEmpty()) {
                                pic = getSearchPic(code);
                            }
                        }
                        String prefix = code.startsWith("ztevod|") ? "VOD" : getPrefix(code);
                        if (pic.isEmpty() && !this.indexIconUri.isEmpty()) {
                            pic = this.indexIconUri;
                        }
                        JSONObject vod = new JSONObject();
                        vod.put("vod_id", code);
                        vod.put("vod_name", name);
                        vod.put("vod_pic", pic);
                        vod.put("vod_remarks", prefix);
                        list.put(vod);
                    }
                }
            }

            // 在线搜索补充
            try {
                String encKey = URLEncoder.encode(key, "UTF-8");
                String url = String.format("http://%s:%d/cms/programIptv_searchByNameWithSearchTypeByJsonp.do?time=%s&riddle=%s&vo.pageid=1&vo.pagecount=50&vo.providerid=MAS&vo.name=%s&vo.searchtypeid=&callback=res",
                        this.sdmsSearchHost, this.sdmsSearchPort, this.sdmsSearchTime, this.sdmsSearchRiddle, encKey);
                String res = httpGet(url);
                if (res != null) {
                    String json = extractJsonp(res);
                    if (json != null) {
                        JSONArray items = new JSONObject(json).optJSONArray("list");
                        if (items != null) {
                            for (int i = 0; i < items.length(); i++) {
                                JSONObject item = items.getJSONObject(i);
                                String code = item.optString("code", item.optString("telecomcode", ""));
                                String name = item.optString("name", "");
                                if (code.isEmpty() || name.isEmpty()) continue;
                                boolean dup = false;
                                for (int j = 0; j < list.length(); j++) {
                                    if (name.equals(list.getJSONObject(j).optString("vod_name", ""))) {
                                        dup = true;
                                        break;
                                    }
                                }
                                if (dup) continue;
                                String prefix = getPrefix(code);
                                if ("1".equals(item.optString("seriesflag", "0"))) prefix = prefix + " 连续剧";
                                JSONObject vod = new JSONObject();
                                vod.put("vod_id", code);
                                vod.put("vod_name", name);
                                vod.put("vod_pic", fixImageUrl(item.optString("fileurl", item.optString("poster", ""))));
                                vod.put("vod_remarks", prefix);
                                list.put(vod);
                            }
                        }
                    }
                }
            } catch (Exception ignored) {}

            // 演员索引搜索
            if (!this.actorIndex.isEmpty()) {
                for (Map.Entry<String, Set<String>> entry : this.actorIndex.entrySet()) {
                    if (!entry.getKey().contains(lowerKey)) continue;
                    for (String item : entry.getValue()) {
                        int tab = item.indexOf('\t');
                        String code = tab > 0 ? item.substring(0, tab) : item;
                        String name = tab > 0 ? item.substring(tab + 1) : code;
                        boolean dup = false;
                        for (int j = 0; j < list.length(); j++) {
                            if (code.equals(list.getJSONObject(j).optString("vod_id", ""))) {
                                dup = true;
                                break;
                            }
                        }
                        if (dup) continue;
                        String pic = "";
                        if (code.startsWith("ztevod|")) {
                            String[] parts = code.substring(7).split("\\|", -1);
                            Object cached = cache.get("spic_vod_" + parts[0]);
                            if (cached instanceof String && !((String) cached).isEmpty()) pic = (String) cached;
                        }
                        if (pic.isEmpty() && !this.indexIconUri.isEmpty()) pic = this.indexIconUri;
                        JSONObject vod = new JSONObject();
                        vod.put("vod_id", code);
                        vod.put("vod_name", name);
                        vod.put("vod_pic", pic);
                        vod.put("vod_remarks", "演员:" + entry.getKey());
                        list.put(vod);
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

    // ═══════════════════════════════════════════════════════════════
    // playerContent — 播放链接 + 索引更新触发
    // ═══════════════════════════════════════════════════════════════

    @Override
    public String playerContent(String flag, String id, List<String> vipFlags) {
        try {
            // 索引更新触发
            if ("__start_update__".equals(id)) {
                if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                    // 已有索引 → 增量更新
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            buildSearchIndex();
                        }
                    }).start();
                    JSONObject result = new JSONObject();
                    result.put("parse", 0);
                    result.put("url", "");
                    result.put("msg", "索引更新已启动，当前" + this.searchIndex.size() + "部，更新后自动保存");
                    return result.toString();
                } else {
                    // 无索引 → 全量构建
                    this.searchIndexBuilt = false;
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
            String telecomCode = null;

            if (id.startsWith("hk_")) {
                realCode = id.substring(3);
            } else if (id.startsWith("zte|")) {
                String[] parts = id.substring(4).split("\\|", -1);
                realCode = parts.length >= 1 ? parts[0] : "";
                if (parts.length >= 2 && !parts[1].isEmpty()) {
                    telecomCode = parts[1];
                }
            }

            // SDK 内容 → 需要解析器
            if (isSdk(realCode)) {
                JSONObject result = new JSONObject();
                result.put("parse", 1);
                result.put("url", "");
                result.put("msg", "SDK节目: " + getPrefix(realCode));
                return result.toString();
            }

            ensureAlive();
            String playUrl = getPlayUrl(realCode, telecomCode);
            if (playUrl == null) {
                stopHeartbeat();
                this.authed = false;
                if (cookieManager != null) {
                    cookieManager.getCookieStore().removeAll();
                }
                if (login()) {
                    playUrl = getPlayUrl(realCode, telecomCode);
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

    private boolean isSdk(String code) {
        return getPrefix(code).equals("极光");
    }

    private String convertCode(String code) {
        for (Map.Entry<String, String> entry : CODE_TRANSFORMS.entrySet()) {
            if (code.startsWith(entry.getKey())) {
                return code.replace(entry.getKey(), entry.getValue());
            }
        }
        return code;
    }

    private String getPlayUrl(String code, String telecomCode) {
        if (!this.authed && !login()) {
            SpiderDebug.log("ZTESpider getPlayUrl not authed");
            return null;
        }

        try {
            List<String> codes = new ArrayList<>();
            String converted = convertCode(code);
            if (!converted.equals(code)) {
                codes.add(converted);
            }
            codes.add(code);

            for (String c : codes) {
                try {
                    String url = this.base + "/iptvepg/frame205/action/getZXPlayURL.jsp?code=" + URLEncoder.encode(c, "UTF-8");
                    String result = httpGet(url);
                    if (result != null) {
                        String trimmed = result.trim();
                        if (trimmed.startsWith("rtsp://") || trimmed.startsWith("http://")) {
                            return trimmed;
                        }
                        Matcher m = Pattern.compile("(rtsp://[^\\s<>\"\\']+)").matcher(trimmed);
                        if (m.find()) return m.group(1).trim();
                    }
                } catch (Exception ignored) {}
            }

            // MediaService 备选
            if (this.userToken != null && !this.userToken.isEmpty()) {
                try {
                    String contentId = (telecomCode != null && !telecomCode.isEmpty()) ? telecomCode : code;
                    String url = this.base + "/iptvepg/function/MediaService/get_playurl.jsp?ContentID="
                            + URLEncoder.encode(contentId, "UTF-8") + "&ContentType=vod&UserToken="
                            + URLEncoder.encode(this.userToken, "UTF-8");
                    String result = httpGet(url);
                    if (result != null) {
                        Matcher m = Pattern.compile("\"PlayUrl\":\"(rtsp://[^\"]+)\"").matcher(result);
                        if (m.find()) return m.group(1).trim();
                        // JSONTokener fallback (matching original APK)
                        try {
                            Object tok = new org.json.JSONTokener(result).nextValue();
                            if (tok instanceof JSONArray) {
                                JSONArray arr = (JSONArray) tok;
                                for (int k = 0; k < arr.length(); k++) {
                                    JSONObject item = arr.getJSONObject(k);
                                    String pu = item.optString("PlayUrl", item.optString("playUrl", ""));
                                    if (!pu.isEmpty() && (pu.startsWith("rtsp://") || pu.startsWith("http://"))) {
                                        return pu.trim();
                                    }
                                }
                            } else if (tok instanceof JSONObject) {
                                JSONObject item = (JSONObject) tok;
                                String pu = item.optString("PlayUrl", item.optString("playUrl", ""));
                                if (!pu.isEmpty() && (pu.startsWith("rtsp://") || pu.startsWith("http://"))) {
                                    return pu.trim();
                                }
                            }
                        } catch (Exception ignored2) {}
                    }
                } catch (Exception ignored) {}
            }

            // geturlhwNew 备选
            for (String c : codes) {
                try {
                    String url = this.base + "/EPG/jsp/defaulttrans2/en/datajsp/geturlhwNew.jsp?code=" + URLEncoder.encode(c, "UTF-8");
                    String result = httpGet(url);
                    if (result != null) {
                        String trimmed = result.trim();
                        if (trimmed.startsWith("rtsp://") || trimmed.startsWith("http://")) {
                            return trimmed;
                        }
                        Matcher m = Pattern.compile("(rtsp://[^\\s<>\"\\']+)").matcher(trimmed);
                        if (m.find()) return m.group(1).trim();
                    }
                } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}

        SpiderDebug.log("ZTESpider getPlayUrl fail code=" + code);
        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // 搜索索引构建（含文件持久化）
    // ═══════════════════════════════════════════════════════════════

    private void buildSearchIndex() {
        loadSearchIndex();

        try {
            JSONArray rootCats = getRootCategories();
            ExecutorService pool = Executors.newFixedThreadPool(6);
            int latchCount = (rootCats != null ? rootCats.length() : 0) + 2;
            final CountDownLatch latch = new CountDownLatch(latchCount);

            if (rootCats != null) {
                for (int i = 0; i < rootCats.length(); i++) {
                    try {
                        JSONObject cat = rootCats.getJSONObject(i);
                        final String catId = cat.optString("primaryid", cat.optString("id", ""));
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

            for (final String sdkId : new String[]{"1032", "1035"}) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            indexCategoryRecursive(sdkId, 0);
                        } finally {
                            latch.countDown();
                        }
                    }
                });
            }

            latch.await(15, TimeUnit.MINUTES);
            pool.shutdown();

            if (this.authed && this.base != null) {
                indexVodColumns();
            }
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
                    String subId = cat.optString("primaryid", cat.optString("name", ""));
                    if (!subId.isEmpty() && !subId.equals(catId)) {
                        indexCategoryRecursive(subId, depth + 1);
                    }
                } catch (Exception ignored) {}
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

    private void indexVodColumns() {
        if (!this.authed || this.base == null) return;
        try {
            String url = String.format("%s/iptvepg/frame205/action/get_column_new.jsp?columnid=%s&destpage=1&numperpage=99&columnlevel=%d",
                    this.base, URLEncoder.encode("190V", "UTF-8"), 1);
            String res = httpGet(url);
            if (res == null) return;
            JSONArray columns;
            try {
                columns = new JSONObject(res).optJSONArray("cateData");
            } catch (Exception e) {
                return;
            }
            if (columns == null) return;

            ExecutorService pool = Executors.newFixedThreadPool(4);
            final CountDownLatch latch = new CountDownLatch(columns.length());
            for (int i = 0; i < columns.length(); i++) {
                try {
                    JSONObject col = columns.getJSONObject(i);
                    final String colCode = col.optString("columncode", "");
                    if (colCode.isEmpty()) {
                        latch.countDown();
                        continue;
                    }
                    pool.submit(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                indexVodColumn(colCode);
                            } finally {
                                latch.countDown();
                            }
                        }
                    });
                } catch (Exception e) {
                    latch.countDown();
                }
            }
            latch.await(10, TimeUnit.MINUTES);
            pool.shutdown();
        } catch (Exception ignored) {}
    }

    private void indexVodColumn(String colCode) {
        for (int page = 1; page <= 20; page++) {
            try {
                JSONObject vodPage = fetchVodPage(colCode, page, 50);
                if (vodPage == null) return;
                JSONArray items = vodPage.optJSONArray("vodData");
                if (items == null || items.length() == 0) return;
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    String pid = item.optString("programId", "");
                    String tcode = item.optString("telecomcode", "");
                    String name = item.optString("programName", "");
                    if ((!pid.isEmpty() || !tcode.isEmpty()) && !name.isEmpty()) {
                        String poster = item.optString("normalposter", "");
                        this.searchIndex.putIfAbsent(name.toLowerCase(), "ztevod|" + pid + "|" + tcode + "|" + poster);
                        if (!poster.isEmpty()) {
                            this.cache.putIfAbsent("spic_vod_" + pid, fixVodImageUrl(poster));
                        }
                    }
                }
                if (page * 50 >= vodPage.optInt("totalCount", 0)) return;
            } catch (Exception e) {
                return;
            }
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // 索引文件持久化
    // ═══════════════════════════════════════════════════════════════

    private void loadSearchIndex() {
        // 优先加载文件
        if (this.indexFilePath != null) {
            try {
                File file = new File(this.indexFilePath);
                if (file.exists()) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        parseIndexLine(line);
                    }
                    reader.close();
                }
            } catch (Exception ignored) {}
        }
        // 然后加载内嵌资源
        try {
            java.io.InputStream is = getClass().getResourceAsStream("/res/search_index.txt");
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                String line;
                while ((line = reader.readLine()) != null) {
                    parseIndexLine(line);
                }
                reader.close();
            }
        } catch (Exception ignored) {}
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
        if ("__actor__".equals(key)) {
            int tab2 = value.indexOf('\t');
            if (tab2 > 0) {
                String actor = value.substring(0, tab2);
                String codes = value.substring(tab2 + 1);
                if (!actor.isEmpty() && !codes.isEmpty()) {
                    Set<String> set = ConcurrentHashMap.newKeySet();
                    for (String c : codes.split(",")) {
                        if (!c.isEmpty()) set.add(c);
                    }
                    this.actorIndex.put(actor, set);
                }
            }
            return;
        }
        if (!key.isEmpty() && !value.isEmpty()) {
            this.searchIndex.put(key, value);
        }
    }

    private void saveSearchIndex() {
        if (this.indexFilePath == null) return;
        if (this.searchIndex.isEmpty()) return;

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("__timestamp__\t");
            sb.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            sb.append('\n');

            for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                sb.append(entry.getKey());
                sb.append('\t');
                sb.append(entry.getValue());
                sb.append('\n');
            }

            // 保存拼音索引
            for (Map.Entry<String, String> entry : this.pinyinIndex.entrySet()) {
                sb.append("__pinyin__\t");
                sb.append(entry.getKey());
                sb.append('\t');
                sb.append(entry.getValue());
                sb.append('\n');
            }

            // 保存演员索引
            for (Map.Entry<String, Set<String>> entry : this.actorIndex.entrySet()) {
                sb.append("__actor__\t");
                sb.append(entry.getKey());
                sb.append('\t');
                sb.append(String.join(",", entry.getValue()));
                sb.append('\n');
            }

            FileOutputStream fos = new FileOutputStream(this.indexFilePath);
            fos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (Exception ignored) {}
    }

    // ═══════════════════════════════════════════════════════════════
    // 分类树
    // ═══════════════════════════════════════════════════════════════

    private JSONArray getRootCategories() {
        // 优先缓存
        if (this.cache.containsKey("root_cats")) {
            Object obj = this.cache.get("root_cats");
            if (obj instanceof JSONArray) return (JSONArray) obj;
        }
        try {
            JSONArray categories = getCategories("1001");
            if (categories == null) return null;
            JSONArray result = new JSONArray();
            for (int i = 0; i < categories.length(); i++) {
                JSONObject cat = categories.getJSONObject(i);
                String name = cat.optString("name", "");
                String count = cat.optString("programCount", "0");
                if (!name.contains("弃用") && !name.startsWith("老") && !name.startsWith("原") && !"0".equals(count)) {
                    result.put(cat);
                }
            }
            if (result.length() > 0) {
                this.cache.put("root_cats", result);
                return result;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // SDMS 数据获取
    // ═══════════════════════════════════════════════════════════════

    private JSONArray getCategories(String categoryId) {
        String key = "cat_" + categoryId;
        if (this.cache.containsKey(key)) {
            Object obj = this.cache.get(key);
            if (obj instanceof JSONArray) return (JSONArray) obj;
        }
        try {
            String url = sdmsCategoryPath(categoryId) + "?time=" + (System.currentTimeMillis() / 1000);
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
            Object obj = this.cache.get(key);
            if (obj instanceof JSONObject) return (JSONObject) obj;
        }
        try {
            String url = sdmsProgramPath(categoryId, page) + "?time=" + (System.currentTimeMillis() / 1000);
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
            String url = sdmsDetailPath(code) + "?hkMac=" + this.mac.replace(":", "")
                    + "&hkIp=" + this.localIp + "&hkUserId=" + this.userId;
            String res = httpGet(url);
            if (res == null) return null;
            JSONObject jsonp = parseJsonp(res);
            if (jsonp != null) {
                JSONArray series = jsonp.optJSONArray("serieslist");
                if (series != null) {
                    for (int i = 0; i < series.length(); i++) {
                        JSONObject ep = series.getJSONObject(i);
                        ep.put("fileurl", fixImageUrl(ep.optString("fileurl", "")));
                    }
                }
                this.cache.put(key, jsonp);
            }
            return jsonp;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject fetchVodPage(String columnCode, int page, int pageSize) {
        ensureAlive();
        if (!this.authed || this.base == null) return null;
        String key = "vodpage_" + columnCode + "_" + page;
        if (this.cache.containsKey(key)) {
            return (JSONObject) this.cache.get(key);
        }
        try {
            String url = String.format("%s/iptvepg/frame205/action/get_vodprogram_data.jsp?columnid=%s&curpage=%d&numperpage=%d",
                    this.base, URLEncoder.encode(columnCode, "UTF-8"), page, pageSize);
            String res = httpGet(url);
            if (res == null) return null;
            JSONObject result;
            try {
                result = new JSONObject(res);
            } catch (Exception e) {
                result = parseVodPageFallback(res);
            }
            if (result != null) {
                this.cache.put(key, result);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject parseVodPageFallback(String html) {
        try {
            Matcher m1 = Pattern.compile("totalCount:\"(\\d+)\"").matcher(html);
            int total = m1.find() ? Integer.parseInt(m1.group(1)) : 0;
            JSONArray items = new JSONArray();
            Matcher m2 = Pattern.compile("vodData:\\[([\\s\\S]*?)\\]").matcher(html);
            if (m2.find()) {
                Matcher m3 = Pattern.compile("\\{([^}]*)\\}").matcher(m2.group(1));
                while (m3.find()) {
                    JSONObject item = new JSONObject();
                    Matcher m4 = Pattern.compile("(\\w+):\"([^\"]*)\"").matcher(m3.group(1));
                    while (m4.find()) {
                        if (!item.has(m4.group(1))) {
                            item.put(m4.group(1), m4.group(2));
                        }
                    }
                    if (item.has("programId") && item.has("programName")) {
                        items.put(item);
                    }
                }
            }
            JSONObject result = new JSONObject();
            result.put("totalCount", total);
            result.put("vodData", items);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONArray fetchVodColumns(String columnCode, int columnLevel) {
        ensureAlive();
        if (!this.authed || this.base == null) return null;
        String cacheKey = "vodcol_" + columnCode + "_" + columnLevel;
        if (this.cache.containsKey(cacheKey)) {
            Object cached = this.cache.get(cacheKey);
            if (cached instanceof JSONArray) return (JSONArray) cached;
        }
        try {
            String url = String.format("%s/iptvepg/frame205/action/get_column_new.jsp?columnid=%s&destpage=1&numperpage=99&columnlevel=%d",
                    this.base, URLEncoder.encode(columnCode, "UTF-8"), columnLevel);
            String res = httpGet(url);
            if (res == null) return null;
            JSONArray columns = null;
            try {
                columns = new JSONObject(res).optJSONArray("cateData");
            } catch (Exception e) {
                // fallback: regex parse
                Matcher m = Pattern.compile("cateData:\\[([\\s\\S]*?)\\]").matcher(res);
                if (m.find()) {
                    columns = new JSONArray();
                    Matcher m2 = Pattern.compile("\\{([^}]*)\\}").matcher(m.group(1));
                    while (m2.find()) {
                        JSONObject obj = new JSONObject();
                        Matcher m3 = Pattern.compile("(\\w+):\"([^\"]*)\"").matcher(m2.group(1));
                        while (m3.find()) {
                            if (!obj.has(m3.group(1))) {
                                obj.put(m3.group(1), m3.group(2));
                            }
                        }
                        if (obj.has("columncode")) {
                            columns.put(obj);
                        }
                    }
                }
            }
            if (columns != null) {
                this.cache.put(cacheKey, columns);
            }
            return columns;
        } catch (Exception e) {
            return null;
        }
    }

    private void loadIndexIcon() {
        if (!this.indexIconUri.isEmpty()) return;
        try {
            java.io.InputStream is = getClass().getResourceAsStream("/res/ICON.png");
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
                    byte[] data = java.util.Arrays.copyOf(buf, total);
                    String b64 = java.util.Base64.getEncoder().encodeToString(data);
                    this.indexIconUri = "data:image/png;base64," + b64;
                }
            }
        } catch (Exception ignored) {}
    }

    // ═══════════════════════════════════════════════════════════════
    // SDMS 路径构建
    // ═══════════════════════════════════════════════════════════════

    private String sdmsCategoryPath(String id) {
        StringBuilder sb = new StringBuilder(
                String.format("http://%s:%d/staticData/data/categorylist/", this.sdmsHost, this.sdmsPort));
        for (int i = 1; i <= id.length(); i += 3) {
            sb.append(id, 0, i);
            sb.append("/");
        }
        sb.append("C").append(id).append(".js");
        return sb.toString();
    }

    private String sdmsProgramPath(String id, int page) {
        StringBuilder sb = new StringBuilder(
                String.format("http://%s:%d/staticData/data/programlist/", this.sdmsHost, this.sdmsPort));
        for (int i = 1; i <= id.length(); i += 3) {
            sb.append(id, 0, i);
            sb.append("/");
        }
        sb.append("P").append(id).append("_").append(page).append(".js");
        return sb.toString();
    }

    private String sdmsDetailPath(String code) {
        return String.format("http://%s:%d/staticData/data/detail/%s/D%s.js",
                this.sdmsHost, this.sdmsPort, code.substring(code.length() - 1), code);
    }

    // ═══════════════════════════════════════════════════════════════
    // 工具方法
    // ═══════════════════════════════════════════════════════════════

    private JSONObject parseJsonp(String str) {
        if (str == null || str.trim().isEmpty()) return null;
        String s = str.trim();
        if (s.endsWith(";")) s = s.substring(0, s.length() - 1).trim();
        int start = s.indexOf('(');
        int end = s.lastIndexOf(')');
        if (start > 0 && end > start) {
            try {
                return new JSONObject(s.substring(start + 1, end));
            } catch (Exception ignored) {}
        }
        try {
            return new JSONObject(s);
        } catch (Exception ignored) {}
        return null;
    }

    private String extractJsonp(String str) {
        if (str == null || str.trim().isEmpty()) return null;
        String s = str.trim();
        int start = s.indexOf('(');
        int end = s.lastIndexOf(')');
        if (start > 0 && end > start) {
            return s.substring(start + 1, end);
        }
        return s;
    }

    private String fixImageUrl(String url) {
        if (url == null || url.isEmpty()) return "";
        if (url.startsWith("//")) return "http:" + url;
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

    private String getPrefix(String code) {
        if (code.contains("_")) {
            String prefix = code.split("_")[0];
            return PREFIX_NAMES.getOrDefault(prefix, prefix);
        }
        String best = "";
        for (String key : PREFIX_NAMES.keySet()) {
            if (code.startsWith(key) && key.length() > best.length()) {
                best = key;
            }
        }
        if (!best.isEmpty()) return PREFIX_NAMES.get(best);
        return code.length() >= 8 ? code.substring(0, 8) : code;
    }

    private void indexActors(String actorDisplay, String code, String name) {
        if (actorDisplay == null || actorDisplay.isEmpty() || code == null || code.isEmpty()) return;
        String entry = code + "\t" + (name != null ? name : "");
        for (String actor : actorDisplay.split("[|,，/]")) {
            String a = actor.trim();
            if (a.isEmpty() || a.length() > 20) continue;
            Set<String> codes = actorIndex.computeIfAbsent(a, k -> ConcurrentHashMap.newKeySet());
            codes.add(entry);
        }
    }

    private void detectLocalIp() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(this.easIp, Integer.parseInt(this.easPort)), 3000);
            this.localIp = socket.getLocalAddress().getHostAddress();
            socket.close();
        } catch (Exception ignored) {}
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
    // HTTP 请求
    // ═══════════════════════════════════════════════════════════════

    private String httpGet(String urlStr) {
        return httpGet(urlStr, StandardCharsets.UTF_8);
    }

    private String httpGet(String urlStr, java.nio.charset.Charset charset) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("Accept-Language", "zh-CN,en-US;q=0.8");
            conn.setRequestProperty("X-Requested-With", "com.android.smart.terminal.iptv");
            if (conn.getResponseCode() != 200) {
                conn.disconnect();
                return null;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
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
            if (data != null && !data.isEmpty()) {
                byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
                conn.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                conn.getOutputStream().write(bytes);
            }
            if (conn.getResponseCode() != 200) return null;
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
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
    // 图片搜索
    // ═══════════════════════════════════════════════════════════════

    private String getSearchPic(String code) {
        String key = "spic_" + code;
        Object obj = this.cache.get(key);
        if (obj instanceof String) return (String) obj;
        try {
            String res = httpGet(sdmsDetailPath(code) + "?hkMac=" + this.mac.replace(":", "")
                    + "&hkIp=" + this.localIp + "&hkUserId=" + this.userId);
            if (res == null) { this.cache.put(key, ""); return ""; }
            JSONObject jsonp = parseJsonp(res);
            if (jsonp == null) { this.cache.put(key, ""); return ""; }
            JSONArray pictures = jsonp.optJSONArray("picturelist");
            if (pictures != null) {
                for (int i = 0; i < pictures.length(); i++) {
                    JSONObject pic = pictures.getJSONObject(i);
                    if ("2".equals(pic.optString("type"))) {
                        String url = fixImageUrl(pic.optString("fileurl", ""));
                        if (!url.isEmpty()) { this.cache.put(key, url); return url; }
                    }
                }
            }
            this.cache.put(key, "");
        } catch (Exception ignored) {}
        return "";
    }

    private String getVodSearchPic(String code) {
        String key = "spic_vod_" + code;
        Object obj = this.cache.get(key);
        if (obj instanceof String) return (String) obj;
        try {
            JSONObject detail = getDetail(code);
            if (detail != null) {
                JSONArray pictures = detail.optJSONArray("picturelist");
                if (pictures != null) {
                    for (int i = 0; i < pictures.length(); i++) {
                        JSONObject pic = pictures.getJSONObject(i);
                        if ("2".equals(pic.optString("type"))) {
                            String url = fixVodImageUrl(pic.optString("fileurl", ""));
                            if (!url.isEmpty()) { this.cache.put(key, url); return url; }
                        }
                    }
                }
            }
            this.cache.put(key, "");
        } catch (Exception ignored) {}
        return "";
    }

    private String fixVodImageUrl(String url) {
        if (url == null || url.isEmpty()) return "";
        if (url.startsWith("http")) return url;
        if (url.startsWith("//")) return "http:" + url;
        if (this.base == null) return fixImageUrl(url);
        return url.startsWith("/") ? this.base + url : this.base + "/" + url;
    }

    private JSONArray searchOnline(String key) {
        try {
            String encKey = URLEncoder.encode(key, "UTF-8");
            String url = String.format("http://%s:%d/cms/programIptv_searchByNameWithSearchTypeByJsonp.do?time=%s&riddle=%s&vo.pageid=1&vo.pagecount=50&vo.providerid=MAS&vo.name=%s&vo.searchtypeid=&callback=res",
                    this.sdmsSearchHost, this.sdmsSearchPort, this.sdmsSearchTime, this.sdmsSearchRiddle, encKey);
            String res = httpGet(url);
            if (res != null) {
                String json = extractJsonp(res);
                if (json != null) {
                    JSONArray arr = new JSONObject(json).optJSONArray("list");
                    if (arr != null && arr.length() > 0) return arr;
                }
            }
            String gbkKey = URLEncoder.encode(key, "GBK");
            if (!gbkKey.equals(encKey)) {
                String url2 = String.format("http://%s:%d/cms/programIptv_searchByNameWithSearchTypeByJsonp.do?time=%s&riddle=%s&vo.pageid=1&vo.pagecount=50&vo.providerid=MAS&vo.name=%s&vo.searchtypeid=&callback=res",
                        this.sdmsSearchHost, this.sdmsSearchPort, this.sdmsSearchTime, this.sdmsSearchRiddle, gbkKey);
                String res2 = httpGet(url2);
                if (res2 != null) {
                    String json2 = extractJsonp(res2);
                    if (json2 != null) {
                        JSONArray arr2 = new JSONObject(json2).optJSONArray("list");
                        if (arr2 != null) return arr2;
                    }
                }
            }
        } catch (Exception ignored) {}
        return new JSONArray();
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
