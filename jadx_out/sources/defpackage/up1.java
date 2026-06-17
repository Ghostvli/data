package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class up1 {
    public static final up1 f = new up1("PUBLIC", 0);
    public static final up1 g = new up1("PROTECTED", 1);
    public static final up1 h = new up1("INTERNAL", 2);
    public static final up1 i = new up1("PRIVATE", 3);
    public static final /* synthetic */ up1[] j;
    public static final /* synthetic */ gt0 k;

    static {
        up1[] up1VarArrA = a();
        j = up1VarArrA;
        k = ht0.a(up1VarArrA);
    }

    public up1(String str, int i2) {
    }

    public static final /* synthetic */ up1[] a() {
        return new up1[]{f, g, h, i};
    }

    public static up1 valueOf(String str) {
        return (up1) Enum.valueOf(up1.class, str);
    }

    public static up1[] values() {
        return (up1[]) j.clone();
    }
}
