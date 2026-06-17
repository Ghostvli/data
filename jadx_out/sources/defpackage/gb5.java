package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class gb5 implements ye3 {
    public final ko1 a;

    public gb5(ko1 ko1Var) {
        this.a = ko1Var;
    }

    @Override // defpackage.ye3
    public String a() {
        return null;
    }

    @Override // defpackage.ye3
    public boolean b() {
        return false;
    }

    @Override // defpackage.ye3
    public long c() throws s83 {
        if (cc5.K(this.a.m("videoCountShortText")) != null) {
            try {
                return Integer.parseInt(r2);
            } catch (NumberFormatException unused) {
                return -2L;
            }
        }
        ny4.a("Could not extract item count for playlist/mix info item");
        return 0L;
    }

    @Override // defpackage.ye3
    public String d() {
        return cc5.K(this.a.m("longBylineText"));
    }

    @Override // defpackage.wj1
    public String getName() throws s83 {
        String strK = cc5.K(this.a.m("title"));
        if (!yy4.n(strK)) {
            return strK;
        }
        ny4.a("Could not get name");
        return null;
    }

    @Override // defpackage.wj1
    public String getUrl() throws s83 {
        String strO = this.a.o("shareUrl");
        if (!yy4.n(strO)) {
            return strO;
        }
        ny4.a("Could not get url");
        return null;
    }

    @Override // defpackage.ye3
    public we3 i() {
        return cc5.r(getUrl());
    }

    @Override // defpackage.wj1
    public List n() {
        return cc5.N(this.a);
    }
}
