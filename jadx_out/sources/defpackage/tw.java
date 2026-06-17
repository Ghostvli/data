package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tw extends sw {
    public static Object A(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(ow.l(list));
    }

    public static boolean B(Iterable iterable, Function1 function1) {
        iterable.getClass();
        function1.getClass();
        return y(iterable, function1, false);
    }

    public static boolean w(Collection collection, Iterable iterable) {
        collection.getClass();
        iterable.getClass();
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean x(Collection collection, Object[] objArr) {
        collection.getClass();
        objArr.getClass();
        return collection.addAll(ta.c(objArr));
    }

    public static final boolean y(Iterable iterable, Function1 function1, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (((Boolean) function1.invoke(it.next())).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static Object z(List list) {
        list.getClass();
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(ow.l(list));
    }
}
