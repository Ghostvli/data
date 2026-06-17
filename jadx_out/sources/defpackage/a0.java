package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 implements z21 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends g30 {
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        public a(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return a0.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.z21
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(defpackage.a31 r5, defpackage.f30 r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof a0.a
            if (r0 == 0) goto L13
            r0 = r6
            a0$a r0 = (a0.a) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            a0$a r0 = new a0$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.g
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f
            tw3 r4 = (defpackage.tw3) r4
            defpackage.lt3.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4e
        L2d:
            r5 = move-exception
            goto L56
        L2f:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r4)
            r4 = 0
            return r4
        L36:
            defpackage.lt3.b(r6)
            tw3 r6 = new tw3
            g40 r2 = r0.getContext()
            r6.<init>(r5, r2)
            r0.f = r6     // Catch: java.lang.Throwable -> L54
            r0.i = r3     // Catch: java.lang.Throwable -> L54
            java.lang.Object r4 = r4.e(r6, r0)     // Catch: java.lang.Throwable -> L54
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = r6
        L4e:
            r4.releaseIntercepted()
            fw4 r4 = defpackage.fw4.a
            return r4
        L54:
            r5 = move-exception
            r4 = r6
        L56:
            r4.releaseIntercepted()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a0.collect(a31, f30):java.lang.Object");
    }

    public abstract Object e(a31 a31Var, f30 f30Var);
}
