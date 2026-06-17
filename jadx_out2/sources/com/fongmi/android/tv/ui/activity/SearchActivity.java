package com.fongmi.android.tv.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import defpackage.i35;
import defpackage.nl3;
import defpackage.pz3;
import defpackage.u3;
import defpackage.xg;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class SearchActivity extends xg {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void U1(Activity activity) {
        V1(activity, "");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void V1(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SearchActivity.class);
        intent.putExtra("keyword", str);
        activity.startActivity(intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public i35 J1() {
        return u3.c(getLayoutInflater());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public void L1(Bundle bundle) {
        if (bundle == null) {
            n1().o().r(nl3.J, pz3.T2(T1()), pz3.class.getSimpleName()).h();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public void P1() {
        if (n1().q0() > 0) {
            n1().X0();
        } else {
            super.P1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String T1() {
        return getIntent().getStringExtra("keyword");
    }
}
