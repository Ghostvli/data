package androidx.media3.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.i;
import androidx.media3.session.u;
import androidx.media3.session.w;
import androidx.media3.session.w.a;
import defpackage.ac3;
import defpackage.b24;
import defpackage.c24;
import defpackage.cd3;
import defpackage.ce;
import defpackage.d24;
import defpackage.dc3;
import defpackage.du2;
import defpackage.fg2;
import defpackage.fm2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.jr1;
import defpackage.kk0;
import defpackage.lu1;
import defpackage.no4;
import defpackage.ph2;
import defpackage.pi2;
import defpackage.qh2;
import defpackage.u43;
import defpackage.ue3;
import defpackage.v5;
import defpackage.v81;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xz1;
import defpackage.y14;
import defpackage.yb;
import defpackage.yn3;
import defpackage.z75;
import defpackage.zf2;
import defpackage.zn3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class w extends pi2.b {
    public static final int C;
    public ac3 A;
    public hd3.b B;
    public final androidx.media3.session.b f;
    public final v g;
    public final fm2 h;
    public final g i;
    public final e j;
    public final boolean k;
    public final v5 l;
    public final pi2 m;
    public final i n;
    public final ComponentName o;
    public z75 p;
    public final boolean q;
    public volatile long r;
    public v81 s;
    public int t;
    public h u;
    public Bundle v;
    public xi1 w;
    public xi1 x;
    public d0 y;
    public hd3.b z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements v81 {
        public final /* synthetic */ u.g a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public a(u.g gVar, boolean z, boolean z2) {
            this.a = gVar;
            this.b = z;
            this.c = z2;
        }

        public static /* synthetic */ void c(a aVar, u.i iVar, boolean z, boolean z2, u.g gVar) {
            ue3 ue3VarV0 = w.this.g.v0();
            a0.i(ue3VarV0, iVar);
            int playbackState = ue3VarV0.getPlaybackState();
            if (z) {
                if (playbackState == 1) {
                    ue3VarV0.r();
                } else if (playbackState == 4) {
                    ue3VarV0.s();
                }
            }
            if (z2) {
                ue3VarV0.q();
            }
            w.this.g.T0(gVar, new hd3.b.a().c(31, 2).e(1, z2).f());
        }

        @Override // defpackage.v81
        public void b(Throwable th) {
        }

        @Override // defpackage.v81
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(final u.i iVar) {
            Handler handlerE0 = w.this.g.e0();
            v vVar = w.this.g;
            final u.g gVar = this.a;
            final boolean z = this.b;
            final boolean z2 = this.c;
            fy4.o1(handlerE0, vVar.Q(gVar, new Runnable() { // from class: am2
                @Override // java.lang.Runnable
                public final void run() {
                    w.a.c(this.f, iVar, z, z2, gVar);
                }
            }));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements v81 {
        public final /* synthetic */ u.g a;
        public final /* synthetic */ int b;

        public b(u.g gVar, int i) {
            this.a = gVar;
            this.b = i;
        }

        public static /* synthetic */ void c(b bVar, int i, List list, u.g gVar) {
            w wVar = w.this;
            if (i == -1) {
                wVar.g.v0().addMediaItems(list);
            } else {
                wVar.g.v0().addMediaItems(i, list);
            }
            w.this.g.T0(gVar, new hd3.b.a().a(20).f());
        }

        @Override // defpackage.v81
        public void b(Throwable th) {
        }

        @Override // defpackage.v81
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(final List list) {
            Handler handlerE0 = w.this.g.e0();
            v vVar = w.this.g;
            final u.g gVar = this.a;
            final int i = this.b;
            fy4.o1(handlerE0, vVar.Q(gVar, new Runnable() { // from class: bm2
                @Override // java.lang.Runnable
                public final void run() {
                    w.b.c(this.f, i, list, gVar);
                }
            }));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends z75 {
        public final /* synthetic */ Handler f;
        public final /* synthetic */ ue3 g;
        public final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, int i2, int i3, String str, Handler handler, ue3 ue3Var, int i4) {
            super(i, i2, i3, str);
            this.f = handler;
            this.g = ue3Var;
            this.h = i4;
        }

        public static /* synthetic */ void e(ue3 ue3Var, int i, int i2) {
            if (ue3Var.isCommandAvailable(26) || ue3Var.isCommandAvailable(34)) {
                if (i == -100) {
                    if (ue3Var.isCommandAvailable(34)) {
                        ue3Var.setDeviceMuted(true, i2);
                        return;
                    } else {
                        ue3Var.setDeviceMuted(true);
                        return;
                    }
                }
                if (i == -1) {
                    if (ue3Var.isCommandAvailable(34)) {
                        ue3Var.decreaseDeviceVolume(i2);
                        return;
                    } else {
                        ue3Var.decreaseDeviceVolume();
                        return;
                    }
                }
                if (i == 1) {
                    if (ue3Var.isCommandAvailable(34)) {
                        ue3Var.increaseDeviceVolume(i2);
                        return;
                    } else {
                        ue3Var.increaseDeviceVolume();
                        return;
                    }
                }
                if (i == 100) {
                    if (ue3Var.isCommandAvailable(34)) {
                        ue3Var.setDeviceMuted(false, i2);
                        return;
                    } else {
                        ue3Var.setDeviceMuted(false);
                        return;
                    }
                }
                if (i != 101) {
                    xz1.i("VolumeProviderCompat", "onAdjustVolume: Ignoring unknown direction: " + i);
                } else if (ue3Var.isCommandAvailable(34)) {
                    ue3Var.setDeviceMuted(!ue3Var.p(), i2);
                } else {
                    ue3Var.setDeviceMuted(!ue3Var.p());
                }
            }
        }

        public static /* synthetic */ void f(ue3 ue3Var, int i, int i2) {
            if (ue3Var.isCommandAvailable(25) || ue3Var.isCommandAvailable(33)) {
                if (ue3Var.isCommandAvailable(33)) {
                    ue3Var.setDeviceVolume(i, i2);
                } else {
                    ue3Var.setDeviceVolume(i);
                }
            }
        }

        @Override // defpackage.z75
        public void b(final int i) {
            Handler handler = this.f;
            final ue3 ue3Var = this.g;
            final int i2 = this.h;
            fy4.o1(handler, new Runnable() { // from class: dm2
                @Override // java.lang.Runnable
                public final void run() {
                    w.c.e(ue3Var, i, i2);
                }
            });
        }

        @Override // defpackage.z75
        public void c(final int i) {
            Handler handler = this.f;
            final ue3 ue3Var = this.g;
            final int i2 = this.h;
            fy4.o1(handler, new Runnable() { // from class: cm2
                @Override // java.lang.Runnable
                public final void run() {
                    w.c.f(ue3Var, i, i2);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public static void a(pi2 pi2Var, ComponentName componentName) {
            try {
                ((MediaSession) gg3.q(pi2Var.d())).setMediaButtonBroadcastReceiver(componentName);
            } catch (IllegalArgumentException e) {
                if (!Build.MANUFACTURER.equals("motorola")) {
                    throw e;
                }
                xz1.e("MediaSessionLegacyStub", "caught IllegalArgumentException on a motorola device when attempting to set the media button broadcast receiver. See https://github.com/androidx/media/issues/1730 for details.", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends Handler {
        public final androidx.media3.session.b a;

        public e(Looper looper, androidx.media3.session.b bVar) {
            super(looper);
            this.a = bVar;
        }

        public void a(u.g gVar, long j) {
            removeMessages(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, gVar);
            sendMessageDelayed(obtainMessage(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, gVar), j);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            u.g gVar = (u.g) message.obj;
            if (this.a.p(gVar)) {
                ((u.f) gg3.q(gVar.c())).a(0);
                this.a.t(gVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f implements u.f {
        public final fm2.b a;

        public f(fm2.b bVar) {
            this.a = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != f.class) {
                return false;
            }
            return Objects.equals(this.a, ((f) obj).a);
        }

        public int hashCode() {
            return u43.b(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class g implements u.f {
        public Uri c;
        public ph2 a = ph2.M;
        public String b = "";
        public long d = -9223372036854775807L;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements v81 {
            public final /* synthetic */ ph2 a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Uri c;
            public final /* synthetic */ long d;

            public a(ph2 ph2Var, String str, Uri uri, long j) {
                this.a = ph2Var;
                this.b = str;
                this.c = uri;
                this.d = j;
            }

            @Override // defpackage.v81
            public void b(Throwable th) {
                if (this != w.this.s) {
                    return;
                }
                xz1.i("MediaSessionLegacyStub", w.I0(th));
            }

            @Override // defpackage.v81
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Bitmap bitmap) {
                if (this != w.this.s) {
                    return;
                }
                w.e1(w.this.m, androidx.media3.session.i.D(this.a, this.b, this.c, this.d, bitmap));
                w.this.g.Q0();
            }
        }

        public g() {
        }

        public static /* synthetic */ void M(g gVar, AtomicInteger atomicInteger, List list, List list2) {
            gVar.getClass();
            if (atomicInteger.incrementAndGet() == list.size()) {
                gVar.O(list2, list);
            }
        }

        @Override // androidx.media3.session.u.f
        public void A(int i, hd3.b bVar) {
            if (P()) {
                return;
            }
            ue3 ue3VarV0 = w.this.g.v0();
            w.this.V0(ue3VarV0);
            w.this.n1(ue3VarV0);
        }

        @Override // androidx.media3.session.u.f
        public void B(int i, boolean z, int i2) {
            if (P()) {
                return;
            }
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void C(int i, ac3 ac3Var) {
            if (P()) {
                return;
            }
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void E(int i, int i2, boolean z) {
            if (w.this.p != null) {
                z75 z75Var = w.this.p;
                if (z) {
                    i2 = 0;
                }
                z75Var.d(i2);
            }
        }

        @Override // androidx.media3.session.u.f
        public void F(int i, dc3 dc3Var) {
            if (P()) {
                return;
            }
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void G(int i, int i2, ac3 ac3Var) {
            if (P()) {
                return;
            }
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void I(int i, c24 c24Var, boolean z, boolean z2, int i2) {
            if (P()) {
                return;
            }
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void J(int i, ph2 ph2Var) {
            if (P()) {
                return;
            }
            Q();
        }

        @Override // androidx.media3.session.u.f
        public void L(int i, boolean z) {
            w.this.m.x(androidx.media3.session.i.L(z));
        }

        public final void O(List list, List list2) {
            Bitmap bitmap;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                lu1 lu1Var = (lu1) list.get(i);
                if (lu1Var != null) {
                    try {
                        bitmap = (Bitmap) x81.c(lu1Var);
                    } catch (CancellationException | ExecutionException e) {
                        xz1.c("MediaSessionLegacyStub", "Failed to get bitmap", e);
                        bitmap = null;
                    }
                } else {
                    bitmap = null;
                }
                arrayList.add(androidx.media3.session.i.O((fg2) list2.get(i), i, bitmap));
            }
            w.h1(w.this.m, arrayList);
        }

        public boolean P() {
            return w.this.A != null;
        }

        public final void Q() {
            long j;
            String str;
            Uri uri;
            g gVar;
            ph2 ph2Var;
            Uri uri2;
            ue3 ue3VarV0 = w.this.g.v0();
            fg2 fg2VarG = ue3VarV0.g();
            ph2 ph2VarL = ue3VarV0.l();
            long jK = ue3VarV0.o() ? -9223372036854775807L : ue3VarV0.k();
            String str2 = fg2VarG != null ? fg2VarG.a : "";
            Bitmap bitmap = null;
            Uri uri3 = (fg2VarG == null || (uri2 = fg2VarG.h.a) == null) ? null : uri2;
            if (Objects.equals(this.a, ph2VarL) && Objects.equals(this.b, str2) && Objects.equals(this.c, uri3) && this.d == jK) {
                return;
            }
            this.b = str2;
            this.c = uri3;
            this.a = ph2VarL;
            this.d = jK;
            lu1 lu1VarB = w.this.g.g0().b(ph2VarL);
            if (lu1VarB != null) {
                w.this.s = null;
                if (lu1VarB.isDone()) {
                    try {
                        bitmap = (Bitmap) x81.c(lu1VarB);
                    } catch (CancellationException | ExecutionException e) {
                        xz1.i("MediaSessionLegacyStub", w.I0(e));
                    }
                    j = jK;
                    str = str2;
                    uri = uri3;
                    gVar = this;
                    ph2Var = ph2VarL;
                } else {
                    j = jK;
                    uri = uri3;
                    ph2Var = ph2VarL;
                    str = str2;
                    gVar = this;
                    w.this.s = gVar.new a(ph2Var, str, uri, j);
                    v81 v81Var = w.this.s;
                    Handler handlerE0 = w.this.g.e0();
                    Objects.requireNonNull(handlerE0);
                    x81.a(lu1VarB, v81Var, new ce(handlerE0));
                }
            } else {
                j = jK;
                str = str2;
                uri = uri3;
                gVar = this;
                ph2Var = ph2VarL;
            }
            w.e1(w.this.m, androidx.media3.session.i.D(ph2Var, str, uri, j, bitmap));
        }

        public final void R(no4 no4Var) {
            if (!w.this.T0() || no4Var.w()) {
                w.h1(w.this.m, null);
                return;
            }
            final List listY = androidx.media3.session.i.y(no4Var);
            final ArrayList arrayList = new ArrayList();
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            Runnable runnable = new Runnable() { // from class: em2
                @Override // java.lang.Runnable
                public final void run() {
                    w.g.M(this.f, atomicInteger, listY, arrayList);
                }
            };
            for (int i = 0; i < listY.size(); i++) {
                ph2 ph2Var = ((fg2) listY.get(i)).e;
                if (ph2Var.k == null) {
                    arrayList.add(null);
                    runnable.run();
                } else {
                    lu1 lu1VarC = w.this.g.g0().c(ph2Var.k);
                    arrayList.add(lu1VarC);
                    Handler handlerE0 = w.this.g.e0();
                    Objects.requireNonNull(handlerE0);
                    lu1VarC.g(runnable, new ce(handlerE0));
                }
            }
        }

        @Override // androidx.media3.session.u.f
        public void a(int i) {
        }

        @Override // androidx.media3.session.u.f
        public void d(int i, PendingIntent pendingIntent) {
            w.this.m.w(pendingIntent);
        }

        @Override // androidx.media3.session.u.f
        public void e(int i, boolean z) {
            if (P()) {
                return;
            }
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void f(int i, no4 no4Var, int i2) {
            if (P()) {
                return;
            }
            R(no4Var);
            Q();
        }

        @Override // androidx.media3.session.u.f
        public void g(int i, ue3 ue3Var, ue3 ue3Var2) {
            no4 no4VarH = ue3Var2.h();
            if (ue3Var == null || !Objects.equals(ue3Var.h(), no4VarH)) {
                f(i, no4VarH, 0);
            }
            ph2 ph2VarM = ue3Var2.m();
            if (ue3Var == null || !Objects.equals(ue3Var.m(), ph2VarM)) {
                q(i, ph2VarM);
            }
            ph2 ph2VarL = ue3Var2.l();
            if (ue3Var == null || !Objects.equals(ue3Var.l(), ph2VarL)) {
                J(i, ph2VarL);
            }
            if (ue3Var == null || ue3Var.getShuffleModeEnabled() != ue3Var2.getShuffleModeEnabled()) {
                L(i, ue3Var2.getShuffleModeEnabled());
            }
            if (ue3Var == null || ue3Var.getRepeatMode() != ue3Var2.getRepeatMode()) {
                m(i, ue3Var2.getRepeatMode());
            }
            l(i, ue3Var2.getDeviceInfo());
            w.this.V0(ue3Var2);
            fg2 fg2VarG = ue3Var2.g();
            if (ue3Var == null || !Objects.equals(ue3Var.g(), fg2VarG)) {
                p(i, fg2VarG, 3);
            } else {
                if (P()) {
                    return;
                }
                w.this.n1(ue3Var2);
            }
        }

        @Override // androidx.media3.session.u.f
        public void h(int i, y14 y14Var, Bundle bundle) {
            if (bundle.isEmpty()) {
                bundle = y14Var.c;
            } else if (!y14Var.c.isEmpty()) {
                Bundle bundle2 = new Bundle(y14Var.c);
                bundle2.putAll(bundle);
                bundle = bundle2;
            }
            w.this.m.i(y14Var.b, bundle);
        }

        @Override // androidx.media3.session.u.f
        public void i(int i, List list) {
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void l(int i, kk0 kk0Var) {
            ue3 ue3VarV0 = w.this.g.v0();
            w.this.p = w.B0(ue3VarV0);
            z75 z75Var = w.this.p;
            w wVar = w.this;
            if (z75Var == null) {
                wVar.m.q(ue3VarV0.e());
            } else {
                wVar.m.r(w.this.p);
            }
        }

        @Override // androidx.media3.session.u.f
        public void m(int i, int i2) {
            w.this.m.v(androidx.media3.session.i.K(i2));
        }

        @Override // androidx.media3.session.u.f
        public void n(int i, hd3.e eVar, hd3.e eVar2, int i2) {
            if (P()) {
                return;
            }
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void p(int i, fg2 fg2Var, int i2) {
            if (P()) {
                return;
            }
            Q();
            w wVar = w.this;
            if (fg2Var == null) {
                wVar.m.u(0);
            } else {
                wVar.m.u(androidx.media3.session.i.e0(fg2Var.e.i));
            }
            w wVar2 = w.this;
            wVar2.n1(wVar2.g.v0());
        }

        @Override // androidx.media3.session.u.f
        public void q(int i, ph2 ph2Var) {
            if (P()) {
                return;
            }
            CharSequence charSequenceK = w.this.m.b().k();
            CharSequence charSequence = ph2Var.a;
            if (TextUtils.equals(charSequenceK, charSequence)) {
                return;
            }
            w wVar = w.this;
            wVar.i1(wVar.m, charSequence);
        }

        @Override // androidx.media3.session.u.f
        public void u(int i, yb ybVar) {
            if (w.this.g.v0().getDeviceInfo().a == 0) {
                w.this.m.q(ybVar);
            }
        }

        @Override // androidx.media3.session.u.f
        public void z(int i, int i2) {
            if (P()) {
                return;
            }
            w wVar = w.this;
            wVar.n1(wVar.g.v0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface j {
        void a(u.g gVar);
    }

    static {
        C = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public w(androidx.media3.session.v r11, android.net.Uri r12, android.os.Handler r13, android.os.Bundle r14, boolean r15, defpackage.xi1 r16, defpackage.xi1 r17, androidx.media3.session.d0 r18, hd3.b r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.w.<init>(androidx.media3.session.v, android.net.Uri, android.os.Handler, android.os.Bundle, boolean, xi1, xi1, androidx.media3.session.d0, hd3$b, android.os.Bundle):void");
    }

    public static z75 B0(ue3 ue3Var) {
        if (ue3Var.getDeviceInfo().a == 0) {
            return null;
        }
        hd3.b availableCommands = ue3Var.getAvailableCommands();
        int i2 = availableCommands.d(26, 34) ? availableCommands.d(25, 33) ? 2 : 1 : 0;
        Handler handler = new Handler(ue3Var.getApplicationLooper());
        int iJ = ue3Var.j();
        kk0 deviceInfo = ue3Var.getDeviceInfo();
        return new c(i2, deviceInfo.c, iJ, deviceInfo.d, handler, ue3Var, 1);
    }

    public static String I0(Throwable th) {
        return "Failed to load bitmap: " + th.getMessage();
    }

    public static /* synthetic */ void M(w wVar, int i2, fm2.b bVar, final j jVar, boolean z) {
        if (wVar.g.H0()) {
            return;
        }
        if (!wVar.m.g()) {
            xz1.i("MediaSessionLegacyStub", "Ignore incoming player command before initialization. command=" + i2 + ", pid=" + bVar.b());
            return;
        }
        final u.g gVarK1 = wVar.k1(bVar);
        if (gVarK1 == null) {
            return;
        }
        if (!wVar.f.q(gVarK1, i2)) {
            if (i2 != 1 || wVar.g.v0().getPlayWhenReady()) {
                return;
            }
            xz1.i("MediaSessionLegacyStub", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
            return;
        }
        if (wVar.g.S0(gVarK1, i2) != 0) {
            return;
        }
        wVar.g.Q(gVarK1, new Runnable() { // from class: ol2
            @Override // java.lang.Runnable
            public final void run() {
                w.h0(jVar, gVarK1);
            }
        }).run();
        if (z) {
            wVar.g.T0(gVarK1, new hd3.b.a().a(i2).f());
        }
    }

    public static ComponentName M0(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            return null;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    public static /* synthetic */ void O(lu1 lu1Var, ResultReceiver resultReceiver) {
        d24 d24Var;
        try {
            d24Var = (d24) gg3.r((d24) lu1Var.get(), "SessionResult must not be null");
        } catch (InterruptedException e2) {
            e = e2;
            xz1.j("MediaSessionLegacyStub", "Custom command failed", e);
            d24Var = new d24(-1);
        } catch (CancellationException e3) {
            xz1.j("MediaSessionLegacyStub", "Custom command cancelled", e3);
            d24Var = new d24(1);
        } catch (ExecutionException e4) {
            e = e4;
            xz1.j("MediaSessionLegacyStub", "Custom command failed", e);
            d24Var = new d24(-1);
        }
        resultReceiver.send(d24Var.a, d24Var.b);
    }

    public static /* synthetic */ void R(w wVar, y14 y14Var, Bundle bundle, ResultReceiver resultReceiver, u.g gVar) {
        v vVar = wVar.g;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        lu1 lu1VarM0 = vVar.M0(gVar, null, y14Var, bundle);
        if (resultReceiver != null) {
            a1(resultReceiver, lu1VarM0);
        } else {
            S0(lu1VarM0);
        }
    }

    public static void S0(Future future) {
    }

    public static boolean U0(Context context) {
        if (Build.VERSION.SDK_INT < 33 || fy4.O0(context)) {
            return false;
        }
        String str = Build.MANUFACTURER;
        return str.equals("Google") || str.equals("motorola") || str.equals("vivo") || str.equals("Sony") || str.equals("Nothing") || str.equals("unknown");
    }

    public static /* synthetic */ void V(w wVar, zf2 zf2Var, int i2, u.g gVar) {
        wVar.getClass();
        if (TextUtils.isEmpty(zf2Var.y())) {
            xz1.i("MediaSessionLegacyStub", "onAddQueueItem(): Media ID shouldn't be empty");
        } else {
            x81.a(wVar.g.K0(gVar, xi1.w(androidx.media3.session.i.t(zf2Var))), wVar.new b(gVar, i2), du2.b());
        }
    }

    public static /* synthetic */ void W(w wVar, yn3 yn3Var, u.g gVar) {
        fg2 fg2VarG = wVar.g.v0().g();
        if (fg2VarG == null) {
            return;
        }
        S0(wVar.g.X0(gVar, fg2VarG.a, yn3Var));
    }

    public static ComponentName Y0(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        if (listQueryBroadcastReceivers.isEmpty()) {
            return null;
        }
        jr1.a("Expected 1 broadcast receiver that handles android.intent.action.MEDIA_BUTTON, found ", listQueryBroadcastReceivers.size());
        return null;
    }

    public static /* synthetic */ void a0(w wVar, ue3 ue3Var) {
        wVar.m.p(wVar.A0(ue3Var));
        wVar.i.R(ue3Var.getAvailableCommands().c(17) ? ue3Var.getCurrentTimeline() : no4.a);
    }

    public static void a1(final ResultReceiver resultReceiver, final lu1 lu1Var) {
        lu1Var.g(new Runnable() { // from class: sl2
            @Override // java.lang.Runnable
            public final void run() {
                w.O(lu1Var, resultReceiver);
            }
        }, du2.b());
    }

    public static void d1(pi2 pi2Var, PendingIntent pendingIntent) {
        pi2Var.n(pendingIntent);
    }

    public static /* synthetic */ void e0(w wVar, y14 y14Var, int i2, fm2.b bVar, j jVar) {
        if (wVar.g.H0()) {
            return;
        }
        if (!wVar.m.g()) {
            StringBuilder sb = new StringBuilder("Ignore incoming session command before initialization. command=");
            sb.append(y14Var == null ? Integer.valueOf(i2) : y14Var.b);
            sb.append(", pid=");
            sb.append(bVar.b());
            xz1.i("MediaSessionLegacyStub", sb.toString());
            return;
        }
        u.g gVarK1 = wVar.k1(bVar);
        if (gVarK1 == null) {
            return;
        }
        androidx.media3.session.b bVar2 = wVar.f;
        if (y14Var != null) {
            if (!bVar2.s(gVarK1, y14Var)) {
                return;
            }
        } else if (!bVar2.r(gVarK1, i2)) {
            return;
        }
        try {
            jVar.a(gVarK1);
        } catch (RemoteException e2) {
            xz1.j("MediaSessionLegacyStub", "Exception in " + gVarK1, e2);
        }
    }

    public static void e1(pi2 pi2Var, qh2 qh2Var) {
        pi2Var.o(qh2Var);
    }

    public static /* synthetic */ void h0(j jVar, u.g gVar) {
        try {
            jVar.a(gVar);
        } catch (RemoteException e2) {
            xz1.j("MediaSessionLegacyStub", "Exception in " + gVar, e2);
        }
    }

    public static void h1(pi2 pi2Var, List list) {
        pi2Var.s(list);
    }

    public static /* synthetic */ void i0(w wVar, zf2 zf2Var, u.g gVar) {
        wVar.getClass();
        String strY = zf2Var.y();
        if (TextUtils.isEmpty(strY)) {
            xz1.i("MediaSessionLegacyStub", "onRemoveQueueItem(): Media ID shouldn't be null");
            return;
        }
        ue3 ue3VarV0 = wVar.g.v0();
        if (!ue3VarV0.isCommandAvailable(17)) {
            xz1.i("MediaSessionLegacyStub", "Can't remove item by ID without COMMAND_GET_TIMELINE being available");
            return;
        }
        no4 currentTimeline = ue3VarV0.getCurrentTimeline();
        no4.d dVar = new no4.d();
        for (int i2 = 0; i2 < currentTimeline.v(); i2++) {
            if (TextUtils.equals(currentTimeline.t(i2, dVar).c.a, strY)) {
                ue3VarV0.removeMediaItem(i2);
                return;
            }
        }
    }

    public static long y0(int i2, boolean z) {
        if (i2 == 1) {
            return z ? 516L : 514L;
        }
        if (i2 == 2) {
            return Http2Stream.EMIT_BUFFER_SIZE;
        }
        if (i2 == 3) {
            return 1L;
        }
        if (i2 == 31) {
            return 240640L;
        }
        switch (i2) {
            case 5:
                return 256L;
            case 6:
            case 7:
                return 16L;
            case 8:
            case 9:
                return 32L;
            case 10:
                return 4096L;
            case 11:
                return 8L;
            case 12:
                return 64L;
            case 13:
                return 4194304L;
            case 14:
                return 2621440L;
            case 15:
                return 262144L;
            default:
                return 0L;
        }
    }

    public static fg2 z0(String str, Uri uri, String str2, Bundle bundle) {
        fg2.c cVar = new fg2.c();
        if (str == null) {
            str = "";
        }
        return cVar.e(str).h(new fg2.i.a().f(uri).g(str2).e(bundle).d()).a();
    }

    @Override // pi2.b
    public void A() {
        if (this.g.v0().isCommandAvailable(7)) {
            E0(7, new j() { // from class: el2
                @Override // androidx.media3.session.w.j
                public final void a(u.g gVar) {
                    this.a.g.v0().seekToPrevious();
                }
            }, this.m.c(), true);
        } else {
            E0(6, new j() { // from class: fl2
                @Override // androidx.media3.session.w.j
                public final void a(u.g gVar) {
                    this.a.g.v0().seekToPreviousMediaItem();
                }
            }, this.m.c(), true);
        }
    }

    public final cd3 A0(ue3 ue3Var) {
        ac3 ac3Var;
        long bufferedPosition;
        h hVar = this.u;
        ac3 playerError = this.A;
        if (playerError == null && hVar != null && hVar.a) {
            Bundle bundle = new Bundle(hVar.d);
            bundle.putAll(this.v);
            return new cd3.b().h(7, -1L, 0.0f, SystemClock.elapsedRealtime()).c(0L).e(0L).g(bundle).f(hVar.b, (CharSequence) gg3.q(hVar.c)).g(hVar.d).b();
        }
        if (playerError == null) {
            playerError = ue3Var.getPlayerError();
        }
        boolean z = ue3Var.isCommandAvailable(16) && !ue3Var.isCurrentMediaItemLive();
        boolean z2 = playerError != null || fy4.D1(ue3Var, this.q);
        int iM = playerError != null ? 7 : androidx.media3.session.i.M(ue3Var, z2);
        hd3.b availableCommands = ue3Var.getAvailableCommands();
        hd3.b bVar = this.B;
        hd3.b bVarF = bVar != null ? a0.f(bVar, availableCommands) : a0.f(this.z, availableCommands);
        long jY0 = 128;
        for (int i2 = 0; i2 < bVarF.g(); i2++) {
            jY0 |= y0(bVarF.f(i2), z2);
        }
        if (!this.x.isEmpty() && androidx.media3.session.a.e(this.w, 2)) {
            jY0 &= -17;
        }
        if (!this.x.isEmpty() && androidx.media3.session.a.e(this.w, 3)) {
            jY0 &= -33;
        }
        if (!z) {
            jY0 &= -257;
        }
        long jP = ue3Var.isCommandAvailable(17) ? androidx.media3.session.i.P(ue3Var.getCurrentMediaItemIndex()) : -1L;
        float f2 = ue3Var.getPlaybackParameters().a;
        float f3 = (ue3Var.isPlaying() && z) ? f2 : 0.0f;
        Bundle bundle2 = playerError != null ? new Bundle(playerError.h) : new Bundle();
        if (playerError == null && hVar != null) {
            bundle2.putAll(hVar.d);
        }
        bundle2.putAll(this.v);
        bundle2.putFloat("EXO_SPEED", f2);
        fg2 fg2VarG = ue3Var.g();
        if (fg2VarG != null && !"".equals(fg2VarG.a)) {
            bundle2.putString("androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID", fg2VarG.a);
        }
        long currentPosition = z ? ue3Var.getCurrentPosition() : -1L;
        if (z) {
            ac3Var = playerError;
            bufferedPosition = ue3Var.getBufferedPosition();
        } else {
            ac3Var = playerError;
            bufferedPosition = -1;
        }
        ac3 ac3Var2 = ac3Var;
        cd3.b bVarG = new cd3.b().h(iM, currentPosition, f3, SystemClock.elapsedRealtime()).c(jY0).d(jP).e(bufferedPosition).g(bundle2);
        for (int i3 = 0; i3 < this.w.size(); i3++) {
            androidx.media3.session.a aVar = (androidx.media3.session.a) this.w.get(i3);
            y14 y14Var = aVar.a;
            if (y14Var != null && aVar.i && y14Var.a == 0 && (androidx.media3.session.a.u(aVar, this.y, bVarF) || androidx.media3.session.a.w(y14Var.b))) {
                boolean z3 = aVar.c != 0;
                boolean z4 = aVar.e != null;
                Bundle bundle3 = (z3 || z4 || !aVar.g.isEmpty()) ? new Bundle(y14Var.c) : y14Var.c;
                if (!aVar.g.isEmpty()) {
                    bundle3.putAll(aVar.g);
                }
                if (z3) {
                    bundle3.putInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", aVar.c);
                }
                if (z4) {
                    bundle3.putString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT", ((Uri) gg3.q(aVar.e)).toString());
                }
                bVarG.a(new cd3.c.b(y14Var.b, aVar.f, aVar.d).b(bundle3).a());
            }
        }
        if (ac3Var2 != null) {
            bVarG.f(androidx.media3.session.i.p(ac3Var2), ac3Var2.getMessage());
        } else if (hVar != null) {
            bVarG.f(hVar.b, hVar.c);
        }
        return bVarG.b();
    }

    @Override // pi2.b
    public void B(final long j2) {
        if (j2 < 0) {
            return;
        }
        E0(10, new j() { // from class: zk2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().seekToDefaultPosition((int) j2);
            }
        }, this.m.c(), true);
    }

    @Override // pi2.b
    public void C() {
        E0(3, new j() { // from class: nl2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().stop();
            }
        }, this.m.c(), true);
    }

    public final void C0(y14 y14Var) {
        try {
            final androidx.media3.session.a aVarF = androidx.media3.session.a.f(y14Var);
            if (!aVarF.d()) {
                xz1.i("MediaSessionLegacyStub", "Can't execute predefined custom command: " + y14Var.b);
                return;
            }
            y14 y14Var2 = aVarF.a;
            if (y14Var2 != null) {
                gg3.v(y14Var2.a == 40010);
                H0((yn3) gg3.q(aVarF.j));
            } else {
                if (aVarF.v(this.g.v0())) {
                    D0();
                    return;
                }
                int i2 = aVarF.b;
                if (i2 == 31) {
                    Q0((fg2) gg3.q(aVarF.j), false, false);
                } else {
                    E0(i2, new j() { // from class: ql2
                        @Override // androidx.media3.session.w.j
                        public final void a(u.g gVar) {
                            aVarF.k(this.a.g.v0());
                        }
                    }, this.m.c(), true);
                }
            }
        } catch (RuntimeException e2) {
            xz1.j("MediaSessionLegacyStub", "Failed to convert predefined custom command: " + y14Var.b, e2);
        }
    }

    public final void D0() {
        E0(1, new j() { // from class: kl2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.D0(gVar, true);
            }
        }, this.m.c(), false);
    }

    public final void E0(final int i2, final j jVar, final fm2.b bVar, final boolean z) {
        if (this.g.H0()) {
            return;
        }
        if (bVar != null) {
            fy4.o1(this.g.e0(), new Runnable() { // from class: yl2
                @Override // java.lang.Runnable
                public final void run() {
                    w.M(this.f, i2, bVar, jVar, z);
                }
            });
            return;
        }
        xz1.b("MediaSessionLegacyStub", "RemoteUserInfo is null, ignoring command=" + i2);
    }

    public final void F0(y14 y14Var, j jVar) {
        G0(y14Var, 0, jVar, this.m.c());
    }

    public final void G0(final y14 y14Var, final int i2, final j jVar, final fm2.b bVar) {
        if (bVar != null) {
            fy4.o1(this.g.e0(), new Runnable() { // from class: pl2
                @Override // java.lang.Runnable
                public final void run() {
                    w.e0(this.f, y14Var, i2, bVar, jVar);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder("RemoteUserInfo is null, ignoring command=");
        Object objValueOf = y14Var;
        if (y14Var == null) {
            objValueOf = Integer.valueOf(i2);
        }
        sb.append(objValueOf);
        xz1.b("MediaSessionLegacyStub", sb.toString());
    }

    public final void H0(final yn3 yn3Var) {
        G0(null, 40010, new j() { // from class: dl2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                w.W(this.a, yn3Var, gVar);
            }
        }, this.m.c());
    }

    public androidx.media3.session.b J0() {
        return this.f;
    }

    public u.f K0() {
        return this.i;
    }

    public u.e L0(u uVar) {
        u.e.a aVarB = new u.e.a(uVar).c(this.y).b(this.z);
        if (this.x.isEmpty()) {
            aVarB.d(this.w);
        } else {
            aVarB.e(this.x);
        }
        return aVarB.a();
    }

    public pi2 N0() {
        return this.m;
    }

    public void O0(fm2.b bVar) {
        E0(1, new j() { // from class: yk2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                w wVar = this.a;
                fy4.I0(wVar.g.v0(), wVar.g.j1());
            }
        }, bVar, true);
    }

    public final void P0(fg2 fg2Var, boolean z) {
        Q0(fg2Var, true, z);
    }

    public final void Q0(final fg2 fg2Var, final boolean z, final boolean z2) {
        E0(31, new j() { // from class: xk2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                w wVar = this.a;
                x81.a(wVar.g.V0(gVar, xi1.w(fg2Var), -1, -9223372036854775807L), wVar.new a(gVar, z, z2), du2.b());
            }
        }, this.m.c(), false);
    }

    public final void R0(final zf2 zf2Var, final int i2) {
        if (zf2Var != null) {
            if (i2 == -1 || i2 >= 0) {
                E0(20, new j() { // from class: bl2
                    @Override // androidx.media3.session.w.j
                    public final void a(u.g gVar) {
                        w.V(this.a, zf2Var, i2, gVar);
                    }
                }, this.m.c(), false);
            }
        }
    }

    public final boolean T0() {
        return this.z.c(17) && this.g.v0().getAvailableCommands().c(17);
    }

    public void V0(ue3 ue3Var) {
        int i2 = ue3Var.isCommandAvailable(20) ? 4 : 0;
        if (this.t != i2) {
            this.t = i2;
            this.m.m(i2);
        }
    }

    public final boolean W0(v5 v5Var) {
        if (this.k) {
            return v5Var == null || !v5Var.e();
        }
        return false;
    }

    public final void X0() {
        fy4.o1(this.g.e0(), new Runnable() { // from class: hl2
            @Override // java.lang.Runnable
            public final void run() {
                this.f.m1();
            }
        });
    }

    public void Z0() {
        if (Build.VERSION.SDK_INT < 31) {
            if (this.o == null) {
                d1(this.m, null);
            } else {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", this.g.B0());
                intent.setComponent(this.o);
                d1(this.m, PendingIntent.getBroadcast(this.g.j0(), 0, intent, C));
            }
        }
        if (this.n != null) {
            this.g.j0().unregisterReceiver(this.n);
        }
        v5 v5Var = this.l;
        if (v5Var != null) {
            v5Var.g();
        }
        this.m.h();
    }

    @Override // pi2.b
    public void b(zf2 zf2Var) {
        R0(zf2Var, -1);
    }

    public void b1(d0 d0Var, hd3.b bVar) {
        if (this.A != null) {
            return;
        }
        boolean z = this.z.c(17) != bVar.c(17);
        this.y = d0Var;
        this.z = bVar;
        if (!this.x.isEmpty()) {
            m1();
        }
        v vVar = this.g;
        if (z) {
            o1(vVar.v0());
        } else {
            n1(vVar.v0());
        }
    }

    @Override // pi2.b
    public void c(zf2 zf2Var, int i2) {
        R0(zf2Var, i2);
    }

    public void c1(androidx.media3.session.j jVar, boolean z) {
        int iO = androidx.media3.session.i.o(jVar.a);
        h hVar = this.u;
        if (hVar == null || hVar.b != iO) {
            b24 b24Var = jVar.f;
            String str = b24Var != null ? b24Var.b : "no error message provided";
            Bundle bundle = Bundle.EMPTY;
            MediaLibraryService.b bVar = jVar.e;
            if (bVar == null || !bVar.a.containsKey("android.media.extras.ERROR_RESOLUTION_ACTION_INTENT")) {
                b24 b24Var2 = jVar.f;
                if (b24Var2 != null) {
                    bundle = b24Var2.c;
                }
            } else {
                bundle = jVar.e.a;
            }
            this.u = new h(z, iO, str, bundle, null);
            n1(this.g.v0());
        }
    }

    @Override // pi2.b
    public void d(String str, final Bundle bundle, final ResultReceiver resultReceiver) {
        gg3.q(str);
        if (str.equals("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST")) {
            return;
        }
        if (str.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN") && resultReceiver != null) {
            resultReceiver.send(0, this.g.A0().m());
        } else {
            final y14 y14Var = new y14(str, Bundle.EMPTY);
            F0(y14Var, new j() { // from class: ll2
                @Override // androidx.media3.session.w.j
                public final void a(u.g gVar) {
                    w.R(this.a, y14Var, bundle, resultReceiver, gVar);
                }
            });
        }
    }

    @Override // pi2.b
    public void e(String str, final Bundle bundle) {
        if (str.equals("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST")) {
            return;
        }
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        final y14 y14Var = new y14(str, bundle);
        if (androidx.media3.session.a.w(y14Var.b)) {
            C0(y14Var);
        } else {
            F0(y14Var, new j() { // from class: al2
                @Override // androidx.media3.session.w.j
                public final void a(u.g gVar) {
                    w.S0(this.a.g.M0(gVar, null, y14Var, bundle));
                }
            });
        }
    }

    @Override // pi2.b
    public void f() {
        E0(12, new j() { // from class: tl2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().seekForward();
            }
        }, this.m.c(), true);
    }

    public void f1(xi1 xi1Var) {
        this.w = xi1Var;
    }

    @Override // pi2.b
    public boolean g(Intent intent) {
        return this.g.P0(new u.g((fm2.b) gg3.q(this.m.c()), 0, 0, false, null, Bundle.EMPTY, 0, Build.VERSION.SDK_INT >= 33), intent);
    }

    public void g1(xi1 xi1Var) {
        this.x = xi1Var;
        m1();
    }

    @Override // pi2.b
    public void h() {
        E0(1, new j() { // from class: zl2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                fy4.G0(this.a.g.v0());
            }
        }, this.m.c(), true);
    }

    @Override // pi2.b
    public void i() {
        D0();
    }

    public final void i1(pi2 pi2Var, CharSequence charSequence) {
        if (!T0()) {
            charSequence = null;
        }
        pi2Var.t(charSequence);
    }

    @Override // pi2.b
    public void j(String str, Bundle bundle) {
        P0(z0(str, null, null, bundle), true);
    }

    public void j1() {
        this.m.j(true);
    }

    @Override // pi2.b
    public void k(String str, Bundle bundle) {
        P0(z0(null, null, str, bundle), true);
    }

    public final u.g k1(fm2.b bVar) {
        u.g gVarK = this.f.k(bVar);
        if (gVarK == null) {
            f fVar = new f(bVar);
            u.g gVar = new u.g(bVar, 0, 0, this.h.b(bVar), fVar, Bundle.EMPTY, 0, Build.VERSION.SDK_INT >= 33);
            u.e eVarL0 = this.g.L0(gVar);
            if (!eVarL0.a) {
                fVar.a(0);
                return null;
            }
            this.f.e(gVar.g(), gVar, eVarL0.b, eVarL0.c);
            this.g.U0(gVar);
            gVarK = gVar;
        }
        this.j.a(gVarK, this.r);
        return gVarK;
    }

    @Override // pi2.b
    public void l(Uri uri, Bundle bundle) {
        P0(z0(null, uri, null, bundle), true);
    }

    public final void l1() {
        xi1 xi1Var = this.x;
        d0 d0Var = this.y;
        hd3.b bVar = this.B;
        if (bVar == null) {
            bVar = this.z;
        }
        this.w = androidx.media3.session.a.m(androidx.media3.session.a.j(xi1Var, d0Var, bVar), true, true, 9);
        if (W0(this.l)) {
            this.v.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", (this.w.isEmpty() || androidx.media3.session.a.e(this.w, 2)) ? false : true);
            this.v.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
        } else {
            this.v.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", !androidx.media3.session.a.e(this.w, 2));
            this.v.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", !androidx.media3.session.a.e(this.w, 3));
        }
    }

    @Override // pi2.b
    public void m() {
        E0(2, new j() { // from class: ml2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().prepare();
            }
        }, this.m.c(), true);
    }

    public final void m1() {
        boolean z = this.v.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false);
        boolean z2 = this.v.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
        l1();
        if (this.v.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false) == z && this.v.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false) == z2) {
            return;
        }
        N0().l(this.v);
    }

    @Override // pi2.b
    public void n(String str, Bundle bundle) {
        P0(z0(str, null, null, bundle), false);
    }

    public void n1(final ue3 ue3Var) {
        fy4.o1(this.g.e0(), new Runnable() { // from class: vl2
            @Override // java.lang.Runnable
            public final void run() {
                w wVar = this.f;
                wVar.m.p(wVar.A0(ue3Var));
            }
        });
    }

    @Override // pi2.b
    public void o(String str, Bundle bundle) {
        P0(z0(null, null, str, bundle), false);
    }

    public void o1(final ue3 ue3Var) {
        fy4.o1(this.g.e0(), new Runnable() { // from class: cl2
            @Override // java.lang.Runnable
            public final void run() {
                w.a0(this.f, ue3Var);
            }
        });
    }

    @Override // pi2.b
    public void p(Uri uri, Bundle bundle) {
        P0(z0(null, uri, null, bundle), false);
    }

    @Override // pi2.b
    public void q(final zf2 zf2Var) {
        if (zf2Var == null) {
            return;
        }
        E0(20, new j() { // from class: ul2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                w.i0(this.a, zf2Var, gVar);
            }
        }, this.m.c(), true);
    }

    @Override // pi2.b
    public void r() {
        E0(11, new j() { // from class: jl2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().seekBack();
            }
        }, this.m.c(), true);
    }

    @Override // pi2.b
    public void s(final long j2) {
        E0(5, new j() { // from class: wl2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().seekTo(j2);
            }
        }, this.m.c(), true);
    }

    @Override // pi2.b
    public void t(boolean z) {
    }

    @Override // pi2.b
    public void u(final float f2) {
        if (f2 <= 0.0f) {
            return;
        }
        E0(13, new j() { // from class: wk2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().setPlaybackSpeed(f2);
            }
        }, this.m.c(), true);
    }

    @Override // pi2.b
    public void v(zn3 zn3Var) {
        w(zn3Var, null);
    }

    @Override // pi2.b
    public void w(zn3 zn3Var, Bundle bundle) {
        yn3 yn3VarQ = androidx.media3.session.i.Q(zn3Var);
        if (yn3VarQ != null) {
            H0(yn3VarQ);
            return;
        }
        xz1.i("MediaSessionLegacyStub", "Ignoring invalid RatingCompat " + zn3Var);
    }

    public boolean w0() {
        return this.o != null;
    }

    @Override // pi2.b
    public void x(final int i2) {
        E0(15, new j() { // from class: il2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().setRepeatMode(i.S(i2));
            }
        }, this.m.c(), true);
    }

    public void x0() {
        if (this.u != null) {
            this.u = null;
            n1(this.g.v0());
        }
    }

    @Override // pi2.b
    public void y(final int i2) {
        E0(14, new j() { // from class: xl2
            @Override // androidx.media3.session.w.j
            public final void a(u.g gVar) {
                this.a.g.v0().setShuffleModeEnabled(i.Y(i2));
            }
        }, this.m.c(), true);
    }

    @Override // pi2.b
    public void z() {
        if (this.g.v0().isCommandAvailable(9)) {
            E0(9, new j() { // from class: gl2
                @Override // androidx.media3.session.w.j
                public final void a(u.g gVar) {
                    this.a.g.v0().seekToNext();
                }
            }, this.m.c(), true);
        } else {
            E0(8, new j() { // from class: rl2
                @Override // androidx.media3.session.w.j
                public final void a(u.g gVar) {
                    this.a.g.v0().seekToNextMediaItem();
                }
            }, this.m.c(), true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class i extends BroadcastReceiver {
        public i() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if (Objects.equals(intent.getAction(), "android.intent.action.MEDIA_BUTTON") && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                w.this.m.b().c(keyEvent);
            }
        }

        public /* synthetic */ i(w wVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h {
        public final boolean a;
        public final int b;
        public final String c;
        public final Bundle d;

        public h(boolean z, int i, String str, Bundle bundle) {
            this.a = z;
            this.b = i;
            this.c = str;
            this.d = bundle == null ? Bundle.EMPTY : bundle;
        }

        public /* synthetic */ h(boolean z, int i, String str, Bundle bundle, a aVar) {
            this(z, i, str, bundle);
        }
    }
}
