package defpackage;

import defpackage.g40;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g30 extends hh {
    private final g40 _context;
    private transient f30 intercepted;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g30(f30 f30Var) {
        this(f30Var, f30Var != null ? f30Var.getContext() : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f30
    public g40 getContext() {
        g40 g40Var = this._context;
        g40Var.getClass();
        return g40Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final f30 intercepted() {
        f30 f30VarQ = this.intercepted;
        if (f30VarQ == null) {
            h30 h30Var = (h30) getContext().a(h30.b);
            if (h30Var == null || (f30VarQ = h30Var.Q(this)) == null) {
                f30VarQ = this;
            }
            this.intercepted = f30VarQ;
        }
        return f30VarQ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hh
    public void releaseIntercepted() {
        f30 f30Var = this.intercepted;
        if (f30Var != null && f30Var != this) {
            g40.b bVarA = getContext().a(h30.b);
            bVarA.getClass();
            ((h30) bVarA).Z(f30Var);
        }
        this.intercepted = yx.f;
    }

    public g30(f30 f30Var, g40 g40Var) {
        super(f30Var);
        this._context = g40Var;
    }
}
