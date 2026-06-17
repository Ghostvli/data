package defpackage;

import defpackage.bl1;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class sy3 {
    public static final Class a = F();
    public static final lw4 b = G();
    public static final lw4 c = new nw4();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int A(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof nk1)) {
            int iK = 0;
            while (i < size) {
                iK += jv.K(((Integer) list.get(i)).intValue());
                i++;
            }
            return iK;
        }
        nk1 nk1Var = (nk1) list;
        int iK2 = 0;
        while (i < size) {
            iK2 += jv.K(nk1Var.m(i));
            i++;
        }
        return iK2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int B(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iC = C(list);
        return z ? jv.I(i) + jv.v(iC) : iC + (size * jv.I(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int C(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof s02)) {
            int iM = 0;
            while (i < size) {
                iM += jv.M(((Long) list.get(i)).longValue());
                i++;
            }
            return iM;
        }
        s02 s02Var = (s02) list;
        int iM2 = 0;
        while (i < size) {
            iM2 += jv.M(s02Var.m(i));
            i++;
        }
        return iM2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object D(Object obj, int i, List list, bl1.d dVar, Object obj2, lw4 lw4Var) {
        if (dVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                dVar.a(iIntValue);
                obj2 = N(obj, i, iIntValue, obj2, lw4Var);
                it.remove();
            }
            return obj2;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iIntValue2 = ((Integer) list.get(i2)).intValue();
            dVar.a(iIntValue2);
            obj2 = N(obj, i, iIntValue2, obj2, lw4Var);
        }
        if (size != 0) {
            list.subList(0, size).clear();
        }
        return obj2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object E(Object obj, int i, List list, bl1.e eVar, Object obj2, lw4 lw4Var) {
        if (eVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!eVar.a(iIntValue)) {
                    obj2 = N(obj, i, iIntValue, obj2, lw4Var);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) list.get(i3);
            int iIntValue2 = num.intValue();
            if (eVar.a(iIntValue2)) {
                if (i3 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = N(obj, i, iIntValue2, obj2, lw4Var);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Class F() {
        if (s5.b) {
            return null;
        }
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lw4 G() {
        try {
            Class clsH = H();
            if (clsH == null) {
                return null;
            }
            return (lw4) clsH.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Class H() {
        if (s5.b) {
            return null;
        }
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void I(yy0 yy0Var, Object obj, Object obj2) {
        b01 b01VarC = yy0Var.c(obj2);
        if (b01VarC.f()) {
            return;
        }
        yy0Var.d(obj).j(b01VarC);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void J(n42 n42Var, Object obj, Object obj2, long j) {
        vw4.R(obj, j, n42Var.a(vw4.C(obj, j), vw4.C(obj2, j)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void K(lw4 lw4Var, Object obj, Object obj2) {
        lw4Var.p(obj, lw4Var.k(lw4Var.g(obj), lw4Var.g(obj2)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void L(Class cls) {
        Class cls2;
        if (i91.class.isAssignableFrom(cls) || s5.b || (cls2 = a) == null || cls2.isAssignableFrom(cls)) {
            return;
        }
        jl.a("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean M(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object N(Object obj, int i, int i2, Object obj2, lw4 lw4Var) {
        if (obj2 == null) {
            obj2 = lw4Var.f(obj);
        }
        lw4Var.e(obj2, i, i2);
        return obj2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lw4 O() {
        return b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lw4 P() {
        return c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void Q(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.B(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void R(int i, List list, ha5 ha5Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.O(i, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void S(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.M(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void T(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.L(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void U(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.z(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void V(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.w(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void W(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.b(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void X(int i, List list, ha5 ha5Var, py3 py3Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.C(i, list, py3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void Y(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.p(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void Z(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.K(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(int i, rs2 rs2Var, py3 py3Var) {
        return (jv.I(i) * 2) + b(rs2Var, py3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a0(int i, List list, ha5 ha5Var, py3 py3Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.A(i, list, py3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(rs2 rs2Var, py3 py3Var) {
        return ((p0) rs2Var).getSerializedSize(py3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b0(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.x(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(int i, p0 p0Var, py3 py3Var) {
        return jv.I(i) + d(p0Var, py3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c0(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.h(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(p0 p0Var, py3 py3Var) {
        return jv.v(p0Var.getSerializedSize(py3Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void d0(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.I(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? jv.I(i) + jv.v(size) : size * jv.d(i, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e0(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.E(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(List list) {
        return list.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f0(int i, List list, ha5 ha5Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.l(i, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int I = size * jv.I(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            I += jv.g((hn) list.get(i2));
        }
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g0(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.D(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = i(list);
        return z ? jv.I(i) + jv.v(i2) : i2 + (size * jv.I(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h0(int i, List list, ha5 ha5Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ha5Var.i(i, list, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof nk1)) {
            int iK = 0;
            while (i < size) {
                iK += jv.k(((Integer) list.get(i)).intValue());
                i++;
            }
            return iK;
        }
        nk1 nk1Var = (nk1) list;
        int iK2 = 0;
        while (i < size) {
            iK2 += jv.k(nk1Var.m(i));
            i++;
        }
        return iK2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? jv.I(i) + jv.v(size * 4) : size * jv.l(i, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(List list) {
        return list.size() * 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int l(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? jv.I(i) + jv.v(size * 8) : size * jv.n(i, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int m(List list) {
        return list.size() * 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int n(int i, List list, py3 py3Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iA += a(i, (rs2) list.get(i2), py3Var);
        }
        return iA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int o(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iP = p(list);
        return z ? jv.I(i) + jv.v(iP) : iP + (size * jv.I(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof nk1)) {
            int iS = 0;
            while (i < size) {
                iS += jv.s(((Integer) list.get(i)).intValue());
                i++;
            }
            return iS;
        }
        nk1 nk1Var = (nk1) list;
        int iS2 = 0;
        while (i < size) {
            iS2 += jv.s(nk1Var.m(i));
            i++;
        }
        return iS2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int q(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int iR = r(list);
        return z ? jv.I(i) + jv.v(iR) : iR + (list.size() * jv.I(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int r(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof s02)) {
            int iU = 0;
            while (i < size) {
                iU += jv.u(((Long) list.get(i)).longValue());
                i++;
            }
            return iU;
        }
        s02 s02Var = (s02) list;
        int iU2 = 0;
        while (i < size) {
            iU2 += jv.u(s02Var.m(i));
            i++;
        }
        return iU2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int s(int i, Object obj, py3 py3Var) {
        return c(i, (p0) obj, py3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int t(int i, List list, py3 py3Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int I = jv.I(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            I += d((p0) list.get(i2), py3Var);
        }
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int u(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = v(list);
        return z ? jv.I(i) + jv.v(iV) : iV + (size * jv.I(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int v(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof nk1)) {
            int iD = 0;
            while (i < size) {
                iD += jv.D(((Integer) list.get(i)).intValue());
                i++;
            }
            return iD;
        }
        nk1 nk1Var = (nk1) list;
        int iD2 = 0;
        while (i < size) {
            iD2 += jv.D(nk1Var.m(i));
            i++;
        }
        return iD2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int w(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iX = x(list);
        return z ? jv.I(i) + jv.v(iX) : iX + (size * jv.I(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int x(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof s02)) {
            int iF = 0;
            while (i < size) {
                iF += jv.F(((Long) list.get(i)).longValue());
                i++;
            }
            return iF;
        }
        s02 s02Var = (s02) list;
        int iF2 = 0;
        while (i < size) {
            iF2 += jv.F(s02Var.m(i));
            i++;
        }
        return iF2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int I = jv.I(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            I += obj instanceof hn ? jv.g((hn) obj) : jv.H((String) obj);
        }
        return I;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int z(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA = A(list);
        return z ? jv.I(i) + jv.v(iA) : iA + (size * jv.I(i));
    }
}
