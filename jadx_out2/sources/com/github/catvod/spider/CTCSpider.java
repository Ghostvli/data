package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.CTCSpider;
import com.hierynomus.msdtyp.FileTime;
import j$.net.URLEncoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.Charset;
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
import org.jupnp.model.ServiceReference;
import org.mozilla.javascript.ES6Iterator;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class CTCSpider extends Spider {
    private static final long AUTH_TTL = 600000;
    private static final Map<String, String> CODE_TRANSFORMS;
    private static final Map<String, String> HK_SUB_PREFIX_MAP;
    private static final String[] NON_VOD_CODES;
    private static final Map<String, String> PREFIX_NAMES;
    private static final List<String> SDK_PREFIXES;
    private static final String[] SDMS_ROOT_IDS;
    private static final List<String> _PREFIX_ORDER;
    private CookieManager cookieManager;
    private String epgHost;
    private Thread heartbeatThread;
    private String indexFilePath;
    private static final String[] HK_HIDDEN_CATEGORIES = {"海看应用商城", "智慧广电", "旅游视野测试", "奇艺专区", "腾讯专区", "优酷专区", "CNTV4", "地市专区_联通", "海看科教"};
    private static final String[] HK_MERGE_CATEGORIES = {"本地", "视博云电竞", "灯塔", "地市专区_电信3.0", "专享客户", "短视频"};
    private static final String[][] HK_EXPAND_ORDER = {new String[]{"海看专区", "海看专区"}, new String[]{"海看专享", "海看专享"}, new String[]{"CNTV2", "CNTV2"}, new String[]{"高清20分类", "高清20分类"}};
    private static final String[] HK_SUB_SORT_LAST_1020 = {"动画明星", "75周年中老年优秀作品展播", "百视通SP专区", "付费单片", "海看乐玩", "海看爱宠", "海看广场舞", "山东新闻专区", "我们的小康2020", "海看枫龄"};
    private String edsServer = "150.138.19.165:33200";
    private String encryptKey = "";
    private String userId = "";
    private String stbId = "";
    private String mac = "";
    private String stbType = "";
    private String stbVersion = "V83321337.1005";
    private String interfaceSuffix = "CTC";
    private String netUserId = "SDIPTVPPPOE@sdiptv";
    private String sdmsHost = "150.138.11.129";
    private int sdmsStaticPort = 86;
    private int sdmsSearchPort = 81;
    private String shicBase = "http://150.139.139.136:18000/sddx-tv-portal/api/v1";
    private volatile boolean authed = false;
    private volatile String localIp = "127.0.0.1";
    private long authTime = 0;
    private volatile boolean heartbeatRunning = false;
    private final Map<String, Object> cache = createLRU(500);
    private final Map<String, JSONObject> programCache = createLRU(2000);
    private final ConcurrentHashMap<String, String> searchIndex = new ConcurrentHashMap<>();
    private volatile JSONArray preloadedRecList = null;
    private volatile boolean searchIndexBuilt = false;
    private volatile boolean searchIndexBuilding = false;
    private String indexTimestamp = "";

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        HashMap map = new HashMap();
        HK_SUB_PREFIX_MAP = map;
        map.put("1054", "EPG");
        SDMS_ROOT_IDS = new String[]{"1020", "1052", "1043", "1036", "1054", "1067", "1045", "1044", "1048", "1062", "1061", "1073", "1074", "1079", "1056", "1039", "1035", "1041", "1059", "1049", "1050", "1053", "1063", "1066", "1051"};
        NON_VOD_CODES = new String[]{"DCFLine1", "DCFLine2", "DCFLine3", "DCFLine4", "DCFLine5"};
        PREFIX_NAMES = new HashMap();
        CODE_TRANSFORMS = new HashMap();
        ArrayList arrayList = new ArrayList();
        SDK_PREFIXES = arrayList;
        _PREFIX_ORDER = new ArrayList();
        arrayList.add("JLTM");
        String[] strArr = {"JIECHENGHUASHIU", "JIECHENGHUASHI", "JIECHENG", "YUESHITONG", "MGTV_HKPRO", "MGTV_XY", "MGTV_SERIES", "MGTV_HK", "MGTV", "GUOQY_ser_", "GUOQY_ser", "GUOQY_pro", "GUOQY", "BESTVWIN", "BESTVLOC", "BESTV", "BLBLP0", "BLBLP", "BLBLU", "HUASHUNM", "HUASH", "WLXHAcc", "WLXH", "JIZRpcmzc", "JIZDL", "JIZRsc", "JIZR", "WOKANU", "WOKAN", "YANHUA", "senyucp", "XHUANWANGseri", "XHUANWANG", "XHUANW", "ZhongL", "BAOBAO", "PUXIN", "LIZHI", "XINGYUN", "SHIY_S", "SHIY", "YZZHSER", "YHYKMLT", "YHYKMDX", "YHYKQTS", "JZTXs", "JZTX_mzc", "JZTX_", "JZTX000005", "JZTX", "JZTQ", "JLTM", "JHTZff", "JHTZ", "SZLT04", "ser", "2110MAMS", "YUNWEI", "PR"};
        for (int i = 0; i < 59; i++) {
            _PREFIX_ORDER.add(strArr[i]);
        }
        Map<String, String> map2 = PREFIX_NAMES;
        map2.put("JIECHENG", "华视网聚");
        map2.put("JIECHENGHUASHI", "华视网聚");
        map2.put("JIECHENGHUASHIU", "华视网聚");
        map2.put("YUESHITONG", "悦视通");
        map2.put("MGTV", "芒果TV");
        map2.put("MGTV_HKPRO", "芒果TV");
        map2.put("MGTV_XY", "芒果TV");
        map2.put("MGTV_SERIES", "芒果TV");
        map2.put("MGTV_HK", "芒果TV");
        map2.put("GUOQY", "爱奇艺");
        map2.put("GUOQY_ser", "爱奇艺");
        map2.put("GUOQY_pro", "爱奇艺");
        map2.put("GUOQY_ser_", "爱奇艺");
        map2.put("BESTV", "百视通");
        map2.put("BESTVWIN", "百视通");
        map2.put("BESTVLOC", "百视通");
        map2.put("BLBLP0", "哔哩哔哩");
        map2.put("BLBLP", "哔哩哔哩");
        map2.put("BLBLU", "哔哩哔哩");
        map2.put("HUASH", "华数");
        map2.put("HUASHUNM", "华数");
        map2.put("WLXH", "未来电视");
        map2.put("WLXHAcc", "未来电视");
        map2.put("JIZR", "腾讯视频");
        map2.put("JIZRpcmzc", "腾讯视频");
        map2.put("JIZDL", "腾讯视频");
        map2.put("JIZRsc", "腾讯视频");
        map2.put("WOKAN", "搜狐视频");
        map2.put("WOKANU", "搜狐视频");
        map2.put("YANHUA", "岩华");
        map2.put("senyucp", "森宇股份");
        map2.put("XHUANW", "广州欢网");
        map2.put("XHUANWANG", "广州欢网");
        map2.put("XHUANWANGseri", "广州欢网");
        map2.put("XHUANWANGprog", "广州欢网");
        map2.put("ZhongL", "中录文化");
        map2.put("BAOBAO", "宝宝巴士");
        map2.put("PUXIN", "普信文化");
        map2.put("LIZHI", "荔枝TV");
        map2.put("XINGYUN", "杭州漫视");
        map2.put("SHIY", "视园");
        map2.put("SHIY_S", "视园");
        map2.put("YZZHSER", "悦众智合");
        map2.put("YHYKMLT", "优酷");
        map2.put("YHYKMDX", "优酷");
        map2.put("YHYKQTS", "优酷");
        map2.put("JZTX", "极智");
        map2.put("JZTXs", "极智");
        map2.put("JZTX_", "极智");
        map2.put("JZTX_mzc", "极智");
        map2.put("JZTX000005", "极智");
        map2.put("JZTQ", "极光");
        map2.put("JLTM", "极光");
        map2.put("JHTZ", "极光");
        map2.put("JHTZff", "极光");
        map2.put("SZLT04", "数字联通");
        map2.put("ser", "其他");
        map2.put("JOYU", "聚鱼");
        map2.put("2110MAMS", "宣传片");
        map2.put("YUNWEI", "运维");
        map2.put("PR", "推荐位");
        map2.put("BSTSDDX0", "百视通");
        map2.put("SWWLJT01", "视博云");
        map2.put("YJYDJ000", "电竞");
        map2.put("YJY008", "银行");
        map2.put("XSGQ0000", "选手");
        map2.put("NFWLqqmu", "南方");
        map2.put("umai", "合智");
        Map<String, String> map3 = CODE_TRANSFORMS;
        map3.put("YHYKMLT", "YHYKQTS");
        map3.put("JZTX_", "JZTQ_");
        map3.put("GUOQY_ser_", "GUOQY_pro_");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String actorsToString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof JSONArray)) {
            return obj.toString();
        }
        JSONArray jSONArray = (JSONArray) obj;
        StringBuilder sb = new StringBuilder();
        int iMin = Math.min(jSONArray.length(), 8);
        for (int i = 0; i < iMin; i++) {
            try {
                Object obj2 = jSONArray.get(i);
                String strOptString = obj2 instanceof JSONObject ? ((JSONObject) obj2).optString("name", "") : obj2.toString();
                if (!strOptString.isEmpty()) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(strOptString);
                }
            } catch (Exception unused) {
            }
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void addHomeItems(JSONObject jSONObject, JSONArray jSONArray, Set<String> set, int i) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("list");
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length() && i2 < i; i3++) {
            try {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i3);
                String strOptString = jSONObject2.optString("code", jSONObject2.optString("telecomcode", ""));
                if (!set.contains(strOptString)) {
                    set.add(strOptString);
                    String strOptString2 = jSONObject2.optString("name", "");
                    if (!strOptString2.isEmpty()) {
                        jSONArray.put(new JSONObject().put("vod_id", strOptString).put("vod_name", strOptString2).put("vod_pic", fixImageUrl(jSONObject2.optString("fileurl", jSONObject2.optString("poster", "")))).put("vod_remarks", "1".equals(jSONObject2.optString("seriesflag", "0")) ? getPrefix(strOptString) + " 连续剧" : getPrefix(strOptString)));
                        i2++;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject buildCategoryFilters(String str) {
        try {
            JSONArray categories = getCategories(str);
            if (categories != null && categories.length() != 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(new JSONObject().put("n", "全部").put("v", str));
                for (int i = 0; i < categories.length(); i++) {
                    JSONObject jSONObject = categories.getJSONObject(i);
                    String strOptString = jSONObject.optString("primaryid", "");
                    String strOptString2 = jSONObject.optString("name", "");
                    if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                        jSONArray.put(new JSONObject().put("n", strOptString2).put("v", strOptString));
                    }
                }
                if (jSONArray.length() <= 1) {
                    return null;
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(new JSONObject().put("key", "sub").put("name", "分类").put(ES6Iterator.VALUE_PROPERTY, jSONArray));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str, jSONArray2);
                return jSONObject2;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject buildDetail(String str) {
        try {
            String strSubstring = str.startsWith("vsp_") ? str.substring(4) : str;
            if (str.startsWith("hk_")) {
                strSubstring = str.substring(3);
            }
            if (str.startsWith("vsp_")) {
                return buildVspDetail(strSubstring);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vod_id", str);
            jSONObject.put("vod_name", str);
            jSONObject.put("vod_play_from", "电信IPTV");
            JSONObject detail = getDetail(strSubstring);
            if (detail != null) {
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
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
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
                }
            }
            jSONObject.put("vod_play_url", "播放$hk_" + strSubstring);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONArray buildRecList() {
        String str = "";
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObjectPut = new JSONObject().put("vod_id", "__update_index__").put("vod_name", "更新搜索索引").put("vod_pic", "");
            StringBuilder sb = new StringBuilder();
            sb.append(this.searchIndex.size());
            sb.append("部");
            if (!this.indexTimestamp.isEmpty()) {
                str = " " + this.indexTimestamp;
            }
            sb.append(str);
            jSONArray.put(jSONObjectPut.put("vod_remarks", sb.toString()));
        } catch (Exception unused) {
        }
        if (this.preloadedRecList != null) {
            for (int i = 1; i < this.preloadedRecList.length(); i++) {
                try {
                    jSONArray.put(this.preloadedRecList.getJSONObject(i));
                } catch (Exception unused2) {
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            String[] strArr = {"1020005023", "1020009013", "1020002001", "1020008020"};
            for (int i2 = 0; i2 < 4; i2++) {
                try {
                    JSONObject programs = getPrograms(strArr[i2], 1);
                    if (programs != null) {
                        addHomeItems(programs, jSONArray, hashSet, 5);
                    }
                } catch (Exception unused3) {
                }
                if (jSONArray.length() >= 21) {
                    break;
                }
            }
        }
        return jSONArray;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void buildSearchIndex(boolean z) {
        StringBuilder sb;
        if (z) {
            this.searchIndex.clear();
        } else {
            loadSearchIndex();
            if (!this.searchIndex.isEmpty()) {
                this.searchIndexBuilt = true;
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder("CTC buildSearchIndex starting, force=");
        sb2.append(z);
        sb2.append(", rootIds=");
        String[] strArr = SDMS_ROOT_IDS;
        sb2.append(strArr.length);
        SpiderDebug.log(sb2.toString());
        try {
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(4);
            final CountDownLatch countDownLatch = new CountDownLatch(strArr.length);
            for (final String str : strArr) {
                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: un
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.lambda$buildSearchIndex$2(str, countDownLatch);
                    }
                });
            }
            countDownLatch.await(10L, TimeUnit.MINUTES);
            executorServiceNewFixedThreadPool.shutdown();
            this.searchIndexBuilt = true;
            sb = new StringBuilder("CTC buildSearchIndex done, count=");
        } catch (Exception unused) {
            this.searchIndexBuilt = true;
            sb = new StringBuilder("CTC buildSearchIndex done, count=");
        } catch (Throwable th) {
            this.searchIndexBuilt = true;
            SpiderDebug.log("CTC buildSearchIndex done, count=" + this.searchIndex.size());
            saveSearchIndex();
            throw th;
        }
        sb.append(this.searchIndex.size());
        SpiderDebug.log(sb.toString());
        saveSearchIndex();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject buildVspDetail(String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vod_id", "vsp_" + str);
            jSONObject.put("vod_name", str);
            jSONObject.put("vod_play_from", "电信IPTV");
            JSONObject vspVodDetail = getVspVodDetail(str);
            if (vspVodDetail == null) {
                jSONObject.put("vod_play_url", "播放$vsp_" + str);
                return jSONObject;
            }
            JSONObject jSONObjectOptJSONObject = vspVodDetail.optJSONObject("VODDetail");
            if (jSONObjectOptJSONObject == null) {
                jSONObject.put("vod_play_url", "播放$vsp_" + str);
                return jSONObject;
            }
            jSONObject.put("vod_name", jSONObjectOptJSONObject.optString("name", str));
            jSONObject.put("vod_year", jSONObjectOptJSONObject.optString("releaseyear", ""));
            jSONObject.put("vod_area", jSONObjectOptJSONObject.optString("originalcountry", ""));
            jSONObject.put("vod_actor", actorsToString(jSONObjectOptJSONObject.opt("actors")));
            jSONObject.put("vod_director", jSONObjectOptJSONObject.optString("director", ""));
            jSONObject.put("vod_content", jSONObjectOptJSONObject.optString("description", ""));
            String strOptString = jSONObjectOptJSONObject.optString("posterUrl", jSONObjectOptJSONObject.optString("picPath", ""));
            if (!strOptString.isEmpty()) {
                jSONObject.put("vod_pic", fixEpgImageUrl(strOptString));
            }
            String strOptString2 = jSONObjectOptJSONObject.optString("VODType", "0");
            if ("1".equals(strOptString2) || "2".equals(strOptString2)) {
                int i = 0;
                JSONObject vspEpisodeList = getVspEpisodeList(str, 0, 200);
                if (vspEpisodeList != null && (jSONArrayOptJSONArray = vspEpisodeList.optJSONArray("episodes")) != null && jSONArrayOptJSONArray.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (i < jSONArrayOptJSONArray.length()) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("VOD");
                        if (jSONObjectOptJSONObject2 != null) {
                            jSONObject2 = jSONObjectOptJSONObject2;
                        }
                        String strOptString3 = jSONObject2.optString("ID", "");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("第");
                        int i2 = i + 1;
                        sb2.append(i2);
                        sb2.append("集");
                        String strOptString4 = jSONObject2.optString("name", sb2.toString());
                        if (i > 0) {
                            sb.append("#");
                        }
                        sb.append(strOptString4);
                        sb.append("$vsp_");
                        sb.append(strOptString3);
                        i = i2;
                    }
                    jSONObject.put("vod_play_url", sb.toString());
                    return jSONObject;
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("mediaFiles");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                jSONObject.put("vod_play_url", "播放$vsp_" + str);
                return jSONObject;
            }
            String strOptString5 = jSONObjectOptJSONObject.optString("code", "");
            if (!strOptString5.isEmpty() && !strOptString5.matches("^\\d+$")) {
                jSONObject.put("vod_play_url", "播放$hk_".concat(strOptString5));
                return jSONObject;
            }
            jSONObject.put("vod_play_url", "播放$vsp_" + str);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void collectPrograms(String str, int i, int i2, JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject programs = getPrograms(str, i);
        if (programs == null || (jSONArrayOptJSONArray = programs.optJSONArray("list")) == null) {
            return;
        }
        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i3);
                String strOptString = jSONObject.optString("code", jSONObject.optString("telecomcode", ""));
                String strOptString2 = jSONObject.optString("name", "");
                if (!strOptString2.isEmpty()) {
                    jSONArray.put(new JSONObject().put("vod_id", strOptString).put("vod_name", strOptString2).put("vod_pic", fixImageUrl(jSONObject.optString("fileurl", jSONObject.optString("poster", "")))).put("vod_remarks", "1".equals(jSONObject.optString("seriesflag", "0")) ? getPrefix(strOptString) + " 连续剧" : getPrefix(strOptString)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String convertCode(String str) {
        for (Map.Entry<String, String> entry : CODE_TRANSFORMS.entrySet()) {
            if (str.startsWith(entry.getKey())) {
                return str.replace(entry.getKey(), entry.getValue());
            }
        }
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static <K, V> Map<K, V> createLRU(final int i) {
        return Collections.synchronizedMap(new LinkedHashMap<K, V>(i, 0.75f, true) { // from class: com.github.catvod.spider.CTCSpider.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                return size() > i;
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int d(JSONObject jSONObject, JSONObject jSONObject2) {
        String strOptString = jSONObject.optString("name", "");
        String strOptString2 = jSONObject2.optString("name", "");
        boolean z = false;
        boolean z2 = false;
        for (String str : HK_SUB_SORT_LAST_1020) {
            if (strOptString.contains(str)) {
                z = true;
            }
            if (strOptString2.contains(str)) {
                z2 = true;
            }
        }
        if (z != z2) {
            return z ? 1 : -1;
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void detectLocalIp() {
        try {
            String str = this.edsServer.split(":")[0];
            int i = this.edsServer.contains(":") ? Integer.parseInt(this.edsServer.split(":")[1]) : 33200;
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(str, i), 3000);
            this.localIp = socket.getLocalAddress().getHostAddress();
            socket.close();
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean ensureAlive() {
        if (this.authed && System.currentTimeMillis() - this.authTime < 600000) {
            return true;
        }
        stopHeartbeat();
        this.authed = false;
        this.cookieManager.getCookieStore().removeAll();
        return login();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String fixEpgImageUrl(String str) {
        String str2;
        return (str == null || str.isEmpty()) ? "" : (str.startsWith("http") || (str2 = this.epgHost) == null) ? str : String.format("http://%s/EPG/jsp/defaulttrans2/en/%s", str2, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String fixImageUrl(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.startsWith("//")) {
            return "http:".concat(str);
        }
        if (str.startsWith("/data") || str.startsWith("/pic")) {
            return String.format("http://%s:%d", this.sdmsHost, Integer.valueOf(this.sdmsStaticPort)).concat(str);
        }
        boolean zStartsWith = str.startsWith("http");
        String str2 = this.sdmsHost;
        return !zStartsWith ? String.format("http://%s:%d/", str2, Integer.valueOf(this.sdmsStaticPort)).concat(str) : str.replace("tsnm-hk.snctv.cn", str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONArray getCategories(String str) {
        String str2 = "cat_" + str;
        Object obj = this.cache.get(str2);
        if (obj != null) {
            return (JSONArray) obj;
        }
        try {
            String strSdmsCategoryPath = sdmsCategoryPath(str);
            String strHttpGet = httpGet(strSdmsCategoryPath);
            if (strHttpGet == null) {
                SpiderDebug.log("CTC getCategories null response, url=" + strSdmsCategoryPath);
                return null;
            }
            JSONObject jsonp = parseJsonp(strHttpGet);
            if (jsonp == null) {
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject getDetail(String str) {
        JSONObject jsonp;
        String str2 = "detail_" + str;
        Object obj = this.cache.get(str2);
        if (obj != null) {
            return (JSONObject) obj;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getPlayUrlEncrypt(String str, String str2) {
        String str3;
        if (this.authed && (str3 = this.epgHost) != null) {
            try {
                String str4 = String.format("http://%s/EPG/jsp/SDGDEPG/app/player/views/encrypt.jsp", str3);
                StringBuilder sb = new StringBuilder("code=");
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append("&categoryid=");
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(URLEncoder.encode(str2, "UTF-8"));
                String strHttpPost = httpPost(str4, sb.toString());
                if (strHttpPost == null) {
                    return null;
                }
                Matcher matcher = Pattern.compile("(rtsp://[^\\s\"<>\\']+)").matcher(strHttpPost);
                if (matcher.find()) {
                    return matcher.group(1);
                }
                Matcher matcher2 = Pattern.compile("(http://[^\\s\"<>\\']+\\.m3u8[^\\s\"<>\\']*)").matcher(strHttpPost);
                if (matcher2.find()) {
                    return matcher2.group(1);
                }
                Matcher matcher3 = Pattern.compile("playUrl[\"\\s]*[=:][\"\\s]*([^\"<>\\s]+)").matcher(strHttpPost);
                if (matcher3.find()) {
                    return matcher3.group(1);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getPlayUrlHk(String str) {
        if (this.authed && this.epgHost != null) {
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
                        String strHttpGet = httpGet(String.format("http://%s/EPG/jsp/SDGDEPG/datajsp/geturlhwNew.jsp?code=%s", this.epgHost, URLEncoder.encode((String) it.next(), "UTF-8")));
                        if (strHttpGet != null) {
                            String strTrim = strHttpGet.trim();
                            if (!strTrim.isEmpty() && !strTrim.toLowerCase().contains("no data")) {
                                try {
                                    String strOptString = new JSONObject(strTrim).optString("playUrl", "");
                                    if (strOptString.contains("^")) {
                                        strOptString = strOptString.substring(strOptString.lastIndexOf("^") + 1);
                                    }
                                    if (!strOptString.isEmpty() && (strOptString.contains("http") || strOptString.contains("rtsp"))) {
                                        return strOptString;
                                    }
                                } catch (Exception unused) {
                                    if (strTrim.startsWith("rtsp://") || strTrim.startsWith("http")) {
                                        return strTrim;
                                    }
                                }
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getPrefix(String str) {
        String str2 = "";
        if (str == null || str.isEmpty() || str.matches("^\\d+$")) {
            return "";
        }
        Iterator<String> it = _PREFIX_ORDER.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (str.startsWith(next)) {
                str2 = next;
                break;
            }
        }
        if (str2.isEmpty() && str.contains("_")) {
            str2 = str.split("_")[0];
        }
        if (str2.isEmpty()) {
            if (str.length() >= 8) {
                str = str.substring(0, 8);
            }
            str2 = str;
        }
        return PREFIX_NAMES.getOrDefault(str2, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject getPrograms(String str, int i) {
        String str2 = str + "_" + i;
        JSONObject jSONObject = this.programCache.get(str2);
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            String strHttpGet = httpGet(sdmsProgramPath(str, i));
            if (strHttpGet == null) {
                return null;
            }
            JSONObject jsonp = parseJsonp(strHttpGet);
            if (jsonp != null) {
                this.programCache.put(str2, jsonp);
            }
            return jsonp;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getSearchPic(String str) {
        JSONObject detail;
        String str2;
        String str3 = "spic_" + str;
        Object obj = this.cache.get(str3);
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            detail = getDetail(str);
        } catch (Exception unused) {
            this.cache.put(str3, "");
        }
        if (detail == null) {
            this.cache.put(str3, "");
            return "";
        }
        JSONArray jSONArrayOptJSONArray = detail.optJSONArray("picturelist");
        if (jSONArrayOptJSONArray != null) {
            str2 = "";
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                String strFixImageUrl = fixImageUrl(jSONObject.optString("fileurl", ""));
                if (!strFixImageUrl.isEmpty()) {
                    if ("2".equals(jSONObject.optString("type"))) {
                        this.cache.put(str3, strFixImageUrl);
                        return strFixImageUrl;
                    }
                    if (str2.isEmpty()) {
                        str2 = strFixImageUrl;
                    }
                }
            }
        } else {
            str2 = "";
        }
        if (!str2.isEmpty()) {
            this.cache.put(str3, str2);
            return str2;
        }
        String strFixImageUrl2 = fixImageUrl(detail.optString("logo", ""));
        boolean zIsEmpty = strFixImageUrl2.isEmpty();
        Map<String, Object> map = this.cache;
        if (zIsEmpty) {
            map.put(str3, "");
            return "";
        }
        map.put(str3, strFixImageUrl2);
        return strFixImageUrl2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject getVspEpisodeList(String str, int i, int i2) {
        try {
            ensureAlive();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("VODID", str);
            jSONObject.put("offset", String.valueOf(i));
            jSONObject.put("count", String.valueOf(i2));
            return vspPost("/VSP/V3/QueryEpisodeList", jSONObject);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getVspPlayUrl(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        try {
            ensureAlive();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("VODID", str);
            jSONObject.put("mediaID", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("checkType", "0");
            jSONObject.put("checkLock", jSONObject2);
            JSONObject jSONObjectVspPost = vspPost("/VSP/V3/PlayVOD", jSONObject);
            if (jSONObjectVspPost != null && (jSONObjectOptJSONObject = jSONObjectVspPost.optJSONObject("result")) != null && "000000000".equals(jSONObjectOptJSONObject.optString("retCode", ""))) {
                return jSONObjectVspPost.optString("playURL", "");
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject getVspVodDetail(String str) {
        try {
            ensureAlive();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("VODID", str);
            return vspPost("/VSP/V3/QueryVOD", jSONObject);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String httpGet(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("User-Agent", "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0");
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String httpGetFullUrl(String str) {
        String str2;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("User-Agent", "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0");
            int responseCode = httpURLConnection.getResponseCode();
            URL url = httpURLConnection.getURL();
            if (this.epgHost == null) {
                int port = url.getPort();
                StringBuilder sb = new StringBuilder();
                sb.append(url.getHost());
                if (port <= 0 || port == 80) {
                    str2 = "";
                } else {
                    str2 = ":" + port;
                }
                sb.append(str2);
                this.epgHost = sb.toString();
            }
            if (responseCode != 200) {
                httpURLConnection.disconnect();
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    return sb2.toString();
                }
                sb2.append(line);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String httpPost(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("User-Agent", "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0");
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String httpPostJson(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(FileTime.NANO100_TO_MILLI);
            httpURLConnection.setReadTimeout(FileTime.NANO100_TO_MILLI);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", "B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0");
            if (str2 != null) {
                byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isHiddenCategory(String str) {
        for (String str2 : HK_HIDDEN_CATEGORIES) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isMergeCategory(String str) {
        for (String str2 : HK_MERGE_CATEGORIES) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isNonVod(String str) {
        for (String str2 : NON_VOD_CODES) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isPlayable(String str) {
        if (str != null && !str.isEmpty()) {
            if (str.matches("^\\d+$")) {
                return true;
            }
            if (!isSdk(str) && !isNonVod(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isSdk(String str) {
        Iterator<String> it = SDK_PREFIXES.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildSearchIndex$2(String str, CountDownLatch countDownLatch) {
        try {
            indexCategoryRecursive(str, 0);
        } catch (Exception unused) {
        } finally {
            countDownLatch.countDown();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$homeContent$4() {
        buildSearchIndex(false);
        this.searchIndexBuilding = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0() {
        this.searchIndexBuilding = true;
        detectLocalIp();
        login();
        loadSearchIndex();
        this.searchIndexBuilt = true;
        this.searchIndexBuilding = false;
        preloadRecommendations();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playerContent$5() {
        buildSearchIndex(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playerContent$6() {
        buildSearchIndex(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
                }
            } catch (Exception unused) {
                this.heartbeatRunning = false;
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void loadSearchIndex() {
        if (this.indexFilePath == null) {
            return;
        }
        try {
            File file = new File(this.indexFilePath);
            if (file.exists() && file.length() != 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        SpiderDebug.log("CTC loadSearchIndex count=" + this.searchIndex.size());
                        return;
                    }
                    int iIndexOf = line.indexOf(9);
                    if (iIndexOf > 0) {
                        String strSubstring = line.substring(0, iIndexOf);
                        String strSubstring2 = line.substring(iIndexOf + 1);
                        if ("__timestamp__".equals(strSubstring)) {
                            this.indexTimestamp = strSubstring2;
                        } else if (!strSubstring.isEmpty() && !strSubstring2.isEmpty() && !strSubstring.startsWith("__")) {
                            this.searchIndex.put(strSubstring, strSubstring2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            SpiderDebug.log("CTC loadSearchIndex error: " + e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private synchronized boolean login() {
        try {
            SpiderDebug.log("CTC login edsServer=" + this.edsServer + " userId=" + this.userId);
            httpGetFullUrl(String.format("http://%s/EDS/jsp/AuthenticationURL?UserID=%s&Action=Login&FCCSupport=1", this.edsServer, URLEncoder.encode(this.userId, "UTF-8")));
            String str = this.epgHost;
            if (str != null && !str.isEmpty()) {
                String strHttpPost = httpPost(String.format("http://%s/EPG/jsp/authLoginHW%s.jsp", this.epgHost, this.interfaceSuffix), "UserID=" + URLEncoder.encode(this.userId, "UTF-8") + "&VIP=");
                if (strHttpPost == null) {
                    return false;
                }
                Matcher matcher = Pattern.compile("EncryptToken\\s*=\\s*\"([^\"]+)\"").matcher(strHttpPost);
                if (!matcher.find()) {
                    return false;
                }
                String strGroup = matcher.group(1);
                httpPost(String.format("http://%s/EPG/jsp/ValidAuthenticationHW%s.jsp", this.epgHost, this.interfaceSuffix), "UserID=" + URLEncoder.encode(this.userId, "UTF-8") + "&Lang=0&SupportHD=1&NetUserID=" + URLEncoder.encode(this.netUserId, "UTF-8") + "&Authenticator=" + URLEncoder.encode(desEncrypt(String.format("%d$%s$%s$%s$%s$%s$$CTC", Long.valueOf(((long) (Math.random() * 9.0E7d)) + 10000000), strGroup, this.userId, this.stbId, this.localIp, this.mac), this.encryptKey), "UTF-8") + "&STBType=" + URLEncoder.encode(this.stbType, "UTF-8") + "&STBVersion=" + URLEncoder.encode(this.stbVersion, "UTF-8") + "&conntype=dhcp&STBID=" + URLEncoder.encode(this.stbId, "UTF-8") + "&templateName=&areaId=&userToken=" + URLEncoder.encode(strGroup, "UTF-8") + "&userGroupId=&productPackageId=&mac=" + URLEncoder.encode(this.mac, "UTF-8") + "&UserField=&SoftwareVersion=" + URLEncoder.encode(this.stbVersion, "UTF-8") + "&IsSmartStb=undefined&desktopId=undefined&stbmaker=&VIP=");
                this.authed = true;
                this.authTime = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder("CTC login success, epgHost=");
                sb.append(this.epgHost);
                SpiderDebug.log(sb.toString());
                startHeartbeat();
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void preloadRecommendations() {
        String str = "";
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObjectPut = new JSONObject().put("vod_id", "__update_index__").put("vod_name", "更新搜索索引").put("vod_pic", "");
            StringBuilder sb = new StringBuilder();
            sb.append(this.searchIndex.size());
            sb.append("部");
            if (!this.indexTimestamp.isEmpty()) {
                str = " " + this.indexTimestamp;
            }
            sb.append(str);
            jSONArray.put(jSONObjectPut.put("vod_remarks", sb.toString()));
            HashSet hashSet = new HashSet();
            String[] strArr = {"1020005023", "1020009013", "1020002001", "1020008020"};
            for (int i = 0; i < 4; i++) {
                try {
                    JSONObject programs = getPrograms(strArr[i], 1);
                    if (programs != null) {
                        addHomeItems(programs, jSONArray, hashSet, 5);
                    }
                } catch (Exception unused) {
                }
                if (jSONArray.length() >= 21) {
                    break;
                }
            }
            if (jSONArray.length() > 1) {
                this.preloadedRecList = jSONArray;
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String resolveMediaId(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject vspVodDetail = getVspVodDetail(str);
            if (vspVodDetail != null && (jSONObjectOptJSONObject = vspVodDetail.optJSONObject("VODDetail")) != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("mediaFiles")) != null && jSONArrayOptJSONArray.length() > 0) {
                return jSONArrayOptJSONArray.getJSONObject(0).optString("ID", "");
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void saveSearchIndex() {
        if (this.indexFilePath == null || this.searchIndex.isEmpty()) {
            return;
        }
        try {
            String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            File file = new File(this.indexFilePath + ".tmp");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            outputStreamWriter.write("__timestamp__\t" + str + "\n");
            for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                outputStreamWriter.write(entry.getKey());
                outputStreamWriter.write(9);
                outputStreamWriter.write(entry.getValue());
                outputStreamWriter.write(10);
            }
            outputStreamWriter.flush();
            outputStreamWriter.close();
            File file2 = new File(this.indexFilePath);
            if (file2.exists()) {
                file2.delete();
            }
            if (file.renameTo(file2)) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    file.delete();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            SpiderDebug.log("CTC saveSearchIndex error: " + e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String sdmsCategoryPath(String str) {
        StringBuilder sb = new StringBuilder(String.format("http://%s:%d/staticData/js/data/categorylist/", this.sdmsHost, Integer.valueOf(this.sdmsStaticPort)));
        for (int i = 1; i <= str.length(); i += 3) {
            sb.append((CharSequence) str, 0, i);
            sb.append(ServiceReference.DELIMITER);
        }
        sb.append("C");
        sb.append(str);
        sb.append(".js");
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String sdmsDetailPath(String str) {
        return String.format("http://%s:%d/staticData/js/data/detail/%s/D%s.js", this.sdmsHost, Integer.valueOf(this.sdmsStaticPort), str.substring(str.length() - 1), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String sdmsProgramPath(String str, int i) {
        StringBuilder sb = new StringBuilder(String.format("http://%s:%d/staticData/js/data/programlist/", this.sdmsHost, Integer.valueOf(this.sdmsStaticPort)));
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void startHeartbeat() {
        if (this.heartbeatRunning) {
            return;
        }
        this.heartbeatRunning = true;
        Thread thread = new Thread(new Runnable() { // from class: wn
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.lambda$startHeartbeat$1();
            }
        }, "CTC-Heartbeat");
        this.heartbeatThread = thread;
        thread.setDaemon(true);
        this.heartbeatThread.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void stopHeartbeat() {
        this.heartbeatRunning = false;
        Thread thread = this.heartbeatThread;
        if (thread != null) {
            thread.interrupt();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject vspPost(String str, JSONObject jSONObject) {
        if (this.authed && this.epgHost != null) {
            try {
                String strConcat = "http://" + this.epgHost + str;
                if (!strConcat.contains("?")) {
                    strConcat = strConcat.concat("?from=throughMSAAccess");
                }
                String strHttpPostJson = httpPostJson(strConcat, jSONObject.toString());
                if (strHttpPostJson == null) {
                    return null;
                }
                return new JSONObject(strHttpPostJson);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        JSONObject jSONObjectBuildCategoryFilters;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            int i = Integer.parseInt(str2);
            String str3 = map != null ? map.get("sub") : null;
            String str4 = (str3 == null || str3.isEmpty()) ? str : str3;
            boolean z2 = str3 == null || str3.isEmpty() || str3.equals(str);
            collectPrograms(str4, i, 20, jSONArray);
            if (jSONArray.length() != 0 || !z2) {
                JSONObject programs = getPrograms(str4, i);
                int iOptInt = programs != null ? programs.optInt("pagecount", 1) : 1;
                jSONObject.put("page", i);
                jSONObject.put("pagecount", iOptInt);
                jSONObject.put("list", jSONArray);
                if (i == 1 && (jSONObjectBuildCategoryFilters = buildCategoryFilters(str)) != null) {
                    jSONObject.put("filters", jSONObjectBuildCategoryFilters);
                }
                return jSONObject.toString();
            }
            JSONArray categories = getCategories(str4);
            if (categories != null && categories.length() > 0) {
                for (int i2 = 0; i2 < categories.length() && jSONArray.length() < 200; i2++) {
                    try {
                        String strOptString = categories.getJSONObject(i2).optString("primaryid", "");
                        if (!strOptString.isEmpty()) {
                            collectPrograms(strOptString, 1, 20, jSONArray);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            jSONObject.put("page", i);
            jSONObject.put("pagecount", iOptInt);
            jSONObject.put("list", jSONArray);
            if (i == 1) {
                jSONObject.put("filters", jSONObjectBuildCategoryFilters);
            }
            return jSONObject.toString();
        } catch (Exception unused2) {
            return "{\"list\":[]}";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public void destroy() {
        stopHeartbeat();
        this.authed = false;
        this.cache.clear();
        super.destroy();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String detailContent(List<String> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                if ("__update_index__".equals(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("vod_id", "__update_index__");
                    jSONObject.put("vod_name", "更新搜索索引");
                    jSONObject.put("vod_pic", "");
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:162:0x00c1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:163:0x00c1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7  */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.CharSequence, java.lang.String] */
    @Override // com.github.catvod.crawler.Spider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String homeContent(boolean z) {
        JSONObject jSONObject;
        boolean z2;
        JSONArray categories;
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray categories2 = getCategories("1");
            StringBuilder sb = new StringBuilder("CTC homeContent rootCats count=");
            sb.append(categories2 == null ? "null" : Integer.valueOf(categories2.length()));
            SpiderDebug.log(sb.toString());
            if (categories2 != null) {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                for (int i = 0; i < categories2.length(); i++) {
                    JSONObject jSONObject3 = categories2.getJSONObject(i);
                    String strOptString = jSONObject3.optString("primaryid", "");
                    String strOptString2 = jSONObject3.optString("name", strOptString);
                    if (!"0".equals(jSONObject3.optString("programCount", "0")) && !strOptString2.contains("弃用") && !strOptString2.startsWith("老") && !strOptString2.startsWith("原") && !isHiddenCategory(strOptString2)) {
                        String[] strArr = SDMS_ROOT_IDS;
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            if (strOptString.equals(strArr[i2])) {
                                map.put(strOptString, strOptString2);
                                map2.put(strOptString2, strOptString);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                String[][] strArr2 = HK_EXPAND_ORDER;
                int length2 = strArr2.length;
                int i3 = 0;
                ?? r8 = strArr2;
                while (true) {
                    z2 = true;
                    if (i3 >= length2) {
                        break;
                    }
                    ?? r17 = r8[i3];
                    ?? r18 = r17[0];
                    HashMap map3 = map2;
                    ?? r6 = r17[1];
                    for (Map.Entry entry : map3.entrySet()) {
                        ?? r21 = r8;
                        ?? r82 = (String) entry.getKey();
                        int i4 = length2;
                        String str = (String) entry.getValue();
                        if (!hashSet.contains(str) && (r82.contains(r6) || r6.contains(r82))) {
                            hashSet.add(str);
                            JSONArray categories3 = getCategories(str);
                            if (categories3 == null || categories3.length() == 0) {
                                length2 = i4;
                                r8 = r21;
                            } else {
                                ?? r19 = r6;
                                ArrayList<JSONObject> arrayList = new ArrayList();
                                JSONObject jSONObject4 = jSONObject2;
                                int i5 = i3;
                                for (int i6 = 0; i6 < categories3.length(); i6++) {
                                    arrayList.add(categories3.getJSONObject(i6));
                                }
                                if ("1020".equals(str)) {
                                    arrayList.sort(new Comparator() { // from class: sn
                                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                        @Override // java.util.Comparator
                                        public final int compare(Object obj, Object obj2) {
                                            return CTCSpider.d((JSONObject) obj, (JSONObject) obj2);
                                        }
                                    });
                                }
                                String orDefault = HK_SUB_PREFIX_MAP.getOrDefault(str, "");
                                for (JSONObject jSONObject5 : arrayList) {
                                    String strOptString3 = jSONObject5.optString("primaryid", "");
                                    String strOptString4 = jSONObject5.optString("name", "");
                                    if (!strOptString3.isEmpty() && !strOptString4.isEmpty() && !"0".equals(jSONObject5.optString("programCount", "0")) && !isHiddenCategory(strOptString4)) {
                                        if (!orDefault.isEmpty()) {
                                            strOptString4 = orDefault + strOptString4;
                                        }
                                        jSONArray.put(new JSONObject().put("type_id", strOptString3).put("type_name", strOptString4));
                                    }
                                }
                                r6 = r19;
                                length2 = i4;
                                r8 = r21;
                                i3 = i5;
                                jSONObject2 = jSONObject4;
                            }
                        }
                    }
                    i3++;
                    map2 = map3;
                    r8 = r8;
                }
                jSONObject = jSONObject2;
                HashMap map4 = map2;
                String[] strArr3 = HK_MERGE_CATEGORIES;
                int length3 = strArr3.length;
                int i7 = 0;
                ?? r2 = strArr3;
                while (i7 < length3) {
                    ?? r9 = r2[i7];
                    ?? r22 = r2;
                    for (Map.Entry entry2 : map4.entrySet()) {
                        ?? r20 = r22;
                        ?? r23 = (String) entry2.getKey();
                        int i8 = length3;
                        String str2 = (String) entry2.getValue();
                        if (!hashSet.contains(str2) && (r23.contains(r9) || r9.contains(r23))) {
                            hashSet.add(str2);
                            JSONArray categories4 = getCategories(str2);
                            if (categories4 != null && categories4.length() != 0) {
                                int i9 = 0;
                                int i10 = i7;
                                while (i9 < categories4.length()) {
                                    JSONObject jSONObject6 = categories4.getJSONObject(i9);
                                    JSONArray jSONArray2 = categories4;
                                    String strOptString5 = jSONObject6.optString("primaryid", "");
                                    int i11 = i9;
                                    String strOptString6 = jSONObject6.optString("name", "");
                                    if (!strOptString5.isEmpty() && !strOptString6.isEmpty() && !"0".equals(jSONObject6.optString("programCount", "0")) && !isHiddenCategory(strOptString6)) {
                                        jSONArray.put(new JSONObject().put("type_id", strOptString5).put("type_name", strOptString6));
                                    }
                                    i9 = i11 + 1;
                                    categories4 = jSONArray2;
                                }
                                i7 = i10;
                            }
                        }
                        length3 = i8;
                        r22 = r20;
                    }
                    i7++;
                    r2 = r22;
                }
                for (String str3 : SDMS_ROOT_IDS) {
                    if (!hashSet.contains(str3)) {
                        String str4 = (String) map.getOrDefault(str3, "");
                        if (!str4.isEmpty() && !isHiddenCategory(str4) && (categories = getCategories(str3)) != null && categories.length() != 0) {
                            hashSet.add(str3);
                            jSONArray.put(new JSONObject().put("type_id", str3).put("type_name", str4));
                        }
                    }
                }
            } else {
                jSONObject = jSONObject2;
                z2 = true;
            }
            SpiderDebug.log("CTC homeContent classes count=" + jSONArray.length());
            JSONObject jSONObject7 = jSONObject;
            jSONObject7.put(Name.LABEL, jSONArray);
            jSONObject7.put("list", buildRecList());
            if (!this.searchIndexBuilt && !this.searchIndexBuilding) {
                this.searchIndexBuilding = z2;
                new Thread(new Runnable() { // from class: tn
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.lambda$homeContent$4();
                    }
                }).start();
            }
            return jSONObject7.toString();
        } catch (Exception e) {
            SpiderDebug.log("CTC homeContent error: " + e.getMessage());
            e.printStackTrace();
            return "{\"class\":[],\"list\":[]}";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String homeVideoContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("list", buildRecList());
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"list\":[]}";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public void init(Context context, String str) {
        super.init(context, str);
        if (str != null && !str.isEmpty()) {
            try {
                if (str.startsWith("{")) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("edsServer")) {
                        this.edsServer = jSONObject.getString("edsServer");
                    }
                    if (jSONObject.has("encryptKey")) {
                        this.encryptKey = jSONObject.getString("encryptKey");
                    }
                    if (jSONObject.has("key")) {
                        this.encryptKey = jSONObject.getString("key");
                    }
                    if (jSONObject.has("userId")) {
                        this.userId = jSONObject.getString("userId");
                    }
                    if (jSONObject.has("user_id")) {
                        this.userId = jSONObject.getString("user_id");
                    }
                    if (jSONObject.has("stbId")) {
                        this.stbId = jSONObject.getString("stbId");
                    }
                    if (jSONObject.has("stb_id")) {
                        this.stbId = jSONObject.getString("stb_id");
                    }
                    if (jSONObject.has("mac")) {
                        this.mac = jSONObject.getString("mac");
                    }
                    if (jSONObject.has("stbType")) {
                        this.stbType = jSONObject.getString("stbType");
                    }
                    if (jSONObject.has("stb_type")) {
                        this.stbType = jSONObject.getString("stb_type");
                    }
                    if (jSONObject.has("stbVersion")) {
                        this.stbVersion = jSONObject.getString("stbVersion");
                    }
                    if (jSONObject.has("interfaceSuffix")) {
                        this.interfaceSuffix = jSONObject.getString("interfaceSuffix");
                    }
                    if (jSONObject.has("netUserId")) {
                        this.netUserId = jSONObject.getString("netUserId");
                    }
                    if (jSONObject.has("sdmsHost")) {
                        this.sdmsHost = jSONObject.getString("sdmsHost");
                    }
                    if (jSONObject.has("sdmsStaticPort")) {
                        this.sdmsStaticPort = jSONObject.optInt("sdmsStaticPort", this.sdmsStaticPort);
                    }
                    if (jSONObject.has("sdmsSearchPort")) {
                        this.sdmsSearchPort = jSONObject.optInt("sdmsSearchPort", this.sdmsSearchPort);
                    }
                    if (jSONObject.has("shicBase")) {
                        this.shicBase = jSONObject.getString("shicBase");
                    }
                } else if (str.contains("$")) {
                    String[] strArrSplit = str.split("\\$");
                    if (strArrSplit.length >= 1 && !strArrSplit[0].isEmpty()) {
                        this.encryptKey = strArrSplit[0];
                    }
                    if (strArrSplit.length >= 2 && !strArrSplit[1].isEmpty()) {
                        this.userId = strArrSplit[1];
                    }
                    if (strArrSplit.length >= 3 && !strArrSplit[2].isEmpty()) {
                        this.stbId = strArrSplit[2];
                    }
                    if (strArrSplit.length >= 4 && !strArrSplit[3].isEmpty()) {
                        this.mac = strArrSplit[3];
                    }
                    if (strArrSplit.length >= 5 && !strArrSplit[4].isEmpty()) {
                        this.stbType = strArrSplit[4];
                    }
                }
            } catch (Exception unused) {
            }
        }
        try {
            this.indexFilePath = context.getCacheDir() + "/ctc_search_index.txt";
        } catch (Exception unused2) {
        }
        CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        this.cookieManager = cookieManager;
        CookieHandler.setDefault(cookieManager);
        new Thread(new Runnable() { // from class: vn
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.lambda$init$0();
            }
        }).start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String playerContent(String str, String str2, List<String> list) {
        String str3;
        String playUrlEncrypt;
        JSONObject detail;
        JSONArray jSONArrayOptJSONArray;
        JSONObject vspEpisodeList;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject vspVodDetail;
        JSONObject jSONObjectOptJSONObject;
        try {
            try {
                if ("__start_update__".equals(str2)) {
                    if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                        new Thread(new Runnable() { // from class: yn
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f.lambda$playerContent$6();
                            }
                        }).start();
                        return new JSONObject().put("parse", 0).put("url", "").put("msg", "索引更新已启动，当前" + this.searchIndex.size() + "部，更新后自动保存").toString();
                    }
                    new Thread(new Runnable() { // from class: xn
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.lambda$playerContent$5();
                        }
                    }).start();
                    return new JSONObject().put("parse", 0).put("url", "").put("msg", "索引更新已启动，请稍候...返回首页可查看进度").toString();
                }
                if (str2.startsWith("vsp_")) {
                    str2 = str2.substring(4);
                    str3 = "vsp";
                } else if (str2.startsWith("hk_")) {
                    str2 = str2.substring(3);
                    str3 = "hk";
                } else {
                    str3 = "";
                }
                if (isSdk(str2)) {
                    return new JSONObject().put("parse", 1).put("url", "").put("msg", "SDK节目: " + getPrefix(str2)).toString();
                }
                ensureAlive();
                if (str3.equals("vsp")) {
                    String strResolveMediaId = resolveMediaId(str2);
                    playUrlEncrypt = strResolveMediaId.isEmpty() ? null : getVspPlayUrl(str2, strResolveMediaId);
                    if ((playUrlEncrypt == null || playUrlEncrypt.isEmpty()) && (vspEpisodeList = getVspEpisodeList(str2, 0, 1)) != null && (jSONArrayOptJSONArray2 = vspEpisodeList.optJSONArray("episodes")) != null && jSONArrayOptJSONArray2.length() > 0) {
                        JSONObject jSONObject = jSONArrayOptJSONArray2.getJSONObject(0);
                        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("VOD");
                        if (jSONObjectOptJSONObject2 != null) {
                            jSONObject = jSONObjectOptJSONObject2;
                        }
                        String strOptString = jSONObject.optString("ID", "");
                        if (!strOptString.isEmpty()) {
                            String strResolveMediaId2 = resolveMediaId(strOptString);
                            if (!strResolveMediaId2.isEmpty()) {
                                playUrlEncrypt = getVspPlayUrl(strOptString, strResolveMediaId2);
                            }
                        }
                    }
                    if ((playUrlEncrypt == null || playUrlEncrypt.isEmpty()) && (vspVodDetail = getVspVodDetail(str2)) != null && (jSONObjectOptJSONObject = vspVodDetail.optJSONObject("VODDetail")) != null) {
                        String strOptString2 = jSONObjectOptJSONObject.optString("code", "");
                        if (!strOptString2.isEmpty() && !strOptString2.matches("^\\d+$") && (playUrlEncrypt = getPlayUrlHk(strOptString2)) == null) {
                            playUrlEncrypt = getPlayUrlEncrypt(strOptString2, "");
                        }
                    }
                } else {
                    if (str2.matches("^\\d+$")) {
                        String strResolveMediaId3 = resolveMediaId(str2);
                        playUrlEncrypt = strResolveMediaId3.isEmpty() ? null : getVspPlayUrl(str2, strResolveMediaId3);
                        if (playUrlEncrypt == null) {
                            playUrlEncrypt = getPlayUrlHk(str2);
                        }
                    } else {
                        String playUrlHk = getPlayUrlHk(str2);
                        if (playUrlHk == null && (detail = getDetail(str2)) != null && (jSONArrayOptJSONArray = detail.optJSONArray("serieslist")) != null && jSONArrayOptJSONArray.length() > 0) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                String strOptString3 = jSONArrayOptJSONArray.getJSONObject(i).optString("code", "");
                                if (!strOptString3.isEmpty() && (playUrlHk = getPlayUrlHk(strOptString3)) != null) {
                                    break;
                                }
                            }
                        }
                        playUrlEncrypt = playUrlHk;
                    }
                    if (playUrlEncrypt == null) {
                        playUrlEncrypt = getPlayUrlEncrypt(str2, "");
                    }
                }
                if (playUrlEncrypt == null || playUrlEncrypt.isEmpty()) {
                    stopHeartbeat();
                    this.authed = false;
                    this.cookieManager.getCookieStore().removeAll();
                    if (login()) {
                        if (str3.equals("vsp")) {
                            String strResolveMediaId4 = resolveMediaId(str2);
                            if (!strResolveMediaId4.isEmpty()) {
                                playUrlEncrypt = getVspPlayUrl(str2, strResolveMediaId4);
                            }
                        } else {
                            playUrlEncrypt = getPlayUrlHk(str2);
                        }
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("parse", 0);
                jSONObject2.put("url", playUrlEncrypt != null ? playUrlEncrypt : "");
                jSONObject2.put("header", "{\"User-Agent\":\"B700-V2A|Mozilla|5.0|ztebw(Chrome)|1.2.0\"}");
                if (playUrlEncrypt == null || playUrlEncrypt.isEmpty()) {
                    jSONObject2.put("msg", "未获取到播放链接");
                }
                return jSONObject2.toString();
            } catch (Exception unused) {
                return "";
            }
        } catch (Exception unused2) {
            return new JSONObject().put("parse", 0).put("url", "").toString();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String searchContent(String str, boolean z) {
        JSONArray jSONArrayOptJSONArray;
        try {
            if (!this.authed) {
                synchronized (this) {
                    login();
                }
            }
            JSONArray jSONArray = new JSONArray();
            String lowerCase = str.toLowerCase();
            HashSet hashSet = new HashSet();
            if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                    if (entry.getKey().contains(lowerCase)) {
                        String value = entry.getValue();
                        String key = entry.getKey();
                        if (!hashSet.contains(value)) {
                            hashSet.add(value);
                            jSONArray.put(new JSONObject().put("vod_id", value).put("vod_name", key).put("vod_pic", getSearchPic(value)).put("vod_remarks", getPrefix(value)));
                            if (jSONArray.length() >= 50) {
                                break;
                            }
                        }
                    }
                }
            }
            if (jSONArray.length() < 50) {
                try {
                    String strHttpGet = httpGet(this.shicBase + "/vod/search/searchResultNew?userId=" + URLEncoder.encode(this.userId, "UTF-8") + "&keyword=" + URLEncoder.encode(str, "UTF-8") + "&pageNo=1&pageSize=50&isIntensive=-1&programType=");
                    if (strHttpGet != null && (jSONArrayOptJSONArray = new JSONObject(strHttpGet).optJSONObject("response").optJSONObject("responseBody").optJSONArray("list")) != null) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length() && jSONArray.length() < 80; i++) {
                            try {
                                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                                String strOptString = jSONObject.optString("code", "");
                                String strOptString2 = jSONObject.optString("name", "");
                                if (!strOptString.isEmpty() && !strOptString2.isEmpty() && !"1".equals(jSONObject.optString("idType", "")) && isPlayable(strOptString) && !hashSet.contains(strOptString)) {
                                    hashSet.add(strOptString);
                                    String strOptString3 = jSONObject.optString("posterUrl", jSONObject.optString("picPath", ""));
                                    if (strOptString3.startsWith("//")) {
                                        strOptString3 = "http:" + strOptString3;
                                    }
                                    jSONArray.put(new JSONObject().put("vod_id", strOptString).put("vod_name", strOptString2).put("vod_pic", strOptString3).put("vod_remarks", "1".equals(jSONObject.optString("seriesflag", "0")) ? getPrefix(strOptString) + " 连续剧" : getPrefix(strOptString)));
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", jSONArray);
            return jSONObject2.toString();
        } catch (Exception unused3) {
            return "{\"list\":[]}";
        }
    }
}
