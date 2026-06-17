package okhttp3.internal.http;

import defpackage.bv;
import defpackage.fw4;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class GzipRequestBody extends RequestBody {
    private final RequestBody delegate;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GzipRequestBody(RequestBody requestBody) {
        requestBody.getClass();
        this.delegate = requestBody;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.RequestBody
    public long contentLength() {
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.delegate.contentType();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final RequestBody getDelegate() {
        return this.delegate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        return this.delegate.isOneShot();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IllegalAccessException, IOException, InvocationTargetException {
        bufferedSink.getClass();
        BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(bufferedSink));
        try {
            this.delegate.writeTo(bufferedSinkBuffer);
            fw4 fw4Var = fw4.a;
            bv.a(bufferedSinkBuffer, null);
        } finally {
        }
    }
}
