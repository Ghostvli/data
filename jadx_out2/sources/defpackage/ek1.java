package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ek1 {
    public a a;
    public b b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, String str2, String str3, String str4, String str5, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ek1(a aVar, b bVar) {
        this.a = aVar;
        this.b = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ek1 a() {
        return new ek1(new a("ANDROID", "21.03.36", "3", "WATCH", null), new b("MOBILE", null, null, "Android", "16", 36));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ek1 b() {
        return new ek1(new a("IOS", "21.03.2", "5", "WATCH", null), new b("MOBILE", "Apple", "iPhone16,2", "iOS", "18.7.2.22H124", -1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static ek1 c() {
        String str = null;
        return new ek1(new a("WEB", "2.20260120.01.00", "1", "WATCH", str), new b("DESKTOP", null, null, str, 0 == true ? 1 : 0, -1));
    }
}
