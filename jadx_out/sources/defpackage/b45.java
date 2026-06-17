package defpackage;

import android.view.View;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b45 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends gt3 implements Function2 {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ View h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, f30 f30Var) {
            super(2, f30Var);
            this.h = view;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            a aVar = new a(this.h, f30Var);
            aVar.g = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(h14 h14Var, f30 f30Var) {
            return ((a) create(h14Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        
            if (r1.c(r6, r5) == r0) goto L17;
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
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L21
                if (r1 == r4) goto L19
                if (r1 != r3) goto L13
                defpackage.lt3.b(r6)
                goto L4d
            L13:
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                defpackage.e04.a(r5)
                return r2
            L19:
                java.lang.Object r1 = r5.g
                h14 r1 = (defpackage.h14) r1
                defpackage.lt3.b(r6)
                goto L36
            L21:
                defpackage.lt3.b(r6)
                java.lang.Object r6 = r5.g
                r1 = r6
                h14 r1 = (defpackage.h14) r1
                android.view.View r6 = r5.h
                r5.g = r1
                r5.f = r4
                java.lang.Object r6 = r1.b(r6, r5)
                if (r6 != r0) goto L36
                goto L4c
            L36:
                android.view.View r6 = r5.h
                boolean r4 = r6 instanceof android.view.ViewGroup
                if (r4 == 0) goto L4d
                android.view.ViewGroup r6 = (android.view.ViewGroup) r6
                f14 r6 = defpackage.y35.b(r6)
                r5.g = r2
                r5.f = r3
                java.lang.Object r5 = r1.c(r6, r5)
                if (r5 != r0) goto L4d
            L4c:
                return r0
            L4d:
                fw4 r5 = defpackage.fw4.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: b45.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final f14 a(View view) {
        return k14.b(new a(view, null));
    }
}
