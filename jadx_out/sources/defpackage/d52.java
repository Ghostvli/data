package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d52 extends qq0 {
    public final float a;

    public d52(float f) {
        this.a = f - 0.001f;
    }

    @Override // defpackage.qq0
    public boolean a() {
        return true;
    }

    @Override // defpackage.qq0
    public void b(float f, float f2, float f3, k54 k54Var) {
        float fSqrt = (float) ((((double) this.a) * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.a, 2.0d) - Math.pow(fSqrt, 2.0d));
        k54Var.n(f2 - fSqrt, ((float) (-((((double) this.a) * Math.sqrt(2.0d)) - ((double) this.a)))) + fSqrt2);
        k54Var.m(f2, (float) (-((((double) this.a) * Math.sqrt(2.0d)) - ((double) this.a))));
        k54Var.m(f2 + fSqrt, ((float) (-((((double) this.a) * Math.sqrt(2.0d)) - ((double) this.a)))) + fSqrt2);
    }
}
