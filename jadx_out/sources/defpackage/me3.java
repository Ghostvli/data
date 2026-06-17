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
        public a() {
        }

        @Override // hd3.d
        public void onIsPlayingChanged(boolean z) {
            if (me3.this.Q()) {
                me3.this.b.onPlayingChanged(z);
            }
        }

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

    public me3(final c cVar) {
        a aVar = new a();
        this.n = aVar;
        this.a = new Runnable() { // from class: ke3
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

    public static /* synthetic */ void d() {
    }

    public static ph2 o(String str, String str2, String str3) {
        return new ph2.b().s0(str).S(str2).U(TextUtils.isEmpty(str3) ? null : Uri.parse(str3)).L();
    }

    public static me3 u() {
        return o;
    }

    public Map A() {
        vb3 vb3Var = this.i;
        return (vb3Var == null || vb3Var.h() == null) ? new HashMap() : this.i.h();
    }

    public void A0() {
        this.l = true;
        if (Q()) {
            x0();
        } else {
            y0();
        }
        k0();
    }

    public String B() {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            return vb3Var.i();
        }
        return null;
    }

    public String B0() {
        return q0(G() == 1.0f ? q24.p() : 1.0f);
    }

    public int C() {
        return this.e.getPlaybackState();
    }

    public hd3 D() {
        return this.j;
    }

    public long E() {
        return this.e.getPosition();
    }

    public String F(long j) {
        return jy4.u(Math.max(0L, Math.min(E() + j, Math.max(0L, z()))));
    }

    public float G() {
        return this.e.c();
    }

    public String H() {
        return String.format(Locale.getDefault(), "%.2f", Float.valueOf(G()));
    }

    public String I() {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            return vb3Var.m();
        }
        return null;
    }

    public int J() {
        e35 e35Var = this.g;
        if (e35Var == null) {
            return 0;
        }
        return e35Var.b;
    }

    public int K() {
        e35 e35Var = this.g;
        if (e35Var == null) {
            return 0;
        }
        return e35Var.a;
    }

    public boolean L() {
        return x() != null && x().stream().anyMatch(new Predicate() { // from class: le3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Danmaku) obj).isSelected();
            }
        });
    }

    public boolean M(int i) {
        return this.e.n(i);
    }

    public boolean N() {
        vb3 vb3Var = this.i;
        return vb3Var == null || TextUtils.isEmpty(vb3Var.m());
    }

    public boolean O() {
        return K() > J();
    }

    public boolean P() {
        return this.e.a();
    }

    public boolean Q() {
        ee3 ee3Var = this.e;
        return ee3Var != null && ee3Var.getType() == 2;
    }

    public boolean R() {
        tv2 tv2Var;
        return Q() && (tv2Var = this.d) != null && tv2Var.S();
    }

    public boolean S() {
        return this.e.isPlaying();
    }

    public boolean T() {
        return J() > K();
    }

    public boolean U() {
        return this.e.b();
    }

    public void V(int i, int i2) {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.W(i, i2);
        }
    }

    public void W(String str, Result result, boolean z, ph2 ph2Var) {
        w0();
        this.i = vb3.d(result, str, ph2Var);
        this.h = f83.k(this).B(result, z);
    }

    public void X() {
        this.e.pause();
    }

    public void Y() {
        this.e.play();
    }

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

    @Override // defpackage.w73
    public void a() {
        this.b.onError(vr3.l(sm3.E));
    }

    public void a0() {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.X();
        }
    }

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

    public void d0() {
        App.f(this.a);
        this.m = 0;
        this.l = false;
    }

    public void e0() {
        this.e.e();
    }

    public void f0(long j) {
        this.e.seekTo(j);
    }

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

    public void h0(float f) {
        this.f.K(f);
    }

    public void i0(DanmakuView danmakuView) {
        o80 o80Var = new o80(danmakuView);
        this.f = o80Var;
        o80Var.A(this.j);
    }

    public final void j0(List list) {
        if (this.f != null) {
            g0((list == null || list.isEmpty()) ? Danmaku.empty() : (Danmaku) list.get(0));
        }
    }

    public void k0() {
        l0(f10.g);
    }

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

    public void m0(ph2 ph2Var) {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            vb3Var.r(ph2Var);
        }
        this.e.m(ph2Var);
    }

    public String n() {
        float fG = G();
        return q0(fG < 5.0f ? Math.min(fG + (fG >= 2.0f ? 1.0f : 0.25f), 5.0f) : 0.25f);
    }

    public void n0(int i) {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.d0(i);
        }
    }

    public void o0(Surface surface) {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.c0(surface);
        }
    }

    public boolean p(long j, long j2) {
        return j > 0 && j2 > 0 && j2 - j <= f10.a(j2);
    }

    public void p0() {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.e0();
        }
    }

    public boolean q(long j, long j2) {
        return j > 0 && j2 > 0 && j <= f10.a(j2);
    }

    public String q0(float f) {
        if (!Q() && !this.j.isCommandAvailable(13)) {
            return H();
        }
        this.e.setPlaybackSpeed(f);
        return H();
    }

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

    public void r0(Sub sub) {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            vb3Var.s(sub);
        }
        k0();
    }

    public void s() {
        this.i = null;
    }

    public void s0(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.e.i(list);
    }

    public void t() {
        tv2 tv2Var = this.d;
        if (tv2Var != null) {
            tv2Var.N();
        }
    }

    public void t0(vb3 vb3Var, long j) {
        this.i = vb3Var;
        l0(j);
    }

    public void u0(vb3 vb3Var) {
        d0();
        s();
        w0();
        t0(vb3Var, f10.g);
    }

    public fg2 v() {
        return this.j.getCurrentMediaItem();
    }

    public void v0() {
        o80 o80Var = this.f;
        if (o80Var != null) {
            o80Var.L();
        }
        this.e.k();
        w0();
    }

    public xr4 w() {
        return this.e.getCurrentTracks();
    }

    public final void w0() {
        f83 f83Var = this.h;
        if (f83Var != null) {
            f83Var.G();
        }
        this.h = null;
    }

    public List x() {
        vb3 vb3Var = this.i;
        if (vb3Var != null) {
            return vb3Var.e();
        }
        return null;
    }

    public void x0() {
        if (Q()) {
            tv2 tv2Var = this.d;
            if (tv2Var != null) {
                tv2Var.k();
            }
            this.e = this.c;
        }
    }

    public String y() {
        return this.e.j();
    }

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

    public long z() {
        return this.e.getDuration();
    }

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
            @Override // java.lang.Runnable
            public final void run() {
                me3.d();
            }
        };
        this.b = null;
    }
}
