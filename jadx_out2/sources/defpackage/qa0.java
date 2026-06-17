package defpackage;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.OffsetDateTime;
import j$.time.ZoneId;
import j$.time.format.DateTimeParseException;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class qa0 implements Serializable {
    public final Instant f;
    public final boolean g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qa0(LocalDateTime localDateTime, boolean z) {
        this(localDateTime.M(ZoneId.systemDefault()).toInstant(), z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qa0 a(String str) throws s83 {
        if (str != null) {
            try {
                return new qa0(Instant.parse(str));
            } catch (DateTimeParseException e) {
                pa0.a("Could not parse date: \"", str, "\"", e);
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qa0 b(String str) throws s83 {
        if (str != null) {
            try {
                return new qa0(OffsetDateTime.parse(str));
            } catch (DateTimeParseException e) {
                pa0.a("Could not parse date: \"", str, "\"", e);
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "DateWrapper{instant=" + this.f + ", isApproximation=" + this.g + "}";
    }

    public qa0(OffsetDateTime offsetDateTime, boolean z) {
        this(offsetDateTime.toInstant(), z);
    }

    public qa0(Instant instant) {
        this(instant, false);
    }

    public qa0(Instant instant, boolean z) {
        this.f = instant;
        this.g = z;
    }

    public qa0(OffsetDateTime offsetDateTime) {
        this(offsetDateTime, false);
    }
}
