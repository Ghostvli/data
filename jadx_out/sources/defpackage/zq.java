package defpackage;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import defpackage.p50;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zq extends dr {
    public final int i;
    public final int j;
    public final int k;
    public final long l;
    public List o;
    public List p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public byte u;
    public byte v;
    public boolean x;
    public long y;
    public static final int[] z = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] A = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] B = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] C = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, Context.VERSION_ECMASCRIPT, 97, 98, 99, 100, 101, 102, 103, Token.ASSIGN_LOGICAL_AND, Token.ASSIGN_LSH, Token.ASSIGN_RSH, Token.ASSIGN_URSH, Token.ASSIGN_ADD, Token.ASSIGN_SUB, 110, Token.ASSIGN_DIV, Token.ASSIGN_MOD, Token.ASSIGN_EXP, 114, Token.HOOK, Token.COLON, Token.OR, Token.AND, Token.INC, 120, Token.DOT, Token.FUNCTION, 231, 247, 209, 241, 9632};
    public static final int[] D = {Token.DEBUGGER, Token.GENEXPR, 189, 191, 8482, Token.XMLEND, Token.TO_OBJECT, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] E = {193, 201, 211, 218, 220, 252, 8216, Token.XMLATTR, 42, 39, 8212, Token.SETCONST, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, Token.ARRAYCOMP, Token.LAST_TOKEN};
    public static final int[] F = {195, 227, 205, 204, 236, 210, 242, 213, 245, Token.EXPORT, Token.IF, 92, 94, 95, Token.IMPORT, 126, 196, 228, 214, 246, 223, Token.GET, Token.TO_DOUBLE, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] G = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public final r73 h = new r73();
    public final ArrayList m = new ArrayList();
    public a n = new a(0, 4);
    public int w = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final List a = new ArrayList();
        public final List b = new ArrayList();
        public final StringBuilder c = new StringBuilder();
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        /* JADX INFO: renamed from: zq$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class C0146a {
            public final int a;
            public final boolean b;
            public int c;

            public C0146a(int i, boolean z, int i2) {
                this.a = i;
                this.b = z;
                this.c = i2;
            }
        }

        public a(int i, int i2) {
            j(i);
            this.h = i2;
        }

        public static void n(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        public static void o(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        public static void q(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        public void e(char c) {
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }

        public void f() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    C0146a c0146a = (C0146a) this.a.get(size);
                    int i = c0146a.c;
                    if (i != length) {
                        return;
                    }
                    c0146a.c = i - 1;
                }
            }
        }

        public p50 g(int i) {
            float f;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                spannableStringBuilder.append((CharSequence) this.b.get(i2));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) h());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i3 = this.e + this.f;
            int length = (32 - i3) - spannableStringBuilder.length();
            int i4 = i3 - length;
            if (i == Integer.MIN_VALUE) {
                i = (this.g != 2 || (Math.abs(i4) >= 3 && length >= 0)) ? (this.g != 2 || i4 <= 0) ? 0 : 2 : 1;
            }
            if (i != 1) {
                if (i == 2) {
                    i3 = 32 - length;
                }
                f = ((i3 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i5 = this.d;
            if (i5 > 7) {
                i5 -= 17;
            } else if (this.g == 1) {
                i5 -= this.h - 1;
            }
            return new p50.b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i5, 1).k(f).l(i).a();
        }

        public final SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 < this.a.size()) {
                C0146a c0146a = (C0146a) this.a.get(i5);
                boolean z2 = c0146a.b;
                int i7 = c0146a.a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i4 = zq.B[i7];
                    }
                    z = z3;
                }
                int i8 = c0146a.c;
                i5++;
                if (i8 != (i5 < this.a.size() ? ((C0146a) this.a.get(i5)).c : length)) {
                    if (i != -1 && !z2) {
                        q(spannableStringBuilder, i, i8);
                        i = -1;
                    } else if (i == -1 && z2) {
                        i = i8;
                    }
                    if (i2 != -1 && !z) {
                        o(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z) {
                        i2 = i8;
                    }
                    if (i4 != i3) {
                        n(spannableStringBuilder, i6, i8, i3);
                        i3 = i4;
                        i6 = i8;
                    }
                }
            }
            if (i != -1 && i != length) {
                q(spannableStringBuilder, i, length);
            }
            if (i2 != -1 && i2 != length) {
                o(spannableStringBuilder, i2, length);
            }
            if (i6 != length) {
                n(spannableStringBuilder, i6, length, i3);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean i() {
            return this.a.isEmpty() && this.b.isEmpty() && this.c.length() == 0;
        }

        public void j(int i) {
            this.g = i;
            this.a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }

        public void k() {
            this.b.add(h());
            this.c.setLength(0);
            this.a.clear();
            int iMin = Math.min(this.h, this.d);
            while (this.b.size() >= iMin) {
                this.b.remove(0);
            }
        }

        public void l(int i) {
            this.g = i;
        }

        public void m(int i) {
            this.h = i;
        }

        public void p(int i, boolean z) {
            this.a.add(new C0146a(i, z, this.c.length()));
        }
    }

    public zq(String str, int i, long j) {
        if (j != -9223372036854775807L) {
            gg3.d(j >= 16000);
            this.l = j * 1000;
        } else {
            this.l = -9223372036854775807L;
        }
        this.i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.k = 0;
            this.j = 0;
        } else if (i == 2) {
            this.k = 1;
            this.j = 0;
        } else if (i == 3) {
            this.k = 0;
            this.j = 1;
        } else if (i != 4) {
            xz1.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.k = 0;
            this.j = 0;
        } else {
            this.k = 1;
            this.j = 1;
        }
        O(0);
        N();
        this.x = true;
        this.y = -9223372036854775807L;
    }

    public static boolean B(byte b) {
        return (b & 224) == 0;
    }

    public static boolean C(byte b, byte b2) {
        return (b & 246) == 18 && (b2 & 224) == 32;
    }

    public static boolean D(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    public static boolean E(byte b, byte b2) {
        return (b & 246) == 20 && (b2 & 240) == 32;
    }

    public static boolean F(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    public static boolean G(byte b) {
        return (b & 240) == 16;
    }

    public static boolean I(byte b) {
        return (b & 246) == 20;
    }

    public static boolean J(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 48;
    }

    public static boolean K(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    public static boolean L(byte b) {
        return 1 <= b && b <= 15;
    }

    public static char r(byte b) {
        return (char) C[(b & 127) - 32];
    }

    public static int s(byte b) {
        return (b >> 3) & 1;
    }

    public static char u(byte b) {
        return (char) E[b & 31];
    }

    public static char v(byte b) {
        return (char) F[b & 31];
    }

    public static char w(byte b, byte b2) {
        return (b & 1) == 0 ? u(b2) : v(b2);
    }

    public static char x(byte b) {
        return (char) D[b & 15];
    }

    public final void A(byte b, byte b2) {
        int i = z[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.n.d) {
            if (this.q != 1 && !this.n.i()) {
                a aVar = new a(this.q, this.r);
                this.n = aVar;
                this.m.add(aVar);
            }
            this.n.d = i;
        }
        boolean z2 = (b2 & 16) == 16;
        boolean z3 = (b2 & 1) == 1;
        int i2 = (b2 >> 1) & 7;
        this.n.p(z2 ? 8 : i2, z3);
        if (z2) {
            this.n.e = A[i2];
        }
    }

    public final boolean H(boolean z2, byte b, byte b2) {
        if (!z2 || !G(b)) {
            this.t = false;
        } else {
            if (this.t && this.u == b && this.v == b2) {
                this.t = false;
                return true;
            }
            this.t = true;
            this.u = b;
            this.v = b2;
        }
        return false;
    }

    public final void M(byte b, byte b2) {
        if (L(b)) {
            this.x = false;
            return;
        }
        if (I(b)) {
            if (b2 != 32 && b2 != 47) {
                switch (b2) {
                    case Token.SETPROP /* 37 */:
                    case Token.SETPROP_SUPER /* 38 */:
                    case Token.GETELEM /* 39 */:
                        break;
                    default:
                        switch (b2) {
                            case Token.SETELEM_SUPER /* 42 */:
                            case Token.CALL /* 43 */:
                                this.x = false;
                                break;
                        }
                        return;
                }
            }
            this.x = true;
        }
    }

    public final void N() {
        this.n.j(this.q);
        this.m.clear();
        this.m.add(this.n);
    }

    public final void O(int i) {
        int i2 = this.q;
        if (i2 == i) {
            return;
        }
        this.q = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                ((a) this.m.get(i3)).l(i);
            }
            return;
        }
        N();
        if (i2 == 3 || i == 1 || i == 0) {
            this.o = Collections.EMPTY_LIST;
        }
    }

    public final void P(int i) {
        this.r = i;
        this.n.m(i);
    }

    public final boolean Q() {
        return (this.l == -9223372036854775807L || this.y == -9223372036854775807L || l() - this.y < this.l) ? false : true;
    }

    public final boolean R(byte b) {
        if (B(b)) {
            this.w = s(b);
        }
        return this.w == this.k;
    }

    @Override // defpackage.dr, defpackage.zh4
    public /* bridge */ /* synthetic */ void c(long j) {
        super.c(j);
    }

    @Override // defpackage.dr, defpackage.fb0
    public void flush() {
        super.flush();
        this.o = null;
        this.p = null;
        O(0);
        P(4);
        N();
        this.s = false;
        this.t = false;
        this.u = (byte) 0;
        this.v = (byte) 0;
        this.w = 0;
        this.x = true;
        this.y = -9223372036854775807L;
    }

    @Override // defpackage.dr
    public yh4 g() {
        List list = this.o;
        this.p = list;
        return new er((List) gg3.q(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    @Override // defpackage.dr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(defpackage.gi4 r10) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zq.h(gi4):void");
    }

    @Override // defpackage.dr
    /* JADX INFO: renamed from: i */
    public /* bridge */ /* synthetic */ gi4 d() {
        return super.d();
    }

    @Override // defpackage.dr, defpackage.fb0
    /* JADX INFO: renamed from: j */
    public hi4 a() {
        hi4 hi4VarK;
        hi4 hi4VarA = super.a();
        if (hi4VarA != null) {
            return hi4VarA;
        }
        if (!Q() || (hi4VarK = k()) == null) {
            return null;
        }
        this.o = Collections.EMPTY_LIST;
        this.y = -9223372036854775807L;
        hi4VarK.g(l(), g(), Long.MAX_VALUE);
        return hi4VarK;
    }

    @Override // defpackage.dr
    public boolean m() {
        return this.o != this.p;
    }

    @Override // defpackage.dr
    /* JADX INFO: renamed from: n */
    public /* bridge */ /* synthetic */ void f(gi4 gi4Var) {
        super.f(gi4Var);
    }

    @Override // defpackage.dr, defpackage.fb0
    public void release() {
    }

    public final List t() {
        int size = this.m.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            p50 p50VarG = ((a) this.m.get(i)).g(Integer.MIN_VALUE);
            arrayList.add(p50VarG);
            if (p50VarG != null) {
                iMin = Math.min(iMin, p50VarG.i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            p50 p50Var = (p50) arrayList.get(i2);
            if (p50Var != null) {
                if (p50Var.i != iMin) {
                    p50Var = (p50) gg3.q(((a) this.m.get(i2)).g(iMin));
                }
                arrayList2.add(p50Var);
            }
        }
        return arrayList2;
    }

    public final void y(byte b) {
        this.n.e(' ');
        this.n.p((b >> 1) & 7, (b & 1) == 1);
    }

    public final void z(byte b) {
        if (b == 32) {
            O(2);
            return;
        }
        if (b == 41) {
            O(3);
            return;
        }
        switch (b) {
            case Token.SETPROP /* 37 */:
                O(1);
                P(2);
                break;
            case Token.SETPROP_SUPER /* 38 */:
                O(1);
                P(3);
                break;
            case Token.GETELEM /* 39 */:
                O(1);
                P(4);
                break;
            default:
                int i = this.q;
                if (i != 0) {
                    if (b != 33) {
                        switch (b) {
                            case Token.NAME /* 44 */:
                                this.o = Collections.EMPTY_LIST;
                                if (i == 1 || i == 3) {
                                    N();
                                }
                                break;
                            case Token.NUMBER /* 45 */:
                                if (i == 1 && !this.n.i()) {
                                    this.n.k();
                                    break;
                                }
                                break;
                            case Token.STRING /* 46 */:
                                N();
                                break;
                            case Token.NULL /* 47 */:
                                this.o = t();
                                N();
                                break;
                        }
                    } else {
                        this.n.f();
                        break;
                    }
                }
                break;
        }
    }
}
