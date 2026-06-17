package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.g;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Collect;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Site;
import com.fongmi.android.tv.bean.Vod;
import com.fongmi.android.tv.ui.activity.FolderActivity;
import com.fongmi.android.tv.ui.activity.VideoActivity;
import com.fongmi.android.tv.ui.custom.CustomRecyclerView;
import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import defpackage.hz3;
import defpackage.ov;
import defpackage.s60;
import j$.util.stream.Stream$EL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class iw extends uh implements ds2, ov.a, hz3.a, s60.a {
    public w51 k0;
    public ov l0;
    public hz3 m0;
    public s60 n0;
    public b94 o0;
    public List p0;

    public static /* synthetic */ int C2(List list, Collect collect, Collect collect2) {
        int iIndexOf = list.indexOf(collect.getSite().getKey());
        int iIndexOf2 = list.indexOf(collect2.getSite().getKey());
        if (iIndexOf < 0) {
            iIndexOf = Integer.MAX_VALUE;
        }
        if (iIndexOf2 < 0) {
            iIndexOf2 = Integer.MAX_VALUE;
        }
        return Integer.compare(iIndexOf, iIndexOf2);
    }

    private String G2() {
        return S().getString("keyword");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H2(View view) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("edit", true);
        k0().o1("result", bundle);
        k0().X0();
    }

    public static iw K2(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        iw iwVar = new iw();
        iwVar.e2(bundle);
        return iwVar;
    }

    private void N2() {
        this.k0.b.setItemAnimator(null);
        this.k0.b.setHasFixedSize(true);
        CustomRecyclerView customRecyclerView = this.k0.b;
        ov ovVar = new ov(this);
        this.l0 = ovVar;
        customRecyclerView.setAdapter(ovVar);
        this.k0.c.setHasFixedSize(true);
        this.k0.c.m(this.n0);
        RecyclerView recyclerView = this.k0.c;
        hz3 hz3Var = new hz3(this);
        this.m0 = hz3Var;
        recyclerView.setAdapter(hz3Var);
        ((GridLayoutManager) this.k0.c.getLayoutManager()).M3(F2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O2(Result result) {
        if (result == null) {
            return;
        }
        this.n0.d(result);
        boolean z = !result.getList().isEmpty() && this.l0.a0().getSite().equals(result.getVod().getSite());
        if (z) {
            this.l0.a0().getList().addAll(result.getList());
        }
        if (z) {
            this.m0.I(result.getList());
        }
    }

    private void Q2() {
        b94 b94VarY = ((b94) new x(this).b(b94.class)).y();
        this.o0 = b94VarY;
        b94VarY.w().f(this, new x43() { // from class: dw
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.M2((Result) obj);
            }
        });
        this.o0.v().f(this, new x43() { // from class: ew
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.O2((Result) obj);
            }
        });
    }

    public final int F2() {
        int i = vr3.r(X1()) ? 2 : 1;
        return vr3.s() ? i + 1 : i;
    }

    public final /* synthetic */ void I2() {
        this.k0.c.t1(0);
    }

    public final /* synthetic */ void J2() {
        this.o0.D(this.p0, G2(), false);
    }

    public final void L2() {
        if (this.p0.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Collect.all());
        Iterator it = this.p0.iterator();
        while (it.hasNext()) {
            arrayList.add(new Collect((Site) it.next(), new ArrayList()));
        }
        if (q24.L() && arrayList.size() > 2) {
            final List listX = b75.I().X();
            Collect collect = (Collect) arrayList.remove(0);
            arrayList.sort(new Comparator() { // from class: fw
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return iw.C2(listX, (Collect) obj, (Collect) obj2);
                }
            });
            arrayList.add(0, collect);
        }
        this.l0.T(arrayList, new Runnable() { // from class: gw
            @Override // java.lang.Runnable
            public final void run() {
                this.f.J2();
            }
        });
    }

    public final void M2(Result result) {
        if (result == null || result.getList().isEmpty()) {
            return;
        }
        if (this.l0.b0() == 0) {
            this.m0.I(result.getList());
        }
        this.l0.Z(result.getList());
        String siteKey = result.getList().get(0).getSiteKey();
        for (int i = 1; i < this.l0.g(); i++) {
            Collect collect = (Collect) this.l0.M(i);
            if (siteKey.equals(collect.getSite().getKey())) {
                collect.getList().addAll(result.getList());
                return;
            }
        }
    }

    public final void P2() {
        this.p0 = Stream$EL.toList(b75.I().Y().stream().filter(new j65()));
    }

    public final void R2() {
        int iA = vr3.a(48);
        int iJ = (vr3.j() / (F2() + 1)) - vr3.a(40);
        Iterator it = this.p0.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, vr3.o(((Site) it.next()).getName(), 14));
        }
        int iMax2 = Math.max(vr3.a(120), Math.min(iMax + iA, iJ));
        ViewGroup.LayoutParams layoutParams = this.k0.b.getLayoutParams();
        layoutParams.width = iMax2;
        this.k0.b.setLayoutParams(layoutParams);
    }

    @Override // hz3.a
    public void a(Vod vod) {
        if (vod.isFolder()) {
            FolderActivity.W1(X1(), vod.getSiteKey(), Result.folder(vod));
        } else {
            VideoActivity.O4(X1(), vod.getSiteKey(), vod.getId(), vod.getName(), vod.getPic());
        }
    }

    @Override // defpackage.uh, defpackage.p51
    public void c1() {
        super.c1();
        this.o0.E();
        X1().s0(this);
    }

    @Override // defpackage.ds2
    public boolean f(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        X1().y().k();
        return true;
    }

    @Override // defpackage.p51
    public void f1(boolean z) {
        if (z) {
            X1().s0(this);
        } else {
            w2();
        }
    }

    @Override // ov.a
    public void h(int i, Collect collect) {
        this.m0.T(collect.getList(), new Runnable() { // from class: hw
            @Override // java.lang.Runnable
            public final void run() {
                this.f.I2();
            }
        });
        this.l0.f0(i);
        this.n0.k(collect.getPage());
    }

    @Override // s60.a
    public void u(String str) {
        Collect collectA0 = this.l0.a0();
        if (DavPrincipal.KEY_ALL.equals(collectA0.getSite().getKey())) {
            return;
        }
        this.o0.C(collectA0.getSite(), G2(), false, str);
        collectA0.setPage(Integer.parseInt(str));
        this.n0.j(true);
    }

    @Override // defpackage.uh
    public i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        w51 w51VarC = w51.c(f0());
        this.k0 = w51VarC;
        return w51VarC;
    }

    @Override // defpackage.uh
    public void v2() {
        this.k0.d.setOnClickListener(new View.OnClickListener() { // from class: cw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.H2(view);
            }
        });
    }

    @Override // defpackage.ds2
    public void w(Menu menu, MenuInflater menuInflater) {
    }

    @Override // defpackage.uh
    public void w2() {
        if (I0()) {
            return;
        }
        x7 x7Var = (x7) X1();
        x7Var.D1(this.k0.d);
        x7Var.u1().r(true);
        x7Var.a1(this, C0(), g.b.j);
        x7Var.setTitle(G2());
    }

    @Override // defpackage.uh
    public void x2() {
        this.n0 = new s60(this);
        N2();
        Q2();
        P2();
        R2();
        L2();
    }
}
