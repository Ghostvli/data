package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class w8 extends ImageButton {
    public final z7 f;
    public final x8 g;
    public boolean h;

    public w8(Context context, AttributeSet attributeSet, int i) {
        super(ap4.b(context), attributeSet, i);
        this.h = false;
        en4.a(this, getContext());
        z7 z7Var = new z7(this);
        this.f = z7Var;
        z7Var.e(attributeSet, i);
        x8 x8Var = new x8(this);
        this.g = x8Var;
        x8Var.g(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        z7 z7Var = this.f;
        if (z7Var != null) {
            z7Var.b();
        }
        x8 x8Var = this.g;
        if (x8Var != null) {
            x8Var.c();
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

    public ColorStateList getSupportImageTintList() {
        x8 x8Var = this.g;
        if (x8Var != null) {
            return x8Var.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        x8 x8Var = this.g;
        if (x8Var != null) {
            return x8Var.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.g.f() && super.hasOverlappingRendering();
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
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        z7 z7Var = this.f;
        if (z7Var != null) {
            z7Var.g(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        x8 x8Var = this.g;
        if (x8Var != null) {
            x8Var.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        x8 x8Var = this.g;
        if (x8Var != null && drawable != null && !this.h) {
            x8Var.h(drawable);
        }
        super.setImageDrawable(drawable);
        x8 x8Var2 = this.g;
        if (x8Var2 != null) {
            x8Var2.c();
            if (this.h) {
                return;
            }
            this.g.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.h = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.g.i(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        x8 x8Var = this.g;
        if (x8Var != null) {
            x8Var.c();
        }
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        x8 x8Var = this.g;
        if (x8Var != null) {
            x8Var.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        x8 x8Var = this.g;
        if (x8Var != null) {
            x8Var.k(mode);
        }
    }

    public w8(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nk3.B);
    }
}
