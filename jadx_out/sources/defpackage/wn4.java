package defpackage;

import defpackage.xs2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wn4 implements xs2.a {
    public final long a;

    public wn4(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && wn4.class == obj.getClass() && this.a == ((wn4) obj).a;
    }

    public int hashCode() {
        return 527 + y02.c(this.a);
    }

    public String toString() {
        return "ThumbnailMetadata: presentationTimeUs=" + this.a;
    }
}
