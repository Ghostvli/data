package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class qk1 implements Iterable, op1 {
    public static final a i = new a(null);
    public final int f;
    public final int g;
    public final int h;

    public qk1(int i2, int i3, int i4) {
        if (i4 == 0) {
            jl.a("Step must be non-zero.");
            throw null;
        }
        if (i4 == Integer.MIN_VALUE) {
            jl.a("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.f = i2;
        this.g = qh3.b(i2, i3, i4);
        this.h = i4;
    }

    public final int b() {
        return this.f;
    }

    public final int c() {
        return this.g;
    }

    public final int d() {
        return this.h;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ok1 iterator() {
        return new rk1(this.f, this.g, this.h);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qk1)) {
            return false;
        }
        if (isEmpty() && ((qk1) obj).isEmpty()) {
            return true;
        }
        qk1 qk1Var = (qk1) obj;
        return this.f == qk1Var.f && this.g == qk1Var.g && this.h == qk1Var.h;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f * 31) + this.g) * 31) + this.h;
    }

    public boolean isEmpty() {
        int i2 = this.h;
        int i3 = this.f;
        int i4 = this.g;
        return i2 > 0 ? i3 > i4 : i3 < i4;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        int i3 = this.h;
        int i4 = this.f;
        if (i3 > 0) {
            sb = new StringBuilder();
            sb.append(i4);
            sb.append("..");
            sb.append(this.g);
            sb.append(" step ");
            i2 = this.h;
        } else {
            sb = new StringBuilder();
            sb.append(i4);
            sb.append(" downTo ");
            sb.append(this.g);
            sb.append(" step ");
            i2 = -this.h;
        }
        sb.append(i2);
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final qk1 a(int i, int i2, int i3) {
            return new qk1(i, i2, i3);
        }

        public a() {
        }
    }
}
