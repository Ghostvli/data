package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f53 {
    public final g53 a = new g53();
    public final r73 b = new r73(new byte[65025], 0);
    public int c = -1;
    public int d;
    public boolean e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            g53 g53Var = this.a;
            if (i5 >= g53Var.g) {
                break;
            }
            int[] iArr = g53Var.j;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g53 b() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r73 c() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d(jz0 jz0Var) {
        int i;
        gg3.v(jz0Var != null);
        if (this.e) {
            this.e = false;
            this.b.b0(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.c(jz0Var) || !this.a.a(jz0Var, true)) {
                    return false;
                }
                g53 g53Var = this.a;
                int iA = g53Var.h;
                if ((g53Var.b & 1) == 1 && this.b.j() == 0) {
                    iA += a(0);
                    i = this.d;
                } else {
                    i = 0;
                }
                if (!nz0.f(jz0Var, iA)) {
                    return false;
                }
                this.c = i;
            }
            int iA2 = a(this.c);
            int i2 = this.c + this.d;
            if (iA2 > 0) {
                r73 r73Var = this.b;
                r73Var.d(r73Var.j() + iA2);
                if (!nz0.e(jz0Var, this.b.f(), this.b.j(), iA2)) {
                    return false;
                }
                r73 r73Var2 = this.b;
                r73Var2.e0(r73Var2.j() + iA2);
                this.e = this.a.j[i2 + (-1)] != 255;
            }
            if (i2 == this.a.g) {
                i2 = -1;
            }
            this.c = i2;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e() {
        this.a.b();
        this.b.b0(0);
        this.c = -1;
        this.e = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f() {
        if (this.b.f().length == 65025) {
            return;
        }
        r73 r73Var = this.b;
        r73Var.d0(Arrays.copyOf(r73Var.f(), Math.max(65025, this.b.j())), this.b.j());
    }
}
