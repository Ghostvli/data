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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gz0(wf4 wf4Var, vt1 vt1Var) {
        Objects.requireNonNull(wf4Var, "service is null");
        this.b = wf4Var;
        Objects.requireNonNull(vt1Var, "LinkHandler is null");
        this.c = vt1Var;
        gn0 gn0VarA = a33.a();
        Objects.requireNonNull(gn0VarA, "downloader is null");
        this.g = gn0VarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a() {
        if (this.f) {
            return;
        }
        e04.a("Page is not fetched. Make sure you call fetchPage()");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        kz0.a(this.a, "base fetchPage called");
        if (this.f) {
            kz0.a(this.a, "Page already fetched; returning");
        } else {
            p(this.g);
            this.f = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(pz1 pz1Var) {
        this.d = pz1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String d() {
        return this.c.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gn0 e() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public m20 f() {
        m20 m20Var = this.e;
        return m20Var == null ? l().b() : m20Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pz1 g() {
        pz1 pz1Var = this.d;
        return pz1Var == null ? l().d() : pz1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String h() {
        return this.c.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vt1 i() {
        return this.c;
    }

    public abstract String j();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String k() {
        return this.c.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wf4 l() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m() {
        return this.b.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public go4 n() {
        return l().l(g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String o() {
        return this.c.d();
    }

    public abstract void p(gn0 gn0Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return getClass().getSimpleName();
    }
}
