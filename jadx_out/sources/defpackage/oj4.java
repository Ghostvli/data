package defpackage;

import kotlin.jvm.internal.FunctionBase;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class oj4 extends g30 implements FunctionBase {
    private final int arity;

    public oj4(int i, f30 f30Var) {
        super(f30Var);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // defpackage.hh
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strG = np3.g(this);
        strG.getClass();
        return strG;
    }
}
