package defpackage;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k14 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements f14 {
        public final /* synthetic */ Function2 a;

        public a(Function2 function2) {
            this.a = function2;
        }

        @Override // defpackage.f14
        public Iterator iterator() {
            return k14.a(this.a);
        }
    }

    public static final Iterator a(Function2 function2) {
        function2.getClass();
        g14 g14Var = new g14();
        g14Var.n(jl1.a(function2, g14Var, g14Var));
        return g14Var;
    }

    public static f14 b(Function2 function2) {
        function2.getClass();
        return new a(function2);
    }
}
