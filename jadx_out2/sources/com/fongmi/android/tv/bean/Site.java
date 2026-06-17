package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.db.AppDatabase;
import com.github.catvod.crawler.Spider;
import com.github.catvod.utils.Trans;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import defpackage.di;
import defpackage.f10;
import defpackage.q53;
import defpackage.qx4;
import defpackage.sy0;
import defpackage.yc1;
import j$.util.stream.Stream$EL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Site implements Parcelable {
    public static final Parcelable.Creator<Site> CREATOR = new Parcelable.Creator<Site>() { // from class: com.fongmi.android.tv.bean.Site.1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Site createFromParcel(Parcel parcel) {
            return new Site(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Site[] newArray(int i) {
            return new Site[i];
        }
    };
    private boolean activated;

    @SerializedName("api")
    private String api;

    @SerializedName("categories")
    private List<String> categories;

    @SerializedName("changeable")
    private Integer changeable;

    @SerializedName("click")
    private String click;

    @SerializedName("ext")
    @JsonAdapter(sy0.class)
    private String ext;

    @SerializedName("header")
    @JsonAdapter(yc1.class)
    private Map<String, String> header;

    @SerializedName("hide")
    private Integer hide;

    @SerializedName("indexs")
    private Integer indexs;

    @SerializedName("jar")
    private String jar;

    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    @SerializedName("playUrl")
    private String playUrl;

    @SerializedName("quickSearch")
    private Integer quickSearch;

    @SerializedName("searchable")
    private Integer searchable;

    @SerializedName("style")
    private Style style;

    @SerializedName("timeout")
    private Integer timeout;

    @SerializedName("type")
    private Integer type;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site(Parcel parcel) {
        this.key = parcel.readString();
        this.name = parcel.readString();
        this.api = parcel.readString();
        this.ext = parcel.readString();
        this.jar = parcel.readString();
        this.click = parcel.readString();
        this.playUrl = parcel.readString();
        this.type = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.indexs = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.timeout = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.searchable = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.changeable = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.categories = parcel.createStringArrayList();
        this.style = (Style) parcel.readParcelable(Style.class.getClassLoader());
        this.activated = parcel.readByte() != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Site> findAll() {
        return AppDatabase.Q().W().g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Site get(String str, String str2) {
        Site site = new Site();
        site.setKey(str);
        site.setName(str2);
        return site;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Site objectFrom(JsonElement jsonElement, String str) {
        try {
            Site site = (Site) App.c().fromJson(jsonElement, Site.class);
            if (site.getJar().isEmpty()) {
                site.setJar(str);
            }
            site.setApi(qx4.a(site.getApi()));
            site.setExt(qx4.a(site.getExt()));
            return site.trans();
        } catch (Exception unused) {
            return new Site();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Site) {
            return Objects.equals(getKey(), ((Site) obj).getKey());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site fetchExt() {
        if (getExt().startsWith("http")) {
            String strE = q53.E(getExt());
            if (!strE.isEmpty()) {
                setExt(strE);
            }
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getApi() {
        return TextUtils.isEmpty(this.api) ? "" : this.api;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<String> getCategories() {
        List<String> list = this.categories;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getChangeable() {
        Integer num = this.changeable;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getClick() {
        return TextUtils.isEmpty(this.click) ? "" : this.click;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getExt() {
        return TextUtils.isEmpty(this.ext) ? "" : this.ext;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, String> getHeader() {
        Map<String, String> map = this.header;
        return map == null ? new HashMap() : map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getHide() {
        Integer num = this.hide;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getIndexs() {
        Integer num = this.indexs;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getJar() {
        return TextUtils.isEmpty(this.jar) ? "" : this.jar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getKey() {
        return TextUtils.isEmpty(this.key) ? "" : this.key;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPlayUrl() {
        return TextUtils.isEmpty(this.playUrl) ? "" : this.playUrl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getQuickSearch() {
        Integer num = this.quickSearch;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getSearchable() {
        Integer num = this.searchable;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Style getStyle(Style style) {
        return getStyle() != null ? getStyle() : style != null ? style : Style.rect();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getTimeout() {
        if (this.timeout == null) {
            return f10.g;
        }
        return TimeUnit.SECONDS.toMillis(Math.max(r2.intValue(), 1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getType() {
        Integer num = this.type;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(getKey());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isActivated() {
        return this.activated;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isChangeable() {
        return getChangeable().intValue() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty() {
        return getKey().isEmpty() && getName().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isHide() {
        return getHide().intValue() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isIndex() {
        return getIndexs().intValue() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isQuickSearch() {
        return getQuickSearch().intValue() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSearchable() {
        return getSearchable().intValue() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site recent() {
        di.d().o(getKey(), getApi(), getJar());
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void save() {
        AppDatabase.Q().W().c(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActivated(Site site) {
        this.activated = site.equals(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setApi(String str) {
        this.api = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCategories(List<String> list) {
        this.categories = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site setChangeable(boolean z) {
        if (getChangeable().intValue() != 0) {
            setChangeable(Integer.valueOf(z ? 1 : 2));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setExt(String str) {
        this.ext = str.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setJar(String str) {
        this.jar = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setKey(String str) {
        this.key = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setName(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site setSearchable(boolean z) {
        if (getSearchable().intValue() != 0) {
            setSearchable(Integer.valueOf(z ? 1 : 2));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Spider spider() {
        return di.d().f(getKey(), getApi(), getExt(), getJar());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site sync(Site site) {
        if (site != null) {
            if (getChangeable().intValue() != 0) {
                setChangeable(Integer.valueOf(Math.max(1, site.getChangeable().intValue())));
            }
            if (getSearchable().intValue() != 0) {
                setSearchable(Integer.valueOf(Math.max(1, site.getSearchable().intValue())));
            }
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site trans() {
        if (Trans.pass()) {
            return this;
        }
        this.name = Trans.s2t(this.name);
        setCategories(Stream$EL.toList(getCategories().stream().map(new Function() { // from class: r74
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Trans.s2t((String) obj);
            }
        })));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.name);
        parcel.writeString(this.api);
        parcel.writeString(this.ext);
        parcel.writeString(this.jar);
        parcel.writeString(this.click);
        parcel.writeString(this.playUrl);
        parcel.writeValue(this.type);
        parcel.writeValue(this.indexs);
        parcel.writeValue(this.timeout);
        parcel.writeValue(this.searchable);
        parcel.writeValue(this.changeable);
        parcel.writeStringList(this.categories);
        parcel.writeParcelable(this.style, i);
        parcel.writeByte(this.activated ? (byte) 1 : (byte) 0);
    }

    public void setActivated(boolean z) {
        this.activated = z;
    }

    public Style getStyle() {
        return this.style;
    }

    public void setChangeable(Integer num) {
        this.changeable = num;
    }

    public void setSearchable(Integer num) {
        this.searchable = num;
    }

    public Site() {
    }
}
