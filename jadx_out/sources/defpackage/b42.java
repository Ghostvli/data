package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class b42 {
    public static final b42 a;
    public static final z32 b;

    static {
        b42 b42Var = new b42();
        a = b42Var;
        pk4.f("kotlinx.coroutines.fast.service.loader", true);
        b = b42Var.a();
    }

    public final z32 a() throws Throwable {
        Object next;
        z32 z32VarE;
        try {
            List listN = p14.n(n14.d(ServiceLoader.load(a42.class, a42.class.getClassLoader()).iterator()));
            Iterator it = listN.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((a42) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((a42) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            a42 a42Var = (a42) next;
            if (a42Var != null && (z32VarE = c42.e(a42Var, listN)) != null) {
                return z32VarE;
            }
            c42.b(null, null, 3, null);
            return null;
        } catch (Throwable th) {
            c42.b(th, null, 2, null);
            return null;
        }
    }
}
