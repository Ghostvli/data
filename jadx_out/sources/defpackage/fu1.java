package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class fu1 extends vt1 {
    public final List i;
    public final String j;

    public fu1(vt1 vt1Var) {
        this(vt1Var.f, vt1Var.g, vt1Var.h, Collections.EMPTY_LIST, "");
    }

    public fu1(String str, String str2, String str3, List list, String str4) {
        super(str, str2, str3);
        this.i = Collections.unmodifiableList(list);
        this.j = str4;
    }
}
