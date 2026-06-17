package defpackage;

import android.graphics.PointF;
import defpackage.zh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class nu3 implements j54, zh.b {
    public final g22 a;
    public final String b;
    public final zh c;
    public b54 d;

    public nu3(g22 g22Var, bi biVar, mu3 mu3Var) {
        this.a = g22Var;
        this.b = mu3Var.c();
        zh zhVarA = mu3Var.b().a();
        this.c = zhVarA;
        biVar.j(zhVarA);
        zhVarA.a(this);
    }

    public static int f(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    public static int g(int i, int i2) {
        return i - (f(i, i2) * i2);
    }

    @Override // zh.b
    public void a() {
        this.a.invalidateSelf();
    }

    @Override // defpackage.k20
    public void b(List list, List list2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009e  */
    @Override // defpackage.j54
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.b54 c(defpackage.b54 r18) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nu3.c(b54):b54");
    }

    @Override // defpackage.j54
    public void e(zh.b bVar) {
        this.c.a(bVar);
    }

    public zh h() {
        return this.c;
    }

    public final b54 j(b54 b54Var) {
        List listA = b54Var.a();
        boolean zD = b54Var.d();
        int size = listA.size() - 1;
        int i = 0;
        while (size >= 0) {
            o50 o50Var = (o50) listA.get(size);
            o50 o50Var2 = (o50) listA.get(g(size - 1, listA.size()));
            PointF pointFC = (size != 0 || zD) ? o50Var2.c() : b54Var.b();
            i = (((size != 0 || zD) ? o50Var2.b() : pointFC).equals(pointFC) && o50Var.a().equals(pointFC) && !(!b54Var.d() && (size == 0 || size == listA.size() - 1))) ? i + 2 : i + 1;
            size--;
        }
        b54 b54Var2 = this.d;
        if (b54Var2 == null || b54Var2.a().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new o50());
            }
            this.d = new b54(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.d.e(zD);
        return this.d;
    }
}
