package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class k70 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final void a(lw3 lw3Var) {
        lw3Var.getClass();
        List listC = nw.c();
        ow3 ow3VarA0 = lw3Var.a0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (ow3VarA0.Y()) {
            try {
                listC.add(ow3VarA0.I(0));
            } finally {
            }
        }
        fw4 fw4Var = fw4.a;
        ne.a(ow3VarA0, null);
        for (String str : nw.a(listC)) {
            if (sg4.K(str, "room_fts_content_sync_", false, 2, null)) {
                kw3.a(lw3Var, "DROP TRIGGER IF EXISTS " + str);
            }
        }
    }
}
