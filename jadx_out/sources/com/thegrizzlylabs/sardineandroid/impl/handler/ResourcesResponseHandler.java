package com.thegrizzlylabs.sardineandroid.impl.handler;

import android.util.Log;
import com.thegrizzlylabs.sardineandroid.DavResource;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ResourcesResponseHandler implements ResponseHandler<List<DavResource>> {
    private static final String TAG = "ResourcesResponseHandler";

    @Override // com.thegrizzlylabs.sardineandroid.impl.handler.ResponseHandler
    public List<DavResource> handleResponse(Response response) {
        List<com.thegrizzlylabs.sardineandroid.model.Response> response2 = new MultiStatusResponseHandler().handleResponse(response).getResponse();
        ArrayList arrayList = new ArrayList(response2.size());
        for (com.thegrizzlylabs.sardineandroid.model.Response response3 : response2) {
            try {
                arrayList.add(new DavResource(response3));
            } catch (URISyntaxException unused) {
                Log.w(TAG, String.format("Ignore resource with invalid URI %s", response3.getHref()));
            }
        }
        return arrayList;
    }
}
