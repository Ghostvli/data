package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class m6 implements z6 {
    public final List a;

    public m6(List list) {
        this.a = list;
    }

    @Override // defpackage.z6
    public zh a() {
        boolean zI = ((dr1) this.a.get(0)).i();
        List list = this.a;
        return zI ? new ff3(list) : new i93(list);
    }

    @Override // defpackage.z6
    public List b() {
        return this.a;
    }

    @Override // defpackage.z6
    public boolean c() {
        return this.a.size() == 1 && ((dr1) this.a.get(0)).i();
    }
}
