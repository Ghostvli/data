package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class g implements yt {
    public byte[] a;
    public byte[] b;
    public yq1 c;
    public int d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g(yq1 yq1Var, int i, byte[] bArr, byte[] bArr2) {
        this.c = yq1Var;
        this.b = qa.b(bArr);
        this.d = i;
        this.a = qa.b(bArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] a() {
        return qa.b(this.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yq1 b() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] d() {
        return qa.b(this.b);
    }

    public g(yq1 yq1Var, int i, byte[] bArr) {
        this(yq1Var, i, bArr, null);
    }
}
