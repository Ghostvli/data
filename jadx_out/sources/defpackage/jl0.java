package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class jl0 implements i35 {
    public final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;

    public jl0(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = appCompatImageView4;
        this.f = appCompatImageView5;
    }

    public static jl0 a(View view) {
        int i = nl3.X;
        AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
        if (appCompatImageView != null) {
            i = nl3.z0;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) j35.a(view, i);
            if (appCompatImageView2 != null) {
                i = nl3.t1;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) j35.a(view, i);
                if (appCompatImageView3 != null) {
                    i = nl3.V1;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) j35.a(view, i);
                    if (appCompatImageView4 != null) {
                        i = nl3.w2;
                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) j35.a(view, i);
                        if (appCompatImageView5 != null) {
                            return new jl0((LinearLayoutCompat) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5);
                        }
                    }
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static jl0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.c0, viewGroup, false);
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
