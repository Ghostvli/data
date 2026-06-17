package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vj {
    public final int a;
    public final CharSequence b;

    public vj(int i, CharSequence charSequence) {
        this.a = i;
        this.b = charSequence;
    }

    public static String a(CharSequence charSequence) {
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public int b() {
        return this.a;
    }

    public CharSequence c() {
        return this.b;
    }

    public final boolean d(CharSequence charSequence) {
        String strA = a(this.b);
        String strA2 = a(charSequence);
        if (strA == null && strA2 == null) {
            return true;
        }
        return strA != null && strA.equals(strA2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof vj) {
            vj vjVar = (vj) obj;
            if (this.a == vjVar.a && d(vjVar.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), a(this.b)});
    }
}
