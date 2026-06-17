package defpackage;

import android.graphics.PointF;
import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ef3 implements cz4 {
    public static final ef3 a = new ef3();

    @Override // defpackage.cz4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(no1 no1Var, float f) {
        no1.b bVarK = no1Var.K();
        if (bVarK == no1.b.BEGIN_ARRAY) {
            return wo1.e(no1Var, f);
        }
        if (bVarK == no1.b.BEGIN_OBJECT) {
            return wo1.e(no1Var, f);
        }
        if (bVarK != no1.b.NUMBER) {
            c.a("Cannot convert json to point. Next token is ", bVarK);
            return null;
        }
        PointF pointF = new PointF(((float) no1Var.v()) * f, ((float) no1Var.v()) * f);
        while (no1Var.t()) {
            no1Var.O();
        }
        return pointF;
    }
}
