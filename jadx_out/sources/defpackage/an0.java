package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.github.catvod.crawler.R;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class an0 {

    @SerializedName("name")
    private String a;

    @SerializedName("url")
    private String b;

    @SerializedName("ips")
    private List<String> c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends TypeToken<List<an0>> {
    }

    public static List a(JsonElement jsonElement) {
        try {
            List list = (List) new Gson().fromJson(jsonElement, new a().getType());
            return list == null ? new ArrayList() : list;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static List b(Context context) {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = context.getResources().getStringArray(R.array.doh_url);
        String[] stringArray2 = context.getResources().getStringArray(R.array.doh_name);
        for (int i = 0; i < stringArray2.length; i++) {
            arrayList.add(new an0().g(stringArray2[i]).i(stringArray[i]));
        }
        return arrayList;
    }

    public static an0 h(String str) {
        an0 an0Var = (an0) new Gson().fromJson(str, an0.class);
        return an0Var == null ? new an0() : an0Var;
    }

    public List c() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = d().iterator();
            while (it.hasNext()) {
                arrayList.add(InetAddress.getByName((String) it.next()));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public List d() {
        List<String> list = this.c;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public String e() {
        return TextUtils.isEmpty(this.a) ? "" : this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof an0) {
            return f().equals(((an0) obj).f());
        }
        return false;
    }

    public String f() {
        return TextUtils.isEmpty(this.b) ? "" : this.b;
    }

    public an0 g(String str) {
        this.a = str;
        return this;
    }

    public int hashCode() {
        return f().hashCode();
    }

    public an0 i(String str) {
        this.b = str;
        return this;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
