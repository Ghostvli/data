package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f8 {
    public final CompoundButton a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public f8(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    public void a() {
        Drawable drawableA = sy.a(this.a);
        if (drawableA != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = tn0.r(drawableA).mutate();
                if (this.d) {
                    tn0.o(drawableMutate, this.b);
                }
                if (this.e) {
                    tn0.p(drawableMutate, this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList b() {
        return this.b;
    }

    public PorterDuff.Mode c() {
        return this.c;
    }

    public void d(AttributeSet attributeSet, int i) {
        int iN;
        int iN2;
        dp4 dp4VarV = dp4.v(this.a.getContext(), attributeSet, mn3.R0, i, 0);
        CompoundButton compoundButton = this.a;
        l35.e0(compoundButton, compoundButton.getContext(), mn3.R0, attributeSet, dp4VarV.r(), i, 0);
        try {
            if (dp4VarV.s(mn3.T0) && (iN2 = dp4VarV.n(mn3.T0, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(e9.b(compoundButton2.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    if (dp4VarV.s(mn3.S0)) {
                        CompoundButton compoundButton3 = this.a;
                        compoundButton3.setButtonDrawable(e9.b(compoundButton3.getContext(), iN));
                    }
                }
            } else if (dp4VarV.s(mn3.S0) && (iN = dp4VarV.n(mn3.S0, 0)) != 0) {
                CompoundButton compoundButton32 = this.a;
                compoundButton32.setButtonDrawable(e9.b(compoundButton32.getContext(), iN));
            }
            if (dp4VarV.s(mn3.U0)) {
                sy.d(this.a, dp4VarV.c(mn3.U0));
            }
            if (dp4VarV.s(mn3.V0)) {
                sy.e(this.a, fo0.e(dp4VarV.k(mn3.V0, -1), null));
            }
            dp4VarV.x();
        } catch (Throwable th) {
            dp4VarV.x();
            throw th;
        }
    }

    public void e() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    public void g(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        a();
    }
}
