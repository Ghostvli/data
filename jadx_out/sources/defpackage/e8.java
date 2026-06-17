package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class e8 {
    public final CheckedTextView a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public e8(CheckedTextView checkedTextView) {
        this.a = checkedTextView;
    }

    public void a() {
        Drawable drawableA = dt.a(this.a);
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
                this.a.setCheckMarkDrawable(drawableMutate);
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
        dp4 dp4VarV = dp4.v(this.a.getContext(), attributeSet, mn3.M0, i, 0);
        CheckedTextView checkedTextView = this.a;
        l35.e0(checkedTextView, checkedTextView.getContext(), mn3.M0, attributeSet, dp4VarV.r(), i, 0);
        try {
            if (dp4VarV.s(mn3.O0) && (iN2 = dp4VarV.n(mn3.O0, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.a;
                    checkedTextView2.setCheckMarkDrawable(e9.b(checkedTextView2.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    if (dp4VarV.s(mn3.N0)) {
                        CheckedTextView checkedTextView3 = this.a;
                        checkedTextView3.setCheckMarkDrawable(e9.b(checkedTextView3.getContext(), iN));
                    }
                }
            } else if (dp4VarV.s(mn3.N0) && (iN = dp4VarV.n(mn3.N0, 0)) != 0) {
                CheckedTextView checkedTextView32 = this.a;
                checkedTextView32.setCheckMarkDrawable(e9.b(checkedTextView32.getContext(), iN));
            }
            if (dp4VarV.s(mn3.P0)) {
                dt.b(this.a, dp4VarV.c(mn3.P0));
            }
            if (dp4VarV.s(mn3.Q0)) {
                dt.c(this.a, fo0.e(dp4VarV.k(mn3.Q0, -1), null));
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
