package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import defpackage.dp4;
import defpackage.e9;
import defpackage.hl3;
import defpackage.l35;
import defpackage.mn3;
import defpackage.nk3;
import defpackage.ob0;
import defpackage.pl3;
import defpackage.s45;
import defpackage.u2;
import defpackage.um3;
import defpackage.v45;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c implements ob0 {
    public Toolbar a;
    public int b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public androidx.appcompat.widget.a n;
    public int o;
    public int p;
    public Drawable q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements View.OnClickListener {
        public final u2 f;

        public a() {
            this.f = new u2(c.this.a.getContext(), 0, R.id.home, 0, 0, c.this.i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            Window.Callback callback = cVar.l;
            if (callback == null || !cVar.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends v45 {
        public boolean a = false;
        public final /* synthetic */ int b;

        public b(int i) {
            this.b = i;
        }

        @Override // defpackage.v45, defpackage.u45
        public void a(View view) {
            this.a = true;
        }

        @Override // defpackage.u45
        public void b(View view) {
            if (this.a) {
                return;
            }
            c.this.a.setVisibility(this.b);
        }

        @Override // defpackage.v45, defpackage.u45
        public void c(View view) {
            c.this.a.setVisibility(0);
        }
    }

    public c(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        dp4 dp4VarV = dp4.v(toolbar.getContext(), null, mn3.a, nk3.c, 0);
        this.q = dp4VarV.g(mn3.l);
        if (z) {
            CharSequence charSequenceP = dp4VarV.p(mn3.r);
            if (!TextUtils.isEmpty(charSequenceP)) {
                F(charSequenceP);
            }
            CharSequence charSequenceP2 = dp4VarV.p(mn3.p);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                E(charSequenceP2);
            }
            Drawable drawableG = dp4VarV.g(mn3.n);
            if (drawableG != null) {
                A(drawableG);
            }
            Drawable drawableG2 = dp4VarV.g(mn3.m);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.g == null && (drawable = this.q) != null) {
                D(drawable);
            }
            k(dp4VarV.k(mn3.h, 0));
            int iN = dp4VarV.n(mn3.g, 0);
            if (iN != 0) {
                y(LayoutInflater.from(this.a.getContext()).inflate(iN, (ViewGroup) this.a, false));
                k(this.b | 16);
            }
            int iM = dp4VarV.m(mn3.j, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = iM;
                this.a.setLayoutParams(layoutParams);
            }
            int iE = dp4VarV.e(mn3.f, -1);
            int iE2 = dp4VarV.e(mn3.e, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.a.K(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = dp4VarV.n(mn3.s, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.O(toolbar2.getContext(), iN2);
            }
            int iN3 = dp4VarV.n(mn3.q, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.N(toolbar3.getContext(), iN3);
            }
            int iN4 = dp4VarV.n(mn3.o, 0);
            if (iN4 != 0) {
                this.a.setPopupTheme(iN4);
            }
        } else {
            this.b = x();
        }
        dp4VarV.x();
        z(i);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    public void A(Drawable drawable) {
        this.f = drawable;
        J();
    }

    public void B(int i) {
        C(i == 0 ? null : getContext().getString(i));
    }

    public void C(CharSequence charSequence) {
        this.k = charSequence;
        H();
    }

    public void D(Drawable drawable) {
        this.g = drawable;
        I();
    }

    public void E(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void F(CharSequence charSequence) {
        this.h = true;
        G(charSequence);
    }

    public final void G(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
            if (this.h) {
                l35.i0(this.a.getRootView(), charSequence);
            }
        }
    }

    public final void H() {
        if ((this.b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.k);
            Toolbar toolbar = this.a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.p);
            } else {
                toolbar.setNavigationContentDescription(this.k);
            }
        }
    }

    public final void I() {
        int i = this.b & 4;
        Toolbar toolbar = this.a;
        if (i == 0) {
            toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        Drawable drawable = this.g;
        if (drawable == null) {
            drawable = this.q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void J() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.e;
        }
        this.a.setLogo(drawable);
    }

    @Override // defpackage.ob0
    public void a(Menu menu, i.a aVar) {
        if (this.n == null) {
            androidx.appcompat.widget.a aVar2 = new androidx.appcompat.widget.a(this.a.getContext());
            this.n = aVar2;
            aVar2.r(pl3.g);
        }
        this.n.g(aVar);
        this.a.L((e) menu, this.n);
    }

    @Override // defpackage.ob0
    public boolean b() {
        return this.a.B();
    }

    @Override // defpackage.ob0
    public void c() {
        this.m = true;
    }

    @Override // defpackage.ob0
    public void collapseActionView() {
        this.a.e();
    }

    @Override // defpackage.ob0
    public boolean d() {
        return this.a.d();
    }

    @Override // defpackage.ob0
    public boolean e() {
        return this.a.A();
    }

    @Override // defpackage.ob0
    public boolean f() {
        return this.a.w();
    }

    @Override // defpackage.ob0
    public boolean g() {
        return this.a.R();
    }

    @Override // defpackage.ob0
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // defpackage.ob0
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // defpackage.ob0
    public void h() {
        this.a.f();
    }

    @Override // defpackage.ob0
    public void i(androidx.appcompat.widget.b bVar) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = bVar;
    }

    @Override // defpackage.ob0
    public boolean j() {
        return this.a.v();
    }

    @Override // defpackage.ob0
    public void k(int i) {
        View view;
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i2 & 3) != 0) {
                J();
            }
            if ((i2 & 8) != 0) {
                int i3 = i & 8;
                Toolbar toolbar = this.a;
                if (i3 != 0) {
                    toolbar.setTitle(this.i);
                    this.a.setSubtitle(this.j);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            int i4 = i & 16;
            Toolbar toolbar2 = this.a;
            if (i4 != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    @Override // defpackage.ob0
    public Menu l() {
        return this.a.getMenu();
    }

    @Override // defpackage.ob0
    public void m(int i) {
        A(i != 0 ? e9.b(getContext(), i) : null);
    }

    @Override // defpackage.ob0
    public int n() {
        return this.o;
    }

    @Override // defpackage.ob0
    public s45 o(int i, long j) {
        return l35.e(this.a).b(i == 0 ? 1.0f : 0.0f).e(j).g(new b(i));
    }

    @Override // defpackage.ob0
    public void p(i.a aVar, e.a aVar2) {
        this.a.M(aVar, aVar2);
    }

    @Override // defpackage.ob0
    public void q(int i) {
        this.a.setVisibility(i);
    }

    @Override // defpackage.ob0
    public ViewGroup r() {
        return this.a;
    }

    @Override // defpackage.ob0
    public void s(boolean z) {
    }

    @Override // defpackage.ob0
    public void setIcon(int i) {
        setIcon(i != 0 ? e9.b(getContext(), i) : null);
    }

    @Override // defpackage.ob0
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // defpackage.ob0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        G(charSequence);
    }

    @Override // defpackage.ob0
    public int t() {
        return this.b;
    }

    @Override // defpackage.ob0
    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // defpackage.ob0
    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // defpackage.ob0
    public void w(boolean z) {
        this.a.setCollapsible(z);
    }

    public final int x() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    public void y(View view) {
        View view2 = this.d;
        if (view2 != null && (this.b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.d = view;
        if (view == null || (this.b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }

    public void z(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            B(this.p);
        }
    }

    @Override // defpackage.ob0
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        J();
    }

    public c(Toolbar toolbar, boolean z) {
        this(toolbar, z, um3.a, hl3.n);
    }
}
