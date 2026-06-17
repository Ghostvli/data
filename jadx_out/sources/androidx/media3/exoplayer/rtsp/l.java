package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import androidx.media3.exoplayer.rtsp.g;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hs4;
import defpackage.ja0;
import defpackage.ll1;
import defpackage.uv4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements a {
    public final uv4 a;
    public l b;

    public l(long j) {
        this.a = new uv4(2000, ll1.e(j));
    }

    @Override // defpackage.aa0
    public long a(ja0 ja0Var) {
        return this.a.a(ja0Var);
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public String c() {
        int iE = e();
        gg3.v(iE != -1);
        return fy4.M("RTP/AVP;unicast;client_port=%d-%d", Integer.valueOf(iE), Integer.valueOf(iE + 1));
    }

    @Override // defpackage.aa0
    public void close() {
        this.a.close();
        l lVar = this.b;
        if (lVar != null) {
            lVar.close();
        }
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public int e() {
        int iE = this.a.e();
        if (iE == -1) {
            return -1;
        }
        return iE;
    }

    @Override // defpackage.aa0
    public void f(hs4 hs4Var) {
        this.a.f(hs4Var);
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public boolean g() {
        return true;
    }

    @Override // defpackage.aa0
    public Uri getUri() {
        return this.a.getUri();
    }

    public void h(l lVar) {
        gg3.d(this != lVar);
        this.b = lVar;
    }

    @Override // androidx.media3.exoplayer.rtsp.a
    public g.b l() {
        return null;
    }

    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) throws uv4.a {
        try {
            return this.a.read(bArr, i, i2);
        } catch (uv4.a e) {
            if (e.f == 2002) {
                return -1;
            }
            throw e;
        }
    }
}
