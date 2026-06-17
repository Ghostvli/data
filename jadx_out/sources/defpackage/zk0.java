package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zk0 extends p51 implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler i0;
    public boolean r0;
    public Dialog t0;
    public boolean u0;
    public boolean v0;
    public boolean w0;
    public Runnable j0 = new a();
    public DialogInterface.OnCancelListener k0 = new b();
    public DialogInterface.OnDismissListener l0 = new c();
    public int m0 = 0;
    public int n0 = 0;
    public boolean o0 = true;
    public boolean p0 = true;
    public int q0 = -1;
    public x43 s0 = new d();
    public boolean x0 = false;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zk0.this.l0.onDismiss(zk0.this.t0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (zk0.this.t0 != null) {
                zk0 zk0Var = zk0.this;
                zk0Var.onCancel(zk0Var.t0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (zk0.this.t0 != null) {
                zk0 zk0Var = zk0.this;
                zk0Var.onDismiss(zk0Var.t0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements x43 {
        public d() {
        }

        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bt1 bt1Var) {
            if (bt1Var == null || !zk0.this.p0) {
                return;
            }
            View viewZ1 = zk0.this.Z1();
            if (viewZ1.getParent() != null) {
                e04.a("DialogFragment can not be attached to a container view");
                return;
            }
            if (zk0.this.t0 != null) {
                if (k61.K0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + zk0.this.t0);
                }
                zk0.this.t0.setContentView(viewZ1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends x51 {
        public final /* synthetic */ x51 f;

        public e(x51 x51Var) {
            this.f = x51Var;
        }

        @Override // defpackage.x51
        public View c(int i) {
            return this.f.d() ? this.f.c(i) : zk0.this.C2(i);
        }

        @Override // defpackage.x51
        public boolean d() {
            return this.f.d() || zk0.this.D2();
        }
    }

    public int A2() {
        return this.n0;
    }

    public Dialog B2(Bundle bundle) {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new my(Y1(), A2());
    }

    @Override // defpackage.p51
    public void C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.C1(layoutInflater, viewGroup, bundle);
        if (this.N != null || this.t0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.t0.onRestoreInstanceState(bundle2);
    }

    public View C2(int i) {
        Dialog dialog = this.t0;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    public boolean D2() {
        return this.x0;
    }

    public final void E2(Bundle bundle) {
        if (this.p0 && !this.x0) {
            try {
                this.r0 = true;
                Dialog dialogB2 = B2(bundle);
                this.t0 = dialogB2;
                if (this.p0) {
                    F2(dialogB2, this.m0);
                    Context contextU = U();
                    if (contextU instanceof Activity) {
                        this.t0.setOwnerActivity((Activity) contextU);
                    }
                    this.t0.setCancelable(this.o0);
                    this.t0.setOnCancelListener(this.k0);
                    this.t0.setOnDismissListener(this.l0);
                    this.x0 = true;
                } else {
                    this.t0 = null;
                }
                this.r0 = false;
            } catch (Throwable th) {
                this.r0 = false;
                throw th;
            }
        }
    }

    public void F2(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void G2(k61 k61Var, String str) {
        this.v0 = false;
        this.w0 = true;
        d71 d71VarO = k61Var.o();
        d71VarO.u(true);
        d71VarO.d(this, str);
        d71VarO.h();
    }

    @Override // defpackage.p51
    public x51 H() {
        return new e(super.H());
    }

    @Override // defpackage.p51
    public void P0(Bundle bundle) {
        super.P0(bundle);
    }

    @Override // defpackage.p51
    public void S0(Context context) {
        super.S0(context);
        D0().g(this.s0);
        if (this.w0) {
            return;
        }
        this.v0 = false;
    }

    @Override // defpackage.p51
    public void V0(Bundle bundle) {
        super.V0(bundle);
        this.i0 = new Handler();
        this.p0 = this.D == 0;
        if (bundle != null) {
            this.m0 = bundle.getInt("android:style", 0);
            this.n0 = bundle.getInt("android:theme", 0);
            this.o0 = bundle.getBoolean("android:cancelable", true);
            this.p0 = bundle.getBoolean("android:showsDialog", this.p0);
            this.q0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // defpackage.p51
    public void c1() {
        super.c1();
        Dialog dialog = this.t0;
        if (dialog != null) {
            this.u0 = true;
            dialog.setOnDismissListener(null);
            this.t0.dismiss();
            if (!this.v0) {
                onDismiss(this.t0);
            }
            this.t0 = null;
            this.x0 = false;
        }
    }

    @Override // defpackage.p51
    public void d1() {
        super.d1();
        if (!this.w0 && !this.v0) {
            this.v0 = true;
        }
        D0().k(this.s0);
    }

    @Override // defpackage.p51
    public LayoutInflater e1(Bundle bundle) {
        LayoutInflater layoutInflaterE1 = super.e1(bundle);
        if (this.p0 && !this.r0) {
            E2(bundle);
            if (k61.K0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.t0;
            if (dialog != null) {
                return layoutInflaterE1.cloneInContext(dialog.getContext());
            }
        } else if (k61.K0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.p0) {
                Log.d("FragmentManager", "mShowsDialog = false: ".concat(str));
                return layoutInflaterE1;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: ".concat(str));
        }
        return layoutInflaterE1;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.u0) {
            return;
        }
        if (k61.K0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        y2(true, true, false);
    }

    @Override // defpackage.p51
    public void r1(Bundle bundle) {
        super.r1(bundle);
        Dialog dialog = this.t0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.m0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.n0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.o0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.p0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.q0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // defpackage.p51
    public void s1() {
        super.s1();
        Dialog dialog = this.t0;
        if (dialog != null) {
            this.u0 = false;
            dialog.show();
            View decorView = this.t0.getWindow().getDecorView();
            a55.a(decorView, this);
            d55.a(decorView, this);
            c55.a(decorView, this);
        }
    }

    @Override // defpackage.p51
    public void t1() {
        super.t1();
        Dialog dialog = this.t0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // defpackage.p51
    public void v1(Bundle bundle) {
        Bundle bundle2;
        super.v1(bundle);
        if (this.t0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.t0.onRestoreInstanceState(bundle2);
    }

    public void w2() {
        y2(false, false, false);
    }

    public void x2() {
        y2(true, false, false);
    }

    public final void y2(boolean z, boolean z2, boolean z3) {
        if (this.v0) {
            return;
        }
        this.v0 = true;
        this.w0 = false;
        Dialog dialog = this.t0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.t0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.i0.getLooper()) {
                    onDismiss(this.t0);
                } else {
                    this.i0.post(this.j0);
                }
            }
        }
        this.u0 = true;
        if (this.q0 >= 0) {
            if (z3) {
                k0().a1(this.q0, 1);
            } else {
                k0().Y0(this.q0, 1, z);
            }
            this.q0 = -1;
            return;
        }
        d71 d71VarO = k0().o();
        d71VarO.u(true);
        d71VarO.p(this);
        if (z3) {
            d71VarO.j();
        } else if (z) {
            d71VarO.i();
        } else {
            d71VarO.h();
        }
    }

    public Dialog z2() {
        return this.t0;
    }
}
