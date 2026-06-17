package com.thegrizzlylabs.sardineandroid.impl.handler;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class VoidResponseHandler extends ValidatingResponseHandler<Void> {
    @Override // com.thegrizzlylabs.sardineandroid.impl.handler.ResponseHandler
    public Void handleResponse(Response response) throws SardineException {
        validateResponse(response);
        return null;
    }
}
