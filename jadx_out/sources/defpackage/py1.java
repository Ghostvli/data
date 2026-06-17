package defpackage;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class py1 implements Consumer {
    public final /* synthetic */ ry1 a;

    public /* synthetic */ py1(ry1 ry1Var) {
        this.a = ry1Var;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.w((Throwable) obj);
    }
}
