package defpackage;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.fongmi.android.tv.ui.custom.CustomSeekView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q35 implements i35 {
    public final RelativeLayout a;
    public final p35 b;
    public final AppCompatImageView c;
    public final LinearLayoutCompat d;
    public final AppCompatImageView e;
    public final LinearLayoutCompat f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final r35 k;
    public final CustomSeekView l;
    public final MaterialTextView m;
    public final LinearLayoutCompat n;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public q35(RelativeLayout relativeLayout, p35 p35Var, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView2, LinearLayoutCompat linearLayoutCompat2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, r35 r35Var, CustomSeekView customSeekView, MaterialTextView materialTextView, LinearLayoutCompat linearLayoutCompat3) {
        this.a = relativeLayout;
        this.b = p35Var;
        this.c = appCompatImageView;
        this.d = linearLayoutCompat;
        this.e = appCompatImageView2;
        this.f = linearLayoutCompat2;
        this.g = appCompatImageView3;
        this.h = appCompatImageView4;
        this.i = appCompatImageView5;
        this.j = appCompatImageView6;
        this.k = r35Var;
        this.l = customSeekView;
        this.m = materialTextView;
        this.n = linearLayoutCompat3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static q35 a(View view) {
        View viewA;
        int i = nl3.d;
        View viewA2 = j35.a(view, i);
        if (viewA2 != null) {
            p35 p35VarA = p35.a(viewA2);
            i = nl3.n;
            AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
            if (appCompatImageView != null) {
                i = nl3.s;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) j35.a(view, i);
                if (linearLayoutCompat != null) {
                    i = nl3.C;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) j35.a(view, i);
                    if (appCompatImageView2 != null) {
                        i = nl3.D;
                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) j35.a(view, i);
                        if (linearLayoutCompat2 != null) {
                            i = nl3.t0;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) j35.a(view, i);
                            if (appCompatImageView3 != null) {
                                i = nl3.Q0;
                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) j35.a(view, i);
                                if (appCompatImageView4 != null) {
                                    i = nl3.Z0;
                                    AppCompatImageView appCompatImageView5 = (AppCompatImageView) j35.a(view, i);
                                    if (appCompatImageView5 != null) {
                                        i = nl3.g1;
                                        AppCompatImageView appCompatImageView6 = (AppCompatImageView) j35.a(view, i);
                                        if (appCompatImageView6 != null && (viewA = j35.a(view, (i = nl3.x1))) != null) {
                                            r35 r35VarA = r35.a(viewA);
                                            i = nl3.P1;
                                            CustomSeekView customSeekView = (CustomSeekView) j35.a(view, i);
                                            if (customSeekView != null) {
                                                i = nl3.m2;
                                                MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
                                                if (materialTextView != null) {
                                                    i = nl3.o2;
                                                    LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) j35.a(view, i);
                                                    if (linearLayoutCompat3 != null) {
                                                        return new q35((RelativeLayout) view, p35VarA, appCompatImageView, linearLayoutCompat, appCompatImageView2, linearLayoutCompat2, appCompatImageView3, appCompatImageView4, appCompatImageView5, appCompatImageView6, r35VarA, customSeekView, materialTextView, linearLayoutCompat3);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getRoot()Landroid/view/View; */
    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
