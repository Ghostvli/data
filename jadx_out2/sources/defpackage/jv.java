package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jv extends cn {
    public static final boolean c = vw4.E();
    public Object a;
    public boolean b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends jv {
        public final byte[] d;
        public final int e;
        public final int f;
        public int g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                om1.a("buffer");
                throw null;
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                jl.a(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
                throw null;
            }
            this.d = bArr;
            this.e = i;
            this.g = i;
            this.f = i3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void A0(int i) throws c {
            int i2;
            int i3 = this.g;
            while (true) {
                int i4 = i & (-128);
                byte[] bArr = this.d;
                if (i4 == 0) {
                    i2 = i3 + 1;
                    bArr[i3] = (byte) i;
                    this.g = i2;
                    return;
                } else {
                    i2 = i3 + 1;
                    try {
                        bArr[i3] = (byte) (i | 128);
                        i >>>= 7;
                        i3 = i2;
                    } catch (IndexOutOfBoundsException e) {
                        throw new c(i2, this.f, 1, (Throwable) e);
                    }
                }
                throw new c(i2, this.f, 1, (Throwable) e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void B0(int i, long j) throws c {
            y0(i, 0);
            C0(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void C0(long j) throws c {
            byte[] bArr;
            int i;
            byte[] bArr2;
            int i2 = this.g;
            if (!jv.c || U() < 10) {
                while (true) {
                    long j2 = j & (-128);
                    bArr = this.d;
                    if (j2 == 0) {
                        break;
                    }
                    i = i2 + 1;
                    try {
                        bArr[i2] = (byte) (((int) j) | 128);
                        j >>>= 7;
                        i2 = i;
                    } catch (IndexOutOfBoundsException e) {
                        throw new c(i, this.f, 1, (Throwable) e);
                    }
                    throw new c(i, this.f, 1, (Throwable) e);
                }
                i = i2 + 1;
                bArr[i2] = (byte) j;
            } else {
                while (true) {
                    long j3 = j & (-128);
                    bArr2 = this.d;
                    if (j3 == 0) {
                        break;
                    }
                    vw4.K(bArr2, i2, (byte) (((int) j) | 128));
                    j >>>= 7;
                    i2++;
                }
                i = i2 + 1;
                vw4.K(bArr2, i2, (byte) j);
            }
            this.g = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void D0(byte[] bArr, int i, int i2) throws c {
            try {
                System.arraycopy(bArr, i, this.d, this.g, i2);
                this.g += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new c(this.g, this.f, i2, (Throwable) e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void E0(hn hnVar) throws c {
            A0(hnVar.size());
            hnVar.F(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void F0(int i, rs2 rs2Var) throws c {
            y0(i, 2);
            G0(rs2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void G0(rs2 rs2Var) throws c {
            A0(rs2Var.getSerializedSize());
            rs2Var.writeTo(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void H0(String str) throws c {
            int i = this.g;
            try {
                int iK = jv.K(str.length() * 3);
                int iK2 = jv.K(str.length());
                if (iK2 != iK) {
                    A0(wx4.c(str));
                    byte[] bArr = this.d;
                    int i2 = this.g;
                    this.g = wx4.b(str, bArr, i2, bArr.length - i2);
                    return;
                }
                int i3 = i + iK2;
                this.g = i3;
                byte[] bArr2 = this.d;
                int iB = wx4.b(str, bArr2, i3, bArr2.length - i3);
                this.g = i;
                A0((iB - i) - iK2);
                this.g = iB;
            } catch (IndexOutOfBoundsException e) {
                throw new c(e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void P() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final int U() {
            return this.f - this.g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void V(byte b) throws c {
            int i = this.g;
            try {
                int i2 = i + 1;
                try {
                    this.d[i] = b;
                    this.g = i2;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i = i2;
                    throw new c(i, this.f, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void W(int i, boolean z) throws c {
            y0(i, 0);
            V(z ? (byte) 1 : (byte) 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void Y(int i, hn hnVar) throws c {
            y0(i, 2);
            E0(hnVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.cn
        public final void a(byte[] bArr, int i, int i2) throws c {
            D0(bArr, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void d0(int i, int i2) throws c {
            y0(i, 5);
            e0(i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void e0(int i) throws c {
            int i2 = this.g;
            try {
                byte[] bArr = this.d;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                bArr[i2 + 3] = (byte) (i >> 24);
                this.g = i2 + 4;
            } catch (IndexOutOfBoundsException e) {
                throw new c(i2, this.f, 4, (Throwable) e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void f0(int i, long j) throws c {
            y0(i, 1);
            g0(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void g0(long j) throws c {
            int i = this.g;
            try {
                byte[] bArr = this.d;
                bArr[i] = (byte) j;
                bArr[i + 1] = (byte) (j >> 8);
                bArr[i + 2] = (byte) (j >> 16);
                bArr[i + 3] = (byte) (j >> 24);
                bArr[i + 4] = (byte) (j >> 32);
                bArr[i + 5] = (byte) (j >> 40);
                bArr[i + 6] = (byte) (j >> 48);
                bArr[i + 7] = (byte) (j >> 56);
                this.g = i + 8;
            } catch (IndexOutOfBoundsException e) {
                throw new c(i, this.f, 8, (Throwable) e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void j0(int i, int i2) throws c {
            y0(i, 0);
            k0(i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void k0(int i) throws c {
            if (i >= 0) {
                A0(i);
            } else {
                C0(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void n0(int i, rs2 rs2Var) throws c {
            y0(1, 3);
            z0(2, i);
            F0(3, rs2Var);
            y0(1, 4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void o0(int i, hn hnVar) throws c {
            y0(1, 3);
            z0(2, i);
            Y(3, hnVar);
            y0(1, 4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void x0(int i, String str) throws c {
            y0(i, 2);
            H0(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void y0(int i, int i2) throws c {
            A0(aa5.c(i, i2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final void z0(int i, int i2) throws c {
            y0(i, 0);
            A0(i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends jv {
        public final byte[] d;
        public final int e;
        public int f;
        public int g;
        public final OutputStream h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(OutputStream outputStream, int i) {
            super();
            if (outputStream == null) {
                om1.a("out");
                throw null;
            }
            this.h = outputStream;
            if (i < 0) {
                jl.a("bufferSize must be >= 0");
                throw null;
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.d = bArr;
            this.e = bArr.length;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void A0(int i) throws IOException {
            L0(5);
            I0(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void B0(int i, long j) throws IOException {
            L0(20);
            H0(i, 0);
            J0(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void C0(long j) throws IOException {
            L0(10);
            J0(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void D0(byte b) {
            int i = this.f;
            this.d[i] = b;
            this.f = i + 1;
            this.g++;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void E0(int i) {
            int i2 = this.f;
            byte[] bArr = this.d;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.f = i2 + 4;
            this.g += 4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void F0(long j) {
            int i = this.f;
            byte[] bArr = this.d;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.f = i + 8;
            this.g += 8;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void G0(int i) {
            if (i >= 0) {
                I0(i);
            } else {
                J0(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void H0(int i, int i2) {
            I0(aa5.c(i, i2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void I0(int i) {
            if (jv.c) {
                long j = this.f;
                while (true) {
                    int i2 = i & (-128);
                    byte[] bArr = this.d;
                    if (i2 == 0) {
                        int i3 = this.f;
                        this.f = i3 + 1;
                        vw4.K(bArr, i3, (byte) i);
                        this.g += (int) (((long) this.f) - j);
                        return;
                    }
                    int i4 = this.f;
                    this.f = i4 + 1;
                    vw4.K(bArr, i4, (byte) (i | 128));
                    i >>>= 7;
                }
            } else {
                while (true) {
                    int i5 = i & (-128);
                    byte[] bArr2 = this.d;
                    if (i5 == 0) {
                        int i6 = this.f;
                        this.f = i6 + 1;
                        bArr2[i6] = (byte) i;
                        this.g++;
                        return;
                    }
                    int i7 = this.f;
                    this.f = i7 + 1;
                    bArr2[i7] = (byte) (i | 128);
                    this.g++;
                    i >>>= 7;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void J0(long j) {
            if (jv.c) {
                long j2 = this.f;
                while (true) {
                    long j3 = j & (-128);
                    byte[] bArr = this.d;
                    if (j3 == 0) {
                        int i = this.f;
                        this.f = i + 1;
                        vw4.K(bArr, i, (byte) j);
                        this.g += (int) (((long) this.f) - j2);
                        return;
                    }
                    int i2 = this.f;
                    this.f = i2 + 1;
                    vw4.K(bArr, i2, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
            } else {
                while (true) {
                    long j4 = j & (-128);
                    byte[] bArr2 = this.d;
                    if (j4 == 0) {
                        int i3 = this.f;
                        this.f = i3 + 1;
                        bArr2[i3] = (byte) j;
                        this.g++;
                        return;
                    }
                    int i4 = this.f;
                    this.f = i4 + 1;
                    bArr2[i4] = (byte) (((int) j) | 128);
                    this.g++;
                    j >>>= 7;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void K0() throws IOException {
            this.h.write(this.d, 0, this.f);
            this.f = 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void L0(int i) throws IOException {
            if (this.e - this.f < i) {
                K0();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void M0(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.e;
            int i4 = this.f;
            int i5 = i3 - i4;
            byte[] bArr2 = this.d;
            if (i5 >= i2) {
                System.arraycopy(bArr, i, bArr2, i4, i2);
                this.f += i2;
                this.g += i2;
                return;
            }
            int i6 = i3 - i4;
            System.arraycopy(bArr, i, bArr2, i4, i6);
            int i7 = i + i6;
            int i8 = i2 - i6;
            this.f = this.e;
            this.g += i6;
            K0();
            if (i8 <= this.e) {
                System.arraycopy(bArr, i7, this.d, 0, i8);
                this.f = i8;
            } else {
                this.h.write(bArr, i7, i8);
            }
            this.g += i8;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void N0(hn hnVar) throws IOException {
            A0(hnVar.size());
            hnVar.F(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void O0(int i, rs2 rs2Var) throws IOException {
            y0(i, 2);
            P0(rs2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void P() throws IOException {
            if (this.f > 0) {
                K0();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void P0(rs2 rs2Var) throws IOException {
            A0(rs2Var.getSerializedSize());
            rs2Var.writeTo(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void Q0(String str) throws IOException {
            int iC;
            int length = str.length() * 3;
            int iK = jv.K(length);
            int i = iK + length;
            int i2 = this.e;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iB = wx4.b(str, bArr, 0, length);
                A0(iB);
                a(bArr, 0, iB);
                return;
            }
            if (i > i2 - this.f) {
                K0();
            }
            int iK2 = jv.K(str.length());
            int i3 = this.f;
            try {
                if (iK2 == iK) {
                    int i4 = i3 + iK2;
                    this.f = i4;
                    int iB2 = wx4.b(str, this.d, i4, this.e - i4);
                    this.f = i3;
                    iC = (iB2 - i3) - iK2;
                    I0(iC);
                    this.f = iB2;
                } else {
                    iC = wx4.c(str);
                    I0(iC);
                    this.f = wx4.b(str, this.d, this.f, iC);
                }
                this.g += iC;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new c(e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public final int U() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void V(byte b) throws IOException {
            if (this.f == this.e) {
                K0();
            }
            D0(b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void W(int i, boolean z) throws IOException {
            L0(11);
            H0(i, 0);
            D0(z ? (byte) 1 : (byte) 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void Y(int i, hn hnVar) throws IOException {
            y0(i, 2);
            N0(hnVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.cn
        public void a(byte[] bArr, int i, int i2) throws IOException {
            M0(bArr, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void d0(int i, int i2) throws IOException {
            L0(14);
            H0(i, 5);
            E0(i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void e0(int i) throws IOException {
            L0(4);
            E0(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void f0(int i, long j) throws IOException {
            L0(18);
            H0(i, 1);
            F0(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void g0(long j) throws IOException {
            L0(8);
            F0(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void j0(int i, int i2) throws IOException {
            L0(20);
            H0(i, 0);
            G0(i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void k0(int i) throws IOException {
            if (i >= 0) {
                A0(i);
            } else {
                C0(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void n0(int i, rs2 rs2Var) throws IOException {
            y0(1, 3);
            z0(2, i);
            O0(3, rs2Var);
            y0(1, 4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void o0(int i, hn hnVar) throws IOException {
            y0(1, 3);
            z0(2, i);
            Y(3, hnVar);
            y0(1, 4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void x0(int i, String str) throws IOException {
            y0(i, 2);
            Q0(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void y0(int i, int i2) throws IOException {
            A0(aa5.c(i, i2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jv
        public void z0(int i, int i2) throws IOException {
            L0(20);
            H0(i, 0);
            I0(i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int A(int i, long j) {
        return I(i) + B(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int B(long j) {
        return 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int C(int i, int i2) {
        return I(i) + D(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int D(int i) {
        return K(N(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int E(int i, long j) {
        return I(i) + F(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int F(long j) {
        return M(O(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int G(int i, String str) {
        return I(i) + H(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int H(String str) {
        return v(wx4.c(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int I(int i) {
        return K(aa5.c(i, 0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int J(int i, int i2) {
        return I(i) + K(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int K(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int L(int i, long j) {
        return I(i) + M(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int M(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int N(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long O(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jv R(OutputStream outputStream, int i) {
        return new d(outputStream, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jv S(byte[] bArr) {
        return T(bArr, 0, bArr.length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jv T(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(int i, boolean z) {
        return I(i) + e(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(boolean z) {
        return 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(int i, hn hnVar) {
        return I(i) + g(hnVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(hn hnVar) {
        return v(hnVar.size());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h(int i, double d2) {
        return I(i) + i(d2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(double d2) {
        return 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(int i, int i2) {
        return I(i) + k(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(int i) {
        return s(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int l(int i, int i2) {
        return I(i) + m(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int m(int i) {
        return 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int n(int i, long j) {
        return I(i) + o(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int o(long j) {
        return 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(int i, float f) {
        return I(i) + q(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int q(float f) {
        return 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int r(int i, int i2) {
        return I(i) + s(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int s(int i) {
        return M(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int t(int i, long j) {
        return I(i) + u(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int u(long j) {
        return M(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int v(int i) {
        return K(i) + i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int w(int i) {
        return i > 4096 ? Buffer.SEGMENTING_THRESHOLD : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int x(int i, hn hnVar) {
        return (I(1) * 2) + J(2, i) + f(3, hnVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int y(int i, int i2) {
        return I(i) + z(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int z(int i) {
        return 4;
    }

    public abstract void A0(int i);

    public abstract void B0(int i, long j);

    public abstract void C0(long j);

    public abstract void P();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean Q() {
        return this.b;
    }

    public abstract int U();

    public abstract void V(byte b2);

    public abstract void W(int i, boolean z);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X(boolean z) {
        V(z ? (byte) 1 : (byte) 0);
    }

    public abstract void Y(int i, hn hnVar);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Z(int i, double d2) {
        f0(i, Double.doubleToRawLongBits(d2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a0(double d2) {
        g0(Double.doubleToRawLongBits(d2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b0(int i, int i2) {
        j0(i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() {
        if (U() > 0) {
            e04.a("Did not write as much data as expected.");
        } else {
            if (U() >= 0) {
                return;
            }
            e04.a("Wrote more data than expected.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c0(int i) {
        k0(i);
    }

    public abstract void d0(int i, int i2);

    public abstract void e0(int i);

    public abstract void f0(int i, long j);

    public abstract void g0(long j);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h0(int i, float f) {
        d0(i, Float.floatToRawIntBits(f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i0(float f) {
        e0(Float.floatToRawIntBits(f));
    }

    public abstract void j0(int i, int i2);

    public abstract void k0(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l0(int i, long j) {
        B0(i, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m0(long j) {
        C0(j);
    }

    public abstract void n0(int i, rs2 rs2Var);

    public abstract void o0(int i, hn hnVar);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p0(int i, int i2) {
        d0(i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q0(int i) {
        e0(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r0(int i, long j) {
        f0(i, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s0(long j) {
        g0(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t0(int i, int i2) {
        z0(i, N(i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u0(int i) {
        A0(N(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v0(int i, long j) {
        B0(i, O(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w0(long j) {
        C0(O(j));
    }

    public abstract void x0(int i, String str);

    public abstract void y0(int i, int i2);

    public abstract void z0(int i, int i2);

    public jv() {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends IOException {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(long j, long j2, int i, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)), th);
        }

        public c(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        public c(int i, int i2, int i3, Throwable th) {
            this(i, i2, i3, th);
        }

        public c(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }
}
