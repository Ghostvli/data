package defpackage;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import defpackage.cd3;
import defpackage.fm2;
import defpackage.lh1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pi2 {
    public final c a;
    public final v82 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends b {
        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public boolean c;
        public a e;
        public final Object a = new Object();
        public final MediaSession.Callback b = new C0112b();
        public WeakReference d = new WeakReference(null);

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c cVar;
                b bVar;
                a aVar;
                if (message.what == 1) {
                    synchronized (b.this.a) {
                        cVar = (c) b.this.d.get();
                        bVar = b.this;
                        aVar = bVar.e;
                    }
                    if (cVar == null || bVar != cVar.i() || aVar == null) {
                        return;
                    }
                    cVar.m((fm2.b) message.obj);
                    b.this.a(cVar, aVar);
                    cVar.m(null);
                }
            }
        }

        /* JADX INFO: renamed from: pi2$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0112b extends MediaSession.Callback {
            public C0112b() {
            }

            public final void a(c cVar) {
                cVar.m(null);
            }

            public final d b() {
                d dVar;
                synchronized (b.this.a) {
                    dVar = (d) b.this.d.get();
                }
                if (dVar == null || b.this != dVar.i()) {
                    return null;
                }
                return dVar;
            }

            public final void c(c cVar) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String strE = cVar.e();
                if (TextUtils.isEmpty(strE)) {
                    strE = "android.media.session.MediaController";
                }
                cVar.m(new fm2.b(strE, -1, -1));
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                Bundle bundleY = fy4.y(bundle);
                c(dVarB);
                try {
                    g gVar = null;
                    IBinder iBinderAsBinder = null;
                    gVar = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        if (resultReceiver != null) {
                            Bundle bundle2 = new Bundle();
                            h hVarA = dVarB.a();
                            lh1 lh1VarS = hVarA.s();
                            if (lh1VarS != null) {
                                iBinderAsBinder = lh1VarS.asBinder();
                            }
                            bundle2.putBinder("android.support.v4.media.session.EXTRA_BINDER", iBinderAsBinder);
                            n73.c(bundle2, "android.support.v4.media.session.SESSION_TOKEN2", hVarA.u());
                            resultReceiver.send(0, bundle2);
                        }
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        if (bundleY != null) {
                            b.this.b((zf2) ps1.a(bundleY.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), zf2.CREATOR));
                        }
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        if (bundleY != null) {
                            b.this.c((zf2) ps1.a(bundleY.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), zf2.CREATOR), bundleY.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                        }
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        if (bundleY != null) {
                            b.this.q((zf2) ps1.a(bundleY.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), zf2.CREATOR));
                        }
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        List list = dVarB.i;
                        if (list != null && bundleY != null) {
                            int i = bundleY.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                            if (i >= 0 && i < list.size()) {
                                gVar = (g) list.get(i);
                            }
                            if (gVar != null) {
                                b.this.q(gVar.s());
                            }
                        }
                    } else {
                        b.this.d(str, bundleY, resultReceiver);
                    }
                } catch (BadParcelableException unused) {
                    xz1.d("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                Bundle bundleY = fy4.y(bundle);
                c(dVarB);
                try {
                    if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        if (bundleY != null) {
                            b.this.l((Uri) bundleY.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), fy4.y(bundleY.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                        b.this.m();
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        if (bundleY != null) {
                            b.this.n(bundleY.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), fy4.y(bundleY.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        if (bundleY != null) {
                            b.this.o(bundleY.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), fy4.y(bundleY.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        if (bundleY != null) {
                            b.this.p((Uri) bundleY.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), fy4.y(bundleY.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        if (bundleY != null) {
                            b.this.t(bundleY.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        if (bundleY != null) {
                            b.this.x(bundleY.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        if (bundleY != null) {
                            b.this.y(bundleY.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                        }
                    } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                        if (bundleY != null) {
                            b.this.w((zn3) ps1.a(bundleY.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), zn3.CREATOR), fy4.y(bundleY.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS")));
                        }
                    } else if (!str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        b.this.e(str, bundleY);
                    } else if (bundleY != null) {
                        b.this.u(bundleY.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    }
                } catch (BadParcelableException unused) {
                    xz1.d("MediaSessionCompat", "Could not unparcel the data.");
                }
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.f();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                d dVarB = b();
                if (dVarB == null) {
                    return false;
                }
                c(dVarB);
                boolean zG = b.this.g(intent);
                a(dVarB);
                return zG || super.onMediaButtonEvent(intent);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.h();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.i();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                Bundle bundleY = fy4.y(bundle);
                c(dVarB);
                b.this.j(str, bundleY);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                Bundle bundleY = fy4.y(bundle);
                c(dVarB);
                b.this.k(str, bundleY);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                Bundle bundleY = fy4.y(bundle);
                c(dVarB);
                b.this.l(uri, bundleY);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepare() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.m();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                Bundle bundleY = fy4.y(bundle);
                c(dVarB);
                b.this.n(str, bundleY);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromSearch(String str, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                Bundle bundleY = fy4.y(bundle);
                c(dVarB);
                b.this.o(str, bundleY);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                Bundle bundleY = fy4.y(bundle);
                c(dVarB);
                b.this.p(uri, bundleY);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.r();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.s(j);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetPlaybackSpeed(float f) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.u(f);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.v(zn3.c(rating));
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.z();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.A();
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j) {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.B(j);
                a(dVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                d dVarB = b();
                if (dVarB == null) {
                    return;
                }
                c(dVarB);
                b.this.C();
                a(dVarB);
            }
        }

        public void A() {
        }

        public void B(long j) {
        }

        public void C() {
        }

        public void D(c cVar, Handler handler) {
            synchronized (this.a) {
                try {
                    this.d = new WeakReference(cVar);
                    a aVar = this.e;
                    a aVar2 = null;
                    if (aVar != null) {
                        aVar.removeCallbacksAndMessages(null);
                    }
                    if (handler != null) {
                        aVar2 = new a(handler.getLooper());
                    }
                    this.e = aVar2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(c cVar, Handler handler) {
            if (this.c) {
                this.c = false;
                handler.removeMessages(1);
                cd3 playbackState = cVar.getPlaybackState();
                long jD = playbackState == null ? 0L : playbackState.d();
                boolean z = playbackState != null && playbackState.E() == 3;
                boolean z2 = (516 & jD) != 0;
                boolean z3 = (jD & 514) != 0;
                if (z && z3) {
                    h();
                } else {
                    if (z || !z2) {
                        return;
                    }
                    i();
                }
            }
        }

        public void b(zf2 zf2Var) {
        }

        public void c(zf2 zf2Var, int i) {
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void e(String str, Bundle bundle) {
        }

        public void f() {
        }

        public boolean g(Intent intent) {
            c cVar;
            a aVar;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.a) {
                cVar = (c) this.d.get();
                aVar = this.e;
            }
            if (cVar == null || aVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            fm2.b bVarT = cVar.t();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                a(cVar, aVar);
                return false;
            }
            if (keyEvent.getRepeatCount() != 0) {
                a(cVar, aVar);
            } else if (this.c) {
                aVar.removeMessages(1);
                this.c = false;
                cd3 playbackState = cVar.getPlaybackState();
                if (((playbackState == null ? 0L : playbackState.d()) & 32) != 0) {
                    z();
                }
            } else {
                this.c = true;
                aVar.sendMessageDelayed(aVar.obtainMessage(1, bVarT), ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void h() {
        }

        public void i() {
        }

        public void j(String str, Bundle bundle) {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l(Uri uri, Bundle bundle) {
        }

        public void m() {
        }

        public void n(String str, Bundle bundle) {
        }

        public void o(String str, Bundle bundle) {
        }

        public void p(Uri uri, Bundle bundle) {
        }

        public void q(zf2 zf2Var) {
        }

        public void r() {
        }

        public void s(long j) {
        }

        public void t(boolean z) {
        }

        public void u(float f) {
        }

        public void v(zn3 zn3Var) {
        }

        public void w(zn3 zn3Var, Bundle bundle) {
        }

        public void x(int i) {
        }

        public void y(int i) {
        }

        public void z() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        h a();

        void b(int i);

        boolean c();

        void d(String str, Bundle bundle);

        String e();

        void f(PendingIntent pendingIntent);

        void g(qh2 qh2Var);

        cd3 getPlaybackState();

        void h(CharSequence charSequence);

        b i();

        void j(PendingIntent pendingIntent);

        void k(int i);

        void l(yb ybVar);

        void m(fm2.b bVar);

        void n(List list);

        void o(z75 z75Var);

        void p(boolean z);

        void q(b bVar, Handler handler);

        Object r();

        void release();

        void s(cd3 cd3Var);

        void setExtras(Bundle bundle);

        void setRepeatMode(int i);

        fm2.b t();

        void u(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements c {
        public final MediaSession a;
        public final a b;
        public final h c;
        public Bundle e;
        public cd3 h;
        public List i;
        public qh2 j;
        public boolean k;
        public int l;
        public int m;
        public b n;
        public fm2.b o;
        public final Object d = new Object();
        public boolean f = false;
        public final RemoteCallbackList g = new RemoteCallbackList();

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a extends lh1.a {
            public final WeakReference d;

            public a(d dVar) {
                this.d = new WeakReference(dVar);
            }

            @Override // defpackage.lh1
            public Bundle J() {
                d dVar = (d) this.d.get();
                if (dVar == null || dVar.e == null) {
                    return null;
                }
                return new Bundle(dVar.e);
            }

            public void b1() {
                this.d.clear();
            }

            @Override // defpackage.lh1
            public int e() {
                d dVar = (d) this.d.get();
                if (dVar != null) {
                    return dVar.m;
                }
                return -1;
            }

            @Override // defpackage.lh1
            public boolean f() {
                d dVar = (d) this.d.get();
                return dVar != null && dVar.k;
            }

            @Override // defpackage.lh1
            public cd3 getPlaybackState() {
                d dVar = (d) this.d.get();
                if (dVar != null) {
                    return pi2.f(dVar.h, dVar.j);
                }
                return null;
            }

            @Override // defpackage.lh1
            public int getRepeatMode() {
                d dVar = (d) this.d.get();
                if (dVar != null) {
                    return dVar.l;
                }
                return -1;
            }

            @Override // defpackage.lh1
            public void m0(kh1 kh1Var) {
                d dVar = (d) this.d.get();
                if (dVar == null || kh1Var == null) {
                    return;
                }
                dVar.g.unregister(kh1Var);
                Binder.getCallingPid();
                Binder.getCallingUid();
                synchronized (dVar.d) {
                }
            }

            @Override // defpackage.lh1
            public void t0(kh1 kh1Var) {
                d dVar = (d) this.d.get();
                if (dVar == null || kh1Var == null) {
                    return;
                }
                dVar.g.register(kh1Var, new fm2.b("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                synchronized (dVar.d) {
                }
            }
        }

        public d(Context context, String str, Bundle bundle) {
            MediaSession mediaSessionV = v(context, str, bundle);
            this.a = mediaSessionV;
            a aVar = new a(this);
            this.b = aVar;
            this.c = new h(mediaSessionV.getSessionToken(), aVar);
            this.e = bundle;
            b(3);
        }

        @Override // pi2.c
        public h a() {
            return this.c;
        }

        @Override // pi2.c
        public void b(int i) {
            this.a.setFlags(i | 3);
        }

        @Override // pi2.c
        public boolean c() {
            return this.a.isActive();
        }

        @Override // pi2.c
        public void d(String str, Bundle bundle) {
            this.a.sendSessionEvent(str, bundle);
        }

        @Override // pi2.c
        public String e() {
            try {
                return (String) this.a.getClass().getMethod("getCallingPackage", null).invoke(this.a, null);
            } catch (Exception e) {
                xz1.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e);
                return null;
            }
        }

        @Override // pi2.c
        public void f(PendingIntent pendingIntent) {
            this.a.setSessionActivity(pendingIntent);
        }

        @Override // pi2.c
        public void g(qh2 qh2Var) {
            this.j = qh2Var;
            this.a.setMetadata(qh2Var == null ? null : qh2Var.y());
        }

        @Override // pi2.c
        public cd3 getPlaybackState() {
            return this.h;
        }

        @Override // pi2.c
        public void h(CharSequence charSequence) {
            this.a.setQueueTitle(charSequence);
        }

        @Override // pi2.c
        public b i() {
            b bVar;
            synchronized (this.d) {
                bVar = this.n;
            }
            return bVar;
        }

        @Override // pi2.c
        public void j(PendingIntent pendingIntent) {
            this.a.setMediaButtonReceiver(pendingIntent);
        }

        @Override // pi2.c
        public void k(int i) {
            this.a.setRatingType(i);
        }

        @Override // pi2.c
        public void l(yb ybVar) {
            this.a.setPlaybackToLocal(ybVar.c());
        }

        @Override // pi2.c
        public void m(fm2.b bVar) {
            synchronized (this.d) {
                this.o = bVar;
            }
        }

        @Override // pi2.c
        public void n(List list) {
            this.i = list;
            if (list == null) {
                this.a.setQueue(null);
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((g) it.next()).v());
            }
            this.a.setQueue(arrayList);
        }

        @Override // pi2.c
        public void o(z75 z75Var) {
            this.a.setPlaybackToRemote((VolumeProvider) z75Var.a());
        }

        @Override // pi2.c
        public void p(boolean z) {
            this.a.setActive(z);
        }

        @Override // pi2.c
        public void q(b bVar, Handler handler) {
            synchronized (this.d) {
                try {
                    this.n = bVar;
                    this.a.setCallback(bVar == null ? null : bVar.b, handler);
                    if (bVar != null) {
                        bVar.D(this, handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // pi2.c
        public Object r() {
            return this.a;
        }

        @Override // pi2.c
        public void release() {
            this.f = true;
            this.g.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.a.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.a);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                } catch (Exception e) {
                    xz1.j("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e);
                }
            }
            this.a.setCallback(null);
            this.b.b1();
            this.a.release();
        }

        @Override // pi2.c
        public void s(cd3 cd3Var) {
            this.h = cd3Var;
            synchronized (this.d) {
                int iBeginBroadcast = this.g.beginBroadcast() - 1;
                while (true) {
                    RemoteCallbackList remoteCallbackList = this.g;
                    if (iBeginBroadcast >= 0) {
                        try {
                            ((kh1) remoteCallbackList.getBroadcastItem(iBeginBroadcast)).i(cd3Var);
                        } catch (RemoteException | SecurityException e) {
                            xz1.e("MediaSessionCompat", "Dead object in setPlaybackState.", e);
                        }
                        iBeginBroadcast--;
                    } else {
                        remoteCallbackList.finishBroadcast();
                    }
                }
            }
            this.a.setPlaybackState(cd3Var.C());
        }

        @Override // pi2.c
        public void setExtras(Bundle bundle) {
            this.a.setExtras(bundle);
        }

        @Override // pi2.c
        public void setRepeatMode(int i) {
            if (this.l != i) {
                this.l = i;
                synchronized (this.d) {
                    int iBeginBroadcast = this.g.beginBroadcast() - 1;
                    while (true) {
                        RemoteCallbackList remoteCallbackList = this.g;
                        if (iBeginBroadcast >= 0) {
                            try {
                                ((kh1) remoteCallbackList.getBroadcastItem(iBeginBroadcast)).onRepeatModeChanged(i);
                            } catch (RemoteException | SecurityException e) {
                                xz1.e("MediaSessionCompat", "Dead object in setRepeatMode.", e);
                            }
                            iBeginBroadcast--;
                        } else {
                            remoteCallbackList.finishBroadcast();
                        }
                    }
                }
            }
        }

        @Override // pi2.c
        public fm2.b t() {
            fm2.b bVar;
            synchronized (this.d) {
                bVar = this.o;
            }
            return bVar;
        }

        @Override // pi2.c
        public void u(int i) {
            if (this.m != i) {
                this.m = i;
                synchronized (this.d) {
                    int iBeginBroadcast = this.g.beginBroadcast() - 1;
                    while (true) {
                        RemoteCallbackList remoteCallbackList = this.g;
                        if (iBeginBroadcast >= 0) {
                            try {
                                ((kh1) remoteCallbackList.getBroadcastItem(iBeginBroadcast)).n0(i);
                            } catch (RemoteException | SecurityException e) {
                                xz1.e("MediaSessionCompat", "Dead object in setShuffleMode.", e);
                            }
                            iBeginBroadcast--;
                        } else {
                            remoteCallbackList.finishBroadcast();
                        }
                    }
                }
            }
        }

        public MediaSession v(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends d {
        public e(Context context, String str, Bundle bundle) {
            super(context, str, bundle);
        }

        @Override // pi2.d, pi2.c
        public void m(fm2.b bVar) {
        }

        @Override // pi2.d, pi2.c
        public final fm2.b t() {
            return new fm2.b(this.a.getCurrentControllerInfo());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f extends e {
        public f(Context context, String str, Bundle bundle) {
            super(context, str, bundle);
        }

        @Override // pi2.d
        public MediaSession v(Context context, String str, Bundle bundle) {
            return qi2.a(context, str, bundle);
        }
    }

    public pi2(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            jl.a("tag must not be null or empty");
            throw null;
        }
        if (componentName == null && (componentName = c72.a(context)) == null) {
            xz1.g("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
        }
        if (componentName != null && pendingIntent == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.a = new f(context, str, bundle);
        } else if (i >= 28) {
            this.a = new e(context, str, bundle);
        } else {
            this.a = new d(context, str, bundle);
        }
        Looper looperMyLooper = Looper.myLooper();
        k(new a(), new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper));
        this.a.j(pendingIntent);
        this.b = new v82(context, this);
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) gg3.q(pi2.class.getClassLoader()));
        }
    }

    public static cd3 f(cd3 cd3Var, qh2 qh2Var) {
        if (cd3Var == null) {
            return cd3Var;
        }
        long jX = -1;
        if (cd3Var.D() == -1) {
            return cd3Var;
        }
        if (cd3Var.E() != 3 && cd3Var.E() != 4 && cd3Var.E() != 5) {
            return cd3Var;
        }
        if (cd3Var.A() <= 0) {
            return cd3Var;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jB = ((long) (cd3Var.B() * (jElapsedRealtime - r0))) + cd3Var.D();
        if (qh2Var != null && qh2Var.c("android.media.metadata.DURATION")) {
            jX = qh2Var.x("android.media.metadata.DURATION");
        }
        return new cd3.b(cd3Var).h(cd3Var.E(), (jX < 0 || jB <= jX) ? jB < 0 ? 0L : jB : jX, cd3Var.B(), jElapsedRealtime).b();
    }

    public v82 b() {
        return this.b;
    }

    public final fm2.b c() {
        return this.a.t();
    }

    public Object d() {
        return this.a.r();
    }

    public h e() {
        return this.a.a();
    }

    public boolean g() {
        return this.a.c();
    }

    public void h() {
        this.a.release();
    }

    public void i(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            jl.a("event cannot be null or empty");
        } else {
            this.a.d(str, bundle);
        }
    }

    public void j(boolean z) {
        this.a.p(z);
    }

    public void k(b bVar, Handler handler) {
        this.a.q(bVar, handler);
    }

    public void l(Bundle bundle) {
        this.a.setExtras(bundle);
    }

    public void m(int i) {
        this.a.b(i);
    }

    public void n(PendingIntent pendingIntent) {
        this.a.j(pendingIntent);
    }

    public void o(qh2 qh2Var) {
        this.a.g(qh2Var);
    }

    public void p(cd3 cd3Var) {
        this.a.s(cd3Var);
    }

    public void q(yb ybVar) {
        this.a.l(ybVar);
    }

    public void r(z75 z75Var) {
        this.a.o(z75Var);
    }

    public void s(List list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (hashSet.contains(Long.valueOf(gVar.u()))) {
                    xz1.e("MediaSessionCompat", "Found duplicate queue id: " + gVar.u(), new IllegalArgumentException("id of each queue item should be unique"));
                }
                hashSet.add(Long.valueOf(gVar.u()));
            }
        }
        this.a.n(list);
    }

    public void t(CharSequence charSequence) {
        this.a.h(charSequence);
    }

    public void u(int i) {
        this.a.k(i);
    }

    public void v(int i) {
        this.a.setRepeatMode(i);
    }

    public void w(PendingIntent pendingIntent) {
        this.a.f(pendingIntent);
    }

    public void x(int i) {
        this.a.u(i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h implements Parcelable {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public final Object f;
        public final MediaSession.Token g;
        public lh1 h;
        public nz4 i;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h((MediaSession.Token) gg3.q((MediaSession.Token) parcel.readParcelable(null)));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i) {
                return new h[i];
            }
        }

        public h(MediaSession.Token token, lh1 lh1Var, nz4 nz4Var) {
            this.f = new Object();
            this.g = token;
            this.h = lh1Var;
            this.i = nz4Var;
        }

        public static h c(MediaSession.Token token) {
            return d(token, null);
        }

        public static h d(MediaSession.Token token, lh1 lh1Var) {
            return new h(token, lh1Var);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                return this.g.equals(((h) obj).g);
            }
            return false;
        }

        public int hashCode() {
            return this.g.hashCode();
        }

        public lh1 s() {
            lh1 lh1Var;
            synchronized (this.f) {
                lh1Var = this.h;
            }
            return lh1Var;
        }

        public nz4 u() {
            nz4 nz4Var;
            synchronized (this.f) {
                nz4Var = this.i;
            }
            return nz4Var;
        }

        public MediaSession.Token v() {
            return this.g;
        }

        public void w(lh1 lh1Var) {
            synchronized (this.f) {
                this.h = lh1Var;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.g, i);
        }

        public void x(nz4 nz4Var) {
            synchronized (this.f) {
                this.i = nz4Var;
            }
        }

        public Bundle y() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.TOKEN", ps1.a(this, MediaSessionCompat.Token.CREATOR));
            synchronized (this.f) {
                try {
                    lh1 lh1Var = this.h;
                    if (lh1Var != null) {
                        bundle.putBinder("android.support.v4.media.session.EXTRA_BINDER", lh1Var.asBinder());
                    }
                    nz4 nz4Var = this.i;
                    if (nz4Var != null) {
                        n73.c(bundle, "android.support.v4.media.session.SESSION_TOKEN2", nz4Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bundle;
        }

        public h(MediaSession.Token token, lh1 lh1Var) {
            this(token, lh1Var, null);
        }

        public h(MediaSession.Token token) {
            this(token, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();
        public final zf2 f;
        public final long g;
        public MediaSession.QueueItem h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i) {
                return new g[i];
            }
        }

        public g(MediaSession.QueueItem queueItem, zf2 zf2Var, long j) {
            if (j == -1) {
                jl.a("Id cannot be QueueItem.UNKNOWN_ID");
                throw null;
            }
            this.f = zf2Var;
            this.g = j;
            this.h = queueItem;
        }

        public static g c(MediaSession.QueueItem queueItem) {
            return new g(queueItem, zf2.c(queueItem.getDescription()), queueItem.getQueueId());
        }

        public static List d(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(c((MediaSession.QueueItem) it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public zf2 s() {
            return this.f;
        }

        public String toString() {
            return "MediaSession.QueueItem { Description=" + this.f + ", Id=" + this.g + " }";
        }

        public long u() {
            return this.g;
        }

        public MediaSession.QueueItem v() {
            MediaSession.QueueItem queueItem = this.h;
            if (queueItem != null) {
                return queueItem;
            }
            MediaSession.QueueItem queueItem2 = new MediaSession.QueueItem(this.f.x(), this.g);
            this.h = queueItem2;
            return queueItem2;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.f.writeToParcel(parcel, i);
            parcel.writeLong(this.g);
        }

        public g(zf2 zf2Var, long j) {
            this(null, zf2Var, j);
        }

        public g(Parcel parcel) {
            this.f = zf2.CREATOR.createFromParcel(parcel);
            this.g = parcel.readLong();
        }
    }
}
