package defpackage;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class og1 extends mg1 {
    public final int i;
    public final String j;
    public final Map k;
    public final byte[] l;

    public og1(int i, String str, IOException iOException, Map map, ja0 ja0Var, byte[] bArr) {
        super("Response code: " + i, iOException, ja0Var, 2004, 1);
        this.i = i;
        this.j = str;
        this.k = map;
        this.l = bArr;
    }
}
