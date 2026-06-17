package defpackage;

import android.text.TextUtils;
import com.github.catvod.utils.Json;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.hierynomus.msdtyp.FileTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class uq3 {

    @SerializedName("buffer")
    private Integer a;

    @SerializedName("redirect")
    private Integer b;

    @SerializedName("timeout")
    private Integer c;

    @SerializedName("postType")
    private String d;

    @SerializedName("method")
    private String e;

    @SerializedName("body")
    private String f;

    @SerializedName("data")
    private JsonElement g;

    @SerializedName("headers")
    private JsonElement h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static uq3 m(String str) {
        return (uq3) new Gson().fromJson(str, uq3.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String a() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int b() {
        Integer num = this.a;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String c() {
        Map mapF = f();
        for (String str : Arrays.asList("Content-Type", "content-type")) {
            if (mapF.containsKey(str)) {
                String str2 = (String) mapF.get(str);
                Objects.requireNonNull(str2);
                return d(str2);
            }
        }
        return "UTF-8";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String d(String str) {
        for (String str2 : str.split(";")) {
            if (str2.contains("charset=")) {
                return str2.split("=")[1];
            }
        }
        return "UTF-8";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JsonElement e() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map f() {
        return Json.toMap(g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final JsonElement g() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String h() {
        return TextUtils.isEmpty(this.e) ? "get" : this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String i() {
        return TextUtils.isEmpty(this.d) ? "json" : this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer j() {
        Integer num = this.b;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer k() {
        Integer num = this.c;
        return Integer.valueOf(num == null ? FileTime.NANO100_TO_MILLI : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean l() {
        return j().intValue() == 1;
    }
}
