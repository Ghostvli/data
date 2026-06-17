package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Flag;
import com.fongmi.android.tv.bean.Vod;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import defpackage.jy4;
import defpackage.nl0;
import defpackage.u94;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
@Root(strict = false)
public class Vod implements Parcelable, nl0 {
    public static final Parcelable.Creator<Vod> CREATOR = new Parcelable.Creator<Vod>() { // from class: com.fongmi.android.tv.bean.Vod.2
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Vod createFromParcel(Parcel parcel) {
            return new Vod(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Vod[] newArray(int i) {
            return new Vod[i];
        }
    };

    @SerializedName("action")
    private String action;

    @SerializedName("cate")
    private Cate cate;

    @SerializedName("circle")
    private Integer circle;

    @SerializedName("land")
    private Integer land;

    @SerializedName("ratio")
    private Float ratio;
    private Site site;

    @SerializedName("style")
    private Style style;

    @SerializedName("type_name")
    @Element(name = "type", required = false)
    private String typeName;

    @SerializedName("vod_actor")
    @Element(name = "actor", required = false)
    private String vodActor;

    @SerializedName("vod_area")
    @Element(name = "area", required = false)
    private String vodArea;

    @SerializedName("vod_content")
    @Element(name = "des", required = false)
    private String vodContent;

    @SerializedName("vod_director")
    @Element(name = "director", required = false)
    private String vodDirector;

    @ElementList(entry = "dd", inline = true, required = false)
    @Path("dl")
    private List<Flag> vodFlags;

    @SerializedName("vod_id")
    @Element(name = Name.MARK, required = false)
    private String vodId;

    @SerializedName("vod_name")
    @Element(name = "name", required = false)
    private String vodName;

    @SerializedName("vod_pic")
    @Element(name = "pic", required = false)
    private String vodPic;

    @SerializedName("vod_play_from")
    private String vodPlayFrom;

    @SerializedName("vod_play_url")
    private String vodPlayUrl;

    @SerializedName("vod_remarks")
    @Element(name = "note", required = false)
    private String vodRemarks;

    @SerializedName("vod_tag")
    private String vodTag;

    @SerializedName("vod_year")
    @Element(name = "year", required = false)
    private String vodYear;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Vod(Parcel parcel) {
        this.vodId = parcel.readString();
        this.vodName = parcel.readString();
        this.typeName = parcel.readString();
        this.vodPic = parcel.readString();
        this.vodRemarks = parcel.readString();
        this.vodYear = parcel.readString();
        this.vodArea = parcel.readString();
        this.vodDirector = parcel.readString();
        this.vodActor = parcel.readString();
        this.vodContent = parcel.readString();
        this.vodPlayFrom = parcel.readString();
        this.vodPlayUrl = parcel.readString();
        this.vodTag = parcel.readString();
        this.action = parcel.readString();
        this.land = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.circle = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.ratio = (Float) parcel.readValue(Float.class.getClassLoader());
        this.cate = (Cate) parcel.readParcelable(Cate.class.getClassLoader());
        this.style = (Style) parcel.readParcelable(Style.class.getClassLoader());
        this.vodFlags = parcel.createTypedArrayList(Flag.CREATOR);
        this.site = (Site) parcel.readParcelable(Site.class.getClassLoader());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Vod> arrayFrom(String str) {
        List<Vod> list = (List) App.c().fromJson(str, new TypeToken<List<Vod>>() { // from class: com.fongmi.android.tv.bean.Vod.1
        }.getType());
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean c(String[] strArr, String[] strArr2, int i) {
        return (strArr[i].trim().isEmpty() || i >= strArr2.length || TextUtils.isEmpty(strArr2[i])) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Vod objectFrom(String str) {
        Vod vod = (Vod) App.c().fromJson(str, Vod.class);
        return vod == null ? new Vod() : vod.trans().setFlags();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void checkName(String str) {
        if (getName().isEmpty()) {
            setName(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void checkPic(String str) {
        if (getPic().isEmpty()) {
            setPic(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        String name;
        String name2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vod)) {
            return false;
        }
        Vod vod = (Vod) obj;
        if (getId().isEmpty() || vod.getId().isEmpty()) {
            name = getName();
            name2 = vod.getName();
        } else {
            name = getId();
            name2 = vod.getId();
        }
        return Objects.equals(name, name2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getAction() {
        return TextUtils.isEmpty(this.action) ? "" : this.action;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getActor() {
        return TextUtils.isEmpty(this.vodActor) ? "" : this.vodActor.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getArea() {
        return TextUtils.isEmpty(this.vodArea) ? "" : this.vodArea.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Cate getCate() {
        return this.cate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCircle() {
        Integer num = this.circle;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getContent() {
        return TextUtils.isEmpty(this.vodContent) ? "" : jy4.b(this.vodContent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDirector() {
        return TextUtils.isEmpty(this.vodDirector) ? "" : this.vodDirector.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Flag> getFlags() {
        List<Flag> arrayList = this.vodFlags;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.vodFlags = arrayList;
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getId() {
        return TextUtils.isEmpty(this.vodId) ? "" : this.vodId.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getLand() {
        Integer num = this.land;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.vodName) ? "" : Html.fromHtml(this.vodName, 0).toString().trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getNameVisible() {
        return getName().isEmpty() ? 8 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPic() {
        return TextUtils.isEmpty(this.vodPic) ? "" : this.vodPic.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPlayFrom() {
        return TextUtils.isEmpty(this.vodPlayFrom) ? "" : this.vodPlayFrom;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPlayUrl() {
        return TextUtils.isEmpty(this.vodPlayUrl) ? "" : this.vodPlayUrl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getRatio() {
        Float f = this.ratio;
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getRemarkVisible() {
        return getRemarks().isEmpty() ? 8 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRemarks() {
        return TextUtils.isEmpty(this.vodRemarks) ? "" : this.vodRemarks.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Site getSite() {
        return this.site;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSiteKey() {
        return getSite() == null ? "" : getSite().getKey();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSiteName() {
        return getSite() == null ? "" : getSite().getName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getSiteVisible() {
        return getSite() == null ? 8 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Style getStyle() {
        Style style = this.style;
        return style != null ? style : Style.get(getLand(), getCircle(), getRatio());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTag() {
        return TextUtils.isEmpty(this.vodTag) ? "" : this.vodTag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTypeName() {
        return TextUtils.isEmpty(this.typeName) ? "" : this.typeName.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getYear() {
        return TextUtils.isEmpty(this.vodYear) ? "" : this.vodYear.trim();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getYearVisible() {
        return (getSite() != null || getYear().length() < 4) ? 8 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return !getId().isEmpty() ? Objects.hash(getId()) : Objects.hash(getName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isAction() {
        return !getAction().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isFolder() {
        return "folder".equals(getTag()) || getCate() != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: isSameContent(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameContent(Vod vod) {
        return getName().equals(vod.getName()) && getPic().equals(vod.getPic()) && getRemarks().equals(vod.getRemarks()) && Objects.equals(getSite(), vod.getSite());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setContent(String str) {
        this.vodContent = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDirector(String str) {
        this.vodDirector = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Vod setFlags() {
        final String[] strArrSplit = getPlayUrl().split("\\$\\$\\$");
        final String[] strArrSplit2 = getPlayFrom().split("\\$\\$\\$");
        if (getFlags().isEmpty()) {
            Stream streamMapToObj = IntStream.range(0, strArrSplit2.length).filter(new IntPredicate() { // from class: v55
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.IntPredicate
                public final boolean test(int i) {
                    return Vod.c(strArrSplit2, strArrSplit, i);
                }
            }).mapToObj(new IntFunction() { // from class: w55
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.IntFunction
                public final Object apply(int i) {
                    return Flag.create(strArrSplit2[i].trim(), strArrSplit[i]);
                }
            });
            final List<Flag> flags = getFlags();
            Objects.requireNonNull(flags);
            streamMapToObj.forEach(new Consumer() { // from class: x55
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    flags.add((Flag) obj);
                }
            });
            return this;
        }
        for (Flag flag : getFlags()) {
            flag.setEpisodes(flag.getUrls());
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setId(String str) {
        this.vodId = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setName(String str) {
        this.vodName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPic(String str) {
        this.vodPic = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPlayFrom(String str) {
        this.vodPlayFrom = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPlayUrl(String str) {
        this.vodPlayUrl = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSite(Site site) {
        this.site = site;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return App.c().toJson(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Vod trans() {
        if (!Trans.pass()) {
            this.vodName = Trans.s2t(this.vodName);
            this.vodArea = Trans.s2t(this.vodArea);
            this.typeName = Trans.s2t(this.typeName);
            String str = this.vodActor;
            if (str != null) {
                boolean zFind = u94.a.matcher(str).find();
                String strS2t = this.vodActor;
                if (!zFind) {
                    strS2t = Trans.s2t(strS2t);
                }
                this.vodActor = strS2t;
            }
            String str2 = this.vodRemarks;
            if (str2 != null) {
                boolean zFind2 = u94.a.matcher(str2).find();
                String strS2t2 = this.vodRemarks;
                if (!zFind2) {
                    strS2t2 = Trans.s2t(strS2t2);
                }
                this.vodRemarks = strS2t2;
            }
            String str3 = this.vodContent;
            if (str3 != null) {
                boolean zFind3 = u94.a.matcher(str3).find();
                String strS2t3 = this.vodContent;
                if (!zFind3) {
                    strS2t3 = Trans.s2t(strS2t3);
                }
                this.vodContent = strS2t3;
            }
            String str4 = this.vodDirector;
            if (str4 != null) {
                boolean zFind4 = u94.a.matcher(str4).find();
                String strS2t4 = this.vodDirector;
                if (!zFind4) {
                    strS2t4 = Trans.s2t(strS2t4);
                }
                this.vodDirector = strS2t4;
            }
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.vodId);
        parcel.writeString(this.vodName);
        parcel.writeString(this.typeName);
        parcel.writeString(this.vodPic);
        parcel.writeString(this.vodRemarks);
        parcel.writeString(this.vodYear);
        parcel.writeString(this.vodArea);
        parcel.writeString(this.vodDirector);
        parcel.writeString(this.vodActor);
        parcel.writeString(this.vodContent);
        parcel.writeString(this.vodPlayFrom);
        parcel.writeString(this.vodPlayUrl);
        parcel.writeString(this.vodTag);
        parcel.writeString(this.action);
        parcel.writeValue(this.land);
        parcel.writeValue(this.circle);
        parcel.writeValue(this.ratio);
        parcel.writeParcelable(this.cate, i);
        parcel.writeParcelable(this.style, i);
        parcel.writeTypedList(this.vodFlags);
        parcel.writeParcelable(this.site, i);
    }

    /* JADX DEBUG: Method merged with bridge method: isSameItem(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameItem(Vod vod) {
        return equals(vod);
    }

    public Style getStyle(Style style) {
        return getStyle() != null ? getStyle() : style != null ? style : Style.rect();
    }

    public void setFlags(List<Flag> list) {
        this.vodFlags = list;
    }

    public Vod() {
    }
}
