package defpackage;

import com.github.catvod.utils.Json;
import com.github.catvod.utils.Util;
import com.whl.quickjs.wrapper.JSObject;
import com.whl.quickjs.wrapper.QuickJSContext;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e00 {
    public static JSObject a(QuickJSContext quickJSContext) {
        JSObject jSObjectCreateNewJSObject = quickJSContext.createNewJSObject();
        jSObjectCreateNewJSObject.setProperty("headers", quickJSContext.createNewJSObject());
        jSObjectCreateNewJSObject.setProperty("content", "");
        jSObjectCreateNewJSObject.setProperty("code", "");
        return jSObjectCreateNewJSObject;
    }

    public static RequestBody b(uq3 uq3Var) {
        FormBody.Builder builder = new FormBody.Builder();
        Map<String, String> map = Json.toMap(uq3Var.e());
        for (String str : map.keySet()) {
            builder.add(str, map.get(str));
        }
        return builder.build();
    }

    public static RequestBody c(uq3 uq3Var) {
        MultipartBody.Builder type = new MultipartBody.Builder("--dio-boundary-" + new SecureRandom().nextInt(42949) + new SecureRandom().nextInt(67296)).setType(MultipartBody.FORM);
        Map<String, String> map = Json.toMap(uq3Var.e());
        for (String str : map.keySet()) {
            type.addFormDataPart(str, map.get(str));
        }
        return type.build();
    }

    public static RequestBody d(uq3 uq3Var) {
        return RequestBody.create(uq3Var.e().toString(), MediaType.get("application/json; charset=utf-8"));
    }

    public static RequestBody e(uq3 uq3Var, String str) {
        return (uq3Var.e() == null || !"json".equals(uq3Var.i())) ? (uq3Var.e() == null || !"form".equals(uq3Var.i())) ? (uq3Var.e() == null || !"form-data".equals(uq3Var.i())) ? (uq3Var.a() == null || str == null) ? RequestBody.create(new byte[0]) : RequestBody.create(uq3Var.a(), MediaType.get(str)) : c(uq3Var) : b(uq3Var) : d(uq3Var);
    }

    public static Request f(String str, uq3 uq3Var, Headers headers) {
        return uq3Var.h().equalsIgnoreCase("post") ? new Request.Builder().url(str).headers(headers).post(e(uq3Var, headers.get("Content-Type"))).build() : uq3Var.h().equalsIgnoreCase("header") ? new Request.Builder().url(str).headers(headers).head().build() : new Request.Builder().url(str).headers(headers).get().build();
    }

    public static void g(QuickJSContext quickJSContext, Response response, JSObject jSObject) {
        for (Map.Entry<String, List<String>> entry : response.headers().toMultimap().entrySet()) {
            if (entry.getValue().size() == 1) {
                jSObject.setProperty(entry.getKey(), entry.getValue().get(0));
            }
            if (entry.getValue().size() >= 2) {
                jSObject.setProperty(entry.getKey(), pm1.a(quickJSContext, entry.getValue()));
            }
        }
    }

    public static JSObject h(QuickJSContext quickJSContext, uq3 uq3Var, Response response) {
        try {
            try {
                JSObject jSObjectCreateNewJSObject = quickJSContext.createNewJSObject();
                JSObject jSObjectCreateNewJSObject2 = quickJSContext.createNewJSObject();
                g(quickJSContext, response, jSObjectCreateNewJSObject2);
                jSObjectCreateNewJSObject.setProperty("code", response.code());
                jSObjectCreateNewJSObject.setProperty("headers", jSObjectCreateNewJSObject2);
                if (uq3Var.b() == 0) {
                    jSObjectCreateNewJSObject.setProperty("content", new String(response.body().bytes(), uq3Var.c()));
                }
                if (uq3Var.b() == 1) {
                    jSObjectCreateNewJSObject.setProperty("content", pm1.b(quickJSContext, response.body().bytes()));
                }
                if (uq3Var.b() == 2) {
                    jSObjectCreateNewJSObject.setProperty("content", Util.base64(response.body().bytes()));
                }
                if (uq3Var.b() == 3) {
                    jSObjectCreateNewJSObject.setProperty("content", response.body().bytes());
                }
                response.close();
                return jSObjectCreateNewJSObject;
            } finally {
            }
        } catch (Exception unused) {
            return a(quickJSContext);
        }
    }

    public static Call i(String str, uq3 uq3Var) {
        return q53.l(uq3Var.l(), uq3Var.k().intValue()).newCall(f(str, uq3Var, Headers.of((Map<String, String>) uq3Var.f())));
    }
}
