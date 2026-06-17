package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.f55;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements e.b, j {
    public e.a A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public e F;
    public androidx.appcompat.view.menu.e u;
    public Context v;
    public int w;
    public boolean x;
    public androidx.appcompat.widget.a y;
    public i.a z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        boolean a();

        boolean b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements i.a {
        @Override // androidx.appcompat.view.menu.i.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements e.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.F;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.A;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.D = (int) (56.0f * f);
        this.E = (int) (f * 4.0f);
        this.v = context;
        this.w = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int H(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r0 = (androidx.appcompat.widget.ActionMenuView.c) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.s()
            if (r9 == 0) goto L28
            r9 = r2
            goto L29
        L28:
            r9 = r1
        L29:
            if (r7 <= 0) goto L4c
            r3 = 2
            if (r9 == 0) goto L30
            if (r7 < r3) goto L4c
        L30:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L45
            int r4 = r4 + 1
        L45:
            if (r9 == 0) goto L4a
            if (r4 >= r3) goto L4a
            goto L4d
        L4a:
            r3 = r4
            goto L4d
        L4c:
            r3 = r1
        L4d:
            boolean r7 = r0.a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.d = r1
            r0.b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.H(android.view.View, int, int, int, int):int");
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public c B() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    public boolean C(int i) {
        boolean zA = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? zA : ((a) childAt2).b() | zA;
    }

    public boolean D() {
        androidx.appcompat.widget.a aVar = this.y;
        return aVar != null && aVar.D();
    }

    public boolean E() {
        androidx.appcompat.widget.a aVar = this.y;
        return aVar != null && aVar.F();
    }

    public boolean F() {
        androidx.appcompat.widget.a aVar = this.y;
        return aVar != null && aVar.G();
    }

    public boolean G() {
        return this.x;
    }

    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v48 */
    public final void I(int i, int i2) {
        long j;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        ?? r3;
        int i5;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i6 = size - paddingLeft;
        int i7 = this.D;
        int i8 = i6 / i7;
        int i9 = i6 % i7;
        if (i8 == 0) {
            setMeasuredDimension(i6, 0);
            return;
        }
        int i10 = i7 + (i9 / i8);
        int childCount = getChildCount();
        int iMax = 0;
        int i11 = 0;
        boolean z3 = false;
        int i12 = 0;
        int iMax2 = 0;
        int i13 = 0;
        long j2 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            int i14 = size2;
            if (childAt.getVisibility() == 8) {
                i5 = i10;
            } else {
                boolean z4 = childAt instanceof ActionMenuItemView;
                i12++;
                if (z4) {
                    int i15 = this.E;
                    z2 = z4;
                    r3 = 0;
                    childAt.setPadding(i15, 0, i15, 0);
                } else {
                    z2 = z4;
                    r3 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f = r3;
                cVar.c = r3;
                cVar.b = r3;
                cVar.d = r3;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r3;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r3;
                cVar.e = z2 && ((ActionMenuItemView) childAt).s();
                int iH = H(childAt, i10, cVar.a ? 1 : i8, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iH);
                i5 = i10;
                if (cVar.d) {
                    i13++;
                }
                if (cVar.a) {
                    z3 = true;
                }
                i8 -= iH;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iH == 1) {
                    j2 |= (long) (1 << i11);
                }
            }
            i11++;
            size2 = i14;
            i10 = i5;
        }
        int i16 = size2;
        int i17 = i10;
        char c2 = 2;
        boolean z5 = z3 && i12 == 2;
        boolean z6 = false;
        while (i13 > 0 && i8 > 0) {
            int i18 = Integer.MAX_VALUE;
            long j3 = 0;
            char c3 = c2;
            int i19 = 0;
            int i20 = 0;
            j = 1;
            while (i20 < childCount) {
                c cVar2 = (c) getChildAt(i20).getLayoutParams();
                boolean z7 = z5;
                if (cVar2.d) {
                    int i21 = cVar2.b;
                    if (i21 < i18) {
                        j3 = 1 << i20;
                        i18 = i21;
                        i19 = 1;
                    } else if (i21 == i18) {
                        j3 |= 1 << i20;
                        i19++;
                    }
                }
                i20++;
                z5 = z7;
            }
            boolean z8 = z5;
            j2 |= j3;
            if (i19 > i8) {
                break;
            }
            int i22 = i18 + 1;
            int i23 = 0;
            while (i23 < childCount) {
                View childAt2 = getChildAt(i23);
                c cVar3 = (c) childAt2.getLayoutParams();
                long j4 = 1 << i23;
                if ((j3 & j4) == 0) {
                    if (cVar3.b == i22) {
                        j2 |= j4;
                    }
                    i4 = i23;
                } else {
                    if (!z8 || !cVar3.e) {
                        i4 = i23;
                        z = true;
                    } else if (i8 == 1) {
                        int i24 = this.E;
                        z = true;
                        i4 = i23;
                        childAt2.setPadding(i24 + i17, 0, i24, 0);
                    } else {
                        i4 = i23;
                        z = true;
                    }
                    cVar3.b++;
                    cVar3.f = z;
                    i8--;
                }
                i23 = i4 + 1;
            }
            c2 = c3;
            z5 = z8;
            z6 = true;
        }
        j = 1;
        boolean z9 = !z3 && i12 == 1;
        if (i8 <= 0 || j2 == 0 || (i8 >= i12 - 1 && !z9 && iMax2 <= 1)) {
            i3 = 0;
        } else {
            float fBitCount = Long.bitCount(j2);
            if (z9) {
                i3 = 0;
            } else {
                if ((j2 & j) != 0) {
                    i3 = 0;
                    if (!((c) getChildAt(0).getLayoutParams()).e) {
                        fBitCount -= 0.5f;
                    }
                } else {
                    i3 = 0;
                }
                int i25 = childCount - 1;
                if ((j2 & ((long) (1 << i25))) != 0 && !((c) getChildAt(i25).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
            }
            int i26 = fBitCount > 0.0f ? (int) ((i8 * i17) / fBitCount) : i3;
            boolean z10 = z6;
            for (int i27 = i3; i27 < childCount; i27++) {
                if ((j2 & ((long) (1 << i27))) != 0) {
                    View childAt3 = getChildAt(i27);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.c = i26;
                        cVar4.f = true;
                        if (i27 == 0 && !cVar4.e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i26) / 2;
                        }
                        z10 = true;
                    } else if (cVar4.a) {
                        cVar4.c = i26;
                        cVar4.f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i26) / 2;
                        z10 = true;
                    } else {
                        if (i27 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i26 / 2;
                        }
                        if (i27 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i26 / 2;
                        }
                    }
                }
            }
            z6 = z10;
        }
        if (z6) {
            for (int i28 = i3; i28 < childCount; i28++) {
                View childAt4 = getChildAt(i28);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.b * i17) + cVar5.c, Buffer.MAX_SIZE), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i6, mode != 1073741824 ? iMax : i16);
    }

    public androidx.appcompat.view.menu.e J() {
        return this.u;
    }

    public void K(i.a aVar, e.a aVar2) {
        this.z = aVar;
        this.A = aVar2;
    }

    public boolean L() {
        androidx.appcompat.widget.a aVar = this.y;
        return aVar != null && aVar.M();
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(g gVar) {
        return this.u.O(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(androidx.appcompat.view.menu.e eVar) {
        this.u = eVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.u == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.u = eVar;
            eVar.W(new d());
            androidx.appcompat.widget.a aVar = new androidx.appcompat.widget.a(context);
            this.y = aVar;
            aVar.L(true);
            androidx.appcompat.widget.a aVar2 = this.y;
            i.a bVar = this.z;
            if (bVar == null) {
                bVar = new b();
            }
            aVar2.g(bVar);
            this.u.c(this.y, this.v);
            this.y.J(this);
        }
        return this.u;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.y.C();
    }

    public int getPopupTheme() {
        return this.w;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.a aVar = this.y;
        if (aVar != null) {
            aVar.c(false);
            if (this.y.G()) {
                this.y.D();
                this.y.M();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.B) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean zB = f55.b(this);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (C(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    C(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.a) {
                    int i15 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.a) {
                int i18 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        androidx.appcompat.view.menu.e eVar;
        boolean z = this.B;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.B = z2;
        if (z != z2) {
            this.C = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.B && (eVar = this.u) != null && size != this.C) {
            this.C = size;
            eVar.N(true);
        }
        int childCount = getChildCount();
        if (this.B && childCount > 0) {
            I(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.y.I(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.F = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.y.K(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.x = z;
    }

    public void setPopupTheme(int i) {
        if (this.w != i) {
            this.w = i;
            if (i == 0) {
                this.v = getContext();
            } else {
                this.v = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.a aVar) {
        this.y = aVar;
        aVar.J(this);
    }

    public void x() {
        androidx.appcompat.widget.a aVar = this.y;
        if (aVar != null) {
            aVar.A();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends LinearLayoutCompat.a {
        public boolean a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        public boolean f;

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.a = cVar.a;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(int i, int i2) {
            super(i, i2);
            this.a = false;
        }
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }
}
