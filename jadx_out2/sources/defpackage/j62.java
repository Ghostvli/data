package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class j62 extends b9 {
    public static final int l = ym3.y;
    public static final int[][] m = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList j;
    public boolean k;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Illegal instructions before constructor call */
    public j62(Context context, AttributeSet attributeSet, int i) {
        int i2 = l;
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayI = dn4.i(context2, attributeSet, cn3.O3, i, i2, new int[0]);
        if (typedArrayI.hasValue(cn3.P3)) {
            sy.d(this, k62.b(context2, typedArrayI, cn3.P3));
        }
        if (typedArrayI.hasValue(cn3.Q3)) {
            setRippleColor(k62.b(context2, typedArrayI, cn3.Q3));
        }
        this.k = typedArrayI.getBoolean(cn3.R3, false);
        typedArrayI.recycle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.j == null) {
            int iD = h62.d(this, nk3.s);
            int iD2 = h62.d(this, mk3.j);
            int iD3 = h62.d(this, mk3.l);
            int[][] iArr = m;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = h62.j(iD3, iD, 1.0f);
            iArr2[1] = h62.j(iD3, iD2, 0.54f);
            iArr2[2] = h62.j(iD3, iD2, 0.38f);
            iArr2[3] = h62.j(iD3, iD2, 0.38f);
            this.j = new ColorStateList(iArr, iArr2);
        }
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setRippleColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof DrawableWrapper) {
            background = ((DrawableWrapper) background).getDrawable();
        }
        if (background instanceof RippleDrawable) {
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.k && sy.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUseMaterialThemeColors(boolean z) {
        this.k = z;
        if (z) {
            sy.d(this, getMaterialThemeColorsTintList());
        } else {
            sy.d(this, null);
        }
    }

    public j62(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nk3.F);
    }
}
