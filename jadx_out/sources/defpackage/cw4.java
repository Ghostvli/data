package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cw4 extends RuntimeException {
    public final List f;

    public cw4(rs2 rs2Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f = null;
    }

    public ol1 a() {
        return new ol1(getMessage());
    }
}
