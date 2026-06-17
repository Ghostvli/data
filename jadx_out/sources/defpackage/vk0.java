package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vk0 implements i35 {
    public final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final RecyclerView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;

    public vk0(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = recyclerView;
        this.d = appCompatImageView2;
        this.e = appCompatImageView3;
    }

    public static vk0 a(View view) {
        int i = nl3.L0;
        AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
        if (appCompatImageView != null) {
            i = nl3.o1;
            RecyclerView recyclerView = (RecyclerView) j35.a(view, i);
            if (recyclerView != null) {
                i = nl3.p1;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) j35.a(view, i);
                if (appCompatImageView2 != null) {
                    i = nl3.J1;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) j35.a(view, i);
                    if (appCompatImageView3 != null) {
                        return new vk0((LinearLayoutCompat) view, appCompatImageView, recyclerView, appCompatImageView2, appCompatImageView3);
                    }
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static vk0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.P, viewGroup, false);
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
