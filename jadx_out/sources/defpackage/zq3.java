package defpackage;

import android.os.Build;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class zq3 extends zi {
    public static final a e = new a(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zq3(oa3 oa3Var) {
        super(oa3Var);
        oa3Var.getClass();
    }

    @Override // defpackage.kr
    public void a(List list) {
        list.getClass();
        this.a.i(this);
    }

    @Override // defpackage.kr
    public void request() {
        if (this.a.s()) {
            int i = Build.VERSION.SDK_INT;
            oa3 oa3Var = this.a;
            if (i < 29) {
                oa3Var.h.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                this.a.k.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                b();
                return;
            } else {
                if (ua3.d(oa3Var.b(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    b();
                    return;
                }
                boolean zD = ua3.d(this.a.b(), "android.permission.ACCESS_FINE_LOCATION");
                boolean zD2 = ua3.d(this.a.b(), "android.permission.ACCESS_COARSE_LOCATION");
                if (zD || zD2) {
                    this.a.getClass();
                    this.a.getClass();
                    a(ow.j());
                    return;
                }
            }
        }
        b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
