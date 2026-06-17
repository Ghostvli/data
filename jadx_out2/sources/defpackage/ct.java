package defpackage;

import android.view.View;
import android.view.ViewGroup;
import defpackage.g62;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ct {
    public final Map a = new HashMap();
    public final Set b = new HashSet();
    public b c;
    public boolean d;
    public boolean e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements g62.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;Z)V */
        @Override // g62.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g62 g62Var, boolean z) {
            ct ctVar = ct.this;
            if (z) {
                if (!ctVar.g(g62Var)) {
                    return;
                }
            } else if (!ctVar.r(g62Var, ctVar.e)) {
                return;
            }
            ct.this.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(Set set);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(g62 g62Var) {
        this.a.put(Integer.valueOf(g62Var.getId()), g62Var);
        if (g62Var.isChecked()) {
            g(g62Var);
        }
        g62Var.setInternalOnCheckedChangeListener(new a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(int i) {
        g62 g62Var = (g62) this.a.get(Integer.valueOf(i));
        if (g62Var != null && g(g62Var)) {
            m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean g(g62 g62Var) {
        int id = g62Var.getId();
        if (this.b.contains(Integer.valueOf(id))) {
            return false;
        }
        g62 g62Var2 = (g62) this.a.get(Integer.valueOf(k()));
        if (g62Var2 != null) {
            r(g62Var2, false);
        }
        boolean zAdd = this.b.add(Integer.valueOf(id));
        if (!g62Var.isChecked()) {
            g62Var.setChecked(true);
        }
        return zAdd;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        boolean zIsEmpty = this.b.isEmpty();
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            r((g62) it.next(), false);
        }
        if (zIsEmpty) {
            return;
        }
        m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set i() {
        return new HashSet(this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List j(ViewGroup viewGroup) {
        Set setI = i();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof g62) && setI.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int k() {
        if (!this.d || this.b.isEmpty()) {
            return -1;
        }
        return ((Integer) this.b.iterator().next()).intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean l() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n(g62 g62Var) {
        g62Var.setInternalOnCheckedChangeListener(null);
        this.a.remove(Integer.valueOf(g62Var.getId()));
        this.b.remove(Integer.valueOf(g62Var.getId()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(b bVar) {
        this.c = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(boolean z) {
        this.e = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(boolean z) {
        if (this.d != z) {
            this.d = z;
            h();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean r(g62 g62Var, boolean z) {
        int id = g62Var.getId();
        if (!this.b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && this.b.size() == 1 && this.b.contains(Integer.valueOf(id))) {
            g62Var.setChecked(true);
            return false;
        }
        boolean zRemove = this.b.remove(Integer.valueOf(id));
        if (g62Var.isChecked()) {
            g62Var.setChecked(false);
        }
        return zRemove;
    }
}
