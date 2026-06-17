package defpackage;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import defpackage.y72;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fk4 implements y72 {
    public final MediaCodec a;
    public final z22 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements y72.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0040 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: android.media.MediaCodec */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
        /* JADX WARN: Type inference failed for: r0v0, types: [fk4$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // y72.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public y72 a(y72.a aVar) throws Throwable {
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                MediaCodec mediaCodecC = c(aVar);
                try {
                    hq4.a("configureCodec");
                    Surface surface = aVar.d;
                    mediaCodecC.configure(aVar.b, surface, aVar.e, (surface == null && aVar.a.k && Build.VERSION.SDK_INT >= 35) ? 8 : 0);
                    hq4.b();
                    hq4.a("startCodec");
                    mediaCodecC.start();
                    hq4.b();
                    return new fk4(mediaCodecC, aVar.f);
                } catch (IOException e) {
                    e = e;
                    mediaCodec = mediaCodecC;
                    if (mediaCodec != 0) {
                        mediaCodec.release();
                    }
                    throw e;
                } catch (RuntimeException e2) {
                    e = e2;
                    mediaCodec = mediaCodecC;
                    if (mediaCodec != 0) {
                    }
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (RuntimeException e4) {
                e = e4;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public MediaCodec c(y72.a aVar) throws IOException {
            gg3.q(aVar.a);
            String str = aVar.a.a;
            hq4.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            hq4.b();
            return mediaCodecCreateByCodecName;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fk4(MediaCodec mediaCodec, z22 z22Var) {
        this.a = mediaCodec;
        this.b = z22Var;
        if (Build.VERSION.SDK_INT < 35 || z22Var == null) {
            return;
        }
        z22Var.b(mediaCodec);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void t(fk4 fk4Var, y72.d dVar, MediaCodec mediaCodec, long j, long j2) {
        fk4Var.getClass();
        dVar.a(fk4Var, j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void a(int i, int i2, h50 h50Var, long j, int i3) {
        this.a.queueSecureInputBuffer(i, i2, h50Var.a(), j, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void b(Bundle bundle) {
        this.a.setParameters(bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void c(int i, int i2, int i3, long j, int i4) {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public boolean d() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void e(List list) {
        this.a.subscribeToVendorParameters(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void flush() {
        this.a.flush();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public MediaFormat g() {
        return this.a.getOutputFormat();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void h() {
        this.a.detachOutputSurface();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void i(List list) {
        this.a.unsubscribeFromVendorParameters(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void j(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public int k() {
        return this.a.dequeueInputBuffer(0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public int l(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void m(int i, boolean z) {
        this.a.releaseOutputBuffer(i, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void n(int i) {
        this.a.setVideoScalingMode(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public ByteBuffer o(int i) {
        return this.a.getInputBuffer(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void p(Surface surface) {
        this.a.setOutputSurface(surface);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public ByteBuffer q(int i) {
        return this.a.getOutputBuffer(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void release() {
        z22 z22Var;
        z22 z22Var2;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && i < 33) {
                this.a.stop();
            }
            if (i >= 35 && (z22Var2 = this.b) != null) {
                z22Var2.d(this.a);
            }
            this.a.release();
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && (z22Var = this.b) != null) {
                z22Var.d(this.a);
            }
            this.a.release();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.y72
    public void s(final y72.d dVar, Handler handler) {
        this.a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: ek4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                fk4.t(this.a, dVar, mediaCodec, j, j2);
            }
        }, handler);
    }
}
