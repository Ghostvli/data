package defpackage;

import android.graphics.PointF;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.no1;
import defpackage.xm0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ym0 implements cz4 {
    public static final ym0 a = new ym0();
    public static final no1.a b = no1.a.a("t", "f", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    @Override // defpackage.cz4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public xm0 a(no1 no1Var, float f) {
        xm0.a aVar = xm0.a.CENTER;
        no1Var.h();
        xm0.a aVar2 = aVar;
        String strF = null;
        String strF2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fV = 0.0f;
        float fV2 = 0.0f;
        float fV3 = 0.0f;
        float fV4 = 0.0f;
        int iY = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zU = true;
        while (no1Var.t()) {
            switch (no1Var.M(b)) {
                case 0:
                    strF = no1Var.F();
                    break;
                case 1:
                    strF2 = no1Var.F();
                    break;
                case 2:
                    fV = (float) no1Var.v();
                    break;
                case 3:
                    int iY2 = no1Var.y();
                    aVar2 = xm0.a.CENTER;
                    if (iY2 <= aVar2.ordinal() && iY2 >= 0) {
                        aVar2 = xm0.a.values()[iY2];
                    }
                    break;
                case 4:
                    iY = no1Var.y();
                    break;
                case 5:
                    fV2 = (float) no1Var.v();
                    break;
                case 6:
                    fV3 = (float) no1Var.v();
                    break;
                case 7:
                    iD = wo1.d(no1Var);
                    break;
                case 8:
                    iD2 = wo1.d(no1Var);
                    break;
                case 9:
                    fV4 = (float) no1Var.v();
                    break;
                case 10:
                    zU = no1Var.u();
                    break;
                case 11:
                    no1Var.c();
                    PointF pointF3 = new PointF(((float) no1Var.v()) * f, ((float) no1Var.v()) * f);
                    no1Var.i();
                    pointF = pointF3;
                    break;
                case 12:
                    no1Var.c();
                    PointF pointF4 = new PointF(((float) no1Var.v()) * f, ((float) no1Var.v()) * f);
                    no1Var.i();
                    pointF2 = pointF4;
                    break;
                default:
                    no1Var.N();
                    no1Var.O();
                    break;
            }
        }
        no1Var.l();
        return new xm0(strF, strF2, fV, aVar2, iY, fV2, fV3, iD, iD2, fV4, zU, pointF, pointF2);
    }
}
