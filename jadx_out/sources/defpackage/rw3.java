package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class rw3 {
    public static final int a(ow3 ow3Var, String str) {
        ow3Var.getClass();
        str.getClass();
        int iB = pw3.b(ow3Var, str);
        if (iB >= 0) {
            return iB;
        }
        int iB2 = pw3.b(ow3Var, "`" + str + '`');
        return iB2 >= 0 ? iB2 : b(ow3Var, str);
    }

    public static final int b(ow3 ow3Var, String str) {
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            int columnCount = ow3Var.getColumnCount();
            String str2 = "." + str;
            String str3 = "." + str + '`';
            for (int i = 0; i < columnCount; i++) {
                String columnName = ow3Var.getColumnName(i);
                if (columnName.length() >= str.length() + 2 && (sg4.x(columnName, str2, false, 2, null) || (columnName.charAt(0) == '`' && sg4.x(columnName, str3, false, 2, null)))) {
                    return i;
                }
            }
        }
        return -1;
    }
}
