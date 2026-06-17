package defpackage;

import android.graphics.Bitmap;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.p;
import defpackage.gi1;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ni1 extends androidx.media3.exoplayer.a {
    public boolean A;
    public boolean B;
    public a C;
    public long D;
    public long E;
    public int F;
    public int G;
    public t41 H;
    public gi1 I;
    public DecoderInputBuffer J;
    public ImageOutput K;
    public Bitmap L;
    public boolean M;
    public b N;
    public b O;
    public int P;
    public boolean Q;
    public final gi1.a x;
    public final DecoderInputBuffer y;
    public final ArrayDeque z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final a c = new a(-9223372036854775807L, -9223372036854775807L);
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final int a;
        public final long b;
        public Bitmap c;

        public b(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public long a() {
            return this.b;
        }

        public Bitmap b() {
            return this.c;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.c != null;
        }

        public void e(Bitmap bitmap) {
            this.c = bitmap;
        }
    }

    public ni1(gi1.a aVar, ImageOutput imageOutput) {
        super(4);
        this.x = aVar;
        this.K = u0(imageOutput);
        this.y = DecoderInputBuffer.newNoDataInstance();
        this.C = a.c;
        this.z = new ArrayDeque();
        this.E = -9223372036854775807L;
        this.D = -9223372036854775807L;
        this.F = 0;
        this.G = 1;
    }

    private void A0(long j) {
        this.D = j;
        while (!this.z.isEmpty() && j >= ((a) this.z.peek()).a) {
            this.C = (a) this.z.removeFirst();
        }
    }

    public static ImageOutput u0(ImageOutput imageOutput) {
        return imageOutput == null ? ImageOutput.a : imageOutput;
    }

    public boolean B0(long j, long j2, Bitmap bitmap, long j3) {
        long j4 = j3 - j;
        if (!E0() && j4 >= 30000) {
            return false;
        }
        this.K.onImageAvailable(j3 - this.C.b, bitmap);
        return true;
    }

    public final void C0() {
        this.J = null;
        this.F = 0;
        this.E = -9223372036854775807L;
        gi1 gi1Var = this.I;
        if (gi1Var != null) {
            gi1Var.release();
            this.I = null;
        }
    }

    public final void D0(ImageOutput imageOutput) {
        this.K = u0(imageOutput);
    }

    public final boolean E0() {
        boolean z = getState() == 2;
        int i = this.G;
        if (i == 0) {
            return z;
        }
        if (i == 1) {
            return true;
        }
        if (i == 3) {
            return false;
        }
        z20.a();
        return false;
    }

    @Override // androidx.media3.exoplayer.a, androidx.media3.exoplayer.n.b
    public void F(int i, Object obj) {
        if (i != 15) {
            super.F(i, obj);
        } else {
            D0(obj instanceof ImageOutput ? (ImageOutput) obj : null);
        }
    }

    @Override // androidx.media3.exoplayer.p
    public int a(t41 t41Var) {
        return this.x.a(t41Var);
    }

    @Override // androidx.media3.exoplayer.o
    public boolean b() {
        return this.B;
    }

    @Override // androidx.media3.exoplayer.o
    public void c(long j, long j2) throws zv0 {
        if (this.B) {
            return;
        }
        if (this.H == null) {
            u41 u41VarT = T();
            this.y.clear();
            int iN0 = n0(u41VarT, this.y, 2);
            if (iN0 != -5) {
                if (iN0 == -4) {
                    gg3.v(this.y.isEndOfStream());
                    this.A = true;
                    this.B = true;
                    return;
                }
                return;
            }
            this.H = (t41) gg3.q(u41VarT.b);
            this.Q = true;
        }
        if (this.I != null || y0()) {
            try {
                hq4.a("drainAndFeedDecoder");
                while (s0(j, j2)) {
                }
                while (t0(j)) {
                }
                hq4.b();
            } catch (hi1 e) {
                throw P(e, null, 4003);
            }
        }
    }

    @Override // androidx.media3.exoplayer.a
    public void c0() {
        this.H = null;
        this.C = a.c;
        this.z.clear();
        C0();
        this.K.a();
    }

    @Override // androidx.media3.exoplayer.a
    public void d0(boolean z, boolean z2) {
        this.G = z2 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.a
    public void f0(long j, boolean z, boolean z2) {
        w0(1);
        this.B = false;
        this.A = false;
        this.L = null;
        this.N = null;
        this.O = null;
        this.M = false;
        this.J = null;
        gi1 gi1Var = this.I;
        if (gi1Var != null) {
            gi1Var.flush();
        }
        this.z.clear();
    }

    @Override // androidx.media3.exoplayer.a
    public void g0() {
        C0();
    }

    @Override // androidx.media3.exoplayer.o, androidx.media3.exoplayer.p
    public String getName() {
        return "ImageRenderer";
    }

    @Override // androidx.media3.exoplayer.a
    public void i0() {
        C0();
        w0(1);
    }

    @Override // androidx.media3.exoplayer.o
    public boolean isReady() {
        int i = this.G;
        if (i != 3) {
            return i == 0 && this.M;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r2 >= r5) goto L15;
     */
    @Override // androidx.media3.exoplayer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l0(defpackage.t41[] r5, long r6, long r8, jq2.b r10) {
        /*
            r4 = this;
            super.l0(r5, r6, r8, r10)
            ni1$a r5 = r4.C
            long r5 = r5.b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 == 0) goto L36
            java.util.ArrayDeque r5 = r4.z
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L29
            long r5 = r4.E
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 == 0) goto L36
            long r2 = r4.D
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 == 0) goto L29
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 < 0) goto L29
            goto L36
        L29:
            java.util.ArrayDeque r5 = r4.z
            ni1$a r6 = new ni1$a
            long r0 = r4.E
            r6.<init>(r0, r8)
            r5.add(r6)
            return
        L36:
            ni1$a r5 = new ni1$a
            r5.<init>(r0, r8)
            r4.C = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ni1.l0(t41[], long, long, jq2$b):void");
    }

    public final boolean q0(t41 t41Var) {
        int iA = this.x.a(t41Var);
        return iA == p.C(4) || iA == p.C(3);
    }

    public final Bitmap r0(int i) {
        gg3.q(this.L);
        int width = this.L.getWidth() / ((t41) gg3.q(this.H)).O;
        int height = this.L.getHeight() / ((t41) gg3.q(this.H)).P;
        int i2 = this.H.O;
        return Bitmap.createBitmap(this.L, (i % i2) * width, (i / i2) * height, width, height);
    }

    public final boolean s0(long j, long j2) throws zv0 {
        if (this.L != null && this.N == null) {
            return false;
        }
        if (this.G == 0 && getState() != 2) {
            return false;
        }
        if (this.L == null) {
            gg3.q(this.I);
            li1 li1VarA = this.I.a();
            if (li1VarA == null) {
                return false;
            }
            if (((li1) gg3.q(li1VarA)).isEndOfStream()) {
                if (this.F == 3) {
                    C0();
                    gg3.q(this.H);
                    y0();
                } else {
                    ((li1) gg3.q(li1VarA)).release();
                    if (this.z.isEmpty()) {
                        this.B = true;
                    }
                }
                return false;
            }
            gg3.r(li1VarA.f, "Non-EOS buffer came back from the decoder without bitmap.");
            this.L = li1VarA.f;
            ((li1) gg3.q(li1VarA)).release();
        }
        if (!this.M || this.L == null || this.N == null) {
            return false;
        }
        gg3.q(this.H);
        t41 t41Var = this.H;
        int i = t41Var.O;
        boolean z = ((i == 1 && t41Var.P == 1) || i == -1 || t41Var.P == -1) ? false : true;
        if (!this.N.d()) {
            b bVar = this.N;
            bVar.e(z ? r0(bVar.c()) : (Bitmap) gg3.q(this.L));
        }
        if (!B0(j, j2, (Bitmap) gg3.q(this.N.b()), this.N.a())) {
            return false;
        }
        A0(((b) gg3.q(this.N)).a());
        this.G = 3;
        if (!z || ((b) gg3.q(this.N)).c() == (((t41) gg3.q(this.H)).P * ((t41) gg3.q(this.H)).O) - 1) {
            this.L = null;
        }
        this.N = this.O;
        this.O = null;
        return true;
    }

    public final boolean t0(long j) {
        if (this.M && this.N != null) {
            return false;
        }
        u41 u41VarT = T();
        gi1 gi1Var = this.I;
        if (gi1Var == null || this.F == 3 || this.A) {
            return false;
        }
        if (this.J == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) gi1Var.d();
            this.J = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        int i = this.F;
        DecoderInputBuffer decoderInputBuffer2 = this.J;
        if (i == 2) {
            gg3.q(decoderInputBuffer2);
            this.J.setFlags(4);
            ((gi1) gg3.q(this.I)).e(this.J);
            this.J = null;
            this.F = 3;
            return false;
        }
        int iN0 = n0(u41VarT, decoderInputBuffer2, 0);
        if (iN0 == -5) {
            this.H = (t41) gg3.q(u41VarT.b);
            this.Q = true;
            this.F = 2;
            return true;
        }
        if (iN0 != -4) {
            if (iN0 == -3) {
                return false;
            }
            z20.a();
            return false;
        }
        this.J.flip();
        ByteBuffer byteBuffer = this.J.data;
        boolean z = (byteBuffer != null && byteBuffer.remaining() > 0) || ((DecoderInputBuffer) gg3.q(this.J)).isEndOfStream();
        if (z) {
            ((DecoderInputBuffer) gg3.q(this.J)).format = this.H;
            ((gi1) gg3.q(this.I)).e((DecoderInputBuffer) gg3.q(this.J));
            this.P = 0;
        }
        x0(j, (DecoderInputBuffer) gg3.q(this.J));
        if (((DecoderInputBuffer) gg3.q(this.J)).isEndOfStream()) {
            this.A = true;
            this.J = null;
            return false;
        }
        this.E = Math.max(this.E, ((DecoderInputBuffer) gg3.q(this.J)).timeUs);
        if (z) {
            this.J = null;
        } else {
            ((DecoderInputBuffer) gg3.q(this.J)).clear();
        }
        return !this.M;
    }

    public final boolean v0(b bVar) {
        return ((t41) gg3.q(this.H)).O == -1 || this.H.P == -1 || bVar.c() == (((t41) gg3.q(this.H)).P * this.H.O) - 1;
    }

    public final void w0(int i) {
        this.G = Math.min(this.G, i);
    }

    public final void x0(long j, DecoderInputBuffer decoderInputBuffer) {
        boolean z = true;
        if (decoderInputBuffer.isEndOfStream()) {
            this.M = true;
            return;
        }
        b bVar = new b(this.P, decoderInputBuffer.timeUs);
        this.O = bVar;
        this.P++;
        if (!this.M) {
            long jA = bVar.a();
            boolean z2 = jA - 30000 <= j && j <= 30000 + jA;
            b bVar2 = this.N;
            boolean z3 = bVar2 != null && bVar2.a() <= j && j < jA;
            boolean zV0 = v0((b) gg3.q(this.O));
            if (!z2 && !z3 && !zV0) {
                z = false;
            }
            this.M = z;
            if (z3 && !z2) {
                return;
            }
        }
        this.N = this.O;
        this.O = null;
    }

    public final boolean y0() throws zv0 {
        if (!z0()) {
            return false;
        }
        if (!this.Q) {
            return true;
        }
        if (!q0((t41) gg3.q(this.H))) {
            throw P(new hi1("Provided decoder factory can't create decoder for format."), this.H, 4005);
        }
        gi1 gi1Var = this.I;
        if (gi1Var != null) {
            gi1Var.release();
        }
        this.I = this.x.b();
        this.Q = false;
        return true;
    }

    public boolean z0() {
        return true;
    }
}
