package defpackage;

import j$.time.LocalDateTime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ho4 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t93 a(pz1 pz1Var) {
        return u93.a(pz1Var.e(), pz1Var.d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static go4 b(pz1 pz1Var) {
        return c(pz1Var, LocalDateTime.now());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static go4 c(pz1 pz1Var, LocalDateTime localDateTime) {
        t93 t93VarA = a(pz1Var);
        if (t93VarA == null) {
            return null;
        }
        return new go4(t93VarA, localDateTime);
    }
}
