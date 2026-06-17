package defpackage;

import defpackage.sz0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zw3 {
    public final e32 a = new e32(1000);
    public final tf3 b = sz0.d(10, new a());

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements sz0.d {
        public a() {
        }

        @Override // sz0.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                wg1.a(e);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements sz0.f {
        public final MessageDigest f;
        public final je4 g = je4.a();

        public b(MessageDigest messageDigest) {
            this.f = messageDigest;
        }

        @Override // sz0.f
        public je4 g() {
            return this.g;
        }
    }

    public final String a(wq1 wq1Var) {
        b bVar = (b) fg3.e((b) this.b.a());
        try {
            wq1Var.b(bVar.f);
            return iy4.y(bVar.f.digest());
        } finally {
            this.b.b(bVar);
        }
    }

    public String b(wq1 wq1Var) {
        String strA;
        synchronized (this.a) {
            strA = (String) this.a.g(wq1Var);
        }
        if (strA == null) {
            strA = a(wq1Var);
        }
        synchronized (this.a) {
            this.a.k(wq1Var, strA);
        }
        return strA;
    }
}
