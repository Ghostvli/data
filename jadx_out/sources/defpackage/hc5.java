package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class hc5 implements ze4 {
    public final ko1 a;

    public hc5(ko1 ko1Var) {
        this.a = ko1Var;
    }

    @Override // defpackage.ze4
    public String a() {
        return null;
    }

    @Override // defpackage.ze4
    public boolean b() {
        return false;
    }

    @Override // defpackage.ze4
    public String d() {
        return null;
    }

    @Override // defpackage.ze4
    public long e() throws s83 {
        String strK = cc5.K(this.a.m("viewCountText"));
        if (yy4.n(strK)) {
            ny4.a("Could not get short view count");
            return 0L;
        }
        if (strK.toLowerCase().contains("no views")) {
            return 0L;
        }
        return yy4.q(strK);
    }

    @Override // defpackage.ze4
    public boolean f() {
        return false;
    }

    @Override // defpackage.ze4
    public long getDuration() {
        return -1L;
    }

    @Override // defpackage.wj1
    public String getName() {
        return cc5.K(this.a.m("headline"));
    }

    @Override // defpackage.wj1
    public String getUrl() throws s83 {
        try {
            return me5.l().f(this.a.o("videoId"));
        } catch (Exception e) {
            uo1.a("Could not get URL", e);
            return null;
        }
    }

    @Override // defpackage.ze4
    public boolean k() {
        return true;
    }

    @Override // defpackage.ze4
    public String l() {
        return null;
    }

    @Override // defpackage.ze4
    public qa0 m() {
        return null;
    }

    @Override // defpackage.wj1
    public List n() {
        return cc5.N(this.a);
    }

    @Override // defpackage.ze4
    public gf4 o() {
        return gf4.VIDEO_STREAM;
    }
}
