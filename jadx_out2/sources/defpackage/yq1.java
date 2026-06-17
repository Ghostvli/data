package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class yq1 implements yt {
    public byte[] a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yq1(byte[] bArr, int i, int i2) {
        this(i2);
        System.arraycopy(bArr, i, this.a, 0, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] a() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int b() {
        return this.a.length;
    }

    public yq1(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public yq1(int i) {
        this.a = new byte[i];
    }
}
