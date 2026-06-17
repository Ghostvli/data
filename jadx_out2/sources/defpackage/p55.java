package defpackage;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class p55 implements i35 {
    public final FrameLayout a;
    public final AppCompatImageView b;
    public final LinearLayoutCompat c;
    public final AppCompatImageView d;
    public final LinearProgressIndicator e;
    public final MaterialTextView f;
    public final LinearLayoutCompat g;
    public final AppCompatImageView h;
    public final MaterialTextView i;
    public final LinearLayoutCompat j;
    public final AppCompatImageView k;
    public final LinearProgressIndicator l;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p55(FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView2, LinearProgressIndicator linearProgressIndicator, MaterialTextView materialTextView, LinearLayoutCompat linearLayoutCompat2, AppCompatImageView appCompatImageView3, MaterialTextView materialTextView2, LinearLayoutCompat linearLayoutCompat3, AppCompatImageView appCompatImageView4, LinearProgressIndicator linearProgressIndicator2) {
        this.a = frameLayout;
        this.b = appCompatImageView;
        this.c = linearLayoutCompat;
        this.d = appCompatImageView2;
        this.e = linearProgressIndicator;
        this.f = materialTextView;
        this.g = linearLayoutCompat2;
        this.h = appCompatImageView3;
        this.i = materialTextView2;
        this.j = linearLayoutCompat3;
        this.k = appCompatImageView4;
        this.l = linearProgressIndicator2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static p55 a(View view) {
        int i = nl3.d;
        AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
        if (appCompatImageView != null) {
            i = nl3.t;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) j35.a(view, i);
            if (linearLayoutCompat != null) {
                i = nl3.u;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) j35.a(view, i);
                if (appCompatImageView2 != null) {
                    i = nl3.v;
                    LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) j35.a(view, i);
                    if (linearProgressIndicator != null) {
                        i = nl3.d0;
                        MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
                        if (materialTextView != null) {
                            i = nl3.P1;
                            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) j35.a(view, i);
                            if (linearLayoutCompat2 != null) {
                                i = nl3.W1;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) j35.a(view, i);
                                if (appCompatImageView3 != null) {
                                    i = nl3.f2;
                                    MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
                                    if (materialTextView2 != null) {
                                        i = nl3.H2;
                                        LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) j35.a(view, i);
                                        if (linearLayoutCompat3 != null) {
                                            i = nl3.I2;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) j35.a(view, i);
                                            if (appCompatImageView4 != null) {
                                                i = nl3.J2;
                                                LinearProgressIndicator linearProgressIndicator2 = (LinearProgressIndicator) j35.a(view, i);
                                                if (linearProgressIndicator2 != null) {
                                                    return new p55((FrameLayout) view, appCompatImageView, linearLayoutCompat, appCompatImageView2, linearProgressIndicator, materialTextView, linearLayoutCompat2, appCompatImageView3, materialTextView2, linearLayoutCompat3, appCompatImageView4, linearProgressIndicator2);
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
    public FrameLayout getRoot() {
        return this.a;
    }
}
