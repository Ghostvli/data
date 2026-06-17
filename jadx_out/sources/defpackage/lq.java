package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lq {
    public final int a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends lq {
        public final /* synthetic */ CarouselLayoutManager b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, CarouselLayoutManager carouselLayoutManager) {
            super(i, null);
            this.b = carouselLayoutManager;
        }

        @Override // defpackage.lq
        public int d() {
            return this.b.x0();
        }

        @Override // defpackage.lq
        public int e() {
            return this.b.y();
        }

        @Override // defpackage.lq
        public int f() {
            return this.b.K0() - this.b.p();
        }

        @Override // defpackage.lq
        public int g() {
            return h();
        }

        @Override // defpackage.lq
        public int h() {
            return 0;
        }

        @Override // defpackage.lq
        public void i(View view, int i, int i2) {
            int iE = e();
            this.b.X0(view, iE, i, iE + k(view), i2);
        }

        @Override // defpackage.lq
        public void j(View view, Rect rect, float f, float f2) {
            view.offsetTopAndBottom((int) (f2 - (rect.top + f)));
        }

        public int k(View view) {
            RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
            return this.b.t0(view) + ((ViewGroup.MarginLayoutParams) rVar).leftMargin + ((ViewGroup.MarginLayoutParams) rVar).rightMargin;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends lq {
        public final /* synthetic */ CarouselLayoutManager b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, CarouselLayoutManager carouselLayoutManager) {
            super(i, null);
            this.b = carouselLayoutManager;
        }

        @Override // defpackage.lq
        public int d() {
            return this.b.x0() - this.b.b();
        }

        @Override // defpackage.lq
        public int e() {
            return 0;
        }

        @Override // defpackage.lq
        public int f() {
            return this.b.K0();
        }

        @Override // defpackage.lq
        public int g() {
            return this.b.a3() ? f() : e();
        }

        @Override // defpackage.lq
        public int h() {
            return this.b.w();
        }

        @Override // defpackage.lq
        public void i(View view, int i, int i2) {
            int iH = h();
            this.b.X0(view, i, iH, i2, iH + k(view));
        }

        @Override // defpackage.lq
        public void j(View view, Rect rect, float f, float f2) {
            view.offsetLeftAndRight((int) (f2 - (rect.left + f)));
        }

        public int k(View view) {
            RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
            return this.b.s0(view) + ((ViewGroup.MarginLayoutParams) rVar).topMargin + ((ViewGroup.MarginLayoutParams) rVar).bottomMargin;
        }
    }

    public lq(int i) {
        this.a = i;
    }

    public static lq a(CarouselLayoutManager carouselLayoutManager) {
        return new b(0, carouselLayoutManager);
    }

    public static lq b(CarouselLayoutManager carouselLayoutManager, int i) {
        if (i == 0) {
            return a(carouselLayoutManager);
        }
        if (i == 1) {
            return c(carouselLayoutManager);
        }
        jl.a("invalid orientation");
        return null;
    }

    public static lq c(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract void i(View view, int i, int i2);

    public abstract void j(View view, Rect rect, float f, float f2);

    public /* synthetic */ lq(int i, a aVar) {
        this(i);
    }
}
