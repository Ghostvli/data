package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xo1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static eo1 a(ko1 ko1Var, String str) {
        return (eo1) c(ko1Var, str, eo1.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Boolean b(ko1 ko1Var, String str) {
        return (Boolean) c(ko1Var, str, Boolean.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object c(ko1 ko1Var, String str, Class cls) throws s83 {
        Object objJ = j(ko1Var, str);
        if (cls.isInstance(objJ)) {
            return cls.cast(objJ);
        }
        to1.a("Wrong data type at path ", str);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 d(String str, String str2) {
        return (ko1) lo1.d().a(cp1.a(str).w0(str2).j(str2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Number e(ko1 ko1Var, String str) {
        return (Number) c(ko1Var, str, Number.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 f(ko1 ko1Var, String str) {
        return (ko1) c(ko1Var, str, ko1.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 g(ko1 ko1Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext() && (ko1Var = ko1Var.m((String) it.next())) != null) {
        }
        return ko1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String h(ko1 ko1Var, String str) {
        return (String) c(ko1Var, str, String.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List i(eo1 eo1Var) {
        final Class<String> cls = String.class;
        return (List) eo1Var.stream().filter(new co1(String.class)).map(new Function() { // from class: vo1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) cls.cast(obj);
            }
        }).collect(Collectors.toList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object j(ko1 ko1Var, String str) throws s83 {
        List listAsList = Arrays.asList(str.split("\\."));
        ko1 ko1VarG = g(ko1Var, listAsList.subList(0, listAsList.size() - 1));
        if (ko1VarG == null) {
            throw new s83("Unable to get ".concat(str));
        }
        V v = ko1VarG.get(listAsList.get(listAsList.size() - 1));
        if (v != 0) {
            return v;
        }
        throw new s83("Unable to get ".concat(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 k(String str) throws s83 {
        try {
            return (ko1) lo1.d().a(str);
        } catch (mo1 e) {
            uo1.a("Could not parse JSON", e);
            return null;
        }
    }
}
