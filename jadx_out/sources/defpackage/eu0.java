package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fongmi.android.tv.bean.Episode;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.b;
import defpackage.au0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class eu0 extends nh {
    public au0.a A0;
    public wk0 B0;
    public List C0;
    public boolean D0;
    public int F0;
    public final List z0 = new ArrayList();
    public int E0 = 5;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends v61 {
        public a(p51 p51Var) {
            super(p51Var);
        }

        @Override // defpackage.v61
        public p51 I(int i) {
            return bu0.B2(eu0.this.E0, eu0.this.C0.subList(eu0.this.F0 * i, Math.min((i * eu0.this.F0) + eu0.this.F0, eu0.this.C0.size())));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int g() {
            return eu0.this.z0.size();
        }
    }

    public static eu0 a3() {
        return new eu0();
    }

    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        wk0 wk0VarC = wk0.c(layoutInflater, viewGroup, false);
        this.B0 = wk0VarC;
        return wk0VarC;
    }

    @Override // defpackage.nh
    public void N2() {
        T().p1("result", this, new p61() { // from class: du0
            @Override // defpackage.p61
            public final void a(String str, Bundle bundle) {
                this.a.c3(str, bundle);
            }
        });
    }

    @Override // defpackage.nh
    public void O2() {
        h3();
        i3();
        g3();
    }

    public eu0 b3(List list) {
        this.C0 = list;
        return this;
    }

    public final /* synthetic */ void c3(String str, Bundle bundle) {
        this.A0.E((Episode) bundle.getParcelable("episode"));
        w2();
    }

    public final /* synthetic */ void d3(TabLayout.g gVar, int i) {
        gVar.n((CharSequence) this.z0.get(i));
    }

    public eu0 e3(boolean z) {
        this.D0 = z;
        return this;
    }

    public final void f3() {
        for (int i = 0; i < this.C0.size(); i++) {
            if (((Episode) this.C0.get(i)).isActivated()) {
                this.B0.b.setCurrentItem(i / this.F0);
                return;
            }
        }
    }

    public final void g3() {
        this.B0.b.setAdapter(new a(this));
        wk0 wk0Var = this.B0;
        new b(wk0Var.c, wk0Var.b, new b.InterfaceC0067b() { // from class: cu0
            @Override // com.google.android.material.tabs.b.InterfaceC0067b
            public final void a(TabLayout.g gVar, int i) {
                this.a.d3(gVar, i);
            }
        }).a();
        f3();
    }

    public final void h3() {
        int i = vr3.r(X1()) ? 5 : 10;
        Iterator it = this.C0.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((Episode) it.next()).getName().length();
        }
        int iCeil = (int) Math.ceil(((double) length) / ((double) this.C0.size()));
        if (iCeil >= 12) {
            this.E0 = 1;
        } else if (iCeil >= 8) {
            this.E0 = 2;
        } else if (iCeil >= 4) {
            this.E0 = 3;
        } else if (iCeil >= 2) {
            this.E0 = 4;
        }
        this.F0 = this.E0 * i;
    }

    public final void i3() {
        if (this.D0) {
            int size = this.C0.size();
            while (size > 0) {
                this.z0.add(size + " - " + Math.max((size - this.F0) - 1, 1));
                size -= this.F0;
            }
            return;
        }
        int i = 0;
        while (i < this.C0.size()) {
            this.z0.add((i + 1) + " - " + Math.min(this.F0 + i, this.C0.size()));
            i += this.F0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j3(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof com.google.android.material.bottomsheet.b) {
                return;
            }
        }
        this.A0 = (au0.a) u51Var;
        G2(u51Var.n1(), null);
    }
}
