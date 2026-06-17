package defpackage;

import android.text.TextUtils;
import android.util.Log;
import defpackage.t90;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yg1 implements t90 {
    public static final b l = new a();
    public final ra1 f;
    public final int g;
    public final b h;
    public HttpURLConnection i;
    public InputStream j;
    public volatile boolean k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements b {
        @Override // yg1.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        HttpURLConnection a(URL url);
    }

    public yg1(ra1 ra1Var, int i, b bVar) {
        this.f = ra1Var;
        this.g = i;
        this.h = bVar;
    }

    public static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    public static boolean h(int i) {
        return i / 100 == 2;
    }

    public static boolean i(int i) {
        return i / 100 == 3;
    }

    @Override // defpackage.t90
    public Class a() {
        return InputStream.class;
    }

    @Override // defpackage.t90
    public void b() {
        InputStream inputStream = this.j;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.i;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.i = null;
    }

    @Override // defpackage.t90
    public void c(ug3 ug3Var, t90.a aVar) {
        long jB = b02.b();
        try {
            try {
                aVar.f(j(this.f.i(), 0, null, this.f.e()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + b02.a(jB));
                }
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                aVar.d(e);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + b02.a(jB));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + b02.a(jB));
            }
            throw th;
        }
    }

    @Override // defpackage.t90
    public void cancel() {
        this.k = true;
    }

    public final HttpURLConnection d(URL url, Map map) throws qg1 {
        try {
            HttpURLConnection httpURLConnectionA = this.h.a(url);
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.g);
            httpURLConnectionA.setReadTimeout(this.g);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e) {
            throw new qg1("URL.openConnection threw", 0, e);
        }
    }

    @Override // defpackage.t90
    public ba0 e() {
        return ba0.REMOTE;
    }

    public final InputStream g(HttpURLConnection httpURLConnection) throws qg1 {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.j = s20.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.j = httpURLConnection.getInputStream();
            }
            return this.j;
        } catch (IOException e) {
            throw new qg1("Failed to obtain InputStream", f(httpURLConnection), e);
        }
    }

    public final InputStream j(URL url, int i, URL url2, Map map) throws qg1 {
        if (i >= 5) {
            throw new qg1("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new qg1("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionD = d(url, map);
        this.i = httpURLConnectionD;
        try {
            httpURLConnectionD.connect();
            this.j = this.i.getInputStream();
            if (this.k) {
                return null;
            }
            int iF = f(this.i);
            if (h(iF)) {
                return g(this.i);
            }
            if (!i(iF)) {
                if (iF == -1) {
                    throw new qg1(iF);
                }
                try {
                    throw new qg1(this.i.getResponseMessage(), iF);
                } catch (IOException e) {
                    throw new qg1("Failed to get a response message", iF, e);
                }
            }
            String headerField = this.i.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new qg1("Received empty or null redirect url", iF);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return j(url3, i + 1, url, map);
            } catch (MalformedURLException e2) {
                throw new qg1("Bad redirect url: " + headerField, iF, e2);
            }
        } catch (IOException e3) {
            throw new qg1("Failed to connect or obtain data", f(this.i), e3);
        }
    }

    public yg1(ra1 ra1Var, int i) {
        this(ra1Var, i, l);
    }
}
