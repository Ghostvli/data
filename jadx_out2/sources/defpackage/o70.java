package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o70 extends yq1 {
    public static byte[] b = {1, 1, 1, 1, 1, 1, 1, 1, 31, 31, 31, 31, 14, 14, 14, 14, -32, -32, -32, -32, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, 31, -32, 31, -32, 14, -15, 14, -15, 1, -32, 1, -32, 1, -15, 1, -15, 31, -2, 31, -2, 14, -2, 14, -2, 1, 31, 1, 31, 1, 14, 1, 14, -32, -2, -32, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, -32, 31, -32, 31, -15, 14, -15, 14, -32, 1, -32, 1, -15, 1, -15, 1, -2, 31, -2, 31, -2, 14, -2, 14, 31, 1, 31, 1, 14, 1, 14, 1, -2, -32, -2, -32, -2, -15, -2, -15};

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o70(byte[] bArr) {
        super(bArr);
        if (c(bArr, 0)) {
            jl.a("attempt to create weak DES key");
            throw null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            jl.a("key material too short.");
            return false;
        }
        int i2 = 0;
        while (i2 < 16) {
            for (int i3 = 0; i3 < 8; i3++) {
                if (bArr[i3 + i] != b[(i2 * 8) + i3]) {
                    break;
                }
            }
            return true;
        }
        return false;
    }
}
