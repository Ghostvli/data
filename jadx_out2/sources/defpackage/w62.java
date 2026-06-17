package defpackage;

import defpackage.xs2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class w62 implements xs2.a {
    public final String a;
    public final byte[] b;
    public final int c;
    public final int d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public w62(String str, byte[] bArr, int i, int i2) {
        f(str, bArr, i2);
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String e(List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("track types = ");
        wn1.g(',').c(sb, list);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(String str, byte[] bArr, int i) {
        boolean z;
        byte b;
        str.getClass();
        switch (str) {
            case "com.android.capture.fps":
                if (i == 23 && bArr.length == 4) {
                    z = true;
                }
                gg3.d(z);
                break;
            case "auxiliary.tracks.interleaved":
                if (i == 75 && bArr.length == 1 && ((b = bArr[0]) == 0 || b == 1)) {
                    z = true;
                }
                gg3.d(z);
                break;
            case "auxiliary.tracks.length":
            case "auxiliary.tracks.offset":
                if (i == 78 && bArr.length == 8) {
                    z = true;
                }
                gg3.d(z);
                break;
            case "auxiliary.tracks.map":
                gg3.d(i == 0);
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List d() {
        gg3.w(this.a.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte b = this.b[1];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b; i++) {
            arrayList.add(Integer.valueOf(this.b[i + 2]));
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w62.class == obj.getClass()) {
            w62 w62Var = (w62) obj;
            if (this.a.equals(w62Var.a) && Arrays.equals(this.b, w62Var.b) && this.c == w62Var.c && this.d == w62Var.d) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String strE;
        int i = this.d;
        if (i != 0) {
            strE = i != 1 ? i != 23 ? i != 67 ? i != 75 ? i != 78 ? fy4.N1(this.b) : String.valueOf(new r73(this.b).X()) : String.valueOf(v62.a(this.b[0])) : String.valueOf(ll1.h(this.b)) : String.valueOf(Float.intBitsToFloat(ll1.h(this.b))) : fy4.N(this.b);
        } else if (this.a.equals("auxiliary.tracks.map")) {
            strE = e(d());
        }
        return "mdta: key=" + this.a + ", value=" + strE;
    }
}
