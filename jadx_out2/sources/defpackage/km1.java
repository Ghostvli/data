package defpackage;

import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class km1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean a(Iterable iterable, ig3 ig3Var) {
        return lm1.b(iterable.iterator(), ig3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Collection b(Iterable iterable) {
        return iterable instanceof Collection ? (Collection) iterable : ru1.g(iterable.iterator());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object c(Iterable iterable, Object obj) {
        return lm1.m(iterable.iterator(), obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object d(Iterable iterable) {
        if (!(iterable instanceof List)) {
            return iterable instanceof SortedSet ? ((SortedSet) iterable).last() : lm1.k(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return f(list);
        }
        bo.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object e(Iterable iterable, Object obj) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return obj;
            }
            if (iterable instanceof List) {
                return f((List) iterable);
            }
            if (iterable instanceof SortedSet) {
                return ((SortedSet) iterable).last();
            }
        }
        return lm1.l(iterable.iterator(), obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object f(List list) {
        return list.get(list.size() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object g(Iterable iterable) {
        return lm1.n(iterable.iterator());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean h(Iterable iterable, ig3 ig3Var) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? i((List) iterable, (ig3) gg3.q(ig3Var)) : lm1.s(iterable.iterator(), ig3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(List list, ig3 ig3Var) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!ig3Var.apply(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException unused) {
                        j(list, ig3Var, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        j(list, ig3Var, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void j(List list, ig3 ig3Var, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (ig3Var.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            list.remove(i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object[] k(Iterable iterable) {
        return b(iterable).toArray();
    }
}
