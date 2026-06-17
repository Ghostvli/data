package defpackage;

import defpackage.t90;
import defpackage.vt2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class iw4 implements vt2 {
    public static final iw4 a = new iw4();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements wt2 {
        public static final a a = new a();

        public static a a() {
            return a;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return iw4.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements t90 {
        public final Object f;

        public b(Object obj) {
            this.f = obj;
        }

        @Override // defpackage.t90
        public Class a() {
            return this.f.getClass();
        }

        @Override // defpackage.t90
        public void b() {
        }

        @Override // defpackage.t90
        public void c(ug3 ug3Var, t90.a aVar) {
            aVar.f(this.f);
        }

        @Override // defpackage.t90
        public void cancel() {
        }

        @Override // defpackage.t90
        public ba0 e() {
            return ba0.LOCAL;
        }
    }

    public static iw4 c() {
        return a;
    }

    @Override // defpackage.vt2
    public boolean a(Object obj) {
        return true;
    }

    @Override // defpackage.vt2
    public vt2.a b(Object obj, int i, int i2, u63 u63Var) {
        return new vt2.a(new t43(obj), new b(obj));
    }
}
