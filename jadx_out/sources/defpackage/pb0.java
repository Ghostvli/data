package defpackage;

import defpackage.j5;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pb0 implements j5 {
    public final boolean a;
    public final int b;
    public final byte[] c;
    public int d;
    public int e;
    public int f;
    public i5[] g;

    public pb0(boolean z, int i, int i2) {
        gg3.d(i > 0);
        gg3.d(i2 >= 0);
        this.a = z;
        this.b = i;
        this.f = i2;
        this.g = new i5[i2 + 100];
        if (i2 <= 0) {
            this.c = null;
            return;
        }
        this.c = new byte[i2 * i];
        for (int i3 = 0; i3 < i2; i3++) {
            this.g[i3] = new i5(this.c, i3 * i);
        }
    }

    @Override // defpackage.j5
    public synchronized void a(j5.a aVar) {
        while (aVar != null) {
            i5[] i5VarArr = this.g;
            int i = this.f;
            this.f = i + 1;
            i5VarArr[i] = aVar.a();
            this.e--;
            aVar = aVar.next();
        }
    }

    @Override // defpackage.j5
    public synchronized void b(i5 i5Var) {
        i5[] i5VarArr = this.g;
        int i = this.f;
        this.f = i + 1;
        i5VarArr[i] = i5Var;
        this.e--;
    }

    @Override // defpackage.j5
    public synchronized i5 c() {
        i5 i5Var;
        try {
            this.e++;
            int i = this.f;
            if (i > 0) {
                i5[] i5VarArr = this.g;
                int i2 = i - 1;
                this.f = i2;
                i5Var = (i5) gg3.q(i5VarArr[i2]);
                this.g[this.f] = null;
            } else {
                i5Var = new i5(new byte[this.b], 0);
                int i3 = this.e;
                i5[] i5VarArr2 = this.g;
                if (i3 > i5VarArr2.length) {
                    this.g = (i5[]) Arrays.copyOf(i5VarArr2, i5VarArr2.length * 2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i5Var;
    }

    @Override // defpackage.j5
    public synchronized void d() {
        try {
            int i = 0;
            int iMax = Math.max(0, fy4.n(this.d, this.b) - this.e);
            int i2 = this.f;
            if (iMax >= i2) {
                return;
            }
            if (this.c != null) {
                int i3 = i2 - 1;
                while (i <= i3) {
                    i5 i5Var = (i5) gg3.q(this.g[i]);
                    if (i5Var.a == this.c) {
                        i++;
                    } else {
                        i5 i5Var2 = (i5) gg3.q(this.g[i3]);
                        if (i5Var2.a != this.c) {
                            i3--;
                        } else {
                            i5[] i5VarArr = this.g;
                            i5VarArr[i] = i5Var2;
                            i5VarArr[i3] = i5Var;
                            i3--;
                            i++;
                        }
                    }
                }
                iMax = Math.max(iMax, i);
                if (iMax >= this.f) {
                    return;
                }
            }
            Arrays.fill(this.g, iMax, this.f, (Object) null);
            this.f = iMax;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.j5
    public int e() {
        return this.b;
    }

    public synchronized void f() {
        if (this.a) {
            g(0);
        }
    }

    public synchronized void g(int i) {
        boolean z = i < this.d;
        this.d = i;
        if (z) {
            d();
        }
    }

    public pb0(boolean z, int i) {
        this(z, i, 0);
    }
}
