package defpackage;

import defpackage.xs2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class av2 implements xs2.a {
    public final long a;
    public final long b;
    public final long c;

    public av2(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof av2)) {
            return false;
        }
        av2 av2Var = (av2) obj;
        return this.a == av2Var.a && this.b == av2Var.b && this.c == av2Var.c;
    }

    public int hashCode() {
        return ((((527 + y02.c(this.a)) * 31) + y02.c(this.b)) * 31) + y02.c(this.c);
    }

    public String toString() {
        return "Mp4Timestamp: creation time=" + this.a + ", modification time=" + this.b + ", timescale=" + this.c;
    }
}
