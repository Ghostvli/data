package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class uh extends p51 {
    public boolean i0;
    public boolean j0;

    @Override // defpackage.p51
    public View Z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return u2(layoutInflater, viewGroup).getRoot();
    }

    @Override // defpackage.p51
    public void c1() {
        super.c1();
        this.i0 = false;
        this.j0 = false;
    }

    @Override // defpackage.p51
    public void m2(boolean z) {
        super.m2(z);
        if (z && this.i0 && !this.j0) {
            y2();
            this.j0 = true;
        }
    }

    public boolean t2() {
        return true;
    }

    @Override // defpackage.p51
    public void u1(View view, Bundle bundle) {
        this.i0 = true;
        if (A0()) {
            y2();
            this.j0 = true;
        }
    }

    public abstract i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void v2() {
    }

    public void w2() {
    }

    public void x2() {
    }

    public final void y2() {
        w2();
        x2();
        v2();
    }
}
