package defpackage;

import okhttp3.internal.http2.Settings;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yu3 implements gv3 {
    public final fv3 c;
    public gr4 d;
    public int e;
    public int i;
    public long j;
    public final r73 a = new r73();
    public final r73 b = new r73(dx2.a);
    public long f = -9223372036854775807L;
    public int g = -1;
    public long h = -9223372036854775807L;
    public boolean k = false;
    public boolean l = false;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yu3(fv3 fv3Var) {
        this.c = fv3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int e(int i) {
        return (i == 19 || i == 20) ? 1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void g(r73 r73Var, int i) throws r83 {
        if (r73Var.f().length < 3) {
            throw r83.c("Malformed FU header.", null);
        }
        int i2 = r73Var.f()[1] & 7;
        byte b = r73Var.f()[2];
        int i3 = b & Utf8.REPLACEMENT_BYTE;
        boolean z = (b & 128) > 0;
        boolean z2 = (b & 64) > 0;
        if (z) {
            if (this.l) {
                this.k = true;
                this.i = 0;
            }
            this.l = true;
            this.i += j();
            this.a.c0((byte[]) r73Var.f().clone());
            this.a.f()[1] = (byte) ((i3 << 1) & 127);
            this.a.f()[2] = (byte) i2;
            this.a.f0(1);
        } else {
            if (this.k) {
                return;
            }
            int i4 = (this.g + 1) % Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            if (i != i4) {
                this.k = true;
                xz1.i("RtpH265Reader", fy4.M("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(i4), Integer.valueOf(i)));
                return;
            } else {
                this.a.c0(r73Var.f());
                this.a.f0(3);
            }
        }
        int iA = this.a.a();
        this.d.a(this.a, iA);
        this.i += iA;
        if (z2) {
            this.l = false;
            this.e = e(i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void h(r73 r73Var) {
        int iA = r73Var.a();
        this.i += j();
        this.d.a(r73Var, iA);
        this.i += iA;
        this.e = e((r73Var.f()[0] >> 1) & 63);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void i() {
        this.k = false;
        this.l = false;
        this.i = 0;
        this.e = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int j() {
        this.b.f0(0);
        int iA = this.b.a();
        ((gr4) gg3.q(this.d)).a(this.b, iA);
        return iA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void a(long j, long j2) {
        this.f = j;
        this.h = -9223372036854775807L;
        i();
        this.j = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void b(mz0 mz0Var, int i) {
        gr4 gr4VarE = mz0Var.e(i, 2);
        this.d = gr4VarE;
        gr4VarE.g(this.c.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void c(long j, int i) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gv3
    public void d(r73 r73Var, long j, int i, boolean z) throws r83 {
        if (r73Var.f().length == 0) {
            throw r83.c("Empty RTP data packet.", null);
        }
        gg3.q(this.d);
        long j2 = this.h;
        if (j2 != -9223372036854775807L && j != j2) {
            i();
        }
        if (!this.k) {
            int i2 = (r73Var.f()[0] >> 1) & 63;
            if (this.l && i2 != 49) {
                this.k = true;
            }
            if (!this.k) {
                if (i2 >= 0 && i2 < 48) {
                    h(r73Var);
                } else if (i2 == 48) {
                    f(r73Var);
                } else {
                    if (i2 != 49) {
                        throw r83.c(fy4.M("RTP H265 payload type [%d] not supported.", Integer.valueOf(i2)), null);
                    }
                    g(r73Var, i);
                }
            }
        }
        if (this.f == -9223372036854775807L) {
            this.f = j;
        }
        if (z) {
            if (!this.k) {
                this.d.b(iv3.a(this.j, j, this.f, 90000), this.e, this.i, 0, null);
            }
            i();
        }
        this.h = j;
        this.g = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(r73 r73Var) throws r83 {
        r73Var.f0(2);
        int i = 0;
        while (r73Var.a() > 2) {
            int iY = r73Var.Y();
            int i2 = dx2.i(r73Var.f(), r73Var.g() - 3);
            if (r73Var.a() < iY) {
                throw r83.c("Malformed Aggregation Packet. NAL unit size exceeds packet size.", null);
            }
            this.i += j();
            this.d.a(r73Var, iY);
            this.i += iY;
            this.e |= e(i2);
            i++;
        }
        if (r73Var.a() > 0) {
            throw r83.c("Malformed Aggregation Packet. Packet size exceeds NAL unit size.", null);
        }
        if (i < 2) {
            throw r83.c("Aggregation Packet must contain at least 2 NAL units.", null);
        }
    }
}
