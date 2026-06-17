package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import defpackage.ct;
import defpackage.g2;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ot extends o31 {
    public static final int p = ym3.u;
    public int j;
    public int k;
    public e l;
    public final ct m;
    public final int n;
    public final f o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ct.b {
        public a() {
        }

        @Override // ct.b
        public void a(Set set) {
            if (ot.this.l != null) {
                e eVar = ot.this.l;
                ot otVar = ot.this;
                eVar.a(otVar, otVar.m.j(ot.this));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements e {
        public b(d dVar) {
        }

        @Override // ot.e
        public void a(ot otVar, List list) {
            if (ot.this.m.l()) {
                ot.this.getCheckedChipId();
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        void a(ot otVar, List list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ot(Context context, AttributeSet attributeSet, int i) {
        int i2 = p;
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        ct ctVar = new ct();
        this.m = ctVar;
        f fVar = new f(this, null);
        this.o = fVar;
        TypedArray typedArrayI = dn4.i(getContext(), attributeSet, cn3.F1, i, i2, new int[0]);
        int dimensionPixelOffset = typedArrayI.getDimensionPixelOffset(cn3.H1, 0);
        setChipSpacingHorizontal(typedArrayI.getDimensionPixelOffset(cn3.I1, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayI.getDimensionPixelOffset(cn3.J1, dimensionPixelOffset));
        setSingleLine(typedArrayI.getBoolean(cn3.L1, false));
        setSingleSelection(typedArrayI.getBoolean(cn3.M1, false));
        setSelectionRequired(typedArrayI.getBoolean(cn3.K1, false));
        this.n = typedArrayI.getResourceId(cn3.G1, -1);
        typedArrayI.recycle();
        ctVar.o(new a());
        super.setOnHierarchyChangeListener(fVar);
    }

    private int getVisibleChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof mt) && h(i2)) {
                i++;
            }
        }
        return i;
    }

    @Override // defpackage.o31
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    public int g(View view) {
        if (!(view instanceof mt)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof mt) && h(i2)) {
                if (((mt) childAt) == view) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.m.k();
    }

    public List<Integer> getCheckedChipIds() {
        return this.m.j(this);
    }

    public int getChipSpacingHorizontal() {
        return this.j;
    }

    public int getChipSpacingVertical() {
        return this.k;
    }

    public final boolean h(int i) {
        return getChildAt(i).getVisibility() == 0;
    }

    public boolean i() {
        return this.m.l();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.n;
        if (i != -1) {
            this.m.f(i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g2.P0(accessibilityNodeInfo).n0(g2.e.a(getRowCount(), c() ? getVisibleChipCount() : -1, false, i() ? 1 : 2));
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.j != i) {
            this.j = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.k != i) {
            this.k = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(d dVar) {
        if (dVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new b(dVar));
        }
    }

    public void setOnCheckedStateChangeListener(e eVar) {
        this.l = eVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.o.f = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.m.p(z);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(int i, int i2) {
            super(i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup.OnHierarchyChangeListener f;

        public f() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ot.this && (view2 instanceof mt)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ot.this.m.e((mt) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            ot otVar = ot.this;
            if (view == otVar && (view2 instanceof mt)) {
                otVar.m.n((mt) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        public /* synthetic */ f(ot otVar, a aVar) {
            this();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    @Override // defpackage.o31
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        this.m.q(z);
    }

    public ot(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.f);
    }

    public ot(Context context) {
        this(context, null);
    }
}
