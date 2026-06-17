package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class y81 implements e {
    public tk a;
    public a91 b;
    public z81 c;
    public boolean d;
    public boolean e;
    public int f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public byte[] m;
    public byte[] n;
    public byte[] o;
    public byte[] p;
    public byte[] q;
    public int r;
    public int s;
    public long t;
    public byte[] u;
    public int v;
    public long w;
    public long x;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y81(tk tkVar, a91 a91Var) {
        if (tkVar.g() != 16) {
            jl.a("cipher required with a block size of 16.");
            throw null;
        }
        a91Var = a91Var == null ? new zk4() : a91Var;
        this.a = tkVar;
        this.b = a91Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f
    public void a(boolean z, yt ytVar) {
        byte[] bArrA;
        yq1 yq1VarB;
        byte[] bArr;
        this.d = z;
        this.m = null;
        this.e = true;
        if (ytVar instanceof g) {
            g gVar = (g) ytVar;
            bArrA = gVar.d();
            this.i = gVar.a();
            int iC = gVar.c();
            if (iC < 32 || iC > 128 || iC % 8 != 0) {
                b.a("Invalid value for MAC size: ", iC);
                return;
            } else {
                this.f = iC / 8;
                yq1VarB = gVar.b();
            }
        } else {
            if (!(ytVar instanceof l73)) {
                jl.a("invalid parameters passed to GCM");
                return;
            }
            l73 l73Var = (l73) ytVar;
            bArrA = l73Var.a();
            this.i = null;
            this.f = 16;
            yq1VarB = (yq1) l73Var.b();
        }
        this.l = new byte[z ? 16 : this.f + 16];
        if (bArrA == null || bArrA.length < 1) {
            jl.a("IV must be at least 1 byte");
            return;
        }
        if (z && (bArr = this.h) != null && qa.a(bArr, bArrA)) {
            if (yq1VarB == null) {
                jl.a("cannot reuse nonce for GCM encryption");
                return;
            }
            byte[] bArr2 = this.g;
            if (bArr2 != null && qa.a(bArr2, yq1VarB.a())) {
                jl.a("cannot reuse nonce for GCM encryption");
                return;
            }
        }
        this.h = bArrA;
        if (yq1VarB != null) {
            this.g = yq1VarB.a();
        }
        if (yq1VarB != null) {
            this.a.a(true, yq1VarB);
            byte[] bArr3 = new byte[16];
            this.j = bArr3;
            this.a.f(bArr3, 0, bArr3, 0);
            this.b.init(this.j);
            this.c = null;
        } else if (this.j == null) {
            jl.a("Key must be specified in initial init");
            return;
        }
        byte[] bArr4 = new byte[16];
        this.k = bArr4;
        byte[] bArr5 = this.h;
        if (bArr5.length == 12) {
            System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
            this.k[15] = 1;
        } else {
            i(bArr4, bArr5, bArr5.length);
            byte[] bArr6 = new byte[16];
            b73.h(((long) this.h.length) * 8, bArr6, 8);
            j(this.k, bArr6);
        }
        this.n = new byte[16];
        this.o = new byte[16];
        this.p = new byte[16];
        this.u = new byte[16];
        this.v = 0;
        this.w = 0L;
        this.x = 0L;
        this.q = qa.b(this.k);
        this.r = -2;
        this.s = 0;
        this.t = 0L;
        byte[] bArr7 = this.i;
        if (bArr7 != null) {
            f(bArr7, 0, bArr7.length);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b() {
        if (this.e) {
            return;
        }
        e04.a(this.d ? "GCM cipher cannot be reused for encryption" : "GCM cipher needs to be initialised");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        b();
        if (bArr.length - i < i2) {
            throw new v90("Input buffer too short");
        }
        int i5 = 16;
        if (this.d) {
            int i6 = this.s;
            if (i6 > 0) {
                int i7 = 16 - i6;
                byte[] bArr3 = this.l;
                if (i2 < i7) {
                    System.arraycopy(bArr, i, bArr3, i6, i2);
                } else {
                    System.arraycopy(bArr, i, bArr3, i6, i7);
                    h(this.l, 0, bArr2, i3);
                    i += i7;
                    i2 -= i7;
                }
            } else {
                i5 = 0;
            }
            int i8 = i2 + i;
            int i9 = i8 - 16;
            while (i <= i9) {
                h(bArr, i, bArr2, i3 + i5);
                i += 16;
                i5 += 16;
            }
            int i10 = i8 - i;
            this.s = i10;
            System.arraycopy(bArr, i, this.l, 0, i10);
            return i5;
        }
        byte[] bArr4 = this.l;
        int length = bArr4.length;
        int i11 = this.s;
        int i12 = length - i11;
        if (i2 >= i12) {
            if (i11 >= 16) {
                g(bArr4, 0, bArr2, i3);
                byte[] bArr5 = this.l;
                int i13 = this.s - 16;
                this.s = i13;
                System.arraycopy(bArr5, 16, bArr5, 0, i13);
                if (i2 < i12 + 16) {
                    System.arraycopy(bArr, i, this.l, this.s, i2);
                    this.s += i2;
                    return 16;
                }
                i4 = 16;
            } else {
                i4 = 0;
            }
            byte[] bArr6 = this.l;
            int length2 = (i2 + i) - bArr6.length;
            int i14 = this.s;
            int i15 = 16 - i14;
            System.arraycopy(bArr, i, bArr6, i14, i15);
            g(this.l, 0, bArr2, i3 + i4);
            int i16 = i + i15;
            int i17 = i4 + 16;
            while (i16 <= length2) {
                g(bArr, i16, bArr2, i3 + i17);
                i16 += 16;
                i17 += 16;
            }
            byte[] bArr7 = this.l;
            int length3 = (bArr7.length + length2) - i16;
            this.s = length3;
            System.arraycopy(bArr, i16, bArr7, 0, length3);
            return i17;
        }
        System.arraycopy(bArr, i, bArr4, i11, i2);
        this.s += i2;
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f
    public int d(int i) {
        int i2 = i + this.s;
        if (!this.d) {
            int i3 = this.f;
            if (i2 < i3) {
                return 0;
            }
            i2 -= i3;
        }
        return i2 - (i2 % 16);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f
    public int doFinal(byte[] bArr, int i) throws nl1 {
        y81 y81Var;
        byte[] bArr2;
        int i2;
        b();
        if (this.t == 0) {
            n();
        }
        int i3 = this.s;
        if (!this.d) {
            int i4 = this.f;
            if (i3 < i4) {
                throw new nl1("data too short");
            }
            i3 -= i4;
            if (bArr.length - i < i3) {
                throw new z63("Output buffer too short");
            }
        } else if (bArr.length - i < this.f + i3) {
            throw new z63("Output buffer too short");
        }
        int i5 = i3;
        if (i5 > 0) {
            y81Var = this;
            bArr2 = bArr;
            i2 = i;
            y81Var.o(this.l, 0, i5, bArr2, i2);
        } else {
            y81Var = this;
            bArr2 = bArr;
            i2 = i;
        }
        long j = y81Var.w;
        int i6 = y81Var.v;
        long j2 = j + ((long) i6);
        y81Var.w = j2;
        if (j2 > y81Var.x) {
            if (i6 > 0) {
                y81Var.l(y81Var.o, y81Var.u, 0, i6);
            }
            if (y81Var.x > 0) {
                b91.p(y81Var.o, y81Var.p);
            }
            long j3 = ((y81Var.t * 8) + 127) >>> 7;
            byte[] bArr3 = new byte[16];
            if (y81Var.c == null) {
                hj hjVar = new hj();
                y81Var.c = hjVar;
                hjVar.init(y81Var.j);
            }
            y81Var.c.a(j3, bArr3);
            b91.i(y81Var.o, bArr3);
            b91.p(y81Var.n, y81Var.o);
        }
        byte[] bArr4 = new byte[16];
        b73.h(y81Var.w * 8, bArr4, 0);
        b73.h(y81Var.t * 8, bArr4, 8);
        y81Var.j(y81Var.n, bArr4);
        byte[] bArr5 = new byte[16];
        y81Var.a.f(y81Var.k, 0, bArr5, 0);
        b91.p(bArr5, y81Var.n);
        int i7 = y81Var.f;
        byte[] bArr6 = new byte[i7];
        y81Var.m = bArr6;
        System.arraycopy(bArr5, 0, bArr6, 0, i7);
        if (y81Var.d) {
            System.arraycopy(y81Var.m, 0, bArr2, i2 + y81Var.s, y81Var.f);
            i5 += y81Var.f;
        } else {
            int i8 = y81Var.f;
            byte[] bArr7 = new byte[i8];
            System.arraycopy(y81Var.l, i5, bArr7, 0, i8);
            if (!qa.c(y81Var.m, bArr7)) {
                throw new nl1("mac check in GCM failed");
            }
        }
        y81Var.p(false);
        return i5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f
    public int e(int i) {
        int i2 = i + this.s;
        boolean z = this.d;
        int i3 = this.f;
        if (z) {
            return i2 + i3;
        }
        if (i2 < i3) {
            return 0;
        }
        return i2 - i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f
    public void f(byte[] bArr, int i, int i2) {
        b();
        int i3 = this.v;
        if (i3 > 0) {
            int i4 = 16 - i3;
            byte[] bArr2 = this.u;
            if (i2 < i4) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.v += i2;
                return;
            } else {
                System.arraycopy(bArr, i, bArr2, i3, i4);
                j(this.o, this.u);
                this.w += 16;
                i += i4;
                i2 -= i4;
            }
        }
        int i5 = i2 + i;
        int i6 = i5 - 16;
        while (i <= i6) {
            k(this.o, bArr, i);
            this.w += 16;
            i += 16;
        }
        int i7 = i5 - i;
        this.v = i7;
        System.arraycopy(bArr, i, this.u, 0, i7);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length - i2 < 16) {
            throw new z63("Output buffer too short");
        }
        if (this.t == 0) {
            n();
        }
        byte[] bArr3 = new byte[16];
        m(bArr3);
        k(this.n, bArr, i);
        b91.o(bArr3, 0, bArr, i, bArr2, i2);
        this.t += 16;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length - i2 < 16) {
            throw new z63("Output buffer too short");
        }
        if (this.t == 0) {
            n();
        }
        byte[] bArr3 = new byte[16];
        m(bArr3);
        b91.q(bArr3, bArr, i);
        j(this.n, bArr3);
        System.arraycopy(bArr3, 0, bArr2, i2, 16);
        this.t += 16;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2 += 16) {
            l(bArr, bArr2, i2, Math.min(i - i2, 16));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(byte[] bArr, byte[] bArr2) {
        b91.p(bArr, bArr2);
        this.b.a(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(byte[] bArr, byte[] bArr2, int i) {
        b91.q(bArr, bArr2, i);
        this.b.a(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(byte[] bArr, byte[] bArr2, int i, int i2) {
        b91.r(bArr, bArr2, i, i2);
        this.b.a(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(byte[] bArr) {
        int i = this.r;
        if (i == 0) {
            e04.a("Attempt to process too many blocks");
            return;
        }
        this.r = i - 1;
        byte[] bArr2 = this.q;
        int i2 = (bArr2[15] & 255) + 1;
        bArr2[15] = (byte) i2;
        int i3 = (i2 >>> 8) + (bArr2[14] & 255);
        bArr2[14] = (byte) i3;
        int i4 = (i3 >>> 8) + (bArr2[13] & 255);
        bArr2[13] = (byte) i4;
        bArr2[12] = (byte) ((i4 >>> 8) + (bArr2[12] & 255));
        this.a.f(bArr2, 0, bArr, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        if (this.w > 0) {
            System.arraycopy(this.o, 0, this.p, 0, 16);
            this.x = this.w;
        }
        int i = this.v;
        if (i > 0) {
            l(this.p, this.u, 0, i);
            this.x += (long) this.v;
        }
        if (this.x > 0) {
            System.arraycopy(this.p, 0, this.n, 0, 16);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = new byte[16];
        m(bArr3);
        if (this.d) {
            b91.n(bArr, i, bArr3, 0, i2);
            l(this.n, bArr, i, i2);
        } else {
            l(this.n, bArr, i, i2);
            b91.n(bArr, i, bArr3, 0, i2);
        }
        System.arraycopy(bArr, i, bArr2, i3, i2);
        this.t += (long) i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(boolean z) {
        this.a.reset();
        this.n = new byte[16];
        this.o = new byte[16];
        this.p = new byte[16];
        this.u = new byte[16];
        this.v = 0;
        this.w = 0L;
        this.x = 0L;
        this.q = qa.b(this.k);
        this.r = -2;
        this.s = 0;
        this.t = 0L;
        byte[] bArr = this.l;
        if (bArr != null) {
            qa.e(bArr, (byte) 0);
        }
        if (z) {
            this.m = null;
        }
        if (this.d) {
            this.e = false;
            return;
        }
        byte[] bArr2 = this.i;
        if (bArr2 != null) {
            f(bArr2, 0, bArr2.length);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f
    public void reset() {
        p(true);
    }

    public y81(tk tkVar) {
        this(tkVar, null);
    }
}
