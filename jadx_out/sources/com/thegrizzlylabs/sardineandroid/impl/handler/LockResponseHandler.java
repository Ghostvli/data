package com.thegrizzlylabs.sardineandroid.impl.handler;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import com.thegrizzlylabs.sardineandroid.model.Prop;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class LockResponseHandler extends ValidatingResponseHandler<String> {
    public String getToken(InputStream inputStream) {
        return ((Prop) SardineUtil.unmarshal(Prop.class, inputStream)).getLockdiscovery().getActivelock().iterator().next().getLocktoken().getHref();
    }

    @Override // com.thegrizzlylabs.sardineandroid.impl.handler.ResponseHandler
    public String handleResponse(Response response) throws SardineException {
        validateResponse(response);
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            return getToken(responseBodyBody.byteStream());
        }
        throw new SardineException("No entity found in response", response.code(), response.message());
    }
}
