package defpackage;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import defpackage.cg0;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cg0 extends lh implements aa0 {
    public final boolean e;
    public final boolean f;
    public final int g;
    public final int h;
    public final String i;
    public final pg1 j;
    public final pg1 k;
    public final ig3 l;
    public final boolean m;
    public ja0 n;
    public HttpURLConnection o;
    public InputStream p;
    public boolean q;
    public int r;
    public long s;
    public long t;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements lg1 {
        public hs4 b;
        public ig3 c;
        public String d;
        public boolean g;
        public boolean h;
        public boolean i;
        public final pg1 a = new pg1();
        public int e = 8000;
        public int f = 8000;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b()Laa0; */
        @Override // aa0.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public cg0 b() {
            cg0 cg0Var = new cg0(this.d, this.e, this.f, this.g, this.h, this.a, this.c, this.i);
            hs4 hs4Var = this.b;
            if (hs4Var != null) {
                cg0Var.f(hs4Var);
            }
            return cg0Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/util/Map;)Llg1; */
        @Override // defpackage.lg1
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a(Map map) {
            this.a.a(map);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e(String str) {
            this.d = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends e51 {
        public final Map f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Map map) {
            this.f = map;
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:java.lang.Object:0x0000: INVOKE (r0v0 java.util.Map$Entry) INTERFACE call: java.util.Map.Entry.getKey():java.lang.Object A[MD:():K (c), WRAPPED] (LINE:1)) != (null java.lang.Object)) ? true : false */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ boolean i(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((r0v0 java.lang.String) != (null java.lang.String)) ? true : false */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ boolean j(String str) {
            return str != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a()Ljava/lang/Object; */
        @Override // defpackage.f51
        public Map b() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.e51, java.util.Map
        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return super.e(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.e51, java.util.Map
        public Set entrySet() {
            return m24.b(super.entrySet(), new ig3() { // from class: dg0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.ig3
                public final boolean apply(Object obj) {
                    return cg0.c.i((Map.Entry) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map
        public boolean equals(Object obj) {
            return obj != null && super.f(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Map
        public int hashCode() {
            return super.h();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.e51, java.util.Map
        public boolean isEmpty() {
            return super.isEmpty() || (super.size() == 1 && super.containsKey(null));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: get(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // defpackage.e51, java.util.Map
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public List get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.e51, java.util.Map
        public Set keySet() {
            return m24.b(super.keySet(), new ig3() { // from class: eg0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.ig3
                public final boolean apply(Object obj) {
                    return cg0.c.j((String) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.e51, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cg0(String str, int i, int i2, boolean z, boolean z2, pg1 pg1Var, ig3 ig3Var, boolean z3) {
        super(true);
        this.i = str;
        this.g = i;
        this.h = i2;
        this.e = z;
        this.f = z2;
        if (z && z2) {
            jl.a("crossProtocolRedirectsForceOriginal should not be set if allowCrossProtocolRedirects is true");
            throw null;
        }
        this.j = pg1Var;
        this.l = ig3Var;
        this.k = new pg1();
        this.m = z3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean A(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long y() {
        Thread threadCurrentThread = Thread.currentThread();
        return Build.VERSION.SDK_INT < 36 ? threadCurrentThread.getId() : threadCurrentThread.threadId();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final HttpURLConnection B(ja0 ja0Var) throws IOException {
        HttpURLConnection httpURLConnectionC;
        URL url = new URL(ja0Var.a.toString());
        int i = ja0Var.c;
        byte[] bArr = ja0Var.d;
        long j = ja0Var.g;
        long j2 = ja0Var.h;
        int i2 = 1;
        boolean zD = ja0Var.d(1);
        if (!this.e && !this.f && !this.m) {
            return C(url, i, bArr, j, j2, zD, true, ja0Var.e);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 > 20) {
                throw new mg1(new NoRouteToHostException("Too many redirects: " + i4), ja0Var, 2001, 1);
            }
            httpURLConnectionC = C(url, i, bArr, j, j2, zD, false, ja0Var.e);
            int responseCode = httpURLConnectionC.getResponseCode();
            String headerField = httpURLConnectionC.getHeaderField("Location");
            if ((i == i2 || i == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionC.disconnect();
                url = z(url, headerField, ja0Var);
            } else {
                if (i != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                httpURLConnectionC.disconnect();
                if (!this.m || responseCode != 302) {
                    bArr = null;
                    i = 1;
                }
                url = z(url, headerField, ja0Var);
            }
            i3 = i4;
            i2 = 1;
        }
        return httpURLConnectionC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final HttpURLConnection C(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        HttpURLConnection httpURLConnectionD = D(url);
        httpURLConnectionD.setConnectTimeout(this.g);
        httpURLConnectionD.setReadTimeout(this.h);
        HashMap map2 = new HashMap();
        pg1 pg1Var = this.j;
        if (pg1Var != null) {
            map2.putAll(pg1Var.b());
        }
        map2.putAll(this.k.b());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionD.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = zg1.a(j, j2);
        if (strA != null) {
            httpURLConnectionD.setRequestProperty("Range", strA);
        }
        String str = this.i;
        if (str != null) {
            httpURLConnectionD.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionD.setRequestProperty("Accept-Encoding", z ? "gzip" : "identity");
        httpURLConnectionD.setInstanceFollowRedirects(z2);
        httpURLConnectionD.setDoOutput(bArr != null);
        httpURLConnectionD.setRequestMethod(ja0.c(i));
        if (bArr == null) {
            httpURLConnectionD.connect();
            return httpURLConnectionD;
        }
        httpURLConnectionD.setFixedLengthStreamingMode(bArr.length);
        httpURLConnectionD.connect();
        OutputStream outputStream = httpURLConnectionD.getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        return httpURLConnectionD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public HttpURLConnection D(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int E(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.s;
        if (j != -1) {
            long j2 = j - this.t;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) fy4.l(this.p)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.t += (long) i3;
        t(i3);
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(long j, ja0 ja0Var) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[Buffer.SEGMENTING_THRESHOLD];
        while (j > 0) {
            int i = ((InputStream) fy4.l(this.p)).read(bArr, 0, (int) Math.min(j, 4096L));
            if (Thread.currentThread().isInterrupted()) {
                throw new mg1(new InterruptedIOException(), ja0Var, 2000, 1);
            }
            if (i == -1) {
                throw new mg1(ja0Var, 2008, 1);
            }
            j -= (long) i;
            t(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public long a(ja0 ja0Var) throws mg1 {
        byte[] bArrB;
        this.n = ja0Var;
        long j = 0;
        this.t = 0L;
        this.s = 0L;
        v(ja0Var);
        try {
            TrafficStats.setThreadStatsTag((int) y());
            HttpURLConnection httpURLConnectionB = B(ja0Var);
            this.o = httpURLConnectionB;
            this.r = httpURLConnectionB.getResponseCode();
            String responseMessage = httpURLConnectionB.getResponseMessage();
            int i = this.r;
            if (i < 200 || i > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionB.getHeaderFields();
                if (this.r == 416) {
                    if (ja0Var.g == zg1.c(httpURLConnectionB.getHeaderField("Content-Range"))) {
                        this.q = true;
                        w(ja0Var);
                        long j2 = ja0Var.h;
                        if (j2 != -1) {
                            return j2;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionB.getErrorStream();
                try {
                    bArrB = errorStream != null ? dn.b(errorStream) : fy4.f;
                } catch (IOException unused) {
                    bArrB = fy4.f;
                }
                byte[] bArr = bArrB;
                x();
                throw new og1(this.r, responseMessage, this.r == 416 ? new ga0(2008) : null, headerFields, ja0Var, bArr);
            }
            String contentType = httpURLConnectionB.getContentType();
            ig3 ig3Var = this.l;
            if (ig3Var != null && !ig3Var.apply(contentType)) {
                x();
                throw new ng1(contentType, ja0Var);
            }
            if (this.r == 200) {
                long j3 = ja0Var.g;
                if (j3 != 0) {
                    j = j3;
                }
            }
            boolean zA = A(httpURLConnectionB);
            if (zA) {
                this.s = ja0Var.h;
            } else {
                long j4 = ja0Var.h;
                if (j4 != -1) {
                    this.s = j4;
                } else {
                    long jB = zg1.b(httpURLConnectionB.getHeaderField("Content-Length"), httpURLConnectionB.getHeaderField("Content-Range"));
                    this.s = jB != -1 ? jB - j : -1L;
                }
            }
            try {
                this.p = httpURLConnectionB.getInputStream();
                if (zA) {
                    this.p = new GZIPInputStream(this.p);
                }
                this.q = true;
                w(ja0Var);
                try {
                    F(j, ja0Var);
                    return this.s;
                } catch (IOException e) {
                    x();
                    if (e instanceof mg1) {
                        throw ((mg1) e);
                    }
                    throw new mg1(e, ja0Var, 2000, 1);
                }
            } catch (IOException e2) {
                x();
                throw new mg1(e2, ja0Var, 2000, 1);
            }
        } catch (IOException e3) {
            x();
            throw mg1.b(e3, ja0Var, 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.aa0
    public void close() {
        try {
            InputStream inputStream = this.p;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new mg1(e, (ja0) fy4.l(this.n), 2000, 3);
                }
            }
        } finally {
            this.p = null;
            x();
            if (this.q) {
                this.q = false;
                u();
            }
            this.o = null;
            this.n = null;
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.o;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        ja0 ja0Var = this.n;
        if (ja0Var != null) {
            return ja0Var.a;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public Map o() {
        HttpURLConnection httpURLConnection = this.o;
        return httpURLConnection == null ? zi1.j() : new c(httpURLConnection.getHeaderFields());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) throws mg1 {
        try {
            return E(bArr, i, i2);
        } catch (IOException e) {
            throw mg1.b(e, (ja0) fy4.l(this.n), 2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x() {
        HttpURLConnection httpURLConnection = this.o;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                xz1.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final URL z(URL url, String str, ja0 ja0Var) throws mg1 {
        if (str == null) {
            throw new mg1("Null location redirect", ja0Var, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new mg1("Unsupported protocol redirect: " + protocol, ja0Var, 2001, 1);
            }
            if (this.e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            if (this.f) {
                try {
                    return new URL(url2.toString().replaceFirst(protocol, url.getProtocol()));
                } catch (MalformedURLException e) {
                    throw new mg1(e, ja0Var, 2001, 1);
                }
            }
            throw new mg1("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", ja0Var, 2001, 1);
        } catch (MalformedURLException e2) {
            throw new mg1(e2, ja0Var, 2001, 1);
        }
    }
}
