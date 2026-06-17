package defpackage;

import android.graphics.Color;
import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class dx implements cz4 {
    public static final dx a = new dx();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Lno1;F)Ljava/lang/Object; */
    @Override // defpackage.cz4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(no1 no1Var, float f) {
        boolean z = no1Var.K() == no1.b.BEGIN_ARRAY;
        if (z) {
            no1Var.c();
        }
        double dV = no1Var.v();
        double dV2 = no1Var.v();
        double dV3 = no1Var.v();
        double dV4 = no1Var.K() == no1.b.NUMBER ? no1Var.v() : 1.0d;
        if (z) {
            no1Var.i();
        }
        if (dV <= 1.0d && dV2 <= 1.0d && dV3 <= 1.0d) {
            dV *= 255.0d;
            dV2 *= 255.0d;
            dV3 *= 255.0d;
            if (dV4 <= 1.0d) {
                dV4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dV4, (int) dV, (int) dV2, (int) dV3));
    }
}
