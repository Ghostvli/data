package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentContainerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f3 implements i35 {
    public final RelativeLayout a;
    public final FragmentContainerView b;
    public final BottomNavigationView c;

    public f3(RelativeLayout relativeLayout, FragmentContainerView fragmentContainerView, BottomNavigationView bottomNavigationView) {
        this.a = relativeLayout;
        this.b = fragmentContainerView;
        this.c = bottomNavigationView;
    }

    public static f3 a(View view) {
        int i = nl3.J;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) j35.a(view, i);
        if (fragmentContainerView != null) {
            i = nl3.P0;
            BottomNavigationView bottomNavigationView = (BottomNavigationView) j35.a(view, i);
            if (bottomNavigationView != null) {
                return new f3((RelativeLayout) view, fragmentContainerView, bottomNavigationView);
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static f3 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f3 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.e, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
