package j$.time.temporal;

import j$.time.format.d0;
import j$.time.format.e0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface p {
    s H(TemporalAccessor temporalAccessor);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default TemporalAccessor N(Map map, d0 d0Var, e0 e0Var) {
        return null;
    }

    s Q();

    long Y(TemporalAccessor temporalAccessor);

    l f0(l lVar, long j);

    boolean isDateBased();

    boolean u(TemporalAccessor temporalAccessor);
}
