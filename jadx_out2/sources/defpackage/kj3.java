package defpackage;

import defpackage.eh4;
import defpackage.kx;
import defpackage.m04;
import defpackage.m33;
import defpackage.su0;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class kj3 implements AutoCloseable {
    public static final char[] i = {'>', '+', '~'};
    public static final String[] j = {"=", "!=", "^=", "$=", "*=", "~="};
    public static final char[] k = {',', ')'};
    public static final Pattern l = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
    public static final Pattern m = Pattern.compile("([+-])?(\\d+)");
    public final mp4 f;
    public final String g;
    public boolean h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public kj3(String str) {
        zy4.h(str);
        String strTrim = str.trim();
        this.g = strTrim;
        this.f = new mp4(strTrim);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static su0 Q(su0 su0Var, su0 su0Var2) {
        if (!(su0Var instanceof kx.b)) {
            return new kx.b(su0Var, su0Var2);
        }
        ((kx.b) su0Var).k(su0Var2);
        return su0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static su0 S(String str) {
        try {
            kj3 kj3Var = new kj3(str);
            try {
                su0 su0VarR = kj3Var.R();
                kj3Var.close();
                return su0VarR;
            } finally {
            }
        } catch (IllegalArgumentException e) {
            throw new m04.a(e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static su0 a(su0 su0Var, su0 su0Var2) {
        if (su0Var == null) {
            return su0Var2;
        }
        if (!(su0Var instanceof kx.a)) {
            return new kx.a(su0Var, su0Var2);
        }
        ((kx.a) su0Var).k(su0Var2);
        return su0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static su0 t(su0 su0Var, char c, su0 su0Var2) {
        if (c == ' ') {
            return a(new eh4.a(su0Var), su0Var2);
        }
        if (c == '+') {
            return a(new eh4.d(su0Var), su0Var2);
        }
        if (c != '>') {
            if (c == '~') {
                return a(new eh4.g(su0Var), su0Var2);
            }
            throw new m04.a("Unknown combinator '%s'", Character.valueOf(c));
        }
        eh4.c cVar = su0Var instanceof eh4.c ? (eh4.c) su0Var : new eh4.c(su0Var);
        cVar.o(su0Var2);
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 B() {
        String strB0 = mp4.b0(v());
        zy4.i(strB0, ":containsData(text) query must not be empty");
        return new su0.l(strB0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 F(boolean z) {
        String str = z ? ":containsWholeOwnText" : ":containsWholeText";
        String strB0 = mp4.b0(v());
        zy4.i(strB0, str.concat("(text) query must not be empty"));
        return z ? new su0.o(strB0) : new su0.p(strB0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d A[PHI: r2
      0x001d: PHI (r2v7 int) = (r2v0 int), (r2v5 int) binds: [B:6:0x001b, B:18:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final su0 J(boolean z, boolean z2) {
        String strB = z33.b(v());
        int i2 = 2;
        if (!"odd".equals(strB)) {
            if ("even".equals(strB)) {
                i = 0;
            } else {
                Matcher matcher = l.matcher(strB);
                if (matcher.matches()) {
                    if (matcher.group(3) != null) {
                        i2 = Integer.parseInt(matcher.group(1).replaceFirst("^\\+", ""));
                    } else {
                        i2 = "-".equals(matcher.group(2)) ? -1 : 1;
                    }
                    if (matcher.group(4) != null) {
                        i = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                    }
                } else {
                    Matcher matcher2 = m.matcher(strB);
                    if (!matcher2.matches()) {
                        throw new m04.a("Could not parse nth-index '%s': unexpected format", strB);
                    }
                    i = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                    i2 = 0;
                }
            }
        }
        return z2 ? z ? new su0.d0(i2, i) : new su0.e0(i2, i) : z ? new su0.c0(i2, i) : new su0.b0(i2, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 K(mp4 mp4Var) {
        String strB = z33.b(mp4Var.y(j));
        zy4.h(strB);
        zy4.c(strB.equals("abs:"), "Absolute attribute key must have a name");
        mp4Var.B();
        if (mp4Var.J()) {
            return strB.startsWith("^") ? new su0.d(strB.substring(1)) : strB.equals("*") ? new su0.d("") : new su0.b(strB);
        }
        if (mp4Var.P('=')) {
            return new su0.e(strB, mp4Var.Z());
        }
        if (mp4Var.Q("!=")) {
            return new su0.i(strB, mp4Var.Z());
        }
        if (mp4Var.Q("^=")) {
            return new su0.j(strB, mp4Var.Z());
        }
        if (mp4Var.Q("$=")) {
            return new su0.g(strB, mp4Var.Z());
        }
        if (mp4Var.Q("*=")) {
            return new su0.f(strB, mp4Var.Z());
        }
        if (mp4Var.Q("~=")) {
            return new su0.h(strB, sp3.a(mp4Var.Z()));
        }
        throw new m04.a("Could not parse attribute query '%s': unexpected token at '%s'", this.g, mp4Var.Z());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 L() {
        return T(new Function() { // from class: jj3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new eh4.b((su0) obj);
            }
        }, ":has() must have a selector");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 M() {
        return T(new Function() { // from class: ij3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new eh4.e((su0) obj);
            }
        }, ":is() must have a selector");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 N(boolean z) {
        String str = z ? ":matchesOwn" : ":matches";
        String strV = v();
        zy4.i(strV, str.concat("(regex) query must not be empty"));
        sp3 sp3VarA = sp3.a(strV);
        return this.h ? new m33.d(sp3VarA) : z ? new su0.k0(sp3VarA) : new su0.j0(sp3VarA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 O(boolean z) {
        String str = z ? ":matchesWholeOwnText" : ":matchesWholeText";
        String strV = v();
        zy4.i(strV, str.concat("(regex) query must not be empty"));
        sp3 sp3VarA = sp3.a(strV);
        return z ? new su0.l0(sp3VarA) : new su0.m0(sp3VarA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 P() {
        String strV = v();
        zy4.i(strV, ":not(selector) subselect must not be empty");
        return new eh4.f(S(strV));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public su0 R() {
        su0 su0VarZ = Z();
        this.f.B();
        if (this.f.J()) {
            return su0VarZ;
        }
        throw new m04.a("Could not parse query '%s': unexpected token at '%s'", this.g, this.f.Z());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 T(Function function, String str) {
        zy4.e(this.f.P('('), str);
        su0 su0VarZ = Z();
        zy4.e(this.f.P(')'), str);
        return (su0) function.apply(su0VarZ);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 U() {
        String strT;
        su0 cVar;
        strT = this.f.t();
        this.h = true;
        strT.getClass();
        switch (strT) {
            case "data":
                cVar = new m33.c(w90.class, strT);
                break;
            case "node":
                cVar = new m33.c(l33.class, strT);
                break;
            case "text":
                cVar = new m33.c(sm4.class, strT);
                break;
            case "cdata":
                cVar = new m33.c(pn.class, strT);
                break;
            case "comment":
                cVar = new m33.c(lx.class, strT);
                break;
            case "leafnode":
                cVar = new m33.c(ms1.class, strT);
                break;
            default:
                throw new m04.a("Could not parse query '%s': unknown node type '::%s'", this.g, strT);
        }
        while (true) {
            su0 su0VarC0 = c0();
            if (su0VarC0 == null) {
                this.h = false;
                return cVar;
            }
            cVar = a(cVar, su0VarC0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 V() {
        String strT = this.f.t();
        strT.getClass();
        switch (strT) {
            case "containsData":
                return B();
            case "first-child":
                return new su0.x();
            case "matchesWholeText":
                return O(false);
            case "nth-child":
                return J(false, false);
            case "nth-last-child":
                return J(true, false);
            case "only-child":
                return new su0.f0();
            case "nth-of-type":
                return J(false, true);
            case "nth-last-of-type":
                return J(true, true);
            case "contains":
                return y(false);
            case "containsWholeOwnText":
                return F(true);
            case "eq":
                return new su0.s(u());
            case "gt":
                return new su0.u(u());
            case "is":
                return M();
            case "lt":
                return new su0.v(u());
            case "has":
                return L();
            case "not":
                return P();
            case "root":
                return new su0.h0();
            case "blank":
                return new m33.a();
            case "empty":
                return new su0.w();
            case "containsOwn":
                return y(true);
            case "matchText":
                return new su0.i0();
            case "last-child":
                return new su0.z();
            case "matches":
                return N(false);
            case "matchesWholeOwnText":
                return O(true);
            case "first-of-type":
                return new su0.y();
            case "only-of-type":
                return new su0.g0();
            case "matchesOwn":
                return N(true);
            case "containsWholeText":
                return F(false);
            case "last-of-type":
                return new su0.a0();
            default:
                throw new m04.a("Could not parse query '%s': unexpected token at '%s'", this.g, this.f.Z());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public su0 W() {
        this.f.B();
        su0 hVar = this.f.T(i) ? new eh4.h() : b0();
        while (true) {
            char cI = this.f.B() ? ' ' : (char) 0;
            boolean zT = this.f.T(i);
            mp4 mp4Var = this.f;
            if (!zT) {
                if (!mp4Var.T(k)) {
                    break;
                    break;
                }
                break;
            }
            cI = mp4Var.i();
            if (cI == 0) {
                break;
            }
            hVar = t(hVar, cI, b0());
        }
        return hVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public su0 Z() {
        su0 su0VarW = W();
        while (this.f.P(',')) {
            su0VarW = Q(su0VarW, W());
        }
        return su0VarW;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public su0 b0() {
        this.f.B();
        su0 su0VarL = (this.f.W() || this.f.S("*|")) ? l() : this.f.P('*') ? new su0.a() : null;
        while (true) {
            su0 su0VarC0 = c0();
            if (su0VarC0 == null) {
                break;
            }
            su0VarL = a(su0VarL, su0VarC0);
        }
        if (su0VarL != null) {
            return su0VarL;
        }
        throw new m04.a("Could not parse query '%s': unexpected token at '%s'", this.g, this.f.Z());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 c() {
        mp4 mp4Var = new mp4(this.f.h('[', ']'));
        try {
            su0 su0VarK = K(mp4Var);
            mp4Var.close();
            return su0VarK;
        } catch (Throwable th) {
            try {
                mp4Var.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public su0 c0() {
        if (this.f.P('#')) {
            return i();
        }
        if (this.f.P('.')) {
            return h();
        }
        if (this.f.R('[')) {
            return c();
        }
        if (this.f.Q("::")) {
            return U();
        }
        if (this.f.P(':')) {
            return V();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 h() {
        String strT = this.f.t();
        zy4.h(strT);
        return new su0.k(strT.trim());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 i() {
        String strT = this.f.t();
        zy4.h(strT);
        return new su0.r(strT);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 l() {
        String strB = z33.b(this.f.u());
        zy4.h(strB);
        if (strB.startsWith("*|")) {
            String strSubstring = strB.substring(2);
            return new kx.b(new su0.n0(strSubstring), new su0.o0(":".concat(strSubstring)));
        }
        if (strB.endsWith("|*")) {
            return new su0.p0(strB.substring(0, strB.length() - 2).concat(":"));
        }
        if (strB.contains("|")) {
            strB = strB.replace("|", ":");
        }
        return new su0.n0(strB);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int u() {
        String strTrim = v().trim();
        zy4.e(fg4.n(strTrim), "Index must be numeric");
        return Integer.parseInt(strTrim);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String v() {
        return this.f.h('(', ')');
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final su0 y(boolean z) {
        String str = z ? ":containsOwn" : ":contains";
        String strB0 = mp4.b0(v());
        zy4.i(strB0, str.concat("(text) query must not be empty"));
        return this.h ? new m33.b(strB0) : z ? new su0.m(strB0) : new su0.n(strB0);
    }
}
