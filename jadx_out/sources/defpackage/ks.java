package defpackage;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ks extends yh1 {
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String[] e;
    public final yh1[] f;

    public ks(String str, boolean z, boolean z2, String[] strArr, yh1[] yh1VarArr) {
        super("CTOC");
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = strArr;
        this.f = yh1VarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ks.class == obj.getClass()) {
            ks ksVar = (ks) obj;
            if (this.c == ksVar.c && this.d == ksVar.d && Objects.equals(this.b, ksVar.b) && Arrays.equals(this.e, ksVar.e) && Arrays.equals(this.f, ksVar.f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (((527 + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31;
        String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }
}
