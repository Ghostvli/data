package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q extends RecyclerView.n {
    public boolean g = true;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(RecyclerView.g0 g0Var) {
        I(g0Var);
        h(g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B(RecyclerView.g0 g0Var) {
        J(g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(RecyclerView.g0 g0Var, boolean z) {
        K(g0Var, z);
        h(g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(RecyclerView.g0 g0Var, boolean z) {
        L(g0Var, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(RecyclerView.g0 g0Var) {
        M(g0Var);
        h(g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(RecyclerView.g0 g0Var) {
        N(g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G(RecyclerView.g0 g0Var) {
        O(g0Var);
        h(g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(RecyclerView.g0 g0Var) {
        P(g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(RecyclerView.g0 g0Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J(RecyclerView.g0 g0Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K(RecyclerView.g0 g0Var, boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L(RecyclerView.g0 g0Var, boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M(RecyclerView.g0 g0Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N(RecyclerView.g0 g0Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(RecyclerView.g0 g0Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P(RecyclerView.g0 g0Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean a(RecyclerView.g0 g0Var, RecyclerView.n.b bVar, RecyclerView.n.b bVar2) {
        int i;
        int i2;
        return (bVar == null || ((i = bVar.a) == (i2 = bVar2.a) && bVar.b == bVar2.b)) ? w(g0Var) : y(g0Var, i, bVar.b, i2, bVar2.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b(RecyclerView.g0 g0Var, RecyclerView.g0 g0Var2, RecyclerView.n.b bVar, RecyclerView.n.b bVar2) {
        int i;
        int i2 = bVar.a;
        int i3 = bVar.b;
        if (g0Var2.K()) {
            i = bVar.a;
        } else {
            i = bVar2.a;
            bVar = bVar2;
        }
        return x(g0Var, g0Var2, i2, i3, i, bVar.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c(RecyclerView.g0 g0Var, RecyclerView.n.b bVar, RecyclerView.n.b bVar2) {
        int i = bVar.a;
        int i2 = bVar.b;
        View view = g0Var.f;
        int left = bVar2 == null ? view.getLeft() : bVar2.a;
        int top = bVar2 == null ? view.getTop() : bVar2.b;
        if (g0Var.w() || (i == left && i2 == top)) {
            return z(g0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return y(g0Var, i, i2, left, top);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean d(RecyclerView.g0 g0Var, RecyclerView.n.b bVar, RecyclerView.n.b bVar2) {
        int i = bVar.a;
        int i2 = bVar2.a;
        if (i != i2 || bVar.b != bVar2.b) {
            return y(g0Var, i, bVar.b, i2, bVar2.b);
        }
        E(g0Var);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean f(RecyclerView.g0 g0Var) {
        return !this.g || g0Var.u();
    }

    public abstract boolean w(RecyclerView.g0 g0Var);

    public abstract boolean x(RecyclerView.g0 g0Var, RecyclerView.g0 g0Var2, int i, int i2, int i3, int i4);

    public abstract boolean y(RecyclerView.g0 g0Var, int i, int i2, int i3, int i4);

    public abstract boolean z(RecyclerView.g0 g0Var);
}
