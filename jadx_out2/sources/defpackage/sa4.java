package defpackage;

import defpackage.di1;
import defpackage.p83;
import j$.time.OffsetDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeParseException;
import j$.util.stream.DesugarCollectors;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import org.mozilla.javascript.Context;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sa4 {
    public static final List a;
    public static final List b;
    public static String c;
    public static final Pattern d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        di1.a aVar = di1.a.LOW;
        oi1 oi1Var = new oi1("mini", 16, 16, aVar);
        oi1 oi1Var2 = new oi1("t20x20", 20, 20, aVar);
        oi1 oi1Var3 = new oi1("small", 32, 32, aVar);
        oi1 oi1Var4 = new oi1("badge", 47, 47, aVar);
        oi1 oi1Var5 = new oi1("t50x50", 50, 50, aVar);
        oi1 oi1Var6 = new oi1("t60x60", 60, 60, aVar);
        oi1 oi1Var7 = new oi1("t67x67", 67, 67, aVar);
        oi1 oi1Var8 = new oi1("t80x80", 80, 80, aVar);
        oi1 oi1Var9 = new oi1("large", 100, 100, aVar);
        oi1 oi1Var10 = new oi1("t120x120", 120, 120, aVar);
        di1.a aVar2 = di1.a.MEDIUM;
        a = av4.a(new oi1[]{oi1Var, oi1Var2, oi1Var3, oi1Var4, oi1Var5, oi1Var6, oi1Var7, oi1Var8, oi1Var9, oi1Var10, new oi1("t200x200", 200, 200, aVar2), new oi1("t240x240", 240, 240, aVar2), new oi1("t250x250", Context.VERSION_ECMASCRIPT, Context.VERSION_ECMASCRIPT, aVar2), new oi1("t300x300", 300, 300, aVar2), new oi1("t500x500", 500, 500, aVar2)});
        b = av4.a(new Object[]{new oi1("t1240x260", 1240, 260, aVar2), new oi1("t2480x520", 2480, 520, aVar2)});
        d = Pattern.compile("^https?://on.soundcloud.com/[0-9a-zA-Z]+$");
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x001a: CONSTRUCTOR 
      (wrap:java.lang.String:0x000a: INVOKE 
      (r3v0 java.lang.String)
      (wrap:java.lang.Object[]:0x0006: FILLED_NEW_ARRAY 
      (wrap:java.lang.String:0x0002: INVOKE (r4v0 oi1) VIRTUAL call: oi1.c():java.lang.String A[MD:():java.lang.String (m), WRAPPED] (LINE:3))
     A[WRAPPED] (LINE:7) elemType: java.lang.Object)
     STATIC call: java.lang.String.format(java.lang.String, java.lang.Object[]):java.lang.String A[MD:(java.lang.String, java.lang.Object[]):java.lang.String VARARG (c), VARARG_CALL, WRAPPED] (LINE:11))
      (wrap:int:0x000e: INVOKE (r4v0 oi1) VIRTUAL call: oi1.a():int A[MD:():int (m), WRAPPED] (LINE:15))
      (wrap:int:0x0012: INVOKE (r4v0 oi1) VIRTUAL call: oi1.d():int A[MD:():int (m), WRAPPED] (LINE:19))
      (wrap:di1$a:0x0016: INVOKE (r4v0 oi1) VIRTUAL call: oi1.b():di1$a A[MD:():di1$a (m), WRAPPED] (LINE:23))
     A[MD:(java.lang.String, int, int, di1$a):void (m)] (LINE:27) call: di1.<init>(java.lang.String, int, int, di1$a):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ di1 a(String str, oi1 oi1Var) {
        return new di1(String.format(str, oi1Var.c()), oi1Var.a(), oi1Var.d(), oi1Var.b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized String b() {
        if (!yy4.n(c)) {
            return c;
        }
        gn0 gn0VarA = a33.a();
        er0 er0VarR0 = cp1.a(gn0VarA.b("https://soundcloud.com").c()).R0("script[src*=\"sndcdn.com/assets/\"][src$=\".js\"]");
        Collections.reverse(er0VarR0);
        Map mapA = m41.a(new Map.Entry[]{new AbstractMap.SimpleEntry("Range", av4.a(new Object[]{"bytes=0-50000"}))});
        Iterator<E> it = er0VarR0.iterator();
        while (it.hasNext()) {
            String strE = ((br0) it.next()).e("src");
            if (!yy4.n(strE)) {
                try {
                    String strK = p83.k(",client_id:\"(.*?)\"", gn0VarA.d(strE, mapA).c());
                    c = strK;
                    return strK;
                } catch (p83.a unused) {
                    continue;
                }
            }
        }
        throw new fz0("Couldn't extract client id");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List c(String str) {
        return yy4.n(str) ? Collections.EMPTY_LIST : d(str.replace("-large.", "-%s."), a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List d(final String str, List list) {
        return (List) list.stream().map(new Function() { // from class: ra4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return sa4.a(str, (oi1) obj);
            }
        }).collect(DesugarCollectors.toUnmodifiableList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List e(ko1 ko1Var) throws s83 {
        String strO = ko1Var.o("artwork_url");
        if (strO != null) {
            return c(strO);
        }
        String strO2 = ko1Var.m("user").o("avatar_url");
        if (strO2 != null) {
            return c(strO2);
        }
        ny4.a("Could not get track or track user's thumbnails");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String f(ko1 ko1Var) {
        return yy4.u(ko1Var.m("user").p("avatar_url", ""));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String g(ko1 ko1Var) {
        try {
            String strO = ko1Var.o("next_href");
            if (strO.contains("client_id=")) {
                return strO;
            }
            return strO + "&client_id=" + b();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String h(af4 af4Var, String str) {
        return i(af4Var, str, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String i(af4 af4Var, String str, boolean z) throws IOException, s83 {
        ws3 ws3VarC = a33.a().c(str, x14.b.d());
        if (ws3VarC.d() >= 400) {
            uf1.a("Could not get streams from API, HTTP ", ws3VarC.d());
            return null;
        }
        try {
            ko1 ko1Var = (ko1) lo1.d().a(ws3VarC.c());
            for (Object obj : ko1Var.b("collection")) {
                if (obj instanceof ko1) {
                    ko1 ko1VarM = (ko1) obj;
                    if (z) {
                        ko1VarM = ko1VarM.m("track");
                    }
                    af4Var.d(new xa4(ko1VarM));
                }
            }
            return g(ko1Var);
        } catch (mo1 e) {
            uo1.a("Could not parse json response", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j(ko1 ko1Var) {
        return ko1Var.m("user").p("username", "");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String k(ko1 ko1Var) {
        return yy4.u(ko1Var.m("user").p("permalink_url", ""));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qa0 l(String str) throws s83 {
        try {
            return qa0.a(str);
        } catch (DateTimeParseException e) {
            try {
                return new qa0(OffsetDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss +0000")));
            } catch (DateTimeParseException e2) {
                e2.addSuppressed(e);
                pa0.a("Could not parse date: \"", str, "\"", e2);
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 m(gn0 gn0Var, String str) throws s83 {
        try {
            return (ko1) lo1.d().a(gn0Var.c("https://api-v2.soundcloud.com/resolve?url=" + yy4.f(str) + "&client_id=" + b(), x14.b.d()).c());
        } catch (mo1 e) {
            uo1.a("Could not parse json response", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String n(String str) throws s83 {
        if (d.matcher(str).find()) {
            try {
                str = a33.a().f(str).b().split("\\?")[0];
            } catch (fz0 e) {
                uo1.a("Could not follow on.soundcloud.com redirect", e);
                return null;
            }
        }
        if (str.charAt(str.length() - 1) == '/') {
            str = str.substring(0, str.length() - 1);
        }
        try {
            try {
                return String.valueOf(xo1.j((ko1) lo1.d().a(a33.a().c("https://api-widget.soundcloud.com/resolve?url=" + yy4.f(yy4.v(yy4.s(str.toLowerCase())).toString()) + "&format=json&client_id=" + b(), x14.b.d()).c()), Name.MARK));
            } catch (fz0 e2) {
                uo1.a("Could not resolve id with embedded player. ClientId not extracted", e2);
                return null;
            } catch (mo1 e3) {
                uo1.a("Could not parse JSON response", e3);
                return null;
            }
        } catch (MalformedURLException unused) {
            jl.a("The given URL is not valid");
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String o(String str) {
        return cp1.a(a33.a().c("https://w.soundcloud.com/player/?url=" + yy4.f(str), x14.b.d()).c()).R0("link[rel=\"canonical\"]").l().e("abs:href");
    }
}
