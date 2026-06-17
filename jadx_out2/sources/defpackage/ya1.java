package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ya1 extends er1 {
    public final wa1 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ya1(List list) {
        super(list);
        int iMax = 0;
        for (int i = 0; i < list.size(); i++) {
            wa1 wa1Var = (wa1) ((dr1) list.get(i)).b;
            if (wa1Var != null) {
                iMax = Math.max(iMax, wa1Var.f());
            }
        }
        this.i = new wa1(new float[iMax], new int[iMax]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i(Ldr1;F)Ljava/lang/Object; */
    @Override // defpackage.zh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public wa1 i(dr1 dr1Var, float f) {
        this.i.g((wa1) dr1Var.b, (wa1) dr1Var.c, f);
        return this.i;
    }
}
