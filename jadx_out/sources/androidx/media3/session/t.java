package androidx.media3.session;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.media3.session.l;
import androidx.media3.session.s;
import androidx.media3.session.t;
import defpackage.c30;
import defpackage.d24;
import defpackage.dl3;
import defpackage.du2;
import defpackage.e43;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.lu1;
import defpackage.pw4;
import defpackage.v81;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xz1;
import defpackage.y14;
import defpackage.z20;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Handler.Callback {
    public final x f;
    public final s.a g;
    public final NotificationManager h;
    public final Handler i = fy4.D(Looper.getMainLooper(), this);
    public final Executor j = new Executor() { // from class: ei2
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            fy4.o1(this.f.i, runnable);
        }
    };
    public final Intent k;
    public final String l;
    public final Map m;
    public s.b n;
    public int o;
    public s p;
    public boolean q;
    public boolean r;
    public boolean s;
    public long t;
    public int u;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements v81 {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // defpackage.v81
        public void b(Throwable th) {
            xz1.j("MediaNtfMng", "custom command " + this.a + " produced an error: " + th.getMessage(), th);
        }

        @Override // defpackage.v81
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(d24 d24Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final lu1 a;
        public boolean b;
        public boolean c;

        public b(lu1 lu1Var) {
            this.a = lu1Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements l.c, hd3.d {
        public final x f;
        public final u g;

        public c(x xVar, u uVar) {
            this.f = xVar;
            this.g = uVar;
        }

        @Override // androidx.media3.session.l.c
        public lu1 A0(l lVar, y14 y14Var, Bundle bundle) {
            int i;
            if (y14Var.b.equals("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY")) {
                t.this.r(this.g);
                i = 0;
            } else {
                i = -6;
            }
            return x81.e(new d24(i));
        }

        @Override // androidx.media3.session.l.c
        public void F0(l lVar) {
            if (this.f.isSessionAdded(this.g)) {
                this.f.removeSession(this.g);
            }
            this.f.onUpdateNotificationInternal(this.g, false);
        }

        @Override // androidx.media3.session.l.c
        public void H(l lVar, d0 d0Var) {
            this.f.onUpdateNotificationInternal(this.g, false);
        }

        @Override // androidx.media3.session.l.c
        public void Q(l lVar, List list) {
            this.f.onUpdateNotificationInternal(this.g, false);
        }

        public void a(boolean z) {
            if (z) {
                this.f.onUpdateNotificationInternal(this.g, false);
            }
        }

        @Override // hd3.d
        public void onEvents(hd3 hd3Var, hd3.c cVar) {
            if (cVar.a(4, 5, 14, 0)) {
                this.f.onUpdateNotificationInternal(this.g, false);
            }
        }
    }

    public t(x xVar, s.b bVar, s.a aVar) {
        this.f = xVar;
        this.n = bVar;
        this.g = aVar;
        this.h = (NotificationManager) gg3.q((NotificationManager) xVar.getSystemService("notification"));
        Intent intent = new Intent(xVar, xVar.getClass());
        this.k = intent;
        String string = UUID.randomUUID().toString();
        this.l = string;
        intent.putExtra("androidx.media3.session.intent.uid", string);
        this.m = new HashMap();
        this.q = false;
        this.s = true;
        this.t = x.DEFAULT_FOREGROUND_SERVICE_TIMEOUT_MS;
        this.u = 3;
    }

    public static /* synthetic */ void e(final t tVar, u uVar, final String str, final Bundle bundle, final l lVar) {
        if (tVar.n.a(uVar, str, bundle)) {
            return;
        }
        tVar.j.execute(new Runnable() { // from class: ki2
            @Override // java.lang.Runnable
            public final void run() {
                this.f.v(lVar, str, bundle);
            }
        });
    }

    public static /* synthetic */ void f(final t tVar, final u uVar, xi1 xi1Var, s.b.a aVar, final boolean z) {
        final s sVarC = tVar.n.c(uVar, xi1Var, tVar.g, aVar);
        gg3.w(sVarC.a != 20938, "notification ID 20938 is already used internally.");
        tVar.j.execute(new Runnable() { // from class: hi2
            @Override // java.lang.Runnable
            public final void run() {
                this.f.D(uVar, sVarC, z);
            }
        });
    }

    public static /* synthetic */ void h(t tVar, lu1 lu1Var, c cVar, u uVar) {
        tVar.getClass();
        try {
            l lVar = (l) lu1Var.get(0L, TimeUnit.MILLISECONDS);
            cVar.a(tVar.A(uVar));
            lVar.addListener(cVar);
        } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException unused) {
            tVar.f.removeSession(uVar);
        }
    }

    public final boolean A(u uVar) {
        l lVarM = m(uVar);
        if (lVarM == null || lVarM.getCurrentTimeline().w()) {
            return false;
        }
        b bVar = (b) gg3.q((b) this.m.get(uVar));
        if (lVarM.getPlaybackState() != 1) {
            bVar.b = false;
            bVar.c = true;
            return true;
        }
        int i = this.u;
        if (i == 1) {
            return !bVar.b;
        }
        if (i != 2) {
            if (i == 3) {
                return !bVar.b && bVar.c;
            }
            z20.a();
        }
        return false;
    }

    public final void B(s sVar) {
        c30.l(this.f, this.k);
        fy4.B1(this.f, sVar.a, sVar.b, 2, "mediaPlayback");
        this.q = true;
    }

    public void C(final u uVar, final boolean z) {
        if (!this.f.isSessionAdded(uVar) || !A(uVar)) {
            t();
            return;
        }
        final int i = this.o + 1;
        this.o = i;
        final xi1 xi1VarH = ((l) gg3.q(m(uVar))).h();
        final s.b.a aVar = new s.b.a() { // from class: fi2
            @Override // androidx.media3.session.s.b.a
            public final void a(s sVar) {
                t tVar = this.a;
                tVar.j.execute(new Runnable() { // from class: li2
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.s(i, uVar, sVar);
                    }
                });
            }
        };
        fy4.o1(new Handler(uVar.m().getApplicationLooper()), new Runnable() { // from class: gi2
            @Override // java.lang.Runnable
            public final void run() {
                t.f(this.f, uVar, xi1VarH, aVar, z);
            }
        });
    }

    public final void D(u uVar, s sVar, boolean z) {
        sVar.b.extras.putParcelable("android.mediaSession", uVar.l());
        this.p = sVar;
        if (z) {
            B(sVar);
        } else {
            this.h.notify(sVar.a, sVar.b);
            fy4.J1(this.f, false);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        List<u> sessions = this.f.getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            this.f.onUpdateNotificationInternal(sessions.get(i), false);
        }
        return true;
    }

    public void j(final u uVar) {
        if (this.m.containsKey(uVar)) {
            return;
        }
        final c cVar = new c(this.f, uVar);
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.media3.session.MediaNotificationManager", true);
        final lu1 lu1VarB = new l.a(this.f, uVar.p()).d(bundle).e(cVar).c(Looper.getMainLooper()).b();
        this.m.put(uVar, new b(lu1VarB));
        lu1VarB.g(new Runnable() { // from class: ji2
            @Override // java.lang.Runnable
            public final void run() {
                t.h(this.f, lu1VarB, cVar, uVar);
            }
        }, this.j);
    }

    public Pair k(Context context) {
        s.b.C0033b c0033bB = this.n.b();
        fy4.K(this.h, c0033bB.a(), c0033bB.b());
        e43.c cVar = new e43.c(context, c0033bB.a());
        if (Build.VERSION.SDK_INT >= 31) {
            cVar.j(2);
        }
        return new Pair(20938, cVar.n(true).p(dl3.v0).s(-1).m(false).b());
    }

    public void l() {
        this.s = false;
        if (this.i.hasMessages(1)) {
            this.i.removeMessages(1);
            List<u> sessions = this.f.getSessions();
            for (int i = 0; i < sessions.size(); i++) {
                this.f.onUpdateNotificationInternal(sessions.get(i), false);
            }
        }
    }

    public final l m(u uVar) {
        b bVar = (b) this.m.get(uVar);
        if (bVar == null || !bVar.a.isDone()) {
            return null;
        }
        try {
            return (l) x81.c(bVar.a);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    public String n() {
        return this.l;
    }

    public final boolean o(boolean z) {
        List<u> sessions = this.f.getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            l lVarM = m(sessions.get(i));
            if (lVarM != null && ((lVarM.getPlayWhenReady() || z) && (lVarM.getPlaybackState() == 3 || lVarM.getPlaybackState() == 2))) {
                return true;
            }
        }
        return false;
    }

    public boolean p() {
        return this.q;
    }

    public void q(final u uVar, final String str, final Bundle bundle) {
        final l lVarM = m(uVar);
        if (lVarM == null) {
            return;
        }
        fy4.o1(new Handler(uVar.m().getApplicationLooper()), new Runnable() { // from class: ii2
            @Override // java.lang.Runnable
            public final void run() {
                t.e(this.f, uVar, str, bundle, lVarM);
            }
        });
    }

    public final void r(u uVar) {
        b bVar = (b) this.m.get(uVar);
        if (bVar != null) {
            bVar.b = true;
        }
    }

    public final void s(int i, u uVar, s sVar) {
        if (i == this.o) {
            D(uVar, sVar, z(false));
        }
    }

    public final void t() {
        fy4.J1(this.f, true);
        s sVar = this.p;
        if (sVar != null) {
            this.h.cancel(sVar.a);
            this.o++;
            this.p = null;
        }
    }

    public void u(u uVar) {
        b bVar = (b) this.m.remove(uVar);
        if (bVar != null) {
            l.m(bVar.a);
        }
    }

    public final void v(l lVar, String str, Bundle bundle) {
        y14 y14Var;
        pw4 it = lVar.e().a.iterator();
        while (true) {
            if (!it.hasNext()) {
                y14Var = null;
                break;
            }
            y14Var = (y14) it.next();
            if (y14Var.a == 0 && y14Var.b.equals(str)) {
                break;
            }
        }
        if (y14Var != null || androidx.media3.session.a.w(str)) {
            x81.a(lVar.o(new y14(str, bundle), bundle), new a(str), du2.b());
        }
    }

    public void w(s.b bVar) {
        this.n = bVar;
    }

    public void x(int i) {
        this.u = i;
        List<u> sessions = this.f.getSessions();
        for (int i2 = 0; i2 < sessions.size(); i2++) {
            this.f.onUpdateNotificationInternal(sessions.get(i2), false);
        }
    }

    public void y(long j) {
        this.t = j;
    }

    public boolean z(boolean z) {
        boolean zO = o(z);
        boolean z2 = this.s && this.t > 0;
        if (this.r && !zO && z2) {
            this.i.sendEmptyMessageDelayed(1, this.t);
        } else if (zO) {
            this.i.removeMessages(1);
        }
        this.r = zO;
        return zO || this.i.hasMessages(1);
    }
}
