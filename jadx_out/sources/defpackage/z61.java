package defpackage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class z61 {
    public final ArrayList a = new ArrayList();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public n61 d;

    public void A(n61 n61Var) {
        this.d = n61Var;
    }

    public Bundle B(String str, Bundle bundle) {
        HashMap map = this.c;
        return bundle != null ? (Bundle) map.put(str, bundle) : (Bundle) map.remove(str);
    }

    public void a(p51 p51Var) {
        if (this.a.contains(p51Var)) {
            ho1.a("Fragment already added: ", p51Var);
            return;
        }
        synchronized (this.a) {
            this.a.add(p51Var);
        }
        p51Var.q = true;
    }

    public void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.b.get(str) != null;
    }

    public void d(int i) {
        for (w61 w61Var : this.b.values()) {
            if (w61Var != null) {
                w61Var.t(i);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (w61 w61Var : this.b.values()) {
                printWriter.print(str);
                if (w61Var != null) {
                    p51 p51VarK = w61Var.k();
                    printWriter.println(p51VarK);
                    p51VarK.I(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                p51 p51Var = (p51) this.a.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(p51Var.toString());
            }
        }
    }

    public p51 f(String str) {
        w61 w61Var = (w61) this.b.get(str);
        if (w61Var != null) {
            return w61Var.k();
        }
        return null;
    }

    public p51 g(int i) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            p51 p51Var = (p51) this.a.get(size);
            if (p51Var != null && p51Var.C == i) {
                return p51Var;
            }
        }
        for (w61 w61Var : this.b.values()) {
            if (w61Var != null) {
                p51 p51VarK = w61Var.k();
                if (p51VarK.C == i) {
                    return p51VarK;
                }
            }
        }
        return null;
    }

    public p51 h(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                p51 p51Var = (p51) this.a.get(size);
                if (p51Var != null && str.equals(p51Var.E)) {
                    return p51Var;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (w61 w61Var : this.b.values()) {
            if (w61Var != null) {
                p51 p51VarK = w61Var.k();
                if (str.equals(p51VarK.E)) {
                    return p51VarK;
                }
            }
        }
        return null;
    }

    public p51 i(String str) {
        p51 p51VarK;
        for (w61 w61Var : this.b.values()) {
            if (w61Var != null && (p51VarK = w61Var.k().K(str)) != null) {
                return p51VarK;
            }
        }
        return null;
    }

    public int j(p51 p51Var) {
        View view;
        View view2;
        ViewGroup viewGroup = p51Var.M;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.a.indexOf(p51Var);
        for (int i = iIndexOf - 1; i >= 0; i--) {
            p51 p51Var2 = (p51) this.a.get(i);
            if (p51Var2.M == viewGroup && (view2 = p51Var2.N) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.a.size()) {
                return -1;
            }
            p51 p51Var3 = (p51) this.a.get(iIndexOf);
            if (p51Var3.M == viewGroup && (view = p51Var3.N) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List k() {
        ArrayList arrayList = new ArrayList();
        for (w61 w61Var : this.b.values()) {
            if (w61Var != null) {
                arrayList.add(w61Var);
            }
        }
        return arrayList;
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (w61 w61Var : this.b.values()) {
            if (w61Var != null) {
                arrayList.add(w61Var.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public HashMap m() {
        return this.c;
    }

    public w61 n(String str) {
        return (w61) this.b.get(str);
    }

    public List o() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public n61 p() {
        return this.d;
    }

    public Bundle q(String str) {
        return (Bundle) this.c.get(str);
    }

    public void r(w61 w61Var) {
        p51 p51VarK = w61Var.k();
        if (c(p51VarK.k)) {
            return;
        }
        this.b.put(p51VarK.k, w61Var);
        if (p51VarK.I) {
            boolean z = p51VarK.H;
            n61 n61Var = this.d;
            if (z) {
                n61Var.e(p51VarK);
            } else {
                n61Var.o(p51VarK);
            }
            p51VarK.I = false;
        }
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + p51VarK);
        }
    }

    public void s(w61 w61Var) {
        p51 p51VarK = w61Var.k();
        if (p51VarK.H) {
            this.d.o(p51VarK);
        }
        if (this.b.get(p51VarK.k) == w61Var && ((w61) this.b.put(p51VarK.k, null)) != null && k61.K0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + p51VarK);
        }
    }

    public void t() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            w61 w61Var = (w61) this.b.get(((p51) it.next()).k);
            if (w61Var != null) {
                w61Var.m();
            }
        }
        for (w61 w61Var2 : this.b.values()) {
            if (w61Var2 != null) {
                w61Var2.m();
                p51 p51VarK = w61Var2.k();
                if (p51VarK.r && !p51VarK.J0()) {
                    if (p51VarK.s && !this.c.containsKey(p51VarK.k)) {
                        B(p51VarK.k, w61Var2.r());
                    }
                    s(w61Var2);
                }
            }
        }
    }

    public void u(p51 p51Var) {
        synchronized (this.a) {
            this.a.remove(p51Var);
        }
        p51Var.q = false;
    }

    public void v() {
        this.b.clear();
    }

    public void w(List list) {
        this.a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                p51 p51VarF = f(str);
                if (p51VarF == null) {
                    wx1.a("No instantiated fragment for (", str, ")");
                    return;
                }
                if (k61.K0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + p51VarF);
                }
                a(p51VarF);
            }
        }
    }

    public void x(HashMap map) {
        this.c.clear();
        this.c.putAll(map);
    }

    public ArrayList y() {
        ArrayList arrayList = new ArrayList(this.b.size());
        for (w61 w61Var : this.b.values()) {
            if (w61Var != null) {
                p51 p51VarK = w61Var.k();
                B(p51VarK.k, w61Var.r());
                arrayList.add(p51VarK.k);
                if (k61.K0(2)) {
                    Log.v("FragmentManager", "Saved state of " + p51VarK + ": " + p51VarK.g);
                }
            }
        }
        return arrayList;
    }

    public ArrayList z() {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.a.size());
                for (p51 p51Var : this.a) {
                    arrayList.add(p51Var.k);
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + p51Var.k + "): " + p51Var);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
