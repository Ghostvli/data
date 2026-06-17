package master.flame.danmaku.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import defpackage.bh1;
import defpackage.c90;
import defpackage.ch1;
import defpackage.dh1;
import defpackage.jh;
import defpackage.lk4;
import defpackage.nh1;
import defpackage.pn0;
import defpackage.qn0;
import defpackage.t80;
import java.util.LinkedList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DanmakuView extends View implements bh1, ch1 {
    public pn0.d f;
    public HandlerThread g;
    public volatile pn0 h;
    public boolean i;
    public boolean j;
    public float k;
    public float l;
    public c90 m;
    public boolean n;
    public boolean o;
    public int p;
    public Object q;
    public boolean r;
    public boolean s;
    public long t;
    public LinkedList u;
    public boolean v;
    public int w;
    public Runnable x;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pn0 pn0Var = DanmakuView.this.h;
            if (pn0Var == null) {
                return;
            }
            DanmakuView.e(DanmakuView.this);
            if (DanmakuView.this.w > 4 || DanmakuView.super.isShown()) {
                pn0Var.M();
            } else {
                pn0Var.postDelayed(this, DanmakuView.this.w * 100);
            }
        }
    }

    public DanmakuView(Context context) {
        super(context);
        this.j = true;
        this.o = true;
        this.p = 0;
        this.q = new Object();
        this.r = false;
        this.s = false;
        this.w = 0;
        this.x = new a();
        i();
    }

    public static /* synthetic */ int e(DanmakuView danmakuView) {
        int i = danmakuView.w;
        danmakuView.w = i + 1;
        return i;
    }

    public final void A() {
        synchronized (this.q) {
            this.r = true;
            this.q.notifyAll();
        }
    }

    @Override // defpackage.ch1
    public long a() {
        if (!this.i) {
            return 0L;
        }
        if (!isShown()) {
            return -1L;
        }
        long jB = lk4.b();
        k();
        return lk4.b() - jB;
    }

    @Override // defpackage.ch1
    public boolean b() {
        return this.i;
    }

    @Override // defpackage.ch1
    public boolean c() {
        return this.j;
    }

    @Override // defpackage.ch1
    public void clear() {
        if (b()) {
            if (this.o && Thread.currentThread().getId() != this.t) {
                l();
            } else {
                this.v = true;
                n();
            }
        }
    }

    public final float g() {
        long jB = lk4.b();
        this.u.addLast(Long.valueOf(jB));
        Long l = (Long) this.u.peekFirst();
        if (l == null) {
            return 0.0f;
        }
        float fLongValue = jB - l.longValue();
        if (this.u.size() > 50) {
            this.u.removeFirst();
        }
        if (fLongValue > 0.0f) {
            return (this.u.size() * 1000) / fLongValue;
        }
        return 0.0f;
    }

    public t80 getConfig() {
        if (this.h == null) {
            return null;
        }
        return this.h.w();
    }

    public long getCurrentTime() {
        if (this.h != null) {
            return this.h.x();
        }
        return 0L;
    }

    @Override // defpackage.bh1
    public dh1 getCurrentVisibleDanmakus() {
        if (this.h != null) {
            return this.h.y();
        }
        return null;
    }

    @Override // defpackage.bh1
    public bh1.a getOnDanmakuClickListener() {
        return null;
    }

    public View getView() {
        return this;
    }

    @Override // defpackage.ch1
    public int getViewHeight() {
        return super.getHeight();
    }

    @Override // defpackage.ch1
    public int getViewWidth() {
        return super.getWidth();
    }

    public float getXOff() {
        return this.k;
    }

    public float getYOff() {
        return this.l;
    }

    public synchronized Looper h(int i) {
        try {
            HandlerThread handlerThread = this.g;
            if (handlerThread != null) {
                handlerThread.quit();
                this.g = null;
            }
            if (i == 1) {
                return Looper.getMainLooper();
            }
            int i2 = i != 2 ? i != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i2, i2);
            this.g = handlerThread2;
            handlerThread2.start();
            return this.g.getLooper();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i() {
        this.t = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        qn0.e(true, false);
        this.m = c90.h(this);
    }

    @Override // android.view.View, defpackage.ch1
    public boolean isHardwareAccelerated() {
        return super.isHardwareAccelerated();
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.o && super.isShown();
    }

    public boolean j() {
        return this.h != null && this.h.B();
    }

    public void k() {
        if (this.o) {
            n();
            synchronized (this.q) {
                while (!this.r && this.h != null) {
                    try {
                        this.q.wait(200L);
                    } catch (InterruptedException unused) {
                        if (!this.o || this.h == null || this.h.C()) {
                            break;
                        } else {
                            Thread.currentThread().interrupt();
                        }
                        this.r = false;
                    }
                }
                this.r = false;
            }
        }
    }

    public final void l() {
        this.v = true;
        k();
    }

    public void m() {
        if (this.h != null) {
            this.h.removeCallbacks(this.x);
            this.h.F();
        }
    }

    public final void n() {
        this.s = true;
        postInvalidateOnAnimation();
    }

    public final void o() {
        if (this.h == null) {
            this.h = new pn0(h(this.p), this, this.o);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.o && !this.s) {
            super.onDraw(canvas);
            return;
        }
        if (this.v) {
            qn0.a(canvas);
            this.v = false;
        } else if (this.h != null) {
            nh1.b bVarU = this.h.u(canvas);
            if (this.n) {
                if (this.u == null) {
                    this.u = new LinkedList();
                }
                qn0.d(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(g()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(bVarU.r), Long.valueOf(bVarU.s)));
            }
        }
        this.s = false;
        A();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.h != null) {
            this.h.D(i3 - i, i4 - i2);
        }
        this.i = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zI = this.m.i(motionEvent);
        return !zI ? super.onTouchEvent(motionEvent) : zI;
    }

    public void p(jh jhVar, t80 t80Var) {
        o();
        this.h.P(t80Var);
        this.h.Q(jhVar);
        this.h.O(this.f);
        this.h.G();
    }

    public void q() {
        y();
        LinkedList linkedList = this.u;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    public void r() {
        y();
        w();
    }

    public void s() {
        if (this.h != null && this.h.B()) {
            this.w = 0;
            this.h.post(this.x);
        } else if (this.h == null) {
            r();
        }
    }

    public void setCallback(pn0.d dVar) {
        this.f = dVar;
        if (this.h != null) {
            this.h.O(dVar);
        }
    }

    public void setDrawingThreadType(int i) {
        this.p = i;
    }

    public void setOnDanmakuClickListener(bh1.a aVar) {
    }

    public void t(Long l) {
        if (this.h != null) {
            this.h.N(l);
        }
    }

    public void u() {
        v(null);
    }

    public void v(Long l) {
        this.o = true;
        this.v = false;
        if (this.h == null) {
            return;
        }
        this.h.R(l);
    }

    public void w() {
        x(0L);
    }

    public void x(long j) {
        pn0 pn0Var = this.h;
        if (pn0Var == null) {
            o();
            pn0Var = this.h;
        } else {
            pn0Var.removeCallbacksAndMessages(null);
        }
        if (pn0Var != null) {
            pn0Var.obtainMessage(1, Long.valueOf(j)).sendToTarget();
        }
    }

    public void y() {
        z();
    }

    public final synchronized void z() {
        try {
            if (this.h == null) {
                return;
            }
            pn0 pn0Var = this.h;
            this.h = null;
            A();
            if (pn0Var != null) {
                pn0Var.I();
            }
            HandlerThread handlerThread = this.g;
            this.g = null;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handlerThread.quit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.o = true;
        this.p = 0;
        this.q = new Object();
        this.r = false;
        this.s = false;
        this.w = 0;
        this.x = new a();
        i();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = true;
        this.o = true;
        this.p = 0;
        this.q = new Object();
        this.r = false;
        this.s = false;
        this.w = 0;
        this.x = new a();
        i();
    }
}
