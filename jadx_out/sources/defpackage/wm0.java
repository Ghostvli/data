package defpackage;

import defpackage.bt0;
import defpackage.su0;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class wm0 extends br0 {
    public static final su0 t = new su0.n0("title");
    public a p;
    public o83 q;
    public b r;
    public final String s;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements Cloneable {
        public bt0.c f = bt0.c.base;
        public Charset g = la0.b;
        public boolean h = true;
        public boolean i = false;
        public int j = 1;
        public int k = 30;
        public EnumC0128a l = EnumC0128a.html;

        /* JADX INFO: renamed from: wm0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum EnumC0128a {
            html,
            xml
        }

        public a a(String str) {
            b(Charset.forName(str));
            return this;
        }

        public a b(Charset charset) {
            this.g = charset;
            return this;
        }

        public Charset c() {
            return this.g;
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a clone() {
            try {
                a aVar = (a) super.clone();
                aVar.a(this.g.name());
                aVar.f = bt0.c.valueOf(this.f.name());
                return aVar;
            } catch (CloneNotSupportedException e) {
                wg1.a(e);
                return null;
            }
        }

        public bt0.c e() {
            return this.f;
        }

        public int f() {
            return this.j;
        }

        public int g() {
            return this.k;
        }

        public boolean h() {
            return this.i;
        }

        public boolean i() {
            return this.h;
        }

        public EnumC0128a j() {
            return this.l;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public wm0(String str, String str2, o83 o83Var) {
        super(new al4("#root", str), str2);
        this.p = new a();
        this.r = b.noQuirks;
        this.s = str2;
        this.q = o83Var;
    }

    @Override // defpackage.br0, defpackage.l33
    public String C() {
        return "#document";
    }

    @Override // defpackage.l33
    public String H() {
        return super.D0();
    }

    public br0 c1() {
        br0 br0VarE1 = e1();
        for (br0 br0VarU0 = br0VarE1.u0(); br0VarU0 != null; br0VarU0 = br0VarU0.A()) {
            if (br0VarU0.z("body") || br0VarU0.z("frameset")) {
                return br0VarU0;
            }
        }
        return br0VarE1.e0("body");
    }

    @Override // defpackage.br0, defpackage.l33
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public wm0 clone() {
        wm0 wm0Var = (wm0) super.clone();
        xb xbVar = this.k;
        if (xbVar != null) {
            wm0Var.k = xbVar.clone();
        }
        wm0Var.p = this.p.clone();
        return wm0Var;
    }

    public final br0 e1() {
        for (br0 br0VarU0 = u0(); br0VarU0 != null; br0VarU0 = br0VarU0.A()) {
            if (br0VarU0.z("html")) {
                return br0VarU0;
            }
        }
        return e0("html");
    }

    public a f1() {
        return this.p;
    }

    public wm0 g1(o83 o83Var) {
        this.q = o83Var;
        return this;
    }

    public o83 h1() {
        return this.q;
    }

    public b i1() {
        return this.r;
    }

    public wm0 j1(b bVar) {
        this.r = bVar;
        return this;
    }

    public wm0 k1() {
        wm0 wm0Var = new wm0(U0().i(), g(), this.q);
        xb xbVar = this.k;
        if (xbVar != null) {
            wm0Var.k = xbVar.clone();
        }
        wm0Var.p = this.p.clone();
        return wm0Var;
    }

    public wm0(String str, String str2) {
        this(str, str2, o83.f());
    }

    public wm0(String str) {
        this("http://www.w3.org/1999/xhtml", str);
    }
}
