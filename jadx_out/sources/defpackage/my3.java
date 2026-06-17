package defpackage;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import defpackage.fa1;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class my3 implements j25, gp {
    public int n;
    public SurfaceTexture o;
    public byte[] r;
    public final AtomicBoolean f = new AtomicBoolean();
    public final AtomicBoolean g = new AtomicBoolean(true);
    public final bi3 h = new bi3();
    public final s71 i = new s71();
    public final ko4 j = new ko4();
    public final ko4 k = new ko4();
    public final float[] l = new float[16];
    public final float[] m = new float[16];
    public volatile int p = 0;
    public int q = -1;

    @Override // defpackage.gp
    public void a(long j, float[] fArr) {
        this.i.e(j, fArr);
    }

    public void c(float[] fArr, boolean z) {
        GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            fa1.c();
        } catch (fa1.a e) {
            xz1.e("SceneRenderer", "Failed to draw a frame", e);
        }
        if (this.f.compareAndSet(true, false)) {
            ((SurfaceTexture) gg3.q(this.o)).updateTexImage();
            try {
                fa1.c();
            } catch (fa1.a e2) {
                xz1.e("SceneRenderer", "Failed to draw a frame", e2);
            }
            if (this.g.compareAndSet(true, false)) {
                fa1.p(this.l);
            }
            long timestamp = this.o.getTimestamp();
            Long l = (Long) this.j.g(timestamp);
            if (l != null) {
                this.i.c(this.l, l.longValue());
            }
            zh3 zh3Var = (zh3) this.k.j(timestamp);
            if (zh3Var != null) {
                this.h.d(zh3Var);
            }
        }
        Matrix.multiplyMM(this.m, 0, fArr, 0, this.l, 0);
        this.h.a(this.n, this.m, z);
    }

    public SurfaceTexture d() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            fa1.c();
            this.h.b();
            fa1.c();
            this.n = fa1.g();
        } catch (fa1.a e) {
            xz1.e("SceneRenderer", "Failed to initialize the renderer", e);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.n);
        this.o = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: ly3
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f.f.set(true);
            }
        });
        return this.o;
    }

    @Override // defpackage.gp
    public void e() {
        this.j.c();
        this.i.d();
        this.g.set(true);
    }

    public void f(int i) {
        this.p = i;
    }

    public final void g(byte[] bArr, int i, long j) {
        byte[] bArr2 = this.r;
        int i2 = this.q;
        this.r = bArr;
        if (i == -1) {
            i = this.p;
        }
        this.q = i;
        if (i2 == i && Arrays.equals(bArr2, this.r)) {
            return;
        }
        byte[] bArr3 = this.r;
        zh3 zh3VarA = bArr3 != null ? ai3.a(bArr3, this.q) : null;
        if (zh3VarA == null || !bi3.c(zh3VarA)) {
            zh3VarA = zh3.b(this.q);
        }
        this.k.a(j, zh3VarA);
    }

    @Override // defpackage.j25
    public void h(long j, long j2, t41 t41Var, MediaFormat mediaFormat) {
        this.j.a(j2, Long.valueOf(j));
        g(t41Var.D, t41Var.E, j2);
    }
}
