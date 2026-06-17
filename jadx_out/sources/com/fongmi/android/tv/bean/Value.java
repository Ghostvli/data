package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import defpackage.nl0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Value implements Parcelable, nl0 {
    public static final Parcelable.Creator<Value> CREATOR = new Parcelable.Creator<Value>() { // from class: com.fongmi.android.tv.bean.Value.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Value createFromParcel(Parcel parcel) {
            return new Value(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Value[] newArray(int i) {
            return new Value[i];
        }
    };
    private transient boolean activated;

    @SerializedName("n")
    private String n;

    @SerializedName("v")
    private String v;

    public Value(Parcel parcel) {
        this.n = parcel.readString();
        this.v = parcel.readString();
        this.activated = parcel.readByte() != 0;
    }

    public static Value create(String str, String str2) {
        return new Value(str, str2).trans();
    }

    public Value copy() {
        Value value = new Value(this.n, this.v);
        value.activated = this.activated;
        return value;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Value) {
            return Objects.equals(getV(), ((Value) obj).getV());
        }
        return false;
    }

    public String getN() {
        return TextUtils.isEmpty(this.n) ? "" : this.n;
    }

    public String getV() {
        return TextUtils.isEmpty(this.v) ? "" : this.v;
    }

    public int hashCode() {
        return Objects.hash(getV());
    }

    public boolean isActivated() {
        return this.activated;
    }

    public void setActivated(Value value) {
        boolean zEquals = value.equals(this);
        if (this.activated && zEquals) {
            this.activated = false;
        } else {
            this.activated = zEquals;
        }
    }

    public void setV(String str) {
        this.v = str;
    }

    public Value trans() {
        this.n = Trans.s2t(this.n);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.n);
        parcel.writeString(this.v);
        parcel.writeByte(this.activated ? (byte) 1 : (byte) 0);
    }

    @Override // defpackage.nl0
    public boolean isSameContent(Value value) {
        return equals(value);
    }

    @Override // defpackage.nl0
    public boolean isSameItem(Value value) {
        return equals(value);
    }

    public static Value create(String str) {
        return new Value(str);
    }

    public void setActivated(boolean z) {
        this.activated = z;
    }

    private Value(String str, String str2) {
        this.n = str;
        this.v = str2;
    }

    private Value(String str) {
        this.v = str;
    }
}
