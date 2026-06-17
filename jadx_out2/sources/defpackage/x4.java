package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class x4 implements i35 {
    public final LinearLayoutCompat a;
    public final ShapeableImageView b;
    public final MaterialTextView c;
    public final MaterialTextView d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x4(LinearLayoutCompat linearLayoutCompat, ShapeableImageView shapeableImageView, MaterialTextView materialTextView, MaterialTextView materialTextView2) {
        this.a = linearLayoutCompat;
        this.b = shapeableImageView;
        this.c = materialTextView;
        this.d = materialTextView2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static x4 a(View view) {
        int i = nl3.q0;
        ShapeableImageView shapeableImageView = (ShapeableImageView) j35.a(view, i);
        if (shapeableImageView != null) {
            i = nl3.N0;
            MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
            if (materialTextView != null) {
                i = nl3.q1;
                MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
                if (materialTextView2 != null) {
                    return new x4((LinearLayoutCompat) view, shapeableImageView, materialTextView, materialTextView2);
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static x4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.I, viewGroup, false);
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
