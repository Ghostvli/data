package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import defpackage.fg2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class x3 {
    public static final x3 g = new x3(null, new a[0], 0, -9223372036854775807L, 0);
    public static final a h = new a(0).o(0);
    public static final String i = fy4.N0(1);
    public static final String j = fy4.N0(2);
    public static final String k = fy4.N0(3);
    public static final String l = fy4.N0(4);
    public final Object a;
    public final int b;
    public final long c;
    public final long d;
    public final int e;
    public final a[] f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final String d = fy4.N0(0);
        public static final String e = fy4.N0(1);
        public static final String f = fy4.N0(2);
        public final long a;
        public final long b;
        public final String c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(long j, long j2, String str) {
            gg3.d((j == -9223372036854775807L && j2 == -9223372036854775807L && str == null) ? false : true);
            this.a = j == -9223372036854775807L ? 0L : j;
            this.b = j2;
            this.c = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static b a(Bundle bundle) {
            return new b(bundle.getLong(d), bundle.getLong(e), bundle.getString(f));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putLong(d, this.a);
            bundle.putLong(e, this.b);
            bundle.putString(f, this.c);
            return bundle;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (this.a == bVar.a && this.b == bVar.b && Objects.equals(this.c, bVar.c)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return Objects.hash(Long.valueOf(this.a), Long.valueOf(this.b), this.c);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x3(Object obj, a[] aVarArr, long j2, long j3, int i2) {
        this.a = obj;
        this.c = j2;
        this.d = j3;
        this.b = aVarArr.length + i2;
        this.f = aVarArr;
        this.e = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static x3 a(Bundle bundle, int i2) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(i);
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i3 = 0; i3 < parcelableArrayList.size(); i3++) {
                aVarArr2[i3] = a.d((Bundle) parcelableArrayList.get(i3), i2);
            }
            aVarArr = aVarArr2;
        }
        String str = j;
        x3 x3Var = g;
        return new x3(null, aVarArr, bundle.getLong(str, x3Var.c), bundle.getLong(k, x3Var.d), bundle.getInt(l, x3Var.e));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a b(int i2) {
        int i3 = this.e;
        return i2 < i3 ? h : this.f[i2 - i3];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c(long j2, long j3) {
        if (j2 != Long.MIN_VALUE && (j3 == -9223372036854775807L || j2 < j3)) {
            int i2 = this.e;
            while (i2 < this.b && ((b(i2).a != Long.MIN_VALUE && b(i2).a <= j2) || !b(i2).m())) {
                i2++;
            }
            if (i2 < this.b && (j3 == -9223372036854775807L || b(i2).a <= j3)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int d(long j2, long j3) {
        x3 x3Var;
        int i2 = this.b - 1;
        int i3 = i2 - (e(i2) ? 1 : 0);
        while (true) {
            x3Var = this;
            if (i3 < 0) {
                break;
            }
            long j4 = j2;
            long j5 = j3;
            if (!x3Var.f(j4, j5, i3)) {
                break;
            }
            i3--;
            this = x3Var;
            j2 = j4;
            j3 = j5;
        }
        if (i3 < 0 || !x3Var.b(i3).k()) {
            return -1;
        }
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e(int i2) {
        return i2 == this.b - 1 && b(i2).l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && x3.class == obj.getClass()) {
            x3 x3Var = (x3) obj;
            if (Objects.equals(this.a, x3Var.a) && this.b == x3Var.b && this.c == x3Var.c && this.d == x3Var.d && this.e == x3Var.e && Arrays.equals(this.f, x3Var.f)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean f(long j2, long j3, int i2) {
        if (j2 == Long.MIN_VALUE) {
            return false;
        }
        a aVarB = b(i2);
        long j4 = aVarB.a;
        return j4 == Long.MIN_VALUE ? j3 == -9223372036854775807L || aVarB.l() || j2 < j3 : j2 < j4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle g(int i2) {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (a aVar : this.f) {
            arrayList.add(aVar.n(i2));
        }
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArrayList(i, arrayList);
        }
        long j2 = this.c;
        x3 x3Var = g;
        if (j2 != x3Var.c) {
            bundle.putLong(j, j2);
        }
        long j3 = this.d;
        if (j3 != x3Var.d) {
            bundle.putLong(k, j3);
        }
        int i3 = this.e;
        if (i3 != x3Var.e) {
            bundle.putInt(l, i3);
        }
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        int i2 = this.b * 31;
        Object obj = this.a;
        return ((((((((i2 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + this.e) * 31) + Arrays.hashCode(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=");
        sb.append(this.a);
        sb.append(", adResumePositionUs=");
        sb.append(this.c);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.f.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f[i2].a);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < this.f[i2].f.length; i3++) {
                sb.append("ad(state=");
                int i4 = this.f[i2].f[i3];
                if (i4 == 0) {
                    sb.append('_');
                } else if (i4 == 1) {
                    sb.append('R');
                } else if (i4 == 2) {
                    sb.append('S');
                } else if (i4 == 3) {
                    sb.append('P');
                } else if (i4 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f[i2].g[i3]);
                sb.append(')');
                if (i3 < this.f[i2].f.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final String m = fy4.N0(0);
        public static final String n = fy4.N0(1);
        public static final String o = fy4.N0(2);
        public static final String p = fy4.N0(3);
        public static final String q = fy4.N0(4);
        public static final String r = fy4.N0(5);
        public static final String s = fy4.N0(6);
        public static final String t = fy4.N0(7);
        public static final String u = fy4.N0(8);
        public static final String v = fy4.N0(9);
        public static final String w = fy4.N0(10);
        public static final String x = fy4.N0(11);
        public final long a;
        public final int b;
        public final int c;
        public final Uri[] d;
        public final fg2[] e;
        public final int[] f;
        public final long[] g;
        public final String[] h;
        public final b[] i;
        public final long j;
        public final boolean k;
        public final boolean l;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(long j, int i, int i2, int[] iArr, fg2[] fg2VarArr, long[] jArr, long j2, boolean z, String[] strArr, b[] bVarArr, boolean z2) {
            int i3 = 0;
            gg3.d(iArr.length == fg2VarArr.length);
            gg3.d(iArr.length == bVarArr.length);
            this.a = j;
            this.b = i;
            this.c = i2;
            this.f = iArr;
            this.e = fg2VarArr;
            this.g = jArr;
            this.j = j2;
            this.k = z;
            this.d = new Uri[fg2VarArr.length];
            while (true) {
                Uri[] uriArr = this.d;
                if (i3 >= uriArr.length) {
                    this.h = strArr;
                    this.i = bVarArr;
                    this.l = z2;
                    return;
                } else {
                    fg2 fg2Var = fg2VarArr[i3];
                    uriArr[i3] = fg2Var == null ? null : ((fg2.h) gg3.q(fg2Var.b)).a;
                    i3++;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static long[] a(long[] jArr, int i) {
            int length = jArr.length;
            int iMax = Math.max(i, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static b[] b(b[] bVarArr, int i) {
            return (b[]) Arrays.copyOf(bVarArr, Math.max(i, bVarArr.length));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int[] c(int[] iArr, int i) {
            int length = iArr.length;
            int iMax = Math.max(i, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a d(Bundle bundle, int i) {
            long j = bundle.getLong(m);
            int i2 = bundle.getInt(n);
            int i3 = bundle.getInt(t);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(o);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(u);
            int[] intArray = bundle.getIntArray(p);
            long[] longArray = bundle.getLongArray(q);
            long j2 = bundle.getLong(r);
            boolean z = bundle.getBoolean(s);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(v);
            ArrayList parcelableArrayList3 = bundle.getParcelableArrayList(x);
            boolean z2 = bundle.getBoolean(w);
            if (intArray == null) {
                intArray = new int[0];
            }
            fg2[] fg2VarArrG = g(parcelableArrayList2, parcelableArrayList, i);
            if (longArray == null) {
                longArray = new long[0];
            }
            return new a(j, i2, i3, intArray, fg2VarArrG, longArray, j2, z, stringArrayList == null ? new String[0] : (String[]) stringArrayList.toArray(new String[0]), parcelableArrayList3 == null ? new b[0] : j(parcelableArrayList3), z2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static fg2[] g(ArrayList arrayList, ArrayList arrayList2, int i) {
            int i2 = 0;
            if (arrayList != null) {
                fg2[] fg2VarArr = new fg2[arrayList.size()];
                while (i2 < arrayList.size()) {
                    Bundle bundle = (Bundle) arrayList.get(i2);
                    fg2VarArr[i2] = bundle == null ? null : fg2.b(bundle, i);
                    i2++;
                }
                return fg2VarArr;
            }
            if (arrayList2 == null) {
                return new fg2[0];
            }
            fg2[] fg2VarArr2 = new fg2[arrayList2.size()];
            while (i2 < arrayList2.size()) {
                Uri uri = (Uri) arrayList2.get(i2);
                fg2VarArr2[i2] = uri == null ? null : fg2.c(uri);
                i2++;
            }
            return fg2VarArr2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static b[] j(List list) {
            b[] bVarArr = new b[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Bundle bundle = (Bundle) list.get(i);
                bVarArr[i] = bundle == null ? null : b.a(bundle);
            }
            return bVarArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int e() {
            return h(-1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && Arrays.equals(this.e, aVar.e) && Arrays.equals(this.f, aVar.f) && Arrays.equals(this.g, aVar.g) && this.j == aVar.j && this.k == aVar.k && Arrays.equals(this.h, aVar.h) && Arrays.equals(this.i, aVar.i) && this.l == aVar.l) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ArrayList f(int i) {
            ArrayList arrayList = new ArrayList();
            fg2[] fg2VarArr = this.e;
            int length = fg2VarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                fg2 fg2Var = fg2VarArr[i2];
                arrayList.add(fg2Var == null ? null : fg2Var.g(i));
            }
            return arrayList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int h(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.f;
                if (i3 >= iArr.length || this.k || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            int i = ((this.b * 31) + this.c) * 31;
            long j = this.a;
            int iHashCode = (((((((i + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f)) * 31) + Arrays.hashCode(this.g)) * 31;
            long j2 = this.j;
            return ((((((((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.k ? 1 : 0)) * 31) + Arrays.hashCode(this.h)) * 31) + Arrays.hashCode(this.i)) * 31) + (this.l ? 1 : 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ArrayList i() {
            ArrayList arrayList = new ArrayList();
            b[] bVarArr = this.i;
            int length = bVarArr.length;
            for (int i = 0; i < length; i++) {
                b bVar = bVarArr[i];
                arrayList.add(bVar == null ? null : bVar.b());
            }
            return arrayList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean k() {
            if (this.b == -1) {
                return true;
            }
            for (int i = 0; i < this.b; i++) {
                int i2 = this.f[i];
                if (i2 == 0 || i2 == 1) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean l() {
            return this.l && this.a == Long.MIN_VALUE && this.b == -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean m() {
            return this.b == -1 || e() < this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Bundle n(int i) {
            Bundle bundle = new Bundle();
            bundle.putLong(m, this.a);
            bundle.putInt(n, this.b);
            bundle.putInt(t, this.c);
            bundle.putParcelableArrayList(o, new ArrayList<>(Arrays.asList(this.d)));
            bundle.putParcelableArrayList(u, f(i));
            bundle.putIntArray(p, this.f);
            bundle.putLongArray(q, this.g);
            bundle.putLong(r, this.j);
            bundle.putBoolean(s, this.k);
            bundle.putStringArrayList(v, new ArrayList<>(Arrays.asList(this.h)));
            bundle.putParcelableArrayList(x, i());
            bundle.putBoolean(w, this.l);
            return bundle;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a o(int i) {
            int[] iArrC = c(this.f, i);
            long[] jArrA = a(this.g, i);
            return new a(this.a, i, this.c, iArrC, (fg2[]) Arrays.copyOf(this.e, i), jArrA, this.j, this.k, (String[]) Arrays.copyOf(this.h, i), b(this.i, i), this.l);
        }

        public a(long j) {
            this(j, -1, -1, new int[0], new fg2[0], new long[0], 0L, false, new String[0], new b[0], false);
        }
    }
}
