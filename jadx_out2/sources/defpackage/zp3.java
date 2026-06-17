package defpackage;

import defpackage.zi1;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zp3 extends zi1 {
    public static final zi1 m = new zp3(null, new Object[0], 0);
    public final transient Object j;
    public final transient Object[] k;
    public final transient int l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends dj1 {
        public final transient zi1 h;
        public final transient Object[] i;
        public final transient int j;
        public final transient int k;

        /* JADX INFO: renamed from: zp3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0145a extends xi1 {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0145a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: get(I)Ljava/lang/Object; */
            @Override // java.util.List
            /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i) {
                gg3.o(i, a.this.k);
                int i2 = i * 2;
                Object obj = a.this.i[a.this.j + i2];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.i[i2 + (a.this.j ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.vi1
            public boolean g() {
                return true;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.k;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(zi1 zi1Var, Object[] objArr, int i, int i2) {
            this.h = zi1Var;
            this.i = objArr;
            this.j = i;
            this.k = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1
        public int c(Object[] objArr, int i) {
            return b().c(objArr, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null && value.equals(this.h.get(key))) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1
        public boolean g() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: iterator()Ljava/util/Iterator; */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public pw4 iterator() {
            return b().iterator();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.dj1
        public xi1 r() {
            return new C0145a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.k;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends dj1 {
        public final transient zi1 h;
        public final transient xi1 i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(zi1 zi1Var, xi1 xi1Var) {
            this.h = zi1Var;
            this.i = xi1Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.dj1, defpackage.vi1
        public xi1 b() {
            return this.i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1
        public int c(Object[] objArr, int i) {
            return b().c(objArr, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.h.get(obj) != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1
        public boolean g() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: iterator()Ljava/util/Iterator; */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public pw4 iterator() {
            return b().iterator();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.h.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends xi1 {
        public final transient Object[] h;
        public final transient int i;
        public final transient int j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Object[] objArr, int i, int i2) {
            this.h = objArr;
            this.i = i;
            this.j = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1
        public boolean g() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.List
        public Object get(int i) {
            gg3.o(i, this.j);
            Object obj = this.h[(i * 2) + this.i];
            Objects.requireNonNull(obj);
            return obj;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.j;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zp3(Object obj, Object[] objArr, int i) {
        this.j = obj;
        this.k = objArr;
        this.l = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zp3 o(int i, Object[] objArr) {
        return p(i, objArr, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zp3 p(int i, Object[] objArr, zi1.a aVar) {
        if (i == 0) {
            return (zp3) m;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            jw.a(obj, obj2);
            return new zp3(null, objArr, 1);
        }
        gg3.s(i, objArr.length >> 1);
        Object objQ = q(objArr, i, dj1.n(i), 0);
        if (objQ instanceof Object[]) {
            Object[] objArr2 = (Object[]) objQ;
            zi1.a.C0144a c0144a = (zi1.a.C0144a) objArr2[2];
            if (aVar == null) {
                throw c0144a.a();
            }
            aVar.e = c0144a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objQ = obj3;
            i = iIntValue;
        }
        return new zp3(objQ, objArr, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object q(Object[] objArr, int i, int i2, int i3) {
        int i4;
        zi1.a.C0144a c0144a = null;
        int i5 = 1;
        if (i == 1) {
            Object obj = objArr[i3];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i3 ^ 1];
            Objects.requireNonNull(obj2);
            jw.a(obj, obj2);
            return null;
        }
        int i6 = i2 - 1;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            int i7 = 0;
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = (i8 * 2) + i3;
                int i10 = (i7 * 2) + i3;
                Object obj3 = objArr[i9];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i9 ^ 1];
                Objects.requireNonNull(obj4);
                jw.a(obj3, obj4);
                int iB = uc1.b(obj3.hashCode());
                while (true) {
                    int i11 = iB & i6;
                    int i12 = bArr[i11] & 255;
                    if (i12 == 255) {
                        bArr[i11] = (byte) i10;
                        if (i7 < i8) {
                            objArr[i10] = obj3;
                            objArr[i10 ^ 1] = obj4;
                        }
                        i7++;
                    } else {
                        if (obj3.equals(objArr[i12])) {
                            int i13 = i12 ^ 1;
                            Object obj5 = objArr[i13];
                            Objects.requireNonNull(obj5);
                            c0144a = new zi1.a.C0144a(obj3, obj4, obj5);
                            objArr[i13] = obj4;
                            break;
                        }
                        iB = i11 + 1;
                    }
                }
            }
            return i7 == i ? bArr : new Object[]{bArr, Integer.valueOf(i7), c0144a};
        }
        if (i2 <= 32768) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            int i14 = 0;
            for (int i15 = 0; i15 < i; i15++) {
                int i16 = (i15 * 2) + i3;
                int i17 = (i14 * 2) + i3;
                Object obj6 = objArr[i16];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i16 ^ 1];
                Objects.requireNonNull(obj7);
                jw.a(obj6, obj7);
                int iB2 = uc1.b(obj6.hashCode());
                while (true) {
                    int i18 = iB2 & i6;
                    int i19 = sArr[i18] & 65535;
                    if (i19 == 65535) {
                        sArr[i18] = (short) i17;
                        if (i14 < i15) {
                            objArr[i17] = obj6;
                            objArr[i17 ^ 1] = obj7;
                        }
                        i14++;
                    } else {
                        if (obj6.equals(objArr[i19])) {
                            int i20 = i19 ^ 1;
                            Object obj8 = objArr[i20];
                            Objects.requireNonNull(obj8);
                            c0144a = new zi1.a.C0144a(obj6, obj7, obj8);
                            objArr[i20] = obj7;
                            break;
                        }
                        iB2 = i18 + 1;
                    }
                }
            }
            return i14 == i ? sArr : new Object[]{sArr, Integer.valueOf(i14), c0144a};
        }
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        int i21 = 0;
        int i22 = 0;
        while (i21 < i) {
            int i23 = (i21 * 2) + i3;
            int i24 = (i22 * 2) + i3;
            Object obj9 = objArr[i23];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i23 ^ i5];
            Objects.requireNonNull(obj10);
            jw.a(obj9, obj10);
            int iB3 = uc1.b(obj9.hashCode());
            while (true) {
                int i25 = iB3 & i6;
                int i26 = iArr[i25];
                if (i26 == -1) {
                    iArr[i25] = i24;
                    if (i22 < i21) {
                        objArr[i24] = obj9;
                        objArr[i24 ^ 1] = obj10;
                    }
                    i22++;
                    i4 = i5;
                } else {
                    i4 = i5;
                    if (obj9.equals(objArr[i26])) {
                        int i27 = i26 ^ 1;
                        Object obj11 = objArr[i27];
                        Objects.requireNonNull(obj11);
                        c0144a = new zi1.a.C0144a(obj9, obj10, obj11);
                        objArr[i27] = obj10;
                        break;
                    }
                    iB3 = i25 + 1;
                    i5 = i4;
                }
            }
            i21++;
            i5 = i4;
        }
        int i28 = i5;
        if (i22 == i) {
            return iArr;
        }
        Object[] objArr2 = new Object[3];
        objArr2[0] = iArr;
        objArr2[i28] = Integer.valueOf(i22);
        objArr2[2] = c0144a;
        return objArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object r(Object[] objArr, int i, int i2, int i3) {
        Object objQ = q(objArr, i, i2, i3);
        if (objQ instanceof Object[]) {
            throw ((zi1.a.C0144a) ((Object[]) objQ)[2]).a();
        }
        return objQ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object s(Object obj, Object[] objArr, int i, int i2, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i2];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i2 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iB = uc1.b(obj2.hashCode());
            while (true) {
                int i3 = iB & length;
                int i4 = bArr[i3] & 255;
                if (i4 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i4])) {
                    return objArr[i4 ^ 1];
                }
                iB = i3 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iB2 = uc1.b(obj2.hashCode());
            while (true) {
                int i5 = iB2 & length2;
                int i6 = sArr[i5] & 65535;
                if (i6 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i6])) {
                    return objArr[i6 ^ 1];
                }
                iB2 = i5 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iB3 = uc1.b(obj2.hashCode());
            while (true) {
                int i7 = iB3 & length3;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                iB3 = i7 + 1;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zi1
    public dj1 d() {
        return new a(this, this.k, 0, this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zi1
    public dj1 e() {
        return new b(this, new c(this.k, 0, this.l));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zi1
    public vi1 f() {
        return new c(this.k, 1, this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zi1, java.util.Map
    public Object get(Object obj) {
        Object objS = s(this.j, this.k, this.l, 0, obj);
        if (objS == null) {
            return null;
        }
        return objS;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zi1
    public boolean h() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Map
    public int size() {
        return this.l;
    }
}
