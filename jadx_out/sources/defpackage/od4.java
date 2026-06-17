package defpackage;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import defpackage.v2;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class od4 extends v2 implements e.a {
    public Context h;
    public ActionBarContextView i;
    public v2.a j;
    public WeakReference k;
    public boolean l;
    public boolean m;
    public e n;

    public od4(Context context, ActionBarContextView actionBarContextView, v2.a aVar, boolean z) {
        this.h = context;
        this.i = actionBarContextView;
        this.j = aVar;
        e eVarX = new e(actionBarContextView.getContext()).X(1);
        this.n = eVarX;
        eVarX.W(this);
        this.m = z;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(e eVar, MenuItem menuItem) {
        return this.j.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(e eVar) {
        k();
        this.i.l();
    }

    @Override // defpackage.v2
    public void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.j.b(this);
    }

    @Override // defpackage.v2
    public View d() {
        WeakReference weakReference = this.k;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // defpackage.v2
    public Menu e() {
        return this.n;
    }

    @Override // defpackage.v2
    public MenuInflater f() {
        return new dj4(this.i.getContext());
    }

    @Override // defpackage.v2
    public CharSequence g() {
        return this.i.getSubtitle();
    }

    @Override // defpackage.v2
    public CharSequence i() {
        return this.i.getTitle();
    }

    @Override // defpackage.v2
    public void k() {
        this.j.d(this, this.n);
    }

    @Override // defpackage.v2
    public boolean l() {
        return this.i.j();
    }

    @Override // defpackage.v2
    public void m(View view) {
        this.i.setCustomView(view);
        this.k = view != null ? new WeakReference(view) : null;
    }

    @Override // defpackage.v2
    public void n(int i) {
        o(this.h.getString(i));
    }

    @Override // defpackage.v2
    public void o(CharSequence charSequence) {
        this.i.setSubtitle(charSequence);
    }

    @Override // defpackage.v2
    public void q(int i) {
        r(this.h.getString(i));
    }

    @Override // defpackage.v2
    public void r(CharSequence charSequence) {
        this.i.setTitle(charSequence);
    }

    @Override // defpackage.v2
    public void s(boolean z) {
        super.s(z);
        this.i.setTitleOptional(z);
    }
}
