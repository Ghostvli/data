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

    public w62(String str, byte[] bArr, int i, int i2) {
        f(str, bArr, i2);
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = i2;
    }

    public static String e(List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("track types = ");
        wn1.g(',').c(sb, list);
        return sb.toString();
    }

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

    public List d() {
        gg3.w(this.a.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte b = this.b[1];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b; i++) {
            arrayList.add(Integer.valueOf(this.b[i + 2]));
        }
        return arrayList;
    }

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

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            int r0 = r3.d
            if (r0 == 0) goto L57
            r1 = 1
            if (r0 == r1) goto L50
            r1 = 23
            if (r0 == r1) goto L41
            r1 = 67
            if (r0 == r1) goto L36
            r1 = 75
            if (r0 == r1) goto L28
            r1 = 78
            if (r0 == r1) goto L18
            goto L6a
        L18:
            r73 r0 = new r73
            byte[] r1 = r3.b
            r0.<init>(r1)
            long r0 = r0.X()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L70
        L28:
            byte[] r0 = r3.b
            r1 = 0
            r0 = r0[r1]
            int r0 = defpackage.v62.a(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L70
        L36:
            byte[] r0 = r3.b
            int r0 = defpackage.ll1.h(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L70
        L41:
            byte[] r0 = r3.b
            int r0 = defpackage.ll1.h(r0)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L70
        L50:
            byte[] r0 = r3.b
            java.lang.String r0 = defpackage.fy4.N(r0)
            goto L70
        L57:
            java.lang.String r0 = r3.a
            java.lang.String r1 = "auxiliary.tracks.map"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6a
            java.util.List r0 = r3.d()
            java.lang.String r0 = e(r0)
            goto L70
        L6a:
            byte[] r0 = r3.b
            java.lang.String r0 = defpackage.fy4.N1(r0)
        L70:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "mdta: key="
            r1.<init>(r2)
            java.lang.String r3 = r3.a
            r1.append(r3)
            java.lang.String r3 = ", value="
            r1.append(r3)
            r1.append(r0)
            java.lang.String r3 = r1.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w62.toString():java.lang.String");
    }
}
