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

    public pf(k61 k61Var) {
        super(k61Var.v0(), k61Var.x0() != null ? k61Var.x0().f().getClassLoader() : null);
        this.v = -1;
        this.w = false;
        this.t = k61Var;
    }

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

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.p51 D(java.util.ArrayList r17, defpackage.p51 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList r5 = r0.c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList r5 = r0.c
            java.lang.Object r5 = r5.get(r4)
            d71$a r5 = (d71.a) r5
            int r6 = r5.a
            r7 = 1
            if (r6 == r7) goto Lb6
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L5a
            if (r6 == r10) goto L43
            r8 = 6
            if (r6 == r8) goto L43
            r8 = 7
            if (r6 == r8) goto Lb6
            r8 = 8
            if (r6 == r8) goto L31
            goto Lbb
        L31:
            java.util.ArrayList r6 = r0.c
            d71$a r8 = new d71$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.c = r7
            int r4 = r4 + 1
            p51 r3 = r5.b
            goto Lbb
        L43:
            p51 r6 = r5.b
            r1.remove(r6)
            p51 r5 = r5.b
            if (r5 != r3) goto Lbb
            java.util.ArrayList r3 = r0.c
            d71$a r6 = new d71$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            p51 r6 = r5.b
            int r8 = r6.D
            int r12 = r1.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            p51 r14 = (defpackage.p51) r14
            int r15 = r14.D
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = r7
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList r3 = r0.c
            d71$a r15 = new d71$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            d71$a r15 = new d71$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.d
            r15.d = r2
            int r2 = r5.f
            r15.f = r2
            int r2 = r5.e
            r15.e = r2
            int r2 = r5.g
            r15.g = r2
            java.util.ArrayList r2 = r0.c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList r2 = r0.c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.a = r7
            r5.c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            p51 r2 = r5.b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pf.D(java.util.ArrayList, p51):p51");
    }

    public String E() {
        return this.k;
    }

    public void F() {
        if (this.s != null) {
            for (int i = 0; i < this.s.size(); i++) {
                ((Runnable) this.s.get(i)).run();
            }
            this.s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.p51 G(java.util.ArrayList r6, defpackage.p51 r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList r2 = r5.c
            java.lang.Object r2 = r2.get(r0)
            d71$a r2 = (d71.a) r2
            int r3 = r2.a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.g$b r3 = r2.h
            r2.i = r3
            goto L32
        L22:
            p51 r7 = r2.b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            p51 r2 = r2.b
            r6.add(r2)
            goto L32
        L2d:
            p51 r2 = r2.b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pf.G(java.util.ArrayList, p51):p51");
    }

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

    @Override // defpackage.d71
    public int h() {
        return y(false);
    }

    @Override // defpackage.d71
    public int i() {
        return y(true);
    }

    @Override // defpackage.d71
    public void j() {
        l();
        this.t.c0(this, false);
    }

    @Override // defpackage.d71
    public void k() {
        l();
        this.t.c0(this, true);
    }

    @Override // defpackage.d71
    public void m(int i, p51 p51Var, String str, int i2) {
        super.m(i, p51Var, str, i2);
        p51Var.y = this.t;
    }

    @Override // defpackage.d71
    public d71 n(p51 p51Var) {
        k61 k61Var = p51Var.y;
        if (k61Var == null || k61Var == this.t) {
            return super.n(p51Var);
        }
        of.a("Cannot hide Fragment attached to a different FragmentManager. Fragment ", p51Var);
        return null;
    }

    @Override // defpackage.d71
    public boolean o() {
        return this.c.isEmpty();
    }

    @Override // defpackage.d71
    public d71 p(p51 p51Var) {
        k61 k61Var = p51Var.y;
        if (k61Var == null || k61Var == this.t) {
            return super.p(p51Var);
        }
        of.a("Cannot remove Fragment attached to a different FragmentManager. Fragment ", p51Var);
        return null;
    }

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

    @Override // defpackage.d71
    public d71 t(p51 p51Var) {
        k61 k61Var;
        if (p51Var == null || (k61Var = p51Var.y) == null || k61Var == this.t) {
            return super.t(p51Var);
        }
        of.a("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ", p51Var);
        return null;
    }

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

    @Override // defpackage.d71
    public d71 w(p51 p51Var) {
        k61 k61Var = p51Var.y;
        if (k61Var == null || k61Var == this.t) {
            return super.w(p51Var);
        }
        of.a("Cannot show Fragment attached to a different FragmentManager. Fragment ", p51Var);
        return null;
    }

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

    public void z(String str, PrintWriter printWriter) {
        A(str, printWriter, true);
    }
}
