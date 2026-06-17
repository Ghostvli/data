package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface lo {
    public static final lo a = new lo() { // from class: ko
        @Override // defpackage.lo
        public final String b(ja0 ja0Var) {
            return lo.a(ja0Var);
        }
    };

    static /* synthetic */ String a(ja0 ja0Var) {
        String str = ja0Var.i;
        return str != null ? str : ja0Var.a.toString();
    }

    String b(ja0 ja0Var);
}
