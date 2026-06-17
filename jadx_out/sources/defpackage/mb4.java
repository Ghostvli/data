package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mb4 implements Cloneable {
    public /* synthetic */ boolean f;
    public /* synthetic */ int[] g;
    public /* synthetic */ Object[] h;
    public /* synthetic */ int i;

    public mb4(int i) {
        if (i == 0) {
            this.g = i20.a;
            this.h = i20.c;
        } else {
            int iE = i20.e(i);
            this.g = new int[iE];
            this.h = new Object[iE];
        }
    }

    public void a(int i, Object obj) {
        int i2 = this.i;
        if (i2 != 0 && i <= this.g[i2 - 1]) {
            g(i, obj);
            return;
        }
        if (this.f && i2 >= this.g.length) {
            nb4.d(this);
        }
        int i3 = this.i;
        if (i3 >= this.g.length) {
            int iE = i20.e(i3 + 1);
            this.g = Arrays.copyOf(this.g, iE);
            this.h = Arrays.copyOf(this.h, iE);
        }
        this.g[i3] = i;
        this.h[i3] = obj;
        this.i = i3 + 1;
    }

    public void b() {
        int i = this.i;
        Object[] objArr = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.i = 0;
        this.f = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public mb4 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        mb4 mb4Var = (mb4) objClone;
        mb4Var.g = (int[]) this.g.clone();
        mb4Var.h = (Object[]) this.h.clone();
        return mb4Var;
    }

    public Object d(int i) {
        return nb4.c(this, i);
    }

    public int e(Object obj) {
        if (this.f) {
            nb4.d(this);
        }
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.h[i2] == obj) {
                return i2;
            }
        }
        return -1;
    }

    public int f(int i) {
        if (this.f) {
            nb4.d(this);
        }
        return this.g[i];
    }

    public void g(int i, Object obj) {
        int iA = i20.a(this.g, this.i, i);
        if (iA >= 0) {
            this.h[iA] = obj;
            return;
        }
        int i2 = ~iA;
        if (i2 < this.i && this.h[i2] == nb4.a) {
            this.g[i2] = i;
            this.h[i2] = obj;
            return;
        }
        if (this.f && this.i >= this.g.length) {
            nb4.d(this);
            i2 = ~i20.a(this.g, this.i, i);
        }
        int i3 = this.i;
        if (i3 >= this.g.length) {
            int iE = i20.e(i3 + 1);
            this.g = Arrays.copyOf(this.g, iE);
            this.h = Arrays.copyOf(this.h, iE);
        }
        int i4 = this.i;
        if (i4 - i2 != 0) {
            int[] iArr = this.g;
            int i5 = i2 + 1;
            ta.e(iArr, iArr, i5, i2, i4);
            Object[] objArr = this.h;
            ta.g(objArr, objArr, i5, i2, this.i);
        }
        this.g[i2] = i;
        this.h[i2] = obj;
        this.i++;
    }

    public int h() {
        if (this.f) {
            nb4.d(this);
        }
        return this.i;
    }

    public Object i(int i) {
        if (this.f) {
            nb4.d(this);
        }
        Object[] objArr = this.h;
        if (i < objArr.length) {
            return objArr[i];
        }
        kw kwVar = kw.a;
        throw new ArrayIndexOutOfBoundsException();
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 28);
        sb.append('{');
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(f(i2));
            sb.append('=');
            Object objI = i(i2);
            if (objI != this) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public mb4() {
        this(0, 1, null);
    }

    public /* synthetic */ mb4(int i, int i2, we0 we0Var) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
