package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import defpackage.kn;
import defpackage.yc1;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Drm {

    @SerializedName("forceKey")
    private boolean forceKey;

    @SerializedName("header")
    @JsonAdapter(yc1.class)
    private Map<String, String> header;

    @SerializedName("key")
    private String key;

    @SerializedName("type")
    private String type;

    private Drm(String str, String str2, Map<String, String> map, boolean z) {
        this.key = str;
        this.type = str2;
        this.header = map;
        this.forceKey = z;
    }

    public static Drm create(String str, String str2, Map<String, String> map, boolean z) {
        return new Drm(str, str2, map, z);
    }

    public Map<String, String> getHeader() {
        Map<String, String> map = this.header;
        return map == null ? new HashMap() : map;
    }

    public String getKey() {
        return TextUtils.isEmpty(this.key) ? "" : this.key;
    }

    public String getType() {
        return TextUtils.isEmpty(this.type) ? "" : this.type;
    }

    public UUID getUUID() {
        return getType().contains("playready") ? kn.f : getType().contains("widevine") ? kn.e : getType().contains("clearkey") ? kn.d : kn.b;
    }

    public boolean isForceKey() {
        return this.forceKey;
    }

    public String toString() {
        return App.c().toJson(this);
    }
}
