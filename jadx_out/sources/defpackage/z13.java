package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class z13 extends FrameLayout implements e23 {
    public boolean f;
    public boolean g;
    public boolean h;

    public z13(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(gm3.g, (ViewGroup) this, true);
        a();
    }

    public void a() {
        setVisibility((!this.h || (!this.f && this.g)) ? 8 : 0);
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void d(g gVar, int i) {
        a();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setDividersEnabled(boolean z) {
        this.h = z;
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
    }

    @Override // defpackage.e23
    public void setExpanded(boolean z) {
        this.f = z;
        a();
    }

    public void setIcon(Drawable drawable) {
    }

    @Override // defpackage.e23
    public void setOnlyShowWhenExpanded(boolean z) {
        this.g = z;
        a();
    }

    public void setTitle(CharSequence charSequence) {
    }
}
