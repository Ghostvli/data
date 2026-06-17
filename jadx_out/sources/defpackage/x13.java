package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class x13 extends x63 implements Serializable {
    public static final x13 f = new x13();

    @Override // defpackage.x63
    public x63 g() {
        return rt3.f;
    }

    @Override // defpackage.x63, java.util.Comparator
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        gg3.q(comparable);
        gg3.q(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
