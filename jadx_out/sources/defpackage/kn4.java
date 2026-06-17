package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class kn4 {
    public static final qj4 a = new qj4("NO_THREAD_ELEMENTS");
    public static final Function2 b = new Function2() { // from class: hn4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return kn4.b(obj, (g40.b) obj2);
        }
    };
    public static final Function2 c = new Function2() { // from class: in4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return kn4.a((fn4) obj, (g40.b) obj2);
        }
    };
    public static final Function2 d = new Function2() { // from class: jn4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return kn4.c((tn4) obj, (g40.b) obj2);
        }
    };

    public static fn4 a(fn4 fn4Var, g40.b bVar) {
        if (fn4Var != null) {
            return fn4Var;
        }
        if (bVar instanceof fn4) {
            return (fn4) bVar;
        }
        return null;
    }

    public static Object b(Object obj, g40.b bVar) {
        if (!(bVar instanceof fn4)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
    }

    public static tn4 c(tn4 tn4Var, g40.b bVar) {
        if (bVar instanceof fn4) {
            fn4 fn4Var = (fn4) bVar;
            tn4Var.a(fn4Var, fn4Var.W(tn4Var.a));
        }
        return tn4Var;
    }

    public static final void d(g40 g40Var, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof tn4) {
            ((tn4) obj).b(g40Var);
            return;
        }
        Object objT = g40Var.T(null, c);
        objT.getClass();
        ((fn4) objT).S(g40Var, obj);
    }

    public static final Object e(g40 g40Var) {
        Object objT = g40Var.T(0, b);
        objT.getClass();
        return objT;
    }

    public static final Object f(g40 g40Var, Object obj) {
        if (obj == null) {
            obj = e(g40Var);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return g40Var.T(new tn4(g40Var, ((Number) obj).intValue()), d);
        }
        obj.getClass();
        return ((fn4) obj).W(g40Var);
    }
}
