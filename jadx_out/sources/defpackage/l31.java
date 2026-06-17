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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function2 function2, f30 f30Var) {
            super(3, f30Var);
            this.i = function2;
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(a31 a31Var, Object obj, f30 f30Var) {
            a aVar = new a(this.i, f30Var);
            aVar.g = a31Var;
            aVar.h = obj;
            return aVar.invokeSuspend(fw4.a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        
            if (r1.emit(r6, r5) == r0) goto L15;
         */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = defpackage.kl1.e()
                int r1 = r5.f
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L21
                if (r1 == r3) goto L19
                if (r1 != r2) goto L12
                defpackage.lt3.b(r6)
                goto L44
            L12:
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                defpackage.e04.a(r5)
                r5 = 0
                return r5
            L19:
                java.lang.Object r1 = r5.g
                a31 r1 = (defpackage.a31) r1
                defpackage.lt3.b(r6)
                goto L38
            L21:
                defpackage.lt3.b(r6)
                java.lang.Object r6 = r5.g
                r1 = r6
                a31 r1 = (defpackage.a31) r1
                java.lang.Object r6 = r5.h
                kotlin.jvm.functions.Function2 r4 = r5.i
                r5.g = r1
                r5.f = r3
                java.lang.Object r6 = r4.invoke(r6, r5)
                if (r6 != r0) goto L38
                goto L43
            L38:
                r3 = 0
                r5.g = r3
                r5.f = r2
                java.lang.Object r5 = r1.emit(r6, r5)
                if (r5 != r0) goto L44
            L43:
                return r0
            L44:
                fw4 r5 = defpackage.fw4.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: l31.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final z21 a(z21 z21Var, Function2 function2) {
        return c31.m(z21Var, new a(function2, null));
    }

    public static final z21 b(z21 z21Var, Function3 function3) {
        return new xr(function3, z21Var, null, 0, null, 28, null);
    }
}
