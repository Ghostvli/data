package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public class gw3 extends g91 implements uy0, rr2 {
    public static final int[] o = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int[] m;
    public int n;

    public gw3(k50 k50Var) {
        super(k50Var);
        this.m = new int[64];
        n50.a(r());
        reset();
    }

    public static int k(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    public static int l(int i, int i2, int i3) {
        return ((i ^ i2) & i3) | (i & i2);
    }

    public static int m(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    public static int n(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    public static int o(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    public static int p(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    @Override // defpackage.rr2
    public rr2 a() {
        return new gw3(this);
    }

    @Override // defpackage.sl0
    public String b() {
        return "SHA-256";
    }

    @Override // defpackage.rr2
    public void c(rr2 rr2Var) {
        q((gw3) rr2Var);
    }

    @Override // defpackage.sl0
    public int doFinal(byte[] bArr, int i) {
        g();
        b73.d(this.e, bArr, i);
        b73.d(this.f, bArr, i + 4);
        b73.d(this.g, bArr, i + 8);
        b73.d(this.h, bArr, i + 12);
        b73.d(this.i, bArr, i + 16);
        b73.d(this.j, bArr, i + 20);
        b73.d(this.k, bArr, i + 24);
        b73.d(this.l, bArr, i + 28);
        reset();
        return 32;
    }

    @Override // defpackage.sl0
    public int e() {
        return 32;
    }

    @Override // defpackage.g91
    public void h() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.m;
            int iP = p(iArr[i - 2]);
            int[] iArr2 = this.m;
            iArr[i] = iP + iArr2[i - 7] + o(iArr2[i - 15]) + this.m[i - 16];
        }
        int iM = this.e;
        int iM2 = this.f;
        int iM3 = this.g;
        int iM4 = this.h;
        int i2 = this.i;
        int i3 = this.j;
        int i4 = this.k;
        int i5 = this.l;
        int i6 = 0;
        for (int i7 = 0; i7 < 8; i7++) {
            int iN = n(i2) + k(i2, i3, i4);
            int[] iArr3 = o;
            int i8 = i5 + iN + iArr3[i6] + this.m[i6];
            int i9 = iM4 + i8;
            int iM5 = i8 + m(iM) + l(iM, iM2, iM3);
            int i10 = i6 + 1;
            int iN2 = i4 + n(i9) + k(i9, i2, i3) + iArr3[i10] + this.m[i10];
            int i11 = iM3 + iN2;
            int iM6 = iN2 + m(iM5) + l(iM5, iM, iM2);
            int i12 = i6 + 2;
            int iN3 = i3 + n(i11) + k(i11, i9, i2) + iArr3[i12] + this.m[i12];
            int i13 = iM2 + iN3;
            int iM7 = iN3 + m(iM6) + l(iM6, iM5, iM);
            int i14 = i6 + 3;
            int iN4 = i2 + n(i13) + k(i13, i11, i9) + iArr3[i14] + this.m[i14];
            int i15 = iM + iN4;
            int iM8 = iN4 + m(iM7) + l(iM7, iM6, iM5);
            int i16 = i6 + 4;
            int iN5 = i9 + n(i15) + k(i15, i13, i11) + iArr3[i16] + this.m[i16];
            i5 = iM5 + iN5;
            iM4 = iN5 + m(iM8) + l(iM8, iM7, iM6);
            int i17 = i6 + 5;
            int iN6 = i11 + n(i5) + k(i5, i15, i13) + iArr3[i17] + this.m[i17];
            i4 = iM6 + iN6;
            iM3 = iN6 + m(iM4) + l(iM4, iM8, iM7);
            int i18 = i6 + 6;
            int iN7 = i13 + n(i4) + k(i4, i5, i15) + iArr3[i18] + this.m[i18];
            i3 = iM7 + iN7;
            iM2 = iN7 + m(iM3) + l(iM3, iM4, iM8);
            int i19 = i6 + 7;
            int iN8 = i15 + n(i3) + k(i3, i4, i5) + iArr3[i19] + this.m[i19];
            i2 = iM8 + iN8;
            iM = iN8 + m(iM2) + l(iM2, iM3, iM4);
            i6 += 8;
        }
        this.e += iM;
        this.f += iM2;
        this.g += iM3;
        this.h += iM4;
        this.i += i2;
        this.j += i3;
        this.k += i4;
        this.l += i5;
        this.n = 0;
        for (int i20 = 0; i20 < 16; i20++) {
            this.m[i20] = 0;
        }
    }

    @Override // defpackage.g91
    public void i(long j) {
        if (this.n > 14) {
            h();
        }
        int[] iArr = this.m;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // defpackage.g91
    public void j(byte[] bArr, int i) {
        this.m[this.n] = b73.a(bArr, i);
        int i2 = this.n + 1;
        this.n = i2;
        if (i2 == 16) {
            h();
        }
    }

    public final void q(gw3 gw3Var) {
        super.f(gw3Var);
        this.e = gw3Var.e;
        this.f = gw3Var.f;
        this.g = gw3Var.g;
        this.h = gw3Var.h;
        this.i = gw3Var.i;
        this.j = gw3Var.j;
        this.k = gw3Var.k;
        this.l = gw3Var.l;
        int[] iArr = gw3Var.m;
        System.arraycopy(iArr, 0, this.m, 0, iArr.length);
        this.n = gw3Var.n;
    }

    public j50 r() {
        return wy4.a(this, Buffer.DEFAULT_SIZE, this.a);
    }

    @Override // defpackage.g91, defpackage.sl0
    public void reset() {
        super.reset();
        this.e = 1779033703;
        this.f = -1150833019;
        this.g = 1013904242;
        this.h = -1521486534;
        this.i = 1359893119;
        this.j = -1694144372;
        this.k = 528734635;
        this.l = 1541459225;
        this.n = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.m;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public gw3() {
        this(k50.ANY);
    }

    public gw3(gw3 gw3Var) {
        super(gw3Var);
        this.m = new int[64];
        q(gw3Var);
    }
}
