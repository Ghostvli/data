package defpackage;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n95 {
    public final a a;
    public final mc1 b;
    public final mc1 c;
    public boolean d;
    public boolean e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final Context a;
        public WifiManager.WifiLock b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Context context) {
            this.a = context;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c(final AtomicBoolean atomicBoolean) {
            if (atomicBoolean.get()) {
                new Thread(new Runnable() { // from class: m95
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.d(atomicBoolean);
                    }
                }, "ExoPlayer:WifiLockManager").start();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final synchronized void d(AtomicBoolean atomicBoolean) {
            WifiManager.WifiLock wifiLock;
            if (atomicBoolean.get() && (wifiLock = this.b) != null) {
                wifiLock.release();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(boolean z, boolean z2) {
            if (z && this.b == null) {
                if (this.a.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                    xz1.i("WifiLockManager", "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                    return;
                }
                WifiManager wifiManager = (WifiManager) this.a.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    xz1.i("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                    return;
                } else {
                    WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                    this.b = wifiLockCreateWifiLock;
                    wifiLockCreateWifiLock.setReferenceCounted(false);
                }
            }
            if (this.b == null) {
                return;
            }
            boolean zH = n95.h(z, z2);
            WifiManager.WifiLock wifiLock = this.b;
            if (zH) {
                wifiLock.acquire();
            } else {
                wifiLock.release();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public n95(Context context, Looper looper, zu zuVar) {
        this.a = new a(context.getApplicationContext());
        this.b = zuVar.c(looper, null);
        this.c = zuVar.c(Looper.getMainLooper(), null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(n95 n95Var, AtomicBoolean atomicBoolean, boolean z, boolean z2) {
        n95Var.getClass();
        atomicBoolean.set(false);
        n95Var.a.e(z, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean h(boolean z, boolean z2) {
        return z && z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(final boolean z, final boolean z2) {
        if (h(z, z2)) {
            this.b.d(new Runnable() { // from class: j95
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.a.e(z, z2);
                }
            });
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.c.g(new Runnable() { // from class: k95
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.a.c(atomicBoolean);
            }
        }, 1000L);
        this.b.d(new Runnable() { // from class: l95
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                n95.a(this.f, atomicBoolean, z, z2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(boolean z) {
        if (this.d == z) {
            return;
        }
        this.d = z;
        e(z, this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
