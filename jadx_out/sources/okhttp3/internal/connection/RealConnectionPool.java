package okhttp3.internal.connection;

import defpackage.eb3;
import defpackage.fw4;
import defpackage.gf5;
import defpackage.ow;
import defpackage.we0;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConnectionListener connectionListener;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* JADX WARN: Type inference failed for: r2v3, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i, long j, TimeUnit timeUnit, ConnectionListener connectionListener) {
        taskRunner.getClass();
        timeUnit.getClass();
        connectionListener.getClass();
        this.maxIdleConnections = i;
        this.connectionListener = connectionListener;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        this.cleanupQueue = taskRunner.newQueue();
        final String str = _UtilJvmKt.okHttpName + " ConnectionPool connection closer";
        this.cleanupTask = new Task(str) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return this.this$0.closeConnections(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (j > 0) {
            return;
        }
        eb3.a("keepAliveDuration <= 0: ", j);
        throw null;
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            gf5.a(Thread.currentThread().getName(), " MUST hold lock on ", realConnection);
            return 0;
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i = 0;
        while (i < calls.size()) {
            Reference<RealCall> reference = calls.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs(j - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: all -> 0x002a, TryCatch #1 {all -> 0x002a, blocks: (B:9:0x0023, B:14:0x002c, B:17:0x0033), top: B:40:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.internal.connection.RealConnection callAcquirePooledConnection$okhttp(boolean r6, okhttp3.Address r7, okhttp3.internal.connection.RealCall r8, java.util.List<okhttp3.Route> r9, boolean r10) {
        /*
            r5 = this;
            r7.getClass()
            r8.getClass()
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r0 = r5.connections
            java.util.Iterator r0 = r0.iterator()
            r0.getClass()
        Lf:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L66
            java.lang.Object r1 = r0.next()
            okhttp3.internal.connection.RealConnection r1 = (okhttp3.internal.connection.RealConnection) r1
            r1.getClass()
            monitor-enter(r1)
            r2 = 1
            r3 = 0
            if (r10 == 0) goto L2c
            boolean r4 = r1.isMultiplexed$okhttp()     // Catch: java.lang.Throwable -> L2a
            if (r4 != 0) goto L2c
            goto L37
        L2a:
            r5 = move-exception
            goto L64
        L2c:
            boolean r4 = r1.isEligible$okhttp(r7, r9)     // Catch: java.lang.Throwable -> L2a
            if (r4 != 0) goto L33
            goto L37
        L33:
            r8.acquireConnectionNoEvents(r1)     // Catch: java.lang.Throwable -> L2a
            r3 = r2
        L37:
            monitor-exit(r1)
            if (r3 == 0) goto Lf
            boolean r3 = r1.isHealthy(r6)
            if (r3 == 0) goto L41
            return r1
        L41:
            monitor-enter(r1)
            boolean r3 = r1.getNoNewExchanges()     // Catch: java.lang.Throwable -> L61
            r1.setNoNewExchanges(r2)     // Catch: java.lang.Throwable -> L61
            java.net.Socket r2 = r8.releaseConnectionNoEvents$okhttp()     // Catch: java.lang.Throwable -> L61
            monitor-exit(r1)
            if (r2 == 0) goto L59
            okhttp3.internal._UtilJvmKt.closeQuietly(r2)
            okhttp3.internal.connection.ConnectionListener r2 = r5.connectionListener
            r2.connectionClosed(r1)
            goto Lf
        L59:
            if (r3 != 0) goto Lf
            okhttp3.internal.connection.ConnectionListener r2 = r5.connectionListener
            r2.noNewExchanges(r1)
            goto Lf
        L61:
            r5 = move-exception
            monitor-exit(r1)
            throw r5
        L64:
            monitor-exit(r1)
            throw r5
        L66:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.callAcquirePooledConnection$okhttp(boolean, okhttp3.Address, okhttp3.internal.connection.RealCall, java.util.List, boolean):okhttp3.internal.connection.RealConnection");
    }

    public final long closeConnections(long j) {
        long j2 = (j - this.keepAliveDurationNs) + 1;
        Iterator<RealConnection> it = this.connections.iterator();
        it.getClass();
        RealConnection realConnection = null;
        long j3 = Long.MAX_VALUE;
        int i = 0;
        RealConnection realConnection2 = null;
        RealConnection realConnection3 = null;
        int i2 = 0;
        while (it.hasNext()) {
            RealConnection next = it.next();
            next.getClass();
            synchronized (next) {
                if (pruneAndGetAllocationCount(next, j) > 0) {
                    i2++;
                } else {
                    long idleAtNs = next.getIdleAtNs();
                    if (idleAtNs < j2) {
                        realConnection2 = next;
                        j2 = idleAtNs;
                    }
                    i++;
                    if (idleAtNs < j3) {
                        realConnection3 = next;
                        j3 = idleAtNs;
                    }
                }
                fw4 fw4Var = fw4.a;
            }
        }
        if (realConnection2 != null) {
            realConnection = realConnection2;
        } else if (i > this.maxIdleConnections) {
            j2 = j3;
            realConnection = realConnection3;
        } else {
            j2 = -1;
        }
        if (realConnection == null) {
            if (realConnection3 != null) {
                return (j3 + this.keepAliveDurationNs) - j;
            }
            if (i2 > 0) {
                return this.keepAliveDurationNs;
            }
            return -1L;
        }
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs() != j2) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            _UtilJvmKt.closeQuietly(realConnection.socket());
            this.connectionListener.connectionClosed(realConnection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        realConnection.getClass();
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            gf5.a(Thread.currentThread().getName(), " MUST hold lock on ", realConnection);
            return false;
        }
        if (!realConnection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            scheduleCloser();
            return false;
        }
        realConnection.setNoNewExchanges(true);
        this.connections.remove(realConnection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        it.getClass();
        while (it.hasNext()) {
            RealConnection next = it.next();
            next.getClass();
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
                this.connectionListener.connectionClosed(next);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    public final long getKeepAliveDurationNs$okhttp() {
        return this.keepAliveDurationNs;
    }

    public final int idleConnectionCount() {
        boolean zIsEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i = 0;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.isEmpty()) {
            return 0;
        }
        for (RealConnection realConnection : concurrentLinkedQueue) {
            realConnection.getClass();
            synchronized (realConnection) {
                zIsEmpty = realConnection.getCalls().isEmpty();
            }
            if (zIsEmpty && (i = i + 1) < 0) {
                ow.r();
            }
        }
        return i;
    }

    public final void put(RealConnection realConnection) {
        realConnection.getClass();
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            gf5.a(Thread.currentThread().getName(), " MUST hold lock on ", realConnection);
        } else {
            this.connections.add(realConnection);
            scheduleCloser();
        }
    }

    public final void scheduleCloser() {
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            connectionPool.getClass();
            return connectionPool.getDelegate$okhttp();
        }

        private Companion() {
        }
    }
}
