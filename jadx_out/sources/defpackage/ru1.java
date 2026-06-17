package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ru1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends AbstractList implements RandomAccess, Serializable {
        public final List f;
        public final p81 g;

        /* JADX INFO: renamed from: ru1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0119a extends qs4 {
            public C0119a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // defpackage.ps4
            public Object b(Object obj) {
                return a.this.g.apply(obj);
            }
        }

        public a(List list, p81 p81Var) {
            this.f = (List) gg3.q(list);
            this.g = (p81) gg3.q(p81Var);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return this.g.apply(this.f.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            return new C0119a(this.f.listIterator(i));
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            return this.g.apply(this.f.remove(i));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i, int i2) {
            this.f.subList(i, i2).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends AbstractSequentialList implements Serializable {
        public final List f;
        public final p81 g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends qs4 {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // defpackage.ps4
            public Object b(Object obj) {
                return b.this.g.apply(obj);
            }
        }

        public b(List list, p81 p81Var) {
            this.f = (List) gg3.q(list);
            this.g = (p81) gg3.q(p81Var);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f.isEmpty();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            return new a(this.f.listIterator(i));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i, int i2) {
            this.f.subList(i, i2).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f.size();
        }
    }

    public static int a(int i) {
        jw.b(i, "arraySize");
        return ll1.m(((long) i) + 5 + ((long) (i / 10)));
    }

    public static boolean b(List list, Object obj) {
        if (obj == gg3.q(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return lm1.e(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int c(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return d(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equals(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int d(List list, Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int e(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equals(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int f(List list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static ArrayList g(Iterator it) {
        ArrayList arrayList = new ArrayList();
        lm1.a(arrayList, it);
        return arrayList;
    }

    public static ArrayList h(Object... objArr) {
        gg3.q(objArr);
        ArrayList arrayList = new ArrayList(a(objArr.length));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    public static List i(List list, p81 p81Var) {
        return list instanceof RandomAccess ? new a(list, p81Var) : new b(list, p81Var);
    }
}
