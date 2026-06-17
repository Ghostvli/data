package defpackage;

import defpackage.di1;
import j$.util.stream.DesugarCollectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ba3 {
    public static /* synthetic */ di1 a(String str, ko1 ko1Var) {
        return new di1(str + ko1Var.o("path"), -1, ko1Var.i("width", -1), di1.a.UNKNOWN);
    }

    public static /* synthetic */ boolean b(ko1 ko1Var) {
        return !yy4.n(ko1Var.o("path"));
    }

    public static List c(String str, ko1 ko1Var) {
        return e(str, ko1Var, "avatars", "avatar");
    }

    public static List d(final String str, eo1 eo1Var) {
        return (List) eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: z93
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ba3.b((ko1) obj);
            }
        }).map(new Function() { // from class: aa3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ba3.a(str, (ko1) obj);
            }
        }).collect(DesugarCollectors.toUnmodifiableList());
    }

    public static List e(String str, ko1 ko1Var, String str2, String str3) {
        eo1 eo1VarB = ko1Var.b(str2);
        if (!yy4.o(eo1VarB)) {
            return d(str, eo1VarB);
        }
        ko1 ko1VarM = ko1Var.m(str3);
        String strO = ko1VarM.o("path");
        if (yy4.n(strO)) {
            return Collections.EMPTY_LIST;
        }
        return av4.a(new Object[]{new di1(str + strO, -1, ko1VarM.i("width", -1), di1.a.UNKNOWN)});
    }

    public static List f(String str, ko1 ko1Var) {
        ArrayList arrayList = new ArrayList(2);
        String strO = ko1Var.o("thumbnailPath");
        if (!yy4.n(strO)) {
            arrayList.add(new di1(str + strO, -1, -1, di1.a.LOW));
        }
        String strO2 = ko1Var.o("previewPath");
        if (!yy4.n(strO2)) {
            arrayList.add(new di1(str + strO2, -1, -1, di1.a.MEDIUM));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void g(ko1 ko1Var) {
        String strO = ko1Var.o("error");
        if (!yy4.l(strO)) {
            throw new x20(strO);
        }
    }
}
