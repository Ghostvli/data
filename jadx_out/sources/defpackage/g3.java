package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.ui.custom.ProgressLayout;
import com.google.android.material.appbar.MaterialToolbar;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class g3 implements i35 {
    public final LinearLayoutCompat a;
    public final ProgressLayout b;
    public final RecyclerView c;
    public final MaterialToolbar d;

    public g3(LinearLayoutCompat linearLayoutCompat, ProgressLayout progressLayout, RecyclerView recyclerView, MaterialToolbar materialToolbar) {
        this.a = linearLayoutCompat;
        this.b = progressLayout;
        this.c = recyclerView;
        this.d = materialToolbar;
    }

    public static g3 a(View view) {
        int i = nl3.i1;
        ProgressLayout progressLayout = (ProgressLayout) j35.a(view, i);
        if (progressLayout != null) {
            i = nl3.o1;
            RecyclerView recyclerView = (RecyclerView) j35.a(view, i);
            if (recyclerView != null) {
                i = nl3.n2;
                MaterialToolbar materialToolbar = (MaterialToolbar) j35.a(view, i);
                if (materialToolbar != null) {
                    return new g3((LinearLayoutCompat) view, progressLayout, recyclerView, materialToolbar);
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static g3 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g3 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.f, viewGroup, false);
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
