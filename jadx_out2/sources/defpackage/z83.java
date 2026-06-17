package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class z83 implements n00 {
    public final nw3 f;
    public final String g;
    public final Function2 h;
    public final cs1 i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends oj4 implements Function2 {
        public int f;
        public final /* synthetic */ Function2 g;
        public final /* synthetic */ x83 h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function2 function2, x83 x83Var, f30 f30Var) {
            super(2, f30Var);
            this.g = function2;
            this.h = x83Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new b(this.g, this.h, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((b) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
            Function2 function2 = this.g;
            x83 x83Var = this.h;
            this.f = 1;
            Object objInvoke = function2.invoke(x83Var, this);
            return objInvoke == objE ? objE : objInvoke;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z83(nw3 nw3Var, String str, Function2 function2) {
        nw3Var.getClass();
        str.getClass();
        this.f = nw3Var;
        this.g = str;
        this.h = function2;
        this.i = is1.b(new Function0() { // from class: y83
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z83.a(this.f);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lw3 a(z83 z83Var) {
        return z83Var.f.a(z83Var.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n00
    public Object X(boolean z, Function2 function2, f30 f30Var) {
        a aVar = (a) f30Var.getContext().a(a.g);
        x83 x83VarB = aVar != null ? aVar.b() : null;
        if (x83VarB != null) {
            return function2.invoke(x83VarB, f30Var);
        }
        x83 x83Var = new x83(this.h, (lw3) this.i.getValue());
        return bm.e(new a(x83Var), new b(function2, x83Var, null), f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n00, java.lang.AutoCloseable
    public void close() {
        if (this.i.isInitialized()) {
            ((lw3) this.i.getValue()).close();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements g40.b {
        public static final C0140a g = new C0140a(null);
        public final x83 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(x83 x83Var) {
            x83Var.getClass();
            this.f = x83Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.g40
        public g40 B(g40.c cVar) {
            return g40.b.a.c(this, cVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.g40
        public g40 N(g40 g40Var) {
            return g40.b.a.d(this, g40Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.g40
        public Object T(Object obj, Function2 function2) {
            return g40.b.a.a(this, obj, function2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // g40.b, defpackage.g40
        public g40.b a(g40.c cVar) {
            return g40.b.a.b(this, cVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final x83 b() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // g40.b
        public g40.c getKey() {
            return g;
        }

        /* JADX INFO: renamed from: z83$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0140a implements g40.c {
            /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: z83.a.a.<init>():void type: THIS */
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public /* synthetic */ C0140a(we0 we0Var) {
                this();
            }

            public C0140a() {
            }
        }
    }
}
