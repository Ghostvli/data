package okhttp3.internal.connection;

import defpackage.we0;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class AddressPolicy {
    public final long backoffDelayMillis;
    public final int backoffJitterMillis;
    public final int minimumConcurrentCalls;

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0012: CONSTRUCTOR 
      (wrap:int:?: TERNARY null = ((wrap:int:0x0000: ARITH (r5v0 int) & (1 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (0 int) : (r1v0 int))
      (wrap:long:?: TERNARY null = ((wrap:int:0x0005: ARITH (r5v0 int) & (2 int) A[WRAPPED] (LINE:6)) != (0 int)) ? (wrap:long:0x0009: SGET  A[WRAPPED] (LINE:10) okhttp3.internal.ws.RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS long) : (r2v0 long))
      (wrap:int:?: TERNARY null = ((wrap:int:0x000c: ARITH (r5v0 int) & (4 int) A[WRAPPED] (LINE:13)) != (0 int)) ? (100 int) : (r4v0 int))
     A[MD:(int, long, int):void (m)] (LINE:19) call: okhttp3.internal.connection.AddressPolicy.<init>(int, long, int):void type: THIS */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public /* synthetic */ AddressPolicy(int i, long j, int i2, int i3, we0 we0Var) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS : j, (i3 & 4) != 0 ? 100 : i2);
    }

    public AddressPolicy(int i, long j, int i2) {
        this.minimumConcurrentCalls = i;
        this.backoffDelayMillis = j;
        this.backoffJitterMillis = i2;
    }

    public AddressPolicy() {
        this(0, 0L, 0, 7, null);
    }
}
