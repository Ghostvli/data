package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class rj4 extends n {
    public final hd3 a;

    public rj4(hd3 hd3Var) {
        this.a = hd3Var;
    }

    @Override // defpackage.n
    public int a() {
        return this.a.isPlaying() ? 2 : 1;
    }

    @Override // defpackage.n
    public long b() {
        return 1000L;
    }

    @Override // defpackage.n
    public long c() {
        return this.a.getCurrentPosition();
    }

    @Override // defpackage.n
    public boolean d() {
        return true;
    }
}
