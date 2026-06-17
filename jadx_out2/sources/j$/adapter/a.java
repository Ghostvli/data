package j$.adapter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final boolean a;
    public static final boolean b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        boolean z;
        try {
            Class.forName("java.util.StringJoiner");
        } catch (ClassNotFoundException unused) {
        }
        boolean z2 = false;
        try {
            Class.forName("java.nio.file.FileSystems");
            z = true;
        } catch (ClassNotFoundException unused2) {
            z = false;
        }
        a = z;
        try {
            Class.forName("android.os.Build");
            z2 = true;
        } catch (ClassNotFoundException unused3) {
        }
        b = z2;
    }
}
