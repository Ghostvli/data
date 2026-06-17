package defpackage;

import defpackage.ph2;
import defpackage.xi1;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xs2 {
    public final a[] a;
    public final long b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        default t41 a() {
            return null;
        }

        default void b(ph2.b bVar) {
        }

        default byte[] c() {
            return null;
        }
    }

    public xs2(List list) {
        this((a[]) list.toArray(new a[0]));
    }

    public xs2 a(a... aVarArr) {
        return aVarArr.length == 0 ? this : new xs2(this.b, (a[]) fy4.h1(this.a, aVarArr));
    }

    public xs2 b(xs2 xs2Var) {
        return xs2Var == null ? this : a(xs2Var.a);
    }

    public xs2 c(long j) {
        return this.b == j ? this : new xs2(j, this.a);
    }

    public final a d(a aVar, Class cls, ig3 ig3Var) {
        if (!cls.isAssignableFrom(aVar.getClass())) {
            return null;
        }
        a aVar2 = (a) cls.cast(aVar);
        if (ig3Var.apply(aVar2)) {
            return aVar2;
        }
        return null;
    }

    public a e(int i) {
        return this.a[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && xs2.class == obj.getClass()) {
            xs2 xs2Var = (xs2) obj;
            if (Arrays.equals(this.a, xs2Var.a) && this.b == xs2Var.b) {
                return true;
            }
        }
        return false;
    }

    public xi1 f(Class cls) {
        xi1.a aVarM = xi1.m();
        for (a aVar : this.a) {
            if (cls.isAssignableFrom(aVar.getClass())) {
                aVarM.a((a) cls.cast(aVar));
            }
        }
        return aVarM.k();
    }

    public a g(Class cls) {
        return h(cls, jg3.b());
    }

    public a h(Class cls, ig3 ig3Var) {
        for (a aVar : this.a) {
            a aVarD = d(aVar, cls, ig3Var);
            if (aVarD != null) {
                return aVarD;
            }
        }
        return null;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.a) * 31) + y02.c(this.b);
    }

    public xi1 i(Class cls, ig3 ig3Var) {
        xi1.a aVarM = xi1.m();
        for (a aVar : this.a) {
            a aVarD = d(aVar, cls, ig3Var);
            if (aVarD != null) {
                aVarM.a(aVarD);
            }
        }
        return aVarM.k();
    }

    public int j() {
        return this.a.length;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("entries=");
        sb.append(Arrays.toString(this.a));
        if (this.b == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.b;
        }
        sb.append(str);
        return sb.toString();
    }

    public xs2(long j, a... aVarArr) {
        this.b = j;
        this.a = aVarArr;
    }

    public xs2(a... aVarArr) {
        this(-9223372036854775807L, aVarArr);
    }

    public xs2(long j, List list) {
        this(j, (a[]) list.toArray(new a[0]));
    }
}
