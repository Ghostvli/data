package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class k3 implements Parcelable {
    public static final Parcelable.Creator<k3> CREATOR = new a();
    public final int f;
    public final Intent g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k3 createFromParcel(Parcel parcel) {
            return new k3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k3[] newArray(int i) {
            return new k3[i];
        }
    }

    public k3(Parcel parcel) {
        this.f = parcel.readInt();
        this.g = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String s(int i) {
        return i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent c() {
        return this.g;
    }

    public int d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + s(this.f) + ", data=" + this.g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeInt(this.g == null ? 0 : 1);
        Intent intent = this.g;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    public k3(int i, Intent intent) {
        this.f = i;
        this.g = intent;
    }
}
