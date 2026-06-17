package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.e04;
import defpackage.eu;
import defpackage.fu;
import defpackage.gu;
import defpackage.ju;
import defpackage.kj1;
import defpackage.mk3;
import defpackage.oi;
import defpackage.uj0;
import defpackage.ym3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class CircularProgressIndicator extends a {
    public static final int w = ym3.w;

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, w);
        v();
        this.p = true;
    }

    public int getIndeterminateAnimationType() {
        return ((ju) this.f).q;
    }

    public int getIndicatorDirection() {
        return ((ju) this.f).t;
    }

    public int getIndicatorInset() {
        return ((ju) this.f).s;
    }

    public int getIndicatorSize() {
        return ((ju) this.f).r;
    }

    public void setIndeterminateAnimationType(int i) {
        if (((ju) this.f).q == i) {
            return;
        }
        if (t() && isIndeterminate()) {
            e04.a("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
            return;
        }
        oi oiVar = this.f;
        ((ju) oiVar).q = i;
        ((ju) oiVar).h();
        getIndeterminateDrawable().A(i == 1 ? new gu(getContext(), (ju) this.f) : new fu((ju) this.f));
        q();
        invalidate();
    }

    public void setIndicatorDirection(int i) {
        ((ju) this.f).t = i;
        invalidate();
    }

    public void setIndicatorInset(int i) {
        oi oiVar = this.f;
        if (((ju) oiVar).s != i) {
            ((ju) oiVar).s = i;
            invalidate();
        }
    }

    public void setIndicatorSize(int i) {
        int iMax = Math.max(i, getTrackThickness() * 2);
        oi oiVar = this.f;
        if (((ju) oiVar).r != iMax) {
            ((ju) oiVar).r = iMax;
            ((ju) oiVar).h();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.a
    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((ju) this.f).h();
    }

    @Override // com.google.android.material.progressindicator.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ju j(Context context, AttributeSet attributeSet) {
        return new ju(context, attributeSet);
    }

    public final void v() {
        eu euVar = new eu((ju) this.f);
        setIndeterminateDrawable(kj1.v(getContext(), (ju) this.f, euVar));
        setProgressDrawable(uj0.B(getContext(), (ju) this.f, euVar));
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.h);
    }

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }
}
