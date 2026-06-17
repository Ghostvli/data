package defpackage;

import defpackage.g40;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface h30 extends g40.b {
    public static final b b = b.f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static g40.b a(h30 h30Var, g40.c cVar) {
            g40.b bVarB;
            cVar.getClass();
            if (!(cVar instanceof y)) {
                if (h30.b != cVar) {
                    return null;
                }
                h30Var.getClass();
                return h30Var;
            }
            y yVar = (y) cVar;
            if (!yVar.a(h30Var.getKey()) || (bVarB = yVar.b(h30Var)) == null) {
                return null;
            }
            return bVarB;
        }

        public static g40 b(h30 h30Var, g40.c cVar) {
            cVar.getClass();
            if (!(cVar instanceof y)) {
                return h30.b == cVar ? bs0.f : h30Var;
            }
            y yVar = (y) cVar;
            return (!yVar.a(h30Var.getKey()) || yVar.b(h30Var) == null) ? h30Var : bs0.f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements g40.c {
        public static final /* synthetic */ b f = new b();
    }

    f30 Q(f30 f30Var);

    void Z(f30 f30Var);
}
