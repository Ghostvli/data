package defpackage;

import defpackage.xs2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ru2 implements xs2.a {
    public final int a;

    public ru2(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ru2) && this.a == ((ru2) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return "Mp4AlternateGroup: " + this.a;
    }
}
