package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class on implements e {
    public tk a;
    public int b;
    public boolean c;
    public byte[] d;
    public byte[] e;
    public int f;
    public yt g;
    public byte[] h;
    public a i = new a();
    public a j = new a();

    public static class a extends ByteArrayOutputStream {
        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public on(tk tkVar) {
        this.a = tkVar;
        int iG = tkVar.g();
        this.b = iG;
        this.h = new byte[iG];
        if (iG == 16) {
            return;
        }
        jl.a("cipher required with a block size of 16.");
        throw null;
    }

    @Override // defpackage.f
    public void a(boolean z, yt ytVar) {
        String strConcat;
        yt ytVarB;
        this.c = z;
        if (ytVar instanceof g) {
            g gVar = (g) ytVar;
            this.d = gVar.d();
            this.e = gVar.a();
            this.f = h(z, gVar.c());
            ytVarB = gVar.b();
        } else if (!(ytVar instanceof l73)) {
            strConcat = "invalid parameters passed to CCM: ".concat(ytVar.getClass().getName());
            jl.a(strConcat);
        } else {
            l73 l73Var = (l73) ytVar;
            this.d = l73Var.a();
            this.e = null;
            this.f = h(z, 64);
            ytVarB = l73Var.b();
        }
        if (ytVarB != null) {
            this.g = ytVarB;
        }
        byte[] bArr = this.d;
        if (bArr != null && bArr.length >= 7 && bArr.length <= 13) {
            reset();
        } else {
            strConcat = "nonce must have length from 7 to 13 octets";
            jl.a(strConcat);
        }
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2) {
        mn mnVar = new mn(this.a, this.f * 8);
        mnVar.b(this.g);
        byte[] bArr3 = new byte[16];
        if (i()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i3 = 2;
        byte bA = (byte) (bArr3[0] | ((((mnVar.a() - 2) / 2) & 7) << 3));
        bArr3[0] = bA;
        byte[] bArr4 = this.d;
        bArr3[0] = (byte) (bA | ((14 - bArr4.length) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i4 = i2;
        int i5 = 1;
        while (i4 > 0) {
            bArr3[16 - i5] = (byte) (i4 & 255);
            i4 >>>= 8;
            i5++;
        }
        mnVar.update(bArr3, 0, 16);
        if (i()) {
            int iG = g();
            if (iG < 65280) {
                mnVar.update((byte) (iG >> 8));
                mnVar.update((byte) iG);
            } else {
                mnVar.update((byte) -1);
                mnVar.update((byte) -2);
                mnVar.update((byte) (iG >> 24));
                mnVar.update((byte) (iG >> 16));
                mnVar.update((byte) (iG >> 8));
                mnVar.update((byte) iG);
                i3 = 6;
            }
            byte[] bArr5 = this.e;
            if (bArr5 != null) {
                mnVar.update(bArr5, 0, bArr5.length);
            }
            if (this.i.size() > 0) {
                mnVar.update(this.i.a(), 0, this.i.size());
            }
            int i6 = (i3 + iG) % 16;
            if (i6 != 0) {
                while (i6 != 16) {
                    mnVar.update((byte) 0);
                    i6++;
                }
            }
        }
        mnVar.update(bArr, i, i2);
        return mnVar.doFinal(bArr2, 0);
    }

    @Override // defpackage.f
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        if (bArr.length < i + i2) {
            throw new v90("Input buffer too short");
        }
        this.j.write(bArr, i, i2);
        return 0;
    }

    @Override // defpackage.f
    public int d(int i) {
        return 0;
    }

    @Override // defpackage.f
    public int doFinal(byte[] bArr, int i) throws nl1 {
        int iJ = j(this.j.a(), 0, this.j.size(), bArr, i);
        reset();
        return iJ;
    }

    @Override // defpackage.f
    public int e(int i) {
        int size = i + this.j.size();
        boolean z = this.c;
        int i2 = this.f;
        if (z) {
            return size + i2;
        }
        if (size < i2) {
            return 0;
        }
        return size - i2;
    }

    @Override // defpackage.f
    public void f(byte[] bArr, int i, int i2) throws IOException {
        this.i.write(bArr, i, i2);
    }

    public final int g() {
        int size = this.i.size();
        byte[] bArr = this.e;
        return size + (bArr == null ? 0 : bArr.length);
    }

    public final int h(boolean z, int i) {
        if (!z || (i >= 32 && i <= 128 && (i & 15) == 0)) {
            return i >>> 3;
        }
        jl.a("tag length in octets must be one of {4,6,8,10,12,14,16}");
        return 0;
    }

    public final boolean i() {
        return g() > 0;
    }

    public int j(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws nl1 {
        String str;
        int i4;
        if (this.g != null) {
            byte[] bArr3 = this.d;
            int length = bArr3.length;
            int i5 = 15 - length;
            if (i5 < 4) {
                str = i2 - (!this.c ? 16 : 0) >= (1 << (i5 * 8)) ? "CCM packet too large for choice of q" : "CCM cipher unitialized.";
            }
            byte[] bArr4 = new byte[this.b];
            bArr4[0] = (byte) ((14 - length) & 7);
            System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
            zn znVarJ = iw3.j(this.a);
            znVarJ.a(this.c, new l73(this.g, bArr4));
            boolean z = this.c;
            int i6 = this.f;
            if (!z) {
                if (i2 < i6) {
                    throw new nl1("data too short");
                }
                int i7 = i2 - i6;
                if (bArr2.length < i7 + i3) {
                    throw new z63("Output buffer too short.");
                }
                int i8 = i + i7;
                System.arraycopy(bArr, i8, this.h, 0, i6);
                byte[] bArr5 = this.h;
                znVarJ.f(bArr5, 0, bArr5, 0);
                int i9 = this.f;
                while (true) {
                    byte[] bArr6 = this.h;
                    if (i9 == bArr6.length) {
                        break;
                    }
                    bArr6[i9] = 0;
                    i9++;
                }
                int i10 = i;
                int i11 = i3;
                while (true) {
                    i4 = this.b;
                    if (i10 >= i8 - i4) {
                        break;
                    }
                    znVarJ.f(bArr, i10, bArr2, i11);
                    int i12 = this.b;
                    i11 += i12;
                    i10 += i12;
                }
                byte[] bArr7 = new byte[i4];
                int i13 = i7 - (i10 - i);
                System.arraycopy(bArr, i10, bArr7, 0, i13);
                znVarJ.f(bArr7, 0, bArr7, 0);
                System.arraycopy(bArr7, 0, bArr2, i11, i13);
                byte[] bArr8 = new byte[this.b];
                b(bArr2, i3, i7, bArr8);
                if (qa.c(this.h, bArr8)) {
                    return i7;
                }
                throw new nl1("mac check in CCM failed");
            }
            int i14 = i6 + i2;
            if (bArr2.length < i14 + i3) {
                throw new z63("Output buffer too short.");
            }
            b(bArr, i, i2, this.h);
            byte[] bArr9 = new byte[this.b];
            znVarJ.f(this.h, 0, bArr9, 0);
            int i15 = i;
            int i16 = i3;
            while (true) {
                int i17 = i + i2;
                int i18 = this.b;
                if (i15 >= i17 - i18) {
                    byte[] bArr10 = new byte[i18];
                    int i19 = i17 - i15;
                    System.arraycopy(bArr, i15, bArr10, 0, i19);
                    znVarJ.f(bArr10, 0, bArr10, 0);
                    System.arraycopy(bArr10, 0, bArr2, i16, i19);
                    System.arraycopy(bArr9, 0, bArr2, i3 + i2, this.f);
                    return i14;
                }
                znVarJ.f(bArr, i15, bArr2, i16);
                int i20 = this.b;
                i16 += i20;
                i15 += i20;
            }
        }
        e04.a(str);
        return 0;
    }

    @Override // defpackage.f
    public void reset() {
        this.a.reset();
        this.i.reset();
        this.j.reset();
    }
}
