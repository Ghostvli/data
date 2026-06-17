package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wf4 {
    public final int a;
    public final b b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        NONE,
        STREAM,
        CHANNEL,
        PLAYLIST
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final String a;
        public final Set b;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum a {
            AUDIO,
            VIDEO,
            LIVE,
            COMMENTS
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, Set set) {
            this.a = str;
            this.b = set;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String a() {
            return this.a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wf4(int i, String str, Set set) {
        this.a = i;
        this.b = new b(str, set);
    }

    public abstract gu1 a();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public m20 b() {
        m20 m20VarB = a33.b();
        return j().contains(m20VarB) ? m20VarB : m20.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final a c(String str) {
        String strG = yy4.g(str);
        wt1 wt1VarI = i();
        gu1 gu1VarA = a();
        gu1 gu1VarE = e();
        return (wt1VarI == null || !wt1VarI.a(strG)) ? (gu1VarA == null || !gu1VarA.a(strG)) ? (gu1VarE == null || !gu1VarE.a(strG)) ? a.NONE : a.PLAYLIST : a.CHANNEL : a.STREAM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pz1 d() {
        pz1 pz1VarC = a33.c();
        if (k().contains(pz1VarC)) {
            return pz1VarC;
        }
        for (pz1 pz1Var : k()) {
            if (pz1Var.e().equals(pz1VarC.e())) {
                return pz1Var;
            }
        }
        return pz1.h;
    }

    public abstract gu1 e();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int f() {
        return this.a;
    }

    public abstract ue4 g(vt1 vt1Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ue4 h(String str) {
        return g(i().c(str));
    }

    public abstract wt1 i();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List j() {
        return Collections.singletonList(m20.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List k() {
        return Collections.singletonList(pz1.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public go4 l(pz1 pz1Var) {
        go4 go4VarB;
        go4 go4VarB2 = ho4.b(pz1Var);
        if (go4VarB2 != null) {
            return go4VarB2;
        }
        if (!pz1Var.d().isEmpty() && (go4VarB = ho4.b(new pz1(pz1Var.e()))) != null) {
            return go4VarB;
        }
        f02.a("Localization is not supported (\"", pz1Var, "\")");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.a + ":" + this.b.a();
    }
}
