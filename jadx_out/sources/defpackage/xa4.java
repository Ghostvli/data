package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class xa4 implements ze4 {
    public final ko1 a;

    public xa4(ko1 ko1Var) {
        this.a = ko1Var;
    }

    @Override // defpackage.ze4
    public String a() {
        return yy4.u(this.a.m("user").o("permalink_url"));
    }

    @Override // defpackage.ze4
    public boolean b() {
        return this.a.m("user").d("verified");
    }

    @Override // defpackage.ze4
    public String d() {
        return this.a.m("user").o("username");
    }

    @Override // defpackage.ze4
    public long e() {
        return this.a.j("playback_count");
    }

    @Override // defpackage.ze4
    public boolean f() {
        return false;
    }

    @Override // defpackage.ze4
    public List g() {
        return sa4.c(this.a.m("user").o("avatar_url"));
    }

    @Override // defpackage.ze4
    public long getDuration() {
        return this.a.j("duration") / 1000;
    }

    @Override // defpackage.wj1
    public String getName() {
        return this.a.o("title");
    }

    @Override // defpackage.wj1
    public String getUrl() {
        return yy4.u(this.a.o("permalink_url"));
    }

    @Override // defpackage.ze4
    public String l() {
        return this.a.o("created_at");
    }

    @Override // defpackage.ze4
    public qa0 m() {
        return sa4.l(l());
    }

    @Override // defpackage.wj1
    public List n() {
        return sa4.e(this.a);
    }

    @Override // defpackage.ze4
    public gf4 o() {
        return gf4.AUDIO_STREAM;
    }
}
