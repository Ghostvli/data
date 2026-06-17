package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ny3 extends qv0 {
    public final int i;
    public final int j;
    public final long k;
    public final String l;
    public t40 m = i0();

    public ny3(int i, int i2, long j, String str) {
        this.i = i;
        this.j = i2;
        this.k = j;
        this.l = str;
    }

    @Override // defpackage.n40
    public void c0(g40 g40Var, Runnable runnable) {
        t40.v(this.m, runnable, false, false, 6, null);
    }

    @Override // defpackage.qv0
    public Executor h0() {
        return this.m;
    }

    public final t40 i0() {
        return new t40(this.i, this.j, this.k, this.l);
    }

    public final void j0(Runnable runnable, boolean z, boolean z2) {
        this.m.u(runnable, z, z2);
    }
}
