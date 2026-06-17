package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import defpackage.qx4;
import java.util.Collections;
import java.util.List;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Danmaku {

    @SerializedName("name")
    private String name;
    private boolean selected;

    @SerializedName("url")
    private String url;

    public static List<Danmaku> arrayFrom(String str) {
        List<Danmaku> list = (List) App.c().fromJson(str, new TypeToken<List<Danmaku>>() { // from class: com.fongmi.android.tv.bean.Danmaku.1
        }.getType());
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public static Danmaku empty() {
        return new Danmaku();
    }

    public static Danmaku from(String str) {
        Danmaku danmaku = new Danmaku();
        danmaku.setName(str);
        danmaku.setUrl(str);
        return danmaku;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Danmaku) {
            return getUrl().equals(((Danmaku) obj).getUrl());
        }
        return false;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? getUrl() : this.name;
    }

    public String getRealUrl() {
        String url;
        if (getUrl().startsWith(ServiceReference.DELIMITER)) {
            url = "file:/" + getUrl();
        } else {
            url = getUrl();
        }
        return qx4.a(url);
    }

    public String getUrl() {
        return TextUtils.isEmpty(this.url) ? "" : this.url;
    }

    public boolean isEmpty() {
        return getUrl().isEmpty();
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return App.c().toJson(this);
    }
}
