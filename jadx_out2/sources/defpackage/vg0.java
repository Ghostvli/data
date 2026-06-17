package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class vg0 implements wv2 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wv2
    public int d() {
        return g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wv2
    public int e(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int iD = d();
        int iF = 0;
        for (int i4 = 0; i4 != i2; i4++) {
            iF += f(bArr, i, bArr2, i3 + iF);
            i += iD;
        }
        return iF;
    }
}
