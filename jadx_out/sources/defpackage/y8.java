package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class y8 extends MultiAutoCompleteTextView {
    public static final int[] i = {R.attr.popupBackground};
    public final z7 f;
    public final j9 g;
    public final t8 h;

    public y8(Context context, AttributeSet attributeSet, int i2) {
        super(ap4.b(context), attributeSet, i2);
        en4.a(this, getContext());
        dp4 dp4VarV = dp4.v(getContext(), attributeSet, i, i2, 0);
        if (dp4VarV.s(0)) {
            setDropDownBackgroundDrawable(dp4VarV.g(0));
        }
        dp4VarV.x();
        z7 z7Var = new z7(this);
        this.f = z7Var;
        z7Var.e(attributeSet, i2);
        j9 j9Var = new j9(this);
        this.g = j9Var;
        j9Var.m(attributeSet, i2);
        j9Var.b();
        t8 t8Var = new t8(this);
        this.h = t8Var;
        t8Var.c(attributeSet, i2);
        a(t8Var);
    }

    public void a(t8 t8Var) {
        KeyListener keyListener = getKeyListener();
        if (t8Var.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = t8Var.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        z7 z7Var = this.f;
        if (z7Var != null) {
            z7Var.b();
        }
        j9 j9Var = this.g;
        if (j9Var != null) {
            j9Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        z7 z7Var = this.f;
        if (z7Var != null) {
            return z7Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        z7 z7Var = this.f;
        if (z7Var != null) {
            return z7Var.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.g.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.g.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.h.d(v8.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        z7 z7Var = this.f;
        if (z7Var != null) {
            z7Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        z7 z7Var = this.f;
        if (z7Var != null) {
            z7Var.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        j9 j9Var = this.g;
        if (j9Var != null) {
            j9Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        j9 j9Var = this.g;
        if (j9Var != null) {
            j9Var.p();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(e9.b(getContext(), i2));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.h.e(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.h.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        z7 z7Var = this.f;
        if (z7Var != null) {
            z7Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        z7 z7Var = this.f;
        if (z7Var != null) {
            z7Var.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.g.w(colorStateList);
        this.g.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.g.x(mode);
        this.g.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        j9 j9Var = this.g;
        if (j9Var != null) {
            j9Var.q(context, i2);
        }
    }

    public y8(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nk3.m);
    }
}
