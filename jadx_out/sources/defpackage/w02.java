package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class w02 implements Cloneable {
    public /* synthetic */ boolean f;
    public /* synthetic */ long[] g;
    public /* synthetic */ Object[] h;
    public /* synthetic */ int i;

    public w02(int i) {
        if (i == 0) {
            this.g = i20.b;
            this.h = i20.c;
        } else {
            int iF = i20.f(i);
            this.g = new long[iF];
            this.h = new Object[iF];
        }
    }

    public void a() {
        int i = this.i;
        Object[] objArr = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.i = 0;
        this.f = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public w02 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        w02 w02Var = (w02) objClone;
        w02Var.g = (long[]) this.g.clone();
        w02Var.h = (Object[]) this.h.clone();
        return w02Var;
    }

    public boolean c(long j) {
        return e(j) >= 0;
    }

    public Object d(long j) {
        int iB = i20.b(this.g, this.i, j);
        if (iB < 0 || this.h[iB] == x02.a) {
            return null;
        }
        return this.h[iB];
    }

    public int e(long j) {
        if (this.f) {
            int i = this.i;
            long[] jArr = this.g;
            Object[] objArr = this.h;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != x02.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.f = false;
            this.i = i2;
        }
        return i20.b(this.g, this.i, j);
    }

    public boolean f() {
        return k() == 0;
    }

    public long g(int i) {
        if (!(i >= 0 && i < this.i)) {
            fw3.a("Expected index to be within 0..size()-1, but was " + i);
        }
        if (this.f) {
            int i2 = this.i;
            long[] jArr = this.g;
            Object[] objArr = this.h;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != x02.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f = false;
            this.i = i3;
        }
        return this.g[i];
    }

    public void h(long j, Object obj) {
        int iB = i20.b(this.g, this.i, j);
        if (iB >= 0) {
            this.h[iB] = obj;
            return;
        }
        int i = ~iB;
        if (i < this.i && this.h[i] == x02.a) {
            this.g[i] = j;
            this.h[i] = obj;
            return;
        }
        if (this.f) {
            int i2 = this.i;
            long[] jArr = this.g;
            if (i2 >= jArr.length) {
                Object[] objArr = this.h;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj2 = objArr[i4];
                    if (obj2 != x02.a) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr[i3] = obj2;
                            objArr[i4] = null;
                        }
                        i3++;
                    }
                }
                this.f = false;
                this.i = i3;
                i = ~i20.b(this.g, i3, j);
            }
        }
        int i5 = this.i;
        if (i5 >= this.g.length) {
            int iF = i20.f(i5 + 1);
            this.g = Arrays.copyOf(this.g, iF);
            this.h = Arrays.copyOf(this.h, iF);
        }
        int i6 = this.i;
        if (i6 - i != 0) {
            long[] jArr2 = this.g;
            int i7 = i + 1;
            ta.f(jArr2, jArr2, i7, i, i6);
            Object[] objArr2 = this.h;
            ta.g(objArr2, objArr2, i7, i, this.i);
        }
        this.g[i] = j;
        this.h[i] = obj;
        this.i++;
    }

    public void i(long j) {
        int iB = i20.b(this.g, this.i, j);
        if (iB < 0 || this.h[iB] == x02.a) {
            return;
        }
        this.h[iB] = x02.a;
        this.f = true;
    }

    public void j(int i) {
        if (this.h[i] != x02.a) {
            this.h[i] = x02.a;
            this.f = true;
        }
    }

    public int k() {
        if (this.f) {
            int i = this.i;
            long[] jArr = this.g;
            Object[] objArr = this.h;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != x02.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.f = false;
            this.i = i2;
        }
        return this.i;
    }

    public Object l(int i) {
        if (!(i >= 0 && i < this.i)) {
            fw3.a("Expected index to be within 0..size()-1, but was " + i);
        }
        if (this.f) {
            int i2 = this.i;
            long[] jArr = this.g;
            Object[] objArr = this.h;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != x02.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f = false;
            this.i = i3;
        }
        return this.h[i];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 28);
        sb.append('{');
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append('=');
            Object objL = l(i2);
            if (objL != sb) {
                sb.append(objL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public w02() {
        this(0, 1, null);
    }

    public /* synthetic */ w02(int i, int i2, we0 we0Var) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
