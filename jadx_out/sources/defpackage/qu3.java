package defpackage;

import android.net.Uri;
import io.antmedia.rtmp_client.RtmpClient;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qu3 extends lh {
    public static final /* synthetic */ int g = 0;
    public RtmpClient e;
    public Uri f;

    static {
        kg2.a("media3.datasource.rtmp");
    }

    public qu3() {
        super(true);
    }

    @Override // defpackage.aa0
    public long a(ja0 ja0Var) throws RtmpClient.a {
        v(ja0Var);
        RtmpClient rtmpClient = new RtmpClient();
        this.e = rtmpClient;
        rtmpClient.b(ja0Var.a.toString(), false);
        this.f = ja0Var.a;
        w(ja0Var);
        return -1L;
    }

    @Override // defpackage.aa0
    public void close() {
        if (this.f != null) {
            this.f = null;
            u();
        }
        RtmpClient rtmpClient = this.e;
        if (rtmpClient != null) {
            rtmpClient.a();
            this.e = null;
        }
    }

    @Override // defpackage.aa0
    public Uri getUri() {
        return this.f;
    }

    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) throws RtmpClient.a {
        int iC = ((RtmpClient) fy4.l(this.e)).c(bArr, i, i2);
        if (iC == -1) {
            return -1;
        }
        t(iC);
        return iC;
    }
}
