package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.an4;
import defpackage.bt4;
import defpackage.c30;
import defpackage.cn3;
import defpackage.dn4;
import defpackage.dp4;
import defpackage.e55;
import defpackage.e9;
import defpackage.fo0;
import defpackage.g2;
import defpackage.h62;
import defpackage.i70;
import defpackage.jl;
import defpackage.k62;
import defpackage.k7;
import defpackage.k9;
import defpackage.l35;
import defpackage.l62;
import defpackage.le4;
import defpackage.lu2;
import defpackage.me4;
import defpackage.mk3;
import defpackage.mv;
import defpackage.nk3;
import defpackage.o62;
import defpackage.ol3;
import defpackage.p;
import defpackage.pj;
import defpackage.pj0;
import defpackage.pj1;
import defpackage.q52;
import defpackage.r1;
import defpackage.rq0;
import defpackage.s8;
import defpackage.sk3;
import defpackage.tm3;
import defpackage.tn0;
import defpackage.tz0;
import defpackage.vd4;
import defpackage.y44;
import defpackage.ym3;
import defpackage.z20;
import defpackage.zk3;
import defpackage.zm3;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int I0 = ym3.p;
    public static final int[][] J0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public ColorStateList A;
    public boolean A0;
    public int B;
    public final mv B0;
    public tz0 C;
    public boolean C0;
    public tz0 D;
    public boolean D0;
    public ColorStateList E;
    public ValueAnimator E0;
    public ColorStateList F;
    public boolean F0;
    public ColorStateList G;
    public boolean G0;
    public ColorStateList H;
    public boolean H0;
    public boolean I;
    public CharSequence J;
    public boolean K;
    public l62 L;
    public l62 M;
    public StateListDrawable N;
    public boolean O;
    public l62 P;
    public l62 Q;
    public y44 R;
    public boolean S;
    public final int T;
    public int U;
    public int V;
    public int W;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public final Rect e0;
    public final FrameLayout f;
    public final Rect f0;
    public final vd4 g;
    public final RectF g0;
    public final com.google.android.material.textfield.a h;
    public Typeface h0;
    public final int i;
    public Drawable i0;
    public EditText j;
    public int j0;
    public CharSequence k;
    public final LinkedHashSet k0;
    public int l;
    public Drawable l0;
    public int m;
    public int m0;
    public int n;
    public Drawable n0;
    public int o;
    public ColorStateList o0;
    public final pj1 p;
    public ColorStateList p0;
    public boolean q;
    public int q0;
    public int r;
    public int r0;
    public boolean s;
    public int s0;
    public f t;
    public ColorStateList t0;
    public TextView u;
    public int u0;
    public int v;
    public int v0;
    public int w;
    public int w0;
    public CharSequence x;
    public int x0;
    public boolean y;
    public int y0;
    public TextView z;
    public int z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements TextWatcher {
        public int f;
        public final /* synthetic */ EditText g;

        public a(EditText editText) {
            this.g = editText;
            this.f = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.w0(!r0.G0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.q) {
                textInputLayout.l0(editable);
            }
            if (TextInputLayout.this.y) {
                TextInputLayout.this.A0(editable);
            }
            int lineCount = this.g.getLineCount();
            int i = this.f;
            if (lineCount != i) {
                if (lineCount < i) {
                    int minimumHeight = this.g.getMinimumHeight();
                    int i2 = TextInputLayout.this.z0;
                    if (minimumHeight != i2) {
                        this.g.setMinimumHeight(i2);
                    }
                }
                this.f = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends r1 {
        public b() {
        }

        @Override // defpackage.r1
        public void g(View view, g2 g2Var) {
            super.g(view, g2Var);
            g2Var.N0(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.h.j();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.B0.j0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends r1 {
        public final TextInputLayout d;

        public e(TextInputLayout textInputLayout) {
            this.d = textInputLayout;
        }

        @Override // defpackage.r1
        public void g(View view, g2 g2Var) {
            super.g(view, g2Var);
            EditText editText = this.d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.d.getHint();
            CharSequence helperText = this.d.getHelperText();
            CharSequence error = this.d.getError();
            CharSequence placeholderText = this.d.getPlaceholderText();
            int counterMaxLength = this.d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.d.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean zQ = this.d.Q();
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : "";
            if (!TextUtils.isEmpty(helperText) && this.d.p.u()) {
                if (TextUtils.isEmpty(string)) {
                    string = helperText.toString();
                } else {
                    string = string + ", " + ((Object) helperText);
                }
            }
            this.d.g.B(g2Var);
            if (!zIsEmpty) {
                g2Var.L0(text);
            } else if (!TextUtils.isEmpty(string)) {
                g2Var.L0(string);
                if (!zQ && placeholderText != null) {
                    g2Var.L0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                g2Var.L0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    g2Var.x0(string);
                } else {
                    if (!zIsEmpty) {
                        string = ((Object) text) + ", " + string;
                    }
                    g2Var.L0(string);
                }
                g2Var.I0(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            g2Var.z0(counterMaxLength);
            if (z) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                g2Var.s0(error);
            }
            this.d.h.o().o(view, g2Var);
        }

        @Override // defpackage.r1
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            this.d.h.o().p(view, accessibilityEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        int a(Editable editable);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface g {
        void a(TextInputLayout textInputLayout);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = I0;
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = new pj1(this);
        this.t = new f() { // from class: om4
            @Override // com.google.android.material.textfield.TextInputLayout.f
            public final int a(Editable editable) {
                return TextInputLayout.c(editable);
            }
        };
        this.e0 = new Rect();
        this.f0 = new Rect();
        this.g0 = new RectF();
        this.k0 = new LinkedHashSet();
        mv mvVar = new mv(this);
        this.B0 = mvVar;
        this.H0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = k7.a;
        mvVar.o0(timeInterpolator);
        mvVar.l0(timeInterpolator);
        mvVar.X(8388659);
        dp4 dp4VarJ = dn4.j(context2, attributeSet, cn3.X6, i, i2, cn3.u7, cn3.s7, cn3.M7, cn3.R7, cn3.W7);
        vd4 vd4Var = new vd4(this, dp4VarJ);
        this.g = vd4Var;
        this.I = dp4VarJ.a(cn3.U7, true);
        setHint(dp4VarJ.p(cn3.c7));
        this.D0 = dp4VarJ.a(cn3.T7, true);
        this.C0 = dp4VarJ.a(cn3.O7, true);
        if (dp4VarJ.s(cn3.e7)) {
            setMinEms(dp4VarJ.k(cn3.e7, -1));
        } else if (dp4VarJ.s(cn3.b7)) {
            setMinWidth(dp4VarJ.f(cn3.b7, -1));
        }
        if (dp4VarJ.s(cn3.d7)) {
            setMaxEms(dp4VarJ.k(cn3.d7, -1));
        } else if (dp4VarJ.s(cn3.a7)) {
            setMaxWidth(dp4VarJ.f(cn3.a7, -1));
        }
        this.R = y44.i(context2, attributeSet, i, i2).m();
        this.T = context2.getResources().getDimensionPixelOffset(zk3.r0);
        this.V = dp4VarJ.e(cn3.h7, 0);
        this.i = getResources().getDimensionPixelSize(zk3.B);
        this.a0 = dp4VarJ.f(cn3.o7, context2.getResources().getDimensionPixelSize(zk3.s0));
        this.b0 = dp4VarJ.f(cn3.p7, context2.getResources().getDimensionPixelSize(zk3.t0));
        this.W = this.a0;
        float fD = dp4VarJ.d(cn3.l7, -1.0f);
        float fD2 = dp4VarJ.d(cn3.k7, -1.0f);
        float fD3 = dp4VarJ.d(cn3.i7, -1.0f);
        float fD4 = dp4VarJ.d(cn3.j7, -1.0f);
        y44.b bVarC = this.R.C();
        if (fD >= 0.0f) {
            bVarC.C(fD);
        }
        if (fD2 >= 0.0f) {
            bVarC.G(fD2);
        }
        if (fD3 >= 0.0f) {
            bVarC.y(fD3);
        }
        if (fD4 >= 0.0f) {
            bVarC.u(fD4);
        }
        this.R = bVarC.m();
        ColorStateList colorStateListA = k62.a(context2, dp4VarJ, cn3.f7);
        if (colorStateListA != null) {
            int defaultColor = colorStateListA.getDefaultColor();
            this.u0 = defaultColor;
            this.d0 = defaultColor;
            if (colorStateListA.isStateful()) {
                this.v0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.w0 = colorStateListA.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.x0 = colorStateListA.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.w0 = this.u0;
                ColorStateList colorStateListA2 = e9.a(context2, sk3.l);
                this.v0 = colorStateListA2.getColorForState(new int[]{-16842910}, -1);
                this.x0 = colorStateListA2.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.d0 = 0;
            this.u0 = 0;
            this.v0 = 0;
            this.w0 = 0;
            this.x0 = 0;
        }
        if (dp4VarJ.s(cn3.Z6)) {
            ColorStateList colorStateListC = dp4VarJ.c(cn3.Z6);
            this.p0 = colorStateListC;
            this.o0 = colorStateListC;
        }
        ColorStateList colorStateListA3 = k62.a(context2, dp4VarJ, cn3.m7);
        this.s0 = dp4VarJ.b(cn3.m7, 0);
        this.q0 = c30.b(context2, sk3.m);
        this.y0 = c30.b(context2, sk3.n);
        this.r0 = c30.b(context2, sk3.o);
        if (colorStateListA3 != null) {
            setBoxStrokeColorStateList(colorStateListA3);
        }
        if (dp4VarJ.s(cn3.n7)) {
            setBoxStrokeErrorColor(k62.a(context2, dp4VarJ, cn3.n7));
        }
        if (dp4VarJ.n(cn3.W7, -1) != -1) {
            setHintTextAppearance(dp4VarJ.n(cn3.W7, 0));
        }
        this.G = dp4VarJ.c(cn3.w7);
        this.H = dp4VarJ.c(cn3.x7);
        int iN = dp4VarJ.n(cn3.M7, 0);
        CharSequence charSequenceP = dp4VarJ.p(cn3.H7);
        int iK = dp4VarJ.k(cn3.G7, 1);
        boolean zA = dp4VarJ.a(cn3.I7, false);
        int iN2 = dp4VarJ.n(cn3.R7, 0);
        boolean zA2 = dp4VarJ.a(cn3.Q7, false);
        CharSequence charSequenceP2 = dp4VarJ.p(cn3.P7);
        int iN3 = dp4VarJ.n(cn3.e8, 0);
        CharSequence charSequenceP3 = dp4VarJ.p(cn3.d8);
        boolean zA3 = dp4VarJ.a(cn3.q7, false);
        setCounterMaxLength(dp4VarJ.k(cn3.r7, -1));
        this.w = dp4VarJ.n(cn3.u7, 0);
        this.v = dp4VarJ.n(cn3.s7, 0);
        setBoxBackgroundMode(dp4VarJ.k(cn3.g7, 0));
        setErrorContentDescription(charSequenceP);
        setErrorAccessibilityLiveRegion(iK);
        setCounterOverflowTextAppearance(this.v);
        setHelperTextTextAppearance(iN2);
        setErrorTextAppearance(iN);
        setCounterTextAppearance(this.w);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        if (dp4VarJ.s(cn3.N7)) {
            setErrorTextColor(dp4VarJ.c(cn3.N7));
        }
        if (dp4VarJ.s(cn3.S7)) {
            setHelperTextColor(dp4VarJ.c(cn3.S7));
        }
        if (dp4VarJ.s(cn3.X7)) {
            setHintTextColor(dp4VarJ.c(cn3.X7));
        }
        if (dp4VarJ.s(cn3.v7)) {
            setCounterTextColor(dp4VarJ.c(cn3.v7));
        }
        if (dp4VarJ.s(cn3.t7)) {
            setCounterOverflowTextColor(dp4VarJ.c(cn3.t7));
        }
        if (dp4VarJ.s(cn3.f8)) {
            setPlaceholderTextColor(dp4VarJ.c(cn3.f8));
        }
        com.google.android.material.textfield.a aVar = new com.google.android.material.textfield.a(this, dp4VarJ);
        this.h = aVar;
        boolean zA4 = dp4VarJ.a(cn3.Y6, true);
        setHintMaxLines(dp4VarJ.k(cn3.V7, 1));
        dp4VarJ.x();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(vd4Var);
        frameLayout.addView(aVar);
        addView(frameLayout);
        setEnabled(zA4);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceP2);
    }

    public static Drawable I(l62 l62Var, int i, int i2, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{h62.j(i2, i, 0.1f), i}), l62Var, l62Var);
    }

    public static Drawable L(Context context, l62 l62Var, int i, int[][] iArr) {
        int iC = h62.c(context, mk3.l, "TextInputLayout");
        l62 l62Var2 = new l62(l62Var.J());
        int iJ = h62.j(i, iC, 0.1f);
        l62Var2.e0(new ColorStateList(iArr, new int[]{iJ, 0}));
        l62Var2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iJ, iC});
        l62 l62Var3 = new l62(l62Var.J());
        l62Var3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, l62Var2, l62Var3), l62Var});
    }

    public static void Y(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                Y((ViewGroup) childAt, z);
            }
        }
    }

    public static /* synthetic */ int c(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.j;
        if (!(editText instanceof AutoCompleteTextView) || rq0.a(editText)) {
            return this.L;
        }
        int iD = h62.d(this.j, nk3.t);
        int i = this.U;
        if (i == 2) {
            return L(getContext(), this.L, iD, J0);
        }
        if (i == 1) {
            return I(this.L, this.d0, iD, J0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.N == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.N = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.N.addState(new int[0], H(false));
        }
        return this.N;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.M == null) {
            this.M = H(true);
        }
        return this.M;
    }

    public static void m0(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? tm3.e : tm3.d, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private void setEditText(EditText editText) {
        if (this.j != null) {
            jl.a("We already have an EditText, can only have one");
            return;
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.j = editText;
        int i = this.l;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.n);
        }
        int i2 = this.m;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.o);
        }
        this.O = false;
        V();
        setTextInputAccessibilityDelegate(new e(this));
        this.B0.p0(this.j.getTypeface());
        this.B0.h0(this.j.getTextSize());
        this.B0.d0(this.j.getLetterSpacing());
        int gravity = this.j.getGravity();
        this.B0.X((gravity & (-113)) | 48);
        this.B0.g0(gravity);
        this.z0 = editText.getMinimumHeight();
        this.j.addTextChangedListener(new a(editText));
        if (this.o0 == null) {
            this.o0 = this.j.getHintTextColors();
        }
        if (this.I) {
            if (TextUtils.isEmpty(this.J)) {
                CharSequence hint = this.j.getHint();
                this.k = hint;
                setHint(hint);
                this.j.setHint((CharSequence) null);
            }
            this.K = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            o0();
        }
        if (this.u != null) {
            l0(this.j.getText());
        }
        q0();
        this.p.e();
        this.g.bringToFront();
        this.h.bringToFront();
        D();
        this.h.z0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        x0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.J)) {
            return;
        }
        this.J = charSequence;
        this.B0.n0(charSequence);
        if (this.A0) {
            return;
        }
        W();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.y == z) {
            return;
        }
        if (z) {
            k();
        } else {
            a0();
            this.z = null;
        }
        this.y = z;
    }

    public final void A(boolean z) {
        ValueAnimator valueAnimator = this.E0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.E0.cancel();
        }
        if (z && this.D0) {
            m(1.0f);
        } else {
            this.B0.j0(1.0f);
        }
        this.A0 = false;
        if (C()) {
            W();
        }
        z0();
        this.g.m(false);
        this.h.J(false);
    }

    public final void A0(Editable editable) {
        if (this.t.a(editable) != 0 || this.A0) {
            M();
        } else {
            g0();
        }
    }

    public final tz0 B() {
        tz0 tz0Var = new tz0();
        tz0Var.Y(lu2.f(getContext(), mk3.G, 87));
        tz0Var.a0(lu2.g(getContext(), mk3.M, k7.a));
        return tz0Var;
    }

    public final void B0(boolean z, boolean z2) {
        int defaultColor = this.t0.getDefaultColor();
        int colorForState = this.t0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.t0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.c0 = colorForState2;
        } else if (z2) {
            this.c0 = colorForState;
        } else {
            this.c0 = defaultColor;
        }
    }

    public final boolean C() {
        return this.I && !TextUtils.isEmpty(this.J) && (this.L instanceof i70);
    }

    public void C0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.L == null || this.U == 0) {
            return;
        }
        boolean z = isFocused() || ((editText2 = this.j) != null && editText2.hasFocus());
        boolean z2 = isHovered() || ((editText = this.j) != null && editText.isHovered());
        if (!isEnabled()) {
            this.c0 = this.y0;
        } else if (d0()) {
            if (this.t0 != null) {
                B0(z, z2);
            } else {
                this.c0 = getErrorCurrentTextColors();
            }
        } else if (!this.s || (textView = this.u) == null) {
            if (z) {
                this.c0 = this.s0;
            } else if (z2) {
                this.c0 = this.r0;
            } else {
                this.c0 = this.q0;
            }
        } else if (this.t0 != null) {
            B0(z, z2);
        } else {
            this.c0 = textView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            o0();
        }
        this.h.K();
        Z();
        if (this.U == 2) {
            int i = this.W;
            if (z && isEnabled()) {
                this.W = this.b0;
            } else {
                this.W = this.a0;
            }
            if (this.W != i) {
                X();
            }
        }
        if (this.U == 1) {
            if (!isEnabled()) {
                this.d0 = this.v0;
            } else if (z2 && !z) {
                this.d0 = this.x0;
            } else if (z) {
                this.d0 = this.w0;
            } else {
                this.d0 = this.u0;
            }
        }
        n();
        if (getEndIconMode() == 3) {
            EditText editText3 = this.j;
            if (!(editText3 instanceof AutoCompleteTextView) || rq0.a(editText3)) {
                getEndIconView().setFocusable(true);
                getEndIconView().setClickable(true);
            } else {
                getEndIconView().setFocusable(false);
                getEndIconView().setClickable(false);
            }
        }
    }

    public final void D() {
        Iterator it = this.k0.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(this);
        }
    }

    public final void E(Canvas canvas) {
        l62 l62Var;
        if (this.Q == null || (l62Var = this.P) == null) {
            return;
        }
        l62Var.draw(canvas);
        if (this.j.isFocused()) {
            Rect bounds = this.Q.getBounds();
            Rect bounds2 = this.P.getBounds();
            float fB = this.B0.B();
            int iCenterX = bounds2.centerX();
            bounds.left = k7.c(iCenterX, bounds2.left, fB);
            bounds.right = k7.c(iCenterX, bounds2.right, fB);
            this.Q.draw(canvas);
        }
    }

    public final void F(Canvas canvas) {
        if (this.I) {
            this.B0.k(canvas);
        }
    }

    public final void G(boolean z) {
        ValueAnimator valueAnimator = this.E0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.E0.cancel();
        }
        if (z && this.D0) {
            m(0.0f);
        } else {
            this.B0.j0(0.0f);
        }
        if (C() && ((i70) this.L).B0()) {
            z();
        }
        this.A0 = true;
        M();
        this.g.m(true);
        this.h.J(true);
    }

    public final l62 H(boolean z) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(zk3.j0);
        float f2 = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.j;
        float popupElevation = editText instanceof q52 ? ((q52) editText).getPopupElevation() : getResources().getDimensionPixelOffset(zk3.A);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(zk3.a0);
        y44 y44VarM = y44.e().C(f2).G(f2).u(dimensionPixelOffset).y(dimensionPixelOffset).m();
        EditText editText2 = this.j;
        l62 l62VarS = l62.s(getContext(), popupElevation, editText2 instanceof q52 ? ((q52) editText2).getDropDownBackgroundTintList() : null);
        l62VarS.setShapeAppearanceModel(y44VarM);
        l62VarS.h0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return l62VarS;
    }

    public final int J(int i, boolean z) {
        return i + ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.j.getCompoundPaddingLeft() : this.h.A() : this.g.d());
    }

    public final int K(int i, boolean z) {
        return i - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.j.getCompoundPaddingRight() : this.g.d() : this.h.A());
    }

    public final void M() {
        TextView textView = this.z;
        if (textView == null || !this.y) {
            return;
        }
        textView.setText((CharSequence) null);
        bt4.a(this.f, this.D);
        this.z.setVisibility(4);
    }

    public boolean N() {
        return this.h.H();
    }

    public boolean O() {
        return this.p.A();
    }

    public boolean P() {
        return this.p.B();
    }

    public final boolean Q() {
        return this.A0;
    }

    public final boolean R() {
        return getHintMaxLines() == 1;
    }

    public final boolean S() {
        if (d0()) {
            return true;
        }
        return this.u != null && this.s;
    }

    public boolean T() {
        return this.K;
    }

    public final boolean U() {
        return this.U == 1 && this.j.getMinLines() <= 1;
    }

    public final void V() {
        q();
        s0();
        C0();
        h0();
        l();
        if (this.U != 0) {
            v0();
        }
        b0();
    }

    public final void W() {
        if (C()) {
            RectF rectF = this.g0;
            this.B0.o(rectF, this.j.getWidth(), this.j.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            p(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.W);
            rectF.top = 0.0f;
            ((i70) this.L).E0(rectF);
        }
    }

    public final void X() {
        if (!C() || this.A0) {
            return;
        }
        z();
        W();
    }

    public void Z() {
        this.g.n();
    }

    public final void a0() {
        TextView textView = this.z;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f.addView(view, layoutParams2);
        this.f.setLayoutParams(layoutParams);
        v0();
        setEditText((EditText) view);
    }

    public final void b0() {
        EditText editText = this.j;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i = this.U;
                if (i == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    public void c0(TextView textView, int i) {
        try {
            an4.m(textView, i);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        an4.m(textView, zm3.b);
        textView.setTextColor(c30.b(getContext(), sk3.a));
    }

    public boolean d0() {
        return this.p.k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.j;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.k != null) {
            boolean z = this.K;
            this.K = false;
            CharSequence hint = editText.getHint();
            this.j.setHint(this.k);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.j.setHint(hint);
                this.K = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.f.getChildCount());
        for (int i2 = 0; i2 < this.f.getChildCount(); i2++) {
            View childAt = this.f.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.j) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.G0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.G0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        F(canvas);
        E(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.F0) {
            return;
        }
        this.F0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        mv mvVar = this.B0;
        boolean zM0 = mvVar != null ? mvVar.m0(drawableState) : false;
        if (this.j != null) {
            w0(isLaidOut() && isEnabled());
        }
        q0();
        C0();
        if (zM0) {
            invalidate();
        }
        this.F0 = false;
    }

    public final boolean e0() {
        return (this.h.I() || ((this.h.C() && N()) || this.h.y() != null)) && this.h.getMeasuredWidth() > 0;
    }

    public final boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.g.getMeasuredWidth() > 0;
    }

    public final void g0() {
        if (this.z == null || !this.y || TextUtils.isEmpty(this.x)) {
            return;
        }
        this.z.setText(this.x);
        bt4.a(this.f, this.C);
        this.z.setVisibility(0);
        this.z.bringToFront();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.j;
        return editText != null ? editText.getBaseline() + getPaddingTop() + w() : super.getBaseline();
    }

    public l62 getBoxBackground() {
        int i = this.U;
        if (i == 1 || i == 2) {
            return this.L;
        }
        z20.a();
        return null;
    }

    public int getBoxBackgroundColor() {
        return this.d0;
    }

    public int getBoxBackgroundMode() {
        return this.U;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.V;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zF = e55.f(this);
        y44 y44Var = this.R;
        return zF ? y44Var.p().a(this.g0) : y44Var.r().a(this.g0);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zF = e55.f(this);
        y44 y44Var = this.R;
        return zF ? y44Var.r().a(this.g0) : y44Var.p().a(this.g0);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zF = e55.f(this);
        y44 y44Var = this.R;
        return zF ? y44Var.x().a(this.g0) : y44Var.z().a(this.g0);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zF = e55.f(this);
        y44 y44Var = this.R;
        return zF ? y44Var.z().a(this.g0) : y44Var.x().a(this.g0);
    }

    public int getBoxStrokeColor() {
        return this.s0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.t0;
    }

    public int getBoxStrokeWidth() {
        return this.a0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.b0;
    }

    public int getCounterMaxLength() {
        return this.r;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.q && this.s && (textView = this.u) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.F;
    }

    public ColorStateList getCounterTextColor() {
        return this.E;
    }

    public ColorStateList getCursorColor() {
        return this.G;
    }

    public ColorStateList getCursorErrorColor() {
        return this.H;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.o0;
    }

    public EditText getEditText() {
        return this.j;
    }

    public CharSequence getEndIconContentDescription() {
        return this.h.n();
    }

    public Drawable getEndIconDrawable() {
        return this.h.p();
    }

    public int getEndIconMinSize() {
        return this.h.q();
    }

    public int getEndIconMode() {
        return this.h.r();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.h.s();
    }

    public CheckableImageButton getEndIconView() {
        return this.h.t();
    }

    public CharSequence getError() {
        if (this.p.A()) {
            return this.p.o();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.p.m();
    }

    public CharSequence getErrorContentDescription() {
        return this.p.n();
    }

    public int getErrorCurrentTextColors() {
        return this.p.p();
    }

    public Drawable getErrorIconDrawable() {
        return this.h.u();
    }

    public CharSequence getHelperText() {
        if (this.p.B()) {
            return this.p.r();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.p.s();
    }

    public CharSequence getHint() {
        if (this.I) {
            return this.J;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.B0.q();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.B0.t();
    }

    public int getHintMaxLines() {
        return this.B0.x();
    }

    public ColorStateList getHintTextColor() {
        return this.p0;
    }

    public f getLengthCounter() {
        return this.t;
    }

    public int getMaxEms() {
        return this.m;
    }

    public int getMaxWidth() {
        return this.o;
    }

    public int getMinEms() {
        return this.l;
    }

    public int getMinWidth() {
        return this.n;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.h.w();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.h.x();
    }

    public CharSequence getPlaceholderText() {
        if (this.y) {
            return this.x;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.B;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.A;
    }

    public CharSequence getPrefixText() {
        return this.g.b();
    }

    public ColorStateList getPrefixTextColor() {
        return this.g.c();
    }

    public TextView getPrefixTextView() {
        return this.g.e();
    }

    public y44 getShapeAppearanceModel() {
        return this.R;
    }

    public CharSequence getStartIconContentDescription() {
        return this.g.f();
    }

    public Drawable getStartIconDrawable() {
        return this.g.g();
    }

    public int getStartIconMinSize() {
        return this.g.h();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.g.i();
    }

    public CharSequence getSuffixText() {
        return this.h.y();
    }

    public ColorStateList getSuffixTextColor() {
        return this.h.z();
    }

    public TextView getSuffixTextView() {
        return this.h.B();
    }

    public Typeface getTypeface() {
        return this.h0;
    }

    public final void h0() {
        if (this.U == 1) {
            if (k62.l(getContext())) {
                this.V = getResources().getDimensionPixelSize(zk3.N);
            } else if (k62.k(getContext())) {
                this.V = getResources().getDimensionPixelSize(zk3.M);
            }
        }
    }

    public final void i0(Rect rect) {
        l62 l62Var = this.P;
        if (l62Var != null) {
            int i = rect.bottom;
            l62Var.setBounds(rect.left, i - this.a0, rect.right, i);
        }
        l62 l62Var2 = this.Q;
        if (l62Var2 != null) {
            int i2 = rect.bottom;
            l62Var2.setBounds(rect.left, i2 - this.b0, rect.right, i2);
        }
    }

    public void j(g gVar) {
        this.k0.add(gVar);
        if (this.j != null) {
            gVar.a(this);
        }
    }

    public final void j0(int i) {
        this.B0.s0(i);
        Rect rect = this.e0;
        pj0.a(this, this.j, rect);
        this.B0.S(s(rect));
        v0();
        l();
        t0(i);
    }

    public final void k() {
        TextView textView = this.z;
        if (textView != null) {
            this.f.addView(textView);
            this.z.setVisibility(0);
        }
    }

    public final void k0() {
        if (this.u != null) {
            EditText editText = this.j;
            l0(editText == null ? null : editText.getText());
        }
    }

    public final void l() {
        if (this.j == null || this.U != 1) {
            return;
        }
        if (!R()) {
            EditText editText = this.j;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.B0.q() + this.i), this.j.getPaddingEnd(), getResources().getDimensionPixelSize(zk3.I));
        } else if (k62.l(getContext())) {
            EditText editText2 = this.j;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(zk3.L), this.j.getPaddingEnd(), getResources().getDimensionPixelSize(zk3.K));
        } else if (k62.k(getContext())) {
            EditText editText3 = this.j;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(zk3.J), this.j.getPaddingEnd(), getResources().getDimensionPixelSize(zk3.I));
        }
    }

    public void l0(Editable editable) {
        int iA = this.t.a(editable);
        boolean z = this.s;
        int i = this.r;
        if (i == -1) {
            this.u.setText(String.valueOf(iA));
            this.u.setContentDescription(null);
            this.s = false;
        } else {
            this.s = iA > i;
            m0(getContext(), this.u, iA, this.r, this.s);
            if (z != this.s) {
                n0();
            }
            this.u.setText(pj.c().j(getContext().getString(tm3.f, Integer.valueOf(iA), Integer.valueOf(this.r))));
        }
        if (this.j == null || z == this.s) {
            return;
        }
        w0(false);
        C0();
        q0();
    }

    public void m(float f2) {
        if (this.B0.B() == f2) {
            return;
        }
        if (this.E0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.E0 = valueAnimator;
            valueAnimator.setInterpolator(lu2.g(getContext(), mk3.L, k7.b));
            this.E0.setDuration(lu2.f(getContext(), mk3.F, Token.LET));
            this.E0.addUpdateListener(new d());
        }
        this.E0.setFloatValues(this.B0.B(), f2);
        this.E0.start();
    }

    public final void n() {
        l62 l62Var = this.L;
        if (l62Var == null) {
            return;
        }
        y44 y44VarJ = l62Var.J();
        y44 y44Var = this.R;
        if (y44VarJ != y44Var) {
            this.L.setShapeAppearanceModel(y44Var);
        }
        if (x()) {
            this.L.m0(this.W, this.c0);
        }
        int iR = r();
        this.d0 = iR;
        this.L.e0(ColorStateList.valueOf(iR));
        o();
        s0();
    }

    public final void n0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.u;
        if (textView != null) {
            c0(textView, this.s ? this.v : this.w);
            if (!this.s && (colorStateList2 = this.E) != null) {
                this.u.setTextColor(colorStateList2);
            }
            if (!this.s || (colorStateList = this.F) == null) {
                return;
            }
            this.u.setTextColor(colorStateList);
        }
    }

    public final void o() {
        if (this.P == null || this.Q == null) {
            return;
        }
        if (y()) {
            this.P.e0(this.j.isFocused() ? ColorStateList.valueOf(this.q0) : ColorStateList.valueOf(this.c0));
            this.Q.e0(ColorStateList.valueOf(this.c0));
        }
        invalidate();
    }

    public final void o0() {
        ColorStateList colorStateList;
        ColorStateList colorStateListG = this.G;
        if (colorStateListG == null) {
            colorStateListG = h62.g(getContext(), nk3.s);
        }
        EditText editText = this.j;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = tn0.r(this.j.getTextCursorDrawable()).mutate();
        if (S() && (colorStateList = this.H) != null) {
            colorStateListG = colorStateList;
        }
        drawableMutate.setTintList(colorStateListG);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.B0.L(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.H0 = false;
        boolean zU0 = u0();
        boolean zP0 = p0();
        if (zU0 || zP0) {
            this.j.post(new Runnable() { // from class: nm4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.j.requestLayout();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.j;
        if (editText != null) {
            Rect rect = this.e0;
            pj0.a(this, editText, rect);
            i0(rect);
            if (this.I) {
                this.B0.h0(this.j.getTextSize());
                int gravity = this.j.getGravity();
                this.B0.X((gravity & (-113)) | 48);
                this.B0.g0(gravity);
                this.B0.S(s(rect));
                this.B0.c0(v(rect));
                this.B0.N();
                if (!C() || this.A0) {
                    return;
                }
                W();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.H0) {
            this.h.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.H0 = true;
        }
        y0();
        this.h.z0();
        if (R()) {
            return;
        }
        j0((this.j.getMeasuredWidth() - this.j.getCompoundPaddingLeft()) - this.j.getCompoundPaddingRight());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.c());
        setError(hVar.h);
        if (hVar.i) {
            post(new c());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 1;
        if (z != this.S) {
            float fA = this.R.x().a(this.g0);
            float fA2 = this.R.z().a(this.g0);
            y44 y44VarM = y44.e().B(this.R.y()).F(this.R.w()).t(this.R.q()).x(this.R.o()).C(fA2).G(fA).u(this.R.r().a(this.g0)).y(this.R.p().a(this.g0)).m();
            this.S = z;
            setShapeAppearanceModel(y44VarM);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (d0()) {
            hVar.h = getError();
        }
        hVar.i = this.h.G();
        return hVar;
    }

    public final void p(RectF rectF) {
        float f2 = rectF.left;
        int i = this.T;
        rectF.left = f2 - i;
        rectF.right += i;
    }

    public boolean p0() {
        boolean z;
        if (this.j == null) {
            return false;
        }
        boolean z2 = true;
        if (f0()) {
            int iMax = Math.max(0, this.g.getMeasuredWidth() - this.j.getPaddingLeft());
            if (this.i0 == null || this.j0 != iMax) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.i0 = colorDrawable;
                this.j0 = iMax;
                colorDrawable.setBounds(0, 0, iMax, 1);
            }
            Drawable[] compoundDrawablesRelative = this.j.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.i0;
            if (drawable != drawable2) {
                this.j.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.i0 != null) {
                Drawable[] compoundDrawablesRelative2 = this.j.getCompoundDrawablesRelative();
                this.j.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.i0 = null;
                z = true;
            }
            z = false;
        }
        if (e0()) {
            int measuredWidth = this.h.B().getMeasuredWidth() - this.j.getPaddingRight();
            CheckableImageButton checkableImageButtonM = this.h.m();
            if (checkableImageButtonM != null) {
                measuredWidth = measuredWidth + checkableImageButtonM.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) checkableImageButtonM.getLayoutParams()).getMarginStart();
            }
            int iMax2 = Math.max(0, measuredWidth);
            Drawable[] compoundDrawablesRelative3 = this.j.getCompoundDrawablesRelative();
            Drawable drawable3 = this.l0;
            if (drawable3 != null && this.m0 != iMax2) {
                this.m0 = iMax2;
                drawable3.setBounds(0, 0, iMax2, 1);
                this.j.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.l0, compoundDrawablesRelative3[3]);
                return true;
            }
            if (drawable3 == null) {
                ColorDrawable colorDrawable2 = new ColorDrawable();
                this.l0 = colorDrawable2;
                this.m0 = iMax2;
                colorDrawable2.setBounds(0, 0, iMax2, 1);
            }
            Drawable drawable4 = compoundDrawablesRelative3[2];
            Drawable drawable5 = this.l0;
            if (drawable4 != drawable5) {
                this.n0 = drawable4;
                this.j.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                return true;
            }
        } else if (this.l0 != null) {
            Drawable[] compoundDrawablesRelative4 = this.j.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative4[2] == this.l0) {
                this.j.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.n0, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.l0 = null;
            return z2;
        }
        return z;
    }

    public final void q() {
        int i = this.U;
        if (i == 0) {
            this.L = null;
            this.P = null;
            this.Q = null;
            return;
        }
        if (i == 1) {
            this.L = new l62(this.R);
            this.P = new l62();
            this.Q = new l62();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.U + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.I || (this.L instanceof i70)) {
                this.L = new l62(this.R);
            } else {
                this.L = i70.A0(this.R);
            }
            this.P = null;
            this.Q = null;
        }
    }

    public void q0() {
        Drawable background;
        TextView textView;
        EditText editText = this.j;
        if (editText == null || this.U != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (fo0.a(background)) {
            background = background.mutate();
        }
        if (d0()) {
            background.setColorFilter(s8.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.s && (textView = this.u) != null) {
            background.setColorFilter(s8.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            tn0.c(background);
            this.j.refreshDrawableState();
        }
    }

    public final int r() {
        return this.U == 1 ? h62.i(h62.e(this, mk3.l, 0), this.d0) : this.d0;
    }

    public final void r0() {
        this.j.setBackground(getEditTextBoxBackground());
    }

    public final Rect s(Rect rect) {
        if (this.j == null) {
            z20.a();
            return null;
        }
        Rect rect2 = this.f0;
        boolean zF = e55.f(this);
        rect2.bottom = rect.bottom;
        int i = this.U;
        if (i == 1) {
            rect2.left = J(rect.left, zF);
            rect2.top = rect.top + this.V;
            rect2.right = K(rect.right, zF);
            return rect2;
        }
        int i2 = rect.left;
        if (i != 2) {
            rect2.left = J(i2, zF);
            rect2.top = getPaddingTop();
            rect2.right = K(rect.right, zF);
            return rect2;
        }
        rect2.left = i2 + this.j.getPaddingLeft();
        rect2.top = rect.top - w();
        rect2.right = rect.right - this.j.getPaddingRight();
        return rect2;
    }

    public void s0() {
        EditText editText = this.j;
        if (editText == null || this.L == null) {
            return;
        }
        if ((this.O || editText.getBackground() == null) && this.U != 0) {
            r0();
            this.O = true;
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.d0 != i) {
            this.d0 = i;
            this.u0 = i;
            this.w0 = i;
            this.x0 = i;
            n();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(c30.b(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.u0 = defaultColor;
        this.d0 = defaultColor;
        this.v0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.w0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.x0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        n();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.U) {
            return;
        }
        this.U = i;
        if (this.j != null) {
            V();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.V = i;
    }

    public void setBoxCornerFamily(int i) {
        this.R = this.R.C().A(i, this.R.x()).E(i, this.R.z()).s(i, this.R.p()).w(i, this.R.r()).m();
        n();
    }

    public void setBoxStrokeColor(int i) {
        if (this.s0 != i) {
            this.s0 = i;
            C0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.q0 = colorStateList.getDefaultColor();
            this.y0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.r0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.s0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.s0 != colorStateList.getDefaultColor()) {
            this.s0 = colorStateList.getDefaultColor();
        }
        C0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.t0 != colorStateList) {
            this.t0 = colorStateList;
            C0();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.a0 = i;
        C0();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.b0 = i;
        C0();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.q != z) {
            if (z) {
                k9 k9Var = new k9(getContext());
                this.u = k9Var;
                k9Var.setId(ol3.u);
                Typeface typeface = this.h0;
                if (typeface != null) {
                    this.u.setTypeface(typeface);
                }
                this.u.setMaxLines(1);
                this.p.d(this.u, 2);
                ((ViewGroup.MarginLayoutParams) this.u.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(zk3.u0));
                n0();
                k0();
            } else {
                this.p.C(this.u, 2);
                this.u = null;
            }
            this.q = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.r != i) {
            if (i > 0) {
                this.r = i;
            } else {
                this.r = -1;
            }
            if (this.q) {
                k0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.v != i) {
            this.v = i;
            n0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            n0();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.w != i) {
            this.w = i;
            n0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            n0();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            o0();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (S()) {
                o0();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.o0 = colorStateList;
        this.p0 = colorStateList;
        if (this.j != null) {
            w0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Y(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.h.P(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.h.Q(z);
    }

    public void setEndIconContentDescription(int i) {
        this.h.R(i);
    }

    public void setEndIconDrawable(int i) {
        this.h.T(i);
    }

    public void setEndIconMinSize(int i) {
        this.h.V(i);
    }

    public void setEndIconMode(int i) {
        this.h.W(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.h.X(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.h.Y(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.h.Z(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.h.a0(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.h.b0(mode);
    }

    public void setEndIconVisible(boolean z) {
        this.h.c0(z);
    }

    public void setError(CharSequence charSequence) {
        if (!this.p.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        pj1 pj1Var = this.p;
        if (zIsEmpty) {
            pj1Var.v();
        } else {
            pj1Var.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        this.p.E(i);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.p.F(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.p.G(z);
    }

    public void setErrorIconDrawable(int i) {
        this.h.d0(i);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.h.f0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.h.g0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.h.h0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.h.i0(mode);
    }

    public void setErrorTextAppearance(int i) {
        this.p.H(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.p.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.C0 != z) {
            this.C0 = z;
            w0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (P()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!P()) {
                setHelperTextEnabled(true);
            }
            this.p.R(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.p.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.p.K(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.p.J(i);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setHintAnimationEnabled(boolean z) {
        this.D0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.I) {
            this.I = z;
            if (z) {
                CharSequence hint = this.j.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.J)) {
                        setHint(hint);
                    }
                    this.j.setHint((CharSequence) null);
                }
                this.K = true;
            } else {
                this.K = false;
                if (!TextUtils.isEmpty(this.J) && TextUtils.isEmpty(this.j.getHint())) {
                    this.j.setHint(this.J);
                }
                setHintInternal(null);
            }
            if (this.j != null) {
                v0();
            }
        }
    }

    public void setHintMaxLines(int i) {
        this.B0.T(i);
        this.B0.e0(i);
        requestLayout();
    }

    public void setHintTextAppearance(int i) {
        this.B0.U(i);
        this.p0 = this.B0.p();
        if (this.j != null) {
            w0(false);
            v0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.p0 != colorStateList) {
            if (this.o0 == null) {
                this.B0.W(colorStateList);
            }
            this.p0 = colorStateList;
            if (this.j != null) {
                w0(false);
            }
        }
    }

    public void setLengthCounter(f fVar) {
        this.t = fVar;
    }

    public void setMaxEms(int i) {
        this.m = i;
        EditText editText = this.j;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.o = i;
        EditText editText = this.j;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.l = i;
        EditText editText = this.j;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.n = i;
        EditText editText = this.j;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        this.h.k0(i);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        this.h.m0(i);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        this.h.o0(z);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.h.p0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.h.q0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.z == null) {
            k9 k9Var = new k9(getContext());
            this.z = k9Var;
            k9Var.setId(ol3.x);
            this.z.setImportantForAccessibility(1);
            this.z.setAccessibilityLiveRegion(1);
            tz0 tz0VarB = B();
            this.C = tz0VarB;
            tz0VarB.d0(67L);
            this.D = B();
            setPlaceholderTextAppearance(this.B);
            setPlaceholderTextColor(this.A);
            l35.g0(this.z, new b());
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.y) {
                setPlaceholderTextEnabled(true);
            }
            this.x = charSequence;
        }
        z0();
    }

    public void setPlaceholderTextAppearance(int i) {
        this.B = i;
        TextView textView = this.z;
        if (textView != null) {
            an4.m(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            TextView textView = this.z;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.g.o(charSequence);
    }

    public void setPrefixTextAppearance(int i) {
        this.g.p(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.g.q(colorStateList);
    }

    public void setShapeAppearanceModel(y44 y44Var) {
        l62 l62Var = this.L;
        if (l62Var == null || l62Var.J() == y44Var) {
            return;
        }
        this.R = y44Var;
        n();
    }

    public void setStartIconCheckable(boolean z) {
        this.g.r(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? e9.b(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        this.g.u(i);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.g.v(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.g.w(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.g.x(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.g.y(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.g.z(mode);
    }

    public void setStartIconVisible(boolean z) {
        this.g.A(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.h.r0(charSequence);
    }

    public void setSuffixTextAppearance(int i) {
        this.h.s0(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.h.t0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.j;
        if (editText != null) {
            l35.g0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.h0) {
            this.h0 = typeface;
            this.B0.p0(typeface);
            this.p.N(typeface);
            TextView textView = this.u;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public final int t(Rect rect, Rect rect2, float f2) {
        return U() ? (int) (rect2.top + f2) : rect.bottom - this.j.getCompoundPaddingBottom();
    }

    public final void t0(int i) {
        if (this.j == null) {
            return;
        }
        float fZ = this.B0.z();
        if (this.x != null) {
            TextPaint textPaint = new TextPaint(Token.DEFAULT);
            textPaint.set(this.z.getPaint());
            textPaint.setTextSize(this.z.getTextSize());
            textPaint.setTypeface(this.z.getTypeface());
            textPaint.setLetterSpacing(this.z.getLetterSpacing());
            fQ = (this.U == 1 ? this.i + this.B0.q() + this.V : 0.0f) + le4.b(this.x, textPaint, i).g(getLayoutDirection() == 1).f(true).h(this.z.getLineSpacingExtra(), this.z.getLineSpacingMultiplier()).j(new me4() { // from class: pm4
                @Override // defpackage.me4
                public final void a(StaticLayout.Builder builder) {
                    builder.setBreakStrategy(this.a.z.getBreakStrategy());
                }
            }).a().getHeight();
        }
        float fMax = Math.max(fZ, fQ);
        if (this.j.getMeasuredHeight() < fMax) {
            this.j.setMinimumHeight(Math.round(fMax));
        }
    }

    public final int u(Rect rect, float f2) {
        if (U()) {
            return (int) (rect.centerY() - (f2 / 2.0f));
        }
        return (rect.top + this.j.getCompoundPaddingTop()) - ((this.U != 0 || R()) ? 0 : (int) (this.B0.A() / 2.0f));
    }

    public final boolean u0() {
        int iMax;
        if (this.j == null || this.j.getMeasuredHeight() >= (iMax = Math.max(this.h.getMeasuredHeight(), this.g.getMeasuredHeight()))) {
            return false;
        }
        this.j.setMinimumHeight(iMax);
        return true;
    }

    public final Rect v(Rect rect) {
        if (this.j == null) {
            z20.a();
            return null;
        }
        Rect rect2 = this.f0;
        boolean zR = R();
        mv mvVar = this.B0;
        float fA = zR ? mvVar.A() : mvVar.y() * this.B0.w();
        rect2.left = rect.left + this.j.getCompoundPaddingLeft();
        rect2.top = u(rect, fA);
        rect2.right = rect.right - this.j.getCompoundPaddingRight();
        rect2.bottom = t(rect, rect2, fA);
        return rect2;
    }

    public final void v0() {
        if (this.U != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int iW = w();
            if (iW != layoutParams.topMargin) {
                layoutParams.topMargin = iW;
                this.f.requestLayout();
            }
        }
    }

    public final int w() {
        if (!this.I) {
            return 0;
        }
        int i = this.U;
        if (i == 0) {
            return (int) this.B0.q();
        }
        if (i != 2) {
            return 0;
        }
        boolean zR = R();
        mv mvVar = this.B0;
        return zR ? (int) (mvVar.q() / 2.0f) : Math.max(0, (int) (mvVar.q() - (this.B0.n() / 2.0f)));
    }

    public void w0(boolean z) {
        x0(z, false);
    }

    public final boolean x() {
        return this.U == 2 && y();
    }

    public final void x0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.j;
        boolean z3 = false;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.j;
        if (editText2 != null && editText2.hasFocus()) {
            z3 = true;
        }
        ColorStateList colorStateList2 = this.o0;
        if (colorStateList2 != null) {
            this.B0.Q(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.o0;
            int colorForState = this.y0;
            if (colorStateList3 != null) {
                colorForState = colorStateList3.getColorForState(new int[]{-16842910}, colorForState);
            }
            this.B0.Q(ColorStateList.valueOf(colorForState));
        } else if (d0()) {
            this.B0.Q(this.p.q());
        } else if (this.s && (textView = this.u) != null) {
            this.B0.Q(textView.getTextColors());
        } else if (z3 && (colorStateList = this.p0) != null) {
            this.B0.W(colorStateList);
        }
        if (z4 || !this.C0 || (isEnabled() && z3)) {
            if (z2 || this.A0) {
                A(z);
                return;
            }
            return;
        }
        if (z2 || !this.A0) {
            G(z);
        }
    }

    public final boolean y() {
        return this.W > -1 && this.c0 != 0;
    }

    public final void y0() {
        EditText editText;
        if (this.z == null || (editText = this.j) == null) {
            return;
        }
        this.z.setGravity(editText.getGravity());
        this.z.setPadding(this.j.getCompoundPaddingLeft(), this.j.getCompoundPaddingTop(), this.j.getCompoundPaddingRight(), this.j.getCompoundPaddingBottom());
    }

    public final void z() {
        if (C()) {
            ((i70) this.L).C0();
        }
    }

    public final void z0() {
        EditText editText = this.j;
        A0(editText == null ? null : editText.getText());
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.h.S(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.h.U(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.h.e0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.h.l0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.h.n0(drawable);
    }

    public void setHint(CharSequence charSequence) {
        if (this.I) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.g.s(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.g.t(drawable);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h extends p {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public CharSequence h;
        public boolean i;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i) {
                return new h[i];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.i = parcel.readInt() == 1;
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.h) + "}";
        }

        @Override // defpackage.p, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.h, parcel, i);
            parcel.writeInt(this.i ? 1 : 0);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.e0);
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }
}
