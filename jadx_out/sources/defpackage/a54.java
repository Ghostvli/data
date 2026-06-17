package defpackage;

import android.graphics.Path;
import defpackage.zh;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a54 implements f93, zh.b, br1 {
    public final String b;
    public final boolean c;
    public final g22 d;
    public final h54 e;
    public boolean f;
    public final Path a = new Path();
    public final uy g = new uy();

    public a54(g22 g22Var, bi biVar, l54 l54Var) {
        this.b = l54Var.b();
        this.c = l54Var.d();
        this.d = g22Var;
        h54 h54VarA = l54Var.c().a();
        this.e = h54VarA;
        biVar.j(h54VarA);
        h54VarA.a(this);
    }

    private void f() {
        this.f = false;
        this.d.invalidateSelf();
    }

    @Override // zh.b
    public void a() {
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // defpackage.k20
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.util.List r6, java.util.List r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            int r1 = r6.size()
            if (r0 >= r1) goto L3c
            java.lang.Object r1 = r6.get(r0)
            k20 r1 = (defpackage.k20) r1
            boolean r2 = r1 instanceof defpackage.nt4
            if (r2 == 0) goto L26
            r2 = r1
            nt4 r2 = (defpackage.nt4) r2
            p54$a r3 = r2.k()
            p54$a r4 = p54.a.SIMULTANEOUSLY
            if (r3 != r4) goto L26
            uy r1 = r5.g
            r1.a(r2)
            r2.f(r5)
            goto L39
        L26:
            boolean r2 = r1 instanceof defpackage.j54
            if (r2 == 0) goto L39
            if (r7 != 0) goto L31
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L31:
            j54 r1 = (defpackage.j54) r1
            r1.e(r5)
            r7.add(r1)
        L39:
            int r0 = r0 + 1
            goto L2
        L3c:
            h54 r5 = r5.e
            r5.s(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a54.b(java.util.List, java.util.List):void");
    }

    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        if (obj == q22.S) {
            this.e.o(y22Var);
        }
    }

    @Override // defpackage.k20
    public String getName() {
        return this.b;
    }

    @Override // defpackage.f93
    public Path getPath() {
        if (this.f && !this.e.k()) {
            return this.a;
        }
        this.a.reset();
        if (this.c) {
            this.f = true;
            return this.a;
        }
        Path path = (Path) this.e.h();
        Path path2 = this.a;
        if (path == null) {
            return path2;
        }
        path2.set(path);
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.g.b(this.a);
        this.f = true;
        return this.a;
    }

    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
    }
}
