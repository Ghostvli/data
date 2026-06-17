package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ff1 implements gx3 {
    public final int f;
    public final kf1 g;
    public int h = -1;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ff1(kf1 kf1Var, int i) {
        this.g = kf1Var;
        this.f = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public void a() throws fx3 {
        int i = this.h;
        if (i == -2) {
            throw new fx3(this.g.s().b(this.f).c(0).p);
        }
        if (i == -1) {
            this.g.Y();
        } else if (i != -3) {
            this.g.Z(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        gg3.d(this.h == -1);
        this.h = this.g.A(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean c() {
        int i = this.h;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d() {
        if (this.h != -1) {
            this.g.v0(this.f);
            this.h = -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public int e(long j) {
        if (c()) {
            return this.g.u0(this.h, j);
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public boolean isReady() {
        if (this.h != -3) {
            return c() && this.g.T(this.h);
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (this.h == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (c()) {
            return this.g.j0(this.h, u41Var, decoderInputBuffer, i);
        }
        return -3;
    }
}
