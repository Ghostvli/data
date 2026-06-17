package defpackage;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ea4 extends ThreadLocal {
    public final /* synthetic */ Supplier a;

    @Override // java.lang.ThreadLocal
    public /* synthetic */ Object initialValue() {
        return this.a.get();
    }
}
