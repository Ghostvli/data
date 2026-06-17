package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    public static final e0 LENIENT;
    public static final e0 SMART;
    public static final e0 STRICT;
    public static final /* synthetic */ e0[] a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        e0 e0Var = new e0("STRICT", 0);
        STRICT = e0Var;
        e0 e0Var2 = new e0("SMART", 1);
        SMART = e0Var2;
        e0 e0Var3 = new e0("LENIENT", 2);
        LENIENT = e0Var3;
        a = new e0[]{e0Var, e0Var2, e0Var3};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e0 valueOf(String str) {
        return (e0) Enum.valueOf(e0.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e0[] values() {
        return (e0[]) a.clone();
    }
}
