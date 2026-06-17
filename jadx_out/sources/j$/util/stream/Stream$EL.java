package j$.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/* JADX INFO: renamed from: j$.util.stream.Stream$-EL, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Stream$EL {
    public static List toList(Stream stream) {
        return Collections.unmodifiableList(new ArrayList(Arrays.asList(stream.toArray())));
    }
}
