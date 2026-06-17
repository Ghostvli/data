package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bf4 implements Comparable, Parcelable {
    public static final Parcelable.Creator<bf4> CREATOR = new a();
    public static final String i = fy4.N0(0);
    public static final String j = fy4.N0(1);
    public static final String k = fy4.N0(2);
    public final int f;
    public final int g;
    public final int h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bf4 createFromParcel(Parcel parcel) {
            return new bf4(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public bf4[] newArray(int i) {
            return new bf4[i];
        }
    }

    public bf4(Parcel parcel) {
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
    }

    public static bf4 w(Bundle bundle) {
        return new bf4(bundle.getInt(i, 0), bundle.getInt(j, 0), bundle.getInt(k, 0));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && bf4.class == obj.getClass()) {
            bf4 bf4Var = (bf4) obj;
            if (this.f == bf4Var.f && this.g == bf4Var.g && this.h == bf4Var.h) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f * 31) + this.g) * 31) + this.h;
    }

    public String toString() {
        return this.f + "." + this.g + "." + this.h;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int compareTo(bf4 bf4Var) {
        int i2 = this.f - bf4Var.f;
        return (i2 == 0 && (i2 = this.g - bf4Var.g) == 0) ? this.h - bf4Var.h : i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
    }

    public Bundle x() {
        Bundle bundle = new Bundle();
        int i2 = this.f;
        if (i2 != 0) {
            bundle.putInt(i, i2);
        }
        int i3 = this.g;
        if (i3 != 0) {
            bundle.putInt(j, i3);
        }
        int i4 = this.h;
        if (i4 != 0) {
            bundle.putInt(k, i4);
        }
        return bundle;
    }

    public bf4(int i2, int i3, int i4) {
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }
}
