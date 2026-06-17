package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import defpackage.d51;
import defpackage.hm3;
import defpackage.n64;
import defpackage.nk3;
import defpackage.s2;
import defpackage.tn0;
import defpackage.up4;
import defpackage.w2;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.appcompat.view.menu.a implements w2.a {
    public boolean A;
    public int B;
    public final SparseBooleanArray C;
    public e D;
    public C0004a E;
    public c F;
    public b G;
    public final f H;
    public int I;
    public d p;
    public Drawable q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C0004a extends h {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0004a(Context context, l lVar, View view) {
            super(context, lVar, view, false, nk3.i);
            if (!((androidx.appcompat.view.menu.g) lVar.getItem()).l()) {
                View view2 = a.this.p;
                f(view2 == null ? (View) a.this.n : view2);
            }
            j(a.this.H);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.h
        public void e() {
            a aVar = a.this;
            aVar.E = null;
            aVar.I = 0;
            super.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends ActionMenuItemView.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public n64 a() {
            C0004a c0004a = a.this.E;
            if (c0004a != null) {
                return c0004a.c();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        public e f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(e eVar) {
            this.f = eVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.h != null) {
                a.this.h.d();
            }
            View view = (View) a.this.n;
            if (view != null && view.getWindowToken() != null && this.f.m()) {
                a.this.D = this.f;
            }
            a.this.F = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends AppCompatImageView implements ActionMenuView.a {

        /* JADX INFO: renamed from: androidx.appcompat.widget.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0005a extends d51 {
            public final /* synthetic */ a o;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0005a(View view, a aVar) {
                super(view);
                this.o = aVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.d51
            public n64 b() {
                e eVar = a.this.D;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.d51
            public boolean c() {
                a.this.M();
                return true;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.d51
            public boolean d() {
                a aVar = a.this;
                if (aVar.F != null) {
                    return false;
                }
                aVar.D();
                return true;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Context context) {
            super(context, null, nk3.h);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            up4.a(this, getContentDescription());
            setOnTouchListener(new C0005a(this, a.this));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            a.this.M();
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                tn0.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends h {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z) {
            super(context, eVar, view, z, nk3.i);
            h(8388613);
            j(a.this.H);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.h
        public void e() {
            if (a.this.h != null) {
                a.this.h.close();
            }
            a.this.D = null;
            super.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements i.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
            if (eVar instanceof l) {
                eVar.F().e(false);
            }
            i.a aVarO = a.this.o();
            if (aVarO != null) {
                aVarO.b(eVar, z);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            if (eVar == a.this.h) {
                return false;
            }
            a.this.I = ((l) eVar).getItem().getItemId();
            i.a aVarO = a.this.o();
            if (aVarO != null) {
                return aVarO.c(eVar);
            }
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a(Context context) {
        super(context, hm3.c, hm3.b);
        this.C = new SparseBooleanArray();
        this.H = new f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean A() {
        return E() | D();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: android.view.View */
    /* JADX WARN: Multi-variable type inference failed */
    public final View B(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.n;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof j.a) && ((j.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable C() {
        d dVar = this.p;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.r) {
            return this.q;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean D() {
        Object obj;
        c cVar = this.F;
        if (cVar != null && (obj = this.n) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.F = null;
            return true;
        }
        e eVar = this.D;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean E() {
        C0004a c0004a = this.E;
        if (c0004a == null) {
            return false;
        }
        c0004a.b();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean F() {
        return this.F != null || G();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean G() {
        e eVar = this.D;
        return eVar != null && eVar.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H(Configuration configuration) {
        if (!this.x) {
            this.w = s2.b(this.g).d();
        }
        androidx.appcompat.view.menu.e eVar = this.h;
        if (eVar != null) {
            eVar.N(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(boolean z) {
        this.A = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J(ActionMenuView actionMenuView) {
        this.n = actionMenuView;
        actionMenuView.b(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K(Drawable drawable) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.r = true;
            this.q = drawable;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L(boolean z) {
        this.s = z;
        this.t = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean M() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.s || G() || (eVar = this.h) == null || this.n == null || this.F != null || eVar.B().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.g, this.h, this.p, true));
        this.F = cVar;
        ((View) this.n).post(cVar);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
        A();
        super.b(eVar, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void c(boolean z) {
        super.c(z);
        ((View) this.n).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.h;
        boolean z2 = false;
        if (eVar != null) {
            ArrayList arrayListU = eVar.u();
            int size = arrayListU.size();
            for (int i = 0; i < size; i++) {
                w2 w2VarB = ((androidx.appcompat.view.menu.g) arrayListU.get(i)).b();
                if (w2VarB != null) {
                    w2VarB.h(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.h;
        ArrayList arrayListB = eVar2 != null ? eVar2.B() : null;
        if (this.s && arrayListB != null) {
            int size2 = arrayListB.size();
            if (size2 == 1) {
                z2 = !((androidx.appcompat.view.menu.g) arrayListB.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        d dVar = this.p;
        if (z2) {
            if (dVar == null) {
                this.p = new d(this.f);
            }
            ViewGroup viewGroup = (ViewGroup) this.p.getParent();
            if (viewGroup != this.n) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.p);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.n;
                actionMenuView.addView(this.p, actionMenuView.B());
            }
        } else if (dVar != null) {
            Object parent = dVar.getParent();
            Object obj = this.n;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.p);
            }
        }
        ((ActionMenuView) this.n).setOverflowReserved(this.s);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x013b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.a] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.g] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.i
    public boolean d() {
        ArrayList arrayListG;
        int size;
        int i;
        int iH;
        ?? r0;
        int i2;
        a aVar = this;
        androidx.appcompat.view.menu.e eVar = aVar.h;
        View view = null;
        ?? r3 = 0;
        if (eVar != null) {
            arrayListG = eVar.G();
            size = arrayListG.size();
        } else {
            arrayListG = null;
            size = 0;
        }
        int i3 = aVar.w;
        int i4 = aVar.v;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) aVar.n;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) arrayListG.get(i7);
            if (gVar.o()) {
                i5++;
            } else if (gVar.n()) {
                i6++;
            } else {
                z = true;
            }
            if (aVar.A && gVar.isActionViewExpanded()) {
                i3 = 0;
            }
        }
        if (aVar.s && (z || i6 + i5 > i3)) {
            i3--;
        }
        int i8 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = aVar.C;
        sparseBooleanArray.clear();
        if (aVar.y) {
            int i9 = aVar.B;
            iH = i4 / i9;
            i = i9 + ((i4 % i9) / iH);
        } else {
            i = 0;
            iH = 0;
        }
        int i10 = 0;
        int i11 = 0;
        ?? r02 = aVar;
        while (i10 < size) {
            ?? r15 = (androidx.appcompat.view.menu.g) arrayListG.get(i10);
            if (r15.o()) {
                View viewP = r02.p(r15, view, viewGroup);
                if (r02.y) {
                    iH -= ActionMenuView.H(viewP, i, iH, iMakeMeasureSpec, r3);
                } else {
                    viewP.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewP.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int groupId = r15.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                r15.u(true);
                r0 = r3;
                i2 = size;
            } else if (r15.n()) {
                int groupId2 = r15.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i8 > 0 || z2) && i4 > 0 && (!r02.y || iH > 0);
                boolean z4 = z3;
                i2 = size;
                if (z3) {
                    View viewP2 = r02.p(r15, null, viewGroup);
                    if (r02.y) {
                        int iH2 = ActionMenuView.H(viewP2, i, iH, iMakeMeasureSpec, 0);
                        iH -= iH2;
                        if (iH2 == 0) {
                            z4 = false;
                        }
                    } else {
                        viewP2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = viewP2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z3 = z5 & (!r02.y ? i4 + i11 <= 0 : i4 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i12 = 0; i12 < i10; i12++) {
                        androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) arrayListG.get(i12);
                        if (gVar2.getGroupId() == groupId2) {
                            if (gVar2.l()) {
                                i8++;
                            }
                            gVar2.u(false);
                        }
                    }
                }
                if (z3) {
                    i8--;
                }
                r15.u(z3);
                r0 = 0;
            } else {
                r0 = r3;
                i2 = size;
                r15.u(r0);
            }
            i10++;
            r3 = r0;
            size = i2;
            view = null;
            r02 = this;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a
    public void h(androidx.appcompat.view.menu.g gVar, j.a aVar) {
        aVar.d(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.n);
        if (this.G == null) {
            this.G = new b();
        }
        actionMenuItemView.setPopupCallback(this.G);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void i(Context context, androidx.appcompat.view.menu.e eVar) {
        super.i(context, eVar);
        Resources resources = context.getResources();
        s2 s2VarB = s2.b(context);
        if (!this.t) {
            this.s = s2VarB.f();
        }
        if (!this.z) {
            this.u = s2VarB.c();
        }
        if (!this.x) {
            this.w = s2VarB.d();
        }
        int measuredWidth = this.u;
        if (this.s) {
            if (this.p == null) {
                d dVar = new d(this.f);
                this.p = dVar;
                if (this.r) {
                    dVar.setImageDrawable(this.q);
                    this.q = null;
                    this.r = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.p.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.p.getMeasuredWidth();
        } else {
            this.p = null;
        }
        this.v = measuredWidth;
        this.B = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public void j(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof g) && (i = ((g) parcelable).f) > 0 && (menuItemFindItem = this.h.findItem(i)) != null) {
            l((l) menuItemFindItem.getSubMenu());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public boolean l(l lVar) {
        boolean z = false;
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        l lVar2 = lVar;
        while (lVar2.j0() != this.h) {
            lVar2 = (l) lVar2.j0();
        }
        View viewB = B(lVar2.getItem());
        if (viewB == null) {
            return false;
        }
        this.I = lVar.getItem().getItemId();
        int size = lVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = lVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        C0004a c0004a = new C0004a(this.g, lVar, viewB);
        this.E = c0004a;
        c0004a.g(z);
        this.E.k();
        super.l(lVar);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.i
    public Parcelable m() {
        g gVar = new g();
        gVar.f = this.I;
        return gVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a
    public boolean n(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.p) {
            return false;
        }
        return super.n(viewGroup, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a
    public View p(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.p(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a
    public j q(ViewGroup viewGroup) {
        j jVar = this.n;
        j jVarQ = super.q(viewGroup);
        if (jVar != jVarQ) {
            ((ActionMenuView) jVarQ).setPresenter(this);
        }
        return jVarQ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.a
    public boolean s(int i, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new C0006a();
        public int f;

        /* JADX INFO: renamed from: androidx.appcompat.widget.a$g$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0006a implements Parcelable.Creator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i) {
                return new g[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(Parcel parcel) {
            this.f = parcel.readInt();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
        }

        public g() {
        }
    }
}
