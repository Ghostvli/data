package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class dr3 {
    public zi a;
    public zi b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(zi ziVar) {
        ziVar.getClass();
        if (this.a == null) {
            this.a = ziVar;
        }
        zi ziVar2 = this.b;
        if (ziVar2 != null) {
            ziVar2.b = ziVar;
        }
        this.b = ziVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b() {
        zi ziVar = this.a;
        if (ziVar != null) {
            ziVar.request();
        }
    }
}
