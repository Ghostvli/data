package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.j;
import defpackage.mi2;
import defpackage.xu;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wu implements mi2, mi2.a {
    public final mi2 f;
    public final boolean g;
    public mi2.a h;
    public a[] i;
    public long j;
    public long k;
    public long l;
    public long m;
    public xu.d n;
    public boolean o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements gx3 {
        public final gx3 f;
        public boolean g;

        public a(gx3 gx3Var) {
            this.f = gx3Var;
        }

        @Override // defpackage.gx3
        public void a() {
            this.f.a();
        }

        public void b() {
            this.g = false;
        }

        @Override // defpackage.gx3
        public int e(long j) {
            if (wu.this.x()) {
                return -3;
            }
            return this.f.e(j);
        }

        @Override // defpackage.gx3
        public boolean isReady() {
            return !wu.this.x() && this.f.isReady();
        }

        @Override // defpackage.gx3
        public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (wu.this.x()) {
                return -3;
            }
            if (wu.this.o) {
                int iO = this.f.o(u41Var, decoderInputBuffer, i);
                if (iO != -5) {
                    return iO;
                }
                wu wuVar = wu.this;
                wu.C(u41Var, wuVar.l, wuVar.m);
                return -5;
            }
            if (this.g) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            long jF = wu.this.f();
            int iO2 = this.f.o(u41Var, decoderInputBuffer, i);
            if (wu.this.k != -9223372036854775807L && iO2 != -3) {
                wu.this.k = -9223372036854775807L;
            }
            wu wuVar2 = wu.this;
            if (iO2 == -5) {
                wu.C(u41Var, wuVar2.l, wuVar2.m);
                return -5;
            }
            long j = wuVar2.m;
            if (j == Long.MIN_VALUE || ((iO2 != -4 || decoderInputBuffer.timeUs < j) && !(iO2 == -3 && jF == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys))) {
                return iO2;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.g = true;
            return -4;
        }
    }

    public wu(mi2 mi2Var, boolean z, long j, long j2, boolean z2) {
        this.f = mi2Var;
        this.i = new a[0];
        this.j = z ? j : -9223372036854775807L;
        this.k = -9223372036854775807L;
        this.g = z2;
        B(j, j2);
    }

    public static boolean A(long j, long j2, jy0[] jy0VarArr) {
        if (j < j2) {
            return true;
        }
        if (j != 0) {
            for (jy0 jy0Var : jy0VarArr) {
                if (jy0Var != null) {
                    t41 t41VarL = jy0Var.l();
                    if (!nt2.a(t41VarL.p, t41VarL.k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void C(u41 u41Var, long j, long j2) {
        t41 t41Var = (t41) gg3.q(u41Var.b);
        int i = t41Var.K;
        if (i == 0 && t41Var.L == 0) {
            return;
        }
        if (j != 0) {
            i = 0;
        }
        u41Var.b = t41Var.b().e0(i).f0(j2 == Long.MIN_VALUE ? t41Var.L : 0).Q();
    }

    public static long w(long j, long j2, long j3) {
        long jMax = Math.max(j, j2);
        return j3 != Long.MIN_VALUE ? Math.min(jMax, j3) : jMax;
    }

    public void B(long j, long j2) {
        this.l = j;
        this.m = j2;
        if (this.g) {
            long jH = this.f.h(j2);
            gg3.z(jH == Long.MIN_VALUE || jH == j2, "Period updating end positions not supported, %s!=%s", jH, j2);
            this.o = jH == j2;
        }
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        return this.f.b(jVar);
    }

    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        long jC = this.f.c();
        if (!this.o) {
            if (jC != Long.MIN_VALUE) {
                long j = this.m;
                if (j == Long.MIN_VALUE || jC < j) {
                }
            }
            return Long.MIN_VALUE;
        }
        long j2 = this.m;
        if (j2 != Long.MIN_VALUE && jC != Long.MIN_VALUE) {
            return Math.min(j2, jC);
        }
        return jC;
    }

    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        long j2 = this.l;
        if (j == j2) {
            return j2;
        }
        return this.f.d(j, v(j, zz3Var));
    }

    @Override // mi2.a
    public void e(mi2 mi2Var) {
        if (this.n != null) {
            return;
        }
        ((mi2.a) gg3.q(this.h)).e(this);
    }

    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        long jF = this.f.f();
        if (!this.o) {
            if (jF != Long.MIN_VALUE) {
                long j = this.m;
                if (j == Long.MIN_VALUE || jF < j) {
                }
            }
            return Long.MIN_VALUE;
        }
        long j2 = this.m;
        if (j2 != Long.MIN_VALUE && jF != Long.MIN_VALUE) {
            return Math.min(j2, jF);
        }
        return jF;
    }

    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
        this.f.g(j);
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return this.f.isLoading();
    }

    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        this.i = new a[gx3VarArr.length];
        gx3[] gx3VarArr2 = new gx3[gx3VarArr.length];
        int i = 0;
        while (true) {
            gx3 gx3Var = null;
            if (i >= gx3VarArr.length) {
                break;
            }
            a[] aVarArr = this.i;
            a aVar = (a) gx3VarArr[i];
            aVarArr[i] = aVar;
            if (aVar != null) {
                gx3Var = aVar.f;
            }
            gx3VarArr2[i] = gx3Var;
            i++;
        }
        long jK = this.f.k(jy0VarArr, zArr, gx3VarArr2, zArr2, j);
        long jW = w(jK, j, this.m);
        this.j = (x() && A(jK, j, jy0VarArr)) ? jW : -9223372036854775807L;
        for (int i2 = 0; i2 < gx3VarArr.length; i2++) {
            gx3 gx3Var2 = gx3VarArr2[i2];
            a[] aVarArr2 = this.i;
            if (gx3Var2 == null) {
                aVarArr2[i2] = null;
            } else {
                a aVar2 = aVarArr2[i2];
                if (aVar2 == null || aVar2.f != gx3Var2) {
                    aVarArr2[i2] = new a(gx3Var2);
                }
            }
            gx3VarArr[i2] = this.i[i2];
        }
        return jW;
    }

    @Override // defpackage.mi2
    public void m() throws xu.d {
        xu.d dVar = this.n;
        if (dVar != null) {
            throw dVar;
        }
        this.f.m();
    }

    @Override // defpackage.mi2
    public long n(long j) {
        this.j = -9223372036854775807L;
        for (a aVar : this.i) {
            if (aVar != null) {
                aVar.b();
            }
        }
        return w(this.f.n(j), this.l, this.m);
    }

    @Override // defpackage.mi2
    public long q() {
        if (x()) {
            long j = this.j;
            this.j = -9223372036854775807L;
            this.k = j;
            long jQ = q();
            return jQ != -9223372036854775807L ? jQ : j;
        }
        long jQ2 = this.f.q();
        if (jQ2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jW = w(jQ2, this.l, this.m);
        if (jW == this.k) {
            return -9223372036854775807L;
        }
        this.k = jW;
        return jW;
    }

    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        this.h = aVar;
        this.f.r(this, j);
    }

    @Override // defpackage.mi2
    public er4 s() {
        return this.f.s();
    }

    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        this.f.t(j, z);
    }

    public final zz3 v(long j, zz3 zz3Var) {
        long jT = fy4.t(zz3Var.a, 0L, j - this.l);
        long j2 = zz3Var.b;
        long j3 = this.m;
        long jT2 = fy4.t(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (jT == zz3Var.a && jT2 == zz3Var.b) ? zz3Var : new zz3(jT, jT2);
    }

    public boolean x() {
        return this.j != -9223372036854775807L;
    }

    @Override // i14.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(mi2 mi2Var) {
        ((mi2.a) gg3.q(this.h)).j(this);
    }

    public void z(xu.d dVar) {
        this.n = dVar;
    }

    public wu(mi2 mi2Var, boolean z, long j, long j2) {
        this(mi2Var, z, j, j2, false);
    }
}
