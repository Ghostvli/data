package defpackage;

import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sq3 {
    public static final String[] a = {"System.out", "stdout", "sysout"};
    public static final b b = e();
    public static final a c = f();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        INFO(1),
        WARN(2),
        ERROR(3);

        public int f;

        a(int i) {
            this.f = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        Stderr,
        Stdout
    }

    public static final void a(String str) {
        c().println("SLF4J(E): " + str);
    }

    public static final void b(String str, Throwable th) {
        c().println("SLF4J(E): " + str);
        c().println("SLF4J(E): Reported exception:");
        th.printStackTrace(c());
    }

    public static PrintStream c() {
        return b.ordinal() != 1 ? System.err : System.out;
    }

    public static void d(String str) {
        if (g(a.INFO)) {
            c().println("SLF4J(I): " + str);
        }
    }

    public static b e() {
        String property = System.getProperty("slf4j.internal.report.stream");
        if (property == null || property.isEmpty()) {
            return b.Stderr;
        }
        for (String str : a) {
            if (str.equalsIgnoreCase(property)) {
                return b.Stdout;
            }
        }
        return b.Stderr;
    }

    public static a f() {
        String property = System.getProperty("slf4j.internal.verbosity");
        return (property == null || property.isEmpty()) ? a.INFO : property.equalsIgnoreCase("ERROR") ? a.ERROR : property.equalsIgnoreCase("WARN") ? a.WARN : a.INFO;
    }

    public static boolean g(a aVar) {
        return aVar.f >= c.f;
    }

    public static final void h(String str) {
        if (g(a.WARN)) {
            c().println("SLF4J(W): " + str);
        }
    }
}
