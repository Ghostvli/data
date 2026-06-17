package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fongmi.android.tv.db.AppDatabase;
import com.fongmi.android.tv.ui.custom.CustomRecyclerView;
import com.google.android.material.bottomsheet.b;
import defpackage.dt3;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class et3 extends nh implements dt3.a {
    public dt3 A0;
    public to B0;
    public gl0 z0;

    public static et3 U2() {
        return new et3();
    }

    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        gl0 gl0VarC = gl0.c(layoutInflater, viewGroup, false);
        this.z0 = gl0VarC;
        return gl0VarC;
    }

    @Override // defpackage.nh
    public void O2() {
        this.z0.b.setItemAnimator(null);
        this.z0.b.setHasFixedSize(false);
        CustomRecyclerView customRecyclerView = this.z0.b;
        dt3 dt3Var = new dt3(this);
        this.A0 = dt3Var;
        customRecyclerView.setAdapter(dt3Var);
        this.z0.b.i(new gb4(1, 16));
        this.z0.b.setVisibility(this.A0.g() == 0 ? 8 : 0);
    }

    public void V2(u51 u51Var, to toVar) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
        this.B0 = toVar;
    }

    @Override // dt3.a
    public void e(File file) {
        if (this.A0.O(file) == 0) {
            w2();
        }
    }

    @Override // dt3.a
    public void s(File file) {
        AppDatabase.Y(file, this.B0);
        w2();
    }
}
