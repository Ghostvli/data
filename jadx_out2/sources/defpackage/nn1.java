package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class nn1 extends sn1 implements wx {
    public final boolean h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nn1(ln1 ln1Var) {
        super(true);
        j0(ln1Var);
        this.h = O0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean O0() {
        sn1 sn1VarV;
        gt gtVarD0 = d0();
        ht htVar = gtVarD0 instanceof ht ? (ht) gtVarD0 : null;
        if (htVar != null && (sn1VarV = htVar.v()) != null) {
            while (!sn1VarV.X()) {
                gt gtVarD02 = sn1VarV.d0();
                ht htVar2 = gtVarD02 instanceof ht ? (ht) gtVarD02 : null;
                if (htVar2 == null || (sn1VarV = htVar2.v()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sn1
    public boolean X() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sn1
    public boolean Y() {
        return true;
    }
}
