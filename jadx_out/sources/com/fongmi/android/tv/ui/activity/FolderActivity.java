package com.fongmi.android.tv.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.fongmi.android.tv.bean.Class;
import com.fongmi.android.tv.bean.Result;
import defpackage.d3;
import defpackage.i35;
import defpackage.nl3;
import defpackage.x31;
import defpackage.xg;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class FolderActivity extends xg {
    public d3 H;

    private Result V1() {
        return (Result) getIntent().getParcelableExtra("result");
    }

    public static void W1(Activity activity, String str, Result result) {
        if (result == null || result.getTypes().isEmpty()) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) FolderActivity.class);
        intent.putExtra("key", str);
        intent.putExtra("result", result);
        activity.startActivity(intent);
    }

    @Override // defpackage.x7
    public void D1(Toolbar toolbar) {
        super.D1(toolbar);
        u1().r(true);
    }

    @Override // defpackage.xg
    public i35 J1() {
        d3 d3VarC = d3.c(getLayoutInflater());
        this.H = d3VarC;
        return d3VarC;
    }

    @Override // defpackage.xg
    public void L1(Bundle bundle) {
        D1(this.H.c);
        Class r4 = V1().getTypes().get(0);
        setTitle(r4.getTypeName());
        n1().o().r(nl3.J, x31.I2(U1(), r4, 8), "0").h();
    }

    @Override // defpackage.xg
    public void P1() {
        if (T1().t2()) {
            T1().H2();
        } else {
            super.P1();
        }
    }

    public final x31 T1() {
        return (x31) n1().j0("0");
    }

    public final String U1() {
        return getIntent().getStringExtra("key");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            P1();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
