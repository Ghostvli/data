package defpackage;

import defpackage.no0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jj1 {
    public kj1 a;
    public final List b = new ArrayList();

    public jj1(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.b.add(new no0.a());
        }
    }

    public abstract void a();

    public float b(int i, int i2, int i3) {
        return r62.a((i - i2) / i3, 0.0f, 1.0f);
    }

    public abstract void c();

    public abstract void d(h6 h6Var);

    public void e(kj1 kj1Var) {
        this.a = kj1Var;
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();
}
