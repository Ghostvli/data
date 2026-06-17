package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class er implements yh4 {
    public final List f;

    public er(List list) {
        this.f = list;
    }

    @Override // defpackage.yh4
    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // defpackage.yh4
    public long b(int i) {
        gg3.d(i == 0);
        return 0L;
    }

    @Override // defpackage.yh4
    public List e(long j) {
        return j >= 0 ? this.f : Collections.EMPTY_LIST;
    }

    @Override // defpackage.yh4
    public int f() {
        return 1;
    }
}
