package defpackage;

import defpackage.gr4;
import java.io.EOFException;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wl0 implements gr4 {
    public final byte[] a = new byte[Buffer.SEGMENTING_THRESHOLD];

    @Override // defpackage.gr4
    public void b(long j, int i, int i2, int i3, gr4.a aVar) {
    }

    @Override // defpackage.gr4
    public void c(r73 r73Var, int i, int i2) {
        r73Var.g0(i);
    }

    @Override // defpackage.gr4
    public int f(x90 x90Var, int i, boolean z, int i2) throws EOFException {
        int i3 = x90Var.read(this.a, 0, Math.min(this.a.length, i));
        if (i3 != -1) {
            return i3;
        }
        if (z) {
            return -1;
        }
        ll.a();
        return 0;
    }

    @Override // defpackage.gr4
    public void g(t41 t41Var) {
    }
}
