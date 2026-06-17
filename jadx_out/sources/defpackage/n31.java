package defpackage;

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

            public C0103a(f30 f30Var) {
                super(2, f30Var);
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                C0103a c0103a = new C0103a(f30Var);
                c0103a.g = ((Number) obj).intValue();
                return c0103a;
            }

            public final Object h(int i, f30 f30Var) {
                return ((C0103a) create(Integer.valueOf(i), f30Var)).invokeSuspend(fw4.a);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return h(((Number) obj).intValue(), (f30) obj2);
            }

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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(z21 z21Var, pw2 pw2Var, Object obj, f30 f30Var) {
                super(2, f30Var);
                this.h = z21Var;
                this.i = pw2Var;
                this.j = obj;
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                b bVar = new b(this.h, this.i, this.j, f30Var);
                bVar.g = obj;
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(y54 y54Var, f30 f30Var) {
                return ((b) create(y54Var, f30Var)).invokeSuspend(fw4.a);
            }

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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a64 a64Var, z21 z21Var, pw2 pw2Var, Object obj, f30 f30Var) {
            super(2, f30Var);
            this.g = a64Var;
            this.h = z21Var;
            this.i = pw2Var;
            this.j = obj;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new a(this.g, this.h, this.i, this.j, f30Var);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

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
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = defpackage.kl1.e()
                int r1 = r7.f
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L24
                if (r1 == r5) goto L20
                if (r1 == r4) goto L1c
                if (r1 == r3) goto L20
                if (r1 != r2) goto L15
                goto L20
            L15:
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                defpackage.e04.a(r7)
                r7 = 0
                return r7
            L1c:
                defpackage.lt3.b(r8)
                goto L5b
            L20:
                defpackage.lt3.b(r8)
                goto L8c
            L24:
                defpackage.lt3.b(r8)
                a64 r8 = r7.g
                a64$a r1 = defpackage.a64.a
                a64 r6 = r1.a()
                if (r8 != r6) goto L3e
                z21 r8 = r7.h
                pw2 r1 = r7.i
                r7.f = r5
                java.lang.Object r7 = r8.collect(r1, r7)
                if (r7 != r0) goto L8c
                goto L8b
            L3e:
                a64 r8 = r7.g
                a64 r1 = r1.b()
                r5 = 0
                if (r8 != r1) goto L68
                pw2 r8 = r7.i
                ce4 r8 = r8.g()
                n31$a$a r1 = new n31$a$a
                r1.<init>(r5)
                r7.f = r4
                java.lang.Object r8 = defpackage.c31.h(r8, r1, r7)
                if (r8 != r0) goto L5b
                goto L8b
            L5b:
                z21 r8 = r7.h
                pw2 r1 = r7.i
                r7.f = r3
                java.lang.Object r7 = r8.collect(r1, r7)
                if (r7 != r0) goto L8c
                goto L8b
            L68:
                a64 r8 = r7.g
                pw2 r1 = r7.i
                ce4 r1 = r1.g()
                z21 r8 = r8.a(r1)
                z21 r8 = defpackage.c31.e(r8)
                n31$a$b r1 = new n31$a$b
                z21 r3 = r7.h
                pw2 r4 = r7.i
                java.lang.Object r6 = r7.j
                r1.<init>(r3, r4, r6, r5)
                r7.f = r2
                java.lang.Object r7 = defpackage.c31.d(r8, r1, r7)
                if (r7 != r0) goto L8c
            L8b:
                return r0
            L8c:
                fw4 r7 = defpackage.fw4.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: n31.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.z54 a(defpackage.z21 r7, int r8) {
        /*
            or$a r0 = defpackage.or.a
            int r0 = r0.a()
            int r0 = defpackage.xn3.b(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof defpackage.tr
            if (r1 == 0) goto L3c
            r1 = r7
            tr r1 = (defpackage.tr) r1
            z21 r2 = r1.j()
            if (r2 == 0) goto L3c
            z54 r7 = new z54
            int r3 = r1.g
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L34
        L26:
            tl r4 = r1.h
            tl r5 = defpackage.tl.f
            r6 = 0
            if (r4 != r5) goto L31
            if (r3 != 0) goto L34
        L2f:
            r0 = r6
            goto L34
        L31:
            if (r8 != 0) goto L2f
            r0 = 1
        L34:
            tl r8 = r1.h
            g40 r1 = r1.f
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3c:
            z54 r8 = new z54
            tl r1 = defpackage.tl.f
            bs0 r2 = defpackage.bs0.f
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n31.a(z21, int):z54");
    }

    public static final ln1 b(u40 u40Var, g40 g40Var, z21 z21Var, pw2 pw2Var, a64 a64Var, Object obj) {
        return bm.a(u40Var, g40Var, il1.a(a64Var, a64.a.a()) ? y40.f : y40.i, new a(a64Var, z21Var, pw2Var, obj, null));
    }

    public static final ce4 c(z21 z21Var, u40 u40Var, a64 a64Var, Object obj) {
        z54 z54VarA = a(z21Var, 1);
        qw2 qw2VarA = ee4.a(obj);
        return new jo3(qw2VarA, b(u40Var, z54VarA.d, z54VarA.a, qw2VarA, a64Var, obj));
    }
}
