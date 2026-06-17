package okhttp3.internal.ws;

import defpackage.jl;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.InflaterSource;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class MessageInflater implements Closeable {
    private final Buffer deflatedBytes = new Buffer();
    private Inflater inflater;
    private InflaterSource inflaterSource;
    private final boolean noContextTakeover;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MessageInflater(boolean z) {
        this.noContextTakeover = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InflaterSource inflaterSource = this.inflaterSource;
        if (inflaterSource != null) {
            inflaterSource.close();
        }
        this.inflaterSource = null;
        this.inflater = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void inflate(Buffer buffer) throws IOException {
        buffer.getClass();
        if (this.deflatedBytes.size() != 0) {
            jl.a("Failed requirement.");
            return;
        }
        Inflater inflater = this.inflater;
        if (inflater == null) {
            inflater = new Inflater(true);
            this.inflater = inflater;
        }
        InflaterSource inflaterSource = this.inflaterSource;
        if (inflaterSource == null) {
            inflaterSource = new InflaterSource((Source) this.deflatedBytes, inflater);
            this.inflaterSource = inflaterSource;
        }
        if (this.noContextTakeover) {
            inflater.reset();
        }
        this.deflatedBytes.writeAll(buffer);
        this.deflatedBytes.writeInt(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        long bytesRead = inflater.getBytesRead() + this.deflatedBytes.size();
        do {
            inflaterSource.readOrInflate(buffer, Long.MAX_VALUE);
            if (inflater.getBytesRead() >= bytesRead) {
                break;
            }
        } while (!inflater.finished());
        if (inflater.getBytesRead() < bytesRead) {
            this.deflatedBytes.clear();
            inflaterSource.close();
            this.inflaterSource = null;
            this.inflater = null;
        }
    }
}
