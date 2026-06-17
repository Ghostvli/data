package defpackage;

import android.util.SparseArray;
import defpackage.ki4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class li4 implements mz0 {
    public final mz0 f;
    public final ki4.a g;
    public final SparseArray h = new SparseArray();
    public boolean i;

    public li4(mz0 mz0Var, ki4.a aVar) {
        this.f = mz0Var;
        this.g = aVar;
    }

    @Override // defpackage.mz0
    public gr4 e(int i, int i2) {
        if (i2 != 3 && i2 != 5) {
            this.i = true;
        }
        if (i2 != 3) {
            return this.f.e(i, i2);
        }
        ni4 ni4Var = (ni4) this.h.get(i);
        if (ni4Var != null) {
            return ni4Var;
        }
        ni4 ni4Var2 = new ni4(this.f.e(i, i2), this.g);
        this.h.put(i, ni4Var2);
        return ni4Var2;
    }

    @Override // defpackage.mz0
    public void o() {
        this.f.o();
        if (this.i) {
            for (int i = 0; i < this.h.size(); i++) {
                ((ni4) this.h.valueAt(i)).k(true);
            }
        }
    }

    @Override // defpackage.mz0
    public void u(yz3 yz3Var) {
        this.f.u(yz3Var);
    }
}
