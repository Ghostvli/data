package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xj1 implements yw {
    public final List a;
    public final List b;
    public final int c;
    public final Comparator d;

    public xj1(int i, Comparator comparator) {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = i;
        this.d = comparator;
    }

    public void b(Exception exc) {
        this.b.add(exc);
    }

    public void c(vj1 vj1Var) {
        this.a.add(vj1Var);
    }

    public void d(wj1 wj1Var) {
        try {
            c((vj1) a(wj1Var));
        } catch (l51 unused) {
        } catch (s83 e) {
            b(e);
        }
    }

    public List e() {
        return Collections.unmodifiableList(this.b);
    }

    public List f() {
        Comparator comparator = this.d;
        if (comparator != null) {
            this.a.sort(comparator);
        }
        return Collections.unmodifiableList(this.a);
    }

    public int g() {
        return this.c;
    }

    public xj1(int i) {
        this(i, null);
    }
}
