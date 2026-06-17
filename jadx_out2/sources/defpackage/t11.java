package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class t11 extends qg3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float e(float f) {
        return f < 1.0f ? 1.0f / f : f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qg3
    public float c(c94 c94Var, c94 c94Var2) {
        int i = c94Var.f;
        if (i <= 0 || c94Var.g <= 0) {
            return 0.0f;
        }
        float fE = (1.0f / e((i * 1.0f) / c94Var2.f)) / e((c94Var.g * 1.0f) / c94Var2.g);
        float fE2 = e(((c94Var.f * 1.0f) / c94Var.g) / ((c94Var2.f * 1.0f) / c94Var2.g));
        return fE * (((1.0f / fE2) / fE2) / fE2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qg3
    public Rect d(c94 c94Var, c94 c94Var2) {
        return new Rect(0, 0, c94Var2.f, c94Var2.g);
    }
}
