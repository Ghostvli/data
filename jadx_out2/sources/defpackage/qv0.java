package defpackage;

import defpackage.g40;
import defpackage.qv0;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qv0 extends n40 implements Closeable, AutoCloseable {
    public static final a h = new a(null);

    public abstract Executor h0();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends y {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            super(n40.g, new Function1() { // from class: pv0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return qv0.a.c((g40.b) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static qv0 c(g40.b bVar) {
            if (bVar instanceof qv0) {
                return (qv0) bVar;
            }
            return null;
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:12) call: qv0.a.<init>():void type: THIS */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }
    }
}
