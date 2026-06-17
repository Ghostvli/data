package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class c94 implements Comparable {
    public final int f;
    public final int g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c94(int i, int i2) {
        this.f = i;
        this.g = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c94 c94Var) {
        int i = this.g * this.f;
        int i2 = c94Var.g * c94Var.f;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c94 b() {
        return new c94(this.g, this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c94 e(c94 c94Var) {
        int i = this.f;
        int i2 = c94Var.g;
        int i3 = i * i2;
        int i4 = c94Var.f;
        int i5 = this.g;
        return i3 <= i4 * i5 ? new c94(i4, (i5 * i4) / i) : new c94((i * i2) / i5, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c94 c94Var = (c94) obj;
            if (this.f == c94Var.f && this.g == c94Var.g) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c94 f(c94 c94Var) {
        int i = this.f;
        int i2 = c94Var.g;
        int i3 = i * i2;
        int i4 = c94Var.f;
        int i5 = this.g;
        return i3 >= i4 * i5 ? new c94(i4, (i5 * i4) / i) : new c94((i * i2) / i5, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return (this.f * 31) + this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.f + "x" + this.g;
    }
}
