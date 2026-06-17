package defpackage;

import android.graphics.Rect;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class r11 extends qg3 {
    public static final String b = "r11";

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qg3
    public float c(c94 c94Var, c94 c94Var2) {
        if (c94Var.f <= 0 || c94Var.g <= 0) {
            return 0.0f;
        }
        c94 c94VarF = c94Var.f(c94Var2);
        float fPow = (c94VarF.f * 1.0f) / c94Var.f;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f = ((c94Var2.f * 1.0f) / c94VarF.f) * ((c94Var2.g * 1.0f) / c94VarF.g);
        return fPow * (((1.0f / f) / f) / f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qg3
    public Rect d(c94 c94Var, c94 c94Var2) {
        c94 c94VarF = c94Var.f(c94Var2);
        Log.i(b, "Preview: " + c94Var + "; Scaled: " + c94VarF + "; Want: " + c94Var2);
        int i = (c94VarF.f - c94Var2.f) / 2;
        int i2 = (c94VarF.g - c94Var2.g) / 2;
        return new Rect(-i, -i2, c94VarF.f - i, c94VarF.g - i2);
    }
}
