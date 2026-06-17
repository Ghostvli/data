package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.g;
import androidx.lifecycle.j;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class my extends Dialog implements bt1, h63, vx3 {
    public j f;
    public final sx3 g;
    public final f63 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public my(Context context, int i) {
        super(context, i);
        context.getClass();
        this.g = sx3.c.b(this);
        this.h = new f63(new Runnable() { // from class: ly
            @Override // java.lang.Runnable
            public final void run() {
                my.a(this.f);
            }
        });
    }

    public static void a(my myVar) {
        myVar.getClass();
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        c();
        super.addContentView(view, layoutParams);
    }

    public final j b() {
        j jVar = this.f;
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this);
        this.f = jVar2;
        return jVar2;
    }

    public void c() {
        Window window = getWindow();
        window.getClass();
        View decorView = window.getDecorView();
        decorView.getClass();
        a55.a(decorView, this);
        Window window2 = getWindow();
        window2.getClass();
        View decorView2 = window2.getDecorView();
        decorView2.getClass();
        b55.a(decorView2, this);
        Window window3 = getWindow();
        window3.getClass();
        View decorView3 = window3.getDecorView();
        decorView3.getClass();
        c55.a(decorView3, this);
    }

    @Override // defpackage.bt1
    public g getLifecycle() {
        return b();
    }

    @Override // defpackage.vx3
    public qx3 l0() {
        return this.g.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.h.k();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            f63 f63Var = this.h;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.getClass();
            f63Var.n(onBackInvokedDispatcher);
        }
        this.g.d(bundle);
        b().h(g.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.getClass();
        this.g.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b().h(g.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        b().h(g.a.ON_DESTROY);
        this.f = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        view.getClass();
        c();
        super.setContentView(view);
    }

    @Override // defpackage.h63
    public final f63 y() {
        return this.h;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        c();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        c();
        super.setContentView(view, layoutParams);
    }
}
