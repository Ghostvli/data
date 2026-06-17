package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class og extends wt1 {
    public static final og a = new og();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static og i() {
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public String e(String str) {
        return dg.h(str) ? str.split("bandcamp.com/\\?show=")[1] : f(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public String f(String str) {
        return str.matches("\\d+") ? "https://bandcamp.com/?show=".concat(str) : yy4.u(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public boolean h(String str) {
        if (dg.h(str)) {
            return true;
        }
        if (str.toLowerCase().matches("https?://.+\\..+/track/.+")) {
            return dg.g(str);
        }
        return false;
    }
}
