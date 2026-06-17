package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class az0 {
    public static final yy0 a = new zy0();
    public static final yy0 b = c();

    public static yy0 a() {
        yy0 yy0Var = b;
        if (yy0Var != null) {
            return yy0Var;
        }
        e04.a("Protobuf runtime is not correctly loaded.");
        return null;
    }

    public static yy0 b() {
        return a;
    }

    public static yy0 c() {
        if (s5.b) {
            return null;
        }
        try {
            return (yy0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
