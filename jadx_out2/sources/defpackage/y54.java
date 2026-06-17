package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class y54 {
    public static final y54 f = new y54("START", 0);
    public static final y54 g = new y54("STOP", 1);
    public static final y54 h = new y54("STOP_AND_RESET_REPLAY_CACHE", 2);
    public static final /* synthetic */ y54[] i;
    public static final /* synthetic */ gt0 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        y54[] y54VarArrA = a();
        i = y54VarArrA;
        j = ht0.a(y54VarArrA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y54(String str, int i2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final /* synthetic */ y54[] a() {
        return new y54[]{f, g, h};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static y54 valueOf(String str) {
        return (y54) Enum.valueOf(y54.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static y54[] values() {
        return (y54[]) i.clone();
    }
}
