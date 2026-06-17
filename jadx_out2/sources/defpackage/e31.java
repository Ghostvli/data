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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.k |= Integer.MIN_VALUE;
            return e31.c(null, null, false, this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object b(a31 a31Var, oo3 oo3Var, f30 f30Var) throws Throwable {
        Object objC = c(a31Var, oo3Var, true, f30Var);
        return objC == kl1.e() ? objC : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
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
    */
    public static final Object c(a31 a31Var, oo3 oo3Var, boolean z, f30 f30Var) throws Throwable {
        a aVar;
        bs it;
        bs bsVar;
        a31 a31Var2;
        Object objB;
        if (f30Var instanceof a) {
            aVar = (a) f30Var;
            int i = aVar.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.k = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(f30Var);
            }
        }
        Object obj = aVar.j;
        Object objE = kl1.e();
        int i2 = aVar.k;
        try {
            if (i2 == 0) {
                lt3.b(obj);
                c31.g(a31Var);
                it = oo3Var.iterator();
                aVar.f = a31Var;
                aVar.g = oo3Var;
                aVar.h = it;
                aVar.i = z;
                aVar.k = 1;
                objB = it.b(aVar);
                if (objB != objE) {
                }
            } else if (i2 == 1) {
                z = aVar.i;
                bsVar = (bs) aVar.h;
                oo3Var = (oo3) aVar.g;
                a31Var2 = (a31) aVar.f;
                lt3.b(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i2 != 2) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                z = aVar.i;
                bsVar = (bs) aVar.h;
                oo3Var = (oo3) aVar.g;
                a31Var2 = (a31) aVar.f;
                lt3.b(obj);
                it = bsVar;
                a31Var = a31Var2;
                aVar.f = a31Var;
                aVar.g = oo3Var;
                aVar.h = it;
                aVar.i = z;
                aVar.k = 1;
                objB = it.b(aVar);
                if (objB != objE) {
                    return objE;
                }
                a31Var2 = a31Var;
                bsVar = it;
                obj = objB;
                if (((Boolean) obj).booleanValue()) {
                    if (z) {
                        hs.a(oo3Var, null);
                    }
                    return fw4.a;
                }
                Object next = bsVar.next();
                aVar.f = a31Var2;
                aVar.g = oo3Var;
                aVar.h = bsVar;
                aVar.i = z;
                aVar.k = 2;
            }
        } finally {
        }
    }
}
