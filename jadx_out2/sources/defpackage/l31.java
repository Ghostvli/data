package defpackage;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l31 {
    public static final int a = pk4.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends oj4 implements Function3 {
        public int f;
        public /* synthetic */ Object g;
        public /* synthetic */ Object h;
        public final /* synthetic */ Function2 i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function2 function2, f30 f30Var) {
            super(3, f30Var);
            this.i = function2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(a31 a31Var, Object obj, f30 f30Var) {
            a aVar = new a(this.i, f30Var);
            aVar.g = a31Var;
            aVar.h = obj;
            return aVar.invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        
            if (r1.emit(r6, r5) == r0) goto L15;
         */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            a31 a31Var;
            Object objE = kl1.e();
            int i = this.f;
            if (i == 0) {
                lt3.b(obj);
                a31Var = (a31) this.g;
                Object obj2 = this.h;
                Function2 function2 = this.i;
                this.g = a31Var;
                this.f = 1;
                obj = function2.invoke(obj2, this);
                if (obj != objE) {
                }
                return objE;
            }
            if (i != 1) {
                if (i == 2) {
                    lt3.b(obj);
                    return fw4.a;
                }
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a31Var = (a31) this.g;
            lt3.b(obj);
            this.g = null;
            this.f = 2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final z21 a(z21 z21Var, Function2 function2) {
        return c31.m(z21Var, new a(function2, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final z21 b(z21 z21Var, Function3 function3) {
        return new xr(function3, z21Var, null, 0, null, 28, null);
    }
}
