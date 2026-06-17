package defpackage;

import defpackage.hp4;
import defpackage.sn3;
import java.io.Reader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class it4 {
    public o83 a;
    public xs b;
    public np4 c;
    public wm0 d;
    public ArrayList e;
    public String f;
    public hp4 g;
    public g83 h;
    public ql4 i;
    public r33 j;
    public hp4.h k;
    public final hp4.g l = new hp4.g(this);
    public boolean m;

    public void A(l33 l33Var, boolean z) {
        if (this.m) {
            hp4 hp4Var = this.g;
            int iP = hp4Var.p();
            int iF = hp4Var.f();
            if (l33Var instanceof br0) {
                br0 br0Var = (br0) l33Var;
                if (hp4Var.l()) {
                    if (br0Var.s0().a()) {
                        return;
                    } else {
                        iP = this.b.A0();
                    }
                } else if (!z ? !(br0Var.U0().e() || br0Var.U0().h() || (hp4Var.m() && br0Var.G().equals(hp4Var.d().e))) : !(hp4Var.n() && br0Var.G().equals(hp4Var.e().e))) {
                }
                iF = iP;
            }
            l33Var.f().H(z ? "jsoup.start" : "jsoup.end", new sn3(new sn3.b(iP, this.b.n0(iP), this.b.L(iP)), new sn3.b(iF, this.b.n0(iF), this.b.L(iF))));
        }
    }

    public void a() {
        xs xsVar = this.b;
        if (xsVar == null) {
            return;
        }
        xsVar.close();
        this.b = null;
        this.c = null;
        this.e = null;
    }

    public br0 b() {
        int size = this.e.size();
        return size > 0 ? (br0) this.e.get(size - 1) : this.d;
    }

    public boolean c(String str) {
        br0 br0VarB;
        return this.e.size() != 0 && (br0VarB = b()) != null && br0VarB.G().equals(str) && br0VarB.U0().i().equals("http://www.w3.org/1999/xhtml");
    }

    public boolean d(String str, String str2) {
        br0 br0VarB;
        return this.e.size() != 0 && (br0VarB = b()) != null && br0VarB.G().equals(str) && br0VarB.U0().i().equals(str2);
    }

    public int e() {
        return 512;
    }

    public String f() {
        return "http://www.w3.org/1999/xhtml";
    }

    public abstract g83 g();

    public ql4 h() {
        return ql4.o();
    }

    public final void i() {
        int iD = this.a.d();
        if (iD == Integer.MAX_VALUE) {
            return;
        }
        while (this.e.size() >= iD) {
            p(r());
        }
    }

    public void j(String str) {
        k(str, null);
    }

    public void k(String str, Object... objArr) {
        y73 y73VarC = this.a.c();
        if (y73VarC.b()) {
            y73VarC.add(new x73(this.b, str, objArr));
        }
    }

    public void l(Reader reader, String str, o83 o83Var) {
        zy4.l(reader, "input");
        zy4.l(str, "baseUri");
        zy4.j(o83Var);
        wm0 wm0Var = new wm0(o83Var.b(), str);
        this.d = wm0Var;
        wm0Var.g1(o83Var);
        this.a = o83Var;
        this.h = o83Var.j();
        this.b = new xs(reader);
        this.m = o83Var.h();
        this.b.G0(o83Var.g() || this.m);
        if (o83Var.g()) {
            o83Var.c().clear();
        }
        this.c = new np4(this);
        this.e = new ArrayList(32);
        this.i = o83Var.k();
        hp4.h hVar = new hp4.h(this);
        this.k = hVar;
        this.g = hVar;
        this.f = str;
        o(this.d);
    }

    public abstract it4 m();

    public void n(l33 l33Var) {
        A(l33Var, false);
        r33 r33Var = this.j;
        if (r33Var != null) {
            r33Var.b(l33Var, this.e.size());
        }
    }

    public void o(l33 l33Var) {
        A(l33Var, true);
        r33 r33Var = this.j;
        if (r33Var != null) {
            r33Var.a(l33Var, this.e.size());
        }
    }

    public abstract void p(br0 br0Var);

    public wm0 q(Reader reader, String str, o83 o83Var) {
        l(reader, str, o83Var);
        w();
        return this.d;
    }

    public br0 r() {
        br0 br0Var = (br0) this.e.remove(this.e.size() - 1);
        n(br0Var);
        return br0Var;
    }

    public abstract boolean s(hp4 hp4Var);

    public boolean t(String str) {
        hp4 hp4Var = this.g;
        hp4.g gVar = this.l;
        return hp4Var == gVar ? s(new hp4.g(this).F(str)) : s(gVar.o().F(str));
    }

    public boolean u(String str) {
        hp4.h hVar = this.k;
        return this.g == hVar ? s(new hp4.h(this).F(str)) : s(hVar.o().F(str));
    }

    public final void v(br0 br0Var) {
        this.e.add(br0Var);
        o(br0Var);
    }

    public void w() {
        while (x()) {
        }
        a();
    }

    public boolean x() {
        if (this.g.a != hp4.j.EOF) {
            hp4 hp4VarW = this.c.w();
            this.g = hp4VarW;
            s(hp4VarW);
            hp4VarW.o();
            return true;
        }
        ArrayList arrayList = this.e;
        if (arrayList == null) {
            return false;
        }
        if (!arrayList.isEmpty()) {
            r();
            return true;
        }
        n(this.d);
        this.e = null;
        return true;
    }

    public al4 y(hp4.i iVar) {
        return this.i.w(iVar.G(), iVar.e, f(), this.h.f());
    }

    public al4 z(String str, String str2, String str3, g83 g83Var) {
        return this.i.w(str, str2, str3, g83Var.f());
    }
}
