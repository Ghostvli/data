package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ls implements ig3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends ls {
        public final ls f;
        public final ls g;

        public a(ls lsVar, ls lsVar2) {
            this.f = (ls) gg3.q(lsVar);
            this.g = (ls) gg3.q(lsVar2);
        }

        @Override // defpackage.ig3
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return this.f.m(c) && this.g.m(c);
        }

        public String toString() {
            return "CharMatcher.and(" + this.f + ", " + this.g + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends j {
        public static final ls g = new b();

        public b() {
            super("CharMatcher.any()");
        }

        @Override // defpackage.ls
        public ls b(ls lsVar) {
            return (ls) gg3.q(lsVar);
        }

        @Override // defpackage.ls
        public int g(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // defpackage.ls
        public int h(CharSequence charSequence, int i) {
            int length = charSequence.length();
            gg3.s(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return true;
        }

        @Override // defpackage.ls
        public boolean n(CharSequence charSequence) {
            gg3.q(charSequence);
            return true;
        }

        @Override // defpackage.ls
        public boolean o(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // ls.e, defpackage.ls
        public ls p() {
            return ls.q();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends ls {
        public final char[] f;

        public c(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f = charArray;
            Arrays.sort(charArray);
        }

        @Override // defpackage.ig3
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return Arrays.binarySearch(this.f, c) >= 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c : this.f) {
                sb.append(ls.s(c));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends j {
        public static final ls g = new d();

        public d() {
            super("CharMatcher.ascii()");
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return c <= 127;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class e extends ls {
        @Override // defpackage.ig3
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // defpackage.ls
        public ls p() {
            return new l(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends e {
        public final char f;

        public f(char c) {
            this.f = c;
        }

        @Override // defpackage.ls
        public ls b(ls lsVar) {
            return lsVar.m(this.f) ? this : ls.q();
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return c == this.f;
        }

        @Override // ls.e, defpackage.ls
        public ls p() {
            return ls.k(this.f);
        }

        public String toString() {
            return "CharMatcher.is('" + ls.s(this.f) + "')";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends e {
        public final char f;
        public final char g;

        public g(char c, char c2) {
            this.f = c;
            this.g = c2;
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return c == this.f || c == this.g;
        }

        public String toString() {
            return "CharMatcher.anyOf(\"" + ls.s(this.f) + ls.s(this.g) + "\")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends e {
        public final char f;

        public h(char c) {
            this.f = c;
        }

        @Override // defpackage.ls
        public ls b(ls lsVar) {
            return lsVar.m(this.f) ? super.b(lsVar) : lsVar;
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return c != this.f;
        }

        @Override // ls.e, defpackage.ls
        public ls p() {
            return ls.i(this.f);
        }

        public String toString() {
            return "CharMatcher.isNot('" + ls.s(this.f) + "')";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i extends j {
        public static final ls g = new i();

        public i() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            if (c > 31) {
                return c >= 127 && c <= 159;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class j extends e {
        public final String f;

        public j(String str) {
            this.f = (String) gg3.q(str);
        }

        public final String toString() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k extends ls {
        public final ls f;

        public k(ls lsVar) {
            this.f = (ls) gg3.q(lsVar);
        }

        @Override // defpackage.ig3
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return !this.f.m(c);
        }

        @Override // defpackage.ls
        public boolean n(CharSequence charSequence) {
            return this.f.o(charSequence);
        }

        @Override // defpackage.ls
        public boolean o(CharSequence charSequence) {
            return this.f.n(charSequence);
        }

        @Override // defpackage.ls
        public ls p() {
            return this.f;
        }

        public String toString() {
            return this.f + ".negate()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l extends k {
        public l(ls lsVar) {
            super(lsVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class m extends j {
        public static final ls g = new m();

        public m() {
            super("CharMatcher.none()");
        }

        @Override // defpackage.ls
        public ls b(ls lsVar) {
            gg3.q(lsVar);
            return this;
        }

        @Override // defpackage.ls
        public int g(CharSequence charSequence) {
            gg3.q(charSequence);
            return -1;
        }

        @Override // defpackage.ls
        public int h(CharSequence charSequence, int i) {
            gg3.s(i, charSequence.length());
            return -1;
        }

        @Override // defpackage.ls
        public boolean m(char c) {
            return false;
        }

        @Override // defpackage.ls
        public boolean n(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // defpackage.ls
        public boolean o(CharSequence charSequence) {
            gg3.q(charSequence);
            return true;
        }

        @Override // ls.e, defpackage.ls
        public ls p() {
            return ls.c();
        }
    }

    public static ls c() {
        return b.g;
    }

    public static ls d(CharSequence charSequence) {
        int length = charSequence.length();
        return length != 0 ? length != 1 ? length != 2 ? new c(charSequence) : j(charSequence.charAt(0), charSequence.charAt(1)) : i(charSequence.charAt(0)) : q();
    }

    public static ls f() {
        return d.g;
    }

    public static ls i(char c2) {
        return new f(c2);
    }

    public static g j(char c2, char c3) {
        return new g(c2, c3);
    }

    public static ls k(char c2) {
        return new h(c2);
    }

    public static ls l() {
        return i.g;
    }

    public static ls q() {
        return m.g;
    }

    public static ls r(CharSequence charSequence) {
        return d(charSequence).p();
    }

    public static String s(char c2) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public ls b(ls lsVar) {
        return new a(this, lsVar);
    }

    public boolean e(Character ch) {
        return m(ch.charValue());
    }

    public int g(CharSequence charSequence) {
        return h(charSequence, 0);
    }

    public int h(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        gg3.s(i2, length);
        while (i2 < length) {
            if (m(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public abstract boolean m(char c2);

    public boolean n(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!m(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean o(CharSequence charSequence) {
        return g(charSequence) == -1;
    }

    public ls p() {
        return new k(this);
    }
}
