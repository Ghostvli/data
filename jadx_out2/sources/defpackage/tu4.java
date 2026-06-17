package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Site;
import com.fongmi.android.tv.bean.Style;
import com.fongmi.android.tv.bean.Value;
import com.fongmi.android.tv.bean.Vod;
import com.fongmi.android.tv.ui.activity.SearchActivity;
import com.fongmi.android.tv.ui.activity.VideoActivity;
import com.fongmi.android.tv.ui.custom.CustomRecyclerView;
import defpackage.s60;
import defpackage.y55;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class tu4 extends uh implements s60.a, y55.a, SwipeRefreshLayout.j {
    public HashMap k0;
    public j71 l0;
    public s60 m0;
    public b94 n0;
    public y55 o0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private HashMap H2() {
        return (HashMap) S().getSerializable("extend");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String J2() {
        return S().getString("key");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Site L2() {
        return b75.I().W(J2());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int Q2() {
        return S().getInt("y");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static tu4 W2(String str, String str2, Style style, HashMap map, boolean z, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("y", i);
        bundle.putString("key", str);
        bundle.putString("typeId", str2);
        bundle.putBoolean("folder", z);
        bundle.putParcelable("style", style);
        bundle.putSerializable("extend", map);
        tu4 tu4Var = new tu4();
        tu4Var.e2(bundle);
        return tu4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void Z2() {
        this.l0.c.setTranslationY(-vr3.a(Q2()));
        this.l0.c.setHasFixedSize(true);
        a3(M2());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void b3() {
        b94 b94Var = (b94) new x(this).b(b94.class);
        this.n0 = b94Var;
        b94Var.v().f(C0(), new x43() { // from class: nu4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.Y2((Result) obj);
            }
        });
        this.n0.t().f(C0(), new x43() { // from class: ou4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.x43
            public final void a(Object obj) {
                i43.i(((Result) obj).getMsg());
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // y55.a
    public boolean D(Vod vod) {
        if (vod.isAction() || vod.isFolder()) {
            return false;
        }
        SearchActivity.V1(X1(), vod.getName());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F2(Result result) {
        Style style = result.getVod().getStyle(M2());
        if (!style.equals(this.o0.Y())) {
            a3(style);
        }
        this.o0.J(result.getList(), new Runnable() { // from class: ru4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.G2();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G2() {
        this.l0.c.post(new Runnable() { // from class: su4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.T2();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I2() {
        this.o0.L(new Runnable() { // from class: pu4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.U2();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final x31 K2() {
        return (x31) j0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Style M2() {
        return R2() ? Style.list() : L2().getStyle((Style) S().getParcelable("style"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String N2() {
        return S().getString("typeId");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O2() {
        this.m0.h();
        this.o0.L(new Runnable() { // from class: qu4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.V2();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P2(String str, String str2) {
        this.n0.q(J2(), str, str2, true, this.k0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean R2() {
        return S().getBoolean("folder");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean S2() {
        return "home".equals(N2());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void T2() {
        if (this.m0.f() || this.l0.c.canScrollVertically(1) || this.l0.c.getScrollState() != 0 || S2()) {
            return;
        }
        P2(N2(), String.valueOf(this.m0.c()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void U2() {
        this.n0.x();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void V2() {
        if (!this.l0.d.p()) {
            this.l0.b.h();
        }
        if (S2()) {
            Y2(K2().E2());
        } else {
            P2(N2(), "1");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X2() {
        this.l0.c.C1(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y2(Result result) {
        boolean zE = this.m0.e();
        int size = result.getList().size();
        this.l0.b.f(zE, size);
        this.l0.d.setRefreshing(false);
        this.m0.d(result);
        if (size > 0) {
            F2(result);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // y55.a
    public void a(Vod vod) {
        if (vod.isAction()) {
            this.n0.p(J2(), vod.getAction());
            return;
        }
        if (vod.isFolder()) {
            K2().J2(vod.getId(), this.k0);
        } else if (L2().isIndex()) {
            SearchActivity.V1(X1(), vod.getName());
        } else {
            VideoActivity.o8(X1(), J2(), vod.getId(), vod.getName(), vod.getPic(), R2() ? vod.getName() : null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a3(Style style) {
        CustomRecyclerView customRecyclerView = this.l0.c;
        y55 y55Var = new y55(this, style, fh3.g(X1(), style));
        this.o0 = y55Var;
        customRecyclerView.setAdapter(y55Var);
        this.l0.c.setLayoutManager(style.isList() ? new LinearLayoutManager(X1()) : new GridLayoutManager(U(), fh3.b(X1(), style)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(String str, Value value) {
        boolean zIsActivated = value.isActivated();
        HashMap map = this.k0;
        if (zIsActivated) {
            map.put(str, value.getV());
        } else {
            map.remove(str);
        }
        q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void q() {
        if (S2()) {
            I2();
        } else {
            O2();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // s60.a
    public void u(String str) {
        if (S2()) {
            return;
        }
        this.m0.j(true);
        P2(N2(), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.uh
    public i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j71 j71VarC = j71.c(layoutInflater, viewGroup, false);
        this.l0 = j71VarC;
        return j71VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.uh
    public void v2() {
        this.l0.d.setOnRefreshListener(this);
        this.l0.c.m(this.m0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.uh
    public void x2() {
        this.l0.d.setColorSchemeResources(rk3.a);
        this.l0.b.h();
        this.m0 = new s60(this);
        this.k0 = H2();
        Z2();
        b3();
        O2();
    }
}
