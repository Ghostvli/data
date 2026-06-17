package defpackage;

import android.text.TextUtils;
import com.github.catvod.utils.Json;
import com.github.catvod.utils.Util;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.thegrizzlylabs.sardineandroid.DavResource;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ur3 {

    @SerializedName("code")
    private Integer a;

    @SerializedName("buffer")
    private Integer b;

    @SerializedName("content")
    private String c;

    @SerializedName("headers")
    private JsonElement d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ur3 h(String str) {
        return (ur3) new Gson().fromJson(str, ur3.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int a() {
        Integer num = this.b;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int b() {
        Integer num = this.a;
        if (num == null) {
            return 200;
        }
        return num.intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String c() {
        return TextUtils.isEmpty(this.c) ? "" : this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String d() {
        Map mapE = e();
        for (String str : Arrays.asList("Content-Type", "content-type")) {
            if (mapE.containsKey(str)) {
                String str2 = (String) mapE.get(str);
                Objects.requireNonNull(str2);
                return str2;
            }
        }
        return DavResource.DEFAULT_CONTENT_TYPE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map e() {
        return Json.toMap(f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final JsonElement f() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ByteArrayInputStream g() {
        return a() == 2 ? new ByteArrayInputStream(Util.decode(c())) : new ByteArrayInputStream(c().getBytes());
    }
}
