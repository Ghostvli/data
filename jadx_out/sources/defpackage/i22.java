package defpackage;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i22 {
    public final HashSet a = new HashSet();

    public boolean a(h22 h22Var, boolean z) {
        if (!z) {
            return this.a.remove(h22Var);
        }
        if (Build.VERSION.SDK_INT >= h22Var.f) {
            return this.a.add(h22Var);
        }
        k02.c(String.format("%s is not supported pre SDK %d", h22Var.name(), Integer.valueOf(h22Var.f)));
        return false;
    }

    public boolean b(h22 h22Var) {
        return this.a.contains(h22Var);
    }
}
