package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m31 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements a31 {
        public final /* synthetic */ Function2 f;
        public final /* synthetic */ mp3 g;

        /* JADX INFO: renamed from: m31$a$a, reason: collision with other inner class name */
        public static final class C0096a extends g30 {
            public Object f;
            public /* synthetic */ Object g;
            public int h;
            public Object j;

            public C0096a(f30 f30Var) {
                super(f30Var);
            }

            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) {
                this.g = obj;
                this.h |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(Function2 function2, mp3 mp3Var) {
            this.f = function2;
            this.g = mp3Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // defpackage.a31
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object emit(java.lang.Object r5, defpackage.f30 r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof m31.a.C0096a
                if (r0 == 0) goto L13
                r0 = r6
                m31$a$a r0 = (m31.a.C0096a) r0
                int r1 = r0.h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.h = r1
                goto L18
            L13:
                m31$a$a r0 = new m31$a$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.g
                java.lang.Object r1 = defpackage.kl1.e()
                int r2 = r0.h
                r3 = 1
                if (r2 == 0) goto L36
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.j
                java.lang.Object r4 = r0.f
                m31$a r4 = (m31.a) r4
                defpackage.lt3.b(r6)
                goto L50
            L2f:
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                defpackage.e04.a(r4)
                r4 = 0
                return r4
            L36:
                defpackage.lt3.b(r6)
                kotlin.jvm.functions.Function2 r6 = r4.f
                r0.f = r4
                r0.j = r5
                r0.h = r3
                r2 = 6
                defpackage.dk1.c(r2)
                java.lang.Object r6 = r6.invoke(r5, r0)
                r0 = 7
                defpackage.dk1.c(r0)
                if (r6 != r1) goto L50
                return r1
            L50:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 != 0) goto L5b
                fw4 r4 = defpackage.fw4.a
                return r4
            L5b:
                mp3 r6 = r4.g
                r6.f = r5
                l r5 = new l
                r5.<init>(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: m31.a.emit(java.lang.Object, f30):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int j;

        public b(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.j |= Integer.MIN_VALUE;
            return c31.h(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(defpackage.z21 r4, kotlin.jvm.functions.Function2 r5, defpackage.f30 r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof m31.b
            if (r0 == 0) goto L13
            r0 = r6
            m31$b r0 = (m31.b) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            m31$b r0 = new m31$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.i
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.j
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L37
            java.lang.Object r4 = r0.h
            m31$a r4 = (m31.a) r4
            java.lang.Object r5 = r0.g
            mp3 r5 = (defpackage.mp3) r5
            java.lang.Object r0 = r0.f
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            defpackage.lt3.b(r6)     // Catch: defpackage.l -> L35
            goto L69
        L35:
            r6 = move-exception
            goto L66
        L37:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r4)
            r4 = 0
            return r4
        L3e:
            defpackage.lt3.b(r6)
            mp3 r6 = new mp3
            r6.<init>()
            qj4 r2 = defpackage.m43.a
            r6.f = r2
            m31$a r2 = new m31$a
            r2.<init>(r5, r6)
            r0.f = r5     // Catch: defpackage.l -> L61
            r0.g = r6     // Catch: defpackage.l -> L61
            r0.h = r2     // Catch: defpackage.l -> L61
            r0.j = r3     // Catch: defpackage.l -> L61
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: defpackage.l -> L61
            if (r4 != r1) goto L5e
            return r1
        L5e:
            r0 = r5
            r5 = r6
            goto L69
        L61:
            r4 = move-exception
            r0 = r5
            r5 = r6
            r6 = r4
            r4 = r2
        L66:
            defpackage.b31.a(r6, r4)
        L69:
            java.lang.Object r4 = r5.f
            qj4 r5 = defpackage.m43.a
            if (r4 == r5) goto L70
            return r4
        L70:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Expected at least one element matching the predicate "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m31.a(z21, kotlin.jvm.functions.Function2, f30):java.lang.Object");
    }
}
