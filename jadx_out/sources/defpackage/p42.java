package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p42 {
    public static final n42 a = c();
    public static final n42 b = new o42();

    public static n42 a() {
        return a;
    }

    public static n42 b() {
        return b;
    }

    public static n42 c() {
        if (s5.b) {
            return null;
        }
        try {
            return (n42) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
