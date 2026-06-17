package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str) {
            super(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Runnable runnable) {
            this.a = runnable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gh1.a
        public void a(ih ihVar) {
            if (pn0.this.g != null) {
                pn0.this.g.s(ihVar);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gh1.a
        public void b() {
            pn0.this.A();
            this.a.run();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gh1.a
        public void c() {
            if (pn0.this.g != null) {
                pn0.this.g.v();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A() {
        long jMax = Math.max(33L, 40L);
        this.r = jMax;
        this.s = (long) (jMax * 2.5f);
        long jMax2 = Math.max(16L, 15L);
        this.t = jMax2;
        this.u = jMax2 + 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean C() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F() {
        removeMessages(3);
        T();
        sendEmptyMessage(7);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G() {
        this.f = false;
        if (this.a.G == 0) {
            this.b = new e(this, null);
        }
        this.q = this.a.G == 1;
        sendEmptyMessage(5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(Runnable runnable) {
        if (this.j == null) {
            this.j = t(this.k.c(), this.h, this.k.getContext(), this.k.getViewWidth(), this.k.getViewHeight(), this.k.isHardwareAccelerated(), new c(runnable));
        } else {
            runnable.run();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I() {
        this.d = true;
        sendEmptyMessage(6);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized void K() {
        this.o.addLast(Long.valueOf(lk4.b()));
        if (this.o.size() > 500) {
            this.o.removeFirst();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L() {
        if (this.d && this.l) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N(Long l) {
        this.w = true;
        this.x = l.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        obtainMessage(4, l).sendToTarget();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(d dVar) {
        this.g = dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P(t80 t80Var) {
        this.a = t80Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(jh jhVar) {
        this.i = jhVar;
        b90 b90VarB = jhVar.b();
        if (b90VarB != null) {
            this.h = b90VarB;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R(Long l) {
        if (this.l) {
            return;
        }
        this.l = true;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(8, l).sendToTarget();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T() {
        if (this.A) {
            S(lk4.b());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W() {
        if (this.p != null) {
            return;
        }
        b bVar = new b("DFM Update");
        this.p = bVar;
        bVar.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    */
    public void handleMessage(Message message) {
        Long l;
        gh1 gh1Var;
        boolean z;
        ch1 ch1Var;
        gh1 gh1Var2;
        int i = message.what;
        switch (i) {
            case 1:
                l = (Long) message.obj;
                if (l == null) {
                    this.c = l.longValue();
                } else {
                    this.c = 0L;
                }
                if (i == 4) {
                    this.d = true;
                    J();
                    Long l2 = (Long) message.obj;
                    long jLongValue = l2.longValue();
                    b90 b90Var = this.h;
                    this.e -= jLongValue - b90Var.a;
                    b90Var.c(l2.longValue());
                    this.a.C.d();
                    gh1 gh1Var3 = this.j;
                    if (gh1Var3 != null) {
                        gh1Var3.c(l2.longValue());
                    }
                    this.c = l2.longValue();
                }
                removeMessages(7);
                this.d = false;
                if (!this.f) {
                    this.n.e();
                    this.o.clear();
                    long jB = lk4.b();
                    long j = this.c;
                    this.e = jB - j;
                    this.h.c(j);
                    removeMessages(3);
                    sendEmptyMessage(2);
                    this.j.start();
                    E();
                    this.w = false;
                    gh1 gh1Var4 = this.j;
                    if (gh1Var4 != null) {
                        gh1Var4.a(1);
                    }
                } else {
                    sendEmptyMessageDelayed(3, 100L);
                }
                break;
            case 2:
                byte b2 = this.a.G;
                if (b2 == 0) {
                    U();
                } else if (b2 == 1) {
                    W();
                } else if (b2 == 2) {
                    V();
                }
                break;
            case 3:
                removeMessages(7);
                this.d = false;
                if (!this.f) {
                }
                break;
            case 4:
                if (i == 4) {
                }
                removeMessages(7);
                this.d = false;
                if (!this.f) {
                }
                break;
            case 5:
                this.e = lk4.b();
                if (this.i != null && this.k.b()) {
                    H(new a());
                } else {
                    sendEmptyMessageDelayed(5, 100L);
                }
                break;
            case 6:
                if (i == 6) {
                    removeCallbacksAndMessages(null);
                }
                this.d = true;
                T();
                this.c = this.h.a;
                if (this.q) {
                    E();
                    J();
                }
                if (this.b != null) {
                    Choreographer.getInstance().removeFrameCallback(this.b);
                }
                if (i == 6) {
                    gh1 gh1Var5 = this.j;
                    if (gh1Var5 != null) {
                        gh1Var5.g();
                    }
                    jh jhVar = this.i;
                    if (jhVar != null) {
                        jhVar.f();
                    }
                    if (getLooper() != Looper.getMainLooper()) {
                        getLooper().quit();
                    }
                }
                break;
            case 7:
                removeMessages(3);
                removeMessages(2);
                gh1Var = this.j;
                if (gh1Var != null) {
                    gh1Var.a(2);
                }
                if (i == 6) {
                }
                this.d = true;
                T();
                this.c = this.h.a;
                if (this.q) {
                }
                if (this.b != null) {
                }
                if (i == 6) {
                }
                break;
            case 8:
                this.l = true;
                Long l3 = (Long) message.obj;
                gh1 gh1Var6 = this.j;
                if (gh1Var6 == null) {
                    z = false;
                    if (this.d && (ch1Var = this.k) != null) {
                        ch1Var.a();
                    }
                    E();
                    if (!z) {
                    }
                    l = (Long) message.obj;
                    if (l == null) {
                    }
                    if (i == 4) {
                    }
                } else if (l3 == null) {
                    this.h.c(x());
                    this.j.l();
                    z = false;
                    if (this.d) {
                        ch1Var.a();
                    }
                    E();
                    if (!z) {
                    }
                    l = (Long) message.obj;
                    if (l == null) {
                    }
                    if (i == 4) {
                    }
                } else {
                    gh1Var6.start();
                    this.j.c(l3.longValue());
                    this.j.l();
                    z = true;
                    if (this.d) {
                    }
                    E();
                    if (!z) {
                    }
                    l = (Long) message.obj;
                    if (l == null) {
                    }
                    if (i == 4) {
                    }
                }
                removeMessages(7);
                this.d = false;
                if (!this.f) {
                }
                break;
            case 9:
                this.l = false;
                ch1 ch1Var2 = this.k;
                if (ch1Var2 != null) {
                    ch1Var2.clear();
                }
                gh1 gh1Var7 = this.j;
                if (gh1Var7 != null) {
                    gh1Var7.l();
                    this.j.j();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && (gh1Var2 = this.j) != null) {
                    gh1Var2.g();
                }
                if (!bool.booleanValue()) {
                }
                removeMessages(3);
                removeMessages(2);
                gh1Var = this.j;
                if (gh1Var != null) {
                }
                if (i == 6) {
                }
                this.d = true;
                T();
                this.c = this.h.a;
                if (this.q) {
                }
                if (this.b != null) {
                }
                if (i == 6) {
                }
                break;
            case 10:
                t80 t80Var = this.a;
                t80Var.E.e(t80Var);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.a.C.d();
                    this.a.C.g();
                    this.j.e();
                    break;
                }
                break;
            case 11:
                E();
                break;
            case 12:
                if (this.d && this.k != null) {
                    this.j.l();
                    this.k.a();
                    E();
                    break;
                }
                break;
            case 13:
                gh1 gh1Var8 = this.j;
                if (gh1Var8 != null) {
                    gh1Var8.h(x());
                }
                break;
            case 14:
                gh1 gh1Var9 = this.j;
                if (gh1Var9 != null) {
                    gh1Var9.d();
                }
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(ch1 ch1Var) {
        this.k = ch1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t80 w() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dh1 y() {
        gh1 gh1Var = this.j;
        if (gh1Var != null) {
            return gh1Var.i(x());
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            pn0.this.sendEmptyMessage(2);
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 pn0) A[MD:(pn0):void (m)] (LINE:7) call: pn0.e.<init>(pn0):void type: THIS */
        public /* synthetic */ e(pn0 pn0Var, a aVar) {
            this();
        }
    }
}
