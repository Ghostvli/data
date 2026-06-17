package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface l extends Comparable {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static l of(String str) {
        ConcurrentHashMap concurrentHashMap = a.a;
        Objects.requireNonNull(str, Name.MARK);
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = a.a;
            l lVar = (l) concurrentHashMap2.get(str);
            if (lVar == null) {
                lVar = (l) a.b.get(str);
            }
            if (lVar != null) {
                return lVar;
            }
            if (concurrentHashMap2.get("ISO") != null) {
                for (l lVar2 : ServiceLoader.load(l.class)) {
                    if (str.equals(lVar2.q()) || str.equals(lVar2.x())) {
                        return lVar2;
                    }
                }
                j$.nio.file.j.h("Unknown chronology: ".concat(str));
                return null;
            }
            o oVar = o.l;
            oVar.getClass();
            a.H(oVar, "Hijrah-umalqura");
            v vVar = v.c;
            vVar.getClass();
            a.H(vVar, "Japanese");
            a0 a0Var = a0.c;
            a0Var.getClass();
            a.H(a0Var, "Minguo");
            g0 g0Var = g0.c;
            g0Var.getClass();
            a.H(g0Var, "ThaiBuddhist");
            try {
                for (a aVar : Arrays.asList(new a[0])) {
                    if (!aVar.q().equals("ISO")) {
                        a.H(aVar, aVar.q());
                    }
                }
                s sVar = s.c;
                sVar.getClass();
                a.H(sVar, "ISO");
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static l s(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.b(j$.time.temporal.q.b);
        s sVar = s.c;
        if (lVar != null) {
            return lVar;
        }
        Objects.requireNonNull(sVar, "defaultObj");
        return sVar;
    }

    j$.time.temporal.s F(j$.time.temporal.a aVar);

    List G();

    m I(int i);

    int K(m mVar, int i);

    b O(TemporalAccessor temporalAccessor);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default e P(LocalDateTime localDateTime) {
        try {
            return O(localDateTime).T(j$.time.i.N(localDateTime));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e);
        }
    }

    b U();

    b Z(int i, int i2, int i3);

    b b0(Map map, j$.time.format.e0 e0Var);

    ChronoZonedDateTime c0(Instant instant, ZoneId zoneId);

    boolean equals(Object obj);

    boolean g0(long j);

    int hashCode();

    b p(long j);

    String q();

    String toString();

    String x();

    b z(int i, int i2);
}
