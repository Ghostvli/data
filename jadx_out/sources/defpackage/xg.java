package defpackage;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xg extends x7 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends e63 {
        public a(boolean z) {
            super(z);
        }

        @Override // defpackage.e63
        public void d() {
            xg.this.P1();
        }
    }

    public boolean G1() {
        return true;
    }

    public final void H1() {
        kq0.a(this, kk4.a(0), kk4.a(0));
        if (Build.VERSION.SDK_INT >= 29) {
            getWindow().setStatusBarContrastEnforced(false);
            getWindow().setNavigationBarContrastEnforced(false);
        }
    }

    public u51 I1() {
        return this;
    }

    public abstract i35 J1();

    public void K1() {
    }

    public void L1(Bundle bundle) {
    }

    public boolean M1(View view) {
        return view.getVisibility() == 8;
    }

    public boolean N1(View view) {
        return view.getVisibility() == 0;
    }

    public void O1(ViewGroup viewGroup) {
        viewGroup.setPadding(0, 0, 0, 0);
    }

    public void P1() {
        finish();
    }

    public final void Q1() {
        y().h(this, new a(true));
    }

    public void R1(ViewGroup viewGroup) {
        S1(viewGroup, false);
    }

    public void S1(ViewGroup viewGroup, boolean z) {
        DisplayCutout cutout;
        if (Build.VERSION.SDK_INT >= 29 && (cutout = vr3.d(this).getCutout()) != null) {
            int safeInsetBottom = cutout.getSafeInsetBottom() | cutout.getSafeInsetTop() | cutout.getSafeInsetLeft() | cutout.getSafeInsetRight();
            viewGroup.setPadding(safeInsetBottom, 0, z ? 0 : safeInsetBottom, 0);
        }
    }

    @Override // defpackage.u51, defpackage.iy, defpackage.ky, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H1();
        setContentView(J1().getRoot());
        uu0.d().p(this);
        L1(bundle);
        Q1();
        K1();
    }

    @Override // defpackage.x7, defpackage.u51, android.app.Activity
    public void onDestroy() {
        uu0.d().r(this);
        super.onDestroy();
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onSubscribe(Object obj) {
    }

    @Override // defpackage.x7, defpackage.iy, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        if (G1()) {
            ((ViewGroup) findViewById(R.id.content)).addView(new z60(this, null), 0, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
