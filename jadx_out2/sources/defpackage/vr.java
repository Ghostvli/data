package defpackage;

import defpackage.h30;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vr extends tr {
    public final z21 i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(f30 f30Var) {
            super(2, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            a aVar = vr.this.new a(f30Var);
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
                vr vrVar = vr.this;
                this.f = 1;
                if (vrVar.q(a31Var, this) == objE) {
                    return objE;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vr(z21 z21Var, g40 g40Var, int i, tl tlVar) {
        super(g40Var, i, tlVar);
        this.i = z21Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object n(vr vrVar, a31 a31Var, f30 f30Var) {
        if (vrVar.g == -3) {
            g40 context = f30Var.getContext();
            g40 g40VarG = k40.g(context, vrVar.f);
            if (il1.a(g40VarG, context)) {
                Object objQ = vrVar.q(a31Var, f30Var);
                return objQ == kl1.e() ? objQ : fw4.a;
            }
            h30.b bVar = h30.b;
            if (il1.a(g40VarG.a(bVar), context.a(bVar))) {
                Object objP = vrVar.p(a31Var, g40VarG, f30Var);
                return objP == kl1.e() ? objP : fw4.a;
            }
        }
        Object objCollect = super.collect(a31Var, f30Var);
        return objCollect == kl1.e() ? objCollect : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object o(vr vrVar, eh3 eh3Var, f30 f30Var) {
        Object objQ = vrVar.q(new v04(eh3Var), f30Var);
        return objQ == kl1.e() ? objQ : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tr, defpackage.z21
    public Object collect(a31 a31Var, f30 f30Var) {
        return n(this, a31Var, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tr
    public Object h(eh3 eh3Var, f30 f30Var) {
        return o(this, eh3Var, f30Var);
    }

    /* JADX DEBUG: Class process forced to load method for inline: ur.a(a31, g40):a31 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object p(a31 a31Var, g40 g40Var, f30 f30Var) {
        return ur.c(g40Var, ur.d(a31Var, f30Var.getContext()), null, new a(null), f30Var, 4, null);
    }

    public abstract Object q(a31 a31Var, f30 f30Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tr
    public String toString() {
        return this.i + " -> " + super.toString();
    }
}
