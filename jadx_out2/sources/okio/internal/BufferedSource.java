package okio.internal;

import okio.TypedOptions;

/* JADX INFO: renamed from: okio.internal.-BufferedSource, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class BufferedSource {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final <T> T commonSelect(okio.BufferedSource bufferedSource, TypedOptions<T> typedOptions) {
        bufferedSource.getClass();
        typedOptions.getClass();
        int iSelect = bufferedSource.select(typedOptions.getOptions$okio());
        if (iSelect == -1) {
            return null;
        }
        return typedOptions.get(iSelect);
    }
}
