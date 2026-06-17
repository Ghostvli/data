package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b3 implements i35 {
    public final LinearLayoutCompat a;
    public final MaterialButton b;
    public final MaterialButton c;

    public b3(LinearLayoutCompat linearLayoutCompat, MaterialButton materialButton, MaterialButton materialButton2) {
        this.a = linearLayoutCompat;
        this.b = materialButton;
        this.c = materialButton2;
    }

    public static b3 a(View view) {
        int i = nl3.T;
        MaterialButton materialButton = (MaterialButton) j35.a(view, i);
        if (materialButton != null) {
            i = nl3.u1;
            MaterialButton materialButton2 = (MaterialButton) j35.a(view, i);
            if (materialButton2 != null) {
                return new b3((LinearLayoutCompat) view, materialButton, materialButton2);
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static b3 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b3 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.a, viewGroup, false);
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
