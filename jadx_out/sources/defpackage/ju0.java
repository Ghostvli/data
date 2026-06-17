package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Episode;
import defpackage.au0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ju0 implements au0.a {
    public final au0.a f;
    public final u51 g;
    public xk0 h;
    public u64 i;
    public au0 j;
    public List k;

    /* JADX WARN: Multi-variable type inference failed */
    public ju0(u51 u51Var) {
        this.f = (au0.a) u51Var;
        this.g = u51Var;
    }

    public static ju0 a(u51 u51Var) {
        return new ju0(u51Var);
    }

    private void d() {
        f();
        e();
    }

    private void f() {
        this.h.b.setHasFixedSize(true);
        this.h.b.setItemAnimator(null);
        RecyclerView recyclerView = this.h.b;
        au0 au0Var = new au0(this, 3);
        this.j = au0Var;
        recyclerView.setAdapter(au0Var);
    }

    private void g() {
        int iA = vr3.a(200);
        int iJ = vr3.j() / 3;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            iA = Math.max(iA, vr3.o(((Episode) it.next()).getName(), 14));
        }
        FrameLayout frameLayout = (FrameLayout) this.i.findViewById(ol3.e);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.width = Math.min(iA, iJ);
        frameLayout.setLayoutParams(layoutParams);
    }

    @Override // au0.a
    public void E(Episode episode) {
        this.f.E(episode);
        this.i.dismiss();
    }

    public ju0 b(List list) {
        this.k = list;
        return this;
    }

    public final void c() {
        this.h = xk0.c(LayoutInflater.from(this.g));
        u64 u64Var = new u64(this.g);
        this.i = u64Var;
        u64Var.setContentView(this.h.getRoot());
        this.i.k().G0(false);
        this.i.getWindow().setFlags(1024, 1024);
        this.i.getWindow().setDimAmount(0.0f);
        this.i.show();
        g();
    }

    public final void e() {
        this.j.G(this.k);
        this.h.b.t1(this.j.K());
    }

    public void h() {
        c();
        d();
    }
}
