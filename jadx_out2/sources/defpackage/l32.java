package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class l32 extends g91 {
    public int e;
    public int f;
    public int g;
    public int h;
    public int[] i;
    public int j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l32(k50 k50Var) {
        super(k50Var);
        this.i = new int[16];
        n50.a(wy4.a(this, 64, k50Var));
        reset();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int k(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int l(int i, int i2, int i3) {
        return (i & i3) | ((~i3) & i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int m(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int p(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rr2
    public rr2 a() {
        return new l32(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sl0
    public String b() {
        return "MD5";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rr2
    public void c(rr2 rr2Var) {
        o((l32) rr2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sl0
    public int e() {
        return 16;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g91
    public void h() {
        int i = this.e;
        int i2 = this.f;
        int i3 = this.g;
        int i4 = this.h;
        int iP = p(((i + k(i2, i3, i4)) + this.i[0]) - 680876936, 7) + i2;
        int iP2 = p(((i4 + k(iP, i2, i3)) + this.i[1]) - 389564586, 12) + iP;
        int iP3 = p(i3 + k(iP2, iP, i2) + this.i[2] + 606105819, 17) + iP2;
        int iP4 = p(((i2 + k(iP3, iP2, iP)) + this.i[3]) - 1044525330, 22) + iP3;
        int iP5 = p(((iP + k(iP4, iP3, iP2)) + this.i[4]) - 176418897, 7) + iP4;
        int iP6 = p(iP2 + k(iP5, iP4, iP3) + this.i[5] + 1200080426, 12) + iP5;
        int iP7 = p(((iP3 + k(iP6, iP5, iP4)) + this.i[6]) - 1473231341, 17) + iP6;
        int iP8 = p(((iP4 + k(iP7, iP6, iP5)) + this.i[7]) - 45705983, 22) + iP7;
        int iP9 = p(iP5 + k(iP8, iP7, iP6) + this.i[8] + 1770035416, 7) + iP8;
        int iP10 = p(((iP6 + k(iP9, iP8, iP7)) + this.i[9]) - 1958414417, 12) + iP9;
        int iP11 = p(((iP7 + k(iP10, iP9, iP8)) + this.i[10]) - 42063, 17) + iP10;
        int iP12 = p(((iP8 + k(iP11, iP10, iP9)) + this.i[11]) - 1990404162, 22) + iP11;
        int iP13 = p(iP9 + k(iP12, iP11, iP10) + this.i[12] + 1804603682, 7) + iP12;
        int iP14 = p(((iP10 + k(iP13, iP12, iP11)) + this.i[13]) - 40341101, 12) + iP13;
        int iP15 = p(((iP11 + k(iP14, iP13, iP12)) + this.i[14]) - 1502002290, 17) + iP14;
        int iP16 = p(iP12 + k(iP15, iP14, iP13) + this.i[15] + 1236535329, 22) + iP15;
        int iP17 = p(((iP13 + l(iP16, iP15, iP14)) + this.i[1]) - 165796510, 5) + iP16;
        int iP18 = p(((iP14 + l(iP17, iP16, iP15)) + this.i[6]) - 1069501632, 9) + iP17;
        int iP19 = p(iP15 + l(iP18, iP17, iP16) + this.i[11] + 643717713, 14) + iP18;
        int iP20 = p(((iP16 + l(iP19, iP18, iP17)) + this.i[0]) - 373897302, 20) + iP19;
        int iP21 = p(((iP17 + l(iP20, iP19, iP18)) + this.i[5]) - 701558691, 5) + iP20;
        int iP22 = p(iP18 + l(iP21, iP20, iP19) + this.i[10] + 38016083, 9) + iP21;
        int iP23 = p(((iP19 + l(iP22, iP21, iP20)) + this.i[15]) - 660478335, 14) + iP22;
        int iP24 = p(((iP20 + l(iP23, iP22, iP21)) + this.i[4]) - 405537848, 20) + iP23;
        int iP25 = p(iP21 + l(iP24, iP23, iP22) + this.i[9] + 568446438, 5) + iP24;
        int iP26 = p(((iP22 + l(iP25, iP24, iP23)) + this.i[14]) - 1019803690, 9) + iP25;
        int iP27 = p(((iP23 + l(iP26, iP25, iP24)) + this.i[3]) - 187363961, 14) + iP26;
        int iP28 = p(iP24 + l(iP27, iP26, iP25) + this.i[8] + 1163531501, 20) + iP27;
        int iP29 = p(((iP25 + l(iP28, iP27, iP26)) + this.i[13]) - 1444681467, 5) + iP28;
        int iP30 = p(((iP26 + l(iP29, iP28, iP27)) + this.i[2]) - 51403784, 9) + iP29;
        int iP31 = p(iP27 + l(iP30, iP29, iP28) + this.i[7] + 1735328473, 14) + iP30;
        int iP32 = p(((iP28 + l(iP31, iP30, iP29)) + this.i[12]) - 1926607734, 20) + iP31;
        int iP33 = p(((iP29 + m(iP32, iP31, iP30)) + this.i[5]) - 378558, 4) + iP32;
        int iP34 = p(((iP30 + m(iP33, iP32, iP31)) + this.i[8]) - 2022574463, 11) + iP33;
        int iP35 = p(iP31 + m(iP34, iP33, iP32) + this.i[11] + 1839030562, 16) + iP34;
        int iP36 = p(((iP32 + m(iP35, iP34, iP33)) + this.i[14]) - 35309556, 23) + iP35;
        int iP37 = p(((iP33 + m(iP36, iP35, iP34)) + this.i[1]) - 1530992060, 4) + iP36;
        int iP38 = p(iP34 + m(iP37, iP36, iP35) + this.i[4] + 1272893353, 11) + iP37;
        int iP39 = p(((iP35 + m(iP38, iP37, iP36)) + this.i[7]) - 155497632, 16) + iP38;
        int iP40 = p(((iP36 + m(iP39, iP38, iP37)) + this.i[10]) - 1094730640, 23) + iP39;
        int iP41 = p(iP37 + m(iP40, iP39, iP38) + this.i[13] + 681279174, 4) + iP40;
        int iP42 = p(((iP38 + m(iP41, iP40, iP39)) + this.i[0]) - 358537222, 11) + iP41;
        int iP43 = p(((iP39 + m(iP42, iP41, iP40)) + this.i[3]) - 722521979, 16) + iP42;
        int iP44 = p(iP40 + m(iP43, iP42, iP41) + this.i[6] + 76029189, 23) + iP43;
        int iP45 = p(((iP41 + m(iP44, iP43, iP42)) + this.i[9]) - 640364487, 4) + iP44;
        int iP46 = p(((iP42 + m(iP45, iP44, iP43)) + this.i[12]) - 421815835, 11) + iP45;
        int iP47 = p(iP43 + m(iP46, iP45, iP44) + this.i[15] + 530742520, 16) + iP46;
        int iP48 = p(((iP44 + m(iP47, iP46, iP45)) + this.i[2]) - 995338651, 23) + iP47;
        int iP49 = p(((iP45 + n(iP48, iP47, iP46)) + this.i[0]) - 198630844, 6) + iP48;
        int iP50 = p(iP46 + n(iP49, iP48, iP47) + this.i[7] + 1126891415, 10) + iP49;
        int iP51 = p(((iP47 + n(iP50, iP49, iP48)) + this.i[14]) - 1416354905, 15) + iP50;
        int iP52 = p(((iP48 + n(iP51, iP50, iP49)) + this.i[5]) - 57434055, 21) + iP51;
        int iP53 = p(iP49 + n(iP52, iP51, iP50) + this.i[12] + 1700485571, 6) + iP52;
        int iP54 = p(((iP50 + n(iP53, iP52, iP51)) + this.i[3]) - 1894986606, 10) + iP53;
        int iP55 = p(((iP51 + n(iP54, iP53, iP52)) + this.i[10]) - 1051523, 15) + iP54;
        int iP56 = p(((iP52 + n(iP55, iP54, iP53)) + this.i[1]) - 2054922799, 21) + iP55;
        int iP57 = p(iP53 + n(iP56, iP55, iP54) + this.i[8] + 1873313359, 6) + iP56;
        int iP58 = p(((iP54 + n(iP57, iP56, iP55)) + this.i[15]) - 30611744, 10) + iP57;
        int iP59 = p(((iP55 + n(iP58, iP57, iP56)) + this.i[6]) - 1560198380, 15) + iP58;
        int iP60 = p(iP56 + n(iP59, iP58, iP57) + this.i[13] + 1309151649, 21) + iP59;
        int iP61 = p(((iP57 + n(iP60, iP59, iP58)) + this.i[4]) - 145523070, 6) + iP60;
        int iP62 = p(((iP58 + n(iP61, iP60, iP59)) + this.i[11]) - 1120210379, 10) + iP61;
        int iP63 = p(iP59 + n(iP62, iP61, iP60) + this.i[2] + 718787259, 15) + iP62;
        int iP64 = p(((iP60 + n(iP63, iP62, iP61)) + this.i[9]) - 343485551, 21) + iP63;
        this.e += iP61;
        this.f += iP64;
        this.g += iP63;
        this.h += iP62;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g91
    public void i(long j) {
        if (this.j > 14) {
            h();
        }
        int[] iArr = this.i;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int n(int i, int i2, int i3) {
        return ((~i3) | i) ^ i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(l32 l32Var) {
        super.f(l32Var);
        this.e = l32Var.e;
        this.f = l32Var.f;
        this.g = l32Var.g;
        this.h = l32Var.h;
        int[] iArr = l32Var.i;
        System.arraycopy(iArr, 0, this.i, 0, iArr.length);
        this.j = l32Var.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    public l32() {
        this(k50.ANY);
    }

    public l32(l32 l32Var) {
        super(l32Var);
        this.i = new int[16];
        o(l32Var);
    }
}
