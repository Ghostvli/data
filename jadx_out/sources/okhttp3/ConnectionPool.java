package okhttp3;

import defpackage.we0;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionListener;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionPool {
    private final RealConnectionPool delegate;

    public /* synthetic */ ConnectionPool(int i, long j, TimeUnit timeUnit, TaskRunner taskRunner, ConnectionListener connectionListener, int i2, we0 we0Var) {
        this((i2 & 1) != 0 ? 5 : i, (i2 & 2) != 0 ? 5L : j, (i2 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i2 & 8) != 0 ? TaskRunner.INSTANCE : taskRunner, (i2 & 16) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener);
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.delegate.getConnectionListener$okhttp();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public ConnectionPool(RealConnectionPool realConnectionPool) {
        realConnectionPool.getClass();
        this.delegate = realConnectionPool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i, long j, TimeUnit timeUnit, TaskRunner taskRunner, ConnectionListener connectionListener) {
        this(new RealConnectionPool(taskRunner, i, j, timeUnit, connectionListener));
        timeUnit.getClass();
        taskRunner.getClass();
        connectionListener.getClass();
    }

    public /* synthetic */ ConnectionPool(int i, long j, TimeUnit timeUnit, ConnectionListener connectionListener, int i2, we0 we0Var) {
        this((i2 & 1) != 0 ? 5 : i, (i2 & 2) != 0 ? 5L : j, (i2 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i2 & 8) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i, long j, TimeUnit timeUnit, ConnectionListener connectionListener) {
        this(i, j, timeUnit, TaskRunner.INSTANCE, connectionListener);
        timeUnit.getClass();
        connectionListener.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this(i, j, timeUnit, TaskRunner.INSTANCE, ConnectionListener.Companion.getNONE());
        timeUnit.getClass();
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
