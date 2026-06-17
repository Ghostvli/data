package defpackage;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ft0 {
    public abstract void a(ow3 ow3Var, Object obj);

    public abstract String b();

    public final long c(lw3 lw3Var, Object obj) throws Exception {
        lw3Var.getClass();
        if (obj == null) {
            return -1L;
        }
        ow3 ow3VarA0 = lw3Var.a0(b());
        try {
            a(ow3VarA0, obj);
            ow3VarA0.Y();
            ne.a(ow3VarA0, null);
            return mw3.a(lw3Var);
        } finally {
        }
    }

    public final List d(lw3 lw3Var, Collection collection) throws Exception {
        lw3Var.getClass();
        if (collection == null) {
            return ow.j();
        }
        List listC = nw.c();
        ow3 ow3VarA0 = lw3Var.a0(b());
        try {
            for (Object obj : collection) {
                if (obj != null) {
                    a(ow3VarA0, obj);
                    ow3VarA0.Y();
                    ow3VarA0.reset();
                    listC.add(Long.valueOf(mw3.a(lw3Var)));
                } else {
                    listC.add(-1L);
                }
            }
            fw4 fw4Var = fw4.a;
            ne.a(ow3VarA0, null);
            return nw.a(listC);
        } finally {
        }
    }
}
