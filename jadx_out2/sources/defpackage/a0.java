package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 implements z21 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends g30 {
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return a0.this.collect(null, this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.z21
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(a31 a31Var, f30 f30Var) throws Throwable {
        a aVar;
        tw3 tw3Var;
        if (f30Var instanceof a) {
            aVar = (a) f30Var;
            int i = aVar.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.i = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(f30Var);
            }
        }
        Object obj = aVar.g;
        Object objE = kl1.e();
        int i2 = aVar.i;
        if (i2 != 0) {
            if (i2 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            tw3Var = (tw3) aVar.f;
            try {
                lt3.b(obj);
                tw3Var.releaseIntercepted();
                return fw4.a;
            } catch (Throwable th) {
                th = th;
                tw3Var.releaseIntercepted();
                throw th;
            }
        }
        lt3.b(obj);
        tw3 tw3Var2 = new tw3(a31Var, aVar.getContext());
        try {
            aVar.f = tw3Var2;
            aVar.i = 1;
            if (e(tw3Var2, aVar) == objE) {
                return objE;
            }
            tw3Var = tw3Var2;
            tw3Var.releaseIntercepted();
            return fw4.a;
        } catch (Throwable th2) {
            th = th2;
            tw3Var = tw3Var2;
            tw3Var.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object e(a31 a31Var, f30 f30Var);
}
