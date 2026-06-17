package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class zd4 implements a64 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ ce4 h;

        /* JADX INFO: renamed from: zd4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0141a implements a31 {
            public final /* synthetic */ kp3 f;
            public final /* synthetic */ a31 g;

            /* JADX INFO: renamed from: zd4$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class C0142a extends g30 {
                public /* synthetic */ Object f;
                public int h;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public C0142a(f30 f30Var) {
                    super(f30Var);
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.hh
                public final Object invokeSuspend(Object obj) {
                    this.f = obj;
                    this.h |= Integer.MIN_VALUE;
                    return C0141a.this.b(0, this);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0141a(kp3 kp3Var, a31 a31Var) {
                this.f = kp3Var;
                this.g = a31Var;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object b(int i, f30 f30Var) throws Throwable {
                C0142a c0142a;
                if (f30Var instanceof C0142a) {
                    c0142a = (C0142a) f30Var;
                    int i2 = c0142a.h;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0142a.h = i2 - Integer.MIN_VALUE;
                    } else {
                        c0142a = new C0142a(f30Var);
                    }
                }
                Object obj = c0142a.f;
                Object objE = kl1.e();
                int i3 = c0142a.h;
                if (i3 == 0) {
                    lt3.b(obj);
                    if (i > 0) {
                        kp3 kp3Var = this.f;
                        if (!kp3Var.f) {
                            kp3Var.f = true;
                            a31 a31Var = this.g;
                            y54 y54Var = y54.f;
                            c0142a.h = 1;
                            if (a31Var.emit(y54Var, c0142a) == objE) {
                                return objE;
                            }
                        }
                    }
                    return fw4.a;
                }
                if (i3 != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
                return fw4.a;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.a31
            public /* bridge */ /* synthetic */ Object emit(Object obj, f30 f30Var) {
                return b(((Number) obj).intValue(), f30Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ce4 ce4Var, f30 f30Var) {
            super(2, f30Var);
            this.h = ce4Var;
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
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(a31 a31Var, f30 f30Var) {
            return ((a) create(a31Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            if (i == 0) {
                lt3.b(obj);
                a31 a31Var = (a31) this.g;
                kp3 kp3Var = new kp3();
                ce4 ce4Var = this.h;
                C0141a c0141a = new C0141a(kp3Var, a31Var);
                this.f = 1;
                if (ce4Var.collect(c0141a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            mx3.a();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.a64
    public z21 a(ce4 ce4Var) {
        return c31.i(new a(ce4Var, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
