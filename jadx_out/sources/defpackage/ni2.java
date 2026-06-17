package defpackage;

import defpackage.jq2;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ni2 {
    public final jq2.b a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    public ni2(jq2.b bVar, long j, long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = true;
        gg3.d(!z5 || z3);
        gg3.d(!z4 || z3);
        if (z2 && (z3 || z4 || z5)) {
            z6 = false;
        }
        gg3.d(z6);
        this.a = bVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = z5;
    }

    public ni2 a(long j) {
        return j == this.d ? this : new ni2(this.a, this.b, this.c, j, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }

    public ni2 b(long j, long j2) {
        return (j == this.b && j2 == this.c) ? this : new ni2(this.a, j, j2, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ni2.class == obj.getClass()) {
            ni2 ni2Var = (ni2) obj;
            if (this.b == ni2Var.b && this.d == ni2Var.d && this.e == ni2Var.e && this.f == ni2Var.f && this.g == ni2Var.g && this.h == ni2Var.h && this.i == ni2Var.i && this.j == ni2Var.j && this.k == ni2Var.k && Objects.equals(this.a, ni2Var.a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.a.hashCode()) * 31) + ((int) this.b)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + ((int) this.f)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0)) * 31) + (this.k ? 1 : 0);
    }
}
