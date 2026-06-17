package androidx.media3.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import defpackage.cq;
import defpackage.d04;
import defpackage.p50;
import defpackage.qi4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {
    public List f;
    public cq g;
    public int h;
    public float i;
    public float j;
    public boolean k;
    public boolean l;
    public int m;
    public a n;
    public View o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(List list, cq cqVar, float f, int i, float f2);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = Collections.EMPTY_LIST;
        this.g = cq.g;
        this.h = 0;
        this.i = 0.0533f;
        this.j = 0.08f;
        this.k = true;
        this.l = true;
        androidx.media3.ui.a aVar = new androidx.media3.ui.a(context);
        this.n = aVar;
        this.o = aVar;
        addView(aVar);
        this.m = 1;
    }

    private List<p50> getCuesWithStylingPreferencesApplied() {
        if (this.k && this.l) {
            return this.f;
        }
        ArrayList arrayList = new ArrayList(this.f.size());
        for (int i = 0; i < this.f.size(); i++) {
            arrayList.add(a((p50) this.f.get(i)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private cq getUserCaptionStyle() {
        if (isInEditMode()) {
            return cq.g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? cq.g : cq.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t) {
        removeView(this.o);
        View view = this.o;
        if (view instanceof e) {
            ((e) view).g();
        }
        this.o = t;
        this.n = t;
        addView(t);
    }

    public final p50 a(p50 p50Var) {
        p50.b bVarA = p50Var.a();
        if (!this.k) {
            qi4.c(bVarA);
        } else if (!this.l) {
            qi4.d(bVarA);
        }
        return bVarA.a();
    }

    public void b(float f, boolean z) {
        c(z ? 1 : 0, f);
    }

    public final void c(int i, float f) {
        this.h = i;
        this.i = f;
        f();
    }

    public void d() {
        setStyle(getUserCaptionStyle());
    }

    public void e() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void f() {
        this.n.a(getCuesWithStylingPreferencesApplied(), this.g, this.i, this.h, this.j);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.l = z;
        f();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.k = z;
        f();
    }

    public void setBottomPaddingFraction(float f) {
        this.j = f;
        f();
    }

    public void setCues(List<p50> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f = list;
        f();
    }

    public void setFractionalTextSize(float f) {
        b(f, false);
    }

    public void setStyle(cq cqVar) {
        this.g = cqVar;
        f();
    }

    public void setViewType(int i) {
        if (this.m == i) {
            return;
        }
        if (i == 1) {
            setView(new androidx.media3.ui.a(getContext()));
        } else {
            if (i != 2) {
                d04.a();
                return;
            }
            setView(new e(getContext()));
        }
        this.m = i;
    }

    public SubtitleView(Context context) {
        this(context, null);
    }
}
