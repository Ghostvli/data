package com.fongmi.android.tv.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Keep;
import defpackage.ak4;
import defpackage.b75;
import defpackage.eq1;
import defpackage.fh3;
import defpackage.g3;
import defpackage.i35;
import defpackage.i43;
import defpackage.im3;
import defpackage.lh4;
import defpackage.nl3;
import defpackage.o52;
import defpackage.qp3;
import defpackage.sm3;
import defpackage.to;
import defpackage.xg;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class KeepActivity extends xg implements eq1.a {
    public g3 H;
    public eq1 I;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends to {
        public final /* synthetic */ Keep f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Keep keep) {
            this.f = keep;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.to
        public void b(String str) {
            i43.i(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.to
        public void d() {
            VideoActivity.n8(KeepActivity.this.I1(), this.f.getSiteKey(), this.f.getVodId(), this.f.getVodName(), this.f.getVodPic());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(DialogInterface dialogInterface, int i) {
        this.I.K();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2() {
        if (this.I.g() == 0) {
            this.I.g0(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void c2() {
        if (this.I.a0()) {
            new o52(this).m(sm3.s).e(sm3.r).setNegativeButton(sm3.u, null).setPositiveButton(sm3.v, new DialogInterface.OnClickListener() { // from class: zp1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f.Z1(dialogInterface, i);
                }
            }).n();
        } else if (this.I.g() > 0) {
            this.I.g0(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void d2() {
        ak4.b3().g3().s3(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void e2() {
        this.H.c.setHasFixedSize(true);
        this.H.c.setLayoutManager(new GridLayoutManager(this, fh3.a(this)));
        RecyclerView recyclerView = this.H.c;
        eq1 eq1Var = new eq1(this);
        this.I = eq1Var;
        recyclerView.setAdapter(eq1Var);
        this.I.h0(fh3.e(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f2(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) KeepActivity.class));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x7
    public void D1(Toolbar toolbar) {
        super.D1(toolbar);
        u1().r(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public i35 J1() {
        g3 g3VarC = g3.c(getLayoutInflater());
        this.H = g3VarC;
        return g3VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public void L1(Bundle bundle) {
        D1(this.H.d);
        e2();
        X1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public void P1() {
        if (this.I.a0()) {
            this.I.g0(false);
        } else {
            super.P1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X1() {
        this.I.T(Keep.getVod(), new Runnable() { // from class: aq1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.Y1();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void Y1() {
        this.H.b.f(true, this.I.g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b2(Config config, Keep keep) {
        b75.j0(config, new a(keep));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // eq1.a
    public void h0(Keep keep) {
        Config configFind = Config.find(keep.getCid());
        if (configFind == null) {
            SearchActivity.V1(this, keep.getVodName());
        } else if (keep.getCid() != b75.K()) {
            b2(configFind, keep);
        } else {
            VideoActivity.n8(this, keep.getSiteKey(), keep.getVodId(), keep.getVodName(), keep.getVodPic());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(im3.b, menu);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            P1();
        } else if (menuItem.getItemId() == nl3.S) {
            c2();
        } else if (menuItem.getItemId() == nl3.b2) {
            d2();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @lh4(threadMode = ThreadMode.MAIN)
    public void onRefreshEvent(qp3 qp3Var) {
        if (qp3Var.e().equals(qp3.a.KEEP)) {
            X1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // eq1.a
    public boolean v() {
        this.I.g0(!r2.a0());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // eq1.a
    public void v0(Keep keep) {
        this.I.Q(keep.delete(), new Runnable() { // from class: bq1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.a2();
            }
        });
    }
}
