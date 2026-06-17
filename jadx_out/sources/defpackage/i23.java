package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i23 extends FrameLayout implements e23 {
    public final TextView f;
    public boolean g;
    public boolean h;
    public g i;
    public ColorStateList j;

    public i23(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(gm3.h, (ViewGroup) this, true);
        this.f = (TextView) findViewById(ol3.p);
    }

    private void a() {
        g gVar = this.i;
        if (gVar != null) {
            setVisibility((!gVar.isVisible() || (!this.g && this.h)) ? 8 : 0);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void d(g gVar, int i) {
        this.i = gVar;
        gVar.setCheckable(false);
        this.f.setText(gVar.getTitle());
        a();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return this.i;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
    }

    @Override // defpackage.e23
    public void setExpanded(boolean z) {
        this.g = z;
        a();
    }

    public void setIcon(Drawable drawable) {
    }

    @Override // defpackage.e23
    public void setOnlyShowWhenExpanded(boolean z) {
        this.h = z;
        a();
    }

    public void setTextAppearance(int i) {
        an4.m(this.f, i);
        ColorStateList colorStateList = this.j;
        if (colorStateList != null) {
            this.f.setTextColor(colorStateList);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.j = colorStateList;
        if (colorStateList != null) {
            this.f.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
    }
}
