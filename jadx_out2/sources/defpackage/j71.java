package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.fongmi.android.tv.ui.custom.CustomRecyclerView;
import com.fongmi.android.tv.ui.custom.ProgressLayout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class j71 implements i35 {
    public final SwipeRefreshLayout a;
    public final ProgressLayout b;
    public final CustomRecyclerView c;
    public final SwipeRefreshLayout d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public j71(SwipeRefreshLayout swipeRefreshLayout, ProgressLayout progressLayout, CustomRecyclerView customRecyclerView, SwipeRefreshLayout swipeRefreshLayout2) {
        this.a = swipeRefreshLayout;
        this.b = progressLayout;
        this.c = customRecyclerView;
        this.d = swipeRefreshLayout2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j71 a(View view) {
        int i = nl3.i1;
        ProgressLayout progressLayout = (ProgressLayout) j35.a(view, i);
        if (progressLayout != null) {
            i = nl3.o1;
            CustomRecyclerView customRecyclerView = (CustomRecyclerView) j35.a(view, i);
            if (customRecyclerView != null) {
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
                return new j71(swipeRefreshLayout, progressLayout, customRecyclerView, swipeRefreshLayout);
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j71 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.m0, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getRoot()Landroid/view/View; */
    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SwipeRefreshLayout getRoot() {
        return this.a;
    }
}
