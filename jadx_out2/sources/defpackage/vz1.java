package defpackage;

import defpackage.sz0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vz1 implements yr3, sz0.f {
    public static final tf3 j = sz0.d(20, new a());
    public final je4 f = je4.a();
    public yr3 g;
    public boolean h;
    public boolean i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements sz0.d {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
        @Override // sz0.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public vz1 create() {
            return new vz1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static vz1 e(yr3 yr3Var) {
        vz1 vz1Var = (vz1) fg3.e((vz1) j.a());
        vz1Var.a(yr3Var);
        return vz1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void f() {
        this.g = null;
        j.b(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(yr3 yr3Var) {
        this.i = false;
        this.h = true;
        this.g = yr3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yr3
    public synchronized void b() {
        this.f.c();
        this.i = true;
        if (!this.h) {
            this.g.b();
            f();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yr3
    public int c() {
        return this.g.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yr3
    public Class d() {
        return this.g.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // sz0.f
    public je4 g() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yr3
    public Object get() {
        return this.g.get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void h() {
        this.f.c();
        if (!this.h) {
            throw new IllegalStateException("Already unlocked");
        }
        this.h = false;
        if (this.i) {
            b();
        }
    }
}
