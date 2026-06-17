package defpackage;

import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Handler;
import defpackage.ie;
import defpackage.pu1;
import defpackage.vc;
import defpackage.wc;
import defpackage.xd;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xd implements vc {
    public static final Object s = new Object();
    public static ScheduledExecutorService t;
    public static int u;
    public final AudioTrack a;
    public final wc.g b;
    public final float c;
    public final b d;
    public d e;
    public final ie f;
    public final boolean g;
    public final int h;
    public final f i;
    public final pu1 j = new pu1(Thread.currentThread());
    public boolean k;
    public long l;
    public long m;
    public long n;
    public ByteBuffer o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(AudioDeviceInfo audioDeviceInfo);

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final AudioTrack a;
        public final b b;
        public final Handler c;
        public AudioRouting.OnRoutingChangedListener d;

        public d(AudioTrack audioTrack, b bVar) {
            this.a = audioTrack;
            this.b = bVar;
            Handler handlerE = fy4.E();
            this.c = handlerE;
            AudioRouting.OnRoutingChangedListener onRoutingChangedListener = new AudioRouting.OnRoutingChangedListener() { // from class: yd
                @Override // android.media.AudioRouting.OnRoutingChangedListener
                public final void onRoutingChanged(AudioRouting audioRouting) {
                    this.a.e(audioRouting);
                }
            };
            this.d = onRoutingChangedListener;
            audioTrack.addOnRoutingChangedListener(onRoutingChangedListener, handlerE);
        }

        public static /* synthetic */ void b(final d dVar, AudioRouting audioRouting) {
            dVar.getClass();
            final AudioDeviceInfo routedDevice = audioRouting.getRoutedDevice();
            if (routedDevice != null) {
                dVar.c.post(new Runnable() { // from class: ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        xd.d.c(this.f, routedDevice);
                    }
                });
            }
        }

        public static /* synthetic */ void c(d dVar, AudioDeviceInfo audioDeviceInfo) {
            if (dVar.d == null) {
                return;
            }
            dVar.b.a(audioDeviceInfo);
        }

        public final void e(final AudioRouting audioRouting) {
            if (this.d == null) {
                return;
            }
            sf.a().execute(new Runnable() { // from class: zd
                @Override // java.lang.Runnable
                public final void run() {
                    xd.d.b(this.f, audioRouting);
                }
            });
        }

        public final void f() {
            this.a.removeOnRoutingChangedListener((AudioRouting.OnRoutingChangedListener) gg3.q(this.d));
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class e implements ie.a {
        public e() {
        }

        @Override // ie.a
        public void a(final long j) {
            if (xd.this.j.g()) {
                xd.this.j.l(new pu1.a() { // from class: be
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((vc.a) obj).a(j);
                    }
                });
            }
        }

        @Override // ie.a
        public void b(long j) {
            xz1.i("AudioTrackAudioOutput", "Ignoring impossibly large audio latency: " + j);
        }

        @Override // ie.a
        public void c(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + xd.this.t();
            if (he.m) {
                throw new c(str);
            }
            xz1.i("AudioTrackAudioOutput", str);
        }

        @Override // ie.a
        public void d(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + xd.this.t();
            if (he.m) {
                throw new c(str);
            }
            xz1.i("AudioTrackAudioOutput", str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class f {
        public final Handler a;
        public final AudioTrack$StreamEventCallback b;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends AudioTrack$StreamEventCallback {
            public final /* synthetic */ xd a;

            public a(xd xdVar) {
                this.a = xdVar;
            }

            public void onDataRequest(AudioTrack audioTrack, int i) {
                xd.this.j.l(new de());
            }

            public void onPresentationEnded(AudioTrack audioTrack) {
                xd.this.j.l(new pu1.a() { // from class: ee
                    @Override // pu1.a
                    public final void invoke(Object obj) {
                        ((vc.a) obj).c();
                    }
                });
            }

            public void onTearDown(AudioTrack audioTrack) {
                xd.this.j.l(new de());
            }
        }

        public f() {
            Handler handlerE = fy4.E();
            this.a = handlerE;
            a aVar = new a(xd.this);
            this.b = aVar;
            AudioTrack audioTrack = xd.this.a;
            Objects.requireNonNull(handlerE);
            audioTrack.registerStreamEventCallback(new ce(handlerE), aVar);
        }

        public final void b() {
            xd.this.a.unregisterStreamEventCallback(this.b);
            this.a.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public xd(AudioTrack audioTrack, wc.g gVar, b bVar, float f2, zu zuVar) {
        this.a = audioTrack;
        this.b = gVar;
        this.c = f2;
        this.d = bVar;
        boolean zR0 = fy4.R0(gVar.a);
        this.g = zR0;
        if (zR0) {
            this.h = fy4.u0(gVar.a, Integer.bitCount(gVar.c));
        } else {
            this.h = -1;
        }
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.f = new ie(new e(), zuVar, audioTrack, gVar.a, this.h, gVar.f);
        if (bVar != null) {
            this.e = new d(audioTrack, bVar);
        }
        this.i = i() ? new f() : null;
    }

    public static /* synthetic */ void a(AudioTrack audioTrack, Handler handler, final pu1 pu1Var) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: vd
                    @Override // java.lang.Runnable
                    public final void run() {
                        xd.b(pu1Var);
                    }
                });
            }
            synchronized (s) {
                try {
                    int i = u - 1;
                    u = i;
                    if (i == 0) {
                        ((ScheduledExecutorService) gg3.q(t)).shutdown();
                        t = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            if (handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: vd
                    @Override // java.lang.Runnable
                    public final void run() {
                        xd.b(pu1Var);
                    }
                });
            }
            synchronized (s) {
                try {
                    int i2 = u - 1;
                    u = i2;
                    if (i2 == 0) {
                        ((ScheduledExecutorService) gg3.q(t)).shutdown();
                        t = null;
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    public static /* synthetic */ void b(pu1 pu1Var) {
        if (pu1Var.g()) {
            pu1Var.l(new pu1.a() { // from class: wd
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((vc.a) obj).d();
                }
            });
        }
    }

    public static boolean v(int i) {
        return i == -6 || i == -32;
    }

    public static void x(final AudioTrack audioTrack, final pu1 pu1Var) {
        final Handler handlerE = fy4.E();
        synchronized (s) {
            try {
                if (t == null) {
                    t = fy4.e1("ExoPlayer:AudioTrackReleaseThread");
                }
                u++;
                t.schedule(new Runnable() { // from class: ud
                    @Override // java.lang.Runnable
                    public final void run() {
                        xd.a(audioTrack, handlerE, pu1Var);
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.vc
    public void c(int i, int i2) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        this.a.setOffloadDelayPadding(i, i2);
    }

    @Override // defpackage.vc
    public void d(ie3 ie3Var) {
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        LogSessionId logSessionIdA = ie3Var.a();
        if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        this.a.setLogSessionId(logSessionIdA);
    }

    @Override // defpackage.vc
    public long e() {
        return this.f.b();
    }

    @Override // defpackage.vc
    public void f(float f2) {
        this.a.setAuxEffectSendLevel(f2);
    }

    @Override // defpackage.vc
    public boolean g() {
        return this.f.i(t());
    }

    @Override // defpackage.vc
    public int getAudioSessionId() {
        return this.a.getAudioSessionId();
    }

    @Override // defpackage.vc
    public dc3 getPlaybackParameters() {
        PlaybackParams playbackParams = this.a.getPlaybackParams();
        return new dc3(playbackParams.getSpeed(), playbackParams.getPitch());
    }

    @Override // defpackage.vc
    public void h(vc.a aVar) {
        this.j.c(aVar);
    }

    @Override // defpackage.vc
    public boolean i() {
        return Build.VERSION.SDK_INT >= 29 && this.a.isOffloadedPlayback();
    }

    @Override // defpackage.vc
    public int j() {
        return this.a.getSampleRate();
    }

    @Override // defpackage.vc
    public long k() {
        return this.a.getBufferSizeInFrames();
    }

    @Override // defpackage.vc
    public void l(int i) {
        this.a.attachAuxEffect(i);
    }

    @Override // defpackage.vc
    public void n() {
        if (Build.VERSION.SDK_INT >= 29 && this.a.getPlayState() == 3) {
            this.a.setOffloadEndOfStream();
            this.f.a();
        }
    }

    @Override // defpackage.vc
    public boolean o(ByteBuffer byteBuffer, int i, long j) throws vc.b {
        int iWrite;
        b bVar;
        if (!this.g && this.q == 0) {
            this.q = pe0.W(this.b.a, byteBuffer);
        }
        w();
        int iRemaining = byteBuffer.remaining();
        if (this.b.d) {
            if (j == Long.MIN_VALUE) {
                j = this.n;
            } else {
                this.n = j;
            }
            iWrite = y(this.a, byteBuffer, j);
        } else {
            iWrite = this.a.write(byteBuffer, byteBuffer.remaining(), 1);
        }
        if (iWrite < 0) {
            boolean zV = v(iWrite);
            if (zV && (bVar = this.d) != null) {
                bVar.b();
            }
            throw new vc.b(iWrite, zV);
        }
        boolean z = iWrite == iRemaining;
        if (this.g) {
            this.l += (long) iWrite;
            return z;
        }
        if (z) {
            this.m += ((long) this.q) * ((long) i);
        }
        return z;
    }

    @Override // defpackage.vc
    public void pause() {
        this.f.m();
        if (!this.k || i()) {
            this.a.pause();
        }
    }

    @Override // defpackage.vc
    public void play() {
        this.f.p();
        if (!this.k || i()) {
            this.a.play();
        }
    }

    @Override // defpackage.vc
    public void release() {
        if (this.f.h()) {
            this.a.pause();
        }
        if (Build.VERSION.SDK_INT >= 29 && i()) {
            ((f) gg3.q(this.i)).b();
        }
        d dVar = this.e;
        if (dVar != null) {
            dVar.f();
            this.e = null;
        }
        x(this.a, this.j);
    }

    public final int s(long j) {
        return this.a.getUnderrunCount();
    }

    @Override // defpackage.vc
    public void setPlaybackParameters(dc3 dc3Var) {
        try {
            this.a.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(fy4.r(dc3Var.a, 0.1f, this.c)).setPitch(fy4.r(dc3Var.b, 0.1f, 8.0f)).setAudioFallbackMode(2));
        } catch (IllegalArgumentException e2) {
            xz1.j("AudioTrackAudioOutput", "Failed to set playback params", e2);
        }
        this.f.o(this.a.getPlaybackParams().getSpeed());
    }

    @Override // defpackage.vc
    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        this.a.setPreferredDevice(audioDeviceInfo);
    }

    @Override // defpackage.vc
    public void setVolume(float f2) {
        this.a.setVolume(f2);
    }

    @Override // defpackage.vc
    public void stop() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.f.g(t());
        this.a.stop();
        this.p = 0;
    }

    public final long t() {
        return this.g ? fy4.o(this.l, this.h) : this.m;
    }

    public final boolean u(long j) {
        int iS = s(j);
        boolean z = iS > this.r;
        this.r = iS;
        return z;
    }

    public final void w() {
        if (this.j.g() && u(t())) {
            this.j.l(new pu1.a() { // from class: td
                @Override // pu1.a
                public final void invoke(Object obj) {
                    ((vc.a) obj).e();
                }
            });
        }
    }

    public final int y(AudioTrack audioTrack, ByteBuffer byteBuffer, long j) {
        int iRemaining = byteBuffer.remaining();
        if (Build.VERSION.SDK_INT >= 26) {
            return audioTrack.write(byteBuffer, iRemaining, 1, j * 1000);
        }
        if (this.o == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.o = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.o.putInt(1431633921);
        }
        if (this.p == 0) {
            this.o.putInt(4, iRemaining);
            this.o.putLong(8, j * 1000);
            this.o.position(0);
            this.p = iRemaining;
        }
        int iRemaining2 = this.o.remaining();
        if (iRemaining2 > 0) {
            int iWrite = audioTrack.write(this.o, iRemaining2, 1);
            if (iWrite < 0) {
                this.p = 0;
                return iWrite;
            }
            if (iWrite < iRemaining2) {
                return 0;
            }
        }
        int iWrite2 = audioTrack.write(byteBuffer, iRemaining, 1);
        if (iWrite2 < 0) {
            this.p = 0;
            return iWrite2;
        }
        this.p -= iWrite2;
        return iWrite2;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends RuntimeException {
        public c(String str) {
            super(str);
        }
    }
}
