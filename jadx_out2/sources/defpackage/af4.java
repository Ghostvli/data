package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class af4 extends xj1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public af4(int i) {
        super(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d(Lwj1;)V */
    @Override // defpackage.xj1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(ze4 ze4Var) {
        try {
            c(a(ze4Var));
        } catch (l51 unused) {
        } catch (Exception e) {
            b(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // defpackage.yw
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public ye4 a(ze4 ze4Var) throws l51 {
        if (ze4Var.f()) {
            throw new l51("Found ad");
        }
        ye4 ye4Var = new ye4(g(), ze4Var.getUrl(), ze4Var.getName(), ze4Var.o());
        try {
            ye4Var.j(ze4Var.getDuration());
        } catch (Exception e) {
            b(e);
        }
        try {
            ye4Var.p(ze4Var.d());
        } catch (Exception e2) {
            b(e2);
        }
        try {
            ye4Var.m(ze4Var.l());
        } catch (Exception e3) {
            b(e3);
        }
        try {
            ye4Var.n(ze4Var.m());
        } catch (s83 e4) {
            b(e4);
        }
        try {
            ye4Var.s(ze4Var.e());
        } catch (Exception e5) {
            b(e5);
        }
        try {
            ye4Var.f(ze4Var.n());
        } catch (Exception e6) {
            b(e6);
        }
        try {
            ye4Var.q(ze4Var.a());
        } catch (Exception e7) {
            b(e7);
        }
        try {
            ye4Var.o(ze4Var.g());
        } catch (Exception e8) {
            b(e8);
        }
        try {
            ye4Var.r(ze4Var.b());
        } catch (Exception e9) {
            b(e9);
        }
        try {
            ye4Var.k(ze4Var.q());
        } catch (Exception e10) {
            b(e10);
        }
        try {
            ye4Var.l(ze4Var.k());
        } catch (Exception e11) {
            b(e11);
        }
        try {
            ye4Var.i(ze4Var.j());
        } catch (Exception e12) {
            b(e12);
        }
        return ye4Var;
    }
}
