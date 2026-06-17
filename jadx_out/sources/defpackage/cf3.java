package defpackage;

import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cf3 implements hz0 {
    public final j74 a = new j74(35152, 2, DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG);

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.a.a(j, j2);
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.a.b(mz0Var);
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        return this.a.d(jz0Var, yf3Var);
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        return this.a.e(jz0Var);
    }

    @Override // defpackage.hz0
    public void release() {
    }
}
