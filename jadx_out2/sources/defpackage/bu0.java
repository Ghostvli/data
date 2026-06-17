package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Episode;
import defpackage.au0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bu0 extends uh implements au0.a {
    public z51 k0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bu0 B2(int i, List list) {
        Bundle bundle = new Bundle();
        bundle.putInt("spanCount", i);
        bundle.putParcelableArrayList("items", new ArrayList<>(list));
        bu0 bu0Var = new bu0();
        bu0Var.e2(bundle);
        return bu0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void C2() {
        this.k0.b.setHasFixedSize(true);
        this.k0.b.setItemAnimator(null);
        this.k0.b.setLayoutManager(new GridLayoutManager(U(), A2()));
        RecyclerView recyclerView = this.k0.b;
        au0 au0Var = new au0(this, 3, z2());
        recyclerView.setAdapter(au0Var);
        this.k0.b.t1(au0Var.K());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int A2() {
        return S().getInt("spanCount");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // au0.a
    public void E(Episode episode) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("episode", episode);
        k0().o1("result", bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.uh
    public i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        z51 z51VarC = z51.c(layoutInflater, viewGroup, false);
        this.k0 = z51VarC;
        return z51VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.uh
    public void x2() {
        C2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ArrayList z2() {
        return S().getParcelableArrayList("items");
    }
}
