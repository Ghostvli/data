package defpackage;

import android.provider.Settings;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class tr3 extends zi {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tr3(oa3 oa3Var) {
        super(oa3Var);
        oa3Var.getClass();
    }

    @Override // defpackage.kr
    public void a(List list) {
        list.getClass();
        this.a.p(this);
    }

    @Override // defpackage.kr
    public void request() {
        if (!this.a.y()) {
            b();
            return;
        }
        int iE = this.a.e();
        oa3 oa3Var = this.a;
        if (iE < 23) {
            oa3Var.l.add("android.permission.WRITE_SETTINGS");
            this.a.h.remove("android.permission.WRITE_SETTINGS");
            b();
        } else {
            if (Settings.System.canWrite(oa3Var.b())) {
                b();
                return;
            }
            this.a.getClass();
            this.a.getClass();
            b();
        }
    }
}
