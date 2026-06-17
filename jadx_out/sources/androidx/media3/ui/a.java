package androidx.media3.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.ui.SubtitleView;
import defpackage.cq;
import defpackage.ii4;
import defpackage.p50;
import defpackage.qi4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends View implements SubtitleView.a {
    public final List f;
    public List g;
    public int h;
    public float i;
    public cq j;
    public float k;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new ArrayList();
        this.g = Collections.EMPTY_LIST;
        this.h = 0;
        this.i = 0.0533f;
        this.j = cq.g;
        this.k = 0.08f;
    }

    public static p50 b(p50 p50Var) {
        p50.b bVarP = p50Var.a().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        int i = p50Var.f;
        float f = p50Var.e;
        if (i == 0) {
            bVarP.h(1.0f - f, 0);
        } else {
            bVarP.h((-f) - 1.0f, 1);
        }
        int i2 = p50Var.g;
        if (i2 == 0) {
            bVarP.i(2);
        } else if (i2 == 2) {
            bVarP.i(0);
        }
        return bVarP.a();
    }

    @Override // androidx.media3.ui.SubtitleView.a
    public void a(List list, cq cqVar, float f, int i, float f2) {
        this.g = list;
        this.j = cqVar;
        this.i = f;
        this.h = i;
        this.k = f2;
        while (this.f.size() < list.size()) {
            this.f.add(new ii4(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.g;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i = paddingBottom - paddingTop;
        float f = qi4.f(this.h, this.i, height, i);
        if (f <= 0.0f) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            p50 p50VarB = (p50) list.get(i2);
            if (p50VarB.p != Integer.MIN_VALUE) {
                p50VarB = b(p50VarB);
            }
            ((ii4) this.f.get(i2)).b(p50VarB, this.j, f, qi4.f(p50VarB.n, p50VarB.o, height, i), this.k, canvas, paddingLeft, paddingTop, width, paddingBottom);
        }
    }

    public a(Context context) {
        this(context, null);
    }
}
