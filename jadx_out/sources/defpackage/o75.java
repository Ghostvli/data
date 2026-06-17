package defpackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Class;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Site;
import com.fongmi.android.tv.bean.Value;
import com.fongmi.android.tv.ui.activity.HistoryActivity;
import com.fongmi.android.tv.ui.activity.KeepActivity;
import com.fongmi.android.tv.ui.activity.SearchActivity;
import com.fongmi.android.tv.ui.activity.VideoActivity;
import com.fongmi.android.tv.ui.custom.CustomViewPager;
import com.google.android.material.appbar.AppBarLayout;
import defpackage.be4;
import defpackage.c00;
import defpackage.ku4;
import defpackage.o45;
import defpackage.qp3;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class o75 extends uh implements gz, e84, g11, ku4.a {
    public m71 k0;
    public b94 l0;
    public ku4 m0;
    public Result n0;
    public final q3 o0 = V1(new p3(), new l3() { // from class: f75
        @Override // defpackage.l3
        public final void a(Object obj) {
            this.a.c3((k3) obj);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends o45.m {
        public a() {
        }

        @Override // o45.j
        public void c(int i) {
            o75.this.k0.k.C1(i);
            o75.this.m0.O(i);
            o75.this.m3(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends to {
        public b() {
        }

        @Override // defpackage.to
        public void b(String str) {
            i43.c();
            i43.i(str);
            o75.this.r3();
        }

        @Override // defpackage.to
        public void c() {
            o75.this.s3();
            o75.this.Y2();
            o75.this.p3();
            o75.this.n3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[be4.a.values().length];
            b = iArr;
            try {
                iArr[be4.a.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[be4.a.PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[qp3.a.values().length];
            a = iArr2;
            try {
                iArr2[qp3.a.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[qp3.a.SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[qp3.a.CATEGORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends y61 {
        public d(k61 k61Var) {
            super(k61Var);
        }

        @Override // defpackage.f73
        public void a(ViewGroup viewGroup, int i, Object obj) {
        }

        @Override // defpackage.f73
        public int c() {
            return o75.this.m0.g();
        }

        @Override // defpackage.y61
        public p51 q(int i) {
            return x31.I2(o75.this.W2().getKey(), o75.this.m0.J(i), 4);
        }
    }

    public static /* synthetic */ boolean F2(String str) {
        return !TextUtils.isEmpty(str);
    }

    private x31 V2() {
        f73 adapter = this.k0.f.getAdapter();
        CustomViewPager customViewPager = this.k0.f;
        return (x31) adapter.g(customViewPager, customViewPager.getCurrentItem());
    }

    private void Z2() {
        this.k0.g.getRoot().setVisibility(8);
    }

    public static o75 e3() {
        return new o75();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(Result result) {
        ku4 ku4Var = this.m0;
        this.n0 = result;
        ku4Var.H(result);
        this.k0.f.getAdapter().i();
        m3(0);
        Z2();
        r3();
    }

    private void o3() {
        this.k0.k.setHasFixedSize(true);
        this.k0.k.setItemAnimator(null);
        RecyclerView recyclerView = this.k0.k;
        ku4 ku4Var = new ku4(this);
        this.m0 = ku4Var;
        recyclerView.setAdapter(ku4Var);
        this.k0.f.setAdapter(new d(T()));
    }

    private void q3() {
        b94 b94Var = (b94) new x(this).b(b94.class);
        this.l0 = b94Var;
        b94Var.v().f(C0(), new x43() { // from class: c75
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.l3((Result) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3() {
        this.k0.g.getRoot().setVisibility(0);
    }

    public final Config U2() {
        return b75.I().i();
    }

    public final Site W2() {
        return b75.I().O();
    }

    public Result X2() {
        Result result = this.n0;
        return result == null ? new Result() : result;
    }

    public final void Y2() {
        this.k0.k.setVisibility(4);
        this.k0.f.setVisibility(4);
    }

    public final void a3() {
        s3();
        m3(0);
        this.m0.I();
        this.l0.x();
        this.k0.f.setAdapter(new d(T()));
    }

    @Override // defpackage.gz
    public void b0(Config config) {
        b75.j0(config, new b());
    }

    public final /* synthetic */ void b3(AppBarLayout appBarLayout, int i) {
        int iA = (int) (vr3.a(12) * Math.abs((i * 1.0f) / appBarLayout.getTotalScrollRange()));
        if (this.k0.k.getPaddingTop() == iA) {
            return;
        }
        RecyclerView recyclerView = this.k0.k;
        recyclerView.setPadding(recyclerView.getPaddingStart(), iA, this.k0.k.getPaddingEnd(), this.k0.k.getPaddingBottom());
    }

    @Override // defpackage.uh, defpackage.p51
    public void c1() {
        super.c1();
        uu0.d().r(this);
    }

    public final /* synthetic */ void c3(k3 k3Var) {
        if (k3Var.d() != -1 || k3Var.c() == null || k3Var.c().getData() == null) {
            return;
        }
        VideoActivity.T4(X1(), g01.m(k3Var.c().getData()));
    }

    public final /* synthetic */ void d3(String str) {
        this.k0.h.setText(str);
    }

    public final void f3(View view) {
        if (this.m0.g() > 0) {
            i11.W2().X2(this.m0.J(this.k0.f.getCurrentItem()).getFilters()).Z2(this);
        }
    }

    public final boolean g3(View view) {
        ut1.e(this).j(this.o0).n();
        return true;
    }

    public final void h3(View view) {
        me1.c(this).f().j(0).i();
    }

    @Override // ku4.a
    public void i(int i, Class r2) {
        this.k0.f.setCurrentItem(i);
        this.m0.O(i);
    }

    public final boolean i3(MenuItem menuItem) {
        if (menuItem.getItemId() == nl3.x0) {
            KeepActivity.f2(X1());
            return true;
        }
        if (menuItem.getItemId() == nl3.M1) {
            SearchActivity.U1(X1());
            return true;
        }
        if (menuItem.getItemId() != nl3.n0) {
            return true;
        }
        HistoryActivity.d2(X1());
        return true;
    }

    @Override // defpackage.g11
    public void j(String str, Value value) {
        V2().j(str, value);
    }

    public final void j3(View view) {
        p84.i(this).h().o();
    }

    public final void k3(View view) {
        V2().K2();
        this.k0.j.setVisibility(4);
        int visibility = this.k0.c.getVisibility();
        m71 m71Var = this.k0;
        if (visibility == 4) {
            m71Var.c.l();
        } else if (m71Var.d.getVisibility() == 4) {
            this.k0.d.l();
        }
    }

    public final void m3(int i) {
        if (this.m0.g() == 0) {
            this.k0.j.setVisibility(4);
            this.k0.d.setVisibility(0);
            this.k0.c.setVisibility(8);
        } else if (!this.m0.J(i).getFilters().isEmpty()) {
            this.k0.j.setVisibility(4);
            this.k0.d.setVisibility(8);
            this.k0.c.l();
        } else if (i == 0 || this.m0.J(i).getFilters().isEmpty()) {
            this.k0.j.setVisibility(4);
            this.k0.c.setVisibility(8);
            this.k0.d.l();
        }
    }

    public final void n3() {
        si1.j(this.k0.e);
    }

    @Override // defpackage.e84
    public void o(Site site) {
        b75.I().q0(site);
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onCastEvent(wq wqVar) {
        qo3.X2().Y2(wqVar).d3(this);
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onConfigEvent(c00 c00Var) {
        if (c00Var.h() == c00.a.VOD) {
            n3();
        }
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onRefreshEvent(qp3 qp3Var) {
        int i = c.a[qp3Var.e().ordinal()];
        if (i == 1) {
            p3();
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            V2().q();
            return;
        }
        a3();
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onStateEvent(be4 be4Var) {
        int i = c.b[be4Var.d().ordinal()];
        if (i == 1) {
            Z2();
        } else {
            if (i != 2) {
                return;
            }
            s3();
        }
    }

    public final void p3() {
        Arrays.asList(W2().getName(), U2().getName(), y0(sm3.b)).stream().filter(new Predicate() { // from class: d75
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return o75.F2((String) obj);
            }
        }).findFirst().ifPresent(new Consumer() { // from class: e75
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.d3((String) obj);
            }
        });
    }

    public final void r3() {
        this.k0.k.setVisibility(0);
        this.k0.f.setVisibility(0);
    }

    @Override // defpackage.uh
    public boolean t2() {
        if (this.k0.f.getAdapter() == null || this.k0.f.getAdapter().c() == 0 || !V2().t2()) {
            return true;
        }
        V2().H2();
        return false;
    }

    @Override // defpackage.uh
    public i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m71 m71VarC = m71.c(layoutInflater, viewGroup, false);
        this.k0 = m71VarC;
        return m71VarC;
    }

    @Override // defpackage.uh
    public void v2() {
        this.k0.j.setOnClickListener(new View.OnClickListener() { // from class: g75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.k3(view);
            }
        });
        this.k0.e.setOnClickListener(new View.OnClickListener() { // from class: h75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.h3(view);
            }
        });
        this.k0.d.setOnClickListener(new View.OnClickListener() { // from class: i75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.g3(view);
            }
        });
        this.k0.h.setOnClickListener(new View.OnClickListener() { // from class: j75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.j3(view);
            }
        });
        this.k0.c.setOnClickListener(new View.OnClickListener() { // from class: k75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.f3(view);
            }
        });
        this.k0.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: l75
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.g3(view);
            }
        });
        this.k0.i.setOnMenuItemClickListener(new Toolbar.h() { // from class: m75
            @Override // androidx.appcompat.widget.Toolbar.h
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.a.i3(menuItem);
            }
        });
        this.k0.b.d(new AppBarLayout.f() { // from class: n75
            @Override // com.google.android.material.appbar.AppBarLayout.b
            public final void a(AppBarLayout appBarLayout, int i) {
                this.a.b3(appBarLayout, i);
            }
        });
        this.k0.f.c(new a());
    }

    @Override // defpackage.uh
    public void x2() {
        uu0.d().p(this);
        this.k0.h.setSelected(true);
        o3();
        q3();
        s3();
        p3();
        n3();
    }
}
