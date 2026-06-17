package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j23 extends FrameLayout {
    public final c23 f;
    public final f23 g;
    public final g23 h;
    public MenuInflater i;
    public c j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements e.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            j23.a(j23.this);
            return (j23.this.j == null || j23.this.j.C(menuItem)) ? false : true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        boolean C(MenuItem menuItem);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:56:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0258  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j23(Context context, AttributeSet attributeSet, int i, int i2) {
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        g23 g23Var = new g23();
        this.h = g23Var;
        Context context2 = getContext();
        dp4 dp4VarJ = dn4.j(context2, attributeSet, cn3.B4, i, i2, cn3.T4, cn3.R4);
        c23 c23Var = new c23(context2, getClass(), getMaxItemCount(), e());
        this.f = c23Var;
        f23 f23VarC = c(context2);
        this.g = f23VarC;
        f23VarC.setMinimumHeight(getSuggestedMinimumHeight());
        f23VarC.setCollapsedMaxItemCount(getCollapsedMaxItemCount());
        g23Var.h(f23VarC);
        g23Var.a(1);
        f23VarC.setPresenter(g23Var);
        c23Var.b(g23Var);
        g23Var.i(getContext(), c23Var);
        if (dp4VarJ.s(cn3.N4)) {
            f23VarC.setIconTintList(dp4VarJ.c(cn3.N4));
        } else {
            f23VarC.setIconTintList(f23VarC.e(R.attr.textColorSecondary));
        }
        setItemIconSize(dp4VarJ.f(cn3.M4, getResources().getDimensionPixelSize(zk3.e0)));
        if (dp4VarJ.s(cn3.T4)) {
            setItemTextAppearanceInactive(dp4VarJ.n(cn3.T4, 0));
        }
        if (dp4VarJ.s(cn3.R4)) {
            setItemTextAppearanceActive(dp4VarJ.n(cn3.R4, 0));
        }
        if (dp4VarJ.s(cn3.G4)) {
            setHorizontalItemTextAppearanceInactive(dp4VarJ.n(cn3.G4, 0));
        }
        if (dp4VarJ.s(cn3.F4)) {
            setHorizontalItemTextAppearanceActive(dp4VarJ.n(cn3.F4, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(dp4VarJ.a(cn3.S4, true));
        if (dp4VarJ.s(cn3.U4)) {
            setItemTextColor(dp4VarJ.c(cn3.U4));
        }
        Drawable background = getBackground();
        ColorStateList colorStateListF = go0.f(background);
        if (background == null || colorStateListF != null) {
            l62 l62Var = new l62(y44.i(context2, attributeSet, i, i2).m());
            if (colorStateListF != null) {
                l62Var.e0(colorStateListF);
            }
            l62Var.S(context2);
            setBackground(l62Var);
        }
        if (dp4VarJ.s(cn3.P4)) {
            setItemPaddingTop(dp4VarJ.f(cn3.P4, 0));
        }
        if (dp4VarJ.s(cn3.O4)) {
            setItemPaddingBottom(dp4VarJ.f(cn3.O4, 0));
        }
        if (dp4VarJ.s(cn3.C4)) {
            setActiveIndicatorLabelPadding(dp4VarJ.f(cn3.C4, 0));
        }
        if (dp4VarJ.s(cn3.H4)) {
            setIconLabelHorizontalSpacing(dp4VarJ.f(cn3.H4, 0));
        }
        if (dp4VarJ.s(cn3.E4)) {
            setElevation(dp4VarJ.f(cn3.E4, 0));
        }
        getBackground().mutate().setTintList(k62.a(context2, dp4VarJ, cn3.D4));
        int dimensionPixelSize = -1;
        setLabelVisibilityMode(dp4VarJ.l(cn3.X4, -1));
        setItemIconGravity(dp4VarJ.l(cn3.L4, 0));
        setItemGravity(dp4VarJ.l(cn3.K4, 49));
        int iN = dp4VarJ.n(cn3.J4, 0);
        if (iN != 0) {
            f23VarC.setItemBackgroundRes(iN);
        } else {
            setItemRippleColor(k62.a(context2, dp4VarJ, cn3.Q4));
        }
        setMeasureBottomPaddingFromLabelBaseline(dp4VarJ.a(cn3.Y4, true));
        setLabelFontScalingEnabled(dp4VarJ.a(cn3.V4, false));
        setLabelMaxLines(dp4VarJ.l(cn3.W4, 1));
        int iN2 = dp4VarJ.n(cn3.I4, 0);
        if (iN2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iN2, cn3.o4);
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.q4, 0);
            setItemActiveIndicatorWidth(dimensionPixelSize2);
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.p4, 0));
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.z4, 0);
            setItemActiveIndicatorMarginHorizontal(dimensionPixelOffset);
            String string = typedArrayObtainStyledAttributes.getString(cn3.y4);
            if (string == null) {
                dimensionPixelSize = -2;
                setItemActiveIndicatorExpandedWidth(dimensionPixelSize);
                setItemActiveIndicatorExpandedHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.w4, dimensionPixelSize2));
                setItemActiveIndicatorExpandedMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.x4, dimensionPixelOffset));
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(zk3.D);
                int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.u4, dimensionPixelSize3);
                int dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.t4, dimensionPixelSize3);
                f(getLayoutDirection() != 1 ? dimensionPixelOffset3 : dimensionPixelOffset2, typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.v4, 0), getLayoutDirection() != 1 ? dimensionPixelOffset3 : dimensionPixelOffset2, typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.s4, 0));
                setItemActiveIndicatorColor(k62.b(context2, typedArrayObtainStyledAttributes, cn3.r4));
                setItemActiveIndicatorShapeAppearance(y44.f(context2, typedArrayObtainStyledAttributes.getResourceId(cn3.A4, 0), 0).m());
                typedArrayObtainStyledAttributes.recycle();
            } else {
                if (!String.valueOf(-1).equals(string)) {
                    if (!String.valueOf(-2).equals(string)) {
                        dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.y4, -2);
                    }
                }
                setItemActiveIndicatorExpandedWidth(dimensionPixelSize);
                setItemActiveIndicatorExpandedHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.w4, dimensionPixelSize2));
                setItemActiveIndicatorExpandedMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.x4, dimensionPixelOffset));
                int dimensionPixelSize32 = getResources().getDimensionPixelSize(zk3.D);
                int dimensionPixelOffset22 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.u4, dimensionPixelSize32);
                int dimensionPixelOffset32 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.t4, dimensionPixelSize32);
                f(getLayoutDirection() != 1 ? dimensionPixelOffset32 : dimensionPixelOffset22, typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.v4, 0), getLayoutDirection() != 1 ? dimensionPixelOffset32 : dimensionPixelOffset22, typedArrayObtainStyledAttributes.getDimensionPixelOffset(cn3.s4, 0));
                setItemActiveIndicatorColor(k62.b(context2, typedArrayObtainStyledAttributes, cn3.r4));
                setItemActiveIndicatorShapeAppearance(y44.f(context2, typedArrayObtainStyledAttributes.getResourceId(cn3.A4, 0), 0).m());
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        if (dp4VarJ.s(cn3.Z4)) {
            d(dp4VarJ.n(cn3.Z4, 0));
        }
        dp4VarJ.x();
        if (!g()) {
            addView(f23VarC);
        }
        c23Var.W(new a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ b a(j23 j23Var) {
        j23Var.getClass();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private MenuInflater getMenuInflater() {
        if (this.i == null) {
            this.i = new dj4(getContext());
        }
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setMeasureBottomPaddingFromLabelBaseline(boolean z) {
        this.g.setMeasurePaddingFromLabelBaseline(z);
    }

    public abstract f23 c(Context context);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(int i) {
        this.h.k(true);
        getMenuInflater().inflate(i, this.f);
        this.h.k(false);
        this.h.c(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(int i, int i2, int i3, int i4) {
        this.g.o(i, i2, i3, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getActiveIndicatorLabelPadding() {
        return this.g.getActiveIndicatorLabelPadding();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCollapsedMaxItemCount() {
        return getMaxItemCount();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getHorizontalItemTextAppearanceActive() {
        return this.g.getHorizontalItemTextAppearanceActive();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getHorizontalItemTextAppearanceInactive() {
        return this.g.getHorizontalItemTextAppearanceInactive();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getIconLabelHorizontalSpacing() {
        return this.g.getIconLabelHorizontalSpacing();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getItemActiveIndicatorColor() {
        return this.g.getItemActiveIndicatorColor();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemActiveIndicatorExpandedHeight() {
        return this.g.getItemActiveIndicatorExpandedHeight();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.g.getItemActiveIndicatorExpandedMarginHorizontal();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemActiveIndicatorExpandedWidth() {
        return this.g.getItemActiveIndicatorExpandedWidth();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemActiveIndicatorHeight() {
        return this.g.getItemActiveIndicatorHeight();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.g.getItemActiveIndicatorMarginHorizontal();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y44 getItemActiveIndicatorShapeAppearance() {
        return this.g.getItemActiveIndicatorShapeAppearance();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemActiveIndicatorWidth() {
        return this.g.getItemActiveIndicatorWidth();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drawable getItemBackground() {
        return this.g.getItemBackground();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public int getItemBackgroundResource() {
        return this.g.getItemBackgroundRes();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemGravity() {
        return this.g.getItemGravity();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemIconGravity() {
        return this.g.getItemIconGravity();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemIconSize() {
        return this.g.getItemIconSize();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getItemIconTintList() {
        return this.g.getIconTintList();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemPaddingBottom() {
        return this.g.getItemPaddingBottom();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemPaddingTop() {
        return this.g.getItemPaddingTop();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getItemRippleColor() {
        return this.g.getItemRippleColor();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemTextAppearanceActive() {
        return this.g.getItemTextAppearanceActive();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getItemTextAppearanceInactive() {
        return this.g.getItemTextAppearanceInactive();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList getItemTextColor() {
        return this.g.getItemTextColor();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getLabelVisibilityMode() {
        return this.g.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Menu getMenu() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public j getMenuView() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ViewGroup getMenuViewGroup() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g23 getPresenter() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean getScaleLabelTextWithFont() {
        return this.g.getScaleLabelTextWithFont();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getSelectedItemId() {
        return this.g.getSelectedItemId();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m62.e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.c());
        this.f.T(dVar.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        dVar.h = bundle;
        this.f.V(bundle);
        return dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActiveIndicatorLabelPadding(int i) {
        this.g.setActiveIndicatorLabelPadding(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        m62.d(this, f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHorizontalItemTextAppearanceActive(int i) {
        this.g.setHorizontalItemTextAppearanceActive(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHorizontalItemTextAppearanceInactive(int i) {
        this.g.setHorizontalItemTextAppearanceInactive(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIconLabelHorizontalSpacing(int i) {
        this.g.setIconLabelHorizontalSpacing(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.g.setItemActiveIndicatorColor(colorStateList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorEnabled(boolean z) {
        this.g.setItemActiveIndicatorEnabled(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorExpandedHeight(int i) {
        this.g.setItemActiveIndicatorExpandedHeight(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorExpandedMarginHorizontal(int i) {
        this.g.setItemActiveIndicatorExpandedMarginHorizontal(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorExpandedWidth(int i) {
        this.g.setItemActiveIndicatorExpandedWidth(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorHeight(int i) {
        this.g.setItemActiveIndicatorHeight(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.g.setItemActiveIndicatorMarginHorizontal(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorShapeAppearance(y44 y44Var) {
        this.g.setItemActiveIndicatorShapeAppearance(y44Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemActiveIndicatorWidth(int i) {
        this.g.setItemActiveIndicatorWidth(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemBackground(Drawable drawable) {
        this.g.setItemBackground(drawable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemBackgroundResource(int i) {
        this.g.setItemBackgroundRes(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemGravity(int i) {
        if (this.g.getItemGravity() != i) {
            this.g.setItemGravity(i);
            this.h.c(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemIconGravity(int i) {
        if (this.g.getItemIconGravity() != i) {
            this.g.setItemIconGravity(i);
            this.h.c(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemIconSize(int i) {
        this.g.setItemIconSize(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemIconTintList(ColorStateList colorStateList) {
        this.g.setIconTintList(colorStateList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemPaddingBottom(int i) {
        this.g.setItemPaddingBottom(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemPaddingTop(int i) {
        this.g.setItemPaddingTop(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemRippleColor(ColorStateList colorStateList) {
        this.g.setItemRippleColor(colorStateList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemTextAppearanceActive(int i) {
        this.g.setItemTextAppearanceActive(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.g.setItemTextAppearanceActiveBoldEnabled(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemTextAppearanceInactive(int i) {
        this.g.setItemTextAppearanceInactive(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setItemTextColor(ColorStateList colorStateList) {
        this.g.setItemTextColor(colorStateList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLabelFontScalingEnabled(boolean z) {
        this.g.setLabelFontScalingEnabled(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLabelMaxLines(int i) {
        this.g.setLabelMaxLines(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLabelVisibilityMode(int i) {
        if (this.g.getLabelVisibilityMode() != i) {
            this.g.setLabelVisibilityMode(i);
            this.h.c(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOnItemReselectedListener(b bVar) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOnItemSelectedListener(c cVar) {
        this.j = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSelectedItemId(int i) {
        MenuItem menuItemFindItem = this.f.findItem(i);
        if (menuItemFindItem != null) {
            boolean zP = this.f.P(menuItemFindItem, this.h, 0);
            if (menuItemFindItem.isCheckable()) {
                if (!zP || menuItemFindItem.isChecked()) {
                    this.g.setCheckedItem(menuItemFindItem);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends p {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public Bundle h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            d(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void d(Parcel parcel, ClassLoader classLoader) {
            this.h = parcel.readBundle(classLoader);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.p, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.h);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
