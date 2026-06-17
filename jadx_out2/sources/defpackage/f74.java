package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f74 extends b74 implements zh4 {
    public final String o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends hi4 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.decoder.a
        public void release() {
            f74.this.t(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f74(String str) {
        super(new gi4[2], new hi4[2]);
        this.o = str;
        w(1024);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: k(Ljava/lang/Throwable;)Lib0; */
    @Override // defpackage.b74
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final ai4 k(Throwable th) {
        return new ai4("Unexpected decode error", th);
    }

    public abstract yh4 B(byte[] bArr, int i, boolean z);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: l(Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/decoder/a;Z)Lib0; */
    @Override // defpackage.b74
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final ai4 l(gi4 gi4Var, hi4 hi4Var, boolean z) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) gg3.q(gi4Var.data);
            hi4Var.g(gi4Var.timeUs, B(byteBuffer.array(), byteBuffer.limit(), z), gi4Var.f);
            hi4Var.shouldBeSkipped = false;
            return null;
        } catch (ai4 e) {
            return e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zh4
    public void c(long j) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i()Landroidx/media3/decoder/DecoderInputBuffer; */
    @Override // defpackage.b74
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final gi4 i() {
        return new gi4();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j()Landroidx/media3/decoder/a; */
    @Override // defpackage.b74
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public final hi4 j() {
        return new a();
    }
}
