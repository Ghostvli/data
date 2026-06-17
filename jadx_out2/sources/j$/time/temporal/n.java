package j$.time.temporal;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n implements m {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public /* synthetic */ n(int i, int i2) {
        this.a = i2;
        this.b = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.m
    public final l e(l lVar) {
        int i = this.a;
        int i2 = this.b;
        switch (i) {
            case 0:
                int iG = lVar.g(a.DAY_OF_WEEK);
                if (iG == i2) {
                    return lVar;
                }
                return lVar.d(iG - i2 >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
            default:
                int iG2 = lVar.g(a.DAY_OF_WEEK);
                if (iG2 == i2) {
                    return lVar;
                }
                return lVar.a(i2 - iG2 >= 0 ? 7 - r2 : -r2, ChronoUnit.DAYS);
        }
    }
}
