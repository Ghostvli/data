package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class l80 {
    public int a;
    public byte[] b;
    public int c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l80(byte[] bArr, int i, int i2) {
        this.b = qa.b(bArr);
        this.c = i;
        this.a = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int a() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] b() {
        return qa.b(this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof l80)) {
            return false;
        }
        l80 l80Var = (l80) obj;
        if (l80Var.c != this.c) {
            return false;
        }
        return qa.a(this.b, l80Var.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return qa.g(this.b) ^ this.c;
    }

    public l80(byte[] bArr, int i) {
        this(bArr, i, -1);
    }
}
