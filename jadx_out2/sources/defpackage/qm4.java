package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class qm4 extends er1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends y22 {
        public final /* synthetic */ k22 d;
        public final /* synthetic */ y22 e;
        public final /* synthetic */ xm0 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(k22 k22Var, y22 y22Var, xm0 xm0Var) {
            this.d = k22Var;
            this.e = y22Var;
            this.f = xm0Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Lk22;)Ljava/lang/Object; */
        @Override // defpackage.y22
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public xm0 a(k22 k22Var) {
            this.d.h(k22Var.f(), k22Var.a(), ((xm0) k22Var.g()).a, ((xm0) k22Var.b()).a, k22Var.d(), k22Var.c(), k22Var.e());
            String str = (String) this.e.a(this.d);
            xm0 xm0Var = (xm0) (k22Var.c() == 1.0f ? k22Var.b() : k22Var.g());
            this.f.a(str, xm0Var.b, xm0Var.c, xm0Var.d, xm0Var.e, xm0Var.f, xm0Var.g, xm0Var.h, xm0Var.i, xm0Var.j, xm0Var.k, xm0Var.l, xm0Var.m);
            return this.f;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qm4(List list) {
        super(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i(Ldr1;F)Ljava/lang/Object; */
    @Override // defpackage.zh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public xm0 i(dr1 dr1Var, float f) {
        Object obj;
        y22 y22Var = this.e;
        if (y22Var == null) {
            return (f != 1.0f || (obj = dr1Var.c) == null) ? (xm0) dr1Var.b : (xm0) obj;
        }
        float f2 = dr1Var.g;
        Float f3 = dr1Var.h;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        Object obj2 = dr1Var.b;
        xm0 xm0Var = (xm0) obj2;
        Object obj3 = dr1Var.c;
        return (xm0) y22Var.b(f2, fFloatValue, xm0Var, obj3 == null ? (xm0) obj2 : (xm0) obj3, f, d(), f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(y22 y22Var) {
        super.o(new a(new k22(), y22Var, new xm0()));
    }
}
