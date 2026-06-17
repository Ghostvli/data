package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class y44 implements x44 {
    public static final d40 m = new dq3(0.5f);
    public e40 a;
    public e40 b;
    public e40 c;
    public e40 d;
    public d40 e;
    public d40 f;
    public d40 g;
    public d40 h;
    public qq0 i;
    public qq0 j;
    public qq0 k;
    public qq0 l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        d40 a(d40 d40Var);
    }

    public y44() {
        this.a = m62.b();
        this.b = m62.b();
        this.c = m62.b();
        this.d = m62.b();
        this.e = new r(0.0f);
        this.f = new r(0.0f);
        this.g = new r(0.0f);
        this.h = new r(0.0f);
        this.i = m62.c();
        this.j = m62.c();
        this.k = m62.c();
        this.l = m62.c();
    }

    public static b e() {
        return new b();
    }

    public static b f(Context context, int i, int i2) {
        return g(context, i, i2, 0);
    }

    public static b g(Context context, int i, int i2, int i3) {
        return h(context, i, i2, new r(i3));
    }

    public static b h(Context context, int i, int i2, d40 d40Var) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i2, true);
        }
        return m(contextThemeWrapper.obtainStyledAttributes(cn3.c5), d40Var);
    }

    public static b i(Context context, AttributeSet attributeSet, int i, int i2) {
        return j(context, attributeSet, i, i2, 0);
    }

    public static b j(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return k(context, attributeSet, i, i2, new r(i3));
    }

    public static b k(Context context, AttributeSet attributeSet, int i, int i2, d40 d40Var) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cn3.S3, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(cn3.T3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(cn3.U3, 0);
        typedArrayObtainStyledAttributes.recycle();
        return h(context, resourceId, resourceId2, d40Var);
    }

    public static b l(Resources.Theme theme, int i) {
        return m(theme.obtainStyledAttributes(i, cn3.c5), new r(0.0f));
    }

    public static b m(TypedArray typedArray, d40 d40Var) {
        try {
            int i = typedArray.getInt(cn3.d5, 0);
            int i2 = typedArray.getInt(cn3.g5, i);
            int i3 = typedArray.getInt(cn3.h5, i);
            int i4 = typedArray.getInt(cn3.f5, i);
            int i5 = typedArray.getInt(cn3.e5, i);
            d40 d40VarS = s(typedArray, cn3.i5, d40Var);
            d40 d40VarS2 = s(typedArray, cn3.l5, d40VarS);
            d40 d40VarS3 = s(typedArray, cn3.m5, d40VarS);
            d40 d40VarS4 = s(typedArray, cn3.k5, d40VarS);
            return new b().A(i2, d40VarS2).E(i3, d40VarS3).w(i4, d40VarS4).s(i5, s(typedArray, cn3.j5, d40VarS));
        } finally {
            typedArray.recycle();
        }
    }

    public static d40 s(TypedArray typedArray, int i, d40 d40Var) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i2 = typedValuePeekValue.type;
            if (i2 == 5) {
                return new r(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new dq3(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return d40Var;
    }

    public boolean A() {
        return (this.b instanceof lu3) && (this.a instanceof lu3) && (this.c instanceof lu3) && (this.d instanceof lu3);
    }

    public boolean B(RectF rectF) {
        boolean z = this.l.getClass().equals(qq0.class) && this.j.getClass().equals(qq0.class) && this.i.getClass().equals(qq0.class) && this.k.getClass().equals(qq0.class);
        float fA = this.e.a(rectF);
        return z && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && A();
    }

    public b C() {
        return new b(this);
    }

    public y44 D(c cVar) {
        return C().D(cVar.a(x())).H(cVar.a(z())).v(cVar.a(p())).z(cVar.a(r())).m();
    }

    @Override // defpackage.x44
    public y44 a(float f) {
        return C().o(f).m();
    }

    @Override // defpackage.x44
    public y44 b(int[] iArr) {
        return this;
    }

    @Override // defpackage.x44
    public y44 c() {
        return this;
    }

    @Override // defpackage.x44
    public boolean d() {
        return false;
    }

    public qq0 n() {
        return this.k;
    }

    public e40 o() {
        return this.d;
    }

    public d40 p() {
        return this.h;
    }

    public e40 q() {
        return this.c;
    }

    public d40 r() {
        return this.g;
    }

    public qq0 t() {
        return this.l;
    }

    public String toString() {
        return "[" + x() + ", " + z() + ", " + r() + ", " + p() + "]";
    }

    public qq0 u() {
        return this.j;
    }

    public qq0 v() {
        return this.i;
    }

    public e40 w() {
        return this.a;
    }

    public d40 x() {
        return this.e;
    }

    public e40 y() {
        return this.b;
    }

    public d40 z() {
        return this.f;
    }

    public y44(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public e40 a;
        public e40 b;
        public e40 c;
        public e40 d;
        public d40 e;
        public d40 f;
        public d40 g;
        public d40 h;
        public qq0 i;
        public qq0 j;
        public qq0 k;
        public qq0 l;

        public b(y44 y44Var) {
            this.a = m62.b();
            this.b = m62.b();
            this.c = m62.b();
            this.d = m62.b();
            this.e = new r(0.0f);
            this.f = new r(0.0f);
            this.g = new r(0.0f);
            this.h = new r(0.0f);
            this.i = m62.c();
            this.j = m62.c();
            this.k = m62.c();
            this.l = m62.c();
            this.a = y44Var.a;
            this.b = y44Var.b;
            this.c = y44Var.c;
            this.d = y44Var.d;
            this.e = y44Var.e;
            this.f = y44Var.f;
            this.g = y44Var.g;
            this.h = y44Var.h;
            this.i = y44Var.i;
            this.j = y44Var.j;
            this.k = y44Var.k;
            this.l = y44Var.l;
        }

        public static float n(e40 e40Var) {
            if (e40Var instanceof lu3) {
                return ((lu3) e40Var).a;
            }
            if (e40Var instanceof h70) {
                return ((h70) e40Var).a;
            }
            return -1.0f;
        }

        public b A(int i, d40 d40Var) {
            return B(m62.a(i)).D(d40Var);
        }

        public b B(e40 e40Var) {
            this.a = e40Var;
            float fN = n(e40Var);
            if (fN != -1.0f) {
                C(fN);
            }
            return this;
        }

        public b C(float f) {
            this.e = new r(f);
            return this;
        }

        public b D(d40 d40Var) {
            this.e = d40Var;
            return this;
        }

        public b E(int i, d40 d40Var) {
            return F(m62.a(i)).H(d40Var);
        }

        public b F(e40 e40Var) {
            this.b = e40Var;
            float fN = n(e40Var);
            if (fN != -1.0f) {
                G(fN);
            }
            return this;
        }

        public b G(float f) {
            this.f = new r(f);
            return this;
        }

        public b H(d40 d40Var) {
            this.f = d40Var;
            return this;
        }

        public y44 m() {
            return new y44(this);
        }

        public b o(float f) {
            return C(f).G(f).y(f).u(f);
        }

        public b p(int i, float f) {
            return q(m62.a(i)).o(f);
        }

        public b q(e40 e40Var) {
            return B(e40Var).F(e40Var).x(e40Var).t(e40Var);
        }

        public b r(qq0 qq0Var) {
            this.k = qq0Var;
            return this;
        }

        public b s(int i, d40 d40Var) {
            return t(m62.a(i)).v(d40Var);
        }

        public b t(e40 e40Var) {
            this.d = e40Var;
            float fN = n(e40Var);
            if (fN != -1.0f) {
                u(fN);
            }
            return this;
        }

        public b u(float f) {
            this.h = new r(f);
            return this;
        }

        public b v(d40 d40Var) {
            this.h = d40Var;
            return this;
        }

        public b w(int i, d40 d40Var) {
            return x(m62.a(i)).z(d40Var);
        }

        public b x(e40 e40Var) {
            this.c = e40Var;
            float fN = n(e40Var);
            if (fN != -1.0f) {
                y(fN);
            }
            return this;
        }

        public b y(float f) {
            this.g = new r(f);
            return this;
        }

        public b z(d40 d40Var) {
            this.g = d40Var;
            return this;
        }

        public b() {
            this.a = m62.b();
            this.b = m62.b();
            this.c = m62.b();
            this.d = m62.b();
            this.e = new r(0.0f);
            this.f = new r(0.0f);
            this.g = new r(0.0f);
            this.h = new r(0.0f);
            this.i = m62.c();
            this.j = m62.c();
            this.k = m62.c();
            this.l = m62.c();
        }
    }
}
