package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hi3 extends so implements sp1 {
    public final boolean f;

    public hi3(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.f = (i & 2) == 2;
    }

    @Override // defpackage.so
    public gp1 compute() {
        return this.f ? this : super.compute();
    }

    @Override // defpackage.so
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public sp1 getReflected() {
        if (!this.f) {
            return (sp1) super.getReflected();
        }
        fn.a("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof hi3) {
            hi3 hi3Var = (hi3) obj;
            return getOwner().equals(hi3Var.getOwner()) && getName().equals(hi3Var.getName()) && getSignature().equals(hi3Var.getSignature()) && il1.a(getBoundReceiver(), hi3Var.getBoundReceiver());
        }
        if (obj instanceof sp1) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        gp1 gp1VarCompute = compute();
        if (gp1VarCompute != this) {
            return gp1VarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
