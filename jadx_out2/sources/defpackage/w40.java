package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class w40 {
    public static final w40 f = new w40("COROUTINE_SUSPENDED", 0);
    public static final w40 g = new w40("UNDECIDED", 1);
    public static final w40 h = new w40("RESUMED", 2);
    public static final /* synthetic */ w40[] i;
    public static final /* synthetic */ gt0 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        w40[] w40VarArrA = a();
        i = w40VarArrA;
        j = ht0.a(w40VarArrA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public w40(String str, int i2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final /* synthetic */ w40[] a() {
        return new w40[]{f, g, h};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static w40 valueOf(String str) {
        return (w40) Enum.valueOf(w40.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static w40[] values() {
        return (w40[]) i.clone();
    }
}
