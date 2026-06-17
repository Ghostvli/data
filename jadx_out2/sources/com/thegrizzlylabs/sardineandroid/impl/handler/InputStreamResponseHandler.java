package com.thegrizzlylabs.sardineandroid.impl.handler;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class InputStreamResponseHandler extends ValidatingResponseHandler<InputStream> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: handleResponse(Lokhttp3/Response;)Ljava/lang/Object; */
    @Override // com.thegrizzlylabs.sardineandroid.impl.handler.ResponseHandler
    public InputStream handleResponse(Response response) throws SardineException {
        validateResponse(response);
        return response.body().byteStream();
    }
}
