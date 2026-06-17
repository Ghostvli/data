package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class kx extends su0 {
    public final ArrayList a;
    public final List b;
    public int c;
    public int d;
    public boolean e;

    public kx() {
        this.c = 0;
        this.d = 0;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    @Override // defpackage.su0
    public int e() {
        return this.d;
    }

    @Override // defpackage.su0
    public void i() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((su0) it.next()).i();
        }
        super.i();
    }

    @Override // defpackage.su0
    public boolean j() {
        return this.e;
    }

    public void k(su0 su0Var) {
        this.a.add(su0Var);
        l();
    }

    public void l() {
        this.c = this.a.size();
        this.d = 0;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            this.d += ((su0) it.next()).e();
        }
        this.b.clear();
        this.b.addAll(this.a);
        this.b.sort(Comparator.comparingInt(new ToIntFunction() { // from class: jx
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((su0) obj).e();
            }
        }));
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            if (((su0) it2.next()).j()) {
                this.e = true;
                return;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends kx {
        public a(su0... su0VarArr) {
            this(Arrays.asList(su0VarArr));
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            for (int i = 0; i < this.c; i++) {
                if (!((su0) this.b.get(i)).f(br0Var, br0Var2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // defpackage.su0
        public boolean g(br0 br0Var, ms1 ms1Var) {
            for (int i = 0; i < this.c; i++) {
                if (!((su0) this.b.get(i)).g(br0Var, ms1Var)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return fg4.p(this.a, "");
        }

        public a(Collection collection) {
            super(collection);
        }
    }

    public kx(Collection collection) {
        this();
        this.a.addAll(collection);
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends kx {
        public b(Collection collection) {
            int i = this.c;
            ArrayList arrayList = this.a;
            if (i > 1) {
                arrayList.add(new a(collection));
            } else {
                arrayList.addAll(collection);
            }
            l();
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            for (int i = 0; i < this.c; i++) {
                if (((su0) this.b.get(i)).f(br0Var, br0Var2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.su0
        public boolean g(br0 br0Var, ms1 ms1Var) {
            for (int i = 0; i < this.c; i++) {
                if (((su0) this.b.get(i)).g(br0Var, ms1Var)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return fg4.p(this.a, ", ");
        }

        public b(su0... su0VarArr) {
            this(Arrays.asList(su0VarArr));
        }
    }
}
