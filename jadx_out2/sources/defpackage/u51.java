package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.g;
import androidx.lifecycle.j;
import defpackage.a3;
import defpackage.qx3;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u51 extends iy implements a3.d {
    public boolean C;
    public boolean D;
    public final y51 A = y51.b(new a());
    public final j B = new j(this);
    public boolean E = true;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends c61 implements i63, o63, k63, l63, l45, h63, s3, vx3, o61, vr2 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            super(u51.this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vr2
        public void D(ds2 ds2Var) {
            u51.this.D(ds2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.l63
        public void K0(h20 h20Var) {
            u51.this.K0(h20Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.k63
        public void L0(h20 h20Var) {
            u51.this.L0(h20Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.l63
        public void N(h20 h20Var) {
            u51.this.N(h20Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.k63
        public void O(h20 h20Var) {
            u51.this.O(h20Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o63
        public void T(h20 h20Var) {
            u51.this.T(h20Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.s3
        public r3 W() {
            return u51.this.W();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o63
        public void Y(h20 h20Var) {
            u51.this.Y(h20Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o61
        public void a(k61 k61Var, p51 p51Var) {
            u51.this.r1(p51Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.x51
        public View c(int i) {
            return u51.this.findViewById(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.x51
        public boolean d() {
            Window window = u51.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.l45
        public k45 d0() {
            return u51.this.d0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.bt1
        public g getLifecycle() {
            return u51.this.B;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.c61
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            u51.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.c61
        public LayoutInflater j() {
            return u51.this.getLayoutInflater().cloneInContext(u51.this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.c61
        public boolean k(String str) {
            return a3.q(u51.this, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vx3
        public qx3 l0() {
            return u51.this.l0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.c61
        public void m() {
            n();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void n() {
            u51.this.g1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: i()Ljava/lang/Object; */
        @Override // defpackage.c61
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public u51 i() {
            return u51.this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vr2
        public void s0(ds2 ds2Var) {
            u51.this.s0(ds2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i63
        public void t0(h20 h20Var) {
            u51.this.t0(h20Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i63
        public void x0(h20 h20Var) {
            u51.this.x0(h20Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h63
        public f63 y() {
            return u51.this.y();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public u51() {
        o1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Bundle k1(u51 u51Var) {
        u51Var.p1();
        u51Var.B.h(g.a.ON_STOP);
        return new Bundle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean q1(k61 k61Var, g.b bVar) {
        boolean zQ1 = false;
        for (p51 p51Var : k61Var.w0()) {
            if (p51Var != null) {
                if (p51Var.e0() != null) {
                    zQ1 |= q1(p51Var.T(), bVar);
                }
                l71 l71Var = p51Var.Z;
                if (l71Var != null && l71Var.getLifecycle().b().b(g.b.i)) {
                    p51Var.Z.f(bVar);
                    zQ1 = true;
                }
                if (p51Var.Y.b().b(g.b.i)) {
                    p51Var.Y.m(bVar);
                    zQ1 = true;
                }
            }
        }
        return zQ1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (T0(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.C);
            printWriter.print(" mResumed=");
            printWriter.print(this.D);
            printWriter.print(" mStopped=");
            printWriter.print(this.E);
            if (getApplication() != null) {
                cz1.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.A.l().X(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View m1(View view, String str, Context context, AttributeSet attributeSet) {
        return this.A.n(view, str, context, attributeSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k61 n1() {
        return this.A.l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o1() {
        l0().c("android:support:lifecycle", new qx3.b() { // from class: q51
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // qx3.b
            public final Bundle a() {
                return u51.k1(this.a);
            }
        });
        t0(new h20() { // from class: r51
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.h20
            public final void accept(Object obj) {
                this.a.A.m();
            }
        });
        c1(new h20() { // from class: s51
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.h20
            public final void accept(Object obj) {
                this.a.A.m();
            }
        });
        b1(new j63() { // from class: t51
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.j63
            public final void a(Context context) {
                this.a.A.a(null);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.iy, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.A.m();
        super.onActivityResult(i, i2, intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.iy, defpackage.ky, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.B.h(g.a.ON_CREATE);
        this.A.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewM1 = m1(null, str, context, attributeSet);
        return viewM1 == null ? super.onCreateView(str, context, attributeSet) : viewM1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.A.f();
        this.B.h(g.a.ON_DESTROY);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.iy, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.A.d(menuItem);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.D = false;
        this.A.g();
        this.B.h(g.a.ON_PAUSE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        s1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.iy, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.A.m();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public void onResume() {
        this.A.m();
        super.onResume();
        this.D = true;
        this.A.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public void onStart() {
        this.A.m();
        super.onStart();
        this.E = false;
        if (!this.C) {
            this.C = true;
            this.A.c();
        }
        this.A.k();
        this.B.h(g.a.ON_START);
        this.A.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.A.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.E = true;
        p1();
        this.A.j();
        this.B.h(g.a.ON_STOP);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p1() {
        while (q1(n1(), g.b.h)) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r1(p51 p51Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s1() {
        this.B.h(g.a.ON_RESUME);
        this.A.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // a3.d
    public final void x(int i) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewM1 = m1(view, str, context, attributeSet);
        return viewM1 == null ? super.onCreateView(view, str, context, attributeSet) : viewM1;
    }
}
