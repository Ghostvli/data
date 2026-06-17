package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import defpackage.ge3;
import defpackage.qx4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Sub {

    @SerializedName("flag")
    private int flag;

    @SerializedName("format")
    private String format;

    @SerializedName("lang")
    private String lang;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public static Sub from(String str) {
        Sub sub = new Sub();
        sub.url = str;
        String strG = qx4.g(str);
        sub.name = strG;
        sub.flag = 2;
        sub.format = ge3.d(strG);
        return sub;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Sub) {
            return getUrl().equals(((Sub) obj).getUrl());
        }
        return false;
    }

    public int getFlag() {
        int i = this.flag;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public String getFormat() {
        return TextUtils.isEmpty(this.format) ? "" : this.format;
    }

    public String getLang() {
        return TextUtils.isEmpty(this.lang) ? "" : this.lang;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    public String getUrl() {
        return TextUtils.isEmpty(this.url) ? "" : this.url;
    }

    public String toString() {
        return App.c().toJson(this);
    }

    public void trans() {
        if (Trans.pass()) {
            return;
        }
        this.name = Trans.s2t(this.name);
    }
}
