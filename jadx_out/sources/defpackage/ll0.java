package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.fongmi.android.tv.ui.custom.CustomRecyclerView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ll0 implements i35 {
    public final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final CustomRecyclerView c;
    public final AppCompatImageView d;
    public final MaterialTextView e;

    public ll0(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, CustomRecyclerView customRecyclerView, AppCompatImageView appCompatImageView2, MaterialTextView materialTextView) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = customRecyclerView;
        this.d = appCompatImageView2;
        this.e = materialTextView;
    }

    public static ll0 a(View view) {
        int i = nl3.G;
        AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
        if (appCompatImageView != null) {
            i = nl3.o1;
            CustomRecyclerView customRecyclerView = (CustomRecyclerView) j35.a(view, i);
            if (customRecyclerView != null) {
                i = nl3.Z1;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) j35.a(view, i);
                if (appCompatImageView2 != null) {
                    i = nl3.m2;
                    MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
                    if (materialTextView != null) {
                        return new ll0((LinearLayoutCompat) view, appCompatImageView, customRecyclerView, appCompatImageView2, materialTextView);
                    }
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static ll0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.e0, viewGroup, false);
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
