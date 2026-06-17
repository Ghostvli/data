package defpackage;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.o;
import defpackage.jq2;
import defpackage.po0;
import defpackage.q82;
import defpackage.y72;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i82 extends androidx.media3.exoplayer.a {
    public static final byte[] P0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final boolean A;
    public boolean A0;
    public final float B;
    public boolean B0;
    public final DecoderInputBuffer C;
    public boolean C0;
    public final DecoderInputBuffer D;
    public boolean D0;
    public final DecoderInputBuffer E;
    public zv0 E0;
    public final kj F;
    public gb0 F0;
    public final MediaCodec.BufferInfo G;
    public e G0;
    public final ArrayDeque H;
    public long H0;
    public final e53 I;
    public boolean I0;
    public final AtomicInteger J;
    public boolean J0;
    public t41 K;
    public boolean K0;
    public t41 L;
    public long L0;
    public po0 M;
    public androidx.media3.exoplayer.b M0;
    public po0 N;
    public androidx.media3.exoplayer.b N0;
    public o.a O;
    public dj1 O0;
    public MediaCrypto P;
    public long Q;
    public float R;
    public float S;
    public y72 T;
    public t41 U;
    public MediaFormat V;
    public boolean W;
    public float X;
    public ArrayDeque Y;
    public c Z;
    public c82 a0;
    public int b0;
    public boolean c0;
    public boolean d0;
    public boolean e0;
    public boolean f0;
    public boolean g0;
    public long h0;
    public boolean i0;
    public long j0;
    public int k0;
    public int l0;
    public ByteBuffer m0;
    public boolean n0;
    public boolean o0;
    public boolean p0;
    public boolean q0;
    public boolean r0;
    public boolean s0;
    public int t0;
    public int u0;
    public int v0;
    public boolean w0;
    public final Context x;
    public boolean x0;
    public final y72.b y;
    public boolean y0;
    public final l82 z;
    public long z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(y72.a aVar, ie3 ie3Var) {
            LogSessionId logSessionIdA = ie3Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            aVar.b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d implements y72.c {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // y72.c
        public void a() {
            if (i82.this.O != null) {
                i82.this.O.b();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // y72.c
        public void b() {
            if (i82.this.O != null) {
                i82.this.O.b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public static final e f = new e(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);
        public final long a;
        public final long b;
        public final long c;
        public final ko4 d = new ko4();
        public long e = -9223372036854775807L;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i82(Context context, int i, y72.b bVar, l82 l82Var, boolean z, float f) {
        super(i);
        this.x = context.getApplicationContext();
        this.y = bVar;
        this.z = (l82) gg3.q(l82Var);
        this.A = z;
        this.B = f;
        this.J = new AtomicInteger();
        this.C = DecoderInputBuffer.newNoDataInstance();
        this.D = new DecoderInputBuffer(0);
        this.E = new DecoderInputBuffer(2);
        kj kjVar = new kj();
        this.F = kjVar;
        this.G = new MediaCodec.BufferInfo();
        this.R = 1.0f;
        this.S = 1.0f;
        this.Q = -9223372036854775807L;
        this.H = new ArrayDeque();
        this.G0 = e.f;
        kjVar.ensureSpaceForWrite(0);
        kjVar.data.order(ByteOrder.nativeOrder());
        this.I = new e53();
        this.X = -1.0f;
        this.b0 = 0;
        this.t0 = 0;
        this.k0 = -1;
        this.l0 = -1;
        this.j0 = -9223372036854775807L;
        this.z0 = -9223372036854775807L;
        this.H0 = -9223372036854775807L;
        this.h0 = -9223372036854775807L;
        this.u0 = 0;
        this.v0 = 0;
        this.F0 = new gb0();
        this.K0 = false;
        this.L0 = 0L;
        this.O0 = dj1.u();
        androidx.media3.exoplayer.b bVar2 = androidx.media3.exoplayer.b.b;
        this.M0 = bVar2;
        this.N0 = bVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean A0(String str) {
        return Build.VERSION.SDK_INT == 29 && "c2.android.aac.decoder".equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean f2(t41 t41Var) {
        int i = t41Var.Q;
        return i == 0 || i == 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean p1(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean y0(String str) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean z0(c82 c82Var) {
        String str = c82Var.a;
        int i = Build.VERSION.SDK_INT;
        if (i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) {
            return true;
        }
        if (i > 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) {
            return "Amazon".equals(Build.MANUFACTURER) && "AFTS".equals(Build.MODEL) && c82Var.g;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A1(long j) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b82 B0(Throwable th, c82 c82Var) {
        return new b82(th, c82Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B1(long j) {
        this.H0 = j;
        while (!this.H.isEmpty() && j >= ((e) this.H.peek()).a) {
            S1((e) gg3.q((e) this.H.poll()));
            C1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C0() {
        this.p0 = false;
        L1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C1() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean D0() {
        if (this.w0) {
            this.u0 = 1;
            if (this.d0) {
                this.v0 = 3;
                return false;
            }
            this.v0 = 1;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D1(DecoderInputBuffer decoderInputBuffer) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a, androidx.media3.exoplayer.p
    public final int E() {
        return 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E0() throws zv0 {
        if (!this.w0) {
            I1();
        } else {
            this.u0 = 1;
            this.v0 = 3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E1() throws zv0 {
        int i = this.v0;
        if (i == 1) {
            K0();
            return;
        }
        if (i == 2) {
            K0();
            j2();
        } else if (i == 3) {
            I1();
        } else {
            this.B0 = true;
            K1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a, androidx.media3.exoplayer.n.b
    public void F(int i, Object obj) {
        if (i == 11) {
            this.O = (o.a) gg3.q((o.a) obj);
            return;
        }
        if (i != 21) {
            if (i != 22) {
                super.F(i, obj);
                return;
            } else {
                if (Build.VERSION.SDK_INT >= 29) {
                    i2((dj1) gg3.q(obj));
                    return;
                }
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.M0 = (androidx.media3.exoplayer.b) gg3.q(obj);
            y72 y72VarO0 = O0();
            if (y72VarO0 != null) {
                y72VarO0.b(this.M0.f());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean F0() throws zv0 {
        if (this.w0) {
            this.u0 = 1;
            if (this.d0) {
                this.v0 = 3;
                return false;
            }
            this.v0 = 2;
        } else {
            j2();
        }
        return true;
    }

    public abstract boolean F1(long j, long j2, y72 y72Var, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, t41 t41Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean G0(long j, long j2) throws zv0 {
        y72 y72Var = (y72) gg3.q(this.T);
        if (!h1()) {
            int iL = y72Var.l(this.G);
            if (iL < 0) {
                if (iL == -2) {
                    G1();
                    return true;
                }
                if (this.g0 && (this.A0 || this.u0 == 2)) {
                    E1();
                }
                long j3 = this.h0;
                if (j3 != -9223372036854775807L && j3 + 100 < R().a()) {
                    E1();
                }
                return false;
            }
            MediaCodec.BufferInfo bufferInfo = this.G;
            bufferInfo.presentationTimeUs -= this.L0;
            if (this.f0) {
                this.f0 = false;
                y72Var.m(iL, false);
                return true;
            }
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                E1();
                return false;
            }
            this.l0 = iL;
            ByteBuffer byteBufferQ = y72Var.q(iL);
            this.m0 = byteBufferQ;
            if (byteBufferQ != null) {
                byteBufferQ.position(this.G.offset);
                ByteBuffer byteBuffer = this.m0;
                MediaCodec.BufferInfo bufferInfo2 = this.G;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            k2(this.G.presentationTimeUs);
        }
        boolean z = this.K0 || this.G.presentationTimeUs < V();
        this.n0 = z;
        long j4 = this.G0.e;
        boolean z2 = j4 != -9223372036854775807L && j4 <= this.G.presentationTimeUs;
        this.o0 = z2;
        ByteBuffer byteBuffer2 = this.m0;
        int i = this.l0;
        MediaCodec.BufferInfo bufferInfo3 = this.G;
        if (F1(j, j2, y72Var, byteBuffer2, i, bufferInfo3.flags, 1, bufferInfo3.presentationTimeUs, z, z2, (t41) gg3.q(this.L))) {
            B1(this.G.presentationTimeUs);
            boolean z3 = (this.G.flags & 4) != 0;
            if (!z3 && this.x0 && this.o0) {
                this.h0 = R().a();
            }
            Q1();
            if (!z3) {
                return true;
            }
            E1();
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G1() {
        this.y0 = true;
        MediaFormat mediaFormatG = ((y72) gg3.q(this.T)).g();
        if (this.b0 != 0 && mediaFormatG.getInteger("width") == 32 && mediaFormatG.getInteger("height") == 32) {
            this.f0 = true;
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            w0(mediaFormatG);
        }
        this.V = mediaFormatG;
        this.W = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean H0(c82 c82Var, t41 t41Var, po0 po0Var, po0 po0Var2) {
        f50 f50VarH;
        f50 f50VarH2;
        if (po0Var == po0Var2) {
            return false;
        }
        if (po0Var2 != null && po0Var != null && (f50VarH = po0Var2.h()) != null && (f50VarH2 = po0Var.h()) != null && f50VarH.getClass().equals(f50VarH2.getClass())) {
            if (!(f50VarH instanceof v71)) {
                return false;
            }
            if (!po0Var2.a().equals(po0Var.a())) {
                return true;
            }
            UUID uuid = kn.f;
            if (!uuid.equals(po0Var.a()) && !uuid.equals(po0Var2.a())) {
                return !c82Var.g && (po0Var2.getState() == 2 || ((po0Var2.getState() == 3 || po0Var2.getState() == 4) && po0Var2.g((String) gg3.q(t41Var.p))));
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean H1(int i) throws zv0 {
        u41 u41VarT = T();
        this.C.clear();
        int iN0 = n0(u41VarT, this.C, i | 4);
        if (iN0 == -5) {
            y1(u41VarT);
            return true;
        }
        if (iN0 != -4 || !this.C.isEndOfStream()) {
            return false;
        }
        this.A0 = true;
        E1();
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I0() {
        this.J0 = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I1() throws zv0 {
        J1();
        r1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean J0() throws zv0 {
        int i;
        if (this.T == null || (i = this.u0) == 2 || this.A0) {
            return false;
        }
        if (i == 0 && a2()) {
            E0();
        }
        y72 y72Var = (y72) gg3.q(this.T);
        if (this.k0 < 0) {
            int iK = y72Var.k();
            this.k0 = iK;
            if (iK < 0) {
                return false;
            }
            this.D.data = y72Var.o(iK);
            this.D.clear();
        }
        if (this.u0 == 1) {
            if (!this.g0) {
                this.x0 = true;
                y72Var.c(this.k0, 0, 0, 0L, 4);
                P1();
            }
            this.u0 = 2;
            return false;
        }
        if (this.e0) {
            this.e0 = false;
            ByteBuffer byteBuffer = (ByteBuffer) gg3.q(this.D.data);
            byte[] bArr = P0;
            byteBuffer.put(bArr);
            y72Var.c(this.k0, 0, bArr.length, 0L, 0);
            P1();
            this.w0 = true;
            return true;
        }
        if (this.t0 == 1) {
            for (int i2 = 0; i2 < ((t41) gg3.q(this.U)).s.size(); i2++) {
                ((ByteBuffer) gg3.q(this.D.data)).put((byte[]) this.U.s.get(i2));
            }
            this.t0 = 2;
        }
        int iPosition = ((ByteBuffer) gg3.q(this.D.data)).position();
        final u41 u41VarT = T();
        try {
            y72Var.f(new Runnable() { // from class: h82
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    i82 i82Var = this.f;
                    i82Var.J.set(i82Var.n0(u41VarT, i82Var.D, 0));
                }
            });
            int i3 = this.J.get();
            if (i3 == -3) {
                if (j()) {
                    Y0().e = this.z0;
                }
                return false;
            }
            if (i3 == -5) {
                if (this.t0 == 2) {
                    this.D.clear();
                    this.t0 = 1;
                }
                y1(u41VarT);
                return true;
            }
            if (this.D.isEndOfStream()) {
                Y0().e = this.z0;
                if (this.t0 == 2) {
                    this.D.clear();
                    this.t0 = 1;
                }
                this.A0 = true;
                if (!this.w0) {
                    E1();
                    return false;
                }
                if (!this.g0) {
                    this.x0 = true;
                    y72Var.c(this.k0, 0, 0, 0L, 4);
                    P1();
                }
                return false;
            }
            if (!this.w0 && !this.D.isKeyFrame()) {
                this.D.clear();
                if (this.t0 == 2) {
                    this.t0 = 1;
                }
                return true;
            }
            DecoderInputBuffer decoderInputBuffer = this.D;
            long j = decoderInputBuffer.timeUs;
            if (X1(decoderInputBuffer)) {
                return true;
            }
            boolean zIsEncrypted = this.D.isEncrypted();
            if (zIsEncrypted) {
                this.D.cryptoInfo.b(iPosition);
            }
            if (this.C0) {
                Y0().d.a(j, (t41) gg3.q(this.K));
                this.C0 = false;
            }
            this.z0 = Math.max(this.z0, j);
            if (j() || this.D.isLastSample()) {
                Y0().e = this.z0;
            }
            this.D.flip();
            if (this.D.hasSupplementalData()) {
                g1(this.D);
            }
            if (this.K0) {
                long j2 = this.z0;
                if (j <= j2) {
                    this.L0 += (j2 - j) + 1;
                }
                this.z0 = j;
                this.K0 = false;
            }
            D1(this.D);
            int iP0 = P0(this.D);
            long j3 = j + this.L0;
            if (zIsEncrypted) {
                ((y72) gg3.q(y72Var)).a(this.k0, 0, this.D.cryptoInfo, j3, iP0);
            } else {
                ((y72) gg3.q(y72Var)).c(this.k0, 0, ((ByteBuffer) gg3.q(this.D.data)).limit(), j3, iP0);
            }
            P1();
            this.w0 = true;
            this.t0 = 0;
            this.F0.c++;
            return true;
        } catch (DecoderInputBuffer.a e2) {
            u1(e2);
            H1(0);
            K0();
            return true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public void J1() {
        try {
            y72 y72Var = this.T;
            if (y72Var != null) {
                y72Var.release();
                this.F0.b++;
                x1(((c82) gg3.q(this.a0)).a);
            }
            this.T = null;
            try {
                MediaCrypto mediaCrypto = this.P;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.T = null;
            try {
                MediaCrypto mediaCrypto2 = this.P;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K0() {
        try {
            ((y72) gg3.q(this.T)).flush();
        } finally {
            M1();
        }
    }

    public abstract void K1();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean L0() throws zv0 {
        boolean zM0 = M0();
        if (zM0) {
            r1();
        }
        return zM0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L1() {
        O1();
        this.r0 = false;
        this.F.clear();
        this.E.clear();
        this.q0 = false;
        this.I.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean M0() {
        if (this.T == null) {
            return false;
        }
        if (b2()) {
            J1();
            return true;
        }
        if (Y1()) {
            K0();
        } else {
            this.K0 = true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M1() {
        P1();
        Q1();
        O1();
        this.j0 = -9223372036854775807L;
        this.x0 = false;
        this.h0 = -9223372036854775807L;
        this.w0 = false;
        this.e0 = false;
        this.f0 = false;
        this.n0 = false;
        this.o0 = false;
        this.u0 = 0;
        this.v0 = 0;
        this.t0 = this.s0 ? 1 : 0;
        this.K0 = false;
        this.L0 = 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List N0(boolean z) {
        t41 t41Var = (t41) gg3.q(this.K);
        List listU0 = U0(this.z, t41Var, z);
        if (!listU0.isEmpty() || !z) {
            return listU0;
        }
        List listU02 = U0(this.z, t41Var, false);
        if (!listU02.isEmpty()) {
            xz1.i("MediaCodecRenderer", "Drm session requires secure decoder for " + t41Var.p + ", but no secure decoder available. Trying to proceed with " + listU02 + ".");
        }
        return listU02;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N1() {
        M1();
        this.E0 = null;
        this.Y = null;
        this.a0 = null;
        this.U = null;
        this.V = null;
        this.W = false;
        this.y0 = false;
        this.X = -1.0f;
        this.b0 = 0;
        this.c0 = false;
        this.d0 = false;
        this.g0 = false;
        this.i0 = false;
        this.s0 = false;
        this.t0 = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final y72 O0() {
        return this.T;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O1() {
        this.z0 = -9223372036854775807L;
        Y0().e = -9223372036854775807L;
        this.H0 = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int P0(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P1() {
        this.k0 = -1;
        this.D.data = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c82 Q0() {
        return this.a0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q1() {
        this.l0 = -1;
        this.m0 = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final t41 R0() {
        return this.U;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R1(po0 po0Var) {
        po0.b(this.M, po0Var);
        this.M = po0Var;
    }

    public abstract float S0(float f, t41 t41Var, t41[] t41VarArr);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S1(e eVar) {
        this.G0 = eVar;
        long j = eVar.c;
        if (j != -9223372036854775807L) {
            this.I0 = true;
            A1(j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final MediaFormat T0() {
        return this.V;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T1() {
        this.D0 = true;
    }

    public abstract List U0(l82 l82Var, t41 t41Var, boolean z);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void U1(zv0 zv0Var) {
        this.E0 = zv0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long V0(long j, long j2, boolean z) {
        return super.l(j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V1(po0 po0Var) {
        po0.b(this.N, po0Var);
        this.N = po0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long W0() {
        return this.z0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean W1(long j) {
        return this.Q == -9223372036854775807L || R().e() - j < this.Q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long X0() {
        return this.G0.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean X1(DecoderInputBuffer decoderInputBuffer) {
        if (!c2(decoderInputBuffer)) {
            return false;
        }
        decoderInputBuffer.clear();
        this.F0.d++;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final e Y0() {
        return !this.H.isEmpty() ? (e) this.H.getLast() : this.G0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean Y1() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long Z0() {
        return this.H0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean Z1(c82 c82Var) {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.p
    public final int a(t41 t41Var) throws zv0 {
        try {
            return e2(this.z, t41Var);
        } catch (q82.c e2) {
            throw this.P(e2, t41Var, 4002);
        }
    }

    public abstract y72.a a1(c82 c82Var, t41 t41Var, MediaCrypto mediaCrypto, float f);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a2() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public boolean b() {
        return this.B0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long b1() {
        return this.G0.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b2() {
        int i = this.v0;
        if (i == 3 || ((this.c0 && !this.y0) || (this.d0 && this.x0))) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        try {
            j2();
            return false;
        } catch (zv0 e2) {
            xz1.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e2);
            return true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public void c(long j, long j2) throws zv0 {
        boolean z = false;
        if (this.D0) {
            this.D0 = false;
            E1();
        }
        zv0 zv0Var = this.E0;
        if (zv0Var != null) {
            this.E0 = null;
            throw zv0Var;
        }
        try {
            if (this.B0) {
                K1();
                return;
            }
            if (this.K != null || H1(2)) {
                r1();
                if (this.p0) {
                    hq4.a("bypassRender");
                    while (u0(j, j2)) {
                    }
                    hq4.b();
                } else if (this.T != null) {
                    long jE = R().e();
                    hq4.a("drainAndFeed");
                    while (G0(j, j2) && W1(jE)) {
                    }
                    while (J0() && W1(jE)) {
                    }
                    hq4.b();
                } else {
                    this.F0.d += p0(j);
                    H1(1);
                }
                this.F0.c();
            }
        } catch (MediaCodec.CryptoException e2) {
            throw P(e2, this.K, fy4.j0(e2.getErrorCode()));
        } catch (IllegalStateException e3) {
            if (!p1(e3)) {
                throw e3;
            }
            u1(e3);
            if ((e3 instanceof MediaCodec.CodecException) && ((MediaCodec.CodecException) e3).isRecoverable()) {
                z = true;
            }
            if (z) {
                J1();
            }
            b82 b82VarB0 = B0(e3, Q0());
            throw Q(b82VarB0, this.K, z, b82VarB0.h == 1101 ? 4006 : 4003);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void c0() {
        this.K = null;
        S1(e.f);
        this.H.clear();
        if (this.p0) {
            C0();
        } else {
            M0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long c1() {
        return this.G0.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c2(DecoderInputBuffer decoderInputBuffer) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void d0(boolean z, boolean z2) {
        this.F0 = new gb0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float d1() {
        return this.R;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d2(t41 t41Var) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long e1() {
        return this.L0;
    }

    public abstract int e2(l82 l82Var, t41 t41Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void f0(long j, boolean z, boolean z2) throws zv0 {
        if (!this.H.isEmpty()) {
            this.G0 = (e) this.H.getLast();
        }
        this.H.clear();
        if (z2) {
            this.A0 = false;
            this.B0 = false;
            this.D0 = false;
            if (this.p0) {
                L1();
            } else {
                L0();
            }
            if (this.G0.d.l() > 0) {
                this.C0 = true;
            }
            this.G0.d.c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final o.a f1() {
        return this.O;
    }

    public abstract void g1(DecoderInputBuffer decoderInputBuffer);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean g2() {
        return h2(this.U);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h1() {
        return this.l0 >= 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h2(t41 t41Var) throws zv0 {
        if (this.T != null && this.v0 != 3 && getState() != 0) {
            float fS0 = S0(this.S, (t41) gg3.q(t41Var), Y());
            float f = this.X;
            if (f == fS0) {
                return true;
            }
            if (fS0 == -1.0f) {
                E0();
                return false;
            }
            if (f == -1.0f && fS0 <= this.B) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fS0);
            ((y72) gg3.q(this.T)).b(bundle);
            this.X = fS0;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void i0() {
        try {
            C0();
            J1();
        } finally {
            V1(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i1() {
        if (!this.F.l()) {
            return true;
        }
        long jV = V();
        return o1(jV, this.F.j()) == o1(jV, this.E.timeUs);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i2(dj1 dj1Var) {
        if (this.O0.equals(dj1Var)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            HashSet hashSet = new HashSet(dj1Var);
            HashSet hashSet2 = new HashSet();
            pw4 it = this.O0.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!hashSet.remove(str)) {
                    hashSet2.add(str);
                }
            }
            y72 y72VarO0 = O0();
            if (y72VarO0 != null) {
                if (!hashSet2.isEmpty()) {
                    y72VarO0.i(new ArrayList(hashSet2));
                }
                if (!hashSet.isEmpty()) {
                    y72VarO0.e(new ArrayList(hashSet));
                }
            }
        }
        this.O0 = dj1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void j0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j1(t41 t41Var) {
        C0();
        String str = t41Var.p;
        if ("audio/mp4a-latm".equals(str) || DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG.equals(str) || "audio/opus".equals(str)) {
            this.F.m(32);
        } else {
            this.F.m(1);
        }
        this.p0 = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j2() throws zv0 {
        f50 f50VarH = ((po0) gg3.q(this.N)).h();
        if (f50VarH instanceof v71) {
            try {
                ((MediaCrypto) gg3.q(this.P)).setMediaDrmSession(((v71) f50VarH).b);
            } catch (MediaCryptoException e2) {
                throw P(e2, this.K, 6006);
            }
        }
        R1(this.N);
        this.u0 = 0;
        this.v0 = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void k0() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k1(c82 c82Var, MediaCrypto mediaCrypto) {
        this.a0 = c82Var;
        t41 t41Var = (t41) gg3.q(this.K);
        String str = c82Var.a;
        float fS0 = S0(this.S, t41Var, Y());
        if (fS0 <= this.B) {
            fS0 = -1.0f;
        }
        long jE = R().e();
        y72.a aVarA1 = a1(c82Var, t41Var, mediaCrypto, fS0);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            b.a(aVarA1, X());
        }
        try {
            hq4.a("createCodec:" + str);
            y72 y72VarA = this.y.a(aVarA1);
            this.T = y72VarA;
            this.i0 = y72VarA.r(new d());
            hq4.b();
            long jE2 = R().e();
            if (!c82Var.q(this.x, t41Var)) {
                xz1.i("MediaCodecRenderer", fy4.M("Format exceeds selected codec's capabilities [%s, %s]", t41.l(t41Var), str));
            }
            this.X = fS0;
            this.U = t41Var;
            this.b0 = x0(str);
            this.c0 = A0(str);
            this.d0 = y0(str);
            this.g0 = z0(c82Var);
            if (((y72) gg3.q(this.T)).d()) {
                this.s0 = true;
                this.t0 = 1;
                this.e0 = this.b0 != 0;
            }
            if (getState() == 2) {
                this.j0 = R().e() + 1000;
            }
            this.F0.a++;
            long j = jE2 - jE;
            if (i >= 31 && !this.O0.isEmpty()) {
                ((y72) gg3.q(O0())).e(new ArrayList(this.O0));
            }
            v1(str, aVarA1, jE2, j);
        } catch (Throwable th) {
            hq4.b();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k2(long j) {
        t41 t41Var = (t41) this.G0.d.j(j);
        if (t41Var == null && this.I0 && this.V != null) {
            t41Var = (t41) this.G0.d.i();
        }
        if (t41Var != null) {
            this.L = t41Var;
        } else if (!this.W || this.L == null) {
            return;
        }
        z1((t41) gg3.q(this.L), this.V);
        this.W = false;
        this.I0 = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public final long l(long j, long j2) {
        return V0(j, j2, this.i0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // androidx.media3.exoplayer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l0(t41[] t41VarArr, long j, long j2, jq2.b bVar) {
        if (this.G0.c == -9223372036854775807L) {
            S1(new e(-9223372036854775807L, j, j2));
            if (this.J0) {
                C1();
                return;
            }
            return;
        }
        if (this.H.isEmpty()) {
            long j3 = this.z0;
            if (j3 != -9223372036854775807L) {
                long j4 = this.H0;
                if (j4 != -9223372036854775807L) {
                }
            }
            S1(new e(-9223372036854775807L, j, j2));
            if (this.G0.c != -9223372036854775807L) {
                C1();
                return;
            }
            return;
        }
        this.H.add(new e(this.z0, j, j2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l1() throws zv0 {
        gg3.v(this.P == null);
        po0 po0Var = this.M;
        f50 f50VarH = po0Var.h();
        if (v71.d && (f50VarH instanceof v71)) {
            int state = po0Var.getState();
            if (state == 1) {
                po0.a aVar = (po0.a) gg3.q(po0Var.getError());
                throw P(aVar, this.K, aVar.f);
            }
            if (state != 4) {
                return false;
            }
        }
        if (f50VarH == null) {
            return po0Var.getError() != null;
        }
        if (f50VarH instanceof v71) {
            v71 v71Var = (v71) f50VarH;
            try {
                this.P = new MediaCrypto(v71Var.a, v71Var.b);
            } catch (MediaCryptoException e2) {
                throw P(e2, this.K, 6006);
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m1() {
        return this.p0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n1(t41 t41Var) {
        return this.N == null && d2(t41Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o1(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        t41 t41Var = this.L;
        return (t41Var != null && Objects.equals(t41Var.p, "audio/opus") && w63.g(j, j2)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean q1() {
        if (this.K == null) {
            return false;
        }
        if (b0() || h1()) {
            return true;
        }
        return this.j0 != -9223372036854775807L && R().e() < this.j0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r1() throws zv0 {
        t41 t41Var;
        boolean z;
        if (this.T != null || this.p0 || (t41Var = this.K) == null) {
            return;
        }
        if (n1(t41Var)) {
            j1(t41Var);
            return;
        }
        R1(this.N);
        if (this.M == null || l1()) {
            try {
                po0 po0Var = this.M;
                if (po0Var == null || !(po0Var.getState() == 3 || this.M.getState() == 4)) {
                    z = false;
                    s1(this.P, z);
                } else {
                    if (this.M.g((String) gg3.q(t41Var.p))) {
                        z = true;
                    }
                    s1(this.P, z);
                }
            } catch (c e2) {
                throw P(e2, t41Var, 4001);
            }
        }
        MediaCrypto mediaCrypto = this.P;
        if (mediaCrypto == null || this.T != null) {
            return;
        }
        mediaCrypto.release();
        this.P = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s0(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.M0.b(mediaFormat);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s1(MediaCrypto mediaCrypto, boolean z) throws c {
        t41 t41Var = (t41) gg3.q(this.K);
        if (this.Y == null) {
            try {
                List listN0 = N0(z);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.Y = arrayDeque;
                if (this.A) {
                    arrayDeque.addAll(listN0);
                } else if (!listN0.isEmpty()) {
                    this.Y.add((c82) listN0.get(0));
                }
                this.Z = null;
            } catch (q82.c e2) {
                throw new c(t41Var, e2, z, -49998);
            }
        }
        if (this.Y.isEmpty()) {
            throw new c(t41Var, (Throwable) null, z, -49999);
        }
        ArrayDeque arrayDeque2 = (ArrayDeque) gg3.q(this.Y);
        while (this.T == null) {
            c82 c82Var = (c82) gg3.q((c82) arrayDeque2.peekFirst());
            if (!t1(t41Var) || !Z1(c82Var)) {
                return;
            }
            try {
                k1(c82Var, mediaCrypto);
            } catch (Exception e3) {
                xz1.j("MediaCodecRenderer", "Failed to initialize decoder: " + c82Var, e3);
                arrayDeque2.removeFirst();
                c cVar = new c(t41Var, e3, z, c82Var);
                u1(cVar);
                if (this.Z == null) {
                    this.Z = cVar;
                } else {
                    this.Z = this.Z.c(cVar);
                }
                if (arrayDeque2.isEmpty()) {
                    throw this.Z;
                }
            }
        }
        this.Y = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t0() throws zv0 {
        gg3.v(!this.A0);
        u41 u41VarT = T();
        this.E.clear();
        do {
            this.E.clear();
            int iN0 = n0(u41VarT, this.E, 0);
            if (iN0 == -5) {
                y1(u41VarT);
                return;
            }
            if (iN0 == -4) {
                if (!this.E.isEndOfStream()) {
                    this.z0 = Math.max(this.z0, this.E.timeUs);
                    if (j() || this.D.isLastSample()) {
                        Y0().e = this.z0;
                    }
                    if (this.C0) {
                        t41 t41Var = (t41) gg3.q(this.K);
                        this.L = t41Var;
                        if (Objects.equals(t41Var.p, "audio/opus") && !this.L.s.isEmpty()) {
                            this.L = this.L.b().e0(w63.f((byte[]) this.L.s.get(0))).Q();
                        }
                        z1(this.L, null);
                        this.C0 = false;
                    }
                    this.E.flip();
                    t41 t41Var2 = this.L;
                    if (t41Var2 != null && Objects.equals(t41Var2.p, "audio/opus")) {
                        if (this.E.hasSupplementalData()) {
                            DecoderInputBuffer decoderInputBuffer = this.E;
                            decoderInputBuffer.format = this.L;
                            g1(decoderInputBuffer);
                        }
                        if (w63.g(V(), this.E.timeUs)) {
                            this.I.a(this.E, this.L.s);
                        }
                    }
                    if (!i1()) {
                        break;
                    }
                } else {
                    this.A0 = true;
                    Y0().e = this.z0;
                    return;
                }
            } else if (iN0 != -3) {
                z20.a();
                return;
            } else {
                if (j()) {
                    Y0().e = this.z0;
                    return;
                }
                return;
            }
        } while (this.F.g(this.E));
        this.q0 = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean t1(t41 t41Var) {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean u0(long j, long j2) throws zv0 {
        boolean z;
        gg3.v(!this.B0);
        if (this.F.l()) {
            kj kjVar = this.F;
            z = false;
            if (!F1(j, j2, null, kjVar.data, this.l0, 0, kjVar.k(), this.F.i(), o1(V(), this.F.j()), this.F.isEndOfStream(), (t41) gg3.q(this.L))) {
                return false;
            }
            B1(this.F.j());
            this.F.clear();
        } else {
            z = false;
        }
        if (this.A0) {
            this.B0 = true;
            return z;
        }
        if (this.q0) {
            gg3.v(this.F.g(this.E));
            this.q0 = z;
        }
        if (this.r0) {
            if (this.F.l()) {
                return true;
            }
            C0();
            this.r0 = z;
            r1();
            if (!this.p0) {
                return z;
            }
        }
        t0();
        if (this.F.l()) {
            this.F.flip();
        }
        if (this.F.l() || this.A0 || this.r0) {
            return true;
        }
        return z;
    }

    public abstract void u1(Exception exc);

    public abstract lb0 v0(c82 c82Var, t41 t41Var, t41 t41Var2);

    public abstract void v1(String str, y72.a aVar, long j, long j2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w0(MediaFormat mediaFormat) {
        if (this.O0.isEmpty()) {
            return;
        }
        androidx.media3.exoplayer.b bVarA = androidx.media3.exoplayer.b.d(mediaFormat, this.O0).a();
        if (bVarA.equals(this.N0)) {
            return;
        }
        this.N0 = bVarA;
        w1(bVarA);
    }

    public abstract void w1(androidx.media3.exoplayer.b bVar);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int x0(String str) {
        if (Build.VERSION.SDK_INT > 25 || !"OMX.Exynos.avc.dec.secure".equals(str)) {
            return 0;
        }
        String str2 = Build.MODEL;
        return (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) ? 2 : 0;
    }

    public abstract void x1(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public lb0 y1(u41 u41Var) throws zv0 {
        int i;
        boolean z = true;
        this.C0 = true;
        t41 t41VarQ = (t41) gg3.q(u41Var.b);
        String str = t41VarQ.p;
        if (str == null) {
            throw P(new IllegalArgumentException("Sample MIME type is null."), t41VarQ, 4005);
        }
        if ((Objects.equals(str, "video/av01") || Objects.equals(t41VarQ.p, "video/x-vnd.on2.vp9") || (Objects.equals(t41VarQ.p, "video/dolby-vision") && Objects.equals(q82.g(t41VarQ), "video/av01"))) && !t41VarQ.s.isEmpty()) {
            t41VarQ = t41VarQ.b().l0(null).Q();
        }
        t41 t41Var = t41VarQ;
        V1(u41Var.a);
        this.K = t41Var;
        if (this.p0) {
            this.r0 = true;
            return null;
        }
        y72 y72Var = this.T;
        if (y72Var == null) {
            this.Y = null;
            r1();
            return null;
        }
        c82 c82Var = (c82) gg3.q(this.a0);
        t41 t41Var2 = (t41) gg3.q(this.U);
        if (H0(c82Var, t41Var, this.M, this.N)) {
            E0();
            return new lb0(c82Var.a, t41Var2, t41Var, 0, 128);
        }
        boolean z2 = this.N != this.M;
        lb0 lb0VarV0 = v0(c82Var, t41Var2, t41Var);
        int i2 = lb0VarV0.d;
        if (i2 != 0) {
            i = 16;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        z20.a();
                        return null;
                    }
                    if (h2(t41Var)) {
                        this.U = t41Var;
                        if (z2 && !F0()) {
                            i = 2;
                        }
                    }
                } else if (h2(t41Var)) {
                    this.s0 = true;
                    this.t0 = 1;
                    int i3 = this.b0;
                    if (i3 != 2 && (i3 != 1 || t41Var.w != t41Var2.w || t41Var.x != t41Var2.x)) {
                        z = false;
                    }
                    this.e0 = z;
                    this.U = t41Var;
                    if (!z2 || F0()) {
                    }
                }
            } else if (h2(t41Var)) {
                this.U = t41Var;
                if (!z2 ? D0() : F0()) {
                }
            }
            return (lb0VarV0.d != 0 || (this.T == y72Var && this.v0 != 3)) ? lb0VarV0 : new lb0(c82Var.a, t41Var2, t41Var, 0, i);
        }
        E0();
        i = 0;
        if (lb0VarV0.d != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public void z(float f, float f2) throws zv0 {
        this.R = f;
        this.S = f2;
        h2(this.U);
    }

    public abstract void z1(t41 t41Var, MediaFormat mediaFormat);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends Exception {
        public final String f;
        public final boolean g;
        public final c82 h;
        public final String i;
        public final c j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(t41 t41Var, Throwable th, boolean z, c82 c82Var) {
            this("Decoder init failed: " + c82Var.a + ", " + t41Var, th, t41Var.p, z, c82Var, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static String b(int i) {
            return "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final c c(c cVar) {
            return new c(getMessage(), getCause(), this.f, this.g, this.h, this.i, cVar);
        }

        public c(t41 t41Var, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + t41Var, th, t41Var.p, z, null, b(i), null);
        }

        public c(String str, Throwable th, String str2, boolean z, c82 c82Var, String str3, c cVar) {
            super(str, th);
            this.f = str2;
            this.g = z;
            this.h = c82Var;
            this.i = str3;
            this.j = cVar;
        }
    }
}
