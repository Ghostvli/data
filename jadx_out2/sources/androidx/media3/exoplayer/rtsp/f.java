package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import android.os.Handler;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.rtsp.RtspMediaSource;
import androidx.media3.exoplayer.rtsp.a;
import androidx.media3.exoplayer.rtsp.b;
import androidx.media3.exoplayer.rtsp.d;
import androidx.media3.exoplayer.rtsp.f;
import androidx.media3.exoplayer.rtsp.g;
import defpackage.br4;
import defpackage.er4;
import defpackage.ex3;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.gr4;
import defpackage.gx3;
import defpackage.j5;
import defpackage.jy0;
import defpackage.mi2;
import defpackage.mz0;
import defpackage.rv3;
import defpackage.t41;
import defpackage.u41;
import defpackage.xi1;
import defpackage.xy1;
import defpackage.yv3;
import defpackage.yz3;
import defpackage.z20;
import defpackage.zv3;
import defpackage.zz3;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements mi2 {
    public boolean A;
    public final j5 f;
    public final Handler g = fy4.E();
    public final c h;
    public final androidx.media3.exoplayer.rtsp.d i;
    public final List j;
    public final List k;
    public final d l;
    public final a.InterfaceC0021a m;
    public mi2.a n;
    public xi1 o;
    public IOException p;
    public RtspMediaSource.c q;
    public long r;
    public long s;
    public long t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements mz0 {
        public final gr4 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(gr4 gr4Var) {
            this.f = gr4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mz0
        public gr4 e(int i, int i2) {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mz0
        public void o() {
            Handler handler = f.this.g;
            final f fVar = f.this;
            handler.post(new Runnable() { // from class: ov3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    fVar.T();
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mz0
        public void u(yz3 yz3Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements xy1.b, ex3.d, d.f, d.e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.rtsp.d.f
        public void a(yv3 yv3Var, xi1 xi1Var) {
            for (int i = 0; i < xi1Var.size(); i++) {
                rv3 rv3Var = (rv3) xi1Var.get(i);
                f fVar = f.this;
                C0023f c0023f = fVar.new C0023f(rv3Var, i, fVar.m);
                f.this.j.add(c0023f);
                c0023f.k();
            }
            f.this.l.a(yv3Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.rtsp.d.f
        public void b(String str, Throwable th) {
            f.this.p = th == null ? new IOException(str) : new IOException(str, th);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.rtsp.d.e
        public void c() {
            long j = f.this.s;
            f fVar = f.this;
            f.this.i.t0(j != -9223372036854775807L ? fy4.S1(fVar.s) : fVar.t != -9223372036854775807L ? fy4.S1(f.this.t) : 0L);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.rtsp.d.e
        public void d(long j, xi1 xi1Var) {
            ArrayList arrayList = new ArrayList(xi1Var.size());
            for (int i = 0; i < xi1Var.size(); i++) {
                arrayList.add((String) gg3.q(((zv3) xi1Var.get(i)).c.getPath()));
            }
            for (int i2 = 0; i2 < f.this.k.size(); i2++) {
                if (!arrayList.contains(((e) f.this.k.get(i2)).c().getPath())) {
                    f.this.l.b();
                    if (f.this.S()) {
                        f.this.v = true;
                        f.this.s = -9223372036854775807L;
                        f.this.r = -9223372036854775807L;
                        f.this.t = -9223372036854775807L;
                    }
                }
            }
            for (int i3 = 0; i3 < xi1Var.size(); i3++) {
                zv3 zv3Var = (zv3) xi1Var.get(i3);
                androidx.media3.exoplayer.rtsp.b bVarQ = f.this.Q(zv3Var.c);
                if (bVarQ != null) {
                    bVarQ.g(zv3Var.a);
                    bVarQ.f(zv3Var.b);
                    if (f.this.S() && f.this.s == f.this.r) {
                        bVarQ.e(j, zv3Var.a);
                    }
                }
            }
            boolean zS = f.this.S();
            f fVar = f.this;
            if (!zS) {
                if (fVar.t == -9223372036854775807L || !f.this.A) {
                    return;
                }
                f fVar2 = f.this;
                fVar2.n(fVar2.t);
                f.this.t = -9223372036854775807L;
                return;
            }
            long j2 = fVar.s;
            long j3 = f.this.r;
            f fVar3 = f.this;
            if (j2 == j3) {
                fVar3.s = -9223372036854775807L;
                f.this.r = -9223372036854775807L;
            } else {
                fVar3.s = -9223372036854775807L;
                f fVar4 = f.this;
                fVar4.n(fVar4.r);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.rtsp.d.e
        public void e(RtspMediaSource.c cVar) {
            if (!(cVar instanceof RtspMediaSource.d) || f.this.A) {
                f.this.q = cVar;
            } else {
                f.this.X();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: j(Lxy1$e;JJZ)V */
        @Override // xy1.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void j(androidx.media3.exoplayer.rtsp.b bVar, long j, long j2, boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: l(Lxy1$e;JJ)V */
        @Override // xy1.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void l(androidx.media3.exoplayer.rtsp.b bVar, long j, long j2) {
            if (f.this.f() == 0) {
                if (f.this.A) {
                    return;
                }
                f.this.X();
                return;
            }
            int i = 0;
            while (true) {
                if (i >= f.this.j.size()) {
                    break;
                }
                C0023f c0023f = (C0023f) f.this.j.get(i);
                if (c0023f.a.b == bVar) {
                    c0023f.c();
                    break;
                }
                i++;
            }
            f.this.i.r0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: v(Lxy1$e;JJLjava/io/IOException;I)Lxy1$c; */
        @Override // xy1.b
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public xy1.c v(androidx.media3.exoplayer.rtsp.b bVar, long j, long j2, IOException iOException, int i) {
            if (f.this.x) {
                boolean z = iOException.getCause() instanceof BindException;
                f fVar = f.this;
                if (!z) {
                    fVar.q = new RtspMediaSource.c(bVar.b.b.toString(), iOException);
                } else if (f.i(fVar) < 3) {
                    return xy1.d;
                }
            } else {
                f.this.p = iOException;
            }
            return xy1.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ex3.d
        public void w(t41 t41Var) {
            Handler handler = f.this.g;
            final f fVar = f.this;
            handler.post(new Runnable() { // from class: pv3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    fVar.T();
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(yv3 yv3Var);

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class e {
        public final rv3 a;
        public final androidx.media3.exoplayer.rtsp.b b;
        public String c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(rv3 rv3Var, int i, gr4 gr4Var, a.InterfaceC0021a interfaceC0021a) {
            this.a = rv3Var;
            this.b = new androidx.media3.exoplayer.rtsp.b(i, rv3Var, new b.a() { // from class: qv3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.exoplayer.rtsp.b.a
                public final void a(String str, a aVar) {
                    f.e.a(this.a, str, aVar);
                }
            }, new b(gr4Var), interfaceC0021a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void a(e eVar, String str, androidx.media3.exoplayer.rtsp.a aVar) {
            eVar.c = str;
            g.b bVarL = aVar.l();
            if (bVarL != null) {
                f.this.i.m0(aVar.e(), bVarL);
                f.this.A = true;
            }
            f.this.U();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Uri c() {
            return this.b.b.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String d() {
            gg3.q(this.c);
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean e() {
            return this.c != null;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.rtsp.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class C0023f {
        public final e a;
        public final xy1 b;
        public final ex3 c;
        public boolean d;
        public boolean e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0023f(rv3 rv3Var, int i, a.InterfaceC0021a interfaceC0021a) {
            this.b = new xy1("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper " + i);
            ex3 ex3VarN = ex3.n(f.this.f);
            this.c = ex3VarN;
            this.a = f.this.new e(rv3Var, i, ex3VarN, interfaceC0021a);
            ex3VarN.i0(f.this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            if (this.d) {
                return;
            }
            this.a.b.c();
            this.d = true;
            f.this.b0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long d() {
            return this.c.D();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean e() {
            return this.c.P(this.d);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int f(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
            return this.c.W(u41Var, decoderInputBuffer, i, this.d);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g() {
            if (this.e) {
                return;
            }
            this.b.l();
            this.c.X();
            this.e = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h() {
            gg3.v(this.d);
            this.d = false;
            f.this.b0();
            k();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(long j) {
            if (this.d) {
                return;
            }
            this.a.b.d();
            this.c.Z();
            this.c.g0(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int j(long j) throws Throwable {
            int I = this.c.I(j, this.d);
            this.c.j0(I);
            return I;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k() {
            this.b.n(this.a.b, f.this.h, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class g implements gx3 {
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(int i) {
            this.f = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public void a() throws RtspMediaSource.c {
            if (f.this.q != null) {
                throw f.this.q;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public int e(long j) {
            return f.this.Z(this.f, j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public boolean isReady() {
            return f.this.R(this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gx3
        public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
            return f.this.V(this.f, u41Var, decoderInputBuffer, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f(j5 j5Var, a.InterfaceC0021a interfaceC0021a, Uri uri, d dVar, String str, SocketFactory socketFactory, boolean z) {
        this.f = j5Var;
        this.m = interfaceC0021a;
        this.l = dVar;
        c cVar = new c();
        this.h = cVar;
        this.i = new androidx.media3.exoplayer.rtsp.d(cVar, cVar, str, uri, socketFactory, z);
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.s = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.t = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 P(xi1 xi1Var) {
        xi1.a aVar = new xi1.a();
        for (int i = 0; i < xi1Var.size(); i++) {
            aVar.a(new br4(Integer.toString(i), (t41) gg3.q(((C0023f) xi1Var.get(i)).c.J())));
        }
        return aVar.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.w || this.x) {
            return;
        }
        for (int i = 0; i < this.j.size(); i++) {
            if (((C0023f) this.j.get(i)).c.J() == null) {
                return;
            }
        }
        this.x = true;
        this.o = P(xi1.p(this.j));
        ((mi2.a) gg3.q(this.n)).e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean a0() {
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int i(f fVar) {
        int i = fVar.z;
        fVar.z = i + 1;
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final androidx.media3.exoplayer.rtsp.b Q(Uri uri) {
        for (int i = 0; i < this.j.size(); i++) {
            if (!((C0023f) this.j.get(i)).d) {
                e eVar = ((C0023f) this.j.get(i)).a;
                if (eVar.c().equals(uri)) {
                    return eVar.b;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean R(int i) {
        return !a0() && ((C0023f) this.j.get(i)).e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean S() {
        return this.s != -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void U() {
        boolean zE = true;
        for (int i = 0; i < this.k.size(); i++) {
            zE &= ((e) this.k.get(i)).e();
        }
        if (zE && this.y) {
            this.i.q0(this.k);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int V(int i, u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (a0()) {
            return -3;
        }
        return ((C0023f) this.j.get(i)).f(u41Var, decoderInputBuffer, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W() {
        for (int i = 0; i < this.j.size(); i++) {
            ((C0023f) this.j.get(i)).g();
        }
        fy4.p(this.i);
        this.w = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X() {
        List list;
        this.A = true;
        this.i.n0();
        a.InterfaceC0021a interfaceC0021aB = this.m.b();
        if (interfaceC0021aB == null) {
            this.q = new RtspMediaSource.c("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.j.size());
        ArrayList arrayList2 = new ArrayList(this.k.size());
        int i = 0;
        while (true) {
            int size = this.j.size();
            list = this.j;
            if (i >= size) {
                break;
            }
            C0023f c0023f = (C0023f) list.get(i);
            if (c0023f.d) {
                arrayList.add(c0023f);
            } else {
                C0023f c0023f2 = new C0023f(c0023f.a.a, i, interfaceC0021aB);
                arrayList.add(c0023f2);
                c0023f2.k();
                if (this.k.contains(c0023f.a)) {
                    arrayList2.add(c0023f2.a);
                }
            }
            i++;
        }
        xi1 xi1VarP = xi1.p(list);
        this.j.clear();
        this.j.addAll(arrayList);
        this.k.clear();
        this.k.addAll(arrayList2);
        for (int i2 = 0; i2 < xi1VarP.size(); i2++) {
            ((C0023f) xi1VarP.get(i2)).c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Y(long j) {
        for (int i = 0; i < this.j.size(); i++) {
            if (!((C0023f) this.j.get(i)).c.d0(j, this.u)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int Z(int i, long j) {
        if (a0()) {
            return -3;
        }
        return ((C0023f) this.j.get(i)).j(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean b(androidx.media3.exoplayer.j jVar) {
        return isLoading();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b0() {
        this.u = true;
        for (int i = 0; i < this.j.size(); i++) {
            this.u &= ((C0023f) this.j.get(i)).d;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        if (this.u || this.j.isEmpty()) {
            return Long.MIN_VALUE;
        }
        long j = this.r;
        if (j != -9223372036854775807L) {
            return j;
        }
        boolean z = true;
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < this.j.size(); i++) {
            C0023f c0023f = (C0023f) this.j.get(i);
            if (!c0023f.d) {
                jMin = Math.min(jMin, c0023f.d());
                z = false;
            }
        }
        if (z || jMin == Long.MIN_VALUE) {
            return 0L;
        }
        return jMin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        if (this.u) {
            return false;
        }
        return this.i.k0() == 2 || this.i.k0() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        for (int i = 0; i < jy0VarArr.length; i++) {
            if (gx3VarArr[i] != null && (jy0VarArr[i] == null || !zArr[i])) {
                gx3VarArr[i] = null;
            }
        }
        this.k.clear();
        for (int i2 = 0; i2 < jy0VarArr.length; i2++) {
            jy0 jy0Var = jy0VarArr[i2];
            if (jy0Var != null) {
                br4 br4VarC = jy0Var.c();
                int iIndexOf = ((xi1) gg3.q(this.o)).indexOf(br4VarC);
                this.k.add(((C0023f) gg3.q((C0023f) this.j.get(iIndexOf))).a);
                if (this.o.contains(br4VarC) && gx3VarArr[i2] == null) {
                    gx3VarArr[i2] = new g(iIndexOf);
                    zArr2[i2] = true;
                }
            }
        }
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            C0023f c0023f = (C0023f) this.j.get(i3);
            if (!this.k.contains(c0023f.a)) {
                c0023f.c();
            }
        }
        this.y = true;
        if (j != 0) {
            this.r = j;
            this.s = j;
            this.t = j;
        }
        U();
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void m() throws IOException {
        IOException iOException = this.p;
        if (iOException != null) {
            throw iOException;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long n(long j) {
        if (f() == 0 && !this.A) {
            this.t = j;
            return j;
        }
        t(j, false);
        this.r = j;
        if (S()) {
            int iK0 = this.i.k0();
            if (iK0 != 1) {
                if (iK0 != 2) {
                    z20.a();
                    return 0L;
                }
                this.s = j;
                this.i.o0(j);
                return j;
            }
        } else if (!Y(j)) {
            this.s = j;
            if (this.u) {
                for (int i = 0; i < this.j.size(); i++) {
                    ((C0023f) this.j.get(i)).h();
                }
                boolean z = this.A;
                androidx.media3.exoplayer.rtsp.d dVar = this.i;
                if (z) {
                    dVar.t0(fy4.S1(j));
                } else {
                    dVar.o0(j);
                }
            } else {
                this.i.o0(j);
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                ((C0023f) this.j.get(i2)).i(j);
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long q() {
        if (!this.v) {
            return -9223372036854775807L;
        }
        this.v = false;
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        this.n = aVar;
        try {
            this.i.s0();
        } catch (IOException e2) {
            this.p = e2;
            fy4.p(this.i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public er4 s() {
        gg3.v(this.x);
        return new er4((br4[]) ((xi1) gg3.q(this.o)).toArray(new br4[0]));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        if (S()) {
            return;
        }
        for (int i = 0; i < this.j.size(); i++) {
            C0023f c0023f = (C0023f) this.j.get(i);
            if (!c0023f.d) {
                c0023f.c.s(j, z, true);
            }
        }
    }
}
