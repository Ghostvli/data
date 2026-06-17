package defpackage;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wg3 extends yh1 {
    public final String b;
    public final byte[] c;

    public wg3(String str, byte[] bArr) {
        super("PRIV");
        this.b = str;
        this.c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && wg3.class == obj.getClass()) {
            wg3 wg3Var = (wg3) obj;
            if (Objects.equals(this.b, wg3Var.b) && Arrays.equals(this.c, wg3Var.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.c);
    }

    @Override // defpackage.yh1
    public String toString() {
        return this.a + ": owner=" + this.b;
    }
}
