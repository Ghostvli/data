package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.k61;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class m61 implements Parcelable {
    public static final Parcelable.Creator<m61> CREATOR = new a();
    public ArrayList f;
    public ArrayList g;
    public qf[] h;
    public int i;
    public String j;
    public ArrayList k;
    public ArrayList l;
    public ArrayList m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m61 createFromParcel(Parcel parcel) {
            return new m61(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m61[] newArray(int i) {
            return new m61[i];
        }
    }

    public m61(Parcel parcel) {
        this.j = null;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.f = parcel.createStringArrayList();
        this.g = parcel.createStringArrayList();
        this.h = (qf[]) parcel.createTypedArray(qf.CREATOR);
        this.i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.createStringArrayList();
        this.l = parcel.createTypedArrayList(rf.CREATOR);
        this.m = parcel.createTypedArrayList(k61.m.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f);
        parcel.writeStringList(this.g);
        parcel.writeTypedArray(this.h, i);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeStringList(this.k);
        parcel.writeTypedList(this.l);
        parcel.writeTypedList(this.m);
    }

    public m61() {
        this.j = null;
        this.k = new ArrayList();
        this.l = new ArrayList();
    }
}
