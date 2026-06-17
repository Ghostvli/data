package okhttp3.internal.concurrent;

import defpackage.dk1;
import defpackage.gf5;
import kotlin.jvm.functions.Function0;
import okhttp3.internal._UtilJvmKt;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class LockableKt {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void assertLockHeld(Lockable lockable) {
        lockable.getClass();
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(lockable)) {
            return;
        }
        gf5.a(Thread.currentThread().getName(), " MUST hold lock on ", lockable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void assertLockNotHeld(Lockable lockable) {
        lockable.getClass();
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(lockable)) {
            gf5.a(Thread.currentThread().getName(), " MUST NOT hold lock on ", lockable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void awaitNanos(Lockable lockable, long j) throws InterruptedException {
        lockable.getClass();
        long j2 = j / 1000000;
        long j3 = j - (1000000 * j2);
        if (j2 > 0 || j > 0) {
            lockable.wait(j2, (int) j3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void notify(Lockable lockable) {
        lockable.getClass();
        lockable.notify();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void notifyAll(Lockable lockable) {
        lockable.getClass();
        lockable.notifyAll();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void wait(Lockable lockable) throws InterruptedException {
        lockable.getClass();
        lockable.wait();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final <T> T withLock(Lockable lockable, Function0<? extends T> function0) {
        T tInvoke;
        lockable.getClass();
        function0.getClass();
        synchronized (lockable) {
            try {
                tInvoke = function0.invoke();
                dk1.b(1);
            } catch (Throwable th) {
                dk1.b(1);
                dk1.a(1);
                throw th;
            }
        }
        dk1.a(1);
        return tInvoke;
    }
}
