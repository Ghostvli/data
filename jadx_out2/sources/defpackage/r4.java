package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r4 implements i35 {
    public final MaterialTextView a;
    public final MaterialTextView b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r4(MaterialTextView materialTextView, MaterialTextView materialTextView2) {
        this.a = materialTextView;
        this.b = materialTextView2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r4 a(View view) {
        if (view != null) {
            MaterialTextView materialTextView = (MaterialTextView) view;
            return new r4(materialTextView, materialTextView);
        }
        om1.a("rootView");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.C, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getRoot()Landroid/view/View; */
    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialTextView getRoot() {
        return this.a;
    }
}
