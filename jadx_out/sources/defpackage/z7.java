package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class z7 {
    public final View a;
    public bp4 d;
    public bp4 e;
    public bp4 f;
    public int c = -1;
    public final s8 b = s8.b();

    public z7(View view) {
        this.a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f == null) {
            this.f = new bp4();
        }
        bp4 bp4Var = this.f;
        bp4Var.a();
        ColorStateList colorStateListQ = l35.q(this.a);
        if (colorStateListQ != null) {
            bp4Var.d = true;
            bp4Var.a = colorStateListQ;
        }
        PorterDuff.Mode modeR = l35.r(this.a);
        if (modeR != null) {
            bp4Var.c = true;
            bp4Var.b = modeR;
        }
        if (!bp4Var.d && !bp4Var.c) {
            return false;
        }
        s8.i(drawable, bp4Var, this.a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            bp4 bp4Var = this.e;
            if (bp4Var != null) {
                s8.i(background, bp4Var, this.a.getDrawableState());
                return;
            }
            bp4 bp4Var2 = this.d;
            if (bp4Var2 != null) {
                s8.i(background, bp4Var2, this.a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        bp4 bp4Var = this.e;
        if (bp4Var != null) {
            return bp4Var.a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        bp4 bp4Var = this.e;
        if (bp4Var != null) {
            return bp4Var.b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i) {
        dp4 dp4VarV = dp4.v(this.a.getContext(), attributeSet, mn3.s3, i, 0);
        View view = this.a;
        l35.e0(view, view.getContext(), mn3.s3, attributeSet, dp4VarV.r(), i, 0);
        try {
            if (dp4VarV.s(mn3.t3)) {
                this.c = dp4VarV.n(mn3.t3, -1);
                ColorStateList colorStateListF = this.b.f(this.a.getContext(), this.c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (dp4VarV.s(mn3.u3)) {
                l35.j0(this.a, dp4VarV.c(mn3.u3));
            }
            if (dp4VarV.s(mn3.v3)) {
                l35.k0(this.a, fo0.e(dp4VarV.k(mn3.v3, -1), null));
            }
            dp4VarV.x();
        } catch (Throwable th) {
            dp4VarV.x();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.c = -1;
        h(null);
        b();
    }

    public void g(int i) {
        this.c = i;
        s8 s8Var = this.b;
        h(s8Var != null ? s8Var.f(this.a.getContext(), i) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new bp4();
            }
            bp4 bp4Var = this.d;
            bp4Var.a = colorStateList;
            bp4Var.d = true;
        } else {
            this.d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new bp4();
        }
        bp4 bp4Var = this.e;
        bp4Var.a = colorStateList;
        bp4Var.d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new bp4();
        }
        bp4 bp4Var = this.e;
        bp4Var.b = mode;
        bp4Var.c = true;
        b();
    }

    public final boolean k() {
        return this.d != null;
    }
}
