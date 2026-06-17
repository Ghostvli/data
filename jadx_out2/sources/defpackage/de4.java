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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.m |= Integer.MIN_VALUE;
            return de4.this.collect(null, this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public de4(Object obj) {
        this._state$volatile = obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u81
    public z21 b(g40 g40Var, int i, tl tlVar) {
        return ee4.d(this, g40Var, i, tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pw2
    public void c() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0042 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0023 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:? */
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
    */
    public Object collect(a31 a31Var, f30 f30Var) throws Throwable {
        a aVar;
        ?? r7;
        a31 a31Var2;
        ln1 ln1Var;
        Object obj;
        ?? r72;
        ?? r2;
        boolean zH;
        Object obj2;
        if (f30Var instanceof a) {
            aVar = (a) f30Var;
            int i = aVar.m;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.m = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(f30Var);
            }
        }
        Object obj3 = aVar.k;
        Object objE = kl1.e();
        ?? r22 = aVar.m;
        try {
            if (r22 == 0) {
                lt3.b(obj3);
                r22 = (fe4) h();
            } else if (r22 == 1) {
                r22 = (fe4) aVar.h;
                a31Var = (a31) aVar.g;
                this = (de4) aVar.f;
                try {
                    lt3.b(obj3);
                    r22 = r22;
                } catch (Throwable th) {
                    r7 = this;
                    th = th;
                    r7.k(r22);
                    throw th;
                }
            } else if (r22 == 2) {
                obj = aVar.j;
                ln1Var = (ln1) aVar.i;
                fe4 fe4Var = (fe4) aVar.h;
                a31Var2 = (a31) aVar.g;
                de4 de4Var = (de4) aVar.f;
                lt3.b(obj3);
                r2 = fe4Var;
                r72 = de4Var;
                zH = r2.h();
                r22 = r2;
                r7 = r72;
                if (!zH) {
                }
                Object obj4 = k.get(r7);
                if (ln1Var != null) {
                }
                if (obj != null) {
                }
                if (obj4 != m43.a) {
                }
                aVar.f = r7;
                aVar.g = a31Var2;
                aVar.h = r22;
                aVar.i = ln1Var;
                aVar.j = obj4;
                aVar.m = 2;
                if (a31Var2.emit(obj2, aVar) != objE) {
                }
            } else {
                if (r22 != 3) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                obj = aVar.j;
                ln1Var = (ln1) aVar.i;
                fe4 fe4Var2 = (fe4) aVar.h;
                a31Var2 = (a31) aVar.g;
                de4 de4Var2 = (de4) aVar.f;
                lt3.b(obj3);
                r22 = fe4Var2;
                r7 = de4Var2;
                Object obj42 = k.get(r7);
                if (ln1Var != null) {
                    on1.f(ln1Var);
                }
                if (obj != null) {
                    r2 = r22;
                    r72 = r7;
                }
                obj2 = obj42 != m43.a ? null : obj42;
                aVar.f = r7;
                aVar.g = a31Var2;
                aVar.h = r22;
                aVar.i = ln1Var;
                aVar.j = obj42;
                aVar.m = 2;
                if (a31Var2.emit(obj2, aVar) != objE) {
                    return objE;
                }
                obj = obj42;
                r2 = r22;
                r72 = r7;
                zH = r2.h();
                r22 = r2;
                r7 = r72;
                if (!zH) {
                    aVar.f = r72;
                    aVar.g = a31Var2;
                    aVar.h = r2;
                    aVar.i = ln1Var;
                    aVar.j = obj;
                    aVar.m = 3;
                    Object objE2 = r2.e(aVar);
                    r22 = r2;
                    r7 = r72;
                    if (objE2 != objE) {
                    }
                    return objE;
                }
                Object obj422 = k.get(r7);
                if (ln1Var != null) {
                }
                if (obj != null) {
                }
                if (obj422 != m43.a) {
                }
                aVar.f = r7;
                aVar.g = a31Var2;
                aVar.h = r22;
                aVar.i = ln1Var;
                aVar.j = obj422;
                aVar.m = 2;
                if (a31Var2.emit(obj2, aVar) != objE) {
                }
            }
            r7 = this;
            a31Var2 = a31Var;
            ln1Var = (ln1) aVar.getContext().a(ln1.e);
            obj = null;
            r22 = r22;
            Object obj4222 = k.get(r7);
            if (ln1Var != null) {
            }
            if (obj != null) {
            }
            if (obj4222 != m43.a) {
            }
            aVar.f = r7;
            aVar.g = a31Var2;
            aVar.h = r22;
            aVar.i = ln1Var;
            aVar.j = obj4222;
            aVar.m = 2;
            if (a31Var2.emit(obj2, aVar) != objE) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pw2
    public boolean d(Object obj) {
        setValue(obj);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pw2, defpackage.a31
    public Object emit(Object obj, f30 f30Var) {
        setValue(obj);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qw2
    public Object getValue() {
        qj4 qj4Var = m43.a;
        Object obj = k.get(this);
        if (obj == qj4Var) {
            return null;
        }
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i()Ld1; */
    @Override // defpackage.b1
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public fe4 i() {
        return new fe4();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(I)[Ld1; */
    @Override // defpackage.b1
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public fe4[] j(int i) {
        return new fe4[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qw2
    public void setValue(Object obj) {
        if (obj == null) {
            obj = m43.a;
        }
        q(null, obj);
    }
}
