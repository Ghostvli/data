package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.j;
import defpackage.aa0;
import defpackage.mi2;
import defpackage.rq2;
import defpackage.sy1;
import defpackage.xy1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class l74 implements mi2, xy1.b {
    public final ja0 f;
    public final aa0.a g;
    public final hs4 h;
    public final sy1 i;
    public final rq2.a j;
    public final er4 k;
    public final ArrayList l = new ArrayList();
    public final long m;
    public final xy1 n;
    public final t41 o;
    public final boolean p;
    public boolean q;
    public byte[] r;
    public int s;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements gx3 {
        public int f;
        public boolean g;

        public b() {
        }

        @Override // defpackage.gx3
        public void a() throws IOException {
            l74 l74Var = l74.this;
            if (l74Var.p) {
                return;
            }
            l74Var.n.a();
        }

        public final void b() {
            if (this.g) {
                return;
            }
            l74.this.j.j(nt2.k(l74.this.o.p), l74.this.o, 0, null, 0L);
            this.g = true;
        }

        public void c() {
            if (this.f == 2) {
                this.f = 1;
            }
        }

        @Override // defpackage.gx3
        public int e(long j) {
            b();
            if (j <= 0 || this.f == 2) {
                return 0;
            }
            this.f = 2;
            return 1;
        }

        @Override // defpackage.gx3
        public boolean isReady() {
            return l74.this.q;
        }

        @Override // defpackage.gx3
        public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
            b();
            l74 l74Var = l74.this;
            boolean z = l74Var.q;
            if (z && l74Var.r == null) {
                this.f = 2;
            }
            int i2 = this.f;
            if (i2 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if ((i & 2) != 0 || i2 == 0) {
                u41Var.b = l74Var.o;
                this.f = 1;
                return -5;
            }
            if (!z) {
                return -3;
            }
            gg3.q(l74Var.r);
            decoderInputBuffer.addFlag(1);
            decoderInputBuffer.timeUs = 0L;
            if ((i & 4) == 0) {
                decoderInputBuffer.ensureSpaceForWrite(l74.this.s);
                ByteBuffer byteBuffer = decoderInputBuffer.data;
                l74 l74Var2 = l74.this;
                byteBuffer.put(l74Var2.r, 0, l74Var2.s);
            }
            if ((i & 1) == 0) {
                this.f = 2;
            }
            return -4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements xy1.e {
        public final long a = ty1.b();
        public final ja0 b;
        public final ne4 c;
        public byte[] d;

        public c(ja0 ja0Var, aa0 aa0Var) {
            this.b = ja0Var;
            this.c = new ne4(aa0Var);
        }

        @Override // xy1.e
        public void b() {
            this.c.v();
            try {
                this.c.a(this.b);
                int i = 0;
                while (true) {
                    ne4 ne4Var = this.c;
                    if (i == -1) {
                        ia0.a(ne4Var);
                        return;
                    }
                    int iH = (int) ne4Var.h();
                    byte[] bArr = this.d;
                    if (bArr == null) {
                        this.d = new byte[1024];
                    } else if (iH == bArr.length) {
                        this.d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    ne4 ne4Var2 = this.c;
                    byte[] bArr2 = this.d;
                    i = ne4Var2.read(bArr2, iH, bArr2.length - iH);
                }
            } catch (Throwable th) {
                ia0.a(this.c);
                throw th;
            }
        }

        @Override // xy1.e
        public void c() {
        }
    }

    public l74(ja0 ja0Var, aa0.a aVar, hs4 hs4Var, t41 t41Var, long j, sy1 sy1Var, rq2.a aVar2, boolean z, eq3 eq3Var) {
        this.f = ja0Var;
        this.g = aVar;
        this.h = hs4Var;
        this.o = t41Var;
        this.m = j;
        this.i = sy1Var;
        this.j = aVar2;
        this.p = z;
        this.k = new er4(new br4(t41Var));
        this.n = eq3Var != null ? new xy1(eq3Var) : new xy1("SingleSampleMediaPeriod");
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        if (this.q || this.n.j() || this.n.i()) {
            return false;
        }
        aa0 aa0VarB = this.g.b();
        hs4 hs4Var = this.h;
        if (hs4Var != null) {
            aa0VarB.f(hs4Var);
        }
        this.n.n(new c(this.f, aa0VarB), this, this.i.d(1));
        return true;
    }

    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return (this.q || this.n.j()) ? Long.MIN_VALUE : 0L;
    }

    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        return j;
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void j(c cVar, long j, long j2, boolean z) {
        ne4 ne4Var = cVar.c;
        ty1 ty1Var = new ty1(cVar.a, cVar.b, ne4Var.t(), ne4Var.u(), j, j2, ne4Var.h());
        this.i.c(cVar.a);
        this.j.m(ty1Var, 1, -1, null, 0, null, 0L, this.m);
    }

    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        return this.q ? Long.MIN_VALUE : 0L;
    }

    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void l(c cVar, long j, long j2) {
        this.s = (int) cVar.c.h();
        this.r = (byte[]) gg3.q(cVar.d);
        this.q = true;
        ne4 ne4Var = cVar.c;
        ty1 ty1Var = new ty1(cVar.a, cVar.b, ne4Var.t(), ne4Var.u(), j, j2, this.s);
        this.i.c(cVar.a);
        this.j.p(ty1Var, 1, -1, this.o, 0, null, 0L, this.m);
    }

    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        return this.n.j();
    }

    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        for (int i = 0; i < jy0VarArr.length; i++) {
            gx3 gx3Var = gx3VarArr[i];
            if (gx3Var != null && (jy0VarArr[i] == null || !zArr[i])) {
                this.l.remove(gx3Var);
                gx3VarArr[i] = null;
            }
            if (gx3VarArr[i] == null && jy0VarArr[i] != null) {
                b bVar = new b();
                this.l.add(bVar);
                gx3VarArr[i] = bVar;
                zArr2[i] = true;
            }
        }
        return j;
    }

    @Override // defpackage.mi2
    public void m() {
    }

    @Override // defpackage.mi2
    public long n(long j) {
        for (int i = 0; i < this.l.size(); i++) {
            ((b) this.l.get(i)).c();
        }
        return j;
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public xy1.c v(c cVar, long j, long j2, IOException iOException, int i) {
        xy1.c cVarH;
        ne4 ne4Var = cVar.c;
        ty1 ty1Var = new ty1(cVar.a, cVar.b, ne4Var.t(), ne4Var.u(), j, j2, ne4Var.h());
        long jA = this.i.a(new sy1.c(ty1Var, new oh2(1, -1, this.o, 0, null, 0L, fy4.S1(this.m)), iOException, i));
        boolean z = jA == -9223372036854775807L || i >= this.i.d(1);
        if (this.p && z) {
            xz1.j("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.q = true;
            cVarH = xy1.f;
        } else {
            cVarH = jA != -9223372036854775807L ? xy1.h(false, jA) : xy1.g;
        }
        xy1.c cVar2 = cVarH;
        boolean zC = cVar2.c();
        this.j.r(ty1Var, 1, -1, this.o, 0, null, 0L, this.m, iOException, !zC);
        if (!zC) {
            this.i.c(cVar.a);
        }
        return cVar2;
    }

    @Override // defpackage.mi2
    public long q() {
        return -9223372036854775807L;
    }

    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        aVar.e(this);
    }

    @Override // defpackage.mi2
    public er4 s() {
        return this.k;
    }

    @Override // defpackage.mi2
    public void t(long j, boolean z) {
    }

    @Override // xy1.b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void p(c cVar, long j, long j2, int i) {
        ne4 ne4Var = cVar.c;
        this.j.v(i == 0 ? new ty1(cVar.a, cVar.b, j) : new ty1(cVar.a, cVar.b, ne4Var.t(), ne4Var.u(), j, j2, ne4Var.h()), 1, -1, this.o, 0, null, 0L, this.m, i);
    }

    public void w() {
        this.n.l();
    }
}
