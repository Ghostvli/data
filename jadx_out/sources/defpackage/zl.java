package defpackage;

import com.hierynomus.msdtyp.FileTime;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zl {
    public static final gs a = new gs(-1, null, null, 0);
    public static final int b = rk4.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
    public static final int c = rk4.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", FileTime.NANO100_TO_MILLI, 0, 0, 12, null);
    public static final qj4 d = new qj4("BUFFERED");
    public static final qj4 e = new qj4("SHOULD_BUFFER");
    public static final qj4 f = new qj4("S_RESUMING_BY_RCV");
    public static final qj4 g = new qj4("RESUMING_BY_EB");
    public static final qj4 h = new qj4("POISONED");
    public static final qj4 i = new qj4("DONE_RCV");
    public static final qj4 j = new qj4("INTERRUPTED_SEND");
    public static final qj4 k = new qj4("INTERRUPTED_RCV");
    public static final qj4 l = new qj4("CHANNEL_CLOSED");
    public static final qj4 m = new qj4("SUSPEND");
    public static final qj4 n = new qj4("SUSPEND_NO_WAITER");
    public static final qj4 o = new qj4("FAILED");
    public static final qj4 p = new qj4("NO_RECEIVE_RESULT");
    public static final qj4 q = new qj4("CLOSE_HANDLER_CLOSED");
    public static final qj4 r = new qj4("CLOSE_HANDLER_INVOKED");
    public static final qj4 s = new qj4("NO_CLOSE_CAUSE");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class a extends t81 implements Function2 {
        public static final a f = new a();

        public a() {
            super(2, zl.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final gs e(long j, gs gsVar) {
            return zl.x(j, gsVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return e(((Number) obj).longValue(), (gs) obj2);
        }
    }

    public static final long A(int i2) {
        if (i2 == 0) {
            return 0L;
        }
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        return Long.MAX_VALUE;
    }

    public static final boolean B(qp qpVar, Object obj, Function3 function3) {
        Object objK = qpVar.k(obj, null, function3);
        if (objK == null) {
            return false;
        }
        qpVar.m(objK);
        return true;
    }

    public static /* synthetic */ boolean C(qp qpVar, Object obj, Function3 function3, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            function3 = null;
        }
        return B(qpVar, obj, function3);
    }

    public static final long v(long j2, boolean z) {
        return (z ? 4611686018427387904L : 0L) + j2;
    }

    public static final long w(long j2, int i2) {
        return (((long) i2) << 60) + j2;
    }

    public static final gs x(long j2, gs gsVar) {
        return new gs(j2, gsVar, gsVar.y(), 0);
    }

    public static final np1 y() {
        return a.f;
    }

    public static final qj4 z() {
        return l;
    }
}
