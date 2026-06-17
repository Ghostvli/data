package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import defpackage.oh1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mt3 implements Parcelable {
    public static final Parcelable.Creator<mt3> CREATOR = new a();
    public final boolean f = false;
    public final Handler g = null;
    public oh1 h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public mt3 createFromParcel(Parcel parcel) {
            return new mt3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public mt3[] newArray(int i) {
            return new mt3[i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends oh1.a {
        public b() {
        }

        @Override // defpackage.oh1
        public void Y0(int i, Bundle bundle) {
            mt3 mt3Var = mt3.this;
            Handler handler = mt3Var.g;
            if (handler != null) {
                handler.post(mt3Var.new c(i, bundle));
            } else {
                mt3Var.c(i, bundle);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        public final int f;
        public final Bundle g;

        public c(int i, Bundle bundle) {
            this.f = i;
            this.g = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            mt3.this.c(this.f, this.g);
        }
    }

    public mt3(Parcel parcel) {
        this.h = oh1.a.Z0(parcel.readStrongBinder());
    }

    public void c(int i, Bundle bundle) {
    }

    public void d(int i, Bundle bundle) {
        if (this.f) {
            Handler handler = this.g;
            if (handler != null) {
                handler.post(new c(i, bundle));
                return;
            } else {
                c(i, bundle);
                return;
            }
        }
        oh1 oh1Var = this.h;
        if (oh1Var != null) {
            try {
                oh1Var.Y0(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.h == null) {
                    this.h = new b();
                }
                parcel.writeStrongBinder(this.h.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
