package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rd4 implements x72 {
    public final zu f;
    public boolean g;
    public long h;
    public long i;
    public dc3 j = dc3.d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rd4(zu zuVar) {
        this.f = zuVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(long j) {
        this.h = j;
        if (this.g) {
            this.i = this.f.e();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        if (this.g) {
            return;
        }
        this.i = this.f.e();
        this.g = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c() {
        if (this.g) {
            a(e());
            this.g = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public long e() {
        long j = this.h;
        if (!this.g) {
            return j;
        }
        long jE = this.f.e() - this.i;
        dc3 dc3Var = this.j;
        return j + (dc3Var.a == 1.0f ? fy4.c1(jE) : dc3Var.b(jE));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public dc3 getPlaybackParameters() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public void setPlaybackParameters(dc3 dc3Var) {
        if (this.g) {
            a(e());
        }
        this.j = dc3Var;
    }
}
