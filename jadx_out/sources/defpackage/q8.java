package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.v2;
import defpackage.xq1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class q8 extends my implements b8 {
    public h8 i;
    public final xq1.a j;

    public q8(Context context, int i) {
        super(context, e(context, i));
        this.j = new xq1.a() { // from class: p8
            @Override // xq1.a
            public final boolean q0(KeyEvent keyEvent) {
                return this.f.f(keyEvent);
            }
        };
        h8 h8VarD = d();
        h8VarD.L(e(context, i));
        h8VarD.w(null);
    }

    private static int e(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(nk3.y, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // defpackage.b8
    public void G(v2 v2Var) {
    }

    @Override // defpackage.b8
    public void I(v2 v2Var) {
    }

    @Override // defpackage.my, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        d().e(view, layoutParams);
    }

    public h8 d() {
        if (this.i == null) {
            this.i = h8.i(this, this);
        }
        return this.i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        d().x();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return xq1.e(this.j, getWindow().getDecorView(), this, keyEvent);
    }

    public boolean f(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public View findViewById(int i) {
        return d().j(i);
    }

    public boolean g(int i) {
        return d().F(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        d().t();
    }

    @Override // defpackage.my, android.app.Dialog
    public void onCreate(Bundle bundle) {
        d().s();
        super.onCreate(bundle);
        d().w(bundle);
    }

    @Override // defpackage.my, android.app.Dialog
    public void onStop() {
        super.onStop();
        d().C();
    }

    @Override // defpackage.my, android.app.Dialog
    public void setContentView(int i) {
        c();
        d().G(i);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        d().M(getContext().getString(i));
    }

    @Override // defpackage.b8
    public v2 z(v2.a aVar) {
        return null;
    }

    @Override // defpackage.my, android.app.Dialog
    public void setContentView(View view) {
        c();
        d().H(view);
    }

    @Override // defpackage.my, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        d().I(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        d().M(charSequence);
    }
}
