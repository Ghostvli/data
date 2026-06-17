package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface bi4 {
    public static final bi4 a = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements bi4 {
        public final qh0 b = new qh0();

        @Override // defpackage.bi4
        public boolean a(t41 t41Var) {
            String str = t41Var.p;
            return this.b.a(t41Var) || Objects.equals(str, "application/cea-608") || Objects.equals(str, "application/x-mp4-cea-608") || Objects.equals(str, "application/cea-708");
        }

        @Override // defpackage.bi4
        public zh4 b(t41 t41Var) {
            String str = t41Var.p;
            if (str != null) {
                switch (str) {
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new zq(str, t41Var.M, 16000L);
                    case "application/cea-708":
                        return new br(t41Var.M, t41Var.s);
                }
            }
            if (this.b.a(t41Var)) {
                ki4 ki4VarB = this.b.b(t41Var);
                return new jj0(ki4VarB.getClass().getSimpleName().concat("Decoder"), ki4VarB);
            }
            c.a("Attempted to create decoder for unsupported MIME type: ", str);
            return null;
        }
    }

    boolean a(t41 t41Var);

    zh4 b(t41 t41Var);
}
