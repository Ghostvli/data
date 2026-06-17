package defpackage;

import android.graphics.PointF;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.no1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y6 {
    public static final no1.a a = no1.a.a("a", "p", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "rz", "r", "o", "so", "eo", "sk", "sa", "rx", "ry");
    public static final no1.a b = no1.a.a("k");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(j6 j6Var, f12 f12Var) {
        Float fValueOf = Float.valueOf(0.0f);
        if (j6Var.b().isEmpty()) {
            j6Var.b().add(new dr1(f12Var, fValueOf, fValueOf, null, 0.0f, Float.valueOf(f12Var.f())));
        } else if (((dr1) j6Var.b().get(0)).b == null) {
            j6Var.b().set(0, new dr1(f12Var, fValueOf, fValueOf, null, 0.0f, Float.valueOf(f12Var.f())));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b(m6 m6Var) {
        if (m6Var != null) {
            return m6Var.c() && ((PointF) ((dr1) m6Var.b().get(0)).b).equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean c(z6 z6Var) {
        if (z6Var != null) {
            return !(z6Var instanceof r6) && z6Var.c() && ((PointF) ((dr1) z6Var.b().get(0)).b).equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean d(j6 j6Var) {
        if (j6Var != null) {
            return j6Var.c() && ((Float) ((dr1) j6Var.b().get(0)).b).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e(p6 p6Var) {
        if (p6Var != null) {
            return p6Var.c() && ((by3) ((dr1) p6Var.b().get(0)).b).a(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean f(j6 j6Var) {
        if (j6Var != null) {
            return j6Var.c() && ((Float) ((dr1) j6Var.b().get(0)).b).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean g(j6 j6Var) {
        if (j6Var != null) {
            return j6Var.c() && ((Float) ((dr1) j6Var.b().get(0)).b).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static x6 h(no1 no1Var, f12 f12Var) {
        boolean z = no1Var.K() == no1.b.BEGIN_OBJECT;
        if (z) {
            no1Var.h();
        }
        m6 m6VarA = null;
        z6 z6VarB = null;
        j6 j6VarF = null;
        p6 p6VarJ = null;
        j6 j6VarF2 = null;
        j6 j6VarF3 = null;
        j6 j6VarF4 = null;
        j6 j6VarF5 = null;
        j6 j6VarF6 = null;
        l6 l6VarH = null;
        j6 j6VarF7 = null;
        j6 j6VarF8 = null;
        while (no1Var.t()) {
            switch (no1Var.M(a)) {
                case 0:
                    no1Var.h();
                    while (no1Var.t()) {
                        if (no1Var.M(b) != 0) {
                            no1Var.N();
                            no1Var.O();
                        } else {
                            m6VarA = n6.a(no1Var, f12Var);
                        }
                    }
                    no1Var.l();
                    break;
                case 1:
                    z6VarB = n6.b(no1Var, f12Var);
                    break;
                case 2:
                    p6VarJ = a7.j(no1Var, f12Var);
                    break;
                case 3:
                    j6VarF6 = a7.f(no1Var, f12Var, false);
                    a(j6VarF6, f12Var);
                    break;
                case 4:
                    j6VarF = a7.f(no1Var, f12Var, false);
                    a(j6VarF, f12Var);
                    break;
                case 5:
                    l6VarH = a7.h(no1Var, f12Var);
                    break;
                case 6:
                    j6VarF7 = a7.f(no1Var, f12Var, false);
                    break;
                case 7:
                    j6VarF8 = a7.f(no1Var, f12Var, false);
                    break;
                case 8:
                    j6VarF2 = a7.f(no1Var, f12Var, false);
                    break;
                case 9:
                    j6VarF3 = a7.f(no1Var, f12Var, false);
                    break;
                case 10:
                    j6VarF4 = a7.f(no1Var, f12Var, false);
                    a(j6VarF4, f12Var);
                    break;
                case 11:
                    j6VarF5 = a7.f(no1Var, f12Var, false);
                    a(j6VarF5, f12Var);
                    break;
                default:
                    no1Var.N();
                    no1Var.O();
                    break;
            }
        }
        if (z) {
            no1Var.l();
        }
        return new x6(b(m6VarA) ? null : m6VarA, c(z6VarB) ? null : z6VarB, e(p6VarJ) ? null : p6VarJ, d(j6VarF) ? null : j6VarF, l6VarH, j6VarF7, j6VarF8, g(j6VarF2) ? null : j6VarF2, f(j6VarF3) ? null : j6VarF3, d(j6VarF4) ? null : j6VarF4, d(j6VarF5) ? null : j6VarF5, d(j6VarF6) ? null : j6VarF6);
    }
}
