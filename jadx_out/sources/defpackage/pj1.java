package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pj1 {
    public ColorStateList A;
    public Typeface B;
    public final int a;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;
    public final TimeInterpolator f;
    public final Context g;
    public final TextInputLayout h;
    public LinearLayout i;
    public int j;
    public FrameLayout k;
    public Animator l;
    public final float m;
    public int n;
    public int o;
    public CharSequence p;
    public boolean q;
    public TextView r;
    public CharSequence s;
    public int t;
    public int u;
    public ColorStateList v;
    public CharSequence w;
    public boolean x;
    public TextView y;
    public int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ TextView d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.a = i;
            this.b = textView;
            this.c = i2;
            this.d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            pj1.this.n = this.a;
            pj1.this.l = null;
            TextView textView = this.b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.c == 1 && pj1.this.r != null) {
                    pj1.this.r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setVisibility(0);
                this.d.setAlpha(0.0f);
            }
        }
    }

    public pj1(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.g = context;
        this.h = textInputLayout;
        this.m = context.getResources().getDimensionPixelSize(zk3.n);
        this.a = lu2.f(context, mk3.I, 217);
        this.b = lu2.f(context, mk3.F, Token.LET);
        this.c = lu2.f(context, mk3.I, Token.LET);
        this.d = lu2.g(context, mk3.K, k7.d);
        int i = mk3.K;
        TimeInterpolator timeInterpolator = k7.a;
        this.e = lu2.g(context, i, timeInterpolator);
        this.f = lu2.g(context, mk3.M, timeInterpolator);
    }

    public boolean A() {
        return this.q;
    }

    public boolean B() {
        return this.x;
    }

    public void C(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.i == null) {
            return;
        }
        if (!z(i) || (frameLayout = this.k) == null) {
            this.i.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i2 = this.j - 1;
        this.j = i2;
        O(this.i, i2);
    }

    public final void D(int i, int i2) {
        TextView textViewL;
        TextView textViewL2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (textViewL2 = l(i2)) != null) {
            textViewL2.setVisibility(0);
            textViewL2.setAlpha(1.0f);
        }
        if (i != 0 && (textViewL = l(i)) != null) {
            textViewL.setVisibility(4);
            if (i == 1) {
                textViewL.setText((CharSequence) null);
            }
        }
        this.n = i2;
    }

    public void E(int i) {
        this.t = i;
        TextView textView = this.r;
        if (textView != null) {
            textView.setAccessibilityLiveRegion(i);
        }
    }

    public void F(CharSequence charSequence) {
        this.s = charSequence;
        TextView textView = this.r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void G(boolean z) {
        if (this.q == z) {
            return;
        }
        g();
        if (z) {
            k9 k9Var = new k9(this.g);
            this.r = k9Var;
            k9Var.setId(ol3.v);
            this.r.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.r.setTypeface(typeface);
            }
            H(this.u);
            I(this.v);
            F(this.s);
            E(this.t);
            this.r.setVisibility(4);
            d(this.r, 0);
        } else {
            v();
            C(this.r, 0);
            this.r = null;
            this.h.q0();
            this.h.C0();
        }
        this.q = z;
    }

    public void H(int i) {
        this.u = i;
        TextView textView = this.r;
        if (textView != null) {
            this.h.c0(textView, i);
        }
    }

    public void I(ColorStateList colorStateList) {
        this.v = colorStateList;
        TextView textView = this.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void J(int i) {
        this.z = i;
        TextView textView = this.y;
        if (textView != null) {
            an4.m(textView, i);
        }
    }

    public void K(boolean z) {
        if (this.x == z) {
            return;
        }
        g();
        if (z) {
            k9 k9Var = new k9(this.g);
            this.y = k9Var;
            k9Var.setId(ol3.w);
            this.y.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.y.setTypeface(typeface);
            }
            this.y.setVisibility(4);
            this.y.setImportantForAccessibility(2);
            J(this.z);
            L(this.A);
            d(this.y, 1);
        } else {
            w();
            C(this.y, 1);
            this.y = null;
            this.h.q0();
            this.h.C0();
        }
        this.x = z;
    }

    public void L(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public final void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void N(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            M(this.r, typeface);
            M(this.y, typeface);
        }
    }

    public final void O(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean P(TextView textView, CharSequence charSequence) {
        if (this.h.isLaidOut() && this.h.isEnabled()) {
            return (this.o == this.n && textView != null && TextUtils.equals(textView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public void Q(CharSequence charSequence) {
        g();
        this.p = charSequence;
        this.r.setText(charSequence);
        int i = this.n;
        if (i != 1) {
            this.o = 1;
        }
        S(i, this.o, P(this.r, charSequence));
    }

    public void R(CharSequence charSequence) {
        g();
        this.w = charSequence;
        this.y.setText(charSequence);
        int i = this.n;
        if (i != 2) {
            this.o = 2;
        }
        S(i, this.o, P(this.y, charSequence));
    }

    public final void S(int i, int i2, boolean z) {
        pj1 pj1Var;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.l = animatorSet;
            ArrayList arrayList = new ArrayList();
            pj1Var = this;
            pj1Var.h(arrayList, this.x, this.y, 2, i, i2);
            pj1Var.h(arrayList, pj1Var.q, pj1Var.r, 1, i, i2);
            o7.a(animatorSet, arrayList);
            animatorSet.addListener(pj1Var.new a(i2, pj1Var.l(i), i, pj1Var.l(i2)));
            animatorSet.start();
        } else {
            pj1Var = this;
            pj1Var.D(i, i2);
        }
        pj1Var.h.q0();
        pj1Var.h.w0(z);
        pj1Var.h.C0();
    }

    public void d(TextView textView, int i) {
        if (this.i == null && this.k == null) {
            LinearLayout linearLayout = new LinearLayout(this.g);
            this.i = linearLayout;
            linearLayout.setOrientation(0);
            this.h.addView(this.i, -1, -2);
            this.k = new FrameLayout(this.g);
            this.i.addView(this.k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.h.getEditText() != null) {
                e();
            }
        }
        if (z(i)) {
            this.k.setVisibility(0);
            this.k.addView(textView);
        } else {
            this.i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.i.setVisibility(0);
        this.j++;
    }

    public void e() {
        if (f()) {
            EditText editText = this.h.getEditText();
            boolean zK = k62.k(this.g);
            this.i.setPaddingRelative(t(zK, zk3.P, editText.getPaddingStart()), t(zK, zk3.Q, this.g.getResources().getDimensionPixelSize(zk3.O)), t(zK, zk3.P, editText.getPaddingEnd()), 0);
        }
    }

    public final boolean f() {
        return (this.i == null || this.h.getEditText() == null) ? false : true;
    }

    public void g() {
        Animator animator = this.l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void h(List list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            ObjectAnimator objectAnimatorI = i(textView, i3 == i);
            if (i == i3 && i2 != 0) {
                objectAnimatorI.setStartDelay(this.c);
            }
            list.add(objectAnimatorI);
            if (i3 != i || i2 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorJ = j(textView);
            objectAnimatorJ.setStartDelay(this.c);
            list.add(objectAnimatorJ);
        }
    }

    public final ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z ? this.b : this.c);
        objectAnimatorOfFloat.setInterpolator(z ? this.e : this.f);
        return objectAnimatorOfFloat;
    }

    public final ObjectAnimator j(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.m, 0.0f);
        objectAnimatorOfFloat.setDuration(this.a);
        objectAnimatorOfFloat.setInterpolator(this.d);
        return objectAnimatorOfFloat;
    }

    public boolean k() {
        return x(this.o);
    }

    public final TextView l(int i) {
        if (i == 1) {
            return this.r;
        }
        if (i != 2) {
            return null;
        }
        return this.y;
    }

    public int m() {
        return this.t;
    }

    public CharSequence n() {
        return this.s;
    }

    public CharSequence o() {
        return this.p;
    }

    public int p() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public ColorStateList q() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence r() {
        return this.w;
    }

    public int s() {
        TextView textView = this.y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int t(boolean z, int i, int i2) {
        return z ? this.g.getResources().getDimensionPixelSize(i) : i2;
    }

    public boolean u() {
        return y(this.o);
    }

    public void v() {
        this.p = null;
        g();
        if (this.n == 1) {
            if (!this.x || TextUtils.isEmpty(this.w)) {
                this.o = 0;
            } else {
                this.o = 2;
            }
        }
        S(this.n, this.o, P(this.r, ""));
    }

    public void w() {
        g();
        int i = this.n;
        if (i == 2) {
            this.o = 0;
        }
        S(i, this.o, P(this.y, ""));
    }

    public final boolean x(int i) {
        return (i != 1 || this.r == null || TextUtils.isEmpty(this.p)) ? false : true;
    }

    public final boolean y(int i) {
        return (i != 2 || this.y == null || TextUtils.isEmpty(this.w)) ? false : true;
    }

    public boolean z(int i) {
        return i == 0 || i == 1;
    }
}
