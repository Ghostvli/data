package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Style implements Parcelable {
    public static final Parcelable.Creator<Style> CREATOR = new Parcelable.Creator<Style>() { // from class: com.fongmi.android.tv.bean.Style.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Style createFromParcel(Parcel parcel) {
            return new Style(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Style[] newArray(int i) {
            return new Style[i];
        }
    };

    @SerializedName("ratio")
    private float ratio;

    @SerializedName("type")
    private String type;

    public Style(Parcel parcel) {
        this.type = parcel.readString();
        this.ratio = parcel.readFloat();
    }

    public static Style get(int i, int i2, float f) {
        if (i == 1) {
            if (f == 0.0f) {
                f = 1.33f;
            }
            return new Style("rect", f);
        }
        if (i2 != 1) {
            return null;
        }
        if (f == 0.0f) {
            f = 1.0f;
        }
        return new Style("oval", f);
    }

    public static Style list() {
        return new Style("list");
    }

    public static Style rect() {
        return new Style("rect", 0.75f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Style) {
            Style style = (Style) obj;
            if (getType().equals(style.getType()) && getRatio() == style.getRatio()) {
                return true;
            }
        }
        return false;
    }

    public float getRatio() {
        float f = this.ratio;
        return f <= 0.0f ? isOval() ? 1.0f : 0.75f : Math.min(4.0f, f);
    }

    public String getType() {
        return TextUtils.isEmpty(this.type) ? "rect" : this.type;
    }

    public int getViewType() {
        String type = getType();
        type.getClass();
        if (type.equals("list")) {
            return 2;
        }
        return !type.equals("oval") ? 0 : 1;
    }

    public boolean isLand() {
        return isRect() && getRatio() > 1.0f;
    }

    public boolean isList() {
        return "list".equals(getType());
    }

    public boolean isOval() {
        return "oval".equals(getType());
    }

    public boolean isRect() {
        return "rect".equals(getType());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeFloat(this.ratio);
    }

    public Style(String str, float f) {
        this.type = str;
        this.ratio = f;
    }

    public Style(String str) {
        this.type = str;
    }
}
