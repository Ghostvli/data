package j$.util.stream;

import j$.desugar.sun.nio.fs.g;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Set set = DesugarCollectors.a;
        return g.o(((List) obj).toArray());
    }
}
