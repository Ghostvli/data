package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class nn3 extends ih {
    public int N;
    public float P;
    public long Q;
    public float L = 0.0f;
    public float M = -1.0f;
    public float[] O = null;

    public nn3(up0 up0Var) {
        this.q = up0Var;
    }

    public float F(fh1 fh1Var, long j) {
        long jB = j - b();
        return jB >= this.q.h ? -this.o : fh1Var.b() - (jB * this.P);
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
        float F = F(fh1Var, j);
        if (this.O == null) {
            this.O = new float[4];
        }
        float[] fArr = this.O;
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
        return 1;
    }

    @Override // defpackage.ih
    public void y(fh1 fh1Var, float f, float f2) {
        b90 b90Var = this.D;
        if (b90Var != null) {
            long j = b90Var.a;
            long jB = j - b();
            if (jB > 0 && jB < this.q.h) {
                this.L = F(fh1Var, j);
                if (!v()) {
                    this.M = f2;
                    E(true);
                }
                this.Q = j;
                return;
            }
            this.Q = j;
        }
        E(false);
    }

    @Override // defpackage.ih
    public void z(fh1 fh1Var, boolean z) {
        super.z(fh1Var, z);
        int iB = (int) (fh1Var.b() + this.o);
        this.N = iB;
        this.P = iB / this.q.h;
    }
}
