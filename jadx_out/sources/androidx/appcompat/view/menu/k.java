package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import defpackage.al3;
import defpackage.bs2;
import defpackage.cs2;
import defpackage.e04;
import defpackage.hm3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends bs2 implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, i, View.OnKeyListener {
    public static final int A = hm3.m;
    public final Context g;
    public final e h;
    public final d i;
    public final boolean j;
    public final int k;
    public final int l;
    public final int m;
    public final cs2 n;
    public PopupWindow.OnDismissListener q;
    public View r;
    public View s;
    public i.a t;
    public ViewTreeObserver u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean z;
    public final ViewTreeObserver.OnGlobalLayoutListener o = new a();
    public final View.OnAttachStateChangeListener p = new b();
    public int y = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!k.this.a() || k.this.n.B()) {
                return;
            }
            View view = k.this.s;
            if (view == null || !view.isShown()) {
                k.this.dismiss();
            } else {
                k.this.n.h();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = k.this.u;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    k.this.u = view.getViewTreeObserver();
                }
                k kVar = k.this;
                kVar.u.removeGlobalOnLayoutListener(kVar.o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public k(Context context, e eVar, View view, int i, int i2, boolean z) {
        this.g = context;
        this.h = eVar;
        this.j = z;
        this.i = new d(eVar, LayoutInflater.from(context), z, A);
        this.l = i;
        this.m = i2;
        Resources resources = context.getResources();
        this.k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(al3.b));
        this.r = view;
        this.n = new cs2(context, null, i, i2);
        eVar.c(this, context);
    }

    public final boolean B() {
        View view;
        if (a()) {
            return true;
        }
        if (this.v || (view = this.r) == null) {
            return false;
        }
        this.s = view;
        this.n.K(this);
        this.n.L(this);
        this.n.J(true);
        View view2 = this.s;
        boolean z = this.u == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.u = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.o);
        }
        view2.addOnAttachStateChangeListener(this.p);
        this.n.D(view2);
        this.n.G(this.y);
        if (!this.w) {
            this.x = bs2.q(this.i, null, this.g, this.k);
            this.w = true;
        }
        this.n.F(this.x);
        this.n.I(2);
        this.n.H(p());
        this.n.h();
        ListView listViewK = this.n.k();
        listViewK.setOnKeyListener(this);
        if (this.z && this.h.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.g).inflate(hm3.l, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.h.z());
            }
            frameLayout.setEnabled(false);
            listViewK.addHeaderView(frameLayout, null, false);
        }
        this.n.p(this.i);
        this.n.h();
        return true;
    }

    @Override // defpackage.n64
    public boolean a() {
        return !this.v && this.n.a();
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(e eVar, boolean z) {
        if (eVar != this.h) {
            return;
        }
        dismiss();
        i.a aVar = this.t;
        if (aVar != null) {
            aVar.b(eVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void c(boolean z) {
        this.w = false;
        d dVar = this.i;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean d() {
        return false;
    }

    @Override // defpackage.n64
    public void dismiss() {
        if (a()) {
            this.n.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void g(i.a aVar) {
        this.t = aVar;
    }

    @Override // defpackage.n64
    public void h() {
        if (B()) {
            return;
        }
        e04.a("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // androidx.appcompat.view.menu.i
    public void j(Parcelable parcelable) {
    }

    @Override // defpackage.n64
    public ListView k() {
        return this.n.k();
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean l(l lVar) {
        if (lVar.hasVisibleItems()) {
            h hVar = new h(this.g, lVar, this.s, this.j, this.l, this.m);
            hVar.j(this.t);
            hVar.g(bs2.z(lVar));
            hVar.i(this.q);
            this.q = null;
            this.h.e(false);
            int iC = this.n.c();
            int iO = this.n.o();
            if ((Gravity.getAbsoluteGravity(this.y, this.r.getLayoutDirection()) & 7) == 5) {
                iC += this.r.getWidth();
            }
            if (hVar.n(iC, iO)) {
                i.a aVar = this.t;
                if (aVar == null) {
                    return true;
                }
                aVar.c(lVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable m() {
        return null;
    }

    @Override // defpackage.bs2
    public void n(e eVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.v = true;
        this.h.close();
        ViewTreeObserver viewTreeObserver = this.u;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.u = this.s.getViewTreeObserver();
            }
            this.u.removeGlobalOnLayoutListener(this.o);
            this.u = null;
        }
        this.s.removeOnAttachStateChangeListener(this.p);
        PopupWindow.OnDismissListener onDismissListener = this.q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // defpackage.bs2
    public void r(View view) {
        this.r = view;
    }

    @Override // defpackage.bs2
    public void t(boolean z) {
        this.i.d(z);
    }

    @Override // defpackage.bs2
    public void u(int i) {
        this.y = i;
    }

    @Override // defpackage.bs2
    public void v(int i) {
        this.n.e(i);
    }

    @Override // defpackage.bs2
    public void w(PopupWindow.OnDismissListener onDismissListener) {
        this.q = onDismissListener;
    }

    @Override // defpackage.bs2
    public void x(boolean z) {
        this.z = z;
    }

    @Override // defpackage.bs2
    public void y(int i) {
        this.n.l(i);
    }
}
