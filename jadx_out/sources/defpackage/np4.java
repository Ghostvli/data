package defpackage;

import defpackage.hp4;
import defpackage.wm0;
import java.util.Arrays;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class np4 {
    public static final char[] u;
    public static final int[] v = {8364, Token.DEFAULT, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, Token.EMPTY, 381, Token.BLOCK, Token.LABEL, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, Token.DOTDOT, 382, 376};
    public final xs a;
    public final y73 b;
    public final hp4.h h;
    public final hp4.g i;
    public hp4.i j;
    public final hp4.k n;
    public String o;
    public String p;
    public int q;
    public op4 c = op4.f;
    public hp4 d = null;
    public boolean e = false;
    public final jp4 f = new jp4();
    public final hp4.c k = new hp4.c();
    public final hp4.e l = new hp4.e();
    public final hp4.d m = new hp4.d();
    public int r = 0;
    public final int[] s = new int[1];
    public final int[] t = new int[2];
    public final wm0.a.EnumC0128a g = wm0.a.EnumC0128a.html;

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        u = cArr;
        Arrays.sort(cArr);
    }

    public np4(it4 it4Var) {
        hp4.h hVar = new hp4.h(it4Var);
        this.h = hVar;
        this.j = hVar;
        this.i = new hp4.g(it4Var);
        this.n = new hp4.k(it4Var);
        this.a = it4Var.b;
        this.b = it4Var.a.c();
    }

    public void a(op4 op4Var) {
        x(op4Var);
        this.a.B();
    }

    public String b() {
        return this.o;
    }

    public String c() {
        if (this.p == null) {
            this.p = "</" + this.o;
        }
        return this.p;
    }

    public final void d(String str, Object... objArr) {
        if (this.b.b()) {
            this.b.add(new x73(this.a, String.format("Invalid character reference: " + str, objArr)));
        }
    }

    public int[] e(Character ch, boolean z) {
        int iIntValue;
        if (this.a.i0()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.a.g0()) || this.a.u0(u)) {
            return null;
        }
        int[] iArr = this.s;
        this.a.o0();
        boolean zP0 = this.a.p0("#");
        xs xsVar = this.a;
        if (zP0) {
            boolean zQ0 = xsVar.q0("X");
            xs xsVar2 = this.a;
            String strQ = zQ0 ? xsVar2.Q() : xsVar2.P();
            if (strQ.isEmpty()) {
                d("numeric reference with no numerals", new Object[0]);
                this.a.E0();
                return null;
            }
            this.a.I0();
            if (!this.a.p0(";")) {
                d("missing semicolon on [&#%s]", strQ);
            }
            try {
                iIntValue = Integer.valueOf(strQ, zQ0 ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = -1;
            }
            if (iIntValue == -1 || iIntValue > 1114111) {
                d("character [%s] outside of valid range", Integer.valueOf(iIntValue));
                iArr[0] = 65533;
            } else {
                if (iIntValue >= 128) {
                    int[] iArr2 = v;
                    if (iIntValue < iArr2.length + 128) {
                        d("character [%s] is not a valid unicode code point", Integer.valueOf(iIntValue));
                        iIntValue = iArr2[iIntValue - 128];
                    }
                }
                iArr[0] = iIntValue;
            }
            return iArr;
        }
        String strS = xsVar.S();
        boolean zR0 = this.a.r0(';');
        if (!bt0.p(strS) && (!bt0.q(strS) || !zR0)) {
            this.a.E0();
            if (zR0) {
                d("invalid named reference [%s]", strS);
            }
            if (z) {
                return null;
            }
            strS = bt0.o(strS);
            if (strS.isEmpty()) {
                return null;
            }
            this.a.p0(strS);
        }
        if (z && (this.a.v0() || this.a.w0() || this.a.t0('=', '-', '_'))) {
            this.a.E0();
            return null;
        }
        this.a.I0();
        if (!this.a.p0(";")) {
            d("missing semicolon on [&%s]", strS);
        }
        int i = bt0.i(strS, this.t);
        if (i == 1) {
            iArr[0] = this.t[0];
            return iArr;
        }
        if (i == 2) {
            return this.t;
        }
        zy4.a("Unexpected characters returned for " + strS);
        return this.t;
    }

    public void f() {
        this.m.o();
        this.m.e = true;
    }

    public void g() {
        this.m.o();
    }

    public void h() {
        this.l.o();
    }

    public hp4.i i(boolean z) {
        hp4.i iVarO = z ? this.h.o() : this.i.o();
        this.j = iVarO;
        return iVarO;
    }

    public void j() {
        this.f.f();
    }

    public hp4.k k(boolean z) {
        hp4.k kVarO = this.n.o();
        kVarO.q = z;
        this.j = kVarO;
        return kVarO;
    }

    public void l(char c) {
        this.k.d.a(c);
        this.k.q(this.r);
        this.k.g(this.a.A0());
    }

    public void m(hp4 hp4Var) {
        zy4.b(this.e);
        this.d = hp4Var;
        this.e = true;
        hp4Var.q(this.q);
        hp4Var.g(this.a.A0());
        this.r = this.a.A0();
        hp4.j jVar = hp4Var.a;
        if (jVar == hp4.j.StartTag) {
            this.o = ((hp4.h) hp4Var).G();
            this.p = null;
        } else if (jVar == hp4.j.EndTag) {
            hp4.g gVar = (hp4.g) hp4Var;
            if (gVar.D()) {
                u("Attributes incorrectly present on end tag [/%s]", gVar.I());
            }
        }
    }

    public void n(String str) {
        this.k.s(str);
        this.k.q(this.r);
        this.k.g(this.a.A0());
    }

    public void o(int[] iArr) {
        n(new String(iArr, 0, iArr.length));
    }

    public void p() {
        m(this.m);
    }

    public void q() {
        m(this.l);
    }

    public void r() {
        this.j.B();
        m(this.j);
    }

    public void s(op4 op4Var) {
        if (this.b.b()) {
            this.b.add(new x73(this.a, "Unexpectedly reached end of file (EOF) in input state [%s]", op4Var));
        }
    }

    public void t(op4 op4Var) {
        if (this.b.b()) {
            y73 y73Var = this.b;
            xs xsVar = this.a;
            y73Var.add(new x73(xsVar, "Unexpected character '%s' in input state [%s]", Character.valueOf(xsVar.g0()), op4Var));
        }
    }

    public void u(String str, Object... objArr) {
        if (this.b.b()) {
            this.b.add(new x73(this.a, str, objArr));
        }
    }

    public boolean v() {
        return this.o != null && this.j.G().equalsIgnoreCase(this.o);
    }

    public hp4 w() {
        while (!this.e) {
            this.c.l(this, this.a);
        }
        if (this.k.d.e()) {
            return this.k;
        }
        this.e = false;
        return this.d;
    }

    public void x(op4 op4Var) {
        if (op4Var == op4.m) {
            this.q = this.a.A0();
        }
        this.c = op4Var;
    }
}
