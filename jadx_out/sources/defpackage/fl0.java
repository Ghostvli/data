package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fl0 implements i35 {
    public final RelativeLayout a;
    public final FrameLayout b;
    public final MaterialTextView c;
    public final ShapeableImageView d;
    public final MaterialTextView e;
    public final FrameLayout f;
    public final q45 g;

    public fl0(RelativeLayout relativeLayout, FrameLayout frameLayout, MaterialTextView materialTextView, ShapeableImageView shapeableImageView, MaterialTextView materialTextView2, FrameLayout frameLayout2, q45 q45Var) {
        this.a = relativeLayout;
        this.b = frameLayout;
        this.c = materialTextView;
        this.d = shapeableImageView;
        this.e = materialTextView2;
        this.f = frameLayout2;
        this.g = q45Var;
    }

    public static fl0 a(View view) {
        View viewA;
        int i = nl3.h0;
        FrameLayout frameLayout = (FrameLayout) j35.a(view, i);
        if (frameLayout != null) {
            i = nl3.i0;
            MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
            if (materialTextView != null) {
                i = nl3.q0;
                ShapeableImageView shapeableImageView = (ShapeableImageView) j35.a(view, i);
                if (shapeableImageView != null) {
                    i = nl3.N0;
                    MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
                    if (materialTextView2 != null) {
                        i = nl3.Z0;
                        FrameLayout frameLayout2 = (FrameLayout) j35.a(view, i);
                        if (frameLayout2 != null && (viewA = j35.a(view, (i = nl3.h1))) != null) {
                            return new fl0((RelativeLayout) view, frameLayout, materialTextView, shapeableImageView, materialTextView2, frameLayout2, q45.a(viewA));
                        }
                    }
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static fl0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.Y, viewGroup, false);
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
