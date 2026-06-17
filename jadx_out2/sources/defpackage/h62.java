package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h62 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(int i, int i2) {
        return gx.k(i, (Color.alpha(i) * i2) / 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(Context context, int i, int i2) {
        Integer numF = f(context, i);
        return numF != null ? numF.intValue() : i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(Context context, int i, String str) {
        return k(context, p52.j(context, i, str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(View view, int i) {
        return k(view.getContext(), p52.k(view, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(View view, int i, int i2) {
        return b(view.getContext(), i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Integer f(Context context, int i) {
        TypedValue typedValueA = p52.a(context, i);
        if (typedValueA != null) {
            return Integer.valueOf(k(context, typedValueA));
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ColorStateList g(Context context, int i) {
        TypedValue typedValueA = p52.a(context, i);
        if (typedValueA == null) {
            return null;
        }
        int i2 = typedValueA.resourceId;
        if (i2 != 0) {
            return c30.c(context, i2);
        }
        int i3 = typedValueA.data;
        if (i3 != 0) {
            return ColorStateList.valueOf(i3);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean h(int i) {
        return i != 0 && gx.d(i) > 0.5d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(int i, int i2) {
        return gx.g(i2, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(int i, int i2, float f) {
        return i(i, gx.k(i2, Math.round(Color.alpha(i2) * f)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(Context context, TypedValue typedValue) {
        int i = typedValue.resourceId;
        return i != 0 ? c30.b(context, i) : typedValue.data;
    }
}
