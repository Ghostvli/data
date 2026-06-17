package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.db.AppDatabase;
import com.github.catvod.utils.Prefers;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Config {

    @SerializedName("home")
    private String home;

    @SerializedName(Name.MARK)
    private int id;

    @SerializedName("json")
    private String json;

    @SerializedName("logo")
    private String logo;

    @SerializedName("name")
    private String name;

    @SerializedName("notice")
    private String notice;

    @SerializedName("parse")
    private String parse;

    @SerializedName("time")
    private long time;

    @SerializedName("type")
    private int type;

    @SerializedName("url")
    private String url;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Config> arrayFrom(String str) {
        List<Config> list = (List) App.c().fromJson(str, new TypeToken<List<Config>>() { // from class: com.fongmi.android.tv.bean.Config.1
        }.getType());
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Config create(int i, String str, String str2) {
        return new Config().type(i).url(str).name(str2).insert();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Config find(Config config, int i) {
        Config configI = AppDatabase.Q().R().i(config.getUrl(), i);
        return configI == null ? create(i, config.getUrl(), config.getName()) : configI.type(i).name(config.getName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Config> findUrls() {
        return AppDatabase.Q().R().n(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Config> getAll(int i) {
        return AppDatabase.Q().R().l(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Config live() {
        Config configM = AppDatabase.Q().R().m(1);
        return configM == null ? create(1) : configM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Config objectFrom(String str) {
        return (Config) App.c().fromJson(str, Config.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Config vod() {
        Config configM = AppDatabase.Q().R().m(0);
        return configM == null ? create(0) : configM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Config wall() {
        Config configM = AppDatabase.Q().R().m(2);
        return configM == null ? create(2) : configM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void delete() {
        AppDatabase.Q().R().h(getUrl(), getType());
        History.delete(getId());
        Keep.delete(getId());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Config) && getId() == ((Config) obj).getId();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDesc() {
        return !TextUtils.isEmpty(getName()) ? getName() : !TextUtils.isEmpty(getUrl()) ? getUrl() : "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getHome() {
        return this.home;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getId() {
        return this.id;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getJson() {
        return this.json;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getLogo() {
        return this.logo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNotice() {
        return this.notice;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getParse() {
        return this.parse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getTime() {
        return this.time;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getType() {
        return this.type;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getUrl() {
        return this.url;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Config insert() {
        if (isEmpty()) {
            return this;
        }
        setId(Math.toIntExact(AppDatabase.Q().R().a(this).longValue()));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty() {
        return TextUtils.isEmpty(getUrl());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Config json(String str) {
        setJson(str);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Config name(String str) {
        setName(str);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Config save() {
        if (isEmpty()) {
            return this;
        }
        AppDatabase.Q().R().c(this);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHome(String str) {
        this.home = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setId(int i) {
        this.id = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setJson(String str) {
        this.json = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLogo(String str) {
        this.logo = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setName(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNotice(String str) {
        this.notice = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setParse(String str) {
        this.parse = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTime(long j) {
        this.time = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setType(int i) {
        this.type = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUrl(String str) {
        this.url = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return App.c().toJson(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Config type(int i) {
        setType(i);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Config update() {
        if (isEmpty()) {
            return this;
        }
        setTime(System.currentTimeMillis());
        Prefers.put("config_" + getType(), getUrl());
        return save();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Config url(String str) {
        setUrl(str);
        return this;
    }

    public static Config create(int i, String str) {
        return new Config().type(i).url(str).insert();
    }

    public static Config create(int i) {
        return new Config().type(i);
    }

    public static void delete(String str, int i) {
        AppDatabase.Q().R().h(str, i);
    }

    public static void delete(String str) {
        AppDatabase.Q().R().g(str);
    }

    public static Config find(String str, int i) {
        Config configI = AppDatabase.Q().R().i(str, i);
        return configI == null ? create(i, str) : configI.type(i);
    }

    public static Config find(String str, String str2, int i) {
        Config configI = AppDatabase.Q().R().i(str, i);
        return configI == null ? create(i, str, str2) : configI.type(i).name(str2);
    }

    public static Config find(Config config) {
        return find(config, config.getType());
    }

    public static Config find(int i) {
        return AppDatabase.Q().R().k(i);
    }

    public static Config find(Depot depot, int i) {
        Config configI = AppDatabase.Q().R().i(depot.getUrl(), i);
        return configI == null ? create(i, depot.getUrl(), depot.getName()) : configI.type(i).name(depot.getName());
    }
}
