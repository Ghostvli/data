package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import defpackage.nl0;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
@Root(strict = false)
public class Class implements Parcelable, nl0 {
    public static final Parcelable.Creator<Class> CREATOR = new Parcelable.Creator<Class>() { // from class: com.fongmi.android.tv.bean.Class.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Class createFromParcel(Parcel parcel) {
            return new Class(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Class[] newArray(int i) {
            return new Class[i];
        }
    };
    private boolean activated;

    @SerializedName("circle")
    private Integer circle;
    private boolean filter;

    @SerializedName("filters")
    private List<Filter> filters;

    @SerializedName("land")
    private Integer land;

    @SerializedName("ratio")
    private Float ratio;

    @SerializedName("type_flag")
    private String typeFlag;

    @SerializedName(alternate = {Name.MARK}, value = "type_id")
    @Attribute(name = Name.MARK, required = false)
    private String typeId;

    @SerializedName(alternate = {"name"}, value = "type_name")
    @Text
    private String typeName;

    public Class(Parcel parcel) {
        this.typeId = parcel.readString();
        this.typeName = parcel.readString();
        this.typeFlag = parcel.readString();
        this.filter = parcel.readByte() != 0;
        this.land = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.circle = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.ratio = (Float) parcel.readValue(Float.class.getClassLoader());
        this.activated = parcel.readByte() != 0;
    }

    public static Class objectFrom(String str) {
        return (Class) App.c().fromJson(str, Class.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Class) {
            return Objects.equals(getTypeId(), ((Class) obj).getTypeId());
        }
        return false;
    }

    public int getCircle() {
        Integer num = this.circle;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getFilter() {
        return this.filter;
    }

    public List<Filter> getFilters() {
        List<Filter> list = this.filters;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public int getLand() {
        Integer num = this.land;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public float getRatio() {
        Float f = this.ratio;
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public Style getStyle() {
        return Style.get(getLand(), getCircle(), getRatio());
    }

    public String getTypeFlag() {
        return TextUtils.isEmpty(this.typeFlag) ? "" : this.typeFlag;
    }

    public String getTypeId() {
        return TextUtils.isEmpty(this.typeId) ? "" : this.typeId;
    }

    public String getTypeName() {
        return TextUtils.isEmpty(this.typeName) ? "" : this.typeName;
    }

    public int hashCode() {
        return Objects.hash(getTypeId());
    }

    public boolean isActivated() {
        return this.activated;
    }

    public boolean isFolder() {
        return "1".equals(getTypeFlag());
    }

    public boolean isHome() {
        return "home".equals(getTypeId());
    }

    @Override // defpackage.nl0
    public boolean isSameContent(Class r3) {
        return getTypeName().equals(r3.getTypeName()) && getTypeFlag().equals(r3.getTypeFlag());
    }

    public void setActivated(boolean z) {
        this.activated = z;
    }

    public void setFilter(boolean z) {
        this.filter = z;
    }

    public void setFilters(List<Filter> list) {
        this.filters = list;
    }

    public void setTypeFlag(String str) {
        this.typeFlag = str;
    }

    public void setTypeId(String str) {
        this.typeId = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void trans() {
        if (Trans.pass()) {
            return;
        }
        this.typeName = Trans.s2t(this.typeName);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.typeId);
        parcel.writeString(this.typeName);
        parcel.writeString(this.typeFlag);
        parcel.writeByte(this.filter ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.land);
        parcel.writeValue(this.circle);
        parcel.writeValue(this.ratio);
        parcel.writeByte(this.activated ? (byte) 1 : (byte) 0);
    }

    @Override // defpackage.nl0
    public boolean isSameItem(Class r1) {
        return equals(r1);
    }

    public Class() {
    }
}
