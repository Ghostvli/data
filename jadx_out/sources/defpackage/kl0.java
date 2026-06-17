package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kl0 implements i35 {
    public final LinearLayoutCompat a;
    public final MaterialButton b;
    public final LinearLayoutCompat c;
    public final MaterialButton d;
    public final MaterialTextView e;
    public final MaterialTextView f;
    public final MaterialTextView g;
    public final MaterialTextView h;
    public final MaterialTextView i;
    public final LinearLayoutCompat j;

    public kl0(LinearLayoutCompat linearLayoutCompat, MaterialButton materialButton, LinearLayoutCompat linearLayoutCompat2, MaterialButton materialButton2, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3, MaterialTextView materialTextView4, MaterialTextView materialTextView5, LinearLayoutCompat linearLayoutCompat3) {
        this.a = linearLayoutCompat;
        this.b = materialButton;
        this.c = linearLayoutCompat2;
        this.d = materialButton2;
        this.e = materialTextView;
        this.f = materialTextView2;
        this.g = materialTextView3;
        this.h = materialTextView4;
        this.i = materialTextView5;
        this.j = linearLayoutCompat3;
    }

    public static kl0 a(View view) {
        int i = nl3.R;
        MaterialButton materialButton = (MaterialButton) j35.a(view, i);
        if (materialButton != null) {
            i = nl3.C0;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) j35.a(view, i);
            if (linearLayoutCompat != null) {
                i = nl3.t1;
                MaterialButton materialButton2 = (MaterialButton) j35.a(view, i);
                if (materialButton2 != null) {
                    i = nl3.e2;
                    MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
                    if (materialTextView != null) {
                        i = nl3.g2;
                        MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
                        if (materialTextView2 != null) {
                            i = nl3.h2;
                            MaterialTextView materialTextView3 = (MaterialTextView) j35.a(view, i);
                            if (materialTextView3 != null) {
                                i = nl3.i2;
                                MaterialTextView materialTextView4 = (MaterialTextView) j35.a(view, i);
                                if (materialTextView4 != null) {
                                    i = nl3.j2;
                                    MaterialTextView materialTextView5 = (MaterialTextView) j35.a(view, i);
                                    if (materialTextView5 != null) {
                                        i = nl3.l2;
                                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) j35.a(view, i);
                                        if (linearLayoutCompat2 != null) {
                                            return new kl0((LinearLayoutCompat) view, materialButton, linearLayoutCompat, materialButton2, materialTextView, materialTextView2, materialTextView3, materialTextView4, materialTextView5, linearLayoutCompat2);
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

    public static kl0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.d0, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
