package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.google.android.material.bottomsheet.b;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nh extends b {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.material.bottomsheet.b, defpackage.r8, defpackage.zk0
    public Dialog B2(Bundle bundle) {
        final a aVar = (a) super.B2(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: mh
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.a.P2(aVar, dialogInterface);
            }
        });
        S2(aVar);
        return aVar;
    }

    public abstract i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N2() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O2() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void P2(a aVar, DialogInterface dialogInterface) {
        Q2(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q2(a aVar) {
        FrameLayout frameLayout = (FrameLayout) aVar.findViewById(ol3.c);
        if (T2()) {
            frameLayout.setBackgroundColor(vr3.c(rk3.c));
        }
        BottomSheetBehavior bottomSheetBehaviorX0 = BottomSheetBehavior.x0(frameLayout);
        bottomSheetBehaviorX0.a(3);
        bottomSheetBehaviorX0.i1(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R2(float f) {
        if (z2() == null || z2().getWindow() == null) {
            return;
        }
        z2().getWindow().setDimAmount(f);
        z2().getWindow().addFlags(2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S2(Dialog dialog) {
        u51 u51VarO = O();
        if (u51VarO == null || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Window window2 = u51VarO.getWindow();
        if (window2 == null || window == null) {
            return;
        }
        int i = window2.getAttributes().flags;
        window.setSoftInputMode(16);
        if ((i & 1024) == 1024) {
            window.addFlags(1024);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean T2() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p51
    public View Z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return M2(layoutInflater, viewGroup).getRoot();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zk0, defpackage.p51
    public void s1() {
        super.s1();
        if (Build.VERSION.SDK_INT < 29 || z2() == null || z2().getWindow() == null) {
            return;
        }
        z2().getWindow().setNavigationBarContrastEnforced(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p51
    public void u1(View view, Bundle bundle) {
        O2();
        N2();
    }
}
