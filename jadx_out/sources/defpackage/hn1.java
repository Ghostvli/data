package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'j' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class hn1 {
    public static final hn1 i = new hn1("VOID", 0, Void.class, Void.class, null);
    public static final hn1 j;
    public static final hn1 k;
    public static final hn1 l;
    public static final hn1 m;
    public static final hn1 n;
    public static final hn1 o;
    public static final hn1 p;
    public static final hn1 q;
    public static final hn1 r;
    public static final /* synthetic */ hn1[] s;
    public final Class f;
    public final Class g;
    public final Object h;

    static {
        Class cls = Integer.TYPE;
        j = new hn1("INT", 1, cls, Integer.class, 0);
        k = new hn1("LONG", 2, Long.TYPE, Long.class, 0L);
        l = new hn1("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        m = new hn1("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        n = new hn1("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        o = new hn1("STRING", 6, String.class, String.class, "");
        p = new hn1("BYTE_STRING", 7, hn.class, hn.class, hn.g);
        q = new hn1("ENUM", 8, cls, Integer.class, null);
        r = new hn1("MESSAGE", 9, Object.class, Object.class, null);
        s = a();
    }

    public hn1(String str, int i2, Class cls, Class cls2, Object obj) {
        this.f = cls;
        this.g = cls2;
        this.h = obj;
    }

    public static /* synthetic */ hn1[] a() {
        return new hn1[]{i, j, k, l, m, n, o, p, q, r};
    }

    public static hn1 valueOf(String str) {
        return (hn1) Enum.valueOf(hn1.class, str);
    }

    public static hn1[] values() {
        return (hn1[]) s.clone();
    }

    public Class b() {
        return this.g;
    }
}
