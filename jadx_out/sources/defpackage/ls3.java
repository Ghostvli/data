package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ls3 {
    public static ls3 i;
    public WeakHashMap a;
    public x64 b;
    public mb4 c;
    public final WeakHashMap d = new WeakHashMap(0);
    public TypedValue e;
    public boolean f;
    public b g;
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static final a j = new a(6);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends f32 {
        public a(int i) {
            super(i);
        }

        public static int j(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter k(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) d(Integer.valueOf(j(i, mode)));
        }

        public PorterDuffColorFilter l(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) e(Integer.valueOf(j(i, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        Drawable a(ls3 ls3Var, Context context, int i);

        boolean b(Context context, int i, Drawable drawable);

        PorterDuff.Mode c(int i);

        ColorStateList d(Context context, int i);

        boolean e(Context context, int i, Drawable drawable);
    }

    public static long d(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ls3 g() {
        try {
            if (i == null) {
                ls3 ls3Var = new ls3();
                i = ls3Var;
                o(ls3Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public static synchronized PorterDuffColorFilter k(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterK;
        a aVar = j;
        porterDuffColorFilterK = aVar.k(i2, mode);
        if (porterDuffColorFilterK == null) {
            porterDuffColorFilterK = new PorterDuffColorFilter(i2, mode);
            aVar.l(i2, mode, porterDuffColorFilterK);
        }
        return porterDuffColorFilterK;
    }

    public static void o(ls3 ls3Var) {
    }

    public static boolean p(Drawable drawable) {
        return (drawable instanceof gz4) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void v(Drawable drawable, bp4 bp4Var, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = bp4Var.d;
        if (z || bp4Var.c) {
            drawable.setColorFilter(f(z ? bp4Var.a : null, bp4Var.c ? bp4Var.b : h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public final synchronized boolean a(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            w02 w02Var = (w02) this.d.get(context);
            if (w02Var == null) {
                w02Var = new w02();
                this.d.put(context, w02Var);
            }
            w02Var.h(j2, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context, int i2, ColorStateList colorStateList) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        mb4 mb4Var = (mb4) this.a.get(context);
        if (mb4Var == null) {
            mb4Var = new mb4();
            this.a.put(context, mb4Var);
        }
        mb4Var.a(i2, colorStateList);
    }

    public final void c(Context context) {
        if (this.f) {
            return;
        }
        this.f = true;
        Drawable drawableI = i(context, bl3.a);
        if (drawableI == null || !p(drawableI)) {
            this.f = false;
            e04.a("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable e(Context context, int i2) {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        b bVar = this.g;
        Drawable drawableA = bVar == null ? null : bVar.a(this, context, i2);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableA);
        }
        return drawableA;
    }

    public final synchronized Drawable h(Context context, long j2) {
        w02 w02Var = (w02) this.d.get(context);
        if (w02Var == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) w02Var.d(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            w02Var.i(j2);
        }
        return null;
    }

    public synchronized Drawable i(Context context, int i2) {
        return j(context, i2, false);
    }

    public synchronized Drawable j(Context context, int i2, boolean z) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i2);
            if (drawableQ == null) {
                drawableQ = e(context, i2);
            }
            if (drawableQ == null) {
                drawableQ = c30.e(context, i2);
            }
            if (drawableQ != null) {
                drawableQ = u(context, i2, z, drawableQ);
            }
            if (drawableQ != null) {
                fo0.b(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    public synchronized ColorStateList l(Context context, int i2) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i2);
        if (colorStateListM == null) {
            b bVar = this.g;
            colorStateListM = bVar == null ? null : bVar.d(context, i2);
            if (colorStateListM != null) {
                b(context, i2, colorStateListM);
            }
        }
        return colorStateListM;
    }

    public final ColorStateList m(Context context, int i2) {
        mb4 mb4Var;
        WeakHashMap weakHashMap = this.a;
        if (weakHashMap == null || (mb4Var = (mb4) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) mb4Var.d(i2);
    }

    public PorterDuff.Mode n(int i2) {
        b bVar = this.g;
        if (bVar == null) {
            return null;
        }
        return bVar.c(i2);
    }

    public final Drawable q(Context context, int i2) {
        int next;
        x64 x64Var = this.b;
        if (x64Var == null || x64Var.isEmpty()) {
            return null;
        }
        mb4 mb4Var = this.c;
        if (mb4Var != null) {
            String str = (String) mb4Var.d(i2);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.b.get(str) == null)) {
                return null;
            }
        } else {
            this.c = new mb4();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.c.a(i2, name);
                w82.a(this.b.get(name));
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (drawableH == null) {
            this.c.a(i2, "appcompat_skip_skip");
        }
        return drawableH;
    }

    public synchronized void r(Context context) {
        w02 w02Var = (w02) this.d.get(context);
        if (w02Var != null) {
            w02Var.a();
        }
    }

    public synchronized Drawable s(Context context, hz4 hz4Var, int i2) {
        try {
            Drawable drawableQ = q(context, i2);
            if (drawableQ == null) {
                drawableQ = hz4Var.a(i2);
            }
            if (drawableQ == null) {
                return null;
            }
            return u(context, i2, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(b bVar) {
        this.g = bVar;
    }

    public final Drawable u(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i2);
        if (colorStateListL != null) {
            Drawable drawableR = tn0.r(drawable.mutate());
            tn0.o(drawableR, colorStateListL);
            PorterDuff.Mode modeN = n(i2);
            if (modeN != null) {
                tn0.p(drawableR, modeN);
            }
            return drawableR;
        }
        b bVar = this.g;
        if ((bVar == null || !bVar.e(context, i2, drawable)) && !w(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    public boolean w(Context context, int i2, Drawable drawable) {
        b bVar = this.g;
        return bVar != null && bVar.b(context, i2, drawable);
    }
}
