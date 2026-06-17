package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g91 implements uy0, rr2 {
    public final k50 a;
    public final byte[] b;
    public int c;
    public long d;

    public g91(g91 g91Var) {
        this.b = new byte[4];
        this.a = g91Var.a;
        f(g91Var);
    }

    @Override // defpackage.uy0
    public int d() {
        return 64;
    }

    public void f(g91 g91Var) {
        byte[] bArr = g91Var.b;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        this.c = g91Var.c;
        this.d = g91Var.d;
    }

    public void g() {
        long j = this.d << 3;
        byte b = -128;
        while (true) {
            update(b);
            if (this.c == 0) {
                i(j);
                h();
                return;
            }
            b = 0;
        }
    }

    public abstract void h();

    public abstract void i(long j);

    public abstract void j(byte[] bArr, int i);

    @Override // defpackage.sl0
    public void reset() {
        this.d = 0L;
        this.c = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i >= bArr.length) {
                return;
            }
            bArr[i] = 0;
            i++;
        }
    }

    @Override // defpackage.sl0
    public void update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int iMax = Math.max(0, i2);
        if (this.c != 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= iMax) {
                    i3 = i4;
                    break;
                }
                byte[] bArr2 = this.b;
                int i5 = this.c;
                int i6 = i5 + 1;
                this.c = i6;
                int i7 = i4 + 1;
                bArr2[i5] = bArr[i4 + i];
                if (i6 == 4) {
                    j(bArr2, 0);
                    this.c = 0;
                    i3 = i7;
                    break;
                }
                i4 = i7;
            }
        }
        int i8 = iMax - 3;
        while (i3 < i8) {
            j(bArr, i + i3);
            i3 += 4;
        }
        while (i3 < iMax) {
            byte[] bArr3 = this.b;
            int i9 = this.c;
            this.c = i9 + 1;
            bArr3[i9] = bArr[i3 + i];
            i3++;
        }
        this.d += (long) iMax;
    }

    public g91(k50 k50Var) {
        this.b = new byte[4];
        this.a = k50Var;
        this.c = 0;
    }

    @Override // defpackage.sl0
    public void update(byte b) {
        byte[] bArr = this.b;
        int i = this.c;
        int i2 = i + 1;
        this.c = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            j(bArr, 0);
            this.c = 0;
        }
        this.d++;
    }
}
