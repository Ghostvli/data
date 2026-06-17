package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class s53 extends lh implements aa0 {
    public final Call.Factory e;
    public final pg1 f;
    public final String g;
    public final CacheControl h;
    public final pg1 i;
    public final ig3 j;
    public ja0 k;
    public Response l;
    public InputStream m;
    public boolean n;
    public long o;
    public long p;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Callback {
        public final /* synthetic */ p24 f;

        public a(p24 p24Var) {
            this.f = p24Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f.N(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            this.f.M(response);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements lg1 {
        public final pg1 a = new pg1();
        public final Call.Factory b;
        public String c;
        public hs4 d;
        public CacheControl e;
        public ig3 f;

        public b(Call.Factory factory) {
            this.b = factory;
        }

        @Override // aa0.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public s53 b() {
            s53 s53Var = new s53(this.b, this.c, this.e, this.a, this.f, null);
            hs4 hs4Var = this.d;
            if (hs4Var != null) {
                s53Var.f(hs4Var);
            }
            return s53Var;
        }

        @Override // defpackage.lg1
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final b a(Map map) {
            this.a.a(map);
            return this;
        }
    }

    static {
        kg2.a("media3.datasource.okhttp");
    }

    public s53(Call.Factory factory, String str, CacheControl cacheControl, pg1 pg1Var, ig3 ig3Var) {
        super(true);
        this.e = (Call.Factory) gg3.q(factory);
        this.g = str;
        this.h = cacheControl;
        this.i = pg1Var;
        this.j = ig3Var;
        this.f = new pg1();
    }

    private int A(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.o;
        if (j != -1) {
            long j2 = j - this.p;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) fy4.l(this.m)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.p += (long) i3;
        t(i3);
        return i3;
    }

    private void B(long j, ja0 ja0Var) throws mg1 {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[Buffer.SEGMENTING_THRESHOLD];
        while (j > 0) {
            try {
                int i = ((InputStream) fy4.l(this.m)).read(bArr, 0, (int) Math.min(j, 4096L));
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i == -1) {
                    throw new mg1(ja0Var, 2008, 1);
                }
                j -= (long) i;
                t(i);
            } catch (IOException e) {
                if (!(e instanceof mg1)) {
                    throw new mg1(ja0Var, 2000, 1);
                }
                throw ((mg1) e);
            }
        }
    }

    private void x() {
        Response response = this.l;
        if (response != null) {
            ((ResponseBody) gg3.q(response.body())).close();
        }
        this.m = null;
    }

    @Override // defpackage.aa0
    public long a(ja0 ja0Var) throws mg1 {
        byte[] bArrB;
        this.k = ja0Var;
        long j = 0;
        this.p = 0L;
        this.o = 0L;
        v(ja0Var);
        try {
            Response responseY = y(this.e.newCall(z(ja0Var)));
            this.l = responseY;
            ResponseBody responseBody = (ResponseBody) gg3.q(responseY.body());
            this.m = responseBody.byteStream();
            int iCode = responseY.code();
            if (!responseY.isSuccessful()) {
                if (iCode == 416) {
                    if (ja0Var.g == zg1.c(responseY.headers().get("Content-Range"))) {
                        this.n = true;
                        w(ja0Var);
                        long j2 = ja0Var.h;
                        if (j2 != -1) {
                            return j2;
                        }
                        return 0L;
                    }
                }
                try {
                    bArrB = dn.b((InputStream) gg3.q(this.m));
                } catch (IOException unused) {
                    bArrB = fy4.f;
                }
                byte[] bArr = bArrB;
                Map<String, List<String>> multimap = responseY.headers().toMultimap();
                x();
                throw new og1(iCode, responseY.message(), iCode == 416 ? new ga0(2008) : null, multimap, ja0Var, bArr);
            }
            MediaType mediaTypeContentType = responseBody.contentType();
            String string = mediaTypeContentType != null ? mediaTypeContentType.toString() : "";
            ig3 ig3Var = this.j;
            if (ig3Var != null && !ig3Var.apply(string)) {
                x();
                throw new ng1(string, ja0Var);
            }
            if (iCode == 200) {
                long j3 = ja0Var.g;
                if (j3 != 0) {
                    j = j3;
                }
            }
            long j4 = ja0Var.h;
            if (j4 != -1) {
                this.o = j4;
            } else {
                long jContentLength = responseBody.contentLength();
                this.o = jContentLength != -1 ? jContentLength - j : -1L;
            }
            this.n = true;
            w(ja0Var);
            try {
                B(j, ja0Var);
                return this.o;
            } catch (mg1 e) {
                x();
                throw e;
            }
        } catch (IOException e2) {
            throw mg1.b(e2, ja0Var, 1);
        }
    }

    @Override // defpackage.aa0
    public void close() {
        if (this.n) {
            this.n = false;
            u();
            x();
        }
        this.l = null;
        this.k = null;
    }

    @Override // defpackage.aa0
    public Uri getUri() {
        Response response = this.l;
        if (response != null) {
            return Uri.parse(response.request().url().toString());
        }
        ja0 ja0Var = this.k;
        if (ja0Var != null) {
            return ja0Var.a;
        }
        return null;
    }

    @Override // defpackage.aa0
    public Map o() {
        Response response = this.l;
        return response == null ? Collections.EMPTY_MAP : response.headers().toMultimap();
    }

    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) throws mg1 {
        try {
            return A(bArr, i, i2);
        } catch (IOException e) {
            throw mg1.b(e, (ja0) fy4.l(this.k), 2);
        }
    }

    public final Response y(Call call) throws IOException {
        p24 p24VarQ = p24.Q();
        call.enqueue(new a(p24VarQ));
        try {
            return (Response) p24VarQ.get();
        } catch (InterruptedException unused) {
            call.cancel();
            throw new InterruptedIOException();
        } catch (ExecutionException e) {
            throw new IOException(e);
        }
    }

    public final Request z(ja0 ja0Var) throws mg1 {
        long j = ja0Var.g;
        long j2 = ja0Var.h;
        HttpUrl httpUrl = HttpUrl.parse(ja0Var.a.toString());
        if (httpUrl == null) {
            throw new mg1("Malformed URL", ja0Var, 1004, 1);
        }
        Request.Builder builderUrl = new Request.Builder().url(httpUrl);
        CacheControl cacheControl = this.h;
        if (cacheControl != null) {
            builderUrl.cacheControl(cacheControl);
        }
        HashMap map = new HashMap();
        pg1 pg1Var = this.i;
        if (pg1Var != null) {
            map.putAll(pg1Var.b());
        }
        map.putAll(this.f.b());
        map.putAll(ja0Var.e);
        for (Map.Entry entry : map.entrySet()) {
            builderUrl.header((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = zg1.a(j, j2);
        if (strA != null) {
            builderUrl.addHeader("Range", strA);
        }
        String str = this.g;
        if (str != null) {
            builderUrl.addHeader("User-Agent", str);
        }
        if (!ja0Var.d(1)) {
            builderUrl.addHeader("Accept-Encoding", "identity");
        }
        byte[] bArr = ja0Var.d;
        builderUrl.method(ja0Var.b(), bArr != null ? RequestBody.create(bArr) : ja0Var.c == 2 ? RequestBody.create(fy4.f) : null);
        return builderUrl.build();
    }

    public /* synthetic */ s53(Call.Factory factory, String str, CacheControl cacheControl, pg1 pg1Var, ig3 ig3Var, a aVar) {
        this(factory, str, cacheControl, pg1Var, ig3Var);
    }
}
