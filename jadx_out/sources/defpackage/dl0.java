package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fongmi.android.tv.ui.custom.CustomRecyclerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class dl0 implements i35 {
    public final CustomRecyclerView a;
    public final CustomRecyclerView b;

    public dl0(CustomRecyclerView customRecyclerView, CustomRecyclerView customRecyclerView2) {
        this.a = customRecyclerView;
        this.b = customRecyclerView2;
    }

    public static dl0 a(View view) {
        if (view != null) {
            CustomRecyclerView customRecyclerView = (CustomRecyclerView) view;
            return new dl0(customRecyclerView, customRecyclerView);
        }
        om1.a("rootView");
        return null;
    }

    public static dl0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static dl0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.W, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CustomRecyclerView getRoot() {
        return this.a;
    }
}
