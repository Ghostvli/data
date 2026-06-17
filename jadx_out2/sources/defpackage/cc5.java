package defpackage;

import defpackage.di1;
import defpackage.k2;
import defpackage.p83;
import fi.iki.elonen.NanoHTTPD;
import j$.util.stream.DesugarCollectors;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class cc5 {
    public static String a;
    public static boolean b;
    public static Optional c = Optional.empty();
    public static final String[] d = {"INNERTUBE_CONTEXT_CLIENT_VERSION\":\"([0-9\\.]+?)\"", "innertube_context_client_version\":\"([0-9\\.]+?)\"", "client.version=([0-9\\.]+)"};
    public static final String[] e = {"window\\[\"ytInitialData\"\\]\\s*=\\s*(\\{.*?\\});", "var\\s*ytInitialData\\s*=\\s*(\\{.*?\\});"};
    public static Random f = new Random();
    public static final Pattern g = Pattern.compile("&c=WEB");
    public static final Pattern h = Pattern.compile("&c=WEB_EMBEDDED_PLAYER");
    public static final Pattern i = Pattern.compile("&c=ANDROID");
    public static final Pattern j = Pattern.compile("&c=IOS");
    public static final Set k = v85.a(new Object[]{"google.", "m.google.", "www.google."});
    public static final Set l = v85.a(new String[]{"invidio.us", "dev.invidio.us", "www.invidio.us", "redirect.invidious.io", "invidious.snopyta.org", "yewtu.be", "tube.connect.cafe", "tubus.eduvid.org", "invidious.kavin.rocks", "invidious.site", "invidious-us.kavin.rocks", "piped.kavin.rocks", "vid.mint.lgbt", "invidiou.site", "invidious.fdn.fr", "invidious.048596.xyz", "invidious.zee.li", "vid.puffyan.us", "ytprivate.com", "invidious.namazso.eu", "invidious.silkky.cloud", "ytb.trom.tf", "invidious.exonip.de", "inv.riverside.rocks", "invidious.blamefran.net", "y.com.cm", "invidious.moomoo.me", "yt.cyberhost.uk"});
    public static final Set m = v85.a(new Object[]{"youtube.com", "www.youtube.com", "m.youtube.com", "music.youtube.com"});
    public static boolean n = false;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String A() throws fz0 {
        if (!yy4.n(a)) {
            return a;
        }
        try {
            p();
        } catch (Exception unused) {
            o();
        }
        if (b) {
            return a;
        }
        if (!V()) {
            throw new fz0("Could not get YouTube WEB client version");
        }
        a = "2.20260120.01.00";
        return "2.20260120.01.00";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String B(Stream stream, final String str, final String str2) {
        return (String) stream.filter(new Predicate() { // from class: bc5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ko1) obj).p("service", "").equals(str);
            }
        }).flatMap(new Function() { // from class: sb5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).b("params").stream();
            }
        }).filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: tb5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ko1) obj).p("key", "").equals(str2);
            }
        }).map(new Function() { // from class: ub5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).o(ES6Iterator.VALUE_PROPERTY);
            }
        }).filter(new Predicate() { // from class: vb5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cc5.j((String) obj);
            }
        }).findFirst().orElse(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map C() {
        return m41.a(new Map.Entry[]{new AbstractMap.SimpleEntry("Cookie", av4.a(new Object[]{u()}))});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 D(ko1 ko1Var) {
        try {
            return xo1.a(ko1Var, "showDialogCommand.panelLoadingStrategy.inlineContent.dialogViewModel.customContent.listViewModel.listItems").d(0).m("listItemViewModel");
        } catch (s83 unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List E(eo1 eo1Var) {
        return (List) eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: yb5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cc5.i((ko1) obj);
            }
        }).map(new Function() { // from class: zb5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return cc5.a((ko1) obj);
            }
        }).collect(DesugarCollectors.toUnmodifiableList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 F(String str) throws s83 {
        try {
            return (ko1) lo1.d().a(yy4.j(str, e, 1));
        } catch (mo1 | p83.a e2) {
            uo1.a("Could not get ytInitialData", e2);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String G(pz1 pz1Var) {
        if (pz1Var == null) {
            pz1Var = pz1.h;
        }
        return "com.google.ios.youtube/21.03.2(iPhone16,2; U; CPU iOS 18_7_2 like Mac OS X; " + pz1Var.d() + ")";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 H(String str, List list, byte[] bArr, pz1 pz1Var) {
        String str2;
        Map mapR = R();
        if (list.isEmpty()) {
            str2 = "?prettyPrint=false";
        } else {
            str2 = "?" + ye1.a("&", list) + "&prettyPrint=false";
        }
        return xo1.k(P(a33.a().k("https://www.youtube.com/youtubei/v1/" + str + str2, mapR, bArr, pz1Var)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 I(String str, byte[] bArr, pz1 pz1Var) {
        Map mapR = R();
        return xo1.k(P(a33.a().k("https://www.youtube.com/youtubei/v1/" + str + "?prettyPrint=false", mapR, bArr, pz1Var)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map J(String str) {
        List listA = av4.a(new Object[]{str});
        return m41.a(new Map.Entry[]{new AbstractMap.SimpleEntry("Origin", listA), new AbstractMap.SimpleEntry("Referer", listA)});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String K(ko1 ko1Var) {
        return L(ko1Var, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String L(ko1 ko1Var, boolean z) {
        if (yy4.p(ko1Var)) {
            return null;
        }
        if (ko1Var.q("simpleText")) {
            return ko1Var.o("simpleText");
        }
        eo1<ko1> eo1VarB = ko1Var.b("runs");
        if (eo1VarB.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (ko1 ko1Var2 : eo1VarB) {
            String strO = ko1Var2.o("text");
            if (z) {
                if (ko1Var2.q("navigationEndpoint")) {
                    String strO2 = O(ko1Var2.m("navigationEndpoint"));
                    if (!yy4.n(strO2)) {
                        strO = "<a href=\"" + bt0.l(strO2) + "\">" + bt0.l(strO) + "</a>";
                    }
                }
                boolean z2 = false;
                boolean z3 = ko1Var2.q("bold") && ko1Var2.d("bold");
                boolean z4 = ko1Var2.q("italics") && ko1Var2.d("italics");
                if (ko1Var2.q("strikethrough") && ko1Var2.d("strikethrough")) {
                    z2 = true;
                }
                if (z3) {
                    sb.append("<b>");
                }
                if (z4) {
                    sb.append("<i>");
                }
                if (z2) {
                    sb.append("<s>");
                }
                sb.append(strO);
                if (z2) {
                    sb.append("</s>");
                }
                if (z4) {
                    sb.append("</i>");
                }
                if (z3) {
                    sb.append("</b>");
                }
            } else {
                sb.append(strO);
            }
        }
        String string = sb.toString();
        return z ? string.replaceAll("\\n", "<br>").replaceAll(" {2}", " &nbsp;") : string;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String M(ko1 ko1Var, String str) throws s83 {
        String strK = K(ko1Var);
        if (strK != null) {
            return strK;
        }
        to1.a("Could not extract text: ", str);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List N(ko1 ko1Var) throws s83 {
        try {
            return E(ko1Var.m("thumbnail").b("thumbnails"));
        } catch (Exception e2) {
            uo1.a("Could not get thumbnails from InfoItem", e2);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String O(ko1 ko1Var) {
        if (ko1Var.q("urlEndpoint")) {
            String strO = ko1Var.m("urlEndpoint").o("url");
            if (strO.startsWith("https://www.youtube.com/redirect?")) {
                strO = strO.substring(23);
            }
            if (strO.startsWith("/redirect?")) {
                for (String str : strO.substring(10).split("&")) {
                    if (str.split("=")[0].equals("q")) {
                        return yy4.e(str.split("=")[1]);
                    }
                }
            } else {
                if (strO.startsWith("http")) {
                    return strO;
                }
                if (strO.startsWith("/channel") || strO.startsWith("/user") || strO.startsWith("/watch")) {
                    return "https://www.youtube.com".concat(strO);
                }
            }
        }
        if (ko1Var.q("browseEndpoint")) {
            ko1 ko1VarM = ko1Var.m("browseEndpoint");
            String strO2 = ko1VarM.o("canonicalBaseUrl");
            String strO3 = ko1VarM.o("browseId");
            if (strO3 != null) {
                if (strO3.startsWith("UC")) {
                    return "https://www.youtube.com/channel/".concat(strO3);
                }
                if (strO3.startsWith("VL")) {
                    return "https://www.youtube.com/playlist?list=".concat(strO3.substring(2));
                }
            }
            if (!yy4.n(strO2)) {
                return "https://www.youtube.com" + strO2;
            }
        }
        if (ko1Var.q("watchEndpoint")) {
            StringBuilder sb = new StringBuilder("https://www.youtube.com/watch?v=");
            sb.append(ko1Var.m("watchEndpoint").o("videoId"));
            if (ko1Var.m("watchEndpoint").q("playlistId")) {
                sb.append("&list=");
                sb.append(ko1Var.m("watchEndpoint").o("playlistId"));
            }
            if (ko1Var.m("watchEndpoint").q("startTimeSeconds")) {
                sb.append("&t=");
                sb.append(ko1Var.m("watchEndpoint").h("startTimeSeconds"));
            }
            return sb.toString();
        }
        if (ko1Var.q("watchPlaylistEndpoint")) {
            return "https://www.youtube.com/playlist?list=" + ko1Var.m("watchPlaylistEndpoint").o("playlistId");
        }
        if (ko1Var.q("showDialogCommand")) {
            try {
                return O(xo1.f(xo1.a(ko1Var, "showDialogCommand.panelLoadingStrategy.inlineContent.dialogViewModel.customContent.listViewModel.listItems").d(0), "listItemViewModel.rendererContext.commandContext.onTap.innertubeCommand"));
            } catch (s83 unused) {
            }
        }
        if (!ko1Var.q("commandMetadata")) {
            return null;
        }
        ko1 ko1VarM2 = ko1Var.m("commandMetadata").m("webCommandMetadata");
        if (!ko1VarM2.q("url")) {
            return null;
        }
        return "https://www.youtube.com" + ko1VarM2.o("url");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String P(ws3 ws3Var) throws s83 {
        if (ws3Var.d() == 404) {
            throw new x20("Not found (\"" + ws3Var.d() + " " + ws3Var.e() + "\")");
        }
        String strC = ws3Var.c();
        if (strC.length() < 50) {
            ny4.a("JSON response is too short");
            return null;
        }
        URL url = new URL(ws3Var.b());
        if (url.getHost().equalsIgnoreCase("www.youtube.com")) {
            String path = url.getPath();
            if (path.equalsIgnoreCase("/oops") || path.equalsIgnoreCase("/error")) {
                throw new x20("Content unavailable");
            }
        }
        String strA = ws3Var.a("Content-Type");
        if (strA == null || !strA.toLowerCase().contains(NanoHTTPD.MIME_HTML)) {
            return strC;
        }
        throw new s83("Got HTML document, expected JSON response (latest url was: \"" + ws3Var.b() + "\")");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String Q(ek1 ek1Var, pz1 pz1Var, m20 m20Var, Map map, String str, String str2, boolean z) throws s83 {
        byte[] bytes = zo1.b(i0(pz1Var, m20Var, ek1Var, str2).b()).getBytes(StandardCharsets.UTF_8);
        String strO = xo1.k(P(a33.a().j(str + (z ? "guide" : "visitor_id") + "?prettyPrint=false", map, bytes))).m("responseContext").o("visitorData");
        if (!yy4.n(strO)) {
            return strO;
        }
        ny4.a("Could not get visitorData");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map R() {
        Map mapZ = z();
        mapZ.put("Cookie", av4.a(new Object[]{u()}));
        return mapZ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean S(eo1 eo1Var) {
        return eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).anyMatch(new Predicate() { // from class: xb5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ko1) obj).m("element").m("type").m("imageType").m("image").b("sources").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).anyMatch(new Predicate() { // from class: wb5
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj2) {
                        return cc5.h((ko1) obj2);
                    }
                });
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean T() {
        return n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean U(String str) {
        try {
            final URL url = new URL(n(str));
            return k.stream().anyMatch(new Predicate() { // from class: ac5
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return url.getHost().startsWith((String) obj);
                }
            });
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean V() {
        if (c.isPresent()) {
            return ((Boolean) c.get()).booleanValue();
        }
        boolean z = false;
        ws3 ws3VarJ = a33.a().j("https://www.youtube.com/youtubei/v1/guide?prettyPrint=false", y("1", "2.20260120.01.00"), ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) ((po1) zo1.a().n()).o("context")).o("client")).E("hl", "en-GB")).E("gl", "GB")).E("clientName", "WEB")).E("clientVersion", "2.20260120.01.00")).E("platform", "DESKTOP")).B("utcOffsetMinutes", 0)).j()).o("request")).d("internalExperimentFlags")).j()).F("useSsl", true)).j()).o("user")).F("lockedSafetyMode", false)).j()).j()).F("fetchLiveState", true)).j()).H().getBytes(StandardCharsets.UTF_8));
        String strC = ws3VarJ.c();
        int iD = ws3VarJ.d();
        if (strC.length() > 5000 && iD == 200) {
            z = true;
        }
        Optional optionalOf = Optional.of(Boolean.valueOf(z));
        c = optionalOf;
        return ((Boolean) optionalOf.get()).booleanValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean W(URL url) {
        return url.getHost().equalsIgnoreCase("hooktube.com");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean X(URL url) {
        return l.contains(url.getHost().toLowerCase(Locale.ROOT));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean Y(eo1 eo1Var) {
        if (yy4.o(eo1Var)) {
            return false;
        }
        Iterator<E> it = eo1Var.iterator();
        while (it.hasNext()) {
            String strO = ((ko1) it.next()).m("metadataBadgeRenderer").o("style");
            if (strO != null && (strO.equals("BADGE_STYLE_TYPE_VERIFIED") || strO.equals("BADGE_STYLE_TYPE_VERIFIED_ARTIST"))) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean Z(URL url) {
        return url.getHost().equalsIgnoreCase("y2u.be");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ di1 a(ko1 ko1Var) {
        int i2 = ko1Var.i("height", -1);
        return new di1(t(ko1Var.o("url")), i2, ko1Var.i("width", -1), di1.a.a(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean a0(String str) {
        return str.startsWith("RDGMEM");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b0(String str) {
        return str.startsWith("RD");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean c0(String str) {
        return str.startsWith("RDAMVM") || str.startsWith("RDCLAK");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean d0(String str) {
        return str.startsWith("RDMM");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e0(URL url) {
        String host = url.getHost();
        return host.equalsIgnoreCase("www.youtube-nocookie.com") || host.equalsIgnoreCase("youtu.be");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean f0(URL url) {
        return m.contains(url.getHost().toLowerCase(Locale.ROOT));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g0(String str) throws s83 {
        String[] strArrSplit = str.contains(":") ? str.split(":") : str.split("\\.");
        int[] iArr = {24, 60, 60, 1};
        int length = 4 - strArrSplit.length;
        if (length < 0) {
            throw new s83("Error duration string with unknown format: ".concat(str));
        }
        int iK = 0;
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            iK = (iK + k(strArrSplit[i2])) * iArr[i2 + length];
        }
        return iK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean h(ko1 ko1Var) {
        String strO = ko1Var.m("clientResource").o("imageName");
        return "CHECK_CIRCLE_FILLED".equals(strO) || "AUDIO_BADGE".equals(strO) || "MUSIC_FILLED".equals(strO);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fo1 h0(pz1 pz1Var, m20 m20Var) {
        return ko1.a().e("context").e("client").h("hl", pz1Var.g()).h("gl", m20Var.a()).h("clientName", "WEB").h("clientVersion", A()).h("originalUrl", "https://www.youtube.com").h("platform", "DESKTOP").f("utcOffsetMinutes", 0).c().e("request").a("internalExperimentFlags").c().i("useSsl", true).c().e("user").i("lockedSafetyMode", false).c().c();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: NOT 
      (wrap:boolean:0x0006: INVOKE 
      (wrap:java.lang.String:0x0002: INVOKE (r1v0 ko1), ("url") VIRTUAL call: ko1.o(java.lang.String):java.lang.String A[DONT_GENERATE, MD:(java.lang.String):java.lang.String (m), REMOVE, WRAPPED] (LINE:3))
     STATIC call: yy4.n(java.lang.String):boolean A[DONT_GENERATE, MD:(java.lang.String):boolean (m), REMOVE, WRAPPED] (LINE:7))
     */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean i(ko1 ko1Var) {
        return !yy4.n(ko1Var.o("url"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fo1 i0(pz1 pz1Var, m20 m20Var, ek1 ek1Var, String str) {
        fo1 fo1VarH = ko1.a().e("context").e("client").h("clientName", ek1Var.a.a).h("clientVersion", ek1Var.a.b);
        String str2 = ek1Var.a.d;
        if (str2 != null) {
            fo1VarH.h("clientScreen", str2);
        }
        String str3 = ek1Var.b.a;
        if (str3 != null) {
            fo1VarH.h("platform", str3);
        }
        String str4 = ek1Var.a.e;
        if (str4 != null) {
            fo1VarH.h("visitorData", str4);
        }
        String str5 = ek1Var.b.b;
        if (str5 != null) {
            fo1VarH.h("deviceMake", str5);
        }
        String str6 = ek1Var.b.c;
        if (str6 != null) {
            fo1VarH.h("deviceModel", str6);
        }
        String str7 = ek1Var.b.d;
        if (str7 != null) {
            fo1VarH.h("osName", str7);
        }
        String str8 = ek1Var.b.e;
        if (str8 != null) {
            fo1VarH.h("osVersion", str8);
        }
        int i2 = ek1Var.b.f;
        if (i2 > 0) {
            fo1VarH.f("androidSdkVersion", i2);
        }
        fo1VarH.h("hl", pz1Var.g()).h("gl", m20Var.a()).f("utcOffsetMinutes", 0).c();
        if (str != null) {
            fo1VarH.e("thirdParty").h("embedUrl", str).c();
        }
        fo1VarH.e("request").a("internalExperimentFlags").c().i("useSsl", true).c().e("user").i("lockedSafetyMode", false).c().c();
        return fo1VarH;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: NOT 
      (wrap:boolean:0x0000: INVOKE (r0v0 java.lang.String) STATIC call: yy4.n(java.lang.String):boolean A[DONT_GENERATE, MD:(java.lang.String):boolean (m), REMOVE, WRAPPED] (LINE:1))
     */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean j(String str) {
        return !yy4.n(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Integer.parseInt(yy4.t(str));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void l(ko1 ko1Var) throws x20 {
        eo1 eo1VarB = ko1Var.b("alerts");
        if (yy4.o(eo1VarB)) {
            return;
        }
        ko1 ko1VarM = eo1VarB.d(0).m("alertRenderer");
        String strK = K(ko1VarM.m("text"));
        if (ko1VarM.p("type", "").equalsIgnoreCase("ERROR")) {
            if (strK == null || !(strK.contains("This account has been terminated") || strK.contains("This channel was removed"))) {
                throw new x20("Got error: \"" + strK + "\"");
            }
            if (!strK.matches(".*violat(ed|ion|ing).*") && !strK.contains("infringement")) {
                throw new k2(strK);
            }
            throw new k2(strK, k2.a.VIOLATION);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static je m(String str) {
        String str2;
        try {
            String strI = yy4.i(new URL(str), "xtags");
            if (strI == null) {
                return null;
            }
            String[] strArrSplit = strI.split(":");
            int length = strArrSplit.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str2 = null;
                    break;
                }
                String[] strArrSplit2 = strArrSplit[i2].split("=", 2);
                if (strArrSplit2.length > 1 && strArrSplit2[0].equals("acont")) {
                    str2 = strArrSplit2[1];
                    break;
                }
                i2++;
            }
            if (str2 == null) {
                return null;
            }
            switch (str2) {
            }
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String n(String str) {
        if (str == null) {
            return null;
        }
        return str.contains("webcache.googleusercontent.com") ? str.split("cache:")[1] : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void o() throws s83 {
        if (b) {
            return;
        }
        String strC = a33.a().d("https://www.youtube.com/results?search_query=&ucbcb=1", C()).c();
        Stream map = F(strC).m("responseContext").b("serviceTrackingParams").stream().filter(new co1(ko1.class)).map(new e72(ko1.class));
        String strB = B(map, "CSI", "cver");
        a = strB;
        if (strB == null) {
            try {
                a = yy4.j(strC, d, 1);
            } catch (p83.a unused) {
            }
        }
        if (yy4.n(a)) {
            a = B(map, "ECATCHER", "client.version");
        }
        if (a != null) {
            b = true;
        } else {
            ny4.a("Could not extract YouTube WEB InnerTube client version from HTML search results page");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void p() throws s83 {
        if (b) {
            return;
        }
        try {
            a = yy4.j(a33.a().d("https://www.youtube.com/sw.js", J("https://www.youtube.com")).c(), d, 1);
            b = true;
        } catch (p83.a e2) {
            uo1.a("Could not extract YouTube WEB InnerTube client version from sw.js", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static we3 q(String str) throws s83 {
        if (!yy4.n(str)) {
            return c0(str) ? we3.MIX_MUSIC : a0(str) ? we3.MIX_GENRE : b0(str) ? we3.MIX_STREAM : we3.NORMAL;
        }
        ny4.a("Could not extract playlist type from empty playlist id");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static we3 r(String str) throws s83 {
        try {
            return q(yy4.i(yy4.v(str), "list"));
        } catch (MalformedURLException e2) {
            uo1.a("Could not extract playlist type from malformed url", e2);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String s(String str) throws s83 {
        if (yy4.n(str)) {
            ny4.a("Video id could not be determined from empty playlist id");
            return null;
        }
        if (d0(str)) {
            return str.substring(4);
        }
        if (c0(str)) {
            return str.substring(6);
        }
        if (a0(str)) {
            to1.a("Video id could not be determined from genre mix id: ", str);
            return null;
        }
        if (!b0(str)) {
            to1.a("Video id could not be determined from playlist id: ", str);
            return null;
        }
        if (str.length() == 13) {
            return str.substring(2);
        }
        throw new s83("Video id could not be determined from mix id: ".concat(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String t(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        return str.startsWith("http://") ? yy4.u(str) : !str.startsWith("https://") ? "https://".concat(str) : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String u() {
        return "SOCS=".concat(T() ? "CAISAiAD" : "CAE=");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String v() {
        return qn3.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", 16, f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String w() {
        return qn3.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", 12, f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String x(pz1 pz1Var) {
        if (pz1Var == null) {
            pz1Var = pz1.h;
        }
        return "com.google.android.youtube/21.03.36 (Linux; U; Android 15; " + pz1Var.d() + ") gzip";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map y(String str, String str2) {
        return m41.a(new Map.Entry[]{new AbstractMap.SimpleEntry("X-YouTube-Client-Name", av4.a(new Object[]{str})), new AbstractMap.SimpleEntry("X-YouTube-Client-Version", av4.a(new Object[]{str2}))});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map z() {
        HashMap map = new HashMap(J("https://www.youtube.com"));
        map.putAll(y("1", A()));
        return map;
    }
}
