package defpackage;

import defpackage.xs2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zu2 implements xs2.a {
    public final float a;
    public final float b;

    public zu2(float f, float f2) {
        gg3.e(f >= -90.0f && f <= 90.0f && f2 >= -180.0f && f2 <= 180.0f, "Invalid latitude or longitude");
        this.a = f;
        this.b = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zu2.class == obj.getClass()) {
            zu2 zu2Var = (zu2) obj;
            if (this.a == zu2Var.a && this.b == zu2Var.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + x21.a(this.a)) * 31) + x21.a(this.b);
    }

    public String toString() {
        return "xyz: latitude=" + this.a + ", longitude=" + this.b;
    }
}
