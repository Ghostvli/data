package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import defpackage.ex3;
import defpackage.gr4;
import defpackage.j5;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cx3 {
    public final j5 a;
    public final int b;
    public final r73 c;
    public a d;
    public a e;
    public a f;
    public long g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements j5.a {
        public long a;
        public long b;
        public i5 c;
        public a d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(long j, int i) {
            d(j, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // j5.a
        public i5 a() {
            return (i5) gg3.q(this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a b() {
            this.c = null;
            a aVar = this.d;
            this.d = null;
            return aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(i5 i5Var, a aVar) {
            this.c = i5Var;
            this.d = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(long j, int i) {
            gg3.v(this.c == null);
            this.a = j;
            this.b = j + ((long) i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int e(long j) {
            return ((int) (j - this.a)) + this.c.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // j5.a
        public j5.a next() {
            a aVar = this.d;
            if (aVar == null || aVar.c == null) {
                return null;
            }
            return aVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cx3(j5 j5Var) {
        this.a = j5Var;
        int iE = j5Var.e();
        this.b = iE;
        this.c = new r73(32);
        a aVar = new a(0L, iE);
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a d(a aVar, long j) {
        while (j >= aVar.b) {
            aVar = aVar.d;
        }
        return aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a i(a aVar, long j, ByteBuffer byteBuffer, int i) {
        a aVarD = d(aVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVarD.b - j));
            byteBuffer.put(aVarD.c.a, aVarD.e(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == aVarD.b) {
                aVarD = aVarD.d;
            }
        }
        return aVarD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a j(a aVar, long j, byte[] bArr, int i) {
        a aVarD = d(aVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVarD.b - j));
            System.arraycopy(aVarD.c.a, aVarD.e(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == aVarD.b) {
                aVarD = aVarD.d;
            }
        }
        return aVarD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a k(a aVar, DecoderInputBuffer decoderInputBuffer, ex3.b bVar, r73 r73Var) {
        long j = bVar.b;
        int iY = 1;
        r73Var.b0(1);
        a aVarJ = j(aVar, j, r73Var.f(), 1);
        long j2 = j + 1;
        byte b = r73Var.f()[0];
        boolean z = (b & 128) != 0;
        int i = b & 127;
        h50 h50Var = decoderInputBuffer.cryptoInfo;
        byte[] bArr = h50Var.a;
        if (bArr == null) {
            h50Var.a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarJ2 = j(aVarJ, j2, h50Var.a, i);
        long j3 = j2 + ((long) i);
        if (z) {
            r73Var.b0(2);
            aVarJ2 = j(aVarJ2, j3, r73Var.f(), 2);
            j3 += 2;
            iY = r73Var.Y();
        }
        int i2 = iY;
        int[] iArr = h50Var.d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = h50Var.e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            r73Var.b0(i3);
            aVarJ2 = j(aVarJ2, j3, r73Var.f(), i3);
            j3 += (long) i3;
            r73Var.f0(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = r73Var.Y();
                iArr4[i4] = r73Var.U();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.a - ((int) (j3 - bVar.b));
        }
        gr4.a aVar2 = (gr4.a) fy4.l(bVar.c);
        h50Var.c(i2, iArr2, iArr4, aVar2.b, h50Var.a, aVar2.a, aVar2.c, aVar2.d);
        long j4 = bVar.b;
        int i5 = (int) (j3 - j4);
        bVar.b = j4 + ((long) i5);
        bVar.a -= i5;
        return aVarJ2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a l(a aVar, DecoderInputBuffer decoderInputBuffer, ex3.b bVar, r73 r73Var) {
        if (decoderInputBuffer.isEncrypted()) {
            aVar = k(aVar, decoderInputBuffer, bVar, r73Var);
        }
        if (!decoderInputBuffer.hasSupplementalData()) {
            decoderInputBuffer.ensureSpaceForWrite(bVar.a);
            return i(aVar, bVar.b, decoderInputBuffer.data, bVar.a);
        }
        r73Var.b0(4);
        a aVarJ = j(aVar, bVar.b, r73Var.f(), 4);
        int iU = r73Var.U();
        bVar.b += 4;
        bVar.a -= 4;
        decoderInputBuffer.ensureSpaceForWrite(iU);
        a aVarI = i(aVarJ, bVar.b, decoderInputBuffer.data, iU);
        bVar.b += (long) iU;
        int i = bVar.a - iU;
        bVar.a = i;
        decoderInputBuffer.resetSupplementalData(i);
        return i(aVarI, bVar.b, decoderInputBuffer.supplementalData, bVar.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(a aVar) {
        if (aVar.c == null) {
            return;
        }
        this.a.a(aVar);
        aVar.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(long j) {
        a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.d;
            if (j < aVar.b) {
                break;
            }
            this.a.b(aVar.c);
            this.d = this.d.b();
        }
        if (this.e.a < aVar.a) {
            this.e = aVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(long j) {
        a aVar;
        gg3.d(j <= this.g);
        this.g = j;
        if (j != 0) {
            a aVar2 = this.d;
            if (j != aVar2.a) {
                while (true) {
                    long j2 = this.g;
                    long j3 = aVar2.b;
                    aVar = aVar2.d;
                    if (j2 <= j3) {
                        break;
                    } else {
                        aVar2 = aVar;
                    }
                }
                a aVar3 = (a) gg3.q(aVar);
                a(aVar3);
                a aVar4 = new a(aVar2.b, this.b);
                aVar2.d = aVar4;
                if (this.g == aVar2.b) {
                    aVar2 = aVar4;
                }
                this.f = aVar2;
                if (this.e == aVar3) {
                    this.e = aVar4;
                    return;
                }
                return;
            }
        }
        a(this.d);
        a aVar5 = new a(this.g, this.b);
        this.d = aVar5;
        this.e = aVar5;
        this.f = aVar5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long e() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(DecoderInputBuffer decoderInputBuffer, ex3.b bVar) {
        l(this.e, decoderInputBuffer, bVar, this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(int i) {
        long j = this.g + ((long) i);
        this.g = j;
        a aVar = this.f;
        if (j == aVar.b) {
            this.f = aVar.d;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int h(int i) {
        a aVar = this.f;
        if (aVar.c == null) {
            aVar.c(this.a.c(), new a(this.f.b, this.b));
        }
        return Math.min(i, (int) (this.f.b - this.g));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(DecoderInputBuffer decoderInputBuffer, ex3.b bVar) {
        this.e = l(this.e, decoderInputBuffer, bVar, this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n() {
        a(this.d);
        this.d.d(0L, this.b);
        a aVar = this.d;
        this.e = aVar;
        this.f = aVar;
        this.g = 0L;
        this.a.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o() {
        this.e = this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int p(x90 x90Var, int i, boolean z) throws EOFException {
        int iH = h(i);
        a aVar = this.f;
        int i2 = x90Var.read(aVar.c.a, aVar.e(this.g), iH);
        if (i2 != -1) {
            g(i2);
            return i2;
        }
        if (z) {
            return -1;
        }
        ll.a();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(r73 r73Var, int i) {
        while (i > 0) {
            int iH = h(i);
            a aVar = this.f;
            r73Var.u(aVar.c.a, aVar.e(this.g), iH);
            i -= iH;
            g(iH);
        }
    }
}
