package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Class;
import com.fongmi.android.tv.bean.Sub;
import com.fongmi.android.tv.bean.Vod;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import defpackage.b75;
import defpackage.f11;
import defpackage.jy4;
import defpackage.lx4;
import defpackage.q24;
import defpackage.s80;
import defpackage.vv2;
import defpackage.yc1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.json.JSONObject;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
@Root(name = "rss", strict = false)
public class Result implements Parcelable {
    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.fongmi.android.tv.bean.Result.1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Result createFromParcel(Parcel parcel) {
            return new Result(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Result[] newArray(int i) {
            return new Result[i];
        }
    };

    @SerializedName("artwork")
    private String artwork;

    @SerializedName("click")
    private String click;

    @SerializedName("code")
    private Integer code;

    @SerializedName("danmaku")
    @JsonAdapter(s80.class)
    private List<Danmaku> danmaku;

    @SerializedName("desc")
    private String desc;

    @SerializedName("drm")
    private Drm drm;

    @SerializedName("filters")
    @JsonAdapter(f11.class)
    private LinkedHashMap<String, List<Filter>> filters;

    @SerializedName("flag")
    private String flag;

    @SerializedName("format")
    private String format;

    @SerializedName("header")
    @JsonAdapter(yc1.class)
    private Map<String, String> header;

    @SerializedName("jx")
    private Integer jx;

    @SerializedName("jxFrom")
    private String jxFrom;

    @SerializedName("key")
    private String key;

    @SerializedName("list")
    @ElementList(entry = "video", inline = true, required = false)
    @Path("list")
    private List<Vod> list;

    @SerializedName("msg")
    @JsonAdapter(vv2.class)
    private String msg;

    @SerializedName("pagecount")
    private Integer pagecount;

    @SerializedName("parse")
    private Integer parse;

    @SerializedName("playUrl")
    private String playUrl;

    @SerializedName("position")
    private Long position;

    @SerializedName("subs")
    private List<Sub> subs;

    @SerializedName(Name.LABEL)
    @ElementList(entry = "ty", inline = true, required = false)
    @Path(Name.LABEL)
    private List<Class> types;

    @SerializedName("url")
    @JsonAdapter(lx4.class)
    private Url url;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Result(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.types = arrayList;
        parcel.readList(arrayList, Class.class.getClassLoader());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result empty() {
        return new Result();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result error(String str) {
        Result result = new Result();
        result.setParse(0);
        result.setMsg(str);
        return result;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result folder(Vod vod) {
        Result result = new Result();
        Class r1 = new Class();
        r1.setTypeFlag("1");
        r1.setTypeId(vod.getId());
        r1.setTypeName(vod.getName());
        result.setTypes(Arrays.asList(r1));
        return result;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result fromJson(String str) {
        Result resultObjectFrom = objectFrom(str);
        return resultObjectFrom == null ? empty() : resultObjectFrom.trans();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result fromObject(JSONObject jSONObject) {
        return jSONObject == null ? empty() : objectFrom(jSONObject.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result fromType(int i, String str) {
        return i == 0 ? fromXml(str) : fromJson(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result fromXml(String str) {
        try {
            return ((Result) new Persister().read(Result.class, str, false)).trans();
        } catch (Exception unused) {
            return empty();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result list(List<Vod> list) {
        Result result = new Result();
        result.setList(list);
        return result;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result objectFrom(String str) {
        try {
            return (Result) App.c().fromJson(str, Result.class);
        } catch (Exception unused) {
            return empty();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result type(String str) {
        Result result = new Result();
        result.setTypes(Arrays.asList(Class.objectFrom(str)));
        return result.trans();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result vod(Vod vod) {
        return list(Arrays.asList(vod));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Result clear() {
        getList().clear();
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getArtwork() {
        return TextUtils.isEmpty(this.artwork) ? "" : this.artwork;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getClick() {
        return TextUtils.isEmpty(this.click) ? "" : this.click;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getCode() {
        Integer num = this.code;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Danmaku> getDanmaku() {
        List<Danmaku> list;
        return (!q24.E() || (list = this.danmaku) == null) ? new ArrayList() : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDesc() {
        return TextUtils.isEmpty(this.desc) ? "" : jy4.b(this.desc);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drm getDrm() {
        return this.drm;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LinkedHashMap<String, List<Filter>> getFilters() {
        LinkedHashMap<String, List<Filter>> linkedHashMap = this.filters;
        return linkedHashMap == null ? new LinkedHashMap<>() : linkedHashMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFlag() {
        return TextUtils.isEmpty(this.flag) ? "" : this.flag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFormat() {
        return this.format;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, String> getHeader() {
        Map<String, String> map = this.header;
        return map == null ? new HashMap() : map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getJx() {
        Integer num = this.jx;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getJxFrom() {
        return TextUtils.isEmpty(this.jxFrom) ? "" : this.jxFrom;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getKey() {
        return TextUtils.isEmpty(this.key) ? "" : this.key;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Vod> getList() {
        List<Vod> list = this.list;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getMsg() {
        return (TextUtils.isEmpty(this.msg) || getCode().intValue() != 0) ? "" : this.msg;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getPageCount() {
        Integer num = this.pagecount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getParse() {
        Integer num = this.parse;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPlayUrl() {
        return TextUtils.isEmpty(this.playUrl) ? "" : this.playUrl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Long getPosition() {
        return this.position;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRealUrl() {
        return getPlayUrl() + getUrl().v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Style getStyle(Style style) {
        return getList().isEmpty() ? Style.rect() : getList().get(0).getStyle(style);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Sub> getSubs() {
        return this.subs == null ? new ArrayList() : new ArrayList(this.subs);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Class> getTypes() {
        List<Class> list = this.types;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Url getUrl() {
        Url url = this.url;
        return url == null ? Url.create() : url;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Vod getVod() {
        return getList().isEmpty() ? new Vod() : getList().get(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasArtwork() {
        return !getArtwork().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasDesc() {
        return !getDesc().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasMsg() {
        return !getMsg().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasPosition() {
        return getPosition() != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean needParse() {
        return getParse().intValue() == 1 || getJx().intValue() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setClick(String str) {
        this.click = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDrm(Drm drm) {
        this.drm = drm;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setFlag(String str) {
        this.flag = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setFormat(String str) {
        this.format = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHeader(Map<String, String> map) {
        if (getHeader().isEmpty()) {
            this.header = map;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setKey(String str) {
        this.key = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setList(List<Vod> list) {
        this.list = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMsg(String str) {
        this.msg = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setParse(Integer num) {
        this.parse = num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTypes(List<Class> list) {
        this.types = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUrl(String str) {
        this.url = getUrl().replace(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean shouldUseParse() {
        if (b75.b0()) {
            return (getPlayUrl().isEmpty() && b75.I().N().contains(getFlag())) || getJx().intValue() == 1;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return App.c().toJson(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Result trans() {
        if (Trans.pass()) {
            return this;
        }
        getTypes().forEach(new Consumer() { // from class: ht3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Class) obj).trans();
            }
        });
        getList().forEach(new Consumer() { // from class: it3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Vod) obj).trans();
            }
        });
        getSubs().forEach(new Consumer() { // from class: jt3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Sub) obj).trans();
            }
        });
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.types);
    }

    public Result() {
    }
}
