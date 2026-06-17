package defpackage;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ax3 implements cs1, Serializable {
    public static final a i = new a(null);
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(ax3.class, Object.class, "g");
    public volatile Function0 f;
    public volatile Object g;
    public final Object h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ax3(Function0 function0) {
        function0.getClass();
        this.f = function0;
        ov4 ov4Var = ov4.a;
        this.g = ov4Var;
        this.h = ov4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cs1
    public Object getValue() {
        Object obj = this.g;
        ov4 ov4Var = ov4.a;
        if (obj != ov4Var) {
            return obj;
        }
        Function0 function0 = this.f;
        if (function0 != null) {
            Object objInvoke = function0.invoke();
            if (z0.a(j, this, ov4Var, objInvoke)) {
                this.f = null;
                return objInvoke;
            }
        }
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cs1
    public boolean isInitialized() {
        return this.g != ov4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: ax3.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
