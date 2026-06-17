package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class l80 {
    public int a;
    public byte[] b;
    public int c;

    public l80(byte[] bArr, int i, int i2) {
        this.b = qa.b(bArr);
        this.c = i;
        this.a = i2;
    }

    public int a() {
        return this.c;
    }

    public byte[] b() {
        return qa.b(this.b);
    }

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

    public int hashCode() {
        return qa.g(this.b) ^ this.c;
    }

    public l80(byte[] bArr, int i) {
        this(bArr, i, -1);
    }
}
