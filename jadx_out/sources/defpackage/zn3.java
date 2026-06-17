package defpackage;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zn3 implements Parcelable {
    public static final Parcelable.Creator<zn3> CREATOR = new a();
    public final int f;
    public final float g;
    public Object h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zn3 createFromParcel(Parcel parcel) {
            return new zn3(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public zn3[] newArray(int i) {
            return new zn3[i];
        }
    }

    public zn3(int i, float f) {
        this.f = i;
        this.g = f;
    }

    public static zn3 A(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new zn3(6, f);
        }
        xz1.d("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static zn3 B(int i, float f) {
        float f2;
        if (i == 3) {
            f2 = 3.0f;
        } else if (i == 4) {
            f2 = 4.0f;
        } else {
            if (i != 5) {
                xz1.d("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
            }
            f2 = 5.0f;
        }
        if (f >= 0.0f && f <= f2) {
            return new zn3(i, f);
        }
        xz1.d("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static zn3 C(boolean z) {
        return new zn3(2, z ? 1.0f : 0.0f);
    }

    public static zn3 D(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new zn3(i, -1.0f);
            default:
                return null;
        }
    }

    public static zn3 c(Object obj) {
        zn3 zn3VarD = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        zn3VarD = z(rating.hasHeart());
                        break;
                    case 2:
                        zn3VarD = C(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        zn3VarD = B(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        zn3VarD = A(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                zn3VarD = D(ratingStyle);
            }
            ((zn3) gg3.q(zn3VarD)).h = obj;
        }
        return zn3VarD;
    }

    public static zn3 z(boolean z) {
        return new zn3(1, z ? 1.0f : 0.0f);
    }

    public float d() {
        if (this.f == 6 && x()) {
            return this.g;
        }
        return -1.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f;
    }

    public Object s() {
        if (this.h == null) {
            boolean zX = x();
            int i = this.f;
            if (zX) {
                switch (i) {
                    case 1:
                        this.h = Rating.newHeartRating(w());
                        break;
                    case 2:
                        this.h = Rating.newThumbRating(y());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.h = Rating.newStarRating(i, v());
                        break;
                    case 6:
                        this.h = Rating.newPercentageRating(d());
                        break;
                    default:
                        return null;
                }
            } else {
                this.h = Rating.newUnratedRating(i);
            }
        }
        return this.h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f);
        sb.append(" rating=");
        float f = this.g;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    public int u() {
        return this.f;
    }

    public float v() {
        int i = this.f;
        if ((i == 3 || i == 4 || i == 5) && x()) {
            return this.g;
        }
        return -1.0f;
    }

    public boolean w() {
        return this.f == 1 && this.g == 1.0f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeFloat(this.g);
    }

    public boolean x() {
        return this.g >= 0.0f;
    }

    public boolean y() {
        return this.f == 2 && this.g == 1.0f;
    }
}
