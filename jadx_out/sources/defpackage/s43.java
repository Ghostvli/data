package defpackage;

import defpackage.kw2;
import defpackage.lw2;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class s43 {
    public transient Object[] a;
    public transient int[] b;
    public transient int c;
    public transient int d;
    public transient int[] e;
    public transient long[] f;
    public transient float g;
    public transient int h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a extends lw2.a {
        public final Object a;
        public int b;

        public a(int i) {
            this.a = s43.this.a[i];
            this.b = i;
        }

        @Override // kw2.a
        public Object a() {
            return this.a;
        }

        public void b() {
            int i = this.b;
            if (i == -1 || i >= s43.this.v() || !Objects.equals(this.a, s43.this.a[this.b])) {
                this.b = s43.this.l(this.a);
            }
        }

        @Override // kw2.a
        public int getCount() {
            b();
            int i = this.b;
            if (i == -1) {
                return 0;
            }
            return s43.this.b[i];
        }
    }

    public s43(s43 s43Var) {
        m(s43Var.v(), 1.0f);
        int iD = s43Var.d();
        while (iD != -1) {
            r(s43Var.h(iD), s43Var.j(iD));
            iD = s43Var.q(iD);
        }
    }

    public static s43 a() {
        return new s43();
    }

    public static s43 b(int i) {
        return new s43(i);
    }

    public static int g(long j) {
        return (int) (j >>> 32);
    }

    public static int i(long j) {
        return (int) j;
    }

    public static long[] o(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] p(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static long w(long j, int i) {
        return (j & (-4294967296L)) | (4294967295L & ((long) i));
    }

    public void c(int i) {
        if (i > this.f.length) {
            s(i);
        }
        if (i >= this.h) {
            u(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public int d() {
        return this.c == 0 ? -1 : 0;
    }

    public int e(Object obj) {
        int iL = l(obj);
        if (iL == -1) {
            return 0;
        }
        return this.b[iL];
    }

    public kw2.a f(int i) {
        gg3.o(i, this.c);
        return new a(i);
    }

    public Object h(int i) {
        gg3.o(i, this.c);
        return this.a[i];
    }

    public int j(int i) {
        gg3.o(i, this.c);
        return this.b[i];
    }

    public final int k() {
        return this.e.length - 1;
    }

    public int l(Object obj) {
        int iC = uc1.c(obj);
        int i = this.e[k() & iC];
        while (i != -1) {
            long j = this.f[i];
            if (g(j) == iC && Objects.equals(obj, this.a[i])) {
                return i;
            }
            i = i(j);
        }
        return -1;
    }

    public void m(int i, float f) {
        gg3.e(i >= 0, "Initial capacity must be non-negative");
        gg3.e(f > 0.0f, "Illegal load factor");
        int iA = uc1.a(i, f);
        this.e = p(iA);
        this.g = f;
        this.a = new Object[i];
        this.b = new int[i];
        this.f = o(i);
        this.h = Math.max(1, (int) (iA * f));
    }

    public void n(int i, Object obj, int i2, int i3) {
        this.f[i] = (((long) i3) << 32) | 4294967295L;
        this.a[i] = obj;
        this.b[i] = i2;
    }

    public int q(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    public int r(Object obj, int i) {
        jw.c(i, "count");
        long[] jArr = this.f;
        Object[] objArr = this.a;
        int[] iArr = this.b;
        int iC = uc1.c(obj);
        int iK = k() & iC;
        int i2 = this.c;
        int[] iArr2 = this.e;
        int i3 = iArr2[iK];
        if (i3 == -1) {
            iArr2[iK] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (g(j) == iC && Objects.equals(obj, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int i5 = i(j);
                if (i5 == -1) {
                    jArr[i3] = w(j, i2);
                    break;
                }
                i3 = i5;
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            e04.a("Cannot contain more than Integer.MAX_VALUE elements!");
            return 0;
        }
        int i6 = i2 + 1;
        t(i6);
        n(i2, obj, i, iC);
        this.c = i6;
        if (i2 >= this.h) {
            u(this.e.length * 2);
        }
        this.d++;
        return 0;
    }

    public void s(int i) {
        this.a = Arrays.copyOf(this.a, i);
        this.b = Arrays.copyOf(this.b, i);
        long[] jArr = this.f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(jArrCopyOf, length, i, -1L);
        }
        this.f = jArrCopyOf;
    }

    public final void t(int i) {
        int length = this.f.length;
        if (i > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                s(iMax);
            }
        }
    }

    public final void u(int i) {
        if (this.e.length >= 1073741824) {
            this.h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.g)) + 1;
        int[] iArrP = p(i);
        long[] jArr = this.f;
        int length = iArrP.length - 1;
        for (int i3 = 0; i3 < this.c; i3++) {
            int iG = g(jArr[i3]);
            int i4 = iG & length;
            int i5 = iArrP[i4];
            iArrP[i4] = i3;
            jArr[i3] = (((long) iG) << 32) | (((long) i5) & 4294967295L);
        }
        this.h = i2;
        this.e = iArrP;
    }

    public int v() {
        return this.c;
    }

    public s43() {
        m(3, 1.0f);
    }

    public s43(int i) {
        this(i, 1.0f);
    }

    public s43(int i, float f) {
        m(i, f);
    }
}
