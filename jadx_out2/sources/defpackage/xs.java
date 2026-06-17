package defpackage;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class xs implements AutoCloseable {
    public static final fa4 s = new fa4(new Supplier() { // from class: ms
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.function.Supplier
        public final Object get() {
            return xs.y();
        }
    });
    public static final fa4 t = new fa4(new Supplier() { // from class: os
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.function.Supplier
        public final Object get() {
            return xs.l();
        }
    });
    public String[] f;
    public Reader g;
    public char[] h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public ArrayList o;
    public int p;
    public String q;
    public int r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        boolean a(char c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xs(Reader reader) {
        this.k = 0;
        this.m = -1;
        this.o = null;
        this.p = 1;
        zy4.j(reader);
        this.g = reader;
        this.h = (char[]) t.b();
        this.f = (String[]) s.b();
        F();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean C0(char[] cArr, int i, int i2, String str) {
        if (i2 != str.length()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 == 0) {
                return true;
            }
            int i5 = i + 1;
            int i6 = i3 + 1;
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i = i5;
            i2 = i4;
            i3 = i6;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String J(char[] cArr, String[] strArr, int i, int i2) {
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        if (i2 < 1) {
            return "";
        }
        int i3 = i2 + i;
        int i4 = 0;
        for (int i5 = i; i5 < i3; i5++) {
            i4 = (i4 * 31) + cArr[i5];
        }
        int i6 = i4 & 511;
        String str = strArr[i6];
        if (str != null && C0(cArr, i, i2, str)) {
            return str;
        }
        String str2 = new String(cArr, i, i2);
        strArr[i6] = str2;
        return str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean a(char c) {
        return (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ' || c == '/' || c == '>') ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean c(boolean z, char c) {
        if (c == 0 || c == '&') {
            return false;
        }
        return z ? c != '\'' : c != '\"';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean h(char c) {
        return c >= '0' && c <= '9';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean i(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c == c2) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: NEW_ARRAY (2048 int) (LINE:3) type: char[] */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ char[] l() {
        return new char[2048];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean t(char c) {
        return (c == '&' || c == '<' || c == 0) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean u(char c) {
        return (c == '<' || c == 0) ? false : true;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:int:0x0000: INVOKE (r0v0 char[]), (r1v0 char) STATIC call: java.util.Arrays.binarySearch(char[], char):int A[MD:(char[], char):int (c), WRAPPED] (LINE:1)) < (0 int)) ? true : false */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean v(char[] cArr, char c) {
        return Arrays.binarySearch(cArr, c) < 0;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: NEW_ARRAY (512 int) (LINE:3) type: java.lang.String[] */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String[] y() {
        return new String[512];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int A0() {
        return this.l + this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B() {
        this.i++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String B0() {
        return m0() + ":" + K();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean D0() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E0() {
        int i = this.m;
        if (i == -1) {
            throw new UncheckedIOException(new IOException("Mark invalid"));
        }
        this.i = i;
        I0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F() {
        if (this.n || this.i < this.k || this.m != -1) {
            return;
        }
        h0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F0() {
        if (k0()) {
            if (this.o.size() > 0) {
                int iL0 = l0(this.l);
                if (iL0 == -1) {
                    iL0 = 0;
                }
                Integer num = (Integer) this.o.get(iL0);
                num.intValue();
                this.p += iL0;
                this.o.clear();
                this.o.add(num);
            }
            for (int i = this.i; i < this.j; i++) {
                if (this.h[i] == '\n') {
                    this.o.add(Integer.valueOf(this.l + 1 + i));
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G0(boolean z) {
        if (z && this.o == null) {
            this.o = new ArrayList(25);
            F0();
        } else {
            if (z) {
                return;
            }
            this.o = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H0() {
        int i = this.i;
        if (i < 1) {
            throw new UncheckedIOException(new IOException("WTF: No buffer left to unconsume."));
        }
        this.i = i - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I0() {
        this.m = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int K() {
        return L(A0());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int L(int i) {
        if (!k0()) {
            return i + 1;
        }
        int iL0 = l0(i);
        return iL0 == -1 ? i + 1 : (i - ((Integer) this.o.get(iL0)).intValue()) + 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char M() {
        F();
        char c = j0() ? (char) 65535 : this.h[this.i];
        this.i++;
        return c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String N(final boolean z) {
        return T(new a() { // from class: us
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return xs.c(z, c);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String O() {
        return T(new a() { // from class: ts
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return xs.t(c);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String P() {
        return T(new a() { // from class: vs
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return xs.h(c);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String Q() {
        return T(new ws());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String R() {
        return T(new a() { // from class: ns
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return Character.isLetter(c);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String S() {
        F();
        int i = this.i;
        while (true) {
            int i2 = this.i;
            if (i2 >= this.j || !fg4.i(this.h[i2])) {
                break;
            }
            this.i++;
        }
        while (!j0() && fg4.k(this.h[this.i])) {
            this.i++;
        }
        return J(this.h, this.f, i, this.i - i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String T(a aVar) {
        return U(aVar, -1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String U(a aVar, int i) {
        F();
        int i2 = this.i;
        int i3 = this.j;
        char[] cArr = this.h;
        int i4 = i2;
        while (i4 < i3 && ((i == -1 || i4 - i2 < i) && aVar.a(cArr[i4]))) {
            i4++;
        }
        this.i = i4;
        return i4 > i2 ? J(this.h, this.f, i2, i4 - i2) : "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String V() {
        return T(new a() { // from class: qs
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return xs.u(c);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String W() {
        return T(new a() { // from class: ss
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return xs.a(c);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String Z(char c) {
        int iY0 = y0(c);
        if (iY0 == -1) {
            return e0();
        }
        String strJ = J(this.h, this.f, this.i, iY0);
        this.i += iY0;
        return strJ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String b0(String str) {
        int iZ0 = z0(str);
        if (iZ0 != -1) {
            String strJ = J(this.h, this.f, this.i, iZ0);
            this.i += iZ0;
            return strJ;
        }
        if (this.j - this.i < str.length()) {
            return e0();
        }
        int length = (this.j - str.length()) + 1;
        char[] cArr = this.h;
        String[] strArr = this.f;
        int i = this.i;
        String strJ2 = J(cArr, strArr, i, length - i);
        this.i = length;
        return strJ2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String c0(final char... cArr) {
        return T(new a() { // from class: ps
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return xs.i(cArr, c);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.AutoCloseable
    public void close() {
        Reader reader = this.g;
        if (reader == null) {
            return;
        }
        try {
            reader.close();
            this.g = null;
            Arrays.fill(this.h, (char) 0);
            t.d(this.h);
            this.h = null;
            s.d(this.f);
        } catch (IOException unused) {
            this.g = null;
            Arrays.fill(this.h, (char) 0);
            t.d(this.h);
            this.h = null;
            s.d(this.f);
        } catch (Throwable th) {
            this.g = null;
            Arrays.fill(this.h, (char) 0);
            t.d(this.h);
            this.h = null;
            s.d(this.f);
            this.f = null;
            throw th;
        }
        this.f = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String d0(final char... cArr) {
        return T(new a() { // from class: rs
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xs.a
            public final boolean a(char c) {
                return xs.v(cArr, c);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String e0() {
        F();
        char[] cArr = this.h;
        String[] strArr = this.f;
        int i = this.i;
        String strJ = J(cArr, strArr, i, this.j - i);
        this.i = this.j;
        return strJ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f0(String str) {
        if (str.equals(this.q)) {
            int i = this.r;
            if (i == -1) {
                return false;
            }
            if (i >= this.i) {
                return true;
            }
        }
        this.q = str;
        Locale locale = Locale.ENGLISH;
        int iZ0 = z0(str.toLowerCase(locale));
        if (iZ0 > -1) {
            this.r = this.i + iZ0;
            return true;
        }
        int iZ02 = z0(str.toUpperCase(locale));
        boolean z = iZ02 > -1;
        this.r = z ? this.i + iZ02 : -1;
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char g0() {
        F();
        if (j0()) {
            return (char) 65535;
        }
        return this.h[this.i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        r4.n = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h0() {
        int i = this.l;
        int i2 = this.i;
        this.l = i + i2;
        int i3 = this.j - i2;
        this.j = i3;
        if (i3 > 0) {
            char[] cArr = this.h;
            System.arraycopy(cArr, i2, cArr, 0, i3);
        }
        this.i = 0;
        while (true) {
            int i4 = this.j;
            if (i4 >= 2048) {
                break;
            }
            try {
                Reader reader = this.g;
                char[] cArr2 = this.h;
                int i5 = reader.read(cArr2, i4, cArr2.length - i4);
                if (i5 == -1) {
                    break;
                } else if (i5 == 0) {
                    break;
                } else {
                    this.j += i5;
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        this.k = Math.min(this.j, 1024);
        F0();
        this.q = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean i0() {
        F();
        return this.i >= this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean j0() {
        return this.i >= this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean k0() {
        return this.o != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int l0(int i) {
        if (!k0()) {
            return 0;
        }
        int iBinarySearch = Collections.binarySearch(this.o, Integer.valueOf(i));
        return iBinarySearch < -1 ? Math.abs(iBinarySearch) - 2 : iBinarySearch;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m0() {
        return n0(A0());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int n0(int i) {
        if (!k0()) {
            return 1;
        }
        int iL0 = l0(i);
        int i2 = this.p;
        return iL0 == -1 ? i2 : iL0 + i2 + 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o0() {
        if (this.j - this.i < 1024) {
            this.k = 0;
        }
        F();
        this.m = this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p0(String str) {
        F();
        if (!s0(str)) {
            return false;
        }
        this.i += str.length();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q0(String str) {
        if (!x0(str)) {
            return false;
        }
        this.i += str.length();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r0(char c) {
        return !i0() && this.h[this.i] == c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s0(String str) {
        F();
        int length = str.length();
        if (length > this.j - this.i) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.h[this.i + i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean t0(char... cArr) {
        if (i0()) {
            return false;
        }
        F();
        char c = this.h[this.i];
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        int i = this.j;
        int i2 = this.i;
        return i - i2 < 0 ? "" : new String(this.h, i2, i - i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean u0(char[] cArr) {
        F();
        return !i0() && Arrays.binarySearch(cArr, this.h[this.i]) >= 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean v0() {
        if (i0()) {
            return false;
        }
        return fg4.i(this.h[this.i]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean w0() {
        if (i0()) {
            return false;
        }
        return fg4.k(this.h[this.i]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean x0(String str) {
        F();
        int length = str.length();
        if (length > this.j - this.i) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            char c = this.h[this.i + i];
            if (cCharAt != c && Character.toUpperCase(cCharAt) != Character.toUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int y0(char c) {
        F();
        for (int i = this.i; i < this.j; i++) {
            if (c == this.h[i]) {
                return i - this.i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int z0(CharSequence charSequence) {
        F();
        char cCharAt = charSequence.charAt(0);
        int i = this.i;
        while (i < this.j) {
            if (cCharAt != this.h[i]) {
                do {
                    i++;
                    if (i >= this.j) {
                        break;
                    }
                } while (cCharAt != this.h[i]);
            }
            int i2 = i + 1;
            int length = (charSequence.length() + i2) - 1;
            int i3 = this.j;
            if (i < i3 && length <= i3) {
                int i4 = i2;
                for (int i5 = 1; i4 < length && charSequence.charAt(i5) == this.h[i4]; i5++) {
                    i4++;
                }
                if (i4 == length) {
                    return i - this.i;
                }
            }
            i = i2;
        }
        return -1;
    }

    public xs(String str) {
        this(new StringReader(str));
    }
}
