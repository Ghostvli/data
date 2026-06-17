package defpackage;

import org.mozilla.javascript.Kit;
import org.mozilla.javascript.ScriptRuntime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class iq0 {
    public boolean a;
    public int c;
    public int e;
    public int g;
    public final String h;
    public int k;
    public int l;
    public final boolean m;
    public char[] b = new char[128];
    public final int[] d = new int[3];
    public int f = -1;
    public int i = 0;
    public int j = 0;

    public iq0(String str, int i, boolean z) {
        this.h = str;
        this.g = i;
        this.m = z;
    }

    public static boolean i(int i) {
        return i <= 90 ? 65 <= i : 97 <= i && i <= 122;
    }

    public static boolean j(int i) {
        return 48 <= i && i <= 57;
    }

    public static boolean k(int i, int i2) {
        if (i == 10 && j(i2)) {
            return true;
        }
        if (i == 16 && m(i2)) {
            return true;
        }
        if (i == 8 && p(i2)) {
            return true;
        }
        return i == 2 && l(i2);
    }

    public static boolean l(int i) {
        return 48 == i || i == 49;
    }

    public static boolean m(int i) {
        if (48 <= i && i <= 57) {
            return true;
        }
        if (97 > i || i > 102) {
            return 65 <= i && i <= 70;
        }
        return true;
    }

    public static boolean n(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    public static boolean o(int i) {
        return i <= 127 ? i == 32 || i == 9 || i == 12 || i == 11 : i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    public static boolean p(int i) {
        return 48 <= i && i <= 55;
    }

    public static ip4 x(String str, boolean z) {
        str.getClass();
        switch (str) {
            case "delete":
                return ip4.DELPROP;
            case "extends":
            case "enum":
            case "await":
            case "class":
            case "super":
                return ip4.RESERVED;
            case "export":
                return ip4.EXPORT;
            case "import":
                return ip4.IMPORT;
            case "public":
            case "implements":
            case "static":
            case "package":
            case "protected":
            case "private":
            case "interface":
                if (z) {
                    return ip4.RESERVED;
                }
                break;
            case "return":
                return ip4.RETURN;
            case "switch":
                return ip4.SWITCH;
            case "typeof":
                return ip4.TYPEOF;
            case "finally":
                return ip4.FINALLY;
            case "continue":
                return ip4.CONTINUE;
            case "do":
                return ip4.DO;
            case "if":
                return ip4.IF;
            case "in":
                return ip4.IN;
            case "for":
                return ip4.FOR;
            case "let":
                return ip4.LET;
            case "new":
                return ip4.NEW;
            case "try":
                return ip4.TRY;
            case "var":
                return ip4.VAR;
            case "case":
                return ip4.CASE;
            case "else":
                return ip4.ELSE;
            case "null":
                return ip4.NULL;
            case "this":
                return ip4.THIS;
            case "true":
                return ip4.TRUE;
            case "void":
                return ip4.VOID;
            case "with":
                return ip4.WITH;
            case "break":
                return ip4.BREAK;
            case "catch":
                return ip4.CATCH;
            case "const":
                return ip4.CONST;
            case "false":
                return ip4.FALSE;
            case "throw":
                return ip4.THROW;
            case "while":
                return ip4.WHILE;
            case "yield":
                return ip4.YIELD;
            case "debugger":
                return ip4.DEBUGGER;
            case "instanceof":
                return ip4.INSTANCEOF;
            case "function":
                return ip4.FUNCTION;
            case "default":
                return ip4.DEFAULT;
        }
        return ip4.EOF;
    }

    public final void a(int i) {
        int i2 = this.c;
        char[] cArr = this.b;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.b = cArr2;
        }
        this.b[i2] = (char) i;
        this.c = i2 + 1;
    }

    public final int b() {
        return d(true, false);
    }

    public final int c(boolean z) {
        return d(z, false);
    }

    public final int d(boolean z, boolean z2) {
        int i;
        int i2 = this.e;
        if (i2 != 0) {
            this.j++;
            int[] iArr = this.d;
            int i3 = i2 - 1;
            this.e = i3;
            return iArr[i3];
        }
        while (this.i != this.h.length()) {
            this.j++;
            String str = this.h;
            int i4 = this.i;
            this.i = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (!z2 && (i = this.f) >= 0) {
                if (i == 13 && cCharAt == '\n') {
                    this.f = 10;
                } else {
                    this.f = -1;
                    this.g++;
                }
            }
            if (cCharAt <= 127) {
                if (cCharAt == '\n' || cCharAt == '\r') {
                    this.f = cCharAt;
                    return 10;
                }
            } else if (cCharAt != 65279) {
                if (!z || !n(cCharAt)) {
                    if (ScriptRuntime.isJSLineTerminator(cCharAt)) {
                        this.f = cCharAt;
                        return 10;
                    }
                }
            }
            return cCharAt;
        }
        return -1;
    }

    public final int e() {
        return d(true, true);
    }

    public final int f(boolean z) {
        return d(z, true);
    }

    public final String g() {
        this.l = this.j;
        return new String(this.b, 0, this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:180:0x021d, code lost:
    
        if (q(42) != false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x021f, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0221, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0222, code lost:
    
        r5 = b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0226, code lost:
    
        if (r5 == (-1)) goto L460;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0228, code lost:
    
        if (r5 != 42) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x022b, code lost:
    
        if (r5 != 47) goto L462;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x022d, code lost:
    
        if (r3 == false) goto L467;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x022f, code lost:
    
        r19.l = r19.j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0235, code lost:
    
        return defpackage.ip4.COMMENT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0236, code lost:
    
        r19.l = r19.j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x023b, code lost:
    
        r19.l = r19.j - 1;
        defpackage.ny4.a("unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0245, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x0222, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:185:0x0228 -> B:181:0x021f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.ip4 h() throws defpackage.s83 {
        /*
            Method dump skipped, instruction units count: 1298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iq0.h():ip4");
    }

    public final boolean q(int i) {
        int iE = e();
        if (iE == i) {
            this.l = this.j;
            return true;
        }
        z(iE);
        return false;
    }

    public ip4 r() throws s83 {
        ip4 ip4VarH = h();
        while (true) {
            if (ip4VarH != ip4.EOL && ip4VarH != ip4.COMMENT) {
                return ip4VarH;
            }
            ip4VarH = h();
        }
    }

    public final int s() {
        int iB = b();
        y(iB);
        return iB;
    }

    public final int t(int i, int i2) {
        if (k(i, i2)) {
            a(i2);
            i2 = b();
            if (i2 != -1) {
                while (true) {
                    if (i2 != 95) {
                        if (!k(i, i2)) {
                            break;
                        }
                        a(i2);
                        i2 = b();
                        if (i2 == -1) {
                            return -1;
                        }
                    } else {
                        i2 = b();
                        if (i2 == 10 || i2 == -1) {
                            return -2;
                        }
                        if (!k(i, i2)) {
                            y(i2);
                            return 95;
                        }
                        a(95);
                    }
                }
            } else {
                return -1;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
    
        defpackage.ny4.a("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0081, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(defpackage.ip4 r9) throws defpackage.s83 {
        /*
            r8 = this;
            int r0 = r8.k
            r1 = 0
            r8.c = r1
            ip4 r2 = defpackage.ip4.ASSIGN_DIV
            r3 = 1
            java.lang.String r4 = "msg.unterminated.re.lit"
            if (r9 != r2) goto L12
            r9 = 61
            r8.a(r9)
            goto L21
        L12:
            ip4 r2 = defpackage.ip4.DIV
            if (r9 == r2) goto L19
            org.mozilla.javascript.Kit.codeBug()
        L19:
            int r9 = r8.s()
            r2 = 42
            if (r9 == r2) goto L82
        L21:
            r9 = r1
        L22:
            int r2 = r8.b()
            r5 = 47
            r6 = -1
            if (r2 != r5) goto L55
            if (r9 == 0) goto L2e
            goto L55
        L2e:
            int r9 = r8.e()
            java.lang.String r1 = "gimysu"
            int r1 = r1.indexOf(r9)
            if (r1 == r6) goto L3e
            r8.a(r9)
            goto L2e
        L3e:
            boolean r1 = i(r9)
            if (r1 != 0) goto L4f
            r8.z(r9)
            int r9 = r8.c
            int r0 = r0 + r9
            int r0 = r0 + 2
            r8.l = r0
            return
        L4f:
            java.lang.String r8 = "msg.invalid.re.flag"
            defpackage.ny4.a(r8)
            return
        L55:
            r5 = 10
            if (r2 == r5) goto L7e
            if (r2 == r6) goto L7e
            r7 = 92
            if (r2 != r7) goto L6f
            r8.a(r2)
            int r2 = r8.b()
            if (r2 == r5) goto L6b
            if (r2 == r6) goto L6b
            goto L7a
        L6b:
            defpackage.ny4.a(r4)
            return
        L6f:
            r5 = 91
            if (r2 != r5) goto L75
            r9 = r3
            goto L7a
        L75:
            r5 = 93
            if (r2 != r5) goto L7a
            r9 = r1
        L7a:
            r8.a(r2)
            goto L22
        L7e:
            defpackage.ny4.a(r4)
            return
        L82:
            int r9 = r8.j
            int r9 = r9 - r3
            r8.l = r9
            defpackage.ny4.a(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iq0.u(ip4):void");
    }

    public final void v() {
        int iB;
        do {
            iB = b();
            if (iB == -1) {
                break;
            }
        } while (iB != 10);
        y(iB);
        this.l = this.j;
    }

    public final ip4 w(String str) {
        return x(str, this.m);
    }

    public final void y(int i) {
        int i2 = this.e;
        if (i2 != 0 && this.d[i2 - 1] == 10) {
            Kit.codeBug();
        }
        int[] iArr = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        iArr[i3] = i;
        this.j--;
    }

    public final void z(int i) {
        int[] iArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        iArr[i2] = i;
        this.j--;
    }
}
