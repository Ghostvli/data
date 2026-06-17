package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class sk0 implements i35 {
    public final LinearLayoutCompat a;
    public final TextInputLayout b;
    public final TextInputLayout c;
    public final TextInputEditText d;
    public final TextInputEditText e;

    public sk0(LinearLayoutCompat linearLayoutCompat, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputEditText textInputEditText, TextInputEditText textInputEditText2) {
        this.a = linearLayoutCompat;
        this.b = textInputLayout;
        this.c = textInputLayout2;
        this.d = textInputEditText;
        this.e = textInputEditText2;
    }

    public static sk0 a(View view) {
        int i = nl3.G;
        TextInputLayout textInputLayout = (TextInputLayout) j35.a(view, i);
        if (textInputLayout != null) {
            i = nl3.v0;
            TextInputLayout textInputLayout2 = (TextInputLayout) j35.a(view, i);
            if (textInputLayout2 != null) {
                i = nl3.N0;
                TextInputEditText textInputEditText = (TextInputEditText) j35.a(view, i);
                if (textInputEditText != null) {
                    i = nl3.x2;
                    TextInputEditText textInputEditText2 = (TextInputEditText) j35.a(view, i);
                    if (textInputEditText2 != null) {
                        return new sk0((LinearLayoutCompat) view, textInputLayout, textInputLayout2, textInputEditText, textInputEditText2);
                    }
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static sk0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static sk0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.M, viewGroup, false);
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
