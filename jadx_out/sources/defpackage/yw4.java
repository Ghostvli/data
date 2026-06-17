package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yw4 implements s94 {
    public final int a;
    public final wi1 b;

    public yw4(int i, int[] iArr) {
        this.a = i;
        this.b = iArr != null ? wi1.b(iArr) : wi1.g();
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(this.b.f());
        for (int i = 0; i < this.b.f(); i++) {
            arrayList.add(fy4.M1(this.b.c(i)));
        }
        return "UnsupportedBrands{major=" + fy4.M1(this.a) + ", compatible=" + arrayList + "}";
    }
}
