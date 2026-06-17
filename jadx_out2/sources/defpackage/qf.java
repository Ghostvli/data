package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.g;
import defpackage.d71;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qf implements Parcelable {
    public static final Parcelable.Creator<qf> CREATOR = new a();
    public final int[] f;
    public final ArrayList g;
    public final int[] h;
    public final int[] i;
    public final int j;
    public final String k;
    public final int l;
    public final int m;
    public final CharSequence n;
    public final int o;
    public final CharSequence p;
    public final ArrayList q;
    public final ArrayList r;
    public final boolean s;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public qf createFromParcel(Parcel parcel) {
            return new qf(parcel);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public qf[] newArray(int i) {
            return new qf[i];
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qf(pf pfVar) {
        int size = pfVar.c.size();
        this.f = new int[size * 6];
        if (!pfVar.i) {
            e04.a("Not on back stack");
            throw null;
        }
        this.g = new ArrayList(size);
        this.h = new int[size];
        this.i = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            d71.a aVar = (d71.a) pfVar.c.get(i2);
            int i3 = i + 1;
            this.f[i] = aVar.a;
            ArrayList arrayList = this.g;
            p51 p51Var = aVar.b;
            arrayList.add(p51Var != null ? p51Var.k : null);
            int[] iArr = this.f;
            iArr[i3] = aVar.c ? 1 : 0;
            iArr[i + 2] = aVar.d;
            iArr[i + 3] = aVar.e;
            int i4 = i + 5;
            iArr[i + 4] = aVar.f;
            i += 6;
            iArr[i4] = aVar.g;
            this.h[i2] = aVar.h.ordinal();
            this.i[i2] = aVar.i.ordinal();
        }
        this.j = pfVar.h;
        this.k = pfVar.k;
        this.l = pfVar.v;
        this.m = pfVar.l;
        this.n = pfVar.m;
        this.o = pfVar.n;
        this.p = pfVar.o;
        this.q = pfVar.p;
        this.r = pfVar.q;
        this.s = pfVar.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(pf pfVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= this.f.length) {
                pfVar.h = this.j;
                pfVar.k = this.k;
                pfVar.i = true;
                pfVar.l = this.m;
                pfVar.m = this.n;
                pfVar.n = this.o;
                pfVar.o = this.p;
                pfVar.p = this.q;
                pfVar.q = this.r;
                pfVar.r = this.s;
                return;
            }
            d71.a aVar = new d71.a();
            int i3 = i + 1;
            aVar.a = this.f[i];
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Instantiate " + pfVar + " op #" + i2 + " base fragment #" + this.f[i3]);
            }
            aVar.h = g.b.values()[this.h[i2]];
            aVar.i = g.b.values()[this.i[i2]];
            int[] iArr = this.f;
            int i4 = i + 2;
            if (iArr[i3] == 0) {
                z = false;
            }
            aVar.c = z;
            int i5 = iArr[i4];
            aVar.d = i5;
            int i6 = iArr[i + 3];
            aVar.e = i6;
            int i7 = i + 5;
            int i8 = iArr[i + 4];
            aVar.f = i8;
            i += 6;
            int i9 = iArr[i7];
            aVar.g = i9;
            pfVar.d = i5;
            pfVar.e = i6;
            pfVar.f = i8;
            pfVar.g = i9;
            pfVar.f(aVar);
            i2++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pf d(k61 k61Var) {
        pf pfVar = new pf(k61Var);
        c(pfVar);
        pfVar.v = this.l;
        for (int i = 0; i < this.g.size(); i++) {
            String str = (String) this.g.get(i);
            if (str != null) {
                ((d71.a) pfVar.c.get(i)).b = k61Var.g0(str);
            }
        }
        pfVar.x(1);
        return pfVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f);
        parcel.writeStringList(this.g);
        parcel.writeIntArray(this.h);
        parcel.writeIntArray(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        TextUtils.writeToParcel(this.n, parcel, 0);
        parcel.writeInt(this.o);
        TextUtils.writeToParcel(this.p, parcel, 0);
        parcel.writeStringList(this.q);
        parcel.writeStringList(this.r);
        parcel.writeInt(this.s ? 1 : 0);
    }

    public qf(Parcel parcel) {
        this.f = parcel.createIntArray();
        this.g = parcel.createStringArrayList();
        this.h = parcel.createIntArray();
        this.i = parcel.createIntArray();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.n = (CharSequence) creator.createFromParcel(parcel);
        this.o = parcel.readInt();
        this.p = (CharSequence) creator.createFromParcel(parcel);
        this.q = parcel.createStringArrayList();
        this.r = parcel.createStringArrayList();
        this.s = parcel.readInt() != 0;
    }
}
