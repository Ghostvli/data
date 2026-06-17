package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bl0 implements i35 {
    public final NestedScrollView a;
    public final MaterialTextView b;
    public final MaterialTextView c;
    public final MaterialTextView d;

    public bl0(NestedScrollView nestedScrollView, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3) {
        this.a = nestedScrollView;
        this.b = materialTextView;
        this.c = materialTextView2;
        this.d = materialTextView3;
    }

    public static bl0 a(View view) {
        int i = nl3.k0;
        MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
        if (materialTextView != null) {
            i = nl3.m2;
            MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
            if (materialTextView2 != null) {
                i = nl3.x2;
                MaterialTextView materialTextView3 = (MaterialTextView) j35.a(view, i);
                if (materialTextView3 != null) {
                    return new bl0((NestedScrollView) view, materialTextView, materialTextView2, materialTextView3);
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static bl0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static bl0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.U, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.a;
    }
}
