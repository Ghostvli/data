package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p52 {
    public static TypedValue a(Context context, int i) {
        return b(context.getTheme(), i);
    }

    public static TypedValue b(Resources.Theme theme, int i) {
        TypedValue typedValue = new TypedValue();
        if (theme.resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean c(Context context, int i, boolean z) {
        return d(context.getTheme(), i, z);
    }

    public static boolean d(Resources.Theme theme, int i, boolean z) {
        TypedValue typedValueB = b(theme, i);
        return (typedValueB == null || typedValueB.type != 18) ? z : typedValueB.data != 0;
    }

    public static float e(Resources.Theme theme, int i, float f) {
        TypedValue typedValueB = b(theme, i);
        return (typedValueB == null || typedValueB.type != 5) ? f : typedValueB.getDimension(theme.getResources().getDisplayMetrics());
    }

    public static int f(Context context, int i, int i2) {
        float fE = e(context.getTheme(), i, Float.NaN);
        return Float.isNaN(fE) ? (int) context.getResources().getDimension(i2) : (int) fE;
    }

    public static int g(Context context, int i, int i2) {
        return h(context.getTheme(), i, i2);
    }

    public static int h(Resources.Theme theme, int i, int i2) {
        TypedValue typedValueB = b(theme, i);
        return (typedValueB == null || typedValueB.type != 16) ? i2 : typedValueB.data;
    }

    public static int i(Context context) {
        return f(context, mk3.B, zk3.d0);
    }

    public static TypedValue j(Context context, int i, String str) {
        TypedValue typedValueA = a(context, i);
        if (typedValueA != null) {
            return typedValueA;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static TypedValue k(View view, int i) {
        return j(view.getContext(), i, view.getClass().getCanonicalName());
    }
}
