package com.github.catvod.spider;

import com.github.catvod.crawler.Spider;
import j$.net.URLEncoder;
import j$.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.jupnp.model.ServiceReference;
import org.mozilla.javascript.ES6Iterator;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ZTESpider extends Spider {
    private static final long AUTH_TTL = 600000;
    private static final Map<String, String> CODE_TRANSFORMS;
    private static final Map<String, String> PREFIX_NAMES;
    private static final String[] VOD_HIDE_CATS;
    private static final String[][] VOD_ROOT_CATS;
    private String base;
    private CookieManager cookieManager;
    private String epgHost;
    private Thread heartbeatThread;
    private String indexFilePath;
    private String userToken;
    private String easIp = "124.132.240.38";
    private String easPort = "8080";
    private String encryptKey = "";
    private String userId = "";
    private String stbId = "";
    private String mac = "";
    private String model = "";
    private String customStr = "$CTC";
    private String sdmsHost = "124.132.253.193";
    private int sdmsPort = 86;
    private String imgHost = "usnm-hk.snctv.cn";
    private int imgPort = 85;
    private String sdmsSearchHost = "124.132.253.193";
    private int sdmsSearchPort = 81;
    private String sdmsSearchTime = "1541756249247";
    private String sdmsSearchRiddle = "5660c2fc967f0026ec138dcc36fff8d5";
    private boolean authed = false;
    private volatile String localIp = "127.0.0.1";
    private long authTime = 0;
    private volatile boolean heartbeatRunning = false;
    private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> searchIndex = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> pinyinIndex = new ConcurrentHashMap<>();
    private volatile boolean searchIndexBuilt = false;
    private String indexTimestamp = "";
    private String indexIconUri = "";

    static {
        HashMap map = new HashMap();
        PREFIX_NAMES = map;
        HashMap map2 = new HashMap();
        CODE_TRANSFORMS = map2;
        VOD_ROOT_CATS = new String[][]{new String[]{"电影", "190V07"}, new String[]{"电视剧", "190V06"}, new String[]{"动画", "190V05"}, new String[]{"娱乐", "190V04"}, new String[]{"纪实", "190V03"}, new String[]{"新闻", "190V08"}, new String[]{"财经", "190V0X"}, new String[]{"军事", "190V0R"}, new String[]{"农业", "190V0W"}, new String[]{"体育", "190V02"}, new String[]{"生活", "190V01"}, new String[]{"音乐", "190V09"}, new String[]{"戏曲", "190V0Y"}, new String[]{"法治", "190V00"}, new String[]{"科教专区", "190V0N"}, new String[]{"爱4K专区", "190V0Q"}, new String[]{"爱4K精彩专题", "190V0D"}, new String[]{"央视4K", "190V0C"}, new String[]{"新闻专区", "190V0U"}, new String[]{"爱看精彩", "190V0Z"}};
        VOD_HIDE_CATS = new String[]{"EPG3.0点播推荐", "EPG3.0爱看精品推荐", "极致版应急EPG", "测试栏目（福建）", "决胜小康", "新闻专区2019"};
        map.put("JIECHENG", "华视网聚");
        map.put("JIECHENGHUASHI", "华视网聚");
        map.put("JIECHENGHUASHIU", "华视网聚");
        map.put("YUESHITONG", "悦视通");
        map.put("MGTV", "芒果TV");
        map.put("MGTV_HKPRO", "芒果TV");
        map.put("MGTV_XY", "芒果TV");
        map.put("MGTV_SERIES", "芒果TV");
        map.put("GUOQY", "爱奇艺");
        map.put("GUOQY_ser", "爱奇艺");
        map.put("GUOQY_pro", "爱奇艺");
        map.put("GUOQY_u_pro", "爱奇艺");
        map.put("GUOQYPROGM", "爱奇艺");
        map.put("BESTV", "百视通");
        map.put("BESTVWIN", "百视通");
        map.put("BESTVLOC", "百视通");
        map.put("BLBLP", "哔哩哔哩");
        map.put("BLBLU", "哔哩哔哩");
        map.put("HUASH", "华数");
        map.put("HUASHUNM", "华数");
        map.put("WLXH", "未来电视");
        map.put("WLXHAcc", "未来电视");
        map.put("WLXHAPROGM", "未来电视");
        map.put("JIZR", "腾讯视频");
        map.put("JIZRpcmzc", "腾讯视频");
        map.put("JIZRsc", "腾讯视频");
        map.put("JIZDL", "腾讯视频");
        map.put("WOKAN", "搜狐视频");
        map.put("WOKANU", "搜狐视频");
        map.put("YANHUA", "岩华");
        map.put("senyucp", "森宇股份");
        map.put("senyuPROGM", "森宇股份");
        map.put("XHUANW", "广州欢网");
        map.put("XHUANWANG", "广州欢网");
        map.put("ZhongL", "中录文化");
        map.put("BAOBAO", "宝宝巴士");
        map.put("PUXIN", "普信文化");
        map.put("LIZHI", "荔枝TV");
        map.put("XINGYUN", "杭州漫视");
        map.put("SHIY", "视园");
        map.put("SHIY_S", "视园");
        map.put("YZZHSER", "悦众智合");
        map.put("YHYKMLT", "优酷");
        map.put("YHYKQTS", "优酷");
        map.put("JZTX", "腾讯视频");
        map.put("JZTQ", "腾讯视频");
        map.put("JLTM", "极光");
        map.put("XHUANWAN", "广州欢网");
        map.put("XINGYUN", "杭州漫视");
        map.put("LIZHI202", "荔枝TV");
        map.put("SHENZHEN", "深圳悦道");
        map.put("YUNWEPROGM", "云味");
        map.put("SHUNYUAN", "顺源");
        map.put("YJYUAN", "艺佳");
        map.put("YJYDJ000", "艺佳电竞");
        map.put("YJY002", "艺佳院线2");
        map.put("YJY004", "艺佳院线4");
        map.put("YJY001", "艺佳院线1");
        map.put("YJY003", "艺佳院线3");
        map.put("YJY009", "艺佳院线9");
        map.put("DUOCAIXI", "多彩戏");
        map.put("TJTV", "天津电视");
        map.put("SHENZHEN", "深圳");
        map.put("dogtv", "DogTV");
        map.put("chengyu", "成语");
        map.put("XSGQ0000", "学生");
        map.put("SDGDYPROGM", "山东广电");
        map.put("SDGD", "山东广电");
        map.put("YUNWEPROGM", "运维");
        map.put("YUNWEI", "运维");
        map.put("2110MAMS", "宣传片");
        map.put("2110MPROGM", "宣传片");
        map.put("21100001", "宣传片");
        map.put("PR", "推荐位");
        map2.put("YHYKMLT", "YHYKQTS");
        map2.put("JZTX", "JZTQ");
        map2.put("GUOQY_ser_", "GUOQY_pro_");
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x02c1: RETURN (r16 I:org.json.JSONObject) A[SYNTHETIC] (LINE:706), block:B:87:? */
    private JSONObject buildCategoryFilters(String str) {
        JSONObject jSONObject;
        String str2;
        JSONArray jSONArray;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (str.startsWith("sdk_")) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONArray jSONArray3 = new JSONArray();
                    if ("sdk_tencent".equals(str)) {
                        jSONArray2.put(new JSONObject().put("n", "全部视频").put("v", "1032007"));
                        jSONArray2.put(new JSONObject().put("n", "电视剧").put("v", "1032002"));
                        jSONArray2.put(new JSONObject().put("n", "电影").put("v", "1032001"));
                        jSONArray2.put(new JSONObject().put("n", "综艺").put("v", "1032004"));
                        jSONArray2.put(new JSONObject().put("n", "动漫").put("v", "1032005"));
                        jSONArray2.put(new JSONObject().put("n", "少儿").put("v", "1032003"));
                        jSONArray2.put(new JSONObject().put("n", "纪实").put("v", "1032006"));
                        jSONArray = jSONArray3;
                        jSONArray.put(new JSONObject().put("key", "sdkcat").put("name", "分类").put(ES6Iterator.VALUE_PROPERTY, jSONArray2));
                        str2 = str;
                    } else {
                        str2 = str;
                        if (!"sdk_youku".equals(str2)) {
                            return null;
                        }
                        jSONArray2.put(new JSONObject().put("n", "全部视频").put("v", "1035006"));
                        jSONArray2.put(new JSONObject().put("n", "电视剧").put("v", "1035002"));
                        jSONArray2.put(new JSONObject().put("n", "电影").put("v", "1035001"));
                        jSONArray2.put(new JSONObject().put("n", "纪实").put("v", "1035004"));
                        jSONArray2.put(new JSONObject().put("n", "动漫").put("v", "1035005"));
                        jSONArray2.put(new JSONObject().put("n", "综艺").put("v", "1035007"));
                        jSONArray2.put(new JSONObject().put("n", "少儿").put("v", "1035003"));
                        jSONArray = jSONArray3;
                        jSONArray.put(new JSONObject().put("key", "sdkcat").put("name", "分类").put(ES6Iterator.VALUE_PROPERTY, jSONArray2));
                    }
                    jSONObject2.put(str2, jSONArray);
                    return jSONObject2;
                }
                int i = 0;
                if (!str.startsWith("ztevod_")) {
                    JSONArray categories = getCategories(str);
                    if (categories != null && categories.length() != 0) {
                        JSONArray jSONArray4 = new JSONArray();
                        jSONArray4.put(new JSONObject().put("n", "全部").put("v", ""));
                        while (i < categories.length()) {
                            JSONObject jSONObject3 = categories.getJSONObject(i);
                            String strOptString = jSONObject3.optString("primaryid", jSONObject3.optString(Name.MARK, ""));
                            String strOptString2 = jSONObject3.optString("name", "");
                            if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                                jSONArray4.put(new JSONObject().put("n", strOptString2).put("v", strOptString));
                            }
                            i++;
                        }
                        if (jSONArray4.length() <= 1) {
                            return null;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        jSONArray5.put(new JSONObject().put("key", "sub").put("name", "分类").put(ES6Iterator.VALUE_PROPERTY, jSONArray4));
                        jSONObject2.put(str, jSONArray5);
                        return jSONObject2;
                    }
                    return null;
                }
                if (this.authed && this.base != null) {
                    String strSubstring = str.substring(7);
                    JSONArray jSONArrayFetchVodColumns = fetchVodColumns(strSubstring, 2);
                    if (jSONArrayFetchVodColumns == null || jSONArrayFetchVodColumns.length() == 0) {
                        jSONArrayFetchVodColumns = fetchVodColumns(strSubstring, 1);
                    }
                    if (jSONArrayFetchVodColumns != null && jSONArrayFetchVodColumns.length() != 0) {
                        JSONArray jSONArray6 = new JSONArray();
                        jSONArray6.put(new JSONObject().put("n", "全部").put("v", ""));
                        while (i < jSONArrayFetchVodColumns.length()) {
                            JSONObject jSONObject4 = jSONArrayFetchVodColumns.getJSONObject(i);
                            String strOptString3 = jSONObject4.optString("columncode", "");
                            String strOptString4 = jSONObject4.optString("columnname", "");
                            if (!strOptString3.isEmpty() && !strOptString4.isEmpty()) {
                                jSONArray6.put(new JSONObject().put("n", strOptString4).put("v", strOptString3));
                            }
                            i++;
                        }
                        if (jSONArray6.length() <= 1) {
                            return null;
                        }
                        JSONArray jSONArray7 = new JSONArray();
                        jSONArray7.put(new JSONObject().put("key", "ztevodsub").put("name", "分类").put(ES6Iterator.VALUE_PROPERTY, jSONArray6));
                        jSONObject2.put(str, jSONArray7);
                        return jSONObject2;
                    }
                }
                return null;
            } catch (Exception unused) {
                return jSONObject;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private JSONObject buildDetail(String str) {
        try {
            if (str.startsWith("ztevod|")) {
                return buildZteVodDetail(str);
            }
            JSONObject detail = getDetail(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vod_id", str);
            jSONObject.put("vod_name", str);
            jSONObject.put("vod_play_from", "海看IPTV");
            if (detail == null) {
                jSONObject.put("vod_play_url", "播放$hk_".concat(str));
                return jSONObject;
            }
            jSONObject.put("vod_name", detail.optString("name", str));
            jSONObject.put("vod_year", detail.optString("releaseyear", ""));
            jSONObject.put("vod_area", detail.optString("originalcountry", ""));
            jSONObject.put("vod_actor", detail.optString("actordisplay", ""));
            jSONObject.put("vod_director", detail.optString("director", ""));
            jSONObject.put("vod_content", detail.optString("description", ""));
            JSONArray jSONArrayOptJSONArray = detail.optJSONArray("picturelist");
            int i = 0;
            if (jSONArrayOptJSONArray != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= jSONArrayOptJSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    if ("2".equals(jSONObject2.optString("type")) && !jSONObject2.optString("fileurl", "").isEmpty()) {
                        jSONObject.put("vod_pic", fixImageUrl(jSONObject2.optString("fileurl")));
                        break;
                    }
                    i2++;
                }
            }
            JSONArray jSONArrayOptJSONArray2 = detail.optJSONArray("serieslist");
            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                jSONObject.put("vod_play_url", "播放$hk_" + str);
                return jSONObject;
            }
            StringBuilder sb = new StringBuilder();
            while (i < jSONArrayOptJSONArray2.length()) {
                JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i);
                if (i > 0) {
                    sb.append("#");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("第");
                i++;
                sb2.append(i);
                sb2.append("集");
                sb.append(jSONObject3.optString("name", sb2.toString()));
                sb.append("$hk_");
                sb.append(jSONObject3.optString("code", ""));
            }
            jSONObject.put("vod_play_url", sb.toString());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildSearchIndex, reason: merged with bridge method [inline-methods] */
    public void lambda$playerContent$6() {
        loadSearchIndex();
        try {
            try {
                JSONArray rootCategories = getRootCategories();
                ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(6);
                final CountDownLatch countDownLatch = new CountDownLatch((rootCategories != null ? rootCategories.length() : 0) + 2);
                if (rootCategories != null) {
                    for (int i = 0; i < rootCategories.length(); i++) {
                        try {
                            JSONObject jSONObject = rootCategories.getJSONObject(i);
                            final String strOptString = jSONObject.optString("primaryid", jSONObject.optString(Name.MARK, ""));
                            if (strOptString.isEmpty()) {
                                countDownLatch.countDown();
                            } else {
                                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: oe5
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f.lambda$buildSearchIndex$3(strOptString, countDownLatch);
                                    }
                                });
                            }
                        } catch (Exception unused) {
                            countDownLatch.countDown();
                        }
                    }
                }
                String[] strArr = {"1032", "1035"};
                for (int i2 = 0; i2 < 2; i2++) {
                    final String str = strArr[i2];
                    executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: pe5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.lambda$buildSearchIndex$4(str, countDownLatch);
                        }
                    });
                }
                countDownLatch.await(15L, TimeUnit.MINUTES);
                executorServiceNewFixedThreadPool.shutdown();
                if (this.authed && this.base != null) {
                    indexVodColumns();
                }
            } catch (Exception unused2) {
            }
            this.searchIndexBuilt = true;
            saveSearchIndex();
        } catch (Throwable th) {
            this.searchIndexBuilt = true;
            saveSearchIndex();
            throw th;
        }
    }

    private JSONObject buildZteVodDetail(String str) {
        try {
            String[] strArrSplit = str.substring(7).split("\\|", -1);
            String str2 = strArrSplit.length >= 1 ? strArrSplit[0] : "";
            String str3 = strArrSplit.length >= 2 ? strArrSplit[1] : "";
            if (str3.isEmpty()) {
                str3 = str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vod_id", str);
            jSONObject.put("vod_name", str);
            jSONObject.put("vod_play_from", "中兴IPTV");
            JSONObject detail = getDetail(str3);
            if (detail == null && !str2.isEmpty() && !str2.equals(str3)) {
                detail = getDetail(str2);
            }
            if (detail == null) {
                jSONObject.put("vod_play_url", "播放$zte|" + str3 + "|" + str2);
                return jSONObject;
            }
            jSONObject.put("vod_name", detail.optString("name", str));
            jSONObject.put("vod_year", detail.optString("releaseyear", ""));
            jSONObject.put("vod_area", detail.optString("originalcountry", ""));
            jSONObject.put("vod_actor", detail.optString("actordisplay", ""));
            jSONObject.put("vod_director", detail.optString("director", ""));
            jSONObject.put("vod_content", detail.optString("description", ""));
            JSONArray jSONArrayOptJSONArray = detail.optJSONArray("picturelist");
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                while (true) {
                    if (i >= jSONArrayOptJSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    if ("2".equals(jSONObject2.optString("type")) && !jSONObject2.optString("fileurl", "").isEmpty()) {
                        jSONObject.put("vod_pic", fixImageUrl(jSONObject2.optString("fileurl")));
                        break;
                    }
                    i++;
                }
            }
            JSONArray jSONArrayOptJSONArray2 = detail.optJSONArray("serieslist");
            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                jSONObject.put("vod_play_url", "播放$zte|" + str3 + "|" + str2);
                return jSONObject;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (i2 < jSONArrayOptJSONArray2.length()) {
                JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i2);
                if (i2 > 0) {
                    sb.append("#");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("第");
                i2++;
                sb2.append(i2);
                sb2.append("集");
                sb.append(jSONObject3.optString("name", sb2.toString()));
                sb.append("$zte|");
                sb.append(jSONObject3.optString("code", ""));
                sb.append("|");
                sb.append(str2);
            }
            jSONObject.put("vod_play_url", sb.toString());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private String convertCode(String str) {
        for (Map.Entry<String, String> entry : CODE_TRANSFORMS.entrySet()) {
            if (str.startsWith(entry.getKey())) {
                return str.replace(entry.getKey(), entry.getValue());
            }
        }
        return str;
    }

    private String desEncrypt(String str, String str2) {
        while (str2.length() < 8) {
            try {
                str2 = str2 + "0";
            } catch (Exception unused) {
                return "";
            }
        }
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = str2.getBytes(charset);
        byte[] bytes2 = str.getBytes(charset);
        int length = ((bytes2.length / 8) + 1) * 8;
        byte[] bArr = new byte[length];
        System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
        for (int length2 = bytes2.length; length2 < length; length2++) {
            bArr[length2] = (byte) (length - bytes2.length);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(1, secretKeySpec);
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDoFinal) {
            sb.append(String.format("%02X", Byte.valueOf(b)));
        }
        return sb.toString().toUpperCase();
    }

    private void detectLocalIp() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(this.easIp, Integer.parseInt(this.easPort)), 3000);
            this.localIp = socket.getLocalAddress().getHostAddress();
            socket.close();
        } catch (Exception unused) {
        }
    }

    private boolean ensureAlive() {
        if (this.authed && System.currentTimeMillis() - this.authTime < 600000) {
            return true;
        }
        stopHeartbeat();
        this.authed = false;
        this.cookieManager.getCookieStore().removeAll();
        return login();
    }

    private JSONArray fetchVodColumns(String str, int i) {
        JSONArray jSONArrayOptJSONArray;
        if (this.authed && this.base != null) {
            String str2 = "vodcol_" + str + "_" + i;
            if (this.cache.containsKey(str2)) {
                return (JSONArray) this.cache.get(str2);
            }
            try {
                String strHttpGet = httpGet(String.format("%s/iptvepg/frame205/action/get_column_new.jsp?columnid=%s&destpage=1&numperpage=99&columnlevel=%d", this.base, URLEncoder.encode(str, "UTF-8"), Integer.valueOf(i)));
                if (strHttpGet == null) {
                    return null;
                }
                try {
                    jSONArrayOptJSONArray = new JSONObject(strHttpGet).optJSONArray("cateData");
                } catch (Exception unused) {
                    jSONArrayOptJSONArray = null;
                }
                if (jSONArrayOptJSONArray == null) {
                    try {
                        Matcher matcher = Pattern.compile("cateData:\\[([\\s\\S]*?)\\]").matcher(strHttpGet);
                        if (matcher.find()) {
                            JSONArray jSONArray = new JSONArray();
                            try {
                                Matcher matcher2 = Pattern.compile("\\{([^}]*)\\}").matcher(matcher.group(1));
                                while (matcher2.find()) {
                                    JSONObject jSONObject = new JSONObject();
                                    Matcher matcher3 = Pattern.compile("(\\w+):\"([^\"]*)\"").matcher(matcher2.group(1));
                                    while (matcher3.find()) {
                                        if (!jSONObject.has(matcher3.group(1))) {
                                            jSONObject.put(matcher3.group(1), matcher3.group(2));
                                        }
                                    }
                                    if (jSONObject.has("columncode") && jSONObject.has("columnname")) {
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                            jSONArrayOptJSONArray = jSONArray;
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    this.cache.put(str2, jSONArrayOptJSONArray);
                }
                return jSONArrayOptJSONArray;
            } catch (Exception unused4) {
            }
        }
        return null;
    }

    private JSONObject fetchVodPage(String str, int i, int i2) {
        JSONObject jSONObject;
        if (this.authed && this.base != null) {
            String str2 = "vodpage_" + str + "_" + i;
            if (this.cache.containsKey(str2)) {
                return (JSONObject) this.cache.get(str2);
            }
            try {
                String strHttpGet = httpGet(String.format("%s/iptvepg/frame205/action/get_vodprogram_data.jsp?columnid=%s&curpage=%d&numperpage=%d", this.base, URLEncoder.encode(str, "UTF-8"), Integer.valueOf(i), Integer.valueOf(i2)));
                if (strHttpGet == null) {
                    return null;
                }
                try {
                    jSONObject = new JSONObject(strHttpGet);
                } catch (Exception unused) {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    try {
                        Matcher matcher = Pattern.compile("totalCount:\"(\\d+)\"").matcher(strHttpGet);
                        int i3 = matcher.find() ? Integer.parseInt(matcher.group(1)) : 0;
                        Matcher matcher2 = Pattern.compile("vodData:\\[([\\s\\S]*?)\\]").matcher(strHttpGet);
                        JSONArray jSONArray = new JSONArray();
                        if (matcher2.find()) {
                            Matcher matcher3 = Pattern.compile("\\{([^}]*)\\}").matcher(matcher2.group(1));
                            while (matcher3.find()) {
                                JSONObject jSONObject2 = new JSONObject();
                                Matcher matcher4 = Pattern.compile("(\\w+):\"([^\"]*)\"").matcher(matcher3.group(1));
                                while (matcher4.find()) {
                                    if (!jSONObject2.has(matcher4.group(1))) {
                                        jSONObject2.put(matcher4.group(1), matcher4.group(2));
                                    }
                                }
                                if (jSONObject2.has("programId") && jSONObject2.has("programName")) {
                                    jSONArray.put(jSONObject2);
                                }
                            }
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("totalCount", i3);
                            jSONObject3.put("vodData", jSONArray);
                        } catch (Exception unused2) {
                        }
                        jSONObject = jSONObject3;
                    } catch (Exception unused3) {
                    }
                }
                if (jSONObject != null) {
                    this.cache.put(str2, jSONObject);
                }
                return jSONObject;
            } catch (Exception unused4) {
            }
        }
        return null;
    }

    private String fixImageUrl(String str) {
        return (str == null || str.isEmpty()) ? "" : str.startsWith("//") ? "http:".concat(str) : str.startsWith("http://124.132.253.193:85/") ? str.replace("http://124.132.253.193:85/", String.format("http://%s:%d/", this.imgHost, Integer.valueOf(this.imgPort))) : (str.startsWith("/data") || str.startsWith("/pic")) ? String.format("http://%s:%d", this.imgHost, Integer.valueOf(this.imgPort)).concat(str) : !str.startsWith("http") ? String.format("http://%s:%d/", this.imgHost, Integer.valueOf(this.imgPort)).concat(str) : str;
    }

    private String fixVodImageUrl(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.startsWith("http")) {
            return str;
        }
        if (str.startsWith("//")) {
            return "http:".concat(str);
        }
        if (this.base == null) {
            return fixImageUrl(str);
        }
        boolean zStartsWith = str.startsWith(ServiceReference.DELIMITER);
        String str2 = this.base;
        if (zStartsWith) {
            return str2 + str;
        }
        return str2 + ServiceReference.DELIMITER + str;
    }

    private JSONArray getCategories(String str) {
        JSONObject jsonp;
        String str2 = "cat_" + str;
        if (this.cache.containsKey(str2)) {
            return (JSONArray) this.cache.get(str2);
        }
        try {
            String strHttpGet = httpGet(sdmsCategoryPath(str) + "?time=" + (System.currentTimeMillis() / 1000));
            if (strHttpGet == null || (jsonp = parseJsonp(strHttpGet)) == null) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jsonp.optJSONArray("categoryList");
            if (jSONArrayOptJSONArray != null) {
                this.cache.put(str2, jSONArrayOptJSONArray);
            }
            return jSONArrayOptJSONArray;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject getDetail(String str) {
        JSONObject jsonp;
        String str2 = "detail_" + str;
        if (this.cache.containsKey(str2)) {
            return (JSONObject) this.cache.get(str2);
        }
        try {
            String strHttpGet = httpGet(sdmsDetailPath(str) + "?hkMac=" + this.mac.replace(":", "") + "&hkIp=" + this.localIp + "&hkUserId=" + this.userId);
            if (strHttpGet == null || (jsonp = parseJsonp(strHttpGet)) == null) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jsonp.optJSONArray("serieslist");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                    jSONObject.put("fileurl", fixImageUrl(jSONObject.optString("fileurl", "")));
                }
            }
            this.cache.put(str2, jsonp);
            return jsonp;
        } catch (Exception unused) {
            return null;
        }
    }

    private String getPlayUrl(String str, String str2) {
        if (!this.authed && !login()) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String strConvertCode = convertCode(str);
            if (!strConvertCode.equals(str)) {
                arrayList.add(strConvertCode);
            }
            arrayList.add(str);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    String strHttpGet = this.httpGet(this.base + "/iptvepg/frame205/action/getZXPlayURL.jsp?code=" + URLEncoder.encode((String) it.next(), "UTF-8"));
                    if (strHttpGet != null) {
                        String strTrim = strHttpGet.trim();
                        if (!strTrim.startsWith("rtsp://") && !strTrim.startsWith("http://")) {
                            Matcher matcher = Pattern.compile("(rtsp://[^\\s<>\"\\']+)").matcher(strTrim);
                            if (matcher.find()) {
                                return matcher.group(1).trim();
                            }
                            continue;
                        }
                        return strTrim;
                    }
                } catch (Exception unused) {
                }
            }
            String str3 = this.userToken;
            if (str3 != null && !str3.isEmpty()) {
                if (str2 == null || str2.isEmpty()) {
                    str2 = str;
                }
                try {
                    String strHttpGet2 = this.httpGet(this.base + "/iptvepg/function/MediaService/get_playurl.jsp?ContentID=" + URLEncoder.encode(str2, "UTF-8") + "&ContentType=vod&UserToken=" + URLEncoder.encode(this.userToken, "UTF-8"));
                    if (strHttpGet2 != null) {
                        Matcher matcher2 = Pattern.compile("\"PlayUrl\":\"(rtsp://[^\"]+)\"").matcher(strHttpGet2);
                        if (matcher2.find()) {
                            return matcher2.group(1).trim();
                        }
                        Object objNextValue = new JSONTokener(strHttpGet2).nextValue();
                        if (objNextValue instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) objNextValue;
                            if (jSONArray.length() > 0) {
                                String strOptString = jSONArray.getJSONObject(0).optString("PlayUrl", "");
                                if (strOptString.startsWith("rtsp://")) {
                                    return strOptString.trim();
                                }
                            }
                        } else if (objNextValue instanceof JSONObject) {
                            String strOptString2 = ((JSONObject) objNextValue).optString("PlayUrl", "");
                            if (strOptString2.startsWith("rtsp://")) {
                                return strOptString2.trim();
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            String strHttpGet3 = this.httpGet(this.base + "/EPG/jsp/defaulttrans2/en/datajsp/geturlhwNew.jsp?code=" + URLEncoder.encode(str, "UTF-8"));
            if (strHttpGet3 != null) {
                String strTrim2 = strHttpGet3.trim();
                if (!strTrim2.startsWith("rtsp://") && !strTrim2.startsWith("http://")) {
                    Matcher matcher3 = Pattern.compile("(rtsp://[^\\s<>\"\\']+)").matcher(strTrim2);
                    if (matcher3.find()) {
                        return matcher3.group(1).trim();
                    }
                }
                return strTrim2;
            }
        } catch (Exception unused3) {
        }
        return null;
    }

    private String getPrefix(String str) {
        String str2;
        if (str.contains("_")) {
            str2 = str.split("_")[0];
        } else {
            ArrayList arrayList = new ArrayList(PREFIX_NAMES.keySet());
            arrayList.sort(new Comparator() { // from class: te5
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Integer.compare(((String) obj2).length(), ((String) obj).length());
                }
            });
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = "";
                    break;
                }
                String str3 = (String) it.next();
                if (str.startsWith(str3)) {
                    str2 = str3;
                    break;
                }
            }
            if (str2.isEmpty()) {
                if (str.length() >= 8) {
                    str = str.substring(0, 8);
                }
                str2 = str;
            }
        }
        return PREFIX_NAMES.getOrDefault(str2, str2);
    }

    private JSONObject getPrograms(String str, int i) {
        String str2 = "prog_" + str + "_" + i;
        if (this.cache.containsKey(str2)) {
            return (JSONObject) this.cache.get(str2);
        }
        try {
            String strHttpGet = httpGet(sdmsProgramPath(str, i) + "?time=" + (System.currentTimeMillis() / 1000));
            if (strHttpGet == null) {
                return null;
            }
            JSONObject jsonp = parseJsonp(strHttpGet);
            if (jsonp != null) {
                this.cache.put(str2, jsonp);
            }
            return jsonp;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONArray getRootCategories() {
        if (this.cache.containsKey("root_cats")) {
            return (JSONArray) this.cache.get("root_cats");
        }
        try {
            JSONArray categories = getCategories("1001");
            if (categories == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < categories.length(); i++) {
                JSONObject jSONObject = categories.getJSONObject(i);
                String strOptString = jSONObject.optString("name", "");
                String strOptString2 = jSONObject.optString("programCount", "0");
                if (!strOptString.contains("弃用") && !strOptString.startsWith("老") && !strOptString.startsWith("原") && !"0".equals(strOptString2)) {
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray.length() > 0) {
                this.cache.put("root_cats", jSONArray);
            }
            return jSONArray;
        } catch (Exception unused) {
            return null;
        }
    }

    private String getSearchPic(String str) {
        String strHttpGet;
        JSONObject jsonp;
        String str2 = "spic_" + str;
        Object obj = this.cache.get(str2);
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            strHttpGet = httpGet(sdmsDetailPath(str) + "?hkMac=" + this.mac.replace(":", "") + "&hkIp=" + this.localIp + "&hkUserId=" + this.userId);
        } catch (Exception unused) {
        }
        if (strHttpGet == null || (jsonp = parseJsonp(strHttpGet)) == null) {
            return "";
        }
        JSONArray jSONArrayOptJSONArray = jsonp.optJSONArray("picturelist");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                if ("2".equals(jSONObject.optString("type"))) {
                    String strFixImageUrl = fixImageUrl(jSONObject.optString("fileurl", ""));
                    if (!strFixImageUrl.isEmpty()) {
                        this.cache.put(str2, strFixImageUrl);
                        return strFixImageUrl;
                    }
                }
            }
        }
        this.cache.put(str2, "");
        return "";
    }

    private String httpGet(String str, Charset charset) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Accept-Language", "zh-CN,en-US;q=0.8");
            httpURLConnection.setRequestProperty("X-Requested-With", "com.android.smart.terminal.iptv");
            if (httpURLConnection.getResponseCode() != 200) {
                httpURLConnection.disconnect();
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), charset));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private String httpPost(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (str2 != null && !str2.isEmpty()) {
                byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }
            if (httpURLConnection.getResponseCode() != 200) {
                httpURLConnection.disconnect();
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private void indexCategory(String str) {
        JSONArray jSONArrayOptJSONArray;
        for (int i = 1; i <= 50; i++) {
            try {
                JSONObject programs = getPrograms(str, i);
                if (programs != null && (jSONArrayOptJSONArray = programs.optJSONArray("list")) != null && jSONArrayOptJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                        String strOptString = jSONObject.optString("code", jSONObject.optString("telecomcode", ""));
                        String strOptString2 = jSONObject.optString("name", "");
                        if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                            this.searchIndex.putIfAbsent(strOptString2.toLowerCase(), strOptString);
                            String strOptString3 = jSONObject.optString("fileurl", jSONObject.optString("poster", ""));
                            if (!strOptString3.isEmpty()) {
                                this.cache.putIfAbsent("spic_" + strOptString, fixImageUrl(strOptString3));
                            }
                        }
                    }
                    if (i >= programs.optInt("pagecount", 1)) {
                        return;
                    }
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
    }

    private void indexCategoryRecursive(String str, int i) {
        if (i > 10) {
            return;
        }
        indexCategory(str);
        JSONArray categories = getCategories(str);
        if (categories != null) {
            for (int i2 = 0; i2 < categories.length(); i2++) {
                try {
                    JSONObject jSONObject = categories.getJSONObject(i2);
                    String strOptString = jSONObject.optString("primaryid", jSONObject.optString(Name.MARK, ""));
                    if (!strOptString.isEmpty() && !strOptString.equals(str)) {
                        indexCategoryRecursive(strOptString, i + 1);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private void indexVodColumn(String str) {
        JSONArray jSONArrayOptJSONArray;
        for (int i = 1; i <= 20; i++) {
            try {
                JSONObject jSONObjectFetchVodPage = fetchVodPage(str, i, 50);
                if (jSONObjectFetchVodPage != null && (jSONArrayOptJSONArray = jSONObjectFetchVodPage.optJSONArray("vodData")) != null && jSONArrayOptJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        try {
                            JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                            String strOptString = jSONObject.optString("programId", "");
                            String strOptString2 = jSONObject.optString("telecomcode", "");
                            String strOptString3 = jSONObject.optString("programName", "");
                            if ((!strOptString.isEmpty() || !strOptString2.isEmpty()) && !strOptString3.isEmpty()) {
                                this.searchIndex.putIfAbsent(strOptString3.toLowerCase(), "ztevod|" + strOptString + "|" + strOptString2);
                                String strOptString4 = jSONObject.optString("normalposter", "");
                                if (!strOptString4.isEmpty()) {
                                    this.cache.putIfAbsent("spic_vod_" + strOptString, fixVodImageUrl(strOptString4));
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (i * 50 >= jSONObjectFetchVodPage.optInt("totalCount", 0)) {
                        return;
                    }
                }
                return;
            } catch (Exception unused2) {
                return;
            }
        }
    }

    private void indexVodColumns() {
        JSONArray jSONArrayFetchVodColumns = fetchVodColumns("190V", 1);
        if (jSONArrayFetchVodColumns == null) {
            return;
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(4);
        final CountDownLatch countDownLatch = new CountDownLatch(jSONArrayFetchVodColumns.length());
        for (int i = 0; i < jSONArrayFetchVodColumns.length(); i++) {
            try {
                JSONObject jSONObject = jSONArrayFetchVodColumns.getJSONObject(i);
                final String strOptString = jSONObject.optString("columncode", "");
                String strOptString2 = jSONObject.optString("columnname", "");
                if (!strOptString.isEmpty()) {
                    String[] strArr = VOD_HIDE_CATS;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: se5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f.lambda$indexVodColumns$5(strOptString, countDownLatch);
                                }
                            });
                            break;
                        } else {
                            if (strArr[i2].equals(strOptString2)) {
                                countDownLatch.countDown();
                                break;
                            }
                            i2++;
                        }
                    }
                } else {
                    countDownLatch.countDown();
                }
            } catch (Exception unused) {
                countDownLatch.countDown();
            }
        }
        try {
            countDownLatch.await(10L, TimeUnit.MINUTES);
        } catch (Exception unused2) {
        }
        executorServiceNewFixedThreadPool.shutdown();
    }

    private boolean isSdk(String str) {
        return getPrefix(str).equals("极光");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildSearchIndex$3(String str, CountDownLatch countDownLatch) {
        try {
            indexCategoryRecursive(str, 0);
        } catch (Exception unused) {
        } finally {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildSearchIndex$4(String str, CountDownLatch countDownLatch) {
        try {
            indexCategoryRecursive(str, 0);
        } catch (Exception unused) {
        } finally {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$indexVodColumns$5(String str, CountDownLatch countDownLatch) {
        try {
            indexVodColumn(str);
        } catch (Exception unused) {
        } finally {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0() {
        detectLocalIp();
        login();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playerContent$7() {
        this.searchIndexBuilt = false;
        lambda$playerContent$6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startHeartbeat$1() {
        while (this.heartbeatRunning && this.authed) {
            try {
                Thread.sleep(300000L);
                if (!this.heartbeatRunning) {
                    return;
                }
                if (System.currentTimeMillis() - this.authTime >= 600000) {
                    stopHeartbeat();
                    this.authed = false;
                    this.cookieManager.getCookieStore().removeAll();
                    if (!login()) {
                        this.heartbeatRunning = false;
                        return;
                    }
                } else {
                    httpGet(this.base + "/iptvepg/heartbeat.jsp");
                }
            } catch (Exception unused) {
                this.heartbeatRunning = false;
                return;
            }
        }
    }

    private void loadIndexIcon() {
        if (this.indexIconUri.isEmpty()) {
            try {
                InputStream resourceAsStream = getClass().getResourceAsStream("/res/ICON.png");
                if (resourceAsStream != null) {
                    int iAvailable = resourceAsStream.available();
                    byte[] bArr = new byte[iAvailable];
                    int i = 0;
                    while (i < iAvailable) {
                        int i2 = resourceAsStream.read(bArr, i, iAvailable - i);
                        if (i2 <= 0) {
                            break;
                        } else {
                            i += i2;
                        }
                    }
                    resourceAsStream.close();
                    if (i > 0) {
                        this.indexIconUri = "data:image/png;base64," + Base64.getEncoder().encodeToString(Arrays.copyOf(bArr, i));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void loadSearchIndex() {
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream("/res/search_index.txt");
            if (resourceAsStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return;
                    }
                    parseIndexLine(line);
                }
            }
        } catch (Exception unused) {
        }
        if (this.indexFilePath == null) {
            return;
        }
        try {
            File file = new File(this.indexFilePath);
            if (!file.exists()) {
                return;
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            while (true) {
                String line2 = bufferedReader2.readLine();
                if (line2 == null) {
                    bufferedReader2.close();
                    return;
                }
                parseIndexLine(line2);
            }
        } catch (Exception unused2) {
        }
    }

    private synchronized boolean login() {
        try {
            try {
                String strHttpGet = httpGet(String.format("http://%s:%s/iptvepg/platform/getencrypttoken.jsp?UserID=%s&Action=Login&TerminalFlag=1&TerminalOsType=0&STBID=&stbtype=", this.easIp, this.easPort, this.userId));
                if (strHttpGet == null) {
                    return false;
                }
                Matcher matcher = Pattern.compile("GetAuthInfo\\('(.*?)'\\)").matcher(strHttpGet);
                if (!matcher.find()) {
                    return false;
                }
                String strGroup = matcher.group(1);
                Matcher matcher2 = Pattern.compile("<form\\s+action=\"http://([^/]+):\\d+/iptvepg/platform/auth\\.jsp").matcher(strHttpGet);
                if (!matcher2.find()) {
                    return false;
                }
                String strGroup2 = matcher2.group(1);
                this.epgHost = strGroup2;
                this.base = String.format("http://%s:8080", strGroup2);
                String strHttpPost = httpPost(this.base + "/iptvepg/platform/auth.jsp?easip=" + this.easIp + "&ipVersion=4&networkid=1", "UserID=" + URLEncoder.encode(this.userId, "UTF-8") + "&Authenticator=" + URLEncoder.encode(desEncrypt(String.format("%d$%s$%s$%s$%s$%s$%s", Long.valueOf(((long) (Math.random() * 9.0E7d)) + 10000000), strGroup, this.userId, this.stbId, this.localIp, this.mac, this.customStr), this.encryptKey), "UTF-8") + "&StbIP=" + URLEncoder.encode(this.localIp, "UTF-8"));
                if (strHttpPost == null) {
                    return false;
                }
                Matcher matcher3 = Pattern.compile("jsSetConfig\\('UserToken','([^']+)'").matcher(strHttpPost);
                if (matcher3.find()) {
                    this.userToken = matcher3.group(1);
                } else {
                    Matcher matcher4 = Pattern.compile("UserToken=([A-Za-z0-9_\\-.]+)").matcher(strHttpPost);
                    if (!matcher4.find()) {
                        return false;
                    }
                    this.userToken = matcher4.group(1);
                }
                Matcher matcher5 = Pattern.compile("window\\.location\\s*=\\s*'(http[^']+)'").matcher(strHttpPost);
                if (matcher5.find()) {
                    try {
                        httpGet(matcher5.group(1));
                    } catch (Exception unused) {
                    }
                }
                String strHttpPost2 = httpPost(this.base + "/iptvepg/function/funcportalauth.jsp", "UserToken=" + URLEncoder.encode(this.userToken, "UTF-8") + "&UserID=" + URLEncoder.encode(this.userId, "UTF-8") + "&STBID=" + URLEncoder.encode(this.stbId, "UTF-8") + "&stbinfo=&prmid=&easip=" + URLEncoder.encode(this.easIp, "UTF-8") + "&networkid=1&stbtype=" + URLEncoder.encode(this.model, "UTF-8") + "&drmsupplier=");
                if (strHttpPost2 != null && (strHttpPost2.contains("errorHandler") || strHttpPost2.contains("ErrorCode"))) {
                    return false;
                }
                try {
                    httpGet(this.base + "/iptvepg/function/frame.jsp");
                } catch (Exception unused2) {
                }
                try {
                    httpPost(this.base + "/iptvepg/function/frameset_judger.jsp", "picturetype=1%2C3%2C5");
                } catch (Exception unused3) {
                }
                try {
                    httpGet(this.base + "/iptvepg/frame205/channel_start.jsp?tempno=-1");
                } catch (Exception unused4) {
                }
                this.authed = true;
                this.authTime = System.currentTimeMillis();
                startHeartbeat();
                return true;
            } catch (Exception unused5) {
                return false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void parseIndexLine(String str) {
        int iIndexOf = str.indexOf(9);
        if (iIndexOf <= 0) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if ("__timestamp__".equals(strSubstring)) {
            this.indexTimestamp = strSubstring2;
            return;
        }
        if (!"__pinyin__".equals(strSubstring)) {
            if (strSubstring.isEmpty() || strSubstring2.isEmpty()) {
                return;
            }
            this.searchIndex.put(strSubstring, strSubstring2);
            return;
        }
        int iIndexOf2 = strSubstring2.indexOf(9);
        if (iIndexOf2 > 0) {
            String strSubstring3 = strSubstring2.substring(0, iIndexOf2);
            String strSubstring4 = strSubstring2.substring(iIndexOf2 + 1);
            if (strSubstring3.isEmpty() || strSubstring4.isEmpty()) {
                return;
            }
            this.pinyinIndex.put(strSubstring3, strSubstring4);
        }
    }

    private JSONObject parseJsonp(String str) {
        if (str != null && !str.trim().isEmpty()) {
            String strTrim = str.trim();
            if (strTrim.endsWith(";")) {
                strTrim = strTrim.substring(0, strTrim.length() - 1).trim();
            }
            int iIndexOf = strTrim.indexOf(40);
            int iLastIndexOf = strTrim.lastIndexOf(41);
            if (iIndexOf > 0 && iLastIndexOf > iIndexOf) {
                try {
                    return new JSONObject(strTrim.substring(iIndexOf + 1, iLastIndexOf));
                } catch (Exception unused) {
                }
            }
            try {
                return new JSONObject(strTrim);
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    private void saveSearchIndex() {
        if (this.indexFilePath == null || this.searchIndex.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            sb.append("__timestamp__\t");
            sb.append(simpleDateFormat.format(new Date()));
            sb.append('\n');
            for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                sb.append(entry.getKey());
                sb.append('\t');
                sb.append(entry.getValue());
                sb.append('\n');
            }
            FileOutputStream fileOutputStream = new FileOutputStream(this.indexFilePath);
            fileOutputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    private String sdmsCategoryPath(String str) {
        StringBuilder sb = new StringBuilder(String.format("http://%s:%d/staticData/data/categorylist/", this.sdmsHost, Integer.valueOf(this.sdmsPort)));
        for (int i = 1; i <= str.length(); i += 3) {
            sb.append((CharSequence) str, 0, i);
            sb.append(ServiceReference.DELIMITER);
        }
        sb.append("C");
        sb.append(str);
        sb.append(".js");
        return sb.toString();
    }

    private String sdmsDetailPath(String str) {
        return String.format("http://%s:%d/staticData/data/detail/%s/D%s.js", this.sdmsHost, Integer.valueOf(this.sdmsPort), str.substring(str.length() - 1), str);
    }

    private String sdmsProgramPath(String str, int i) {
        StringBuilder sb = new StringBuilder(String.format("http://%s:%d/staticData/data/programlist/", this.sdmsHost, Integer.valueOf(this.sdmsPort)));
        for (int i2 = 1; i2 <= str.length(); i2 += 3) {
            sb.append((CharSequence) str, 0, i2);
            sb.append(ServiceReference.DELIMITER);
        }
        sb.append("P");
        sb.append(str);
        sb.append("_");
        sb.append(i);
        sb.append(".js");
        return sb.toString();
    }

    private JSONArray searchOnline(String str) {
        String strHttpGet;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        try {
            String strHttpGet2 = httpGet(String.format("http://%s:%d%s?time=%s&riddle=%s&vo.pageid=1&vo.pagecount=50&vo.providerid=MAS&vo.name=%s&vo.searchtypeid=&callback=res", this.sdmsSearchHost, Integer.valueOf(this.sdmsSearchPort), "/cms/programIptv_searchByNameWithSearchTypeByJsonp.do", this.sdmsSearchTime, this.sdmsSearchRiddle, URLEncoder.encode(str, "UTF-8")));
            if (strHttpGet2 != null) {
                int iIndexOf = strHttpGet2.indexOf(40);
                int iLastIndexOf = strHttpGet2.lastIndexOf(41);
                if (iIndexOf > 0 && iLastIndexOf > iIndexOf && (jSONArrayOptJSONArray2 = new JSONObject(strHttpGet2.substring(iIndexOf + 1, iLastIndexOf)).optJSONArray("list")) != null && jSONArrayOptJSONArray2.length() > 0) {
                    return jSONArrayOptJSONArray2;
                }
            }
            String strEncode = URLEncoder.encode(str, "GBK");
            if (!strEncode.equals(URLEncoder.encode(str, "UTF-8")) && (strHttpGet = httpGet(String.format("http://%s:%d%s?time=%s&riddle=%s&vo.pageid=1&vo.pagecount=50&vo.providerid=MAS&vo.name=%s&vo.searchtypeid=&callback=res", this.sdmsSearchHost, Integer.valueOf(this.sdmsSearchPort), "/cms/programIptv_searchByNameWithSearchTypeByJsonp.do", this.sdmsSearchTime, this.sdmsSearchRiddle, strEncode))) != null) {
                int iIndexOf2 = strHttpGet.indexOf(40);
                int iLastIndexOf2 = strHttpGet.lastIndexOf(41);
                if (iIndexOf2 > 0 && iLastIndexOf2 > iIndexOf2 && (jSONArrayOptJSONArray = new JSONObject(strHttpGet.substring(iIndexOf2 + 1, iLastIndexOf2)).optJSONArray("list")) != null) {
                    if (jSONArrayOptJSONArray.length() > 0) {
                        return jSONArrayOptJSONArray;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return new JSONArray();
    }

    private void startHeartbeat() {
        if (this.heartbeatRunning) {
            return;
        }
        this.heartbeatRunning = true;
        Thread thread = new Thread(new Runnable() { // from class: ve5
            @Override // java.lang.Runnable
            public final void run() {
                this.f.lambda$startHeartbeat$1();
            }
        }, "ZTE-Heartbeat");
        this.heartbeatThread = thread;
        thread.setDaemon(true);
        this.heartbeatThread.start();
    }

    private void stopHeartbeat() {
        this.heartbeatRunning = false;
        Thread thread = this.heartbeatThread;
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override // com.github.catvod.crawler.Spider
    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        JSONArray jSONArray;
        int i;
        String str3;
        String str4;
        int iOptInt;
        int i2;
        JSONObject programs;
        int iOptInt2;
        String str5;
        String prefix;
        String str6;
        String prefix2;
        String str7;
        int iOptInt3;
        int i3;
        String str8;
        String str9;
        String str10;
        String prefix3;
        String str11;
        String str12;
        JSONArray jSONArray2;
        int i4;
        int i5;
        String str13;
        JSONObject jSONObject;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String strOptString5;
        String strOptString6;
        Object objBuildCategoryFilters;
        String str14;
        String str15;
        String str16;
        JSONObject programs2;
        int i6;
        String prefix4;
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray3 = new JSONArray();
            int i7 = Integer.parseInt(str2);
            String str17 = "fileurl";
            String str18 = "name";
            String str19 = "1";
            String str20 = "0";
            String str21 = "seriesflag";
            String str22 = "vod_name";
            String str23 = "vod_id";
            String str24 = " 连续剧";
            String str25 = "pagecount";
            String str26 = "list";
            JSONArray jSONArrayOptJSONArray = null;
            String str27 = null;
            JSONArray jSONArrayOptJSONArray2 = null;
            JSONArray jSONArray4 = jSONArray3;
            String str28 = "code";
            String str29 = "vod_remarks";
            String str30 = "";
            if (str.startsWith("sdk_")) {
                if (map != null) {
                    str14 = "vod_pic";
                    str27 = map.get("sdkcat");
                } else {
                    str14 = "vod_pic";
                }
                if (str27 == null || str27.isEmpty()) {
                    if ("sdk_tencent".equals(str)) {
                        str27 = "1032007";
                    } else if ("sdk_youku".equals(str)) {
                        str27 = "1035006";
                    }
                }
                String str31 = str27;
                if (str31 == null || str31.isEmpty()) {
                    str15 = str26;
                    str16 = str25;
                    jSONArray = jSONArray4;
                    str4 = str16;
                    i = i7;
                    str3 = str15;
                    iOptInt2 = 1;
                } else {
                    int i8 = 1;
                    while (i8 <= 50 && (programs2 = getPrograms(str31, i8)) != null) {
                        String str32 = str31;
                        JSONArray jSONArrayOptJSONArray3 = programs2.optJSONArray(str26);
                        if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() == 0) {
                            break;
                        }
                        str15 = str26;
                        int i9 = i8;
                        int i10 = 0;
                        while (i10 < jSONArrayOptJSONArray3.length()) {
                            JSONObject jSONObject3 = jSONArrayOptJSONArray3.getJSONObject(i10);
                            JSONArray jSONArray5 = jSONArrayOptJSONArray3;
                            if (str19.equals(jSONObject3.optString("seriesflag", "0"))) {
                                StringBuilder sb = new StringBuilder();
                                i6 = i10;
                                sb.append(getPrefix(jSONObject3.optString("code", "")));
                                sb.append(" 连续剧");
                                prefix4 = sb.toString();
                            } else {
                                i6 = i10;
                                prefix4 = getPrefix(jSONObject3.optString("code", ""));
                            }
                            String str33 = str19;
                            JSONObject jSONObjectPut = new JSONObject().put("vod_id", jSONObject3.optString("code", "")).put("vod_name", jSONObject3.optString("name", ""));
                            String strFixImageUrl = fixImageUrl(jSONObject3.optString(str17, jSONObject3.optString("poster", "")));
                            String str34 = str14;
                            JSONObject jSONObjectPut2 = jSONObjectPut.put(str34, strFixImageUrl);
                            String str35 = str29;
                            JSONObject jSONObjectPut3 = jSONObjectPut2.put(str35, prefix4);
                            JSONArray jSONArray6 = jSONArray4;
                            jSONArray6.put(jSONObjectPut3);
                            jSONArray4 = jSONArray6;
                            str29 = str35;
                            str14 = str34;
                            str19 = str33;
                            i10 = i6 + 1;
                            jSONArrayOptJSONArray3 = jSONArray5;
                        }
                        String str36 = str14;
                        String str37 = str17;
                        String str38 = str19;
                        str16 = str25;
                        jSONArray = jSONArray4;
                        String str39 = str29;
                        if (i9 >= programs2.optInt(str16, 1)) {
                            break;
                        }
                        str17 = str37;
                        str25 = str16;
                        jSONArray4 = jSONArray;
                        str29 = str39;
                        str14 = str36;
                        str26 = str15;
                        str19 = str38;
                        str31 = str32;
                        i8 = i9 + 1;
                    }
                    str15 = str26;
                    str16 = str25;
                    jSONArray = jSONArray4;
                    str4 = str16;
                    i = i7;
                    str3 = str15;
                    iOptInt2 = 1;
                }
            } else {
                String str40 = "fileurl";
                String str41 = "1";
                String str42 = str25;
                jSONArray = jSONArray4;
                String str43 = "poster";
                if (str.startsWith("ztevod_")) {
                    String strSubstring = str.substring(7);
                    String str44 = map != null ? map.get("ztevodsub") : null;
                    if (str44 != null && !str44.isEmpty()) {
                        strSubstring = str44;
                    }
                    i = i7;
                    JSONObject jSONObjectFetchVodPage = fetchVodPage(strSubstring, i, 20);
                    if (jSONObjectFetchVodPage != null) {
                        int iMax = Math.max(1, (jSONObjectFetchVodPage.optInt("totalCount", 0) + 19) / 20);
                        JSONArray jSONArrayOptJSONArray4 = jSONObjectFetchVodPage.optJSONArray("vodData");
                        if (jSONArrayOptJSONArray4 != null) {
                            int i11 = 0;
                            while (i11 < jSONArrayOptJSONArray4.length()) {
                                try {
                                    jSONObject = jSONArrayOptJSONArray4.getJSONObject(i11);
                                    strOptString = jSONObject.optString("programId", str30);
                                    jSONArray2 = jSONArrayOptJSONArray4;
                                } catch (Exception unused) {
                                    str12 = str42;
                                    jSONArray2 = jSONArrayOptJSONArray4;
                                }
                                try {
                                    strOptString2 = jSONObject.optString("telecomcode", str30);
                                    i4 = i11;
                                    try {
                                        strOptString3 = jSONObject.optString("programName", str30);
                                        i5 = iMax;
                                        try {
                                            strOptString4 = jSONObject.optString("programType", str30);
                                            strOptString5 = jSONObject.optString("normalposter", str30);
                                            str12 = str42;
                                            try {
                                                strOptString6 = jSONObject.optString("genre", str30);
                                            } catch (Exception unused2) {
                                            }
                                        } catch (Exception unused3) {
                                            str12 = str42;
                                        }
                                    } catch (Exception unused4) {
                                        str12 = str42;
                                        i5 = iMax;
                                    }
                                } catch (Exception unused5) {
                                    str12 = str42;
                                    i4 = i11;
                                    i5 = iMax;
                                    str13 = str30;
                                    i11 = i4 + 1;
                                    jSONArrayOptJSONArray4 = jSONArray2;
                                    iMax = i5;
                                    str42 = str12;
                                    str30 = str13;
                                }
                                if (strOptString.isEmpty() && strOptString2.isEmpty()) {
                                    str13 = str30;
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    str13 = str30;
                                    try {
                                        sb2.append("ztevod|");
                                        sb2.append(strOptString);
                                        sb2.append("|");
                                        sb2.append(strOptString2);
                                        String string = sb2.toString();
                                        if ("2".equals(strOptString4)) {
                                            if (strOptString6.isEmpty()) {
                                                strOptString6 = "连续剧";
                                            } else {
                                                strOptString6 = strOptString6 + " 连续剧";
                                            }
                                        }
                                        jSONArray.put(new JSONObject().put("vod_id", string).put("vod_name", strOptString3).put("vod_pic", fixVodImageUrl(strOptString5)).put(str29, strOptString6));
                                    } catch (Exception unused6) {
                                    }
                                }
                                i11 = i4 + 1;
                                jSONArrayOptJSONArray4 = jSONArray2;
                                iMax = i5;
                                str42 = str12;
                                str30 = str13;
                            }
                        }
                        str11 = str42;
                        iOptInt2 = iMax;
                    } else {
                        str11 = str42;
                        iOptInt2 = 1;
                    }
                    str4 = str11;
                    str3 = "list";
                } else {
                    String str45 = "";
                    i = i7;
                    String str46 = map != null ? map.get("sub") : null;
                    if (str46 == null || str46.isEmpty()) {
                        String str47 = " 连续剧";
                        str3 = "list";
                        String str48 = "0";
                        String str49 = str43;
                        String str50 = "vod_name";
                        JSONObject programs3 = getPrograms(str, i);
                        if (programs3 != null) {
                            jSONArrayOptJSONArray = programs3.optJSONArray(str3);
                            str4 = str42;
                            iOptInt = programs3.optInt(str4, 1);
                        } else {
                            str4 = str42;
                            iOptInt = 1;
                        }
                        JSONArray jSONArray7 = jSONArrayOptJSONArray;
                        if (jSONArray7 == null || jSONArray7.length() <= 0) {
                            i2 = iOptInt;
                            String str51 = "name";
                            String str52 = "seriesflag";
                            JSONArray categories = getCategories(str);
                            if (categories != null && categories.length() > 0) {
                                int i12 = i2;
                                int i13 = 0;
                                while (i13 < categories.length() && jSONArray.length() == 0) {
                                    JSONObject jSONObject4 = categories.getJSONObject(i13);
                                    JSONArray jSONArray8 = categories;
                                    int i14 = i12;
                                    String strOptString7 = jSONObject4.optString("primaryid", jSONObject4.optString(Name.MARK, str45));
                                    if (!strOptString7.isEmpty() && (programs = getPrograms(strOptString7, i)) != null) {
                                        JSONArray jSONArrayOptJSONArray5 = programs.optJSONArray(str3);
                                        iOptInt2 = programs.optInt(str4, 1);
                                        if (jSONArrayOptJSONArray5 == null || jSONArrayOptJSONArray5.length() <= 0) {
                                            i14 = iOptInt2;
                                        } else {
                                            int i15 = 0;
                                            while (i15 < jSONArrayOptJSONArray5.length()) {
                                                JSONObject jSONObject5 = jSONArrayOptJSONArray5.getJSONObject(i15);
                                                String str53 = str52;
                                                JSONArray jSONArray9 = jSONArrayOptJSONArray5;
                                                int i16 = iOptInt2;
                                                int i17 = i15;
                                                String str54 = str48;
                                                String strOptString8 = jSONObject5.optString(str53, str54);
                                                str48 = str54;
                                                String str55 = str41;
                                                if (str55.equals(strOptString8)) {
                                                    StringBuilder sb3 = new StringBuilder();
                                                    str41 = str55;
                                                    sb3.append(getPrefix(jSONObject5.optString(str28, str45)));
                                                    str5 = str47;
                                                    sb3.append(str5);
                                                    prefix = sb3.toString();
                                                } else {
                                                    str41 = str55;
                                                    str5 = str47;
                                                    prefix = getPrefix(jSONObject5.optString(str28, str45));
                                                }
                                                str47 = str5;
                                                JSONObject jSONObjectPut4 = new JSONObject().put(str23, jSONObject5.optString(str28, str45));
                                                String str56 = str51;
                                                String str57 = str28;
                                                String str58 = str50;
                                                jSONArray.put(jSONObjectPut4.put(str58, jSONObject5.optString(str56, str45)).put("vod_pic", fixImageUrl(jSONObject5.optString(str40, jSONObject5.optString(str49, str45)))).put(str29, prefix));
                                                i15 = i17 + 1;
                                                iOptInt2 = i16;
                                                str50 = str58;
                                                str23 = str23;
                                                str28 = str57;
                                                str51 = str56;
                                                jSONArrayOptJSONArray5 = jSONArray9;
                                                str52 = str53;
                                            }
                                        }
                                    }
                                    i13++;
                                    str50 = str50;
                                    str23 = str23;
                                    str52 = str52;
                                    str28 = str28;
                                    str51 = str51;
                                    i12 = i14;
                                    categories = jSONArray8;
                                }
                                i2 = i12;
                            }
                        } else {
                            i2 = iOptInt;
                            int i18 = 0;
                            while (i18 < jSONArray7.length()) {
                                JSONObject jSONObject6 = jSONArray7.getJSONObject(i18);
                                int i19 = i18;
                                JSONArray jSONArray10 = jSONArray7;
                                String str59 = str48;
                                String strOptString9 = jSONObject6.optString(str21, str59);
                                str48 = str59;
                                String str60 = str41;
                                if (str60.equals(strOptString9)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    str41 = str60;
                                    sb4.append(getPrefix(jSONObject6.optString("code", str45)));
                                    str6 = str47;
                                    sb4.append(str6);
                                    prefix2 = sb4.toString();
                                } else {
                                    str41 = str60;
                                    str6 = str47;
                                    prefix2 = getPrefix(jSONObject6.optString("code", str45));
                                }
                                str47 = str6;
                                String str61 = str21;
                                JSONObject jSONObjectPut5 = new JSONObject().put("vod_id", jSONObject6.optString("code", str45));
                                String strOptString10 = jSONObject6.optString(str18, str45);
                                String str62 = str18;
                                String str63 = str50;
                                JSONObject jSONObjectPut6 = jSONObjectPut5.put(str63, strOptString10);
                                str50 = str63;
                                String str64 = str49;
                                jSONArray.put(jSONObjectPut6.put("vod_pic", fixImageUrl(jSONObject6.optString(str40, jSONObject6.optString(str64, str45)))).put(str29, prefix2));
                                i18 = i19 + 1;
                                jSONArray7 = jSONArray10;
                                str49 = str64;
                                str21 = str61;
                                str18 = str62;
                            }
                        }
                        iOptInt2 = i2;
                    } else {
                        JSONObject programs4 = getPrograms(str46, i);
                        if (programs4 != null) {
                            str3 = "list";
                            jSONArrayOptJSONArray2 = programs4.optJSONArray(str3);
                            str7 = str42;
                            iOptInt3 = programs4.optInt(str7, 1);
                        } else {
                            str7 = str42;
                            str3 = "list";
                            iOptInt3 = 1;
                        }
                        JSONArray jSONArray11 = jSONArrayOptJSONArray2;
                        if (jSONArray11 == null || jSONArray11.length() <= 0) {
                            i3 = iOptInt3;
                            str8 = str7;
                        } else {
                            i3 = iOptInt3;
                            str8 = str7;
                            int i20 = 0;
                            while (i20 < jSONArray11.length()) {
                                JSONObject jSONObject7 = jSONArray11.getJSONObject(i20);
                                JSONArray jSONArray12 = jSONArray11;
                                int i21 = i20;
                                String str65 = str41;
                                if (str65.equals(jSONObject7.optString("seriesflag", str20))) {
                                    StringBuilder sb5 = new StringBuilder();
                                    str41 = str65;
                                    str9 = str45;
                                    str10 = str20;
                                    sb5.append(getPrefix(jSONObject7.optString("code", str9)));
                                    sb5.append(str24);
                                    prefix3 = sb5.toString();
                                } else {
                                    str41 = str65;
                                    str9 = str45;
                                    str10 = str20;
                                    prefix3 = getPrefix(jSONObject7.optString("code", str9));
                                }
                                String str66 = str24;
                                JSONObject jSONObjectPut7 = new JSONObject().put("vod_id", jSONObject7.optString("code", str9)).put(str22, jSONObject7.optString("name", str9));
                                String str67 = str43;
                                String str68 = str22;
                                String strOptString11 = jSONObject7.optString(str67, str9);
                                String str69 = str40;
                                jSONArray.put(jSONObjectPut7.put("vod_pic", fixImageUrl(jSONObject7.optString(str69, strOptString11))).put(str29, prefix3));
                                str40 = str69;
                                str22 = str68;
                                str20 = str10;
                                str24 = str66;
                                str43 = str67;
                                str45 = str9;
                                i20 = i21 + 1;
                                jSONArray11 = jSONArray12;
                            }
                        }
                        iOptInt2 = i3;
                        str4 = str8;
                    }
                }
            }
            jSONObject2.put("page", i);
            jSONObject2.put(str4, iOptInt2);
            jSONObject2.put(str3, jSONArray);
            if (i == 1 && (objBuildCategoryFilters = buildCategoryFilters(str)) != null) {
                jSONObject2.put("filters", objBuildCategoryFilters);
            }
            return jSONObject2.toString();
        } catch (Exception unused7) {
            return "{\"list\":[]}";
        }
    }

    @Override // com.github.catvod.crawler.Spider
    public void destroy() {
        stopHeartbeat();
        this.authed = false;
        this.cache.clear();
        super.destroy();
    }

    @Override // com.github.catvod.crawler.Spider
    public String detailContent(List<String> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                if ("__update_index__".equals(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("vod_id", "__update_index__");
                    jSONObject.put("vod_name", "更新搜索索引");
                    jSONObject.put("vod_pic", this.indexIconUri);
                    jSONObject.put("vod_play_from", "索引管理");
                    jSONObject.put("vod_content", "当前索引: " + this.searchIndex.size() + " 部影片\n索引日期: " + (this.indexTimestamp.isEmpty() ? "未知" : this.indexTimestamp) + "\n\n点击下方\"播放\"按钮开始全量更新索引\n更新完成后自动保存，下次启动无需重新拉取");
                    jSONObject.put("vod_play_url", "开始更新索引$__start_update__");
                    jSONArray.put(jSONObject);
                } else {
                    JSONObject jSONObjectBuildDetail = buildDetail(str);
                    if (jSONObjectBuildDetail != null) {
                        jSONArray.put(jSONObjectBuildDetail);
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", jSONArray);
            return jSONObject2.toString();
        } catch (Exception unused) {
            return "{\"list\":[]}";
        }
    }

    @Override // com.github.catvod.crawler.Spider
    public String homeContent(boolean z) {
        boolean z2;
        boolean z3;
        String strOptString;
        String strOptString2;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray rootCategories = getRootCategories();
            String str = "";
            String str2 = str;
            if (rootCategories != null) {
                for (int i = 0; i < rootCategories.length(); i++) {
                    JSONObject jSONObject2 = rootCategories.getJSONObject(i);
                    String strOptString3 = jSONObject2.optString("primaryid", jSONObject2.optString(Name.MARK, ""));
                    String strOptString4 = jSONObject2.optString("name", "");
                    if (!strOptString3.isEmpty() && !strOptString4.isEmpty()) {
                        if (strOptString4.contains("付费")) {
                            str2 = strOptString4;
                            str = strOptString3;
                        } else {
                            jSONArray.put(new JSONObject().put("type_id", strOptString3).put("type_name", strOptString4));
                        }
                    }
                }
            }
            if (!str.isEmpty()) {
                jSONArray.put(new JSONObject().put("type_id", str).put("type_name", str2));
            }
            jSONArray.put(new JSONObject().put("type_id", "sdk_tencent").put("type_name", "腾讯专区"));
            jSONArray.put(new JSONObject().put("type_id", "sdk_youku").put("type_name", "优酷专区"));
            boolean z4 = true;
            JSONArray jSONArrayFetchVodColumns = (!this.authed || this.base == null) ? null : fetchVodColumns("190V", 1);
            if (jSONArrayFetchVodColumns != null) {
                int i2 = 0;
                while (i2 < jSONArrayFetchVodColumns.length()) {
                    try {
                        JSONObject jSONObject3 = jSONArrayFetchVodColumns.getJSONObject(i2);
                        strOptString = jSONObject3.optString("columncode", "");
                        strOptString2 = jSONObject3.optString("columnname", "");
                    } catch (Exception unused) {
                    }
                    if (strOptString.isEmpty() || strOptString2.isEmpty()) {
                        z3 = z4;
                    } else {
                        String[] strArr = VOD_HIDE_CATS;
                        int length = strArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                z3 = z4;
                                jSONArray.put(new JSONObject().put("type_id", "ztevod_" + strOptString).put("type_name", "VOD" + strOptString2));
                                break;
                            }
                            z3 = z4;
                            try {
                                if (strArr[i3].equals(strOptString2)) {
                                    break;
                                }
                                i3++;
                                z4 = z3;
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    i2++;
                    z4 = z3;
                }
                z2 = z4;
            } else {
                z2 = true;
                for (String[] strArr2 : VOD_ROOT_CATS) {
                    jSONArray.put(new JSONObject().put("type_id", "ztevod_" + strArr2[1]).put("type_name", "VOD" + strArr2[0]));
                }
            }
            jSONObject.put(Name.LABEL, jSONArray);
            jSONObject.put("list", new JSONArray());
            if (!this.searchIndexBuilt) {
                loadSearchIndex();
                loadIndexIcon();
                this.searchIndexBuilt = z2;
            }
            return jSONObject.toString();
        } catch (Exception unused3) {
            return "{\"class\":[],\"list\":[]}";
        }
    }

    @Override // com.github.catvod.crawler.Spider
    public String homeVideoContent() {
        String str;
        JSONArray jSONArrayOptJSONArray;
        String str2 = "vod_name";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObjectPut = new JSONObject().put("vod_id", "__update_index__").put("vod_name", "🔄更新搜索索引").put("vod_pic", this.indexIconUri);
            StringBuilder sb = new StringBuilder();
            sb.append(this.searchIndex.size());
            sb.append("部");
            if (this.indexTimestamp.isEmpty()) {
                str = "";
            } else {
                str = " " + this.indexTimestamp;
            }
            sb.append(str);
            jSONArray.put(jSONObjectPut.put("vod_remarks", sb.toString()));
            JSONObject programs = getPrograms("1001016022", 1);
            if (programs != null && (jSONArrayOptJSONArray = programs.optJSONArray("list")) != null) {
                int iMin = Math.min(jSONArrayOptJSONArray.length(), 12);
                int i = 0;
                while (i < iMin) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    jSONArray.put(new JSONObject().put("vod_id", jSONObject2.optString("code", "")).put(str2, jSONObject2.optString("name", "")).put("vod_pic", fixImageUrl(jSONObject2.optString("fileurl", jSONObject2.optString("poster", "")))).put("vod_remarks", getPrefix(jSONObject2.optString("code", ""))));
                    i++;
                    str2 = str2;
                }
            }
            jSONObject.put("list", jSONArray);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"list\":[]}";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:15:0x004d, B:17:0x0059, B:19:0x0064, B:20:0x006a, B:22:0x0070, B:23:0x0076, B:25:0x007c, B:26:0x0082, B:28:0x0088, B:29:0x008e, B:31:0x0094, B:32:0x009a, B:34:0x00a0, B:35:0x00a6, B:37:0x00ac, B:38:0x00b2, B:40:0x00b8, B:41:0x00be, B:43:0x00c4, B:44:0x00cc, B:46:0x00d2, B:47:0x00d8, B:49:0x00de, B:50:0x00e6, B:52:0x00ee, B:53:0x00f4, B:55:0x00fc, B:56:0x0104, B:58:0x010c, B:59:0x0112, B:61:0x011a, B:62:0x0121, B:64:0x012b, B:65:0x0130, B:67:0x0134, B:68:0x0138, B:70:0x013c, B:71:0x0140, B:73:0x0144, B:74:0x0148, B:76:0x014c), top: B:83:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0121 A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:15:0x004d, B:17:0x0059, B:19:0x0064, B:20:0x006a, B:22:0x0070, B:23:0x0076, B:25:0x007c, B:26:0x0082, B:28:0x0088, B:29:0x008e, B:31:0x0094, B:32:0x009a, B:34:0x00a0, B:35:0x00a6, B:37:0x00ac, B:38:0x00b2, B:40:0x00b8, B:41:0x00be, B:43:0x00c4, B:44:0x00cc, B:46:0x00d2, B:47:0x00d8, B:49:0x00de, B:50:0x00e6, B:52:0x00ee, B:53:0x00f4, B:55:0x00fc, B:56:0x0104, B:58:0x010c, B:59:0x0112, B:61:0x011a, B:62:0x0121, B:64:0x012b, B:65:0x0130, B:67:0x0134, B:68:0x0138, B:70:0x013c, B:71:0x0140, B:73:0x0144, B:74:0x0148, B:76:0x014c), top: B:83:0x004d }] */
    @Override // com.github.catvod.crawler.Spider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void init(android.content.Context r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.ZTESpider.init(android.content.Context, java.lang.String):void");
    }

    @Override // com.github.catvod.crawler.Spider
    public String playerContent(String str, String str2, List<String> list) {
        try {
            try {
                if ("__start_update__".equals(str2)) {
                    if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                        new Thread(new Runnable() { // from class: re5
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f.lambda$playerContent$7();
                            }
                        }).start();
                        return new JSONObject().put("parse", 0).put("url", "").put("msg", "索引更新已启动，当前" + this.searchIndex.size() + "部，更新后自动保存").toString();
                    }
                    new Thread(new Runnable() { // from class: qe5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.lambda$playerContent$6();
                        }
                    }).start();
                    return new JSONObject().put("parse", 0).put("url", "").put("msg", "索引更新已启动，请稍候...返回首页可查看进度").toString();
                }
                String strSubstring = str2.startsWith("hk_") ? str2.substring(3) : str2;
                String str3 = null;
                if (str2.startsWith("zte|")) {
                    String[] strArrSplit = str2.substring(4).split("\\|", -1);
                    strSubstring = strArrSplit.length >= 1 ? strArrSplit[0] : "";
                    if (strArrSplit.length >= 2 && !strArrSplit[1].isEmpty()) {
                        str3 = strArrSplit[1];
                    }
                }
                if (isSdk(strSubstring)) {
                    return new JSONObject().put("parse", 1).put("url", "").put("msg", "SDK节目: " + getPrefix(strSubstring)).toString();
                }
                ensureAlive();
                String playUrl = getPlayUrl(strSubstring, str3);
                if (playUrl == null) {
                    stopHeartbeat();
                    this.authed = false;
                    this.cookieManager.getCookieStore().removeAll();
                    if (login()) {
                        playUrl = getPlayUrl(strSubstring, str3);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parse", 0);
                jSONObject.put("url", playUrl != null ? playUrl : "");
                if (playUrl == null || !playUrl.startsWith("rtsp://")) {
                    jSONObject.put("header", "");
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("X-ZTE-NAT", "true");
                    jSONObject.put("header", jSONObject2);
                }
                if (playUrl == null) {
                    jSONObject.put("msg", "未获取到播放链接");
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return "";
            }
        } catch (Exception unused2) {
            return new JSONObject().put("parse", 0).put("url", "").toString();
        }
    }

    @Override // com.github.catvod.crawler.Spider
    public String searchContent(String str, boolean z) {
        boolean z2;
        int i;
        String str2;
        String str3;
        String str4;
        String searchPic;
        String prefix;
        Iterator<Map.Entry<String, String>> it;
        String searchPic2;
        String prefix2;
        try {
            JSONArray jSONArray = new JSONArray();
            String lowerCase = str.toLowerCase();
            boolean zMatches = lowerCase.matches("^[a-z0-9]+$");
            if (!this.searchIndexBuilt || this.searchIndex.isEmpty()) {
                z2 = zMatches;
                i = 0;
            } else {
                Iterator<Map.Entry<String, String>> it2 = this.searchIndex.entrySet().iterator();
                while (true) {
                    i = 0;
                    z2 = zMatches;
                    if (!it2.hasNext()) {
                        str2 = "\\|";
                        str3 = "VOD";
                        break;
                    }
                    Map.Entry<String, String> next = it2.next();
                    if (next.getKey().contains(lowerCase)) {
                        String value = next.getValue();
                        String key = next.getKey();
                        if (value.startsWith("ztevod|")) {
                            it = it2;
                            str3 = "VOD";
                            String[] strArrSplit = value.substring(7).split("\\|", -1);
                            str2 = "\\|";
                            Object obj = this.cache.get("spic_vod_" + (strArrSplit.length >= 1 ? strArrSplit[0] : ""));
                            searchPic2 = (!(obj instanceof String) || ((String) obj).isEmpty()) ? "" : (String) obj;
                            prefix2 = str3;
                        } else {
                            it = it2;
                            str2 = "\\|";
                            str3 = "VOD";
                            Object obj2 = this.cache.get("spic_" + value);
                            searchPic2 = (!(obj2 instanceof String) || ((String) obj2).isEmpty()) ? getSearchPic(value) : (String) obj2;
                            prefix2 = getPrefix(value);
                        }
                        jSONArray.put(new JSONObject().put("vod_id", value).put("vod_name", key).put("vod_pic", searchPic2).put("vod_remarks", prefix2));
                        if (jSONArray.length() >= 50) {
                            break;
                        }
                    } else {
                        it = it2;
                    }
                    zMatches = z2;
                    it2 = it;
                }
                if (z2 && jSONArray.length() < 50) {
                    for (Map.Entry<String, String> entry : this.pinyinIndex.entrySet()) {
                        if (entry.getKey().contains(lowerCase)) {
                            String value2 = entry.getValue();
                            String str5 = this.searchIndex.get(value2);
                            if (str5 != null && !str5.isEmpty()) {
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    if (jSONArray.getJSONObject(i2).optString("vod_name", "").equals(value2)) {
                                        break;
                                    }
                                }
                                if (str5.startsWith("ztevod|")) {
                                    str4 = lowerCase;
                                    String str6 = str2;
                                    String[] strArrSplit2 = str5.substring(7).split(str6, -1);
                                    str2 = str6;
                                    Object obj3 = this.cache.get("spic_vod_" + (strArrSplit2.length >= 1 ? strArrSplit2[0] : ""));
                                    searchPic = (!(obj3 instanceof String) || ((String) obj3).isEmpty()) ? "" : (String) obj3;
                                    prefix = str3;
                                } else {
                                    str4 = lowerCase;
                                    Object obj4 = this.cache.get("spic_" + str5);
                                    searchPic = (!(obj4 instanceof String) || ((String) obj4).isEmpty()) ? getSearchPic(str5) : (String) obj4;
                                    prefix = getPrefix(str5);
                                }
                                jSONArray.put(new JSONObject().put("vod_id", str5).put("vod_name", value2).put("vod_pic", searchPic).put("vod_remarks", prefix));
                                if (jSONArray.length() >= 50) {
                                    break;
                                }
                            }
                        } else {
                            str4 = lowerCase;
                        }
                        lowerCase = str4;
                    }
                }
            }
            if (z2) {
                JSONArray jSONArraySearchOnline = searchOnline(str);
                for (int i3 = i; i3 < jSONArraySearchOnline.length() && jSONArray.length() < 80; i3++) {
                    try {
                        JSONObject jSONObject = jSONArraySearchOnline.getJSONObject(i3);
                        String strOptString = jSONObject.optString("code", jSONObject.optString("telecomcode", ""));
                        String strOptString2 = jSONObject.optString("name", "");
                        if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                            int i4 = i;
                            while (true) {
                                if (i4 >= jSONArray.length()) {
                                    jSONArray.put(new JSONObject().put("vod_id", strOptString).put("vod_name", strOptString2).put("vod_pic", fixImageUrl(jSONObject.optString("fileurl", jSONObject.optString("poster", "")))).put("vod_remarks", "1".equals(jSONObject.optString("seriesflag", "0")) ? getPrefix(strOptString) + " 连续剧" : getPrefix(strOptString)));
                                } else {
                                    if (jSONArray.getJSONObject(i4).optString("vod_name", "").equals(strOptString2)) {
                                        break;
                                    }
                                    i4++;
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", jSONArray);
            return jSONObject2.toString();
        } catch (Exception unused2) {
            return "{\"list\":[]}";
        }
    }

    private String httpGet(String str) {
        return httpGet(str, StandardCharsets.UTF_8);
    }
}
