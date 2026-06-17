package defpackage;

import defpackage.gr4;
import defpackage.ki4;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ni4 implements gr4 {
    public final gr4 a;
    public final ki4.a b;
    public ki4 h;
    public t41 i;
    public boolean j;
    public final s50 c = new s50();
    public int e = 0;
    public int f = 0;
    public byte[] g = fy4.f;
    public final r73 d = new r73();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ni4(gr4 gr4Var, ki4.a aVar) {
        this.a = gr4Var;
        this.b = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gr4
    public void b(final long j, final int i, int i2, int i3, gr4.a aVar) {
        int i4;
        if (this.h == null) {
            this.a.b(j, i, i2, i3, aVar);
            return;
        }
        gg3.e(aVar == null, "DRM on subtitles is not supported");
        int i5 = (this.f - i3) - i2;
        try {
            i4 = i5;
            try {
                this.h.b(this.g, i4, i2, ki4.b.b(), new g20() { // from class: mi4
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        this.a.j((y50) obj, j, i);
                    }
                });
            } catch (RuntimeException e) {
                e = e;
                RuntimeException runtimeException = e;
                if (!this.j) {
                    throw runtimeException;
                }
                xz1.j("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", runtimeException);
            }
        } catch (RuntimeException e2) {
            e = e2;
            i4 = i5;
        }
        int i6 = i4 + i2;
        this.e = i6;
        if (i6 == this.f) {
            this.e = 0;
            this.f = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gr4
    public void c(r73 r73Var, int i, int i2) {
        if (this.h == null) {
            this.a.c(r73Var, i, i2);
            return;
        }
        i(i);
        r73Var.u(this.g, this.f, i);
        this.f += i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gr4
    public int f(x90 x90Var, int i, boolean z, int i2) throws EOFException {
        if (this.h == null) {
            return this.a.f(x90Var, i, z, i2);
        }
        i(i);
        int i3 = x90Var.read(this.g, this.f, i);
        if (i3 != -1) {
            this.f += i3;
            return i3;
        }
        if (z) {
            return -1;
        }
        ll.a();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gr4
    public void g(t41 t41Var) {
        gg3.q(t41Var.p);
        gg3.d(nt2.k(t41Var.p) == 3);
        if (!t41Var.equals(this.i)) {
            this.i = t41Var;
            this.h = this.b.a(t41Var) ? this.b.b(t41Var) : null;
        }
        ki4 ki4Var = this.h;
        gr4 gr4Var = this.a;
        if (ki4Var == null) {
            gr4Var.g(t41Var);
        } else {
            gr4Var.g(t41Var.b().A0("application/x-media3-cues").V(t41Var.p).E0(Long.MAX_VALUE).Z(this.b.c(t41Var)).Q());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(int i) {
        int length = this.g.length;
        int i2 = this.f;
        if (length - i2 >= i) {
            return;
        }
        int i3 = i2 - this.e;
        int iMax = Math.max(i3 * 2, i + i3);
        byte[] bArr = this.g;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.e, bArr2, 0, i3);
        this.e = 0;
        this.f = i3;
        this.g = bArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(y50 y50Var, long j, int i) {
        long j2;
        gg3.q(this.i);
        byte[] bArrA = this.c.a(y50Var.a, y50Var.c);
        this.d.c0(bArrA);
        this.a.a(this.d, bArrA.length);
        long j3 = y50Var.b;
        t41 t41Var = this.i;
        if (j3 == -9223372036854775807L) {
            gg3.v(t41Var.u == Long.MAX_VALUE);
            j2 = j;
        } else {
            long j4 = t41Var.u;
            j2 = j4 == Long.MAX_VALUE ? j3 + j : j3 + j4;
        }
        this.a.b(j2, i | 1, bArrA.length, 0, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(boolean z) {
        this.j = z;
    }
}
