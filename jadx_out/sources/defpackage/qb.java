package defpackage;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class qb implements a82 {
    public static final ArrayDeque g = new ArrayDeque();
    public static final Object h = new Object();
    public final MediaCodec a;
    public final HandlerThread b;
    public Handler c;
    public final AtomicReference d;
    public final cz e;
    public boolean f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            qb.this.j(message);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public int a;
        public int b;
        public int c;
        public final MediaCodec.CryptoInfo d = new MediaCodec.CryptoInfo();
        public long e;
        public int f;

        public void a(int i, int i2, int i3, long j, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.e = j;
            this.f = i4;
        }
    }

    public qb(MediaCodec mediaCodec, HandlerThread handlerThread, cz czVar) {
        this.a = mediaCodec;
        this.b = handlerThread;
        this.e = czVar;
        this.d = new AtomicReference();
    }

    public static void g(h50 h50Var, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = h50Var.f;
        cryptoInfo.numBytesOfClearData = i(h50Var.d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = i(h50Var.e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) gg3.q(h(h50Var.b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) gg3.q(h(h50Var.a, cryptoInfo.iv));
        cryptoInfo.mode = h50Var.c;
        cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(h50Var.g, h50Var.h));
    }

    public static byte[] h(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int[] i(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static b o() {
        ArrayDeque arrayDeque = g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new b();
                }
                return (b) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void p(b bVar) {
        ArrayDeque arrayDeque = g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    @Override // defpackage.a82
    public void a(int i, int i2, h50 h50Var, long j, int i3) {
        d();
        b bVarO = o();
        bVarO.a(i, i2, 0, j, i3);
        g(h50Var, bVarO.d);
        ((Handler) fy4.l(this.c)).obtainMessage(2, bVarO).sendToTarget();
    }

    @Override // defpackage.a82
    public void b(Bundle bundle) {
        d();
        ((Handler) fy4.l(this.c)).obtainMessage(4, bundle).sendToTarget();
    }

    @Override // defpackage.a82
    public void c(int i, int i2, int i3, long j, int i4) {
        d();
        b bVarO = o();
        bVarO.a(i, i2, i3, j, i4);
        ((Handler) fy4.l(this.c)).obtainMessage(1, bVarO).sendToTarget();
    }

    @Override // defpackage.a82
    public void d() {
        RuntimeException runtimeException = (RuntimeException) this.d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final void f() {
        this.e.d();
        ((Handler) gg3.q(this.c)).obtainMessage(3).sendToTarget();
        this.e.a();
    }

    @Override // defpackage.a82
    public void flush() {
        if (this.f) {
            try {
                n();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(android.os.Message r9) {
        /*
            r8 = this;
            int r2 = r9.what
            r3 = 1
            if (r2 == r3) goto L41
            r3 = 2
            if (r2 == r3) goto L2c
            r3 = 3
            r4 = 0
            if (r2 == r3) goto L26
            r3 = 4
            if (r2 == r3) goto L1e
            java.util.concurrent.atomic.AtomicReference r0 = r8.d
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            defpackage.pb.a(r0, r4, r1)
            goto L55
        L1e:
            java.lang.Object r1 = r9.obj
            android.os.Bundle r1 = (android.os.Bundle) r1
            r8.m(r1)
            goto L55
        L26:
            cz r0 = r8.e
            r0.f()
            goto L55
        L2c:
            java.lang.Object r1 = r9.obj
            r7 = r1
            qb$b r7 = (qb.b) r7
            int r1 = r7.a
            int r2 = r7.b
            android.media.MediaCodec$CryptoInfo r3 = r7.d
            long r4 = r7.e
            int r6 = r7.f
            r0 = r8
            r0.l(r1, r2, r3, r4, r6)
        L3f:
            r4 = r7
            goto L55
        L41:
            java.lang.Object r0 = r9.obj
            r7 = r0
            qb$b r7 = (qb.b) r7
            int r1 = r7.a
            int r2 = r7.b
            int r3 = r7.c
            long r4 = r7.e
            int r6 = r7.f
            r0 = r8
            r0.k(r1, r2, r3, r4, r6)
            goto L3f
        L55:
            if (r4 == 0) goto L5a
            p(r4)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qb.j(android.os.Message):void");
    }

    public final void k(int i, int i2, int i3, long j, int i4) {
        try {
            this.a.queueInputBuffer(i, i2, i3, j, i4);
        } catch (RuntimeException e) {
            pb.a(this.d, null, e);
        }
    }

    public final void l(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            synchronized (h) {
                this.a.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
            }
        } catch (RuntimeException e) {
            pb.a(this.d, null, e);
        }
    }

    public final void m(Bundle bundle) {
        try {
            this.a.setParameters(bundle);
        } catch (RuntimeException e) {
            pb.a(this.d, null, e);
        }
    }

    public final void n() {
        ((Handler) gg3.q(this.c)).removeCallbacksAndMessages(null);
        f();
    }

    @Override // defpackage.a82
    public void shutdown() {
        if (this.f) {
            flush();
            this.b.quit();
        }
        this.f = false;
    }

    @Override // defpackage.a82
    public void start() {
        if (this.f) {
            return;
        }
        this.b.start();
        this.c = new a(this.b.getLooper());
        this.f = true;
    }

    public qb(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new cz());
    }
}
