package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yk0 implements i35 {
    public final NestedScrollView a;
    public final LinearLayout b;

    public yk0(NestedScrollView nestedScrollView, LinearLayout linearLayout) {
        this.a = nestedScrollView;
        this.b = linearLayout;
    }

    public static yk0 a(View view) {
        int i = nl3.J;
        LinearLayout linearLayout = (LinearLayout) j35.a(view, i);
        if (linearLayout != null) {
            return new yk0((NestedScrollView) view, linearLayout);
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static yk0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.S, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.a;
    }
}
