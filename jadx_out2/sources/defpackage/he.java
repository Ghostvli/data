package defpackage;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import defpackage.gc;
import defpackage.pe0;
import defpackage.pu1;
import defpackage.wc;
import defpackage.xd;
import java.util.Objects;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class he implements wc {
    public static boolean m;
    public final Context a;
    public final BiConsumer b;
    public final pe0.d c;
    public final pe0.b d;
    public final c e;
    public final float f;
    public pu1 g;
    public zu h;
    public ec i;
    public gc j;
    public Looper k;
    public Context l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final Context a;
        public BiConsumer b;
        public pe0.b c;
        public pe0.d d;
        public ec e;
        public float f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Context context) {
            this.a = context != null ? context.getApplicationContext() : null;
            this.d = pe0.d.a;
            if (context == null) {
                this.e = ec.g;
            }
            this.f = 8.0f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ pe0.e f(b bVar) {
            bVar.getClass();
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public he h() {
            if (this.c == null) {
                this.c = new me0(this.a);
            }
            return new he(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b i(ec ecVar) {
            if (this.a == null) {
                this.e = ecVar;
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b j(pe0.b bVar) {
            this.c = bVar;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b k(pe0.d dVar) {
            this.d = dVar;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b l(pe0.e eVar) {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements xd.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // xd.b
        public void a(AudioDeviceInfo audioDeviceInfo) {
            if (he.this.j != null) {
                he.this.j.m(audioDeviceInfo);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // xd.b
        public void b() {
            if (he.this.j != null) {
                he heVar = he.this;
                ec ecVar = ec.g;
                heVar.i = ecVar;
                he.this.j.j(ecVar);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public he(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.d = (pe0.b) gg3.q(bVar.c);
        this.c = bVar.d;
        this.i = bVar.e;
        b.f(bVar);
        this.e = bVar.a != null ? new c() : null;
        this.f = bVar.f;
        this.h = zu.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String o(Looper looper) {
        return looper == null ? "null" : looper.getThread().getName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ec c() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i(Lwc$g;)Lvc; */
    @Override // defpackage.wc
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public xd i(wc.g gVar) throws wc.e {
        Context context;
        try {
            int i = gVar.h;
            if (gVar.i == -1 || this.a == null || Build.VERSION.SDK_INT < 34) {
                context = null;
            } else {
                Context context2 = this.l;
                if (context2 == null || context2.getDeviceId() != gVar.i) {
                    this.l = this.a.createDeviceContext(gVar.i);
                }
                context = this.l;
                i = 0;
            }
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(k(gVar.g, gVar.d)).setAudioFormat(new AudioFormat.Builder().setSampleRate(gVar.b).setChannelMask(gVar.c).setEncoding(gVar.a).build()).setTransferMode(1).setBufferSizeInBytes(gVar.f).setSessionId(i);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                sessionId.setOffloadedPlayback(gVar.e);
            }
            if (i2 >= 34 && context != null) {
                sessionId.setContext(context);
            }
            BiConsumer biConsumer = this.b;
            if (biConsumer != null) {
                biConsumer.accept(sessionId, gVar);
            }
            AudioTrack audioTrackBuild = sessionId.build();
            if (audioTrackBuild.getState() == 1) {
                return new xd(audioTrackBuild, gVar, this.e, this.f, this.h);
            }
            try {
                audioTrackBuild.release();
            } catch (Exception unused) {
            }
            throw new wc.e();
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new wc.e(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wc
    public void e(zu zuVar) {
        this.h = zuVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wc
    public wc.d f(wc.c cVar) {
        q(cVar);
        uc ucVarA = this.d.a(cVar.a, cVar.b);
        return new wc.d.a().f(n(cVar)).g(ucVarA.a).h(ucVarA.b).i(ucVarA.c).e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wc
    public wc.g g(wc.c cVar) throws wc.b {
        int i;
        boolean z;
        int i2;
        int i3;
        int iJ;
        int iU0;
        boolean z2;
        int i4;
        double d;
        t41 t41Var = cVar.a;
        q(cVar);
        if (Objects.equals(t41Var.p, "audio/raw")) {
            gg3.d(fy4.R0(t41Var.J));
            int i5 = t41Var.J;
            i = t41Var.I;
            iJ = j(t41Var.H);
            iU0 = fy4.u0(i5, t41Var.H);
            z = cVar.e;
            i2 = i5;
            z2 = false;
            i3 = 0;
        } else {
            i = t41Var.I;
            uc ucVarA = cVar.f ? this.d.a(t41Var, cVar.b) : uc.d;
            if (cVar.f && ucVarA.a) {
                int iF = nt2.f((String) gg3.q(t41Var.p), t41Var.k);
                int iJ2 = j(t41Var.H);
                z2 = ucVarA.b;
                z = true;
                i3 = 1;
                i2 = iF;
                iJ = iJ2;
                iU0 = -1;
            } else {
                Pair pairH = this.i.h(t41Var, cVar.b);
                if (pairH == null) {
                    throw new wc.b("Unable to configure passthrough for: " + t41Var);
                }
                int iIntValue = ((Integer) pairH.first).intValue();
                int iIntValue2 = ((Integer) pairH.second).intValue();
                z = cVar.e;
                i2 = iIntValue;
                i3 = 2;
                iJ = iIntValue2;
                iU0 = -1;
                z2 = false;
            }
        }
        int i6 = t41Var.j;
        if (Objects.equals(t41Var.p, "audio/vnd.dts.hd;profile=lbr") && i6 == -1) {
            i6 = 768000;
        }
        int i7 = i6;
        int iA = cVar.j;
        if (iA == -1) {
            pe0.d dVar = this.c;
            int iL = l(i, iJ, i2);
            int i8 = iU0 != -1 ? iU0 : 1;
            if (z) {
                i4 = i;
                d = this.f;
            } else {
                i4 = i;
                d = 1.0d;
            }
            iA = dVar.a(iL, i2, i3, i8, i4, i7, d);
            i = i4;
        }
        return new wc.g.a().t(i).p(iJ).q(i2).o(iA).n(cVar.g).m(cVar.b).r(i3 == 1).s(cVar.i).v(z).u(z2).w(cVar.h).l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wc
    public void h(wc.f fVar) {
        r();
        if (this.g == null) {
            this.g = new pu1(Thread.currentThread());
        }
        this.g.c(fVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int j(int i) {
        return fy4.S(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final AudioAttributes k(yb ybVar, boolean z) {
        return z ? m() : ybVar.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int l(int i, int i2, int i3) {
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3);
        gg3.v(minBufferSize != -2);
        return minBufferSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final AudioAttributes m() {
        return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int n(wc.c cVar) {
        t41 t41Var = cVar.a;
        if (!Objects.equals(t41Var.p, "audio/raw")) {
            return this.i.m(t41Var, cVar.b) ? 2 : 0;
        }
        int i = t41Var.J;
        if (i == 2) {
            return 2;
        }
        if (!cVar.d) {
            return 0;
        }
        boolean zR0 = fy4.R0(i);
        int i2 = t41Var.J;
        if (zR0) {
            return Build.VERSION.SDK_INT < fy4.Q(i2) ? 0 : 2;
        }
        xz1.i("ATAudioOutputProvider", "Invalid PCM encoding: " + i2);
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(ec ecVar) {
        r();
        ec ecVar2 = this.i;
        if (ecVar2 == null || ecVar.equals(ecVar2)) {
            return;
        }
        this.i = ecVar;
        pu1 pu1Var = this.g;
        if (pu1Var != null) {
            pu1Var.l(new pu1.a() { // from class: ge
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((wc.f) obj).a();
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(wc.c cVar) {
        Context context;
        r();
        gc gcVar = this.j;
        if (gcVar == null && (context = this.a) != null) {
            gc gcVar2 = new gc(context, new gc.e() { // from class: fe
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // gc.e
                public final void a(ec ecVar) {
                    this.a.p(ecVar);
                }
            }, cVar.b, cVar.c);
            this.j = gcVar2;
            this.i = gcVar2.k();
        } else if (gcVar != null) {
            AudioDeviceInfo audioDeviceInfo = cVar.c;
            if (audioDeviceInfo != null) {
                gcVar.m(audioDeviceInfo);
            }
            this.j.l(cVar.b);
        }
        gg3.q(this.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r() {
        if (this.a == null) {
            return;
        }
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.k;
        gg3.B(looper == null || looper == looperMyLooper, "AudioTrackAudioOutputProvider accessed on multiple threads: %s and %s", o(looper), o(looperMyLooper));
        this.k = looperMyLooper;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wc
    public void release() {
        pu1 pu1Var = this.g;
        if (pu1Var != null) {
            pu1Var.i();
        }
        gc gcVar = this.j;
        if (gcVar != null) {
            gcVar.n();
        }
    }
}
