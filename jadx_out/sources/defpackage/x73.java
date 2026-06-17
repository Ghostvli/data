package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class x73 {
    public final int a;
    public final String b;
    public final String c;

    public x73(xs xsVar, String str, Object... objArr) {
        this.a = xsVar.A0();
        this.b = xsVar.B0();
        this.c = String.format(str, objArr);
    }

    public String toString() {
        return "<" + this.b + ">: " + this.c;
    }

    public x73(xs xsVar, String str) {
        this.a = xsVar.A0();
        this.b = xsVar.B0();
        this.c = str;
    }
}
