package defpackage;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class bk4 implements cs1, Serializable {
    public Function0 f;
    public volatile Object g;
    public final Object h;

    public bk4(Function0 function0, Object obj) {
        function0.getClass();
        this.f = function0;
        this.g = ov4.a;
        this.h = obj == null ? this : obj;
    }

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

    @Override // defpackage.cs1
    public boolean isInitialized() {
        return this.g != ov4.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ bk4(Function0 function0, Object obj, int i, we0 we0Var) {
        this(function0, (i & 2) != 0 ? null : obj);
    }
}
