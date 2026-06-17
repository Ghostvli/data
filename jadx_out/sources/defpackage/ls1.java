package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ls1 {
    public static final ls1 f = new ls1("SYNCHRONIZED", 0);
    public static final ls1 g = new ls1("PUBLICATION", 1);
    public static final ls1 h = new ls1("NONE", 2);
    public static final /* synthetic */ ls1[] i;
    public static final /* synthetic */ gt0 j;

    static {
        ls1[] ls1VarArrA = a();
        i = ls1VarArrA;
        j = ht0.a(ls1VarArrA);
    }

    public ls1(String str, int i2) {
    }

    public static final /* synthetic */ ls1[] a() {
        return new ls1[]{f, g, h};
    }

    public static ls1 valueOf(String str) {
        return (ls1) Enum.valueOf(ls1.class, str);
    }

    public static ls1[] values() {
        return (ls1[]) i.clone();
    }
}
