package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.fongmi.android.tv.bean.Result;
import defpackage.fg2;
import defpackage.ph2;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class il {
    public static final Map a = new ConcurrentHashMap();
    public static final fg2 b = g("ROOT", "影視");
    public static final fg2 c = g("VOD", "點播");
    public static final fg2 d;

    static {
        Bundle bundle = new Bundle();
        bundle.putInt("android.media.browse.CONTENT_STYLE_BROWSABLE_HINT", 1);
        d = new fg2.c().e("LIVE").f(new ph2.b().s0("直播").f0(Boolean.TRUE).g0(Boolean.FALSE).h0(20).c0(bundle).L()).a();
    }

    public static fg2 a(String str, boolean z, boolean z2, int i, String str2, String str3, String str4, Uri uri) {
        ph2.b bVarH0 = new ph2.b().s0(str2).f0(Boolean.valueOf(z)).g0(Boolean.valueOf(z2)).h0(Integer.valueOf(i));
        if (!TextUtils.isEmpty(str3)) {
            bVarH0.q0(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            bVarH0.U(Uri.parse(str4));
        }
        if (!TextUtils.isEmpty(str3) && uri != null) {
            bVarH0.S(str3);
        }
        fg2.c cVarF = new fg2.c().e(str).f(bVarH0.L());
        if (uri != null) {
            cVarF.k(uri);
        }
        return cVarF.a();
    }

    public static void b() {
        d();
        c();
    }

    public static void c() {
        ww1.g();
    }

    public static void d() {
        n65.n();
    }

    public static Result e(String str) {
        return (Result) a.remove(str);
    }

    public static long f() {
        return n65.p();
    }

    public static fg2 g(String str, String str2) {
        return a(str, true, false, 20, str2, null, null, null);
    }

    public static xi1 h(String str) {
        str.getClass();
        switch (str) {
            case "VOD":
                return n65.x();
            case "LIVE":
                return ww1.j();
            case "ROOT":
                return xi1.x(c, d);
            default:
                return str.startsWith("LG:") ? ww1.i(str) : xi1.u();
        }
    }

    public static fg2 i(String str) {
        str.getClass();
        switch (str) {
            case "VOD":
                return c;
            case "LIVE":
                return d;
            case "ROOT":
                return b;
            default:
                if (str.startsWith("LG:")) {
                    return g(str, str.substring(3));
                }
                return null;
        }
    }

    public static fg2 j() {
        return b;
    }

    public static xi1 k() {
        return n65.A();
    }

    public static fg2 l(String str, int i) {
        fg2 fg2VarD = n65.D(str, i);
        return fg2VarD != null ? fg2VarD : ww1.n(str, i);
    }

    public static fg2 m(String str, String str2, String str3, String str4) {
        return a(str, false, true, 6, str2, str3, str4, null);
    }

    public static void n(String str, Result result) {
        a.put(str, result);
    }

    public static fg2 o(String str) {
        return str.startsWith("LC:") ? ww1.p(str) : n65.F(str);
    }

    public static fg2 p(fg2 fg2Var) {
        fg2 fg2VarO;
        try {
            fg2VarO = o(fg2Var.a);
        } catch (Exception unused) {
        }
        return fg2VarO != null ? fg2VarO : fg2Var;
    }

    public static boolean q(long j, long j2) {
        return n65.K(j, j2);
    }

    public static xi1 r(String str) {
        return n65.L(str);
    }

    public static fg2 s(String str, String str2, String str3, String str4, String str5) {
        return a(str, false, true, 6, str3, str4, str5, Uri.parse(str2));
    }

    public static int t(int i, int i2, int i3) {
        return (((i + i2) % i3) + i3) % i3;
    }
}
