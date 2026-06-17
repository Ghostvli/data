package defpackage;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class uy {
    public final List a = new ArrayList();

    public void a(nt4 nt4Var) {
        this.a.add(nt4Var);
    }

    public void b(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            uy4.b(path, (nt4) this.a.get(size));
        }
    }
}
