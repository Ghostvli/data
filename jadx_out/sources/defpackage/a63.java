package defpackage;

import android.util.Log;
import defpackage.t90;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a63 implements t90, Callback {
    public final Call.Factory f;
    public final ra1 g;
    public InputStream h;
    public ResponseBody i;
    public t90.a j;
    public volatile Call k;

    public a63(Call.Factory factory, ra1 ra1Var) {
        this.f = factory;
        this.g = ra1Var;
    }

    @Override // defpackage.t90
    public Class a() {
        return InputStream.class;
    }

    @Override // defpackage.t90
    public void b() {
        try {
            InputStream inputStream = this.h;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.i;
        if (responseBody != null) {
            responseBody.close();
        }
        this.j = null;
    }

    @Override // defpackage.t90
    public void c(ug3 ug3Var, t90.a aVar) {
        Request.Builder builderUrl = new Request.Builder().url(this.g.h());
        for (Map.Entry entry : this.g.e().entrySet()) {
            builderUrl.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        Request requestBuild = builderUrl.build();
        this.j = aVar;
        this.k = this.f.newCall(requestBuild);
        this.k.enqueue(this);
    }

    @Override // defpackage.t90
    public void cancel() {
        Call call = this.k;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // defpackage.t90
    public ba0 e() {
        return ba0.REMOTE;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.j.d(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        this.i = response.body();
        if (!response.isSuccessful()) {
            this.j.d(new qg1(response.message(), response.code()));
            return;
        }
        InputStream inputStreamC = s20.c(this.i.byteStream(), ((ResponseBody) fg3.e(this.i)).contentLength());
        this.h = inputStreamC;
        this.j.f(inputStreamC);
    }
}
