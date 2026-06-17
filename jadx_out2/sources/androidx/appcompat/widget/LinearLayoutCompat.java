package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.dp4;
import defpackage.f55;
import defpackage.fp3;
import defpackage.hb1;
import defpackage.l35;
import defpackage.mn3;
import defpackage.zt2;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public float l;
    public boolean m;
    public int[] n;
    public int[] o;
    public Drawable p;
    public int q;
    public int r;
    public int s;
    public int t;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.g = -1;
        this.h = 0;
        this.j = 8388659;
        dp4 dp4VarV = dp4.v(context, attributeSet, mn3.W0, i, 0);
        l35.e0(this, context, mn3.W0, attributeSet, dp4VarV.r(), i, 0);
        int iK = dp4VarV.k(mn3.Y0, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = dp4VarV.k(mn3.X0, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = dp4VarV.a(mn3.Z0, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.l = dp4VarV.i(mn3.b1, -1.0f);
        this.g = dp4VarV.k(mn3.a1, -1);
        this.m = dp4VarV.a(mn3.e1, false);
        setDividerDrawable(dp4VarV.g(mn3.c1));
        this.s = dp4VarV.k(mn3.f1, 0);
        this.t = dp4VarV.f(mn3.d1, 0);
        dp4VarV.x();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat;
        int i3;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Buffer.MAX_SIZE);
        int i4 = 0;
        while (i4 < i) {
            View viewO = this.o(i4);
            if (viewO.getVisibility() != 8) {
                a aVar = (a) viewO.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewO.getMeasuredHeight();
                    linearLayoutCompat = this;
                    i3 = i2;
                    linearLayoutCompat.measureChildWithMargins(viewO, iMakeMeasureSpec, 0, i3, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i5;
                } else {
                    linearLayoutCompat = this;
                    i3 = i2;
                }
            }
            i4++;
            this = linearLayoutCompat;
            i2 = i3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void w(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = f55.b(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewO = o(i2);
            if (viewO != null && viewO.getVisibility() != 8 && p(i2)) {
                a aVar = (a) viewO.getLayoutParams();
                f(canvas, zB ? viewO.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewO.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.q);
            }
        }
        if (p(virtualChildCount)) {
            View viewO2 = o(virtualChildCount - 1);
            if (viewO2 != null) {
                a aVar2 = (a) viewO2.getLayoutParams();
                if (zB) {
                    left = viewO2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i = this.q;
                    right = left - i;
                } else {
                    right = viewO2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.q;
                right = left - i;
            }
            f(canvas, right);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View viewO = o(i);
            if (viewO != null && viewO.getVisibility() != 8 && p(i)) {
                e(canvas, (viewO.getTop() - ((LinearLayout.LayoutParams) ((a) viewO.getLayoutParams())).topMargin) - this.r);
            }
        }
        if (p(virtualChildCount)) {
            View viewO2 = o(virtualChildCount - 1);
            e(canvas, viewO2 == null ? (getHeight() - getPaddingBottom()) - this.r : viewO2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewO2.getLayoutParams())).bottomMargin);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(Canvas canvas, int i) {
        this.p.setBounds(getPaddingLeft() + this.t, i, (getWidth() - getPaddingRight()) - this.t, this.r + i);
        this.p.draw(canvas);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(Canvas canvas, int i) {
        this.p.setBounds(i, getPaddingTop() + this.t, this.q + i, (getHeight() - getPaddingBottom()) - this.t);
        this.p.draw(canvas);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat;
        int i3;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Buffer.MAX_SIZE);
        int i4 = 0;
        while (i4 < i) {
            View viewO = this.o(i4);
            if (viewO.getVisibility() != 8) {
                a aVar = (a) viewO.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewO.getMeasuredWidth();
                    linearLayoutCompat = this;
                    i3 = i2;
                    linearLayoutCompat.measureChildWithMargins(viewO, i3, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i5;
                } else {
                    linearLayoutCompat = this;
                    i3 = i2;
                }
            }
            i4++;
            this = linearLayoutCompat;
            i2 = i3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.g < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.g;
        if (childCount <= i2) {
            zt2.a("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
            return 0;
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.g == 0) {
                return -1;
            }
            zt2.a("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            return 0;
        }
        int bottom = this.h;
        if (this.i == 1 && (i = this.j & Token.ASSIGN_MOD) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.k) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.k;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getBaselineAlignedChildIndex() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getDividerDrawable() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getDividerPadding() {
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getDividerWidth() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getGravity() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getOrientation() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getShowDividers() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getWeightSum() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams; */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i = this.i;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams; */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams; */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a ? new a((ViewGroup.MarginLayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int l(View view, int i) {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m(View view) {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int n(View view) {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public View o(int i) {
        return getChildAt(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.p == null) {
            return;
        }
        if (this.i == 1) {
            d(canvas);
        } else {
            c(canvas);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.i == 1) {
            r(i, i2, i3, i4);
        } else {
            q(i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.i == 1) {
            v(i, i2);
        } else {
            t(i, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p(int i) {
        if (i == 0) {
            return (this.s & 1) != 0;
        }
        int childCount = getChildCount();
        int i2 = this.s;
        if (i == childCount) {
            return (i2 & 4) != 0;
        }
        if ((i2 & 2) != 0) {
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        char c;
        char c2;
        int i7;
        int iL;
        int i8;
        int i9;
        int i10;
        int i11;
        int measuredHeight;
        boolean zB = f55.b(this);
        int paddingTop = getPaddingTop();
        int i12 = i4 - i2;
        int paddingBottom = i12 - getPaddingBottom();
        int paddingBottom2 = (i12 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.j;
        int i14 = i13 & Token.ASSIGN_MOD;
        boolean z = this.f;
        int[] iArr = this.n;
        int[] iArr2 = this.o;
        int iB = hb1.b(8388615 & i13, getLayoutDirection());
        char c3 = 2;
        char c4 = 1;
        int paddingLeft = iB != 1 ? iB != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.k : getPaddingLeft() + (((i3 - i) - this.k) / 2);
        if (zB) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i15 = 0;
        while (i15 < virtualChildCount) {
            int i16 = i5 + (i6 * i15);
            int i17 = i15;
            View viewO = o(i16);
            if (viewO == null) {
                paddingLeft += u(i16);
                iL = i17;
                i7 = paddingTop;
                c = c3;
                c2 = c4;
            } else {
                c = c3;
                c2 = c4;
                if (viewO.getVisibility() != 8) {
                    int measuredWidth = viewO.getMeasuredWidth();
                    int measuredHeight2 = viewO.getMeasuredHeight();
                    a aVar = (a) viewO.getLayoutParams();
                    int i18 = paddingLeft;
                    if (z) {
                        i8 = measuredHeight2;
                        int baseline = ((LinearLayout.LayoutParams) aVar).height != -1 ? viewO.getBaseline() : -1;
                        i9 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i9 < 0) {
                            i9 = i14;
                        }
                        i10 = i9 & Token.ASSIGN_MOD;
                        i7 = paddingTop;
                        if (i10 == 16) {
                            if (i10 == 48) {
                                i11 = i7 + ((LinearLayout.LayoutParams) aVar).topMargin;
                                if (baseline != -1) {
                                    i11 += iArr[c2] - baseline;
                                }
                            } else if (i10 != 80) {
                                i11 = i7;
                            } else {
                                i11 = (paddingBottom - i8) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight = iArr2[c] - (viewO.getMeasuredHeight() - baseline);
                                }
                            }
                            int i19 = ((LinearLayout.LayoutParams) aVar).leftMargin + (p(i16) ? i18 + this.q : i18);
                            w(viewO, m(viewO) + i19, i11, measuredWidth, i8);
                            int iN = i19 + ((LinearLayout.LayoutParams) aVar).rightMargin + measuredWidth + n(viewO);
                            iL = l(viewO, i16) + i17;
                            paddingLeft = iN;
                        } else {
                            i11 = i7 + ((paddingBottom2 - i8) / 2) + ((LinearLayout.LayoutParams) aVar).topMargin;
                            measuredHeight = ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        }
                        i11 -= measuredHeight;
                        int i192 = ((LinearLayout.LayoutParams) aVar).leftMargin + (p(i16) ? i18 + this.q : i18);
                        w(viewO, m(viewO) + i192, i11, measuredWidth, i8);
                        int iN2 = i192 + ((LinearLayout.LayoutParams) aVar).rightMargin + measuredWidth + n(viewO);
                        iL = l(viewO, i16) + i17;
                        paddingLeft = iN2;
                    } else {
                        i8 = measuredHeight2;
                    }
                    i9 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i9 < 0) {
                    }
                    i10 = i9 & Token.ASSIGN_MOD;
                    i7 = paddingTop;
                    if (i10 == 16) {
                    }
                    i11 -= measuredHeight;
                    int i1922 = ((LinearLayout.LayoutParams) aVar).leftMargin + (p(i16) ? i18 + this.q : i18);
                    w(viewO, m(viewO) + i1922, i11, measuredWidth, i8);
                    int iN22 = i1922 + ((LinearLayout.LayoutParams) aVar).rightMargin + measuredWidth + n(viewO);
                    iL = l(viewO, i16) + i17;
                    paddingLeft = iN22;
                } else {
                    i7 = paddingTop;
                    iL = i17;
                }
            }
            i15 = iL + 1;
            c3 = c;
            c4 = c2;
            paddingTop = i7;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        LinearLayoutCompat linearLayoutCompat;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.j;
        int i10 = i9 & Token.ASSIGN_MOD;
        int i11 = i9 & 8388615;
        int paddingTop = i10 != 16 ? i10 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.k : getPaddingTop() + (((i4 - i2) - this.k) / 2);
        int iL = 0;
        while (iL < virtualChildCount) {
            View viewO = this.o(iL);
            if (viewO == null) {
                paddingTop += this.u(iL);
            } else {
                if (viewO.getVisibility() != 8) {
                    int measuredWidth = viewO.getMeasuredWidth();
                    int measuredHeight = viewO.getMeasuredHeight();
                    a aVar = (a) viewO.getLayoutParams();
                    int i12 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i12 < 0) {
                        i12 = i11;
                    }
                    int iB = hb1.b(i12, this.getLayoutDirection()) & 7;
                    if (iB == 1) {
                        i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                        i6 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    } else if (iB != 5) {
                        i7 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        int i13 = i7;
                        if (this.p(iL)) {
                            paddingTop += this.r;
                        }
                        int i14 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                        linearLayoutCompat = this;
                        linearLayoutCompat.w(viewO, i13, i14 + this.m(viewO), measuredWidth, measuredHeight);
                        paddingTop = i14 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + linearLayoutCompat.n(viewO);
                        iL += linearLayoutCompat.l(viewO, iL);
                    } else {
                        i5 = paddingRight - measuredWidth;
                        i6 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    i7 = i5 - i6;
                    int i132 = i7;
                    if (this.p(iL)) {
                    }
                    int i142 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    linearLayoutCompat = this;
                    linearLayoutCompat.w(viewO, i132, i142 + this.m(viewO), measuredWidth, measuredHeight);
                    paddingTop = i142 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + linearLayoutCompat.n(viewO);
                    iL += linearLayoutCompat.l(viewO, iL);
                }
                iL++;
                this = linearLayoutCompat;
            }
            linearLayoutCompat = this;
            iL++;
            this = linearLayoutCompat;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setBaselineAligned(boolean z) {
        this.f = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            fp3.a("base aligned child index out of range (0, ", getChildCount(), ")");
        } else {
            this.g = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.p) {
            return;
        }
        this.p = drawable;
        if (drawable != null) {
            this.q = drawable.getIntrinsicWidth();
            this.r = drawable.getIntrinsicHeight();
        } else {
            this.q = 0;
            this.r = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDividerPadding(int i) {
        this.t = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGravity(int i) {
        if (this.j != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & Token.ASSIGN_MOD) == 0) {
                i |= 48;
            }
            this.j = i;
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.j;
        if ((8388615 & i3) != i2) {
            this.j = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.m = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOrientation(int i) {
        if (this.i != i) {
            this.i = i;
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowDividers(int i) {
        if (i != this.s) {
            requestLayout();
        }
        this.s = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVerticalGravity(int i) {
        int i2 = i & Token.ASSIGN_MOD;
        int i3 = this.j;
        if ((i3 & Token.ASSIGN_MOD) != i2) {
            this.j = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWeightSum(float f) {
        this.l = Math.max(0.0f, f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0451  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        int iMax;
        int i8;
        int i9;
        int baseline;
        int i10;
        int i11;
        float f2;
        byte b;
        int i12;
        boolean z;
        int i13;
        int i14;
        int i15;
        int[] iArr;
        int i16;
        int i17;
        boolean z2;
        int[] iArr2;
        View view;
        boolean z3;
        boolean z4;
        int baseline2;
        this.k = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.n == null || this.o == null) {
            this.n = new int[4];
            this.o = new int[4];
        }
        int[] iArr3 = this.n;
        int[] iArr4 = this.o;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        iArr4[3] = -1;
        iArr4[2] = -1;
        iArr4[1] = -1;
        iArr4[0] = -1;
        boolean z5 = this.f;
        boolean z6 = this.m;
        int i18 = Buffer.MAX_SIZE;
        boolean z7 = mode == 1073741824;
        boolean z8 = z6;
        int iL = 0;
        int i19 = 0;
        int iMax2 = 0;
        boolean z9 = false;
        int iCombineMeasuredStates = 0;
        boolean z10 = false;
        boolean z11 = true;
        float f3 = 0.0f;
        int iMax3 = 0;
        int iMax4 = 0;
        while (true) {
            i3 = i19;
            if (iL >= virtualChildCount) {
                break;
            }
            boolean z12 = z5;
            View viewO = o(iL);
            if (viewO == null) {
                this.k += u(iL);
            } else if (viewO.getVisibility() == 8) {
                iL += l(viewO, iL);
            } else {
                if (p(iL)) {
                    this.k += this.q;
                }
                a aVar = (a) viewO.getLayoutParams();
                float f4 = ((LinearLayout.LayoutParams) aVar).weight;
                float f5 = f3 + f4;
                if (mode == i18 && ((LinearLayout.LayoutParams) aVar).width == 0 && f4 > 0.0f) {
                    int i20 = this.k;
                    if (z7) {
                        this.k = i20 + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                    } else {
                        this.k = Math.max(i20, ((LinearLayout.LayoutParams) aVar).leftMargin + i20 + ((LinearLayout.LayoutParams) aVar).rightMargin);
                    }
                    if (z12) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        viewO.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        i14 = virtualChildCount;
                        i15 = mode;
                        iArr = iArr3;
                        iArr2 = iArr4;
                    } else {
                        i14 = virtualChildCount;
                        i15 = mode;
                        iArr = iArr3;
                        iArr2 = iArr4;
                        z9 = true;
                    }
                    i16 = i3;
                    i17 = Buffer.MAX_SIZE;
                    z2 = z8;
                    view = viewO;
                } else {
                    if (((LinearLayout.LayoutParams) aVar).width != 0 || f4 <= 0.0f) {
                        b = -2;
                        i12 = Integer.MIN_VALUE;
                    } else {
                        b = -2;
                        ((LinearLayout.LayoutParams) aVar).width = -2;
                        i12 = 0;
                    }
                    if (f5 == 0.0f) {
                        z = z8;
                        i13 = this.k;
                    } else {
                        z = z8;
                        i13 = 0;
                    }
                    i14 = virtualChildCount;
                    i15 = mode;
                    iArr = iArr3;
                    i16 = i3;
                    i17 = Buffer.MAX_SIZE;
                    z2 = z;
                    iArr2 = iArr4;
                    int i21 = i12;
                    s(viewO, iL, i, i13, i2, 0);
                    view = viewO;
                    if (i21 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) aVar).width = i21;
                    }
                    int measuredWidth = view.getMeasuredWidth();
                    int i22 = this.k;
                    if (z7) {
                        this.k = i22 + ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + n(view);
                    } else {
                        this.k = Math.max(i22, i22 + measuredWidth + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin + n(view));
                    }
                    if (z2) {
                        iMax2 = Math.max(measuredWidth, iMax2);
                    }
                }
                if (mode2 == i17 || ((LinearLayout.LayoutParams) aVar).height != -1) {
                    z3 = false;
                } else {
                    z3 = true;
                    z10 = true;
                }
                int i23 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                int measuredHeight = view.getMeasuredHeight() + i23;
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                if (!z12 || (baseline2 = view.getBaseline()) == -1) {
                    z4 = z3;
                } else {
                    int i24 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i24 < 0) {
                        i24 = this.j;
                    }
                    int i25 = (((i24 & Token.ASSIGN_MOD) >> 4) & (-2)) >> 1;
                    z4 = z3;
                    iArr[i25] = Math.max(iArr[i25], baseline2);
                    iArr2[i25] = Math.max(iArr2[i25], measuredHeight - baseline2);
                }
                int iMax5 = Math.max(i16, measuredHeight);
                z11 = z11 && ((LinearLayout.LayoutParams) aVar).height == -1;
                if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                    if (!z4) {
                        i23 = measuredHeight;
                    }
                    iMax4 = Math.max(iMax4, i23);
                } else {
                    if (!z4) {
                        i23 = measuredHeight;
                    }
                    iMax3 = Math.max(iMax3, i23);
                }
                iL += l(view, iL);
                i19 = iMax5;
                f3 = f5;
                iL++;
                z8 = z2;
                iArr4 = iArr2;
                z5 = z12;
                mode = i15;
                iArr3 = iArr;
                virtualChildCount = i14;
                i18 = Buffer.MAX_SIZE;
            }
            i14 = virtualChildCount;
            i15 = mode;
            iArr = iArr3;
            iArr2 = iArr4;
            i19 = i3;
            z2 = z8;
            iL++;
            z8 = z2;
            iArr4 = iArr2;
            z5 = z12;
            mode = i15;
            iArr3 = iArr;
            virtualChildCount = i14;
            i18 = Buffer.MAX_SIZE;
        }
        boolean z13 = z5;
        int i26 = virtualChildCount;
        int i27 = mode;
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        int iCombineMeasuredStates2 = iCombineMeasuredStates;
        boolean z14 = z8;
        if (this.k > 0) {
            i4 = i26;
            if (p(i4)) {
                this.k += this.q;
            }
        } else {
            i4 = i26;
        }
        int i28 = iArr5[1];
        int iMax6 = (i28 == -1 && iArr5[0] == -1 && iArr5[2] == -1 && iArr5[3] == -1) ? i3 : Math.max(i3, Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i28, iArr5[2]))) + Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))));
        if (z14) {
            i5 = i27;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                this.k = 0;
                int iL2 = 0;
                while (iL2 < i4) {
                    View viewO2 = o(iL2);
                    if (viewO2 == null) {
                        this.k += u(iL2);
                    } else if (viewO2.getVisibility() == 8) {
                        iL2 += l(viewO2, iL2);
                    } else {
                        a aVar2 = (a) viewO2.getLayoutParams();
                        int i29 = this.k;
                        if (z7) {
                            f2 = f3;
                            this.k = i29 + ((LinearLayout.LayoutParams) aVar2).leftMargin + iMax2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + n(viewO2);
                        } else {
                            f2 = f3;
                            this.k = Math.max(i29, i29 + iMax2 + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin + n(viewO2));
                        }
                        iL2++;
                        f3 = f2;
                    }
                    f2 = f3;
                    iL2++;
                    f3 = f2;
                }
            }
            f = f3;
        } else {
            f = f3;
            i5 = i27;
        }
        int paddingLeft = this.k + getPaddingLeft() + getPaddingRight();
        this.k = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i30 = (16777215 & iResolveSizeAndState) - this.k;
        if (z9 || (i30 != 0 && f > 0.0f)) {
            float f6 = this.l;
            if (f6 > 0.0f) {
                f = f6;
            }
            iArr5[3] = -1;
            iArr5[2] = -1;
            iArr5[1] = -1;
            iArr5[0] = -1;
            iArr6[3] = -1;
            iArr6[2] = -1;
            iArr6[1] = -1;
            iArr6[0] = -1;
            this.k = 0;
            iMax6 = -1;
            int i31 = 0;
            while (i31 < i4) {
                View viewO3 = o(i31);
                if (viewO3 == null || viewO3.getVisibility() == 8) {
                    i8 = iResolveSizeAndState;
                } else {
                    a aVar3 = (a) viewO3.getLayoutParams();
                    float f7 = ((LinearLayout.LayoutParams) aVar3).weight;
                    if (f7 > 0.0f) {
                        int i32 = (int) ((i30 * f7) / f);
                        f -= f7;
                        i30 -= i32;
                        i8 = iResolveSizeAndState;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin, ((LinearLayout.LayoutParams) aVar3).height);
                        if (((LinearLayout.LayoutParams) aVar3).width == 0) {
                            i11 = Buffer.MAX_SIZE;
                            if (i5 == 1073741824) {
                                if (i32 <= 0) {
                                    i32 = 0;
                                }
                                viewO3.measure(View.MeasureSpec.makeMeasureSpec(i32, Buffer.MAX_SIZE), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewO3.getMeasuredState() & (-16777216));
                        } else {
                            i11 = Buffer.MAX_SIZE;
                        }
                        int measuredWidth2 = viewO3.getMeasuredWidth() + i32;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewO3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i11), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewO3.getMeasuredState() & (-16777216));
                    } else {
                        i8 = iResolveSizeAndState;
                    }
                    int i33 = this.k;
                    if (z7) {
                        this.k = i33 + viewO3.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + n(viewO3);
                    } else {
                        this.k = Math.max(i33, viewO3.getMeasuredWidth() + i33 + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + n(viewO3));
                    }
                    boolean z15 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == -1;
                    int i34 = ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = viewO3.getMeasuredHeight() + i34;
                    iMax6 = Math.max(iMax6, measuredHeight2);
                    if (!z15) {
                        i34 = measuredHeight2;
                    }
                    int iMax7 = Math.max(iMax3, i34);
                    if (z11) {
                        i9 = -1;
                        boolean z16 = ((LinearLayout.LayoutParams) aVar3).height == -1;
                        if (z13 && (baseline = viewO3.getBaseline()) != i9) {
                            i10 = ((LinearLayout.LayoutParams) aVar3).gravity;
                            if (i10 < 0) {
                                i10 = this.j;
                            }
                            int i35 = (((i10 & Token.ASSIGN_MOD) >> 4) & (-2)) >> 1;
                            iArr5[i35] = Math.max(iArr5[i35], baseline);
                            iArr6[i35] = Math.max(iArr6[i35], measuredHeight2 - baseline);
                        }
                        iMax3 = iMax7;
                        z11 = z16;
                    } else {
                        i9 = -1;
                    }
                    if (z13) {
                        i10 = ((LinearLayout.LayoutParams) aVar3).gravity;
                        if (i10 < 0) {
                        }
                        int i352 = (((i10 & Token.ASSIGN_MOD) >> 4) & (-2)) >> 1;
                        iArr5[i352] = Math.max(iArr5[i352], baseline);
                        iArr6[i352] = Math.max(iArr6[i352], measuredHeight2 - baseline);
                    }
                    iMax3 = iMax7;
                    z11 = z16;
                }
                i31++;
                iResolveSizeAndState = i8;
            }
            i6 = iResolveSizeAndState;
            i7 = -16777216;
            this.k += getPaddingLeft() + getPaddingRight();
            int i36 = iArr5[1];
            if (i36 != -1 || iArr5[0] != -1 || iArr5[2] != -1 || iArr5[3] != -1) {
                iMax6 = Math.max(iMax6, Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i36, iArr5[2]))) + Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))));
            }
            iMax = iMax3;
        } else {
            iMax = Math.max(iMax3, iMax4);
            if (z14 && i5 != 1073741824) {
                for (int i37 = 0; i37 < i4; i37++) {
                    View viewO4 = o(i37);
                    if (viewO4 != null && viewO4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewO4.getLayoutParams())).weight > 0.0f) {
                        viewO4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, Buffer.MAX_SIZE), View.MeasureSpec.makeMeasureSpec(viewO4.getMeasuredHeight(), Buffer.MAX_SIZE));
                    }
                }
            }
            i6 = iResolveSizeAndState;
            i7 = -16777216;
        }
        int i38 = iCombineMeasuredStates2;
        if (!z11 && mode2 != 1073741824) {
            iMax6 = iMax;
        }
        setMeasuredDimension(i6 | (i38 & i7), View.resolveSizeAndState(Math.max(iMax6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i38 << 16));
        if (z10) {
            g(i4, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int u(int i) {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(int i, int i2) {
        int i3;
        int iMax;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        View view;
        boolean z;
        int iMax2;
        boolean z2;
        int iMax3;
        int i15;
        this.k = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i16 = this.g;
        boolean z3 = this.m;
        int iL = 0;
        int i17 = 0;
        int iMax4 = 0;
        int i18 = 0;
        int i19 = 0;
        int iMax5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        float f = 0.0f;
        boolean z6 = true;
        while (true) {
            int i20 = 8;
            if (iL >= virtualChildCount) {
                float f2 = f;
                int i21 = i17;
                int i22 = virtualChildCount;
                int i23 = mode2;
                boolean z7 = z3;
                int i24 = iMax4;
                int iMax6 = i18;
                int iCombineMeasuredStates = i19;
                if (this.k > 0) {
                    i3 = i22;
                    if (p(i3)) {
                        this.k += this.r;
                    }
                } else {
                    i3 = i22;
                }
                int i25 = i23;
                if (z7 && (i25 == Integer.MIN_VALUE || i25 == 0)) {
                    this.k = 0;
                    int iL2 = 0;
                    while (iL2 < i3) {
                        View viewO = o(iL2);
                        if (viewO == null) {
                            this.k += u(iL2);
                        } else if (viewO.getVisibility() == i20) {
                            iL2 += l(viewO, iL2);
                        } else {
                            a aVar = (a) viewO.getLayoutParams();
                            int i26 = this.k;
                            this.k = Math.max(i26, i26 + i24 + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + n(viewO));
                        }
                        iL2++;
                        i20 = 8;
                    }
                }
                int paddingTop = this.k + getPaddingTop() + getPaddingBottom();
                this.k = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i27 = (16777215 & iResolveSizeAndState) - this.k;
                if (z4 || (i27 != 0 && f2 > 0.0f)) {
                    float f3 = this.l;
                    if (f3 <= 0.0f) {
                        f3 = f2;
                    }
                    this.k = 0;
                    float f4 = f3;
                    int i28 = i27;
                    int i29 = 0;
                    while (i29 < i3) {
                        View viewO2 = o(i29);
                        if (viewO2.getVisibility() == 8) {
                            i4 = i25;
                            i5 = i29;
                        } else {
                            a aVar2 = (a) viewO2.getLayoutParams();
                            float f5 = ((LinearLayout.LayoutParams) aVar2).weight;
                            if (f5 > 0.0f) {
                                i5 = i29;
                                int i30 = (int) ((i28 * f5) / f4);
                                f4 -= f5;
                                i28 -= i30;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin, ((LinearLayout.LayoutParams) aVar2).width);
                                if (((LinearLayout.LayoutParams) aVar2).height == 0) {
                                    i7 = Buffer.MAX_SIZE;
                                    if (i25 == 1073741824) {
                                        i4 = i25;
                                        viewO2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i30 > 0 ? i30 : 0, Buffer.MAX_SIZE));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewO2.getMeasuredState() & (-256));
                                } else {
                                    i7 = Buffer.MAX_SIZE;
                                }
                                i4 = i25;
                                int measuredHeight = viewO2.getMeasuredHeight() + i30;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewO2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i7));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewO2.getMeasuredState() & (-256));
                            } else {
                                i4 = i25;
                                i5 = i29;
                            }
                            int i31 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                            int measuredWidth = viewO2.getMeasuredWidth() + i31;
                            iMax6 = Math.max(iMax6, measuredWidth);
                            if (mode != 1073741824) {
                                i6 = -1;
                                if (((LinearLayout.LayoutParams) aVar2).width == -1) {
                                    measuredWidth = i31;
                                }
                            } else {
                                i6 = -1;
                            }
                            int iMax7 = Math.max(iMax5, measuredWidth);
                            boolean z8 = z6 && ((LinearLayout.LayoutParams) aVar2).width == i6;
                            int i32 = this.k;
                            this.k = Math.max(i32, i32 + viewO2.getMeasuredHeight() + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + n(viewO2));
                            iMax5 = iMax7;
                            z6 = z8;
                        }
                        i29 = i5 + 1;
                        i25 = i4;
                    }
                    this.k += getPaddingTop() + getPaddingBottom();
                    iMax = iMax5;
                } else {
                    iMax = Math.max(iMax5, i21);
                    if (z7 && i25 != 1073741824) {
                        for (int i33 = 0; i33 < i3; i33++) {
                            View viewO3 = o(i33);
                            if (viewO3 != null && viewO3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewO3.getLayoutParams())).weight > 0.0f) {
                                viewO3.measure(View.MeasureSpec.makeMeasureSpec(viewO3.getMeasuredWidth(), Buffer.MAX_SIZE), View.MeasureSpec.makeMeasureSpec(i24, Buffer.MAX_SIZE));
                            }
                        }
                    }
                }
                if (!z6 && mode != 1073741824) {
                    iMax6 = iMax;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax6 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates), iResolveSizeAndState);
                if (z5) {
                    h(i3, i2);
                    return;
                }
                return;
            }
            float f6 = f;
            View viewO4 = o(iL);
            if (viewO4 == null) {
                this.k += u(iL);
            } else if (viewO4.getVisibility() == 8) {
                iL += l(viewO4, iL);
            } else {
                if (p(iL)) {
                    this.k += this.r;
                }
                a aVar3 = (a) viewO4.getLayoutParams();
                float f7 = ((LinearLayout.LayoutParams) aVar3).weight;
                float f8 = f6 + f7;
                if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == 0 && f7 > 0.0f) {
                    int i34 = this.k;
                    this.k = Math.max(i34, ((LinearLayout.LayoutParams) aVar3).topMargin + i34 + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                    iMax2 = i17;
                    i11 = virtualChildCount;
                    i12 = mode2;
                    z4 = true;
                    view = viewO4;
                    i14 = i18;
                    i13 = i19;
                    z = z3;
                } else {
                    if (((LinearLayout.LayoutParams) aVar3).height != 0 || f7 <= 0.0f) {
                        i8 = Integer.MIN_VALUE;
                    } else {
                        ((LinearLayout.LayoutParams) aVar3).height = -2;
                        i8 = 0;
                    }
                    if (f8 == 0.0f) {
                        int i35 = i19;
                        i10 = this.k;
                        i9 = i35;
                    } else {
                        i9 = i19;
                        i10 = 0;
                    }
                    int i36 = iMax4;
                    i11 = virtualChildCount;
                    i12 = mode2;
                    i13 = i9;
                    i14 = i18;
                    view = viewO4;
                    z = z3;
                    iMax2 = i17;
                    s(view, iL, i, 0, i2, i10);
                    if (i8 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) aVar3).height = i8;
                    }
                    int measuredHeight2 = view.getMeasuredHeight();
                    int i37 = this.k;
                    this.k = Math.max(i37, i37 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin + n(view));
                    iMax4 = z ? Math.max(measuredHeight2, i36) : i36;
                }
                if (i16 >= 0 && i16 == iL + 1) {
                    this.h = this.k;
                }
                if (iL < i16 && ((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                    zt2.a("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    return;
                }
                if (mode == 1073741824 || ((LinearLayout.LayoutParams) aVar3).width != -1) {
                    z2 = false;
                } else {
                    z2 = true;
                    z5 = true;
                }
                int i38 = ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin;
                int measuredWidth2 = view.getMeasuredWidth() + i38;
                iMax3 = Math.max(i14, measuredWidth2);
                int i39 = iMax4;
                int iCombineMeasuredStates2 = View.combineMeasuredStates(i13, view.getMeasuredState());
                if (z6) {
                    i15 = iCombineMeasuredStates2;
                    z6 = ((LinearLayout.LayoutParams) aVar3).width == -1;
                    if (((LinearLayout.LayoutParams) aVar3).weight <= 0.0f) {
                        if (!z2) {
                            i38 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i38);
                    } else {
                        if (!z2) {
                            i38 = measuredWidth2;
                        }
                        iMax5 = Math.max(iMax5, i38);
                    }
                    iL += l(view, iL);
                    f = f8;
                    iMax4 = i39;
                    i19 = i15;
                    iL++;
                    i18 = iMax3;
                    i17 = iMax2;
                    z3 = z;
                    mode2 = i12;
                    virtualChildCount = i11;
                } else {
                    i15 = iCombineMeasuredStates2;
                }
                if (((LinearLayout.LayoutParams) aVar3).weight <= 0.0f) {
                }
                iL += l(view, iL);
                f = f8;
                iMax4 = i39;
                i19 = i15;
                iL++;
                i18 = iMax3;
                i17 = iMax2;
                z3 = z;
                mode2 = i12;
                virtualChildCount = i11;
            }
            iMax2 = i17;
            i11 = virtualChildCount;
            i12 = mode2;
            z = z3;
            f = f6;
            iMax3 = i18;
            iL++;
            i18 = iMax3;
            i17 = iMax2;
            z3 = z;
            mode2 = i12;
            virtualChildCount = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends LinearLayout.LayoutParams {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }
}
