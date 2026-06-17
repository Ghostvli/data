package defpackage;

import android.media.MediaCodec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b82 extends ib0 {
    public final c82 f;
    public final String g;
    public final int h;

    public b82(Throwable th, c82 c82Var) {
        StringBuilder sb = new StringBuilder("Decoder failed: ");
        sb.append(c82Var == null ? null : c82Var.a);
        super(sb.toString(), th);
        this.f = c82Var;
        this.g = th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null;
        this.h = a(th);
    }

    public static int a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getErrorCode();
        }
        return 0;
    }
}
