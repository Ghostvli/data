package j$.time.format;

import java.util.concurrent.ConcurrentHashMap;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {
    public static final c0 a = new c0();

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof c0);
    }

    public final int hashCode() {
        return Token.TEMPLATE_LITERAL_SUBST;
    }

    public final String toString() {
        return "DecimalStyle[0+-.]";
    }
}
