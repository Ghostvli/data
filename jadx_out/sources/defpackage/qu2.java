package defpackage;

import defpackage.xs2;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qu2 implements xs2.a {
    public final float a;
    public a b;
    public a c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final int b;
        public final float c;

        public a(int i, int i2, float f) {
            this.a = i;
            this.b = i2;
            this.c = f;
        }

        public static a b(int i) {
            int i2 = (i >> 13) & 7;
            if (i2 == 0) {
                return null;
            }
            return new a(i2, (i >> 10) & 7, ((i & 511) * ((i & 512) != 0 ? -1 : 1)) / 10.0f);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && Float.compare(this.c, aVar.c) == 0;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + Float.hashCode(this.c);
        }

        public String toString() {
            return "GainField{name=" + this.a + ", originator=" + this.b + ", gain=" + this.c + '}';
        }
    }

    public qu2(float f, a aVar, a aVar2) {
        this.a = f;
        this.b = aVar;
        this.c = aVar2;
    }

    public static qu2 d(float f, int i, int i2) {
        a aVarB = a.b(i);
        a aVarB2 = a.b(i2);
        if (f <= 0.0f && aVarB == null && aVarB2 == null) {
            return null;
        }
        return new qu2(f, aVarB, aVarB2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qu2)) {
            return false;
        }
        qu2 qu2Var = (qu2) obj;
        return Float.compare(this.a, qu2Var.a) == 0 && Objects.equals(this.b, qu2Var.b) && Objects.equals(this.c, qu2Var.c);
    }

    public int hashCode() {
        int iHashCode = Float.hashCode(this.a) * 31;
        a aVar = this.b;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        a aVar2 = this.c;
        return iHashCode2 + (aVar2 != null ? aVar2.hashCode() : 0);
    }

    public String toString() {
        return "ReplayGain Xing/Info: peak=" + this.a + ", field 1=" + this.b + ", field 2=" + this.c;
    }
}
