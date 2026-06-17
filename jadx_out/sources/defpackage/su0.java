package defpackage;

import java.util.Iterator;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class su0 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends su0 {
        @Override // defpackage.su0
        public int e() {
            return 10;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a0 extends d0 {
        public a0() {
            super(0, 1);
        }

        @Override // su0.q
        public String toString() {
            return ":last-of-type";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends su0 {
        public final String a;

        public b(String str) {
            this.a = str;
        }

        @Override // defpackage.su0
        public int e() {
            return 2;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.w(this.a);
        }

        public String toString() {
            return String.format("[%s]", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b0 extends q {
        public b0(int i, int i2) {
            super(i, i2);
        }

        @Override // su0.q
        public int k(br0 br0Var, br0 br0Var2) {
            return br0Var2.q0() + 1;
        }

        @Override // su0.q
        public String l() {
            return "nth-child";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c extends su0 {
        public final String a;
        public final String b;

        public c(String str, String str2) {
            zy4.h(str);
            zy4.j(str2);
            this.a = z33.b(str);
            if ((str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""))) {
                zy4.e(str2.length() > 1, "Quoted value must have content");
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.b = z33.a(str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c0 extends q {
        public c0(int i, int i2) {
            super(i, i2);
        }

        @Override // su0.q
        public int k(br0 br0Var, br0 br0Var2) {
            if (br0Var2.L() == null) {
                return 0;
            }
            return br0Var2.L().l0() - br0Var2.q0();
        }

        @Override // su0.q
        public String l() {
            return "nth-last-child";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends su0 {
        public final String a;

        public d(String str) {
            zy4.j(str);
            this.a = z33.a(str);
        }

        @Override // defpackage.su0
        public int e() {
            return 6;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            Iterator it = br0Var2.f().f().iterator();
            while (it.hasNext()) {
                if (z33.a(((wb) it.next()).getKey()).startsWith(this.a)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d0 extends q {
        public d0(int i, int i2) {
            super(i, i2);
        }

        @Override // su0.q
        public int k(br0 br0Var, br0 br0Var2) {
            int i = 0;
            if (br0Var2.L() == null) {
                return 0;
            }
            for (br0 br0VarA = br0Var2; br0VarA != null; br0VarA = br0VarA.A()) {
                if (br0VarA.G().equals(br0Var2.G())) {
                    i++;
                }
            }
            return i;
        }

        @Override // su0.q
        public String l() {
            return "nth-last-of-type";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends c {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // defpackage.su0
        public int e() {
            return 3;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.w(this.a) && this.b.equalsIgnoreCase(br0Var2.e(this.a));
        }

        public String toString() {
            return String.format("[%s=%s]", this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e0 extends q {
        public e0(int i, int i2) {
            super(i, i2);
        }

        @Override // su0.q
        public int k(br0 br0Var, br0 br0Var2) {
            br0 br0VarL = br0Var2.L();
            if (br0VarL == null) {
                return 0;
            }
            int iL = br0VarL.l();
            int i = 0;
            for (int i2 = 0; i2 < iL; i2++) {
                l33 l33VarK = br0VarL.k(i2);
                if (l33VarK.G().equals(br0Var2.G())) {
                    i++;
                }
                if (l33VarK == br0Var2) {
                    return i;
                }
            }
            return i;
        }

        @Override // su0.q
        public String l() {
            return "nth-of-type";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends c {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // defpackage.su0
        public int e() {
            return 6;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.w(this.a) && z33.a(br0Var2.e(this.a)).contains(this.b);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f0 extends su0 {
        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            br0 br0VarL = br0Var2.L();
            return (br0VarL == null || (br0VarL instanceof wm0) || !br0Var2.S0().isEmpty()) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends c {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // defpackage.su0
        public int e() {
            return 4;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.w(this.a) && z33.a(br0Var2.e(this.a)).endsWith(this.b);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g0 extends su0 {
        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            br0 br0VarL = br0Var2.L();
            if (br0VarL != null && !(br0VarL instanceof wm0)) {
                int i = 0;
                for (br0 br0VarU0 = br0VarL.u0(); br0VarU0 != null; br0VarU0 = br0VarU0.A()) {
                    if (br0VarU0.G().equals(br0Var2.G())) {
                        i++;
                    }
                    if (i > 1) {
                        break;
                    }
                }
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends su0 {
        public final String a;
        public final sp3 b;

        public h(String str, sp3 sp3Var) {
            this.a = z33.b(str);
            this.b = sp3Var;
        }

        @Override // defpackage.su0
        public int e() {
            return 8;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.w(this.a) && this.b.c(br0Var2.e(this.a)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.a, this.b.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h0 extends su0 {
        @Override // defpackage.su0
        public int e() {
            return 1;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            if (br0Var instanceof wm0) {
                br0Var = br0Var.u0();
            }
            return br0Var2 == br0Var;
        }

        public String toString() {
            return ":root";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i extends c {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // defpackage.su0
        public int e() {
            return 3;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return !this.b.equalsIgnoreCase(br0Var2.e(this.a));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i0 extends su0 {
        public static boolean a;

        public i0() {
            if (a) {
                return;
            }
            a = true;
            System.err.println("WARNING: :matchText selector is deprecated and will be removed in jsoup 1.24.1. Use Element#selectNodes(String, Class) with selector ::textnode and class TextNode instead.");
        }

        @Override // defpackage.su0
        public int e() {
            return -1;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            if (br0Var2 instanceof wi3) {
                return true;
            }
            for (l33 l33Var : br0Var2.X0()) {
                wi3 wi3Var = new wi3(al4.o(br0Var2.V0(), br0Var2.U0().i(), g83.d), br0Var2.g(), br0Var2.f());
                l33Var.U(wi3Var);
                wi3Var.d0(l33Var);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j extends c {
        public j(String str, String str2) {
            super(str, str2);
        }

        @Override // defpackage.su0
        public int e() {
            return 4;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.w(this.a) && z33.a(br0Var2.e(this.a)).startsWith(this.b);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j0 extends su0 {
        public final sp3 a;

        public j0(sp3 sp3Var) {
            this.a = sp3Var;
        }

        @Override // defpackage.su0
        public int e() {
            return 8;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return this.a.c(br0Var2.W0()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k extends su0 {
        public final String a;

        public k(String str) {
            this.a = str;
        }

        @Override // defpackage.su0
        public int e() {
            return 8;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.A0(this.a);
        }

        public String toString() {
            return String.format(".%s", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k0 extends su0 {
        public final sp3 a;

        public k0(sp3 sp3Var) {
            this.a = sp3Var;
        }

        @Override // defpackage.su0
        public int e() {
            return 7;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return this.a.c(br0Var2.K0()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class l extends su0 {
        public final String a;

        public l(String str) {
            this.a = z33.a(str);
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return z33.a(br0Var2.n0()).contains(this.a);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class l0 extends su0 {
        public final sp3 a;

        public l0(sp3 sp3Var) {
            this.a = sp3Var;
        }

        @Override // defpackage.su0
        public int e() {
            return 7;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return this.a.c(br0Var2.Z0()).find();
        }

        public String toString() {
            return String.format(":matchesWholeOwnText(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class m extends su0 {
        public final String a;

        public m(String str) {
            this.a = z33.a(fg4.t(str));
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return z33.a(br0Var2.K0()).contains(this.a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class m0 extends su0 {
        public final sp3 a;

        public m0(sp3 sp3Var) {
            this.a = sp3Var;
        }

        @Override // defpackage.su0
        public int e() {
            return 8;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return this.a.c(br0Var2.a1()).find();
        }

        public String toString() {
            return String.format(":matchesWholeText(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class n extends su0 {
        public final String a;

        public n(String str) {
            this.a = z33.a(fg4.t(str));
        }

        @Override // defpackage.su0
        public int e() {
            return 10;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return z33.a(br0Var2.W0()).contains(this.a);
        }

        public String toString() {
            return String.format(":contains(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class n0 extends su0 {
        public final String a;

        public n0(String str) {
            this.a = str;
        }

        @Override // defpackage.su0
        public int e() {
            return 1;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.z(this.a);
        }

        public String toString() {
            return String.format("%s", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class o extends su0 {
        public final String a;

        public o(String str) {
            this.a = str;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.Z0().contains(this.a);
        }

        public String toString() {
            return String.format(":containsWholeOwnText(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class o0 extends su0 {
        public final String a;

        public o0(String str) {
            this.a = str;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.G().endsWith(this.a);
        }

        public String toString() {
            return String.format("*|%s", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class p extends su0 {
        public final String a;

        public p(String str) {
            this.a = str;
        }

        @Override // defpackage.su0
        public int e() {
            return 10;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.a1().contains(this.a);
        }

        public String toString() {
            return String.format(":containsWholeText(%s)", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class p0 extends su0 {
        public final String a;

        public p0(String str) {
            this.a = str;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.G().startsWith(this.a);
        }

        public String toString() {
            return String.format("%s|*", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class q extends su0 {
        public final int a;
        public final int b;

        public q(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            br0 br0VarL = br0Var2.L();
            if (br0VarL != null && !(br0VarL instanceof wm0)) {
                int iK = k(br0Var, br0Var2);
                int i = this.a;
                int i2 = this.b;
                if (i == 0) {
                    return iK == i2;
                }
                if ((iK - i2) * i >= 0 && (iK - i2) % i == 0) {
                    return true;
                }
            }
            return false;
        }

        public abstract int k(br0 br0Var, br0 br0Var2);

        public abstract String l();

        public String toString() {
            return String.format(this.a == 0 ? ":%s(%3$d)" : this.b == 0 ? ":%s(%2$dn)" : ":%s(%2$dn%3$+d)", l(), Integer.valueOf(this.a), Integer.valueOf(this.b));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class r extends su0 {
        public final String a;

        public r(String str) {
            this.a = str;
        }

        @Override // defpackage.su0
        public int e() {
            return 2;
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return this.a.equals(br0Var2.E0());
        }

        public String toString() {
            return String.format("#%s", this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class s extends t {
        public s(int i) {
            super(i);
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.q0() == this.a;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.a));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class t extends su0 {
        public final int a;

        public t(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class u extends t {
        public u(int i) {
            super(i);
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var2.q0() > this.a;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.a));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class v extends t {
        public v(int i) {
            super(i);
        }

        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            return br0Var != br0Var2 && br0Var2.q0() < this.a;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.a));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class w extends su0 {
        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            for (l33 l33VarS = br0Var2.s(); l33VarS != null; l33VarS = l33VarS.B()) {
                if (l33VarS instanceof sm4) {
                    if (!((sm4) l33VarS).g0()) {
                        return false;
                    }
                } else if (!(l33VarS instanceof lx) && !(l33VarS instanceof zm0)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class x extends su0 {
        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            br0 br0VarL = br0Var2.L();
            return (br0VarL == null || (br0VarL instanceof wm0) || br0Var2 != br0VarL.u0()) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class y extends e0 {
        public y() {
            super(0, 1);
        }

        @Override // su0.q
        public String toString() {
            return ":first-of-type";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class z extends su0 {
        @Override // defpackage.su0
        public boolean f(br0 br0Var, br0 br0Var2) {
            br0 br0VarL = br0Var2.L();
            return (br0VarL == null || (br0VarL instanceof wm0) || br0Var2 != br0VarL.I0()) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public Predicate c(final br0 br0Var) {
        return new Predicate() { // from class: qu0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.a.h(br0Var, (l33) obj);
            }
        };
    }

    public Predicate d(final br0 br0Var) {
        return new Predicate() { // from class: ru0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.a.f(br0Var, (br0) obj);
            }
        };
    }

    public int e() {
        return 5;
    }

    public abstract boolean f(br0 br0Var, br0 br0Var2);

    public boolean g(br0 br0Var, ms1 ms1Var) {
        return false;
    }

    public final boolean h(br0 br0Var, l33 l33Var) {
        if (l33Var instanceof br0) {
            return f(br0Var, (br0) l33Var);
        }
        if ((l33Var instanceof ms1) && j()) {
            return g(br0Var, (ms1) l33Var);
        }
        return false;
    }

    public void i() {
    }

    public boolean j() {
        return false;
    }
}
