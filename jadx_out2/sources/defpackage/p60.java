package defpackage;

import android.app.Activity;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import com.fongmi.android.tv.App;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class p60 extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
    public final ScaleGestureDetector f;
    public final GestureDetector g;
    public final AudioManager h;
    public final a i;
    public final Activity j;
    public final View k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public float u;
    public float v;
    public float w = 1.0f;
    public long x;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void A();

        void C0();

        void F(int i);

        void M0(int i);

        void P();

        void e0(long j);

        void k0();

        void m0();

        void p0();

        void r0(long j);

        void u0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.app.Activity */
    /* JADX WARN: Multi-variable type inference failed */
    public p60(Activity activity, View view) {
        this.h = (AudioManager) activity.getSystemService("audio");
        this.f = new ScaleGestureDetector(activity, this);
        this.g = new GestureDetector(activity, this);
        this.i = (a) activity;
        this.k = view;
        this.j = activity;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static p60 l(Activity activity, View view) {
        return new p60(activity, view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A() {
        if (this.w == 1.0f) {
            return;
        }
        this.k.animate().scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setDuration(250L).withEndAction(new Runnable() { // from class: j60
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.x();
            }
        }).start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B(float f) {
        float measuredHeight = ((f * 2.0f) / this.k.getMeasuredHeight()) + this.u;
        if (measuredHeight < 0.0f) {
            measuredHeight = 0.0f;
        }
        if (measuredHeight > 1.0f) {
            measuredHeight = 1.0f;
        }
        WindowManager.LayoutParams attributes = this.j.getWindow().getAttributes();
        attributes.screenBrightness = measuredHeight;
        this.j.getWindow().setAttributes(attributes);
        this.i.F((int) (measuredHeight * 100.0f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C(boolean z) {
        this.t = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(float f) {
        float streamMaxVolume = this.h.getStreamMaxVolume(3);
        float measuredHeight = this.v + (((f * 2.0f) / this.k.getMeasuredHeight()) * streamMaxVolume);
        if (measuredHeight > streamMaxVolume) {
            measuredHeight = streamMaxVolume;
        }
        if (measuredHeight < 0.0f) {
            measuredHeight = 0.0f;
        }
        this.h.setStreamVolume(3, (int) measuredHeight, 0);
        this.i.M0((int) ((measuredHeight / streamMaxVolume) * 100.0f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(float f, float f2, MotionEvent motionEvent) {
        if (((float) Math.sqrt((f * f) + (f2 * f2))) < vr3.a(20)) {
            return;
        }
        if (f >= f2) {
            this.p = true;
        } else if (p(motionEvent)) {
            k(motionEvent);
        }
        this.s = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(MotionEvent motionEvent, MotionEvent motionEvent2) {
        double degrees = Math.toDegrees(Math.atan2(Math.abs(motionEvent2.getY() - motionEvent.getY()), Math.abs(motionEvent2.getX() - motionEvent.getX())));
        if (degrees > 70.0d && motionEvent.getY() - motionEvent2.getY() > 100.0f) {
            this.k.animate().translationYBy(vr3.a(q24.J() ? 24 : -24)).setDuration(150L).withStartAction(new Runnable() { // from class: f60
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.q();
                }
            }).withEndAction(new Runnable() { // from class: g60
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.s();
                }
            }).start();
        } else {
            if (degrees <= 70.0d || motionEvent2.getY() - motionEvent.getY() <= 100.0f) {
                return;
            }
            this.k.animate().translationYBy(vr3.a(q24.J() ? -24 : 24)).setDuration(150L).withStartAction(new Runnable() { // from class: h60
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.t();
                }
            }).withEndAction(new Runnable() { // from class: i60
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.v();
                }
            }).start();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(MotionEvent motionEvent) {
        if (motionEvent.getX() > vr3.k(this.j) / 2) {
            this.m = true;
        } else {
            this.l = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float m() {
        return this.w;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n(MotionEvent motionEvent) {
        return vr3.q(this.j, motionEvent, vr3.a(24));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o(MotionEvent motionEvent) {
        return motionEvent.getPointerCount() > 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!o(motionEvent) && !n(motionEvent) && !this.o) {
            this.i.k0();
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (!o(motionEvent) && !n(motionEvent) && !this.o && !this.t) {
            z();
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!o(motionEvent) && !n(motionEvent) && !p(motionEvent) && !this.o && !this.t && !this.r) {
            j(motionEvent, motionEvent2);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.q || n(motionEvent) || this.o || this.t) {
            return;
        }
        this.i.u0();
        this.n = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = this.w * scaleGestureDetector.getScaleFactor();
        this.w = scaleFactor;
        this.w = Math.max(1.0f, Math.min(scaleFactor, 5.0f));
        this.k.setPivotX(scaleGestureDetector.getFocusX());
        this.k.setPivotY(scaleGestureDetector.getFocusY());
        this.k.setScaleX(this.w);
        this.k.setScaleY(this.w);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        if (this.l || this.m || this.n || this.p || this.t) {
            this.o = false;
            return false;
        }
        this.o = true;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        App.e(new Runnable() { // from class: k60
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.w();
            }
        }, 500L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!o(motionEvent) && !n(motionEvent) && !this.o && !this.t && !this.n) {
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent.getY() - motionEvent2.getY();
            if (this.s) {
                i(Math.abs(x), Math.abs(y), motionEvent2);
            }
            if (this.p) {
                a aVar = this.i;
                long j = (long) (x * 50.0f);
                this.x = j;
                aVar.e0(j);
            }
            if (this.l) {
                B(y);
            }
            if (this.m) {
                D(y);
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (!o(motionEvent) && !n(motionEvent) && !this.o) {
            this.i.A();
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p(MotionEvent motionEvent) {
        int iK = vr3.k(this.j) / 4;
        return motionEvent.getX() <= ((float) iK) || motionEvent.getX() >= ((float) (iK * 3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void q() {
        this.r = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void r() {
        this.r = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void s() {
        ViewPropertyAnimator duration = this.k.animate().translationY(0.0f).setDuration(100L);
        final a aVar = this.i;
        Objects.requireNonNull(aVar);
        duration.withStartAction(new Runnable() { // from class: l60
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                aVar.m0();
            }
        }).withEndAction(new Runnable() { // from class: m60
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.r();
            }
        }).start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void t() {
        this.r = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void u() {
        this.r = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void v() {
        ViewPropertyAnimator duration = this.k.animate().translationY(0.0f).setDuration(100L);
        final a aVar = this.i;
        Objects.requireNonNull(aVar);
        duration.withStartAction(new Runnable() { // from class: n60
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                aVar.p0();
            }
        }).withEndAction(new Runnable() { // from class: o60
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.u();
            }
        }).start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void w() {
        this.o = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void x() {
        this.k.setPivotY(r0.getHeight() / 2.0f);
        this.k.setPivotX(r0.getWidth() / 2.0f);
        this.w = 1.0f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean y(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.q = false;
        }
        if (actionMasked == 5) {
            this.q = true;
        }
        if (actionMasked == 1) {
            this.i.C0();
        }
        if (this.n && actionMasked == 1) {
            this.i.P();
        }
        if (this.p && actionMasked == 1) {
            this.i.r0(this.x);
        }
        return motionEvent.getPointerCount() == 2 ? this.f.onTouchEvent(motionEvent) : this.g.onTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z() {
        this.x = 0L;
        this.s = true;
        this.p = false;
        this.n = false;
        this.l = false;
        this.m = false;
        this.u = jy4.f(this.j);
        this.v = this.h.getStreamVolume(3);
    }
}
