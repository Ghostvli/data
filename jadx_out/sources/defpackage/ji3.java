package defpackage;

import android.graphics.RectF;
import defpackage.jk4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ji3 implements jk4.c {
    public final ArrayList a = new ArrayList();
    public final jk4 b;
    public lk1 c;
    public lk1 d;
    public int e;
    public boolean f;

    public ji3(jk4 jk4Var, List list) {
        lk1 lk1Var = lk1.e;
        this.c = lk1Var;
        this.d = lk1Var;
        f(list, false);
        f(list, true);
        jk4Var.g(this);
        this.b = jk4Var;
    }

    @Override // jk4.c
    public void a(int i, lk1 lk1Var, RectF rectF) {
        int size = this.a.size() - 1;
        if (size < 0) {
            return;
        }
        w82.a(this.a.get(size));
        throw null;
    }

    @Override // jk4.c
    public void b(lk1 lk1Var, lk1 lk1Var2) {
        this.c = lk1Var;
        this.d = lk1Var2;
        j();
    }

    @Override // jk4.c
    public void c() {
        this.e++;
    }

    @Override // jk4.c
    public void d() {
        int i = this.e;
        boolean z = i > 0;
        int i2 = i - 1;
        this.e = i2;
        if (z && i2 == 0) {
            j();
        }
    }

    @Override // jk4.c
    public void e(int i) {
        int size = this.a.size() - 1;
        if (size < 0) {
            return;
        }
        w82.a(this.a.get(size));
        throw null;
    }

    public final void f(List list, boolean z) {
        if (list.size() <= 0) {
            return;
        }
        w82.a(list.get(0));
        throw null;
    }

    public void g() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.b.l(this);
        int size = this.a.size() - 1;
        ArrayList arrayList = this.a;
        if (size < 0) {
            arrayList.clear();
        } else {
            w82.a(arrayList.get(size));
            throw null;
        }
    }

    public ii3 h(int i) {
        w82.a(this.a.get(i));
        return null;
    }

    public int i() {
        return this.a.size();
    }

    public final void j() {
        lk1 lk1Var = lk1.e;
        int size = this.a.size() - 1;
        if (size < 0) {
            return;
        }
        w82.a(this.a.get(size));
        throw null;
    }
}
