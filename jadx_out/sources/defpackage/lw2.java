package defpackage;

import defpackage.kw2;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lw2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a implements kw2.a {
        public boolean equals(Object obj) {
            if (obj instanceof kw2.a) {
                kw2.a aVar = (kw2.a) obj;
                if (getCount() == aVar.getCount() && Objects.equals(a(), aVar.a())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object objA = a();
            return getCount() ^ (objA == null ? 0 : objA.hashCode());
        }

        public String toString() {
            String strValueOf = String.valueOf(a());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    public static boolean a(kw2 kw2Var, Object obj) {
        if (obj == kw2Var) {
            return true;
        }
        if (obj instanceof kw2) {
            kw2 kw2Var2 = (kw2) obj;
            if (kw2Var.size() == kw2Var2.size() && kw2Var.entrySet().size() == kw2Var2.entrySet().size()) {
                for (kw2.a aVar : kw2Var2.entrySet()) {
                    if (kw2Var.t(aVar.a()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static int b(Iterable iterable) {
        if (iterable instanceof kw2) {
            return ((kw2) iterable).i().size();
        }
        return 11;
    }
}
