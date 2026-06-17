package defpackage;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ss4;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class et4 extends ss4 {
    public int T;
    public ArrayList R = new ArrayList();
    public boolean S = true;
    public boolean U = false;
    public int V = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends at4 {
        public final /* synthetic */ ss4 a;

        public a(ss4 ss4Var) {
            this.a = ss4Var;
        }

        @Override // ss4.g
        public void c(ss4 ss4Var) {
            this.a.X();
            ss4Var.T(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends at4 {
        public et4 a;

        public b(et4 et4Var) {
            this.a = et4Var;
        }

        @Override // defpackage.at4, ss4.g
        public void a(ss4 ss4Var) {
            et4 et4Var = this.a;
            if (et4Var.U) {
                return;
            }
            et4Var.e0();
            this.a.U = true;
        }

        @Override // ss4.g
        public void c(ss4 ss4Var) {
            et4 et4Var = this.a;
            int i = et4Var.T - 1;
            et4Var.T = i;
            if (i == 0) {
                et4Var.U = false;
                et4Var.o();
            }
            ss4Var.T(this);
        }
    }

    @Override // defpackage.ss4
    public void R(View view) {
        super.R(view);
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((ss4) this.R.get(i)).R(view);
        }
    }

    @Override // defpackage.ss4
    public void V(View view) {
        super.V(view);
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((ss4) this.R.get(i)).V(view);
        }
    }

    @Override // defpackage.ss4
    public void X() {
        ArrayList arrayList;
        if (this.R.isEmpty()) {
            e0();
            o();
            return;
        }
        s0();
        if (this.S) {
            Iterator it = this.R.iterator();
            while (it.hasNext()) {
                ((ss4) it.next()).X();
            }
            return;
        }
        int i = 1;
        while (true) {
            int size = this.R.size();
            arrayList = this.R;
            if (i >= size) {
                break;
            }
            ((ss4) arrayList.get(i - 1)).a(new a((ss4) this.R.get(i)));
            i++;
        }
        ss4 ss4Var = (ss4) arrayList.get(0);
        if (ss4Var != null) {
            ss4Var.X();
        }
    }

    @Override // defpackage.ss4
    public void Z(ss4.f fVar) {
        super.Z(fVar);
        this.V |= 8;
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((ss4) this.R.get(i)).Z(fVar);
        }
    }

    @Override // defpackage.ss4
    public void b0(k93 k93Var) {
        super.b0(k93Var);
        this.V |= 4;
        if (this.R != null) {
            for (int i = 0; i < this.R.size(); i++) {
                ((ss4) this.R.get(i)).b0(k93Var);
            }
        }
    }

    @Override // defpackage.ss4
    public void c0(dt4 dt4Var) {
        super.c0(dt4Var);
        this.V |= 2;
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((ss4) this.R.get(i)).c0(dt4Var);
        }
    }

    @Override // defpackage.ss4
    public void cancel() {
        super.cancel();
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((ss4) this.R.get(i)).cancel();
        }
    }

    @Override // defpackage.ss4
    public void f(gt4 gt4Var) {
        if (I(gt4Var.b)) {
            for (ss4 ss4Var : this.R) {
                if (ss4Var.I(gt4Var.b)) {
                    ss4Var.f(gt4Var);
                    gt4Var.c.add(ss4Var);
                }
            }
        }
    }

    @Override // defpackage.ss4
    public String f0(String str) {
        String strF0 = super.f0(str);
        for (int i = 0; i < this.R.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strF0);
            sb.append("\n");
            sb.append(((ss4) this.R.get(i)).f0(str + "  "));
            strF0 = sb.toString();
        }
        return strF0;
    }

    @Override // defpackage.ss4
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public et4 a(ss4.g gVar) {
        return (et4) super.a(gVar);
    }

    @Override // defpackage.ss4
    public void h(gt4 gt4Var) {
        super.h(gt4Var);
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((ss4) this.R.get(i)).h(gt4Var);
        }
    }

    @Override // defpackage.ss4
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public et4 b(View view) {
        for (int i = 0; i < this.R.size(); i++) {
            ((ss4) this.R.get(i)).b(view);
        }
        return (et4) super.b(view);
    }

    @Override // defpackage.ss4
    public void i(gt4 gt4Var) {
        if (I(gt4Var.b)) {
            for (ss4 ss4Var : this.R) {
                if (ss4Var.I(gt4Var.b)) {
                    ss4Var.i(gt4Var);
                    gt4Var.c.add(ss4Var);
                }
            }
        }
    }

    public et4 i0(ss4 ss4Var) {
        j0(ss4Var);
        long j = this.h;
        if (j >= 0) {
            ss4Var.Y(j);
        }
        if ((this.V & 1) != 0) {
            ss4Var.a0(t());
        }
        if ((this.V & 2) != 0) {
            x();
            ss4Var.c0(null);
        }
        if ((this.V & 4) != 0) {
            ss4Var.b0(w());
        }
        if ((this.V & 8) != 0) {
            ss4Var.Z(s());
        }
        return this;
    }

    public final void j0(ss4 ss4Var) {
        this.R.add(ss4Var);
        ss4Var.w = this;
    }

    public ss4 k0(int i) {
        if (i < 0 || i >= this.R.size()) {
            return null;
        }
        return (ss4) this.R.get(i);
    }

    @Override // defpackage.ss4
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public ss4 clone() {
        et4 et4Var = (et4) super.clone();
        et4Var.R = new ArrayList();
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            et4Var.j0(((ss4) this.R.get(i)).clone());
        }
        return et4Var;
    }

    public int l0() {
        return this.R.size();
    }

    @Override // defpackage.ss4
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public et4 T(ss4.g gVar) {
        return (et4) super.T(gVar);
    }

    @Override // defpackage.ss4
    public void n(ViewGroup viewGroup, ht4 ht4Var, ht4 ht4Var2, ArrayList arrayList, ArrayList arrayList2) {
        long jA = A();
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ss4 ss4Var = (ss4) this.R.get(i);
            if (jA > 0 && (this.S || i == 0)) {
                long jA2 = ss4Var.A();
                if (jA2 > 0) {
                    ss4Var.d0(jA2 + jA);
                } else {
                    ss4Var.d0(jA);
                }
            }
            ss4Var.n(viewGroup, ht4Var, ht4Var2, arrayList, arrayList2);
        }
    }

    @Override // defpackage.ss4
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public et4 U(View view) {
        for (int i = 0; i < this.R.size(); i++) {
            ((ss4) this.R.get(i)).U(view);
        }
        return (et4) super.U(view);
    }

    @Override // defpackage.ss4
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public et4 Y(long j) {
        ArrayList arrayList;
        super.Y(j);
        if (this.h >= 0 && (arrayList = this.R) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((ss4) this.R.get(i)).Y(j);
            }
        }
        return this;
    }

    @Override // defpackage.ss4
    public ss4 p(Class cls, boolean z) {
        for (int i = 0; i < this.R.size(); i++) {
            ((ss4) this.R.get(i)).p(cls, z);
        }
        return super.p(cls, z);
    }

    @Override // defpackage.ss4
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public et4 a0(TimeInterpolator timeInterpolator) {
        this.V |= 1;
        ArrayList arrayList = this.R;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((ss4) this.R.get(i)).a0(timeInterpolator);
            }
        }
        return (et4) super.a0(timeInterpolator);
    }

    public et4 q0(int i) {
        if (i == 0) {
            this.S = true;
            return this;
        }
        if (i == 1) {
            this.S = false;
            return this;
        }
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
    }

    @Override // defpackage.ss4
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public et4 d0(long j) {
        return (et4) super.d0(j);
    }

    public final void s0() {
        b bVar = new b(this);
        Iterator it = this.R.iterator();
        while (it.hasNext()) {
            ((ss4) it.next()).a(bVar);
        }
        this.T = this.R.size();
    }
}
