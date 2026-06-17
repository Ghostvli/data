package defpackage;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.view.KeyEvent;
import defpackage.kh1;
import defpackage.lh1;
import defpackage.pi2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class v82 {
    public final b a;
    public final pi2.h b;
    public final Set c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a implements IBinder.DeathRecipient {
        public final MediaController.Callback a = new b(this);
        public c b;
        public kh1 c;

        /* JADX INFO: renamed from: v82$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class BinderC0126a extends kh1.a {
            public final WeakReference d;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public BinderC0126a(a aVar) {
                this.d = new WeakReference(aVar);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.kh1
            public void P(boolean z) {
                a aVar = (a) this.d.get();
                if (aVar != null) {
                    aVar.m(11, Boolean.valueOf(z), null);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.kh1
            public void i(cd3 cd3Var) {
                a aVar = (a) this.d.get();
                if (aVar != null) {
                    aVar.m(2, cd3Var, null);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.kh1
            public void n0(int i) {
                a aVar = (a) this.d.get();
                if (aVar != null) {
                    aVar.m(12, Integer.valueOf(i), null);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.kh1
            public void onRepeatModeChanged(int i) {
                a aVar = (a) this.d.get();
                if (aVar != null) {
                    aVar.m(9, Integer.valueOf(i), null);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.kh1
            public void z() {
                a aVar = (a) this.d.get();
                if (aVar != null) {
                    aVar.m(13, null, null);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class b extends MediaController.Callback {
            public final WeakReference a;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b(a aVar) {
                this.a = new WeakReference(aVar);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                a aVar = (a) this.a.get();
                if (aVar == null || playbackInfo == null) {
                    return;
                }
                int playbackType = playbackInfo.getPlaybackType();
                String volumeControlId = Build.VERSION.SDK_INT >= 30 ? playbackInfo.getVolumeControlId() : null;
                boolean z = true;
                if (playbackType == 1 && volumeControlId != null) {
                    z = false;
                }
                gg3.d(z);
                aVar.a(new e(playbackType, yb.b(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume(), volumeControlId));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                Bundle bundleY = fy4.y(bundle);
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.c(bundleY);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.d(qh2.d(mediaMetadata));
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                a aVar = (a) this.a.get();
                if (aVar == null || aVar.c != null) {
                    return;
                }
                aVar.e(cd3.c(playbackState));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List list) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.f(pi2.g.d(list));
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.g(charSequence);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.i();
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                Bundle bundleY = fy4.y(bundle);
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.j(str, bundleY);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class c extends Handler {
            public boolean a;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public c(Looper looper) {
                super(looper);
                this.a = false;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.a) {
                    int i = message.what;
                    if (i == 2) {
                        a.this.e((cd3) message.obj);
                        return;
                    }
                    if (i == 8) {
                        a.this.i();
                        return;
                    }
                    if (i == 9) {
                        a.this.h(((Integer) message.obj).intValue());
                        return;
                    }
                    switch (i) {
                        case 11:
                            a.this.b(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            a.this.l(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            a.this.k();
                            break;
                    }
                }
            }
        }

        public abstract void a(e eVar);

        public abstract void b(boolean z);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            m(8, null, null);
        }

        public abstract void c(Bundle bundle);

        public abstract void d(qh2 qh2Var);

        public abstract void e(cd3 cd3Var);

        public abstract void f(List list);

        public abstract void g(CharSequence charSequence);

        public abstract void h(int i);

        public abstract void i();

        public abstract void j(String str, Bundle bundle);

        public abstract void k();

        public abstract void l(int i);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void m(int i, Object obj, Bundle bundle) {
            c cVar = this.b;
            if (cVar != null) {
                Message messageObtainMessage = cVar.obtainMessage(i, obj);
                if (bundle != null) {
                    messageObtainMessage.setData(bundle);
                }
                messageObtainMessage.sendToTarget();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void n(Handler handler) {
            if (handler != null) {
                c cVar = new c(handler.getLooper());
                this.b = cVar;
                cVar.a = true;
            } else {
                c cVar2 = this.b;
                if (cVar2 != null) {
                    cVar2.a = false;
                    cVar2.removeCallbacksAndMessages(null);
                    this.b = null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        long a();

        String b();

        void c(a aVar, Handler handler);

        int d();

        int e();

        boolean f();

        e g();

        Bundle getExtras();

        cd3 getPlaybackState();

        int getRepeatMode();

        void h(int i, int i2);

        void i(zf2 zf2Var, int i);

        CharSequence j();

        qh2 k();

        boolean l(KeyEvent keyEvent);

        void m(int i, int i2);

        boolean n();

        void o(a aVar);

        List p();

        f q();

        void r(zf2 zf2Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements b {
        public final MediaController a;
        public final Object b = new Object();
        public final List c = new ArrayList();
        public final HashMap d = new HashMap();
        public final pi2.h e;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a extends ResultReceiver {
            public final WeakReference f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(c cVar) {
                super(null);
                this.f = new WeakReference(cVar);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i, Bundle bundle) {
                c cVar = (c) this.f.get();
                if (cVar == null || bundle == null) {
                    return;
                }
                synchronized (cVar.b) {
                    cVar.e.w(lh1.a.Z0(bundle.getBinder("android.support.v4.media.session.EXTRA_BINDER")));
                    cVar.e.x(n73.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                    cVar.s();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Context context, pi2.h hVar) {
            this.e = hVar;
            this.a = new MediaController(context, hVar.v());
            if (hVar.s() == null) {
                t();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public long a() {
            return this.a.getFlags();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public String b() {
            return this.a.getPackageName();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public final void c(a aVar, Handler handler) {
            this.a.registerCallback((MediaController.Callback) gg3.q(aVar.a), handler);
            synchronized (this.b) {
                lh1 lh1VarS = this.e.s();
                if (lh1VarS != null) {
                    a.BinderC0126a binderC0126a = new a.BinderC0126a(aVar);
                    this.d.put(aVar, binderC0126a);
                    aVar.c = binderC0126a;
                    try {
                        lh1VarS.t0(binderC0126a);
                        aVar.m(13, null, null);
                    } catch (RemoteException | SecurityException e) {
                        xz1.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                } else {
                    aVar.c = null;
                    this.c.add(aVar);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public int d() {
            return this.a.getRatingType();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public int e() {
            lh1 lh1VarS = this.e.s();
            if (lh1VarS == null) {
                return -1;
            }
            try {
                return lh1VarS.e();
            } catch (RemoteException | SecurityException e) {
                xz1.e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
                return -1;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public boolean f() {
            lh1 lh1VarS = this.e.s();
            if (lh1VarS == null) {
                return false;
            }
            try {
                return lh1VarS.f();
            } catch (RemoteException | SecurityException e) {
                xz1.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
                return false;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public e g() {
            MediaController.PlaybackInfo playbackInfo = this.a.getPlaybackInfo();
            if (playbackInfo != null) {
                return new e(playbackInfo.getPlaybackType(), yb.b(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume(), Build.VERSION.SDK_INT >= 30 ? playbackInfo.getVolumeControlId() : null);
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public Bundle getExtras() {
            return fy4.y(this.a.getExtras());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public cd3 getPlaybackState() {
            lh1 lh1VarS = this.e.s();
            if (lh1VarS != null) {
                try {
                    return lh1VarS.getPlaybackState();
                } catch (RemoteException | SecurityException e) {
                    xz1.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
                }
            }
            PlaybackState playbackState = this.a.getPlaybackState();
            if (playbackState != null) {
                return cd3.c(playbackState);
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public int getRepeatMode() {
            lh1 lh1VarS = this.e.s();
            if (lh1VarS == null) {
                return -1;
            }
            try {
                return lh1VarS.getRepeatMode();
            } catch (RemoteException | SecurityException e) {
                xz1.e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
                return -1;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public void h(int i, int i2) {
            this.a.adjustVolume(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public void i(zf2 zf2Var, int i) {
            if ((a() & 4) == 0) {
                fn.a("This session doesn't support queue management operations");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", ps1.a(zf2Var, MediaDescriptionCompat.CREATOR));
            bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", i);
            u("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public CharSequence j() {
            return this.a.getQueueTitle();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public qh2 k() {
            MediaMetadata metadata = this.a.getMetadata();
            if (metadata != null) {
                return qh2.d(metadata);
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public boolean l(KeyEvent keyEvent) {
            return this.a.dispatchMediaButtonEvent(keyEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public void m(int i, int i2) {
            this.a.setVolumeTo(i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public boolean n() {
            return this.e.s() != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public final void o(a aVar) {
            this.a.unregisterCallback((MediaController.Callback) gg3.q(aVar.a));
            synchronized (this.b) {
                lh1 lh1VarS = this.e.s();
                if (lh1VarS != null) {
                    try {
                        a.BinderC0126a binderC0126a = (a.BinderC0126a) this.d.remove(aVar);
                        if (binderC0126a != null) {
                            aVar.c = null;
                            lh1VarS.m0(binderC0126a);
                        }
                    } catch (RemoteException | SecurityException e) {
                        xz1.e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
                    }
                } else {
                    this.c.remove(aVar);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public List p() {
            List<MediaSession.QueueItem> queue = this.a.getQueue();
            if (queue != null) {
                return pi2.g.d(queue);
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public f q() {
            MediaController.TransportControls transportControls = this.a.getTransportControls();
            return Build.VERSION.SDK_INT >= 29 ? new i(transportControls) : new h(transportControls);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.b
        public void r(zf2 zf2Var) {
            if ((a() & 4) == 0) {
                fn.a("This session doesn't support queue management operations");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", ps1.a(zf2Var, MediaDescriptionCompat.CREATOR));
            u("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s() {
            lh1 lh1VarS = this.e.s();
            if (lh1VarS == null) {
                return;
            }
            for (a aVar : this.c) {
                a.BinderC0126a binderC0126a = new a.BinderC0126a(aVar);
                this.d.put(aVar, binderC0126a);
                aVar.c = binderC0126a;
                try {
                    lh1VarS.t0(binderC0126a);
                    aVar.m(13, null, null);
                } catch (RemoteException | SecurityException e) {
                    xz1.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                }
            }
            this.c.clear();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void t() {
            u("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new a(this));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void u(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.a.sendCommand(str, bundle, resultReceiver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends c {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Context context, pi2.h hVar) {
            super(context, hVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final int a;
        public final yb b;
        public final int c;
        public final int d;
        public final int e;
        public final String f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(int i, yb ybVar, int i2, int i3, int i4, String str) {
            this.a = i;
            this.b = ybVar;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public yb a() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int c() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int d() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int e() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class f {
        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d(String str, Bundle bundle);

        public abstract void e(String str, Bundle bundle);

        public abstract void f(Uri uri, Bundle bundle);

        public abstract void g();

        public abstract void h(String str, Bundle bundle);

        public abstract void i(String str, Bundle bundle);

        public abstract void j(Uri uri, Bundle bundle);

        public abstract void k();

        public abstract void l(long j);

        public abstract void m(String str, Bundle bundle);

        public abstract void n(float f);

        public abstract void o(int i);

        public abstract void p(int i);

        public abstract void q();

        public abstract void r();

        public abstract void s(long j);

        public abstract void t();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends f {
        public final MediaController.TransportControls a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(MediaController.TransportControls transportControls) {
            this.a = transportControls;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void a() {
            this.a.fastForward();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void b() {
            this.a.pause();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void c() {
            this.a.play();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void d(String str, Bundle bundle) {
            this.a.playFromMediaId(str, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void e(String str, Bundle bundle) {
            this.a.playFromSearch(str, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void f(Uri uri, Bundle bundle) {
            this.a.playFromUri(uri, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void k() {
            this.a.rewind();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void l(long j) {
            this.a.seekTo(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void m(String str, Bundle bundle) {
            v82.v(str, bundle);
            this.a.sendCustomAction(str, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void n(float f) {
            if (f == 0.0f) {
                jl.a("speed must not be zero");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", f);
            m("android.support.v4.media.session.action.SET_PLAYBACK_SPEED", bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void o(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i);
            m("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void p(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", i);
            m("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void q() {
            this.a.skipToNext();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void r() {
            this.a.skipToPrevious();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void s(long j) {
            this.a.skipToQueueItem(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void t() {
            this.a.stop();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h extends g {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void g() {
            this.a.prepare();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void h(String str, Bundle bundle) {
            this.a.prepareFromMediaId(str, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void i(String str, Bundle bundle) {
            this.a.prepareFromSearch(str, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.f
        public void j(Uri uri, Bundle bundle) {
            this.a.prepareFromUri(uri, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i extends h {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v82.g, v82.f
        public void n(float f) {
            if (f != 0.0f) {
                this.a.setPlaybackSpeed(f);
            } else {
                jl.a("speed must not be zero");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v82(Context context, pi2.h hVar) {
        this.c = Collections.synchronizedSet(new HashSet());
        this.b = hVar;
        if (Build.VERSION.SDK_INT >= 29) {
            this.a = new d(context, hVar);
        } else {
            this.a = new c(context, hVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void v(String str, Bundle bundle) {
        if (str == null) {
            return;
        }
        if (str.equals("android.support.v4.media.session.action.FOLLOW") || str.equals("android.support.v4.media.session.action.UNFOLLOW")) {
            if (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")) {
                f02.a("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ", str, ".");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(zf2 zf2Var, int i2) {
        this.a.i(zf2Var, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(int i2, int i3) {
        this.a.h(i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.a.l(keyEvent);
        }
        jl.a("KeyEvent may not be null");
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle d() {
        return this.a.getExtras();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long e() {
        return this.a.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qh2 f() {
        return this.a.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String g() {
        return this.a.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e h() {
        return this.a.g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cd3 i() {
        return this.a.getPlaybackState();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List j() {
        return this.a.p();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence k() {
        return this.a.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int l() {
        return this.a.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m() {
        return this.a.getRepeatMode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int n() {
        return this.a.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f o() {
        return this.a.q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p() {
        return this.a.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q() {
        return this.a.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(a aVar, Handler handler) {
        if (!this.c.add(aVar)) {
            xz1.i("MediaControllerCompat", "the callback has already been registered");
            return;
        }
        if (handler == null) {
            handler = new Handler();
        }
        aVar.n(handler);
        this.a.c(aVar, handler);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(zf2 zf2Var) {
        this.a.r(zf2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(int i2, int i3) {
        this.a.m(i2, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u(a aVar) {
        if (!this.c.remove(aVar)) {
            xz1.i("MediaControllerCompat", "the callback has never been registered");
            return;
        }
        try {
            this.a.o(aVar);
        } finally {
            aVar.n(null);
        }
    }

    public v82(Context context, pi2 pi2Var) {
        this(context, pi2Var.e());
    }
}
