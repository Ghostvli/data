package defpackage;

import android.app.Dialog;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class r8 extends zk0 {
    @Override // defpackage.zk0
    public Dialog B2(Bundle bundle) {
        return new q8(U(), A2());
    }

    @Override // defpackage.zk0
    public void F2(Dialog dialog, int i) {
        if (!(dialog instanceof q8)) {
            super.F2(dialog, i);
            return;
        }
        q8 q8Var = (q8) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        q8Var.g(1);
    }
}
