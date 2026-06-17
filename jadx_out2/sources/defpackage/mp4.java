package defpackage;

import defpackage.xs;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class mp4 implements AutoCloseable {
    public static final char[] g = {'*', '|', '_', '-'};
    public static final char[] h = {'-', '_'};
    public final xs f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mp4(String str) {
        this.f = new xs(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean K(char c) {
        return c == '-' || fg4.k(c) || L(c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean L(char c) {
        return c == '_' || fg4.i(c) || N(c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean M(char c) {
        return c == '\n' || c == '\r' || c == '\f';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean N(char c) {
        return c >= 128;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean O(int i) {
        return (i == 0 || !Character.isValidCodePoint(i) || Character.isSurrogate((char) i)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String b0(String str) {
        if (str.indexOf(92) == -1) {
            return str;
        }
        StringBuilder sbE = fg4.e();
        char c = 0;
        for (char c2 : str.toCharArray()) {
            if (c2 == '\\') {
                if (c == '\\') {
                    sbE.append(c2);
                    c = 0;
                }
            } else {
                sbE.append(c2);
            }
            c = c2;
        }
        return fg4.v(sbE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B() {
        boolean z = false;
        while (V()) {
            c();
            z = true;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char F() {
        return this.f.g0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean J() {
        return this.f.i0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean P(char c) {
        if (!this.f.r0(c)) {
            return false;
        }
        i();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean Q(String str) {
        return this.f.q0(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean R(char c) {
        return this.f.r0(c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean S(String str) {
        return this.f.x0(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean T(char... cArr) {
        return this.f.t0(cArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean U(char... cArr) {
        return W() || this.f.t0(cArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean V() {
        return fg4.o(this.f.g0());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean W() {
        return Character.isLetterOrDigit(this.f.g0());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String Z() {
        return this.f.e0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c() {
        if (J()) {
            return;
        }
        this.f.B();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String h(char c, char c2) {
        StringBuilder sbE = fg4.e();
        this.f.o0();
        char c3 = 0;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        boolean z3 = false;
        while (!J()) {
            char cI = i();
            if (c3 == '\\') {
                if (cI == 'Q') {
                    z3 = true;
                } else if (cI == 'E') {
                    z3 = false;
                }
                sbE.append(cI);
            } else {
                if (cI == '\'' && cI != c && !z) {
                    z2 = !z2;
                } else if (cI == '\"' && cI != c && !z2) {
                    z = !z;
                }
                if (z2 || z || z3) {
                    sbE.append(cI);
                } else if (cI == c) {
                    i++;
                    if (i > 1) {
                        sbE.append(cI);
                    }
                } else if (cI != c2 || i - 1 > 0) {
                    sbE.append(cI);
                }
            }
            if (i <= 0) {
                break;
            }
            c3 = cI;
        }
        String strV = fg4.v(sbE);
        if (i > 0) {
            this.f.E0();
            zy4.a("Did not find balanced marker at '" + strV + "'");
        }
        return strV;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char i() {
        return this.f.M();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(StringBuilder sb) {
        if (J()) {
            sb.append(Utf8.REPLACEMENT_CHARACTER);
            return;
        }
        char cI = i();
        if (!fg4.l(cI)) {
            sb.append(cI);
            return;
        }
        this.f.H0();
        String strU = this.f.U(new ws(), 6);
        try {
            int i = Integer.parseInt(strU, 16);
            if (O(i)) {
                sb.appendCodePoint(i);
            } else {
                sb.append(Utf8.REPLACEMENT_CHARACTER);
            }
            if (J()) {
                return;
            }
            char cF = F();
            if (cF == '\r') {
                c();
                if (J() || F() != '\n') {
                    return;
                }
                c();
                return;
            }
            if (cF == ' ' || cF == '\t' || M(cF)) {
                c();
            }
        } catch (NumberFormatException e) {
            kp4.a("Invalid escape sequence: ", strU, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String t() {
        if (J()) {
            jl.a("CSS identifier expected, but end of input found");
            return null;
        }
        String strT = this.f.T(new xs.a() { // from class: lp4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return mp4.K(c);
            }
        });
        char cF = F();
        if (cF != '\\' && cF != 0) {
            return strT;
        }
        StringBuilder sbE = fg4.e();
        if (!strT.isEmpty()) {
            sbE.append(strT);
        }
        while (true) {
            if (!J()) {
                char cF2 = F();
                if (!K(cF2)) {
                    if (cF2 != 0) {
                        if (cF2 != '\\') {
                            break;
                        }
                        c();
                        if (!J() && M(F())) {
                            this.f.H0();
                            break;
                        }
                        l(sbE);
                    } else {
                        c();
                        sbE.append(Utf8.REPLACEMENT_CHARACTER);
                    }
                } else {
                    sbE.append(i());
                }
            } else {
                break;
            }
        }
        return fg4.v(sbE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.f.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String u() {
        return v(g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String v(char... cArr) {
        StringBuilder sbE = fg4.e();
        while (!J()) {
            char cF = F();
            if (cF != '\\') {
                if (!U(cArr)) {
                    break;
                }
                sbE.append(cF);
                c();
            } else {
                c();
                if (J()) {
                    break;
                }
                sbE.append(i());
            }
        }
        return fg4.v(sbE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String y(String... strArr) {
        StringBuilder sbE = fg4.e();
        loop0: while (!J()) {
            for (String str : strArr) {
                if (this.f.x0(str)) {
                    break loop0;
                }
            }
            sbE.append(i());
        }
        return fg4.v(sbE);
    }
}
