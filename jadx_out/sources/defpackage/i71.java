package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ss4;
import defpackage.wp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i71 extends g71 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ss4.f {
        public final /* synthetic */ Rect a;

        public a(Rect rect) {
            this.a = rect;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements ss4.g {
        public final /* synthetic */ View a;
        public final /* synthetic */ ArrayList b;

        public b(View view, ArrayList arrayList) {
            this.a = view;
            this.b = arrayList;
        }

        @Override // ss4.g
        public void a(ss4 ss4Var) {
            ss4Var.T(this);
            ss4Var.a(this);
        }

        @Override // ss4.g
        public void b(ss4 ss4Var) {
        }

        @Override // ss4.g
        public void c(ss4 ss4Var) {
            ss4Var.T(this);
            this.a.setVisibility(8);
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.b.get(i)).setVisibility(0);
            }
        }

        @Override // ss4.g
        public void e(ss4 ss4Var) {
        }

        @Override // ss4.g
        public void g(ss4 ss4Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends at4 {
        public final /* synthetic */ Object a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ ArrayList f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.b = arrayList;
            this.c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // defpackage.at4, ss4.g
        public void a(ss4 ss4Var) {
            Object obj = this.a;
            if (obj != null) {
                i71.this.x(obj, this.b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                i71.this.x(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                i71.this.x(obj3, this.f, null);
            }
        }

        @Override // ss4.g
        public void c(ss4 ss4Var) {
            ss4Var.T(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements ss4.g {
        public final /* synthetic */ Runnable a;

        public d(Runnable runnable) {
            this.a = runnable;
        }

        @Override // ss4.g
        public void a(ss4 ss4Var) {
        }

        @Override // ss4.g
        public void b(ss4 ss4Var) {
        }

        @Override // ss4.g
        public void c(ss4 ss4Var) {
            this.a.run();
        }

        @Override // ss4.g
        public void e(ss4 ss4Var) {
        }

        @Override // ss4.g
        public void g(ss4 ss4Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends ss4.f {
        public final /* synthetic */ Rect a;

        public e(Rect rect) {
            this.a = rect;
        }
    }

    public static /* synthetic */ void v(Runnable runnable, ss4 ss4Var, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        } else {
            ss4Var.cancel();
            runnable2.run();
        }
    }

    public static boolean w(ss4 ss4Var) {
        return (g71.i(ss4Var.B()) && g71.i(ss4Var.C()) && g71.i(ss4Var.D())) ? false : true;
    }

    @Override // defpackage.g71
    public void a(Object obj, View view) {
        if (obj != null) {
            ((ss4) obj).b(view);
        }
    }

    @Override // defpackage.g71
    public void b(Object obj, ArrayList arrayList) {
        ss4 ss4Var = (ss4) obj;
        if (ss4Var == null) {
            return;
        }
        int i = 0;
        if (ss4Var instanceof et4) {
            et4 et4Var = (et4) ss4Var;
            int iL0 = et4Var.l0();
            while (i < iL0) {
                b(et4Var.k0(i), arrayList);
                i++;
            }
            return;
        }
        if (w(ss4Var) || !g71.i(ss4Var.E())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            ss4Var.b((View) arrayList.get(i));
            i++;
        }
    }

    @Override // defpackage.g71
    public void c(ViewGroup viewGroup, Object obj) {
        bt4.a(viewGroup, (ss4) obj);
    }

    @Override // defpackage.g71
    public boolean e(Object obj) {
        return obj instanceof ss4;
    }

    @Override // defpackage.g71
    public Object f(Object obj) {
        if (obj != null) {
            return ((ss4) obj).clone();
        }
        return null;
    }

    @Override // defpackage.g71
    public Object j(Object obj, Object obj2, Object obj3) {
        ss4 ss4VarQ0 = (ss4) obj;
        ss4 ss4Var = (ss4) obj2;
        ss4 ss4Var2 = (ss4) obj3;
        if (ss4VarQ0 != null && ss4Var != null) {
            ss4VarQ0 = new et4().i0(ss4VarQ0).i0(ss4Var).q0(1);
        } else if (ss4VarQ0 == null) {
            ss4VarQ0 = ss4Var != null ? ss4Var : null;
        }
        if (ss4Var2 == null) {
            return ss4VarQ0;
        }
        et4 et4Var = new et4();
        if (ss4VarQ0 != null) {
            et4Var.i0(ss4VarQ0);
        }
        et4Var.i0(ss4Var2);
        return et4Var;
    }

    @Override // defpackage.g71
    public Object k(Object obj, Object obj2, Object obj3) {
        et4 et4Var = new et4();
        if (obj != null) {
            et4Var.i0((ss4) obj);
        }
        if (obj2 != null) {
            et4Var.i0((ss4) obj2);
        }
        if (obj3 != null) {
            et4Var.i0((ss4) obj3);
        }
        return et4Var;
    }

    @Override // defpackage.g71
    public void m(Object obj, View view, ArrayList arrayList) {
        ((ss4) obj).a(new b(view, arrayList));
    }

    @Override // defpackage.g71
    public void n(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((ss4) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // defpackage.g71
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((ss4) obj).Z(new e(rect));
        }
    }

    @Override // defpackage.g71
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((ss4) obj).Z(new a(rect));
        }
    }

    @Override // defpackage.g71
    public void q(p51 p51Var, Object obj, wp wpVar, Runnable runnable) {
        y(p51Var, obj, wpVar, null, runnable);
    }

    @Override // defpackage.g71
    public void s(Object obj, View view, ArrayList arrayList) {
        et4 et4Var = (et4) obj;
        List listE = et4Var.E();
        listE.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            g71.d(listE, (View) arrayList.get(i));
        }
        listE.add(view);
        arrayList.add(view);
        b(et4Var, arrayList);
    }

    @Override // defpackage.g71
    public void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        et4 et4Var = (et4) obj;
        if (et4Var != null) {
            et4Var.E().clear();
            et4Var.E().addAll(arrayList2);
            x(et4Var, arrayList, arrayList2);
        }
    }

    @Override // defpackage.g71
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        et4 et4Var = new et4();
        et4Var.i0((ss4) obj);
        return et4Var;
    }

    public void x(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        ss4 ss4Var = (ss4) obj;
        int i = 0;
        if (ss4Var instanceof et4) {
            et4 et4Var = (et4) ss4Var;
            int iL0 = et4Var.l0();
            while (i < iL0) {
                x(et4Var.k0(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (w(ss4Var)) {
            return;
        }
        List listE = ss4Var.E();
        if (listE.size() == arrayList.size() && listE.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                ss4Var.b((View) arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ss4Var.U((View) arrayList.get(size2));
            }
        }
    }

    public void y(p51 p51Var, Object obj, wp wpVar, final Runnable runnable, final Runnable runnable2) {
        final ss4 ss4Var = (ss4) obj;
        wpVar.c(new wp.a() { // from class: h71
            @Override // wp.a
            public final void onCancel() {
                i71.v(runnable, ss4Var, runnable2);
            }
        });
        ss4Var.a(new d(runnable2));
    }
}
