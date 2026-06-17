package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class ln extends vg0 implements nn {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public int d;
    public tk e;
    public boolean f;

    public ln(tk tkVar) {
        this.e = tkVar;
        int iG = tkVar.g();
        this.d = iG;
        this.a = new byte[iG];
        this.b = new byte[iG];
        this.c = new byte[iG];
    }

    public static nn j(tk tkVar) {
        return new ln(tkVar);
    }

    @Override // defpackage.tk
    public void a(boolean z, yt ytVar) {
        boolean z2 = this.f;
        this.f = z;
        if (ytVar instanceof l73) {
            l73 l73Var = (l73) ytVar;
            byte[] bArrA = l73Var.a();
            if (bArrA.length != this.d) {
                jl.a("initialisation vector must be the same length as block size");
                return;
            } else {
                System.arraycopy(bArrA, 0, this.a, 0, bArrA.length);
                ytVar = l73Var.b();
            }
        } else {
            qa.e(this.a, (byte) 0);
        }
        reset();
        if (ytVar != null) {
            this.e.a(z, ytVar);
        } else {
            if (z2 == z) {
                return;
            }
            jl.a("cannot change encrypting state without providing key.");
        }
    }

    @Override // defpackage.tk
    public String b() {
        return this.e.b() + "/CBC";
    }

    @Override // defpackage.tk
    public int f(byte[] bArr, int i, byte[] bArr2, int i2) {
        return this.f ? i(bArr, i, bArr2, i2) : h(bArr, i, bArr2, i2);
    }

    @Override // defpackage.tk
    public int g() {
        return this.e.g();
    }

    public final int h(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.d;
        if (i + i3 > bArr.length) {
            throw new v90("input buffer too short");
        }
        System.arraycopy(bArr, i, this.c, 0, i3);
        int iF = this.e.f(bArr, i, bArr2, i2);
        for (int i4 = 0; i4 < this.d; i4++) {
            int i5 = i2 + i4;
            bArr2[i5] = (byte) (bArr2[i5] ^ this.b[i4]);
        }
        byte[] bArr3 = this.b;
        this.b = this.c;
        this.c = bArr3;
        return iF;
    }

    public final int i(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.d + i > bArr.length) {
            throw new v90("input buffer too short");
        }
        for (int i3 = 0; i3 < this.d; i3++) {
            byte[] bArr3 = this.b;
            bArr3[i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
        }
        int iF = this.e.f(this.b, 0, bArr2, i2);
        byte[] bArr4 = this.b;
        System.arraycopy(bArr2, i2, bArr4, 0, bArr4.length);
        return iF;
    }

    @Override // defpackage.tk
    public void reset() {
        byte[] bArr = this.a;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        qa.e(this.c, (byte) 0);
        this.e.reset();
    }
}
