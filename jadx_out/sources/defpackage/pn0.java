package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import defpackage.gh1;
import defpackage.nh1;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class pn0 extends Handler {
    public boolean A;
    public boolean B;
    public boolean C;
    public t80 a;
    public e b;
    public long c;
    public boolean d;
    public long e;
    public boolean f;
    public d g;
    public b90 h;
    public jh i;
    public gh1 j;
    public ch1 k;
    public boolean l;
    public o m;
    public final nh1.b n;
    public LinkedList o;
    public ax4 p;
    public boolean q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public boolean w;
    public long x;
    public long y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pn0.this.c = 0L;
            pn0.this.f = true;
            if (pn0.this.g != null) {
                pn0.this.g.x();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends ax4 {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long jB = lk4.b();
            while (!a() && !pn0.this.d) {
                long jB2 = lk4.b();
                if (pn0.this.t - (lk4.b() - jB) <= 1 || pn0.this.C) {
                    long jS = pn0.this.S(jB2);
                    if (jS >= 0 || pn0.this.C) {
                        long jA = pn0.this.k.a();
                        if (jA > pn0.this.s) {
                            pn0.this.h.a(jA);
                            pn0.this.o.clear();
                        }
                        boolean z = pn0.this.l;
                        pn0 pn0Var = pn0.this;
                        if (!z) {
                            pn0Var.X(10000000L);
                        } else if (pn0Var.n.p && pn0.this.B) {
                            long j = pn0.this.n.o - pn0.this.h.a;
                            if (j > 500) {
                                pn0.this.E();
                                pn0.this.X(j - 10);
                            }
                        }
                    } else {
                        lk4.a(60 - jS);
                    }
                    jB = jB2;
                } else {
                    lk4.a(1L);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements gh1.a {
        public final /* synthetic */ Runnable a;

        public c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // gh1.a
        public void a(ih ihVar) {
            if (pn0.this.g != null) {
                pn0.this.g.s(ihVar);
            }
        }

        @Override // gh1.a
        public void b() {
            pn0.this.A();
            this.a.run();
        }

        @Override // gh1.a
        public void c() {
            if (pn0.this.g != null) {
                pn0.this.g.v();
            }
        }

        @Override // gh1.a
        public void d() {
            pn0.this.L();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(b90 b90Var);

        void s(ih ihVar);

        void v();

        void x();
    }

    public pn0(Looper looper, ch1 ch1Var, boolean z) {
        super(looper);
        this.c = 0L;
        this.d = true;
        this.h = new b90();
        this.l = true;
        this.n = new nh1.b();
        this.o = new LinkedList();
        this.r = 30L;
        this.s = 60L;
        this.t = 16L;
        this.B = true ^ nk0.f();
        s(ch1Var);
        if (z) {
            R(null);
        } else {
            z(false);
        }
        this.l = z;
    }

    public final void A() {
        long jMax = Math.max(33L, 40L);
        this.r = jMax;
        this.s = (long) (jMax * 2.5f);
        long jMax2 = Math.max(16L, 15L);
        this.t = jMax2;
        this.u = jMax2 + 3;
    }

    public boolean B() {
        return this.f;
    }

    public boolean C() {
        return this.d;
    }

    public void D(int i, int i2) {
        o oVar = this.m;
        if (oVar == null) {
            return;
        }
        if (oVar.b() == i && this.m.a() == i2) {
            return;
        }
        this.m.t(i, i2);
        obtainMessage(10, Boolean.TRUE).sendToTarget();
    }

    public final void E() {
        if (this.A) {
            gh1 gh1Var = this.j;
            if (gh1Var != null) {
                gh1Var.l();
            }
            if (this.q) {
                synchronized (this) {
                    this.o.clear();
                }
                synchronized (this.j) {
                    this.j.notifyAll();
                }
            } else {
                this.o.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.A = false;
        }
    }

    public void F() {
        removeMessages(3);
        T();
        sendEmptyMessage(7);
    }

    public void G() {
        this.f = false;
        if (this.a.G == 0) {
            this.b = new e(this, null);
        }
        this.q = this.a.G == 1;
        sendEmptyMessage(5);
    }

    public final void H(Runnable runnable) {
        if (this.j == null) {
            this.j = t(this.k.c(), this.h, this.k.getContext(), this.k.getViewWidth(), this.k.getViewHeight(), this.k.isHardwareAccelerated(), new c(runnable));
        } else {
            runnable.run();
        }
    }

    public void I() {
        this.d = true;
        sendEmptyMessage(6);
    }

    public final synchronized void J() {
        ax4 ax4Var = this.p;
        this.p = null;
        if (ax4Var != null) {
            synchronized (this.j) {
                this.j.notifyAll();
            }
            ax4Var.b();
            try {
                ax4Var.join(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final synchronized void K() {
        this.o.addLast(Long.valueOf(lk4.b()));
        if (this.o.size() > 500) {
            this.o.removeFirst();
        }
    }

    public final void L() {
        if (this.d && this.l) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    public void M() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    public void N(Long l) {
        this.w = true;
        this.x = l.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        obtainMessage(4, l).sendToTarget();
    }

    public void O(d dVar) {
        this.g = dVar;
    }

    public void P(t80 t80Var) {
        this.a = t80Var;
    }

    public void Q(jh jhVar) {
        this.i = jhVar;
        b90 b90VarB = jhVar.b();
        if (b90VarB != null) {
            this.h = b90VarB;
        }
    }

    public void R(Long l) {
        if (this.l) {
            return;
        }
        this.l = true;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(8, l).sendToTarget();
    }

    public final long S(long j) {
        long jB = 0;
        if (!this.w && !this.z) {
            this.z = true;
            long j2 = j - this.e;
            if (this.C) {
                d dVar = this.g;
                if (dVar != null) {
                    dVar.a(this.h);
                    jB = this.h.b();
                }
            } else if (!this.l || this.n.p || this.A) {
                this.h.c(j2);
                this.y = 0L;
                d dVar2 = this.g;
                if (dVar2 != null) {
                    dVar2.a(this.h);
                }
            } else {
                long j3 = j2 - this.h.a;
                long jMax = Math.max(this.t, v());
                if (j3 <= 2000) {
                    long j4 = this.n.m;
                    long j5 = this.r;
                    if (j4 <= j5 && jMax <= j5) {
                        long j6 = this.t;
                        long jMin = Math.min(this.r, Math.max(j6, jMax + (j3 / j6)));
                        long j7 = this.v;
                        long j8 = jMin - j7;
                        if (j8 > 3 && j8 < 8 && j7 >= this.t && j7 <= this.r) {
                            jMin = j7;
                        }
                        this.v = jMin;
                        jB = j3 - jMin;
                        j3 = jMin;
                    }
                }
                this.y = jB;
                this.h.a(j3);
                d dVar3 = this.g;
                if (dVar3 != null) {
                    dVar3.a(this.h);
                }
                jB = j3;
            }
            this.z = false;
        }
        return jB;
    }

    public final void T() {
        if (this.A) {
            S(lk4.b());
        }
    }

    public final void U() {
        if (this.d) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this.b);
        if (S(lk4.b()) < 0) {
            removeMessages(2);
            return;
        }
        long jA = this.k.a();
        removeMessages(2);
        if (jA > this.s) {
            this.h.a(jA);
            this.o.clear();
        }
        if (!this.l) {
            X(10000000L);
            return;
        }
        nh1.b bVar = this.n;
        if (bVar.p && this.B) {
            long j = bVar.o - this.h.a;
            if (j > 500) {
                X(j - 10);
            }
        }
    }

    public final void V() {
        if (this.d) {
            return;
        }
        long jS = S(lk4.b());
        if (jS < 0 && !this.C) {
            removeMessages(2);
            sendEmptyMessageDelayed(2, 60 - jS);
            return;
        }
        long jA = this.k.a();
        removeMessages(2);
        if (jA > this.s) {
            this.h.a(jA);
            this.o.clear();
        }
        if (!this.l) {
            X(10000000L);
            return;
        }
        nh1.b bVar = this.n;
        if (bVar.p && this.B) {
            long j = bVar.o - this.h.a;
            if (j > 500) {
                X(j - 10);
                return;
            }
        }
        long j2 = this.t;
        if (jA < j2) {
            sendEmptyMessageDelayed(2, j2 - jA);
        } else {
            sendEmptyMessage(2);
        }
    }

    public final void W() {
        if (this.p != null) {
            return;
        }
        b bVar = new b("DFM Update");
        this.p = bVar;
        bVar.start();
    }

    public final void X(long j) {
        if (C() || !B() || this.w) {
            return;
        }
        this.n.q = lk4.b();
        this.A = true;
        if (!this.q) {
            if (j == 10000000) {
                removeMessages(11);
                removeMessages(2);
                return;
            } else {
                removeMessages(11);
                removeMessages(2);
                sendEmptyMessageDelayed(11, j);
                return;
            }
        }
        if (this.p == null) {
            return;
        }
        try {
            synchronized (this.j) {
                gh1 gh1Var = this.j;
                try {
                    if (j == 10000000) {
                        gh1Var.wait();
                    } else {
                        gh1Var.wait(j);
                    }
                    sendEmptyMessage(11);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0166  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pn0.handleMessage(android.os.Message):void");
    }

    public final void s(ch1 ch1Var) {
        this.k = ch1Var;
    }

    public final gh1 t(boolean z, b90 b90Var, Context context, int i, int i2, boolean z2, gh1.a aVar) {
        o oVarB = this.a.b();
        this.m = oVarB;
        oVarB.t(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.m.i(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.m.e(this.a.h);
        this.m.l(z2);
        t80 t80Var = this.a;
        gh1 moVar = z ? new mo(b90Var, t80Var, aVar) : new rn0(b90Var, t80Var, aVar);
        moVar.f(this.i);
        moVar.prepare();
        obtainMessage(10, Boolean.FALSE).sendToTarget();
        return moVar;
    }

    public nh1.b u(Canvas canvas) {
        n nVar;
        boolean zD;
        if (this.j == null) {
            return this.n;
        }
        if (!this.A && (nVar = this.a.r) != null && ((zD = nVar.d()) || !this.d)) {
            int iA = nVar.a();
            if (iA == 2) {
                long j = this.h.a;
                long jC = nVar.c();
                long j2 = jC - j;
                if (Math.abs(j2) > nVar.b()) {
                    if (zD && this.d) {
                        M();
                    }
                    this.j.k(j, jC, j2);
                    this.h.c(jC);
                    this.e -= j2;
                    this.y = 0L;
                }
            } else if (iA == 1 && zD && !this.d) {
                F();
            }
        }
        this.m.y(canvas);
        this.n.f(this.j.b(this.m));
        K();
        return this.n;
    }

    public final synchronized long v() {
        int size = this.o.size();
        if (size <= 0) {
            return 0L;
        }
        Long l = (Long) this.o.peekFirst();
        Long l2 = (Long) this.o.peekLast();
        if (l != null && l2 != null) {
            return (l2.longValue() - l.longValue()) / ((long) size);
        }
        return 0L;
    }

    public t80 w() {
        return this.a;
    }

    public long x() {
        long jB;
        long j;
        if (!this.f) {
            return 0L;
        }
        if (this.w) {
            return this.x;
        }
        if (this.d || !this.A) {
            jB = this.h.a;
            j = this.y;
        } else {
            jB = lk4.b();
            j = this.e;
        }
        return jB - j;
    }

    public dh1 y() {
        gh1 gh1Var = this.j;
        if (gh1Var != null) {
            return gh1Var.i(x());
        }
        return null;
    }

    public long z(boolean z) {
        if (!this.l) {
            return this.h.a;
        }
        this.l = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.h.a;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements Choreographer.FrameCallback {
        public e() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            pn0.this.sendEmptyMessage(2);
        }

        public /* synthetic */ e(pn0 pn0Var, a aVar) {
            this();
        }
    }
}
