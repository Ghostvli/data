package defpackage;

import defpackage.wm0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l33 implements Cloneable {
    public static final List h = Collections.EMPTY_LIST;
    public br0 f;
    public int g;

    public br0 A() {
        do {
            this = this.B();
            if (this == null) {
                return null;
            }
        } while (!(this instanceof br0));
        return (br0) this;
    }

    public l33 B() {
        br0 br0Var = this.f;
        if (br0Var == null) {
            return null;
        }
        List listR = br0Var.r();
        int iY = Y() + 1;
        if (listR.size() > iY) {
            return (l33) listR.get(iY);
        }
        return null;
    }

    public abstract String C();

    public Stream D() {
        return q33.d(this, l33.class);
    }

    public Stream E(Class cls) {
        return q33.d(this, cls);
    }

    public abstract String F();

    public String G() {
        return C();
    }

    public String H() {
        StringBuilder sbE = fg4.e();
        I(uj3.d(sbE));
        return fg4.v(sbE);
    }

    public void I(uj3 uj3Var) {
        sg3.i(this, uj3Var).c(this);
    }

    public abstract void J(uj3 uj3Var, wm0.a aVar);

    public wm0 K() {
        while (this != null) {
            if (this instanceof wm0) {
                return (wm0) this;
            }
            this = this.f;
        }
        return null;
    }

    public abstract l33 L();

    public boolean M(String str) {
        br0 br0Var = this.f;
        return br0Var != null && br0Var.G().equals(str);
    }

    public final l33 N() {
        return this.f;
    }

    public br0 O() {
        do {
            this = this.P();
            if (this == null) {
                return null;
            }
        } while (!(this instanceof br0));
        return (br0) this;
    }

    public l33 P() {
        if (this.f != null && Y() > 0) {
            return (l33) this.f.r().get(this.g - 1);
        }
        return null;
    }

    public void Q() {
        br0 br0Var = this.f;
        if (br0Var != null) {
            br0Var.R(this);
        }
    }

    public void R(l33 l33Var) {
        zy4.d(l33Var.f == this);
        br0 br0Var = (br0) this;
        if (br0Var.B0()) {
            r().remove(l33Var.g);
        } else {
            r().remove(l33Var);
        }
        br0Var.G0();
        l33Var.f = null;
    }

    public void S(l33 l33Var) {
        l33Var.W(this);
    }

    public void T(l33 l33Var, l33 l33Var2) {
        zy4.d(l33Var.f == this);
        zy4.j(l33Var2);
        if (l33Var == l33Var2) {
            return;
        }
        br0 br0Var = l33Var2.f;
        if (br0Var != null) {
            br0Var.R(l33Var2);
        }
        int iY = l33Var.Y();
        r().set(iY, l33Var2);
        br0 br0Var2 = (br0) this;
        l33Var2.f = br0Var2;
        l33Var2.X(iY);
        l33Var.f = null;
        br0Var2.j.b();
    }

    public void U(l33 l33Var) {
        zy4.j(l33Var);
        if (this.f == null) {
            this.f = l33Var.f;
        }
        zy4.j(this.f);
        this.f.T(this, l33Var);
    }

    public void V(String str) {
        zy4.j(str);
        p(str);
    }

    public void W(l33 l33Var) {
        zy4.j(l33Var);
        br0 br0Var = this.f;
        if (br0Var != null) {
            br0Var.R(this);
        }
        this.f = (br0) l33Var;
    }

    public void X(int i) {
        this.g = i;
    }

    public int Y() {
        br0 br0Var = this.f;
        if (br0Var != null && !br0Var.j.f) {
            br0Var.O0();
        }
        return this.g;
    }

    public l33 Z(r33 r33Var) {
        zy4.j(r33Var);
        r33Var.c(this);
        return this;
    }

    public String b(String str) {
        zy4.h(str);
        return (x() && f().q(str)) ? fg4.x(g(), f().n(str)) : "";
    }

    public void c(int i, l33... l33VarArr) {
        zy4.j(l33VarArr);
        if (l33VarArr.length == 0) {
            return;
        }
        List listR = r();
        l33 l33VarL = l33VarArr[0].L();
        if (l33VarL != null && l33VarL.l() == l33VarArr.length) {
            List listR2 = l33VarL.r();
            int length = l33VarArr.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    l33VarL.q();
                    listR.addAll(i, Arrays.asList(l33VarArr));
                    int length2 = l33VarArr.length;
                    while (true) {
                        int i3 = length2 - 1;
                        if (length2 <= 0) {
                            ((br0) this).G0();
                            return;
                        } else {
                            l33VarArr[i3].f = (br0) this;
                            length2 = i3;
                        }
                    }
                } else if (l33VarArr[i2] != listR2.get(i2)) {
                    break;
                } else {
                    length = i2;
                }
            }
        }
        zy4.f(l33VarArr);
        for (l33 l33Var : l33VarArr) {
            S(l33Var);
        }
        listR.addAll(i, Arrays.asList(l33VarArr));
        ((br0) this).G0();
    }

    public l33 d(String str, String str2) {
        wm0 wm0VarK = K();
        f().D((wm0VarK != null ? wm0VarK.h1().j() : g83.c).b(str), str2);
        return this;
    }

    public String e(String str) {
        zy4.j(str);
        if (!x()) {
            return "";
        }
        String strN = f().n(str);
        return strN.length() > 0 ? strN : str.startsWith("abs:") ? b(str.substring(4)) : "";
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public abstract xb f();

    public abstract String g();

    public int hashCode() {
        return super.hashCode();
    }

    public l33 j(l33 l33Var) {
        zy4.j(l33Var);
        zy4.j(this.f);
        if (l33Var.f == this.f) {
            l33Var.Q();
        }
        this.f.c(Y(), l33Var);
        return this;
    }

    public l33 k(int i) {
        return (l33) r().get(i);
    }

    public abstract int l();

    public List m() {
        if (l() == 0) {
            return h;
        }
        List listR = r();
        ArrayList arrayList = new ArrayList(listR.size());
        arrayList.addAll(listR);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // 
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public l33 clone() {
        l33 l33VarO = o(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(l33VarO);
        while (!linkedList.isEmpty()) {
            l33 l33Var = (l33) linkedList.remove();
            int iL = l33Var.l();
            for (int i = 0; i < iL; i++) {
                List listR = l33Var.r();
                l33 l33VarO2 = ((l33) listR.get(i)).o(l33Var);
                listR.set(i, l33VarO2);
                linkedList.add(l33VarO2);
            }
        }
        return l33VarO;
    }

    public l33 o(l33 l33Var) {
        wm0 wm0VarK;
        try {
            l33 l33Var2 = (l33) super.clone();
            l33Var2.f = (br0) l33Var;
            l33Var2.g = l33Var == null ? 0 : Y();
            if (l33Var == null && !(this instanceof wm0) && (wm0VarK = K()) != null) {
                wm0 wm0VarK1 = wm0VarK.k1();
                l33Var2.f = wm0VarK1;
                wm0VarK1.r().add(l33Var2);
            }
            return l33Var2;
        } catch (CloneNotSupportedException e) {
            wg1.a(e);
            return null;
        }
    }

    public abstract void p(String str);

    public abstract l33 q();

    public abstract List r();

    public l33 s() {
        if (l() == 0) {
            return null;
        }
        return (l33) r().get(0);
    }

    public String toString() {
        return H();
    }

    public l33 u() {
        br0 br0Var = this.f;
        return br0Var != null ? br0Var.s() : this;
    }

    public boolean w(String str) {
        zy4.j(str);
        if (!x()) {
            return false;
        }
        if (str.startsWith("abs:")) {
            String strSubstring = str.substring(4);
            if (f().q(strSubstring) && !b(strSubstring).isEmpty()) {
                return true;
            }
        }
        return f().q(str);
    }

    public abstract boolean x();

    public boolean y() {
        return this.f != null;
    }

    public boolean z(String str) {
        return G().equals(str);
    }
}
