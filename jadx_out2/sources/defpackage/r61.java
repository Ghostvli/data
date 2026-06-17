package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r61 implements i35 {
    public final LinearLayoutCompat a;
    public final AppCompatEditText b;
    public final MaterialTextView c;
    public final RecyclerView d;
    public final MaterialToolbar e;
    public final MaterialTextView f;
    public final RecyclerView g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r61(LinearLayoutCompat linearLayoutCompat, AppCompatEditText appCompatEditText, MaterialTextView materialTextView, RecyclerView recyclerView, MaterialToolbar materialToolbar, MaterialTextView materialTextView2, RecyclerView recyclerView2) {
        this.a = linearLayoutCompat;
        this.b = appCompatEditText;
        this.c = materialTextView;
        this.d = recyclerView;
        this.e = materialToolbar;
        this.f = materialTextView2;
        this.g = recyclerView2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r61 a(View view) {
        int i = nl3.y0;
        AppCompatEditText appCompatEditText = (AppCompatEditText) j35.a(view, i);
        if (appCompatEditText != null) {
            i = nl3.m1;
            MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
            if (materialTextView != null) {
                i = nl3.n1;
                RecyclerView recyclerView = (RecyclerView) j35.a(view, i);
                if (recyclerView != null) {
                    i = nl3.n2;
                    MaterialToolbar materialToolbar = (MaterialToolbar) j35.a(view, i);
                    if (materialToolbar != null) {
                        i = nl3.P2;
                        MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
                        if (materialTextView2 != null) {
                            i = nl3.Q2;
                            RecyclerView recyclerView2 = (RecyclerView) j35.a(view, i);
                            if (recyclerView2 != null) {
                                return new r61((LinearLayoutCompat) view, appCompatEditText, materialTextView, recyclerView, materialToolbar, materialTextView2, recyclerView2);
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
    public static r61 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r61 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.j0, viewGroup, false);
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
