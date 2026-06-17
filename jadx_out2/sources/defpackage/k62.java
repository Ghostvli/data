package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k62 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ColorStateList a(Context context, dp4 dp4Var, int i) {
        int iN;
        ColorStateList colorStateListA;
        return (!dp4Var.s(i) || (iN = dp4Var.n(i, 0)) == 0 || (colorStateListA = e9.a(context, iN)) == null) ? dp4Var.c(i) : colorStateListA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ColorStateList b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListA = e9.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(TypedValue typedValue) {
        return typedValue.getComplexUnit();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Drawable e(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableB = e9.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float f(Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bm4 h(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new bm4(context, resourceId);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(Context context, int i, int i2) {
        if (i != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, cn3.Y3);
            TypedValue typedValue = new TypedValue();
            boolean value = typedArrayObtainStyledAttributes.getValue(cn3.d4, typedValue);
            if (!value) {
                value = typedArrayObtainStyledAttributes.getValue(cn3.b4, typedValue);
            }
            typedArrayObtainStyledAttributes.recycle();
            if (value) {
                int iC = c(typedValue);
                int i3 = typedValue.data;
                return iC == 2 ? Math.round(TypedValue.complexToFloat(i3) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(i3, context.getResources().getDisplayMetrics());
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(Context context, int i, int i2) {
        if (i != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, mn3.u2);
            TypedValue typedValue = new TypedValue();
            boolean value = typedArrayObtainStyledAttributes.getValue(mn3.v2, typedValue);
            typedArrayObtainStyledAttributes.recycle();
            if (value) {
                int iC = c(typedValue);
                int i3 = typedValue.data;
                return iC == 2 ? Math.round(TypedValue.complexToFloat(i3) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(i3, context.getResources().getDisplayMetrics());
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean k(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean l(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
