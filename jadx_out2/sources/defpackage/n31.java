package defpackage;

import defpackage.a64;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class n31 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends oj4 implements Function2 {
        public int f;
        public final /* synthetic */ a64 g;
        public final /* synthetic */ z21 h;
        public final /* synthetic */ pw2 i;
        public final /* synthetic */ Object j;

        /* JADX INFO: renamed from: n31$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0103a extends oj4 implements Function2 {
            public int f;
            public /* synthetic */ int g;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0103a(f30 f30Var) {
                super(2, f30Var);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                C0103a c0103a = new C0103a(f30Var);
                c0103a.g = ((Number) obj).intValue();
                return c0103a;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final Object h(int i, f30 f30Var) {
                return ((C0103a) create(Integer.valueOf(i), f30Var)).invokeSuspend(fw4.a);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return h(((Number) obj).intValue(), (f30) obj2);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) throws Throwable {
                kl1.e();
                if (this.f == 0) {
                    lt3.b(obj);
                    return hl.a(this.g > 0);
                }
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class b extends oj4 implements Function2 {
            public int f;
            public /* synthetic */ Object g;
            public final /* synthetic */ z21 h;
            public final /* synthetic */ pw2 i;
            public final /* synthetic */ Object j;

            /* JADX INFO: renamed from: n31$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public /* synthetic */ class C0104a {
                public static final /* synthetic */ int[] a;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                static {
                    int[] iArr = new int[y54.values().length];
                    try {
                        iArr[y54.f.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[y54.g.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[y54.h.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(z21 z21Var, pw2 pw2Var, Object obj, f30 f30Var) {
                super(2, f30Var);
                this.h = z21Var;
                this.i = pw2Var;
                this.j = obj;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                b bVar = new b(this.h, this.i, this.j, f30Var);
                bVar.g = obj;
                return bVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(y54 y54Var, f30 f30Var) {
                return ((b) create(y54Var, f30Var)).invokeSuspend(fw4.a);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kl1.e();
                int i = this.f;
                if (i == 0) {
                    lt3.b(obj);
                    int i2 = C0104a.a[((y54) this.g).ordinal()];
                    if (i2 == 1) {
                        z21 z21Var = this.h;
                        pw2 pw2Var = this.i;
                        this.f = 1;
                        if (z21Var.collect(pw2Var, this) == objE) {
                            return objE;
                        }
                    } else if (i2 != 2) {
                        if (i2 != 3) {
                            throw new j33();
                        }
                        Object obj2 = this.j;
                        qj4 qj4Var = w54.a;
                        pw2 pw2Var2 = this.i;
                        if (obj2 == qj4Var) {
                            pw2Var2.c();
                        } else {
                            hl.a(pw2Var2.d(obj2));
                        }
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a64 a64Var, z21 z21Var, pw2 pw2Var, Object obj, f30 f30Var) {
            super(2, f30Var);
            this.g = a64Var;
            this.h = z21Var;
            this.i = pw2Var;
            this.j = obj;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new a(this.g, this.h, this.i, this.j, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        
            if (r8.collect(r1, r7) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
        
            if (r8.collect(r1, r7) != r0) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
        
            if (defpackage.c31.d(r8, r1, r7) == r0) goto L28;
         */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        lt3.b(obj);
                        z21 z21Var = this.h;
                        pw2 pw2Var = this.i;
                        this.f = 3;
                    } else if (i != 3 && i != 4) {
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                }
                lt3.b(obj);
                return fw4.a;
            }
            lt3.b(obj);
            a64 a64Var = this.g;
            a64.a aVar = a64.a;
            if (a64Var != aVar.a()) {
                if (this.g == aVar.b()) {
                    ce4 ce4VarG = this.i.g();
                    C0103a c0103a = new C0103a(null);
                    this.f = 2;
                    if (c31.h(ce4VarG, c0103a, this) != objE) {
                        z21 z21Var2 = this.h;
                        pw2 pw2Var2 = this.i;
                        this.f = 3;
                    }
                } else {
                    z21 z21VarE = c31.e(this.g.a(this.i.g()));
                    b bVar = new b(this.h, this.i, this.j, null);
                    this.f = 4;
                }
                return objE;
            }
            z21 z21Var3 = this.h;
            pw2 pw2Var3 = this.i;
            this.f = 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final z54 a(z21 z21Var, int i) {
        tr trVar;
        z21 z21VarJ;
        int iB = xn3.b(i, or.a.a()) - i;
        if (!(z21Var instanceof tr) || (z21VarJ = (trVar = (tr) z21Var).j()) == null) {
            return new z54(z21Var, iB, tl.f, bs0.f);
        }
        int i2 = trVar.g;
        if (i2 != -3 && i2 != -2 && i2 != 0) {
            iB = i2;
        } else if (trVar.h == tl.f) {
            if (i2 == 0) {
                iB = 0;
            }
        } else if (i == 0) {
            iB = 1;
        }
        return new z54(z21VarJ, iB, trVar.h, trVar.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ln1 b(u40 u40Var, g40 g40Var, z21 z21Var, pw2 pw2Var, a64 a64Var, Object obj) {
        return bm.a(u40Var, g40Var, il1.a(a64Var, a64.a.a()) ? y40.f : y40.i, new a(a64Var, z21Var, pw2Var, obj, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ce4 c(z21 z21Var, u40 u40Var, a64 a64Var, Object obj) {
        z54 z54VarA = a(z21Var, 1);
        qw2 qw2VarA = ee4.a(obj);
        return new jo3(qw2VarA, b(u40Var, z54VarA.d, z54VarA.a, qw2VarA, a64Var, obj));
    }
}
