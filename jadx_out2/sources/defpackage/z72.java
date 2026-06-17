package defpackage;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.o;
import androidx.media3.exoplayer.p;
import defpackage.od;
import defpackage.pd;
import defpackage.t41;
import defpackage.y72;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;
import net.engio.mbassy.listener.MessageHandler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class z72 extends i82 implements x72 {
    public final Context Q0;
    public final od.a R0;
    public final pd S0;
    public final z22 T0;
    public int U0;
    public boolean V0;
    public boolean W0;
    public t41 X0;
    public t41 Y0;
    public long Z0;
    public boolean a1;
    public boolean b1;
    public boolean c1;
    public boolean d1;
    public int e1;
    public boolean f1;
    public long g1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements pd.d {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void a(long j) {
            z72.this.d1 = true;
            z72.this.R0.z(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void b(pd.a aVar) {
            z72.this.R0.t(aVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void c(pd.a aVar) {
            z72.this.R0.s(aVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void d(Exception exc) {
            xz1.e("MediaCodecAudioRenderer", "Audio sink error", exc);
            z72.this.R0.r(exc);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void e() {
            z72.this.c1 = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void f() {
            o.a aVarF1 = z72.this.f1();
            if (aVarF1 != null) {
                aVarF1.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void g(int i, long j, long j2) {
            z72.this.R0.B(i, j, j2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void h() {
            z72.this.h0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void i() {
            z72.this.A2();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void j() {
            o.a aVarF1 = z72.this.f1();
            if (aVarF1 != null) {
                aVarF1.b();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void onAudioSessionIdChanged(int i) {
            if (Build.VERSION.SDK_INT >= 35 && z72.this.T0 != null) {
                z72.this.T0.e(i);
            }
            z72.this.R0.q(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // pd.d
        public void onSkipSilenceEnabledChanged(boolean z) {
            z72.this.R0.A(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z72(Context context, y72.b bVar, l82 l82Var, boolean z, Handler handler, od odVar, pd pdVar, z22 z22Var) {
        super(context.getApplicationContext(), 1, bVar, l82Var, z, 44100.0f);
        this.Q0 = context.getApplicationContext();
        this.S0 = pdVar;
        this.T0 = z22Var;
        this.e1 = -1000;
        this.R0 = new od.a(handler, odVar);
        this.g1 = -9223372036854775807L;
        pdVar.q(new b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean s2(String str) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean t2(String str) {
        return str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean u2() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int w2(c82 c82Var, t41 t41Var) {
        "OMX.google.raw.decoder".equals(c82Var.a);
        return t41Var.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List y2(l82 l82Var, t41 t41Var, boolean z, pd pdVar) {
        c82 c82VarP;
        return t41Var.p == null ? xi1.u() : (!pdVar.a(t41Var) || (c82VarP = q82.p()) == null) ? q82.m(l82Var, t41Var, z, false) : xi1.w(c82VarP);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void A1(long j) {
        this.S0.r(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A2() {
        this.a1 = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B2(int i) {
        z22 z22Var;
        this.S0.h(i);
        if (Build.VERSION.SDK_INT < 35 || (z22Var = this.T0) == null) {
            return;
        }
        z22Var.e(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void C1() {
        super.C1();
        this.S0.s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C2() {
        y72 y72VarO0 = O0();
        if (y72VarO0 != null && Build.VERSION.SDK_INT >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.e1));
            y72VarO0.b(bundle);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public boolean D() {
        boolean z = this.c1;
        this.c1 = false;
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D2() {
        long jN = this.S0.n(b());
        if (jN != Long.MIN_VALUE) {
            if (!this.a1) {
                jN = Math.max(this.Z0, jN);
            }
            this.Z0 = jN;
            this.a1 = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82, androidx.media3.exoplayer.a, androidx.media3.exoplayer.n.b
    public void F(int i, Object obj) {
        if (i == 2) {
            this.S0.setVolume(((Float) gg3.q(obj)).floatValue());
            return;
        }
        if (i == 3) {
            this.S0.p((yb) gg3.q((yb) obj));
            return;
        }
        if (i == 6) {
            this.S0.v((af) gg3.q((af) obj));
            return;
        }
        if (i == 12) {
            this.S0.setPreferredDevice((AudioDeviceInfo) obj);
            return;
        }
        if (i == 16) {
            this.e1 = ((Integer) gg3.q(obj)).intValue();
            C2();
            return;
        }
        if (i == 9) {
            this.S0.z(((Boolean) gg3.q(obj)).booleanValue());
            return;
        }
        if (i == 10) {
            B2(((Integer) gg3.q(obj)).intValue());
            return;
        }
        if (i == 19) {
            this.S0.w(((Integer) gg3.q(obj)).intValue());
        } else if (i != 20) {
            super.F(i, obj);
        } else {
            this.S0.j((wc) gg3.q(obj));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public boolean F1(long j, long j2, y72 y72Var, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, t41 t41Var) throws zv0 {
        gg3.q(byteBuffer);
        this.g1 = -9223372036854775807L;
        if (this.Y0 != null && (i2 & 2) != 0) {
            ((y72) gg3.q(y72Var)).m(i, false);
            return true;
        }
        if (z) {
            if (y72Var != null) {
                y72Var.m(i, false);
            }
            this.F0.f += i3;
            this.S0.s();
            return true;
        }
        try {
            if (!this.S0.y(byteBuffer, j3, i3)) {
                this.g1 = j3;
                return false;
            }
            if (y72Var != null) {
                y72Var.m(i, false);
            }
            this.F0.e += i3;
            return true;
        } catch (pd.c e) {
            throw Q(e, this.X0, e.g, (!m1() || S().a == 0) ? 5001 : 5004);
        } catch (pd.f e2) {
            throw Q(e2, t41Var, e2.g, (!m1() || S().a == 0) ? 5002 : 5003);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void K1() throws zv0 {
        try {
            this.S0.f();
            if (X0() != -9223372036854775807L) {
                this.g1 = X0();
            }
        } catch (pd.f e) {
            throw Q(e, e.h, e.g, m1() ? 5003 : 5002);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a, androidx.media3.exoplayer.o
    public x72 N() {
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public float S0(float f, t41 t41Var, t41[] t41VarArr) {
        int iMax = -1;
        for (t41 t41Var2 : t41VarArr) {
            int i = t41Var2.I;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public List U0(l82 l82Var, t41 t41Var, boolean z) {
        return q82.n(this.Q0, y2(l82Var, t41Var, z, this.S0), t41Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public long V0(long j, long j2, boolean z) {
        boolean z2 = this.S0.g() && this.g1 != -9223372036854775807L;
        if (!this.f1) {
            return (z2 || super.b()) ? 1000000L : 10000L;
        }
        long jI = this.S0.i();
        if (this.d1 && z2 && jI != -9223372036854775807L) {
            return Math.max(10000L, (long) ((Math.min(jI, this.g1 - j) / (getPlaybackParameters() != null ? getPlaybackParameters().a : 1.0f)) / 2.0f));
        }
        return 10000L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public y72.a a1(c82 c82Var, t41 t41Var, MediaCrypto mediaCrypto, float f) {
        this.U0 = x2(c82Var, t41Var, Y());
        this.V0 = s2(c82Var.a);
        this.W0 = t2(c82Var.a);
        MediaFormat mediaFormatZ2 = z2(t41Var, c82Var.c, this.U0, f);
        this.Y0 = (!"audio/raw".equals(c82Var.b) || "audio/raw".equals(t41Var.p)) ? null : t41Var;
        return y72.a.a(c82Var, mediaFormatZ2, t41Var, mediaCrypto, this.T0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82, androidx.media3.exoplayer.o
    public boolean b() {
        return super.b() && this.S0.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void c0() {
        this.b1 = true;
        this.X0 = null;
        this.g1 = -9223372036854775807L;
        this.d1 = false;
        try {
            this.S0.flush();
            try {
                super.c0();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.c0();
                throw th;
            } finally {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void d0(boolean z, boolean z2) {
        super.d0(z, z2);
        this.R0.x(this.F0);
        boolean z3 = S().b;
        pd pdVar = this.S0;
        if (z3) {
            pdVar.t();
        } else {
            pdVar.o();
        }
        this.S0.d(X());
        this.S0.e(R());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public boolean d2(t41 t41Var) {
        if (S().a != 0) {
            int iV2 = v2(t41Var);
            if ((iV2 & 512) != 0) {
                if (S().a == 2 || (iV2 & 1024) != 0) {
                    return true;
                }
                if (t41Var.K == 0 && t41Var.L == 0) {
                    return true;
                }
            }
        }
        return this.S0.a(t41Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public long e() {
        if (getState() == 2) {
            D2();
        }
        return this.Z0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public int e2(l82 l82Var, t41 t41Var) {
        int iV2;
        boolean z;
        if (!nt2.o(t41Var.p)) {
            return p.C(0);
        }
        boolean z2 = true;
        boolean z3 = t41Var.Q != 0;
        boolean zF2 = i82.f2(t41Var);
        int i = 8;
        if (!zF2 || (z3 && q82.p() == null)) {
            iV2 = 0;
        } else {
            iV2 = v2(t41Var);
            if (this.S0.a(t41Var)) {
                return p.u(4, 8, 32, iV2);
            }
        }
        if ("audio/raw".equals(t41Var.p) && !this.S0.a(t41Var)) {
            return p.C(1);
        }
        if (!this.S0.a(fy4.t0(2, t41Var.H, t41Var.I))) {
            return p.C(1);
        }
        List listY2 = y2(l82Var, t41Var, false, this.S0);
        if (listY2.isEmpty()) {
            return p.C(1);
        }
        if (!zF2) {
            return p.C(2);
        }
        c82 c82Var = (c82) listY2.get(0);
        boolean zQ = c82Var.q(this.Q0, t41Var);
        if (zQ) {
            z = true;
            z2 = zQ;
        } else {
            for (int i2 = 1; i2 < listY2.size(); i2++) {
                c82 c82Var2 = (c82) listY2.get(i2);
                if (c82Var2.q(this.Q0, t41Var)) {
                    z = false;
                    c82Var = c82Var2;
                    break;
                }
            }
            z = true;
            z2 = zQ;
        }
        int i3 = z2 ? 4 : 3;
        if (z2 && c82Var.t(t41Var)) {
            i = 16;
        }
        return p.i(i3, i, 32, c82Var.h ? 64 : 0, z ? 128 : 0, iV2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void f0(long j, boolean z, boolean z2) throws zv0 {
        super.f0(j, z, z2);
        this.S0.flush();
        this.Z0 = j;
        this.g1 = -9223372036854775807L;
        this.c1 = false;
        this.d1 = false;
        this.a1 = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void g0() {
        z22 z22Var;
        this.S0.release();
        if (Build.VERSION.SDK_INT < 35 || (z22Var = this.T0) == null) {
            return;
        }
        z22Var.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void g1(DecoderInputBuffer decoderInputBuffer) {
        t41 t41Var;
        if (Build.VERSION.SDK_INT < 29 || (t41Var = decoderInputBuffer.format) == null || !Objects.equals(t41Var.p, "audio/opus") || !m1()) {
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) gg3.q(decoderInputBuffer.supplementalData);
        int i = ((t41) gg3.q(decoderInputBuffer.format)).K;
        if (byteBuffer.remaining() == 8) {
            this.S0.c(i, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o, androidx.media3.exoplayer.p
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public dc3 getPlaybackParameters() {
        return this.S0.getPlaybackParameters();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void i0() {
        this.c1 = false;
        this.d1 = false;
        this.g1 = -9223372036854775807L;
        try {
            super.i0();
        } finally {
            if (this.b1) {
                this.b1 = false;
                this.S0.reset();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public boolean isReady() {
        return this.S0.g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void j0() {
        super.j0();
        this.S0.play();
        this.f1 = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void k0() {
        D2();
        this.f1 = false;
        this.S0.pause();
        super.k0();
        this.d1 = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public void setPlaybackParameters(dc3 dc3Var) {
        this.S0.setPlaybackParameters(dc3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void u1(Exception exc) {
        xz1.e("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.R0.o(exc);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public lb0 v0(c82 c82Var, t41 t41Var, t41 t41Var2) {
        lb0 lb0VarE = c82Var.e(t41Var, t41Var2);
        int i = lb0VarE.e;
        if (n1(t41Var2)) {
            i |= 32768;
        }
        if (w2(c82Var, t41Var2) > this.U0) {
            i |= 64;
        }
        int i2 = i;
        return new lb0(c82Var.a, t41Var, t41Var2, i2 != 0 ? 0 : lb0VarE.d, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void v1(String str, y72.a aVar, long j, long j2) {
        this.R0.u(str, j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int v2(t41 t41Var) {
        uc ucVarL = this.S0.l(t41Var);
        if (!ucVarL.a) {
            return 0;
        }
        int i = ucVarL.b ? 1536 : 512;
        return ucVarL.c ? i | 2048 : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void w1(androidx.media3.exoplayer.b bVar) {
        this.R0.p(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void x1(String str) {
        this.R0.v(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int x2(c82 c82Var, t41 t41Var, t41[] t41VarArr) {
        int iW2 = w2(c82Var, t41Var);
        if (t41VarArr.length == 1) {
            return iW2;
        }
        for (t41 t41Var2 : t41VarArr) {
            if (c82Var.e(t41Var, t41Var2).d != 0) {
                iW2 = Math.max(iW2, w2(c82Var, t41Var2));
            }
        }
        return iW2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public lb0 y1(u41 u41Var) throws zv0 {
        t41 t41Var = (t41) gg3.q(u41Var.b);
        this.X0 = t41Var;
        lb0 lb0VarY1 = super.y1(u41Var);
        this.R0.y(t41Var, lb0VarY1);
        return lb0VarY1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i82
    public void z1(t41 t41Var, MediaFormat mediaFormat) throws zv0 {
        int i;
        t41 t41Var2 = this.Y0;
        int[] iArrA = null;
        if (t41Var2 != null) {
            t41Var = t41Var2;
        } else if (O0() != null) {
            gg3.q(mediaFormat);
            t41 t41VarQ = new t41.b().A0("audio/raw").t0("audio/raw".equals(t41Var.p) ? t41Var.J : mediaFormat.containsKey("pcm-encoding") ? mediaFormat.getInteger("pcm-encoding") : mediaFormat.containsKey("v-bits-per-sample") ? fy4.r0(mediaFormat.getInteger("v-bits-per-sample")) : 2).e0(t41Var.K).f0(t41Var.L).s0(t41Var.l).a0(t41Var.m).k0(t41Var.a).m0(t41Var.b).n0(t41Var.c).o0(t41Var.d).C0(t41Var.e).y0(t41Var.f).U(mediaFormat.getInteger("channel-count")).B0(mediaFormat.getInteger("sample-rate")).Q();
            if (this.V0 && t41VarQ.H == 6 && (i = t41Var.H) < 6) {
                iArrA = new int[i];
                for (int i2 = 0; i2 < t41Var.H; i2++) {
                    iArrA[i2] = i2;
                }
            } else if (this.W0) {
                iArrA = d85.a(t41VarQ.H);
            }
            t41Var = t41VarQ;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                if (!m1() || S().a == 0) {
                    this.S0.m(0);
                } else {
                    this.S0.m(S().a);
                }
            }
            this.S0.x(t41Var, 0, iArrA);
        } catch (pd.b e) {
            throw P(e, e.f, 5001);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MediaFormat z2(t41 t41Var, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", t41Var.H);
        mediaFormat.setInteger("sample-rate", t41Var.I);
        eg2.e(mediaFormat, t41Var.s);
        eg2.d(mediaFormat, "max-input-size", i);
        mediaFormat.setInteger(MessageHandler.Properties.Priority, 0);
        if (f != -1.0f && !u2()) {
            mediaFormat.setFloat("operating-rate", f);
        }
        if ("audio/ac4".equals(t41Var.p)) {
            Pair pairU = gv.u(t41Var);
            if (pairU != null) {
                eg2.d(mediaFormat, "profile", ((Integer) pairU.first).intValue());
                eg2.d(mediaFormat, "level", ((Integer) pairU.second).intValue());
            }
            if (Build.VERSION.SDK_INT <= 28) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        if (this.S0.k(fy4.t0(4, t41Var.H, t41Var.I)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i2 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.e1));
        }
        if (Objects.equals(t41Var.p, "audio/iamf")) {
            ec ecVarU = this.S0.u();
            if (ecVarU == null) {
                xz1.i("MediaCodecAudioRenderer", "AudioCapabilities from the AudioSink are null, using default stereo output layout.");
                mediaFormat.setInteger("channel-mask", 12);
                mediaFormat.setInteger("max-output-channel-count", 2);
            } else {
                int iB = qh1.b(ecVarU);
                int iBitCount = Integer.bitCount(iB);
                mediaFormat.setInteger("channel-mask", iB);
                mediaFormat.setInteger("max-output-channel-count", iBitCount);
            }
        }
        s0(mediaFormat);
        return mediaFormat;
    }

    public z72(Context context, y72.b bVar, l82 l82Var, boolean z, Handler handler, od odVar, pd pdVar) {
        this(context, bVar, l82Var, z, handler, odVar, pdVar, Build.VERSION.SDK_INT >= 35 ? new z22() : null);
    }
}
