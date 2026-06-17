package defpackage;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pj {
    public static final fm4 d;
    public static final String e;
    public static final String f;
    public static final pj g;
    public static final pj h;
    public final boolean a;
    public final int b;
    public final fm4 c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public boolean a;
        public int b;
        public fm4 c;

        public a() {
            c(pj.e(Locale.getDefault()));
        }

        public static pj b(boolean z) {
            return z ? pj.h : pj.g;
        }

        public pj a() {
            return (this.b == 2 && this.c == pj.d) ? b(this.a) : new pj(this.a, this.b, this.c);
        }

        public final void c(boolean z) {
            this.a = z;
            this.c = pj.d;
            this.b = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static final byte[] f = new byte[1792];
        public final CharSequence a;
        public final boolean b;
        public final int c;
        public int d;
        public char e;

        static {
            for (int i = 0; i < 1792; i++) {
                f[i] = Character.getDirectionality(i);
            }
        }

        public b(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.b = z;
            this.c = charSequence.length();
        }

        public static byte c(char c) {
            return c < 1792 ? f[c] : Character.getDirectionality(c);
        }

        public byte a() {
            char cCharAt = this.a.charAt(this.d - 1);
            this.e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.a, this.d);
                this.d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.d--;
            byte bC = c(this.e);
            if (this.b) {
                char c = this.e;
                if (c == '>') {
                    return h();
                }
                if (c == ';') {
                    return f();
                }
            }
            return bC;
        }

        public byte b() {
            char cCharAt = this.a.charAt(this.d);
            this.e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.a, this.d);
                this.d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.d++;
            byte bC = c(this.e);
            if (this.b) {
                char c = this.e;
                if (c == '<') {
                    return i();
                }
                if (c == '&') {
                    return g();
                }
            }
            return bC;
        }

        public int d() {
            this.d = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.d < this.c && i == 0) {
                byte b = b();
                if (b != 0) {
                    if (b == 1 || b == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b != 9) {
                        switch (b) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        public int e() {
            this.d = this.c;
            int i = 0;
            while (true) {
                int i2 = i;
                while (this.d > 0) {
                    byte bA = a();
                    if (bA == 0) {
                        if (i == 0) {
                            return -1;
                        }
                        if (i2 == 0) {
                            break;
                        }
                    } else if (bA == 1 || bA == 2) {
                        if (i == 0) {
                            return 1;
                        }
                        if (i2 == 0) {
                            break;
                        }
                    } else if (bA != 9) {
                        switch (bA) {
                            case 14:
                            case 15:
                                if (i2 == i) {
                                    return -1;
                                }
                                i--;
                                break;
                            case 16:
                            case 17:
                                if (i2 == i) {
                                    return 1;
                                }
                                i--;
                                break;
                            case 18:
                                i++;
                                break;
                            default:
                                if (i2 != 0) {
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        }

        public final byte f() {
            char cCharAt;
            int i = this.d;
            do {
                int i2 = this.d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.d = i3;
                cCharAt = charSequence.charAt(i3);
                this.e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.d = i;
            this.e = ';';
            return (byte) 13;
        }

        public final byte g() {
            char cCharAt;
            do {
                int i = this.d;
                if (i >= this.c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.a;
                this.d = i + 1;
                cCharAt = charSequence.charAt(i);
                this.e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        public final byte h() {
            char cCharAt;
            int i = this.d;
            while (true) {
                int i2 = this.d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.d = i3;
                char cCharAt2 = charSequence.charAt(i3);
                this.e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i4 = this.d;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.a;
                            int i5 = i4 - 1;
                            this.d = i5;
                            cCharAt = charSequence2.charAt(i5);
                            this.e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.d = i;
            this.e = '>';
            return (byte) 13;
        }

        public final byte i() {
            char cCharAt;
            int i = this.d;
            while (true) {
                int i2 = this.d;
                if (i2 >= this.c) {
                    this.d = i;
                    this.e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.a;
                this.d = i2 + 1;
                char cCharAt2 = charSequence.charAt(i2);
                this.e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i3 = this.d;
                        if (i3 < this.c) {
                            CharSequence charSequence2 = this.a;
                            this.d = i3 + 1;
                            cCharAt = charSequence2.charAt(i3);
                            this.e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }
    }

    static {
        fm4 fm4Var = gm4.c;
        d = fm4Var;
        e = Character.toString((char) 8206);
        f = Character.toString((char) 8207);
        g = new pj(false, 2, fm4Var);
        h = new pj(true, 2, fm4Var);
    }

    public pj(boolean z, int i, fm4 fm4Var) {
        this.a = z;
        this.b = i;
        this.c = fm4Var;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static pj c() {
        return new a().a();
    }

    public static boolean e(Locale locale) {
        return zm4.a(locale) == 1;
    }

    public boolean d() {
        return (this.b & 2) != 0;
    }

    public final String f(CharSequence charSequence, fm4 fm4Var) {
        boolean zIsRtl = fm4Var.isRtl(charSequence, 0, charSequence.length());
        return (this.a || !(zIsRtl || b(charSequence) == 1)) ? this.a ? (!zIsRtl || b(charSequence) == -1) ? f : "" : "" : e;
    }

    public final String g(CharSequence charSequence, fm4 fm4Var) {
        boolean zIsRtl = fm4Var.isRtl(charSequence, 0, charSequence.length());
        return (this.a || !(zIsRtl || a(charSequence) == 1)) ? this.a ? (!zIsRtl || a(charSequence) == -1) ? f : "" : "" : e;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.c, true);
    }

    public CharSequence i(CharSequence charSequence, fm4 fm4Var, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = fm4Var.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zIsRtl ? gm4.b : gm4.a));
        }
        if (zIsRtl != this.a) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zIsRtl ? gm4.b : gm4.a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.c, true);
    }

    public String k(String str, fm4 fm4Var, boolean z) {
        if (str == null) {
            return null;
        }
        return i(str, fm4Var, z).toString();
    }
}
