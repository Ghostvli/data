package defpackage;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class xr extends vr {
    public final Function3 j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ a31 i;

        /* JADX INFO: renamed from: xr$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0131a implements a31 {
            public final /* synthetic */ mp3 f;
            public final /* synthetic */ u40 g;
            public final /* synthetic */ xr h;
            public final /* synthetic */ a31 i;

            /* JADX INFO: renamed from: xr$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class C0132a extends oj4 implements Function2 {
                public int f;
                public final /* synthetic */ xr g;
                public final /* synthetic */ a31 h;
                public final /* synthetic */ Object i;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0132a(xr xrVar, a31 a31Var, Object obj, f30 f30Var) {
                    super(2, f30Var);
                    this.g = xrVar;
                    this.h = a31Var;
                    this.i = obj;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.hh
                public final f30 create(Object obj, f30 f30Var) {
                    return new C0132a(this.g, this.h, this.i, f30Var);
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(u40 u40Var, f30 f30Var) {
                    return ((C0132a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.hh
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objE = kl1.e();
                    int i = this.f;
                    if (i == 0) {
                        lt3.b(obj);
                        Function3 function3 = this.g.j;
                        a31 a31Var = this.h;
                        Object obj2 = this.i;
                        this.f = 1;
                        if (function3.invoke(a31Var, obj2, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            e04.a("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        lt3.b(obj);
                    }
                    return fw4.a;
                }
            }

            /* JADX INFO: renamed from: xr$a$a$b */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class b extends g30 {
                public Object f;
                public Object g;
                public Object h;
                public /* synthetic */ Object i;
                public int k;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public b(f30 f30Var) {
                    super(f30Var);
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.hh
                public final Object invokeSuspend(Object obj) {
                    this.i = obj;
                    this.k |= Integer.MIN_VALUE;
                    return C0131a.this.emit(null, this);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0131a(mp3 mp3Var, u40 u40Var, xr xrVar, a31 a31Var) {
                this.f = mp3Var;
                this.g = u40Var;
                this.h = xrVar;
                this.i = a31Var;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // defpackage.a31
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, f30 f30Var) throws Throwable {
                b bVar;
                if (f30Var instanceof b) {
                    bVar = (b) f30Var;
                    int i = bVar.k;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        bVar.k = i - Integer.MIN_VALUE;
                    } else {
                        bVar = new b(f30Var);
                    }
                }
                Object obj2 = bVar.i;
                Object objE = kl1.e();
                int i2 = bVar.k;
                if (i2 == 0) {
                    lt3.b(obj2);
                    ln1 ln1Var = (ln1) this.f.f;
                    if (ln1Var != null) {
                        ln1Var.h(new et());
                        bVar.f = this;
                        bVar.g = obj;
                        bVar.h = ln1Var;
                        bVar.k = 1;
                        if (ln1Var.b0(bVar) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = bVar.g;
                    this = (C0131a) bVar.f;
                    lt3.b(obj2);
                }
                this.f.f = dm.b(this.g, null, y40.i, new C0132a(this.h, this.i, obj, null), 1, null);
                return fw4.a;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a31 a31Var, f30 f30Var) {
            super(2, f30Var);
            this.i = a31Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            a aVar = xr.this.new a(this.i, f30Var);
            aVar.g = obj;
            return aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            if (i == 0) {
                lt3.b(obj);
                u40 u40Var = (u40) this.g;
                mp3 mp3Var = new mp3();
                xr xrVar = xr.this;
                z21 z21Var = xrVar.i;
                C0131a c0131a = new C0131a(mp3Var, u40Var, xrVar, this.i);
                this.f = 1;
                if (z21Var.collect(c0131a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0017: CONSTRUCTOR 
      (r7v0 kotlin.jvm.functions.Function3)
      (r8v0 z21)
      (wrap:g40:0x0006: TERNARY null = ((wrap:int:0x0000: ARITH (r12v0 int) & (4 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (wrap:g40:0x0004: SGET  A[WRAPPED] (LINE:5) bs0.f bs0) : (r9v0 g40))
      (wrap:int:0x000c: TERNARY null = ((wrap:int:0x0007: ARITH (r12v0 int) & (8 int) A[WRAPPED] (LINE:8)) != (0 int)) ? (-2 int) : (r10v0 int))
      (wrap:tl:?: TERNARY null = ((wrap:int:0x000d: ARITH (r12v0 int) & (16 int) A[WRAPPED] (LINE:14)) != (0 int)) ? (wrap:tl:0x0011: SGET  A[WRAPPED] (LINE:18) tl.f tl) : (r11v0 tl))
     A[MD:(kotlin.jvm.functions.Function3, z21, g40, int, tl):void (m)] (LINE:24) call: xr.<init>(kotlin.jvm.functions.Function3, z21, g40, int, tl):void type: THIS */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public /* synthetic */ xr(Function3 function3, z21 z21Var, g40 g40Var, int i, tl tlVar, int i2, we0 we0Var) {
        this(function3, z21Var, (i2 & 4) != 0 ? bs0.f : g40Var, (i2 & 8) != 0 ? -2 : i, (i2 & 16) != 0 ? tl.f : tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tr
    public tr i(g40 g40Var, int i, tl tlVar) {
        return new xr(this.j, this.i, g40Var, i, tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vr
    public Object q(a31 a31Var, f30 f30Var) {
        Object objD = v40.d(new a(a31Var, null), f30Var);
        return objD == kl1.e() ? objD : fw4.a;
    }

    public xr(Function3 function3, z21 z21Var, g40 g40Var, int i, tl tlVar) {
        super(z21Var, g40Var, i, tlVar);
        this.j = function3;
    }
}
