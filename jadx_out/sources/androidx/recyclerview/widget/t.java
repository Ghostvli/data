package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import defpackage.jl;
import defpackage.tf3;
import defpackage.uf3;
import defpackage.w02;
import defpackage.x64;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class t {
    public final x64 a = new x64();
    public final w02 b = new w02();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static tf3 d = new uf3(20);
        public int a;
        public RecyclerView.n.b b;
        public RecyclerView.n.b c;

        public static void a() {
            while (d.a() != null) {
            }
        }

        public static a b() {
            a aVar = (a) d.a();
            return aVar == null ? new a() : aVar;
        }

        public static void c(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.b(aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(RecyclerView.g0 g0Var);

        void b(RecyclerView.g0 g0Var, RecyclerView.n.b bVar, RecyclerView.n.b bVar2);

        void c(RecyclerView.g0 g0Var, RecyclerView.n.b bVar, RecyclerView.n.b bVar2);

        void d(RecyclerView.g0 g0Var, RecyclerView.n.b bVar, RecyclerView.n.b bVar2);
    }

    public void a(RecyclerView.g0 g0Var, RecyclerView.n.b bVar) {
        a aVarB = (a) this.a.get(g0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(g0Var, aVarB);
        }
        aVarB.a |= 2;
        aVarB.b = bVar;
    }

    public void b(RecyclerView.g0 g0Var) {
        a aVarB = (a) this.a.get(g0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(g0Var, aVarB);
        }
        aVarB.a |= 1;
    }

    public void c(long j, RecyclerView.g0 g0Var) {
        this.b.h(j, g0Var);
    }

    public void d(RecyclerView.g0 g0Var, RecyclerView.n.b bVar) {
        a aVarB = (a) this.a.get(g0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(g0Var, aVarB);
        }
        aVarB.c = bVar;
        aVarB.a |= 8;
    }

    public void e(RecyclerView.g0 g0Var, RecyclerView.n.b bVar) {
        a aVarB = (a) this.a.get(g0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(g0Var, aVarB);
        }
        aVarB.b = bVar;
        aVarB.a |= 4;
    }

    public void f() {
        this.a.clear();
        this.b.a();
    }

    public RecyclerView.g0 g(long j) {
        return (RecyclerView.g0) this.b.d(j);
    }

    public boolean h(RecyclerView.g0 g0Var) {
        a aVar = (a) this.a.get(g0Var);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.g0 g0Var) {
        a aVar = (a) this.a.get(g0Var);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.g0 g0Var) {
        p(g0Var);
    }

    public final RecyclerView.n.b l(RecyclerView.g0 g0Var, int i) {
        a aVar;
        RecyclerView.n.b bVar;
        int iD = this.a.d(g0Var);
        if (iD >= 0 && (aVar = (a) this.a.j(iD)) != null) {
            int i2 = aVar.a;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                aVar.a = i3;
                if (i == 4) {
                    bVar = aVar.b;
                } else if (i == 8) {
                    bVar = aVar.c;
                } else {
                    jl.a("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    this.a.h(iD);
                    a.c(aVar);
                }
                return bVar;
            }
        }
        return null;
    }

    public RecyclerView.n.b m(RecyclerView.g0 g0Var) {
        return l(g0Var, 8);
    }

    public RecyclerView.n.b n(RecyclerView.g0 g0Var) {
        return l(g0Var, 4);
    }

    public void o(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.g0 g0Var = (RecyclerView.g0) this.a.f(size);
            a aVar = (a) this.a.h(size);
            int i = aVar.a;
            if ((i & 3) == 3) {
                bVar.a(g0Var);
            } else if ((i & 1) != 0) {
                RecyclerView.n.b bVar2 = aVar.b;
                if (bVar2 == null) {
                    bVar.a(g0Var);
                } else {
                    bVar.c(g0Var, bVar2, aVar.c);
                }
            } else if ((i & 14) == 14) {
                bVar.b(g0Var, aVar.b, aVar.c);
            } else if ((i & 12) == 12) {
                bVar.d(g0Var, aVar.b, aVar.c);
            } else if ((i & 4) != 0) {
                bVar.c(g0Var, aVar.b, null);
            } else if ((i & 8) != 0) {
                bVar.b(g0Var, aVar.b, aVar.c);
            }
            a.c(aVar);
        }
    }

    public void p(RecyclerView.g0 g0Var) {
        a aVar = (a) this.a.get(g0Var);
        if (aVar == null) {
            return;
        }
        aVar.a &= -2;
    }

    public void q(RecyclerView.g0 g0Var) {
        int iK = this.b.k() - 1;
        while (true) {
            if (iK < 0) {
                break;
            }
            if (g0Var == this.b.l(iK)) {
                this.b.j(iK);
                break;
            }
            iK--;
        }
        a aVar = (a) this.a.remove(g0Var);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
