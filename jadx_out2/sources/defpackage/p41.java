package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class p41 extends br0 {
    public static final su0 q = m04.a(fg4.r(s54.a, ", "));
    public final er0 p;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p41(al4 al4Var, String str, xb xbVar) {
        super(al4Var, str, xbVar);
        this.p = new er0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l33
    public void R(l33 l33Var) {
        super.R(l33Var);
        this.p.remove(l33Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p41 c1(br0 br0Var) {
        this.p.add(br0Var);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: clone()Ljava/lang/Object; */
    /* JADX DEBUG: Method merged with bridge method: m0()Lbr0; */
    /* JADX DEBUG: Method merged with bridge method: n()Ll33; */
    @Override // defpackage.br0, defpackage.l33
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public p41 clone() {
        return (p41) super.clone();
    }
}
