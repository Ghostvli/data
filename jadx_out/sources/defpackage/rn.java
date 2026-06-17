package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public class rn implements y32 {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public int e;
    public tk f;
    public int g;
    public byte[] h;
    public byte[] i;

    public rn(tk tkVar, int i) {
        if (i % 8 != 0) {
            jl.a("MAC size must be multiple of 8");
            throw null;
        }
        if (i > tkVar.g() * 8) {
            qn.a("MAC size must be less or equal to ", tkVar.g() * 8);
            throw null;
        }
        this.f = ln.j(tkVar);
        this.g = i / 8;
        this.a = d(tkVar.g());
        this.c = new byte[tkVar.g()];
        this.d = new byte[tkVar.g()];
        this.b = new byte[tkVar.g()];
        this.e = 0;
    }

    public static byte[] d(int i) {
        int i2 = i * 8;
        int i3 = Token.VAR;
        switch (i2) {
            case 64:
            case 320:
                i3 = 27;
                break;
            case 128:
            case 192:
                break;
            case 160:
                i3 = 45;
                break;
            case 224:
                i3 = 777;
                break;
            case Buffer.DEFAULT_SIZE /* 256 */:
                i3 = 1061;
                break;
            case 384:
                i3 = 4109;
                break;
            case 448:
                i3 = 2129;
                break;
            case 512:
                i3 = 293;
                break;
            case 768:
                i3 = 655377;
                break;
            case 1024:
                i3 = 524355;
                break;
            case 2048:
                i3 = 548865;
                break;
            default:
                b.a("Unknown block size for CMAC: ", i2);
                return null;
        }
        return b73.e(i3);
    }

    public static int e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            int i2 = bArr[length] & 255;
            bArr2[length] = (byte) (i | (i2 << 1));
            i = (i2 >>> 7) & 1;
        }
    }

    @Override // defpackage.y32
    public int a() {
        return this.g;
    }

    @Override // defpackage.y32
    public void b(yt ytVar) {
        f(ytVar);
        this.f.a(true, ytVar);
        byte[] bArr = this.b;
        byte[] bArr2 = new byte[bArr.length];
        this.f.f(bArr, 0, bArr2, 0);
        byte[] bArrC = c(bArr2);
        this.h = bArrC;
        this.i = c(bArrC);
        reset();
    }

    public final byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = (-e(bArr, bArr2)) & 255;
        int length = bArr.length - 3;
        byte b = bArr2[length];
        byte[] bArr3 = this.a;
        bArr2[length] = (byte) (b ^ (bArr3[1] & i));
        int length2 = bArr.length - 2;
        bArr2[length2] = (byte) ((bArr3[2] & i) ^ bArr2[length2]);
        int length3 = bArr.length - 1;
        bArr2[length3] = (byte) ((bArr3[3] & i) ^ bArr2[length3]);
        return bArr2;
    }

    @Override // defpackage.y32
    public int doFinal(byte[] bArr, int i) {
        byte[] bArr2;
        if (this.e == this.f.g()) {
            bArr2 = this.h;
        } else {
            new ph1().a(this.d, this.e);
            bArr2 = this.i;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr3 = this.c;
            if (i2 >= bArr3.length) {
                this.f.f(this.d, 0, bArr3, 0);
                System.arraycopy(this.c, 0, bArr, i, this.g);
                reset();
                return this.g;
            }
            byte[] bArr4 = this.d;
            bArr4[i2] = (byte) (bArr4[i2] ^ bArr2[i2]);
            i2++;
        }
    }

    public void f(yt ytVar) {
        if (ytVar == null || (ytVar instanceof yq1)) {
            return;
        }
        jl.a("CMac mode only permits key to be set.");
    }

    @Override // defpackage.y32
    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.d;
            if (i >= bArr.length) {
                this.e = 0;
                this.f.reset();
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
        int iG = this.f.g();
        int i3 = this.e;
        int i4 = iG - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.d, i3, i4);
            this.f.f(this.d, 0, this.c, 0);
            this.e = 0;
            i2 -= i4;
            i += i4;
            while (i2 > iG) {
                this.f.f(bArr, i, this.c, 0);
                i2 -= iG;
                i += iG;
            }
        }
        System.arraycopy(bArr, i, this.d, this.e, i2);
        this.e += i2;
    }

    @Override // defpackage.y32
    public void update(byte b) {
        int i = this.e;
        byte[] bArr = this.d;
        if (i == bArr.length) {
            this.f.f(bArr, 0, this.c, 0);
            this.e = 0;
        }
        byte[] bArr2 = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        bArr2[i2] = b;
    }

    public rn(tk tkVar) {
        this(tkVar, tkVar.g() * 8);
    }
}
