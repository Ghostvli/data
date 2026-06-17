package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h3 implements i35 {
    public final FrameLayout a;
    public final RecyclerView b;
    public final q35 c;
    public final RecyclerView d;
    public final PlayerView e;
    public final RecyclerView f;
    public final q45 g;
    public final LinearLayoutCompat h;
    public final FrameLayout i;
    public final o55 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h3(FrameLayout frameLayout, RecyclerView recyclerView, q35 q35Var, RecyclerView recyclerView2, PlayerView playerView, RecyclerView recyclerView3, q45 q45Var, LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout2, o55 o55Var) {
        this.a = frameLayout;
        this.b = recyclerView;
        this.c = q35Var;
        this.d = recyclerView2;
        this.e = playerView;
        this.f = recyclerView3;
        this.g = q45Var;
        this.h = linearLayoutCompat;
        this.i = frameLayout2;
        this.j = o55Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static h3 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i = nl3.F;
        RecyclerView recyclerView = (RecyclerView) j35.a(view, i);
        if (recyclerView != null && (viewA = j35.a(view, (i = nl3.M))) != null) {
            q35 q35VarA = q35.a(viewA);
            i = nl3.a0;
            RecyclerView recyclerView2 = (RecyclerView) j35.a(view, i);
            if (recyclerView2 != null) {
                i = nl3.e0;
                PlayerView playerView = (PlayerView) j35.a(view, i);
                if (playerView != null) {
                    i = nl3.j0;
                    RecyclerView recyclerView3 = (RecyclerView) j35.a(view, i);
                    if (recyclerView3 != null && (viewA2 = j35.a(view, (i = nl3.h1))) != null) {
                        q45 q45VarA = q45.a(viewA2);
                        i = nl3.o1;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) j35.a(view, i);
                        if (linearLayoutCompat != null) {
                            i = nl3.A2;
                            FrameLayout frameLayout = (FrameLayout) j35.a(view, i);
                            if (frameLayout != null && (viewA3 = j35.a(view, (i = nl3.O2))) != null) {
                                return new h3((FrameLayout) view, recyclerView, q35VarA, recyclerView2, playerView, recyclerView3, q45VarA, linearLayoutCompat, frameLayout, o55.a(viewA3));
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
    public static h3 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static h3 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.g, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getRoot()Landroid/view/View; */
    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
