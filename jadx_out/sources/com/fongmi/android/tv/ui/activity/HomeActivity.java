package com.fongmi.android.tv.ui.activity;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.a;
import androidx.core.graphics.drawable.IconCompat;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.db.AppDatabase;
import com.fongmi.android.tv.receiver.ShortcutReceiver;
import com.fongmi.android.tv.service.PlaybackService;
import defpackage.b75;
import defpackage.be4;
import defpackage.c00;
import defpackage.db4;
import defpackage.f3;
import defpackage.g01;
import defpackage.i35;
import defpackage.i43;
import defpackage.j23;
import defpackage.j64;
import defpackage.jm3;
import defpackage.k61;
import defpackage.lh4;
import defpackage.lx1;
import defpackage.m64;
import defpackage.m85;
import defpackage.nl3;
import defpackage.o75;
import defpackage.p51;
import defpackage.pc4;
import defpackage.q24;
import defpackage.q53;
import defpackage.qp3;
import defpackage.qx4;
import defpackage.sm3;
import defpackage.t14;
import defpackage.ta3;
import defpackage.to;
import defpackage.u14;
import defpackage.u44;
import defpackage.x61;
import defpackage.xg;
import defpackage.z34;
import fi.iki.elonen.NanoHTTPD;
import java.util.function.Consumer;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class HomeActivity extends xg implements j23.c {
    public x61 H;
    public f3 I;
    public int J;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends x61 {
        public a(ViewGroup viewGroup, k61 k61Var) {
            super(viewGroup, k61Var);
        }

        @Override // defpackage.x61
        public p51 d(int i) {
            if (i == 0) {
                return o75.e3();
            }
            if (i == 1) {
                return z34.B3();
            }
            if (i == 2) {
                return u44.W2();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends to {
        public b() {
        }

        @Override // defpackage.to
        public void b(String str) {
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.c2(homeActivity.getIntent());
            be4.c();
            i43.i(str);
        }

        @Override // defpackage.to
        public void d() {
            HomeActivity homeActivity = HomeActivity.this;
            homeActivity.c2(homeActivity.getIntent());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends to {
        public c() {
        }

        @Override // defpackage.to
        public void d() {
            HomeActivity.this.n2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c00.a.values().length];
            a = iArr;
            try {
                iArr[c00.a.VOD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c00.a.COMMON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c00.a.BOOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private to f2() {
        return new b();
    }

    @Override // j23.c
    public boolean C(MenuItem menuItem) {
        if (this.I.c.getSelectedItemId() == menuItem.getItemId()) {
            return false;
        }
        if (menuItem.getItemId() == nl3.Q1) {
            return this.H.b(1);
        }
        if (menuItem.getItemId() == nl3.D2) {
            return this.H.b(0);
        }
        if (menuItem.getItemId() == nl3.D0) {
            return n2();
        }
        return false;
    }

    @Override // defpackage.xg
    public i35 J1() {
        f3 f3VarC = f3.c(getLayoutInflater());
        this.I = f3VarC;
        return f3VarC;
    }

    @Override // defpackage.xg
    public void K1() {
        this.I.c.setOnItemSelectedListener(this);
        this.I.c.findViewById(nl3.D0).setOnLongClickListener(new View.OnLongClickListener() { // from class: nf1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.a2(view);
            }
        });
    }

    @Override // defpackage.xg
    public void L1(Bundle bundle) {
        if (!q24.G()) {
            p2();
            return;
        }
        this.J = getResources().getConfiguration().orientation;
        h2(bundle);
        g2();
    }

    @Override // defpackage.xg
    public void P1() {
        if (!this.I.c.getMenu().findItem(nl3.D2).isVisible()) {
            o2();
            return;
        }
        if (this.H.f(2)) {
            b2(1);
            return;
        }
        if (this.H.f(1)) {
            this.I.c.setSelectedItemId(nl3.D2);
        } else if (this.H.a(0)) {
            if (PlaybackService.isRunning()) {
                moveTaskToBack(true);
            } else {
                super.P1();
            }
        }
    }

    public final boolean a2(View view) {
        m64.b(this, new j64.b(this, getString(sm3.O)).b(IconCompat.e(this, jm3.a)).c(new Intent("android.intent.action.VIEW", null, this, LiveActivity.class)).e(getString(sm3.O)).a(), PendingIntent.getBroadcast(this, 0, new Intent(this, (Class<?>) ShortcutReceiver.class).setAction(ShortcutReceiver.a), 201326592).getIntentSender());
        return true;
    }

    public void b2(int i) {
        this.H.b(i);
    }

    public final void c2(final Intent intent) {
        if ("android.intent.action.SEND".equals(intent.getAction())) {
            VideoActivity.m7(this, intent.getStringExtra("android.intent.extra.TEXT"));
            return;
        }
        if ("android.intent.action.VIEW".equals(intent.getAction()) && intent.getData() != null) {
            ta3.b(this, new Consumer() { // from class: mf1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.i2(intent, (Boolean) obj);
                }
            });
        } else if ("android.intent.action.SEARCH".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("query");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            SearchActivity.V1(this, stringExtra);
        }
    }

    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public final void j2(Configuration configuration) {
        int i = this.J;
        int i2 = configuration.orientation;
        if (i != i2) {
            this.J = i2;
            qp3.h();
        }
    }

    public final void e2(Intent intent) {
        if (!NanoHTTPD.MIME_PLAINTEXT.equals(intent.getType()) && !qx4.f(intent.getData()).endsWith(".m3u")) {
            VideoActivity.m7(this, intent.getData().toString());
            return;
        }
        m2("file:/" + g01.m(intent.getData()));
    }

    public final void g2() {
        b75.I().c0().n(f2());
        lx1.J().U().a0();
        m85.x().z();
    }

    public final void h2(Bundle bundle) {
        a aVar = new a(this.I.b, n1());
        this.H = aVar;
        if (bundle == null) {
            aVar.b(0);
        }
    }

    public final /* synthetic */ void i2(Intent intent, Boolean bool) {
        e2(intent);
    }

    public final /* synthetic */ void k2(DialogInterface dialogInterface, int i) {
        q24.Y(true);
        dialogInterface.dismiss();
        L1(null);
    }

    public final /* synthetic */ void l2(DialogInterface dialogInterface, int i) {
        finishAffinity();
    }

    public final void m2(String str) {
        lx1.b0(Config.find(str, 1), new c());
    }

    public final boolean n2() {
        LiveActivity.V5(this);
        return false;
    }

    public final void o2() {
        this.I.c.getMenu().findItem(nl3.D2).setVisible(true);
        this.I.c.getMenu().findItem(nl3.Q1).setVisible(true);
        this.I.c.getMenu().findItem(nl3.D0).setVisible(lx1.T());
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onConfigEvent(c00 c00Var) {
        int i = d.a[c00Var.h().ordinal()];
        if (i == 1) {
            qp3.h();
        } else if (i == 2) {
            o2();
        } else {
            if (i != 3) {
                return;
            }
            LiveActivity.V5(this);
        }
    }

    @Override // defpackage.x7, defpackage.iy, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        App.e(new Runnable() { // from class: qf1
            @Override // java.lang.Runnable
            public final void run() {
                this.f.j2(configuration);
            }
        }, 100L);
    }

    @Override // defpackage.xg, defpackage.u51, defpackage.iy, defpackage.ky, android.app.Activity
    public void onCreate(Bundle bundle) {
        pc4.c(this);
        super.onCreate(bundle);
    }

    @Override // defpackage.xg, defpackage.x7, defpackage.u51, android.app.Activity
    public void onDestroy() {
        lx1.J().G();
        b75.I().G();
        AppDatabase.M();
        q53.n().i();
        db4.f().d();
        t14.b().j();
        super.onDestroy();
    }

    @Override // defpackage.iy, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c2(intent);
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onServerEvent(u14 u14Var) {
        if (u14Var.h() == u14.a.PUSH) {
            VideoActivity.m7(this, u14Var.g());
        }
        if (u14Var.h() == u14.a.SEARCH) {
            SearchActivity.V1(this, u14Var.g());
        }
    }

    public final void p2() {
        androidx.appcompat.app.a aVarCreate = new a.C0002a(this).m(sm3.z).e(sm3.y).setPositiveButton(sm3.w, new DialogInterface.OnClickListener() { // from class: of1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.k2(dialogInterface, i);
            }
        }).setNegativeButton(sm3.x, new DialogInterface.OnClickListener() { // from class: pf1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.l2(dialogInterface, i);
            }
        }).b(false).create();
        aVarCreate.show();
        aVarCreate.h(-1).requestFocus();
    }
}
