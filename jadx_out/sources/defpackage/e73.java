package defpackage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class e73 implements Serializable {
    public final String f;
    public final String g;
    public final List h;
    public final Map i;
    public final byte[] j;

    public e73(String str, String str2, List list, Map map, byte[] bArr) {
        this.f = str;
        this.g = str2;
        this.h = list;
        this.i = map;
        this.j = bArr;
    }

    public static boolean d(e73 e73Var) {
        if (e73Var != null) {
            return (yy4.n(e73Var.c()) && yy4.o(e73Var.b())) ? false : true;
        }
        return false;
    }

    public byte[] a() {
        return this.j;
    }

    public List b() {
        return this.h;
    }

    public String c() {
        return this.f;
    }

    public e73(String str, byte[] bArr) {
        this(str, null, null, null, bArr);
    }
}
