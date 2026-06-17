package defpackage;

import defpackage.yc;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ot4 extends zg {
    public int i;
    public int j;
    public boolean k;
    public int l;
    public byte[] m = fy4.f;
    public int n;
    public long o;

    @Override // defpackage.zg, defpackage.yc
    public boolean b() {
        return super.b() && this.n == 0;
    }

    @Override // defpackage.zg, defpackage.yc
    public ByteBuffer d() {
        int i;
        if (super.b() && (i = this.n) > 0) {
            o(i).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.d();
    }

    @Override // defpackage.yc
    public void f(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.l);
        this.o += (long) (iMin / this.b.d);
        this.l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.l > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.n + i2) - this.m.length;
        ByteBuffer byteBufferO = o(length);
        int iS = fy4.s(length, 0, this.n);
        byteBufferO.put(this.m, 0, iS);
        int iS2 = fy4.s(length - iS, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iS2);
        byteBufferO.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iS2;
        int i4 = this.n - iS;
        this.n = i4;
        byte[] bArr = this.m;
        System.arraycopy(bArr, iS, bArr, 0, i4);
        byteBuffer.get(this.m, this.n, i3);
        this.n += i3;
        byteBufferO.flip();
    }

    @Override // defpackage.yc
    public long i(long j) {
        return Math.max(0L, j - fy4.t1(this.j + this.i, this.b.a));
    }

    @Override // defpackage.zg
    public yc.a j(yc.a aVar) throws yc.c {
        if (!fy4.R0(aVar.c)) {
            throw new yc.c(aVar);
        }
        this.k = true;
        return (this.i == 0 && this.j == 0) ? yc.a.e : aVar;
    }

    @Override // defpackage.zg
    public void l(yc.b bVar) {
        if (this.k) {
            this.k = false;
            int i = this.j;
            int i2 = this.b.d;
            this.m = new byte[i * i2];
            this.l = this.i * i2;
        }
        this.n = 0;
    }

    @Override // defpackage.zg
    public void m() {
        if (this.k) {
            int i = this.n;
            if (i > 0) {
                this.o += (long) (i / this.b.d);
            }
            this.n = 0;
        }
    }

    @Override // defpackage.zg
    public void n() {
        this.m = fy4.f;
    }

    public long p() {
        return this.o;
    }

    public void q() {
        this.o = 0L;
    }

    public void r(int i, int i2) {
        this.i = i;
        this.j = i2;
    }
}
