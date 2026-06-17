package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Depot {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Depot> arrayFrom(String str) {
        List<Depot> list = (List) App.c().fromJson(str, new TypeToken<List<Depot>>() { // from class: com.fongmi.android.tv.bean.Depot.1
        }.getType());
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.name) ? getUrl() : this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getUrl() {
        return TextUtils.isEmpty(this.url) ? "" : this.url;
    }
}
