package defpackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.WindowManager;
import androidx.appcompat.app.a;
import com.fongmi.android.tv.bean.Config;
import defpackage.fz;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class me1 implements fz.a {
    public final gz a;
    public al0 b;
    public fz c;
    public a d;
    public boolean e;
    public boolean f;
    public int g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: p51 */
    /* JADX WARN: Multi-variable type inference failed */
    public me1(p51 p51Var) {
        this.a = (gz) p51Var;
        e(p51Var.X1());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static me1 c(p51 p51Var) {
        return new me1(p51Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static me1 d(Activity activity) {
        return new me1(activity);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // fz.a
    public void a(Config config) {
        if (this.c.O(config) == 0) {
            this.d.dismiss();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // fz.a
    public void b(Config config) {
        this.a.b0(config);
        this.d.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(Activity activity) {
        this.b = al0.c(LayoutInflater.from(activity));
        this.d = new o52(activity).setView(this.b.getRoot()).create();
        this.c = new fz(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public me1 f() {
        this.e = true;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g() {
        if (this.c.g() == 0) {
            return;
        }
        WindowManager.LayoutParams attributes = this.d.getWindow().getAttributes();
        if (this.f && vr3.r(this.d.getContext())) {
            attributes.width = (int) (vr3.j() * 0.5f);
        }
        this.d.getWindow().setAttributes(attributes);
        this.d.getWindow().setDimAmount(0.0f);
        this.d.show();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        this.b.b.setItemAnimator(null);
        this.b.b.setHasFixedSize(false);
        this.b.b.i(new gb4(1, 8));
        this.b.b.setAdapter(this.c.N(this.e).I(this.g));
        if (this.f) {
            this.b.b.setMaxHeight(vr3.a(264));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i() {
        h();
        g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public me1 j(int i) {
        this.g = i;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.app.Activity */
    /* JADX WARN: Multi-variable type inference failed */
    public me1(Activity activity) {
        this.a = (gz) activity;
        this.f = true;
        e(activity);
    }
}
