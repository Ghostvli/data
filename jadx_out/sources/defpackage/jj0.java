package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class jj0 extends f74 {
    public final ki4 p;

    public jj0(String str, ki4 ki4Var) {
        super(str);
        this.p = ki4Var;
    }

    @Override // defpackage.f74
    public yh4 B(byte[] bArr, int i, boolean z) {
        if (z) {
            this.p.reset();
        }
        return this.p.a(bArr, 0, i);
    }
}
