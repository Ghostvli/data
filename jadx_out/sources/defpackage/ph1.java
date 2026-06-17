package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class ph1 implements uk {
    @Override // defpackage.uk
    public int a(byte[] bArr, int i) {
        int length = bArr.length - i;
        bArr[i] = -128;
        while (true) {
            i++;
            if (i >= bArr.length) {
                return length;
            }
            bArr[i] = 0;
        }
    }
}
