package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vd4 extends LinearLayout {
    public final TextInputLayout f;
    public final TextView g;
    public CharSequence h;
    public final CheckableImageButton i;
    public ColorStateList j;
    public PorterDuff.Mode k;
    public int l;
    public ImageView.ScaleType m;
    public View.OnLongClickListener n;
    public boolean o;

    public vd4(TextInputLayout textInputLayout, dp4 dp4Var) {
        super(textInputLayout.getContext());
        this.f = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(gm3.f, (ViewGroup) this, false);
        this.i = checkableImageButton;
        rh1.e(checkableImageButton);
        k9 k9Var = new k9(getContext());
        this.g = k9Var;
        k(dp4Var);
        j(dp4Var);
        addView(checkableImageButton);
        addView(k9Var);
        checkableImageButton.setOnFocusableChangedListener(new CheckableImageButton.b() { // from class: ud4
            @Override // com.google.android.material.internal.CheckableImageButton.b
            public final void a(View view, boolean z) {
                vd4 vd4Var = this.a;
                rh1.k(vd4Var.i, vd4Var.n, vd4Var.f());
            }
        });
    }

    public void A(boolean z) {
        if (l() != z) {
            this.i.setVisibility(z ? 0 : 8);
            C();
            D();
        }
    }

    public void B(g2 g2Var) {
        if (this.g.getVisibility() != 0) {
            g2Var.M0(this.i);
        } else {
            g2Var.y0(this.g);
            g2Var.M0(this.g);
        }
    }

    public void C() {
        EditText editText = this.f.j;
        if (editText == null) {
            return;
        }
        this.g.setPaddingRelative(l() ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(zk3.R), editText.getCompoundPaddingBottom());
    }

    public final void D() {
        int i = (this.h == null || this.o) ? 8 : 0;
        setVisibility((this.i.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.g.setVisibility(i);
        this.f.p0();
    }

    public CharSequence b() {
        return this.h;
    }

    public ColorStateList c() {
        return this.g.getTextColors();
    }

    public int d() {
        return getPaddingStart() + this.g.getPaddingStart() + (l() ? this.i.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.i.getLayoutParams()).getMarginEnd() : 0);
    }

    public TextView e() {
        return this.g;
    }

    public CharSequence f() {
        return this.i.getContentDescription();
    }

    public Drawable g() {
        return this.i.getDrawable();
    }

    public int h() {
        return this.l;
    }

    public ImageView.ScaleType i() {
        return this.m;
    }

    public final void j(dp4 dp4Var) {
        this.g.setVisibility(8);
        this.g.setId(ol3.y);
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.g.setAccessibilityLiveRegion(1);
        p(dp4Var.n(cn3.h8, 0));
        if (dp4Var.s(cn3.i8)) {
            q(dp4Var.c(cn3.i8));
        }
        o(dp4Var.p(cn3.g8));
    }

    public final void k(dp4 dp4Var) {
        if (k62.k(getContext())) {
            ((ViewGroup.MarginLayoutParams) this.i.getLayoutParams()).setMarginEnd(0);
        }
        v(null);
        w(null);
        if (dp4Var.s(cn3.o8)) {
            this.j = k62.a(getContext(), dp4Var, cn3.o8);
        }
        if (dp4Var.s(cn3.p8)) {
            this.k = e55.g(dp4Var.k(cn3.p8, -1), null);
        }
        if (dp4Var.s(cn3.l8)) {
            t(dp4Var.g(cn3.l8));
            if (dp4Var.s(cn3.k8)) {
                s(dp4Var.p(cn3.k8));
            }
            r(dp4Var.a(cn3.j8, true));
        }
        u(dp4Var.f(cn3.m8, getResources().getDimensionPixelSize(zk3.d0)));
        if (dp4Var.s(cn3.n8)) {
            x(rh1.b(dp4Var.k(cn3.n8, -1)));
        }
    }

    public boolean l() {
        return this.i.getVisibility() == 0;
    }

    public void m(boolean z) {
        this.o = z;
        D();
    }

    public void n() {
        rh1.d(this.f, this.i, this.j);
    }

    public void o(CharSequence charSequence) {
        this.h = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.g.setText(charSequence);
        D();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        C();
    }

    public void p(int i) {
        an4.m(this.g, i);
    }

    public void q(ColorStateList colorStateList) {
        this.g.setTextColor(colorStateList);
    }

    public void r(boolean z) {
        this.i.setCheckable(z);
    }

    public void s(CharSequence charSequence) {
        if (f() != charSequence) {
            this.i.setContentDescription(charSequence);
            rh1.k(this.i, this.n, charSequence);
        }
    }

    public void t(Drawable drawable) {
        this.i.setImageDrawable(drawable);
        if (drawable != null) {
            rh1.a(this.f, this.i, this.j, this.k);
            A(true);
            n();
        } else {
            A(false);
            v(null);
            w(null);
            s(null);
        }
    }

    public void u(int i) {
        if (i < 0) {
            jl.a("startIconSize cannot be less than 0");
        } else if (i != this.l) {
            this.l = i;
            rh1.g(this.i, i);
        }
    }

    public void v(View.OnClickListener onClickListener) {
        rh1.h(this.i, onClickListener, this.n);
    }

    public void w(View.OnLongClickListener onLongClickListener) {
        this.n = onLongClickListener;
        rh1.i(this.i, onLongClickListener);
    }

    public void x(ImageView.ScaleType scaleType) {
        this.m = scaleType;
        rh1.j(this.i, scaleType);
    }

    public void y(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            rh1.a(this.f, this.i, colorStateList, this.k);
        }
    }

    public void z(PorterDuff.Mode mode) {
        if (this.k != mode) {
            this.k = mode;
            rh1.a(this.f, this.i, this.j, mode);
        }
    }
}
