package defpackage;

import defpackage.kw2;
import defpackage.vi1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bj1 extends vi1 implements kw2 {
    public transient xi1 g;
    public transient dj1 h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends pw4 {
        public int f;
        public Object g;
        public final /* synthetic */ Iterator h;
        public final /* synthetic */ bj1 i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(bj1 bj1Var, Iterator it) {
            this.h = it;
            this.i = bj1Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f > 0 || this.h.hasNext();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public Object next() {
            if (this.f <= 0) {
                kw2.a aVar = (kw2.a) this.h.next();
                this.g = aVar.a();
                this.f = aVar.getCount();
            }
            this.f--;
            Object obj = this.g;
            Objects.requireNonNull(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends vi1.b {
        public s43 a;
        public boolean b = false;
        public boolean c = false;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i) {
            this.a = s43.b(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static s43 h(Iterable iterable) {
            if (iterable instanceof aq3) {
                return ((aq3) iterable).i;
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)Lvi1$b; */
        @Override // vi1.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a(Object obj) {
            return f(obj, 1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e(Iterable iterable) {
            Objects.requireNonNull(this.a);
            if (!(iterable instanceof kw2)) {
                super.b(iterable);
                return this;
            }
            kw2 kw2Var = (kw2) iterable;
            s43 s43VarH = h(kw2Var);
            if (s43VarH != null) {
                s43 s43Var = this.a;
                s43Var.c(Math.max(s43Var.v(), s43VarH.v()));
                for (int iD = s43VarH.d(); iD >= 0; iD = s43VarH.q(iD)) {
                    f(s43VarH.h(iD), s43VarH.j(iD));
                }
            } else {
                Set setEntrySet = kw2Var.entrySet();
                s43 s43Var2 = this.a;
                s43Var2.c(Math.max(s43Var2.v(), setEntrySet.size()));
                for (kw2.a aVar : kw2Var.entrySet()) {
                    f(aVar.a(), aVar.getCount());
                }
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b f(Object obj, int i) {
            Objects.requireNonNull(this.a);
            if (i == 0) {
                return this;
            }
            if (this.b) {
                this.a = new s43(this.a);
                this.c = false;
            }
            this.b = false;
            gg3.q(obj);
            s43 s43Var = this.a;
            s43Var.r(obj, i + s43Var.e(obj));
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public bj1 g() {
            Objects.requireNonNull(this.a);
            if (this.a.v() == 0) {
                return bj1.p();
            }
            if (this.c) {
                this.a = new s43(this.a);
                this.c = false;
            }
            this.b = true;
            return new aq3(this.a);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bj1 k(Iterable iterable) {
        if (iterable instanceof bj1) {
            bj1 bj1Var = (bj1) iterable;
            if (!bj1Var.g()) {
                return bj1Var;
            }
        }
        b bVar = new b(lw2.b(iterable));
        bVar.e(iterable);
        return bVar.g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bj1 p() {
        return aq3.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vi1
    public xi1 b() {
        xi1 xi1Var = this.g;
        if (xi1Var != null) {
            return xi1Var;
        }
        xi1 xi1VarB = super.b();
        this.g = xi1VarB;
        return xi1VarB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vi1
    public int c(Object[] objArr, int i) {
        pw4 it = entrySet().iterator();
        while (it.hasNext()) {
            kw2.a aVar = (kw2.a) it.next();
            Arrays.fill(objArr, i, aVar.getCount() + i, aVar.a());
            i += aVar.getCount();
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return t(obj) > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return lw2.a(this, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Collection
    public int hashCode() {
        return m24.d(entrySet());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: iterator()Ljava/util/Iterator; */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: j */
    public pw4 iterator() {
        return new a(this, entrySet().iterator());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final dj1 l() {
        return isEmpty() ? dj1.u() : new c(this, null);
    }

    /* JADX INFO: renamed from: m */
    public abstract dj1 i();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: entrySet()Ljava/util/Set; */
    @Override // defpackage.kw2
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public dj1 entrySet() {
        dj1 dj1Var = this.h;
        if (dj1Var != null) {
            return dj1Var;
        }
        dj1 dj1VarL = l();
        this.h = dj1VarL;
        return dj1VarL;
    }

    public abstract kw2.a o(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c extends oj1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: get(I)Ljava/lang/Object; */
        @Override // defpackage.oj1
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public kw2.a get(int i) {
            return bj1.this.o(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof kw2.a) {
                kw2.a aVar = (kw2.a) obj;
                if (aVar.getCount() > 0 && bj1.this.t(aVar.a()) == aVar.getCount()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1
        public boolean g() {
            return bj1.this.g();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.dj1, java.util.Collection, java.util.Set
        public int hashCode() {
            return bj1.this.hashCode();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return bj1.this.i().size();
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 bj1) A[MD:(bj1):void (m)] (LINE:7) call: bj1.c.<init>(bj1):void type: THIS */
        public /* synthetic */ c(bj1 bj1Var, a aVar) {
            this();
        }
    }
}
