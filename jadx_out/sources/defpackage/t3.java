package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class t3 implements i35 {
    public final FrameLayout a;
    public final DecoratedBarcodeView b;

    public t3(FrameLayout frameLayout, DecoratedBarcodeView decoratedBarcodeView) {
        this.a = frameLayout;
        this.b = decoratedBarcodeView;
    }

    public static t3 a(View view) {
        int i = nl3.K1;
        DecoratedBarcodeView decoratedBarcodeView = (DecoratedBarcodeView) j35.a(view, i);
        if (decoratedBarcodeView != null) {
            return new t3((FrameLayout) view, decoratedBarcodeView);
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static t3 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t3 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.h, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
