package defpackage;

import defpackage.zu0;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class qf0 extends zu0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final qf0 n;
    public static final long o;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        Long l;
        qf0 qf0Var = new qf0();
        n = qf0Var;
        yu0.n0(qf0Var, false, 1, null);
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        o = TimeUnit.MILLISECONDS.toNanos(l.longValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized void N0() {
        if (Q0()) {
            debugStatus = 3;
            H0();
            notifyAll();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized Thread O0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(n.getClass().getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean P0() {
        return debugStatus == 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Q0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized boolean R0() {
        if (Q0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[SPUT, INVOKE, INVOKE, INVOKE]}, finally: {[SPUT, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public void run() {
        boolean zF0;
        mn4.a.d(this);
        g1.a();
        try {
            if (!R0()) {
                if (zF0) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jQ0 = q0();
                if (jQ0 == Long.MAX_VALUE) {
                    g1.a();
                    long jNanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = o + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        N0();
                        g1.a();
                        if (F0()) {
                            return;
                        }
                        t0();
                        return;
                    }
                    jQ0 = xn3.e(jQ0, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jQ0 > 0) {
                    if (Q0()) {
                        _thread = null;
                        N0();
                        g1.a();
                        if (F0()) {
                            return;
                        }
                        t0();
                        return;
                    }
                    g1.a();
                    LockSupport.parkNanos(this, jQ0);
                }
            }
        } finally {
            _thread = null;
            N0();
            g1.a();
            if (!F0()) {
                t0();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zu0, defpackage.yu0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.av0
    public Thread t0() {
        Thread thread = _thread;
        return thread == null ? O0() : thread;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n40
    public String toString() {
        return "DefaultExecutor";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.av0
    public void u0(long j, zu0.c cVar) {
        S0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zu0, defpackage.gj0
    public qm0 y(long j, Runnable runnable, g40 g40Var) {
        return K0(j, runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zu0
    public void z0(Runnable runnable) {
        if (P0()) {
            S0();
        }
        super.z0(runnable);
    }
}
