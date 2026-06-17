package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tl4 implements zs1 {
    public final Set f = Collections.newSetFromMap(new WeakHashMap());

    @Override // defpackage.zs1
    public void b() {
        Iterator it = iy4.k(this.f).iterator();
        while (it.hasNext()) {
            ((rl4) it.next()).b();
        }
    }

    public void c() {
        this.f.clear();
    }

    public List e() {
        return iy4.k(this.f);
    }

    public void g(rl4 rl4Var) {
        this.f.add(rl4Var);
    }

    @Override // defpackage.zs1
    public void h() {
        Iterator it = iy4.k(this.f).iterator();
        while (it.hasNext()) {
            ((rl4) it.next()).h();
        }
    }

    public void n(rl4 rl4Var) {
        this.f.remove(rl4Var);
    }

    @Override // defpackage.zs1
    public void onStop() {
        Iterator it = iy4.k(this.f).iterator();
        while (it.hasNext()) {
            ((rl4) it.next()).onStop();
        }
    }
}
