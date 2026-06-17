package defpackage;

import defpackage.dv2;
import defpackage.t41;
import defpackage.wt4;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cv2 implements cr0 {
    public final r73 a;
    public final dv2.a b;
    public final String c;
    public final int d;
    public final String e;
    public gr4 f;
    public String g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public long l;
    public int m;
    public long n;

    public cv2(String str, int i, String str2) {
        this.h = 0;
        r73 r73Var = new r73(4);
        this.a = r73Var;
        r73Var.f()[0] = -1;
        this.b = new dv2.a();
        this.n = -9223372036854775807L;
        this.c = str;
        this.d = i;
        this.e = str2;
    }

    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        gg3.q(this.f);
        while (r73Var.a() > 0) {
            int i = this.h;
            if (i == 0) {
                b(r73Var);
            } else if (i == 1) {
                h(r73Var);
            } else {
                if (i != 2) {
                    z20.a();
                    return;
                }
                g(r73Var);
            }
        }
    }

    public final void b(r73 r73Var) {
        byte[] bArrF = r73Var.f();
        int iJ = r73Var.j();
        for (int iG = r73Var.g(); iG < iJ; iG++) {
            byte b = bArrF[iG];
            boolean z = (b & 255) == 255;
            boolean z2 = this.k && (b & 224) == 224;
            this.k = z;
            if (z2) {
                r73Var.f0(iG + 1);
                this.k = false;
                this.a.f()[1] = bArrF[iG];
                this.i = 2;
                this.h = 1;
                return;
            }
        }
        r73Var.f0(iJ);
    }

    @Override // defpackage.cr0
    public void c() {
        this.h = 0;
        this.i = 0;
        this.k = false;
        this.n = -9223372036854775807L;
    }

    @Override // defpackage.cr0
    public void d(boolean z) {
    }

    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.n = j;
    }

    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.g = dVar.b();
        this.f = mz0Var.e(dVar.c(), 1);
    }

    public final void g(r73 r73Var) {
        int iMin = Math.min(r73Var.a(), this.m - this.i);
        this.f.a(r73Var, iMin);
        int i = this.i + iMin;
        this.i = i;
        if (i < this.m) {
            return;
        }
        gg3.v(this.n != -9223372036854775807L);
        this.f.b(this.n, 1, this.m, 0, null);
        this.n += this.l;
        this.i = 0;
        this.h = 0;
    }

    public final void h(r73 r73Var) {
        int iMin = Math.min(r73Var.a(), 4 - this.i);
        r73Var.u(this.a.f(), this.i, iMin);
        int i = this.i + iMin;
        this.i = i;
        if (i < 4) {
            return;
        }
        this.a.f0(0);
        if (!this.b.a(this.a.z())) {
            this.i = 0;
            this.h = 1;
            return;
        }
        dv2.a aVar = this.b;
        this.m = aVar.c;
        if (!this.j) {
            this.l = (((long) aVar.g) * 1000000) / ((long) aVar.d);
            this.f.g(new t41.b().k0(this.g).X(this.e).A0(this.b.b).p0(Buffer.SEGMENTING_THRESHOLD).U(this.b.e).B0(this.b.d).o0(this.c).y0(this.d).Q());
            this.j = true;
        }
        this.a.f0(0);
        this.f.a(this.a, 4);
        this.h = 2;
    }

    public cv2(String str) {
        this(null, 0, str);
    }
}
