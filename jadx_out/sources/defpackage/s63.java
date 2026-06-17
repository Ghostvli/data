package defpackage;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s63 {
    public static final b e = new a();
    public final Object a;
    public final b b;
    public final String c;
    public volatile byte[] d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements b {
        @Override // s63.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    public s63(String str, Object obj, b bVar) {
        this.c = fg3.c(str);
        this.a = obj;
        this.b = (b) fg3.e(bVar);
    }

    public static s63 a(String str, Object obj, b bVar) {
        return new s63(str, obj, bVar);
    }

    public static b b() {
        return e;
    }

    public static s63 e(String str) {
        return new s63(str, null, b());
    }

    public static s63 f(String str, Object obj) {
        return new s63(str, obj, b());
    }

    public Object c() {
        return this.a;
    }

    public final byte[] d() {
        if (this.d == null) {
            this.d = this.c.getBytes(wq1.a);
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s63) {
            return this.c.equals(((s63) obj).c);
        }
        return false;
    }

    public void g(Object obj, MessageDigest messageDigest) {
        this.b.a(d(), obj, messageDigest);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.c + "'}";
    }
}
