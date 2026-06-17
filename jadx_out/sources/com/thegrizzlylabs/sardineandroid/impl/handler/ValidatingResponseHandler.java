package com.thegrizzlylabs.sardineandroid.impl.handler;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ValidatingResponseHandler<T> implements ResponseHandler<T> {
    public void validateResponse(Response response) throws SardineException {
        if (response.isSuccessful()) {
            return;
        }
        throw new SardineException("Error contacting " + response.request().url(), response.code(), response.message());
    }
}
