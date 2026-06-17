package defpackage;

import org.mozilla.javascript.Kit;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Token;

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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iq0(String str, int i, boolean z) {
        this.h = str;
        this.g = i;
        this.m = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(int i) {
        return i <= 90 ? 65 <= i : 97 <= i && i <= 122;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean j(int i) {
        return 48 <= i && i <= 57;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean l(int i) {
        return 48 == i || i == 49;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean m(int i) {
        if (48 <= i && i <= 57) {
            return true;
        }
        if (97 > i || i > 102) {
            return 65 <= i && i <= 70;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean n(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean o(int i) {
        return i <= 127 ? i == 32 || i == 9 || i == 12 || i == 11 : i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean p(int i) {
        return 48 <= i && i <= 55;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int b() {
        return d(true, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int c(boolean z) {
        return d(z, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int e() {
        return d(true, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int f(boolean z) {
        return d(z, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String g() {
        this.l = this.j;
        return new String(this.b, 0, this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Duplicate block (B:182:0x0221) to fix multi-entry loop: BACK_EDGE: B:182:0x0221 -> B:183:0x0222 */
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
    */
    public final ip4 h() throws s83 {
        int iB;
        int i;
        boolean z;
        boolean zIsJavaIdentifierStart;
        boolean z2;
        int i2;
        boolean z3;
        int iB2;
        ip4 ip4VarW;
        do {
            iB = b();
            i = -1;
            if (iB == -1) {
                int i3 = this.j;
                this.k = i3 - 1;
                this.l = i3;
                return ip4.EOF;
            }
            z = false;
            if (iB == 10) {
                this.a = false;
                int i4 = this.j;
                this.k = i4 - 1;
                this.l = i4;
                return ip4.EOL;
            }
        } while (o(iB));
        if (iB != 45) {
            this.a = true;
        }
        int i5 = this.j;
        this.k = i5 - 1;
        this.l = i5;
        if (iB == 92) {
            iB = b();
            if (iB == 117) {
                this.c = 0;
                zIsJavaIdentifierStart = true;
                z2 = true;
            } else {
                y(iB);
                zIsJavaIdentifierStart = false;
                z2 = false;
                iB = 92;
            }
        } else {
            zIsJavaIdentifierStart = Character.isJavaIdentifierStart((char) iB);
            if (zIsJavaIdentifierStart) {
                this.c = 0;
                a(iB);
            }
            z2 = false;
        }
        if (zIsJavaIdentifierStart) {
            boolean z4 = z2;
            while (true) {
                if (z2) {
                    int iXDigitToInt = 0;
                    for (int i6 = 0; i6 != 4; i6++) {
                        iXDigitToInt = Kit.xDigitToInt(b(), iXDigitToInt);
                        if (iXDigitToInt < 0) {
                            break;
                        }
                    }
                    if (iXDigitToInt < 0) {
                        ny4.a("invalid unicode escape");
                        return null;
                    }
                    a(iXDigitToInt);
                    z2 = false;
                } else {
                    iB2 = b();
                    if (iB2 == 92) {
                        int iB3 = b();
                        if (iB3 != 117) {
                            throw new s83(String.format("illegal character: '%c'", Integer.valueOf(iB3)));
                        }
                        z4 = true;
                        z2 = true;
                    } else {
                        if (iB2 == -1 || iB2 == 65279 || !Character.isJavaIdentifierPart((char) iB2)) {
                            break;
                        }
                        a(iB2);
                    }
                }
            }
            y(iB2);
            return (z4 || (ip4VarW = w(g())) == ip4.EOF) ? ip4.NAME : ip4VarW;
        }
        int i7 = 4;
        if (j(iB) || (iB == 46 && j(s()))) {
            this.c = 0;
            if (iB != 48) {
                i2 = 10;
            } else {
                iB = b();
                if (iB == 120 || iB == 88) {
                    iB = b();
                    i2 = 16;
                } else {
                    if (iB == 111 || iB == 79) {
                        iB = b();
                    } else if (iB == 98 || iB == 66) {
                        iB = b();
                        i2 = 2;
                    } else if (j(iB)) {
                        z = true;
                    } else {
                        a(48);
                        i2 = 10;
                    }
                    i2 = 8;
                }
            }
            int i8 = this.c;
            if (i2 == 10 || i2 == 16 || ((i2 == 8 && !z) || i2 == 2)) {
                iB = t(i2, iB);
                if (iB == -2) {
                    ny4.a("number format error");
                    return null;
                }
            } else {
                while (true) {
                    if (!j(iB)) {
                        break;
                    }
                    if (iB >= 56) {
                        iB = t(10, iB);
                        if (iB == -2) {
                            ny4.a("number format error");
                            return null;
                        }
                        i2 = 10;
                    } else {
                        a(iB);
                        iB = b();
                    }
                }
            }
            if (this.c == i8 && i2 != 10) {
                ny4.a("number format error");
                return null;
            }
            if (iB == 110) {
                iB = b();
            } else if (i2 == 10 && (iB == 46 || iB == 101 || iB == 69)) {
                if (iB == 46) {
                    a(iB);
                    iB = t(i2, b());
                    if (iB == -2) {
                        ny4.a("number format error");
                        return null;
                    }
                }
                if (iB == 101 || iB == 69) {
                    a(iB);
                    int iB4 = b();
                    if (iB4 == 43 || iB4 == 45) {
                        a(iB4);
                        iB4 = b();
                    }
                    if (!j(iB4)) {
                        ny4.a("missing exponent");
                        return null;
                    }
                    iB = t(i2, iB4);
                    if (iB == -2) {
                        ny4.a("number format error");
                        return null;
                    }
                }
            }
            y(iB);
            this.l = this.j;
            return ip4.NUMBER;
        }
        if (iB == 34 || iB == 39 || iB == 96) {
            this.c = 0;
            int iF = f(false);
            while (iF != iB) {
                int iXDigitToInt2 = 13;
                if (iF != i) {
                    if (iF == 10) {
                        int i9 = this.f;
                        if (i9 != 10 && i9 != 13) {
                            if (i9 == 8232 || i9 == 8233) {
                                iF = i9;
                            }
                        }
                        z3 = true;
                    }
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    ny4.a("unterminated string literal");
                    return null;
                }
                if (iF == 92) {
                    int iB5 = b();
                    if (iB5 == 10) {
                        iF = b();
                    } else if (iB5 == 98) {
                        iXDigitToInt2 = 8;
                    } else if (iB5 == 102) {
                        iXDigitToInt2 = 12;
                    } else if (iB5 == 110) {
                        iXDigitToInt2 = 10;
                    } else if (iB5 != 114) {
                        if (iB5 != 120) {
                            switch (iB5) {
                                case Token.COLON /* 116 */:
                                    iXDigitToInt2 = 9;
                                    break;
                                case Token.OR /* 117 */:
                                    int i10 = this.c;
                                    a(Token.OR);
                                    iXDigitToInt2 = 0;
                                    int i11 = 0;
                                    for (int i12 = i7; i11 != i12; i12 = 4) {
                                        int iB6 = b();
                                        iXDigitToInt2 = Kit.xDigitToInt(iB6, iXDigitToInt2);
                                        if (iXDigitToInt2 < 0) {
                                            iF = iB6;
                                        } else {
                                            a(iB6);
                                            i11++;
                                        }
                                        break;
                                    }
                                    this.c = i10;
                                    break;
                                case Token.AND /* 118 */:
                                    iXDigitToInt2 = 11;
                                    break;
                                default:
                                    if (48 > iB5 || iB5 >= 56) {
                                        iXDigitToInt2 = iB5;
                                    } else {
                                        int i13 = iB5 - 48;
                                        int iB7 = b();
                                        if (48 <= iB7 && iB7 < 56) {
                                            i13 = ((i13 * 8) + iB7) - 48;
                                            iB7 = b();
                                            if (48 <= iB7 && iB7 < 56 && i13 <= 31) {
                                                i13 = ((i13 * 8) + iB7) - 48;
                                                iB7 = b();
                                            }
                                        }
                                        iXDigitToInt2 = i13;
                                        y(iB7);
                                    }
                                    break;
                            }
                        } else {
                            iF = b();
                            int iXDigitToInt3 = Kit.xDigitToInt(iF, 0);
                            if (iXDigitToInt3 < 0) {
                                a(120);
                            } else {
                                int iB8 = b();
                                int iXDigitToInt4 = Kit.xDigitToInt(iB8, iXDigitToInt3);
                                if (iXDigitToInt4 < 0) {
                                    a(120);
                                    a(iF);
                                    iF = iB8;
                                } else {
                                    iXDigitToInt2 = iXDigitToInt4;
                                }
                            }
                        }
                    }
                    i = -1;
                    i7 = 4;
                } else {
                    iXDigitToInt2 = iF;
                }
                a(iXDigitToInt2);
                iF = c(false);
                i = -1;
                i7 = 4;
            }
            this.l = this.j;
            return iB == 96 ? ip4.TEMPLATE_LITERAL : ip4.STRING;
        }
        if (iB == 33) {
            return q(61) ? q(61) ? ip4.SHNE : ip4.NE : ip4.NOT;
        }
        if (iB == 91) {
            return ip4.LB;
        }
        if (iB == 37) {
            return q(61) ? ip4.ASSIGN_MOD : ip4.MOD;
        }
        if (iB == 38) {
            return q(38) ? ip4.AND : q(61) ? ip4.ASSIGN_BITAND : ip4.BITAND;
        }
        if (iB == 93) {
            return ip4.RB;
        }
        if (iB == 94) {
            return q(61) ? ip4.ASSIGN_BITXOR : ip4.BITXOR;
        }
        switch (iB) {
            case 40:
                return ip4.LP;
            case Token.SETELEM /* 41 */:
                return ip4.RP;
            case Token.SETELEM_SUPER /* 42 */:
                return q(42) ? q(61) ? ip4.ASSIGN_EXP : ip4.EXP : q(61) ? ip4.ASSIGN_MUL : ip4.MUL;
            case Token.CALL /* 43 */:
                return q(61) ? ip4.ASSIGN_ADD : q(43) ? ip4.INC : ip4.ADD;
            case Token.NAME /* 44 */:
                return ip4.COMMA;
            case Token.NUMBER /* 45 */:
                ip4 ip4Var = ip4.SUB;
                if (q(61)) {
                    ip4Var = ip4.ASSIGN_SUB;
                } else if (q(45)) {
                    if (!this.a && q(62)) {
                        v();
                        return ip4.COMMENT;
                    }
                    ip4Var = ip4.DEC;
                }
                this.a = true;
                return ip4Var;
            case Token.STRING /* 46 */:
                return ip4.DOT;
            case Token.NULL /* 47 */:
                if (q(47)) {
                    this.k = this.j - 2;
                    v();
                    return ip4.COMMENT;
                }
                if (!q(42)) {
                    return q(61) ? ip4.ASSIGN_DIV : ip4.DIV;
                }
                this.k = this.j - 2;
                break;
                break;
            default:
                switch (iB) {
                    case Token.INSTANCEOF /* 58 */:
                        return ip4.COLON;
                    case Token.LOCAL_LOAD /* 59 */:
                        return ip4.SEMI;
                    case 60:
                        if (q(33)) {
                            if (q(45)) {
                                if (q(45)) {
                                    this.k = this.j - 4;
                                    v();
                                    return ip4.COMMENT;
                                }
                                z(45);
                            }
                            z(33);
                        }
                        return q(60) ? q(61) ? ip4.ASSIGN_LSH : ip4.LSH : q(61) ? ip4.LE : ip4.LT;
                    case Token.SETVAR /* 61 */:
                        return q(61) ? q(61) ? ip4.SHEQ : ip4.EQ : q(62) ? ip4.ARROW : ip4.ASSIGN;
                    case Token.CATCH_SCOPE /* 62 */:
                        return q(62) ? q(62) ? q(61) ? ip4.ASSIGN_URSH : ip4.URSH : q(61) ? ip4.ASSIGN_RSH : ip4.RSH : q(61) ? ip4.GE : ip4.GT;
                    case Token.ENUM_INIT_KEYS /* 63 */:
                        return ip4.HOOK;
                    default:
                        switch (iB) {
                            case Token.EXPORT /* 123 */:
                                return ip4.LC;
                            case Token.IMPORT /* 124 */:
                                return q(Token.IMPORT) ? ip4.OR : q(61) ? ip4.ASSIGN_BITOR : ip4.BITOR;
                            case Token.IF /* 125 */:
                                return ip4.RC;
                            case 126:
                                return ip4.BITNOT;
                            default:
                                throw new s83(String.format("illegal character: '%c'", Integer.valueOf(iB)));
                        }
                }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean q(int i) {
        int iE = e();
        if (iE == i) {
            this.l = this.j;
            return true;
        }
        z(iE);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ip4 r() throws s83 {
        ip4 ip4VarH = h();
        while (true) {
            if (ip4VarH != ip4.EOL && ip4VarH != ip4.COMMENT) {
                return ip4VarH;
            }
            ip4VarH = h();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int s() {
        int iB = b();
        y(iB);
        return iB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
    
        defpackage.ny4.a("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0081, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(ip4 ip4Var) throws s83 {
        int iE;
        int i = this.k;
        this.c = 0;
        if (ip4Var == ip4.ASSIGN_DIV) {
            a(61);
        } else {
            if (ip4Var != ip4.DIV) {
                Kit.codeBug();
            }
            if (s() == 42) {
                this.l = this.j - 1;
                ny4.a("msg.unterminated.re.lit");
                return;
            }
        }
        boolean z = false;
        while (true) {
            int iB = b();
            if (iB == 47 && !z) {
                while (true) {
                    iE = e();
                    if ("gimysu".indexOf(iE) == -1) {
                        break;
                    } else {
                        a(iE);
                    }
                }
                if (i(iE)) {
                    ny4.a("msg.invalid.re.flag");
                    return;
                } else {
                    z(iE);
                    this.l = i + this.c + 2;
                    return;
                }
            }
            if (iB == 10 || iB == -1) {
                break;
            }
            if (iB == 92) {
                a(iB);
                iB = b();
                if (iB == 10 || iB == -1) {
                    break;
                }
            } else if (iB == 91) {
                z = true;
            } else if (iB == 93) {
                z = false;
            }
            a(iB);
        }
        ny4.a("msg.unterminated.re.lit");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ip4 w(String str) {
        return x(str, this.m);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(int i) {
        int[] iArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        iArr[i2] = i;
        this.j--;
    }
}
