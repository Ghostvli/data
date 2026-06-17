package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentContainerView;
import com.google.android.material.appbar.MaterialToolbar;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d3 implements i35 {
    public final LinearLayoutCompat a;
    public final FragmentContainerView b;
    public final MaterialToolbar c;

    public d3(LinearLayoutCompat linearLayoutCompat, FragmentContainerView fragmentContainerView, MaterialToolbar materialToolbar) {
        this.a = linearLayoutCompat;
        this.b = fragmentContainerView;
        this.c = materialToolbar;
    }

    public static d3 a(View view) {
        int i = nl3.J;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) j35.a(view, i);
        if (fragmentContainerView != null) {
            i = nl3.n2;
            MaterialToolbar materialToolbar = (MaterialToolbar) j35.a(view, i);
            if (materialToolbar != null) {
                return new d3((LinearLayoutCompat) view, fragmentContainerView, materialToolbar);
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static d3 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d3 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.c, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
