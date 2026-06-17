package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class lp1 implements oj0 {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public int d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lp1(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (bArr == null) {
            jl.a("A KDF requires Ki (a seed) as input");
            throw null;
        }
        this.a = qa.b(bArr);
        if (bArr2 == null) {
            this.b = new byte[0];
        } else {
            this.b = qa.b(bArr2);
        }
        if (bArr3 == null) {
            this.c = new byte[0];
        } else {
            this.c = qa.b(bArr3);
        }
        if (i == 8 || i == 16 || i == 24 || i == 32) {
            this.d = i;
        } else {
            jl.a("Length of counter should be 8, 16, 24 or 32");
            throw null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] a() {
        return qa.b(this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] b() {
        return qa.b(this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] c() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int d() {
        return this.d;
    }

    public lp1(byte[] bArr, byte[] bArr2, int i) {
        this(bArr, null, bArr2, i);
    }
}
