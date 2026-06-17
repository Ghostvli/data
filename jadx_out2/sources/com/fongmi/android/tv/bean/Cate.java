package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Cate implements Parcelable {
    public static final Parcelable.Creator<Cate> CREATOR = new Parcelable.Creator<Cate>() { // from class: com.fongmi.android.tv.bean.Cate.1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Cate createFromParcel(Parcel parcel) {
            return new Cate(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Cate[] newArray(int i) {
            return new Cate[i];
        }
    };

    @SerializedName("circle")
    private Integer circle;

    @SerializedName("land")
    private Integer land;

    @SerializedName("ratio")
    private Float ratio;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Cate(Parcel parcel) {
        this.land = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.circle = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.ratio = (Float) parcel.readValue(Float.class.getClassLoader());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
    public int getLand() {
        Integer num = this.land;
        if (num == null) {
            return 0;
        }
        return num.intValue();
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
    public Style getStyle() {
        return Style.get(getLand(), getCircle(), getRatio());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.land);
        parcel.writeValue(this.circle);
        parcel.writeValue(this.ratio);
    }
}
