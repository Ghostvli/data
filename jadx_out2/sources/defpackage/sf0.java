package defpackage;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class sf0 implements jz0 {
    public final x90 b;
    public final long c;
    public long d;
    public int f;
    public int g;
    public byte[] e = new byte[65536];
    public final byte[] a = new byte[Buffer.SEGMENTING_THRESHOLD];

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        kg2.a("media3.extractor");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sf0(x90 x90Var, long j, long j2) {
        this.b = x90Var;
        this.d = j;
        this.c = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public int b(int i) throws EOFException, InterruptedIOException {
        sf0 sf0Var;
        int iW = w(i);
        if (iW == 0) {
            byte[] bArr = this.a;
            sf0Var = this;
            iW = sf0Var.v(bArr, 0, Math.min(i, bArr.length), 0, true);
        } else {
            sf0Var = this;
        }
        sf0Var.h(iW);
        return iW;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public boolean d(byte[] bArr, int i, int i2, boolean z) throws EOFException, InterruptedIOException {
        int iU = u(bArr, i, i2);
        while (iU < i2 && iU != -1) {
            iU = v(bArr, i, i2, iU, z);
        }
        h(iU);
        return iU != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public long getLength() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public long getPosition() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(int i) {
        if (i != -1) {
            this.d += (long) i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public boolean i(int i, boolean z) throws EOFException, InterruptedIOException {
        int iW = w(i);
        while (iW < i && iW != -1) {
            iW = v(this.a, -iW, Math.min(i, this.a.length + iW), iW, z);
        }
        h(iW);
        return iW != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public boolean j(byte[] bArr, int i, int i2, boolean z) {
        if (!r(i2, z)) {
            return false;
        }
        System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public long k() {
        return this.d + ((long) this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public void m(int i) throws EOFException, InterruptedIOException {
        r(i, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public int n(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        sf0 sf0Var;
        int iMin;
        t(i2);
        int i3 = this.g;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            sf0Var = this;
            iMin = sf0Var.v(this.e, i4, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            sf0Var.g += iMin;
        } else {
            sf0Var = this;
            iMin = Math.min(i2, i5);
        }
        System.arraycopy(sf0Var.e, sf0Var.f, bArr, i, iMin);
        sf0Var.f += iMin;
        return iMin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public void p() {
        this.f = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public void q(int i) throws EOFException, InterruptedIOException {
        i(i, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public boolean r(int i, boolean z) throws EOFException, InterruptedIOException {
        t(i);
        int iV = this.g - this.f;
        while (iV < i) {
            sf0 sf0Var = this;
            int i2 = i;
            boolean z2 = z;
            iV = sf0Var.v(this.e, this.f, i2, iV, z2);
            if (iV == -1) {
                return false;
            }
            sf0Var.g = sf0Var.f + iV;
            this = sf0Var;
            i = i2;
            z = z2;
        }
        this.f += i;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0, defpackage.x90
    public int read(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        sf0 sf0Var;
        int iU = u(bArr, i, i2);
        if (iU == 0) {
            sf0Var = this;
            iU = sf0Var.v(bArr, i, i2, 0, true);
        } else {
            sf0Var = this;
        }
        sf0Var.h(iU);
        return iU;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public void readFully(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        d(bArr, i, i2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jz0
    public void s(byte[] bArr, int i, int i2) {
        j(bArr, i, i2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, fy4.s(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int u(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, iMin);
        x(iMin);
        return iMin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int v(byte[] bArr, int i, int i2, int i3, boolean z) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i4 = this.b.read(bArr, i + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        ll.a();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int w(int i) {
        int iMin = Math.min(this.g, i);
        x(iMin);
        return iMin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }
}
