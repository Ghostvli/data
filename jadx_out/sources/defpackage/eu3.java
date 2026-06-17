package defpackage;

import defpackage.g40;
import defpackage.kt3;
import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class eu3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Runnable {
        public final /* synthetic */ qp f;
        public final /* synthetic */ bu3 g;
        public final /* synthetic */ Function2 h;

        /* JADX INFO: renamed from: eu3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0079a extends oj4 implements Function2 {
            public int f;
            public /* synthetic */ Object g;
            public final /* synthetic */ bu3 h;
            public final /* synthetic */ qp i;
            public final /* synthetic */ Function2 j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0079a(bu3 bu3Var, qp qpVar, Function2 function2, f30 f30Var) {
                super(2, f30Var);
                this.h = bu3Var;
                this.i = qpVar;
                this.j = function2;
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                C0079a c0079a = new C0079a(this.h, this.i, this.j, f30Var);
                c0079a.g = obj;
                return c0079a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(u40 u40Var, f30 f30Var) {
                return ((C0079a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
            }

            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) throws Throwable {
                f30 f30Var;
                Object objE = kl1.e();
                int i = this.f;
                if (i == 0) {
                    lt3.b(obj);
                    g40.b bVarA = ((u40) this.g).g().a(h30.b);
                    bVarA.getClass();
                    g40 g40VarC = eu3.c(this.h, (h30) bVarA);
                    qp qpVar = this.i;
                    kt3.a aVar = kt3.g;
                    Function2 function2 = this.j;
                    this.g = qpVar;
                    this.f = 1;
                    obj = bm.e(g40VarC, function2, this);
                    if (obj == objE) {
                        return objE;
                    }
                    f30Var = qpVar;
                } else {
                    if (i != 1) {
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    f30Var = (f30) this.g;
                    lt3.b(obj);
                }
                f30Var.resumeWith(kt3.b(obj));
                return fw4.a;
            }
        }

        public a(qp qpVar, bu3 bu3Var, Function2 function2) {
            this.f = qpVar;
            this.g = bu3Var;
            this.h = function2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                bm.c(this.f.getContext().B(h30.b), new C0079a(this.g, this.f, this.h, null));
            } catch (Throwable th) {
                this.f.j(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ Function1 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function1 function1, f30 f30Var) {
            super(2, f30Var);
            this.h = function1;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            b bVar = new b(this.h, f30Var);
            bVar.g = obj;
            return bVar;
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
            if (((u40) this.g).g().a(zr4.g) == null) {
                e04.a("Expected a TransactionElement in the CoroutineContext but none was found.");
                return null;
            }
            Function1 function1 = this.h;
            this.f = 1;
            Object objInvoke = function1.invoke(this);
            return objInvoke == objE ? objE : objInvoke;
        }
    }

    public static final Object b(bu3 bu3Var, Function1 function1, f30 f30Var) {
        return (bu3Var.z() && bu3Var.E() && bu3Var.A()) ? function1.invoke(f30Var) : f30Var.getContext().a(fu3.f) == null ? function1.invoke(f30Var) : cu3.e(bu3Var, function1, f30Var);
    }

    public static final g40 c(bu3 bu3Var, h30 h30Var) {
        g40 g40VarN = h30Var.N(new zr4(h30Var));
        return g40VarN.N(gn4.a(bu3Var.w(), g40VarN));
    }

    public static final Object d(bu3 bu3Var, Function2 function2, f30 f30Var) {
        sp spVar = new sp(jl1.c(f30Var), 1);
        spVar.E();
        try {
            bu3Var.x().execute(new a(spVar, bu3Var, function2));
        } catch (RejectedExecutionException e) {
            spVar.j(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object objY = spVar.y();
        if (objY == kl1.e()) {
            ta0.c(f30Var);
        }
        return objY;
    }

    public static final Object e(bu3 bu3Var, Function1 function1, f30 f30Var) {
        b bVar = new b(function1, null);
        zr4 zr4Var = (zr4) f30Var.getContext().a(zr4.g);
        h30 h30VarB = zr4Var != null ? zr4Var.b() : null;
        return h30VarB != null ? bm.e(h30VarB, bVar, f30Var) : d(bu3Var, bVar, f30Var);
    }
}
