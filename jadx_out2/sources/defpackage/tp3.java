package defpackage;

import java.util.regex.MatchResult;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tp3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final sk1 c(MatchResult matchResult) {
        return xn3.j(matchResult.start(), matchResult.end());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final sk1 d(MatchResult matchResult, int i) {
        return xn3.j(matchResult.start(i), matchResult.end(i));
    }
}
