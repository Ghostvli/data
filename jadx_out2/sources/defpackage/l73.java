package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class l73 implements yt {
    public byte[] a;
    public yt b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l73(yt ytVar, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.a = bArr2;
        this.b = ytVar;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] a() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yt b() {
        return this.b;
    }

    public l73(yt ytVar, byte[] bArr) {
        this(ytVar, bArr, 0, bArr.length);
    }
}
