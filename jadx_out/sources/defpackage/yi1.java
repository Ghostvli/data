package defpackage;

import defpackage.aj1;
import defpackage.xi1;
import defpackage.zi1;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yi1 extends aj1 implements hu1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends aj1.c {
        public yi1 e() {
            return (yi1) super.a();
        }

        public a f(Object obj, Object obj2) {
            super.d(obj, obj2);
            return this;
        }
    }

    public yi1(zi1 zi1Var, int i) {
        super(zi1Var, i);
    }

    public static a t() {
        return new a();
    }

    public static yi1 u(Collection collection, Comparator comparator) {
        if (collection.isEmpty()) {
            return w();
        }
        zi1.a aVar = new zi1.a(collection.size());
        Iterator it = collection.iterator();
        int size = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            xi1.a aVar2 = (xi1.a) entry.getValue();
            xi1 xi1VarK = comparator == null ? aVar2.k() : aVar2.l(comparator);
            aVar.g(key, xi1VarK);
            size += xi1VarK.size();
        }
        return new yi1(aVar.d(), size);
    }

    public static yi1 w() {
        return cs0.l;
    }

    public static yi1 x(Object obj, Object obj2) {
        a aVarT = t();
        aVarT.f(obj, obj2);
        return aVarT.e();
    }

    @Override // defpackage.dw2
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public xi1 get(Object obj) {
        xi1 xi1Var = (xi1) this.j.get(obj);
        return xi1Var == null ? xi1.u() : xi1Var;
    }
}
