package defpackage;

import defpackage.yc;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class w64 extends zg {
    public final float i;
    public final short j;
    public final int k;
    public final long l;
    public final long m;
    public int n;
    public boolean o;
    public int p;
    public long q;
    public int r;
    public byte[] s;
    public int t;
    public int u;
    public byte[] v;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public w64(long j, float f, long j2, int i, short s) {
        boolean z = false;
        this.r = 0;
        this.t = 0;
        this.u = 0;
        if (f >= 0.0f && f <= 1.0f) {
            z = true;
        }
        gg3.d(z);
        this.l = j;
        this.i = f;
        this.m = j2;
        this.k = i;
        this.j = s;
        byte[] bArr = fy4.f;
        this.s = bArr;
        this.v = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void F(byte[] bArr, int i, int i2) {
        if (i2 >= 32767) {
            bArr[i] = -1;
            bArr[i + 1] = 127;
        } else if (i2 <= -32768) {
            bArr[i] = 0;
            bArr[i + 1] = -128;
        } else {
            bArr[i] = (byte) (i2 & 255);
            bArr[i + 1] = (byte) (i2 >> 8);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int I(byte b, byte b2) {
        return (b << 8) | (b2 & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(ByteBuffer byteBuffer) {
        o(byteBuffer.remaining()).put(byteBuffer).flip();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B(byte[] bArr, int i, int i2) {
        gg3.g(i % this.n == 0, "byteOutput size is not aligned to frame size %s", i);
        z(bArr, i, i2);
        o(i).put(bArr, 0, i).flip();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(boolean z) {
        int length;
        int iT;
        int i = this.u;
        byte[] bArr = this.s;
        if (i == bArr.length || z) {
            if (this.r == 0) {
                if (z) {
                    D(i, 3);
                    length = i;
                } else {
                    gg3.v(i >= bArr.length / 2);
                    length = this.s.length / 2;
                    D(length, 0);
                }
                iT = length;
            } else if (z) {
                int length2 = i - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iT2 = t(length2) + (this.s.length / 2);
                D(iT2, 2);
                iT = iT2;
                length = length3;
            } else {
                length = i - (bArr.length / 2);
                iT = t(length);
                D(iT, 1);
            }
            gg3.y(length % this.n == 0, "bytesConsumed is not aligned to frame size: %s", length);
            gg3.v(i >= iT);
            this.u -= length;
            int i2 = this.t + length;
            this.t = i2;
            this.t = i2 % this.s.length;
            int i3 = this.r;
            int i4 = this.n;
            this.r = i3 + (iT / i4);
            this.q += (long) ((length - iT) / i4);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(int i, int i2) {
        if (i == 0) {
            return;
        }
        gg3.d(this.u >= i);
        int i3 = this.t;
        if (i2 == 2) {
            int i4 = this.u;
            int i5 = i3 + i4;
            byte[] bArr = this.s;
            if (i5 <= bArr.length) {
                System.arraycopy(bArr, (i3 + i4) - i, this.v, 0, i);
            } else {
                int length = i4 - (bArr.length - i3);
                if (length >= i) {
                    System.arraycopy(bArr, length - i, this.v, 0, i);
                } else {
                    int i6 = i - length;
                    System.arraycopy(bArr, bArr.length - i6, this.v, 0, i6);
                    System.arraycopy(this.s, 0, this.v, i6, length);
                }
            }
        } else {
            int i7 = i3 + i;
            byte[] bArr2 = this.s;
            if (i7 <= bArr2.length) {
                System.arraycopy(bArr2, i3, this.v, 0, i);
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr2, i3, this.v, 0, length2);
                System.arraycopy(this.s, 0, this.v, length2, i - length2);
            }
        }
        gg3.g(i % this.n == 0, "sizeToOutput is not aligned to frame size: %s", i);
        gg3.v(this.t < this.s.length);
        B(this.v, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.s.length));
        int iV = v(byteBuffer);
        if (iV == byteBuffer.position()) {
            this.p = 1;
        } else {
            byteBuffer.limit(Math.min(iV, byteBuffer.capacity()));
            A(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G(boolean z) {
        this.o = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(ByteBuffer byteBuffer) {
        int length;
        int i;
        gg3.v(this.t < this.s.length);
        int iLimit = byteBuffer.limit();
        int iW = w(byteBuffer);
        int iPosition = iW - byteBuffer.position();
        int i2 = this.t;
        int i3 = this.u;
        int i4 = i2 + i3;
        byte[] bArr = this.s;
        if (i4 < bArr.length) {
            length = bArr.length - (i3 + i2);
            i = i2 + i3;
        } else {
            int length2 = i3 - (bArr.length - i2);
            length = i2 - length2;
            i = length2;
        }
        boolean z = iW < iLimit;
        int iMin = Math.min(iPosition, length);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.s, i, iMin);
        int i5 = this.u + iMin;
        this.u = i5;
        gg3.v(i5 <= this.s.length);
        boolean z2 = z && iPosition < length;
        C(z2);
        if (z2) {
            this.p = 0;
            this.r = 0;
        }
        byteBuffer.limit(iLimit);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg, defpackage.yc
    public boolean c() {
        return super.c() && this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public void f(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !a()) {
            int i = this.p;
            if (i == 0) {
                E(byteBuffer);
            } else {
                if (i != 1) {
                    z20.a();
                    return;
                }
                H(byteBuffer);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public yc.a j(yc.a aVar) throws yc.c {
        if (aVar.c == 2) {
            return aVar.a == -1 ? yc.a.e : aVar;
        }
        throw new yc.c(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public void l(yc.b bVar) {
        if (c()) {
            this.n = this.b.b * 2;
            int iQ = q(u(this.l) / 2) * 2;
            if (this.s.length != iQ) {
                this.s = new byte[iQ];
                this.v = new byte[iQ];
            }
        }
        this.p = 0;
        this.q = 0L;
        this.r = 0;
        this.t = 0;
        this.u = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public void m() {
        if (this.u > 0) {
            C(true);
            this.r = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg
    public void n() {
        this.o = false;
        byte[] bArr = fy4.f;
        this.s = bArr;
        this.v = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int p(float f) {
        return q((int) f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int q(int i) {
        int i2 = this.n;
        return (i / i2) * i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int r(int i, int i2) {
        int i3 = this.k;
        return i3 + ((((100 - i3) * (i * 1000)) / i2) / 1000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int s(int i, int i2) {
        return (((this.k - 100) * ((i * 1000) / i2)) / 1000) + 100;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int t(int i) {
        int iU = ((u(this.m) - this.r) * this.n) - (this.s.length / 2);
        gg3.v(iU >= 0);
        return p(Math.min((i * this.i) + 0.5f, iU));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int u(long j) {
        return (int) ((j * ((long) this.b.a)) / 1000000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int v(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 1; iLimit >= byteBuffer.position(); iLimit -= 2) {
            if (y(byteBuffer.get(iLimit), byteBuffer.get(iLimit - 1))) {
                int i = this.n;
                return ((iLimit / i) * i) + i;
            }
        }
        return byteBuffer.position();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int w(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position() + 1; iPosition < byteBuffer.limit(); iPosition += 2) {
            if (y(byteBuffer.get(iPosition), byteBuffer.get(iPosition - 1))) {
                int i = this.n;
                return i * (iPosition / i);
            }
        }
        return byteBuffer.limit();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long x() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean y(byte b, byte b2) {
        return Math.abs(I(b, b2)) > this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(byte[] bArr, int i, int i2) {
        if (i2 == 3) {
            return;
        }
        for (int i3 = 0; i3 < i; i3 += 2) {
            F(bArr, i3, (I(bArr[i3 + 1], bArr[i3]) * (i2 == 0 ? s(i3, i - 1) : i2 == 2 ? r(i3, i - 1) : this.k)) / 100);
        }
    }

    public w64() {
        this(100000L, 0.2f, 2000000L, 10, (short) 1024);
    }
}
