package defpackage;

import com.fongmi.android.tv.bean.Catchup;
import com.fongmi.android.tv.bean.Channel;
import com.fongmi.android.tv.bean.ClearKey;
import com.fongmi.android.tv.bean.Drm;
import com.fongmi.android.tv.bean.Group;
import com.fongmi.android.tv.bean.Live;
import com.github.catvod.utils.Json;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.HTTP;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zx1 {
    public static final Pattern a = Pattern.compile("^(?!.*#genre#).*#EXTM3U.*", 8);
    public static final Pattern b = Pattern.compile(".*http-user-agent=\"(.?|.+?)\".*");
    public static final Pattern c = Pattern.compile(".*catchup-replace=\"(.?|.+?)\".*");
    public static final Pattern d = Pattern.compile(".*catchup-source=\"(.?|.+?)\".*");
    public static final Pattern e = Pattern.compile(".*catchup=\"(.?|.+?)\".*");
    public static final Pattern f = Pattern.compile(".*tvg-chno=\"(.?|.+?)\".*");
    public static final Pattern g = Pattern.compile(".*tvg-logo=\"(.?|.+?)\".*");
    public static final Pattern h = Pattern.compile(".*tvg-name=\"(.?|.+?)\".*");
    public static final Pattern i = Pattern.compile(".*tvg-url=\"(.?|.+?)\".*");
    public static final Pattern j = Pattern.compile(".*tvg-id=\"(.?|.+?)\".*");
    public static final Pattern k = Pattern.compile(".*url-tvg=\"(.?|.+?)\".*");
    public static final Pattern l = Pattern.compile(".*group-title=\"(.?|.+?)\".*");
    public static final Pattern m = Pattern.compile(".*,(.+?)$");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public Integer h;
        public boolean i;
        public Map j = new HashMap();
        public Map k = new HashMap();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a k() {
            return new a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void A(String str) {
            try {
                if (str.contains("license_type=")) {
                    str = str.split("license_type=")[1].trim();
                }
                this.c = str;
            } catch (Exception e) {
                e.printStackTrace();
                this.c = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void B(String str) {
            try {
                if (str.contains("user-agent=")) {
                    this.a = str.split("(?i)user-agent=")[1].trim().replace("\"", "");
                }
                if (str.contains("ua=")) {
                    this.a = str.split("ua=")[1].trim().replace("\"", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.a = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void g(String str) {
            if (str.startsWith("ua")) {
                B(str);
                return;
            }
            if (str.startsWith("parse")) {
                x(str);
                return;
            }
            if (str.startsWith("click")) {
                i(str);
                return;
            }
            if (str.startsWith("header")) {
                q(str);
                return;
            }
            if (str.startsWith("format")) {
                p(str);
                return;
            }
            if (str.startsWith("origin")) {
                w(str);
                return;
            }
            if (str.startsWith("referer")) {
                y(str);
                return;
            }
            if (str.startsWith("#EXTHTTP:")) {
                q(str);
                return;
            }
            if (str.startsWith("forceKey")) {
                o(str);
                return;
            }
            if (str.startsWith("#EXTVLCOPT:http-origin")) {
                w(str);
                return;
            }
            if (str.startsWith("#EXTVLCOPT:http-user-agent")) {
                B(str);
                return;
            }
            if (str.startsWith("#EXTVLCOPT:http-referrer")) {
                z(str);
                return;
            }
            if (str.startsWith("#KODIPROP:inputstream.adaptive.license_key")) {
                u(str);
                return;
            }
            if (str.startsWith("#KODIPROP:inputstream.adaptive.license_type")) {
                A(str);
                return;
            }
            if (str.startsWith("#KODIPROP:inputstream.adaptive.drm_legacy")) {
                m(str);
                return;
            }
            if (str.startsWith("#KODIPROP:inputstream.adaptive.manifest_type")) {
                p(str);
            } else if (str.startsWith("#KODIPROP:inputstream.adaptive.stream_headers")) {
                r(str);
            } else if (str.startsWith("#KODIPROP:inputstream.adaptive.common_headers")) {
                r(str);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.h = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.i = false;
            this.j = new HashMap();
            this.k = new HashMap();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void i(String str) {
            try {
                this.d = str.split("click=")[1].trim();
            } catch (Exception e) {
                e.printStackTrace();
                this.d = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final a j(Channel channel) {
            String str;
            String str2 = this.a;
            if (str2 != null) {
                channel.setUa(str2);
            }
            Integer num = this.h;
            if (num != null) {
                channel.setParse(num);
            }
            String str3 = this.d;
            if (str3 != null) {
                channel.setClick(str3);
            }
            String str4 = this.e;
            if (str4 != null) {
                channel.setFormat(str4);
            }
            String str5 = this.f;
            if (str5 != null) {
                channel.setOrigin(str5);
            }
            String str6 = this.g;
            if (str6 != null) {
                channel.setReferer(str6);
            }
            if (!this.j.isEmpty()) {
                channel.setHeader(this.j);
            }
            String str7 = this.b;
            if (str7 != null && (str = this.c) != null) {
                channel.setDrm(Drm.create(str7, str, this.k, this.i));
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void l(String str) {
            try {
                if (!str.contains("|")) {
                    s(this.k, str.trim().split("&"));
                    return;
                }
                for (String str2 : str.split("\\|")) {
                    l(str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void m(String str) {
            try {
                String[] strArrSplit = str.split("drm_legacy=")[1].trim().split("\\|", 2);
                A(strArrSplit[0].trim());
                u(strArrSplit[1].trim());
            } catch (Exception e) {
                e.printStackTrace();
                this.c = null;
                this.b = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean n(String str) {
            return str.startsWith("ua") || str.startsWith("parse") || str.startsWith("click") || str.startsWith("header") || str.startsWith("format") || str.startsWith("origin") || str.startsWith("referer") || str.startsWith("forceKey") || str.startsWith("#EXTHTTP:") || str.startsWith("#EXTVLCOPT:") || str.startsWith("#KODIPROP:");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void o(String str) {
            try {
                this.i = Boolean.parseBoolean(str.split("forceKey=")[1].trim());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void p(String str) {
            try {
                if (str.startsWith("format=")) {
                    this.e = str.split("format=")[1].trim();
                }
                if (str.contains("manifest_type=")) {
                    this.e = str.split("manifest_type=")[1].trim();
                }
                if ("mpd".equals(this.e) || "dash".equals(this.e)) {
                    this.e = "application/dash+xml";
                }
                if ("hls".equals(this.e)) {
                    this.e = "application/x-mpegURL";
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.e = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void q(String str) {
            try {
                if (str.contains("#EXTHTTP:")) {
                    this.j.putAll(Json.toMap(Json.parse(str.split("#EXTHTTP:")[1].trim())));
                }
                if (str.contains("header=")) {
                    this.j.putAll(Json.toMap(Json.parse(str.split("header=")[1].trim())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void r(String str) {
            try {
                if (str.contains("headers=")) {
                    s(this.j, str.split("headers=")[1].trim().split("&"));
                    return;
                }
                if (!str.contains("|")) {
                    s(this.j, str.trim().split("&"));
                    return;
                }
                for (String str2 : str.split("\\|")) {
                    r(str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void s(Map map, String[] strArr) {
            for (String str : strArr) {
                if (str.contains("=")) {
                    String[] strArrSplit = str.split("=", 2);
                    String strReplace = strArrSplit[0].trim().replace("\"", "");
                    String strReplace2 = strArrSplit[1].trim().replace("\"", "");
                    if ("drmScheme".equals(strReplace)) {
                        A(strReplace2);
                    } else if ("drmLicense".equals(strReplace)) {
                        u(strReplace2);
                    } else {
                        map.put(strReplace, strReplace2);
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void t() {
            String[] strArrSplit = this.b.split("\\|", 2);
            if (strArrSplit.length > 1) {
                l(strArrSplit[1]);
            }
            this.b = strArrSplit[0].trim();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void u(String str) {
            try {
                if (str.contains("license_key=")) {
                    str = str.split("license_key=")[1].trim();
                }
                this.b = str;
                if (str.startsWith("http")) {
                    t();
                } else {
                    v();
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.b = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void v() {
            try {
                ClearKey.objectFrom(this.b);
            } catch (Exception unused) {
                this.b = ClearKey.get(this.b.replace("\"", "").replace("{", "").replace("}", "")).toString();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void w(String str) {
            try {
                this.f = str.split("(?i)origin=")[1].trim();
            } catch (Exception e) {
                e.printStackTrace();
                this.f = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void x(String str) {
            try {
                this.h = Integer.valueOf(Integer.parseInt(str.split("parse=")[1].trim()));
            } catch (Exception e) {
                e.printStackTrace();
                this.h = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void y(String str) {
            try {
                this.g = str.split("(?i)referer=")[1].trim().replace("\"", "");
            } catch (Exception e) {
                e.printStackTrace();
                this.g = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void z(String str) {
            try {
                this.g = str.split("(?i)referrer=")[1].trim().replace("\"", "");
            } catch (Exception e) {
                e.printStackTrace();
                this.g = null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(Live live) {
        Iterator<Group> it = live.getGroups().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            for (Channel channel : it.next().trans().getChannel()) {
                if (channel.getNumber().isEmpty()) {
                    i2++;
                    channel.setNumber(i2);
                }
                channel.trans().live(live);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String b(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str.trim());
        return matcher.matches() ? matcher.group(1).trim() : "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c(String str, String... strArr) {
        for (String str2 : str.split(" ")) {
            for (String str3 : strArr) {
                if (str2.contains(str3)) {
                    return str2.split("=")[1].replace("\"", "");
                }
            }
        }
        return "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String d(Live live) {
        return !live.getApi().isEmpty() ? live.spider().liveContent(live.getUrl()) : q53.F(qx4.a(live.getUrl()), live.getHeaders());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(Live live, String str) {
        live.getGroups().addAll(Group.arrayFrom(str));
        a(live);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(Live live, String str) {
        a aVarK = a.k();
        Catchup catchupCreate = Catchup.create();
        Channel channelCreate = Channel.create("");
        for (String str2 : str.replace(HTTP.CRLF, "\n").replace("\r", "").split("\n")) {
            if (Thread.interrupted()) {
                return;
            }
            if (aVarK.n(str2)) {
                aVarK.g(str2);
            } else if (str2.startsWith("#EXTM3U")) {
                catchupCreate.setType(b(str2, e));
                catchupCreate.setSource(b(str2, d));
                catchupCreate.setReplace(b(str2, c));
                if (live.getEpg().isEmpty()) {
                    live.setEpg(b(str2, i).replace("\"", ""));
                }
                if (live.getEpg().isEmpty()) {
                    live.setEpg(b(str2, k).replace("\"", ""));
                }
                if (live.getEpg().isEmpty()) {
                    live.setEpg(c(str2, "tvg-url=", "url-tvg="));
                }
            } else if (str2.startsWith("#EXTINF:")) {
                channelCreate = live.find(Group.create(b(str2, l), live.isPass())).find(Channel.create(b(str2, m)));
                channelCreate.setUa(b(str2, b));
                channelCreate.setTvgName(b(str2, h));
                channelCreate.setNumber(b(str2, f));
                channelCreate.setLogo(b(str2, g));
                channelCreate.setTvgId(b(str2, j));
                Catchup catchupCreate2 = Catchup.create();
                catchupCreate2.setType(b(str2, e));
                catchupCreate2.setSource(b(str2, d));
                catchupCreate2.setReplace(b(str2, c));
                channelCreate.setCatchup(Catchup.decide(catchupCreate2, catchupCreate));
            } else if (!str2.startsWith("#") && str2.contains("://")) {
                String[] strArrSplit = str2.split("\\|", 2);
                if (strArrSplit.length > 1) {
                    aVarK.r(strArrSplit[1]);
                }
                channelCreate.getUrls().add(strArrSplit[0]);
                aVarK.j(channelCreate).h();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g(Live live) {
        if (live.getGroups().isEmpty()) {
            String strD = d(live);
            if (Json.isArray(strD)) {
                e(live, strD);
            } else {
                h(live, strD);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(Live live, String str) {
        if (live.getGroups().isEmpty()) {
            if (a.matcher(str).find()) {
                f(live, str);
            } else {
                i(live, str);
            }
            a(live);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void i(Live live, String str) {
        a aVarK = a.k();
        for (String str2 : str.replace(HTTP.CRLF, "\n").replace("\r", "").split("\n")) {
            if (Thread.interrupted()) {
                return;
            }
            String[] strArrSplit = str2.split(",", 2);
            if (aVarK.n(str2)) {
                aVarK.g(str2);
            }
            if (str2.contains("#genre#")) {
                aVarK.h();
            }
            if (str2.contains("#genre#")) {
                live.getGroups().add(Group.create(strArrSplit[0], live.isPass()));
            }
            if (strArrSplit.length > 1 && live.getGroups().isEmpty()) {
                live.getGroups().add(Group.create());
            }
            if (strArrSplit.length > 1 && strArrSplit[1].contains("://")) {
                Channel channelFind = live.getGroups().get(live.getGroups().size() - 1).find(Channel.create(strArrSplit[0]));
                for (String str3 : strArrSplit[1].split("#")) {
                    String[] strArrSplit2 = str3.split("\\|", 2);
                    if (strArrSplit2.length > 1) {
                        aVarK.r(strArrSplit2[1]);
                    }
                    channelFind.getUrls().add(strArrSplit2[0]);
                    aVarK.j(channelFind);
                }
            }
        }
    }
}
