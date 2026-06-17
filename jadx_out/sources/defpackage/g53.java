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

    public boolean c(jz0 jz0Var) {
        return d(jz0Var, -1L);
    }

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
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(defpackage.jz0 r9, long r10) {
        /*
            r8 = this;
            long r0 = r9.getPosition()
            long r2 = r9.k()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            defpackage.gg3.d(r0)
            r73 r0 = r8.k
            r3 = 4
            r0.b0(r3)
        L1a:
            r4 = -1
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L2b
            long r4 = r9.getPosition()
            r6 = 4
            long r4 = r4 + r6
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 >= 0) goto L51
        L2b:
            r73 r4 = r8.k
            byte[] r4 = r4.f()
            boolean r4 = defpackage.nz0.c(r9, r4, r1, r3, r2)
            if (r4 == 0) goto L51
            r73 r0 = r8.k
            r0.f0(r1)
            r73 r0 = r8.k
            long r4 = r0.S()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L4d
            r9.p()
            return r2
        L4d:
            r9.q(r2)
            goto L1a
        L51:
            if (r0 == 0) goto L5b
            long r3 = r9.getPosition()
            int r8 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r8 >= 0) goto L63
        L5b:
            int r8 = r9.b(r2)
            r3 = -1
            if (r8 == r3) goto L63
            goto L51
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g53.d(jz0, long):boolean");
    }
}
