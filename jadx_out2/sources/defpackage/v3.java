package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.fongmi.android.tv.ui.custom.ProgressLayout;
import com.google.android.material.textview.MaterialTextView;
import master.flame.danmaku.ui.widget.DanmakuView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class v3 implements i35 {
    public final View a;
    public final MaterialTextView b;
    public final MaterialTextView c;
    public final LinearLayoutCompat d;
    public final t35 e;
    public final DanmakuView f;
    public final MaterialTextView g;
    public final RecyclerView h;
    public final PlayerView i;
    public final RecyclerView j;
    public final AppCompatImageView k;
    public final MaterialTextView l;
    public final MaterialTextView m;
    public final q45 n;
    public final ProgressLayout o;
    public final RecyclerView p;
    public final MaterialTextView q;
    public final RecyclerView r;
    public final MaterialTextView s;
    public final AppCompatImageView t;
    public final NestedScrollView u;
    public final MaterialTextView v;
    public final View w;
    public final SwipeRefreshLayout x;
    public final FrameLayout y;
    public final p55 z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v3(View view, MaterialTextView materialTextView, MaterialTextView materialTextView2, LinearLayoutCompat linearLayoutCompat, t35 t35Var, DanmakuView danmakuView, MaterialTextView materialTextView3, RecyclerView recyclerView, PlayerView playerView, RecyclerView recyclerView2, AppCompatImageView appCompatImageView, MaterialTextView materialTextView4, MaterialTextView materialTextView5, q45 q45Var, ProgressLayout progressLayout, RecyclerView recyclerView3, MaterialTextView materialTextView6, RecyclerView recyclerView4, MaterialTextView materialTextView7, AppCompatImageView appCompatImageView2, NestedScrollView nestedScrollView, MaterialTextView materialTextView8, View view2, SwipeRefreshLayout swipeRefreshLayout, FrameLayout frameLayout, p55 p55Var) {
        this.a = view;
        this.b = materialTextView;
        this.c = materialTextView2;
        this.d = linearLayoutCompat;
        this.e = t35Var;
        this.f = danmakuView;
        this.g = materialTextView3;
        this.h = recyclerView;
        this.i = playerView;
        this.j = recyclerView2;
        this.k = appCompatImageView;
        this.l = materialTextView4;
        this.m = materialTextView5;
        this.n = q45Var;
        this.o = progressLayout;
        this.p = recyclerView3;
        this.q = materialTextView6;
        this.r = recyclerView4;
        this.s = materialTextView7;
        this.t = appCompatImageView2;
        this.u = nestedScrollView;
        this.v = materialTextView8;
        this.w = view2;
        this.x = swipeRefreshLayout;
        this.y = frameLayout;
        this.z = p55Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static v3 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i = nl3.g;
        MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
        if (materialTextView != null) {
            i = nl3.K;
            MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
            if (materialTextView2 != null) {
                i = nl3.L;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) j35.a(view, i);
                if (linearLayoutCompat != null && (viewA = j35.a(view, (i = nl3.M))) != null) {
                    t35 t35VarA = t35.a(viewA);
                    i = nl3.N;
                    DanmakuView danmakuView = (DanmakuView) j35.a(view, i);
                    if (danmakuView != null) {
                        i = nl3.U;
                        MaterialTextView materialTextView3 = (MaterialTextView) j35.a(view, i);
                        if (materialTextView3 != null) {
                            i = nl3.b0;
                            RecyclerView recyclerView = (RecyclerView) j35.a(view, i);
                            if (recyclerView != null) {
                                i = nl3.e0;
                                PlayerView playerView = (PlayerView) j35.a(view, i);
                                if (playerView != null) {
                                    i = nl3.g0;
                                    RecyclerView recyclerView2 = (RecyclerView) j35.a(view, i);
                                    if (recyclerView2 != null) {
                                        i = nl3.M0;
                                        AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
                                        if (appCompatImageView != null) {
                                            i = nl3.N0;
                                            MaterialTextView materialTextView4 = (MaterialTextView) j35.a(view, i);
                                            if (materialTextView4 != null) {
                                                i = nl3.U0;
                                                MaterialTextView materialTextView5 = (MaterialTextView) j35.a(view, i);
                                                if (materialTextView5 != null && (viewA2 = j35.a(view, (i = nl3.h1))) != null) {
                                                    q45 q45VarA = q45.a(viewA2);
                                                    i = nl3.i1;
                                                    ProgressLayout progressLayout = (ProgressLayout) j35.a(view, i);
                                                    if (progressLayout != null) {
                                                        i = nl3.j1;
                                                        RecyclerView recyclerView3 = (RecyclerView) j35.a(view, i);
                                                        if (recyclerView3 != null) {
                                                            i = nl3.k1;
                                                            MaterialTextView materialTextView6 = (MaterialTextView) j35.a(view, i);
                                                            if (materialTextView6 != null) {
                                                                i = nl3.l1;
                                                                RecyclerView recyclerView4 = (RecyclerView) j35.a(view, i);
                                                                if (recyclerView4 != null) {
                                                                    i = nl3.q1;
                                                                    MaterialTextView materialTextView7 = (MaterialTextView) j35.a(view, i);
                                                                    if (materialTextView7 != null) {
                                                                        i = nl3.w1;
                                                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) j35.a(view, i);
                                                                        if (appCompatImageView2 != null) {
                                                                            i = nl3.L1;
                                                                            NestedScrollView nestedScrollView = (NestedScrollView) j35.a(view, i);
                                                                            if (nestedScrollView != null) {
                                                                                i = nl3.R1;
                                                                                MaterialTextView materialTextView8 = (MaterialTextView) j35.a(view, i);
                                                                                if (materialTextView8 != null && (viewA3 = j35.a(view, (i = nl3.Y1))) != null) {
                                                                                    i = nl3.a2;
                                                                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) j35.a(view, i);
                                                                                    if (swipeRefreshLayout != null) {
                                                                                        i = nl3.A2;
                                                                                        FrameLayout frameLayout = (FrameLayout) j35.a(view, i);
                                                                                        if (frameLayout != null && (viewA4 = j35.a(view, (i = nl3.O2))) != null) {
                                                                                            return new v3(view, materialTextView, materialTextView2, linearLayoutCompat, t35VarA, danmakuView, materialTextView3, recyclerView, playerView, recyclerView2, appCompatImageView, materialTextView4, materialTextView5, q45VarA, progressLayout, recyclerView3, materialTextView6, recyclerView4, materialTextView7, appCompatImageView2, nestedScrollView, materialTextView8, viewA3, swipeRefreshLayout, frameLayout, p55.a(viewA4));
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static v3 b(LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static v3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.j, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i35
    public View getRoot() {
        return this.a;
    }
}
