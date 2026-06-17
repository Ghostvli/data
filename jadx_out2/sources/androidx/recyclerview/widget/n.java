package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends r {
    public m d;
    public m e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends k {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Context context) {
            super(context);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.RecyclerView.b0
        public void o(View view, RecyclerView.c0 c0Var, RecyclerView.b0.a aVar) {
            n nVar = n.this;
            int[] iArrC = nVar.c(nVar.a.getLayoutManager(), view);
            int i = iArrC[0];
            int i2 = iArrC[1];
            int iW = w(Math.max(Math.abs(i), Math.abs(i2)));
            if (iW > 0) {
                aVar.d(i, i2, iW, this.j);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.k
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.k
        public int x(int i) {
            return Math.min(100, super.x(i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.r
    public int[] c(RecyclerView.q qVar, View view) {
        int[] iArr = new int[2];
        if (qVar.L()) {
            iArr[0] = k(view, m(qVar));
        } else {
            iArr[0] = 0;
        }
        if (qVar.M()) {
            iArr[1] = k(view, o(qVar));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.r
    public RecyclerView.b0 d(RecyclerView.q qVar) {
        if (qVar instanceof RecyclerView.b0.b) {
            return new a(this.a.getContext());
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.r
    public View f(RecyclerView.q qVar) {
        if (qVar.M()) {
            return l(qVar, o(qVar));
        }
        if (qVar.L()) {
            return l(qVar, m(qVar));
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.r
    public int g(RecyclerView.q qVar, int i, int i2) {
        m mVarN;
        int iV = qVar.v();
        if (iV == 0 || (mVarN = n(qVar)) == null) {
            return -1;
        }
        int iK0 = qVar.k0();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < iK0; i5++) {
            View viewJ0 = qVar.j0(i5);
            if (viewJ0 != null) {
                int iK = k(viewJ0, mVarN);
                if (iK <= 0 && iK > i4) {
                    view2 = viewJ0;
                    i4 = iK;
                }
                if (iK >= 0 && iK < i3) {
                    view = viewJ0;
                    i3 = iK;
                }
            }
        }
        boolean zP = p(qVar, i, i2);
        if (zP && view != null) {
            return qVar.D0(view);
        }
        if (!zP && view2 != null) {
            return qVar.D0(view2);
        }
        if (zP) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iD0 = qVar.D0(view) + (q(qVar) == zP ? -1 : 1);
        if (iD0 < 0 || iD0 >= iV) {
            return -1;
        }
        return iD0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int k(View view, m mVar) {
        return (mVar.g(view) + (mVar.e(view) / 2)) - (mVar.m() + (mVar.n() / 2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final View l(RecyclerView.q qVar, m mVar) {
        int iK0 = qVar.k0();
        View view = null;
        if (iK0 == 0) {
            return null;
        }
        int iM = mVar.m() + (mVar.n() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iK0; i2++) {
            View viewJ0 = qVar.j0(i2);
            int iAbs = Math.abs((mVar.g(viewJ0) + (mVar.e(viewJ0) / 2)) - iM);
            if (iAbs < i) {
                view = viewJ0;
                i = iAbs;
            }
        }
        return view;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final m m(RecyclerView.q qVar) {
        m mVar = this.e;
        if (mVar == null || mVar.a != qVar) {
            this.e = m.a(qVar);
        }
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final m n(RecyclerView.q qVar) {
        if (qVar.M()) {
            return o(qVar);
        }
        if (qVar.L()) {
            return m(qVar);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final m o(RecyclerView.q qVar) {
        m mVar = this.d;
        if (mVar == null || mVar.a != qVar) {
            this.d = m.c(qVar);
        }
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p(RecyclerView.q qVar, int i, int i2) {
        return qVar.L() ? i > 0 : i2 > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: androidx.recyclerview.widget.RecyclerView$q */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean q(RecyclerView.q qVar) {
        PointF pointFF;
        int iV = qVar.v();
        if (!(qVar instanceof RecyclerView.b0.b) || (pointFF = ((RecyclerView.b0.b) qVar).f(iV - 1)) == null) {
            return false;
        }
        return pointFF.x < 0.0f || pointFF.y < 0.0f;
    }
}
