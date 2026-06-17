package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.github.catvod.utils.Util;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import defpackage.nl0;
import defpackage.qx4;
import defpackage.sm3;
import defpackage.vr3;
import defpackage.yc1;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Parse implements nl0 {
    private boolean activated;
    private String click;

    @SerializedName("ext")
    private Ext ext;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private Integer type;

    @SerializedName("url")
    private String url;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Ext {

        @SerializedName("flag")
        private List<String> flag;

        @SerializedName("header")
        @JsonAdapter(yc1.class)
        private Map<String, String> header;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List<String> getFlag() {
            List<String> list = this.flag;
            return list == null ? Collections.EMPTY_LIST : list;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Map<String, String> getHeader() {
            Map<String, String> map = this.header;
            return map == null ? new HashMap() : map;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isEmpty() {
            return getFlag().isEmpty() && getHeader().isEmpty();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void setFlag(List<String> list) {
            this.flag = list;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void setHeader(Map<String, String> map) {
            this.header = map;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return App.c().toJson(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Parse get(Integer num, String str) {
        Parse parse = new Parse();
        parse.setType(num);
        parse.setUrl(str);
        return parse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Parse god() {
        Parse parse = new Parse();
        parse.setName(vr3.l(sm3.R));
        parse.setType(4);
        return parse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Parse objectFrom(JsonElement jsonElement) {
        return (Parse) App.c().fromJson(jsonElement, Parse.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Parse) {
            return Objects.equals(getName(), ((Parse) obj).getName());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String extUrl() {
        int iIndexOf = getUrl().indexOf("?");
        if (getExt().isEmpty() || iIndexOf == -1) {
            return getUrl();
        }
        StringBuilder sb = new StringBuilder();
        int i = iIndexOf + 1;
        sb.append(getUrl().substring(0, i));
        sb.append("cat_ext=");
        sb.append(Util.base64(getExt().toString(), 10));
        sb.append("&");
        sb.append(getUrl().substring(i));
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getClick() {
        return TextUtils.isEmpty(this.click) ? "" : this.click;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Ext getExt() {
        Ext ext = this.ext;
        if (ext == null) {
            ext = new Ext();
        }
        this.ext = ext;
        return ext;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, String> getHeader() {
        return getExt().getHeader();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getType() {
        Integer num = this.type;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getUrl() {
        return TextUtils.isEmpty(this.url) ? "" : qx4.a(this.url);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(getName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isActivated() {
        return this.activated;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty() {
        return getType().intValue() == 0 && getUrl().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public HashMap<String, String> mixMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", getType().toString());
        map.put("ext", getExt().toString());
        map.put("url", getUrl());
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActivated(Parse parse) {
        this.activated = parse.equals(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setClick(String str) {
        this.click = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHeader(Map<String, String> map) {
        if (getHeader().isEmpty()) {
            getExt().setHeader(map);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setName(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setType(Integer num) {
        this.type = num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUrl(String str) {
        this.url = str;
    }

    /* JADX DEBUG: Method merged with bridge method: isSameContent(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameContent(Parse parse) {
        return equals(parse);
    }

    /* JADX DEBUG: Method merged with bridge method: isSameItem(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameItem(Parse parse) {
        return equals(parse);
    }

    public void setActivated(boolean z) {
        this.activated = z;
    }
}
