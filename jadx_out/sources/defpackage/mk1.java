package defpackage;

import android.view.View;
import defpackage.r95;
import defpackage.w95;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mk1 extends r95.b {
    public final View c;
    public int d;
    public int e;
    public final int[] f;

    public mk1(View view) {
        super(0);
        this.f = new int[2];
        this.c = view;
    }

    @Override // r95.b
    public void b(r95 r95Var) {
        this.c.setTranslationY(0.0f);
    }

    @Override // r95.b
    public void c(r95 r95Var) {
        this.c.getLocationOnScreen(this.f);
        this.d = this.f[1];
    }

    @Override // r95.b
    public w95 d(w95 w95Var, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((r95) it.next()).d() & w95.n.a()) != 0) {
                this.c.setTranslationY(k7.c(this.e, 0, r0.c()));
                break;
            }
        }
        return w95Var;
    }

    @Override // r95.b
    public r95.a e(r95 r95Var, r95.a aVar) {
        this.c.getLocationOnScreen(this.f);
        int i = this.d - this.f[1];
        this.e = i;
        this.c.setTranslationY(i);
        return aVar;
    }
}
