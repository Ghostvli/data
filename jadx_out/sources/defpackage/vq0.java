package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.a;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vq0 extends a {
    public static float e(float f) {
        return (float) (1.0d - Math.cos((((double) f) * 3.141592653589793d) / 2.0d));
    }

    public static float f(float f) {
        return (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.a
    public void d(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float f2;
        float fE;
        RectF rectFA = a.a(tabLayout, view);
        RectF rectFA2 = a.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            f2 = e(f);
            fE = f(f);
        } else {
            f2 = f(f);
            fE = e(f);
        }
        drawable.setBounds(k7.c((int) rectFA.left, (int) rectFA2.left, f2), drawable.getBounds().top, k7.c((int) rectFA.right, (int) rectFA2.right, fE), drawable.getBounds().bottom);
    }
}
