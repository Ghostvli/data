package defpackage;

import defpackage.es;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class d00 extends yl {
    public final int r;
    public final tl s;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d00(int i, tl tlVar, Function1 function1) {
        super(i, function1);
        this.r = i;
        this.s = tlVar;
        if (tlVar == tl.f) {
            vq3.a("This implementation does not support suspension for senders, use ", np3.b(yl.class).c(), " instead");
            throw null;
        }
        if (i >= 1) {
            return;
        }
        i04.a("Buffered channel capacity must be at least 1, but ", i, " was specified");
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object S0(d00 d00Var, Object obj, f30 f30Var) throws Throwable {
        xv4 xv4VarC;
        Object objU0 = d00Var.U0(obj, true);
        if (!(objU0 instanceof es.a)) {
            return fw4.a;
        }
        es.c(objU0);
        Function1 function1 = d00Var.g;
        if (function1 == null || (xv4VarC = p63.c(function1, obj, null, 2, null)) == null) {
            throw d00Var.U();
        }
        mv0.a(xv4VarC, d00Var.U());
        throw xv4VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object T0(Object obj, boolean z) {
        Function1 function1;
        xv4 xv4VarC;
        Object objH0 = super.H0(obj);
        if (es.e(objH0) || es.d(objH0)) {
            return objH0;
        }
        if (!z || (function1 = this.g) == null || (xv4VarC = p63.c(function1, obj, null, 2, null)) == null) {
            return es.a.c(fw4.a);
        }
        throw xv4VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object U0(Object obj, boolean z) {
        return this.s == tl.h ? T0(obj, z) : I0(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yl, defpackage.t04
    public Object b(Object obj, f30 f30Var) {
        return S0(this, obj, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yl
    public boolean j0() {
        return this.s == tl.g;
    }
}
