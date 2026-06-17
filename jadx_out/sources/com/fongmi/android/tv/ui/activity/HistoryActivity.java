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
import com.fongmi.android.tv.bean.History;
import defpackage.ak4;
import defpackage.e3;
import defpackage.fh3;
import defpackage.i35;
import defpackage.im3;
import defpackage.lh4;
import defpackage.nl3;
import defpackage.o52;
import defpackage.qp3;
import defpackage.rh;
import defpackage.sm3;
import defpackage.xd1;
import defpackage.xg;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class HistoryActivity extends xg implements xd1.a {
    public e3 H;
    public xd1 I;

    private void c2() {
        this.H.c.setHasFixedSize(true);
        this.H.c.setLayoutManager(new GridLayoutManager(this, fh3.a(this)));
        RecyclerView recyclerView = this.H.c;
        xd1 xd1Var = new xd1(this);
        this.I = xd1Var;
        recyclerView.setAdapter(xd1Var);
        this.I.h0(fh3.e(this));
    }

    public static void d2(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) HistoryActivity.class));
    }

    @Override // xd1.a
    public void B0(History history) {
        VideoActivity.n8(this, history.getSiteKey(), history.getVodId(), history.getVodName(), history.getVodPic());
    }

    @Override // defpackage.x7
    public void D1(Toolbar toolbar) {
        super.D1(toolbar);
        u1().r(true);
    }

    @Override // defpackage.xg
    public i35 J1() {
        e3 e3VarC = e3.c(getLayoutInflater());
        this.H = e3VarC;
        return e3VarC;
    }

    @Override // defpackage.xg
    public void L1(Bundle bundle) {
        D1(this.H.d);
        c2();
        W1();
    }

    @Override // defpackage.xg
    public void P1() {
        if (this.I.a0()) {
            this.I.g0(false);
        } else {
            super.P1();
        }
    }

    @Override // xd1.a
    public void R(History history) {
        this.I.Q(history.delete(), new Runnable() { // from class: ud1
            @Override // java.lang.Runnable
            public final void run() {
                this.f.Z1();
            }
        });
    }

    public final void W1() {
        this.I.S(History.get(), new rh.a() { // from class: sd1
            @Override // rh.a
            public final void a(boolean z) {
                this.a.X1(z);
            }
        });
    }

    public final /* synthetic */ void X1(boolean z) {
        this.H.b.f(true, this.I.g());
        if (z) {
            this.H.c.t1(0);
        }
    }

    public final /* synthetic */ void Y1(DialogInterface dialogInterface, int i) {
        this.I.K();
    }

    public final /* synthetic */ void Z1() {
        if (this.I.g() == 0) {
            this.I.g0(false);
        }
    }

    public final void a2() {
        if (this.I.a0()) {
            new o52(this).m(sm3.s).e(sm3.q).setNegativeButton(sm3.u, null).setPositiveButton(sm3.v, new DialogInterface.OnClickListener() { // from class: td1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f.Y1(dialogInterface, i);
                }
            }).n();
        } else if (this.I.g() > 0) {
            this.I.g0(true);
        }
    }

    public final void b2() {
        ak4.b3().f3().s3(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(im3.a, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            P1();
        } else if (menuItem.getItemId() == nl3.S) {
            a2();
        } else if (menuItem.getItemId() == nl3.b2) {
            b2();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onRefreshEvent(qp3 qp3Var) {
        if (qp3Var.e().equals(qp3.a.HISTORY)) {
            W1();
        }
    }

    @Override // xd1.a
    public boolean v() {
        this.I.g0(!r2.a0());
        return true;
    }
}
