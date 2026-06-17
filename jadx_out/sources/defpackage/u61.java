package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.g;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class u61 implements Parcelable {
    public static final Parcelable.Creator<u61> CREATOR = new a();
    public final String f;
    public final String g;
    public final boolean h;
    public final int i;
    public final int j;
    public final String k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final int p;
    public final String q;
    public final int r;
    public final boolean s;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u61 createFromParcel(Parcel parcel) {
            return new u61(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u61[] newArray(int i) {
            return new u61[i];
        }
    }

    public u61(Parcel parcel) {
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt() != 0;
        this.m = parcel.readInt() != 0;
        this.n = parcel.readInt() != 0;
        this.o = parcel.readInt() != 0;
        this.p = parcel.readInt();
        this.q = parcel.readString();
        this.r = parcel.readInt();
        this.s = parcel.readInt() != 0;
    }

    public p51 c(a61 a61Var, ClassLoader classLoader) {
        p51 p51VarA = a61Var.a(classLoader, this.f);
        p51VarA.k = this.g;
        p51VarA.t = this.h;
        p51VarA.v = true;
        p51VarA.C = this.i;
        p51VarA.D = this.j;
        p51VarA.E = this.k;
        p51VarA.H = this.l;
        p51VarA.r = this.m;
        p51VarA.G = this.n;
        p51VarA.F = this.o;
        p51VarA.X = g.b.values()[this.p];
        p51VarA.n = this.q;
        p51VarA.o = this.r;
        p51VarA.P = this.s;
        return p51VarA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f);
        sb.append(" (");
        sb.append(this.g);
        sb.append(")}:");
        if (this.h) {
            sb.append(" fromLayout");
        }
        if (this.j != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.j));
        }
        String str = this.k;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.k);
        }
        if (this.l) {
            sb.append(" retainInstance");
        }
        if (this.m) {
            sb.append(" removing");
        }
        if (this.n) {
            sb.append(" detached");
        }
        if (this.o) {
            sb.append(" hidden");
        }
        if (this.q != null) {
            sb.append(" targetWho=");
            sb.append(this.q);
            sb.append(" targetRequestCode=");
            sb.append(this.r);
        }
        if (this.s) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeInt(this.o ? 1 : 0);
        parcel.writeInt(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s ? 1 : 0);
    }

    public u61(p51 p51Var) {
        this.f = p51Var.getClass().getName();
        this.g = p51Var.k;
        this.h = p51Var.t;
        this.i = p51Var.C;
        this.j = p51Var.D;
        this.k = p51Var.E;
        this.l = p51Var.H;
        this.m = p51Var.r;
        this.n = p51Var.G;
        this.o = p51Var.F;
        this.p = p51Var.X.ordinal();
        this.q = p51Var.n;
        this.r = p51Var.o;
        this.s = p51Var.P;
    }
}
