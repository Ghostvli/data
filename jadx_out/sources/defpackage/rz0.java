package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class rz0 extends ih {
    public float L = 0.0f;
    public float M = -1.0f;
    public float[] N = null;
    public float O;
    public float P;
    public int Q;

    public rz0(up0 up0Var) {
        this.q = up0Var;
    }

    public float F(fh1 fh1Var) {
        if (this.Q == fh1Var.b() && this.P == this.o) {
            return this.O;
        }
        float fB = (fh1Var.b() - this.o) / 2.0f;
        this.Q = fh1Var.b();
        this.P = this.o;
        this.O = fB;
        return fB;
    }

    @Override // defpackage.ih
    public float d() {
        return this.M + this.p;
    }

    @Override // defpackage.ih
    public float g() {
        return this.L;
    }

    @Override // defpackage.ih
    public float[] h(fh1 fh1Var, long j) {
        if (!q()) {
            return null;
        }
        float F = F(fh1Var);
        if (this.N == null) {
            this.N = new float[4];
        }
        float[] fArr = this.N;
        fArr[0] = F;
        float f = this.M;
        fArr[1] = f;
        fArr[2] = F + this.o;
        fArr[3] = f + this.p;
        return fArr;
    }

    @Override // defpackage.ih
    public float i() {
        return this.L + this.o;
    }

    @Override // defpackage.ih
    public float l() {
        return this.M;
    }

    @Override // defpackage.ih
    public int m() {
        return 5;
    }

    @Override // defpackage.ih
    public void y(fh1 fh1Var, float f, float f2) {
        b90 b90Var = this.D;
        if (b90Var != null) {
            long jB = b90Var.a - b();
            if (jB <= 0 || jB >= this.q.h) {
                E(false);
                this.M = -1.0f;
                this.L = fh1Var.b();
            } else {
                if (v()) {
                    return;
                }
                this.L = F(fh1Var);
                this.M = f2;
                E(true);
            }
        }
    }
}
