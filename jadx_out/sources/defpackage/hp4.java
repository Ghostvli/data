package defpackage;

import defpackage.sn3;
import okio.Utf8;
import org.jupnp.xml.DOM;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hp4 {
    public final j a;
    public int b;
    public int c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends c {
        public b(String str) {
            t(str);
        }

        @Override // hp4.c
        public String toString() {
            return DOM.CDATA_BEGIN + u() + DOM.CDATA_END;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends hp4 {
        public final jp4 d;
        public boolean e;

        public d() {
            super(j.Comment);
            this.d = new jp4();
            this.e = false;
        }

        @Override // defpackage.hp4
        public hp4 o() {
            super.o();
            this.d.f();
            this.e = false;
            return this;
        }

        public d s(char c) {
            this.d.a(c);
            return this;
        }

        public d t(String str) {
            this.d.b(str);
            return this;
        }

        public String toString() {
            return "<!--" + u() + "-->";
        }

        public String u() {
            return this.d.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends hp4 {
        public final jp4 d;
        public String e;
        public final jp4 f;
        public final jp4 g;
        public boolean h;

        public e() {
            super(j.Doctype);
            this.d = new jp4();
            this.e = null;
            this.f = new jp4();
            this.g = new jp4();
            this.h = false;
        }

        @Override // defpackage.hp4
        public hp4 o() {
            super.o();
            this.d.f();
            this.e = null;
            this.f.f();
            this.g.f();
            this.h = false;
            return this;
        }

        public String s() {
            return this.d.h();
        }

        public String t() {
            return this.e;
        }

        public String toString() {
            return "<!doctype " + s() + ">";
        }

        public String u() {
            return this.f.h();
        }

        public String v() {
            return this.g.h();
        }

        public boolean w() {
            return this.h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends hp4 {
        public f() {
            super(j.EOF);
        }

        @Override // defpackage.hp4
        public hp4 o() {
            super.o();
            return this;
        }

        public String toString() {
            return "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends i {
        public g(it4 it4Var) {
            super(j.EndTag, it4Var);
        }

        public String toString() {
            return "</" + M() + ">";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends i {
        public h(it4 it4Var) {
            super(j.StartTag, it4Var);
        }

        @Override // hp4.i, defpackage.hp4
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public i o() {
            super.o();
            this.g = null;
            return this;
        }

        public String toString() {
            String str = E() ? "/>" : ">";
            if (!D() || this.g.size() <= 0) {
                return "<" + M() + str;
            }
            return "<" + M() + " " + this.g.toString() + str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class i extends hp4 {
        public jp4 d;
        public String e;
        public boolean f;
        public xb g;
        public final jp4 h;
        public final jp4 i;
        public boolean j;
        public final it4 k;
        public final boolean l;
        public int m;
        public int n;
        public int o;
        public int p;

        public i(j jVar, it4 it4Var) {
            super(jVar);
            this.d = new jp4();
            this.f = false;
            this.h = new jp4();
            this.i = new jp4();
            this.j = false;
            this.k = it4Var;
            this.l = it4Var.m;
        }

        public final void A(int i, int i2) {
            if (this.l) {
                int i3 = this.o;
                if (i3 > -1) {
                    i = i3;
                }
                this.o = i;
                this.p = i2;
            }
        }

        public final void B() {
            if (this.h.e()) {
                H();
            }
        }

        public final boolean C(String str) {
            xb xbVar = this.g;
            return xbVar != null && xbVar.q(str);
        }

        public final boolean D() {
            return this.g != null;
        }

        public final boolean E() {
            return this.f;
        }

        public final i F(String str) {
            this.d.g(str);
            this.e = g83.a(this.d.h());
            return this;
        }

        public final String G() {
            return this.d.h();
        }

        public final void H() {
            if (this.g == null) {
                this.g = new xb();
            }
            if (this.h.e() && this.g.size() < 512) {
                String strTrim = this.h.h().trim();
                if (!strTrim.isEmpty()) {
                    this.g.c(strTrim, this.i.e() ? this.i.h() : this.j ? "" : null);
                    N(strTrim);
                }
            }
            K();
        }

        public final String I() {
            String str = this.e;
            zy4.b(str == null || str.isEmpty());
            return this.e;
        }

        @Override // defpackage.hp4
        /* JADX INFO: renamed from: J */
        public i o() {
            super.o();
            this.d.f();
            this.e = null;
            this.f = false;
            this.g = null;
            K();
            return this;
        }

        public final void K() {
            this.h.f();
            this.i.f();
            this.j = false;
            if (this.l) {
                this.p = -1;
                this.o = -1;
                this.n = -1;
                this.m = -1;
            }
        }

        public final void L() {
            this.j = true;
        }

        public final String M() {
            String strH = this.d.h();
            return strH.isEmpty() ? "[unset]" : strH;
        }

        public final void N(String str) {
            if (this.l && n()) {
                it4 it4Var = e().k;
                xs xsVar = it4Var.b;
                if (!it4Var.h.e()) {
                    str = z33.a(str);
                }
                if (this.g.G(str).a().a()) {
                    return;
                }
                if (!this.i.e()) {
                    int i = this.n;
                    this.p = i;
                    this.o = i;
                }
                int i2 = this.m;
                sn3.b bVar = new sn3.b(i2, xsVar.n0(i2), xsVar.L(this.m));
                int i3 = this.n;
                sn3 sn3Var = new sn3(bVar, new sn3.b(i3, xsVar.n0(i3), xsVar.L(this.n)));
                int i4 = this.o;
                sn3.b bVar2 = new sn3.b(i4, xsVar.n0(i4), xsVar.L(this.o));
                int i5 = this.p;
                this.g.F(str, new sn3.a(sn3Var, new sn3(bVar2, new sn3.b(i5, xsVar.n0(i5), xsVar.L(this.p)))));
            }
        }

        public final void s(char c, int i, int i2) {
            this.h.a(c);
            z(i, i2);
        }

        public final void t(String str, int i, int i2) {
            this.h.b(str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER));
            z(i, i2);
        }

        public final void u(char c, int i, int i2) {
            this.i.a(c);
            A(i, i2);
        }

        public final void v(String str, int i, int i2) {
            this.i.b(str);
            A(i, i2);
        }

        public final void w(int[] iArr, int i, int i2) {
            for (int i3 : iArr) {
                this.i.c(i3);
            }
            A(i, i2);
        }

        public final void x(char c) {
            y(String.valueOf(c));
        }

        public final void y(String str) {
            this.d.b(str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER));
            this.e = g83.a(this.d.h());
        }

        public final void z(int i, int i2) {
            if (this.l) {
                int i3 = this.m;
                if (i3 > -1) {
                    i = i3;
                }
                this.m = i;
                this.n = i2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum j {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        XmlDecl,
        EOF
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k extends i {
        public boolean q;

        public k(it4 it4Var) {
            super(j.XmlDecl, it4Var);
            this.q = true;
        }

        @Override // hp4.i, defpackage.hp4
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public k o() {
            super.o();
            this.q = true;
            return this;
        }

        public String toString() {
            boolean z = this.q;
            String str = z ? "<!" : "<?";
            String str2 = z ? ">" : "?>";
            if (!D() || this.g.size() <= 0) {
                return str + M() + str2;
            }
            return str + M() + " " + this.g.toString() + str2;
        }
    }

    public hp4(j jVar) {
        this.c = -1;
        this.a = jVar;
    }

    public final c a() {
        return (c) this;
    }

    public final d b() {
        return (d) this;
    }

    public final e c() {
        return (e) this;
    }

    public final g d() {
        return (g) this;
    }

    public final h e() {
        return (h) this;
    }

    public int f() {
        return this.c;
    }

    public void g(int i2) {
        this.c = i2;
    }

    public final boolean h() {
        return this instanceof b;
    }

    public final boolean i() {
        return this.a == j.Character;
    }

    public final boolean j() {
        return this.a == j.Comment;
    }

    public final boolean k() {
        return this.a == j.Doctype;
    }

    public final boolean l() {
        return this.a == j.EOF;
    }

    public final boolean m() {
        return this.a == j.EndTag;
    }

    public final boolean n() {
        return this.a == j.StartTag;
    }

    public hp4 o() {
        this.b = -1;
        this.c = -1;
        return this;
    }

    public int p() {
        return this.b;
    }

    public void q(int i2) {
        this.b = i2;
    }

    public String r() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends hp4 {
        public static final String e = String.valueOf((char) 0);
        public final jp4 d;

        public c(c cVar) {
            super(j.Character);
            jp4 jp4Var = new jp4();
            this.d = jp4Var;
            this.b = cVar.b;
            this.c = cVar.c;
            jp4Var.g(cVar.d.h());
        }

        @Override // defpackage.hp4
        public hp4 o() {
            super.o();
            this.d.f();
            return this;
        }

        public c s(String str) {
            this.d.b(str);
            return this;
        }

        public c t(String str) {
            this.d.g(str);
            return this;
        }

        public String toString() {
            return u();
        }

        public String u() {
            return this.d.h();
        }

        public void v(boolean z) {
            String strH = this.d.h();
            if (strH.indexOf(0) == -1) {
                return;
            }
            this.d.g(z ? strH.replace((char) 0, Utf8.REPLACEMENT_CHARACTER) : strH.replace(e, ""));
        }

        public c() {
            super(j.Character);
            this.d = new jp4();
        }
    }
}
