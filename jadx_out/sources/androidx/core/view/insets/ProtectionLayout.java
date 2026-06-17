package androidx.core.view.insets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import defpackage.ii3;
import defpackage.ji3;
import defpackage.jk4;
import defpackage.rl3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ProtectionLayout extends FrameLayout {
    public static final Object h = new Object();
    public final List f;
    public ji3 g;

    public ProtectionLayout(Context context, List list) {
        super(context);
        this.f = new ArrayList();
        setProtections(list);
    }

    private jk4 getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(rl3.R);
        if (tag instanceof jk4) {
            return (jk4) tag;
        }
        jk4 jk4Var = new jk4(viewGroup);
        viewGroup.setTag(rl3.R, jk4Var);
        return jk4Var;
    }

    public final void a(Context context, int i, ii3 ii3Var) {
        throw null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getTag() != h) {
            ji3 ji3Var = this.g;
            int childCount = getChildCount() - (ji3Var != null ? ji3Var.i() : 0);
            if (i > childCount || i < 0) {
                i = childCount;
            }
        }
        super.addView(view, i, layoutParams);
    }

    public final void b() {
        if (this.f.isEmpty()) {
            return;
        }
        this.g = new ji3(getOrInstallSystemBarStateMonitor(), this.f);
        int childCount = getChildCount();
        int i = this.g.i();
        for (int i2 = 0; i2 < i; i2++) {
            this.g.h(i2);
            a(getContext(), i2 + childCount, null);
        }
    }

    public final void c() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(rl3.R);
        if (tag instanceof jk4) {
            jk4 jk4Var = (jk4) tag;
            if (jk4Var.k()) {
                return;
            }
            jk4Var.h();
            viewGroup.setTag(rl3.R, null);
        }
    }

    public final void d() {
        if (this.g != null) {
            removeViews(getChildCount() - this.g.i(), this.g.i());
            int i = this.g.i();
            ji3 ji3Var = this.g;
            if (i > 0) {
                ji3Var.h(0);
                throw null;
            }
            ji3Var.g();
            this.g = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g != null) {
            d();
        }
        b();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
        c();
    }

    public void setProtections(List<ii3> list) {
        this.f.clear();
        this.f.addAll(list);
        if (isAttachedToWindow()) {
            d();
            b();
            requestApplyInsets();
        }
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f = new ArrayList();
    }

    public ProtectionLayout(Context context) {
        super(context);
        this.f = new ArrayList();
    }
}
