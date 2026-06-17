package defpackage;

import android.content.Context;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class l25 {
    public final b a;
    public final n25 b;
    public final long c;
    public boolean d;
    public long g;
    public boolean j;
    public boolean m;
    public boolean n;
    public boolean o;
    public int e = 0;
    public long f = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public long i = -9223372036854775807L;
    public float k = 1.0f;
    public zu l = zu.a;
    public boolean p = true;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public long a = -9223372036854775807L;
        public long b = -9223372036854775807L;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long f() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long g() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h() {
            this.a = -9223372036854775807L;
            this.b = -9223372036854775807L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        boolean A(long j, long j2, boolean z);

        boolean K(long j, long j2);

        boolean g(long j, long j2, long j3, boolean z, boolean z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l25(Context context, b bVar, long j) {
        this.a = bVar;
        this.c = j;
        this.b = new n25(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a() {
        if (this.e == 0) {
            this.e = 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long b(long j, long j2, long j3) {
        long j4 = (long) ((j3 - j) / ((double) this.k));
        return this.d ? j4 - (fy4.c1(this.l.e()) - j2) : j4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c(long j, long j2, long j3, long j4, boolean z, boolean z2, a aVar) {
        aVar.h();
        if (this.d && this.f == -9223372036854775807L) {
            this.f = j2;
        }
        if (this.h != j) {
            this.b.f(j);
            this.h = j;
        }
        aVar.a = b(j2, j3, j);
        if (z && !z2) {
            return 3;
        }
        if (!this.m && this.p) {
            if (this.a.g(aVar.a, j2, j3, z2, true)) {
                return 4;
            }
            if (this.d && aVar.a < 30000) {
                return 3;
            }
            this.n = true;
            return 5;
        }
        if (!this.p) {
            this.n = true;
        }
        if (q(j2, aVar.a, j4)) {
            return 0;
        }
        if (!this.d || j2 == this.f) {
            return 5;
        }
        long jNanoTime = this.l.nanoTime();
        aVar.b = this.b.a((aVar.a * 1000) + jNanoTime, j);
        aVar.a = (aVar.b - jNanoTime) / 1000;
        boolean z3 = (this.i == -9223372036854775807L || this.j) ? false : true;
        if (this.a.g(aVar.a, j2, j3, z2, z3)) {
            return 4;
        }
        return this.a.A(aVar.a, j3, z2) ? z3 ? 3 : 2 : aVar.a > 50000 ? 5 : 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d(boolean z) {
        if (z && (this.e == 3 || (this.n && (!this.m || !this.p)))) {
            this.i = -9223372036854775807L;
            return true;
        }
        if (this.i == -9223372036854775807L) {
            return false;
        }
        if (this.l.e() < this.i) {
            return true;
        }
        this.i = -9223372036854775807L;
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(boolean z) {
        this.j = z;
        this.i = this.c > 0 ? this.l.e() + this.c : -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(int i) {
        this.e = Math.min(this.e, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g() {
        boolean z = this.e != 3;
        this.e = 3;
        this.g = fy4.c1(this.l.e());
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        this.d = true;
        this.g = fy4.c1(this.l.e());
        this.b.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i() {
        this.d = false;
        this.i = -9223372036854775807L;
        this.b.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(int i) {
        if (i == 0) {
            this.e = 1;
        } else if (i == 1) {
            this.e = 0;
        } else {
            if (i != 2) {
                z20.a();
                return;
            }
            f(2);
        }
        this.b.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k() {
        this.b.h();
        this.h = -9223372036854775807L;
        this.f = -9223372036854775807L;
        f(1);
        this.i = -9223372036854775807L;
        this.n = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(int i) {
        this.b.m(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(zu zuVar) {
        this.l = zuVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n(float f) {
        this.b.e(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(Surface surface) {
        this.m = surface != null;
        this.n = false;
        this.b.k(surface);
        f(1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(float f) {
        gg3.d(f > 0.0f);
        if (f == this.k) {
            return;
        }
        this.k = f;
        this.b.g(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean q(long j, long j2, long j3) {
        if (this.i != -9223372036854775807L && !this.j) {
            return false;
        }
        int i = this.e;
        if (i == 0) {
            return this.d;
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return j >= j3;
        }
        if (i != 3) {
            z20.a();
            return false;
        }
        long jC1 = fy4.c1(this.l.e()) - this.g;
        if (this.d) {
            if (!this.o) {
                long j4 = this.f;
                if (j4 != -9223372036854775807L && j4 != j) {
                    if (this.a.K(j2, jC1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
