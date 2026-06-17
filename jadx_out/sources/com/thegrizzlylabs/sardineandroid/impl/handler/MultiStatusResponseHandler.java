package com.thegrizzlylabs.sardineandroid.impl.handler;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import com.thegrizzlylabs.sardineandroid.model.Multistatus;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MultiStatusResponseHandler extends ValidatingResponseHandler<Multistatus> {
    public Multistatus getMultistatus(InputStream inputStream) {
        return (Multistatus) SardineUtil.unmarshal(Multistatus.class, inputStream);
    }

    @Override // com.thegrizzlylabs.sardineandroid.impl.handler.ResponseHandler
    public Multistatus handleResponse(Response response) throws SardineException {
        super.validateResponse(response);
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            return getMultistatus(responseBodyBody.byteStream());
        }
        throw new SardineException("No entity found in response", response.code(), response.message());
    }
}
