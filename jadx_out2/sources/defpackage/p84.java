package defpackage;

import android.app.Activity;
import android.view.LayoutInflater;
import androidx.appcompat.app.a;
import com.fongmi.android.tv.bean.Site;
import defpackage.x74;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class p84 implements x74.a {
    public hl0 a;
    public e84 b;
    public x74 c;
    public a d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: p51 */
    /* JADX WARN: Multi-variable type inference failed */
    public p84(p51 p51Var) {
        if (p51Var instanceof e84) {
            this.b = (e84) p51Var;
        }
        j(p51Var.X1());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static p84 i(p51 p51Var) {
        return new p84(p51Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // x74.a
    public void a(Site site) {
        e84 e84Var = this.b;
        if (e84Var == null) {
            return;
        }
        e84Var.o(site);
        this.d.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // x74.a
    public void b(int i, Site site) {
        site.setChangeable(!site.isChangeable()).save();
        this.c.m(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // x74.a
    public boolean c(Site site) {
        boolean z = !site.isChangeable();
        Iterator it = this.c.O().iterator();
        while (it.hasNext()) {
            ((Site) it.next()).setChangeable(z).save();
        }
        x74 x74Var = this.c;
        x74Var.p(0, x74Var.g());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // x74.a
    public boolean d(Site site) {
        boolean z = !site.isSearchable();
        Iterator it = this.c.O().iterator();
        while (it.hasNext()) {
            ((Site) it.next()).setSearchable(z).save();
        }
        x74 x74Var = this.c;
        x74Var.p(0, x74Var.g());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // x74.a
    public void e(int i, Site site) {
        site.setSearchable(!site.isSearchable()).save();
        this.c.m(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p84 g() {
        this.c.X(true);
        this.c.M(true);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p84 h() {
        this.c.M(true);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(Activity activity) {
        this.a = hl0.c(LayoutInflater.from(activity));
        this.d = new o52(activity).setView(this.a.getRoot()).create();
        this.c = new x74(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void k() {
        this.a.b.t1(b75.P());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p84 l() {
        this.c.X(true);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m() {
        if (this.c.g() == 0) {
            return;
        }
        this.d.getWindow().setDimAmount(0.0f);
        this.d.show();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        this.a.b.setAdapter(this.c);
        this.a.b.setItemAnimator(null);
        this.a.b.setHasFixedSize(true);
        this.a.b.i(new gb4(1, 8));
        this.a.b.post(new Runnable() { // from class: o84
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.k();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o() {
        n();
        m();
    }
}
