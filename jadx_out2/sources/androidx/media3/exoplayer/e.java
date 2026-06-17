package androidx.media3.exoplayer;

import defpackage.dc3;
import defpackage.gg3;
import defpackage.rd4;
import defpackage.x72;
import defpackage.zu;
import defpackage.zv0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements x72 {
    public final rd4 f;
    public final a g;
    public o h;
    public x72 i;
    public boolean j = true;
    public boolean k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void onPlaybackParametersChanged(dc3 dc3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e(a aVar, zu zuVar) {
        this.g = aVar;
        this.f = new rd4(zuVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public boolean D() {
        return this.j ? this.f.D() : ((x72) gg3.q(this.i)).D();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(o oVar) {
        if (oVar == this.h) {
            this.i = null;
            this.h = null;
            this.j = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(o oVar) throws zv0 {
        x72 x72Var;
        x72 x72VarN = oVar.N();
        if (x72VarN == null || x72VarN == (x72Var = this.i)) {
            return;
        }
        if (x72Var != null) {
            throw zv0.m(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.i = x72VarN;
        this.h = oVar;
        x72VarN.setPlaybackParameters(this.f.getPlaybackParameters());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(long j) {
        this.f.a(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean d(boolean z) {
        o oVar = this.h;
        if (oVar == null || oVar.b()) {
            return true;
        }
        if (z && this.h.getState() != 2) {
            return true;
        }
        if (this.h.isReady()) {
            return false;
        }
        return z || this.h.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public long e() {
        return this.j ? this.f.e() : ((x72) gg3.q(this.i)).e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f() {
        this.k = true;
        this.f.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        this.k = false;
        this.f.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public dc3 getPlaybackParameters() {
        x72 x72Var = this.i;
        return x72Var != null ? x72Var.getPlaybackParameters() : this.f.getPlaybackParameters();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long h(boolean z) {
        i(z);
        return e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(boolean z) {
        if (d(z)) {
            this.j = true;
            if (this.k) {
                this.f.b();
                return;
            }
            return;
        }
        x72 x72Var = (x72) gg3.q(this.i);
        long jE = x72Var.e();
        if (this.j) {
            if (jE < this.f.e()) {
                this.f.c();
                return;
            } else {
                this.j = false;
                if (this.k) {
                    this.f.b();
                }
            }
        }
        this.f.a(jE);
        dc3 playbackParameters = x72Var.getPlaybackParameters();
        if (playbackParameters.equals(this.f.getPlaybackParameters())) {
            return;
        }
        this.f.setPlaybackParameters(playbackParameters);
        this.g.onPlaybackParametersChanged(playbackParameters);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x72
    public void setPlaybackParameters(dc3 dc3Var) {
        x72 x72Var = this.i;
        if (x72Var != null) {
            x72Var.setPlaybackParameters(dc3Var);
            dc3Var = this.i.getPlaybackParameters();
        }
        this.f.setPlaybackParameters(dc3Var);
    }
}
