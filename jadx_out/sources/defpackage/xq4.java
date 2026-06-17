package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Sub;
import com.fongmi.android.tv.bean.Track;
import com.google.android.material.bottomsheet.b;
import com.thegrizzlylabs.sardineandroid.DavResource;
import defpackage.jq4;
import defpackage.xr4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xq4 extends nh implements jq4.a {
    public ll0 B0;
    public me3 C0;
    public a D0;
    public int E0;
    public final q3 F0 = V1(new p3(), new l3() { // from class: sq4
        @Override // defpackage.l3
        public final void a(Object obj) {
            this.a.d3((k3) obj);
        }
    });
    public final jq4 A0 = new jq4(this);
    public final fr4 z0 = new fi0(App.b().getResources());

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void z0();
    }

    public static xq4 a3() {
        return new xq4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c3() {
        this.B0.c.t1(this.A0.J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(View view) {
        g01.b(this.F0).v(new String[]{"application/x-subrip", "text/x-ssa", "text/vtt", "application/ttml+xml", "audio/*", "text/*", DavResource.DEFAULT_CONTENT_TYPE});
        this.C0.X();
    }

    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ll0 ll0VarC = ll0.c(layoutInflater, viewGroup, false);
        this.B0 = ll0VarC;
        return ll0VarC;
    }

    @Override // defpackage.nh
    public void N2() {
        this.B0.b.setOnClickListener(new View.OnClickListener() { // from class: tq4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.i3(view);
            }
        });
        this.B0.d.setOnClickListener(new View.OnClickListener() { // from class: uq4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.f3(view);
            }
        });
    }

    @Override // defpackage.nh
    public void O2() {
        if (z2() != null && z2().getWindow() != null) {
            z2().getWindow().setDimAmount(0.0f);
        }
        this.B0.c.setItemAnimator(null);
        this.B0.c.setHasFixedSize(true);
        this.B0.c.setAdapter(this.A0.I(b3()));
        this.B0.c.i(new gb4(1, 16));
        this.B0.c.post(new Runnable() { // from class: vq4
            @Override // java.lang.Runnable
            public final void run() {
                this.f.c3();
            }
        });
        this.B0.c.setVisibility(this.A0.g() == 0 ? 8 : 0);
        this.B0.b.setVisibility((this.E0 == 3 && this.C0.U()) ? 0 : 8);
        this.B0.d.setVisibility((this.E0 == 3 && this.C0.M(3)) ? 0 : 8);
        this.B0.e.setText(vr3.n(dk3.l)[this.E0 - 1]);
    }

    @Override // defpackage.nh
    public boolean T2() {
        return true;
    }

    public final void Z2(List list) {
        xi1 xi1VarB = this.C0.w().b();
        for (int i = 0; i < xi1VarB.size(); i++) {
            xr4.a aVar = (xr4.a) xi1VarB.get(i);
            if (aVar.e() == this.E0) {
                for (int i2 = 0; i2 < aVar.a; i2++) {
                    t41 t41VarD = aVar.d(i2);
                    String str = t41VarD.b;
                    Track track = new Track(this.E0, (str == null || str.isEmpty() || t41VarD.b.equals("Unknown")) ? this.z0.a(t41VarD) : t41VarD.b, ge3.a(t41VarD));
                    track.setSelected(aVar.h(i2));
                    list.add(track);
                }
            }
        }
    }

    public final List b3() {
        ArrayList arrayList = new ArrayList();
        Z2(arrayList);
        return arrayList;
    }

    public final /* synthetic */ void d3(k3 k3Var) {
        if (k3Var.d() != -1 || k3Var.c() == null || k3Var.c().getData() == null) {
            return;
        }
        this.C0.r0(Sub.from(g01.m(k3Var.c().getData())));
        w2();
    }

    public final /* synthetic */ void e3() {
        this.D0.z0();
    }

    public final void f3(View view) {
        App.e(new Runnable() { // from class: wq4
            @Override // java.lang.Runnable
            public final void run() {
                this.f.e3();
            }
        }, 100L);
        w2();
    }

    public xq4 g3(me3 me3Var) {
        this.C0 = me3Var;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h3(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
        this.D0 = (a) u51Var;
    }

    public xq4 j3(int i) {
        this.E0 = i;
        return this;
    }

    @Override // jq4.a
    public void m(Track track) {
        me3 me3Var = this.C0;
        me3Var.s0(Arrays.asList(track.key(me3Var.B()).save()));
        w2();
    }
}
