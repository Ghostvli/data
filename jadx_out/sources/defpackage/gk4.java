package defpackage;

import android.media.MediaCodec;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gk4 implements a82 {
    public final MediaCodec a;

    public gk4(MediaCodec mediaCodec) {
        this.a = mediaCodec;
    }

    @Override // defpackage.a82
    public void a(int i, int i2, h50 h50Var, long j, int i3) {
        this.a.queueSecureInputBuffer(i, i2, h50Var.a(), j, i3);
    }

    @Override // defpackage.a82
    public void b(Bundle bundle) {
        this.a.setParameters(bundle);
    }

    @Override // defpackage.a82
    public void c(int i, int i2, int i3, long j, int i4) {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // defpackage.a82
    public void d() {
    }

    @Override // defpackage.a82
    public void flush() {
    }

    @Override // defpackage.a82
    public void shutdown() {
    }

    @Override // defpackage.a82
    public void start() {
    }
}
