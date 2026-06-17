package defpackage;

import defpackage.bu3;
import defpackage.hu3;
import defpackage.jj4;
import defpackage.qi;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zt3 extends qi {
    public final ma0 d;
    public final hu3 e;
    public final List f;
    public final n00 g;
    public final jj4 h;
    public hj4 i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends hu3 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            super(-1, "", "");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hu3
        public void a(lw3 lw3Var) {
            lw3Var.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hu3
        public void b(lw3 lw3Var) {
            lw3Var.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hu3
        public void f(lw3 lw3Var) {
            lw3Var.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hu3
        public void g(lw3 lw3Var) {
            lw3Var.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hu3
        public void h(lw3 lw3Var) {
            lw3Var.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hu3
        public void i(lw3 lw3Var) {
            lw3Var.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hu3
        public hu3.a j(lw3 lw3Var) {
            lw3Var.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends jj4.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // jj4.a
        public void d(hj4 hj4Var) {
            hj4Var.getClass();
            zt3.this.x(new gj4(hj4Var));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // jj4.a
        public void e(hj4 hj4Var, int i, int i2) {
            hj4Var.getClass();
            g(hj4Var, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // jj4.a
        public void f(hj4 hj4Var) {
            hj4Var.getClass();
            zt3.this.z(new gj4(hj4Var));
            zt3.this.i = hj4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // jj4.a
        public void g(hj4 hj4Var, int i, int i2) {
            hj4Var.getClass();
            zt3.this.y(new gj4(hj4Var), i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends bu3.b {
        public final /* synthetic */ Function1 a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // bu3.b
        public void f(hj4 hj4Var) {
            hj4Var.getClass();
            this.a.invoke(hj4Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zt3(ma0 ma0Var, hu3 hu3Var, Function2 function2) {
        n00 n00VarB;
        ma0Var.getClass();
        hu3Var.getClass();
        function2.getClass();
        this.d = ma0Var;
        this.e = hu3Var;
        List list = ma0Var.e;
        this.f = list == null ? ow.j() : list;
        nw3 nw3Var = ma0Var.t;
        if (nw3Var != null) {
            this.h = null;
            if (nw3Var.b()) {
                qi.b bVar = new qi.b(this, ma0Var.t);
                String str = ma0Var.b;
                n00VarB = new z83(bVar, str != null ? str : ":memory:", function2);
            } else {
                String str2 = ma0Var.b;
                nw3 nw3Var2 = ma0Var.t;
                n00VarB = str2 == null ? t00.b(new qi.b(this, nw3Var2), ":memory:", ma0Var.d()) : t00.a(new qi.b(this, nw3Var2), ma0Var.b, p(ma0Var.g), q(ma0Var.g), ma0Var.d());
            }
            this.g = n00VarB;
        } else {
            if (ma0Var.c == null) {
                jl.a("SQLiteManager was constructed with both null driver and open helper factory!");
                throw null;
            }
            jj4 jj4VarA = ma0Var.c.a(jj4.b.f.a(ma0Var.a).c(ma0Var.b).b(new b(hu3Var.e())).a());
            this.h = jj4VarA;
            ij4 ij4Var = new ij4(jj4VarA);
            String str3 = ma0Var.b;
            this.g = new z83(ij4Var, str3 != null ? str3 : ":memory:", function2);
        }
        G();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 C(zt3 zt3Var, hj4 hj4Var) {
        hj4Var.getClass();
        zt3Var.i = hj4Var;
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qi
    public String A(String str) {
        str.getClass();
        if (il1.a(str, ":memory:")) {
            return str;
        }
        String absolutePath = o().a.getDatabasePath(str).getAbsolutePath();
        absolutePath.getClass();
        return absolutePath;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E() {
        this.g.close();
        jj4 jj4Var = this.h;
        if (jj4Var != null) {
            jj4Var.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final jj4 F() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G() {
        boolean z = o().g == bu3.d.h;
        jj4 jj4Var = this.h;
        if (jj4Var != null) {
            jj4Var.setWriteAheadLoggingEnabled(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ma0 H(ma0 ma0Var, Function1 function1) {
        List listJ = ma0Var.e;
        if (listJ == null) {
            listJ = ow.j();
        }
        return ma0.b(ma0Var, null, null, null, null, ww.U(listJ, new c(function1)), false, null, null, null, null, false, false, null, null, null, null, null, null, null, false, null, null, 4194287, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean I() {
        hj4 hj4Var = this.i;
        if (hj4Var != null) {
            return hj4Var.isOpen();
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object J(boolean z, Function2 function2, f30 f30Var) {
        return this.g.X(z, function2, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qi
    public List n() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qi
    public ma0 o() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qi
    public hu3 r() {
        return this.e;
    }

    public zt3(ma0 ma0Var, Function1 function1, Function2 function2) {
        ma0Var.getClass();
        function1.getClass();
        function2.getClass();
        this.d = ma0Var;
        this.e = new a();
        List list = ma0Var.e;
        this.f = list == null ? ow.j() : list;
        jj4 jj4Var = (jj4) function1.invoke(H(ma0Var, new Function1() { // from class: yt3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return zt3.C(this.f, (hj4) obj);
            }
        }));
        this.h = jj4Var;
        ij4 ij4Var = new ij4(jj4Var);
        String str = ma0Var.b;
        this.g = new z83(ij4Var, str == null ? ":memory:" : str, function2);
        G();
    }
}
