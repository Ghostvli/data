package defpackage;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import defpackage.bd3;
import defpackage.fg2;
import defpackage.gf0;
import defpackage.h01;
import defpackage.hd3;
import defpackage.i82;
import defpackage.jq2;
import defpackage.no4;
import defpackage.p5;
import defpackage.pd;
import defpackage.po0;
import defpackage.uv4;
import defpackage.xr4;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class di2 implements p5, bd3.a {
    public int A;
    public boolean B;
    public final Context a;
    public final bd3 c;
    public final PlaybackSession d;
    public String j;
    public PlaybackMetrics.Builder k;
    public int l;
    public ac3 o;
    public b p;
    public b q;
    public b r;
    public t41 s;
    public t41 t;
    public t41 u;
    public boolean v;
    public int w;
    public boolean x;
    public int y;
    public int z;
    public final Executor b = sf.a();
    public final no4.d f = new no4.d();
    public final no4.b g = new no4.b();
    public final HashMap i = new HashMap();
    public final HashMap h = new HashMap();
    public final long e = SystemClock.elapsedRealtime();
    public int m = 0;
    public int n = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final t41 a;
        public final int b;
        public final String c;

        public b(t41 t41Var, int i, String str) {
            this.a = t41Var;
            this.b = i;
            this.c = str;
        }
    }

    public di2(Context context, PlaybackSession playbackSession) {
        this.a = context.getApplicationContext();
        this.d = playbackSession;
        bh0 bh0Var = new bh0();
        this.c = bh0Var;
        bh0Var.g(this);
    }

    public static di2 L0(Context context) {
        MediaMetricsManager mediaMetricsManagerA = xh2.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new di2(context, mediaMetricsManagerA.createPlaybackSession());
    }

    public static int N0(int i) {
        switch (fy4.j0(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    public static oo0 O0(xi1 xi1Var) {
        oo0 oo0Var;
        pw4 it = xi1Var.iterator();
        while (it.hasNext()) {
            xr4.a aVar = (xr4.a) it.next();
            for (int i = 0; i < aVar.a; i++) {
                if (aVar.h(i) && (oo0Var = aVar.d(i).t) != null) {
                    return oo0Var;
                }
            }
        }
        return null;
    }

    public static int P0(oo0 oo0Var) {
        for (int i = 0; i < oo0Var.i; i++) {
            UUID uuid = oo0Var.v(i).g;
            if (uuid.equals(kn.e)) {
                return 3;
            }
            if (uuid.equals(kn.f)) {
                return 2;
            }
            if (uuid.equals(kn.d)) {
                return 6;
            }
        }
        return 1;
    }

    public static a Q0(ac3 ac3Var, Context context, boolean z) {
        int i;
        boolean z2;
        if (ac3Var.f == 1001) {
            return new a(20, 0);
        }
        if (ac3Var instanceof zv0) {
            zv0 zv0Var = (zv0) ac3Var;
            z2 = zv0Var.o == 1;
            i = zv0Var.s;
        } else {
            i = 0;
            z2 = false;
        }
        Throwable th = (Throwable) gg3.q(ac3Var.getCause());
        if (!(th instanceof IOException)) {
            if (z2 && (i == 0 || i == 1)) {
                return new a(35, 0);
            }
            if (z2 && i == 3) {
                return new a(15, 0);
            }
            if (z2 && i == 2) {
                return new a(23, 0);
            }
            if (th instanceof i82.c) {
                return new a(13, fy4.k0(((i82.c) th).i));
            }
            if (th instanceof b82) {
                return new a(14, ((b82) th).h);
            }
            if (th instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (th instanceof pd.c) {
                return new a(17, ((pd.c) th).f);
            }
            if (th instanceof pd.f) {
                return new a(18, ((pd.f) th).f);
            }
            if (!(th instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new a(N0(errorCode), errorCode);
        }
        if (th instanceof og1) {
            return new a(5, ((og1) th).i);
        }
        if ((th instanceof ng1) || (th instanceof r83)) {
            return new a(z ? 10 : 11, 0);
        }
        boolean z3 = th instanceof mg1;
        if (z3 || (th instanceof uv4.a)) {
            if (u23.e(context).g() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : (z3 && ((mg1) th).h == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (ac3Var.f == 1002) {
            return new a(21, 0);
        }
        if (th instanceof po0.a) {
            Throwable th2 = (Throwable) gg3.q(th.getCause());
            if (!(th2 instanceof MediaDrm.MediaDrmStateException)) {
                return th2 instanceof MediaDrmResetException ? new a(27, 0) : th2 instanceof NotProvisionedException ? new a(24, 0) : th2 instanceof DeniedByServerException ? new a(29, 0) : th2 instanceof zw4 ? new a(23, 0) : th2 instanceof gf0.e ? new a(28, 0) : new a(30, 0);
            }
            int iK0 = fy4.k0(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
            return new a(N0(iK0), iK0);
        }
        if (!(th instanceof h01.b) || !(th.getCause() instanceof FileNotFoundException)) {
            return new a(9, 0);
        }
        Throwable cause2 = ((Throwable) gg3.q(th.getCause())).getCause();
        return ((cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
    }

    public static Pair R0(String str) {
        String[] strArrG1 = fy4.G1(str, "-");
        return Pair.create(strArrG1[0], strArrG1.length >= 2 ? strArrG1[1] : null);
    }

    public static int T0(Context context) {
        switch (u23.e(context).g()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    public static int U0(fg2 fg2Var) {
        fg2.h hVar = fg2Var.b;
        if (hVar == null) {
            return 0;
        }
        int iL0 = fy4.L0(hVar.a, hVar.b);
        if (iL0 == 0) {
            return 3;
        }
        if (iL0 != 1) {
            return iL0 != 2 ? 1 : 4;
        }
        return 5;
    }

    public static int V0(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 1 : 4;
        }
        return 3;
    }

    @Override // defpackage.p5
    public void D0(p5.a aVar, ac3 ac3Var) {
        this.o = ac3Var;
    }

    @Override // defpackage.p5
    public void E0(hd3 hd3Var, p5.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        W0(bVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c1(hd3Var, bVar);
        Y0(jElapsedRealtime);
        a1(hd3Var, bVar, jElapsedRealtime);
        X0(jElapsedRealtime);
        Z0(hd3Var, bVar, jElapsedRealtime);
        if (bVar.a(1028)) {
            this.c.d(bVar.c(1028));
        }
    }

    @Override // bd3.a
    public void F(p5.a aVar, String str) {
        jq2.b bVar = aVar.d;
        if (bVar == null || !bVar.c()) {
            M0();
            this.j = str;
            this.k = th2.a().setPlayerName("AndroidXMedia3").setPlayerVersion("1.10.0");
            e1(aVar.b, aVar.d);
        }
    }

    @Override // defpackage.p5
    public void J(p5.a aVar, e35 e35Var) {
        b bVar = this.p;
        if (bVar != null) {
            t41 t41Var = bVar.a;
            if (t41Var.x == -1) {
                this.p = new b(t41Var.b().H0(e35Var.a).i0(e35Var.b).Q(), bVar.b, bVar.c);
            }
        }
    }

    public final boolean K0(b bVar) {
        return bVar != null && bVar.c.equals(this.c.a());
    }

    public final void M0() {
        PlaybackMetrics.Builder builder = this.k;
        if (builder != null && this.B) {
            builder.setAudioUnderrunCount(this.A);
            this.k.setVideoFramesDropped(this.y);
            this.k.setVideoFramesPlayed(this.z);
            Long l = (Long) this.h.get(this.j);
            this.k.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.i.get(this.j);
            this.k.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.k.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.k.build();
            this.b.execute(new Runnable() { // from class: yh2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.d.reportPlaybackMetrics(playbackMetricsBuild);
                }
            });
        }
        this.k = null;
        this.j = null;
        this.A = 0;
        this.y = 0;
        this.z = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.B = false;
    }

    public LogSessionId S0() {
        return this.d.getSessionId();
    }

    public final void W0(p5.b bVar) {
        for (int i = 0; i < bVar.d(); i++) {
            int iB = bVar.b(i);
            p5.a aVarC = bVar.c(iB);
            if (iB == 0) {
                this.c.e(aVarC);
            } else {
                bd3 bd3Var = this.c;
                if (iB == 11) {
                    bd3Var.c(aVarC, this.l);
                } else {
                    bd3Var.f(aVarC);
                }
            }
        }
    }

    @Override // bd3.a
    public void X(p5.a aVar, String str, String str2) {
    }

    public final void X0(long j) {
        int iT0 = T0(this.a);
        if (iT0 != this.n) {
            this.n = iT0;
            final NetworkEvent networkEventBuild = sh2.a().setNetworkType(iT0).setTimeSinceCreatedMillis(j - this.e).build();
            this.b.execute(new Runnable() { // from class: bi2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.d.reportNetworkEvent(networkEventBuild);
                }
            });
        }
    }

    public final void Y0(long j) {
        ac3 ac3Var = this.o;
        if (ac3Var == null) {
            return;
        }
        a aVarQ0 = Q0(ac3Var, this.a, this.w == 4);
        final PlaybackErrorEvent playbackErrorEventBuild = uh2.a().setTimeSinceCreatedMillis(j - this.e).setErrorCode(aVarQ0.a).setSubErrorCode(aVarQ0.b).setException(ac3Var).build();
        this.b.execute(new Runnable() { // from class: ci2
            @Override // java.lang.Runnable
            public final void run() {
                this.f.d.reportPlaybackErrorEvent(playbackErrorEventBuild);
            }
        });
        this.B = true;
        this.o = null;
    }

    public final void Z0(hd3 hd3Var, p5.b bVar, long j) {
        if (hd3Var.getPlaybackState() != 2) {
            this.v = false;
        }
        if (hd3Var.getPlayerError() == null) {
            this.x = false;
        } else if (bVar.a(10)) {
            this.x = true;
        }
        int iH1 = h1(hd3Var);
        if (this.m != iH1) {
            this.m = iH1;
            this.B = true;
            final PlaybackStateEvent playbackStateEventBuild = vh2.a().setState(this.m).setTimeSinceCreatedMillis(j - this.e).build();
            this.b.execute(new Runnable() { // from class: zh2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.d.reportPlaybackStateEvent(playbackStateEventBuild);
                }
            });
        }
    }

    public final void a1(hd3 hd3Var, p5.b bVar, long j) {
        if (bVar.a(2)) {
            xr4 currentTracks = hd3Var.getCurrentTracks();
            boolean zD = currentTracks.d(2);
            boolean zD2 = currentTracks.d(1);
            boolean zD3 = currentTracks.d(3);
            if (zD || zD2 || zD3) {
                if (!zD) {
                    f1(j, null, 0);
                }
                if (!zD2) {
                    b1(j, null, 0);
                }
                if (!zD3) {
                    d1(j, null, 0);
                }
            }
        }
        if (K0(this.p)) {
            b bVar2 = this.p;
            t41 t41Var = bVar2.a;
            if (t41Var.x != -1) {
                f1(j, t41Var, bVar2.b);
                this.p = null;
            }
        }
        if (K0(this.q)) {
            b bVar3 = this.q;
            b1(j, bVar3.a, bVar3.b);
            this.q = null;
        }
        if (K0(this.r)) {
            b bVar4 = this.r;
            d1(j, bVar4.a, bVar4.b);
            this.r = null;
        }
    }

    public final void b1(long j, t41 t41Var, int i) {
        if (Objects.equals(this.t, t41Var)) {
            return;
        }
        if (this.t == null && i == 0) {
            i = 1;
        }
        this.t = t41Var;
        g1(0, j, t41Var, i);
    }

    public final void c1(hd3 hd3Var, p5.b bVar) {
        oo0 oo0VarO0;
        if (bVar.a(0)) {
            p5.a aVarC = bVar.c(0);
            if (this.k != null) {
                e1(aVarC.b, aVarC.d);
            }
        }
        if (bVar.a(2) && this.k != null && (oo0VarO0 = O0(hd3Var.getCurrentTracks().b())) != null) {
            wh2.a(fy4.l(this.k)).setDrmType(P0(oo0VarO0));
        }
        if (bVar.a(1011)) {
            this.A++;
        }
    }

    public final void d1(long j, t41 t41Var, int i) {
        if (Objects.equals(this.u, t41Var)) {
            return;
        }
        if (this.u == null && i == 0) {
            i = 1;
        }
        this.u = t41Var;
        g1(2, j, t41Var, i);
    }

    public final void e1(no4 no4Var, jq2.b bVar) {
        int iH;
        PlaybackMetrics.Builder builder = this.k;
        if (bVar == null || (iH = no4Var.h(bVar.a)) == -1) {
            return;
        }
        no4Var.l(iH, this.g);
        no4Var.t(this.g.c, this.f);
        builder.setStreamType(U0(this.f.c));
        no4.d dVar = this.f;
        if (dVar.m != -9223372036854775807L && !dVar.k && !dVar.i && !dVar.g()) {
            builder.setMediaDurationMillis(this.f.e());
        }
        builder.setPlaybackType(this.f.g() ? 2 : 1);
        this.B = true;
    }

    @Override // bd3.a
    public void f(p5.a aVar, String str) {
    }

    public final void f1(long j, t41 t41Var, int i) {
        if (Objects.equals(this.s, t41Var)) {
            return;
        }
        if (this.s == null && i == 0) {
            i = 1;
        }
        this.s = t41Var;
        g1(1, j, t41Var, i);
    }

    public final void g1(int i, long j, t41 t41Var, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = rh2.a(i).setTimeSinceCreatedMillis(j - this.e);
        if (t41Var != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(V0(i2));
            String str = t41Var.o;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = t41Var.p;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = t41Var.k;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = t41Var.j;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = t41Var.w;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = t41Var.x;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = t41Var.H;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = t41Var.I;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = t41Var.d;
            if (str4 != null) {
                Pair pairR0 = R0(str4);
                timeSinceCreatedMillis.setLanguage((String) pairR0.first);
                Object obj = pairR0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = t41Var.A;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.B = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.b.execute(new Runnable() { // from class: ai2
            @Override // java.lang.Runnable
            public final void run() {
                this.f.d.reportTrackChangeEvent(trackChangeEventBuild);
            }
        });
    }

    public final int h1(hd3 hd3Var) {
        int playbackState = hd3Var.getPlaybackState();
        if (this.v) {
            return 5;
        }
        if (this.x) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i = this.m;
            if (i == 0 || i == 2 || i == 12) {
                return 2;
            }
            if (hd3Var.getPlayWhenReady()) {
                return hd3Var.getPlaybackSuppressionReason() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (hd3Var.getPlayWhenReady()) {
                return hd3Var.getPlaybackSuppressionReason() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.m == 0) {
            return this.m;
        }
        return 12;
    }

    @Override // defpackage.p5
    public void i0(p5.a aVar, int i, long j, long j2) {
        jq2.b bVar = aVar.d;
        if (bVar != null) {
            String strB = this.c.b(aVar.b, (jq2.b) gg3.q(bVar));
            Long l = (Long) this.i.get(strB);
            Long l2 = (Long) this.h.get(strB);
            this.i.put(strB, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.h.put(strB, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // defpackage.p5
    public void j0(p5.a aVar, gb0 gb0Var) {
        this.y += gb0Var.g;
        this.z += gb0Var.e;
    }

    @Override // defpackage.p5
    public void k0(p5.a aVar, oh2 oh2Var) {
        if (aVar.d == null) {
            return;
        }
        b bVar = new b((t41) gg3.q(oh2Var.c), oh2Var.d, this.c.b(aVar.b, (jq2.b) gg3.q(aVar.d)));
        int i = oh2Var.b;
        if (i != 0) {
            if (i == 1) {
                this.q = bVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.r = bVar;
                return;
            }
        }
        this.p = bVar;
    }

    @Override // defpackage.p5
    public void l(p5.a aVar, hd3.e eVar, hd3.e eVar2, int i) {
        if (i == 1) {
            this.v = true;
        }
        this.l = i;
    }

    @Override // bd3.a
    public void p(p5.a aVar, String str, boolean z) {
        jq2.b bVar = aVar.d;
        if ((bVar == null || !bVar.c()) && str.equals(this.j)) {
            M0();
        }
        this.h.remove(str);
        this.i.remove(str);
    }

    @Override // defpackage.p5
    public void q(p5.a aVar, ty1 ty1Var, oh2 oh2Var, IOException iOException, boolean z) {
        this.w = oh2Var.a;
    }
}
