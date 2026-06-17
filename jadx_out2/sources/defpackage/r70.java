package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class r70 {
    public byte[] a;
    public int b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r70(byte[] bArr, int i) {
        this.a = qa.b(bArr);
        this.b = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof r70)) {
            return false;
        }
        r70 r70Var = (r70) obj;
        if (r70Var.b != this.b) {
            return false;
        }
        return qa.a(this.a, r70Var.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return qa.g(this.a) ^ this.b;
    }
}
