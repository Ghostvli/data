package defpackage;

import defpackage.wm0;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z33 {
    public static String a(String str) {
        return str != null ? str.toLowerCase(Locale.ROOT) : "";
    }

    public static String b(String str) {
        return a(str).trim();
    }

    public static String c(String str) {
        return wb.c(str, wm0.a.EnumC0128a.xml);
    }
}
