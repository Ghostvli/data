package defpackage;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class l85 {
    public final a a;
    public final mc1 b;
    public final mc1 c;
    public boolean d;
    public boolean e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final Context a;
        public PowerManager.WakeLock b;

        public a(Context context) {
            this.a = context;
        }

        public final void d(final AtomicBoolean atomicBoolean) {
            if (atomicBoolean.get()) {
                new Thread(new Runnable() { // from class: k85
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.e(atomicBoolean);
                    }
                }, "ExoPlayer:WakeLockManager").start();
            }
        }

        public final synchronized void e(AtomicBoolean atomicBoolean) {
            PowerManager.WakeLock wakeLock;
            if (atomicBoolean.get() && (wakeLock = this.b) != null) {
                wakeLock.release();
            }
        }

        public final synchronized void f(boolean z, boolean z2) {
            if (z) {
                if (this.b == null) {
                    if (this.a.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                        xz1.i("WakeLockManager", "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                        return;
                    }
                    PowerManager powerManager = (PowerManager) this.a.getSystemService("power");
                    if (powerManager == null) {
                        xz1.i("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                        return;
                    } else {
                        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                        this.b = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.setReferenceCounted(false);
                    }
                }
            }
            if (this.b == null) {
                return;
            }
            boolean zH = l85.h(z, z2);
            PowerManager.WakeLock wakeLock = this.b;
            if (zH) {
                wakeLock.acquire();
            } else {
                wakeLock.release();
            }
        }
    }

    public l85(Context context, Looper looper, zu zuVar) {
        this.a = new a(context.getApplicationContext());
        this.b = zuVar.c(looper, null);
        this.c = zuVar.c(Looper.getMainLooper(), null);
    }

    public static /* synthetic */ void a(l85 l85Var, AtomicBoolean atomicBoolean, boolean z, boolean z2) {
        l85Var.getClass();
        atomicBoolean.set(false);
        l85Var.a.f(z, z2);
    }

    public static boolean h(boolean z, boolean z2) {
        return z && z2;
    }

    public final void e(final boolean z, final boolean z2) {
        if (h(z, z2)) {
            this.b.d(new Runnable() { // from class: h85
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.a.f(z, z2);
                }
            });
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.c.g(new Runnable() { // from class: i85
            @Override // java.lang.Runnable
            public final void run() {
                this.f.a.d(atomicBoolean);
            }
        }, 1000L);
        this.b.d(new Runnable() { // from class: j85
            @Override // java.lang.Runnable
            public final void run() {
                l85.a(this.f, atomicBoolean, z, z2);
            }
        });
    }

    public void f(boolean z) {
        if (this.d == z) {
            return;
        }
        this.d = z;
        e(z, this.e);
    }

    public void g(boolean z) {
        if (this.e == z) {
            return;
        }
        this.e = z;
        if (this.d) {
            e(true, z);
        }
    }
}
