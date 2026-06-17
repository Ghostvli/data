package defpackage;

import androidx.media3.session.i;
import defpackage.no4;
import defpackage.pi2;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lj3 extends no4 {
    public static final lj3 g = new lj3(xi1.u(), null);
    public static final Object h = new Object();
    public final xi1 e;
    public final a f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final fg2 a;
        public final long b;
        public final long c;

        public a(fg2 fg2Var, long j, long j2) {
            this.a = fg2Var;
            this.b = j;
            this.c = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.a.equals(aVar.a) && this.c == aVar.c;
        }

        public int hashCode() {
            long j = this.b;
            int iHashCode = (((217 + ((int) (j ^ (j >>> 32)))) * 31) + this.a.hashCode()) * 31;
            long j2 = this.c;
            return iHashCode + ((int) (j2 ^ (j2 >>> 32)));
        }
    }

    public lj3(xi1 xi1Var, a aVar) {
        this.e = xi1Var;
        this.f = aVar;
    }

    public static lj3 H(List list) {
        xi1.a aVar = new xi1.a();
        for (int i = 0; i < list.size(); i++) {
            pi2.g gVar = (pi2.g) list.get(i);
            aVar.a(new a(i.w(gVar), gVar.u(), -9223372036854775807L));
        }
        return new lj3(aVar.k(), null);
    }

    public lj3 A() {
        return new lj3(this.e, this.f);
    }

    public lj3 B() {
        return new lj3(this.e, null);
    }

    public lj3 C(fg2 fg2Var, long j) {
        return new lj3(this.e, new a(fg2Var, -1L, j));
    }

    public lj3 D(int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList(this.e);
        fy4.b1(arrayList, i, i2, i3);
        return new lj3(xi1.p(arrayList), this.f);
    }

    public lj3 E(int i, fg2 fg2Var, long j) {
        gg3.d(i < this.e.size() || (i == this.e.size() && this.f != null));
        int size = this.e.size();
        xi1 xi1Var = this.e;
        if (i == size) {
            return new lj3(xi1Var, new a(fg2Var, -1L, j));
        }
        long j2 = ((a) xi1Var.get(i)).b;
        xi1.a aVar = new xi1.a();
        aVar.j(this.e.subList(0, i));
        aVar.a(new a(fg2Var, j2, j));
        xi1 xi1Var2 = this.e;
        aVar.j(xi1Var2.subList(i + 1, xi1Var2.size()));
        return new lj3(aVar.k(), this.f);
    }

    public lj3 F(int i, List list) {
        xi1.a aVar = new xi1.a();
        aVar.j(this.e.subList(0, i));
        for (int i2 = 0; i2 < list.size(); i2++) {
            aVar.a(new a((fg2) list.get(i2), -1L, -9223372036854775807L));
        }
        xi1 xi1Var = this.e;
        aVar.j(xi1Var.subList(i, xi1Var.size()));
        return new lj3(aVar.k(), this.f);
    }

    public lj3 G(int i, int i2) {
        xi1.a aVar = new xi1.a();
        aVar.j(this.e.subList(0, i));
        xi1 xi1Var = this.e;
        aVar.j(xi1Var.subList(i2, xi1Var.size()));
        return new lj3(aVar.k(), this.f);
    }

    public fg2 I(int i) {
        if (i >= v()) {
            return null;
        }
        return K(i).a;
    }

    public long J(int i) {
        if (i < 0 || i >= this.e.size()) {
            return -1L;
        }
        return ((a) this.e.get(i)).b;
    }

    public final a K(int i) {
        a aVar;
        return (i != this.e.size() || (aVar = this.f) == null) ? (a) this.e.get(i) : aVar;
    }

    @Override // defpackage.no4
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lj3)) {
            return false;
        }
        lj3 lj3Var = (lj3) obj;
        return Objects.equals(this.e, lj3Var.e) && Objects.equals(this.f, lj3Var.f);
    }

    @Override // defpackage.no4
    public int h(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.no4
    public int hashCode() {
        return Objects.hash(this.e, this.f);
    }

    @Override // defpackage.no4
    public no4.b m(int i, no4.b bVar, boolean z) {
        a aVarK = K(i);
        bVar.u(Long.valueOf(aVarK.b), null, i, fy4.c1(aVarK.c), 0L);
        return bVar;
    }

    @Override // defpackage.no4
    public int o() {
        return v();
    }

    @Override // defpackage.no4
    public Object s(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.no4
    public no4.d u(int i, no4.d dVar, long j) {
        a aVarK = K(i);
        dVar.h(h, aVarK.a, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, true, false, null, 0L, fy4.c1(aVarK.c), i, i, 0L);
        return dVar;
    }

    @Override // defpackage.no4
    public int v() {
        return this.e.size() + (this.f == null ? 0 : 1);
    }

    public boolean z(fg2 fg2Var) {
        a aVar = this.f;
        if (aVar != null && fg2Var.equals(aVar.a)) {
            return true;
        }
        for (int i = 0; i < this.e.size(); i++) {
            if (fg2Var.equals(((a) this.e.get(i)).a)) {
                return true;
            }
        }
        return false;
    }
}
