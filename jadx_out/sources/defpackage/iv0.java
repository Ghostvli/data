package defpackage;

import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class iv0 {
    public final dv0[] a;
    public final long[] b;
    public final String c;
    public final String d;
    public final long e;

    public iv0(String str, String str2, long j, long[] jArr, dv0[] dv0VarArr) {
        this.c = str;
        this.d = str2;
        this.e = j;
        this.b = jArr;
        this.a = dv0VarArr;
    }

    public String a() {
        return this.c + ServiceReference.DELIMITER + this.d;
    }
}
