package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class r70 {
    public byte[] a;
    public int b;

    public r70(byte[] bArr, int i) {
        this.a = qa.b(bArr);
        this.b = i;
    }

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

    public int hashCode() {
        return qa.g(this.a) ^ this.b;
    }
}
