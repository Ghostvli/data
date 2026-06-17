package defpackage;

import android.os.Looper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class z5 implements a42 {
    @Override // defpackage.a42
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // defpackage.a42
    public z32 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new ic1(kc1.a(mainLooper, true), null, 2, null);
        }
        e04.a("The main looper is not available");
        return null;
    }

    @Override // defpackage.a42
    public int c() {
        return 1073741823;
    }
}
