package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface zs2 {
    public static final zs2 a = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements zs2 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zs2
        public boolean a(t41 t41Var) {
            String str = t41Var.p;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.zs2
        public ys2 b(t41 t41Var) {
            String str = t41Var.p;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new u9();
                    case "application/x-icy":
                        return new th1();
                    case "application/id3":
                        return new xh1();
                    case "application/x-emsg":
                        return new ev0();
                    case "application/x-scte35":
                        return new vc4();
                }
            }
            c.a("Attempted to create decoder for unsupported MIME type: ", str);
            return null;
        }
    }

    boolean a(t41 t41Var);

    ys2 b(t41 t41Var);
}
