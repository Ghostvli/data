package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class tl {
    public static final tl f = new tl("SUSPEND", 0);
    public static final tl g = new tl("DROP_OLDEST", 1);
    public static final tl h = new tl("DROP_LATEST", 2);
    public static final /* synthetic */ tl[] i;
    public static final /* synthetic */ gt0 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        tl[] tlVarArrA = a();
        i = tlVarArrA;
        j = ht0.a(tlVarArrA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tl(String str, int i2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final /* synthetic */ tl[] a() {
        return new tl[]{f, g, h};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static tl valueOf(String str) {
        return (tl) Enum.valueOf(tl.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static tl[] values() {
        return (tl[]) i.clone();
    }
}
