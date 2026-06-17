package j$.util.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class DesugarCollectors {
    public static final Set a = Collections.EMPTY_SET;

    static {
        Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED));
    }

    public static <T> Collector<T, ?, List<T>> toUnmodifiableList() {
        return new e(new a(), new b(), new c(), new d(), a);
    }
}
