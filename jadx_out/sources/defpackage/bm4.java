package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import defpackage.ps3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bm4 {
    public final ColorStateList a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final String d;
    public String e;
    public final int f;
    public final int g;
    public final boolean h;
    public final float i;
    public final float j;
    public final float k;
    public final boolean l;
    public final float m;
    public ColorStateList n;
    public float o;
    public final int p;
    public boolean q = false;
    public boolean r = false;
    public Typeface s;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ps3.e {
        public final /* synthetic */ dm4 a;

        public a(dm4 dm4Var) {
            this.a = dm4Var;
        }

        @Override // ps3.e
        public void f(int i) {
            bm4.this.q = true;
            this.a.a(i);
        }

        @Override // ps3.e
        public void g(Typeface typeface) {
            bm4 bm4Var = bm4.this;
            bm4Var.s = Typeface.create(typeface, bm4Var.f);
            bm4.this.q = true;
            this.a.b(bm4.this.s, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends dm4 {
        public final /* synthetic */ Context a;
        public final /* synthetic */ TextPaint b;
        public final /* synthetic */ dm4 c;

        public b(Context context, TextPaint textPaint, dm4 dm4Var) {
            this.a = context;
            this.b = textPaint;
            this.c = dm4Var;
        }

        @Override // defpackage.dm4
        public void a(int i) {
            this.c.a(i);
        }

        @Override // defpackage.dm4
        public void b(Typeface typeface, boolean z) {
            bm4.this.t(this.a, this.b, typeface);
            this.c.b(typeface, z);
        }
    }

    public bm4(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, mn3.u2);
        q(typedArrayObtainStyledAttributes.getDimension(mn3.v2, 0.0f));
        p(k62.b(context, typedArrayObtainStyledAttributes, mn3.y2));
        this.a = k62.b(context, typedArrayObtainStyledAttributes, mn3.z2);
        this.b = k62.b(context, typedArrayObtainStyledAttributes, mn3.A2);
        this.f = typedArrayObtainStyledAttributes.getInt(mn3.x2, 0);
        this.g = typedArrayObtainStyledAttributes.getInt(mn3.w2, 1);
        int iG = k62.g(typedArrayObtainStyledAttributes, mn3.H2, mn3.F2);
        this.p = typedArrayObtainStyledAttributes.getResourceId(iG, 0);
        this.d = typedArrayObtainStyledAttributes.getString(iG);
        this.h = typedArrayObtainStyledAttributes.getBoolean(mn3.J2, false);
        this.c = k62.b(context, typedArrayObtainStyledAttributes, mn3.B2);
        this.i = typedArrayObtainStyledAttributes.getFloat(mn3.C2, 0.0f);
        this.j = typedArrayObtainStyledAttributes.getFloat(mn3.D2, 0.0f);
        this.k = typedArrayObtainStyledAttributes.getFloat(mn3.E2, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, cn3.Y3);
        this.l = typedArrayObtainStyledAttributes2.hasValue(cn3.Z3);
        this.m = typedArrayObtainStyledAttributes2.getFloat(cn3.Z3, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.e = typedArrayObtainStyledAttributes2.getString(k62.g(typedArrayObtainStyledAttributes2, cn3.c4, cn3.a4));
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    public static String n(Context context, int i) {
        Resources resources = context.getResources();
        if (i != 0 && resources.getResourceTypeName(i).equals("font")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                while (xml.getEventType() != 1) {
                    if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), en3.g);
                        String string = typedArrayObtainAttributes.getString(en3.o);
                        typedArrayObtainAttributes.recycle();
                        return string;
                    }
                    xml.next();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public final void d() {
        String str;
        if (this.s == null && (str = this.d) != null) {
            this.s = Typeface.create(str, this.f);
        }
        if (this.s == null) {
            int i = this.g;
            if (i == 1) {
                this.s = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.s = Typeface.SERIF;
            } else if (i != 3) {
                this.s = Typeface.DEFAULT;
            } else {
                this.s = Typeface.MONOSPACE;
            }
            this.s = Typeface.create(this.s, this.f);
        }
    }

    public Typeface e() {
        d();
        return this.s;
    }

    public Typeface f(Context context) {
        if (this.q) {
            return this.s;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = ps3.g(context, this.p);
                this.s = typefaceG;
                if (typefaceG != null) {
                    this.s = Typeface.create(typefaceG, this.f);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.d, e);
            }
        }
        d();
        this.q = true;
        return this.s;
    }

    public void g(Context context, dm4 dm4Var) {
        if (!m(context)) {
            d();
        }
        int i = this.p;
        if (i == 0) {
            this.q = true;
        }
        if (this.q) {
            dm4Var.b(this.s, true);
            return;
        }
        try {
            ps3.i(context, i, new a(dm4Var), null);
        } catch (Resources.NotFoundException unused) {
            this.q = true;
            dm4Var.a(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.d, e);
            this.q = true;
            dm4Var.a(-3);
        }
    }

    public void h(Context context, TextPaint textPaint, dm4 dm4Var) {
        t(context, textPaint, e());
        g(context, new b(context, textPaint, dm4Var));
    }

    public String i() {
        return this.e;
    }

    public final Typeface j(Context context) {
        Typeface typefaceCreate;
        if (this.r) {
            return null;
        }
        this.r = true;
        String strN = n(context, this.p);
        if (strN == null || (typefaceCreate = Typeface.create(strN, 0)) == Typeface.DEFAULT) {
            return null;
        }
        return Typeface.create(typefaceCreate, this.f);
    }

    public ColorStateList k() {
        return this.n;
    }

    public float l() {
        return this.o;
    }

    public final boolean m(Context context) {
        if (cm4.a()) {
            f(context);
            return true;
        }
        if (this.q) {
            return true;
        }
        int i = this.p;
        if (i == 0) {
            return false;
        }
        Typeface typefaceC = ps3.c(context, i);
        if (typefaceC != null) {
            this.s = typefaceC;
            this.q = true;
            return true;
        }
        Typeface typefaceJ = j(context);
        if (typefaceJ == null) {
            return false;
        }
        this.s = typefaceJ;
        this.q = true;
        return true;
    }

    public void o(String str) {
        this.e = str;
    }

    public void p(ColorStateList colorStateList) {
        this.n = colorStateList;
    }

    public void q(float f) {
        this.o = f;
    }

    public void r(Context context, TextPaint textPaint, dm4 dm4Var) {
        s(context, textPaint, dm4Var);
        ColorStateList colorStateList = this.n;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.k;
        float f2 = this.i;
        float f3 = this.j;
        ColorStateList colorStateList2 = this.c;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void s(Context context, TextPaint textPaint, dm4 dm4Var) {
        Typeface typeface;
        if (m(context) && this.q && (typeface = this.s) != null) {
            t(context, textPaint, typeface);
        } else {
            h(context, textPaint, dm4Var);
        }
    }

    public void t(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = mv4.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i = this.f & (~typeface.getStyle());
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.o);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(null);
            textPaint.setFontVariationSettings(this.e);
        }
        if (this.l) {
            textPaint.setLetterSpacing(this.m);
        }
    }
}
