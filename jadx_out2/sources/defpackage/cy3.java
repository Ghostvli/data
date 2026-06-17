package defpackage;

import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cy3 implements cz4 {
    public static final cy3 a = new cy3();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Lno1;F)Ljava/lang/Object; */
    @Override // defpackage.cz4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public by3 a(no1 no1Var, float f) {
        boolean z = no1Var.K() == no1.b.BEGIN_ARRAY;
        if (z) {
            no1Var.c();
        }
        float fV = (float) no1Var.v();
        float fV2 = (float) no1Var.v();
        while (no1Var.t()) {
            no1Var.O();
        }
        if (z) {
            no1Var.i();
        }
        return new by3((fV / 100.0f) * f, (fV2 / 100.0f) * f);
    }
}
