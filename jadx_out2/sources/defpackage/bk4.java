package defpackage;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class bk4 implements cs1, Serializable {
    public Function0 f;
    public volatile Object g;
    public final Object h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bk4(Function0 function0, Object obj) {
        function0.getClass();
        this.f = function0;
        this.g = ov4.a;
        this.h = obj == null ? this : obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cs1
    public Object getValue() {
        Object objInvoke;
        Object obj = this.g;
        ov4 ov4Var = ov4.a;
        if (obj != ov4Var) {
            return obj;
        }
        synchronized (this.h) {
            objInvoke = this.g;
            if (objInvoke == ov4Var) {
                Function0 function0 = this.f;
                function0.getClass();
                objInvoke = function0.invoke();
                this.g = objInvoke;
                this.f = null;
            }
        }
        return objInvoke;
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

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0005: CONSTRUCTOR 
      (r1v0 kotlin.jvm.functions.Function0)
      (wrap:java.lang.Object:?: TERNARY null = ((wrap:int:0x0000: ARITH (r3v0 int) & (2 int) A[WRAPPED]) != (0 int)) ? (null java.lang.Object) : (r2v0 java.lang.Object))
     A[MD:(kotlin.jvm.functions.Function0, java.lang.Object):void (m)] (LINE:19) call: bk4.<init>(kotlin.jvm.functions.Function0, java.lang.Object):void type: THIS */
    public /* synthetic */ bk4(Function0 function0, Object obj, int i, we0 we0Var) {
        this(function0, (i & 2) != 0 ? null : obj);
    }
}
