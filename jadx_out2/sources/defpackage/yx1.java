package defpackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.WindowManager;
import androidx.appcompat.app.a;
import com.fongmi.android.tv.bean.Live;
import defpackage.gw1;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yx1 implements gw1.a {
    public final yw1 a;
    public dl0 b;
    public gw1 c;
    public a d;
    public boolean e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: p51 */
    /* JADX WARN: Multi-variable type inference failed */
    public yx1(p51 p51Var) {
        this.a = (yw1) p51Var;
        j(p51Var.X1());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yx1 h(p51 p51Var) {
        return new yx1(p51Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yx1 i(Activity activity) {
        return new yx1(activity);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // gw1.a
    public void a(int i, Live live) {
        live.pass(!live.isPass()).save();
        this.c.m(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // gw1.a
    public boolean b(Live live) {
        boolean z = !live.isPass();
        Iterator it = lx1.J().P().iterator();
        while (it.hasNext()) {
            ((Live) it.next()).pass(z).save();
        }
        gw1 gw1Var = this.c;
        gw1Var.p(0, gw1Var.g());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // gw1.a
    public boolean c(Live live) {
        boolean z = !live.isBoot();
        Iterator it = lx1.J().P().iterator();
        while (it.hasNext()) {
            ((Live) it.next()).boot(z).save();
        }
        gw1 gw1Var = this.c;
        gw1Var.p(0, gw1Var.g());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // gw1.a
    public void d(int i, Live live) {
        live.boot(!live.isBoot()).save();
        this.c.m(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // gw1.a
    public void e(Live live) {
        this.a.B(live);
        this.d.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yx1 g() {
        this.c.S(true);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(Activity activity) {
        this.b = dl0.c(LayoutInflater.from(activity));
        this.d = new o52(activity).setView(this.b.getRoot()).create();
        this.c = new gw1(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void k() {
        this.b.b.t1(lx1.N());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l() {
        if (this.c.g() == 0) {
            return;
        }
        WindowManager.LayoutParams attributes = this.d.getWindow().getAttributes();
        if (this.e && vr3.r(this.d.getContext())) {
            attributes.width = (int) (vr3.j() * 0.5f);
        }
        this.d.getWindow().setAttributes(attributes);
        this.d.getWindow().setDimAmount(0.0f);
        this.d.show();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m() {
        this.b.b.setAdapter(this.c);
        this.b.b.setItemAnimator(null);
        this.b.b.setHasFixedSize(true);
        this.b.b.i(new gb4(1, 8));
        this.b.b.post(new Runnable() { // from class: xx1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.k();
            }
        });
        if (this.e) {
            this.b.b.setMaxHeight(vr3.a(264));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n() {
        m();
        l();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.app.Activity */
    /* JADX WARN: Multi-variable type inference failed */
    public yx1(Activity activity) {
        this.a = (yw1) activity;
        this.e = true;
        j(activity);
    }
}
