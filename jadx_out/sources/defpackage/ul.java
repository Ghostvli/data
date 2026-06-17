package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class ul {
    public byte[] a;
    public int b;
    public boolean c;
    public tk d;
    public wv2 e;
    public boolean f;
    public boolean g;

    public ul(tk tkVar) {
        this.d = tkVar;
        if (tkVar instanceof wv2) {
            wv2 wv2Var = (wv2) tkVar;
            this.e = wv2Var;
            this.a = new byte[wv2Var.d()];
        } else {
            this.e = null;
            this.a = new byte[tkVar.g()];
        }
        boolean z = false;
        this.b = 0;
        String strB = tkVar.b();
        int iIndexOf = strB.indexOf(47) + 1;
        boolean z2 = iIndexOf > 0 && strB.startsWith("PGP", iIndexOf);
        this.g = z2;
        if (z2 || (tkVar instanceof se4)) {
            this.f = true;
            return;
        }
        if (iIndexOf > 0 && strB.startsWith("OpenPGP", iIndexOf)) {
            z = true;
        }
        this.f = z;
    }

    public int a(byte[] bArr, int i) {
        try {
            int i2 = this.b;
            if (i + i2 > bArr.length) {
                throw new z63("output buffer too short for doFinal()");
            }
            int i3 = 0;
            if (i2 != 0) {
                if (!this.f) {
                    throw new v90("data not block size aligned");
                }
                tk tkVar = this.d;
                byte[] bArr2 = this.a;
                tkVar.f(bArr2, 0, bArr2, 0);
                int i4 = this.b;
                this.b = 0;
                System.arraycopy(this.a, 0, bArr, i, i4);
                i3 = i4;
            }
            f();
            return i3;
        } catch (Throwable th) {
            f();
            throw th;
        }
    }

    public int b() {
        return this.d.g();
    }

    public int c(int i) {
        int length;
        int length2;
        int i2 = i + this.b;
        if (this.g) {
            boolean z = this.c;
            byte[] bArr = this.a;
            if (z) {
                length2 = (i2 % bArr.length) - (this.d.g() + 2);
                return i2 - length2;
            }
            length = bArr.length;
        } else {
            length = this.a.length;
        }
        length2 = i2 % length;
        return i2 - length2;
    }

    public void d(boolean z, yt ytVar) {
        this.c = z;
        f();
        this.d.a(z, ytVar);
    }

    public int e(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int iF;
        if (i2 < 0) {
            jl.a("Can't have a negative input length!");
            return 0;
        }
        int iB = b();
        int iC = c(i2);
        if (iC > 0 && iC + i3 > bArr2.length) {
            throw new z63("output buffer too short");
        }
        byte[] bArr3 = this.a;
        int length = bArr3.length;
        int i4 = this.b;
        int i5 = length - i4;
        if (i2 > i5) {
            System.arraycopy(bArr, i, bArr3, i4, i5);
            iF = this.d.f(this.a, 0, bArr2, i3);
            this.b = 0;
            i2 -= i5;
            int i6 = i5 + i;
            wv2 wv2Var = this.e;
            if (wv2Var != null) {
                int iD = i2 / wv2Var.d();
                if (iD > 0) {
                    iF += this.e.e(bArr, i6, iD, bArr2, i3 + iF);
                    int iD2 = iD * this.e.d();
                    i2 -= iD2;
                    i6 += iD2;
                }
                i = i6;
            } else {
                i = i6;
                while (i2 > this.a.length) {
                    iF += this.d.f(bArr, i, bArr2, i3 + iF);
                    i2 -= iB;
                    i += iB;
                }
            }
        } else {
            iF = 0;
        }
        System.arraycopy(bArr, i, this.a, this.b, i2);
        int i7 = this.b + i2;
        this.b = i7;
        byte[] bArr4 = this.a;
        if (i7 != bArr4.length) {
            return iF;
        }
        int iF2 = iF + this.d.f(bArr4, 0, bArr2, i3 + iF);
        this.b = 0;
        return iF2;
    }

    public void f() {
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                this.b = 0;
                this.d.reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }
}
