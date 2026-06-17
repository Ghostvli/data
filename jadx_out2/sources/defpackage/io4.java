package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.j;
import defpackage.mi2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class io4 implements mi2, mi2.a {
    public final mi2 f;
    public final long g;
    public mi2.a h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements gx3 {
        public final gx3 f;
        public final long g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(gx3 gx3Var, long j) {
            this.f = gx3Var;
            this.g = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public void a() {
            this.f.a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public gx3 b() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public int e(long j) {
            return this.f.e(j - this.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public boolean isReady() {
            return this.f.isReady();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
            int iO = this.f.o(u41Var, decoderInputBuffer, i);
            if (iO == -4) {
                decoderInputBuffer.timeUs += this.g;
            }
            return iO;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public io4(mi2 mi2Var, long j) {
        this.f = mi2Var;
        this.g = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mi2 a() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        return this.f.b(jVar.a().f(jVar.a - this.g).d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        long jC = this.f.c();
        if (jC == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jC + this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        return this.f.d(j - this.g, zz3Var) + this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // mi2.a
    public void e(mi2 mi2Var) {
        ((mi2.a) gg3.q(this.h)).e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        long jF = this.f.f();
        if (jF == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jF + this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
        this.f.g(j - this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long h(long j) {
        long jH = this.f.h(j == Long.MIN_VALUE ? Long.MIN_VALUE : j - this.g);
        if (jH == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jH + this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return this.f.isLoading();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        gx3[] gx3VarArr2 = new gx3[gx3VarArr.length];
        int i = 0;
        while (true) {
            gx3 gx3VarB = null;
            if (i >= gx3VarArr.length) {
                break;
            }
            a aVar = (a) gx3VarArr[i];
            if (aVar != null) {
                gx3VarB = aVar.b();
            }
            gx3VarArr2[i] = gx3VarB;
            i++;
        }
        long jK = this.f.k(jy0VarArr, zArr, gx3VarArr2, zArr2, j - this.g);
        for (int i2 = 0; i2 < gx3VarArr.length; i2++) {
            gx3 gx3Var = gx3VarArr2[i2];
            if (gx3Var == null) {
                gx3VarArr[i2] = null;
            } else {
                gx3 gx3Var2 = gx3VarArr[i2];
                if (gx3Var2 == null || ((a) gx3Var2).b() != gx3Var) {
                    gx3VarArr[i2] = new a(gx3Var, this.g);
                }
            }
        }
        return jK + this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void m() {
        this.f.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long n(long j) {
        return this.f.n(j - this.g) + this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Li14;)V */
    @Override // i14.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(mi2 mi2Var) {
        ((mi2.a) gg3.q(this.h)).j(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long q() {
        long jQ = this.f.q();
        if (jQ == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jQ + this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        this.h = aVar;
        this.f.r(this, j - this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public er4 s() {
        return this.f.s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        this.f.t(j - this.g, z);
    }
}
