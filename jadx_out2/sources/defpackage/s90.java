package defpackage;

import java.util.Arrays;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s90 extends pt {
    public byte[] j;
    public volatile boolean k;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s90(aa0 aa0Var, ja0 ja0Var, int i, t41 t41Var, int i2, Object obj, byte[] bArr) {
        super(aa0Var, ja0Var, i, t41Var, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.j = bArr == null ? fy4.f : bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.e
    public final void b() {
        try {
            this.i.a(this.b);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.k) {
                i(i2);
                i = this.i.read(this.j, i2, Http2.INITIAL_MAX_FRAME_SIZE);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.k) {
                g(this.j, i2);
            }
            ia0.a(this.i);
        } catch (Throwable th) {
            ia0.a(this.i);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.e
    public final void c() {
        this.k = true;
    }

    public abstract void g(byte[] bArr, int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] h() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(int i) {
        byte[] bArr = this.j;
        if (bArr.length < i + Http2.INITIAL_MAX_FRAME_SIZE) {
            this.j = Arrays.copyOf(bArr, bArr.length + Http2.INITIAL_MAX_FRAME_SIZE);
        }
    }
}
