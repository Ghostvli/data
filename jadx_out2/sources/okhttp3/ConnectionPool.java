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

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0027: CONSTRUCTOR 
      (wrap:int:?: TERNARY null = ((wrap:int:0x0000: ARITH (r7v0 int) & (1 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (5 int) : (r1v0 int))
      (wrap:long:?: TERNARY null = ((wrap:int:0x0005: ARITH (r7v0 int) & (2 int) A[WRAPPED] (LINE:6)) != (0 int)) ? (5 long) : (r2v0 long))
      (wrap:java.util.concurrent.TimeUnit:?: TERNARY null = ((wrap:int:0x000b: ARITH (r7v0 int) & (4 int) A[WRAPPED] (LINE:12)) != (0 int)) ? (wrap:java.util.concurrent.TimeUnit:0x000f: SGET  A[WRAPPED] (LINE:16) java.util.concurrent.TimeUnit.MINUTES java.util.concurrent.TimeUnit) : (r4v0 java.util.concurrent.TimeUnit))
      (wrap:okhttp3.internal.concurrent.TaskRunner:?: TERNARY null = ((wrap:int:0x0011: ARITH (r7v0 int) & (8 int) A[WRAPPED] (LINE:18)) != (0 int)) ? (wrap:okhttp3.internal.concurrent.TaskRunner:0x0015: SGET  A[WRAPPED] (LINE:22) okhttp3.internal.concurrent.TaskRunner.INSTANCE okhttp3.internal.concurrent.TaskRunner) : (r5v0 okhttp3.internal.concurrent.TaskRunner))
      (wrap:okhttp3.internal.connection.ConnectionListener:?: TERNARY null = ((wrap:int:0x0017: ARITH (r7v0 int) & (16 int) A[WRAPPED] (LINE:24)) != (0 int)) ? (wrap:okhttp3.internal.connection.ConnectionListener:0x001d: INVOKE 
      (wrap:okhttp3.internal.connection.ConnectionListener$Companion:0x001b: SGET  A[WRAPPED] (LINE:28) okhttp3.internal.connection.ConnectionListener.Companion okhttp3.internal.connection.ConnectionListener$Companion)
     VIRTUAL call: okhttp3.internal.connection.ConnectionListener.Companion.getNONE():okhttp3.internal.connection.ConnectionListener A[MD:():okhttp3.internal.connection.ConnectionListener (m), WRAPPED] (LINE:30)) : (r6v0 okhttp3.internal.connection.ConnectionListener))
     A[MD:(int, long, java.util.concurrent.TimeUnit, okhttp3.internal.concurrent.TaskRunner, okhttp3.internal.connection.ConnectionListener):void (m)] (LINE:40) call: okhttp3.ConnectionPool.<init>(int, long, java.util.concurrent.TimeUnit, okhttp3.internal.concurrent.TaskRunner, okhttp3.internal.connection.ConnectionListener):void type: THIS */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public /* synthetic */ ConnectionPool(int i, long j, TimeUnit timeUnit, TaskRunner taskRunner, ConnectionListener connectionListener, int i2, we0 we0Var) {
        this((i2 & 1) != 0 ? 5 : i, (i2 & 2) != 0 ? 5L : j, (i2 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i2 & 8) != 0 ? TaskRunner.INSTANCE : taskRunner, (i2 & 16) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void evictAll() {
        this.delegate.evictAll();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ConnectionListener getConnectionListener$okhttp() {
        return this.delegate.getConnectionListener$okhttp();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0020: CONSTRUCTOR 
      (wrap:int:?: TERNARY null = ((wrap:int:0x0000: ARITH (r6v0 int) & (1 int) A[WRAPPED]) != (0 int)) ? (5 int) : (r1v0 int))
      (wrap:long:?: TERNARY null = ((wrap:int:0x0005: ARITH (r6v0 int) & (2 int) A[WRAPPED]) != (0 int)) ? (5 long) : (r2v0 long))
      (wrap:java.util.concurrent.TimeUnit:?: TERNARY null = ((wrap:int:0x000b: ARITH (r6v0 int) & (4 int) A[WRAPPED]) != (0 int)) ? (wrap:java.util.concurrent.TimeUnit:0x000f: SGET  A[WRAPPED] (LINE:48) java.util.concurrent.TimeUnit.MINUTES java.util.concurrent.TimeUnit) : (r4v0 java.util.concurrent.TimeUnit))
      (wrap:okhttp3.internal.connection.ConnectionListener:?: TERNARY null = ((wrap:int:0x0011: ARITH (r6v0 int) & (8 int) A[WRAPPED]) != (0 int)) ? (wrap:okhttp3.internal.connection.ConnectionListener:0x0017: INVOKE 
      (wrap:okhttp3.internal.connection.ConnectionListener$Companion:0x0015: SGET  A[WRAPPED] (LINE:49) okhttp3.internal.connection.ConnectionListener.Companion okhttp3.internal.connection.ConnectionListener$Companion)
     VIRTUAL call: okhttp3.internal.connection.ConnectionListener.Companion.getNONE():okhttp3.internal.connection.ConnectionListener A[MD:():okhttp3.internal.connection.ConnectionListener (m), WRAPPED] (LINE:49)) : (r5v0 okhttp3.internal.connection.ConnectionListener))
     A[MD:(int, long, java.util.concurrent.TimeUnit, okhttp3.internal.connection.ConnectionListener):void (m)] (LINE:50) call: okhttp3.ConnectionPool.<init>(int, long, java.util.concurrent.TimeUnit, okhttp3.internal.connection.ConnectionListener):void type: THIS */
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
