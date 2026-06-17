package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import defpackage.r8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b extends r8 {
    public boolean y0;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C0062b extends BottomSheetBehavior.g {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0062b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i) {
            if (i == 5) {
                b.this.I2();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r8, defpackage.zk0
    public Dialog B2(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(U(), A2());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I2() {
        if (this.y0) {
            super.x2();
        } else {
            super.w2();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J2(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        this.y0 = z;
        if (bottomSheetBehavior.getState() == 5) {
            I2();
            return;
        }
        if (z2() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) z2()).p();
        }
        bottomSheetBehavior.h0(new C0062b());
        bottomSheetBehavior.a(5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean K2(boolean z) {
        Dialog dialogZ2 = z2();
        if (!(dialogZ2 instanceof com.google.android.material.bottomsheet.a)) {
            return false;
        }
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogZ2;
        BottomSheetBehavior bottomSheetBehaviorM = aVar.m();
        if (!bottomSheetBehaviorM.I0() || !aVar.n()) {
            return false;
        }
        J2(bottomSheetBehaviorM, z);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zk0
    public void w2() {
        if (K2(false)) {
            return;
        }
        super.w2();
    }
}
