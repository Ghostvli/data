package defpackage;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class q53 {
    public static final long i = 30000;
    public zs3 a;
    public ir3 b;
    public ke c;
    public i53 d;
    public c63 e;
    public OkHttpClient f;
    public OkHttpClient g;
    public o53 h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements X509TrustManager {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static volatile q53 a = new q53();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized OkHttpClient A() {
        if (n().g != null) {
            return n().g;
        }
        q53 q53VarN = n();
        OkHttpClient okHttpClientBuild = o().build();
        q53VarN.g = okHttpClientBuild;
        return okHttpClientBuild;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ir3 B() {
        if (n().b != null) {
            return n().b;
        }
        q53 q53VarN = n();
        ir3 ir3Var = new ir3();
        q53VarN.b = ir3Var;
        return ir3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zs3 C() {
        if (n().a != null) {
            return n().a;
        }
        q53 q53VarN = n();
        zs3 zs3Var = new zs3();
        q53VarN.a = zs3Var;
        return zs3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c63 D() {
        if (n().e != null) {
            return n().e;
        }
        q53 q53VarN = n();
        c63 c63Var = new c63();
        q53VarN.e = c63Var;
        return c63Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String E(String str) {
        if (!str.startsWith("http")) {
            return "";
        }
        try {
            Response responseExecute = q(str).execute();
            try {
                String strString = responseExecute.body().string();
                responseExecute.close();
                return strString;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String F(String str, Map map) {
        if (!str.startsWith("http")) {
            return "";
        }
        try {
            Response responseExecute = s(str, map).execute();
            try {
                String strString = responseExecute.body().string();
                responseExecute.close();
                return strString;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FormBody G(la laVar) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry entry : laVar.entrySet()) {
            builder.add((String) entry.getKey(), (String) entry.getValue());
        }
        return builder.build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static X509TrustManager H() {
        return new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean a(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ke b() {
        if (n().c != null) {
            return n().c;
        }
        q53 q53VarN = n();
        ke keVar = new ke();
        q53VarN.c = keVar;
        return keVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i53 c() {
        if (n().d != null) {
            return n().d;
        }
        q53 q53VarN = n();
        i53 i53Var = new i53();
        q53VarN.d = i53Var;
        return i53Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static HttpUrl d(String str, la laVar) {
        HttpUrl httpUrl = HttpUrl.parse(str);
        Objects.requireNonNull(httpUrl);
        HttpUrl.Builder builderNewBuilder = httpUrl.newBuilder();
        for (Map.Entry entry : laVar.entrySet()) {
            builderNewBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return builderNewBuilder.build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(String str) {
        f(j(), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(OkHttpClient okHttpClient, String str) {
        for (Call call : okHttpClient.dispatcher().queuedCalls()) {
            if (str.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : okHttpClient.dispatcher().runningCalls()) {
            if (str.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g() {
        h(j());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(OkHttpClient okHttpClient) {
        okHttpClient.dispatcher().cancelAll();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized OkHttpClient j() {
        if (n().f != null) {
            return n().f;
        }
        q53 q53VarN = n();
        OkHttpClient okHttpClientBuild = o().build();
        q53VarN.f = okHttpClientBuild;
        return okHttpClientBuild;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static OkHttpClient k(long j) {
        OkHttpClient.Builder builderNewBuilder = j().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builderNewBuilder.connectTimeout(j, timeUnit).readTimeout(j, timeUnit).writeTimeout(j, timeUnit).build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static OkHttpClient l(boolean z, long j) {
        return z ? k(j) : z(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static o53 m() {
        if (n().h != null) {
            return n().h;
        }
        q53 q53VarN = n();
        o53 o53Var = new o53();
        q53VarN.h = o53Var;
        return o53Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static q53 n() {
        return b.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static OkHttpClient.Builder o() {
        OkHttpClient.Builder builderAddNetworkInterceptor = new OkHttpClient.Builder().addInterceptor(B()).addInterceptor(b()).addNetworkInterceptor(C());
        long j = i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder builderSslSocketFactory = builderAddNetworkInterceptor.connectTimeout(j, timeUnit).readTimeout(j, timeUnit).writeTimeout(j, timeUnit).dns(m()).hostnameVerifier(new HostnameVerifier() { // from class: p53
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return q53.a(str, sSLSession);
            }
        }).sslSocketFactory(p().getSocketFactory(), H());
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        builderSslSocketFactory.proxyAuthenticator(c());
        builderSslSocketFactory.proxySelector(D());
        return builderSslSocketFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SSLContext p() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{H()}, new SecureRandom());
            return sSLContext;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Call q(String str) {
        return j().newCall(new Request.Builder().url(str).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Call r(String str, String str2) {
        return j().newCall(new Request.Builder().url(str).tag(str2).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Call s(String str, Map map) {
        return j().newCall(new Request.Builder().url(str).headers(Headers.of((Map<String, String>) map)).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Call t(String str, Map map, la laVar) {
        return j().newCall(new Request.Builder().url(d(str, laVar)).headers(Headers.of((Map<String, String>) map)).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Call u(String str, Map map, RequestBody requestBody) {
        return j().newCall(new Request.Builder().url(str).headers(Headers.of((Map<String, String>) map)).post(requestBody).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Call v(OkHttpClient okHttpClient, String str) {
        return okHttpClient.newCall(new Request.Builder().url(str).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Call w(OkHttpClient okHttpClient, String str, String str2) {
        return okHttpClient.newCall(new Request.Builder().url(str).tag(str2).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Call x(OkHttpClient okHttpClient, String str, RequestBody requestBody) {
        return okHttpClient.newCall(new Request.Builder().url(str).post(requestBody).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static OkHttpClient y() {
        return z(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static OkHttpClient z(long j) {
        OkHttpClient.Builder builderNewBuilder = j().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builderNewBuilder.connectTimeout(j, timeUnit).readTimeout(j, timeUnit).writeTimeout(j, timeUnit).followRedirects(false).followSslRedirects(false).build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i() {
        g();
        m().g();
        D().b();
        c().b();
        b().b();
        B().b();
        C().c();
    }
}
