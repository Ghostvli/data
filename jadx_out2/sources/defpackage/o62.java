package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o62 {
    public static final int[] a = {R.attr.theme, nk3.K};
    public static final int[] b = {mk3.A};

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        int[] iArr2 = new int[iArr.length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        return iArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(Context context, AttributeSet attributeSet, int i, int i2) {
        return b(context, attributeSet, b, i, i2)[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Context d(Context context, AttributeSet attributeSet, int i, int i2) {
        return e(context, attributeSet, i, i2, new int[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Context e(Context context, AttributeSet attributeSet, int i, int i2, int[] iArr) {
        int iC = c(context, attributeSet, i, i2);
        boolean z = (context instanceof e30) && ((e30) context).c() == iC;
        if (iC == 0 || z) {
            return context;
        }
        e30 e30Var = new e30(context, iC);
        for (int i3 : b(context, attributeSet, iArr, i, i2)) {
            if (i3 != 0) {
                e30Var.getTheme().applyStyle(i3, true);
            }
        }
        int iA = a(context, attributeSet);
        if (iA != 0) {
            e30Var.getTheme().applyStyle(iA, true);
        }
        return e30Var;
    }
}
