package defpackage;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer$VsyncCallback;
import android.view.Display;
import android.view.Surface;
import defpackage.n25;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n25 {
    public final Context b;
    public boolean c;
    public c d;
    public boolean e;
    public Surface f;
    public float h;
    public float i;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public final u11 a = new u11();
    public float g = -1.0f;
    public float j = 1.0f;
    public int k = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                xz1.e("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c implements DisplayManager.DisplayListener {
        public final Choreographer f;
        public final DisplayManager g;
        public volatile long h;
        public volatile long i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Choreographer choreographer, DisplayManager displayManager) {
            this.f = choreographer;
            this.g = displayManager;
            this.h = -9223372036854775807L;
            this.i = -9223372036854775807L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c b(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager == null) {
                return null;
            }
            try {
                Choreographer choreographer = Choreographer.getInstance();
                return Build.VERSION.SDK_INT >= 33 ? new e(choreographer, displayManager) : new d(choreographer, displayManager);
            } catch (RuntimeException e) {
                xz1.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            this.g.registerDisplayListener(this, fy4.E());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            this.g.unregisterDisplayListener(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends c implements Choreographer.FrameCallback {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Choreographer choreographer, DisplayManager displayManager) {
            super(choreographer, displayManager);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static long e(DisplayManager displayManager) {
            Display display = displayManager.getDisplay(0);
            if (display != null) {
                return (long) (1.0E9d / ((double) display.getRefreshRate()));
            }
            xz1.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            return -9223372036854775807L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // n25.c
        public void c() {
            super.c();
            this.f.postFrameCallback(this);
            this.i = e(this.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // n25.c
        public void d() {
            super.d();
            this.f.removeFrameCallback(this);
            this.h = -9223372036854775807L;
            this.i = -9223372036854775807L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.h = j;
            this.f.postFrameCallbackDelayed(this, 500L);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                this.f.postFrameCallback(this);
                this.i = e(this.g);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends c implements Choreographer$VsyncCallback {
        public final Handler j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(Choreographer choreographer, DisplayManager displayManager) {
            super(choreographer, displayManager);
            this.j = fy4.E();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // n25.c
        public void c() {
            super.c();
            this.f.postVsyncCallback(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // n25.c
        public void d() {
            super.d();
            this.j.removeCallbacksAndMessages(null);
            this.f.removeVsyncCallback(this);
            this.h = -9223372036854775807L;
            this.i = -9223372036854775807L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                this.f.postVsyncCallback(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void onVsync(Choreographer.FrameData frameData) {
            this.h = frameData.getFrameTimeNanos();
            Choreographer.FrameTimeline[] frameTimelines = frameData.getFrameTimelines();
            if (frameTimelines.length >= 2) {
                long expectedPresentationTimeNanos = frameTimelines[1].getExpectedPresentationTimeNanos() - frameTimelines[0].getExpectedPresentationTimeNanos();
                this.i = expectedPresentationTimeNanos != 0 ? expectedPresentationTimeNanos : -9223372036854775807L;
            } else {
                this.i = -9223372036854775807L;
            }
            this.j.postDelayed(new Runnable() { // from class: o25
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    n25.e eVar = this.f;
                    eVar.f.postVsyncCallback(eVar);
                }
            }, 500L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public n25(Context context) {
        this.b = context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b(long j, long j2) {
        return Math.abs(j - j2) <= 20000000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long a(long j, long j2) {
        long j3;
        float fA;
        float f;
        if (this.r == -1) {
            j3 = j;
        } else {
            if (this.a.e()) {
                fA = this.a.a() * (this.n - this.r);
                f = this.j;
            } else {
                fA = (j2 - this.t) * 1000;
                f = this.j;
            }
            long j4 = this.s + ((long) (fA / f));
            if (b(j, j4)) {
                j3 = j4;
            } else {
                l();
                j3 = j;
            }
        }
        this.o = this.n;
        this.p = j3;
        this.q = j2;
        c cVar = this.d;
        if (cVar != null) {
            long j5 = cVar.h;
            long j6 = this.d.i;
            if (j5 != -9223372036854775807L && j6 != -9223372036854775807L) {
                return d(j3, j5, j6) - ((j6 * 80) / 100);
            }
        }
        return j3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.f) == null || this.k == Integer.MIN_VALUE || this.i == 0.0f || !surface.isValid()) {
            return;
        }
        this.i = 0.0f;
        b.a(this.f, 0.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long d(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j4 = j5;
            j5 += j3;
        }
        long j6 = j5 - j;
        long j7 = j - j4;
        long jAbs = Math.abs(j6 - j7);
        if (jAbs < j3 / 2) {
            long j8 = j3 / 4;
            if (jAbs < j8) {
                long j9 = this.l;
                if (j9 != 0) {
                    this.m = j9;
                } else {
                    if (j6 < j7) {
                        j8 = -j8;
                    }
                    this.m = j8;
                }
            } else {
                this.m = 0L;
            }
        } else {
            this.m = this.l;
        }
        return j6 + this.m < j7 ? j5 : j4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(float f) {
        this.g = f;
        this.a.g();
        n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(long j) {
        long j2 = this.o;
        if (j2 != -1) {
            this.r = j2;
            this.s = this.p;
            this.t = this.q;
            this.l = this.m;
        }
        this.n++;
        this.a.f(j * 1000);
        n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(float f) {
        this.j = f;
        o(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i() {
        this.e = true;
        l();
        if (!this.c) {
            this.d = c.b(this.b);
        }
        c cVar = this.d;
        if (cVar != null) {
            cVar.c();
        }
        o(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j() {
        this.e = false;
        c cVar = this.d;
        if (cVar != null) {
            cVar.d();
        }
        c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(Surface surface) {
        if (this.f == surface) {
            return;
        }
        c();
        this.f = surface;
        o(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l() {
        this.n = 0L;
        this.r = -1L;
        this.o = -1L;
        this.l = 0L;
        this.m = 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(int i) {
        if (this.k == i) {
            return;
        }
        this.k = i;
        o(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        if (Build.VERSION.SDK_INT < 30 || this.f == null) {
            return;
        }
        float fB = this.a.e() ? this.a.b() : this.g;
        float f = this.h;
        if (fB == f) {
            return;
        }
        if (fB != -1.0f && f != -1.0f) {
            if (Math.abs(fB - this.h) < ((!this.a.e() || this.a.d() < 5000000000L) ? 1.0f : 0.1f)) {
                return;
            }
        } else if (fB == -1.0f && this.a.c() < 30) {
            return;
        }
        this.h = fB;
        o(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(boolean z) {
        Surface surface;
        float f;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.f) == null || this.k == Integer.MIN_VALUE || !surface.isValid()) {
            return;
        }
        if (this.e) {
            float f2 = this.h;
            f = f2 != -1.0f ? f2 * this.j : 0.0f;
        }
        if (z || this.i != f) {
            this.i = f;
            b.a(this.f, f);
        }
    }
}
