package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i62 {
    public static Rect a(Context context, int i, int i2) {
        TypedArray typedArrayI = dn4.i(context, null, cn3.H2, i, i2, new int[0]);
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(cn3.K2, context.getResources().getDimensionPixelSize(zk3.U));
        int dimensionPixelSize2 = typedArrayI.getDimensionPixelSize(cn3.L2, context.getResources().getDimensionPixelSize(zk3.V));
        int dimensionPixelSize3 = typedArrayI.getDimensionPixelSize(cn3.J2, context.getResources().getDimensionPixelSize(zk3.T));
        int dimensionPixelSize4 = typedArrayI.getDimensionPixelSize(cn3.I2, context.getResources().getDimensionPixelSize(zk3.S));
        typedArrayI.recycle();
        int layoutDirection = context.getResources().getConfiguration().getLayoutDirection();
        int i3 = layoutDirection == 1 ? dimensionPixelSize3 : dimensionPixelSize;
        if (layoutDirection != 1) {
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new Rect(i3, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize4);
    }

    public static InsetDrawable b(Drawable drawable, Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
