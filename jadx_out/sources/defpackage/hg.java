package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class hg implements ye3 {
    public final br0 a;

    public hg(br0 br0Var) {
        this.a = br0Var;
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
    public long c() {
        return -1L;
    }

    @Override // defpackage.ye3
    public String d() {
        return this.a.y0("by-artist").p().replace("by ", "");
    }

    @Override // defpackage.wj1
    public String getName() {
        return this.a.y0("release-title").p();
    }

    @Override // defpackage.wj1
    public String getUrl() {
        return this.a.y0("album-link").j("abs:href");
    }

    @Override // defpackage.wj1
    public List n() {
        return dg.f(this.a.y0("album-art").j("src"));
    }
}
