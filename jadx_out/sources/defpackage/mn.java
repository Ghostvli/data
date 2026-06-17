package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class mn implements y32 {
    public byte[] a;
    public byte[] b;
    public int c;
    public tk d;
    public uk e;
    public int f;

    public mn(tk tkVar, int i, uk ukVar) {
        if (i % 8 != 0) {
            jl.a("MAC size must be multiple of 8");
            throw null;
        }
        this.d = ln.j(tkVar);
        this.e = ukVar;
        this.f = i / 8;
        this.a = new byte[tkVar.g()];
        this.b = new byte[tkVar.g()];
        this.c = 0;
    }

    @Override // defpackage.y32
    public int a() {
        return this.f;
    }

    @Override // defpackage.y32
    public void b(yt ytVar) {
        reset();
        this.d.a(true, ytVar);
    }

    @Override // defpackage.y32
    public int doFinal(byte[] bArr, int i) {
        int iG = this.d.g();
        if (this.e == null) {
            while (true) {
                int i2 = this.c;
                if (i2 >= iG) {
                    break;
                }
                this.b[i2] = 0;
                this.c = i2 + 1;
            }
        } else {
            if (this.c == iG) {
                this.d.f(this.b, 0, this.a, 0);
                this.c = 0;
            }
            this.e.a(this.b, this.c);
        }
        this.d.f(this.b, 0, this.a, 0);
        System.arraycopy(this.a, 0, bArr, i, this.f);
        reset();
        return this.f;
    }

    @Override // defpackage.y32
    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i >= bArr.length) {
                this.c = 0;
                this.d.reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    @Override // defpackage.y32
    public void update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            jl.a("Can't have a negative input length!");
            return;
        }
        int iG = this.d.g();
        int i3 = this.c;
        int i4 = iG - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.b, i3, i4);
            this.d.f(this.b, 0, this.a, 0);
            this.c = 0;
            i2 -= i4;
            i += i4;
            while (i2 > iG) {
                this.d.f(bArr, i, this.a, 0);
                i2 -= iG;
                i += iG;
            }
        }
        System.arraycopy(bArr, i, this.b, this.c, i2);
        this.c += i2;
    }

    public mn(tk tkVar, int i) {
        this(tkVar, i, null);
    }

    @Override // defpackage.y32
    public void update(byte b) {
        int i = this.c;
        byte[] bArr = this.b;
        if (i == bArr.length) {
            this.d.f(bArr, 0, this.a, 0);
            this.c = 0;
        }
        byte[] bArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr2[i2] = b;
    }
}
