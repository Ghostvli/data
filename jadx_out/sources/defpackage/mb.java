package defpackage;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import defpackage.mb;
import defpackage.y72;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mb implements y72 {
    public final MediaCodec a;
    public final sb b;
    public final a82 c;
    public final z22 d;
    public boolean e;
    public int f;

    public mb(MediaCodec mediaCodec, HandlerThread handlerThread, a82 a82Var, z22 z22Var) {
        this.a = mediaCodec;
        this.b = new sb(handlerThread);
        this.c = a82Var;
        this.d = z22Var;
        this.f = 0;
    }

    public static String A(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    public static /* synthetic */ void t(mb mbVar, y72.d dVar, MediaCodec mediaCodec, long j, long j2) {
        mbVar.getClass();
        dVar.a(mbVar, j, j2);
    }

    public static /* synthetic */ void u(mb mbVar, Runnable runnable) {
        mbVar.c.d();
        mbVar.b.r(runnable);
    }

    public static String y(int i) {
        return A(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static String z(int i) {
        return A(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public final void B(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        z22 z22Var;
        this.b.h(this.a);
        hq4.a("configureCodec");
        this.a.configure(mediaFormat, surface, mediaCrypto, i);
        hq4.b();
        this.c.start();
        hq4.a("startCodec");
        this.a.start();
        hq4.b();
        if (Build.VERSION.SDK_INT >= 35 && (z22Var = this.d) != null) {
            z22Var.b(this.a);
        }
        this.f = 1;
    }

    @Override // defpackage.y72
    public void a(int i, int i2, h50 h50Var, long j, int i3) {
        this.c.a(i, i2, h50Var, j, i3);
    }

    @Override // defpackage.y72
    public void b(Bundle bundle) {
        this.c.b(bundle);
    }

    @Override // defpackage.y72
    public void c(int i, int i2, int i3, long j, int i4) {
        this.c.c(i, i2, i3, j, i4);
    }

    @Override // defpackage.y72
    public boolean d() {
        return false;
    }

    @Override // defpackage.y72
    public void e(List list) {
        this.a.subscribeToVendorParameters(list);
    }

    @Override // defpackage.y72
    public void f(final Runnable runnable) {
        this.b.r(new Runnable() { // from class: lb
            @Override // java.lang.Runnable
            public final void run() {
                mb.u(this.f, runnable);
            }
        });
    }

    @Override // defpackage.y72
    public void flush() {
        this.c.flush();
        this.a.flush();
        this.b.e();
        this.a.start();
    }

    @Override // defpackage.y72
    public MediaFormat g() {
        return this.b.g();
    }

    @Override // defpackage.y72
    public void h() {
        this.a.detachOutputSurface();
    }

    @Override // defpackage.y72
    public void i(List list) {
        this.a.unsubscribeFromVendorParameters(list);
    }

    @Override // defpackage.y72
    public void j(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // defpackage.y72
    public int k() {
        this.c.d();
        return this.b.c();
    }

    @Override // defpackage.y72
    public int l(MediaCodec.BufferInfo bufferInfo) {
        this.c.d();
        return this.b.d(bufferInfo);
    }

    @Override // defpackage.y72
    public void m(int i, boolean z) {
        this.a.releaseOutputBuffer(i, z);
    }

    @Override // defpackage.y72
    public void n(int i) {
        this.a.setVideoScalingMode(i);
    }

    @Override // defpackage.y72
    public ByteBuffer o(int i) {
        return this.a.getInputBuffer(i);
    }

    @Override // defpackage.y72
    public void p(Surface surface) {
        this.a.setOutputSurface(surface);
    }

    @Override // defpackage.y72
    public ByteBuffer q(int i) {
        return this.a.getOutputBuffer(i);
    }

    @Override // defpackage.y72
    public boolean r(y72.c cVar) {
        this.b.p(cVar);
        return true;
    }

    @Override // defpackage.y72
    public void release() {
        z22 z22Var;
        z22 z22Var2;
        try {
            if (this.f == 1) {
                this.c.shutdown();
                this.b.q();
            }
            this.f = 2;
            if (this.e) {
                return;
            }
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 30 && i < 33) {
                    this.a.stop();
                }
                if (i >= 35 && (z22Var2 = this.d) != null) {
                    z22Var2.d(this.a);
                }
                this.a.release();
                this.e = true;
            } finally {
            }
        } catch (Throwable th) {
            if (!this.e) {
                try {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 30 && i2 < 33) {
                        this.a.stop();
                    }
                    if (i2 >= 35 && (z22Var = this.d) != null) {
                        z22Var.d(this.a);
                    }
                    this.a.release();
                    this.e = true;
                } finally {
                }
            }
            throw th;
        }
    }

    @Override // defpackage.y72
    public void s(final y72.d dVar, Handler handler) {
        this.a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: kb
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                mb.t(this.a, dVar, mediaCodec, j, j2);
            }
        }, handler);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements y72.b {
        public final xi4 b;
        public final xi4 c;
        public boolean d;

        public b(final int i) {
            this(new xi4() { // from class: nb
                @Override // defpackage.xi4
                public final Object get() {
                    return mb.b.d(i);
                }
            }, new xi4() { // from class: ob
                @Override // defpackage.xi4
                public final Object get() {
                    return mb.b.c(i);
                }
            });
        }

        public static /* synthetic */ HandlerThread c(int i) {
            return new HandlerThread(mb.z(i));
        }

        public static /* synthetic */ HandlerThread d(int i) {
            return new HandlerThread(mb.y(i));
        }

        public static boolean g() {
            return Build.VERSION.SDK_INT >= 36;
        }

        @Override // y72.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public mb a(y72.a aVar) throws Exception {
            Exception exc;
            MediaCodec mediaCodecCreateByCodecName;
            a82 qbVar;
            int i;
            mb mbVar;
            String str = aVar.a.a;
            mb mbVar2 = null;
            try {
                hq4.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    if (this.d && g()) {
                        qbVar = new gk4(mediaCodecCreateByCodecName);
                        i = 4;
                    } else {
                        qbVar = new qb(mediaCodecCreateByCodecName, (HandlerThread) this.c.get());
                        i = 0;
                    }
                    mbVar = new mb(mediaCodecCreateByCodecName, (HandlerThread) this.b.get(), qbVar, aVar.f);
                } catch (Exception e) {
                    exc = e;
                }
                try {
                    hq4.b();
                    Surface surface = aVar.d;
                    if (surface == null && aVar.a.k && Build.VERSION.SDK_INT >= 35) {
                        i |= 8;
                    }
                    mbVar.B(aVar.b, surface, aVar.e, i);
                    return mbVar;
                } catch (Exception e2) {
                    exc = e2;
                    mbVar2 = mbVar;
                    if (mbVar2 != null) {
                        mbVar2.release();
                        throw exc;
                    }
                    if (mediaCodecCreateByCodecName == null) {
                        throw exc;
                    }
                    mediaCodecCreateByCodecName.release();
                    throw exc;
                }
            } catch (Exception e3) {
                exc = e3;
                mediaCodecCreateByCodecName = null;
            }
        }

        public void f(boolean z) {
            this.d = z;
        }

        public b(xi4 xi4Var, xi4 xi4Var2) {
            this.b = xi4Var;
            this.c = xi4Var2;
            this.d = true;
        }
    }
}
