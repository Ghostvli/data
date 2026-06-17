package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wk0 implements i35 {
    public final LinearLayoutCompat a;
    public final ViewPager2 b;
    public final TabLayout c;

    public wk0(LinearLayoutCompat linearLayoutCompat, ViewPager2 viewPager2, TabLayout tabLayout) {
        this.a = linearLayoutCompat;
        this.b = viewPager2;
        this.c = tabLayout;
    }

    public static wk0 a(View view) {
        int i = nl3.V0;
        ViewPager2 viewPager2 = (ViewPager2) j35.a(view, i);
        if (viewPager2 != null) {
            i = nl3.c2;
            TabLayout tabLayout = (TabLayout) j35.a(view, i);
            if (tabLayout != null) {
                return new wk0((LinearLayoutCompat) view, viewPager2, tabLayout);
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static wk0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.Q, viewGroup, false);
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
