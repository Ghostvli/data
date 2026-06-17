package defpackage;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b45 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends gt3 implements Function2 {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ View h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, f30 f30Var) {
            super(2, f30Var);
            this.h = view;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            a aVar = new a(this.h, f30Var);
            aVar.g = obj;
            return aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(h14 h14Var, f30 f30Var) {
            return ((a) create(h14Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        
            if (r1.c(r6, r5) == r0) goto L17;
         */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            h14 h14Var;
            Object objE = kl1.e();
            int i = this.f;
            if (i == 0) {
                lt3.b(obj);
                h14Var = (h14) this.g;
                View view = this.h;
                this.g = h14Var;
                this.f = 1;
                if (h14Var.b(view, this) != objE) {
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
            h14Var = (h14) this.g;
            lt3.b(obj);
            View view2 = this.h;
            if (view2 instanceof ViewGroup) {
                f14 f14VarB = y35.b((ViewGroup) view2);
                this.g = null;
                this.f = 2;
            }
            return fw4.a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final f14 a(View view) {
        return k14.b(new a(view, null));
    }
}
