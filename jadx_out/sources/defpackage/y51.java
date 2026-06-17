package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class y51 {
    public final c61 a;

    public y51(c61 c61Var) {
        this.a = c61Var;
    }

    public static y51 b(c61 c61Var) {
        return new y51((c61) hg3.h(c61Var, "callbacks == null"));
    }

    public void a(p51 p51Var) {
        c61 c61Var = this.a;
        c61Var.j.m(c61Var, c61Var, p51Var);
    }

    public void c() {
        this.a.j.y();
    }

    public boolean d(MenuItem menuItem) {
        return this.a.j.B(menuItem);
    }

    public void e() {
        this.a.j.C();
    }

    public void f() {
        this.a.j.E();
    }

    public void g() {
        this.a.j.N();
    }

    public void h() {
        this.a.j.R();
    }

    public void i() {
        this.a.j.S();
    }

    public void j() {
        this.a.j.U();
    }

    public boolean k() {
        return this.a.j.b0(true);
    }

    public k61 l() {
        return this.a.j;
    }

    public void m() {
        this.a.j.U0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.j.y0().onCreateView(view, str, context, attributeSet);
    }
}
