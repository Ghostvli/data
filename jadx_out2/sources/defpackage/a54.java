package defpackage;

import android.graphics.Path;
import defpackage.p54;
import defpackage.zh;
import java.util.ArrayList;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a54(g22 g22Var, bi biVar, l54 l54Var) {
        this.b = l54Var.b();
        this.c = l54Var.d();
        this.d = g22Var;
        h54 h54VarA = l54Var.c().a();
        this.e = h54VarA;
        biVar.j(h54VarA);
        h54VarA.a(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void f() {
        this.f = false;
        this.d.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zh.b
    public void a() {
        f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // defpackage.k20
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(List list, List list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            k20 k20Var = (k20) list.get(i);
            if (k20Var instanceof nt4) {
                nt4 nt4Var = (nt4) k20Var;
                if (nt4Var.k() == p54.a.SIMULTANEOUSLY) {
                    this.g.a(nt4Var);
                    nt4Var.f(this);
                } else if (k20Var instanceof j54) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    j54 j54Var = (j54) k20Var;
                    j54Var.e(this);
                    arrayList.add(j54Var);
                }
            }
        }
        this.e.s(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        if (obj == q22.S) {
            this.e.o(y22Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public String getName() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ar1
    public void h(zq1 zq1Var, int i, List list, zq1 zq1Var2) {
        ot2.k(zq1Var, i, list, zq1Var2, this);
    }
}
