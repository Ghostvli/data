package defpackage;

import android.graphics.Rect;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class hr extends qg3 {
    public static final String b = "hr";

    @Override // defpackage.qg3
    public float c(c94 c94Var, c94 c94Var2) {
        if (c94Var.f <= 0 || c94Var.g <= 0) {
            return 0.0f;
        }
        c94 c94VarE = c94Var.e(c94Var2);
        float fPow = (c94VarE.f * 1.0f) / c94Var.f;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f = ((c94VarE.f * 1.0f) / c94Var2.f) + ((c94VarE.g * 1.0f) / c94Var2.g);
        return fPow * ((1.0f / f) / f);
    }

    @Override // defpackage.qg3
    public Rect d(c94 c94Var, c94 c94Var2) {
        c94 c94VarE = c94Var.e(c94Var2);
        Log.i(b, "Preview: " + c94Var + "; Scaled: " + c94VarE + "; Want: " + c94Var2);
        int i = (c94VarE.f - c94Var2.f) / 2;
        int i2 = (c94VarE.g - c94Var2.g) / 2;
        return new Rect(-i, -i2, c94VarE.f - i, c94VarE.g - i2);
    }
}
