package defpackage;

import android.util.Log;
import androidx.lifecycle.g;
import defpackage.d71;
import defpackage.k61;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pf extends d71 implements k61.o {
    public final k61 t;
    public boolean u;
    public int v;
    public boolean w;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pf(k61 k61Var) {
        super(k61Var.v0(), k61Var.x0() != null ? k61Var.x0().f().getClassLoader() : null);
        this.v = -1;
        this.w = false;
        this.t = k61Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f != 0 || this.g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.m);
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (this.c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            d71.a aVar = (d71.a) this.c.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.d != 0 || aVar.e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.e));
                }
                if (aVar.f != 0 || aVar.g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.g));
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            d71.a aVar = (d71.a) this.c.get(i);
            p51 p51Var = aVar.b;
            if (p51Var != null) {
                p51Var.s = this.w;
                p51Var.j2(false);
                p51Var.i2(this.h);
                p51Var.l2(this.p, this.q);
            }
            switch (aVar.a) {
                case 1:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.n1(p51Var, false);
                    this.t.j(p51Var);
                    break;
                case 2:
                default:
                    qn.a("Unknown cmd: ", aVar.a);
                    return;
                case 3:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.f1(p51Var);
                    break;
                case 4:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.H0(p51Var);
                    break;
                case 5:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.n1(p51Var, false);
                    this.t.t1(p51Var);
                    break;
                case 6:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.x(p51Var);
                    break;
                case 7:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.n1(p51Var, false);
                    this.t.n(p51Var);
                    break;
                case 8:
                    this.t.r1(p51Var);
                    break;
                case 9:
                    this.t.r1(null);
                    break;
                case 10:
                    this.t.q1(p51Var, aVar.i);
                    break;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            d71.a aVar = (d71.a) this.c.get(size);
            p51 p51Var = aVar.b;
            if (p51Var != null) {
                p51Var.s = this.w;
                p51Var.j2(true);
                p51Var.i2(k61.j1(this.h));
                p51Var.l2(this.q, this.p);
            }
            switch (aVar.a) {
                case 1:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.n1(p51Var, true);
                    this.t.f1(p51Var);
                    break;
                case 2:
                default:
                    qn.a("Unknown cmd: ", aVar.a);
                    return;
                case 3:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.j(p51Var);
                    break;
                case 4:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.t1(p51Var);
                    break;
                case 5:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.n1(p51Var, true);
                    this.t.H0(p51Var);
                    break;
                case 6:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.n(p51Var);
                    break;
                case 7:
                    p51Var.d2(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.n1(p51Var, true);
                    this.t.x(p51Var);
                    break;
                case 8:
                    this.t.r1(null);
                    break;
                case 9:
                    this.t.r1(p51Var);
                    break;
                case 10:
                    this.t.q1(p51Var, aVar.h);
                    break;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p51 D(ArrayList arrayList, p51 p51Var) {
        p51 p51Var2 = p51Var;
        int i = 0;
        while (i < this.c.size()) {
            d71.a aVar = (d71.a) this.c.get(i);
            int i2 = aVar.a;
            if (i2 == 1) {
                arrayList.add(aVar.b);
            } else if (i2 == 2) {
                p51 p51Var3 = aVar.b;
                int i3 = p51Var3.D;
                boolean z = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    p51 p51Var4 = (p51) arrayList.get(size);
                    if (p51Var4.D == i3) {
                        if (p51Var4 == p51Var3) {
                            z = true;
                        } else {
                            if (p51Var4 == p51Var2) {
                                this.c.add(i, new d71.a(9, p51Var4, true));
                                i++;
                                p51Var2 = null;
                            }
                            d71.a aVar2 = new d71.a(3, p51Var4, true);
                            aVar2.d = aVar.d;
                            aVar2.f = aVar.f;
                            aVar2.e = aVar.e;
                            aVar2.g = aVar.g;
                            this.c.add(i, aVar2);
                            arrayList.remove(p51Var4);
                            i++;
                        }
                    }
                }
                if (z) {
                    this.c.remove(i);
                    i--;
                } else {
                    aVar.a = 1;
                    aVar.c = true;
                    arrayList.add(p51Var3);
                }
            } else if (i2 == 3 || i2 == 6) {
                arrayList.remove(aVar.b);
                p51 p51Var5 = aVar.b;
                if (p51Var5 == p51Var2) {
                    this.c.add(i, new d71.a(9, p51Var5));
                    i++;
                    p51Var2 = null;
                }
            } else if (i2 != 7) {
                if (i2 == 8) {
                    this.c.add(i, new d71.a(9, p51Var2, true));
                    aVar.c = true;
                    i++;
                    p51Var2 = aVar.b;
                }
            }
            i++;
        }
        return p51Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String E() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F() {
        if (this.s != null) {
            for (int i = 0; i < this.s.size(); i++) {
                ((Runnable) this.s.get(i)).run();
            }
            this.s = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p51 G(ArrayList arrayList, p51 p51Var) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            d71.a aVar = (d71.a) this.c.get(size);
            int i = aVar.a;
            if (i == 1) {
                arrayList.remove(aVar.b);
            } else if (i != 3) {
                switch (i) {
                    case 6:
                        arrayList.add(aVar.b);
                        break;
                    case 8:
                        p51Var = null;
                        break;
                    case 9:
                        p51Var = aVar.b;
                        break;
                    case 10:
                        aVar.i = aVar.h;
                        break;
                }
            }
        }
        return p51Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // k61.o
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.i) {
            return true;
        }
        this.t.i(this);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public int h() {
        return y(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public int i() {
        return y(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public void j() {
        l();
        this.t.c0(this, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public void k() {
        l();
        this.t.c0(this, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public void m(int i, p51 p51Var, String str, int i2) {
        super.m(i, p51Var, str, i2);
        p51Var.y = this.t;
    }

    /* JADX DEBUG: Class process forced to load method for inline: of.a(java.lang.String, p51):void */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public d71 n(p51 p51Var) {
        k61 k61Var = p51Var.y;
        if (k61Var == null || k61Var == this.t) {
            return super.n(p51Var);
        }
        of.a("Cannot hide Fragment attached to a different FragmentManager. Fragment ", p51Var);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public boolean o() {
        return this.c.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public d71 p(p51 p51Var) {
        k61 k61Var = p51Var.y;
        if (k61Var == null || k61Var == this.t) {
            return super.p(p51Var);
        }
        of.a("Cannot remove Fragment attached to a different FragmentManager. Fragment ", p51Var);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public d71 s(p51 p51Var, g.b bVar) {
        if (p51Var.y != this.t) {
            nl.a("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ", this.t);
            return null;
        }
        if (bVar == g.b.g && p51Var.f > -1) {
            f02.a("Cannot set maximum Lifecycle to ", bVar, " after the Fragment has been created");
            return null;
        }
        if (bVar != g.b.f) {
            return super.s(p51Var, bVar);
        }
        f02.a("Cannot set maximum Lifecycle to ", bVar, ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public d71 t(p51 p51Var) {
        k61 k61Var;
        if (p51Var == null || (k61Var = p51Var.y) == null || k61Var == this.t) {
            return super.t(p51Var);
        }
        of.a("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ", p51Var);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.d71
    public d71 w(p51 p51Var) {
        k61 k61Var = p51Var.y;
        if (k61Var == null || k61Var == this.t) {
            return super.w(p51Var);
        }
        of.a("Cannot show Fragment attached to a different FragmentManager. Fragment ", p51Var);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x(int i) {
        if (this.i) {
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                d71.a aVar = (d71.a) this.c.get(i2);
                p51 p51Var = aVar.b;
                if (p51Var != null) {
                    p51Var.x += i;
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.x);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int y(boolean z) {
        if (this.u) {
            e04.a("commit already called");
            return 0;
        }
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new c02("FragmentManager"));
            z("  ", printWriter);
            printWriter.close();
        }
        this.u = true;
        if (this.i) {
            this.v = this.t.l();
        } else {
            this.v = -1;
        }
        this.t.Z(this, z);
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z(String str, PrintWriter printWriter) {
        A(str, printWriter, true);
    }
}
