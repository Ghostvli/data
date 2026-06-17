package defpackage;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n14 extends l14 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements f14 {
        public final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // defpackage.f14
        public Iterator iterator() {
            return this.a;
        }
    }

    public static f14 d(Iterator it) {
        it.getClass();
        return e(new a(it));
    }

    public static f14 e(f14 f14Var) {
        f14Var.getClass();
        return f14Var instanceof j10 ? f14Var : new j10(f14Var);
    }

    public static f14 f(final Object obj, Function1 function1) {
        function1.getClass();
        return obj == null ? js0.a : new k91(new Function0() { // from class: m14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return n14.g(obj);
            }
        }, function1);
    }

    public static final Object g(Object obj) {
        return obj;
    }
}
