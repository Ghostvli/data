package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class qw3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int a(ow3 ow3Var, String str) {
        ow3Var.getClass();
        str.getClass();
        int columnCount = ow3Var.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            if (il1.a(str, ow3Var.getColumnName(i))) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int b(ow3 ow3Var, String str) {
        ow3Var.getClass();
        str.getClass();
        int iA = pw3.a(ow3Var, str);
        if (iA >= 0) {
            return iA;
        }
        int columnCount = ow3Var.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i = 0; i < columnCount; i++) {
            arrayList.add(ow3Var.getColumnName(i));
        }
        im.a("Column '", str, "' does not exist. Available columns: [", ww.P(arrayList, null, null, null, 0, null, null, 63, null), 93);
        return 0;
    }
}
