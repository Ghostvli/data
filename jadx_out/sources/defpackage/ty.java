package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ty extends x63 implements Serializable {
    public final Comparator[] f;

    public ty(Comparator comparator, Comparator comparator2) {
        this.f = new Comparator[]{comparator, comparator2};
    }

    @Override // defpackage.x63, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int i = 0;
        while (true) {
            Comparator[] comparatorArr = this.f;
            if (i >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ty) {
            return Arrays.equals(this.f, ((ty) obj).f);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.f) + ")";
    }
}
