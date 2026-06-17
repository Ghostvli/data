package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Danmaku;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Sub;
import com.fongmi.android.tv.bean.Track;
import defpackage.ee3;
import defpackage.hd3;
import defpackage.ph2;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import master.flame.danmaku.ui.widget.DanmakuView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class me3 implements w73 {
    public static final me3 o = new me3();
    public final Runnable a;
    public final c b;
    public kw0 c;
    public tv2 d;
    public ee3 e;
    public o80 f;
    public e35 g;
    public f83 h;
    public vb3 i;
    public hd3 j;
    public boolean k;
    public boolean l;
    public int m;
    public final hd3.d n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements hd3.d {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public void onIsPlayingChanged(boolean z) {
            if (me3.this.Q()) {
                me3.this.b.onPlayingChanged(z);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public void onPlaybackStateChanged(int i) {
            if (i != 1) {
                App.f(me3.this.a);
            }
            if (me3.this.Q()) {
                if (i == 4 && me3.this.d != null) {
                    String strR = me3.this.d.R();
                    if ("MPV_ENGINE_ERROR".equals(strR)) {
                        me3.this.x0();
                        me3.this.k0();
                        return;
                    } else if (strR != null) {
                        me3.this.b.onError(strR);
                        return;
                    }
                }
                me3.this.b.onStateChanged(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public void onPlayerError(ac3 ac3Var) {
            ee3.a aVarG = me3.this.e.g(ac3Var);
            if (aVarG == ee3.a.RECOVERED) {
                return;
            }
            me3 me3Var = me3.this;
            int i = me3Var.m + 1;
            me3Var.m = i;
            if (i > 2) {
                me3.this.b.onError(me3.this.e.d(ac3Var));
                return;
            }
            int i2 = b.a[aVarG.ordinal()];
            if (i2 == 1) {
                me3.this.z0();
            } else {
                if (i2 != 2) {
                    return;
                }
                me3.this.b.onError(me3.this.e.d(ac3Var));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public void onTracksChanged(xr4 xr4Var) {
            if (xr4Var.c() || me3.this.k) {
                return;
            }
            me3 me3Var = me3.this;
            me3Var.s0(Track.find(me3Var.B()));
            me3.this.b.onTracksChanged();
            me3.this.k = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public void onVideoSizeChanged(e35 e35Var) {
            me3.this.g = e35Var;
            if (me3.this.Q()) {
                me3.this.b.onVideoSizeChanged(e35Var);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[ee3.a.values().length];
            a = iArr;
            try {
                iArr[ee3.a.DECODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ee3.a.FATAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void onError(String str);

        void onPlayerRebuild(hd3 hd3Var);

        void onPlayingChanged(boolean z);

        void onPrepare();

        void onStateChanged(int i);

        void onTracksChanged();

        void onVideoSizeChanged(e35 e35Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public me3(final c cVar) {
        a aVar = new a();
        this.n = aVar;
        this.a = new Runnable() { // from class: ke3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                cVar.onError(vr3.l(sm3.G));
            }
        };
        kw0 kw0Var = new kw0(q24.d(), aVar);
        this.c = kw0Var;
        this.e = kw0Var;
        this.j = kw0Var.o();
        this.b = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void d() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ph2 o(String str, String str2, String str3) {
        return new ph2.b().s0(str).S(str2).U(TextUtils.isEmpty(str3) ? null : Uri.parse(str3)).L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static me3 u() {
        return o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map A() {
        vb3 vb3Var = this.i;
        return (vb3Var == null || vb3Var.h() == null) ? new HashMap() : this.i.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A0() {
        this.l = true;
        if (Q()) {
            x0();
        } else {
            y0();
        }
        k0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String B() {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            return vb3Var.i();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String B0() {
        return q0(G() == 1.0f ? q24.p() : 1.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int C() {
        return this.e.getPlaybackState();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hd3 D() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long E() {
        return this.e.getPosition();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String F(long j) {
        return jy4.u(Math.max(0L, Math.min(E() + j, Math.max(0L, z()))));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float G() {
        return this.e.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String H() {
        return String.format(Locale.getDefault(), "%.2f", Float.valueOf(G()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String I() {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            return vb3Var.m();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int J() {
        e35 e35Var = this.g;
        if (e35Var == null) {
            return 0;
        }
        return e35Var.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int K() {
        e35 e35Var = this.g;
        if (e35Var == null) {
            return 0;
        }
        return e35Var.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean L() {
        return x() != null && x().stream().anyMatch(new Predicate() { // from class: le3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Danmaku) obj).isSelected();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean M(int i) {
        return this.e.n(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean N() {
        vb3 vb3Var = this.i;
        return vb3Var == null || TextUtils.isEmpty(vb3Var.m());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean O() {
        return K() > J();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean P() {
        return this.e.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean Q() {
        ee3 ee3Var = this.e;
        return ee3Var != null && ee3Var.getType() == 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean R() {
        tv2 tv2Var;
        return Q() && (tv2Var = this.d) != null && tv2Var.S();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean S() {
        return this.e.isPlaying();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean T() {
        return J() > K();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean U() {
        return this.e.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V(int i, int i2) {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.W(i, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W(String str, Result result, boolean z, ph2 ph2Var) {
        w0();
        this.i = vb3.d(result, str, ph2Var);
        this.h = f83.k(this).B(result, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X() {
        this.e.pause();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y() {
        this.e.play();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z() {
        if (this.l) {
            return;
        }
        boolean z = q24.j() == 2;
        if (z && !Q()) {
            y0();
        } else {
            if (z || !Q()) {
                return;
            }
            x0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w73
    public void a() {
        this.b.onError(vr3.l(sm3.E));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a0() {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.X();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w73
    public void b(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            i43.i(vr3.m(sm3.Q, str2));
        }
        if (map != null) {
            map.remove("Range");
        }
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            vb3Var.q(map);
        }
        vb3 vb3Var2 = this.i;
        if (vb3Var2 != null) {
            vb3Var2.t(str);
        }
        k0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b0() {
        this.j.removeListener(this.n);
        hd3 hd3VarP = this.c.p(this.n);
        this.j = hd3VarP;
        o80 o80Var = this.f;
        if (o80Var != null) {
            o80Var.A(hd3VarP);
        }
        this.b.onPlayerRebuild(this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c0() {
        w0();
        App.f(this.a);
        o80 o80Var = this.f;
        if (o80Var != null) {
            o80Var.release();
            this.f = null;
        }
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.Z();
            this.d = null;
        }
        if (this.c != null) {
            this.j.removeListener(this.n);
            this.c.q();
            this.c = null;
            this.e = null;
            this.j = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d0() {
        App.f(this.a);
        this.m = 0;
        this.l = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e0() {
        this.e.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f0(long j) {
        this.e.seekTo(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g0(Danmaku danmaku) {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            vb3Var.o(danmaku);
        }
        o80 o80Var = this.f;
        if (o80Var != null) {
            o80Var.J(danmaku);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h0(float f) {
        this.f.K(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i0(DanmakuView danmakuView) {
        o80 o80Var = new o80(danmakuView);
        this.f = o80Var;
        o80Var.A(this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j0(List list) {
        if (this.f != null) {
            g0((list == null || list.isEmpty()) ? Danmaku.empty() : (Danmaku) list.get(0));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k0() {
        l0(f10.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l0(long j) {
        vb3 vb3Var = this.i;
        if (vb3Var == null || vb3Var.m() == null) {
            return;
        }
        r(this.i.m());
        j0(this.i.e());
        this.e.l(this.i.b());
        App.e(this.a, j);
        this.b.onPrepare();
        this.k = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m0(ph2 ph2Var) {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            vb3Var.r(ph2Var);
        }
        this.e.m(ph2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String n() {
        float fG = G();
        return q0(fG < 5.0f ? Math.min(fG + (fG >= 2.0f ? 1.0f : 0.25f), 5.0f) : 0.25f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n0(int i) {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.d0(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o0(Surface surface) {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.c0(surface);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p(long j, long j2) {
        return j > 0 && j2 > 0 && j2 - j <= f10.a(j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p0() {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.e0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q(long j, long j2) {
        return j > 0 && j2 > 0 && j <= f10.a(j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String q0(float f) {
        if (!Q() && !this.j.isCommandAvailable(13)) {
            return H();
        }
        this.e.setPlaybackSpeed(f);
        return H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r(String str) {
        if (this.l) {
            return;
        }
        boolean z = q24.j() == 2;
        if (z && !Q()) {
            y0();
        } else {
            if (z || !Q()) {
                return;
            }
            x0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r0(Sub sub) {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            vb3Var.s(sub);
        }
        k0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s() {
        this.i = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s0(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.e.i(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t() {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.N();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t0(vb3 vb3Var, long j) {
        this.i = vb3Var;
        l0(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u0(vb3 vb3Var) {
        d0();
        s();
        w0();
        t0(vb3Var, f10.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fg2 v() {
        return this.j.getCurrentMediaItem();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v0() {
        o80 o80Var = this.f;
        if (o80Var != null) {
            o80Var.L();
        }
        this.e.k();
        w0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xr4 w() {
        return this.e.getCurrentTracks();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w0() {
        f83 f83Var = this.h;
        if (f83Var != null) {
            f83Var.G();
        }
        this.h = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List x() {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            return vb3Var.e();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x0() {
        if (Q()) {
            tv2 tv2Var = this.d;
            if (tv2Var != null) {
                tv2Var.k();
            }
            this.e = this.c;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String y() {
        return this.e.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y0() {
        if (Q()) {
            return;
        }
        this.c.k();
        tv2 tv2Var = this.d;
        hd3.d dVar = this.n;
        if (tv2Var == null) {
            this.d = new tv2(dVar);
        } else {
            tv2Var.Y(dVar);
        }
        this.e = this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long z() {
        return this.e.getDuration();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z0() {
        ee3 ee3Var = this.e;
        ee3Var.f(!ee3Var.h() ? 1 : 0);
        if (Q()) {
            this.d.Y(this.n);
            k0();
        } else {
            b0();
            k0();
        }
    }

    public me3() {
        this.n = new a();
        this.a = new Runnable() { // from class: je3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                me3.d();
            }
        };
        this.b = null;
    }
}
