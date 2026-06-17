package okhttp3.internal;

import java.io.EOFException;
import okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class IsProbablyUtf8Kt {
    public static final boolean isProbablyUtf8(BufferedSource bufferedSource, long j) {
        bufferedSource.getClass();
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (long j2 = 0; j2 < j; j2++) {
                if (bufferedSourcePeek.exhausted()) {
                    return true;
                }
                int utf8CodePoint = bufferedSourcePeek.readUtf8CodePoint();
                if (Character.isISOControl(utf8CodePoint) && !Character.isWhitespace(utf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean isProbablyUtf8$default(BufferedSource bufferedSource, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return isProbablyUtf8(bufferedSource, j);
    }
}
