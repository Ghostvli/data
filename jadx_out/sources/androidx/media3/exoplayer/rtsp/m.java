package androidx.media3.exoplayer.rtsp;

import androidx.media3.exoplayer.rtsp.a;
import defpackage.ia0;
import defpackage.jv3;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements a.InterfaceC0021a {
    public final long a;

    public m(long j) {
        this.a = j;
    }

    @Override // androidx.media3.exoplayer.rtsp.a.InterfaceC0021a
    public a a(int i) throws IOException {
        l lVar = new l(this.a);
        l lVar2 = new l(this.a);
        try {
            lVar.a(jv3.a(0));
            int iE = lVar.e();
            boolean z = iE % 2 == 0;
            lVar2.a(jv3.a(z ? iE + 1 : iE - 1));
            if (z) {
                lVar.h(lVar2);
                return lVar;
            }
            lVar2.h(lVar);
            return lVar2;
        } catch (IOException e) {
            ia0.a(lVar);
            ia0.a(lVar2);
            throw e;
        }
    }

    @Override // androidx.media3.exoplayer.rtsp.a.InterfaceC0021a
    public a.InterfaceC0021a b() {
        return new k(this.a);
    }
}
