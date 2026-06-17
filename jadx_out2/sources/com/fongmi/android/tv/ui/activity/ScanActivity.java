package com.fongmi.android.tv.ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.b;
import defpackage.av4;
import defpackage.i35;
import defpackage.jy4;
import defpackage.rg;
import defpackage.sg;
import defpackage.t3;
import defpackage.xg;
import defpackage.ze0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ScanActivity extends xg implements rg {
    public t3 H;
    public b I;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public i35 J1() {
        t3 t3VarC = t3.c(getLayoutInflater());
        this.H = t3VarC;
        return t3VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public void L1(Bundle bundle) {
        this.I = new b(this, this.H.b);
        this.H.b.getBarcodeView().setDecoderFactory(new ze0(av4.a(new Object[]{BarcodeFormat.QR_CODE})));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rg
    public void R0(sg sgVar) {
        if (sgVar.e().startsWith("http")) {
            setResult(-1, new Intent().putExtra("address", sgVar.e()));
            finish();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x7, defpackage.iy, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        jy4.m(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg, defpackage.u51, defpackage.iy, defpackage.ky, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jy4.m(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg, defpackage.x7, defpackage.u51, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.I.r();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u51, android.app.Activity
    public void onPause() {
        super.onPause();
        this.I.s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u51, defpackage.iy, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.I.t(i, strArr, iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u51, android.app.Activity
    public void onResume() {
        super.onResume();
        this.I.u();
        this.H.b.b(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            jy4.m(this);
        }
    }
}
