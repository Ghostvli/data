package defpackage;

import android.graphics.Rect;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class nm0 {
    public c94 a;
    public int b;
    public boolean c = false;
    public qg3 d = new r11();

    public nm0(int i, c94 c94Var) {
        this.b = i;
        this.a = c94Var;
    }

    public c94 a(List list, boolean z) {
        return this.d.b(list, b(z));
    }

    public c94 b(boolean z) {
        c94 c94Var = this.a;
        if (c94Var == null) {
            return null;
        }
        return z ? c94Var.b() : c94Var;
    }

    public int c() {
        return this.b;
    }

    public Rect d(c94 c94Var) {
        return this.d.d(c94Var, this.a);
    }

    public void e(qg3 qg3Var) {
        this.d = qg3Var;
    }
}
