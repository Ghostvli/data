package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class g83 {
    public static final g83 c = new g83(false, false);
    public static final g83 d = new g83(true, true);
    public final boolean a;
    public final boolean b;

    public g83(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public static String a(String str) {
        return z33.b(str);
    }

    public String b(String str) {
        String strTrim = str.trim();
        return !this.b ? z33.a(strTrim) : strTrim;
    }

    public void c(xb xbVar) {
        if (this.b) {
            return;
        }
        xbVar.A();
    }

    public String d(String str) {
        String strTrim = str.trim();
        return !this.a ? z33.a(strTrim) : strTrim;
    }

    public boolean e() {
        return this.b;
    }

    public boolean f() {
        return this.a;
    }

    public g83(g83 g83Var) {
        this(g83Var.a, g83Var.b);
    }
}
