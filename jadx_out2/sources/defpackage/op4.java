package defpackage;

import defpackage.hp4;
import defpackage.wm0;
import okio.Utf8;
import org.jupnp.xml.DOM;
import org.mozilla.javascript.Token;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class op4 {
    public static final op4 f = new k("Data", 0);
    public static final op4 g = new op4("CharacterReferenceInData", 1) { // from class: op4.v
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.m(np4Var, op4.f);
        }
    };
    public static final op4 h = new op4("Rcdata", 2) { // from class: op4.g0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cG0 = xsVar.g0();
            if (cG0 == 0) {
                np4Var.t(this);
                xsVar.B();
                np4Var.l(Utf8.REPLACEMENT_CHARACTER);
            } else {
                if (cG0 == '&') {
                    np4Var.a(op4.i);
                    return;
                }
                if (cG0 == '<') {
                    np4Var.a(op4.p);
                } else if (cG0 != 65535) {
                    np4Var.n(xsVar.O());
                } else {
                    np4Var.m(new hp4.f());
                }
            }
        }
    };
    public static final op4 i = new op4("CharacterReferenceInRcdata", 3) { // from class: op4.r0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.m(np4Var, op4.h);
        }
    };
    public static final op4 j = new op4("Rawtext", 4) { // from class: op4.c1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.o(np4Var, xsVar, this, op4.s);
        }
    };
    public static final op4 k = new op4("ScriptData", 5) { // from class: op4.m1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.o(np4Var, xsVar, this, op4.v);
        }
    };
    public static final op4 l = new op4("PLAINTEXT", 6) { // from class: op4.n1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cG0 = xsVar.g0();
            if (cG0 == 0) {
                np4Var.t(this);
                xsVar.B();
                np4Var.l(Utf8.REPLACEMENT_CHARACTER);
            } else if (cG0 != 65535) {
                np4Var.n(xsVar.Z((char) 0));
            } else {
                np4Var.m(new hp4.f());
            }
        }
    };
    public static final op4 m = new op4("TagOpen", 7) { // from class: op4.o1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cG0 = xsVar.g0();
            if (cG0 == '!') {
                np4Var.a(op4.W);
                return;
            }
            if (cG0 == '/') {
                np4Var.a(op4.n);
                return;
            }
            if (cG0 == '?') {
                if (np4Var.g == wm0.a.EnumC0128a.xml) {
                    np4Var.a(op4.X);
                    return;
                } else {
                    np4Var.f();
                    np4Var.x(op4.V);
                    return;
                }
            }
            if (xsVar.v0()) {
                np4Var.i(true);
                np4Var.x(op4.o);
            } else {
                np4Var.t(this);
                np4Var.l('<');
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 n = new op4("EndTagOpen", 8) { // from class: op4.p1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.i0()) {
                np4Var.s(this);
                np4Var.n("</");
                np4Var.x(op4.f);
            } else if (xsVar.v0()) {
                np4Var.i(false);
                np4Var.x(op4.o);
            } else if (xsVar.r0('>')) {
                np4Var.t(this);
                np4Var.a(op4.f);
            } else {
                np4Var.t(this);
                np4Var.f();
                np4Var.m.s('/');
                np4Var.x(op4.V);
            }
        }
    };
    public static final op4 o = new op4("TagName", 9) { // from class: op4.a
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            np4Var.j.y(xsVar.W());
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.j.y(op4.x0);
                return;
            }
            if (cM != ' ') {
                if (cM == '/') {
                    np4Var.x(op4.U);
                    return;
                }
                if (cM == '>') {
                    np4Var.r();
                    np4Var.x(op4.f);
                    return;
                } else if (cM == 65535) {
                    np4Var.s(this);
                    np4Var.x(op4.f);
                    return;
                } else if (cM != '\t' && cM != '\n' && cM != '\f' && cM != '\r') {
                    np4Var.j.x(cM);
                    return;
                }
            }
            np4Var.x(op4.M);
        }
    };
    public static final op4 p = new op4("RcdataLessthanSign", 10) { // from class: op4.b
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.r0('/')) {
                np4Var.j();
                np4Var.a(op4.q);
            } else if (!xsVar.D0() || !xsVar.v0() || np4Var.b() == null || xsVar.f0(np4Var.c())) {
                np4Var.l('<');
                np4Var.x(op4.h);
            } else {
                np4Var.j = np4Var.i(false).F(np4Var.b());
                np4Var.r();
                np4Var.x(op4.m);
            }
        }
    };
    public static final op4 q = new op4("RCDATAEndTagOpen", 11) { // from class: op4.c
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (!xsVar.v0()) {
                np4Var.n("</");
                np4Var.x(op4.h);
            } else {
                np4Var.i(false);
                np4Var.j.x(xsVar.g0());
                np4Var.f.a(xsVar.g0());
                np4Var.a(op4.r);
            }
        }
    };
    public static final op4 r = new op4("RCDATAEndTagName", 12) { // from class: op4.d
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.v0()) {
                String strW = xsVar.W();
                np4Var.j.y(strW);
                np4Var.f.b(strW);
                return;
            }
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                if (np4Var.v()) {
                    np4Var.x(op4.M);
                    return;
                } else {
                    p(np4Var, xsVar);
                    return;
                }
            }
            if (cM == '/') {
                if (np4Var.v()) {
                    np4Var.x(op4.U);
                    return;
                } else {
                    p(np4Var, xsVar);
                    return;
                }
            }
            if (cM != '>') {
                p(np4Var, xsVar);
            } else if (!np4Var.v()) {
                p(np4Var, xsVar);
            } else {
                np4Var.r();
                np4Var.x(op4.f);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void p(np4 np4Var, xs xsVar) {
            np4Var.n("</");
            np4Var.n(np4Var.f.h());
            xsVar.H0();
            np4Var.x(op4.h);
        }
    };
    public static final op4 s = new op4("RawtextLessthanSign", 13) { // from class: op4.e
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.r0('/')) {
                np4Var.j();
                np4Var.a(op4.t);
            } else {
                np4Var.l('<');
                np4Var.x(op4.j);
            }
        }
    };
    public static final op4 t = new op4("RawtextEndTagOpen", 14) { // from class: op4.f
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.n(np4Var, xsVar, op4.u, op4.j);
        }
    };
    public static final op4 u = new op4("RawtextEndTagName", 15) { // from class: op4.g
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.k(np4Var, xsVar, op4.j);
        }
    };
    public static final op4 v = new op4("ScriptDataLessthanSign", 16) { // from class: op4.h
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '!') {
                np4Var.n("<!");
                np4Var.x(op4.y);
                return;
            }
            if (cM == '/') {
                np4Var.j();
                np4Var.x(op4.w);
            } else if (cM != 65535) {
                np4Var.l('<');
                xsVar.H0();
                np4Var.x(op4.k);
            } else {
                np4Var.l('<');
                np4Var.s(this);
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 w = new op4("ScriptDataEndTagOpen", 17) { // from class: op4.i
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.n(np4Var, xsVar, op4.x, op4.k);
        }
    };
    public static final op4 x = new op4("ScriptDataEndTagName", 18) { // from class: op4.j
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.k(np4Var, xsVar, op4.k);
        }
    };
    public static final op4 y = new op4("ScriptDataEscapeStart", 19) { // from class: op4.l
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (!xsVar.r0('-')) {
                np4Var.x(op4.k);
            } else {
                np4Var.l('-');
                np4Var.a(op4.z);
            }
        }
    };
    public static final op4 z = new op4("ScriptDataEscapeStartDash", 20) { // from class: op4.m
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (!xsVar.r0('-')) {
                np4Var.x(op4.k);
            } else {
                np4Var.l('-');
                np4Var.a(op4.C);
            }
        }
    };
    public static final op4 A = new op4("ScriptDataEscaped", 21) { // from class: op4.n
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.i0()) {
                np4Var.s(this);
                np4Var.x(op4.f);
                return;
            }
            char cG0 = xsVar.g0();
            if (cG0 == 0) {
                np4Var.t(this);
                xsVar.B();
                np4Var.l(Utf8.REPLACEMENT_CHARACTER);
            } else if (cG0 == '-') {
                np4Var.l('-');
                np4Var.a(op4.B);
            } else if (cG0 != '<') {
                np4Var.n(xsVar.c0('-', '<', 0));
            } else {
                np4Var.a(op4.D);
            }
        }
    };
    public static final op4 B = new op4("ScriptDataEscapedDash", 22) { // from class: op4.o
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.i0()) {
                np4Var.s(this);
                np4Var.x(op4.f);
                return;
            }
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.A);
            } else if (cM == '-') {
                np4Var.l(cM);
                np4Var.x(op4.C);
            } else if (cM == '<') {
                np4Var.x(op4.D);
            } else {
                np4Var.l(cM);
                np4Var.x(op4.A);
            }
        }
    };
    public static final op4 C = new op4("ScriptDataEscapedDashDash", 23) { // from class: op4.p
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.i0()) {
                np4Var.s(this);
                np4Var.x(op4.f);
                return;
            }
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.A);
            } else {
                if (cM == '-') {
                    np4Var.l(cM);
                    return;
                }
                if (cM == '<') {
                    np4Var.x(op4.D);
                } else if (cM != '>') {
                    np4Var.l(cM);
                    np4Var.x(op4.A);
                } else {
                    np4Var.l(cM);
                    np4Var.x(op4.k);
                }
            }
        }
    };
    public static final op4 D = new op4("ScriptDataEscapedLessthanSign", 24) { // from class: op4.q
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.v0()) {
                np4Var.j();
                np4Var.f.a(xsVar.g0());
                np4Var.l('<');
                np4Var.l(xsVar.g0());
                np4Var.a(op4.G);
                return;
            }
            if (xsVar.r0('/')) {
                np4Var.j();
                np4Var.a(op4.E);
            } else {
                np4Var.l('<');
                np4Var.x(op4.A);
            }
        }
    };
    public static final op4 E = new op4("ScriptDataEscapedEndTagOpen", 25) { // from class: op4.r
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (!xsVar.v0()) {
                np4Var.n("</");
                np4Var.x(op4.A);
            } else {
                np4Var.i(false);
                np4Var.j.x(xsVar.g0());
                np4Var.f.a(xsVar.g0());
                np4Var.a(op4.F);
            }
        }
    };
    public static final op4 F = new op4("ScriptDataEscapedEndTagName", 26) { // from class: op4.s
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.k(np4Var, xsVar, op4.A);
        }
    };
    public static final op4 G = new op4("ScriptDataDoubleEscapeStart", 27) { // from class: op4.t
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.j(np4Var, xsVar, op4.H, op4.A);
        }
    };
    public static final op4 H = new op4("ScriptDataDoubleEscaped", 28) { // from class: op4.u
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cG0 = xsVar.g0();
            if (cG0 == 0) {
                np4Var.t(this);
                xsVar.B();
                np4Var.l(Utf8.REPLACEMENT_CHARACTER);
            } else if (cG0 == '-') {
                np4Var.l(cG0);
                np4Var.a(op4.I);
            } else if (cG0 == '<') {
                np4Var.l(cG0);
                np4Var.a(op4.K);
            } else if (cG0 != 65535) {
                np4Var.n(xsVar.c0('-', '<', 0));
            } else {
                np4Var.s(this);
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 I = new op4("ScriptDataDoubleEscapedDash", 29) { // from class: op4.w
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.H);
            } else if (cM == '-') {
                np4Var.l(cM);
                np4Var.x(op4.J);
            } else if (cM == '<') {
                np4Var.l(cM);
                np4Var.x(op4.K);
            } else if (cM != 65535) {
                np4Var.l(cM);
                np4Var.x(op4.H);
            } else {
                np4Var.s(this);
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 J = new op4("ScriptDataDoubleEscapedDashDash", 30) { // from class: op4.x
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.H);
                return;
            }
            if (cM == '-') {
                np4Var.l(cM);
                return;
            }
            if (cM == '<') {
                np4Var.l(cM);
                np4Var.x(op4.K);
            } else if (cM == '>') {
                np4Var.l(cM);
                np4Var.x(op4.k);
            } else if (cM != 65535) {
                np4Var.l(cM);
                np4Var.x(op4.H);
            } else {
                np4Var.s(this);
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 K = new op4("ScriptDataDoubleEscapedLessthanSign", 31) { // from class: op4.y
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (!xsVar.r0('/')) {
                np4Var.x(op4.H);
                return;
            }
            np4Var.l('/');
            np4Var.j();
            np4Var.a(op4.L);
        }
    };
    public static final op4 L = new op4("ScriptDataDoubleEscapeEnd", 32) { // from class: op4.z
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            op4.j(np4Var, xsVar, op4.A, op4.H);
        }
    };
    public static final op4 M = new op4("BeforeAttributeName", 33) { // from class: op4.a0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                xsVar.H0();
                np4Var.t(this);
                np4Var.j.H();
                np4Var.x(op4.N);
                return;
            }
            if (cM != ' ') {
                if (cM != '\"' && cM != '\'') {
                    if (cM == '/') {
                        np4Var.x(op4.U);
                        return;
                    }
                    if (cM == 65535) {
                        np4Var.s(this);
                        np4Var.x(op4.f);
                        return;
                    }
                    if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r') {
                        return;
                    }
                    switch (cM) {
                        case Token.CATCH_SCOPE /* 62 */:
                            np4Var.r();
                            np4Var.x(op4.f);
                            return;
                        case Token.ENUM_INIT_KEYS /* 63 */:
                            if (np4Var.j instanceof hp4.k) {
                                return;
                            }
                            break;
                    }
                    np4Var.j.H();
                    xsVar.H0();
                    np4Var.x(op4.N);
                    return;
                }
                np4Var.t(this);
                np4Var.j.H();
                np4Var.j.s(cM, xsVar.A0() - 1, xsVar.A0());
                np4Var.x(op4.N);
            }
        }
    };
    public static final op4 N = new op4("AttributeName", 34) { // from class: op4.b0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            int iA0 = xsVar.A0();
            np4Var.j.t(xsVar.d0(op4.v0), iA0, xsVar.A0());
            int iA02 = xsVar.A0();
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                np4Var.x(op4.O);
                return;
            }
            if (cM != '\"' && cM != '\'') {
                if (cM == '/') {
                    np4Var.x(op4.U);
                    return;
                }
                if (cM == 65535) {
                    np4Var.s(this);
                    np4Var.x(op4.f);
                    return;
                }
                switch (cM) {
                    case Token.SETVAR /* 61 */:
                        np4Var.x(op4.P);
                        return;
                    case Token.CATCH_SCOPE /* 62 */:
                        np4Var.r();
                        np4Var.x(op4.f);
                        return;
                    case Token.ENUM_INIT_KEYS /* 63 */:
                        if (np4Var.g == wm0.a.EnumC0128a.xml && (np4Var.j instanceof hp4.k)) {
                            np4Var.x(op4.O);
                            return;
                        }
                        break;
                }
                np4Var.j.s(cM, iA02, xsVar.A0());
                return;
            }
            np4Var.t(this);
            np4Var.j.s(cM, iA02, xsVar.A0());
        }
    };
    public static final op4 O = new op4("AfterAttributeName", 35) { // from class: op4.c0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.j.s(Utf8.REPLACEMENT_CHARACTER, xsVar.A0() - 1, xsVar.A0());
                np4Var.x(op4.N);
                return;
            }
            if (cM != ' ') {
                if (cM != '\"' && cM != '\'') {
                    if (cM == '/') {
                        np4Var.x(op4.U);
                        return;
                    }
                    if (cM == 65535) {
                        np4Var.s(this);
                        np4Var.x(op4.f);
                        return;
                    }
                    if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r') {
                        return;
                    }
                    switch (cM) {
                        case '<':
                            break;
                        case Token.SETVAR /* 61 */:
                            np4Var.x(op4.P);
                            break;
                        case Token.CATCH_SCOPE /* 62 */:
                            np4Var.r();
                            np4Var.x(op4.f);
                            break;
                        default:
                            np4Var.j.H();
                            xsVar.H0();
                            np4Var.x(op4.N);
                            break;
                    }
                    return;
                }
                np4Var.t(this);
                np4Var.j.H();
                np4Var.j.s(cM, xsVar.A0() - 1, xsVar.A0());
                np4Var.x(op4.N);
            }
        }
    };
    public static final op4 P = new op4("BeforeAttributeValue", 36) { // from class: op4.d0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.j.u(Utf8.REPLACEMENT_CHARACTER, xsVar.A0() - 1, xsVar.A0());
                np4Var.x(op4.S);
                return;
            }
            if (cM != ' ') {
                if (cM == '\"') {
                    np4Var.x(op4.Q);
                    return;
                }
                if (cM != '`') {
                    if (cM == 65535) {
                        np4Var.s(this);
                        np4Var.r();
                        np4Var.x(op4.f);
                        return;
                    }
                    if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r') {
                        return;
                    }
                    if (cM == '&') {
                        xsVar.H0();
                        np4Var.x(op4.S);
                        return;
                    }
                    if (cM == '\'') {
                        np4Var.x(op4.R);
                        return;
                    }
                    switch (cM) {
                        case '<':
                        case Token.SETVAR /* 61 */:
                            break;
                        case Token.CATCH_SCOPE /* 62 */:
                            np4Var.t(this);
                            np4Var.r();
                            np4Var.x(op4.f);
                            break;
                        default:
                            xsVar.H0();
                            np4Var.x(op4.S);
                            break;
                    }
                    return;
                }
                np4Var.t(this);
                np4Var.j.u(cM, xsVar.A0() - 1, xsVar.A0());
                np4Var.x(op4.S);
            }
        }
    };
    public static final op4 Q = new op4("AttributeValue_doubleQuoted", 37) { // from class: op4.e0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            int iA0 = xsVar.A0();
            String strN = xsVar.N(false);
            if (strN.length() > 0) {
                np4Var.j.v(strN, iA0, xsVar.A0());
            } else {
                np4Var.j.L();
            }
            int iA02 = xsVar.A0();
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.j.u(Utf8.REPLACEMENT_CHARACTER, iA02, xsVar.A0());
                return;
            }
            if (cM == '\"') {
                np4Var.x(op4.T);
                return;
            }
            if (cM != '&') {
                if (cM != 65535) {
                    np4Var.j.u(cM, iA02, xsVar.A0());
                    return;
                } else {
                    np4Var.s(this);
                    np4Var.x(op4.f);
                    return;
                }
            }
            int[] iArrE = np4Var.e('\"', true);
            hp4.i iVar = np4Var.j;
            if (iArrE != null) {
                iVar.w(iArrE, iA02, xsVar.A0());
            } else {
                iVar.u('&', iA02, xsVar.A0());
            }
        }
    };
    public static final op4 R = new op4("AttributeValue_singleQuoted", 38) { // from class: op4.f0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            int iA0 = xsVar.A0();
            String strN = xsVar.N(true);
            if (strN.length() > 0) {
                np4Var.j.v(strN, iA0, xsVar.A0());
            } else {
                np4Var.j.L();
            }
            int iA02 = xsVar.A0();
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.j.u(Utf8.REPLACEMENT_CHARACTER, iA02, xsVar.A0());
                return;
            }
            if (cM == 65535) {
                np4Var.s(this);
                np4Var.x(op4.f);
                return;
            }
            if (cM != '&') {
                if (cM != '\'') {
                    np4Var.j.u(cM, iA02, xsVar.A0());
                    return;
                } else {
                    np4Var.x(op4.T);
                    return;
                }
            }
            int[] iArrE = np4Var.e('\'', true);
            hp4.i iVar = np4Var.j;
            if (iArrE != null) {
                iVar.w(iArrE, iA02, xsVar.A0());
            } else {
                iVar.u('&', iA02, xsVar.A0());
            }
        }
    };
    public static final op4 S = new op4("AttributeValue_unquoted", 39) { // from class: op4.h0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            int iA0 = xsVar.A0();
            String strD0 = xsVar.d0(op4.w0);
            if (strD0.length() > 0) {
                np4Var.j.v(strD0, iA0, xsVar.A0());
            }
            int iA02 = xsVar.A0();
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.j.u(Utf8.REPLACEMENT_CHARACTER, iA02, xsVar.A0());
                return;
            }
            if (cM != ' ') {
                if (cM != '\"' && cM != '`') {
                    if (cM == 65535) {
                        np4Var.s(this);
                        np4Var.x(op4.f);
                        return;
                    }
                    if (cM != '\t' && cM != '\n' && cM != '\f' && cM != '\r') {
                        if (cM == '&') {
                            int[] iArrE = np4Var.e('>', true);
                            hp4.i iVar = np4Var.j;
                            if (iArrE != null) {
                                iVar.w(iArrE, iA02, xsVar.A0());
                                return;
                            } else {
                                iVar.u('&', iA02, xsVar.A0());
                                return;
                            }
                        }
                        if (cM != '\'') {
                            switch (cM) {
                                case '<':
                                case Token.SETVAR /* 61 */:
                                    break;
                                case Token.CATCH_SCOPE /* 62 */:
                                    np4Var.r();
                                    np4Var.x(op4.f);
                                    break;
                                default:
                                    np4Var.j.u(cM, iA02, xsVar.A0());
                                    break;
                            }
                            return;
                        }
                    }
                }
                np4Var.t(this);
                np4Var.j.u(cM, iA02, xsVar.A0());
                return;
            }
            np4Var.x(op4.M);
        }
    };
    public static final op4 T = new op4("AfterAttributeValue_quoted", 40) { // from class: op4.i0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                np4Var.x(op4.M);
                return;
            }
            if (cM == '/') {
                np4Var.x(op4.U);
                return;
            }
            if (cM == 65535) {
                np4Var.s(this);
                np4Var.x(op4.f);
            } else if (cM == '>') {
                np4Var.r();
                np4Var.x(op4.f);
            } else {
                if (cM == '?' && (np4Var.j instanceof hp4.k)) {
                    return;
                }
                xsVar.H0();
                np4Var.t(this);
                np4Var.x(op4.M);
            }
        }
    };
    public static final op4 U = new op4("SelfClosingStartTag", 41) { // from class: op4.j0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '>') {
                np4Var.j.f = true;
                np4Var.r();
                np4Var.x(op4.f);
            } else if (cM == 65535) {
                np4Var.s(this);
                np4Var.x(op4.f);
            } else {
                xsVar.H0();
                np4Var.t(this);
                np4Var.x(op4.M);
            }
        }
    };
    public static final op4 V = new op4("BogusComment", 42) { // from class: op4.k0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            np4Var.m.t(xsVar.Z('>'));
            char cG0 = xsVar.g0();
            if (cG0 == '>' || cG0 == 65535) {
                xsVar.M();
                np4Var.p();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 W = new op4("MarkupDeclarationOpen", 43) { // from class: op4.l0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.p0("--")) {
                np4Var.g();
                np4Var.x(op4.Y);
                return;
            }
            if (xsVar.q0("DOCTYPE")) {
                np4Var.x(op4.e0);
                return;
            }
            if (xsVar.p0("[CDATA[")) {
                np4Var.j();
                np4Var.x(op4.u0);
            } else if (np4Var.g == wm0.a.EnumC0128a.xml && xsVar.v0()) {
                np4Var.k(true);
                np4Var.x(op4.o);
            } else {
                np4Var.t(this);
                np4Var.f();
                np4Var.x(op4.V);
            }
        }
    };
    public static final op4 X = new op4("MarkupProcessingOpen", 44) { // from class: op4.m0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.v0()) {
                np4Var.k(false);
                np4Var.x(op4.o);
            } else {
                np4Var.t(this);
                np4Var.f();
                np4Var.m.s('?');
                np4Var.x(op4.V);
            }
        }
    };
    public static final op4 Y = new op4("CommentStart", 45) { // from class: op4.n0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.m.s(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.a0);
                return;
            }
            if (cM == '-') {
                np4Var.x(op4.Z);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.p();
                np4Var.x(op4.f);
            } else if (cM != 65535) {
                xsVar.H0();
                np4Var.x(op4.a0);
            } else {
                np4Var.s(this);
                np4Var.p();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 Z = new op4("CommentStartDash", 46) { // from class: op4.o0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.m.s(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.a0);
                return;
            }
            if (cM == '-') {
                np4Var.x(op4.c0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.p();
                np4Var.x(op4.f);
            } else if (cM != 65535) {
                np4Var.m.s(cM);
                np4Var.x(op4.a0);
            } else {
                np4Var.s(this);
                np4Var.p();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 a0 = new op4("Comment", 47) { // from class: op4.p0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cG0 = xsVar.g0();
            if (cG0 == 0) {
                np4Var.t(this);
                xsVar.B();
                np4Var.m.s(Utf8.REPLACEMENT_CHARACTER);
            } else if (cG0 == '-') {
                np4Var.a(op4.b0);
            } else {
                if (cG0 != 65535) {
                    np4Var.m.t(xsVar.c0('-', 0));
                    return;
                }
                np4Var.s(this);
                np4Var.p();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 b0 = new op4("CommentEndDash", 48) { // from class: op4.q0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.m.s('-').s(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.a0);
            } else {
                if (cM == '-') {
                    np4Var.x(op4.c0);
                    return;
                }
                if (cM != 65535) {
                    np4Var.m.s('-').s(cM);
                    np4Var.x(op4.a0);
                } else {
                    np4Var.s(this);
                    np4Var.p();
                    np4Var.x(op4.f);
                }
            }
        }
    };
    public static final op4 c0 = new op4("CommentEnd", 49) { // from class: op4.s0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.m.t("--").s(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.a0);
                return;
            }
            if (cM == '!') {
                np4Var.x(op4.d0);
                return;
            }
            if (cM == '-') {
                np4Var.m.s('-');
                return;
            }
            if (cM == '>') {
                np4Var.p();
                np4Var.x(op4.f);
            } else if (cM != 65535) {
                np4Var.m.t("--").s(cM);
                np4Var.x(op4.a0);
            } else {
                np4Var.s(this);
                np4Var.p();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 d0 = new op4("CommentEndBang", 50) { // from class: op4.t0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.m.t("--!").s(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.a0);
                return;
            }
            if (cM == '-') {
                np4Var.m.t("--!");
                np4Var.x(op4.b0);
                return;
            }
            if (cM == '>') {
                np4Var.p();
                np4Var.x(op4.f);
            } else if (cM != 65535) {
                np4Var.m.t("--!").s(cM);
                np4Var.x(op4.a0);
            } else {
                np4Var.s(this);
                np4Var.p();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 e0 = new op4("Doctype", 51) { // from class: op4.u0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                np4Var.x(op4.f0);
                return;
            }
            if (cM != '>') {
                if (cM != 65535) {
                    np4Var.t(this);
                    np4Var.x(op4.f0);
                    return;
                }
                np4Var.s(this);
            }
            np4Var.t(this);
            np4Var.h();
            np4Var.l.h = true;
            np4Var.q();
            np4Var.x(op4.f);
        }
    };
    public static final op4 f0 = new op4("BeforeDoctypeName", 52) { // from class: op4.v0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.v0()) {
                np4Var.h();
                np4Var.x(op4.g0);
                return;
            }
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.h();
                np4Var.l.d.a(Utf8.REPLACEMENT_CHARACTER);
                np4Var.x(op4.g0);
                return;
            }
            if (cM != ' ') {
                if (cM == 65535) {
                    np4Var.s(this);
                    np4Var.h();
                    np4Var.l.h = true;
                    np4Var.q();
                    np4Var.x(op4.f);
                    return;
                }
                if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r') {
                    return;
                }
                np4Var.h();
                np4Var.l.d.a(cM);
                np4Var.x(op4.g0);
            }
        }
    };
    public static final op4 g0 = new op4("DoctypeName", 53) { // from class: op4.w0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.v0()) {
                np4Var.l.d.b(xsVar.R());
                return;
            }
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l.d.a(Utf8.REPLACEMENT_CHARACTER);
                return;
            }
            if (cM != ' ') {
                if (cM == '>') {
                    np4Var.q();
                    np4Var.x(op4.f);
                    return;
                }
                if (cM == 65535) {
                    np4Var.s(this);
                    np4Var.l.h = true;
                    np4Var.q();
                    np4Var.x(op4.f);
                    return;
                }
                if (cM != '\t' && cM != '\n' && cM != '\f' && cM != '\r') {
                    np4Var.l.d.a(cM);
                    return;
                }
            }
            np4Var.x(op4.h0);
        }
    };
    public static final op4 h0 = new op4("AfterDoctypeName", 54) { // from class: op4.x0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            if (xsVar.i0()) {
                np4Var.s(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (xsVar.t0('\t', '\n', '\r', '\f', ' ')) {
                xsVar.B();
                return;
            }
            if (xsVar.r0('>')) {
                np4Var.q();
                np4Var.a(op4.f);
                return;
            }
            if (xsVar.q0("PUBLIC")) {
                np4Var.l.e = "PUBLIC";
                np4Var.x(op4.i0);
            } else if (xsVar.q0("SYSTEM")) {
                np4Var.l.e = "SYSTEM";
                np4Var.x(op4.o0);
            } else {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.a(op4.t0);
            }
        }
    };
    public static final op4 i0 = new op4("AfterDoctypePublicKeyword", 55) { // from class: op4.y0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                np4Var.x(op4.j0);
                return;
            }
            if (cM == '\"') {
                np4Var.t(this);
                np4Var.x(op4.k0);
                return;
            }
            if (cM == '\'') {
                np4Var.t(this);
                np4Var.x(op4.l0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (cM != 65535) {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.x(op4.t0);
            } else {
                np4Var.s(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 j0 = new op4("BeforeDoctypePublicIdentifier", 56) { // from class: op4.z0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                return;
            }
            if (cM == '\"') {
                np4Var.x(op4.k0);
                return;
            }
            if (cM == '\'') {
                np4Var.x(op4.l0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (cM != 65535) {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.x(op4.t0);
            } else {
                np4Var.s(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 k0 = new op4("DoctypePublicIdentifier_doubleQuoted", 57) { // from class: op4.a1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l.f.a(Utf8.REPLACEMENT_CHARACTER);
                return;
            }
            if (cM == '\"') {
                np4Var.x(op4.m0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (cM != 65535) {
                np4Var.l.f.a(cM);
                return;
            }
            np4Var.s(this);
            np4Var.l.h = true;
            np4Var.q();
            np4Var.x(op4.f);
        }
    };
    public static final op4 l0 = new op4("DoctypePublicIdentifier_singleQuoted", 58) { // from class: op4.b1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l.f.a(Utf8.REPLACEMENT_CHARACTER);
                return;
            }
            if (cM == '\'') {
                np4Var.x(op4.m0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (cM != 65535) {
                np4Var.l.f.a(cM);
                return;
            }
            np4Var.s(this);
            np4Var.l.h = true;
            np4Var.q();
            np4Var.x(op4.f);
        }
    };
    public static final op4 m0 = new op4("AfterDoctypePublicIdentifier", 59) { // from class: op4.d1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                np4Var.x(op4.n0);
                return;
            }
            if (cM == '\"') {
                np4Var.t(this);
                np4Var.x(op4.q0);
                return;
            }
            if (cM == '\'') {
                np4Var.t(this);
                np4Var.x(op4.r0);
                return;
            }
            if (cM == '>') {
                np4Var.q();
                np4Var.x(op4.f);
            } else if (cM != 65535) {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.x(op4.t0);
            } else {
                np4Var.s(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 n0 = new op4("BetweenDoctypePublicAndSystemIdentifiers", 60) { // from class: op4.e1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                return;
            }
            if (cM == '\"') {
                np4Var.t(this);
                np4Var.x(op4.q0);
                return;
            }
            if (cM == '\'') {
                np4Var.t(this);
                np4Var.x(op4.r0);
                return;
            }
            if (cM == '>') {
                np4Var.q();
                np4Var.x(op4.f);
            } else if (cM != 65535) {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.x(op4.t0);
            } else {
                np4Var.s(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 o0 = new op4("AfterDoctypeSystemKeyword", 61) { // from class: op4.f1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                np4Var.x(op4.p0);
                return;
            }
            if (cM == '\"') {
                np4Var.t(this);
                np4Var.x(op4.q0);
                return;
            }
            if (cM == '\'') {
                np4Var.t(this);
                np4Var.x(op4.r0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (cM != 65535) {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
            } else {
                np4Var.s(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 p0 = new op4("BeforeDoctypeSystemIdentifier", 62) { // from class: op4.g1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                return;
            }
            if (cM == '\"') {
                np4Var.x(op4.q0);
                return;
            }
            if (cM == '\'') {
                np4Var.x(op4.r0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (cM != 65535) {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.x(op4.t0);
            } else {
                np4Var.s(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 q0 = new op4("DoctypeSystemIdentifier_doubleQuoted", 63) { // from class: op4.h1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l.g.a(Utf8.REPLACEMENT_CHARACTER);
                return;
            }
            if (cM == '\"') {
                np4Var.x(op4.s0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (cM != 65535) {
                np4Var.l.g.a(cM);
                return;
            }
            np4Var.s(this);
            np4Var.l.h = true;
            np4Var.q();
            np4Var.x(op4.f);
        }
    };
    public static final op4 r0 = new op4("DoctypeSystemIdentifier_singleQuoted", 64) { // from class: op4.i1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == 0) {
                np4Var.t(this);
                np4Var.l.g.a(Utf8.REPLACEMENT_CHARACTER);
                return;
            }
            if (cM == '\'') {
                np4Var.x(op4.s0);
                return;
            }
            if (cM == '>') {
                np4Var.t(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
                return;
            }
            if (cM != 65535) {
                np4Var.l.g.a(cM);
                return;
            }
            np4Var.s(this);
            np4Var.l.h = true;
            np4Var.q();
            np4Var.x(op4.f);
        }
    };
    public static final op4 s0 = new op4("AfterDoctypeSystemIdentifier", 65) { // from class: op4.j1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                return;
            }
            if (cM == '>') {
                np4Var.q();
                np4Var.x(op4.f);
            } else if (cM != 65535) {
                np4Var.t(this);
                np4Var.x(op4.t0);
            } else {
                np4Var.s(this);
                np4Var.l.h = true;
                np4Var.q();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 t0 = new op4("BogusDoctype", 66) { // from class: op4.k1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cM = xsVar.M();
            if (cM == '>') {
                np4Var.q();
                np4Var.x(op4.f);
            } else {
                if (cM != 65535) {
                    return;
                }
                np4Var.q();
                np4Var.x(op4.f);
            }
        }
    };
    public static final op4 u0 = new op4("CdataSection", 67) { // from class: op4.l1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            k kVar = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            np4Var.f.b(xsVar.b0(DOM.CDATA_END));
            if (xsVar.p0(DOM.CDATA_END) || xsVar.i0()) {
                np4Var.m(new hp4.b(np4Var.f.h()));
                np4Var.x(op4.f);
            }
        }
    };
    public static final /* synthetic */ op4[] y0 = a();
    public static final char[] v0 = {'\t', '\n', '\f', '\r', ' ', '\"', '\'', '/', '<', '=', '>', '?'};
    public static final char[] w0 = {0, '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};
    public static final String x0 = String.valueOf(Utf8.REPLACEMENT_CHARACTER);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum k extends op4 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public k(String str, int i) {
            super(str, i, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.op4
        public void l(np4 np4Var, xs xsVar) {
            char cG0 = xsVar.g0();
            if (cG0 == 0) {
                np4Var.t(this);
                np4Var.l(xsVar.M());
            } else {
                if (cG0 == '&') {
                    np4Var.a(op4.g);
                    return;
                }
                if (cG0 == '<') {
                    np4Var.a(op4.m);
                } else if (cG0 != 65535) {
                    np4Var.n(xsVar.O());
                } else {
                    np4Var.m(new hp4.f());
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public op4(String str, int i2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ op4[] a() {
        return new op4[]{f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0, k0, l0, m0, n0, o0, p0, q0, r0, s0, t0, u0};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void j(np4 np4Var, xs xsVar, op4 op4Var, op4 op4Var2) {
        if (xsVar.v0()) {
            String strR = xsVar.R();
            np4Var.f.b(strR);
            np4Var.n(strR);
            return;
        }
        char cM = xsVar.M();
        if (cM != '\t' && cM != '\n' && cM != '\f' && cM != '\r' && cM != ' ' && cM != '/' && cM != '>') {
            xsVar.H0();
            np4Var.x(op4Var2);
        } else {
            if (np4Var.f.h().equals("script")) {
                np4Var.x(op4Var);
            } else {
                np4Var.x(op4Var2);
            }
            np4Var.l(cM);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void k(np4 np4Var, xs xsVar, op4 op4Var) {
        if (xsVar.v0()) {
            String strW = xsVar.W();
            np4Var.j.y(strW);
            np4Var.f.b(strW);
            return;
        }
        if (np4Var.v() && !xsVar.i0()) {
            char cM = xsVar.M();
            if (cM == '\t' || cM == '\n' || cM == '\f' || cM == '\r' || cM == ' ') {
                np4Var.x(M);
                return;
            }
            if (cM == '/') {
                np4Var.x(U);
                return;
            } else {
                if (cM == '>') {
                    np4Var.r();
                    np4Var.x(f);
                    return;
                }
                np4Var.f.a(cM);
            }
        }
        np4Var.n("</");
        np4Var.n(np4Var.f.h());
        np4Var.x(op4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void m(np4 np4Var, op4 op4Var) {
        int[] iArrE = np4Var.e(null, false);
        if (iArrE == null) {
            np4Var.l('&');
        } else {
            np4Var.o(iArrE);
        }
        np4Var.x(op4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void n(np4 np4Var, xs xsVar, op4 op4Var, op4 op4Var2) {
        if (xsVar.v0()) {
            np4Var.i(false);
            np4Var.x(op4Var);
        } else {
            np4Var.n("</");
            np4Var.x(op4Var2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void o(np4 np4Var, xs xsVar, op4 op4Var, op4 op4Var2) {
        char cG0 = xsVar.g0();
        if (cG0 == 0) {
            np4Var.t(op4Var);
            xsVar.B();
            np4Var.l(Utf8.REPLACEMENT_CHARACTER);
        } else if (cG0 == '<') {
            np4Var.a(op4Var2);
        } else if (cG0 != 65535) {
            np4Var.n(xsVar.V());
        } else {
            np4Var.m(new hp4.f());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static op4 valueOf(String str) {
        return (op4) Enum.valueOf(op4.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static op4[] values() {
        return (op4[]) y0.clone();
    }

    public abstract void l(np4 np4Var, xs xsVar);

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 java.lang.String), (r2v0 int) A[MD:(java.lang.String, int):void (m)] (LINE:5) call: op4.<init>(java.lang.String, int):void type: THIS */
    public /* synthetic */ op4(String str, int i2, k kVar) {
        this(str, i2);
    }
}
