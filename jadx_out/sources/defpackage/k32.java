package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class k32 extends g91 {
    public int e;
    public int f;
    public int g;
    public int h;
    public int[] i;
    public int j;

    public k32(k32 k32Var) {
        super(k32Var.a);
        this.i = new int[16];
        n50.a(wy4.a(this, 64, this.a));
        n(k32Var);
    }

    @Override // defpackage.rr2
    public rr2 a() {
        return new k32(this);
    }

    @Override // defpackage.sl0
    public String b() {
        return "MD4";
    }

    @Override // defpackage.rr2
    public void c(rr2 rr2Var) {
        n((k32) rr2Var);
    }

    @Override // defpackage.sl0
    public int doFinal(byte[] bArr, int i) {
        g();
        b73.f(this.e, bArr, i);
        b73.f(this.f, bArr, i + 4);
        b73.f(this.g, bArr, i + 8);
        b73.f(this.h, bArr, i + 12);
        reset();
        return 16;
    }

    @Override // defpackage.sl0
    public int e() {
        return 16;
    }

    @Override // defpackage.g91
    public void h() {
        int i = this.e;
        int i2 = this.f;
        int i3 = this.g;
        int i4 = this.h;
        int iO = o(i + k(i2, i3, i4) + this.i[0], 3);
        int iO2 = o(i4 + k(iO, i2, i3) + this.i[1], 7);
        int iO3 = o(i3 + k(iO2, iO, i2) + this.i[2], 11);
        int iO4 = o(i2 + k(iO3, iO2, iO) + this.i[3], 19);
        int iO5 = o(iO + k(iO4, iO3, iO2) + this.i[4], 3);
        int iO6 = o(iO2 + k(iO5, iO4, iO3) + this.i[5], 7);
        int iO7 = o(iO3 + k(iO6, iO5, iO4) + this.i[6], 11);
        int iO8 = o(iO4 + k(iO7, iO6, iO5) + this.i[7], 19);
        int iO9 = o(iO5 + k(iO8, iO7, iO6) + this.i[8], 3);
        int iO10 = o(iO6 + k(iO9, iO8, iO7) + this.i[9], 7);
        int iO11 = o(iO7 + k(iO10, iO9, iO8) + this.i[10], 11);
        int iO12 = o(iO8 + k(iO11, iO10, iO9) + this.i[11], 19);
        int iO13 = o(iO9 + k(iO12, iO11, iO10) + this.i[12], 3);
        int iO14 = o(iO10 + k(iO13, iO12, iO11) + this.i[13], 7);
        int iO15 = o(iO11 + k(iO14, iO13, iO12) + this.i[14], 11);
        int iO16 = o(iO12 + k(iO15, iO14, iO13) + this.i[15], 19);
        int iO17 = o(iO13 + l(iO16, iO15, iO14) + this.i[0] + 1518500249, 3);
        int iO18 = o(iO14 + l(iO17, iO16, iO15) + this.i[4] + 1518500249, 5);
        int iO19 = o(iO15 + l(iO18, iO17, iO16) + this.i[8] + 1518500249, 9);
        int iO20 = o(iO16 + l(iO19, iO18, iO17) + this.i[12] + 1518500249, 13);
        int iO21 = o(iO17 + l(iO20, iO19, iO18) + this.i[1] + 1518500249, 3);
        int iO22 = o(iO18 + l(iO21, iO20, iO19) + this.i[5] + 1518500249, 5);
        int iO23 = o(iO19 + l(iO22, iO21, iO20) + this.i[9] + 1518500249, 9);
        int iO24 = o(iO20 + l(iO23, iO22, iO21) + this.i[13] + 1518500249, 13);
        int iO25 = o(iO21 + l(iO24, iO23, iO22) + this.i[2] + 1518500249, 3);
        int iO26 = o(iO22 + l(iO25, iO24, iO23) + this.i[6] + 1518500249, 5);
        int iO27 = o(iO23 + l(iO26, iO25, iO24) + this.i[10] + 1518500249, 9);
        int iO28 = o(iO24 + l(iO27, iO26, iO25) + this.i[14] + 1518500249, 13);
        int iO29 = o(iO25 + l(iO28, iO27, iO26) + this.i[3] + 1518500249, 3);
        int iO30 = o(iO26 + l(iO29, iO28, iO27) + this.i[7] + 1518500249, 5);
        int iO31 = o(iO27 + l(iO30, iO29, iO28) + this.i[11] + 1518500249, 9);
        int iO32 = o(iO28 + l(iO31, iO30, iO29) + this.i[15] + 1518500249, 13);
        int iO33 = o(iO29 + m(iO32, iO31, iO30) + this.i[0] + 1859775393, 3);
        int iO34 = o(iO30 + m(iO33, iO32, iO31) + this.i[8] + 1859775393, 9);
        int iO35 = o(iO31 + m(iO34, iO33, iO32) + this.i[4] + 1859775393, 11);
        int iO36 = o(iO32 + m(iO35, iO34, iO33) + this.i[12] + 1859775393, 15);
        int iO37 = o(iO33 + m(iO36, iO35, iO34) + this.i[2] + 1859775393, 3);
        int iO38 = o(iO34 + m(iO37, iO36, iO35) + this.i[10] + 1859775393, 9);
        int iO39 = o(iO35 + m(iO38, iO37, iO36) + this.i[6] + 1859775393, 11);
        int iO40 = o(iO36 + m(iO39, iO38, iO37) + this.i[14] + 1859775393, 15);
        int iO41 = o(iO37 + m(iO40, iO39, iO38) + this.i[1] + 1859775393, 3);
        int iO42 = o(iO38 + m(iO41, iO40, iO39) + this.i[9] + 1859775393, 9);
        int iO43 = o(iO39 + m(iO42, iO41, iO40) + this.i[5] + 1859775393, 11);
        int iO44 = o(iO40 + m(iO43, iO42, iO41) + this.i[13] + 1859775393, 15);
        int iO45 = o(iO41 + m(iO44, iO43, iO42) + this.i[3] + 1859775393, 3);
        int iO46 = o(iO42 + m(iO45, iO44, iO43) + this.i[11] + 1859775393, 9);
        int iO47 = o(iO43 + m(iO46, iO45, iO44) + this.i[7] + 1859775393, 11);
        int iO48 = o(iO44 + m(iO47, iO46, iO45) + this.i[15] + 1859775393, 15);
        this.e += iO45;
        this.f += iO48;
        this.g += iO47;
        this.h += iO46;
        this.j = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.i;
            if (i5 == iArr.length) {
                return;
            }
            iArr[i5] = 0;
            i5++;
        }
    }

    @Override // defpackage.g91
    public void i(long j) {
        if (this.j > 14) {
            h();
        }
        int[] iArr = this.i;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // defpackage.g91
    public void j(byte[] bArr, int i) {
        int[] iArr = this.i;
        int i2 = this.j;
        this.j = i2 + 1;
        iArr[i2] = b73.g(bArr, i);
        if (this.j == 16) {
            h();
        }
    }

    public final int k(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    public final int l(int i, int i2, int i3) {
        return ((i2 | i3) & i) | (i2 & i3);
    }

    public final int m(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    public final void n(k32 k32Var) {
        super.f(k32Var);
        this.e = k32Var.e;
        this.f = k32Var.f;
        this.g = k32Var.g;
        this.h = k32Var.h;
        int[] iArr = k32Var.i;
        System.arraycopy(iArr, 0, this.i, 0, iArr.length);
        this.j = k32Var.j;
    }

    public final int o(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    @Override // defpackage.g91, defpackage.sl0
    public void reset() {
        super.reset();
        this.e = 1732584193;
        this.f = -271733879;
        this.g = -1732584194;
        this.h = 271733878;
        this.j = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.i;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public k32(k50 k50Var) {
        super(k50Var);
        this.i = new int[16];
        n50.a(wy4.a(this, 64, k50Var));
        reset();
    }

    public k32() {
        this(k50.ANY);
    }
}
