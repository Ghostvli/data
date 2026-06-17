package defpackage;

import java.io.StringReader;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class lo1 {
    public Object a;
    public int b;
    public qo1 c;
    public boolean d;

    public static final class a {
        public final Class a;
        public boolean b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Class cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Object a(String str) {
            return new lo1(new qo1(new StringReader(str)), this.b).e(this.a);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lo1(qo1 qo1Var, boolean z) {
        this.c = qo1Var;
        this.d = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a b() {
        return new a(eo1.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a d() {
        return new a(ko1.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int a(boolean z, boolean z2) throws mo1 {
        Object string;
        int i;
        if (z2) {
            this.c.h--;
        }
        int iB = this.c.b(z);
        this.b = iB;
        switch (iB) {
            case 5:
                this.a = null;
                return this.b;
            case 6:
                string = Boolean.TRUE;
                this.a = string;
                return this.b;
            case 7:
                string = Boolean.FALSE;
                this.a = string;
                return this.b;
            case 8:
            case 12:
                string = this.c.m.toString();
                this.a = string;
                return this.b;
            case 9:
                string = this.d ? new jo1(this.c.m.toString(), this.c.n) : f();
                this.a = string;
                return this.b;
            case 10:
                ko1 ko1Var = new ko1();
                if (a(true, false) != 3) {
                    do {
                        int i2 = this.b;
                        if (i2 == 5 || i2 == 6 || i2 == 7) {
                            this.a = this.a.toString();
                        } else if (i2 != 8 && i2 != 12) {
                            throw this.c.j(null, "Expected STRING, got " + this.b, true);
                        }
                        String str = (String) this.a;
                        if (this.b == 12) {
                            if (a(false, true) != 2) {
                                throw this.c.j(null, "Expected COLON, got " + this.b, true);
                            }
                        } else if (a(false, false) != 2) {
                            throw this.c.j(null, "Expected COLON, got " + this.b, true);
                        }
                        a(false, false);
                        ko1Var.put(str, c());
                        if (a(false, false) != 3) {
                            if (this.b != 1) {
                                throw this.c.j(null, "Expected a comma or end of the object instead of " + this.b, true);
                            }
                        }
                    } while (a(true, false) != 3);
                    throw this.c.j(null, "Trailing object found in array", true);
                }
                this.a = ko1Var;
                i = 10;
                this.b = i;
                return i;
            case 11:
                eo1 eo1Var = new eo1();
                if (a(false, false) != 4) {
                    do {
                        eo1Var.add(c());
                        if (this.b == 12) {
                            throw this.c.j(null, "Semi-string is not allowed in array", true);
                        }
                        if (a(false, false) != 4) {
                            if (this.b != 1) {
                                throw this.c.j(null, "Expected a comma or end of the array instead of " + this.b, true);
                            }
                        }
                    } while (a(false, false) != 4);
                    throw this.c.j(null, "Trailing comma found in array", true);
                }
                this.a = eo1Var;
                i = 11;
                this.b = i;
                return i;
            default:
                return this.b;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object c() throws mo1 {
        if (this.b >= 5) {
            return this.a;
        }
        throw this.c.j(null, "Expected JSON value, got " + this.b, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object e(Class cls) throws mo1 {
        a(false, false);
        Object objC = c();
        if (a(false, false) != 0) {
            throw this.c.j(null, "Expected end of input, got " + this.b, true);
        }
        if (cls == Object.class || (objC != null && cls.isAssignableFrom(objC.getClass()))) {
            return cls.cast(objC);
        }
        throw this.c.j(null, "JSON did not contain the correct type, expected " + cls.getSimpleName() + ".", true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Number f() throws mo1 {
        String string = this.c.m.toString();
        try {
            if (this.c.n) {
                return Double.valueOf(Double.parseDouble(string));
            }
            if (string.length() == 1) {
                return Integer.valueOf(string.charAt(0) - '0');
            }
            if (string.length() == 2 && string.charAt(0) == '-') {
                return Integer.valueOf('0' - string.charAt(1));
            }
            int i = string.charAt(0) == '-' ? 1 : 0;
            int length = i != 0 ? string.length() - 1 : string.length();
            if (length >= 10 && (length != 10 || string.charAt(i) >= '2')) {
                if (length >= 19 && (length != 19 || string.charAt(i) >= '9')) {
                    return new BigInteger(string);
                }
                return Long.valueOf(Long.parseLong(string));
            }
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException e) {
            throw this.c.j(e, "Malformed number: ".concat(string), true);
        }
    }
}
