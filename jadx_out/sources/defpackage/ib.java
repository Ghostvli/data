package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ib implements Runnable, ag3 {
    public final ka3 f = new ka3();
    public final uu0 g;

    public ib(uu0 uu0Var) {
        this.g = uu0Var;
    }

    @Override // defpackage.ag3
    public void a(sh4 sh4Var, Object obj) {
        this.f.a(ja3.a(sh4Var, obj));
        this.g.e().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        ja3 ja3VarB = this.f.b();
        if (ja3VarB != null) {
            this.g.h(ja3VarB);
        } else {
            e04.a("No pending post available");
        }
    }
}
