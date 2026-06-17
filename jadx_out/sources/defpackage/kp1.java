package defpackage;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class kp1 implements nj0 {
    public static final BigInteger i = BigInteger.valueOf(2147483647L);
    public static final BigInteger j = BigInteger.valueOf(2);
    public final y32 a;
    public final int b;
    public byte[] c;
    public byte[] d;
    public int e;
    public byte[] f;
    public int g;
    public byte[] h;

    public kp1(y32 y32Var) {
        this.a = y32Var;
        int iA = y32Var.a();
        this.b = iA;
        this.h = new byte[iA];
    }

    @Override // defpackage.nj0
    public void a(oj0 oj0Var) {
        if (!(oj0Var instanceof lp1)) {
            jl.a("Wrong type of arguments given");
            return;
        }
        lp1 lp1Var = (lp1) oj0Var;
        this.a.b(new yq1(lp1Var.c()));
        this.c = lp1Var.a();
        this.d = lp1Var.b();
        int iD = lp1Var.d();
        this.f = new byte[iD / 8];
        BigInteger bigIntegerMultiply = j.pow(iD).multiply(BigInteger.valueOf(this.b));
        this.e = bigIntegerMultiply.compareTo(i) == 1 ? Integer.MAX_VALUE : bigIntegerMultiply.intValue();
        this.g = 0;
    }

    public final void b() {
        int i2 = (this.g / this.b) + 1;
        byte[] bArr = this.f;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length != 4) {
                        e04.a("Unsupported size of counter i");
                        return;
                    }
                    bArr[0] = (byte) (i2 >>> 24);
                }
                bArr[bArr.length - 3] = (byte) (i2 >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i2 >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i2;
        y32 y32Var = this.a;
        byte[] bArr2 = this.c;
        y32Var.update(bArr2, 0, bArr2.length);
        y32 y32Var2 = this.a;
        byte[] bArr3 = this.f;
        y32Var2.update(bArr3, 0, bArr3.length);
        y32 y32Var3 = this.a;
        byte[] bArr4 = this.d;
        y32Var3.update(bArr4, 0, bArr4.length);
        this.a.doFinal(this.h, 0);
    }

    @Override // defpackage.nj0
    public int generateBytes(byte[] bArr, int i2, int i3) {
        int i4 = this.g;
        int i5 = i4 + i3;
        if (i5 < 0 || i5 >= this.e) {
            throw new v90("Current KDFCTR may only be used for " + this.e + " bytes");
        }
        if (i4 % this.b == 0) {
            b();
        }
        int i6 = this.g;
        int i7 = this.b;
        int i8 = i6 % i7;
        int iMin = Math.min(i7 - (i6 % i7), i3);
        System.arraycopy(this.h, i8, bArr, i2, iMin);
        this.g += iMin;
        int i9 = i3 - iMin;
        while (true) {
            i2 += iMin;
            if (i9 <= 0) {
                return i3;
            }
            b();
            iMin = Math.min(this.b, i9);
            System.arraycopy(this.h, 0, bArr, i2, iMin);
            this.g += iMin;
            i9 -= iMin;
        }
    }
}
