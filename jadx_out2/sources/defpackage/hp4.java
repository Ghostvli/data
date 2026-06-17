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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str) {
            t(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hp4.c
        public String toString() {
            return DOM.CDATA_BEGIN + u() + DOM.CDATA_END;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends hp4 {
        public final jp4 d;
        public boolean e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
            super(j.Comment);
            this.d = new jp4();
            this.e = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hp4
        public hp4 o() {
            super.o();
            this.d.f();
            this.e = false;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d s(char c) {
            this.d.a(c);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d t(String str) {
            this.d.b(str);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "<!--" + u() + "-->";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
            super(j.Doctype);
            this.d = new jp4();
            this.e = null;
            this.f = new jp4();
            this.g = new jp4();
            this.h = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String s() {
            return this.d.h();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String t() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "<!doctype " + s() + ">";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String u() {
            return this.f.h();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String v() {
            return this.g.h();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean w() {
            return this.h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends hp4 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f() {
            super(j.EOF);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hp4
        public hp4 o() {
            super.o();
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends i {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(it4 it4Var) {
            super(j.EndTag, it4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "</" + M() + ">";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends i {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(it4 it4Var) {
            super(j.StartTag, it4Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: o()Lhp4; */
        @Override // hp4.i, defpackage.hp4
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public i o() {
            super.o();
            this.g = null;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void B() {
            if (this.h.e()) {
                H();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean C(String str) {
            xb xbVar = this.g;
            return xbVar != null && xbVar.q(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean D() {
            return this.g != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean E() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final i F(String str) {
            this.d.g(str);
            this.e = g83.a(this.d.h());
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String G() {
            return this.d.h();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String I() {
            String str = this.e;
            zy4.b(str == null || str.isEmpty());
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: o()Lhp4; */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void L() {
            this.j = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String M() {
            String strH = this.d.h();
            return strH.isEmpty() ? "[unset]" : strH;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void s(char c, int i, int i2) {
            this.h.a(c);
            z(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void t(String str, int i, int i2) {
            this.h.b(str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER));
            z(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void u(char c, int i, int i2) {
            this.i.a(c);
            A(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void v(String str, int i, int i2) {
            this.i.b(str);
            A(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void w(int[] iArr, int i, int i2) {
            for (int i3 : iArr) {
                this.i.c(i3);
            }
            A(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void x(char c) {
            y(String.valueOf(c));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void y(String str) {
            this.d.b(str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER));
            this.e = g83.a(this.d.h());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public k(it4 it4Var) {
            super(j.XmlDecl, it4Var);
            this.q = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: J()Lhp4$i; */
        /* JADX DEBUG: Method merged with bridge method: o()Lhp4; */
        @Override // hp4.i, defpackage.hp4
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public k o() {
            super.o();
            this.q = true;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hp4(j jVar) {
        this.c = -1;
        this.a = jVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c a() {
        return (c) this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final d b() {
        return (d) this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final e c() {
        return (e) this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final g d() {
        return (g) this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final h e() {
        return (h) this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int f() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(int i2) {
        this.c = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h() {
        return this instanceof b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i() {
        return this.a == j.Character;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean j() {
        return this.a == j.Comment;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean k() {
        return this.a == j.Doctype;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l() {
        return this.a == j.EOF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m() {
        return this.a == j.EndTag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n() {
        return this.a == j.StartTag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hp4 o() {
        this.b = -1;
        this.c = -1;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int p() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(int i2) {
        this.b = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String r() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends hp4 {
        public static final String e = String.valueOf((char) 0);
        public final jp4 d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(c cVar) {
            super(j.Character);
            jp4 jp4Var = new jp4();
            this.d = jp4Var;
            this.b = cVar.b;
            this.c = cVar.c;
            jp4Var.g(cVar.d.h());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hp4
        public hp4 o() {
            super.o();
            this.d.f();
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c s(String str) {
            this.d.b(str);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c t(String str) {
            this.d.g(str);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return u();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String u() {
            return this.d.h();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
