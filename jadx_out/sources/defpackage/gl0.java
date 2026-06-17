package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.fongmi.android.tv.ui.custom.CustomRecyclerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gl0 implements i35 {
    public final LinearLayoutCompat a;
    public final CustomRecyclerView b;

    public gl0(LinearLayoutCompat linearLayoutCompat, CustomRecyclerView customRecyclerView) {
        this.a = linearLayoutCompat;
        this.b = customRecyclerView;
    }

    public static gl0 a(View view) {
        int i = nl3.o1;
        CustomRecyclerView customRecyclerView = (CustomRecyclerView) j35.a(view, i);
        if (customRecyclerView != null) {
            return new gl0((LinearLayoutCompat) view, customRecyclerView);
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static gl0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.Z, viewGroup, false);
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
