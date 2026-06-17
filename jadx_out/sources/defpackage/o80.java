package defpackage;

import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Danmaku;
import defpackage.hd3;
import defpackage.pn0;
import java.util.HashMap;
import java.util.concurrent.Future;
import master.flame.danmaku.ui.widget.DanmakuView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class o80 implements pn0.d, hd3.d {
    public final t80 f = t80.a();
    public final DanmakuView g;
    public Future h;
    public hd3 i;

    public o80(DanmakuView danmakuView) {
        danmakuView.setCallback(this);
        this.g = danmakuView;
        D();
    }

    private void B() {
        if (this.h == null) {
            return;
        }
        q53.e("danmaku");
        this.h.cancel(true);
        this.h = null;
    }

    public void A(hd3 hd3Var) {
        this.i = hd3Var;
        hd3Var.addListener(this);
        this.f.k(new rj4(hd3Var));
    }

    public void C() {
        this.i.removeListener(this);
    }

    public final void D() {
        HashMap map = new HashMap();
        map.put(5, 2);
        map.put(1, 2);
        map.put(6, 2);
        map.put(4, 2);
        this.f.o(0.8f);
        this.f.n(map);
        this.f.p(1.2f);
        this.f.l(0.8f);
        this.f.i(vr3.a(8));
        this.f.j(2, 3.0f);
    }

    public final boolean E() {
        return this.g.j();
    }

    public final /* synthetic */ void F() {
        if (E()) {
            this.g.x(this.i.getCurrentPosition());
            if (!this.i.isPlaying()) {
                this.g.m();
            }
            this.g.u();
        }
    }

    public final /* synthetic */ void G(Danmaku danmaku) {
        boolean zIsEmpty = danmaku.isEmpty();
        DanmakuView danmakuView = this.g;
        if (zIsEmpty) {
            danmakuView.y();
        } else {
            danmakuView.p(new q83().d(new yy1().b(danmaku).a()), this.f);
        }
    }

    public final void H() {
        if (E()) {
            this.g.m();
        }
    }

    public final void I() {
        if (E()) {
            this.g.s();
        }
    }

    public void J(final Danmaku danmaku) {
        B();
        this.h = ul4.h(new Runnable() { // from class: n80
            @Override // java.lang.Runnable
            public final void run() {
                this.f.G(danmaku);
            }
        });
    }

    public void K(float f) {
        this.f.o(f);
    }

    public void L() {
        B();
        this.g.y();
    }

    @Override // pn0.d
    public void a(b90 b90Var) {
    }

    @Override // hd3.d
    public void onIsPlayingChanged(boolean z) {
        if (z) {
            I();
        } else {
            H();
        }
    }

    @Override // hd3.d
    public void onPositionDiscontinuity(hd3.e eVar, hd3.e eVar2, int i) {
        if (E()) {
            this.g.t(Long.valueOf(eVar2.g));
        }
    }

    public void release() {
        B();
        C();
        this.g.q();
    }

    @Override // pn0.d
    public void s(ih ihVar) {
    }

    @Override // pn0.d
    public void v() {
    }

    @Override // pn0.d
    public void x() {
        App.d(new Runnable() { // from class: m80
            @Override // java.lang.Runnable
            public final void run() {
                this.f.F();
            }
        });
    }
}
