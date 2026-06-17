package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.ui.custom.CustomViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class m71 implements i35 {
    public final CoordinatorLayout a;
    public final AppBarLayout b;
    public final FloatingActionButton c;
    public final FloatingActionButton d;
    public final AppCompatImageView e;
    public final CustomViewPager f;
    public final q45 g;
    public final MaterialTextView h;
    public final MaterialToolbar i;
    public final FloatingActionButton j;
    public final RecyclerView k;

    public m71(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton, FloatingActionButton floatingActionButton2, AppCompatImageView appCompatImageView, CustomViewPager customViewPager, q45 q45Var, MaterialTextView materialTextView, MaterialToolbar materialToolbar, FloatingActionButton floatingActionButton3, RecyclerView recyclerView) {
        this.a = coordinatorLayout;
        this.b = appBarLayout;
        this.c = floatingActionButton;
        this.d = floatingActionButton2;
        this.e = appCompatImageView;
        this.f = customViewPager;
        this.g = q45Var;
        this.h = materialTextView;
        this.i = materialToolbar;
        this.j = floatingActionButton3;
        this.k = recyclerView;
    }

    public static m71 a(View view) {
        View viewA;
        int i = nl3.j;
        AppBarLayout appBarLayout = (AppBarLayout) j35.a(view, i);
        if (appBarLayout != null) {
            i = nl3.f0;
            FloatingActionButton floatingActionButton = (FloatingActionButton) j35.a(view, i);
            if (floatingActionButton != null) {
                i = nl3.B0;
                FloatingActionButton floatingActionButton2 = (FloatingActionButton) j35.a(view, i);
                if (floatingActionButton2 != null) {
                    i = nl3.J0;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) j35.a(view, i);
                    if (appCompatImageView != null) {
                        i = nl3.V0;
                        CustomViewPager customViewPager = (CustomViewPager) j35.a(view, i);
                        if (customViewPager != null && (viewA = j35.a(view, (i = nl3.h1))) != null) {
                            q45 q45VarA = q45.a(viewA);
                            i = nl3.m2;
                            MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
                            if (materialTextView != null) {
                                i = nl3.n2;
                                MaterialToolbar materialToolbar = (MaterialToolbar) j35.a(view, i);
                                if (materialToolbar != null) {
                                    i = nl3.o2;
                                    FloatingActionButton floatingActionButton3 = (FloatingActionButton) j35.a(view, i);
                                    if (floatingActionButton3 != null) {
                                        i = nl3.t2;
                                        RecyclerView recyclerView = (RecyclerView) j35.a(view, i);
                                        if (recyclerView != null) {
                                            return new m71((CoordinatorLayout) view, appBarLayout, floatingActionButton, floatingActionButton2, appCompatImageView, customViewPager, q45VarA, materialTextView, materialToolbar, floatingActionButton3, recyclerView);
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

    public static m71 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.n0, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
