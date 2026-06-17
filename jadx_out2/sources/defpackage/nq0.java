package defpackage;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nq0 implements oq0 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oq0
    public void a(kk4 kk4Var, kk4 kk4Var2, Window window, View view, boolean z, boolean z2) {
        kk4Var.getClass();
        kk4Var2.getClass();
        window.getClass();
        view.getClass();
        p95.b(window, false);
        window.setStatusBarColor(kk4Var.f(z));
        window.setNavigationBarColor(kk4Var2.f(z2));
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(kk4Var2.d() == 0);
        z95 z95Var = new z95(window, view);
        z95Var.d(!z);
        z95Var.c(!z2);
    }
}
