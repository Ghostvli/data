package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
        public a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            j23.a(j23.this);
            return (j23.this.j == null || j23.this.j.C(menuItem)) ? false : true;
        }

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

    /* JADX WARN: Removed duplicated region for block: B:56:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0258  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j23(android.content.Context r10, android.util.AttributeSet r11, int r12, int r13) {
        /*
            Method dump skipped, instruction units count: 677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j23.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    public static /* synthetic */ b a(j23 j23Var) {
        j23Var.getClass();
        return null;
    }

    private MenuInflater getMenuInflater() {
        if (this.i == null) {
            this.i = new dj4(getContext());
        }
        return this.i;
    }

    private void setMeasureBottomPaddingFromLabelBaseline(boolean z) {
        this.g.setMeasurePaddingFromLabelBaseline(z);
    }

    public abstract f23 c(Context context);

    public void d(int i) {
        this.h.k(true);
        getMenuInflater().inflate(i, this.f);
        this.h.k(false);
        this.h.c(true);
    }

    public boolean e() {
        return false;
    }

    public void f(int i, int i2, int i3, int i4) {
        this.g.o(i, i2, i3, i4);
    }

    public boolean g() {
        return false;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.g.getActiveIndicatorLabelPadding();
    }

    public int getCollapsedMaxItemCount() {
        return getMaxItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.g.getHorizontalItemTextAppearanceActive();
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.g.getHorizontalItemTextAppearanceInactive();
    }

    public int getIconLabelHorizontalSpacing() {
        return this.g.getIconLabelHorizontalSpacing();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.g.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.g.getItemActiveIndicatorExpandedHeight();
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.g.getItemActiveIndicatorExpandedMarginHorizontal();
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.g.getItemActiveIndicatorExpandedWidth();
    }

    public int getItemActiveIndicatorHeight() {
        return this.g.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.g.getItemActiveIndicatorMarginHorizontal();
    }

    public y44 getItemActiveIndicatorShapeAppearance() {
        return this.g.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.g.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.g.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.g.getItemBackgroundRes();
    }

    public int getItemGravity() {
        return this.g.getItemGravity();
    }

    public int getItemIconGravity() {
        return this.g.getItemIconGravity();
    }

    public int getItemIconSize() {
        return this.g.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.g.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.g.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.g.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.g.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.g.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.g.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.g.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.g.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f;
    }

    public j getMenuView() {
        return this.g;
    }

    public ViewGroup getMenuViewGroup() {
        return this.g;
    }

    public g23 getPresenter() {
        return this.h;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.g.getScaleLabelTextWithFont();
    }

    public int getSelectedItemId() {
        return this.g.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m62.e(this);
    }

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

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        dVar.h = bundle;
        this.f.V(bundle);
        return dVar;
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.g.setActiveIndicatorLabelPadding(i);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        m62.d(this, f);
    }

    public void setHorizontalItemTextAppearanceActive(int i) {
        this.g.setHorizontalItemTextAppearanceActive(i);
    }

    public void setHorizontalItemTextAppearanceInactive(int i) {
        this.g.setHorizontalItemTextAppearanceInactive(i);
    }

    public void setIconLabelHorizontalSpacing(int i) {
        this.g.setIconLabelHorizontalSpacing(i);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.g.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.g.setItemActiveIndicatorEnabled(z);
    }

    public void setItemActiveIndicatorExpandedHeight(int i) {
        this.g.setItemActiveIndicatorExpandedHeight(i);
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i) {
        this.g.setItemActiveIndicatorExpandedMarginHorizontal(i);
    }

    public void setItemActiveIndicatorExpandedWidth(int i) {
        this.g.setItemActiveIndicatorExpandedWidth(i);
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.g.setItemActiveIndicatorHeight(i);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.g.setItemActiveIndicatorMarginHorizontal(i);
    }

    public void setItemActiveIndicatorShapeAppearance(y44 y44Var) {
        this.g.setItemActiveIndicatorShapeAppearance(y44Var);
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.g.setItemActiveIndicatorWidth(i);
    }

    public void setItemBackground(Drawable drawable) {
        this.g.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.g.setItemBackgroundRes(i);
    }

    public void setItemGravity(int i) {
        if (this.g.getItemGravity() != i) {
            this.g.setItemGravity(i);
            this.h.c(false);
        }
    }

    public void setItemIconGravity(int i) {
        if (this.g.getItemIconGravity() != i) {
            this.g.setItemIconGravity(i);
            this.h.c(false);
        }
    }

    public void setItemIconSize(int i) {
        this.g.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.g.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i) {
        this.g.setItemPaddingBottom(i);
    }

    public void setItemPaddingTop(int i) {
        this.g.setItemPaddingTop(i);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.g.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.g.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.g.setItemTextAppearanceActiveBoldEnabled(z);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.g.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.g.setItemTextColor(colorStateList);
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.g.setLabelFontScalingEnabled(z);
    }

    public void setLabelMaxLines(int i) {
        this.g.setLabelMaxLines(i);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.g.getLabelVisibilityMode() != i) {
            this.g.setLabelVisibilityMode(i);
            this.h.c(false);
        }
    }

    public void setOnItemReselectedListener(b bVar) {
    }

    public void setOnItemSelectedListener(c cVar) {
        this.j = cVar;
    }

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
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            d(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        public final void d(Parcel parcel, ClassLoader classLoader) {
            this.h = parcel.readBundle(classLoader);
        }

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
