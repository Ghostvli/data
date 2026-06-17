package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fongmi.android.tv.bean.Danmaku;
import com.google.android.material.bottomsheet.b;
import defpackage.r80;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class x80 extends nh implements r80.a {
    public uk0 A0;
    public me3 B0;
    public final q3 C0 = V1(new p3(), new l3() { // from class: u80
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.l3
        public final void a(Object obj) {
            this.a.Z2((k3) obj);
        }
    });
    public final r80 z0 = new r80(this);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static x80 X2() {
        return new x80();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        uk0 uk0VarC = uk0.c(layoutInflater, viewGroup, false);
        this.A0 = uk0VarC;
        return uk0VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void N2() {
        this.A0.b.setOnClickListener(new View.OnClickListener() { // from class: v80
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.c3(view);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void O2() {
        this.A0.c.setItemAnimator(null);
        this.A0.c.setHasFixedSize(true);
        this.A0.c.setAdapter(this.z0.I(this.B0.x()));
        this.A0.c.i(new gb4(1, 16));
        this.A0.c.post(new Runnable() { // from class: w80
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.Y2();
            }
        });
        this.A0.c.setVisibility(this.z0.g() == 0 ? 8 : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void Y2() {
        this.A0.c.t1(this.z0.J());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void Z2(k3 k3Var) {
        if (k3Var.d() != -1 || k3Var.c() == null || k3Var.c().getData() == null) {
            return;
        }
        this.B0.g0(Danmaku.from(g01.m(k3Var.c().getData())));
        w2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x80 a3(me3 me3Var) {
        this.B0 = me3Var;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b3(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c3(View view) {
        g01.b(this.C0).v(new String[]{"text/*"});
        this.B0.X();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // r80.a
    public void k(Danmaku danmaku) {
        me3 me3Var = this.B0;
        if (danmaku.isSelected()) {
            danmaku = Danmaku.empty();
        }
        me3Var.g0(danmaku);
        w2();
    }
}
