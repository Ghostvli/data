package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import defpackage.al3;
import defpackage.bs2;
import defpackage.cs2;
import defpackage.hb1;
import defpackage.hm3;
import defpackage.zr2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends bs2 implements i, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int G = hm3.e;
    public boolean B;
    public i.a C;
    public ViewTreeObserver D;
    public PopupWindow.OnDismissListener E;
    public boolean F;
    public final Context g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean k;
    public final Handler l;
    public View t;
    public View u;
    public boolean w;
    public boolean x;
    public int y;
    public int z;
    public final List m = new ArrayList();
    public final List n = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener o = new a();
    public final View.OnAttachStateChangeListener p = new ViewOnAttachStateChangeListenerC0003b();
    public final zr2 q = new c();
    public int r = 0;
    public int s = 0;
    public boolean A = false;
    public int v = F();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.a() || b.this.n.size() <= 0 || ((d) b.this.n.get(0)).a.B()) {
                return;
            }
            View view = b.this.u;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it = b.this.n.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a.h();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class ViewOnAttachStateChangeListenerC0003b implements View.OnAttachStateChangeListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ViewOnAttachStateChangeListenerC0003b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.D;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.D = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.D.removeGlobalOnLayoutListener(bVar.o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements zr2 {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Runnable {
            public final /* synthetic */ d f;
            public final /* synthetic */ MenuItem g;
            public final /* synthetic */ e h;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(d dVar, MenuItem menuItem, e eVar) {
                this.f = dVar;
                this.g = menuItem;
                this.h = eVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f;
                if (dVar != null) {
                    b.this.F = true;
                    dVar.b.e(false);
                    b.this.F = false;
                }
                if (this.g.isEnabled() && this.g.hasSubMenu()) {
                    this.h.O(this.g, 4);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zr2
        public void d(e eVar, MenuItem menuItem) {
            b.this.l.removeCallbacksAndMessages(null);
            int size = b.this.n.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (eVar == ((d) b.this.n.get(i)).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            b.this.l.postAtTime(new a(i2 < b.this.n.size() ? (d) b.this.n.get(i2) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zr2
        public void g(e eVar, MenuItem menuItem) {
            b.this.l.removeCallbacksAndMessages(eVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final cs2 a;
        public final e b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(cs2 cs2Var, e eVar, int i) {
            this.a = cs2Var;
            this.b = eVar;
            this.c = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ListView a() {
            return this.a.k();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b(Context context, View view, int i, int i2, boolean z) {
        this.g = context;
        this.t = view;
        this.i = i;
        this.j = i2;
        this.k = z;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(al3.b));
        this.l = new Handler();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final cs2 B() {
        cs2 cs2Var = new cs2(this.g, null, this.i, this.j);
        cs2Var.U(this.q);
        cs2Var.L(this);
        cs2Var.K(this);
        cs2Var.D(this.t);
        cs2Var.G(this.s);
        cs2Var.J(true);
        cs2Var.I(2);
        return cs2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int C(e eVar) {
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            if (eVar == ((d) this.n.get(i)).b) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final MenuItem D(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = eVar.getItem(i);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View E(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemD = D(dVar.b, eVar);
        if (menuItemD == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            headersCount = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemD == dVar2.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int F() {
        return this.t.getLayoutDirection() == 1 ? 0 : 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int G(int i) {
        List list = this.n;
        ListView listViewA = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.u.getWindowVisibleDisplayFrame(rect);
        return this.v == 1 ? (iArr[0] + listViewA.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(e eVar) {
        d dVar;
        View viewE;
        int i;
        int i2;
        int i3;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.g);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, layoutInflaterFrom, this.k, G);
        if (!a() && this.A) {
            dVar2.d(true);
        } else if (a()) {
            dVar2.d(bs2.z(eVar));
        }
        int iQ = bs2.q(dVar2, null, this.g, this.h);
        cs2 cs2VarB = B();
        cs2VarB.p(dVar2);
        cs2VarB.F(iQ);
        cs2VarB.G(this.s);
        if (this.n.size() > 0) {
            List list = this.n;
            dVar = (d) list.get(list.size() - 1);
            viewE = E(dVar, eVar);
        } else {
            dVar = null;
            viewE = null;
        }
        if (viewE != null) {
            cs2VarB.V(false);
            cs2VarB.S(null);
            int iG = G(iQ);
            boolean z = iG == 1;
            this.v = iG;
            if (Build.VERSION.SDK_INT >= 26) {
                cs2VarB.D(viewE);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.t.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewE.getLocationOnScreen(iArr2);
                if ((this.s & 7) == 5) {
                    iArr[0] = iArr[0] + this.t.getWidth();
                    iArr2[0] = iArr2[0] + viewE.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.s & 5) == 5) {
                if (!z) {
                    iQ = viewE.getWidth();
                    i3 = i - iQ;
                }
                i3 = i + iQ;
            } else {
                if (z) {
                    iQ = viewE.getWidth();
                    i3 = i + iQ;
                }
                i3 = i - iQ;
            }
            cs2VarB.e(i3);
            cs2VarB.N(true);
            cs2VarB.l(i2);
        } else {
            if (this.w) {
                cs2VarB.e(this.y);
            }
            if (this.x) {
                cs2VarB.l(this.z);
            }
            cs2VarB.H(p());
        }
        this.n.add(new d(cs2VarB, eVar, this.v));
        cs2VarB.h();
        ListView listViewK = cs2VarB.k();
        listViewK.setOnKeyListener(this);
        if (dVar == null && this.B && eVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(hm3.l, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.z());
            listViewK.addHeaderView(frameLayout, null, false);
            cs2VarB.h();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n64
    public boolean a() {
        return this.n.size() > 0 && ((d) this.n.get(0)).a.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public void b(e eVar, boolean z) {
        int iC = C(eVar);
        if (iC < 0) {
            return;
        }
        int i = iC + 1;
        if (i < this.n.size()) {
            ((d) this.n.get(i)).b.e(false);
        }
        d dVar = (d) this.n.remove(iC);
        dVar.b.R(this);
        if (this.F) {
            dVar.a.T(null);
            dVar.a.E(0);
        }
        dVar.a.dismiss();
        int size = this.n.size();
        if (size > 0) {
            this.v = ((d) this.n.get(size - 1)).c;
        } else {
            this.v = F();
        }
        if (size != 0) {
            if (z) {
                ((d) this.n.get(0)).b.e(false);
                return;
            }
            return;
        }
        dismiss();
        i.a aVar = this.C;
        if (aVar != null) {
            aVar.b(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.D;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.D.removeGlobalOnLayoutListener(this.o);
            }
            this.D = null;
        }
        this.u.removeOnAttachStateChangeListener(this.p);
        this.E.onDismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public void c(boolean z) {
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            bs2.A(((d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public boolean d() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n64
    public void dismiss() {
        int size = this.n.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.n.toArray(new d[size]);
            for (int i = size - 1; i >= 0; i--) {
                d dVar = dVarArr[i];
                if (dVar.a.a()) {
                    dVar.a.dismiss();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public void g(i.a aVar) {
        this.C = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n64
    public void h() {
        if (a()) {
            return;
        }
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            H((e) it.next());
        }
        this.m.clear();
        View view = this.t;
        this.u = view;
        if (view != null) {
            boolean z = this.D == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.D = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.o);
            }
            this.u.addOnAttachStateChangeListener(this.p);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public void j(Parcelable parcelable) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n64
    public ListView k() {
        if (this.n.isEmpty()) {
            return null;
        }
        return ((d) this.n.get(r1.size() - 1)).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public boolean l(l lVar) {
        for (d dVar : this.n) {
            if (lVar == dVar.b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        n(lVar);
        i.a aVar = this.C;
        if (aVar != null) {
            aVar.c(lVar);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public Parcelable m() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public void n(e eVar) {
        eVar.c(this, this.g);
        if (a()) {
            H(eVar);
        } else {
            this.m.add(eVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public boolean o() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.n.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.n.get(i);
            if (!dVar.a.a()) {
                break;
            } else {
                i++;
            }
        }
        if (dVar != null) {
            dVar.b.e(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public void r(View view) {
        if (this.t != view) {
            this.t = view;
            this.s = hb1.b(this.r, view.getLayoutDirection());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public void t(boolean z) {
        this.A = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public void u(int i) {
        if (this.r != i) {
            this.r = i;
            this.s = hb1.b(i, this.t.getLayoutDirection());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public void v(int i) {
        this.w = true;
        this.y = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public void w(PopupWindow.OnDismissListener onDismissListener) {
        this.E = onDismissListener;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public void x(boolean z) {
        this.B = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bs2
    public void y(int i) {
        this.x = true;
        this.z = i;
    }
}
