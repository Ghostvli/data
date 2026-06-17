package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 {
    public static final f0 ALWAYS;
    public static final f0 EXCEEDS_PAD;
    public static final f0 NEVER;
    public static final f0 NORMAL;
    public static final f0 NOT_NEGATIVE;
    public static final /* synthetic */ f0[] a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        f0 f0Var = new f0("NORMAL", 0);
        NORMAL = f0Var;
        f0 f0Var2 = new f0("ALWAYS", 1);
        ALWAYS = f0Var2;
        f0 f0Var3 = new f0("NEVER", 2);
        NEVER = f0Var3;
        f0 f0Var4 = new f0("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = f0Var4;
        f0 f0Var5 = new f0("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = f0Var5;
        a = new f0[]{f0Var, f0Var2, f0Var3, f0Var4, f0Var5};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f0 valueOf(String str) {
        return (f0) Enum.valueOf(f0.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f0[] values() {
        return (f0[]) a.clone();
    }
}
