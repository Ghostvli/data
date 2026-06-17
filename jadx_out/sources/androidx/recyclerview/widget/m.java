package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public final RecyclerView.q a;
    public int b;
    public final Rect c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends m {
        public a(RecyclerView.q qVar) {
            super(qVar, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.a.u0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.r) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
            return this.a.t0(view) + ((ViewGroup.MarginLayoutParams) rVar).leftMargin + ((ViewGroup.MarginLayoutParams) rVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
            return this.a.s0(view) + ((ViewGroup.MarginLayoutParams) rVar).topMargin + ((ViewGroup.MarginLayoutParams) rVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.a.r0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.r) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.a.K0();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.a.K0() - this.a.p();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.a.p();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.a.L0();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.a.y0();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.a.y();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.a.K0() - this.a.y()) - this.a.p();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.a.J0(view, true, this.c);
            return this.c.right;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.a.J0(view, true, this.c);
            return this.c.left;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i) {
            this.a.a1(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends m {
        public b(RecyclerView.q qVar) {
            super(qVar, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.a.p0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.r) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
            return this.a.s0(view) + ((ViewGroup.MarginLayoutParams) rVar).topMargin + ((ViewGroup.MarginLayoutParams) rVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
            return this.a.t0(view) + ((ViewGroup.MarginLayoutParams) rVar).leftMargin + ((ViewGroup.MarginLayoutParams) rVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.a.v0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.r) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.a.x0();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.a.x0() - this.a.b();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.a.b();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.a.y0();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.a.L0();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.a.w();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.a.x0() - this.a.w()) - this.a.b();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.a.J0(view, true, this.c);
            return this.c.bottom;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.a.J0(view, true, this.c);
            return this.c.top;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i) {
            this.a.b1(i);
        }
    }

    public m(RecyclerView.q qVar) {
        this.b = Integer.MIN_VALUE;
        this.c = new Rect();
        this.a = qVar;
    }

    public static m a(RecyclerView.q qVar) {
        return new a(qVar);
    }

    public static m b(RecyclerView.q qVar, int i) {
        if (i == 0) {
            return a(qVar);
        }
        if (i == 1) {
            return c(qVar);
        }
        jl.a("invalid orientation");
        return null;
    }

    public static m c(RecyclerView.q qVar) {
        return new b(qVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return n() - this.b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public void s() {
        this.b = n();
    }

    public /* synthetic */ m(RecyclerView.q qVar, a aVar) {
        this(qVar);
    }
}
