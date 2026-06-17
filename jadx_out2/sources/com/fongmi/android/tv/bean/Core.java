package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import defpackage.q53;
import defpackage.qx4;
import defpackage.rf1;
import defpackage.t14;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Core {

    @SerializedName("auth")
    private String auth;

    @SerializedName("broker")
    private String broker;

    @SerializedName("domain")
    private String domain;

    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    @SerializedName("option")
    private List<Option> option;

    @SerializedName("pass")
    private String pass;

    @SerializedName("pkg")
    private String pkg;

    @SerializedName("resp")
    private String resp;

    @SerializedName("sign")
    private String sign;

    @SerializedName("so")
    private String so;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Option {

        @SerializedName("key")
        private String key;

        @SerializedName("values")
        private List<String> values;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getKey() {
            return TextUtils.isEmpty(this.key) ? "" : this.key;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List<String> getValues() {
            List<String> list = this.values;
            return list == null ? Collections.EMPTY_LIST : list;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getString(String str) {
        String strA = qx4.a(str);
        return strA.startsWith("http") ? q53.E(strA) : strA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Core objectFrom(String str) {
        return (Core) new Gson().fromJson(str, Core.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Core) {
            return getSign().equals(((Core) obj).getSign());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getAuth() {
        return !getResp().isEmpty() ? t14.b().d("/tvbus") : TextUtils.isEmpty(this.auth) ? "" : qx4.a(this.auth);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getBroker() {
        return TextUtils.isEmpty(this.broker) ? "" : qx4.a(this.broker);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDomain() {
        return TextUtils.isEmpty(this.domain) ? "" : getString(this.domain);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rf1 getHook() {
        if (getPkg().isEmpty() || getSign().isEmpty()) {
            return null;
        }
        return new rf1(getSign(), getPkg());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : getString(this.name);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Option> getOption() {
        List<Option> list = this.option;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPass() {
        return TextUtils.isEmpty(this.pass) ? "" : getString(this.pass);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPkg() {
        return TextUtils.isEmpty(this.pkg) ? "" : getString(this.pkg);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getResp() {
        return TextUtils.isEmpty(this.resp) ? "" : getString(this.resp);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSign() {
        return TextUtils.isEmpty(this.sign) ? "" : getString(this.sign);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSo() {
        return TextUtils.isEmpty(this.so) ? "" : qx4.a(this.so);
    }
}
