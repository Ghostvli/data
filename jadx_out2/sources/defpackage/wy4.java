package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class wy4 {

    public static class a implements j50 {
        public final int a;
        public final int b;
        public final String c;
        public final k50 d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, int i2, String str, k50 k50Var) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = k50Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j50 a(sl0 sl0Var, int i, k50 k50Var) {
        return new a(sl0Var.e() * 4, i, sl0Var.b(), k50Var);
    }
}
