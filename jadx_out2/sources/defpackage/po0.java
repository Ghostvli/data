package defpackage;

import defpackage.wo0;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface po0 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends IOException {
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Throwable th, int i) {
            super(th);
            this.f = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static void b(po0 po0Var, po0 po0Var2) {
        if (po0Var == po0Var2) {
            return;
        }
        if (po0Var2 != null) {
            po0Var2.f(null);
        }
        if (po0Var != null) {
            po0Var.d(null);
        }
    }

    UUID a();

    boolean c();

    void d(wo0.a aVar);

    Map e();

    void f(wo0.a aVar);

    boolean g(String str);

    a getError();

    int getState();

    f50 h();
}
