package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.e04;
import defpackage.jt1;
import defpackage.kj1;
import defpackage.kt1;
import defpackage.lt1;
import defpackage.mk3;
import defpackage.nt1;
import defpackage.oi;
import defpackage.uj0;
import defpackage.ym3;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class LinearProgressIndicator extends a {
    public static final int w = ym3.A;

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, w);
        v();
        this.p = true;
    }

    private void v() {
        jt1 jt1Var = new jt1((nt1) this.f);
        setIndeterminateDrawable(kj1.w(getContext(), (nt1) this.f, jt1Var));
        setProgressDrawable(uj0.C(getContext(), (nt1) this.f, jt1Var));
    }

    public int getIndeterminateAnimationType() {
        return ((nt1) this.f).q;
    }

    public int getIndicatorDirection() {
        return ((nt1) this.f).r;
    }

    public int getTrackInnerCornerRadius() {
        return ((nt1) this.f).v;
    }

    public Integer getTrackStopIndicatorPadding() {
        return ((nt1) this.f).u;
    }

    public int getTrackStopIndicatorSize() {
        return ((nt1) this.f).t;
    }

    @Override // com.google.android.material.progressindicator.a, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        oi oiVar = this.f;
        nt1 nt1Var = (nt1) oiVar;
        boolean z2 = true;
        if (((nt1) oiVar).r != 1 && ((getLayoutDirection() != 1 || ((nt1) this.f).r != 2) && (getLayoutDirection() != 0 || ((nt1) this.f).r != 3))) {
            z2 = false;
        }
        nt1Var.s = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        kj1 indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        uj0 progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    @Override // com.google.android.material.progressindicator.a
    public void r(int i, boolean z) {
        oi oiVar = this.f;
        if (oiVar != null && ((nt1) oiVar).q == 0 && isIndeterminate()) {
            return;
        }
        super.r(i, z);
    }

    public void setIndeterminateAnimationType(int i) {
        if (((nt1) this.f).q == i) {
            return;
        }
        if (t() && isIndeterminate()) {
            e04.a("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
            return;
        }
        oi oiVar = this.f;
        ((nt1) oiVar).q = i;
        ((nt1) oiVar).h();
        if (i == 0) {
            getIndeterminateDrawable().A(new kt1((nt1) this.f));
        } else {
            getIndeterminateDrawable().A(new lt1(getContext(), (nt1) this.f));
        }
        q();
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.a
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((nt1) this.f).h();
    }

    public void setIndicatorDirection(int i) {
        oi oiVar = this.f;
        ((nt1) oiVar).r = i;
        nt1 nt1Var = (nt1) oiVar;
        boolean z = true;
        if (i != 1 && ((getLayoutDirection() != 1 || ((nt1) this.f).r != 2) && (getLayoutDirection() != 0 || i != 3))) {
            z = false;
        }
        nt1Var.s = z;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.a
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        ((nt1) this.f).h();
        invalidate();
    }

    public void setTrackInnerCornerRadius(int i) {
        oi oiVar = this.f;
        if (((nt1) oiVar).v != i) {
            ((nt1) oiVar).v = Math.round(Math.min(i, ((nt1) oiVar).a / 2.0f));
            oi oiVar2 = this.f;
            ((nt1) oiVar2).x = false;
            ((nt1) oiVar2).y = true;
            ((nt1) oiVar2).h();
            invalidate();
        }
    }

    public void setTrackInnerCornerRadiusFraction(float f) {
        oi oiVar = this.f;
        if (((nt1) oiVar).w != f) {
            ((nt1) oiVar).w = Math.min(f, 0.5f);
            oi oiVar2 = this.f;
            ((nt1) oiVar2).x = true;
            ((nt1) oiVar2).y = true;
            ((nt1) oiVar2).h();
            invalidate();
        }
    }

    public void setTrackStopIndicatorPadding(Integer num) {
        if (Objects.equals(((nt1) this.f).u, num)) {
            return;
        }
        ((nt1) this.f).u = num;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i) {
        oi oiVar = this.f;
        if (((nt1) oiVar).t != i) {
            ((nt1) oiVar).t = i;
            ((nt1) oiVar).h();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public nt1 j(Context context, AttributeSet attributeSet) {
        return new nt1(context, attributeSet);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.v);
    }

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }
}
