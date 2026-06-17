package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yk1 implements Parcelable {
    public final IntentSender f;
    public final Intent g;
    public final int h;
    public final int i;
    public static final c j = new c(null);
    public static final Parcelable.Creator<yk1> CREATOR = new b();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final IntentSender a;
        public Intent b;
        public int c;
        public int d;

        public a(IntentSender intentSender) {
            intentSender.getClass();
            this.a = intentSender;
        }

        public final yk1 a() {
            return new yk1(this.a, this.b, this.c, this.d);
        }

        public final a b(Intent intent) {
            this.b = intent;
            return this;
        }

        public final a c(int i, int i2) {
            this.d = i;
            this.c = i2;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public yk1 createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new yk1(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public yk1[] newArray(int i) {
            return new yk1[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public yk1(Parcel parcel) {
        parcel.getClass();
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        parcelable.getClass();
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    public final Intent c() {
        return this.g;
    }

    public final int d() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int s() {
        return this.i;
    }

    public final IntentSender u() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public /* synthetic */ c(we0 we0Var) {
            this();
        }

        public c() {
        }
    }

    public yk1(IntentSender intentSender, Intent intent, int i, int i2) {
        intentSender.getClass();
        this.f = intentSender;
        this.g = intent;
        this.h = i;
        this.i = i2;
    }
}
