package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import defpackage.ps3;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class j9 {
    public final TextView a;
    public bp4 b;
    public bp4 c;
    public bp4 d;
    public bp4 e;
    public bp4 f;
    public bp4 g;
    public bp4 h;
    public final l9 i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ps3.e {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;

        public a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.b = i2;
            this.c = weakReference;
        }

        @Override // ps3.e
        public void f(int i) {
        }

        @Override // ps3.e
        public void g(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = e.a(typeface, i, (this.b & 2) != 0);
            }
            j9.this.n(this.c, typeface);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        public final /* synthetic */ TextView f;
        public final /* synthetic */ Typeface g;
        public final /* synthetic */ int h;

        public b(TextView textView, Typeface typeface, int i) {
            this.f = textView;
            this.g = typeface;
            this.h = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.setTypeface(this.g, this.h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        public static void c(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public static Typeface a(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    public j9(TextView textView) {
        this.a = textView;
        this.i = new l9(textView);
    }

    public static bp4 d(Context context, s8 s8Var, int i) {
        ColorStateList colorStateListF = s8Var.f(context, i);
        if (colorStateListF == null) {
            return null;
        }
        bp4 bp4Var = new bp4();
        bp4Var.d = true;
        bp4Var.a = colorStateListF;
        return bp4Var;
    }

    public void A(int i, float f) {
        if (f55.c || l()) {
            return;
        }
        B(i, f);
    }

    public final void B(int i, float f) {
        this.i.t(i, f);
    }

    public final void C(Context context, dp4 dp4Var) {
        String strO;
        this.j = dp4Var.k(mn3.x2, this.j);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int iK = dp4Var.k(mn3.G2, -1);
            this.k = iK;
            if (iK != -1) {
                this.j &= 2;
            }
        }
        if (!dp4Var.s(mn3.F2) && !dp4Var.s(mn3.H2)) {
            if (dp4Var.s(mn3.w2)) {
                this.m = false;
                int iK2 = dp4Var.k(mn3.w2, 1);
                if (iK2 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i2 = dp4Var.s(mn3.H2) ? mn3.H2 : mn3.F2;
        int i3 = this.k;
        int i4 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = dp4Var.j(i2, this.j, new a(i3, i4, new WeakReference(this.a)));
                if (typefaceJ != null) {
                    if (i < 28 || this.k == -1) {
                        this.l = typefaceJ;
                    } else {
                        this.l = e.a(Typeface.create(typefaceJ, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (strO = dp4Var.o(i2)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(strO, this.j);
        } else {
            this.l = e.a(Typeface.create(strO, 0), this.k, (this.j & 2) != 0);
        }
    }

    public final void a(Drawable drawable, bp4 bp4Var) {
        if (drawable == null || bp4Var == null) {
            return;
        }
        s8.i(drawable, bp4Var, this.a.getDrawableState());
    }

    public void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    public void c() {
        this.i.a();
    }

    public int e() {
        return this.i.f();
    }

    public int f() {
        return this.i.g();
    }

    public int g() {
        return this.i.h();
    }

    public int[] h() {
        return this.i.i();
    }

    public int i() {
        return this.i.j();
    }

    public ColorStateList j() {
        bp4 bp4Var = this.h;
        if (bp4Var != null) {
            return bp4Var.a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        bp4 bp4Var = this.h;
        if (bp4Var != null) {
            return bp4Var.b;
        }
        return null;
    }

    public boolean l() {
        return this.i.n();
    }

    public void m(AttributeSet attributeSet, int i) {
        boolean zA;
        boolean z;
        String strO;
        String strO2;
        boolean z2;
        int iA;
        float f;
        Context context = this.a.getContext();
        s8 s8VarB = s8.b();
        dp4 dp4VarV = dp4.v(context, attributeSet, mn3.V, i, 0);
        TextView textView = this.a;
        l35.e0(textView, textView.getContext(), mn3.V, attributeSet, dp4VarV.r(), i, 0);
        int iN = dp4VarV.n(mn3.W, -1);
        if (dp4VarV.s(mn3.Z)) {
            this.b = d(context, s8VarB, dp4VarV.n(mn3.Z, 0));
        }
        if (dp4VarV.s(mn3.X)) {
            this.c = d(context, s8VarB, dp4VarV.n(mn3.X, 0));
        }
        if (dp4VarV.s(mn3.a0)) {
            this.d = d(context, s8VarB, dp4VarV.n(mn3.a0, 0));
        }
        if (dp4VarV.s(mn3.Y)) {
            this.e = d(context, s8VarB, dp4VarV.n(mn3.Y, 0));
        }
        if (dp4VarV.s(mn3.b0)) {
            this.f = d(context, s8VarB, dp4VarV.n(mn3.b0, 0));
        }
        if (dp4VarV.s(mn3.c0)) {
            this.g = d(context, s8VarB, dp4VarV.n(mn3.c0, 0));
        }
        dp4VarV.x();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iN != -1) {
            dp4 dp4VarT = dp4.t(context, iN, mn3.u2);
            if (z3 || !dp4VarT.s(mn3.J2)) {
                zA = false;
                z = false;
            } else {
                zA = dp4VarT.a(mn3.J2, false);
                z = true;
            }
            C(context, dp4VarT);
            strO = dp4VarT.s(mn3.K2) ? dp4VarT.o(mn3.K2) : null;
            strO2 = (Build.VERSION.SDK_INT < 26 || !dp4VarT.s(mn3.I2)) ? null : dp4VarT.o(mn3.I2);
            dp4VarT.x();
        } else {
            zA = false;
            z = false;
            strO = null;
            strO2 = null;
        }
        dp4 dp4VarV2 = dp4.v(context, attributeSet, mn3.u2, i, 0);
        if (z3 || !dp4VarV2.s(mn3.J2)) {
            z2 = z;
        } else {
            zA = dp4VarV2.a(mn3.J2, false);
            z2 = true;
        }
        if (dp4VarV2.s(mn3.K2)) {
            strO = dp4VarV2.o(mn3.K2);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && dp4VarV2.s(mn3.I2)) {
            strO2 = dp4VarV2.o(mn3.I2);
        }
        if (i2 >= 28 && dp4VarV2.s(mn3.v2) && dp4VarV2.f(mn3.v2, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        C(context, dp4VarV2);
        dp4VarV2.x();
        if (!z3 && z2) {
            s(zA);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            int i3 = this.k;
            TextView textView2 = this.a;
            if (i3 == -1) {
                textView2.setTypeface(typeface, this.j);
            } else {
                textView2.setTypeface(typeface);
            }
        }
        if (strO2 != null) {
            d.d(this.a, strO2);
        }
        if (strO != null) {
            c.b(this.a, c.a(strO));
        }
        this.i.o(attributeSet, i);
        if (f55.c && this.i.j() != 0) {
            int[] iArrI = this.i.i();
            if (iArrI.length > 0) {
                float fA = d.a(this.a);
                TextView textView3 = this.a;
                if (fA != -1.0f) {
                    d.b(textView3, this.i.g(), this.i.f(), this.i.h(), 0);
                } else {
                    d.c(textView3, iArrI, 0);
                }
            }
        }
        dp4 dp4VarU = dp4.u(context, attributeSet, mn3.d0);
        int iN2 = dp4VarU.n(mn3.l0, -1);
        Drawable drawableC = iN2 != -1 ? s8VarB.c(context, iN2) : null;
        int iN3 = dp4VarU.n(mn3.q0, -1);
        Drawable drawableC2 = iN3 != -1 ? s8VarB.c(context, iN3) : null;
        int iN4 = dp4VarU.n(mn3.m0, -1);
        Drawable drawableC3 = iN4 != -1 ? s8VarB.c(context, iN4) : null;
        int iN5 = dp4VarU.n(mn3.j0, -1);
        Drawable drawableC4 = iN5 != -1 ? s8VarB.c(context, iN5) : null;
        int iN6 = dp4VarU.n(mn3.n0, -1);
        Drawable drawableC5 = iN6 != -1 ? s8VarB.c(context, iN6) : null;
        int iN7 = dp4VarU.n(mn3.k0, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? s8VarB.c(context, iN7) : null);
        if (dp4VarU.s(mn3.o0)) {
            an4.f(this.a, dp4VarU.c(mn3.o0));
        }
        if (dp4VarU.s(mn3.p0)) {
            an4.g(this.a, fo0.e(dp4VarU.k(mn3.p0, -1), null));
        }
        int iF = dp4VarU.f(mn3.s0, -1);
        int iF2 = dp4VarU.f(mn3.t0, -1);
        if (dp4VarU.s(mn3.u0)) {
            TypedValue typedValueW = dp4VarU.w(mn3.u0);
            if (typedValueW == null || typedValueW.type != 5) {
                f = dp4VarU.f(mn3.u0, -1);
                iA = -1;
            } else {
                iA = xu4.a(typedValueW.data);
                f = TypedValue.complexToFloat(typedValueW.data);
            }
        } else {
            iA = -1;
            f = -1.0f;
        }
        dp4VarU.x();
        if (iF != -1) {
            an4.h(this.a, iF);
        }
        if (iF2 != -1) {
            an4.i(this.a, iF2);
        }
        if (f != -1.0f) {
            TextView textView4 = this.a;
            if (iA == -1) {
                an4.j(textView4, (int) f);
            } else {
                an4.k(textView4, iA, f);
            }
        }
    }

    public void n(WeakReference weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                boolean zIsAttachedToWindow = textView.isAttachedToWindow();
                int i = this.j;
                if (zIsAttachedToWindow) {
                    textView.post(new b(textView, typeface, i));
                } else {
                    textView.setTypeface(typeface, i);
                }
            }
        }
    }

    public void o(boolean z, int i, int i2, int i3, int i4) {
        if (f55.c) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i) {
        String strO;
        dp4 dp4VarT = dp4.t(context, i, mn3.u2);
        if (dp4VarT.s(mn3.J2)) {
            s(dp4VarT.a(mn3.J2, false));
        }
        if (dp4VarT.s(mn3.v2) && dp4VarT.f(mn3.v2, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        C(context, dp4VarT);
        if (Build.VERSION.SDK_INT >= 26 && dp4VarT.s(mn3.I2) && (strO = dp4VarT.o(mn3.I2)) != null) {
            d.d(this.a, strO);
        }
        dp4VarT.x();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        uq0.f(editorInfo, textView.getText());
    }

    public void s(boolean z) {
        this.a.setAllCaps(z);
    }

    public void t(int i, int i2, int i3, int i4) {
        this.i.p(i, i2, i3, i4);
    }

    public void u(int[] iArr, int i) {
        this.i.q(iArr, i);
    }

    public void v(int i) {
        this.i.r(i);
    }

    public void w(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new bp4();
        }
        bp4 bp4Var = this.h;
        bp4Var.a = colorStateList;
        bp4Var.d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new bp4();
        }
        bp4 bp4Var = this.h;
        bp4Var.b = mode;
        bp4Var.c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView2 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public final void z() {
        bp4 bp4Var = this.h;
        this.b = bp4Var;
        this.c = bp4Var;
        this.d = bp4Var;
        this.e = bp4Var;
        this.f = bp4Var;
        this.g = bp4Var;
    }
}
