package defpackage;

import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ss1 {
    public final iq0 a;
    public final d b = new d();
    public final Stack c = new Stack();
    public final Stack d = new Stack();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ip4.values().length];
            a = iArr;
            try {
                iArr[ip4.LP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ip4.LC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ip4.RP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ip4.RC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ip4.CASE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ip4.COLON.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ip4.RETURN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ip4.YIELD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ip4.YIELD_STAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final boolean a;
        public final f b;

        public b(boolean z, f fVar) {
            this.a = z;
            this.b = fVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends e {
        public final b c;

        public c(ip4 ip4Var, int i, b bVar) {
            super(ip4Var, i);
            this.c = bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final e[] a = new e[3];

        public e a() {
            return this.a[0];
        }

        public boolean b(ip4 ip4Var) {
            e eVar = this.a[0];
            return eVar != null && eVar.a == ip4Var;
        }

        public void c(e eVar) {
            int i = 0;
            while (i < 3) {
                e[] eVarArr = this.a;
                e eVar2 = eVarArr[i];
                eVarArr[i] = eVar;
                i++;
                eVar = eVar2;
            }
        }

        public e d() {
            return this.a[2];
        }

        public e e() {
            return this.a[1];
        }

        public boolean f(ip4 ip4Var) {
            e eVar = this.a[1];
            return eVar != null && eVar.a == ip4Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public final ip4 a;
        public final int b;

        public e(ip4 ip4Var, int i) {
            this.a = ip4Var;
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f {
        public final boolean a;
        public final boolean b;

        public f(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends e {
        public final f c;

        public g(ip4 ip4Var, int i, f fVar) {
            super(ip4Var, i);
            this.c = fVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h {
        public final ip4 a;
        public final int b;
        public final int c;

        public h(ip4 ip4Var, int i, int i2) {
            this.a = ip4Var;
            this.b = i;
            this.c = i2;
        }
    }

    public ss1(String str) {
        this.a = new iq0(str, 0, false);
    }

    public boolean a(ip4 ip4Var) {
        return ip4Var.f || ip4Var == ip4.RETURN || ip4Var == ip4.CASE;
    }

    public h b() throws s83 {
        ip4 ip4VarR = this.a.r();
        if ((ip4VarR == ip4.DIV || ip4VarR == ip4.ASSIGN_DIV) && h()) {
            this.a.u(ip4VarR);
            ip4VarR = ip4.REGEXP;
        }
        iq0 iq0Var = this.a;
        h hVar = new h(ip4VarR, iq0Var.k, iq0Var.l);
        i(hVar);
        return hVar;
    }

    public void c(int i) throws s83 {
        if (!this.c.isEmpty()) {
            this.b.c(new c(ip4.RC, this.a.g, (b) this.c.pop()));
        } else {
            throw new s83("unmatched closing brace at " + i);
        }
    }

    public void d(int i) throws s83 {
        if (!this.d.isEmpty()) {
            this.b.c(new g(ip4.RP, this.a.g, (f) this.d.pop()));
        } else {
            throw new s83("unmatched closing paren at " + i);
        }
    }

    public void e() {
        boolean z = true;
        if (this.b.a() != null) {
            int i = a.a[this.b.a().a.ordinal()];
            if (i != 1 && i != 2) {
                switch (i) {
                    case 5:
                        z = false;
                        break;
                    case 6:
                        if (this.c.isEmpty() || !((b) this.c.lastElement()).a) {
                            z = false;
                        }
                        break;
                    case 7:
                    case 8:
                    case 9:
                        if (this.b.e() == null || this.b.e().b == this.a.g) {
                            z = false;
                        }
                        break;
                    default:
                        z = true ^ this.b.a().a.f;
                        break;
                }
            } else {
                z = false;
            }
        }
        b bVar = new b(z, ((this.b.a() instanceof g) && this.b.a().a == ip4.RP) ? ((g) this.b.a()).c : null);
        this.c.push(bVar);
        this.b.c(new c(ip4.LC, this.a.g, bVar));
    }

    public void f() {
        d dVar = this.b;
        ip4 ip4Var = ip4.FUNCTION;
        boolean zB = dVar.b(ip4Var);
        d dVar2 = this.b;
        f fVar = new f(!zB ? !(dVar2.f(ip4Var) && this.b.d() != null && a(this.b.d().a)) : dVar2.e() == null || !a(this.b.e().a), this.b.a() != null && this.b.a().a.a());
        this.d.push(fVar);
        this.b.c(new g(ip4.LP, this.a.g, fVar));
    }

    public boolean g() {
        return this.c.isEmpty() && this.d.isEmpty();
    }

    public boolean h() {
        if (this.b.a() == null) {
            return true;
        }
        ip4 ip4Var = this.b.a().a;
        if (ip4Var.h) {
            return ip4Var != ip4.THIS;
        }
        if (ip4Var == ip4.RP && (this.b.a() instanceof g)) {
            return ((g) this.b.a()).c.b;
        }
        if (ip4Var != ip4.RC || !(this.b.a() instanceof c)) {
            return ip4Var.g && ip4Var != ip4.RB;
        }
        b bVar = ((c) this.b.a()).c;
        if (!bVar.a) {
            return false;
        }
        if (bVar.b != null) {
            return !r4.a;
        }
        return true;
    }

    public void i(h hVar) throws s83 {
        ip4 ip4Var = hVar.a;
        if (ip4Var.g) {
            int i = a.a[ip4Var.ordinal()];
            if (i == 1) {
                f();
                return;
            }
            if (i == 2) {
                e();
                return;
            } else if (i == 3) {
                d(hVar.b);
                return;
            } else if (i == 4) {
                c(hVar.b);
                return;
            }
        }
        ip4 ip4Var2 = hVar.a;
        if (ip4Var2 != ip4.COMMENT) {
            this.b.c(new e(ip4Var2, this.a.g));
        }
    }
}
