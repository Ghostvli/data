package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class oo0 implements Comparator, Parcelable {
    public static final Parcelable.Creator<oo0> CREATOR = new a();
    public final b[] f;
    public int g;
    public final String h;
    public final int i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public oo0 createFromParcel(Parcel parcel) {
            return new oo0(parcel);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public oo0[] newArray(int i) {
            return new oo0[i];
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public oo0(Parcel parcel) {
        this.h = parcel.readString();
        b[] bVarArr = (b[]) fy4.l((b[]) parcel.createTypedArray(b.CREATOR));
        this.f = bVarArr;
        this.i = bVarArr.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean d(ArrayList arrayList, int i, UUID uuid) {
        for (int i2 = 0; i2 < i; i2++) {
            if (((b) arrayList.get(i2)).g.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static oo0 u(oo0 oo0Var, oo0 oo0Var2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (oo0Var != null) {
            str = oo0Var.h;
            for (b bVar : oo0Var.f) {
                if (bVar.s()) {
                    arrayList.add(bVar);
                }
            }
        } else {
            str = null;
        }
        if (oo0Var2 != null) {
            if (str == null) {
                str = oo0Var2.h;
            }
            int size = arrayList.size();
            for (b bVar2 : oo0Var2.f) {
                if (bVar2.s() && !d(arrayList, size, bVar2.g)) {
                    arrayList.add(bVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new oo0(str, arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compare(Ljava/lang/Object;Ljava/lang/Object;)I */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        UUID uuid = kn.b;
        return uuid.equals(bVar.g) ? uuid.equals(bVar2.g) ? 0 : 1 : bVar.g.compareTo(bVar2.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && oo0.class == obj.getClass()) {
            oo0 oo0Var = (oo0) obj;
            if (Objects.equals(this.h, oo0Var.h) && Arrays.equals(this.f, oo0Var.f)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        if (this.g == 0) {
            String str = this.h;
            this.g = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f);
        }
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public oo0 s(String str) {
        return Objects.equals(this.h, str) ? this : new oo0(str, false, this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b v(int i) {
        return this.f[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public oo0 w(oo0 oo0Var) {
        String str;
        String str2 = this.h;
        gg3.v(str2 == null || (str = oo0Var.h) == null || TextUtils.equals(str2, str));
        String str3 = this.h;
        if (str3 == null) {
            str3 = oo0Var.h;
        }
        return new oo0(str3, (b[]) fy4.h1(this.f, oo0Var.f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.h);
        parcel.writeTypedArray(this.f, 0);
    }

    public oo0(String str, List list) {
        this(str, false, (b[]) list.toArray(new b[0]));
    }

    public oo0(b... bVarArr) {
        this((String) null, bVarArr);
    }

    public oo0(String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    public oo0(String str, boolean z, b... bVarArr) {
        this.h = str;
        bVarArr = z ? (b[]) bVarArr.clone() : bVarArr;
        this.f = bVarArr;
        this.i = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    public oo0(List list) {
        this(null, false, (b[]) list.toArray(new b[0]));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public int f;
        public final UUID g;
        public final String h;
        public final String i;
        public final byte[] j;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Parcel parcel) {
            this.g = new UUID(parcel.readLong(), parcel.readLong());
            this.h = parcel.readString();
            this.i = (String) fy4.l(parcel.readString());
            this.j = parcel.createByteArray();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c(b bVar) {
            return s() && !bVar.s() && u(bVar.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(byte[] bArr) {
            return new b(this.g, this.h, this.i, bArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return Objects.equals(this.h, bVar.h) && Objects.equals(this.i, bVar.i) && Objects.equals(this.g, bVar.g) && Arrays.equals(this.j, bVar.j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            if (this.f == 0) {
                int iHashCode = this.g.hashCode() * 31;
                String str = this.h;
                this.f = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.i.hashCode()) * 31) + Arrays.hashCode(this.j);
            }
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean s() {
            return this.j != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean u(UUID uuid) {
            return kn.b.equals(this.g) || uuid.equals(this.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.g.getMostSignificantBits());
            parcel.writeLong(this.g.getLeastSignificantBits());
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeByteArray(this.j);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this.g = (UUID) gg3.q(uuid);
            this.h = str;
            this.i = nt2.u((String) gg3.q(str2));
            this.j = bArr;
        }

        public b(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }
    }
}
