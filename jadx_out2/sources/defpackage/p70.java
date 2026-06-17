package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class p70 extends o70 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p70(byte[] bArr) {
        super(bArr);
        if (d(bArr, 0, bArr.length)) {
            jl.a("attempt to create weak DESede key");
            throw null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean d(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (o70.c(bArr, i)) {
                return true;
            }
            i += 8;
        }
        return false;
    }
}
