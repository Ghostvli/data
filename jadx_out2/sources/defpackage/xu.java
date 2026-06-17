package defpackage;

import defpackage.jq2;
import defpackage.no4;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xu extends fa5 {
    public c A;
    public d B;
    public long C;
    public long D;
    public final long r;
    public final long s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final ArrayList y;
    public final no4.d z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final jq2 a;
        public long b;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean d = true;
        public long c = Long.MIN_VALUE;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(jq2 jq2Var) {
            this.a = (jq2) gg3.q(jq2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public xu i() {
            this.i = true;
            return new xu(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b j(boolean z) {
            gg3.v(!this.i);
            this.e = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b k(boolean z) {
            gg3.v(!this.i);
            this.g = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b l(boolean z) {
            gg3.v(!this.i);
            this.h = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b m(boolean z) {
            gg3.v(!this.i);
            this.d = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b n(long j) {
            gg3.v(!this.i);
            this.c = j;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b o(boolean z) {
            gg3.v(!this.i);
            this.f = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b p(long j) {
            gg3.d(j >= 0);
            gg3.v(!this.i);
            this.b = j;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends i51 {
        public final long f;
        public final long g;
        public final long h;
        public final boolean i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(no4 no4Var, long j, long j2, boolean z) throws d {
            super(no4Var);
            if (j2 != Long.MIN_VALUE && j2 < j) {
                throw new d(2, j, j2);
            }
            boolean z2 = false;
            if (no4Var.o() != 1) {
                throw new d(0);
            }
            no4.d dVarT = no4Var.t(0, new no4.d());
            long jMax = Math.max(0L, j);
            if (!z && !dVarT.k && jMax != 0 && !dVarT.h) {
                throw new d(1);
            }
            long jMax2 = j2 == Long.MIN_VALUE ? dVarT.m : Math.max(0L, j2);
            long j3 = dVarT.m;
            if (j3 != -9223372036854775807L) {
                jMax2 = jMax2 > j3 ? j3 : jMax2;
                if (jMax > jMax2) {
                    jMax = jMax2;
                }
            }
            this.f = jMax;
            this.g = jMax2;
            this.h = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (dVarT.i && (jMax2 == -9223372036854775807L || (j3 != -9223372036854775807L && jMax2 == j3))) {
                z2 = true;
            }
            this.i = z2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i51, defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            this.e.m(0, bVar, z);
            long jP = bVar.p() - this.f;
            long j = this.h;
            return bVar.u(bVar.a, bVar.b, 0, j != -9223372036854775807L ? j - jP : -9223372036854775807L, jP);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i51, defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            this.e.u(0, dVar, 0L);
            long j2 = dVar.p;
            long j3 = this.f;
            dVar.p = j2 + j3;
            dVar.m = this.h;
            dVar.i = this.i;
            long j4 = dVar.l;
            if (j4 != -9223372036854775807L) {
                long jMax = Math.max(j4, j3);
                dVar.l = jMax;
                long j5 = this.g;
                if (j5 != -9223372036854775807L) {
                    jMax = Math.min(jMax, j5);
                }
                dVar.l = jMax - this.f;
            }
            long jS1 = fy4.S1(this.f);
            long j6 = dVar.e;
            if (j6 != -9223372036854775807L) {
                dVar.e = j6 + jS1;
            }
            long j7 = dVar.f;
            if (j7 != -9223372036854775807L) {
                dVar.f = j7 + jS1;
            }
            return dVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xu(b bVar) {
        super(bVar.a);
        this.r = bVar.b;
        this.s = bVar.c;
        this.t = bVar.d;
        this.u = bVar.e;
        this.v = bVar.f;
        this.w = bVar.g;
        this.x = bVar.h;
        this.y = new ArrayList();
        this.z = new no4.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oy, defpackage.ji
    public void G() {
        super.G();
        this.B = null;
        this.A = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fa5
    public void V(no4 no4Var) {
        if (this.B != null) {
            return;
        }
        Z(no4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Z(no4 no4Var) {
        long j;
        no4Var.t(0, this.z);
        long jF = this.z.f();
        if (this.A == null || this.y.isEmpty() || this.u) {
            j = this.r;
            long j2 = this.s;
            if (this.v) {
                long jD = this.z.d();
                j += jD;
                j2 += jD;
            }
            this.C = jF + j;
            this.D = this.s != Long.MIN_VALUE ? jF + j2 : Long.MIN_VALUE;
            int size = this.y.size();
            for (int i = 0; i < size; i++) {
                ((wu) this.y.get(i)).B(this.C, this.D);
            }
            j = j2;
        } else {
            j = this.C - jF;
            if (this.s != Long.MIN_VALUE) {
                j = this.D - jF;
            }
        }
        try {
            c cVar = new c(no4Var, j, j, this.w);
            this.A = cVar;
            F(cVar);
        } catch (d e) {
            this.B = e;
            for (int i2 = 0; i2 < this.y.size(); i2++) {
                ((wu) this.y.get(i2)).z(this.B);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        return i().f.equals(fg2Var.f) && this.p.a(fg2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        wu wuVar = new wu(this.p.d(bVar, j5Var, j), this.t, this.C, this.D, this.x);
        this.y.add(wuVar);
        return wuVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oy, defpackage.jq2
    public void m() throws d {
        d dVar = this.B;
        if (dVar != null) {
            throw dVar;
        }
        super.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        gg3.v(this.y.remove(mi2Var));
        this.p.s(((wu) mi2Var).f);
        if (!this.y.isEmpty() || this.u) {
            return;
        }
        Z(((c) gg3.q(this.A)).e);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends IOException {
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(int i, long j, long j2) {
            super("Illegal clipping: " + a(i, j, j2));
            this.f = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static String a(int i, long j, long j2) {
            if (i == 0) {
                return "invalid period count";
            }
            if (i == 1) {
                return "not seekable to start";
            }
            if (i != 2) {
                return "unknown";
            }
            gg3.v((j == -9223372036854775807L || j2 == -9223372036854775807L) ? false : true);
            return "start exceeds end. Start time: " + j + ", End time: " + j2;
        }

        public d(int i) {
            this(i, -9223372036854775807L, -9223372036854775807L);
        }
    }
}
