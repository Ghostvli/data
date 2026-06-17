package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class h91 implements qs2 {
    public static final h91 a = new h91();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static h91 c() {
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qs2
    public ps2 a(Class cls) {
        if (!i91.class.isAssignableFrom(cls)) {
            jl.a("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            return (ps2) i91.getDefaultInstance(cls.asSubclass(i91.class)).buildMessageInfo();
        } catch (Exception e) {
            cx4.a("Unable to get message info for ".concat(cls.getName()), e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qs2
    public boolean b(Class cls) {
        return i91.class.isAssignableFrom(cls);
    }
}
