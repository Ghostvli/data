package defpackage;

import defpackage.hp4;
import defpackage.wf1;
import fi.iki.elonen.NanoHTTPD;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class vf1 extends it4 {
    public static final String[] B = {"applet", "caption", "html", "marquee", "object", "table", "td", "template", "th"};
    public static final String[] C = {"annotation-xml", "mi", "mn", "mo", "ms", "mtext"};
    public static final String[] D = {"desc", "foreignobject", "title"};
    public static final String[] E = {"ol", "ul"};
    public static final String[] F = {"button"};
    public static final String[] G = {"html", "table"};
    public static final String[] H = {"optgroup", "option"};
    public static final String[] I = {"dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc"};
    public static final String[] J = {"caption", "colgroup", "dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};
    public static final String[] K = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "keygen", "li", "link", "listing", "main", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "search", "section", "select", "source", "style", "summary", "table", "tbody", "td", "template", "textarea", "tfoot", "th", "thead", "title", "tr", "track", "ul", "wbr", "xmp"};
    public static String[] L = {"annotation-xml", "mi", "mn", "mo", "ms", "mtext"};
    public static final String[] M = {"mi", "mn", "mo", "ms", "mtext"};
    public static final String[] N = {"desc", "foreignObject", "title"};
    public static final String[] O = {"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
    public final String[] A = {null};
    public wf1 n;
    public wf1 o;
    public boolean p;
    public br0 q;
    public p41 r;
    public br0 s;
    public ArrayList t;
    public ArrayList u;
    public List v;
    public hp4.g w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean A0(br0 br0Var, br0 br0Var2) {
        return br0Var.G().equals(br0Var2.G()) && br0Var.f().equals(br0Var2.f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean B0(br0 br0Var) {
        String strG;
        String strI = br0Var.U0().i();
        strG = br0Var.G();
        strI.getClass();
        switch (strI) {
            case "http://www.w3.org/1999/xhtml":
                return fg4.g(strG, K);
            case "http://www.w3.org/2000/svg":
                return fg4.g(strG, N);
            case "http://www.w3.org/1998/Math/MathML":
                return fg4.g(strG, L);
            default:
                return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean I0(ArrayList arrayList, br0 br0Var) {
        int size = arrayList.size();
        int i = size - 1;
        int i2 = i >= 256 ? size - 257 : 0;
        while (i >= i2) {
            if (((br0) arrayList.get(i)) == br0Var) {
                return true;
            }
            i--;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void Z0(ArrayList arrayList, br0 br0Var, br0 br0Var2) {
        int iLastIndexOf = arrayList.lastIndexOf(br0Var);
        zy4.d(iLastIndexOf != -1);
        arrayList.set(iLastIndexOf, br0Var2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean x0(br0 br0Var) {
        if ("http://www.w3.org/1998/Math/MathML".equals(br0Var.U0().i()) && br0Var.z("annotation-xml")) {
            String strB = z33.b(br0Var.e("encoding"));
            if (strB.equals(NanoHTTPD.MIME_HTML) || strB.equals("application/xhtml+xml")) {
                return true;
            }
        }
        return "http://www.w3.org/2000/svg".equals(br0Var.U0().i()) && fg4.f(br0Var.V0(), N);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean z0(br0 br0Var) {
        return "http://www.w3.org/1998/Math/MathML".equals(br0Var.U0().i()) && fg4.g(br0Var.G(), M);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 B(br0 br0Var) {
        if (!G0(br0Var)) {
            return null;
        }
        for (int size = this.e.size() - 1; size > 0; size--) {
            if (((br0) this.e.get(size)) == br0Var) {
                return (br0) this.e.get(size - 1);
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C(hp4.c cVar) {
        this.v.add(new hp4.c(cVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 C0() {
        if (this.t.size() <= 0) {
            return null;
        }
        return (br0) this.t.get(r1.size() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D(br0 br0Var) {
        int size = this.t.size();
        int i = size - 13;
        int i2 = 0;
        if (i < 0) {
            i = 0;
        }
        for (int i3 = size - 1; i3 >= i; i3--) {
            br0 br0Var2 = (br0) this.t.get(i3);
            if (br0Var2 == null) {
                return;
            }
            if (A0(br0Var, br0Var2)) {
                i2++;
            }
            if (i2 == 3) {
                this.t.remove(i3);
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D0() {
        this.o = this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E() {
        while (!this.t.isEmpty() && X0() != null) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E0(br0 br0Var) {
        if (this.p) {
            return;
        }
        String strB = br0Var.b("href");
        if (strB.length() != 0) {
            this.f = strB;
            this.p = true;
            this.d.V(strB);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(String... strArr) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            br0 br0Var = (br0) this.e.get(size);
            if ("http://www.w3.org/1999/xhtml".equals(br0Var.U0().i()) && (fg4.f(br0Var.G(), strArr) || br0Var.z("html"))) {
                return;
            }
            r();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: m()Lit4; */
    @Override // defpackage.it4
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public vf1 m() {
        return new vf1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G() {
        F("tbody", "tfoot", "thead", "template");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean G0(br0 br0Var) {
        return I0(this.e, br0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H() {
        F("table", "template");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean H0(String str) {
        return X(str) != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I() {
        F("tr", "template");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J(String str) {
        R(str);
        if (!str.equals(b().G())) {
            N(h1());
        }
        L0(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean J0(String[] strArr) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            if (!fg4.g(((br0) this.e.get(size)).G(), strArr)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 K(hp4.h hVar, String str, boolean z) {
        xb xbVar = hVar.g;
        if (xbVar != null && !xbVar.isEmpty()) {
            if (!z) {
                this.h.c(xbVar);
            }
            if (xbVar.l(this.h) > 0) {
                k("Dropped duplicate attribute(s) in tag [%s]", hVar.e);
            }
        }
        al4 al4VarZ = z(hVar.G(), hVar.e, str, z ? g83.d : this.h);
        return al4VarZ.j().equals("form") ? new p41(al4VarZ, null, xbVar) : new br0(al4VarZ, null, xbVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wf1 K0() {
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wf1 L() {
        if (this.u.size() <= 0) {
            return null;
        }
        return (wf1) this.u.get(r1.size() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 L0(String str) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            br0 br0VarR = r();
            if (br0VarR.p0(str, "http://www.w3.org/1999/xhtml")) {
                return br0VarR;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M(br0 br0Var) {
        i();
        if (this.r != null && br0Var.U0().f.equals("http://www.w3.org/1999/xhtml") && fg4.g(br0Var.G(), O)) {
            this.r.c1(br0Var);
        }
        if (this.a.c().b() && br0Var.w(XMLConstants.XMLNS_ATTRIBUTE) && !br0Var.e(XMLConstants.XMLNS_ATTRIBUTE).equals(br0Var.U0().i())) {
            k("Invalid xmlns attribute [%s] on tag [%s]", br0Var.e(XMLConstants.XMLNS_ATTRIBUTE), br0Var.V0());
        }
        if (v0() && fg4.g(b().G(), wf1.z.A)) {
            s0(br0Var);
        } else {
            b().d0(br0Var);
        }
        v(br0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M0(String... strArr) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            br0 br0VarR = r();
            if (fg4.g(br0VarR.G(), strArr) && "http://www.w3.org/1999/xhtml".equals(br0VarR.U0().i())) {
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N(wf1 wf1Var) {
        if (this.a.c().b()) {
            this.a.c().add(new x73(this.b, "Unexpected %s token [%s] when in state [%s]", this.g.r(), this.g, wf1Var));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 N0(String str) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            br0 br0VarR = r();
            if (br0VarR.z(str)) {
                return br0VarR;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(boolean z) {
        this.x = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wf1 O0() {
        if (this.u.size() <= 0) {
            return null;
        }
        return (wf1) this.u.remove(r1.size() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean P() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int P0(br0 br0Var) {
        for (int i = 0; i < this.t.size(); i++) {
            if (br0Var == this.t.get(i)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q() {
        S(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean Q0(hp4 hp4Var, wf1 wf1Var) {
        return wf1Var.j(hp4Var, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R(String str) {
        while (fg4.g(b().G(), I)) {
            if (str != null && c(str)) {
                return;
            } else {
                r();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R0(br0 br0Var) {
        D(br0Var);
        this.t.add(br0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S(boolean z) {
        String[] strArr = z ? J : I;
        while ("http://www.w3.org/1999/xhtml".equals(b().U0().i()) && fg4.g(b().G(), strArr)) {
            r();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S0(wf1 wf1Var) {
        this.u.add(wf1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 T(String str) {
        for (int size = this.t.size() - 1; size >= 0; size--) {
            br0 br0Var = (br0) this.t.get(size);
            if (br0Var == null) {
                return null;
            }
            if (br0Var.z(str)) {
                return br0Var;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T0(br0 br0Var, int i) {
        D(br0Var);
        try {
            this.t.add(i, br0Var);
        } catch (IndexOutOfBoundsException unused) {
            this.t.add(br0Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String U() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Duplicate block (B:20:0x003d) to fix multi-entry loop: BACK_EDGE: B:24:0x0075 -> B:20:0x003d */
    public void U0() {
        br0 br0VarC0;
        if (this.e.size() > 256 || (br0VarC0 = C0()) == null || G0(br0VarC0)) {
            return;
        }
        int size = this.t.size();
        int i = size - 12;
        if (i < 0) {
            i = 0;
        }
        boolean z = true;
        int i2 = size - 1;
        int i3 = i2;
        while (i3 != i) {
            i3--;
            br0VarC0 = (br0) this.t.get(i3);
            if (br0VarC0 == null || G0(br0VarC0)) {
                z = false;
                break;
            }
        }
        while (true) {
            if (!z) {
                i3++;
                br0VarC0 = (br0) this.t.get(i3);
            }
            zy4.j(br0VarC0);
            br0 br0Var = new br0(z(br0VarC0.C(), br0VarC0.G(), f(), this.h), null, br0VarC0.f().clone());
            M(br0Var);
            this.t.set(i3, br0Var);
            if (i3 == i2) {
                return;
            } else {
                z = false;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wm0 V() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V0(br0 br0Var) {
        for (int size = this.t.size() - 1; size >= 0; size--) {
            if (((br0) this.t.get(size)) == br0Var) {
                this.t.remove(size);
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p41 W() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean W0(br0 br0Var) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            if (((br0) this.e.get(size)) == br0Var) {
                this.e.remove(size);
                n(br0Var);
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 X(String str) {
        int size = this.e.size();
        int i = size - 1;
        int i2 = i >= 256 ? size - 257 : 0;
        while (i >= i2) {
            br0 br0Var = (br0) this.e.get(i);
            if (br0Var.p0(str, "http://www.w3.org/1999/xhtml")) {
                return br0Var;
            }
            i--;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 X0() {
        int size = this.t.size();
        if (size > 0) {
            return (br0) this.t.remove(size - 1);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 Y() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y0(br0 br0Var, br0 br0Var2) {
        Z0(this.t, br0Var, br0Var2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List Z() {
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ArrayList a0() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a1(br0 br0Var, br0 br0Var2) {
        Z0(this.e, br0Var, br0Var2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b0(String str) {
        return e0(str, F);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b1() {
        if (!H0("body")) {
            this.e.add(this.d.c1());
        }
        j1(wf1.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c0(String str) {
        return e0(str, E);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c1() {
        int size = this.e.size();
        int i = size - 1;
        int i2 = i >= 256 ? size - 257 : 0;
        wf1 wf1Var = this.n;
        if (this.e.size() == 0) {
            j1(wf1.l);
        }
        boolean z = false;
        while (true) {
            if (i >= i2) {
                br0 br0Var = (br0) this.e.get(i);
                if (i == i2) {
                    if (this.z) {
                        br0Var = this.s;
                    }
                    z = true;
                }
                String strG = br0Var != null ? br0Var.G() : "";
                if ("http://www.w3.org/1999/xhtml".equals(br0Var.U0().i())) {
                    strG.getClass();
                    switch (strG) {
                        case "frameset":
                            j1(wf1.y);
                            break;
                        case "template":
                            wf1 wf1VarL = L();
                            zy4.k(wf1VarL, "Bug: no template insertion mode on stack!");
                            j1(wf1VarL);
                            break;
                        case "select":
                            j1(wf1.u);
                            break;
                        case "colgroup":
                            j1(wf1.q);
                            break;
                        case "td":
                        case "th":
                            if (z) {
                                if (z) {
                                    j1(wf1.l);
                                }
                                break;
                            } else {
                                j1(wf1.t);
                                break;
                            }
                            break;
                        case "tr":
                            j1(wf1.s);
                            break;
                        case "body":
                            j1(wf1.l);
                            break;
                        case "head":
                            if (!z) {
                                j1(wf1.i);
                                break;
                            }
                            break;
                        case "html":
                            j1(this.q == null ? wf1.h : wf1.k);
                            break;
                        case "table":
                            j1(wf1.n);
                            break;
                        case "tbody":
                        case "tfoot":
                        case "thead":
                            j1(wf1.r);
                            break;
                        case "caption":
                            j1(wf1.p);
                            break;
                    }
                }
                i--;
            }
        }
        return this.n != wf1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d0(String str) {
        return e0(str, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d1() {
        this.v.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e0(String str, String[] strArr) {
        return h0(str, B, strArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e1(p41 p41Var) {
        this.r = p41Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f0(String[] strArr) {
        return i0(strArr, B, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f1(boolean z) {
        this.y = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.it4
    public g83 g() {
        return g83.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g0(String str) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            String strG = ((br0) this.e.get(size)).G();
            if (strG.equals(str)) {
                return true;
            }
            if (!fg4.g(strG, H)) {
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g1(br0 br0Var) {
        this.q = br0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h0(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.A;
        strArr3[0] = str;
        return i0(strArr3, strArr, strArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wf1 h1() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i0(String[] strArr, String[] strArr2, String[] strArr3) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            br0 br0Var = (br0) this.e.get(size);
            String strG = br0Var.G();
            String strI = br0Var.U0().i();
            if (strI.equals("http://www.w3.org/1999/xhtml")) {
                if (fg4.g(strG, strArr)) {
                    return true;
                }
                if (fg4.g(strG, strArr2)) {
                    return false;
                }
                if (strArr3 != null && fg4.g(strG, strArr3)) {
                    return false;
                }
            } else if (strArr2 != B) {
                continue;
            } else {
                if (strI.equals("http://www.w3.org/1998/Math/MathML") && fg4.g(strG, C)) {
                    return false;
                }
                if (strI.equals("http://www.w3.org/2000/svg") && fg4.g(strG, D)) {
                    return false;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int i1() {
        return this.u.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j0(String str) {
        return h0(str, G, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j1(wf1 wf1Var) {
        this.n = wf1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k0(hp4.c cVar) {
        l0(cVar, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean k1(hp4 hp4Var) {
        if (this.e.isEmpty()) {
            return true;
        }
        br0 br0VarB = b();
        String strI = br0VarB.U0().i();
        if ("http://www.w3.org/1999/xhtml".equals(strI)) {
            return true;
        }
        if (z0(br0VarB) && ((hp4Var.n() && !"mglyph".equals(hp4Var.e().e) && !"malignmark".equals(hp4Var.e().e)) || hp4Var.i())) {
            return true;
        }
        if ("http://www.w3.org/1998/Math/MathML".equals(strI) && br0VarB.z("annotation-xml") && hp4Var.n() && "svg".equals(hp4Var.e().e)) {
            return true;
        }
        if (x0(br0VarB) && (hp4Var.n() || hp4Var.i())) {
            return true;
        }
        return hp4Var.l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.it4
    public void l(Reader reader, String str, o83 o83Var) {
        super.l(reader, str, o83Var);
        this.n = wf1.f;
        this.o = null;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new hp4.g(this);
        this.x = true;
        this.y = false;
        this.z = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l0(hp4.c cVar, boolean z) {
        cVar.v(z);
        m0(cVar, b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m0(hp4.c cVar, br0 br0Var) {
        String strU = cVar.u();
        l33 pnVar = cVar.h() ? new pn(strU) : br0Var.U0().c(al4.r) ? new w90(strU) : new sm4(strU);
        br0Var.d0(pnVar);
        o(pnVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n0(hp4.d dVar) {
        lx lxVar = new lx(dVar.u());
        b().d0(lxVar);
        o(lxVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 o0(hp4.h hVar) {
        br0 br0VarK = K(hVar, "http://www.w3.org/1999/xhtml", false);
        M(br0VarK);
        if (hVar.E()) {
            al4 al4VarU0 = br0VarK.U0();
            al4VarU0.m();
            if (!al4VarU0.e()) {
                if (al4VarU0.g() && al4VarU0.h()) {
                    this.c.x(op4.f);
                    this.c.m(this.w.o().F(br0VarK.V0()));
                } else {
                    this.c.u("Tag [%s] cannot be self-closing; not a void tag", al4VarU0.j());
                }
            }
        }
        if (br0VarK.U0().e()) {
            r();
        }
        return br0VarK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.it4
    public void p(br0 br0Var) {
        if (br0Var == this.q) {
            this.q = null;
        }
        if (br0Var == this.r) {
            e1(null);
        }
        V0(br0Var);
        if (br0Var.z("template")) {
            E();
            if (i1() > 0) {
                O0();
            }
            c1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 p0(hp4.h hVar) {
        br0 br0VarK = K(hVar, "http://www.w3.org/1999/xhtml", false);
        M(br0VarK);
        r();
        return br0VarK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br0 q0(hp4.h hVar, String str) {
        br0 br0VarK = K(hVar, str, true);
        M(br0VarK);
        if (hVar.E()) {
            br0VarK.U0().m();
            r();
        }
        return br0VarK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p41 r0(hp4.h hVar, boolean z, boolean z2) {
        p41 p41Var = (p41) K(hVar, "http://www.w3.org/1999/xhtml", false);
        if (!z2 || !H0("template")) {
            e1(p41Var);
        }
        M(p41Var);
        if (!z) {
            r();
        }
        return p41Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.it4
    public boolean s(hp4 hp4Var) {
        return (k1(hp4Var) ? this.n : wf1.C).j(hp4Var, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s0(l33 l33Var) {
        br0 br0VarB;
        br0 br0VarX = X("table");
        boolean z = false;
        if (br0VarX == null) {
            br0VarB = (br0) this.e.get(0);
        } else if (br0VarX.L() != null) {
            br0VarB = br0VarX.L();
            z = true;
        } else {
            br0VarB = B(br0VarX);
        }
        if (!z) {
            br0VarB.d0(l33Var);
        } else {
            zy4.j(br0VarX);
            br0VarX.i0(l33Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t0() {
        this.t.add(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "TreeBuilder{currentToken=" + this.g + ", state=" + this.n + ", currentElement=" + b() + '}';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u0(br0 br0Var, br0 br0Var2) {
        int iLastIndexOf = this.e.lastIndexOf(br0Var);
        if (iLastIndexOf != -1) {
            this.e.add(iLastIndexOf + 1, br0Var2);
        } else {
            j("Did not find element on stack to insert after");
            this.e.add(br0Var2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean v0() {
        return this.y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean w0() {
        return this.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean y0(br0 br0Var) {
        return I0(this.t, br0Var);
    }
}
