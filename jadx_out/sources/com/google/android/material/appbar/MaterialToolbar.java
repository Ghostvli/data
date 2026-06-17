package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.cn3;
import defpackage.dn4;
import defpackage.go0;
import defpackage.l62;
import defpackage.m62;
import defpackage.nk3;
import defpackage.o62;
import defpackage.tn0;
import defpackage.tp4;
import defpackage.y44;
import defpackage.ym3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final int h0 = ym3.F;
    public static final ImageView.ScaleType[] i0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer c0;
    public boolean d0;
    public boolean e0;
    public ImageView.ScaleType f0;
    public Boolean g0;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        int i2 = h0;
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayI = dn4.i(context2, attributeSet, cn3.i4, i, i2, new int[0]);
        if (typedArrayI.hasValue(cn3.l4)) {
            setNavigationIconTint(typedArrayI.getColor(cn3.l4, -1));
        }
        this.d0 = typedArrayI.getBoolean(cn3.n4, false);
        this.e0 = typedArrayI.getBoolean(cn3.m4, false);
        int i3 = typedArrayI.getInt(cn3.k4, -1);
        if (i3 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = i0;
            if (i3 < scaleTypeArr.length) {
                this.f0 = scaleTypeArr[i3];
            }
        }
        if (typedArrayI.hasValue(cn3.j4)) {
            this.g0 = Boolean.valueOf(typedArrayI.getBoolean(cn3.j4, false));
        }
        typedArrayI.recycle();
        U(context2, y44.i(context2, attributeSet, i, i2).m());
    }

    public final Pair T(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    public final void U(Context context, y44 y44Var) {
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : go0.f(background);
        if (colorStateListValueOf != null) {
            l62 l62Var = new l62(y44Var);
            l62Var.e0(colorStateListValueOf);
            l62Var.S(context);
            l62Var.d0(getElevation());
            setBackground(l62Var);
        }
    }

    public final void V(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i2 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, Buffer.MAX_SIZE), view.getMeasuredHeightAndState());
        }
        view.layout(i, view.getTop(), i2, view.getBottom());
    }

    public final void W() {
        if (this.d0 || this.e0) {
            TextView textViewE = tp4.e(this);
            TextView textViewC = tp4.c(this);
            if (textViewE == null && textViewC == null) {
                return;
            }
            Pair pairT = T(textViewE, textViewC);
            if (this.d0 && textViewE != null) {
                V(textViewE, pairT);
            }
            if (!this.e0 || textViewC == null) {
                return;
            }
            V(textViewC, pairT);
        }
    }

    public final Drawable X(Drawable drawable) {
        if (drawable == null || this.c0 == null) {
            return drawable;
        }
        Drawable drawableR = tn0.r(drawable.mutate());
        drawableR.setTint(this.c0.intValue());
        return drawableR;
    }

    public final void Y() {
        ImageView imageViewB = tp4.b(this);
        if (imageViewB != null) {
            Boolean bool = this.g0;
            if (bool != null) {
                imageViewB.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f0;
            if (scaleType != null) {
                imageViewB.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f0;
    }

    public Integer getNavigationIconTint() {
        return this.c0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m62.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        W();
        Y();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        m62.d(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.g0;
        if (bool == null || bool.booleanValue() != z) {
            this.g0 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f0 != scaleType) {
            this.f0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(X(drawable));
    }

    public void setNavigationIconTint(int i) {
        this.c0 = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.e0 != z) {
            this.e0 = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.d0 != z) {
            this.d0 = z;
            requestLayout();
        }
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nk3.M);
    }

    public MaterialToolbar(Context context) {
        this(context, null);
    }
}
