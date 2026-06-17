package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ml0 implements i35 {
    public final LinearLayoutCompat a;
    public final TextInputLayout b;
    public final TextInputEditText c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ml0(LinearLayoutCompat linearLayoutCompat, TextInputLayout textInputLayout, TextInputEditText textInputEditText) {
        this.a = linearLayoutCompat;
        this.b = textInputLayout;
        this.c = textInputEditText;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ml0 a(View view) {
        int i = nl3.v0;
        TextInputLayout textInputLayout = (TextInputLayout) j35.a(view, i);
        if (textInputLayout != null) {
            i = nl3.d2;
            TextInputEditText textInputEditText = (TextInputEditText) j35.a(view, i);
            if (textInputEditText != null) {
                return new ml0((LinearLayoutCompat) view, textInputLayout, textInputEditText);
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ml0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ml0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.f0, viewGroup, false);
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
