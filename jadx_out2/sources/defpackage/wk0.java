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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wk0(LinearLayoutCompat linearLayoutCompat, ViewPager2 viewPager2, TabLayout tabLayout) {
        this.a = linearLayoutCompat;
        this.b = viewPager2;
        this.c = tabLayout;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wk0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(fm3.Q, viewGroup, false);
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
