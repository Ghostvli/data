package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import java.io.Serializable;
import java.util.Locale;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class jm1 implements Serializable {
    public static final jm1[] G;
    public String A;
    public je B;
    public Locale C;
    public boolean D;
    public long E;
    public String F;
    public final dg2 f;
    public final int g;
    public final a h;
    public int i;
    public int j;
    public int k;
    public String l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public String u;
    public String v;
    public int w;
    public long x;
    public long y;
    public String z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        AUDIO,
        VIDEO,
        VIDEO_ONLY
    }

    static {
        a aVar = a.VIDEO;
        dg2 dg2Var = dg2.v3GPP;
        jm1 jm1Var = new jm1(17, aVar, dg2Var, "144p");
        jm1 jm1Var2 = new jm1(36, aVar, dg2Var, "240p");
        dg2 dg2Var2 = dg2.MPEG_4;
        jm1 jm1Var3 = new jm1(18, aVar, dg2Var2, "360p");
        jm1 jm1Var4 = new jm1(34, aVar, dg2Var2, "360p");
        jm1 jm1Var5 = new jm1(35, aVar, dg2Var2, "480p");
        jm1 jm1Var6 = new jm1(59, aVar, dg2Var2, "480p");
        jm1 jm1Var7 = new jm1(78, aVar, dg2Var2, "480p");
        jm1 jm1Var8 = new jm1(22, aVar, dg2Var2, "720p");
        jm1 jm1Var9 = new jm1(37, aVar, dg2Var2, "1080p");
        jm1 jm1Var10 = new jm1(38, aVar, dg2Var2, "1080p");
        dg2 dg2Var3 = dg2.WEBM;
        jm1 jm1Var11 = new jm1(43, aVar, dg2Var3, "360p");
        jm1 jm1Var12 = new jm1(44, aVar, dg2Var3, "480p");
        jm1 jm1Var13 = new jm1(45, aVar, dg2Var3, "720p");
        jm1 jm1Var14 = new jm1(46, aVar, dg2Var3, "1080p");
        a aVar2 = a.AUDIO;
        dg2 dg2Var4 = dg2.WEBMA;
        jm1 jm1Var15 = new jm1(Token.ARRAYCOMP, aVar2, dg2Var4, 128);
        jm1 jm1Var16 = new jm1(Token.LETEXPR, aVar2, dg2Var4, Buffer.DEFAULT_SIZE);
        dg2 dg2Var5 = dg2.M4A;
        jm1 jm1Var17 = new jm1(599, aVar2, dg2Var5, 32);
        jm1 jm1Var18 = new jm1(Token.VOID, aVar2, dg2Var5, 48);
        jm1 jm1Var19 = new jm1(140, aVar2, dg2Var5, 128);
        jm1 jm1Var20 = new jm1(Token.EMPTY, aVar2, dg2Var5, Buffer.DEFAULT_SIZE);
        dg2 dg2Var6 = dg2.WEBMA_OPUS;
        jm1 jm1Var21 = new jm1(600, aVar2, dg2Var6, 35);
        jm1 jm1Var22 = new jm1(249, aVar2, dg2Var6, 50);
        jm1 jm1Var23 = new jm1(Context.VERSION_ECMASCRIPT, aVar2, dg2Var6, 70);
        jm1 jm1Var24 = new jm1(251, aVar2, dg2Var6, 160);
        a aVar3 = a.VIDEO_ONLY;
        G = new jm1[]{jm1Var, jm1Var2, jm1Var3, jm1Var4, jm1Var5, jm1Var6, jm1Var7, jm1Var8, jm1Var9, jm1Var10, jm1Var11, jm1Var12, jm1Var13, jm1Var14, jm1Var15, jm1Var16, jm1Var17, jm1Var18, jm1Var19, jm1Var20, jm1Var21, jm1Var22, jm1Var23, jm1Var24, new jm1(160, aVar3, dg2Var2, "144p"), new jm1(394, aVar3, dg2Var2, "144p"), new jm1(Token.BREAK, aVar3, dg2Var2, "240p"), new jm1(395, aVar3, dg2Var2, "240p"), new jm1(Token.CONTINUE, aVar3, dg2Var2, "360p"), new jm1(396, aVar3, dg2Var2, "360p"), new jm1(Token.VAR, aVar3, dg2Var2, "480p"), new jm1(212, aVar3, dg2Var2, "480p"), new jm1(397, aVar3, dg2Var2, "480p"), new jm1(Token.WITH, aVar3, dg2Var2, "720p"), new jm1(398, aVar3, dg2Var2, "720p"), new jm1(298, aVar3, dg2Var2, "720p60", 60), new jm1(Token.CATCH, aVar3, dg2Var2, "1080p"), new jm1(399, aVar3, dg2Var2, "1080p"), new jm1(299, aVar3, dg2Var2, "1080p60", 60), new jm1(400, aVar3, dg2Var2, "1440p"), new jm1(266, aVar3, dg2Var2, "2160p"), new jm1(401, aVar3, dg2Var2, "2160p"), new jm1(278, aVar3, dg2Var3, "144p"), new jm1(242, aVar3, dg2Var3, "240p"), new jm1(243, aVar3, dg2Var3, "360p"), new jm1(244, aVar3, dg2Var3, "480p"), new jm1(245, aVar3, dg2Var3, "480p"), new jm1(246, aVar3, dg2Var3, "480p"), new jm1(247, aVar3, dg2Var3, "720p"), new jm1(248, aVar3, dg2Var3, "1080p"), new jm1(271, aVar3, dg2Var3, "1440p"), new jm1(272, aVar3, dg2Var3, "2160p"), new jm1(302, aVar3, dg2Var3, "720p60", 60), new jm1(303, aVar3, dg2Var3, "1080p60", 60), new jm1(HttpStatusCodesKt.HTTP_PERM_REDIRECT, aVar3, dg2Var3, "1440p60", 60), new jm1(313, aVar3, dg2Var3, "2160p"), new jm1(315, aVar3, dg2Var3, "2160p60", 60)};
    }

    public jm1(jm1 jm1Var) {
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.m = -1;
        this.w = -1;
        this.x = -1L;
        this.y = -1L;
        this.f = jm1Var.f;
        this.g = jm1Var.g;
        this.h = jm1Var.h;
        this.i = jm1Var.i;
        this.j = jm1Var.j;
        this.k = jm1Var.k;
        this.l = jm1Var.l;
        this.m = jm1Var.m;
        this.n = jm1Var.n;
        this.o = jm1Var.o;
        this.p = jm1Var.p;
        this.q = jm1Var.q;
        this.r = jm1Var.r;
        this.s = jm1Var.s;
        this.t = jm1Var.t;
        this.u = jm1Var.u;
        this.v = jm1Var.v;
        this.w = jm1Var.w;
        this.x = jm1Var.x;
        this.y = jm1Var.y;
        this.z = jm1Var.z;
        this.A = jm1Var.A;
        this.B = jm1Var.B;
        this.C = jm1Var.C;
    }

    public static jm1 n(int i) throws s83 {
        for (jm1 jm1Var : G) {
            if (i == jm1Var.g) {
                return new jm1(jm1Var);
            }
        }
        throw new s83("itag " + i + " is not supported");
    }

    public void A(String str) {
        this.v = str;
    }

    public void B(long j) {
        if (j <= 0) {
            j = -1;
        }
        this.y = j;
    }

    public void C(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.m = i;
    }

    public void D(int i) {
        this.p = i;
    }

    public void E(int i) {
        this.t = i;
    }

    public void F(int i) {
        this.s = i;
    }

    public void G(int i) {
        this.r = i;
    }

    public void H(int i) {
        this.q = i;
    }

    public void I(Boolean bool) {
        this.D = bool.booleanValue();
    }

    public void J(long j) {
        this.E = j;
    }

    public void K(String str) {
        this.u = str;
    }

    public void L(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.j = i;
    }

    public void M(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.w = i;
    }

    public void N(int i) {
        this.o = i;
    }

    public void O(String str) {
        this.F = str;
    }

    public Locale a() {
        return this.C;
    }

    public String b() {
        return this.z;
    }

    public String c() {
        return this.A;
    }

    public je d() {
        return this.B;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.n;
    }

    public String g() {
        return this.v;
    }

    public int h() {
        return this.m;
    }

    public int i() {
        return this.p;
    }

    public int j() {
        return this.t;
    }

    public int k() {
        return this.s;
    }

    public int l() {
        return this.r;
    }

    public int m() {
        return this.q;
    }

    public dg2 o() {
        return this.f;
    }

    public String p() {
        return this.u;
    }

    public String q() {
        return this.l;
    }

    public int r() {
        return this.j;
    }

    public int s() {
        return this.o;
    }

    public void t(long j) {
        if (j <= 0) {
            j = -1;
        }
        this.x = j;
    }

    public void u(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.k = i;
    }

    public void v(Locale locale) {
        this.C = locale;
    }

    public void w(String str) {
        this.z = str;
    }

    public void x(String str) {
        this.A = str;
    }

    public void y(je jeVar) {
        this.B = jeVar;
    }

    public void z(int i) {
        this.n = i;
    }

    public jm1(int i, a aVar, dg2 dg2Var, String str, int i2) {
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.w = -1;
        this.x = -1L;
        this.y = -1L;
        this.g = i;
        this.h = aVar;
        this.f = dg2Var;
        this.l = str;
        this.m = i2;
    }

    public jm1(int i, a aVar, dg2 dg2Var, int i2) {
        this.j = -1;
        this.k = -1;
        this.m = -1;
        this.w = -1;
        this.x = -1L;
        this.y = -1L;
        this.g = i;
        this.h = aVar;
        this.f = dg2Var;
        this.i = i2;
    }

    public jm1(int i, a aVar, dg2 dg2Var, String str) {
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.w = -1;
        this.x = -1L;
        this.y = -1L;
        this.g = i;
        this.h = aVar;
        this.f = dg2Var;
        this.l = str;
        this.m = 30;
    }
}
