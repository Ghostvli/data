package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class a60 implements yh4 {
    public static final x63 h = x63.d().f(new p81() { // from class: z50
        @Override // defpackage.p81
        public final Object apply(Object obj) {
            return Long.valueOf(a60.g(((y50) obj).b));
        }
    });
    public final xi1 f;
    public final long[] g;

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a60(java.util.List r15) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a60.<init>(java.util.List):void");
    }

    public static long g(long j) {
        if (j == -9223372036854775807L) {
            return 0L;
        }
        return j;
    }

    @Override // defpackage.yh4
    public int a(long j) {
        int iG = fy4.g(this.g, j, false, false);
        if (iG < this.f.size()) {
            return iG;
        }
        return -1;
    }

    @Override // defpackage.yh4
    public long b(int i) {
        gg3.d(i < this.f.size());
        return this.g[i];
    }

    @Override // defpackage.yh4
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public xi1 e(long j) {
        int iK = fy4.k(this.g, j, true, false);
        return iK == -1 ? xi1.u() : (xi1) this.f.get(iK);
    }

    @Override // defpackage.yh4
    public int f() {
        return this.f.size();
    }
}
