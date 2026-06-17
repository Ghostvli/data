package org.jupnp.model.types;

import java.util.Arrays;
import org.jupnp.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DLNACaps {
    final String[] caps;

    public DLNACaps(String[] strArr) {
        this.caps = strArr;
    }

    public static DLNACaps valueOf(String str) {
        if (str == null || str.isEmpty()) {
            return new DLNACaps(new String[0]);
        }
        String[] strArrSplit = str.split(",");
        String[] strArr = new String[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            strArr[i] = strArrSplit[i].trim();
        }
        return new DLNACaps(strArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.caps, ((DLNACaps) obj).caps);
    }

    public String[] getCaps() {
        return this.caps;
    }

    public int hashCode() {
        return Arrays.hashCode(this.caps);
    }

    public String toString() {
        return ModelUtil.toCommaSeparatedList(getCaps());
    }
}
