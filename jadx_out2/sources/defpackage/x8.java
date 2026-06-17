package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class x8 {
    public final ImageView a;
    public bp4 b;
    public bp4 c;
    public bp4 d;
    public int e = 0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x8(ImageView imageView) {
        this.a = imageView;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new bp4();
        }
        bp4 bp4Var = this.d;
        bp4Var.a();
        ColorStateList colorStateListA = pi1.a(this.a);
        if (colorStateListA != null) {
            bp4Var.d = true;
            bp4Var.a = colorStateListA;
        }
        PorterDuff.Mode modeB = pi1.b(this.a);
        if (modeB != null) {
            bp4Var.c = true;
            bp4Var.b = modeB;
        }
        if (!bp4Var.d && !bp4Var.c) {
            return false;
        }
        s8.i(drawable, bp4Var, this.a.getDrawableState());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        if (this.a.getDrawable() != null) {
            this.a.getDrawable().setLevel(this.e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            fo0.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            bp4 bp4Var = this.c;
            if (bp4Var != null) {
                s8.i(drawable, bp4Var, this.a.getDrawableState());
                return;
            }
            bp4 bp4Var2 = this.b;
            if (bp4Var2 != null) {
                s8.i(drawable, bp4Var2, this.a.getDrawableState());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList d() {
        bp4 bp4Var = this.c;
        if (bp4Var != null) {
            return bp4Var.a;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PorterDuff.Mode e() {
        bp4 bp4Var = this.c;
        if (bp4Var != null) {
            return bp4Var.b;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f() {
        return !(this.a.getBackground() instanceof RippleDrawable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(AttributeSet attributeSet, int i) {
        int iN;
        dp4 dp4VarV = dp4.v(this.a.getContext(), attributeSet, mn3.M, i, 0);
        ImageView imageView = this.a;
        l35.e0(imageView, imageView.getContext(), mn3.M, attributeSet, dp4VarV.r(), i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (iN = dp4VarV.n(mn3.N, -1)) != -1 && (drawable = e9.b(this.a.getContext(), iN)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                fo0.b(drawable);
            }
            if (dp4VarV.s(mn3.O)) {
                pi1.c(this.a, dp4VarV.c(mn3.O));
            }
            if (dp4VarV.s(mn3.P)) {
                pi1.d(this.a, fo0.e(dp4VarV.k(mn3.P, -1), null));
            }
            dp4VarV.x();
        } catch (Throwable th) {
            dp4VarV.x();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(Drawable drawable) {
        this.e = drawable.getLevel();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(int i) {
        ImageView imageView = this.a;
        if (i != 0) {
            Drawable drawableB = e9.b(imageView.getContext(), i);
            if (drawableB != null) {
                fo0.b(drawableB);
            }
            this.a.setImageDrawable(drawableB);
        } else {
            imageView.setImageDrawable(null);
        }
        c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new bp4();
        }
        bp4 bp4Var = this.c;
        bp4Var.a = colorStateList;
        bp4Var.d = true;
        c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new bp4();
        }
        bp4 bp4Var = this.c;
        bp4Var.b = mode;
        bp4Var.c = true;
        c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l() {
        return this.b != null;
    }
}
