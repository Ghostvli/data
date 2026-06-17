package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.MediaRouter2$ControllerCallback;
import android.media.MediaRouter2$RouteCallback;
import android.media.RouteDiscoveryPreference;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.f;
import androidx.media3.exoplayer.r;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.uh0;
import defpackage.vh0;
import defpackage.wh0;
import defpackage.xf;
import defpackage.xh0;
import defpackage.xi1;
import defpackage.zu;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements r {
    public final r a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements r {
        public AudioManager a;
        public AudioDeviceCallback b;
        public xf c;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends AudioDeviceCallback {
            public a() {
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                b.this.c.g(Boolean.valueOf(b.this.h()));
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                b.this.c.g(Boolean.valueOf(b.this.h()));
            }
        }

        public b() {
        }

        public static /* synthetic */ void d(b bVar, Context context) {
            AudioManager audioManager;
            gg3.q(bVar.c);
            if (fy4.X0(context) && (audioManager = (AudioManager) context.getSystemService("audio")) != null) {
                bVar.a = audioManager;
                a aVar = bVar.new a();
                bVar.b = aVar;
                audioManager.registerAudioDeviceCallback(aVar, new Handler((Looper) gg3.q(Looper.myLooper())));
                bVar.c.g(Boolean.valueOf(bVar.h()));
            }
        }

        public static /* synthetic */ void e(b bVar) {
            AudioManager audioManager = bVar.a;
            if (audioManager != null) {
                audioManager.unregisterAudioDeviceCallback((AudioDeviceCallback) gg3.q(bVar.b));
            }
        }

        @Override // androidx.media3.exoplayer.r
        public boolean a() {
            xf xfVar = this.c;
            if (xfVar == null) {
                return true;
            }
            return ((Boolean) xfVar.d()).booleanValue();
        }

        @Override // androidx.media3.exoplayer.r
        public void b(final r.a aVar, final Context context, Looper looper, Looper looper2, zu zuVar) {
            xf xfVar = new xf(Boolean.TRUE, looper2, looper, zuVar, new xf.a() { // from class: sh0
                @Override // xf.a
                public final void a(Object obj, Object obj2) {
                    aVar.a(((Boolean) obj2).booleanValue());
                }
            });
            this.c = xfVar;
            xfVar.e(new Runnable() { // from class: th0
                @Override // java.lang.Runnable
                public final void run() {
                    f.b.d(this.f, context);
                }
            });
        }

        @Override // androidx.media3.exoplayer.r
        public void disable() {
            ((xf) gg3.q(this.c)).e(new Runnable() { // from class: rh0
                @Override // java.lang.Runnable
                public final void run() {
                    f.b.e(this.f);
                }
            });
        }

        public final boolean h() {
            for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) gg3.q(this.a)).getDevices(2)) {
                if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 5 || audioDeviceInfo.getType() == 6 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                    return true;
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 26 && audioDeviceInfo.getType() == 22) {
                    return true;
                }
                if (i >= 28 && audioDeviceInfo.getType() == 23) {
                    return true;
                }
                if (i >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
                    return true;
                }
                if (i >= 33 && audioDeviceInfo.getType() == 30) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements r {
        public static final RouteDiscoveryPreference e;
        public MediaRouter2 a;
        public MediaRouter2$RouteCallback b;
        public MediaRouter2$ControllerCallback c;
        public xf d;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends MediaRouter2$RouteCallback {
            public a() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b extends MediaRouter2$ControllerCallback {
            public b() {
            }

            public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
                c.this.d.g(Boolean.valueOf(c.j(c.this.a)));
            }
        }

        static {
            vh0.a();
            e = uh0.a(xi1.u(), false).build();
        }

        public c() {
        }

        public static /* synthetic */ void c(c cVar) {
            ((MediaRouter2) gg3.q(cVar.a)).unregisterControllerCallback((MediaRouter2$ControllerCallback) gg3.q(cVar.c));
            cVar.c = null;
            cVar.a.unregisterRouteCallback((MediaRouter2$RouteCallback) gg3.q(cVar.b));
        }

        public static /* synthetic */ void e(c cVar, Context context) {
            gg3.q(cVar.d);
            cVar.a = MediaRouter2.getInstance(context);
            cVar.b = cVar.new a();
            final xf xfVar = cVar.d;
            Objects.requireNonNull(xfVar);
            Executor executor = new Executor() { // from class: bi0
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    xfVar.e(runnable);
                }
            };
            cVar.a.registerRouteCallback(executor, cVar.b, e);
            b bVar = cVar.new b();
            cVar.c = bVar;
            cVar.a.registerControllerCallback(executor, bVar);
            cVar.d.g(Boolean.valueOf(j(cVar.a)));
        }

        public static boolean i(MediaRoute2Info mediaRoute2Info, int i, boolean z) {
            int suitabilityStatus = mediaRoute2Info.getSuitabilityStatus();
            return suitabilityStatus == 1 ? (i == 1 || i == 2) && z : suitabilityStatus == 0;
        }

        public static boolean j(MediaRouter2 mediaRouter2) {
            int transferReason = wh0.a(gg3.q(mediaRouter2)).getSystemController().getRoutingSessionInfo().getTransferReason();
            boolean zWasTransferInitiatedBySelf = mediaRouter2.getSystemController().wasTransferInitiatedBySelf();
            Iterator<MediaRoute2Info> it = mediaRouter2.getSystemController().getSelectedRoutes().iterator();
            while (it.hasNext()) {
                if (i(xh0.a(it.next()), transferReason, zWasTransferInitiatedBySelf)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.media3.exoplayer.r
        public boolean a() {
            xf xfVar = this.d;
            if (xfVar == null) {
                return true;
            }
            return ((Boolean) xfVar.d()).booleanValue();
        }

        @Override // androidx.media3.exoplayer.r
        public void b(final r.a aVar, final Context context, Looper looper, Looper looper2, zu zuVar) {
            xf xfVar = new xf(Boolean.TRUE, looper2, looper, zuVar, new xf.a() { // from class: zh0
                @Override // xf.a
                public final void a(Object obj, Object obj2) {
                    aVar.a(((Boolean) obj2).booleanValue());
                }
            });
            this.d = xfVar;
            xfVar.e(new Runnable() { // from class: ai0
                @Override // java.lang.Runnable
                public final void run() {
                    f.c.e(this.f, context);
                }
            });
        }

        @Override // androidx.media3.exoplayer.r
        public void disable() {
            ((xf) gg3.q(this.d)).e(new Runnable() { // from class: yh0
                @Override // java.lang.Runnable
                public final void run() {
                    f.c.c(this.f);
                }
            });
        }
    }

    public f() {
        if (Build.VERSION.SDK_INT >= 35) {
            this.a = new c();
        } else {
            this.a = new b();
        }
    }

    @Override // androidx.media3.exoplayer.r
    public boolean a() {
        return this.a.a();
    }

    @Override // androidx.media3.exoplayer.r
    public void b(r.a aVar, Context context, Looper looper, Looper looper2, zu zuVar) {
        this.a.b(aVar, context, looper, looper2, zuVar);
    }

    @Override // androidx.media3.exoplayer.r
    public void disable() {
        this.a.disable();
    }
}
