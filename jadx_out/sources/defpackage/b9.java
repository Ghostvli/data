package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b9 extends RadioButton implements ep4 {
    public final f8 f;
    public final z7 g;
    public final j9 h;
    public u8 i;

    public b9(Context context, AttributeSet attributeSet, int i) {
        super(ap4.b(context), attributeSet, i);
        en4.a(this, getContext());
        f8 f8Var = new f8(this);
        this.f = f8Var;
        f8Var.d(attributeSet, i);
        z7 z7Var = new z7(this);
        this.g = z7Var;
        z7Var.e(attributeSet, i);
        j9 j9Var = new j9(this);
        this.h = j9Var;
        j9Var.m(attributeSet, i);
        getEmojiTextViewHelper().c(attributeSet, i);
    }

    private u8 getEmojiTextViewHelper() {
        if (this.i == null) {
            this.i = new u8(this);
        }
        return this.i;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        z7 z7Var = this.g;
        if (z7Var != null) {
            z7Var.b();
        }
        j9 j9Var = this.h;
        if (j9Var != null) {
            j9Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        z7 z7Var = this.g;
        if (z7Var != null) {
            return z7Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        z7 z7Var = this.g;
        if (z7Var != null) {
            return z7Var.d();
        }
        return null;
    }

    @Override // defpackage.ep4
    public ColorStateList getSupportButtonTintList() {
        f8 f8Var = this.f;
        if (f8Var != null) {
            return f8Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        f8 f8Var = this.f;
        if (f8Var != null) {
            return f8Var.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.h.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.h.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        z7 z7Var = this.g;
        if (z7Var != null) {
            z7Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        z7 z7Var = this.g;
        if (z7Var != null) {
            z7Var.g(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(e9.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        j9 j9Var = this.h;
        if (j9Var != null) {
            j9Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        j9 j9Var = this.h;
        if (j9Var != null) {
            j9Var.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        z7 z7Var = this.g;
        if (z7Var != null) {
            z7Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        z7 z7Var = this.g;
        if (z7Var != null) {
            z7Var.j(mode);
        }
    }

    @Override // defpackage.ep4
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        f8 f8Var = this.f;
        if (f8Var != null) {
            f8Var.f(colorStateList);
        }
    }

    @Override // defpackage.ep4
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        f8 f8Var = this.f;
        if (f8Var != null) {
            f8Var.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.h.w(colorStateList);
        this.h.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.h.x(mode);
        this.h.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        f8 f8Var = this.f;
        if (f8Var != null) {
            f8Var.e();
        }
    }

    public b9(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nk3.F);
    }
}
