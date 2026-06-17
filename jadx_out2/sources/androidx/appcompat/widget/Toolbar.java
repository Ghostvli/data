package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.dj4;
import defpackage.dp4;
import defpackage.ds2;
import defpackage.e9;
import defpackage.f55;
import defpackage.hb1;
import defpackage.k9;
import defpackage.l35;
import defpackage.lv;
import defpackage.mn3;
import defpackage.nk3;
import defpackage.ob0;
import defpackage.p;
import defpackage.pu3;
import defpackage.q2;
import defpackage.up4;
import defpackage.vr2;
import defpackage.w8;
import defpackage.xr2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements vr2 {
    public int A;
    public int B;
    public CharSequence C;
    public CharSequence D;
    public ColorStateList E;
    public ColorStateList F;
    public boolean G;
    public boolean H;
    public final ArrayList I;
    public final ArrayList J;
    public final int[] K;
    public final xr2 L;
    public ArrayList M;
    public h N;
    public final ActionMenuView.e O;
    public androidx.appcompat.widget.c P;
    public androidx.appcompat.widget.a Q;
    public f R;
    public i.a S;
    public e.a T;
    public boolean U;
    public OnBackInvokedCallback V;
    public OnBackInvokedDispatcher W;
    public boolean a0;
    public final Runnable b0;
    public ActionMenuView f;
    public TextView g;
    public TextView h;
    public ImageButton i;
    public ImageView j;
    public Drawable k;
    public CharSequence l;
    public ImageButton m;
    public View n;
    public Context o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public pu3 y;
    public int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ActionMenuView.e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.L.f(menuItem)) {
                return true;
            }
            h hVar = Toolbar.this.N;
            if (hVar != null) {
                return hVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.R();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements e.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.T;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.f.F()) {
                Toolbar.this.L.g(eVar);
            }
            e.a aVar = Toolbar.this.T;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements View.OnClickListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: rp4
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements androidx.appcompat.view.menu.i {
        public androidx.appcompat.view.menu.e f;
        public androidx.appcompat.view.menu.g g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public void c(boolean z) {
            if (this.g != null) {
                androidx.appcompat.view.menu.e eVar = this.f;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f.getItem(i) == this.g) {
                            return;
                        }
                    }
                }
                e(this.f, this.g);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public boolean d() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public boolean e(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.n;
            if (callback instanceof lv) {
                ((lv) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.n);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.m);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.n = null;
            toolbar3.a();
            this.g = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.S();
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public boolean f(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.m.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.m);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.m);
            }
            Toolbar.this.n = gVar.getActionView();
            this.g = gVar;
            ViewParent parent2 = Toolbar.this.n.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.n);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.a = (toolbar4.s & Token.ASSIGN_MOD) | 8388611;
                gVarGenerateDefaultLayoutParams.b = 2;
                toolbar4.n.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.n);
            }
            Toolbar.this.J();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.n;
            if (callback instanceof lv) {
                ((lv) callback).onActionViewExpanded();
            }
            Toolbar.this.S();
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public int getId() {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public void i(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f;
            if (eVar2 != null && (gVar = this.g) != null) {
                eVar2.f(gVar);
            }
            this.f = eVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public void j(Parcelable parcelable) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public boolean l(l lVar) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i
        public Parcelable m() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface h {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B = 8388627;
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new int[2];
        this.L = new xr2(new Runnable() { // from class: qp4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.y();
            }
        });
        this.M = new ArrayList();
        this.O = new a();
        this.b0 = new b();
        dp4 dp4VarV = dp4.v(getContext(), attributeSet, mn3.L2, i2, 0);
        l35.e0(this, context, mn3.L2, attributeSet, dp4VarV.r(), i2, 0);
        this.q = dp4VarV.n(mn3.n3, 0);
        this.r = dp4VarV.n(mn3.e3, 0);
        this.B = dp4VarV.l(mn3.M2, this.B);
        this.s = dp4VarV.l(mn3.N2, 48);
        int iE = dp4VarV.e(mn3.h3, 0);
        iE = dp4VarV.s(mn3.m3) ? dp4VarV.e(mn3.m3, iE) : iE;
        this.x = iE;
        this.w = iE;
        this.v = iE;
        this.u = iE;
        int iE2 = dp4VarV.e(mn3.k3, -1);
        if (iE2 >= 0) {
            this.u = iE2;
        }
        int iE3 = dp4VarV.e(mn3.j3, -1);
        if (iE3 >= 0) {
            this.v = iE3;
        }
        int iE4 = dp4VarV.e(mn3.l3, -1);
        if (iE4 >= 0) {
            this.w = iE4;
        }
        int iE5 = dp4VarV.e(mn3.i3, -1);
        if (iE5 >= 0) {
            this.x = iE5;
        }
        this.t = dp4VarV.f(mn3.Y2, -1);
        int iE6 = dp4VarV.e(mn3.U2, Integer.MIN_VALUE);
        int iE7 = dp4VarV.e(mn3.Q2, Integer.MIN_VALUE);
        int iF = dp4VarV.f(mn3.S2, 0);
        int iF2 = dp4VarV.f(mn3.T2, 0);
        h();
        this.y.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.y.g(iE6, iE7);
        }
        this.z = dp4VarV.e(mn3.V2, Integer.MIN_VALUE);
        this.A = dp4VarV.e(mn3.R2, Integer.MIN_VALUE);
        this.k = dp4VarV.g(mn3.P2);
        this.l = dp4VarV.p(mn3.O2);
        CharSequence charSequenceP = dp4VarV.p(mn3.g3);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = dp4VarV.p(mn3.d3);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.o = getContext();
        setPopupTheme(dp4VarV.n(mn3.c3, 0));
        Drawable drawableG = dp4VarV.g(mn3.b3);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = dp4VarV.p(mn3.a3);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = dp4VarV.g(mn3.W2);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = dp4VarV.p(mn3.X2);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        if (dp4VarV.s(mn3.o3)) {
            setTitleTextColor(dp4VarV.c(mn3.o3));
        }
        if (dp4VarV.s(mn3.f3)) {
            setSubtitleTextColor(dp4VarV.c(mn3.f3));
        }
        if (dp4VarV.s(mn3.Z2)) {
            x(dp4VarV.n(mn3.Z2, 0));
        }
        dp4VarV.x();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private MenuInflater getMenuInflater() {
        return new dj4(getContext());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean A() {
        ActionMenuView actionMenuView = this.f;
        return actionMenuView != null && actionMenuView.E();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B() {
        ActionMenuView actionMenuView = this.f;
        return actionMenuView != null && actionMenuView.F();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int C(View view, int i2, int[] iArr, int i3) {
        g gVar = (g) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int iQ = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vr2
    public void D(ds2 ds2Var) {
        this.L.b(ds2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int E(View view, int i2, int[] iArr, int i3) {
        g gVar = (g) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int iQ = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int F(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, Buffer.MAX_SIZE);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.L.d(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.M = currentMenuItems2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I() {
        removeCallbacks(this.b0);
        post(this.b0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).b != 2 && childAt != this.f) {
                removeViewAt(childCount);
                this.J.add(childAt);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K(int i2, int i3) {
        h();
        this.y.g(i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L(androidx.appcompat.view.menu.e eVar, androidx.appcompat.widget.a aVar) {
        if (eVar == null && this.f == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e eVarJ = this.f.J();
        if (eVarJ == eVar) {
            return;
        }
        if (eVarJ != null) {
            eVarJ.R(this.Q);
            eVarJ.R(this.R);
        }
        if (this.R == null) {
            this.R = new f();
        }
        aVar.I(true);
        Context context = this.o;
        if (eVar != null) {
            eVar.c(aVar, context);
            eVar.c(this.R, this.o);
        } else {
            aVar.i(context, null);
            this.R.i(this.o, null);
            aVar.c(true);
            this.R.c(true);
        }
        this.f.setPopupTheme(this.p);
        this.f.setPresenter(aVar);
        this.Q = aVar;
        S();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M(i.a aVar, e.a aVar2) {
        this.S = aVar;
        this.T = aVar2;
        ActionMenuView actionMenuView = this.f;
        if (actionMenuView != null) {
            actionMenuView.K(aVar, aVar2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N(Context context, int i2) {
        this.r = i2;
        TextView textView = this.h;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(Context context, int i2) {
        this.q = i2;
        TextView textView = this.g;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean P() {
        if (!this.U) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (Q(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Q(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean R() {
        ActionMenuView actionMenuView = this.f;
        return actionMenuView != null && actionMenuView.L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z = v() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.a0;
            if (z && this.W == null) {
                if (this.V == null) {
                    this.V = e.b(new Runnable() { // from class: pp4
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.e();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.V);
                this.W = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.W) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.V);
            this.W = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:3:0x0008 */
    public void a() {
        int size = this.J.size();
        while (true) {
            size--;
            ArrayList arrayList = this.J;
            if (size < 0) {
                arrayList.clear();
                return;
            }
            addView((View) arrayList.get(size));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(List list, int i2) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iB = hb1.b(i2, getLayoutDirection());
        list.clear();
        if (!z) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.b == 0 && Q(childAt) && p(gVar.a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.b == 0 && Q(childAt2) && p(gVar2.a) == iB) {
                list.add(childAt2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.b = 1;
        if (!z || this.n == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.J.add(view);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f) != null && actionMenuView.G();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e() {
        f fVar = this.R;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.g;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f() {
        ActionMenuView actionMenuView = this.f;
        if (actionMenuView != null) {
            actionMenuView.x();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        if (this.m == null) {
            w8 w8Var = new w8(getContext(), null, nk3.L);
            this.m = w8Var;
            w8Var.setImageDrawable(this.k);
            this.m.setContentDescription(this.l);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.a = (this.s & Token.ASSIGN_MOD) | 8388611;
            gVarGenerateDefaultLayoutParams.b = 2;
            this.m.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.m.setOnClickListener(new d());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getContentInsetEnd() {
        pu3 pu3Var = this.y;
        if (pu3Var != null) {
            return pu3Var.a();
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getContentInsetEndWithActions() {
        int i2 = this.A;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getContentInsetLeft() {
        pu3 pu3Var = this.y;
        if (pu3Var != null) {
            return pu3Var.b();
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getContentInsetRight() {
        pu3 pu3Var = this.y;
        if (pu3Var != null) {
            return pu3Var.c();
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getContentInsetStart() {
        pu3 pu3Var = this.y;
        if (pu3Var != null) {
            return pu3Var.d();
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getContentInsetStartWithNavigation() {
        int i2 = this.z;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarJ;
        ActionMenuView actionMenuView = this.f;
        return (actionMenuView == null || (eVarJ = actionMenuView.J()) == null || !eVarJ.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.A, 0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.z, 0)) : getContentInsetStart();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getLogo() {
        ImageView imageView = this.j;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence getLogoDescription() {
        ImageView imageView = this.j;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Menu getMenu() {
        j();
        return this.f.getMenu();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View getNavButtonView() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public androidx.appcompat.widget.a getOuterActionMenuPresenter() {
        return this.Q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getOverflowIcon() {
        j();
        return this.f.getOverflowIcon();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Context getPopupContext() {
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPopupTheme() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence getSubtitle() {
        return this.D;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final TextView getSubtitleTextView() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence getTitle() {
        return this.C;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTitleMarginBottom() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTitleMarginEnd() {
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTitleMarginStart() {
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTitleMarginTop() {
        return this.w;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final TextView getTitleTextView() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ob0 getWrapper() {
        if (this.P == null) {
            this.P = new androidx.appcompat.widget.c(this, true);
        }
        return this.P;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        if (this.y == null) {
            this.y = new pu3();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i() {
        if (this.j == null) {
            this.j = new AppCompatImageView(getContext());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j() {
        k();
        if (this.f.J() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f.getMenu();
            if (this.R == null) {
                this.R = new f();
            }
            this.f.setExpandedActionViewsExclusive(true);
            eVar.c(this.R, this.o);
            S();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k() {
        if (this.f == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f = actionMenuView;
            actionMenuView.setPopupTheme(this.p);
            this.f.setOnMenuItemClickListener(this.O);
            this.f.K(this.S, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.a = (this.s & Token.ASSIGN_MOD) | 8388613;
            this.f.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f, false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l() {
        if (this.i == null) {
            this.i = new w8(getContext(), null, nk3.L);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.a = (this.s & Token.ASSIGN_MOD) | 8388611;
            this.i.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams; */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams; */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams; */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof q2.a ? new g((q2.a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        S();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.b0);
        S();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.H = false;
        }
        if (!this.H) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.H = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.H = false;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:111:0x028f A[LOOP:0: B:109:0x028b->B:111:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ab A[LOOP:1: B:113:0x02a7->B:115:0x02ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e0 A[LOOP:2: B:123:0x02dc->B:125:0x02e0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x029c A[EDGE_INSN: B:128:0x029c->B:112:0x029c BREAK  A[LOOP:0: B:109:0x028b->B:111:0x028f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02b8 A[EDGE_INSN: B:129:0x02b8->B:116:0x02b8 BREAK  A[LOOP:1: B:113:0x02a7->B:115:0x02ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0214  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iC;
        int iE;
        int iMax;
        int iMin;
        boolean zQ;
        boolean zQ2;
        boolean z2;
        int measuredHeight;
        int i6;
        int paddingTop;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int size;
        int iC2;
        int i12;
        ArrayList arrayList;
        int size2;
        int i13;
        ArrayList arrayList2;
        int i14;
        int size3;
        ArrayList arrayList3;
        boolean z3 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i15 = width - paddingRight;
        int[] iArr = this.K;
        iArr[1] = 0;
        iArr[0] = 0;
        int iY = l35.y(this);
        int iMin2 = iY >= 0 ? Math.min(iY, i5 - i3) : 0;
        if (Q(this.i)) {
            View view = this.i;
            if (z3) {
                iE = E(view, i15, iArr, iMin2);
                iC = paddingLeft;
                if (Q(this.m)) {
                    View view2 = this.m;
                    if (z3) {
                        iE = E(view2, iE, iArr, iMin2);
                    } else {
                        iC = C(view2, iC, iArr, iMin2);
                    }
                }
                if (Q(this.f)) {
                    View view3 = this.f;
                    if (z3) {
                        iC = C(view3, iC, iArr, iMin2);
                    } else {
                        iE = E(view3, iE, iArr, iMin2);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - iC);
                iArr[1] = Math.max(0, currentContentInsetRight - (i15 - iE));
                iMax = Math.max(iC, currentContentInsetLeft);
                iMin = Math.min(iE, i15 - currentContentInsetRight);
                if (Q(this.n)) {
                    View view4 = this.n;
                    if (z3) {
                        iMin = E(view4, iMin, iArr, iMin2);
                    } else {
                        iMax = C(view4, iMax, iArr, iMin2);
                    }
                }
                if (Q(this.j)) {
                    View view5 = this.j;
                    if (z3) {
                        iMin = E(view5, iMin, iArr, iMin2);
                    } else {
                        iMax = C(view5, iMax, iArr, iMin2);
                    }
                }
                zQ = Q(this.g);
                zQ2 = Q(this.h);
                if (zQ) {
                    z2 = z3;
                    measuredHeight = 0;
                } else {
                    g gVar = (g) this.g.getLayoutParams();
                    z2 = z3;
                    measuredHeight = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin + ((ViewGroup.MarginLayoutParams) gVar).topMargin + this.g.getMeasuredHeight();
                }
                if (!zQ2) {
                    g gVar2 = (g) this.h.getLayoutParams();
                    measuredHeight += ((ViewGroup.MarginLayoutParams) gVar2).topMargin + this.h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin;
                }
                if (!zQ || zQ2) {
                    TextView textView = !zQ ? this.g : this.h;
                    TextView textView2 = !zQ2 ? this.h : this.g;
                    g gVar3 = (g) textView.getLayoutParams();
                    g gVar4 = (g) textView2.getLayoutParams();
                    int i16 = measuredHeight;
                    boolean z4 = (zQ && this.g.getMeasuredWidth() > 0) || (zQ2 && this.h.getMeasuredWidth() > 0);
                    i6 = this.B & Token.ASSIGN_MOD;
                    int i17 = iMax;
                    if (i6 == 48) {
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar3).topMargin + this.w;
                    } else if (i6 != 80) {
                        int iMax2 = (((height - paddingTop2) - paddingBottom) - i16) / 2;
                        int i18 = ((ViewGroup.MarginLayoutParams) gVar3).topMargin;
                        int i19 = this.w;
                        if (iMax2 < i18 + i19) {
                            iMax2 = i18 + i19;
                        } else {
                            int i20 = (((height - paddingBottom) - i16) - iMax2) - paddingTop2;
                            int i21 = ((ViewGroup.MarginLayoutParams) gVar3).bottomMargin;
                            int i22 = this.x;
                            if (i20 < i21 + i22) {
                                iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) gVar4).bottomMargin + i22) - i20));
                            }
                        }
                        paddingTop = paddingTop2 + iMax2;
                    } else {
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) gVar4).bottomMargin) - this.x) - i16;
                    }
                    if (z2) {
                        int i23 = (z4 ? this.u : 0) - iArr[1];
                        iMin -= Math.max(0, i23);
                        iArr[1] = Math.max(0, -i23);
                        if (zQ) {
                            g gVar5 = (g) this.g.getLayoutParams();
                            int measuredWidth = iMin - this.g.getMeasuredWidth();
                            int measuredHeight2 = this.g.getMeasuredHeight() + paddingTop;
                            this.g.layout(measuredWidth, paddingTop, iMin, measuredHeight2);
                            i10 = measuredWidth - this.v;
                            paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) gVar5).bottomMargin;
                        } else {
                            i10 = iMin;
                        }
                        if (zQ2) {
                            int i24 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.h.getLayoutParams())).topMargin;
                            this.h.layout(iMin - this.h.getMeasuredWidth(), i24, iMin, this.h.getMeasuredHeight() + i24);
                            i11 = iMin - this.v;
                        } else {
                            i11 = iMin;
                        }
                        if (z4) {
                            iMin = Math.min(i10, i11);
                        }
                        iMax = i17;
                        i7 = 0;
                    } else {
                        i7 = 0;
                        int i25 = (z4 ? this.u : 0) - iArr[0];
                        iMax = i17 + Math.max(0, i25);
                        iArr[0] = Math.max(0, -i25);
                        if (zQ) {
                            g gVar6 = (g) this.g.getLayoutParams();
                            int measuredWidth2 = this.g.getMeasuredWidth() + iMax;
                            int measuredHeight3 = this.g.getMeasuredHeight() + paddingTop;
                            this.g.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                            i8 = measuredWidth2 + this.v;
                            paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) gVar6).bottomMargin;
                        } else {
                            i8 = iMax;
                        }
                        if (zQ2) {
                            int i26 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.h.getLayoutParams())).topMargin;
                            int measuredWidth3 = this.h.getMeasuredWidth() + iMax;
                            this.h.layout(iMax, i26, measuredWidth3, this.h.getMeasuredHeight() + i26);
                            i9 = measuredWidth3 + this.v;
                        } else {
                            i9 = iMax;
                        }
                        if (z4) {
                            iMax = Math.max(i8, i9);
                        }
                    }
                } else {
                    i7 = 0;
                }
                b(this.I, 3);
                size = this.I.size();
                iC2 = iMax;
                i12 = i7;
                while (true) {
                    arrayList = this.I;
                    if (i12 < size) {
                        break;
                    }
                    iC2 = C((View) arrayList.get(i12), iC2, iArr, iMin2);
                    i12++;
                }
                b(arrayList, 5);
                size2 = this.I.size();
                i13 = i7;
                while (true) {
                    arrayList2 = this.I;
                    if (i13 < size2) {
                        break;
                    }
                    iMin = E((View) arrayList2.get(i13), iMin, iArr, iMin2);
                    i13++;
                }
                b(arrayList2, 1);
                int iU = u(this.I, iArr);
                i14 = (paddingLeft + (((width - paddingLeft) - paddingRight) / 2)) - (iU / 2);
                int i27 = iU + i14;
                if (i14 >= iC2) {
                    iC2 = i27 > iMin ? i14 - (i27 - iMin) : i14;
                }
                size3 = this.I.size();
                while (true) {
                    arrayList3 = this.I;
                    if (i7 < size3) {
                        arrayList3.clear();
                        return;
                    } else {
                        iC2 = C((View) arrayList3.get(i7), iC2, iArr, iMin2);
                        i7++;
                    }
                }
            } else {
                iC = C(view, paddingLeft, iArr, iMin2);
            }
        } else {
            iC = paddingLeft;
        }
        iE = i15;
        if (Q(this.m)) {
        }
        if (Q(this.f)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iC);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i15 - iE));
        iMax = Math.max(iC, currentContentInsetLeft2);
        iMin = Math.min(iE, i15 - currentContentInsetRight2);
        if (Q(this.n)) {
        }
        if (Q(this.j)) {
        }
        zQ = Q(this.g);
        zQ2 = Q(this.h);
        if (zQ) {
        }
        if (!zQ2) {
        }
        if (zQ) {
            if (!zQ) {
            }
            if (!zQ2) {
            }
            g gVar32 = (g) textView.getLayoutParams();
            g gVar42 = (g) textView2.getLayoutParams();
            int i162 = measuredHeight;
            if (zQ) {
                i6 = this.B & Token.ASSIGN_MOD;
                int i172 = iMax;
                if (i6 == 48) {
                }
                if (z2) {
                }
            } else {
                i6 = this.B & Token.ASSIGN_MOD;
                int i1722 = iMax;
                if (i6 == 48) {
                }
                if (z2) {
                }
            }
        }
        b(this.I, 3);
        size = this.I.size();
        iC2 = iMax;
        i12 = i7;
        while (true) {
            arrayList = this.I;
            if (i12 < size) {
            }
            iC2 = C((View) arrayList.get(i12), iC2, iArr, iMin2);
            i12++;
        }
        b(arrayList, 5);
        size2 = this.I.size();
        i13 = i7;
        while (true) {
            arrayList2 = this.I;
            if (i13 < size2) {
            }
            iMin = E((View) arrayList2.get(i13), iMin, iArr, iMin2);
            i13++;
        }
        b(arrayList2, 1);
        int iU2 = u(this.I, iArr);
        i14 = (paddingLeft + (((width - paddingLeft) - paddingRight) / 2)) - (iU2 / 2);
        int i272 = iU2 + i14;
        if (i14 >= iC2) {
        }
        size3 = this.I.size();
        while (true) {
            arrayList3 = this.I;
            if (i7 < size3) {
            }
            iC2 = C((View) arrayList3.get(i7), iC2, iArr, iMin2);
            i7++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int[] iArr;
        int iMax2;
        int iCombineMeasuredStates2;
        int measuredHeight;
        int[] iArr2 = this.K;
        boolean zB = f55.b(this);
        int i4 = !zB ? 1 : 0;
        if (Q(this.i)) {
            G(this.i, i2, 0, i3, 0, this.t);
            measuredWidth = this.i.getMeasuredWidth() + s(this.i);
            iMax = Math.max(0, this.i.getMeasuredHeight() + t(this.i));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.i.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (Q(this.m)) {
            G(this.m, i2, 0, i3, 0, this.t);
            measuredWidth = this.m.getMeasuredWidth() + s(this.m);
            iMax = Math.max(iMax, this.m.getMeasuredHeight() + t(this.m));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.m.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr2[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (Q(this.f)) {
            G(this.f, i2, iMax3, i3, 0, this.t);
            measuredWidth2 = this.f.getMeasuredWidth() + s(this.f);
            iMax = Math.max(iMax, this.f.getMeasuredHeight() + t(this.f));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr2[i4] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (Q(this.n)) {
            iArr = iArr2;
            iMax4 += F(this.n, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.n.getMeasuredHeight() + t(this.n));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.n.getMeasuredState());
        } else {
            iArr = iArr2;
        }
        if (Q(this.j)) {
            iMax4 += F(this.j, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.j.getMeasuredHeight() + t(this.j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.j.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (((g) childAt.getLayoutParams()).b == 0 && Q(childAt)) {
                iMax4 += F(childAt, i2, iMax4, i3, 0, iArr);
                int iMax5 = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax5;
            } else {
                iMax4 = iMax4;
            }
        }
        int i6 = iMax4;
        int i7 = this.w + this.x;
        int i8 = this.u + this.v;
        if (Q(this.g)) {
            F(this.g, i2, i6 + i8, i3, i7, iArr);
            int measuredWidth3 = this.g.getMeasuredWidth() + s(this.g);
            int measuredHeight2 = this.g.getMeasuredHeight() + t(this.g);
            iMax2 = measuredWidth3;
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.g.getMeasuredState());
            measuredHeight = measuredHeight2;
        } else {
            iMax2 = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            measuredHeight = 0;
        }
        if (Q(this.h)) {
            iMax2 = Math.max(iMax2, F(this.h, i2, i6 + i8, i3, i7 + measuredHeight, iArr));
            measuredHeight += this.h.getMeasuredHeight() + t(this.h);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.h.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i6 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2), P() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.c());
        ActionMenuView actionMenuView = this.f;
        androidx.appcompat.view.menu.e eVarJ = actionMenuView != null ? actionMenuView.J() : null;
        int i2 = iVar.h;
        if (i2 != 0 && this.R != null && eVarJ != null && (menuItemFindItem = eVarJ.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.i) {
            I();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        h();
        this.y.f(i2 == 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.R;
        if (fVar != null && (gVar = fVar.g) != null) {
            iVar.h = gVar.getItemId();
        }
        iVar.i = B();
        return iVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.G = false;
        }
        if (!this.G) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int p(int i2) {
        int layoutDirection = getLayoutDirection();
        int iB = hb1.b(i2, layoutDirection) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : layoutDirection == 1 ? 5 : 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int q(View view, int i2) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int iR = r(gVar.a);
        if (iR == 48) {
            return getPaddingTop() - i3;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int r(int i2) {
        int i3 = i2 & Token.ASSIGN_MOD;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.B & Token.ASSIGN_MOD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vr2
    public void s0(ds2 ds2Var) {
        this.L.h(ds2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.a0 != z) {
            this.a0 = z;
            S();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.m.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.m;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.k);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCollapsible(boolean z) {
        this.U = z;
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.A) {
            this.A = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.z) {
            this.z = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.j)) {
                c(this.j, true);
            }
        } else {
            ImageView imageView = this.j;
            if (imageView != null && z(imageView)) {
                removeView(this.j);
                this.J.remove(this.j);
            }
        }
        ImageView imageView2 = this.j;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            up4.a(this.i, charSequence);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.i)) {
                c(this.i, true);
            }
        } else {
            ImageButton imageButton = this.i;
            if (imageButton != null && z(imageButton)) {
                removeView(this.i);
                this.J.remove(this.i);
            }
        }
        ImageButton imageButton2 = this.i;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.i.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOnMenuItemClickListener(h hVar) {
        this.N = hVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f.setOverflowIcon(drawable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPopupTheme(int i2) {
        if (this.p != i2) {
            this.p = i2;
            if (i2 == 0) {
                this.o = getContext();
            } else {
                this.o = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSubtitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.h;
        if (!zIsEmpty) {
            if (textView == null) {
                Context context = getContext();
                k9 k9Var = new k9(context);
                this.h = k9Var;
                k9Var.setSingleLine();
                this.h.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.r;
                if (i2 != 0) {
                    this.h.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.F;
                if (colorStateList != null) {
                    this.h.setTextColor(colorStateList);
                }
            }
            if (!z(this.h)) {
                c(this.h, true);
            }
        } else if (textView != null && z(textView)) {
            removeView(this.h);
            this.J.remove(this.h);
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.D = charSequence;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.F = colorStateList;
        TextView textView = this.h;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.g;
        if (!zIsEmpty) {
            if (textView == null) {
                Context context = getContext();
                k9 k9Var = new k9(context);
                this.g = k9Var;
                k9Var.setSingleLine();
                this.g.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.q;
                if (i2 != 0) {
                    this.g.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.g.setTextColor(colorStateList);
                }
            }
            if (!z(this.g)) {
                c(this.g, true);
            }
        } else if (textView != null && z(textView)) {
            removeView(this.g);
            this.J.remove(this.g);
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.C = charSequence;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTitleMarginBottom(int i2) {
        this.x = i2;
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTitleMarginEnd(int i2) {
        this.v = i2;
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTitleMarginStart(int i2) {
        this.u = i2;
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTitleMarginTop(int i2) {
        this.w = i2;
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTitleTextColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        TextView textView = this.g;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int u(List list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = (View) list.get(i4);
            g gVar = (g) view.getLayoutParams();
            int i5 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i2;
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i2 = iMax3;
        }
        return measuredWidth;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean v() {
        f fVar = this.R;
        return (fVar == null || fVar.g == null) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean w() {
        ActionMenuView actionMenuView = this.f;
        return actionMenuView != null && actionMenuView.D();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y() {
        Iterator it = this.M.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean z(View view) {
        return view.getParent() == this || this.J.contains(view);
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends q2.a {
        public int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public g(g gVar) {
            super((q2.a) gVar);
            this.b = 0;
            this.b = gVar.b;
        }

        public g(q2.a aVar) {
            super(aVar);
            this.b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i extends p {
        public static final Parcelable.Creator<i> CREATOR = new a();
        public int h;
        public boolean i;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i) {
                return new i[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.h = parcel.readInt();
            this.i = parcel.readInt() != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.p, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(e9.b(getContext(), i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setLogo(int i2) {
        setLogo(e9.b(getContext(), i2));
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(e9.b(getContext(), i2));
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nk3.M);
    }

    public Toolbar(Context context) {
        this(context, null);
    }
}
