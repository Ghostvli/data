package defpackage;

import defpackage.wt4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wz3 implements wt4 {
    public final vz3 a;
    public final r73 b = new r73(32);
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wz3(vz3 vz3Var) {
        this.a = vz3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt4
    public void a(r73 r73Var, int i) {
        boolean z = (i & 1) != 0;
        int iG = z ? r73Var.g() + r73Var.Q() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            r73Var.f0(iG);
            this.d = 0;
        }
        while (r73Var.a() > 0) {
            int i2 = this.d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int iQ = r73Var.Q();
                    r73Var.f0(r73Var.g() - 1);
                    if (iQ == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(r73Var.a(), 3 - this.d);
                r73Var.u(this.b.f(), this.d, iMin);
                int i3 = this.d + iMin;
                this.d = i3;
                if (i3 == 3) {
                    this.b.f0(0);
                    this.b.e0(3);
                    this.b.g0(1);
                    int iQ2 = this.b.Q();
                    int iQ3 = this.b.Q();
                    this.e = (iQ2 & 128) != 0;
                    this.c = (((iQ2 & 15) << 8) | iQ3) + 3;
                    int iB = this.b.b();
                    int i4 = this.c;
                    if (iB < i4) {
                        this.b.d(Math.min(4098, Math.max(i4, this.b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(r73Var.a(), this.c - this.d);
                r73Var.u(this.b.f(), this.d, iMin2);
                int i5 = this.d + iMin2;
                this.d = i5;
                int i6 = this.c;
                if (i5 == i6) {
                    boolean z2 = this.e;
                    r73 r73Var2 = this.b;
                    if (!z2) {
                        r73Var2.e0(i6);
                    } else {
                        if (fy4.B(r73Var2.f(), 0, this.c, -1) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.e0(this.c - 4);
                    }
                    this.b.f0(0);
                    this.a.a(this.b);
                    this.d = 0;
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt4
    public void b(yo4 yo4Var, mz0 mz0Var, wt4.d dVar) {
        this.a.b(yo4Var, mz0Var, dVar);
        this.f = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt4
    public void c() {
        this.f = true;
    }
}
