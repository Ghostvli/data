package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jl1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends ft3 {
        public int f;
        public final /* synthetic */ Function2 g;
        public final /* synthetic */ Object h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f30 f30Var, Function2 function2, Object obj) {
            super(f30Var);
            this.g = function2;
            this.h = obj;
            f30Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public Object invokeSuspend(Object obj) throws Throwable {
            int i = this.f;
            if (i == 0) {
                this.f = 1;
                lt3.b(obj);
                this.g.getClass();
                return ((Function2) vu4.b(this.g, 2)).invoke(this.h, this);
            }
            if (i != 1) {
                e04.a("This coroutine had already completed");
                return null;
            }
            this.f = 2;
            lt3.b(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends g30 {
        public int f;
        public final /* synthetic */ Function2 g;
        public final /* synthetic */ Object h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f30 f30Var, g40 g40Var, Function2 function2, Object obj) {
            super(f30Var, g40Var);
            this.g = function2;
            this.h = obj;
            f30Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public Object invokeSuspend(Object obj) throws Throwable {
            int i = this.f;
            if (i == 0) {
                this.f = 1;
                lt3.b(obj);
                this.g.getClass();
                return ((Function2) vu4.b(this.g, 2)).invoke(this.h, this);
            }
            if (i != 1) {
                e04.a("This coroutine had already completed");
                return null;
            }
            this.f = 2;
            lt3.b(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends ft3 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f30 f30Var) {
            super(f30Var);
            f30Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public Object invokeSuspend(Object obj) throws Throwable {
            lt3.b(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends g30 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f30 f30Var, g40 g40Var) {
            super(f30Var, g40Var);
            f30Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public Object invokeSuspend(Object obj) throws Throwable {
            lt3.b(obj);
            return obj;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static f30 a(Function2 function2, Object obj, f30 f30Var) {
        function2.getClass();
        f30Var.getClass();
        f30 f30VarA = ta0.a(f30Var);
        if (function2 instanceof hh) {
            return ((hh) function2).create(obj, f30VarA);
        }
        g40 context = f30VarA.getContext();
        return context == bs0.f ? new a(f30VarA, function2, obj) : new b(f30VarA, context, function2, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final f30 b(f30 f30Var) {
        g40 context = f30Var.getContext();
        return context == bs0.f ? new c(f30Var) : new d(f30Var, context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f30 c(f30 f30Var) {
        f30 f30VarIntercepted;
        f30Var.getClass();
        g30 g30Var = f30Var instanceof g30 ? (g30) f30Var : null;
        return (g30Var == null || (f30VarIntercepted = g30Var.intercepted()) == null) ? f30Var : f30VarIntercepted;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object d(Function2 function2, Object obj, f30 f30Var) {
        function2.getClass();
        f30Var.getClass();
        return ((Function2) vu4.b(function2, 2)).invoke(obj, b(ta0.a(f30Var)));
    }
}
