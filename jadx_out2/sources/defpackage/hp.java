package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.a;
import androidx.media3.exoplayer.p;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class hp extends a {
    public long A;
    public final DecoderInputBuffer x;
    public final r73 y;
    public gp z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hp() {
        super(6);
        this.x = new DecoderInputBuffer(1);
        this.y = new r73();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a, androidx.media3.exoplayer.n.b
    public void F(int i, Object obj) {
        if (i == 8) {
            this.z = (gp) obj;
        } else {
            super.F(i, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.p
    public int a(t41 t41Var) {
        return "application/x-camera-motion".equals(t41Var.p) ? p.C(4) : p.C(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public boolean b() {
        return j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public void c(long j, long j2) {
        while (!j() && this.A < 100000 + j) {
            this.x.clear();
            if (n0(T(), this.x, 0) != -4 || this.x.isEndOfStream()) {
                return;
            }
            long j3 = this.x.timeUs;
            this.A = j3;
            boolean z = j3 < V();
            if (this.z != null && !z) {
                this.x.flip();
                float[] fArrQ0 = q0((ByteBuffer) fy4.l(this.x.data));
                if (fArrQ0 != null) {
                    ((gp) fy4.l(this.z)).a(this.A - Z(), fArrQ0);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void c0() {
        r0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void f0(long j, boolean z, boolean z2) {
        this.A = Long.MIN_VALUE;
        r0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o, androidx.media3.exoplayer.p
    public String getName() {
        return "CameraMotionRenderer";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public boolean isReady() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float[] q0(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.y.d0(byteBuffer.array(), byteBuffer.limit());
        this.y.f0(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.y.D());
        }
        return fArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r0() {
        gp gpVar = this.z;
        if (gpVar != null) {
            gpVar.e();
        }
    }
}
