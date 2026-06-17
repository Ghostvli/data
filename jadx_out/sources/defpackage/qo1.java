package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import java.io.IOException;
import java.io.Reader;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes.dex */
public final class qo1 {
    public static final char[] o = {'r', 'u', 'e'};
    public static final char[] p = {'a', 'l', 's', 'e'};
    public static final char[] q = {'u', 'l', 'l'};
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public final Reader i;
    public int k;
    public boolean n;
    public int a = 1;
    public final char[] j = new char[32768];
    public StringBuilder m = new StringBuilder();
    public final boolean l = false;

    public qo1(Reader reader) throws mo1 {
        this.i = reader;
        m();
    }

    public final int a() {
        if (this.g) {
            return -1;
        }
        char[] cArr = this.j;
        int i = this.h;
        char c = cArr[i];
        if (c == '\n') {
            this.a++;
            this.b = i + 1 + this.c;
            this.d = 0;
        }
        int i2 = i + 1;
        this.h = i2;
        if (i2 >= this.k) {
            this.g = r();
        }
        return c;
    }

    public int b(boolean z) throws mo1 {
        int iA;
        do {
            iA = a();
        } while (p(iA));
        int i = this.h;
        int i2 = this.c;
        this.e = ((i + i2) - this.b) - this.d;
        this.f = i2 + i;
        if (iA == -1) {
            return 0;
        }
        if (iA == 34 || iA == 39) {
            f(iA);
            return 8;
        }
        if (iA == 91) {
            return 11;
        }
        if (iA == 93) {
            return 4;
        }
        if (iA == 102) {
            try {
                c((char) iA, p);
                return 7;
            } catch (mo1 e) {
                if (!z) {
                    throw e;
                }
            }
        } else if (iA == 110) {
            try {
                c((char) iA, q);
                return 5;
            } catch (mo1 e2) {
                if (!z) {
                    throw e2;
                }
            }
        } else {
            if (iA != 116) {
                if (iA == 123) {
                    return 10;
                }
                if (iA == 125) {
                    return 3;
                }
                switch (iA) {
                    case Token.CALL /* 43 */:
                    case Token.STRING /* 46 */:
                        throw j(null, "Numbers may not start with '" + ((char) iA) + "'", true);
                    case Token.NAME /* 44 */:
                        return 1;
                    case Token.NUMBER /* 45 */:
                        break;
                    default:
                        switch (iA) {
                            case 48:
                            case Token.FALSE /* 49 */:
                            case 50:
                            case Token.SHEQ /* 51 */:
                            case Token.SHNE /* 52 */:
                            case Token.REGEXP /* 53 */:
                            case Token.BINDNAME /* 54 */:
                            case Token.THROW /* 55 */:
                            case Token.RETHROW /* 56 */:
                            case Token.IN /* 57 */:
                                break;
                            case Token.INSTANCEOF /* 58 */:
                                return 2;
                            default:
                                if (z) {
                                    this.h = i - 1;
                                    e();
                                    return 12;
                                }
                                if (n(iA)) {
                                    throw i((char) iA, null, 0);
                                }
                                throw j(null, "Unexpected character: " + ((char) iA), true);
                        }
                        break;
                }
                d((char) iA);
                return 9;
            }
            try {
                c((char) iA, o);
                return 6;
            } catch (mo1 e3) {
                if (!z) {
                    throw e3;
                }
            }
        }
        this.h = i - 1;
        e();
        return 12;
    }

    public void c(char c, char[] cArr) throws mo1 {
        if (k(cArr.length) < cArr.length) {
            throw i(c, cArr, 0);
        }
        for (int i = 0; i < cArr.length; i++) {
            char[] cArr2 = this.j;
            int i2 = this.h;
            this.h = i2 + 1;
            if (cArr2[i2] != cArr[i]) {
                throw i(c, cArr, i);
            }
        }
        l();
        int iQ = q();
        if (iQ != 9 && iQ != 10 && iQ != 13 && iQ != 32 && iQ != 44 && iQ != 58 && iQ != 91 && iQ != 93 && iQ != 123 && iQ != 125) {
            throw i(c, cArr, cArr.length);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(char r17) throws defpackage.mo1 {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo1.d(char):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0153, code lost:
    
        throw j(null, r1.toString(), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0154, code lost:
    
        r1 = r17.m;
        r3 = (char) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x016b, code lost:
    
        throw j(null, "Invalid escape: \\" + r1, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x016c, code lost:
    
        r17.m.append('\t');
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0172, code lost:
    
        r17.m.append('\r');
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0178, code lost:
    
        r1 = r17.m;
        r3 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x017e, code lost:
    
        r1 = r17.m;
        r3 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0184, code lost:
    
        r1 = r17.m;
        r3 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x018a, code lost:
    
        r17.m.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x018f, code lost:
    
        r1 = com.hierynomus.protocol.commons.buffer.Buffer.DEFAULT_SIZE;
        r6 = true;
        r9 = ':';
        r11 = ',';
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01a8, code lost:
    
        throw j(null, "Invalid character in semi-string: " + r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a9, code lost:
    
        l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01ac, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ad, code lost:
    
        r1 = r17.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01af, code lost:
    
        if (r3 > r1) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01b1, code lost:
    
        r1 = com.hierynomus.protocol.commons.buffer.Buffer.DEFAULT_SIZE;
        r6 = true;
        r9 = ':';
        r11 = ',';
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01ba, code lost:
    
        r17.h = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01c0, code lost:
    
        throw j(null, "EOF encountered in the middle of a string escape", false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01c6, code lost:
    
        throw j(null, "String was not terminated before end of input", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01c7, code lost:
    
        r17.m.append(r17.j, (r17.h - r7) - 1, r7);
        l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01d5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        r17.m.append(r17.j, (r17.h - r7) - 1, r7);
        r17.h--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r3 = k(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        if (r3 == 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
    
        r7 = r17.h + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
    
        r3 = r17.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
    
        if (r3 >= r7) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
    
        r3 = s();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        if (r17.l == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
    
        if ((r3 & 128) == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        g(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r3 == '\t') goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0094, code lost:
    
        if (r3 == '\n') goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0098, code lost:
    
        if (r3 == '\r') goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
    
        if (r3 == ' ') goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        if (r3 == r11) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
    
        if (r3 == r9) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
    
        if (r3 == '{') goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
    
        if (r3 == '}') goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        switch(r3) {
            case 91: goto L148;
            case 92: goto L55;
            case 93: goto L148;
            default: goto L53;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a9, code lost:
    
        r1 = r17.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
    
        r1.append(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b7, code lost:
    
        if ((r7 - r17.h) >= 5) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b9, code lost:
    
        r1 = k(5);
        r7 = r17.h;
        r16 = r7 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c5, code lost:
    
        if (r17.j[r7] != 'u') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c7, code lost:
    
        if (r1 < 5) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ca, code lost:
    
        r17.h = r17.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d2, code lost:
    
        throw j(null, "EOF encountered in the middle of a string escape", false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d3, code lost:
    
        r7 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d5, code lost:
    
        r1 = r17.j;
        r8 = r17.h;
        r17.h = r8 + 1;
        r1 = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e1, code lost:
    
        if (r1 == '\"') goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
    
        if (r1 == '/') goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e7, code lost:
    
        if (r1 == '\\') goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00eb, code lost:
    
        if (r1 == 'b') goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ef, code lost:
    
        if (r1 == 'f') goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f3, code lost:
    
        if (r1 == 'n') goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f7, code lost:
    
        if (r1 == 'r') goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00fb, code lost:
    
        if (r1 == 't') goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00fd, code lost:
    
        if (r1 != 'u') goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ff, code lost:
    
        r1 = 0;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0102, code lost:
    
        if (r1 >= 4) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0104, code lost:
    
        r3 = r3 << 4;
        r6 = r17.j;
        r9 = r17.h;
        r17.h = r9 + 1;
        r6 = r6[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0112, code lost:
    
        if (r6 < '0') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0116, code lost:
    
        if (r6 > '9') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0118, code lost:
    
        r6 = r6 - '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x011a, code lost:
    
        r3 = r3 | r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x011e, code lost:
    
        if (r6 < 'A') goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0122, code lost:
    
        if (r6 > 'F') goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0124, code lost:
    
        r6 = r6 - '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0129, code lost:
    
        if (r6 < 'a') goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x012b, code lost:
    
        if (r6 > 'f') goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x012d, code lost:
    
        r6 = r6 - 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0130, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0133, code lost:
    
        r1 = new java.lang.StringBuilder("Expected unicode hex escape character: ");
        r1.append(r6);
        r1.append(" (");
        r1.append((int) r6);
        r1.append(")");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e() throws defpackage.mo1 {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo1.e():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0100, code lost:
    
        r1 = new java.lang.StringBuilder("Expected unicode hex escape character: ");
        r1.append(r11);
        r1.append(" (");
        r1.append((int) r11);
        r1.append(")");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0120, code lost:
    
        throw j(null, r1.toString(), false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(int r17) throws defpackage.mo1 {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo1.f(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x01a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(char r10) throws defpackage.mo1 {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo1.g(char):void");
    }

    public final void h() throws mo1 {
        int iK;
        do {
            iK = k(Buffer.DEFAULT_SIZE);
            for (int i = 0; i < iK; i++) {
                char c = this.j[this.h];
                if (!p(c)) {
                    l();
                    return;
                }
                if (c == '\n') {
                    this.a++;
                    this.b = this.h + 1 + this.c;
                    this.d = 0;
                }
                this.h++;
            }
        } while (iK > 0);
        this.g = true;
    }

    public mo1 i(char c, char[] cArr, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        String str = "";
        sb.append(cArr == null ? "" : new String(cArr, 0, i));
        StringBuilder sb2 = new StringBuilder(sb.toString());
        while (n(q()) && sb2.length() < 15) {
            sb2.append((char) a());
        }
        StringBuilder sb3 = new StringBuilder("Unexpected token '");
        sb3.append((Object) sb2);
        sb3.append("'");
        if (cArr != null) {
            str = ". Did you mean '" + c + new String(cArr) + "'?";
        }
        sb3.append(str);
        return j(null, sb3.toString(), true);
    }

    public mo1 j(Exception exc, String str, boolean z) {
        if (z) {
            return new mo1(exc, str + " on line " + this.a + ", char " + this.e, this.a, this.e, this.f);
        }
        int iMax = Math.max(1, ((this.h + this.c) - this.b) - this.d);
        return new mo1(exc, str + " on line " + this.a + ", char " + iMax, this.a, iMax, this.h + this.c);
    }

    public int k(int i) throws mo1 {
        int i2;
        int i3 = this.k;
        int i4 = i3 - i;
        int i5 = this.h;
        if (i4 >= i5) {
            return i;
        }
        if (i5 > 0) {
            this.c += i5;
            int i6 = i3 - i5;
            this.k = i6;
            char[] cArr = this.j;
            System.arraycopy(cArr, i5, cArr, 0, i6);
            this.h = 0;
        }
        do {
            try {
                char[] cArr2 = this.j;
                int length = cArr2.length;
                int i7 = this.k;
                if (length <= i7) {
                    throw new IOException("Unexpected internal error");
                }
                int i8 = this.i.read(cArr2, i7, cArr2.length - i7);
                int i9 = this.k;
                if (i8 <= 0) {
                    return i9 - this.h;
                }
                i2 = i9 + i8;
                this.k = i2;
            } catch (IOException e) {
                throw j(e, "IOException", true);
            }
        } while (i2 <= i);
        return i2 - this.h;
    }

    public void l() {
        if (this.h >= this.k) {
            this.g = r();
        }
    }

    public final void m() throws mo1 {
        this.g = r();
        h();
    }

    public boolean n(int i) {
        if (i < 65 || i > 90) {
            return i >= 97 && i <= 122;
        }
        return true;
    }

    public final boolean o(int i) {
        return (i >= 48 && i <= 57) || i == 101 || i == 69 || i == 46 || i == 43 || i == 45;
    }

    public boolean p(int i) {
        return i == 32 || i == 10 || i == 13 || i == 9;
    }

    public final int q() {
        if (this.g) {
            return -1;
        }
        return this.j[this.h];
    }

    public final boolean r() throws mo1 {
        try {
            Reader reader = this.i;
            char[] cArr = this.j;
            int i = reader.read(cArr, 0, cArr.length);
            if (i <= 0) {
                return true;
            }
            this.c += this.k;
            this.h = 0;
            this.k = i;
            return false;
        } catch (IOException e) {
            throw j(e, "IOException", true);
        }
    }

    public final char s() throws mo1 {
        char[] cArr = this.j;
        int i = this.h;
        this.h = i + 1;
        char c = cArr[i];
        if (c < ' ') {
            t(c);
        }
        return c;
    }

    public final void t(char c) throws mo1 {
        if (c == '\n') {
            this.a++;
            this.b = this.h + 1 + this.c;
            this.d = 0;
        }
        throw j(null, "Strings may not contain control characters: 0x" + Integer.toString(c, 16), false);
    }
}
