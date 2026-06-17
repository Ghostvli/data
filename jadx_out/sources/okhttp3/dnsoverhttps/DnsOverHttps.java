package okhttp3.dnsoverhttps;

import defpackage.bv;
import defpackage.e04;
import defpackage.mv0;
import defpackage.nw;
import defpackage.om1;
import defpackage.sg4;
import defpackage.ua;
import defpackage.we0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class DnsOverHttps implements Dns {
    public static final Companion Companion = new Companion(null);
    private static final MediaType DNS_MESSAGE = MediaType.Companion.get("application/dns-message");
    public static final int MAX_RESPONSE_SIZE = 65536;
    private final OkHttpClient client;
    private final boolean includeIPv6;
    private final boolean post;
    private final boolean resolvePrivateAddresses;
    private final boolean resolvePublicAddresses;
    private final HttpUrl url;

    public DnsOverHttps(OkHttpClient okHttpClient, HttpUrl httpUrl, boolean z, boolean z2, boolean z3, boolean z4) {
        okHttpClient.getClass();
        httpUrl.getClass();
        this.client = okHttpClient;
        this.url = httpUrl;
        this.includeIPv6 = z;
        this.post = z2;
        this.resolvePrivateAddresses = z3;
        this.resolvePublicAddresses = z4;
    }

    private final Request buildRequest(String str, int i) {
        Request.Builder builder = new Request.Builder();
        MediaType mediaType = DNS_MESSAGE;
        Request.Builder builderHeader = builder.header("Accept", mediaType.toString());
        ByteString byteStringEncodeQuery = DnsRecordCodec.INSTANCE.encodeQuery(str, i);
        HttpUrl httpUrl = this.url;
        if (this.post) {
            builderHeader.url(httpUrl).cacheUrlOverride(httpUrl.newBuilder().addQueryParameter("hostname", str).build()).post(RequestBody.Companion.create(byteStringEncodeQuery, mediaType));
        } else {
            builderHeader.url(httpUrl.newBuilder().addQueryParameter("dns", sg4.G(byteStringEncodeQuery.base64Url(), "=", "", false, 4, null)).build());
        }
        return builderHeader.build();
    }

    private final void executeRequests(final String str, List<? extends Call> list, final List<InetAddress> list2, final List<Exception> list3) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        Iterator<? extends Call> it = list.iterator();
        while (it.hasNext()) {
            it.next().enqueue(new Callback() { // from class: okhttp3.dnsoverhttps.DnsOverHttps.executeRequests.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    call.getClass();
                    iOException.getClass();
                    List<Exception> list4 = list3;
                    synchronized (list4) {
                        list4.add(iOException);
                    }
                    countDownLatch.countDown();
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    call.getClass();
                    response.getClass();
                    this.processResponse(response, str, list2, list3);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            list3.add(e);
        }
    }

    private final List<InetAddress> lookupHttps(String str) {
        List listC = nw.c();
        listC.add(this.client.newCall(buildRequest(str, 1)));
        if (this.includeIPv6) {
            listC.add(this.client.newCall(buildRequest(str, 28)));
        }
        List<? extends Call> listA = nw.a(listC);
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(5);
        executeRequests(str, listA, arrayList2, arrayList);
        return arrayList2.isEmpty() ? throwBestFailure(str, arrayList) : arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processResponse(Response response, String str, List<InetAddress> list, List<Exception> list2) {
        try {
            List<InetAddress> response2 = readResponse(str, response);
            synchronized (list) {
                list.addAll(response2);
            }
        } catch (Exception e) {
            synchronized (list2) {
                list2.add(e);
            }
        }
    }

    private final List<InetAddress> readResponse(String str, Response response) throws IllegalAccessException, IOException, InvocationTargetException {
        if (response.cacheResponse() == null && response.protocol() != Protocol.HTTP_2 && response.protocol() != Protocol.QUIC) {
            Platform.log$default(Platform.Companion.get(), "Incorrect protocol: " + response.protocol(), 5, null, 4, null);
        }
        try {
            if (!response.isSuccessful()) {
                throw new IOException("response: " + response.code() + ' ' + response.message());
            }
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody.contentLength() <= 65536) {
                List<InetAddress> listDecodeAnswers = DnsRecordCodec.INSTANCE.decodeAnswers(str, responseBodyBody.source().readByteString());
                bv.a(response, null);
                return listDecodeAnswers;
            }
            throw new IOException("response size exceeds limit (65536 bytes): " + responseBodyBody.contentLength() + " bytes");
        } finally {
        }
    }

    private final List<InetAddress> throwBestFailure(String str, List<? extends Exception> list) throws Exception {
        if (list.isEmpty()) {
            throw new UnknownHostException(str);
        }
        Exception exc = list.get(0);
        if (exc instanceof UnknownHostException) {
            throw exc;
        }
        UnknownHostException unknownHostException = new UnknownHostException(str);
        unknownHostException.initCause(exc);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            mv0.a(unknownHostException, list.get(i));
        }
        throw unknownHostException;
    }

    public final OkHttpClient client() {
        return this.client;
    }

    public final boolean includeIPv6() {
        return this.includeIPv6;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        str.getClass();
        if (!this.resolvePrivateAddresses || !this.resolvePublicAddresses) {
            boolean zIsPrivateHost$okhttp_dnsoverhttps = Companion.isPrivateHost$okhttp_dnsoverhttps(str);
            if (zIsPrivateHost$okhttp_dnsoverhttps && !this.resolvePrivateAddresses) {
                throw new UnknownHostException("private hosts not resolved");
            }
            if (!zIsPrivateHost$okhttp_dnsoverhttps && !this.resolvePublicAddresses) {
                throw new UnknownHostException("public hosts not resolved");
            }
        }
        return lookupHttps(str);
    }

    public final boolean post() {
        return this.post;
    }

    public final boolean resolvePrivateAddresses() {
        return this.resolvePrivateAddresses;
    }

    public final boolean resolvePublicAddresses() {
        return this.resolvePublicAddresses;
    }

    public final HttpUrl url() {
        return this.url;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Dns buildBootstrapClient(Builder builder) {
            List<InetAddress> bootstrapDnsHosts$okhttp_dnsoverhttps = builder.getBootstrapDnsHosts$okhttp_dnsoverhttps();
            if (bootstrapDnsHosts$okhttp_dnsoverhttps == null) {
                return builder.getSystemDns$okhttp_dnsoverhttps();
            }
            HttpUrl url$okhttp_dnsoverhttps = builder.getUrl$okhttp_dnsoverhttps();
            url$okhttp_dnsoverhttps.getClass();
            return new BootstrapDns(url$okhttp_dnsoverhttps.host(), bootstrapDnsHosts$okhttp_dnsoverhttps);
        }

        public final MediaType getDNS_MESSAGE() {
            return DnsOverHttps.DNS_MESSAGE;
        }

        public final boolean isPrivateHost$okhttp_dnsoverhttps(String str) {
            str.getClass();
            return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str) == null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Builder {
        private List<? extends InetAddress> bootstrapDnsHosts;
        private OkHttpClient client;
        private boolean post;
        private boolean resolvePrivateAddresses;
        private HttpUrl url;
        private boolean includeIPv6 = true;
        private Dns systemDns = Dns.SYSTEM;
        private boolean resolvePublicAddresses = true;

        public final Builder bootstrapDnsHosts(InetAddress... inetAddressArr) {
            inetAddressArr.getClass();
            return bootstrapDnsHosts(ua.L(inetAddressArr));
        }

        public final DnsOverHttps build() {
            OkHttpClient okHttpClient = this.client;
            if (okHttpClient == null) {
                om1.a("client not set");
                return null;
            }
            OkHttpClient okHttpClientBuild = okHttpClient.newBuilder().dns(DnsOverHttps.Companion.buildBootstrapClient(this)).build();
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new DnsOverHttps(okHttpClientBuild, httpUrl, this.includeIPv6, this.post, this.resolvePrivateAddresses, this.resolvePublicAddresses);
            }
            e04.a("url not set");
            return null;
        }

        public final Builder client(OkHttpClient okHttpClient) {
            okHttpClient.getClass();
            this.client = okHttpClient;
            return this;
        }

        public final List<InetAddress> getBootstrapDnsHosts$okhttp_dnsoverhttps() {
            return this.bootstrapDnsHosts;
        }

        public final OkHttpClient getClient$okhttp_dnsoverhttps() {
            return this.client;
        }

        public final boolean getIncludeIPv6$okhttp_dnsoverhttps() {
            return this.includeIPv6;
        }

        public final boolean getPost$okhttp_dnsoverhttps() {
            return this.post;
        }

        public final boolean getResolvePrivateAddresses$okhttp_dnsoverhttps() {
            return this.resolvePrivateAddresses;
        }

        public final boolean getResolvePublicAddresses$okhttp_dnsoverhttps() {
            return this.resolvePublicAddresses;
        }

        public final Dns getSystemDns$okhttp_dnsoverhttps() {
            return this.systemDns;
        }

        public final HttpUrl getUrl$okhttp_dnsoverhttps() {
            return this.url;
        }

        public final Builder includeIPv6(boolean z) {
            this.includeIPv6 = z;
            return this;
        }

        public final Builder post(boolean z) {
            this.post = z;
            return this;
        }

        public final Builder resolvePrivateAddresses(boolean z) {
            this.resolvePrivateAddresses = z;
            return this;
        }

        public final Builder resolvePublicAddresses(boolean z) {
            this.resolvePublicAddresses = z;
            return this;
        }

        public final void setBootstrapDnsHosts$okhttp_dnsoverhttps(List<? extends InetAddress> list) {
            this.bootstrapDnsHosts = list;
        }

        public final void setClient$okhttp_dnsoverhttps(OkHttpClient okHttpClient) {
            this.client = okHttpClient;
        }

        public final void setIncludeIPv6$okhttp_dnsoverhttps(boolean z) {
            this.includeIPv6 = z;
        }

        public final void setPost$okhttp_dnsoverhttps(boolean z) {
            this.post = z;
        }

        public final void setResolvePrivateAddresses$okhttp_dnsoverhttps(boolean z) {
            this.resolvePrivateAddresses = z;
        }

        public final void setResolvePublicAddresses$okhttp_dnsoverhttps(boolean z) {
            this.resolvePublicAddresses = z;
        }

        public final void setSystemDns$okhttp_dnsoverhttps(Dns dns) {
            dns.getClass();
            this.systemDns = dns;
        }

        public final void setUrl$okhttp_dnsoverhttps(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public final Builder systemDns(Dns dns) {
            dns.getClass();
            this.systemDns = dns;
            return this;
        }

        public final Builder url(HttpUrl httpUrl) {
            httpUrl.getClass();
            this.url = httpUrl;
            return this;
        }

        public final Builder bootstrapDnsHosts(List<? extends InetAddress> list) {
            this.bootstrapDnsHosts = list;
            return this;
        }
    }
}
