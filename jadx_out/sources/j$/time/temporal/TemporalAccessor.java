package j$.time.temporal;

import j$.time.DateTimeException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface TemporalAccessor {
    default Object b(j$.time.d dVar) {
        if (dVar == q.a || dVar == q.b || dVar == q.c) {
            return null;
        }
        return dVar.k(this);
    }

    default int g(p pVar) {
        s sVarL = l(pVar);
        if (!sVarL.d()) {
            throw new r("Invalid field " + pVar + " for get() method, use getLong() instead");
        }
        long jI = i(pVar);
        if (sVarL.e(jI)) {
            return (int) jI;
        }
        throw new DateTimeException("Invalid value for " + pVar + " (valid values " + sVarL + "): " + jI);
    }

    boolean h(p pVar);

    long i(p pVar);

    default s l(p pVar) {
        if (!(pVar instanceof a)) {
            Objects.requireNonNull(pVar, "field");
            return pVar.H(this);
        }
        if (h(pVar)) {
            return ((a) pVar).b;
        }
        throw new r(j$.time.b.a("Unsupported field: ", pVar));
    }
}
