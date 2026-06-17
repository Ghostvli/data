package defpackage;

import defpackage.t41;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bv3 implements gv3 {
    public final fv3 a;
    public gr4 b;
    public long d;
    public boolean f;
    public boolean g;
    public long c = -1;
    public int e = -1;

    public bv3(fv3 fv3Var) {
        this.a = fv3Var;
    }

    public static void e(r73 r73Var) {
        int iG = r73Var.g();
        gg3.e(r73Var.j() > 18, "ID Header has insufficient data");
        gg3.e(r73Var.N(8).equals("OpusHead"), "ID Header missing");
        gg3.e(r73Var.Q() == 1, "version number must always be 1");
        r73Var.f0(iG);
    }

    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.c = j;
        this.d = j2;
    }

    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 1);
        this.b = gr4VarE;
        gr4VarE.g(this.a.c);
    }

    @Override // defpackage.gv3
    public void c(long j, int i) {
        this.c = j;
    }

    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) {
        gg3.q(this.b);
        if (!this.f) {
            e(r73Var);
            List listA = w63.a(r73Var.f());
            t41.b bVarB = this.a.c.b();
            bVarB.l0(listA);
            this.b.g(bVarB.Q());
            this.f = true;
        } else if (this.g) {
            int iB = cv3.b(this.e);
            if (i != iB) {
                xz1.i("RtpOpusReader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i)));
            }
            int iA = r73Var.a();
            this.b.a(r73Var, iA);
            this.b.b(iv3.a(this.d, j, this.c, 48000), 1, iA, 0, null);
        } else {
            gg3.e(r73Var.j() >= 8, "Comment Header has insufficient data");
            gg3.e(r73Var.N(8).equals("OpusTags"), "Comment Header should follow ID Header");
            this.g = true;
        }
        this.e = i;
    }
}
