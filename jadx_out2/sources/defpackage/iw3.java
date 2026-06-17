package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class iw3 extends re4 implements zn {
    public final tk b;
    public final int c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public int g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iw3(tk tkVar) {
        super(tkVar);
        this.b = tkVar;
        int iG = tkVar.g();
        this.c = iG;
        this.d = new byte[iG];
        this.e = new byte[iG];
        this.f = new byte[iG];
        this.g = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zn j(tk tkVar) {
        return new iw3(tkVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tk
    public void a(boolean z, yt ytVar) {
        if (!(ytVar instanceof l73)) {
            jl.a("CTR/SIC mode requires ParametersWithIV");
            return;
        }
        l73 l73Var = (l73) ytVar;
        byte[] bArrB = qa.b(l73Var.a());
        this.d = bArrB;
        int i = this.c;
        if (i < bArrB.length) {
            fp3.a("CTR/SIC mode requires IV no greater than: ", this.c, " bytes.");
            return;
        }
        int i2 = 8 > i / 2 ? i / 2 : 8;
        if (i - bArrB.length > i2) {
            fp3.a("CTR/SIC mode requires IV of at least: ", this.c - i2, " bytes.");
            return;
        }
        if (l73Var.b() != null) {
            this.b.a(true, l73Var.b());
        }
        reset();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tk
    public String b() {
        return this.b.b() + "/SIC";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.se4
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte b;
        if (i + i2 > bArr.length) {
            throw new v90("input buffer too small");
        }
        if (i3 + i2 > bArr2.length) {
            throw new z63("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.g;
            if (i5 == 0) {
                h();
                this.b.f(this.e, 0, this.f, 0);
                byte b2 = bArr[i + i4];
                byte[] bArr3 = this.f;
                int i6 = this.g;
                this.g = i6 + 1;
                b = (byte) (b2 ^ bArr3[i6]);
            } else {
                byte b3 = bArr[i + i4];
                byte[] bArr4 = this.f;
                int i7 = i5 + 1;
                this.g = i7;
                b = (byte) (bArr4[i5] ^ b3);
                if (i7 == this.e.length) {
                    this.g = 0;
                    i();
                }
            }
            bArr2[i3 + i4] = b;
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tk
    public int f(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.g;
        int i4 = this.c;
        if (i3 != 0) {
            c(bArr, i, i4, bArr2, i2);
        } else {
            if (i + i4 > bArr.length) {
                throw new v90("input buffer too small");
            }
            if (i2 + i4 > bArr2.length) {
                throw new z63("output buffer too short");
            }
            this.b.f(this.e, 0, this.f, 0);
            for (int i5 = 0; i5 < this.c; i5++) {
                bArr2[i2 + i5] = (byte) (bArr[i + i5] ^ this.f[i5]);
            }
            i();
        }
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tk
    public int g() {
        return this.b.g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        byte[] bArr = this.d;
        if (bArr.length >= this.c || this.e[bArr.length - 1] == bArr[bArr.length - 1]) {
            return;
        }
        e04.a("Counter in CTR/SIC mode out of range.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i() {
        byte b;
        int length = this.e.length;
        do {
            length--;
            if (length < 0) {
                return;
            }
            byte[] bArr = this.e;
            b = (byte) (bArr[length] + 1);
            bArr[length] = b;
        } while (b == 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tk
    public void reset() {
        qa.e(this.e, (byte) 0);
        byte[] bArr = this.d;
        System.arraycopy(bArr, 0, this.e, 0, bArr.length);
        this.b.reset();
        this.g = 0;
    }
}
