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

                public C0142a(f30 f30Var) {
                    super(f30Var);
                }

                @Override // defpackage.hh
                public final Object invokeSuspend(Object obj) {
                    this.f = obj;
                    this.h |= Integer.MIN_VALUE;
                    return C0141a.this.b(0, this);
                }
            }

            public C0141a(kp3 kp3Var, a31 a31Var) {
                this.f = kp3Var;
                this.g = a31Var;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object b(int r5, defpackage.f30 r6) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof zd4.a.C0141a.C0142a
                    if (r0 == 0) goto L13
                    r0 = r6
                    zd4$a$a$a r0 = (zd4.a.C0141a.C0142a) r0
                    int r1 = r0.h
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.h = r1
                    goto L18
                L13:
                    zd4$a$a$a r0 = new zd4$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f
                    java.lang.Object r1 = defpackage.kl1.e()
                    int r2 = r0.h
                    r3 = 1
                    if (r2 == 0) goto L30
                    if (r2 != r3) goto L29
                    defpackage.lt3.b(r6)
                    goto L4a
                L29:
                    java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                    defpackage.e04.a(r4)
                    r4 = 0
                    return r4
                L30:
                    defpackage.lt3.b(r6)
                    if (r5 <= 0) goto L4d
                    kp3 r5 = r4.f
                    boolean r6 = r5.f
                    if (r6 != 0) goto L4d
                    r5.f = r3
                    a31 r4 = r4.g
                    y54 r5 = defpackage.y54.f
                    r0.h = r3
                    java.lang.Object r4 = r4.emit(r5, r0)
                    if (r4 != r1) goto L4a
                    return r1
                L4a:
                    fw4 r4 = defpackage.fw4.a
                    return r4
                L4d:
                    fw4 r4 = defpackage.fw4.a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: zd4.a.C0141a.b(int, f30):java.lang.Object");
            }

            @Override // defpackage.a31
            public /* bridge */ /* synthetic */ Object emit(Object obj, f30 f30Var) {
                return b(((Number) obj).intValue(), f30Var);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ce4 ce4Var, f30 f30Var) {
            super(2, f30Var);
            this.h = ce4Var;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            a aVar = new a(this.h, f30Var);
            aVar.g = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(a31 a31Var, f30 f30Var) {
            return ((a) create(a31Var, f30Var)).invokeSuspend(fw4.a);
        }

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

    @Override // defpackage.a64
    public z21 a(ce4 ce4Var) {
        return c31.i(new a(ce4Var, null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
