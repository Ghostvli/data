package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.a;
import androidx.media3.exoplayer.p;
import defpackage.jq2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vm4 extends a implements Handler.Callback {
    public final bi4 A;
    public boolean B;
    public int C;
    public zh4 D;
    public gi4 E;
    public hi4 F;
    public hi4 G;
    public int H;
    public final Handler I;
    public final tm4 J;
    public final u41 K;
    public boolean L;
    public boolean M;
    public t41 N;
    public long O;
    public long P;
    public boolean Q;
    public final q50 x;
    public final DecoderInputBuffer y;
    public x50 z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vm4(tm4 tm4Var, Looper looper, bi4 bi4Var) {
        super(3);
        this.J = (tm4) gg3.q(tm4Var);
        this.I = looper == null ? null : fy4.D(looper, this);
        this.A = bi4Var;
        this.x = new q50();
        this.y = new DecoderInputBuffer(1);
        this.K = new u41();
        this.P = -9223372036854775807L;
        this.O = -9223372036854775807L;
        this.Q = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private long u0(long j) {
        gg3.v(j != -9223372036854775807L);
        return j - Z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean w0(yh4 yh4Var, long j) {
        return yh4Var != null && yh4Var.f() > 0 && yh4Var.b(yh4Var.f() - 1) > j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean z0(t41 t41Var) {
        return Objects.equals(t41Var.p, "application/x-media3-cues");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean A0(long j) {
        if (this.L || n0(this.K, this.y, 0) != -4) {
            return false;
        }
        if (this.y.isEndOfStream()) {
            this.L = true;
            return false;
        }
        this.y.flip();
        ByteBuffer byteBuffer = (ByteBuffer) gg3.q(this.y.data);
        y50 y50VarA = this.x.a(this.y.timeUs, byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.y.clear();
        return this.z.b(y50VarA, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B0() {
        this.E = null;
        this.H = -1;
        hi4 hi4Var = this.F;
        if (hi4Var != null) {
            hi4Var.release();
            this.F = null;
        }
        hi4 hi4Var2 = this.G;
        if (hi4Var2 != null) {
            hi4Var2.release();
            this.G = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C0() {
        B0();
        ((zh4) gg3.q(this.D)).release();
        this.D = null;
        this.C = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D0(long j) {
        boolean zA0 = A0(j);
        long jA = this.z.a(this.O);
        if (jA == Long.MIN_VALUE && this.L && !zA0) {
            this.M = true;
        }
        if (jA != Long.MIN_VALUE && jA <= j) {
            zA0 = true;
        }
        if (zA0) {
            xi1 xi1VarC = this.z.c(j);
            long jD = this.z.d(j);
            H0(new w50(xi1VarC, u0(jD)));
            this.z.e(jD);
        }
        this.O = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E0(long j) {
        boolean z;
        this.O = j;
        if (this.G == null) {
            ((zh4) gg3.q(this.D)).c(j);
            try {
                this.G = (hi4) ((zh4) gg3.q(this.D)).a();
            } catch (ai4 e) {
                v0(e);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.F != null) {
            long jT0 = t0();
            z = false;
            while (jT0 <= j) {
                this.H++;
                jT0 = t0();
                z = true;
            }
        } else {
            z = false;
        }
        hi4 hi4Var = this.G;
        if (hi4Var != null) {
            if (hi4Var.isEndOfStream()) {
                if (!z && t0() == Long.MAX_VALUE) {
                    if (this.C == 2) {
                        F0();
                    } else {
                        B0();
                        this.M = true;
                    }
                }
            } else if (hi4Var.timeUs <= j) {
                hi4 hi4Var2 = this.F;
                if (hi4Var2 != null) {
                    hi4Var2.release();
                }
                this.H = hi4Var.a(j);
                this.F = hi4Var;
                this.G = null;
                z = true;
            }
        }
        if (z) {
            gg3.q(this.F);
            H0(new w50(this.F.e(j), u0(s0(j))));
        }
        if (this.C == 2) {
            return;
        }
        while (!this.L) {
            try {
                gi4 gi4Var = this.E;
                if (gi4Var == null) {
                    gi4Var = (gi4) ((zh4) gg3.q(this.D)).d();
                    if (gi4Var == null) {
                        return;
                    } else {
                        this.E = gi4Var;
                    }
                }
                if (this.C == 1) {
                    gi4Var.setFlags(4);
                    ((zh4) gg3.q(this.D)).f(gi4Var);
                    this.E = null;
                    this.C = 2;
                    return;
                }
                int iN0 = n0(this.K, gi4Var, 0);
                if (iN0 == -4) {
                    if (gi4Var.isEndOfStream()) {
                        this.L = true;
                        this.B = false;
                    } else {
                        t41 t41Var = this.K.b;
                        if (t41Var == null) {
                            return;
                        }
                        gi4Var.f = t41Var.u;
                        gi4Var.flip();
                        this.B &= !gi4Var.isKeyFrame();
                    }
                    if (!this.B) {
                        ((zh4) gg3.q(this.D)).f(gi4Var);
                        this.E = null;
                    }
                } else if (iN0 == -3) {
                    return;
                }
            } catch (ai4 e2) {
                v0(e2);
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F0() {
        C0();
        x0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G0(long j) {
        gg3.v(L());
        this.P = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H0(w50 w50Var) {
        Handler handler = this.I;
        if (handler != null) {
            handler.obtainMessage(1, w50Var).sendToTarget();
        } else {
            y0(w50Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.p
    public int a(t41 t41Var) {
        if (z0(t41Var) || this.A.a(t41Var)) {
            return p.C(t41Var.Q == 0 ? 4 : 2);
        }
        return nt2.s(t41Var.p) ? p.C(1) : p.C(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public boolean b() {
        return this.M;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public void c(long j, long j2) {
        if (L()) {
            long j3 = this.P;
            if (j3 != -9223372036854775807L && j >= j3) {
                B0();
                this.M = true;
            }
        }
        if (this.M) {
            return;
        }
        if (z0((t41) gg3.q(this.N))) {
            gg3.q(this.z);
            D0(j);
        } else {
            q0();
            E0(j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void c0() {
        this.N = null;
        this.P = -9223372036854775807L;
        r0();
        this.O = -9223372036854775807L;
        if (this.D != null) {
            C0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void f0(long j, boolean z, boolean z2) {
        this.O = j;
        x50 x50Var = this.z;
        if (x50Var != null) {
            x50Var.clear();
        }
        r0();
        this.L = false;
        this.M = false;
        this.P = -9223372036854775807L;
        t41 t41Var = this.N;
        if (t41Var == null || z0(t41Var)) {
            return;
        }
        if (this.C != 0) {
            F0();
            return;
        }
        B0();
        zh4 zh4Var = (zh4) gg3.q(this.D);
        zh4Var.flush();
        zh4Var.b(V());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o, androidx.media3.exoplayer.p
    public String getName() {
        return "TextRenderer";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            y0((w50) message.obj);
            return true;
        }
        z20.a();
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public boolean isReady() {
        t41 t41Var = this.N;
        if (t41Var == null) {
            return true;
        }
        if (!z0((t41) gg3.q(t41Var))) {
            return !this.M && (!this.L || w0(this.F, this.O) || w0(this.G, this.O) || this.E == null);
        }
        if (((x50) gg3.q(this.z)).a(this.O) != Long.MIN_VALUE) {
            return true;
        }
        try {
            H();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void l0(t41[] t41VarArr, long j, long j2, jq2.b bVar) {
        t41 t41Var = t41VarArr[0];
        this.N = t41Var;
        if (z0(t41Var)) {
            this.z = this.N.N == 1 ? new ks2() : new rq3();
            return;
        }
        q0();
        if (this.D != null) {
            this.C = 1;
        } else {
            x0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q0() {
        gg3.B(this.Q || Objects.equals(this.N.p, "application/cea-608") || Objects.equals(this.N.p, "application/x-mp4-cea-608") || Objects.equals(this.N.p, "application/cea-708"), "Legacy decoding is disabled, can't handle %s samples (expected %s).", this.N.p, "application/x-media3-cues");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r0() {
        H0(new w50(xi1.u(), u0(this.O)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long s0(long j) {
        int iA = this.F.a(j);
        if (iA == 0 || this.F.f() == 0) {
            return this.F.timeUs;
        }
        hi4 hi4Var = this.F;
        return iA == -1 ? hi4Var.b(hi4Var.f() - 1) : hi4Var.b(iA - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long t0() {
        if (this.H == -1) {
            return Long.MAX_VALUE;
        }
        gg3.q(this.F);
        if (this.H >= this.F.f()) {
            return Long.MAX_VALUE;
        }
        return this.F.b(this.H);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v0(ai4 ai4Var) {
        xz1.e("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.N, ai4Var);
        r0();
        F0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x0() {
        this.B = true;
        zh4 zh4VarB = this.A.b((t41) gg3.q(this.N));
        this.D = zh4VarB;
        zh4VarB.b(V());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y0(w50 w50Var) {
        this.J.onCues(w50Var.a);
        this.J.onCues(w50Var);
    }

    public vm4(tm4 tm4Var, Looper looper) {
        this(tm4Var, looper, bi4.a);
    }
}
