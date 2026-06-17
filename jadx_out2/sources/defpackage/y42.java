package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y42 extends x42 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map h() {
        gs0 gs0Var = gs0.f;
        gs0Var.getClass();
        return gs0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object i(Map map, Object obj) {
        map.getClass();
        return w42.a(map, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map j(i73... i73VarArr) {
        i73VarArr.getClass();
        return i73VarArr.length > 0 ? r(i73VarArr, new LinkedHashMap(x42.e(i73VarArr.length))) : h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map k(i73... i73VarArr) {
        i73VarArr.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(x42.e(i73VarArr.length));
        n(linkedHashMap, i73VarArr);
        return linkedHashMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Map l(Map map) {
        map.getClass();
        int size = map.size();
        return size != 0 ? size != 1 ? map : x42.g(map) : h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void m(Map map, Iterable iterable) {
        map.getClass();
        iterable.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            i73 i73Var = (i73) it.next();
            map.put(i73Var.a(), i73Var.b());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void n(Map map, i73[] i73VarArr) {
        map.getClass();
        i73VarArr.getClass();
        for (i73 i73Var : i73VarArr) {
            map.put(i73Var.a(), i73Var.b());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map o(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return l(p(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return p(iterable, new LinkedHashMap(x42.e(collection.size())));
        }
        return x42.f((i73) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Map p(Iterable iterable, Map map) {
        iterable.getClass();
        map.getClass();
        m(map, iterable);
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map q(Map map) {
        map.getClass();
        int size = map.size();
        return size != 0 ? size != 1 ? s(map) : x42.g(map) : h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Map r(i73[] i73VarArr, Map map) {
        i73VarArr.getClass();
        map.getClass();
        n(map, i73VarArr);
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map s(Map map) {
        map.getClass();
        return new LinkedHashMap(map);
    }
}
