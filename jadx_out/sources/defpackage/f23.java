package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import defpackage.g2;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f23 extends ViewGroup implements j {
    public static final int[] e0 = {R.attr.state_checked};
    public static final int[] f0 = {-16842910};
    public final SparseArray A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public y44 N;
    public boolean O;
    public ColorStateList P;
    public g23 Q;
    public d23 R;
    public boolean S;
    public boolean T;
    public int U;
    public int V;
    public boolean W;
    public MenuItem a0;
    public int b0;
    public boolean c0;
    public final Rect d0;
    public final et4 f;
    public final View.OnClickListener g;
    public tf3 h;
    public final SparseArray i;
    public int j;
    public int k;
    public e23[] l;
    public int m;
    public int n;
    public ColorStateList o;
    public int p;
    public ColorStateList q;
    public final ColorStateList r;
    public int s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public Drawable x;
    public ColorStateList y;
    public int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g itemData = ((b23) view).getItemData();
            boolean zE = f23.this.R.e(itemData, f23.this.Q, 0);
            if (itemData == null || !itemData.isCheckable()) {
                return;
            }
            if (!zE || itemData.isChecked()) {
                f23.this.setCheckedItem(itemData);
            }
        }
    }

    public f23(Context context) {
        super(context);
        this.i = new SparseArray();
        this.m = -1;
        this.n = -1;
        this.A = new SparseArray();
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.M = 49;
        this.O = false;
        this.U = 1;
        this.V = 0;
        this.a0 = null;
        this.b0 = 7;
        this.c0 = false;
        this.d0 = new Rect();
        this.r = e(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.f = null;
        } else {
            ze zeVar = new ze();
            this.f = zeVar;
            zeVar.q0(0);
            zeVar.p(TextView.class, true);
            zeVar.Y(lu2.f(getContext(), mk3.F, getResources().getInteger(zl3.b)));
            zeVar.a0(lu2.g(getContext(), mk3.N, k7.b));
            zeVar.i0(new wm4());
        }
        this.g = new a();
        setImportantForAccessibility(1);
    }

    private int getCollapsedVisibleItemCount() {
        return Math.min(this.b0, this.R.d());
    }

    private b23 getNewItem() {
        tf3 tf3Var = this.h;
        b23 b23Var = tf3Var != null ? (b23) tf3Var.a() : null;
        return b23Var == null ? h(getContext()) : b23Var;
    }

    private void setBadgeIfNeeded(b23 b23Var) {
        yf yfVar;
        int id = b23Var.getId();
        if (k(id) && (yfVar = (yf) this.A.get(id)) != null) {
            b23Var.setBadge(yfVar);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar) {
        this.R = new d23(eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d() {
        View viewG;
        removeAllViews();
        l();
        this.Q.k(true);
        this.R.f();
        this.Q.k(false);
        int iA = this.R.a();
        if (iA == 0) {
            this.m = 0;
            this.n = 0;
            this.l = null;
            this.h = null;
            return;
        }
        if (this.h == null || this.V != iA) {
            this.V = iA;
            this.h = new vf3(iA);
        }
        m();
        int iG = this.R.g();
        this.l = new e23[iG];
        boolean zJ = j(this.j, getCurrentVisibleContentItemCount());
        int size = 0;
        int i = 0;
        for (int i2 = 0; i2 < iG; i2++) {
            MenuItem menuItemB = this.R.b(i2);
            boolean z = menuItemB instanceof um0;
            if (z) {
                z13 z13Var = new z13(getContext());
                z13Var.setOnlyShowWhenExpanded(true);
                z13Var.setDividersEnabled(this.c0);
                viewG = z13Var;
            } else if (menuItemB.hasSubMenu()) {
                if (size > 0) {
                    jl.a("Only one layer of submenu is supported; a submenu inside a submenu is not supported by the Navigation Bar.");
                    return;
                }
                i23 i23Var = new i23(getContext());
                int i3 = this.v;
                if (i3 == 0) {
                    i3 = this.t;
                }
                i23Var.setTextAppearance(i3);
                i23Var.setTextColor(this.q);
                i23Var.setOnlyShowWhenExpanded(true);
                i23Var.d((g) menuItemB, 0);
                size = menuItemB.getSubMenu().size();
                viewG = i23Var;
            } else if (size > 0) {
                size--;
                viewG = g(i2, (g) menuItemB, zJ, true);
            } else {
                g gVar = (g) menuItemB;
                boolean z2 = i >= this.b0;
                i++;
                viewG = g(i2, gVar, zJ, z2);
            }
            if (!z && menuItemB.isCheckable() && this.n == -1) {
                this.n = i2;
            }
            this.l[i2] = viewG;
            addView(viewG);
        }
        int iMin = Math.min(iG - 1, this.n);
        this.n = iMin;
        setCheckedItem(this.l[iMin].getItemData());
    }

    public ColorStateList e(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = e9.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(nk3.w, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = f0;
        return new ColorStateList(new int[][]{iArr, e0, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    public final Drawable f() {
        if (this.N == null || this.P == null) {
            return null;
        }
        l62 l62Var = new l62(this.N);
        l62Var.e0(this.P);
        return l62Var;
    }

    public final b23 g(int i, g gVar, boolean z, boolean z2) {
        this.Q.k(true);
        gVar.setCheckable(true);
        this.Q.k(false);
        b23 newItem = getNewItem();
        newItem.setShifting(z);
        newItem.setLabelMaxLines(this.U);
        newItem.setIconTintList(this.o);
        newItem.setIconSize(this.p);
        newItem.setTextColor(this.r);
        newItem.setTextAppearanceInactive(this.s);
        newItem.setTextAppearanceActive(this.t);
        newItem.setHorizontalTextAppearanceInactive(this.u);
        newItem.setHorizontalTextAppearanceActive(this.v);
        newItem.setTextAppearanceActiveBoldEnabled(this.w);
        newItem.setTextColor(this.q);
        int i2 = this.B;
        if (i2 != -1) {
            newItem.setItemPaddingTop(i2);
        }
        int i3 = this.C;
        if (i3 != -1) {
            newItem.setItemPaddingBottom(i3);
        }
        newItem.setMeasureBottomPaddingFromLabelBaseline(this.S);
        newItem.setLabelFontScalingEnabled(this.T);
        int i4 = this.D;
        if (i4 != -1) {
            newItem.setActiveIndicatorLabelPadding(i4);
        }
        int i5 = this.E;
        if (i5 != -1) {
            newItem.setIconLabelHorizontalSpacing(i5);
        }
        newItem.setActiveIndicatorWidth(this.G);
        newItem.setActiveIndicatorHeight(this.H);
        newItem.setActiveIndicatorExpandedWidth(this.I);
        newItem.setActiveIndicatorExpandedHeight(this.J);
        newItem.setActiveIndicatorMarginHorizontal(this.K);
        newItem.setItemGravity(this.M);
        newItem.setActiveIndicatorExpandedPadding(this.d0);
        newItem.setActiveIndicatorExpandedMarginHorizontal(this.L);
        newItem.setActiveIndicatorDrawable(f());
        newItem.setActiveIndicatorResizeable(this.O);
        newItem.setActiveIndicatorEnabled(this.F);
        Drawable drawable = this.x;
        if (drawable != null) {
            newItem.setItemBackground(drawable);
        } else {
            newItem.setItemBackground(this.z);
        }
        newItem.setItemRippleColor(this.y);
        newItem.setLabelVisibilityMode(this.j);
        newItem.setItemIconGravity(this.k);
        newItem.setOnlyShowWhenExpanded(z2);
        newItem.setExpanded(this.W);
        newItem.d(gVar, 0);
        newItem.setItemPosition(i);
        int itemId = gVar.getItemId();
        newItem.setOnTouchListener((View.OnTouchListener) this.i.get(itemId));
        newItem.setOnClickListener(this.g);
        int i6 = this.m;
        if (i6 != 0 && itemId == i6) {
            this.n = i;
        }
        setBadgeIfNeeded(newItem);
        return newItem;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.D;
    }

    public SparseArray<yf> getBadgeDrawables() {
        return this.A;
    }

    public int getCurrentVisibleContentItemCount() {
        return this.W ? this.R.c() : getCollapsedVisibleItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.v;
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.u;
    }

    public int getIconLabelHorizontalSpacing() {
        return this.E;
    }

    public ColorStateList getIconTintList() {
        return this.o;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.P;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.F;
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.J;
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.L;
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.I;
    }

    public int getItemActiveIndicatorHeight() {
        return this.H;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.K;
    }

    public y44 getItemActiveIndicatorShapeAppearance() {
        return this.N;
    }

    public int getItemActiveIndicatorWidth() {
        return this.G;
    }

    public Drawable getItemBackground() {
        e23[] e23VarArr = this.l;
        if (e23VarArr != null && e23VarArr.length > 0) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    return ((b23) e23Var).getBackground();
                }
            }
        }
        return this.x;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.z;
    }

    public int getItemGravity() {
        return this.M;
    }

    public int getItemIconGravity() {
        return this.k;
    }

    public int getItemIconSize() {
        return this.p;
    }

    public int getItemPaddingBottom() {
        return this.C;
    }

    public int getItemPaddingTop() {
        return this.B;
    }

    public ColorStateList getItemRippleColor() {
        return this.y;
    }

    public int getItemTextAppearanceActive() {
        return this.t;
    }

    public int getItemTextAppearanceInactive() {
        return this.s;
    }

    public ColorStateList getItemTextColor() {
        return this.q;
    }

    public int getLabelMaxLines() {
        return this.U;
    }

    public int getLabelVisibilityMode() {
        return this.j;
    }

    public d23 getMenu() {
        return this.R;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.T;
    }

    public int getSelectedItemId() {
        return this.m;
    }

    public int getSelectedItemPosition() {
        return this.n;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public abstract b23 h(Context context);

    public final boolean i() {
        d23 d23Var;
        if (this.l == null || (d23Var = this.R) == null || d23Var.g() != this.l.length) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= this.l.length) {
                return true;
            }
            if ((this.R.b(i) instanceof um0) && !(this.l[i] instanceof z13)) {
                return false;
            }
            boolean z = this.R.b(i).hasSubMenu() && !(this.l[i] instanceof i23);
            boolean z2 = (this.R.b(i).hasSubMenu() || (this.l[i] instanceof b23)) ? false : true;
            if (!(this.R.b(i) instanceof um0) && (z || z2)) {
                break;
            }
            i++;
        }
        return false;
    }

    public boolean j(int i, int i2) {
        return i == -1 ? i2 > 3 : i == 0;
    }

    public final boolean k(int i) {
        return i != -1;
    }

    public final void l() {
        e23[] e23VarArr = this.l;
        if (e23VarArr == null || this.h == null) {
            return;
        }
        for (e23 e23Var : e23VarArr) {
            if (e23Var instanceof b23) {
                b23 b23Var = (b23) e23Var;
                this.h.b(b23Var);
                b23Var.g();
            }
        }
    }

    public final void m() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.R.g(); i++) {
            hashSet.add(Integer.valueOf(this.R.b(i).getItemId()));
        }
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            int iKeyAt = this.A.keyAt(i2);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.A.delete(iKeyAt);
            }
        }
    }

    public void n(SparseArray sparseArray) {
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            if (this.A.indexOfKey(iKeyAt) < 0) {
                this.A.append(iKeyAt, (yf) sparseArray.get(iKeyAt));
            }
        }
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    b23 b23Var = (b23) e23Var;
                    yf yfVar = (yf) this.A.get(b23Var.getId());
                    if (yfVar != null) {
                        b23Var.setBadge(yfVar);
                    }
                }
            }
        }
    }

    public void o(int i, int i2, int i3, int i4) {
        Rect rect = this.d0;
        rect.left = i;
        rect.top = i2;
        rect.right = i3;
        rect.bottom = i4;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorExpandedPadding(this.d0);
                }
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g2.P0(accessibilityNodeInfo).n0(g2.e.a(1, getCurrentVisibleContentItemCount(), false, 1));
    }

    public void p(int i) {
        int iG = this.R.g();
        for (int i2 = 0; i2 < iG; i2++) {
            MenuItem menuItemB = this.R.b(i2);
            if (i == menuItemB.getItemId()) {
                this.m = i;
                this.n = i2;
                setCheckedItem(menuItemB);
                return;
            }
        }
    }

    public void q() {
        et4 et4Var;
        if (this.R == null || this.l == null) {
            return;
        }
        this.Q.k(true);
        this.R.f();
        this.Q.k(false);
        if (!i()) {
            d();
            return;
        }
        int i = this.m;
        int iG = this.R.g();
        for (int i2 = 0; i2 < iG; i2++) {
            MenuItem menuItemB = this.R.b(i2);
            if (menuItemB.isChecked()) {
                setCheckedItem(menuItemB);
                this.m = menuItemB.getItemId();
                this.n = i2;
            }
        }
        if (i != this.m && (et4Var = this.f) != null) {
            bt4.a(this, et4Var);
        }
        boolean zJ = j(this.j, getCurrentVisibleContentItemCount());
        for (int i3 = 0; i3 < iG; i3++) {
            this.Q.k(true);
            this.l[i3].setExpanded(this.W);
            e23 e23Var = this.l[i3];
            if (e23Var instanceof b23) {
                b23 b23Var = (b23) e23Var;
                b23Var.setLabelVisibilityMode(this.j);
                b23Var.setItemIconGravity(this.k);
                b23Var.setItemGravity(this.M);
                b23Var.setShifting(zJ);
            }
            if (this.R.b(i3) instanceof g) {
                this.l[i3].d((g) this.R.b(i3), 0);
            }
            this.Q.k(false);
        }
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.D = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorLabelPadding(i);
                }
            }
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        if (this.a0 == menuItem || !menuItem.isCheckable()) {
            return;
        }
        MenuItem menuItem2 = this.a0;
        if (menuItem2 != null && menuItem2.isChecked()) {
            this.a0.setChecked(false);
        }
        menuItem.setChecked(true);
        this.a0 = menuItem;
    }

    public void setCollapsedMaxItemCount(int i) {
        this.b0 = i;
    }

    public void setExpanded(boolean z) {
        this.W = z;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                e23Var.setExpanded(z);
            }
        }
    }

    public void setHorizontalItemTextAppearanceActive(int i) {
        this.v = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setHorizontalTextAppearanceActive(i);
                }
            }
        }
    }

    public void setHorizontalItemTextAppearanceInactive(int i) {
        this.u = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setHorizontalTextAppearanceInactive(i);
                }
            }
        }
    }

    public void setIconLabelHorizontalSpacing(int i) {
        this.E = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setIconLabelHorizontalSpacing(i);
                }
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setIconTintList(colorStateList);
                }
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.P = colorStateList;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorDrawable(f());
                }
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.F = z;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorEnabled(z);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedHeight(int i) {
        this.J = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorExpandedHeight(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i) {
        this.L = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorExpandedMarginHorizontal(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedWidth(int i) {
        this.I = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorExpandedWidth(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.H = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorHeight(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.K = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorMarginHorizontal(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z) {
        this.O = z;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorResizeable(z);
                }
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(y44 y44Var) {
        this.N = y44Var;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorDrawable(f());
                }
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.G = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setActiveIndicatorWidth(i);
                }
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.x = drawable;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setItemBackground(drawable);
                }
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.z = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setItemBackground(i);
                }
            }
        }
    }

    public void setItemGravity(int i) {
        this.M = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setItemGravity(i);
                }
            }
        }
    }

    public void setItemIconGravity(int i) {
        this.k = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setItemIconGravity(i);
                }
            }
        }
    }

    public void setItemIconSize(int i) {
        this.p = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setIconSize(i);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i) {
        this.C = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setItemPaddingBottom(this.C);
                }
            }
        }
    }

    public void setItemPaddingTop(int i) {
        this.B = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setItemPaddingTop(i);
                }
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.y = colorStateList;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setItemRippleColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        this.t = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setTextAppearanceActive(i);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.w = z;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setTextAppearanceActiveBoldEnabled(z);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        this.s = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setTextAppearanceInactive(i);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.q = colorStateList;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setTextColor(colorStateList);
                }
            }
        }
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.T = z;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setLabelFontScalingEnabled(z);
                }
            }
        }
    }

    public void setLabelMaxLines(int i) {
        this.U = i;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setLabelMaxLines(i);
                }
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.j = i;
    }

    public void setMeasurePaddingFromLabelBaseline(boolean z) {
        this.S = z;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof b23) {
                    ((b23) e23Var).setMeasureBottomPaddingFromLabelBaseline(z);
                }
            }
        }
    }

    public void setPresenter(g23 g23Var) {
        this.Q = g23Var;
    }

    public void setSubmenuDividersEnabled(boolean z) {
        if (this.c0 == z) {
            return;
        }
        this.c0 = z;
        e23[] e23VarArr = this.l;
        if (e23VarArr != null) {
            for (e23 e23Var : e23VarArr) {
                if (e23Var instanceof z13) {
                    ((z13) e23Var).setDividersEnabled(z);
                }
            }
        }
    }
}
