package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b4 implements i35 {
    public final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final MaterialButton c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b4(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, MaterialButton materialButton) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = materialButton;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b4 a(View view) {
        int i = nl3.S;
        AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
        if (appCompatImageView != null) {
            i = nl3.d2;
            MaterialButton materialButton = (MaterialButton) j35.a(view, i);
            if (materialButton != null) {
                return new b4((LinearLayoutCompat) view, appCompatImageView, materialButton);
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.m, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getRoot()Landroid/view/View; */
    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
