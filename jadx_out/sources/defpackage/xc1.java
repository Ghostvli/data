package defpackage;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xc1 {

    @SerializedName("host")
    private String a;

    @SerializedName("header")
    private JsonElement b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends TypeToken<List<xc1>> {
    }

    public static List a(JsonElement jsonElement) {
        try {
            List list = (List) new Gson().fromJson(jsonElement, new a().getType());
            return list == null ? Collections.EMPTY_LIST : list;
        } catch (Exception unused) {
            return Collections.EMPTY_LIST;
        }
    }

    public JsonElement b() {
        return this.b;
    }

    public String c() {
        return TextUtils.isEmpty(this.a) ? "" : this.a;
    }
}
