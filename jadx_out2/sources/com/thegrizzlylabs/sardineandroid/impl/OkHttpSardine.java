package com.thegrizzlylabs.sardineandroid.impl;

import android.text.TextUtils;
import com.thegrizzlylabs.sardineandroid.DavAce;
import com.thegrizzlylabs.sardineandroid.DavAcl;
import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import com.thegrizzlylabs.sardineandroid.DavQuota;
import com.thegrizzlylabs.sardineandroid.DavResource;
import com.thegrizzlylabs.sardineandroid.Sardine;
import com.thegrizzlylabs.sardineandroid.impl.handler.ExistsResponseHandler;
import com.thegrizzlylabs.sardineandroid.impl.handler.InputStreamResponseHandler;
import com.thegrizzlylabs.sardineandroid.impl.handler.LockResponseHandler;
import com.thegrizzlylabs.sardineandroid.impl.handler.MultiStatusResponseHandler;
import com.thegrizzlylabs.sardineandroid.impl.handler.ResourcesResponseHandler;
import com.thegrizzlylabs.sardineandroid.impl.handler.ResponseHandler;
import com.thegrizzlylabs.sardineandroid.impl.handler.VoidResponseHandler;
import com.thegrizzlylabs.sardineandroid.model.Acl;
import com.thegrizzlylabs.sardineandroid.model.Allprop;
import com.thegrizzlylabs.sardineandroid.model.Exclusive;
import com.thegrizzlylabs.sardineandroid.model.Group;
import com.thegrizzlylabs.sardineandroid.model.Lockinfo;
import com.thegrizzlylabs.sardineandroid.model.Lockscope;
import com.thegrizzlylabs.sardineandroid.model.Locktype;
import com.thegrizzlylabs.sardineandroid.model.Multistatus;
import com.thegrizzlylabs.sardineandroid.model.Owner;
import com.thegrizzlylabs.sardineandroid.model.PrincipalCollectionSet;
import com.thegrizzlylabs.sardineandroid.model.Prop;
import com.thegrizzlylabs.sardineandroid.model.Propertyupdate;
import com.thegrizzlylabs.sardineandroid.model.Propfind;
import com.thegrizzlylabs.sardineandroid.model.Propstat;
import com.thegrizzlylabs.sardineandroid.model.QuotaAvailableBytes;
import com.thegrizzlylabs.sardineandroid.model.QuotaUsedBytes;
import com.thegrizzlylabs.sardineandroid.model.Remove;
import com.thegrizzlylabs.sardineandroid.model.SearchRequest;
import com.thegrizzlylabs.sardineandroid.model.Write;
import com.thegrizzlylabs.sardineandroid.report.SardineReport;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OkHttpSardine implements Sardine {
    private OkHttpClient client;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class AuthenticationInterceptor implements Interceptor {
        private String password;
        private String userName;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AuthenticationInterceptor(String str, String str2) {
            this.userName = str;
            this.password = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            return chain.proceed(chain.request().newBuilder().addHeader("Authorization", Credentials.basic(this.userName, this.password, SardineUtil.standardUTF8())).build());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OkHttpSardine() {
        this.client = new OkHttpClient.Builder().build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void addCustomProperties(Prop prop, Set<QName> set) {
        List<Element> any = prop.getAny();
        Iterator<QName> it = set.iterator();
        while (it.hasNext()) {
            any.add(SardineUtil.createElement(it.next()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void addLockTokenToHeaders(Headers.Builder builder, String str, String str2) {
        builder.add("If", "<" + str + "> (<" + str2 + ">)");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private <T> T execute(Request request, ResponseHandler<T> responseHandler) {
        return responseHandler.handleResponse(this.client.newCall(request).execute());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void copy(String str, String str2, boolean z) {
        execute(new Request.Builder().url(str).method("COPY", null).header("DESTINATION", URI.create(str2).toASCIIString()).header("OVERWRITE", z ? "T" : "F").build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void createDirectory(String str) {
        execute(new Request.Builder().url(str).method("MKCOL", null).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void delete(String str) {
        execute(new Request.Builder().url(str).delete().build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void disableCompression() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void enableCompression() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public boolean exists(String str) {
        return ((Boolean) execute(new Request.Builder().url(str).method("HEAD", null).build(), new ExistsResponseHandler())).booleanValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public InputStream get(String str, Headers headers) {
        return (InputStream) execute(new Request.Builder().url(str).get().headers(headers).build(), new InputStreamResponseHandler());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public DavAcl getAcl(String str) {
        Propfind propfind = new Propfind();
        Prop prop = new Prop();
        prop.setOwner(new Owner());
        prop.setGroup(new Group());
        prop.setAcl(new Acl());
        propfind.setProp(prop);
        List<com.thegrizzlylabs.sardineandroid.model.Response> response = ((Multistatus) execute(new Request.Builder().url(str).header("Depth", "0").method("PROPFIND", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(propfind))).build(), new MultiStatusResponseHandler())).getResponse();
        if (response.isEmpty()) {
            return null;
        }
        return new DavAcl(response.get(0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<String> getPrincipalCollectionSet(String str) {
        Propfind propfind = new Propfind();
        Prop prop = new Prop();
        prop.setPrincipalCollectionSet(new PrincipalCollectionSet());
        propfind.setProp(prop);
        List<com.thegrizzlylabs.sardineandroid.model.Response> response = ((Multistatus) execute(new Request.Builder().url(str).header("Depth", "0").method("PROPFIND", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(propfind))).build(), new MultiStatusResponseHandler())).getResponse();
        if (response.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.thegrizzlylabs.sardineandroid.model.Response response2 : response) {
            if (response2.getPropstat() != null) {
                for (Propstat propstat : response2.getPropstat()) {
                    if (propstat.getProp() != null && propstat.getProp().getPrincipalCollectionSet() != null && propstat.getProp().getPrincipalCollectionSet().getHref() != null) {
                        arrayList.add(propstat.getProp().getPrincipalCollectionSet().getHref());
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavPrincipal> getPrincipals(String str) {
        Propfind propfind = new Propfind();
        propfind.setProp(new Prop());
        List<com.thegrizzlylabs.sardineandroid.model.Response> response = ((Multistatus) execute(new Request.Builder().url(str).header("Depth", "1").method("PROPFIND", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(propfind))).build(), new MultiStatusResponseHandler())).getResponse();
        if (response.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.thegrizzlylabs.sardineandroid.model.Response response2 : response) {
            if (response2.getPropstat() != null) {
                for (Propstat propstat : response2.getPropstat()) {
                    if (propstat.getProp() != null && propstat.getProp().getResourcetype() != null && propstat.getProp().getResourcetype().getPrincipal() != null) {
                        arrayList.add(new DavPrincipal(DavPrincipal.PrincipalType.HREF, response2.getHref(), propstat.getProp().getDisplayname()));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public DavQuota getQuota(String str) {
        Propfind propfind = new Propfind();
        Prop prop = new Prop();
        prop.setQuotaAvailableBytes(new QuotaAvailableBytes());
        prop.setQuotaUsedBytes(new QuotaUsedBytes());
        propfind.setProp(prop);
        List<com.thegrizzlylabs.sardineandroid.model.Response> response = ((Multistatus) execute(new Request.Builder().url(str).header("Depth", "0").method("PROPFIND", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(propfind))).build(), new MultiStatusResponseHandler())).getResponse();
        if (response.isEmpty()) {
            return null;
        }
        return new DavQuota(response.get(0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> getResources(String str) {
        return list(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void ignoreCookies() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> list(String str, int i, boolean z) {
        if (!z) {
            return list(str, i, Collections.EMPTY_SET);
        }
        Propfind propfind = new Propfind();
        propfind.setAllprop(new Allprop());
        return propfind(str, i, propfind);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public String lock(String str, int i) {
        Lockinfo lockinfo = new Lockinfo();
        Lockscope lockscope = new Lockscope();
        lockscope.setExclusive(new Exclusive());
        lockinfo.setLockscope(lockscope);
        Locktype locktype = new Locktype();
        locktype.setWrite(new Write());
        lockinfo.setLocktype(locktype);
        Request.Builder builderMethod = new Request.Builder().url(str).method("LOCK", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(lockinfo)));
        if (i > 0) {
            builderMethod.header("Timeout", "Second-" + i);
        }
        return (String) execute(builderMethod.build(), new LockResponseHandler());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void move(String str, String str2, boolean z, String str3) {
        Request.Builder builderMethod = new Request.Builder().url(str).method("MOVE", null);
        Headers.Builder builder = new Headers.Builder();
        builder.add("DESTINATION", str2);
        builder.add("OVERWRITE", z ? "T" : "F");
        if (str3 != null) {
            addLockTokenToHeaders(builder, str2, str3);
        }
        builderMethod.headers(builder.build());
        execute(builderMethod.build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> patch(String str, List<Element> list, List<QName> list2) {
        Propertyupdate propertyupdate = new Propertyupdate();
        com.thegrizzlylabs.sardineandroid.model.Set set = new com.thegrizzlylabs.sardineandroid.model.Set();
        propertyupdate.getRemoveOrSet().add(set);
        Prop prop = new Prop();
        prop.getAny().addAll(list);
        set.setProp(prop);
        Remove remove = new Remove();
        propertyupdate.getRemoveOrSet().add(remove);
        Prop prop2 = new Prop();
        List<Element> any = prop2.getAny();
        Iterator<QName> it = list2.iterator();
        while (it.hasNext()) {
            any.add(SardineUtil.createElement(it.next()));
        }
        remove.setProp(prop2);
        return (List) execute(new Request.Builder().url(str).method("PROPPATCH", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(propertyupdate))).build(), new ResourcesResponseHandler());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<DavResource> propfind(String str, int i, Propfind propfind) {
        return (List) execute(new Request.Builder().url(str).header("Depth", i < 0 ? "infinity" : Integer.toString(i)).method("PROPFIND", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(propfind))).build(), new ResourcesResponseHandler());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void put(String str, File file, String str2, boolean z, String str3) {
        RequestBody requestBodyCreate = RequestBody.create(str2 == null ? null : MediaType.parse(str2), file);
        Headers.Builder builder = new Headers.Builder();
        if (z) {
            builder.add("Expect", "100-Continue");
        }
        if (!TextUtils.isEmpty(str3)) {
            addLockTokenToHeaders(builder, str, str3);
        }
        put(str, requestBodyCreate, builder.build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public String refreshLock(String str, String str2, String str3) {
        return (String) execute(new Request.Builder().url(str).method("LOCK", null).header("If", "<" + str3 + "> (<" + str2 + ">)").build(), new LockResponseHandler());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public <T> T report(String str, int i, SardineReport<T> sardineReport) {
        return sardineReport.fromMultistatus((Multistatus) execute(new Request.Builder().url(str).header("Depth", i < 0 ? "infinity" : Integer.toString(i)).method("REPORT", RequestBody.create(MediaType.parse("text/xml"), sardineReport.toXml())).build(), new MultiStatusResponseHandler()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> search(String str, String str2, String str3) {
        return (List) execute(new Request.Builder().url(str).method("SEARCH", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(SardineUtil.toXml(new SearchRequest(str2, str3))))).build(), new ResourcesResponseHandler());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void setAcl(String str, List<DavAce> list) {
        Acl acl = new Acl();
        acl.setAce(new ArrayList());
        for (DavAce davAce : list) {
            if (davAce.getInherited() == null && !davAce.isProtected()) {
                acl.getAce().add(davAce.toModel());
            }
        }
        execute(new Request.Builder().url(str).method("ACL", RequestBody.create(MediaType.parse("text/xml"), SardineUtil.toXml(acl))).build(), new VoidResponseHandler());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void setCredentials(String str, String str2, boolean z) {
        OkHttpClient.Builder builderNewBuilder = this.client.newBuilder();
        if (z) {
            builderNewBuilder.addInterceptor(new AuthenticationInterceptor(str, str2));
        } else {
            builderNewBuilder.authenticator(new BasicAuthenticator(str, str2));
        }
        this.client = builderNewBuilder.build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void setCustomProps(String str, Map<String, String> map, List<String> list) {
        patch(str, SardineUtil.toQName(map), SardineUtil.toQName(list));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void unlock(String str, String str2) {
        execute(new Request.Builder().url(str).method("UNLOCK", null).header("Lock-Token", "<" + str2 + ">").build(), new VoidResponseHandler());
    }

    public OkHttpSardine(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    private void execute(Request request) {
        execute(request, new VoidResponseHandler());
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> list(String str, int i) {
        return list(str, i, true);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> list(String str, int i, Set<QName> set) {
        Propfind propfind = new Propfind();
        Prop prop = new Prop();
        addCustomProperties(prop, set);
        propfind.setProp(prop);
        return propfind(str, i, propfind);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void setCredentials(String str, String str2) {
        setCredentials(str, str2, false);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public InputStream get(String str, Map<String, String> map) {
        return get(str, Headers.of(map));
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> list(String str) {
        return list(str, 1);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public InputStream get(String str) {
        return get(str, Collections.EMPTY_MAP);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void put(String str, byte[] bArr, String str2) {
        put(str, RequestBody.create(str2 == null ? null : MediaType.parse(str2), bArr));
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void put(String str, File file, String str2) {
        put(str, file, str2, false);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void put(String str, File file, String str2, boolean z) {
        put(str, file, str2, z, null);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void put(String str, byte[] bArr) {
        put(str, bArr, (String) null);
    }

    private void put(String str, RequestBody requestBody) {
        put(str, requestBody, new Headers.Builder().build());
    }

    private void put(String str, RequestBody requestBody, Headers headers) {
        execute(new Request.Builder().url(str).put(requestBody).headers(headers).build());
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void copy(String str, String str2) {
        copy(str, str2, true);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void move(String str, String str2, boolean z) {
        move(str, str2, z, null);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public void move(String str, String str2) {
        move(str, str2, true);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> propfind(String str, int i, Set<QName> set) {
        Propfind propfind = new Propfind();
        Prop prop = new Prop();
        addCustomProperties(prop, set);
        propfind.setProp(prop);
        return propfind(str, i, propfind);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public String lock(String str) {
        return lock(str, 0);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> patch(String str, Map<QName, String> map, List<QName> list) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<QName, String> entry : map.entrySet()) {
            Element elementCreateElement = SardineUtil.createElement(entry.getKey());
            elementCreateElement.setTextContent(entry.getValue());
            arrayList.add(elementCreateElement);
        }
        return patch(str, arrayList, list);
    }

    @Override // com.thegrizzlylabs.sardineandroid.Sardine
    public List<DavResource> patch(String str, Map<QName, String> map) {
        return patch(str, map, Collections.EMPTY_LIST);
    }
}
