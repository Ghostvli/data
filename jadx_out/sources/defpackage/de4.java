package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class de4 extends b1 implements qw2, z21, u81 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(de4.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    public int j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public /* synthetic */ Object k;
        public int m;

        public a(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.m |= Integer.MIN_VALUE;
            return de4.this.collect(null, this);
        }
    }

    public de4(Object obj) {
        this._state$volatile = obj;
    }

    @Override // defpackage.qw2
    public boolean a(Object obj, Object obj2) {
        if (obj == null) {
            obj = m43.a;
        }
        if (obj2 == null) {
            obj2 = m43.a;
        }
        return q(obj, obj2);
    }

    @Override // defpackage.u81
    public z21 b(g40 g40Var, int i, tl tlVar) {
        return ee4.d(this, g40Var, i, tlVar);
    }

    @Override // defpackage.pw2
    public void c() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
    
        if (defpackage.il1.a(r9, r11) == false) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:32:0x0093, B:48:0x00c9], limit reached: 53 */
    /* JADX WARN: Path cross not found for [B:36:0x00a2, B:38:0x00a8], limit reached: 53 */
    /* JADX WARN: Path cross not found for [B:38:0x00a8, B:36:0x00a2], limit reached: 53 */
    /* JADX WARN: Path cross not found for [B:38:0x00a8, B:46:0x00c3], limit reached: 53 */
    /* JADX WARN: Path cross not found for [B:48:0x00c9, B:32:0x0093], limit reached: 53 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:32:0x0093, B:34:0x009d, B:36:0x00a2, B:46:0x00c3, B:48:0x00c9, B:38:0x00a8, B:42:0x00af, B:22:0x005d), top: B:53:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:32:0x0093, B:34:0x009d, B:36:0x00a2, B:46:0x00c3, B:48:0x00c9, B:38:0x00a8, B:42:0x00af, B:22:0x005d), top: B:53:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c9 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:32:0x0093, B:34:0x009d, B:36:0x00a2, B:46:0x00c3, B:48:0x00c9, B:38:0x00a8, B:42:0x00af, B:22:0x005d), top: B:53:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [d1] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [fe4, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [fe4] */
    /* JADX WARN: Type inference failed for: r7v1, types: [b1] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00c7 -> B:32:0x0093). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d9 -> B:32:0x0093). Please report as a decompilation issue!!! */
    @Override // defpackage.u54, defpackage.z21
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(defpackage.a31 r10, defpackage.f30 r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.de4.collect(a31, f30):java.lang.Object");
    }

    @Override // defpackage.pw2
    public boolean d(Object obj) {
        setValue(obj);
        return true;
    }

    @Override // defpackage.pw2, defpackage.a31
    public Object emit(Object obj, f30 f30Var) {
        setValue(obj);
        return fw4.a;
    }

    @Override // defpackage.qw2
    public Object getValue() {
        qj4 qj4Var = m43.a;
        Object obj = k.get(this);
        if (obj == qj4Var) {
            return null;
        }
        return obj;
    }

    @Override // defpackage.b1
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public fe4 i() {
        return new fe4();
    }

    @Override // defpackage.b1
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public fe4[] j(int i) {
        return new fe4[i];
    }

    public final boolean q(Object obj, Object obj2) {
        int i;
        d1[] d1VarArrM;
        synchronized (this) {
            Object obj3 = k.get(this);
            if (obj != null && !il1.a(obj3, obj)) {
                return false;
            }
            if (il1.a(obj3, obj2)) {
                return true;
            }
            k.set(this, obj2);
            int i2 = this.j;
            if ((i2 & 1) != 0) {
                this.j = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.j = i3;
            d1[] d1VarArrM2 = m();
            fw4 fw4Var = fw4.a;
            while (true) {
                fe4[] fe4VarArr = (fe4[]) d1VarArrM2;
                if (fe4VarArr != null) {
                    for (fe4 fe4Var : fe4VarArr) {
                        if (fe4Var != null) {
                            fe4Var.g();
                        }
                    }
                }
                synchronized (this) {
                    i = this.j;
                    if (i == i3) {
                        this.j = i3 + 1;
                        return true;
                    }
                    d1VarArrM = m();
                    fw4 fw4Var2 = fw4.a;
                }
                d1VarArrM2 = d1VarArrM;
                i3 = i;
            }
        }
    }

    @Override // defpackage.qw2
    public void setValue(Object obj) {
        if (obj == null) {
            obj = m43.a;
        }
        q(null, obj);
    }
}
