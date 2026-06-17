package defpackage;

import defpackage.eh4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class eh4 extends su0 {
    public final su0 a;
    public boolean b;
    public final ThreadLocal c = new ea4(new Supplier() { // from class: bh4
        @Override // java.util.function.Supplier
        public final Object get() {
            return new WeakHashMap();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends eh4 {
        public a(su0 su0Var) {
            super(su0Var);
        }

        @Override // defpackage.su0
        public int e() {
            return this.a.e() * 8;
        }

        @Override // defpackage.eh4
        public boolean m(br0 br0Var, l33 l33Var) {
            if (br0Var == l33Var) {
                return false;
            }
            do {
                l33Var = l33Var.L();
                if (l33Var == null) {
                    break;
                }
                if (n(br0Var, l33Var)) {
                    return true;
                }
            } while (l33Var != br0Var);
            return false;
        }

        public String toString() {
            return String.format("%s ", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends eh4 {
        public static final fa4 e = new fa4(new Supplier() { // from class: fh4
            @Override // java.util.function.Supplier
            public final Object get() {
                return eh4.b.o();
            }
        });
        public final boolean d;

        public b(su0 su0Var) {
            super(su0Var);
            this.d = p(su0Var);
        }

        public static /* synthetic */ n33 o() {
            return new n33(new sm4(""), l33.class);
        }

        public static boolean p(su0 su0Var) {
            if (!(su0Var instanceof kx)) {
                return false;
            }
            for (su0 su0Var2 : ((kx) su0Var).a) {
                if ((su0Var2 instanceof g) || (su0Var2 instanceof d)) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.su0
        public int e() {
            return this.a.e() * 10;
        }

        @Override // defpackage.eh4, defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            if (this.d) {
                for (br0 br0VarV0 = br0Var2.v0(); br0VarV0 != null; br0VarV0 = br0VarV0.A()) {
                    if (br0VarV0 != br0Var2 && this.a.f(br0Var2, br0VarV0)) {
                        return true;
                    }
                }
            }
            n33 n33Var = (n33) e.b();
            n33Var.e(br0Var2);
            while (n33Var.hasNext()) {
                try {
                    l33 next = n33Var.next();
                    if (next != br0Var2 && this.a.h(br0Var2, next)) {
                        return true;
                    }
                } finally {
                    e.d(n33Var);
                }
            }
            e.d(n33Var);
            return false;
        }

        @Override // defpackage.eh4
        public boolean m(br0 br0Var, l33 l33Var) {
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends eh4 {
        public final ArrayList d;
        public int e;

        public c(su0 su0Var) {
            super(su0Var);
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            this.e = 2;
            arrayList.add(su0Var);
            this.e += su0Var.e();
        }

        @Override // defpackage.su0
        public int e() {
            return this.e;
        }

        @Override // defpackage.eh4, defpackage.su0
        public void i() {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((su0) it.next()).i();
            }
            super.i();
        }

        @Override // defpackage.eh4
        public boolean m(br0 br0Var, l33 l33Var) {
            if (l33Var == br0Var) {
                return false;
            }
            for (int size = this.d.size() - 1; size >= 0; size--) {
                if (l33Var == null || !((su0) this.d.get(size)).h(br0Var, l33Var)) {
                    return false;
                }
                l33Var = l33Var.L();
            }
            return true;
        }

        public void o(su0 su0Var) {
            this.d.add(su0Var);
            this.e += su0Var.e();
            this.b = su0Var.j() | this.b;
        }

        public String toString() {
            return fg4.p(this.d, " > ");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends eh4 {
        public d(su0 su0Var) {
            super(su0Var);
        }

        @Override // defpackage.su0
        public int e() {
            return this.a.e() + 2;
        }

        @Override // defpackage.eh4
        public boolean m(br0 br0Var, l33 l33Var) {
            if (br0Var == l33Var) {
                return false;
            }
            l33 l33VarP = this.b ? l33Var.P() : l33Var.O();
            return l33VarP != null && n(br0Var, l33VarP);
        }

        public String toString() {
            return String.format("%s + ", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends eh4 {
        public e(su0 su0Var) {
            super(su0Var);
        }

        @Override // defpackage.su0
        public int e() {
            return this.a.e() + 2;
        }

        @Override // defpackage.eh4
        public boolean m(br0 br0Var, l33 l33Var) {
            return this.a.h(br0Var, l33Var);
        }

        public String toString() {
            return String.format(":is(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f extends eh4 {
        public f(su0 su0Var) {
            super(su0Var);
        }

        @Override // defpackage.su0
        public int e() {
            return this.a.e() + 2;
        }

        @Override // defpackage.eh4
        public boolean m(br0 br0Var, l33 l33Var) {
            return !n(br0Var, l33Var);
        }

        public String toString() {
            return String.format(":not(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends eh4 {
        public g(su0 su0Var) {
            super(su0Var);
        }

        @Override // defpackage.su0
        public int e() {
            return this.a.e() * 3;
        }

        @Override // defpackage.eh4
        public boolean m(br0 br0Var, l33 l33Var) {
            if (br0Var == l33Var) {
                return false;
            }
            for (l33 l33VarU = l33Var.u(); l33VarU != null && l33VarU != l33Var; l33VarU = l33VarU.B()) {
                if (n(br0Var, l33VarU)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("%s ~ ", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h extends su0 {
        @Override // defpackage.su0
        public int e() {
            return 1;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var == br0Var2;
        }

        public String toString() {
            return ">";
        }
    }

    public eh4(su0 su0Var) {
        this.a = su0Var;
        this.b = su0Var.j();
    }

    public static /* synthetic */ Map l(l33 l33Var) {
        return new WeakHashMap();
    }

    @Override // defpackage.su0
    public boolean f(br0 br0Var, br0 br0Var2) {
        return m(br0Var, br0Var2);
    }

    @Override // defpackage.su0
    public boolean g(br0 br0Var, ms1 ms1Var) {
        return m(br0Var, ms1Var);
    }

    @Override // defpackage.su0
    public void i() {
        this.c.remove();
        this.a.i();
        super.i();
    }

    @Override // defpackage.su0
    public boolean j() {
        return this.b;
    }

    public abstract boolean m(br0 br0Var, l33 l33Var);

    public boolean n(final br0 br0Var, l33 l33Var) {
        return ((Boolean) ((Map) ((Map) this.c.get()).computeIfAbsent(br0Var, new Function() { // from class: ch4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return eh4.l((l33) obj);
            }
        })).computeIfAbsent(l33Var, new Function() { // from class: dh4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(this.a.a.h(br0Var, (l33) obj));
            }
        })).booleanValue();
    }
}
