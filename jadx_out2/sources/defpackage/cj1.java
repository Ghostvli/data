package defpackage;

import defpackage.xi1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cj1 extends x0 implements Serializable {
    public static final cj1 h = new cj1(xi1.u());
    public static final cj1 i = new cj1(xi1.w(rn3.a()));
    public final transient xi1 f;
    public final transient cj1 g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final List a = new ArrayList();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a a(rn3 rn3Var) {
            gg3.k(!rn3Var.g(), "range must not be empty, but was %s", rn3Var);
            this.a.add(rn3Var);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a b(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a((rn3) it.next());
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public cj1 c() {
            xi1.a aVar = new xi1.a(this.a.size());
            Collections.sort(this.a, rn3.h());
            w93 w93VarP = lm1.p(this.a.iterator());
            while (w93VarP.hasNext()) {
                rn3 rn3VarI = (rn3) w93VarP.next();
                while (w93VarP.hasNext()) {
                    rn3 rn3Var = (rn3) w93VarP.peek();
                    if (rn3VarI.f(rn3Var)) {
                        gg3.m(rn3VarI.e(rn3Var).g(), "Overlapping ranges not permitted but found %s overlapping %s", rn3VarI, rn3Var);
                        rn3VarI = rn3VarI.i((rn3) w93VarP.next());
                    }
                }
                aVar.a(rn3VarI);
            }
            xi1 xi1VarK = aVar.k();
            return xi1VarK.isEmpty() ? cj1.e() : (xi1VarK.size() == 1 && ((rn3) km1.g(xi1VarK)).equals(rn3.a())) ? cj1.b() : new cj1(xi1VarK);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a d(a aVar) {
            b(aVar.a);
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cj1(xi1 xi1Var, cj1 cj1Var) {
        this.f = xi1Var;
        this.g = cj1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cj1 b() {
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a d() {
        return new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cj1 e() {
        return h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a()Ljava/util/Set; */
    @Override // defpackage.un3
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public dj1 a() {
        return this.f.isEmpty() ? dj1.u() : new cq3(this.f, rn3.h());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public cj1(xi1 xi1Var) {
        this(xi1Var, null);
    }
}
