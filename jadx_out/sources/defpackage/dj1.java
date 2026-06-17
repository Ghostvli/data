package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.vi1;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dj1 extends vi1 implements Set {
    public transient xi1 g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends vi1.a {
        public Object[] d;
        public int e;

        public a() {
            super(4);
        }

        @Override // vi1.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            gg3.q(obj);
            if (this.d != null && dj1.n(this.b) <= this.d.length) {
                j(obj);
                return this;
            }
            this.d = null;
            super.d(obj);
            return this;
        }

        public a i(Iterable iterable) {
            gg3.q(iterable);
            if (this.d == null) {
                super.b(iterable);
                return this;
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public final void j(Object obj) {
            Objects.requireNonNull(this.d);
            int length = this.d.length - 1;
            int iHashCode = obj.hashCode();
            int iB = uc1.b(iHashCode);
            while (true) {
                int i = iB & length;
                Object[] objArr = this.d;
                Object obj2 = objArr[i];
                if (obj2 == null) {
                    objArr[i] = obj;
                    this.e += iHashCode;
                    super.d(obj);
                    return;
                } else if (obj2.equals(obj)) {
                    return;
                } else {
                    iB = i + 1;
                }
            }
        }

        public dj1 k() {
            dj1 dj1VarO;
            int i = this.b;
            if (i == 0) {
                return dj1.u();
            }
            if (i == 1) {
                Object obj = this.a[0];
                Objects.requireNonNull(obj);
                return dj1.w(obj);
            }
            if (this.d == null || dj1.n(i) != this.d.length) {
                dj1VarO = dj1.o(this.b, this.a);
                this.b = dj1VarO.size();
            } else {
                boolean zC = dj1.C(this.b, this.a.length);
                Object[] objArrCopyOf = this.a;
                if (zC) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, this.b);
                }
                dj1VarO = new bq3(objArrCopyOf, this.e, this.d, r6.length - 1, this.b);
            }
            this.c = true;
            this.d = null;
            return dj1VarO;
        }

        public a l(a aVar) {
            if (this.d == null) {
                f(aVar.a, aVar.b);
                return this;
            }
            for (int i = 0; i < aVar.b; i++) {
                Object obj = aVar.a[i];
                Objects.requireNonNull(obj);
                a(obj);
            }
            return this;
        }
    }

    public static dj1 A(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return o(5, obj, obj2, obj3, obj4, obj5);
    }

    public static dj1 B(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        gg3.e(objArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return o(length, objArr2);
    }

    public static boolean C(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    public static a m() {
        return new a();
    }

    public static int n(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            gg3.e(iMax < 1073741824, "collection too large");
            return Buffer.MAX_SIZE;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static dj1 o(int i, Object... objArr) {
        if (i == 0) {
            return u();
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return w(obj);
        }
        int iN = n(i);
        Object[] objArr2 = new Object[iN];
        int i2 = iN - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object objA = r43.a(objArr[i5], i5);
            int iHashCode = objA.hashCode();
            int iB = uc1.b(iHashCode);
            while (true) {
                int i6 = iB & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = objA;
                    objArr2[i6] = objA;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iB++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new q74(obj3);
        }
        if (n(i4) < iN / 2) {
            return o(i4, objArr);
        }
        if (C(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new bq3(objArr, i3, objArr2, i2, i4);
    }

    public static dj1 p(Collection collection) {
        if ((collection instanceof dj1) && !(collection instanceof SortedSet)) {
            dj1 dj1Var = (dj1) collection;
            if (!dj1Var.g()) {
                return dj1Var;
            }
        }
        Object[] array = collection.toArray();
        return o(array.length, array);
    }

    public static dj1 q(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? o(objArr.length, (Object[]) objArr.clone()) : w(objArr[0]) : u();
    }

    public static dj1 u() {
        return bq3.n;
    }

    public static dj1 w(Object obj) {
        return new q74(obj);
    }

    public static dj1 x(Object obj, Object obj2) {
        return o(2, obj, obj2);
    }

    public static dj1 y(Object obj, Object obj2, Object obj3) {
        return o(3, obj, obj2, obj3);
    }

    public static dj1 z(Object obj, Object obj2, Object obj3, Object obj4) {
        return o(4, obj, obj2, obj3, obj4);
    }

    @Override // defpackage.vi1
    public xi1 b() {
        xi1 xi1Var = this.g;
        if (xi1Var != null) {
            return xi1Var;
        }
        xi1 xi1VarR = r();
        this.g = xi1VarR;
        return xi1VarR;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof dj1) && s() && ((dj1) obj).s() && hashCode() != obj.hashCode()) {
            return false;
        }
        return m24.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return m24.d(this);
    }

    @Override // defpackage.vi1
    /* JADX INFO: renamed from: j */
    public abstract pw4 iterator();

    public xi1 r() {
        return xi1.k(toArray());
    }

    public boolean s() {
        return false;
    }
}
