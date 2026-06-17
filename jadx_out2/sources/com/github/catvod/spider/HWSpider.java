package com.github.catvod.spider;

import android.content.Context;
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
public class HWSpider extends Spider {
    private static final long AUTH_TTL = 600000;
    private static final Map<String, String> CODE_TRANSFORMS;
    private static final Map<String, String> PREFIX_NAMES;
    private static final Map<String, String> ZONE_DEFAULT_SUB;
    private CookieManager cookieManager;
    private String epgHost;
    private Thread heartbeatThread;
    private String indexFilePath;
    private String edsServer = "27.223.126.136:8082";
    private String encryptKey = "";
    private String userId = "";
    private String stbId = "";
    private String mac = "";
    private String stbType = "";
    private String stbVersion = "V83321337.1005";
    private String interfaceSuffix = "CU";
    private String sdmsHost = "124.132.253.193";
    private int sdmsPort = 86;
    private String imgHost = "124.132.253.193";
    private int imgPort = 85;
    private String sdmsSearchHost = "124.132.253.193";
    private int sdmsSearchPort = 81;
    private String sdmsSearchTime = "1541756249247";
    private String sdmsSearchRiddle = "5660c2fc967f0026ec138dcc36fff8d5";
    private String topCatId = "10000100000000090000000000013994";
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        HashMap map = new HashMap();
        PREFIX_NAMES = map;
        HashMap map2 = new HashMap();
        CODE_TRANSFORMS = map2;
        HashMap map3 = new HashMap();
        ZONE_DEFAULT_SUB = map3;
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
        map.put("JZTX", "极智");
        map.put("JLTM", "极光");
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
        map.put("YUNWEPROGM", "运维");
        map.put("YUNWEI", "运维");
        map.put("2110MAMS", "宣传片");
        map.put("2110MPROGM", "宣传片");
        map.put("21100001", "宣传片");
        map.put("PR", "推荐位");
        map2.put("YHYKMLT", "YHYKQTS");
        map2.put("JZTX_", "JZTQ_");
        map2.put("GUOQY_ser_", "GUOQY_pro_");
        map3.put("1032", "1032007");
        map3.put("1035", "1035006");
        map3.put("1024", "1024014");
        map3.put("1025", "1025004");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0151: RETURN (r16 I:org.json.JSONObject) A[SYNTHETIC] (LINE:338), block:B:70:? */
    private JSONObject buildCategoryFilters(String str) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            int i = 0;
            try {
                if (!str.startsWith("epgcat_")) {
                    JSONArray categories = getCategories(str);
                    if (categories != null && categories.length() != 0) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(new JSONObject().put("n", "全部").put("v", ""));
                        while (i < categories.length()) {
                            JSONObject jSONObject3 = categories.getJSONObject(i);
                            String strOptString = jSONObject3.optString("primaryid", jSONObject3.optString(Name.MARK, ""));
                            String strOptString2 = jSONObject3.optString("name", "");
                            if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                                jSONArray.put(new JSONObject().put("n", strOptString2).put("v", strOptString));
                            }
                            i++;
                        }
                        if (jSONArray.length() <= 1) {
                            return null;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(new JSONObject().put("key", "sub").put("name", "分类").put(ES6Iterator.VALUE_PROPERTY, jSONArray));
                        jSONObject2.put(str, jSONArray2);
                        return jSONObject2;
                    }
                    return null;
                }
                JSONArray epgCategories = getEpgCategories(str.substring(7));
                if (epgCategories == null || epgCategories.length() == 0) {
                    return null;
                }
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put(new JSONObject().put("n", "全部").put("v", ""));
                while (i < epgCategories.length()) {
                    JSONObject jSONObject4 = epgCategories.getJSONObject(i);
                    if (!"0".equals(jSONObject4.optString("introduce", "1"))) {
                        String strOptString3 = jSONObject4.optString("typeId", "");
                        String strOptString4 = jSONObject4.optString("typeName", jSONObject4.optString("subTypeName", ""));
                        if (!strOptString3.isEmpty() && !strOptString4.isEmpty()) {
                            jSONArray3.put(new JSONObject().put("n", strOptString4).put("v", strOptString3));
                        }
                    }
                    i++;
                }
                if (jSONArray3.length() <= 1) {
                    return null;
                }
                JSONArray jSONArray4 = new JSONArray();
                jSONArray4.put(new JSONObject().put("key", "epgsub").put("name", "分类").put(ES6Iterator.VALUE_PROPERTY, jSONArray3));
                jSONObject2.put(str, jSONArray4);
                return jSONObject2;
            } catch (Exception unused) {
                return jSONObject;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject buildDetail(String str) {
        try {
            if (str.startsWith("epg_")) {
                return buildEpgDetail(str.substring(4));
            }
            if (str.startsWith("epgm_")) {
                return buildEpgMergedDetail(str.substring(5));
            }
            if (str.startsWith("epglist_")) {
                return buildEpgListDetail(str.substring(8));
            }
            JSONObject detail = getDetail(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vod_id", str);
            jSONObject.put("vod_name", str);
            jSONObject.put("vod_play_from", "华为IPTV");
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02bc A[Catch: Exception -> 0x02df, TRY_LEAVE, TryCatch #0 {Exception -> 0x02df, blocks: (B:3:0x000e, B:6:0x0019, B:8:0x001d, B:10:0x0021, B:12:0x0025, B:14:0x0029, B:16:0x002d, B:20:0x0061, B:22:0x0067, B:25:0x00b2, B:27:0x00b8, B:29:0x00ce, B:31:0x00d8, B:32:0x00e4, B:33:0x00e9, B:35:0x00f1, B:37:0x00f7, B:38:0x00fd, B:40:0x0103, B:42:0x0109, B:43:0x010c, B:44:0x014a, B:51:0x016d, B:53:0x0173, B:55:0x0179, B:57:0x0182, B:60:0x018d, B:62:0x0193, B:64:0x01a5, B:66:0x01ad, B:68:0x01b3, B:69:0x01bb, B:71:0x01c1, B:73:0x01c7, B:74:0x01ca, B:76:0x01d0, B:78:0x0242, B:77:0x0212, B:79:0x024c, B:82:0x0260, B:84:0x026c, B:87:0x027f, B:89:0x028b, B:91:0x0291, B:98:0x02bc, B:86:0x0276, B:93:0x029c), top: B:102:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject buildEpgDetail(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        boolean z2;
        String str6;
        String str7;
        boolean z3;
        JSONObject epgVodList;
        JSONArray jSONArrayOptJSONArray;
        boolean z4;
        int i;
        String str8;
        String str9;
        HWSpider hWSpider = this;
        try {
            String[] strArrSplit = str.split("_");
            String str10 = strArrSplit.length >= 1 ? strArrSplit[0] : "";
            String str11 = strArrSplit.length >= 2 ? strArrSplit[1] : "";
            String str12 = strArrSplit.length >= 3 ? strArrSplit[2] : "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vod_id", "epg_".concat(str));
            jSONObject.put("vod_name", str);
            jSONObject.put("vod_play_from", "华为IPTV");
            String str13 = "#";
            String str14 = "code";
            if (str12.isEmpty()) {
                str2 = "vod_name";
                str3 = str12;
            } else {
                String str15 = str11;
                JSONObject detail = hWSpider.getDetail(str12);
                if (detail != null) {
                    str3 = str12;
                    jSONObject.put("vod_name", detail.optString("name", str));
                    jSONObject.put("vod_year", detail.optString("releaseyear", ""));
                    jSONObject.put("vod_area", detail.optString("originalcountry", ""));
                    jSONObject.put("vod_actor", detail.optString("actordisplay", ""));
                    jSONObject.put("vod_director", detail.optString("director", ""));
                    jSONObject.put("vod_content", detail.optString("description", ""));
                    JSONArray jSONArrayOptJSONArray2 = detail.optJSONArray("picturelist");
                    str2 = "vod_name";
                    if (jSONArrayOptJSONArray2 != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArrayOptJSONArray2.length()) {
                                break;
                            }
                            JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                            JSONArray jSONArray = jSONArrayOptJSONArray2;
                            int i3 = i2;
                            if ("2".equals(jSONObject2.optString("type")) && !jSONObject2.optString("fileurl", "").isEmpty()) {
                                jSONObject.put("vod_pic", hWSpider.fixImageUrl(jSONObject2.optString("fileurl")));
                                break;
                            }
                            i2 = i3 + 1;
                            jSONArrayOptJSONArray2 = jSONArray;
                        }
                    }
                    JSONArray jSONArrayOptJSONArray3 = detail.optJSONArray("serieslist");
                    if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        int i4 = 0;
                        while (i4 < jSONArrayOptJSONArray3.length()) {
                            JSONObject jSONObject3 = jSONArrayOptJSONArray3.getJSONObject(i4);
                            if (i4 > 0) {
                                sb.append("#");
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("第");
                            i4++;
                            sb2.append(i4);
                            sb2.append("集");
                            sb.append(jSONObject3.optString("name", sb2.toString()));
                            sb.append("$epg_");
                            sb.append(str10);
                            sb.append("_");
                            String str16 = str15;
                            sb.append(str16);
                            sb.append("_");
                            JSONArray jSONArray2 = jSONArrayOptJSONArray3;
                            String str17 = str14;
                            sb.append(jSONObject3.optString(str17, ""));
                            str14 = str17;
                            jSONArrayOptJSONArray3 = jSONArray2;
                            str15 = str16;
                        }
                        str11 = str15;
                        str5 = str14;
                        str4 = "vod_play_url";
                        jSONObject.put(str4, sb.toString());
                        z = true;
                        if (!z || str10.isEmpty() || str11.isEmpty() || (epgVodList = hWSpider.getEpgVodList(str11, 0, 500)) == null || (jSONArrayOptJSONArray = epgVodList.optJSONArray("arr")) == null) {
                            z2 = z;
                        } else {
                            z2 = z;
                            int i5 = 0;
                            while (i5 < jSONArrayOptJSONArray.length()) {
                                JSONObject jSONObject4 = jSONArrayOptJSONArray.getJSONObject(i5);
                                JSONArray jSONArray3 = jSONArrayOptJSONArray;
                                if (str10.equals(jSONObject4.optString("vodId", ""))) {
                                    JSONArray jSONArrayOptJSONArray4 = jSONObject4.optJSONArray("childrenList");
                                    if (jSONArrayOptJSONArray4 == null || jSONArrayOptJSONArray4.length() <= 0) {
                                        str6 = str10;
                                        str7 = str3;
                                        z4 = z2;
                                    } else {
                                        StringBuilder sb3 = new StringBuilder();
                                        str6 = str10;
                                        int i6 = 0;
                                        while (i6 < jSONArrayOptJSONArray4.length()) {
                                            Object obj = jSONArrayOptJSONArray4.get(i6);
                                            if (i6 > 0) {
                                                sb3.append(str13);
                                            }
                                            JSONArray jSONArray4 = jSONArrayOptJSONArray4;
                                            if (obj instanceof JSONObject) {
                                                JSONObject jSONObject5 = (JSONObject) obj;
                                                i = i6;
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append("第");
                                                str8 = str13;
                                                sb4.append(i + 1);
                                                sb4.append("集");
                                                String strOptString = jSONObject5.optString("subVodName", sb4.toString());
                                                String strOptString2 = jSONObject5.optString("subVodId", "");
                                                sb3.append(strOptString);
                                                sb3.append("$epg_");
                                                sb3.append(strOptString2);
                                                sb3.append("_");
                                                sb3.append(str11);
                                                sb3.append("_");
                                                str9 = str3;
                                                sb3.append(jSONObject5.optString(str5, str9));
                                            } else {
                                                i = i6;
                                                str8 = str13;
                                                str9 = str3;
                                                String strValueOf = String.valueOf(obj);
                                                sb3.append("第" + (i + 1) + "集");
                                                sb3.append("$epg_");
                                                sb3.append(strValueOf);
                                                sb3.append("_");
                                                sb3.append(str11);
                                                sb3.append("_");
                                            }
                                            i6 = i + 1;
                                            str3 = str9;
                                            jSONArrayOptJSONArray4 = jSONArray4;
                                            str13 = str8;
                                        }
                                        str7 = str3;
                                        jSONObject.put(str4, sb3.toString());
                                        z4 = true;
                                    }
                                    String str18 = str2;
                                    if (jSONObject.optString(str18, "").equals(str) || jSONObject.optString(str18, "").isEmpty()) {
                                        jSONObject.put(str18, jSONObject4.optString("vodName", str));
                                    }
                                    String strOptString3 = jSONObject4.optString("picPath", "");
                                    if (!strOptString3.isEmpty() && !jSONObject.has("vod_pic")) {
                                        jSONObject.put("vod_pic", fixEpgImageUrl(strOptString3));
                                    }
                                    z3 = z4;
                                    if (!z3) {
                                        jSONObject.put(str4, "播放$epg_" + str6 + "_" + str11 + "_" + str7);
                                    }
                                    return jSONObject;
                                }
                                i5++;
                                hWSpider = hWSpider;
                                jSONArrayOptJSONArray = jSONArray3;
                                str10 = str10;
                            }
                        }
                        str6 = str10;
                        str7 = str3;
                        z3 = z2;
                        if (!z3) {
                        }
                        return jSONObject;
                    }
                } else {
                    str2 = "vod_name";
                    str3 = str12;
                }
                str11 = str15;
            }
            str4 = "vod_play_url";
            str5 = str14;
            z = false;
            if (z) {
                z2 = z;
                str6 = str10;
                str7 = str3;
                z3 = z2;
            }
            if (!z3) {
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0045, code lost:
    
        r17 = r2;
        r20 = "seriesflag";
        r21 = "vodName";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject buildEpgListDetail(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String strOptString;
        Iterator it;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        JSONArray jSONArray;
        String str13;
        JSONObject detail;
        String str14;
        String str15 = str;
        String str16 = "fileurl";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vod_id", "epglist_" + str15);
            jSONObject.put("vod_play_from", "华为IPTV");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int length = 0;
            while (true) {
                JSONObject epgVodList = getEpgVodList(str15, length, 50);
                String str17 = "seriesflag";
                str2 = "isSitcom";
                String str18 = "vodName";
                str3 = "1";
                str4 = "0";
                if (epgVodList == null) {
                    break;
                }
                int i = length;
                JSONArray jSONArrayOptJSONArray = epgVodList.optJSONArray("arr");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    break;
                }
                str5 = str16;
                int i2 = 0;
                while (i2 < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    int i3 = i2;
                    String strOptString2 = jSONObject2.optString("isSitcom", "0");
                    JSONArray jSONArray2 = jSONArrayOptJSONArray;
                    String strOptString3 = jSONObject2.optString(str17, "0");
                    String str19 = str17;
                    String strOptString4 = jSONObject2.optString(str18, "");
                    String str20 = str18;
                    String strOptString5 = jSONObject2.optString("vodId", "");
                    if ("1".equals(strOptString2) || "1".equals(strOptString3)) {
                        String str21 = "__sitcom__" + strOptString5;
                        if (!linkedHashMap.containsKey(str21)) {
                            linkedHashMap.put(str21, new ArrayList());
                        }
                        ((List) linkedHashMap.get(str21)).add(jSONObject2);
                    } else {
                        if (!linkedHashMap.containsKey(strOptString4)) {
                            linkedHashMap.put(strOptString4, new ArrayList());
                        }
                        ((List) linkedHashMap.get(strOptString4)).add(jSONObject2);
                    }
                    if (jSONObject.optString("vod_name", "").isEmpty()) {
                        jSONObject.put("vod_name", strOptString4);
                    }
                    if (!jSONObject.has("vod_pic")) {
                        String strOptString6 = jSONObject2.optString("picPath", "");
                        if (!strOptString6.isEmpty()) {
                            jSONObject.put("vod_pic", fixEpgImageUrl(strOptString6));
                        }
                    }
                    i2 = i3 + 1;
                    jSONArrayOptJSONArray = jSONArray2;
                    str17 = str19;
                    str18 = str20;
                }
                str6 = str17;
                str7 = str18;
                int iOptInt = epgVodList.optInt("countTotal", 0);
                length = i + jSONArrayOptJSONArray.length();
                if (length >= iOptInt) {
                    break;
                }
                str15 = str;
                str16 = str5;
            }
            Iterator it2 = linkedHashMap.values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    strOptString = "";
                    break;
                }
                strOptString = ((JSONObject) ((List) it2.next()).get(0)).optString("code", "");
                if (!strOptString.isEmpty()) {
                    break;
                }
            }
            if (!strOptString.isEmpty() && (detail = getDetail(strOptString)) != null) {
                jSONObject.put("vod_name", detail.optString("name", jSONObject.optString("vod_name", "")));
                jSONObject.put("vod_year", detail.optString("releaseyear", ""));
                jSONObject.put("vod_area", detail.optString("originalcountry", ""));
                jSONObject.put("vod_actor", detail.optString("actordisplay", ""));
                jSONObject.put("vod_director", detail.optString("director", ""));
                jSONObject.put("vod_content", detail.optString("description", ""));
                JSONArray jSONArrayOptJSONArray2 = detail.optJSONArray("picturelist");
                if (jSONArrayOptJSONArray2 != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= jSONArrayOptJSONArray2.length()) {
                            break;
                        }
                        JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i4);
                        if ("2".equals(jSONObject3.optString("type"))) {
                            str14 = str5;
                            if (!jSONObject3.optString(str14, "").isEmpty()) {
                                jSONObject.put("vod_pic", fixImageUrl(jSONObject3.optString(str14)));
                                break;
                            }
                        } else {
                            str14 = str5;
                        }
                        i4++;
                        str5 = str14;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            Iterator it3 = linkedHashMap.entrySet().iterator();
            while (it3.hasNext()) {
                List list = (List) ((Map.Entry) it3.next()).getValue();
                if (list.size() == 1) {
                    JSONObject jSONObject4 = (JSONObject) list.get(0);
                    String strOptString7 = jSONObject4.optString(str2, str4);
                    String str22 = str6;
                    String strOptString8 = jSONObject4.optString(str22, str4);
                    it = it3;
                    String strOptString9 = jSONObject4.optString("vodId", "");
                    str8 = str2;
                    String strOptString10 = jSONObject4.optString("code", "");
                    if (str3.equals(strOptString7)) {
                        str6 = str22;
                        str10 = str7;
                        str12 = str;
                        str9 = str3;
                    } else if (str3.equals(strOptString8)) {
                        str6 = str22;
                        str9 = str3;
                        str10 = str7;
                        str12 = str;
                    } else {
                        if (sb.length() > 0) {
                            sb.append("#");
                        }
                        str10 = str7;
                        sb.append(jSONObject4.optString(str10, ""));
                        sb.append("$epg_");
                        sb.append(strOptString9);
                        sb.append("_");
                        sb.append(str);
                        sb.append("_");
                        sb.append(strOptString10);
                        str6 = str22;
                        str9 = str3;
                        str11 = str4;
                    }
                    JSONArray jSONArrayOptJSONArray3 = jSONObject4.optJSONArray("childrenList");
                    if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                        str11 = str4;
                        if (sb.length() > 0) {
                            sb.append("#");
                        }
                        sb.append(jSONObject4.optString(str10, ""));
                        sb.append("$epg_");
                        sb.append(strOptString9);
                        sb.append("_");
                        sb.append(str12);
                        sb.append("_");
                        sb.append(strOptString10);
                    } else {
                        int i5 = 0;
                        while (i5 < jSONArrayOptJSONArray3.length()) {
                            if (sb.length() > 0) {
                                sb.append("#");
                            }
                            Object obj = jSONArrayOptJSONArray3.get(i5);
                            int i6 = i5;
                            if (obj instanceof JSONObject) {
                                JSONObject jSONObject5 = (JSONObject) obj;
                                jSONArray = jSONArrayOptJSONArray3;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("第");
                                str13 = str4;
                                sb2.append(i6 + 1);
                                sb2.append("集");
                                sb.append(jSONObject5.optString("subVodName", sb2.toString()));
                                sb.append("$epg_");
                                sb.append(jSONObject5.optString("subVodId", ""));
                                sb.append("_");
                                sb.append(str12);
                                sb.append("_");
                                sb.append(jSONObject5.optString("code", strOptString10));
                            } else {
                                jSONArray = jSONArrayOptJSONArray3;
                                str13 = str4;
                                sb.append("第");
                                sb.append(i6 + 1);
                                sb.append("集$epg_");
                                sb.append(obj);
                                sb.append("_");
                                sb.append(str12);
                                sb.append("_");
                            }
                            i5 = i6 + 1;
                            jSONArrayOptJSONArray3 = jSONArray;
                            str4 = str13;
                        }
                        str11 = str4;
                    }
                } else {
                    it = it3;
                    str8 = str2;
                    str9 = str3;
                    str10 = str7;
                    str11 = str4;
                    int i7 = 0;
                    while (i7 < list.size()) {
                        JSONObject jSONObject6 = (JSONObject) list.get(i7);
                        String strOptString11 = jSONObject6.optString("vodId", "");
                        String strOptString12 = jSONObject6.optString("code", "");
                        if (sb.length() > 0) {
                            sb.append("#");
                        }
                        sb.append("第");
                        i7++;
                        sb.append(i7);
                        sb.append("期$epg_");
                        sb.append(strOptString11);
                        sb.append("_");
                        sb.append(str);
                        sb.append("_");
                        sb.append(strOptString12);
                    }
                }
                it3 = it;
                str2 = str8;
                str3 = str9;
                str4 = str11;
                str7 = str10;
            }
            jSONObject.put("vod_play_url", sb.toString());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject buildEpgMergedDetail(String str) {
        String strOptString;
        JSONObject detail;
        JSONObject epgVodList;
        JSONArray jSONArrayOptJSONArray;
        try {
            String[] strArrSplit = str.split("_", 2);
            int i = 0;
            String str2 = strArrSplit.length >= 1 ? strArrSplit[0] : "";
            String[] strArrSplit2 = (strArrSplit.length >= 2 ? strArrSplit[1] : "").split(",");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vod_id", "epgm_".concat(str));
            jSONObject.put("vod_play_from", "华为IPTV");
            String str3 = strArrSplit2.length > 0 ? strArrSplit2[0] : "";
            if (str3.isEmpty() || str2.isEmpty() || (epgVodList = getEpgVodList(str2, 0, 500)) == null || (jSONArrayOptJSONArray = epgVodList.optJSONArray("arr")) == null) {
                strOptString = "";
            } else {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    if (str3.equals(jSONObject2.optString("vodId", ""))) {
                        jSONObject.put("vod_name", jSONObject2.optString("vodName", ""));
                        String strOptString2 = jSONObject2.optString("picPath", "");
                        if (!strOptString2.isEmpty()) {
                            jSONObject.put("vod_pic", fixEpgImageUrl(strOptString2));
                        }
                        strOptString = jSONObject2.optString("code", "");
                    }
                }
                strOptString = "";
            }
            if (!strOptString.isEmpty() && (detail = getDetail(strOptString)) != null) {
                if (!jSONObject.has("vod_name") || jSONObject.optString("vod_name", "").isEmpty()) {
                    jSONObject.put("vod_name", detail.optString("name", ""));
                }
                jSONObject.put("vod_year", detail.optString("releaseyear", ""));
                jSONObject.put("vod_area", detail.optString("originalcountry", ""));
                jSONObject.put("vod_actor", detail.optString("actordisplay", ""));
                jSONObject.put("vod_director", detail.optString("director", ""));
                jSONObject.put("vod_content", detail.optString("description", ""));
                JSONArray jSONArrayOptJSONArray2 = detail.optJSONArray("picturelist");
                if (jSONArrayOptJSONArray2 != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArrayOptJSONArray2.length()) {
                            break;
                        }
                        JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i3);
                        if ("2".equals(jSONObject3.optString("type")) && !jSONObject3.optString("fileurl", "").isEmpty()) {
                            jSONObject.put("vod_pic", fixImageUrl(jSONObject3.optString("fileurl")));
                            break;
                        }
                        i3++;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (i < strArrSplit2.length) {
                if (i > 0) {
                    sb.append("#");
                }
                sb.append("第");
                int i4 = i + 1;
                sb.append(i4);
                sb.append("集$epg_");
                sb.append(strArrSplit2[i]);
                sb.append("_");
                sb.append(str2);
                sb.append("_");
                i = i4;
            }
            jSONObject.put("vod_play_url", sb.toString());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject buildEpgVodItem(JSONObject jSONObject, String str) {
        String string;
        try {
            String strOptString = jSONObject.optString("picPath", "");
            String strOptString2 = jSONObject.optString("seriesflag", "0");
            String strOptString3 = jSONObject.optString("isSitcom", "0");
            String strOptString4 = jSONObject.optString("code", "");
            String strOptString5 = jSONObject.optString("vodId", "");
            String strOptString6 = jSONObject.optString("TYPEID", jSONObject.optString("rootTypeId", str));
            String strOptString7 = jSONObject.optString("vodName", "");
            if ("1".equals(strOptString3) || "1".equals(strOptString2)) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childrenList");
                int length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : jSONObject.optInt("sitcomNum", 0);
                StringBuilder sb = new StringBuilder();
                sb.append(getPrefix(strOptString4));
                String str2 = " 连续剧";
                if (length > 0) {
                    str2 = " 连续剧" + length + "集";
                }
                sb.append(str2);
                string = sb.toString();
            } else {
                string = getPrefix(strOptString4);
            }
            return new JSONObject().put("vod_id", "epg_" + strOptString5 + "_" + strOptString6 + "_" + strOptString4).put("vod_name", strOptString7).put("vod_pic", fixEpgImageUrl(strOptString)).put("vod_remarks", string);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONArray buildEpgVodList(JSONArray jSONArray, String str) {
        try {
            JSONArray jSONArray2 = new JSONArray();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String strOptString = jSONObject.optString("isSitcom", "0");
                String strOptString2 = jSONObject.optString("seriesflag", "0");
                String strOptString3 = jSONObject.optString("vodName", "");
                String strOptString4 = jSONObject.optString("vodId", "");
                if ("1".equals(strOptString) || "1".equals(strOptString2)) {
                    String str2 = "__sitcom__" + strOptString4;
                    if (!linkedHashMap.containsKey(str2)) {
                        linkedHashMap.put(str2, new ArrayList());
                    }
                    ((List) linkedHashMap.get(str2)).add(jSONObject);
                } else {
                    if (!linkedHashMap.containsKey(strOptString3)) {
                        linkedHashMap.put(strOptString3, new ArrayList());
                    }
                    ((List) linkedHashMap.get(strOptString3)).add(jSONObject);
                }
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                List<JSONObject> list = (List) ((Map.Entry) it.next()).getValue();
                if (list.size() == 1) {
                    JSONObject jSONObjectBuildEpgVodItem = buildEpgVodItem((JSONObject) list.get(i), str);
                    if (jSONObjectBuildEpgVodItem != null) {
                        jSONArray2.put(jSONObjectBuildEpgVodItem);
                    }
                } else {
                    JSONObject jSONObject2 = (JSONObject) list.get(i);
                    String strOptString5 = jSONObject2.optString("vodName", "");
                    String strOptString6 = jSONObject2.optString("TYPEID", jSONObject2.optString("rootTypeId", str));
                    String strOptString7 = jSONObject2.optString("code", "");
                    String strOptString8 = jSONObject2.optString("picPath", "");
                    StringBuilder sb = new StringBuilder();
                    for (JSONObject jSONObject3 : list) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(jSONObject3.optString("vodId", ""));
                    }
                    jSONArray2.put(new JSONObject().put("vod_id", "epgm_" + strOptString6 + "_" + ((Object) sb)).put("vod_name", strOptString5).put("vod_pic", fixEpgImageUrl(strOptString8)).put("vod_remarks", getPrefix(strOptString7) + " " + list.size() + "集"));
                }
                i = 0;
            }
            return jSONArray2;
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: lambda$playerContent$5()V */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildSearchIndex, reason: merged with bridge method [inline-methods] */
    public void lambda$playerContent$5() {
        loadSearchIndex();
        try {
            try {
                JSONArray rootCategories = getRootCategories();
                ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(6);
                final CountDownLatch countDownLatch = new CountDownLatch((rootCategories != null ? rootCategories.length() : 0) + ZONE_DEFAULT_SUB.size());
                if (rootCategories != null) {
                    for (int i = 0; i < rootCategories.length(); i++) {
                        try {
                            JSONObject jSONObject = rootCategories.getJSONObject(i);
                            final String strOptString = jSONObject.optString("primaryid", jSONObject.optString(Name.MARK, ""));
                            if (strOptString.isEmpty()) {
                                countDownLatch.countDown();
                            } else {
                                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: ac1
                                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f.lambda$buildSearchIndex$0(strOptString, countDownLatch);
                                    }
                                });
                            }
                        } catch (Exception unused) {
                            countDownLatch.countDown();
                        }
                    }
                }
                for (final String str : ZONE_DEFAULT_SUB.keySet()) {
                    executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: bc1
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.lambda$buildSearchIndex$1(str, countDownLatch);
                        }
                    });
                }
                countDownLatch.await(15L, TimeUnit.MINUTES);
                executorServiceNewFixedThreadPool.shutdown();
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
            int i = this.edsServer.contains(":") ? Integer.parseInt(this.edsServer.split(":")[1]) : 8082;
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
    private String epgGet(String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder("http://" + this.epgHost + str);
            if (map != null && !map.isEmpty()) {
                sb.append("?");
                boolean z = true;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!z) {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    z = false;
                }
            }
            return httpGet(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject epgGetJson(String str, Map<String, String> map) {
        String strEpgGet = epgGet(str, map);
        if (strEpgGet == null) {
            return null;
        }
        try {
            return new JSONObject(strEpgGet);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String fixEpgImageUrl(String str) {
        return (str == null || str.isEmpty()) ? "" : str.startsWith("http") ? str : String.format("http://%s/EPG/jsp/defaulttrans2/en/%s", this.epgHost, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String fixImageUrl(String str) {
        return (str == null || str.isEmpty()) ? "" : str.startsWith("//") ? "http:".concat(str) : str.startsWith("http://124.132.253.193:85/") ? str.replace("http://124.132.253.193:85/", String.format("http://%s:%d/", this.imgHost, Integer.valueOf(this.imgPort))) : (str.startsWith("/data") || str.startsWith("/pic")) ? String.format("http://%s:%d", this.imgHost, Integer.valueOf(this.imgPort)).concat(str) : !str.startsWith("http") ? String.format("http://%s:%d/", this.imgHost, Integer.valueOf(this.imgPort)).concat(str) : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONArray getCategories(String str) {
        JSONObject jsonp;
        String str2 = "cat_" + str;
        if (this.cache.containsKey(str2)) {
            return (JSONArray) this.cache.get(str2);
        }
        try {
            String strHttpGet = httpGet(sdmsCategoryPath(str));
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONArray getEpgCategories(String str) {
        String str2 = "epgcat_" + str;
        if (this.cache.containsKey(str2)) {
            return (JSONArray) this.cache.get(str2);
        }
        try {
            HashMap map = new HashMap();
            map.put("recTypeId", str);
            String strEpgGet = epgGet("/EPG/jsp/defaulttrans2/en/datajsp/waterfall_getTypeListData.jsp", map);
            if (strEpgGet == null) {
                return null;
            }
            Object objNextValue = new JSONTokener(strEpgGet).nextValue();
            if (objNextValue instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) objNextValue;
                this.cache.put(str2, jSONArray);
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject getEpgVodList(String str, int i, int i2) {
        String str2 = "epgvod_" + str + "_" + i;
        if (this.cache.containsKey(str2)) {
            return (JSONObject) this.cache.get(str2);
        }
        try {
            HashMap map = new HashMap();
            map.put("recTypeId", str);
            map.put("STATION", String.valueOf(i));
            map.put("LENGTH", String.valueOf(i2));
            map.put("subLength", "200");
            JSONObject jSONObjectEpgGetJson = epgGetJson("/EPG/jsp/defaulttrans2/en/datajsp/vod_ListData.jsp", map);
            if (jSONObjectEpgGetJson != null) {
                this.cache.put(str2, jSONObjectEpgGetJson);
            }
            return jSONObjectEpgGetJson;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getPlayUrlEpg(String str, String str2) {
        if (this.authed && this.epgHost != null) {
            try {
                HashMap map = new HashMap();
                map.put("PROGID", str);
                map.put("TYPEID", str2);
                map.put("PLAYTYPE", "1");
                map.put("CONTENTTYPE", "10");
                map.put("BUSINESSTYPE", "1");
                map.put("ONECEPRICE", "0");
                JSONObject jSONObjectEpgGetJson = epgGetJson("/EPG/jsp/defaulttrans2/en/datajsp/play_getVodPlayUrl.jsp", map);
                if (jSONObjectEpgGetJson != null && jSONObjectEpgGetJson.optBoolean("isSucess", false)) {
                    String strOptString = jSONObjectEpgGetJson.optString("url", "");
                    if (!strOptString.isEmpty()) {
                        return strOptString;
                    }
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
                        String strHttpGet = this.httpGet(String.format("http://%s/EPG/jsp/defaulttrans2/en/datajsp/geturlhwNew.jsp?code=%s", this.epgHost, URLEncoder.encode((String) it.next(), "UTF-8")));
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
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getPrefix(String str) {
        String str2;
        if (str.contains("_")) {
            str2 = str.split("_")[0];
        } else {
            ArrayList arrayList = new ArrayList(PREFIX_NAMES.keySet());
            arrayList.sort(new Comparator() { // from class: yb1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONObject getPrograms(String str, int i) {
        String str2 = "prog_" + str + "_" + i;
        if (this.cache.containsKey(str2)) {
            return (JSONObject) this.cache.get(str2);
        }
        try {
            String strHttpGet = httpGet(sdmsProgramPath(str, i));
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
            if (responseCode == 200 || responseCode == 302) {
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
                if (responseCode == 200) {
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
                }
            }
            httpURLConnection.disconnect();
            return null;
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
    private boolean isSdk(String str) {
        return getPrefix(str).equals("极光");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildSearchIndex$0(String str, CountDownLatch countDownLatch) {
        try {
            indexCategoryRecursive(str, 0);
        } catch (Exception unused) {
        } finally {
            countDownLatch.countDown();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildSearchIndex$1(String str, CountDownLatch countDownLatch) {
        try {
            indexCategoryRecursive(str, 0);
        } catch (Exception unused) {
        } finally {
            countDownLatch.countDown();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2() {
        detectLocalIp();
        login();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playerContent$6() {
        this.searchIndexBuilt = false;
        lambda$playerContent$5();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startHeartbeat$3() {
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void loadSearchIndex() {
        if (this.indexFilePath == null) {
            return;
        }
        try {
            File file = new File(this.indexFilePath);
            if (!file.exists()) {
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                }
                parseIndexLine(line);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private synchronized boolean login() {
        try {
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
                httpPost(String.format("http://%s/EPG/jsp/ValidAuthenticationHW%s.jsp", this.epgHost, this.interfaceSuffix), "UserID=" + URLEncoder.encode(this.userId, "UTF-8") + "&Lang=0&SupportHD=1&NetUserID=SDIPTVPPPOE@sdiptv&Authenticator=" + URLEncoder.encode(desEncrypt(String.format("%d$%s$%s$%s$%s$%s$Reserved$CTC", Long.valueOf(((long) (Math.random() * 9.0E7d)) + 10000000), strGroup, this.userId, this.stbId, this.localIp, this.mac), this.encryptKey), "UTF-8") + "&STBType=" + URLEncoder.encode(this.stbType, "UTF-8") + "&STBVersion=" + URLEncoder.encode(this.stbVersion, "UTF-8") + "&conntype=dhcp&STBID=" + URLEncoder.encode(this.stbId, "UTF-8") + "&templateName=&areaId=&userToken=" + URLEncoder.encode(strGroup, "UTF-8") + "&userGroupId=&productPackageId=&mac=" + URLEncoder.encode(this.mac, "UTF-8") + "&UserField=&SoftwareVersion=" + URLEncoder.encode(this.stbVersion, "UTF-8") + "&IsSmartStb=undefined&desktopId=undefined&stbmaker=&VIP=");
                this.authed = true;
                this.authTime = System.currentTimeMillis();
                startHeartbeat();
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String sdmsDetailPath(String str) {
        return String.format("http://%s:%d/staticData/data/detail/%s/D%s.js", this.sdmsHost, Integer.valueOf(this.sdmsPort), str.substring(str.length() - 1), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONArray searchEpg(String str) {
        try {
            HashMap map = new HashMap();
            map.put("CONDITION", str);
            JSONObject jSONObjectEpgGetJson = epgGetJson("/EPG/jsp/defaulttrans2/en/datajsp/vod_searchResult.jsp", map);
            return jSONObjectEpgGetJson == null ? new JSONArray() : jSONObjectEpgGetJson.optJSONArray("filmList");
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private JSONArray searchOnline(String str) {
        try {
            String strHttpGet = httpGet(String.format("http://%s:%d%s?time=%s&riddle=%s&vo.pageid=1&vo.pagecount=50&vo.providerid=MAS&vo.name=%s&vo.searchtypeid=&callback=res", this.sdmsSearchHost, Integer.valueOf(this.sdmsSearchPort), "/cms/programIptv_searchByNameWithSearchTypeByJsonp.do", this.sdmsSearchTime, this.sdmsSearchRiddle, URLEncoder.encode(str, "UTF-8")));
            if (strHttpGet == null) {
                return new JSONArray();
            }
            int iIndexOf = strHttpGet.indexOf(40);
            int iLastIndexOf = strHttpGet.lastIndexOf(41);
            return (iIndexOf <= 0 || iLastIndexOf <= iIndexOf) ? new JSONArray() : new JSONObject(strHttpGet.substring(iIndexOf + 1, iLastIndexOf)).optJSONArray("list");
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void startHeartbeat() {
        if (this.heartbeatRunning) {
            return;
        }
        this.heartbeatRunning = true;
        Thread thread = new Thread(new Runnable() { // from class: ec1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.lambda$startHeartbeat$3();
            }
        }, "HW-Heartbeat");
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
    /* JADX WARN: Removed duplicated region for block: B:132:0x044b A[Catch: Exception -> 0x045b, TryCatch #0 {Exception -> 0x045b, blocks: (B:3:0x0008, B:7:0x003d, B:9:0x0043, B:12:0x0053, B:16:0x005d, B:18:0x006d, B:21:0x008a, B:23:0x0090, B:40:0x013c, B:26:0x00cc, B:28:0x00d2, B:39:0x00ff, B:32:0x00db, B:34:0x00e3, B:37:0x00eb, B:130:0x0437, B:132:0x044b, B:134:0x0451, B:135:0x0456, B:47:0x016e, B:50:0x017a, B:59:0x019e, B:61:0x01a4, B:63:0x01ac, B:66:0x01c5, B:69:0x01d0, B:71:0x01d6, B:73:0x01ec, B:75:0x0220, B:74:0x020e, B:78:0x0268, B:80:0x027a, B:83:0x0294, B:86:0x029f, B:88:0x02a5, B:90:0x02c1, B:93:0x02ec, B:92:0x02df, B:95:0x0328, B:97:0x0334, B:100:0x033d, B:102:0x0343, B:104:0x0349, B:127:0x0424, B:107:0x0364, B:111:0x0376, B:113:0x0389, B:116:0x0392, B:118:0x0398, B:120:0x03b4, B:123:0x03df, B:122:0x03d2, B:54:0x0184, B:56:0x018e), top: B:139:0x0008 }] */
    @Override // com.github.catvod.crawler.Spider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        JSONArray jSONArray;
        String str3;
        int i;
        String str4;
        String str5;
        int iOptInt;
        JSONArray jSONArray2;
        int i2;
        String str6;
        String str7;
        JSONObject programs;
        int i3;
        String str8;
        String str9;
        String str10;
        String prefix;
        int i4;
        String str11;
        String prefix2;
        String str12;
        JSONArray jSONArray3;
        int iOptInt2;
        int i5;
        String str13;
        String str14;
        String str15;
        String str16;
        String prefix3;
        JSONObject jSONObjectBuildCategoryFilters;
        String str17;
        String str18;
        String str19;
        String str20;
        JSONArray jSONArray4;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray5 = new JSONArray();
            int i6 = Integer.parseInt(str2);
            String str21 = "seriesflag";
            String str22 = "1";
            String str23 = "0";
            String str24 = "code";
            String str25 = "";
            if (str.startsWith("epgcat_")) {
                str3 = "list";
                String strSubstring = str.substring(7);
                if (map != null) {
                    str17 = strSubstring;
                    str18 = map.get("epgsub");
                } else {
                    str17 = strSubstring;
                    str18 = null;
                }
                String str26 = (str18 == null || str18.isEmpty()) ? str17 : str18;
                JSONObject epgVodList = getEpgVodList(str26, (i6 - 1) * 20, 20);
                if (epgVodList != null) {
                    JSONArray jSONArrayOptJSONArray = epgVodList.optJSONArray("arr");
                    JSONArray jSONArray6 = jSONArray5;
                    int iMax = Math.max(1, (epgVodList.optInt("countTotal", 0) + 19) / 20);
                    if (jSONArrayOptJSONArray != null) {
                        int i7 = 0;
                        while (i7 < jSONArrayOptJSONArray.length()) {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i7);
                            int i8 = iMax;
                            String strOptString = jSONObject2.optString("isSitcom", str23);
                            JSONArray jSONArray7 = jSONArrayOptJSONArray;
                            String strOptString2 = jSONObject2.optString(str21, str23);
                            int i9 = i7;
                            String strOptString3 = jSONObject2.optString("vodId", str25);
                            String str27 = str23;
                            String strOptString4 = jSONObject2.optString("vodName", str25);
                            String str28 = str21;
                            String strOptString5 = jSONObject2.optString(str24, str25);
                            String str29 = str24;
                            String strOptString6 = jSONObject2.optString("picPath", str25);
                            if (strOptString4.isEmpty()) {
                                str20 = str25;
                                jSONArray4 = jSONArray6;
                            } else {
                                if ("1".equals(strOptString) || "1".equals(strOptString2)) {
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("childrenList");
                                    int length = jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.length() : 0;
                                    if (length > 0) {
                                        str19 = length + "集";
                                    } else {
                                        str19 = "连续剧";
                                    }
                                } else {
                                    str19 = str25;
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                StringBuilder sb = new StringBuilder();
                                str20 = str25;
                                sb.append("epg_");
                                sb.append(strOptString3);
                                sb.append("_");
                                sb.append(str26);
                                sb.append("_");
                                sb.append(strOptString5);
                                JSONObject jSONObjectPut = jSONObject3.put("vod_id", sb.toString()).put("vod_name", strOptString4).put("vod_pic", fixEpgImageUrl(strOptString6)).put("vod_remarks", str19);
                                jSONArray4 = jSONArray6;
                                jSONArray4.put(jSONObjectPut);
                            }
                            i7 = i9 + 1;
                            iMax = i8;
                            jSONArrayOptJSONArray = jSONArray7;
                            jSONArray6 = jSONArray4;
                            str23 = str27;
                            str21 = str28;
                            str24 = str29;
                            str25 = str20;
                        }
                    }
                    jSONArray = jSONArray6;
                    i4 = iMax;
                } else {
                    jSONArray = jSONArray5;
                    i4 = 1;
                }
                str6 = "pagecount";
                i = i6;
            } else {
                String str30 = "code";
                jSONArray = jSONArray5;
                String str31 = "0";
                String str32 = "";
                str3 = "list";
                String str33 = "seriesflag";
                String str34 = map != null ? map.get("sub") : null;
                if (str34 == null || str34.isEmpty()) {
                    Map<String, String> map2 = ZONE_DEFAULT_SUB;
                    if (map2.containsKey(str)) {
                        str34 = map2.get(str);
                    }
                }
                String str35 = " 连续剧";
                if (str34 == null || str34.isEmpty()) {
                    String str36 = " 连续剧";
                    i = i6;
                    String str37 = "1";
                    JSONObject programs2 = getPrograms(str, i);
                    if (programs2 != null) {
                        str4 = str3;
                        JSONArray jSONArrayOptJSONArray3 = programs2.optJSONArray(str4);
                        str5 = "pagecount";
                        iOptInt = programs2.optInt(str5, 1);
                        jSONArray2 = jSONArrayOptJSONArray3;
                    } else {
                        str4 = str3;
                        str5 = "pagecount";
                        iOptInt = 1;
                        jSONArray2 = null;
                    }
                    if (jSONArray2 == null || jSONArray2.length() <= 0) {
                        String str38 = str5;
                        i2 = iOptInt;
                        String str39 = str4;
                        JSONArray categories = getCategories(str);
                        if (categories == null || categories.length() <= 0) {
                            str6 = str38;
                            str7 = str39;
                        } else {
                            int i10 = i2;
                            int i11 = 0;
                            while (i11 < categories.length() && jSONArray.length() == 0) {
                                JSONObject jSONObject4 = categories.getJSONObject(i11);
                                JSONArray jSONArray8 = categories;
                                int i12 = i10;
                                String strOptString7 = jSONObject4.optString("primaryid", jSONObject4.optString(Name.MARK, str32));
                                if (strOptString7.isEmpty() || (programs = getPrograms(strOptString7, i)) == null) {
                                    str8 = str31;
                                    str9 = str38;
                                    str7 = str39;
                                    i3 = i11;
                                } else {
                                    String str40 = str39;
                                    JSONArray jSONArrayOptJSONArray4 = programs.optJSONArray(str40);
                                    i3 = i11;
                                    String str41 = str38;
                                    str7 = str40;
                                    int iOptInt3 = programs.optInt(str41, 1);
                                    if (jSONArrayOptJSONArray4 == null || jSONArrayOptJSONArray4.length() <= 0) {
                                        i12 = iOptInt3;
                                        str8 = str31;
                                        str9 = str41;
                                    } else {
                                        i2 = iOptInt3;
                                        int i13 = 0;
                                        while (i13 < jSONArrayOptJSONArray4.length()) {
                                            JSONObject jSONObject5 = jSONArrayOptJSONArray4.getJSONObject(i13);
                                            int i14 = i13;
                                            JSONArray jSONArray9 = jSONArrayOptJSONArray4;
                                            String str42 = str31;
                                            String str43 = str33;
                                            String str44 = str41;
                                            String strOptString8 = jSONObject5.optString(str43, str42);
                                            str33 = str43;
                                            String str45 = str37;
                                            if (str45.equals(strOptString8)) {
                                                StringBuilder sb2 = new StringBuilder();
                                                str37 = str45;
                                                sb2.append(getPrefix(jSONObject5.optString(str30, str32)));
                                                str10 = str36;
                                                sb2.append(str10);
                                                prefix = sb2.toString();
                                            } else {
                                                str37 = str45;
                                                str10 = str36;
                                                prefix = getPrefix(jSONObject5.optString(str30, str32));
                                            }
                                            str36 = str10;
                                            jSONArray.put(new JSONObject().put("vod_id", jSONObject5.optString(str30, str32)).put("vod_name", jSONObject5.optString("name", str32)).put("vod_pic", fixImageUrl(jSONObject5.optString("fileurl", jSONObject5.optString("poster", str32)))).put("vod_remarks", prefix));
                                            i13 = i14 + 1;
                                            jSONArrayOptJSONArray4 = jSONArray9;
                                            str41 = str44;
                                            str31 = str42;
                                        }
                                        str6 = str41;
                                    }
                                }
                                i10 = i12;
                                i11 = i3 + 1;
                                categories = jSONArray8;
                                str39 = str7;
                                str38 = str9;
                                str31 = str8;
                            }
                            i2 = i10;
                            str6 = str38;
                            str7 = str39;
                        }
                        jSONObject.put("page", i);
                        jSONObject.put(str6, i4);
                        jSONObject.put(str7, jSONArray);
                        if (i == 1 && (jSONObjectBuildCategoryFilters = buildCategoryFilters(str)) != null) {
                            jSONObject.put("filters", jSONObjectBuildCategoryFilters);
                        }
                        return jSONObject.toString();
                    }
                    String str46 = str5;
                    i2 = iOptInt;
                    int i15 = 0;
                    while (i15 < jSONArray2.length()) {
                        JSONObject jSONObject6 = jSONArray2.getJSONObject(i15);
                        int i16 = i15;
                        String str47 = str4;
                        JSONArray jSONArray10 = jSONArray2;
                        String str48 = str31;
                        String str49 = str33;
                        String strOptString9 = jSONObject6.optString(str49, str48);
                        str33 = str49;
                        String str50 = str37;
                        if (str50.equals(strOptString9)) {
                            StringBuilder sb3 = new StringBuilder();
                            str37 = str50;
                            sb3.append(getPrefix(jSONObject6.optString(str30, str32)));
                            str11 = str36;
                            sb3.append(str11);
                            prefix2 = sb3.toString();
                        } else {
                            str37 = str50;
                            str11 = str36;
                            prefix2 = getPrefix(jSONObject6.optString(str30, str32));
                        }
                        str36 = str11;
                        str31 = str48;
                        jSONArray.put(new JSONObject().put("vod_id", jSONObject6.optString(str30, str32)).put("vod_name", jSONObject6.optString("name", str32)).put("vod_pic", fixImageUrl(jSONObject6.optString("fileurl", jSONObject6.optString("poster", str32)))).put("vod_remarks", prefix2));
                        i15 = i16 + 1;
                        jSONArray2 = jSONArray10;
                        str4 = str47;
                    }
                    str6 = str46;
                    str7 = str4;
                    i4 = i2;
                    jSONObject.put("page", i);
                    jSONObject.put(str6, i4);
                    jSONObject.put(str7, jSONArray);
                    if (i == 1) {
                        jSONObject.put("filters", jSONObjectBuildCategoryFilters);
                    }
                    return jSONObject.toString();
                }
                i = i6;
                JSONObject programs3 = getPrograms(str34, i);
                if (programs3 != null) {
                    JSONArray jSONArrayOptJSONArray5 = programs3.optJSONArray(str3);
                    str12 = "pagecount";
                    iOptInt2 = programs3.optInt(str12, 1);
                    jSONArray3 = jSONArrayOptJSONArray5;
                } else {
                    str12 = "pagecount";
                    jSONArray3 = null;
                    iOptInt2 = 1;
                }
                if (jSONArray3 == null || jSONArray3.length() <= 0) {
                    i5 = iOptInt2;
                    str13 = str12;
                } else {
                    i5 = iOptInt2;
                    str13 = str12;
                    int i17 = 0;
                    while (i17 < jSONArray3.length()) {
                        JSONObject jSONObject7 = jSONArray3.getJSONObject(i17);
                        JSONArray jSONArray11 = jSONArray3;
                        int i18 = i17;
                        String str51 = str31;
                        String str52 = str33;
                        if (str22.equals(jSONObject7.optString(str52, str51))) {
                            StringBuilder sb4 = new StringBuilder();
                            str33 = str52;
                            str31 = str51;
                            str14 = str22;
                            str15 = str30;
                            str16 = str32;
                            sb4.append(getPrefix(jSONObject7.optString(str15, str16)));
                            sb4.append(str35);
                            prefix3 = sb4.toString();
                        } else {
                            str33 = str52;
                            str31 = str51;
                            str14 = str22;
                            str15 = str30;
                            str16 = str32;
                            prefix3 = getPrefix(jSONObject7.optString(str15, str16));
                        }
                        jSONArray.put(new JSONObject().put("vod_id", jSONObject7.optString(str15, str16)).put("vod_name", jSONObject7.optString("name", str16)).put("vod_pic", fixImageUrl(jSONObject7.optString("fileurl", jSONObject7.optString("poster", str16)))).put("vod_remarks", prefix3));
                        i17 = i18 + 1;
                        str32 = str16;
                        str30 = str15;
                        str22 = str14;
                        str35 = str35;
                        jSONArray3 = jSONArray11;
                    }
                }
                i4 = i5;
                str6 = str13;
            }
            str7 = str3;
            jSONObject.put("page", i);
            jSONObject.put(str6, i4);
            jSONObject.put(str7, jSONArray);
            if (i == 1) {
            }
            return jSONObject.toString();
        } catch (Exception unused) {
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String homeContent(boolean z) {
        String str;
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray rootCategories = getRootCategories();
            if (rootCategories != null) {
                str = "";
                str2 = str;
                for (int i = 0; i < rootCategories.length(); i++) {
                    JSONObject jSONObject2 = rootCategories.getJSONObject(i);
                    String strOptString = jSONObject2.optString("primaryid", jSONObject2.optString(Name.MARK, ""));
                    String strOptString2 = jSONObject2.optString("name", "");
                    if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                        if (strOptString2.contains("付费")) {
                            str2 = strOptString2;
                            str = strOptString;
                        } else {
                            jSONArray.put(new JSONObject().put("type_id", strOptString).put("type_name", strOptString2));
                        }
                    }
                }
            } else {
                str = "";
                str2 = str;
            }
            if (!str.isEmpty()) {
                jSONArray.put(new JSONObject().put("type_id", str).put("type_name", str2));
            }
            String[][] strArr = {new String[]{"1032", "腾讯专区"}, new String[]{"1035", "优酷专区"}, new String[]{"1024", "短视频"}, new String[]{"1025", "短视频2"}};
            for (int i2 = 0; i2 < 4; i2++) {
                String[] strArr2 = strArr[i2];
                jSONArray.put(new JSONObject().put("type_id", strArr2[0]).put("type_name", strArr2[1]));
            }
            JSONArray epgCategories = getEpgCategories(this.topCatId);
            if (epgCategories != null) {
                for (int i3 = 0; i3 < epgCategories.length(); i3++) {
                    JSONObject jSONObject3 = epgCategories.getJSONObject(i3);
                    String strOptString3 = jSONObject3.optString("typeId", "");
                    String strOptString4 = jSONObject3.optString("typeName", jSONObject3.optString("subTypeName", ""));
                    if (!strOptString3.isEmpty() && !strOptString4.isEmpty() && !strOptString4.contains("测试") && !strOptString4.contains("两会") && !strOptString4.contains("春晚") && !strOptString4.contains("跨年") && !strOptString4.contains("精品推荐") && !strOptString4.contains("爱看精彩")) {
                        String str3 = "epgcat_" + strOptString3;
                        jSONArray.put(new JSONObject().put("type_id", str3).put("type_name", "EPG" + strOptString4));
                        this.cache.put("epgname_" + str3, strOptString4);
                    }
                }
            }
            jSONObject.put(Name.LABEL, jSONArray);
            jSONObject.put("list", new JSONArray());
            if (!this.searchIndexBuilt) {
                loadSearchIndex();
                loadIndexIcon();
                this.searchIndexBuilt = true;
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"class\":[],\"list\":[]}";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061 A[Catch: Exception -> 0x0174, TryCatch #3 {Exception -> 0x0174, blocks: (B:15:0x0055, B:17:0x0061, B:19:0x006c, B:20:0x0072, B:22:0x0078, B:23:0x007e, B:25:0x0084, B:26:0x008a, B:28:0x0090, B:29:0x0096, B:31:0x009c, B:32:0x00a2, B:34:0x00a8, B:35:0x00ae, B:37:0x00b4, B:38:0x00ba, B:40:0x00c0, B:41:0x00c6, B:43:0x00cc, B:44:0x00d2, B:46:0x00d8, B:47:0x00e0, B:49:0x00e6, B:50:0x00ec, B:52:0x00f4, B:53:0x00fc, B:55:0x0104, B:56:0x010a, B:58:0x0112, B:59:0x011a, B:61:0x0122, B:62:0x0128, B:64:0x0130, B:65:0x0136, B:67:0x013e, B:68:0x0145, B:70:0x014f, B:71:0x0154, B:73:0x0158, B:74:0x015c, B:76:0x0160, B:77:0x0164, B:79:0x0168, B:80:0x016c, B:82:0x0170), top: B:95:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0145 A[Catch: Exception -> 0x0174, TryCatch #3 {Exception -> 0x0174, blocks: (B:15:0x0055, B:17:0x0061, B:19:0x006c, B:20:0x0072, B:22:0x0078, B:23:0x007e, B:25:0x0084, B:26:0x008a, B:28:0x0090, B:29:0x0096, B:31:0x009c, B:32:0x00a2, B:34:0x00a8, B:35:0x00ae, B:37:0x00b4, B:38:0x00ba, B:40:0x00c0, B:41:0x00c6, B:43:0x00cc, B:44:0x00d2, B:46:0x00d8, B:47:0x00e0, B:49:0x00e6, B:50:0x00ec, B:52:0x00f4, B:53:0x00fc, B:55:0x0104, B:56:0x010a, B:58:0x0112, B:59:0x011a, B:61:0x0122, B:62:0x0128, B:64:0x0130, B:65:0x0136, B:67:0x013e, B:68:0x0145, B:70:0x014f, B:71:0x0154, B:73:0x0158, B:74:0x015c, B:76:0x0160, B:77:0x0164, B:79:0x0168, B:80:0x016c, B:82:0x0170), top: B:95:0x0055 }] */
    @Override // com.github.catvod.crawler.Spider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void init(Context context, String str) {
        String str2;
        String str3;
        File filesDir;
        super.init(context, str);
        try {
            filesDir = context.getFilesDir();
        } catch (Exception unused) {
        }
        if (filesDir != null) {
            str2 = "sdmsSearchHost";
            try {
                str3 = "imgPort";
                try {
                    this.indexFilePath = new File(filesDir, "hw_search_index.txt").getAbsolutePath();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                str3 = "imgPort";
            }
            if (str != null && !str.isEmpty()) {
                try {
                    if (str.trim().startsWith("{")) {
                        String[] strArrSplit = str.split("\\$");
                        if (strArrSplit.length >= 1) {
                            this.encryptKey = strArrSplit[0];
                        }
                        if (strArrSplit.length >= 2) {
                            this.userId = strArrSplit[1];
                        }
                        if (strArrSplit.length >= 3) {
                            this.stbId = strArrSplit[2];
                        }
                        if (strArrSplit.length >= 4) {
                            this.mac = strArrSplit[3];
                        }
                        if (strArrSplit.length >= 5) {
                            this.stbType = strArrSplit[4];
                        }
                    } else {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("edsServer")) {
                            this.edsServer = jSONObject.getString("edsServer");
                        }
                        if (jSONObject.has("encryptKey")) {
                            this.encryptKey = jSONObject.getString("encryptKey");
                        }
                        if (jSONObject.has("userId")) {
                            this.userId = jSONObject.getString("userId");
                        }
                        if (jSONObject.has("stbId")) {
                            this.stbId = jSONObject.getString("stbId");
                        }
                        if (jSONObject.has("mac")) {
                            this.mac = jSONObject.getString("mac");
                        }
                        if (jSONObject.has("stbType")) {
                            this.stbType = jSONObject.getString("stbType");
                        }
                        if (jSONObject.has("stbVersion")) {
                            this.stbVersion = jSONObject.getString("stbVersion");
                        }
                        if (jSONObject.has("interfaceSuffix")) {
                            this.interfaceSuffix = jSONObject.getString("interfaceSuffix");
                        }
                        if (jSONObject.has("sdmsHost")) {
                            this.sdmsHost = jSONObject.getString("sdmsHost");
                        }
                        if (jSONObject.has("sdmsPort")) {
                            this.sdmsPort = jSONObject.optInt("sdmsPort", this.sdmsPort);
                        }
                        if (jSONObject.has("imgHost")) {
                            this.imgHost = jSONObject.getString("imgHost");
                        }
                        String str4 = str3;
                        if (jSONObject.has(str4)) {
                            this.imgPort = jSONObject.optInt(str4, this.imgPort);
                        }
                        String str5 = str2;
                        if (jSONObject.has(str5)) {
                            this.sdmsSearchHost = jSONObject.getString(str5);
                        }
                        if (jSONObject.has("sdmsSearchPort")) {
                            this.sdmsSearchPort = jSONObject.optInt("sdmsSearchPort", this.sdmsSearchPort);
                        }
                        if (jSONObject.has("sdmsSearchTime")) {
                            this.sdmsSearchTime = jSONObject.getString("sdmsSearchTime");
                        }
                        if (jSONObject.has("sdmsSearchRiddle")) {
                            this.sdmsSearchRiddle = jSONObject.getString("sdmsSearchRiddle");
                        }
                        if (jSONObject.has("topCatId")) {
                            this.topCatId = jSONObject.getString("topCatId");
                        }
                    }
                } catch (Exception unused4) {
                }
            }
            CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
            this.cookieManager = cookieManager;
            CookieHandler.setDefault(cookieManager);
            new Thread(new Runnable() { // from class: zb1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.lambda$init$2();
                }
            }).start();
        }
        str2 = "sdmsSearchHost";
        str3 = "imgPort";
        if (str != null) {
            if (str.trim().startsWith("{")) {
            }
        }
        CookieManager cookieManager2 = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        this.cookieManager = cookieManager2;
        CookieHandler.setDefault(cookieManager2);
        new Thread(new Runnable() { // from class: zb1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.lambda$init$2();
            }
        }).start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String playerContent(String str, String str2, List<String> list) {
        int i;
        String playUrlHk;
        try {
            try {
                if ("__start_update__".equals(str2)) {
                    if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                        new Thread(new Runnable() { // from class: dc1
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f.lambda$playerContent$6();
                            }
                        }).start();
                        return new JSONObject().put("parse", 0).put("url", "").put("msg", "索引更新已启动，当前" + this.searchIndex.size() + "部，更新后自动保存").toString();
                    }
                    new Thread(new Runnable() { // from class: cc1
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.lambda$playerContent$5();
                        }
                    }).start();
                    return new JSONObject().put("parse", 0).put("url", "").put("msg", "索引更新已启动，请稍候...返回首页可查看进度").toString();
                }
                String strSubstring = str2.startsWith("hk_") ? str2.substring(3) : str2;
                if (str2.startsWith("epg_")) {
                    strSubstring = str2.substring(4);
                }
                if (isSdk(strSubstring.contains("_") ? strSubstring.split("_")[strSubstring.split("_").length - 1] : strSubstring)) {
                    JSONObject jSONObjectPut = new JSONObject().put("parse", 1).put("url", "");
                    StringBuilder sb = new StringBuilder("SDK节目: ");
                    if (strSubstring.contains("_")) {
                        strSubstring = strSubstring.split("_")[strSubstring.split("_").length - 1];
                    }
                    sb.append(getPrefix(strSubstring));
                    return jSONObjectPut.put("msg", sb.toString()).toString();
                }
                ensureAlive();
                if (str2.startsWith("epg_")) {
                    String[] strArrSplit = strSubstring.split("_");
                    String str3 = strArrSplit.length >= 1 ? strArrSplit[0] : "";
                    String str4 = strArrSplit.length >= 2 ? strArrSplit[1] : "";
                    i = 2;
                    String str5 = strArrSplit.length >= 3 ? strArrSplit[2] : "";
                    playUrlHk = getPlayUrlEpg(str3, str4);
                    if (playUrlHk == null && !str5.isEmpty()) {
                        playUrlHk = getPlayUrlHk(str5);
                    }
                } else {
                    i = 2;
                    playUrlHk = getPlayUrlHk(strSubstring);
                }
                if (playUrlHk == null) {
                    stopHeartbeat();
                    this.authed = false;
                    this.cookieManager.getCookieStore().removeAll();
                    if (login()) {
                        if (str2.startsWith("epg_")) {
                            String[] strArrSplit2 = strSubstring.split("_");
                            String str6 = strArrSplit2.length >= 1 ? strArrSplit2[0] : "";
                            int i2 = i;
                            String str7 = strArrSplit2.length >= i2 ? strArrSplit2[1] : "";
                            String str8 = strArrSplit2.length >= 3 ? strArrSplit2[i2] : "";
                            String playUrlEpg = getPlayUrlEpg(str6, str7);
                            playUrlHk = (playUrlEpg != null || str8.isEmpty()) ? playUrlEpg : getPlayUrlHk(str8);
                        } else {
                            playUrlHk = getPlayUrlHk(strSubstring);
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parse", 0);
                jSONObject.put("url", playUrlHk != null ? playUrlHk : "");
                jSONObject.put("header", "");
                if (playUrlHk == null) {
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 3 */
    @Override // com.github.catvod.crawler.Spider
    public String searchContent(String str, boolean z) {
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        JSONArray jSONArray2;
        String str6;
        String strOptString;
        String strOptString2;
        String str7;
        String prefix;
        JSONArray jSONArray3;
        String str8;
        String str9;
        String str10;
        String str11;
        int i;
        JSONArray jSONArray4;
        JSONObject jSONObject;
        String strOptString3;
        String strOptString4;
        String strOptString5;
        String str12;
        String strOptString6;
        String strOptString7;
        String strOptString8;
        StringBuilder sb;
        String string;
        String value;
        String str13;
        try {
            JSONArray jSONArray5 = new JSONArray();
            String lowerCase = str.toLowerCase();
            boolean zMatches = lowerCase.matches("^[a-z0-9]+$");
            String str14 = "vod_remarks";
            if (this.searchIndexBuilt && !this.searchIndex.isEmpty()) {
                for (Map.Entry<String, String> entry : this.searchIndex.entrySet()) {
                    if (entry.getKey().contains(lowerCase)) {
                        String value2 = entry.getValue();
                        String key = entry.getKey();
                        jSONArray5.put(new JSONObject().put("vod_id", value2).put("vod_name", key).put("vod_pic", getSearchPic(value2)).put("vod_remarks", getPrefix(value2)));
                        if (jSONArray5.length() >= 50) {
                            break;
                        }
                    }
                }
                if (zMatches && jSONArray5.length() < 50) {
                    for (Map.Entry<String, String> entry2 : this.pinyinIndex.entrySet()) {
                        if (entry2.getKey().contains(lowerCase) && (str13 = this.searchIndex.get((value = entry2.getValue()))) != null && !str13.isEmpty()) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= jSONArray5.length()) {
                                    jSONArray5.put(new JSONObject().put("vod_id", str13).put("vod_name", value).put("vod_pic", getSearchPic(str13)).put("vod_remarks", getPrefix(str13)));
                                    if (jSONArray5.length() >= 50) {
                                        break;
                                    }
                                } else {
                                    if (jSONArray5.getJSONObject(i2).optString("vod_id", "").equals(str13)) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                }
            }
            String str15 = " 连续剧";
            String str16 = "1";
            String str17 = "code";
            if (this.epgHost != null) {
                JSONArray jSONArraySearchEpg = searchEpg(str);
                int i3 = 0;
                while (i3 < jSONArraySearchEpg.length()) {
                    JSONArray jSONArray6 = jSONArray5;
                    if (jSONArray5.length() >= 80) {
                        str2 = str15;
                        str3 = str16;
                        str4 = str14;
                        str5 = str17;
                        jSONArray = jSONArray6;
                        break;
                    }
                    try {
                        jSONObject = jSONArraySearchEpg.getJSONObject(i3);
                        strOptString3 = jSONObject.optString(str17, "");
                        jSONArray3 = jSONArraySearchEpg;
                    } catch (Exception unused) {
                        jSONArray3 = jSONArraySearchEpg;
                    }
                    try {
                        strOptString4 = jSONObject.optString("vodName", "");
                        i = i3;
                        try {
                            strOptString5 = jSONObject.optString("vodId", "");
                            str11 = str17;
                            str12 = str14;
                            try {
                                strOptString6 = jSONObject.optString("TYPEID", jSONObject.optString("rootTypeId", ""));
                                strOptString7 = jSONObject.optString("picPath", "");
                                strOptString8 = jSONObject.optString("seriesflag", "0");
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                            str8 = str15;
                            str9 = str16;
                            str10 = str14;
                            str11 = str17;
                        }
                    } catch (Exception unused4) {
                        str8 = str15;
                        str9 = str16;
                        str10 = str14;
                        str11 = str17;
                        i = i3;
                        jSONArray4 = jSONArray6;
                        i3 = i + 1;
                        jSONArray5 = jSONArray4;
                        str14 = str10;
                        jSONArraySearchEpg = jSONArray3;
                        str17 = str11;
                        str16 = str9;
                        str15 = str8;
                    }
                    if (strOptString4.isEmpty()) {
                        str8 = str15;
                        str9 = str16;
                    } else {
                        if (str16.equals(strOptString8)) {
                            try {
                                sb = new StringBuilder();
                                str9 = str16;
                            } catch (Exception unused5) {
                                str9 = str16;
                                str8 = str15;
                            }
                            try {
                                sb.append(getPrefix(strOptString3));
                                sb.append(str15);
                                string = sb.toString();
                            } catch (Exception unused6) {
                                str8 = str15;
                            }
                        } else {
                            str9 = str16;
                            string = getPrefix(strOptString3);
                        }
                        StringBuilder sb2 = new StringBuilder();
                        str8 = str15;
                        try {
                            sb2.append("epg_");
                            sb2.append(strOptString5);
                            sb2.append("_");
                            sb2.append(strOptString6);
                            sb2.append("_");
                            sb2.append(strOptString3);
                            str10 = str12;
                            try {
                                JSONObject jSONObjectPut = new JSONObject().put("vod_id", sb2.toString()).put("vod_name", strOptString4).put("vod_pic", fixEpgImageUrl(strOptString7)).put(str10, string);
                                jSONArray4 = jSONArray6;
                                try {
                                    jSONArray4.put(jSONObjectPut);
                                } catch (Exception unused7) {
                                }
                            } catch (Exception unused8) {
                                jSONArray4 = jSONArray6;
                            }
                        } catch (Exception unused9) {
                            jSONArray4 = jSONArray6;
                            str10 = str12;
                        }
                        i3 = i + 1;
                        jSONArray5 = jSONArray4;
                        str14 = str10;
                        jSONArraySearchEpg = jSONArray3;
                        str17 = str11;
                        str16 = str9;
                        str15 = str8;
                    }
                    jSONArray4 = jSONArray6;
                    str10 = str12;
                    i3 = i + 1;
                    jSONArray5 = jSONArray4;
                    str14 = str10;
                    jSONArraySearchEpg = jSONArray3;
                    str17 = str11;
                    str16 = str9;
                    str15 = str8;
                }
                jSONArray = jSONArray5;
                str2 = str15;
                str3 = str16;
                str4 = str14;
                str5 = str17;
            } else {
                jSONArray = jSONArray5;
                str2 = str15;
                str3 = str16;
                str4 = str14;
                str5 = str17;
            }
            if (!this.searchIndexBuilt || this.searchIndex.isEmpty()) {
                JSONArray jSONArraySearchOnline = searchOnline(str);
                int i4 = 0;
                while (i4 < jSONArraySearchOnline.length() && jSONArray.length() < 80) {
                    try {
                        JSONObject jSONObject2 = jSONArraySearchOnline.getJSONObject(i4);
                        str6 = str5;
                        try {
                            strOptString = jSONObject2.optString(str6, jSONObject2.optString("telecomcode", ""));
                            strOptString2 = jSONObject2.optString("name", "");
                        } catch (Exception unused10) {
                        }
                        if (strOptString.isEmpty() || strOptString2.isEmpty()) {
                            jSONArray2 = jSONArraySearchOnline;
                        } else {
                            jSONArray2 = jSONArraySearchOnline;
                            String str18 = str3;
                            try {
                                if (str18.equals(jSONObject2.optString("seriesflag", "0"))) {
                                    StringBuilder sb3 = new StringBuilder();
                                    str3 = str18;
                                    try {
                                        sb3.append(getPrefix(strOptString));
                                        str7 = str2;
                                        try {
                                            sb3.append(str7);
                                            prefix = sb3.toString();
                                        } catch (Exception unused11) {
                                            str2 = str7;
                                        }
                                    } catch (Exception unused12) {
                                    }
                                } else {
                                    str3 = str18;
                                    str7 = str2;
                                    prefix = getPrefix(strOptString);
                                }
                                str2 = str7;
                                jSONArray.put(new JSONObject().put("vod_id", strOptString).put("vod_name", strOptString2).put("vod_pic", fixImageUrl(jSONObject2.optString("fileurl", jSONObject2.optString("poster", "")))).put(str4, prefix));
                            } catch (Exception unused13) {
                                str3 = str18;
                            }
                        }
                    } catch (Exception unused14) {
                        jSONArray2 = jSONArraySearchOnline;
                        str6 = str5;
                    }
                    i4++;
                    jSONArraySearchOnline = jSONArray2;
                    str5 = str6;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("list", jSONArray);
            return jSONObject3.toString();
        } catch (Exception unused15) {
            return "{\"list\":[]}";
        }
    }
}
