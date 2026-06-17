package defpackage;

import defpackage.t41;
import defpackage.wt4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ai1 implements cr0 {
    public final String a;
    public gr4 c;
    public boolean d;
    public int f;
    public int g;
    public final r73 b = new r73(10);
    public long e = -9223372036854775807L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ai1(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        gg3.q(this.c);
        if (this.d) {
            int iA = r73Var.a();
            int i = this.g;
            if (i < 10) {
                int iMin = Math.min(iA, 10 - i);
                System.arraycopy(r73Var.f(), r73Var.g(), this.b.f(), this.g, iMin);
                if (this.g + iMin == 10) {
                    this.b.f0(0);
                    if (73 != this.b.Q() || 68 != this.b.Q() || 51 != this.b.Q()) {
                        xz1.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.d = false;
                        return;
                    } else {
                        this.b.g0(3);
                        this.f = this.b.P() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f - this.g);
            this.c.a(r73Var, iMin2);
            this.g += iMin2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void c() {
        this.d = false;
        this.e = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void d(boolean z) {
        int i;
        gg3.q(this.c);
        if (this.d && (i = this.f) != 0 && this.g == i) {
            gg3.v(this.e != -9223372036854775807L);
            this.c.b(this.e, 1, this.f, 0, null);
            this.d = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void e(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.d = true;
        this.e = j;
        this.f = 0;
        this.g = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        gr4 gr4VarE = mz0Var.e(dVar.c(), 5);
        this.c = gr4VarE;
        gr4VarE.g(new t41.b().k0(dVar.b()).X(this.a).A0("application/id3").Q());
    }
}
