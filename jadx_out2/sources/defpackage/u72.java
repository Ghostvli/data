package defpackage;

import defpackage.p83;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class u72 extends wt1 {
    public static final u72 a = new u72();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static u72 i() {
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public String e(String str) {
        String strK;
        try {
            strK = p83.k("streaming\\.media\\.ccc\\.de\\/(\\w+\\/\\w+)", str);
        } catch (p83.a unused) {
            strK = null;
        }
        return strK == null ? p83.k("(?:(?:(?:api\\.)?media\\.ccc\\.de/public/events/)|(?:media\\.ccc\\.de/v/))([^/?&#]*)", str) : strK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public String f(String str) {
        if (q72.f(str)) {
            return "https://streaming.media.ccc.de/" + str;
        }
        return "https://media.ccc.de/v/" + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public boolean h(String str) {
        return e(str) != null;
    }
}
