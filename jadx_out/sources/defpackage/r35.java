package defpackage;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r35 implements i35 {
    public final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final LinearLayoutCompat c;
    public final AppCompatImageView d;

    public r35(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat2, AppCompatImageView appCompatImageView2) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = linearLayoutCompat2;
        this.d = appCompatImageView2;
    }

    public static r35 a(View view) {
        int i = nl3.H0;
        AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
        if (appCompatImageView != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            int i2 = nl3.y1;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) j35.a(view, i2);
            if (appCompatImageView2 != null) {
                return new r35(linearLayoutCompat, appCompatImageView, linearLayoutCompat, appCompatImageView2);
            }
            i = i2;
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
