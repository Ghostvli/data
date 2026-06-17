package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q4 implements i35 {
    public final RelativeLayout a;
    public final ShapeableImageView b;
    public final MaterialTextView c;
    public final MaterialTextView d;
    public final MaterialTextView e;

    public q4(RelativeLayout relativeLayout, ShapeableImageView shapeableImageView, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3) {
        this.a = relativeLayout;
        this.b = shapeableImageView;
        this.c = materialTextView;
        this.d = materialTextView2;
        this.e = materialTextView3;
    }

    public static q4 a(View view) {
        int i = nl3.q0;
        ShapeableImageView shapeableImageView = (ShapeableImageView) j35.a(view, i);
        if (shapeableImageView != null) {
            i = nl3.N0;
            MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
            if (materialTextView != null) {
                i = nl3.q1;
                MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
                if (materialTextView2 != null) {
                    i = nl3.R1;
                    MaterialTextView materialTextView3 = (MaterialTextView) j35.a(view, i);
                    if (materialTextView3 != null) {
                        return new q4((RelativeLayout) view, shapeableImageView, materialTextView, materialTextView2, materialTextView3);
                    }
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static q4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.B, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
