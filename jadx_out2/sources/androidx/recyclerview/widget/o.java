package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import defpackage.g2;
import defpackage.h2;
import defpackage.l35;
import defpackage.r1;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class o extends r1 {
    public final RecyclerView d;
    public final a e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends r1 {
        public final o d;
        public Map e = new WeakHashMap();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(o oVar) {
            this.d = oVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            r1 r1Var = (r1) this.e.get(view);
            return r1Var != null ? r1Var.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public h2 b(View view) {
            r1 r1Var = (r1) this.e.get(view);
            return r1Var != null ? r1Var.b(view) : super.b(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            r1 r1Var = (r1) this.e.get(view);
            if (r1Var != null) {
                r1Var.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public void g(View view, g2 g2Var) {
            if (this.d.o() || this.d.d.getLayoutManager() == null) {
                super.g(view, g2Var);
                return;
            }
            this.d.d.getLayoutManager().m1(view, g2Var);
            r1 r1Var = (r1) this.e.get(view);
            if (r1Var != null) {
                r1Var.g(view, g2Var);
            } else {
                super.g(view, g2Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            r1 r1Var = (r1) this.e.get(view);
            if (r1Var != null) {
                r1Var.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            r1 r1Var = (r1) this.e.get(viewGroup);
            return r1Var != null ? r1Var.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public boolean j(View view, int i, Bundle bundle) {
            if (this.d.o() || this.d.d.getLayoutManager() == null) {
                return super.j(view, i, bundle);
            }
            r1 r1Var = (r1) this.e.get(view);
            if (r1Var != null) {
                if (r1Var.j(view, i, bundle)) {
                    return true;
                }
            } else if (super.j(view, i, bundle)) {
                return true;
            }
            return this.d.d.getLayoutManager().G1(view, i, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public void l(View view, int i) {
            r1 r1Var = (r1) this.e.get(view);
            if (r1Var != null) {
                r1Var.l(view, i);
            } else {
                super.l(view, i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.r1
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            r1 r1Var = (r1) this.e.get(view);
            if (r1Var != null) {
                r1Var.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public r1 n(View view) {
            return (r1) this.e.remove(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void o(View view) {
            r1 r1VarK = l35.k(view);
            if (r1VarK == null || r1VarK == this) {
                return;
            }
            this.e.put(view, r1VarK);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o(RecyclerView recyclerView) {
        this.d = recyclerView;
        r1 r1VarN = n();
        if (r1VarN == null || !(r1VarN instanceof a)) {
            this.e = new a(this);
        } else {
            this.e = (a) r1VarN;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r1
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().i1(accessibilityEvent);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r1
    public void g(View view, g2 g2Var) {
        super.g(view, g2Var);
        if (o() || this.d.getLayoutManager() == null) {
            return;
        }
        this.d.getLayoutManager().k1(g2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r1
    public boolean j(View view, int i, Bundle bundle) {
        if (super.j(view, i, bundle)) {
            return true;
        }
        if (o() || this.d.getLayoutManager() == null) {
            return false;
        }
        return this.d.getLayoutManager().E1(i, bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r1 n() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean o() {
        return this.d.v0();
    }
}
