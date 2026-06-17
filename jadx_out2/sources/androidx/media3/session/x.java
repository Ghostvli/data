package androidx.media3.session;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Pair;
import androidx.media3.session.e;
import androidx.media3.session.h;
import androidx.media3.session.s;
import androidx.media3.session.u;
import androidx.media3.session.x;
import androidx.media3.session.z;
import defpackage.fm2;
import defpackage.ft1;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.h24;
import defpackage.la;
import defpackage.lm2;
import defpackage.u00;
import defpackage.xz1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x extends ft1 {
    public static final String CONNECTION_HINT_KEY_CONTROLLER_INFO_TYPE = "androidx.media3.session.hint.controller_info_type";
    public static final String CONNECTION_HINT_KEY_INTENT_EXTRAS = "androidx.media3.session.hint.intent_extras";
    public static final String CONNECTION_HINT_KEY_SESSION_ID = "androidx.media3.session.hint.session_id";
    public static final long DEFAULT_FOREGROUND_SERVICE_TIMEOUT_MS = 600000;
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaSessionService";
    public static final int SHOW_NOTIFICATION_FOR_IDLE_PLAYER_AFTER_STOP_OR_ERROR = 3;
    public static final int SHOW_NOTIFICATION_FOR_IDLE_PLAYER_ALWAYS = 1;
    public static final int SHOW_NOTIFICATION_FOR_IDLE_PLAYER_NEVER = 2;
    private static final String TAG = "MSessionService";
    private androidx.media3.session.d actionFactory;
    private boolean initialStartIntentProcessed;
    private c listener;
    private t mediaNotificationManager;
    private e stub;
    private final Object lock = new Object();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map<String, u> sessions = new la();
    private boolean defaultMethodCalled = false;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean a(IllegalStateException illegalStateException) {
            return lm2.a(illegalStateException);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d implements u.h {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.h
        public void a(u uVar) {
            x.this.onUpdateNotificationInternal(uVar, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.u.h
        public boolean b(u uVar) {
            int i = Build.VERSION.SDK_INT;
            if (i < 31 || i >= 33 || x.this.j().p()) {
                return true;
            }
            return x.this.onUpdateNotificationInternal(uVar, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends h.a {
        public final WeakReference d;
        public final Handler e;
        public final Set f = Collections.synchronizedSet(new HashSet());

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(x xVar) {
            this.d = new WeakReference(xVar);
            this.e = new Handler(xVar.getApplicationContext().getMainLooper());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void a1(e eVar, f fVar, fm2.b bVar, u00 u00Var, boolean z) {
            eVar.f.remove(fVar);
            try {
                try {
                    x xVar = (x) eVar.d.get();
                    if (xVar == null) {
                        h24.b(fVar);
                        return;
                    }
                    int i = u00Var.a;
                    int i2 = u00Var.b;
                    u.g gVar = new u.g(bVar, i, i2, z, new z.a(fVar, i2), u00Var.e, u00Var.f, true);
                    u uVarOnGetSession = xVar.onGetSession(gVar);
                    if (uVarOnGetSession == null) {
                        h24.b(fVar);
                        return;
                    } else {
                        xVar.addSession(uVarOnGetSession);
                        uVarOnGetSession.q(fVar, gVar);
                        return;
                    }
                } catch (Exception e) {
                    xz1.j(x.TAG, "Failed to add a session to session service", e);
                    h24.b(fVar);
                    return;
                }
            } catch (Throwable th) {
                h24.b(fVar);
                throw th;
            }
            h24.b(fVar);
            throw th;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b1() {
            this.d.clear();
            this.e.removeCallbacksAndMessages(null);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                h24.b((f) it.next());
            }
            this.f.clear();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.session.h
        public void y(final f fVar, Bundle bundle) {
            if (fVar == null || bundle == null) {
                h24.b(fVar);
                return;
            }
            try {
                final u00 u00VarA = u00.a(bundle);
                x xVar = (x) this.d.get();
                if (xVar == null) {
                    h24.b(fVar);
                    return;
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                if (callingPid == 0) {
                    callingPid = u00VarA.d;
                }
                int iA = h24.a(xVar, u00VarA.c, callingUid);
                String str = u00VarA.c;
                if (iA == 0) {
                    final fm2.b bVar = new fm2.b(str, callingPid, callingUid);
                    final boolean zB = fm2.a(xVar.getApplicationContext()).b(bVar);
                    this.f.add(fVar);
                    try {
                        this.e.post(new Runnable() { // from class: mm2
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                x.e.a1(this.f, fVar, bVar, u00VarA, zB);
                            }
                        });
                        return;
                    } finally {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                }
                xz1.i(x.TAG, "Ignoring connection from invalid package name " + str + " (uid=" + callingUid + ")");
                h24.b(fVar);
            } catch (RuntimeException e) {
                xz1.j(x.TAG, "Ignoring malformed Bundle for ConnectionRequest", e);
                h24.b(fVar);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b(v vVar, Intent intent) {
        u.g gVarQ0 = vVar.q0();
        if (gVarQ0 == null) {
            gVarQ0 = g(intent);
        }
        if (vVar.P0(gVarQ0, intent)) {
            return;
        }
        xz1.b(TAG, "Ignored unrecognized media button intent.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void d(x xVar, u uVar) {
        xVar.j().j(uVar);
        uVar.t(new d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void e(x xVar, u uVar) {
        xVar.j().u(uVar);
        uVar.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static u.g g(Intent intent) {
        ComponentName component = intent.getComponent();
        String packageName = component != null ? component.getPackageName() : SERVICE_INTERFACE;
        Bundle bundle = new Bundle();
        bundle.putString(CONNECTION_HINT_KEY_CONTROLLER_INFO_TYPE, "android.intent.action.MEDIA_BUTTON");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            bundle.putBundle(CONNECTION_HINT_KEY_INTENT_EXTRAS, extras);
        }
        Uri data = intent.getData();
        if (data != null) {
            bundle.putString(CONNECTION_HINT_KEY_SESSION_ID, v.y0(data));
        }
        return new u.g(new fm2.b(packageName, -1, -1), 1010000300, 9, false, null, bundle, 0, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void addSession(final u uVar) {
        u uVar2;
        gg3.r(uVar, "session must not be null");
        boolean z = true;
        gg3.e(!uVar.r(), "session is already released");
        synchronized (this.lock) {
            uVar2 = this.sessions.get(uVar.g());
            if (uVar2 != null && uVar2 != uVar) {
                z = false;
            }
            gg3.e(z, "Session ID should be unique");
            this.sessions.put(uVar.g(), uVar);
        }
        if (uVar2 == null) {
            fy4.o1(this.mainHandler, new Runnable() { // from class: jm2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    x.d(this.f, uVar);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void clearListener() {
        synchronized (this.lock) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IBinder getServiceBinder() {
        return ((e) gg3.q(this.stub)).asBinder();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public u getSessionByUri(Uri uri) {
        synchronized (this.lock) {
            try {
                for (u uVar : this.sessions.values()) {
                    if (Objects.equals(uVar.h().B0(), uri)) {
                        return uVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List<u> getSessions() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.sessions.values());
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final androidx.media3.session.d h() {
        if (this.actionFactory == null) {
            this.actionFactory = new androidx.media3.session.d(this);
        }
        return this.actionFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c i() {
        synchronized (this.lock) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isPlaybackOngoing() {
        return j().p();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isSessionAdded(u uVar) {
        boolean zContainsKey;
        synchronized (this.lock) {
            zContainsKey = this.sessions.containsKey(uVar.g());
        }
        return zContainsKey;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final t j() {
        return k(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final t k(s.b bVar) {
        if (this.mediaNotificationManager == null) {
            if (bVar == null) {
                gg3.r(getBaseContext(), "Accessing service context before onCreate()");
                bVar = new e.c(getApplicationContext()).f();
            }
            this.mediaNotificationManager = new t(this, bVar, h());
        }
        return this.mediaNotificationManager;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l() {
        List<u> sessions = getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).m().isPlaying()) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m() {
        this.mainHandler.post(new Runnable() { // from class: hm2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.i();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        Pair pairK = j().k(this);
        fy4.B1(this, ((Integer) pairK.first).intValue(), (Notification) pairK.second, 2, "mediaPlayback");
        j().l();
        fy4.J1(this, true);
        stopSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ft1, android.app.Service
    public IBinder onBind(Intent intent) {
        String action;
        u uVarOnGetSession;
        super.onBind((Intent) fy4.l(intent));
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        if (action.equals(SERVICE_INTERFACE)) {
            return getServiceBinder();
        }
        if (!action.equals("android.media.browse.MediaBrowserService") || (uVarOnGetSession = onGetSession(u.g.a())) == null) {
            return null;
        }
        addSession(uVarOnGetSession);
        return uVarOnGetSession.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ft1, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.stub = new e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ft1, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        t tVar = this.mediaNotificationManager;
        if (tVar != null) {
            tVar.l();
        }
        e eVar = this.stub;
        if (eVar != null) {
            eVar.b1();
            this.stub = null;
        }
    }

    public abstract u onGetSession(u.g gVar);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ft1, android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (intent == null) {
            return 1;
        }
        androidx.media3.session.d dVarH = h();
        Uri data = intent.getData();
        if (dVarH.i(intent) || dVarH.h(intent)) {
            u sessionByUri = data != null ? getSessionByUri(data) : null;
            if (sessionByUri == null) {
                sessionByUri = onGetSession(g(intent));
                if (sessionByUri == null) {
                    if (!this.initialStartIntentProcessed) {
                        n();
                    }
                    return 1;
                }
                addSession(sessionByUri);
            }
            if (dVarH.i(intent)) {
                final v vVarH = sessionByUri.h();
                vVarH.e0().post(new Runnable() { // from class: gm2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.b(vVarH, intent);
                    }
                });
            } else {
                String strE = dVarH.e(intent);
                if (strE == null) {
                    if (!this.initialStartIntentProcessed) {
                        n();
                    }
                    return 1;
                }
                j().q(sessionByUri, strE, dVarH.f(intent));
            }
        }
        if (!this.initialStartIntentProcessed && intent.hasExtra("androidx.media3.session.intent.uid")) {
            boolean zEquals = Objects.equals(j().n(), intent.getStringExtra("androidx.media3.session.intent.uid"));
            this.initialStartIntentProcessed = zEquals;
            if (!zEquals) {
                xz1.i(TAG, "Terminating service that was started by a stale start intent");
                n();
            }
        }
        return 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (isPlaybackOngoing() && l()) {
            return;
        }
        pauseAllPlayersAndStopSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onUpdateNotification(u uVar, boolean z) {
        onUpdateNotification(uVar);
        if (this.defaultMethodCalled) {
            j().C(uVar, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean onUpdateNotificationInternal(u uVar, boolean z) {
        try {
            onUpdateNotification(uVar, j().z(z));
            return true;
        } catch (IllegalStateException e2) {
            if (Build.VERSION.SDK_INT < 31 || !b.a(e2)) {
                throw e2;
            }
            xz1.e(TAG, "Failed to start foreground", e2);
            m();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void pauseAllPlayersAndStopSelf() {
        j().l();
        List<u> sessions = getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            sessions.get(i).m().setPlayWhenReady(false);
        }
        stopSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void removeSession(final u uVar) {
        gg3.r(uVar, "session must not be null");
        synchronized (this.lock) {
            gg3.e(this.sessions.containsKey(uVar.g()), "session not found");
            this.sessions.remove(uVar.g());
        }
        fy4.o1(this.mainHandler, new Runnable() { // from class: im2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                x.e(this.f, uVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void setForegroundServiceTimeoutMs(long j) {
        j().y(fy4.t(j, 0L, DEFAULT_FOREGROUND_SERVICE_TIMEOUT_MS));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void setListener(c cVar) {
        synchronized (this.lock) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void setMediaNotificationProvider(final s.b bVar) {
        gg3.q(bVar);
        fy4.o1(this.mainHandler, new Runnable() { // from class: km2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.f;
                s.b bVar2 = bVar;
                xVar.k(bVar2).w(bVar2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void setShowNotificationForIdlePlayer(int i) {
        j().x(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void triggerNotificationUpdate() {
        List<u> sessions = getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            onUpdateNotificationInternal(sessions.get(i), false);
        }
    }

    @Deprecated
    public void onUpdateNotification(u uVar) {
        this.defaultMethodCalled = true;
    }
}
