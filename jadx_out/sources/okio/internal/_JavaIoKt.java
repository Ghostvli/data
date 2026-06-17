package okio.internal;

import defpackage.wg4;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class _JavaIoKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        assertionError.getClass();
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? wg4.P(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }
}
