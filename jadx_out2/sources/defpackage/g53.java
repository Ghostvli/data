package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class g53 {
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    public final r73 k = new r73(255);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a(jz0 jz0Var, boolean z) throws r83 {
        b();
        this.k.b0(27);
        if (!nz0.c(jz0Var, this.k.f(), 0, 27, z) || this.k.S() != 1332176723) {
            return false;
        }
        int iQ = this.k.Q();
        this.a = iQ;
        if (iQ != 0) {
            if (z) {
                return false;
            }
            throw r83.e("unsupported bit stream revision");
        }
        this.b = this.k.Q();
        this.c = this.k.E();
        this.d = this.k.G();
        this.e = this.k.G();
        this.f = this.k.G();
        int iQ2 = this.k.Q();
        this.g = iQ2;
        this.h = iQ2 + 27;
        this.k.b0(iQ2);
        if (!nz0.c(jz0Var, this.k.f(), 0, this.g, z)) {
            return false;
        }
        for (int i = 0; i < this.g; i++) {
            this.j[i] = this.k.Q();
            this.i += this.j[i];
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c(jz0 jz0Var) {
        return d(jz0Var, -1L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.b(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(jz0 jz0Var, long j) {
        gg3.d(jz0Var.getPosition() == jz0Var.k());
        this.k.b0(4);
        while (true) {
            if ((j != -1 && jz0Var.getPosition() + 4 >= j) || !nz0.c(jz0Var, this.k.f(), 0, 4, true)) {
                break;
            }
            this.k.f0(0);
            if (this.k.S() == 1332176723) {
                jz0Var.p();
                return true;
            }
            jz0Var.q(1);
        }
    }
}
