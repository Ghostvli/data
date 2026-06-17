package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.hierynomus.msdtyp.FileTime;
import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class k extends RecyclerView.b0 {
    public PointF k;
    public final DisplayMetrics l;
    public float n;
    public final LinearInterpolator i = new LinearInterpolator();
    public final DecelerateInterpolator j = new DecelerateInterpolator();
    public boolean m = false;
    public int o = 0;
    public int p = 0;

    public k(Context context) {
        this.l = context.getResources().getDisplayMetrics();
    }

    public final float A() {
        if (!this.m) {
            this.n = v(this.l);
            this.m = true;
        }
        return this.n;
    }

    public int B() {
        PointF pointF = this.k;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.y;
        if (f == 0.0f) {
            return 0;
        }
        return f > 0.0f ? 1 : -1;
    }

    public void C(RecyclerView.b0.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.k = pointFA;
        this.o = (int) (pointFA.x * 10000.0f);
        this.p = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.o * 1.2f), (int) (this.p * 1.2f), (int) (x(FileTime.NANO100_TO_MILLI) * 1.2f), this.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.b0
    public void l(int i, int i2, RecyclerView.c0 c0Var, RecyclerView.b0.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.o = y(this.o, i);
        int iY = y(this.p, i2);
        this.p = iY;
        if (this.o == 0 && iY == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.b0
    public void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.b0
    public void n() {
        this.p = 0;
        this.o = 0;
        this.k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.b0
    public void o(View view, RecyclerView.c0 c0Var, RecyclerView.b0.a aVar) {
        int iT = t(view, z());
        int iU = u(view, B());
        int iW = w((int) Math.sqrt((iT * iT) + (iU * iU)));
        if (iW > 0) {
            aVar.d(-iT, -iU, iW, this.j);
        }
    }

    public int s(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            jl.a("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            return 0;
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int t(View view, int i) {
        RecyclerView.q qVarE = e();
        if (qVarE == null || !qVarE.L()) {
            return 0;
        }
        RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
        return s(qVarE.r0(view) - ((ViewGroup.MarginLayoutParams) rVar).leftMargin, qVarE.u0(view) + ((ViewGroup.MarginLayoutParams) rVar).rightMargin, qVarE.y(), qVarE.K0() - qVarE.p(), i);
    }

    public int u(View view, int i) {
        RecyclerView.q qVarE = e();
        if (qVarE == null || !qVarE.M()) {
            return 0;
        }
        RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
        return s(qVarE.v0(view) - ((ViewGroup.MarginLayoutParams) rVar).topMargin, qVarE.p0(view) + ((ViewGroup.MarginLayoutParams) rVar).bottomMargin, qVarE.w(), qVarE.x0() - qVarE.b(), i);
    }

    public float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int w(int i) {
        return (int) Math.ceil(((double) x(i)) / 0.3356d);
    }

    public int x(int i) {
        return (int) Math.ceil(Math.abs(i) * A());
    }

    public final int y(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int z() {
        PointF pointF = this.k;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.x;
        if (f == 0.0f) {
            return 0;
        }
        return f > 0.0f ? 1 : -1;
    }
}
