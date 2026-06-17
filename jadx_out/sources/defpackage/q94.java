package defpackage;

import defpackage.xs2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q94 implements xs2.a {
    public final float a;
    public final int b;

    public q94(float f, int i) {
        this.a = f;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q94.class == obj.getClass()) {
            q94 q94Var = (q94) obj;
            if (this.a == q94Var.a && this.b == q94Var.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + x21.a(this.a)) * 31) + this.b;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.a + ", svcTemporalLayerCount=" + this.b;
    }
}
