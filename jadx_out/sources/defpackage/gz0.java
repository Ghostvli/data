package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gz0 {
    public final wf4 b;
    public final vt1 c;
    public final gn0 g;
    public final String a = getClass().getSimpleName() + "@" + hashCode();
    public pz1 d = null;
    public m20 e = null;
    public boolean f = false;

    public gz0(wf4 wf4Var, vt1 vt1Var) {
        Objects.requireNonNull(wf4Var, "service is null");
        this.b = wf4Var;
        Objects.requireNonNull(vt1Var, "LinkHandler is null");
        this.c = vt1Var;
        gn0 gn0VarA = a33.a();
        Objects.requireNonNull(gn0VarA, "downloader is null");
        this.g = gn0VarA;
    }

    public void a() {
        if (this.f) {
            return;
        }
        e04.a("Page is not fetched. Make sure you call fetchPage()");
    }

    public void b() {
        kz0.a(this.a, "base fetchPage called");
        if (this.f) {
            kz0.a(this.a, "Page already fetched; returning");
        } else {
            p(this.g);
            this.f = true;
        }
    }

    public void c(pz1 pz1Var) {
        this.d = pz1Var;
    }

    public String d() {
        return this.c.a();
    }

    public gn0 e() {
        return this.g;
    }

    public m20 f() {
        m20 m20Var = this.e;
        return m20Var == null ? l().b() : m20Var;
    }

    public pz1 g() {
        pz1 pz1Var = this.d;
        return pz1Var == null ? l().d() : pz1Var;
    }

    public String h() {
        return this.c.b();
    }

    public vt1 i() {
        return this.c;
    }

    public abstract String j();

    public String k() {
        return this.c.c();
    }

    public wf4 l() {
        return this.b;
    }

    public int m() {
        return this.b.f();
    }

    public go4 n() {
        return l().l(g());
    }

    public String o() {
        return this.c.d();
    }

    public abstract void p(gn0 gn0Var);

    public String toString() {
        return getClass().getSimpleName();
    }
}
