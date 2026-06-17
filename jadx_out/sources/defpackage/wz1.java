package defpackage;

import android.content.LocusId;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wz1 {
    public final String a;
    public final LocusId b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static LocusId a(String str) {
            return new LocusId(str);
        }
    }

    public wz1(String str) {
        this.a = (String) hg3.j(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.b = a.a(str);
        } else {
            this.b = null;
        }
    }

    public String a() {
        return this.a;
    }

    public final String b() {
        return this.a.length() + "_chars";
    }

    public LocusId c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || wz1.class != obj.getClass()) {
            return false;
        }
        String str = this.a;
        String str2 = ((wz1) obj).a;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
