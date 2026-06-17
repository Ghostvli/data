package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import defpackage.v2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class q95 extends q2 implements ActionBarOverlayLayout.d {
    public static final Interpolator D = new AccelerateInterpolator();
    public static final Interpolator E = new DecelerateInterpolator();
    public Context a;
    public Context b;
    public Activity c;
    public ActionBarOverlayLayout d;
    public ActionBarContainer e;
    public ob0 f;
    public ActionBarContextView g;
    public View h;
    public boolean k;
    public d l;
    public v2 m;
    public v2.a n;
    public boolean o;
    public boolean q;
    public boolean t;
    public boolean u;
    public boolean v;
    public t45 x;
    public boolean y;
    public boolean z;
    public ArrayList i = new ArrayList();
    public int j = -1;
    public ArrayList p = new ArrayList();
    public int r = 0;
    public boolean s = true;
    public boolean w = true;
    public final u45 A = new a();
    public final u45 B = new b();
    public final w45 C = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends v45 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.u45
        public void b(View view) {
            View view2;
            q95 q95Var = q95.this;
            if (q95Var.s && (view2 = q95Var.h) != null) {
                view2.setTranslationY(0.0f);
                q95.this.e.setTranslationY(0.0f);
            }
            q95.this.e.setVisibility(8);
            q95.this.e.setTransitioning(false);
            q95 q95Var2 = q95.this;
            q95Var2.x = null;
            q95Var2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = q95.this.d;
            if (actionBarOverlayLayout != null) {
                l35.d0(actionBarOverlayLayout);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends v45 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.u45
        public void b(View view) {
            q95 q95Var = q95.this;
            q95Var.x = null;
            q95Var.e.requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements w45 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.w45
        public void a(View view) {
            ((View) q95.this.e.getParent()).invalidate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends v2 implements e.a {
        public final Context h;
        public final e i;
        public v2.a j;
        public WeakReference k;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Context context, v2.a aVar) {
            this.h = context;
            this.j = aVar;
            e eVarX = new e(context).X(1);
            this.i = eVarX;
            eVarX.W(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            v2.a aVar = this.j;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
            if (this.j == null) {
                return;
            }
            k();
            q95.this.g.l();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public void c() {
            q95 q95Var = q95.this;
            if (q95Var.l != this) {
                return;
            }
            if (q95.w(q95Var.t, q95Var.u, false)) {
                this.j.b(this);
            } else {
                q95 q95Var2 = q95.this;
                q95Var2.m = this;
                q95Var2.n = this.j;
            }
            this.j = null;
            q95.this.v(false);
            q95.this.g.g();
            q95 q95Var3 = q95.this;
            q95Var3.d.setHideOnContentScrollEnabled(q95Var3.z);
            q95.this.l = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public View d() {
            WeakReference weakReference = this.k;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public Menu e() {
            return this.i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public MenuInflater f() {
            return new dj4(this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public CharSequence g() {
            return q95.this.g.getSubtitle();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public CharSequence i() {
            return q95.this.g.getTitle();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public void k() {
            if (q95.this.l != this) {
                return;
            }
            this.i.i0();
            try {
                this.j.d(this, this.i);
            } finally {
                this.i.h0();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public boolean l() {
            return q95.this.g.j();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public void m(View view) {
            q95.this.g.setCustomView(view);
            this.k = new WeakReference(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public void n(int i) {
            o(q95.this.a.getResources().getString(i));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public void o(CharSequence charSequence) {
            q95.this.g.setSubtitle(charSequence);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public void q(int i) {
            r(q95.this.a.getResources().getString(i));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public void r(CharSequence charSequence) {
            q95.this.g.setTitle(charSequence);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v2
        public void s(boolean z) {
            super.s(z);
            q95.this.g.setTitleOptional(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean t() {
            this.i.i0();
            try {
                return this.j.c(this, this.i);
            } finally {
                this.i.h0();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public q95(Activity activity, boolean z) {
        this.c = activity;
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z) {
            return;
        }
        this.h = decorView.findViewById(R.id.content);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean w(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.view.View */
    /* JADX WARN: Multi-variable type inference failed */
    public final ob0 A(View view) {
        if (view instanceof ob0) {
            return (ob0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(view != 0 ? view.getClass().getSimpleName() : "null"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int B() {
        return this.f.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C() {
        if (this.v) {
            this.v = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            L(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(pl3.p);
        this.d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f = A(view.findViewById(pl3.a));
        this.g = (ActionBarContextView) view.findViewById(pl3.f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(pl3.c);
        this.e = actionBarContainer;
        ob0 ob0Var = this.f;
        if (ob0Var == null || this.g == null || actionBarContainer == null) {
            e04.a(getClass().getSimpleName().concat(" can only be used with a compatible window decor layout"));
            return;
        }
        this.a = ob0Var.getContext();
        boolean z = (this.f.t() & 4) != 0;
        if (z) {
            this.k = true;
        }
        s2 s2VarB = s2.b(this.a);
        I(s2VarB.a() || z);
        G(s2VarB.e());
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, mn3.a, nk3.c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(mn3.k, false)) {
            H(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(mn3.i, 0);
        if (dimensionPixelSize != 0) {
            F(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E(int i, int i2) {
        int iT = this.f.t();
        if ((i2 & 4) != 0) {
            this.k = true;
        }
        this.f.k((i & i2) | ((~i2) & iT));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F(float f) {
        l35.l0(this.e, f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G(boolean z) {
        this.q = z;
        if (z) {
            this.e.setTabContainer(null);
            this.f.i(null);
        } else {
            this.f.i(null);
            this.e.setTabContainer(null);
        }
        boolean z2 = false;
        boolean z3 = B() == 2;
        this.f.w(!this.q && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (!this.q && z3) {
            z2 = true;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H(boolean z) {
        if (z && !this.d.x()) {
            e04.a("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        } else {
            this.z = z;
            this.d.setHideOnContentScrollEnabled(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(boolean z) {
        this.f.s(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean J() {
        return this.e.isLaidOut();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K() {
        if (this.v) {
            return;
        }
        this.v = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        L(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L(boolean z) {
        boolean zW = w(this.t, this.u, this.v);
        boolean z2 = this.w;
        if (zW) {
            if (z2) {
                return;
            }
            this.w = true;
            z(z);
            return;
        }
        if (z2) {
            this.w = false;
            y(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.u) {
            this.u = false;
            L(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z) {
        this.s = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.u) {
            return;
        }
        this.u = true;
        L(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        t45 t45Var = this.x;
        if (t45Var != null) {
            t45Var.a();
            this.x = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public boolean g() {
        ob0 ob0Var = this.f;
        if (ob0Var == null || !ob0Var.j()) {
            return false;
        }
        this.f.collapseActionView();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public void h(boolean z) {
        if (z == this.o) {
            return;
        }
        this.o = z;
        if (this.p.size() <= 0) {
            return;
        }
        w82.a(this.p.get(0));
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public int i() {
        return this.f.t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public Context j() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(nk3.e, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.a, i);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public void l(Configuration configuration) {
        G(s2.b(this.a).e());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public boolean n(int i, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.l;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i, keyEvent, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void onWindowVisibilityChanged(int i) {
        this.r = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public void q(boolean z) {
        if (this.k) {
            return;
        }
        r(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public void r(boolean z) {
        E(z ? 4 : 0, 4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public void s(boolean z) {
        t45 t45Var;
        this.y = z;
        if (z || (t45Var = this.x) == null) {
            return;
        }
        t45Var.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public void t(CharSequence charSequence) {
        this.f.setWindowTitle(charSequence);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q2
    public v2 u(v2.a aVar) {
        d dVar = this.l;
        if (dVar != null) {
            dVar.c();
        }
        this.d.setHideOnContentScrollEnabled(false);
        this.g.k();
        d dVar2 = new d(this.g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.l = dVar2;
        dVar2.k();
        this.g.h(dVar2);
        v(true);
        return dVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v(boolean z) {
        s45 s45VarF;
        s45 s45VarF2;
        if (z) {
            K();
        } else {
            C();
        }
        if (!J()) {
            ob0 ob0Var = this.f;
            if (z) {
                ob0Var.q(4);
                this.g.setVisibility(0);
                return;
            } else {
                ob0Var.q(0);
                this.g.setVisibility(8);
                return;
            }
        }
        ob0 ob0Var2 = this.f;
        if (z) {
            s45VarF = ob0Var2.o(4, 100L);
            s45VarF2 = this.g.f(0, 200L);
        } else {
            s45 s45VarO = ob0Var2.o(0, 200L);
            s45VarF = this.g.f(8, 100L);
            s45VarF2 = s45VarO;
        }
        t45 t45Var = new t45();
        t45Var.d(s45VarF, s45VarF2);
        t45Var.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x() {
        v2.a aVar = this.n;
        if (aVar != null) {
            aVar.b(this.m);
            this.m = null;
            this.n = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y(boolean z) {
        View view;
        t45 t45Var = this.x;
        if (t45Var != null) {
            t45Var.a();
        }
        if (this.r != 0 || (!this.y && !z)) {
            this.A.b(null);
            return;
        }
        this.e.setAlpha(1.0f);
        this.e.setTransitioning(true);
        t45 t45Var2 = new t45();
        float f = -this.e.getHeight();
        if (z) {
            this.e.getLocationInWindow(new int[]{0, 0});
            f -= r5[1];
        }
        s45 s45VarL = l35.e(this.e).l(f);
        s45VarL.j(this.C);
        t45Var2.c(s45VarL);
        if (this.s && (view = this.h) != null) {
            t45Var2.c(l35.e(view).l(f));
        }
        t45Var2.f(D);
        t45Var2.e(250L);
        t45Var2.g(this.A);
        this.x = t45Var2;
        t45Var2.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z(boolean z) {
        View view;
        View view2;
        t45 t45Var = this.x;
        if (t45Var != null) {
            t45Var.a();
        }
        this.e.setVisibility(0);
        if (this.r == 0 && (this.y || z)) {
            this.e.setTranslationY(0.0f);
            float f = -this.e.getHeight();
            if (z) {
                this.e.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.e.setTranslationY(f);
            t45 t45Var2 = new t45();
            s45 s45VarL = l35.e(this.e).l(0.0f);
            s45VarL.j(this.C);
            t45Var2.c(s45VarL);
            if (this.s && (view2 = this.h) != null) {
                view2.setTranslationY(f);
                t45Var2.c(l35.e(this.h).l(0.0f));
            }
            t45Var2.f(E);
            t45Var2.e(250L);
            t45Var2.g(this.B);
            this.x = t45Var2;
            t45Var2.h();
        } else {
            this.e.setAlpha(1.0f);
            this.e.setTranslationY(0.0f);
            if (this.s && (view = this.h) != null) {
                view.setTranslationY(0.0f);
            }
            this.B.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (actionBarOverlayLayout != null) {
            l35.d0(actionBarOverlayLayout);
        }
    }

    public q95(Dialog dialog) {
        D(dialog.getWindow().getDecorView());
    }
}
