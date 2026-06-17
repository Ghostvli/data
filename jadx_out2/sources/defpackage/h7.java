package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class h7 {
    public static final ThreadLocal j = new ThreadLocal();
    public r71 e;
    public e i;
    public final x64 a = new x64();
    public final ArrayList b = new ArrayList();
    public final b c = new b();
    public final Runnable d = new Runnable() { // from class: g7
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public final void run() {
            this.f.c.a();
        }
    };
    public long f = 0;
    public boolean g = false;
    public float h = 1.0f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            h7.this.f = SystemClock.uptimeMillis();
            h7 h7Var = h7.this;
            h7Var.f(h7Var.f);
            if (h7.this.b.size() > 0) {
                h7.this.e.a(h7.this.d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        boolean a(long j);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements e {
        public ValueAnimator.DurationScaleChangeListener a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // h7.e
        public boolean a() {
            if (this.a != null) {
                return true;
            }
            ValueAnimator.DurationScaleChangeListener durationScaleChangeListener = new ValueAnimator.DurationScaleChangeListener() { // from class: i7
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                public final void onChanged(float f) {
                    h7.this.h = f;
                }
            };
            this.a = durationScaleChangeListener;
            return ValueAnimator.registerDurationScaleChangeListener(durationScaleChangeListener);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // h7.e
        public boolean b() {
            boolean zUnregisterDurationScaleChangeListener = ValueAnimator.unregisterDurationScaleChangeListener(this.a);
            this.a = null;
            return zUnregisterDurationScaleChangeListener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        boolean a();

        boolean b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f implements r71 {
        public final Choreographer a = Choreographer.getInstance();
        public final Looper b = Looper.myLooper();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r71
        public void a(final Runnable runnable) {
            this.a.postFrameCallback(new Choreographer.FrameCallback() { // from class: j7
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    runnable.run();
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r71
        public boolean b() {
            return Thread.currentThread() == this.b.getThread();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h7(r71 r71Var) {
        this.e = r71Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static h7 h() {
        ThreadLocal threadLocal = j;
        if (threadLocal.get() == null) {
            threadLocal.set(new h7(new f()));
        }
        return (h7) threadLocal.get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(c cVar, long j2) {
        if (this.b.size() == 0) {
            this.e.a(this.d);
            if (Build.VERSION.SDK_INT >= 33) {
                this.h = ValueAnimator.getDurationScale();
                if (this.i == null) {
                    this.i = new d();
                }
                this.i.a();
            }
        }
        if (!this.b.contains(cVar)) {
            this.b.add(cVar);
        }
        if (j2 > 0) {
            this.a.put(cVar, Long.valueOf(SystemClock.uptimeMillis() + j2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:5:0x000c */
    public final void e() {
        ArrayList arrayList;
        if (this.g) {
            int size = this.b.size();
            while (true) {
                size--;
                arrayList = this.b;
                if (size < 0) {
                    break;
                } else if (arrayList.get(size) == null) {
                    this.b.remove(size);
                }
            }
            if (arrayList.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                this.i.b();
            }
            this.g = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(long j2) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = (c) this.b.get(i);
            if (cVar != null && i(cVar, jUptimeMillis)) {
                cVar.a(j2);
            }
        }
        e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float g() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i(c cVar, long j2) {
        Long l = (Long) this.a.get(cVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() >= j2) {
            return false;
        }
        this.a.remove(cVar);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j() {
        return this.e.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(c cVar) {
        this.a.remove(cVar);
        int iIndexOf = this.b.indexOf(cVar);
        if (iIndexOf >= 0) {
            this.b.set(iIndexOf, null);
            this.g = true;
        }
    }
}
