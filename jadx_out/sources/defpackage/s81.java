package defpackage;

import kotlin.jvm.internal.FunctionBase;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s81 extends so implements FunctionBase, np1 {
    private final int arity;
    private final int flags;

    public s81(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }

    @Override // defpackage.so
    public gp1 computeReflected() {
        return np3.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s81) {
            s81 s81Var = (s81) obj;
            return getName().equals(s81Var.getName()) && getSignature().equals(s81Var.getSignature()) && this.flags == s81Var.flags && this.arity == s81Var.arity && il1.a(getBoundReceiver(), s81Var.getBoundReceiver()) && il1.a(getOwner(), s81Var.getOwner());
        }
        if (obj instanceof np1) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // defpackage.so
    public np1 getReflected() {
        return (np1) super.getReflected();
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // defpackage.np1
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // defpackage.np1
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // defpackage.np1
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // defpackage.np1
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // defpackage.np1
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        gp1 gp1VarCompute = compute();
        if (gp1VarCompute != this) {
            return gp1VarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
