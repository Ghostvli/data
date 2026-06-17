package defpackage;

import defpackage.c60;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bq implements Serializable {
    public int f = 1;
    public boolean g = true;
    public boolean h = true;
    public boolean i = true;
    public boolean j = true;
    public boolean k = false;
    public int l = 3000;
    public Integer m = null;
    public Class n = null;
    public Class o = null;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public bq a;

        public static a c() {
            a aVar = new a();
            bq bqVarL = c60.l();
            bq bqVar = new bq();
            bqVar.f = bqVarL.f;
            bqVar.g = bqVarL.g;
            bqVar.h = bqVarL.h;
            bqVar.i = bqVarL.i;
            bqVar.j = bqVarL.j;
            bqVar.k = bqVarL.k;
            bqVar.l = bqVarL.l;
            bqVar.m = bqVarL.m;
            bqVar.n = bqVarL.n;
            bq.w(bqVarL);
            bq.x(bqVar, null);
            bqVar.o = bqVarL.o;
            bq.g(bqVarL);
            bq.h(bqVar, null);
            aVar.a = bqVar;
            return aVar;
        }

        public void a() {
            c60.D(this.a);
        }

        public a b(int i) {
            this.a.f = i;
            return this;
        }

        public a d(Class cls) {
            this.a.n = cls;
            return this;
        }

        public a e(boolean z) {
            this.a.k = z;
            return this;
        }
    }

    public static /* synthetic */ c60.c g(bq bqVar) {
        bqVar.getClass();
        return null;
    }

    public static /* synthetic */ c60.c h(bq bqVar, c60.c cVar) {
        bqVar.getClass();
        return cVar;
    }

    public static /* synthetic */ c60.b w(bq bqVar) {
        bqVar.getClass();
        return null;
    }

    public static /* synthetic */ c60.b x(bq bqVar, c60.b bVar) {
        bqVar.getClass();
        return bVar;
    }

    public Class A() {
        return this.n;
    }

    public Integer B() {
        return this.m;
    }

    public c60.c C() {
        return null;
    }

    public int D() {
        return this.l;
    }

    public Class E() {
        return this.o;
    }

    public boolean F() {
        return this.g;
    }

    public boolean G() {
        return this.j;
    }

    public boolean H() {
        return this.h;
    }

    public boolean I() {
        return this.i;
    }

    public boolean J() {
        return this.k;
    }

    public void K(Class cls) {
        this.o = cls;
    }

    public int y() {
        return this.f;
    }

    public c60.b z() {
        return null;
    }
}
