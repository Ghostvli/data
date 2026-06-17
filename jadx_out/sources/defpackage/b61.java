package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentContainerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b61 implements i35 {
    public final FrameLayout a;
    public final FragmentContainerView b;

    public b61(FrameLayout frameLayout, FragmentContainerView fragmentContainerView) {
        this.a = frameLayout;
        this.b = fragmentContainerView;
    }

    public static b61 a(View view) {
        int i = nl3.J;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) j35.a(view, i);
        if (fragmentContainerView != null) {
            return new b61((FrameLayout) view, fragmentContainerView);
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static b61 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.i0, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
