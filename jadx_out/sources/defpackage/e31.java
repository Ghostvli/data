package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class e31 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public boolean i;
        public /* synthetic */ Object j;
        public int k;

        public a(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.k |= Integer.MIN_VALUE;
            return e31.c(null, null, false, this);
        }
    }

    public static final Object b(a31 a31Var, oo3 oo3Var, f30 f30Var) throws Throwable {
        Object objC = c(a31Var, oo3Var, true, f30Var);
        return objC == kl1.e() ? objC : fw4.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
    
        if (r2.emit(r10, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #1 {all -> 0x003d, blocks: (B:13:0x0037, B:24:0x0061, B:28:0x0076, B:30:0x007e, B:20:0x0053, B:23:0x005d), top: B:44:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0090 -> B:14:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(defpackage.a31 r7, defpackage.oo3 r8, boolean r9, defpackage.f30 r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof e31.a
            if (r0 == 0) goto L13
            r0 = r10
            e31$a r0 = (e31.a) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            e31$a r0 = new e31$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.j
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.k
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L57
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3f
            boolean r9 = r0.i
            java.lang.Object r7 = r0.h
            bs r7 = (defpackage.bs) r7
            java.lang.Object r8 = r0.g
            oo3 r8 = (defpackage.oo3) r8
            java.lang.Object r2 = r0.f
            a31 r2 = (defpackage.a31) r2
            defpackage.lt3.b(r10)     // Catch: java.lang.Throwable -> L3d
        L3a:
            r10 = r7
            r7 = r2
            goto L61
        L3d:
            r7 = move-exception
            goto L9b
        L3f:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r7)
            return r5
        L45:
            boolean r9 = r0.i
            java.lang.Object r7 = r0.h
            bs r7 = (defpackage.bs) r7
            java.lang.Object r8 = r0.g
            oo3 r8 = (defpackage.oo3) r8
            java.lang.Object r2 = r0.f
            a31 r2 = (defpackage.a31) r2
            defpackage.lt3.b(r10)     // Catch: java.lang.Throwable -> L3d
            goto L76
        L57:
            defpackage.lt3.b(r10)
            defpackage.c31.g(r7)
            bs r10 = r8.iterator()     // Catch: java.lang.Throwable -> L3d
        L61:
            r0.f = r7     // Catch: java.lang.Throwable -> L3d
            r0.g = r8     // Catch: java.lang.Throwable -> L3d
            r0.h = r10     // Catch: java.lang.Throwable -> L3d
            r0.i = r9     // Catch: java.lang.Throwable -> L3d
            r0.k = r4     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r2 = r10.b(r0)     // Catch: java.lang.Throwable -> L3d
            if (r2 != r1) goto L72
            goto L92
        L72:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L76:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L3d
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L3d
            if (r10 == 0) goto L93
            java.lang.Object r10 = r7.next()     // Catch: java.lang.Throwable -> L3d
            r0.f = r2     // Catch: java.lang.Throwable -> L3d
            r0.g = r8     // Catch: java.lang.Throwable -> L3d
            r0.h = r7     // Catch: java.lang.Throwable -> L3d
            r0.i = r9     // Catch: java.lang.Throwable -> L3d
            r0.k = r3     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L3d
            if (r10 != r1) goto L3a
        L92:
            return r1
        L93:
            if (r9 == 0) goto L98
            defpackage.hs.a(r8, r5)
        L98:
            fw4 r7 = defpackage.fw4.a
            return r7
        L9b:
            throw r7     // Catch: java.lang.Throwable -> L9c
        L9c:
            r10 = move-exception
            if (r9 == 0) goto La2
            defpackage.hs.a(r8, r7)
        La2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e31.c(a31, oo3, boolean, f30):java.lang.Object");
    }
}
