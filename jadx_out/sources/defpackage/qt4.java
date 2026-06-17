package defpackage;

import defpackage.gr4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qt4 {
    public final byte[] a = new byte[10];
    public boolean b;
    public int c;
    public long d;
    public int e;
    public int f;
    public int g;

    public void a(gr4 gr4Var, gr4.a aVar) {
        if (this.c > 0) {
            gr4Var.b(this.d, this.e, this.f, this.g, aVar);
            this.c = 0;
        }
    }

    public void b() {
        this.b = false;
        this.c = 0;
    }

    public void c(gr4 gr4Var, long j, int i, int i2, int i3, gr4.a aVar) {
        gg3.w(this.g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.b) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i4 == 0) {
                this.d = j;
                this.e = i;
                this.f = 0;
            }
            this.f += i2;
            this.g = i3;
            if (i5 >= 16) {
                a(gr4Var, aVar);
            }
        }
    }

    public void d(jz0 jz0Var) {
        if (this.b) {
            return;
        }
        jz0Var.s(this.a, 0, 10);
        jz0Var.p();
        if (l1.j(this.a) == 0) {
            return;
        }
        this.b = true;
    }
}
