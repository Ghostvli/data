package defpackage;

import defpackage.ds4;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class x83 implements ds4, ao3 {
    public final Function2 a;
    public final lw3 b;
    public AtomicInteger c;
    public ds4.a d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements cs4, ao3 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pf3
        public Object a(String str, Function1 function1, f30 f30Var) {
            return x83.this.a(str, function1, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ao3
        public lw3 d() {
            return x83.this.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[ds4.a.values().length];
            try {
                iArr[ds4.a.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ds4.a.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ds4.a.h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends g30 {
        public int f;
        public /* synthetic */ Object g;
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return x83.this.g(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends g30 {
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public int j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return x83.this.a(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends oj4 implements Function1 {
        public int f;
        public final /* synthetic */ String h;
        public final /* synthetic */ Function1 i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Function1 function1, f30 f30Var) {
            super(1, f30Var);
            this.h = str;
            this.i = function1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(f30 f30Var) {
            return x83.this.new e(this.h, this.i, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f30 f30Var) {
            return ((e) create(f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Exception {
            kl1.e();
            if (this.f != 0) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
            ow3 ow3VarA0 = x83.this.f().a0(this.h);
            try {
                Object objInvoke = this.i.invoke(ow3VarA0);
                ne.a(ow3VarA0, null);
                return objInvoke;
            } finally {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends oj4 implements Function1 {
        public int f;
        public final /* synthetic */ ds4.a h;
        public final /* synthetic */ Function2 i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ds4.a aVar, Function2 function2, f30 f30Var) {
            super(1, f30Var);
            this.h = aVar;
            this.i = function2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(f30 f30Var) {
            return x83.this.new f(this.h, this.i, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f30 f30Var) {
            return ((f) create(f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Exception {
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
            x83 x83Var = x83.this;
            ds4.a aVar = this.h;
            Function2 function2 = this.i;
            this.f = 1;
            Object objG = x83Var.g(aVar, function2, this);
            return objG == objE ? objE : objG;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x83(Function2 function2, lw3 lw3Var) {
        lw3Var.getClass();
        this.a = function2;
        this.b = lw3Var;
        this.c = new AtomicInteger(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.pf3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, Function1 function1, f30 f30Var) throws Exception {
        d dVar;
        Function2 function2;
        if (f30Var instanceof d) {
            dVar = (d) f30Var;
            int i = dVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.j = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(f30Var);
            }
        }
        Object objC = dVar.h;
        Object objE = kl1.e();
        int i2 = dVar.j;
        if (i2 == 0) {
            lt3.b(objC);
            dVar.f = str;
            dVar.g = function1;
            dVar.j = 1;
            objC = c(dVar);
            if (objC != objE) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                lt3.b(objC);
                return objC;
            }
            e04.a("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        function1 = (Function1) dVar.g;
        str = (String) dVar.f;
        lt3.b(objC);
        if (((Boolean) objC).booleanValue() && (function2 = this.a) != null) {
            e eVar = new e(str, function1, null);
            dVar.f = null;
            dVar.g = null;
            dVar.j = 2;
            Object objInvoke = function2.invoke(eVar, dVar);
            return objInvoke == objE ? objE : objInvoke;
        }
        ow3 ow3VarA0 = this.b.a0(str);
        try {
            Object objInvoke2 = function1.invoke(ow3VarA0);
            ne.a(ow3VarA0, null);
            return objInvoke2;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ds4
    public Object b(ds4.a aVar, Function2 function2, f30 f30Var) {
        Function2 function22 = this.a;
        if (function22 == null) {
            return g(aVar, function2, f30Var);
        }
        Object objInvoke = function22.invoke(new f(aVar, function2, null), f30Var);
        kl1.e();
        return objInvoke;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ds4
    public Object c(f30 f30Var) {
        return hl.a(this.d != null || this.b.f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao3
    public lw3 d() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lw3 f() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(ds4.a aVar, Function2 function2, f30 f30Var) throws Exception {
        c cVar;
        if (f30Var instanceof c) {
            cVar = (c) f30Var;
            int i = cVar.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.i = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(f30Var);
            }
        }
        Object objInvoke = cVar.g;
        Object objE = kl1.e();
        int i2 = cVar.i;
        int i3 = 1;
        try {
            if (i2 == 0) {
                lt3.b(objInvoke);
                int i4 = b.a[aVar.ordinal()];
                if (i4 == 1) {
                    kw3.a(this.b, "BEGIN DEFERRED TRANSACTION");
                } else if (i4 == 2) {
                    kw3.a(this.b, "BEGIN IMMEDIATE TRANSACTION");
                } else {
                    if (i4 != 3) {
                        throw new j33();
                    }
                    kw3.a(this.b, "BEGIN EXCLUSIVE TRANSACTION");
                }
                if (this.c.incrementAndGet() > 0) {
                    this.d = aVar;
                }
                a aVar2 = new a();
                cVar.f = 1;
                cVar.i = 1;
                objInvoke = function2.invoke(aVar2, cVar);
                if (objInvoke == objE) {
                    return objE;
                }
            } else {
                if (i2 != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i3 = cVar.f;
                lt3.b(objInvoke);
            }
            if (this.c.decrementAndGet() == 0) {
                this.d = null;
            }
            lw3 lw3Var = this.b;
            if (i3 != 0) {
                kw3.a(lw3Var, "END TRANSACTION");
                return objInvoke;
            }
            kw3.a(lw3Var, "ROLLBACK TRANSACTION");
            return objInvoke;
        } finally {
        }
    }
}
