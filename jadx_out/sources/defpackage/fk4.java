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
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
        /* JADX WARN: Type inference failed for: r0v0, types: [fk4$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // y72.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public defpackage.y72 a(y72.a r6) throws java.lang.Throwable {
            /*
                r5 = this;
                r0 = 0
                android.media.MediaCodec r5 = r5.c(r6)     // Catch: java.lang.RuntimeException -> L40 java.io.IOException -> L42
                java.lang.String r1 = "configureCodec"
                defpackage.hq4.a(r1)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                android.view.Surface r1 = r6.d     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                if (r1 != 0) goto L22
                c82 r2 = r6.a     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                boolean r2 = r2.k     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                if (r2 == 0) goto L22
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r3 = 35
                if (r2 < r3) goto L22
                r2 = 8
                goto L23
            L1d:
                r6 = move-exception
            L1e:
                r0 = r5
                goto L43
            L20:
                r6 = move-exception
                goto L1e
            L22:
                r2 = 0
            L23:
                android.media.MediaFormat r3 = r6.b     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                android.media.MediaCrypto r4 = r6.e     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r5.configure(r3, r1, r4, r2)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                defpackage.hq4.b()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                java.lang.String r1 = "startCodec"
                defpackage.hq4.a(r1)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r5.start()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                defpackage.hq4.b()     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                fk4 r1 = new fk4     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                z22 r6 = r6.f     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                r1.<init>(r5, r6)     // Catch: java.lang.RuntimeException -> L1d java.io.IOException -> L20
                return r1
            L40:
                r6 = move-exception
                goto L43
            L42:
                r6 = move-exception
            L43:
                if (r0 == 0) goto L48
                r0.release()
            L48:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: fk4.b.a(y72$a):y72");
        }

        public MediaCodec c(y72.a aVar) throws IOException {
            gg3.q(aVar.a);
            String str = aVar.a.a;
            hq4.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            hq4.b();
            return mediaCodecCreateByCodecName;
        }
    }

    public fk4(MediaCodec mediaCodec, z22 z22Var) {
        this.a = mediaCodec;
        this.b = z22Var;
        if (Build.VERSION.SDK_INT < 35 || z22Var == null) {
            return;
        }
        z22Var.b(mediaCodec);
    }

    public static /* synthetic */ void t(fk4 fk4Var, y72.d dVar, MediaCodec mediaCodec, long j, long j2) {
        fk4Var.getClass();
        dVar.a(fk4Var, j, j2);
    }

    @Override // defpackage.y72
    public void a(int i, int i2, h50 h50Var, long j, int i3) {
        this.a.queueSecureInputBuffer(i, i2, h50Var.a(), j, i3);
    }

    @Override // defpackage.y72
    public void b(Bundle bundle) {
        this.a.setParameters(bundle);
    }

    @Override // defpackage.y72
    public void c(int i, int i2, int i3, long j, int i4) {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
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
    public void flush() {
        this.a.flush();
    }

    @Override // defpackage.y72
    public MediaFormat g() {
        return this.a.getOutputFormat();
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
        return this.a.dequeueInputBuffer(0L);
    }

    @Override // defpackage.y72
    public int l(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
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

    @Override // defpackage.y72
    public void s(final y72.d dVar, Handler handler) {
        this.a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: ek4
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                fk4.t(this.a, dVar, mediaCodec, j, j2);
            }
        }, handler);
    }
}
