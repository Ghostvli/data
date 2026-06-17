package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class n33 implements Iterator {
    public l33 f;
    public l33 g;
    public l33 h;
    public l33 i;
    public l33 j;
    public final Class k;

    public n33(l33 l33Var, Class cls) {
        zy4.j(l33Var);
        zy4.j(cls);
        this.k = cls;
        e(l33Var);
    }

    public final l33 b() {
        l33 l33VarL = this.h;
        do {
            if (l33VarL.l() > 0) {
                l33VarL = l33VarL.k(0);
            } else if (this.f.equals(l33VarL)) {
                l33VarL = null;
            } else if (l33VarL.B() != null) {
                l33VarL = l33VarL.B();
            } else {
                do {
                    l33VarL = l33VarL.L();
                    if (l33VarL == null || this.f.equals(l33VarL)) {
                        return null;
                    }
                } while (l33VarL.B() == null);
                l33VarL = l33VarL.B();
            }
            if (l33VarL == null) {
                return null;
            }
        } while (!this.k.isInstance(l33VarL));
        return l33VarL;
    }

    public final void c() {
        if (this.g != null) {
            return;
        }
        if (this.j != null && !this.h.y()) {
            this.h = this.i;
        }
        this.g = b();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public l33 next() {
        c();
        l33 l33Var = this.g;
        if (l33Var == null) {
            bo.a();
            return null;
        }
        this.i = this.h;
        this.h = l33Var;
        this.j = l33Var.L();
        this.g = null;
        return l33Var;
    }

    public void e(l33 l33Var) {
        if (this.k.isInstance(l33Var)) {
            this.g = l33Var;
        }
        this.h = l33Var;
        this.i = l33Var;
        this.f = l33Var;
        this.j = l33Var.L();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        c();
        return this.g != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.h.Q();
    }
}
