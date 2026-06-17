package defpackage;

import defpackage.g40;
import defpackage.kt3;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cw3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ Function2 h;

        /* JADX INFO: renamed from: cw3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0074a extends oj4 implements Function2 {
            public int f;
            public /* synthetic */ Object g;
            public final /* synthetic */ tx h;
            public final /* synthetic */ Function2 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0074a(tx txVar, Function2 function2, f30 f30Var) {
                super(2, f30Var);
                this.h = txVar;
                this.i = function2;
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                C0074a c0074a = new C0074a(this.h, this.i, f30Var);
                c0074a.g = obj;
                return c0074a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(u40 u40Var, f30 f30Var) {
                return ((C0074a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
            }

            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) throws Throwable {
                tx txVar;
                Object objB;
                Object objE = kl1.e();
                int i = this.f;
                if (i == 0) {
                    lt3.b(obj);
                    u40 u40Var = (u40) this.g;
                    tx txVar2 = this.h;
                    Function2 function2 = this.i;
                    try {
                        kt3.a aVar = kt3.g;
                        this.g = txVar2;
                        this.f = 1;
                        obj = function2.invoke(u40Var, this);
                        if (obj == objE) {
                            return objE;
                        }
                        txVar = txVar2;
                    } catch (Throwable th) {
                        th = th;
                        txVar = txVar2;
                        kt3.a aVar2 = kt3.g;
                        objB = kt3.b(lt3.a(th));
                    }
                } else {
                    if (i != 1) {
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    txVar = (tx) this.g;
                    try {
                        lt3.b(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        kt3.a aVar22 = kt3.g;
                        objB = kt3.b(lt3.a(th));
                    }
                }
                objB = kt3.b(obj);
                vx.c(txVar, objB);
                return fw4.a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class b extends oj4 implements Function2 {
            public int f;
            public final /* synthetic */ tx g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(tx txVar, f30 f30Var) {
                super(2, f30Var);
                this.g = txVar;
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                return new b(this.g, f30Var);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(u40 u40Var, f30 f30Var) {
                return ((b) create(u40Var, f30Var)).invokeSuspend(fw4.a);
            }

            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kl1.e();
                int i = this.f;
                if (i != 0) {
                    if (i == 1) {
                        lt3.b(obj);
                        return obj;
                    }
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
                tx txVar = this.g;
                this.f = 1;
                Object objO = txVar.O(this);
                return objO == objE ? objE : objO;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function2 function2, f30 f30Var) {
            super(2, f30Var);
            this.h = function2;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            a aVar = new a(this.h, f30Var);
            aVar.g = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            kl1.e();
            if (this.f != 0) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
            g40.b bVarA = ((u40) this.g).g().a(h30.b);
            bVarA.getClass();
            h30 h30Var = (h30) bVarA;
            tx txVarB = vx.b(null, 1, null);
            bm.a(va1.f, h30Var, y40.i, new C0074a(txVarB, this.h, null));
            while (!txVarB.U()) {
                try {
                    return bm.c(h30Var, new b(txVarB, null));
                } catch (InterruptedException unused) {
                }
            }
            return txVarB.l();
        }
    }

    public static final Object a(Function2 function2) {
        function2.getClass();
        Thread.interrupted();
        return cm.b(null, new a(function2, null), 1, null);
    }
}
