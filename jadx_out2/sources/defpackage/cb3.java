package defpackage;

import defpackage.ph2;
import defpackage.xs2;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cb3 implements xs2.a {
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final byte[] h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cb3(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cb3 d(r73 r73Var) {
        int iZ = r73Var.z();
        String strU = nt2.u(r73Var.O(r73Var.z(), StandardCharsets.US_ASCII));
        String strN = r73Var.N(r73Var.z());
        int iZ2 = r73Var.z();
        int iZ3 = r73Var.z();
        int iZ4 = r73Var.z();
        int iZ5 = r73Var.z();
        int iZ6 = r73Var.z();
        byte[] bArr = new byte[iZ6];
        r73Var.u(bArr, 0, iZ6);
        return new cb3(iZ, strU, strN, iZ2, iZ3, iZ4, iZ5, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xs2.a
    public void b(ph2.b bVar) {
        bVar.M(this.h, this.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && cb3.class == obj.getClass()) {
            cb3 cb3Var = (cb3) obj;
            if (this.a == cb3Var.a && this.b.equals(cb3Var.b) && this.c.equals(cb3Var.c) && this.d == cb3Var.d && this.e == cb3Var.e && this.f == cb3Var.f && this.g == cb3Var.g && Arrays.equals(this.h, cb3Var.h)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return ((((((((((((((527 + this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + Arrays.hashCode(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "Picture: mimeType=" + this.b + ", description=" + this.c;
    }
}
