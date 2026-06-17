package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t33 extends ArrayList {
    public t33() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l33 b() {
        if (isEmpty()) {
            return null;
        }
        return (l33) get(0);
    }

    public String c() {
        return (String) stream().map(new Function() { // from class: s33
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((l33) obj).H();
            }
        }).collect(fg4.s("\n"));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        e();
        super.clear();
    }

    public l33 d(int i) {
        l33 l33Var = (l33) super.remove(i);
        l33Var.Q();
        return l33Var;
    }

    public t33 e() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            ((l33) it.next()).Q();
        }
        return this;
    }

    public l33 f(int i, l33 l33Var) {
        zy4.j(l33Var);
        l33 l33Var2 = (l33) super.set(i, l33Var);
        l33Var2.U(l33Var);
        return l33Var2;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = super.indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        d(iIndexOf);
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate predicate) {
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.test((l33) it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator unaryOperator) {
        for (int i = 0; i < size(); i++) {
            f(i, (l33) unaryOperator.apply((l33) get(i)));
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains((l33) it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return c();
    }

    public t33(int i) {
        super(i);
    }
}
