package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(RecyclerView.c0 c0Var, m mVar, View view, View view2, RecyclerView.q qVar, boolean z) {
        if (qVar.k0() == 0 || c0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(qVar.D0(view) - qVar.D0(view2)) + 1;
        }
        return Math.min(mVar.n(), mVar.d(view2) - mVar.g(view));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(RecyclerView.c0 c0Var, m mVar, View view, View view2, RecyclerView.q qVar, boolean z, boolean z2) {
        if (qVar.k0() == 0 || c0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (c0Var.b() - Math.max(qVar.D0(view), qVar.D0(view2))) - 1) : Math.max(0, Math.min(qVar.D0(view), qVar.D0(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(mVar.d(view2) - mVar.g(view)) / (Math.abs(qVar.D0(view) - qVar.D0(view2)) + 1))) + (mVar.m() - mVar.g(view)));
        }
        return iMax;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(RecyclerView.c0 c0Var, m mVar, View view, View view2, RecyclerView.q qVar, boolean z) {
        if (qVar.k0() == 0 || c0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0Var.b();
        }
        return (int) (((mVar.d(view2) - mVar.g(view)) / (Math.abs(qVar.D0(view) - qVar.D0(view2)) + 1)) * c0Var.b());
    }
}
