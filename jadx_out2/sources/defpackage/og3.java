package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class og3 implements v41 {
    public final int a;
    public final int b;
    public final boolean c;
    public final a02 d;
    public final String e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public int a;
        public int b;
        public boolean c;
        public a02 d;
        public String e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
            this.a = 2;
            this.b = 0;
            this.c = true;
            this.e = "PRETTY_LOGGER";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public og3 a() {
            if (this.d == null) {
                this.d = new d02();
            }
            return new og3(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(int i) {
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(boolean z) {
            this.c = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(String str) {
            this.e = str;
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public og3(b bVar) {
        vy4.a(bVar);
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b k() {
        return new b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.v41
    public void a(int i, String str, String str2) {
        vy4.a(str2);
        String strB = b(str);
        j(i, strB);
        i(i, strB, this.a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        int i2 = this.a;
        if (length <= 4000) {
            if (i2 > 0) {
                h(i, strB);
            }
            g(i, strB, str2);
            e(i, strB);
            return;
        }
        if (i2 > 0) {
            h(i, strB);
        }
        for (int i3 = 0; i3 < length; i3 += 4000) {
            g(i, strB, new String(bytes, i3, Math.min(length - i3, 4000)));
        }
        e(i, strB);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String b(String str) {
        if (vy4.d(str) || vy4.b(this.e, str)) {
            return this.e;
        }
        return this.e + "-" + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String c(String str) {
        vy4.a(str);
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int d(StackTraceElement[] stackTraceElementArr) {
        vy4.a(stackTraceElementArr);
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(o02.class.getName()) && !className.equals(g02.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(int i, String str) {
        f(i, str, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(int i, String str, String str2) {
        vy4.a(str2);
        this.d.a(i, str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(int i, String str, String str2) {
        vy4.a(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            f(i, str, "│ " + str3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(int i, String str) {
        f(i, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.c) {
            f(i, str, "│ Thread: " + Thread.currentThread().getName());
            h(i, str);
        }
        int iD = d(stackTrace) + this.b;
        if (i2 + iD > stackTrace.length) {
            i2 = (stackTrace.length - iD) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + iD;
            if (i3 < stackTrace.length) {
                str2 = str2 + "   ";
                f(i, str, "│ " + str2 + c(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + "  (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(int i, String str) {
        f(i, str, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}
