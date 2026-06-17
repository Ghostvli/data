package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.g;
import defpackage.p51;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y61 extends f73 {
    public final k61 c;
    public final int d;
    public d71 e;
    public ArrayList f;
    public ArrayList g;
    public p51 h;
    public boolean i;

    public y61(k61 k61Var, int i) {
        this.e = null;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = null;
        this.c = k61Var;
        this.d = i;
    }

    @Override // defpackage.f73
    public void b(ViewGroup viewGroup) {
        d71 d71Var = this.e;
        if (d71Var != null) {
            if (!this.i) {
                try {
                    this.i = true;
                    d71Var.k();
                } finally {
                    this.i = false;
                }
            }
            this.e = null;
        }
    }

    @Override // defpackage.f73
    public Object g(ViewGroup viewGroup, int i) {
        p51.n nVar;
        p51 p51Var;
        if (this.g.size() > i && (p51Var = (p51) this.g.get(i)) != null) {
            return p51Var;
        }
        if (this.e == null) {
            this.e = this.c.o();
        }
        p51 p51VarQ = q(i);
        if (this.f.size() > i && (nVar = (p51.n) this.f.get(i)) != null) {
            p51VarQ.g2(nVar);
        }
        while (this.g.size() <= i) {
            this.g.add(null);
        }
        p51VarQ.h2(false);
        if (this.d == 0) {
            p51VarQ.m2(false);
        }
        this.g.set(i, p51VarQ);
        this.e.b(viewGroup.getId(), p51VarQ);
        if (this.d == 1) {
            this.e.s(p51VarQ, g.b.i);
        }
        return p51VarQ;
    }

    @Override // defpackage.f73
    public boolean h(View view, Object obj) {
        return ((p51) obj).B0() == view;
    }

    @Override // defpackage.f73
    public void k(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f.clear();
            this.g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f.add((p51.n) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    p51 p51VarT0 = this.c.t0(bundle, str);
                    if (p51VarT0 != null) {
                        while (this.g.size() <= i) {
                            this.g.add(null);
                        }
                        p51VarT0.h2(false);
                        this.g.set(i, p51VarT0);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key ".concat(str));
                    }
                }
            }
        }
    }

    @Override // defpackage.f73
    public Parcelable l() {
        Bundle bundle;
        if (this.f.size() > 0) {
            bundle = new Bundle();
            p51.n[] nVarArr = new p51.n[this.f.size()];
            this.f.toArray(nVarArr);
            bundle.putParcelableArray("states", nVarArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.g.size(); i++) {
            p51 p51Var = (p51) this.g.get(i);
            if (p51Var != null && p51Var.H0()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.c.d1(bundle, "f" + i, p51Var);
            }
        }
        return bundle;
    }

    @Override // defpackage.f73
    public void m(ViewGroup viewGroup, int i, Object obj) {
        p51 p51Var = (p51) obj;
        p51 p51Var2 = this.h;
        if (p51Var != p51Var2) {
            if (p51Var2 != null) {
                p51Var2.h2(false);
                if (this.d == 1) {
                    if (this.e == null) {
                        this.e = this.c.o();
                    }
                    this.e.s(this.h, g.b.i);
                } else {
                    this.h.m2(false);
                }
            }
            p51Var.h2(true);
            if (this.d == 1) {
                if (this.e == null) {
                    this.e = this.c.o();
                }
                this.e.s(p51Var, g.b.j);
            } else {
                p51Var.m2(true);
            }
            this.h = p51Var;
        }
    }

    @Override // defpackage.f73
    public void o(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        wx1.a("ViewPager with adapter ", this, " requires a view id");
    }

    public abstract p51 q(int i);

    public y61(k61 k61Var) {
        this(k61Var, 0);
    }
}
