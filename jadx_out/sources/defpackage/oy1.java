package defpackage;

import com.fongmi.android.tv.bean.Result;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oy1 implements Consumer {
    public final /* synthetic */ nw2 a;

    public /* synthetic */ oy1(nw2 nw2Var) {
        this.a = nw2Var;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.j((Result) obj);
    }
}
