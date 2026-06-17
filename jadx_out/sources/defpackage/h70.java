package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class h70 extends e40 {
    public float a = -1.0f;

    @Override // defpackage.e40
    public void a(k54 k54Var, float f, float f2, float f3) {
        float f4 = f3 * f2;
        k54Var.o(0.0f, f4, 180.0f, 180.0f - f);
        double d = f4;
        k54Var.m((float) (Math.sin(Math.toRadians(f)) * d), (float) (Math.sin(Math.toRadians(90.0f - f)) * d));
    }
}
