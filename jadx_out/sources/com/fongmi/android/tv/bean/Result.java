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
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Result createFromParcel(Parcel parcel) {
            return new Result(parcel);
        }

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

    public Result(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.types = arrayList;
        parcel.readList(arrayList, Class.class.getClassLoader());
    }

    public static Result empty() {
        return new Result();
    }

    public static Result error(String str) {
        Result result = new Result();
        result.setParse(0);
        result.setMsg(str);
        return result;
    }

    public static Result folder(Vod vod) {
        Result result = new Result();
        Class r1 = new Class();
        r1.setTypeFlag("1");
        r1.setTypeId(vod.getId());
        r1.setTypeName(vod.getName());
        result.setTypes(Arrays.asList(r1));
        return result;
    }

    public static Result fromJson(String str) {
        Result resultObjectFrom = objectFrom(str);
        return resultObjectFrom == null ? empty() : resultObjectFrom.trans();
    }

    public static Result fromObject(JSONObject jSONObject) {
        return jSONObject == null ? empty() : objectFrom(jSONObject.toString());
    }

    public static Result fromType(int i, String str) {
        return i == 0 ? fromXml(str) : fromJson(str);
    }

    public static Result fromXml(String str) {
        try {
            return ((Result) new Persister().read(Result.class, str, false)).trans();
        } catch (Exception unused) {
            return empty();
        }
    }

    public static Result list(List<Vod> list) {
        Result result = new Result();
        result.setList(list);
        return result;
    }

    public static Result objectFrom(String str) {
        try {
            return (Result) App.c().fromJson(str, Result.class);
        } catch (Exception unused) {
            return empty();
        }
    }

    public static Result type(String str) {
        Result result = new Result();
        result.setTypes(Arrays.asList(Class.objectFrom(str)));
        return result.trans();
    }

    public static Result vod(Vod vod) {
        return list(Arrays.asList(vod));
    }

    public Result clear() {
        getList().clear();
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArtwork() {
        return TextUtils.isEmpty(this.artwork) ? "" : this.artwork;
    }

    public String getClick() {
        return TextUtils.isEmpty(this.click) ? "" : this.click;
    }

    public Integer getCode() {
        Integer num = this.code;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public List<Danmaku> getDanmaku() {
        List<Danmaku> list;
        return (!q24.E() || (list = this.danmaku) == null) ? new ArrayList() : list;
    }

    public String getDesc() {
        return TextUtils.isEmpty(this.desc) ? "" : jy4.b(this.desc);
    }

    public Drm getDrm() {
        return this.drm;
    }

    public LinkedHashMap<String, List<Filter>> getFilters() {
        LinkedHashMap<String, List<Filter>> linkedHashMap = this.filters;
        return linkedHashMap == null ? new LinkedHashMap<>() : linkedHashMap;
    }

    public String getFlag() {
        return TextUtils.isEmpty(this.flag) ? "" : this.flag;
    }

    public String getFormat() {
        return this.format;
    }

    public Map<String, String> getHeader() {
        Map<String, String> map = this.header;
        return map == null ? new HashMap() : map;
    }

    public Integer getJx() {
        Integer num = this.jx;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getJxFrom() {
        return TextUtils.isEmpty(this.jxFrom) ? "" : this.jxFrom;
    }

    public String getKey() {
        return TextUtils.isEmpty(this.key) ? "" : this.key;
    }

    public List<Vod> getList() {
        List<Vod> list = this.list;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public String getMsg() {
        return (TextUtils.isEmpty(this.msg) || getCode().intValue() != 0) ? "" : this.msg;
    }

    public Integer getPageCount() {
        Integer num = this.pagecount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getParse() {
        Integer num = this.parse;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getPlayUrl() {
        return TextUtils.isEmpty(this.playUrl) ? "" : this.playUrl;
    }

    public Long getPosition() {
        return this.position;
    }

    public String getRealUrl() {
        return getPlayUrl() + getUrl().v();
    }

    public Style getStyle(Style style) {
        return getList().isEmpty() ? Style.rect() : getList().get(0).getStyle(style);
    }

    public List<Sub> getSubs() {
        return this.subs == null ? new ArrayList() : new ArrayList(this.subs);
    }

    public List<Class> getTypes() {
        List<Class> list = this.types;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public Url getUrl() {
        Url url = this.url;
        return url == null ? Url.create() : url;
    }

    public Vod getVod() {
        return getList().isEmpty() ? new Vod() : getList().get(0);
    }

    public boolean hasArtwork() {
        return !getArtwork().isEmpty();
    }

    public boolean hasDesc() {
        return !getDesc().isEmpty();
    }

    public boolean hasMsg() {
        return !getMsg().isEmpty();
    }

    public boolean hasPosition() {
        return getPosition() != null;
    }

    public boolean needParse() {
        return getParse().intValue() == 1 || getJx().intValue() == 1;
    }

    public void setClick(String str) {
        this.click = str;
    }

    public void setDrm(Drm drm) {
        this.drm = drm;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setHeader(Map<String, String> map) {
        if (getHeader().isEmpty()) {
            this.header = map;
        }
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setList(List<Vod> list) {
        this.list = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setParse(Integer num) {
        this.parse = num;
    }

    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    public void setTypes(List<Class> list) {
        this.types = list;
    }

    public void setUrl(String str) {
        this.url = getUrl().replace(str);
    }

    public boolean shouldUseParse() {
        if (b75.b0()) {
            return (getPlayUrl().isEmpty() && b75.I().N().contains(getFlag())) || getJx().intValue() == 1;
        }
        return false;
    }

    public String toString() {
        return App.c().toJson(this);
    }

    public Result trans() {
        if (Trans.pass()) {
            return this;
        }
        getTypes().forEach(new Consumer() { // from class: ht3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Class) obj).trans();
            }
        });
        getList().forEach(new Consumer() { // from class: it3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Vod) obj).trans();
            }
        });
        getSubs().forEach(new Consumer() { // from class: jt3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Sub) obj).trans();
            }
        });
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.types);
    }

    public Result() {
    }
}
