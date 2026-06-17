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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nu3(g22 g22Var, bi biVar, mu3 mu3Var) {
        this.a = g22Var;
        this.b = mu3Var.c();
        zh zhVarA = mu3Var.b().a();
        this.c = zhVarA;
        biVar.j(zhVarA);
        zhVarA.a(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(int i, int i2) {
        return i - (f(i, i2) * i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // zh.b
    public void a() {
        this.a.invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public void b(List list, List list2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009e  */
    @Override // defpackage.j54
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b54 c(b54 b54Var) {
        boolean z;
        List list;
        b54 b54Var2;
        List listA = b54Var.a();
        if (listA.size() > 2) {
            float fFloatValue = ((Float) this.c.h()).floatValue();
            if (fFloatValue != 0.0f) {
                b54 b54VarJ = j(b54Var);
                b54VarJ.f(b54Var.b().x, b54Var.b().y);
                List listA2 = b54VarJ.a();
                boolean zD = b54Var.d();
                int i = 0;
                int i2 = 0;
                while (i < listA.size()) {
                    o50 o50Var = (o50) listA.get(i);
                    o50 o50Var2 = (o50) listA.get(g(i - 1, listA.size()));
                    o50 o50Var3 = (o50) listA.get(g(i - 2, listA.size()));
                    PointF pointFC = (i != 0 || zD) ? o50Var2.c() : b54Var.b();
                    PointF pointFB = (i != 0 || zD) ? o50Var2.b() : pointFC;
                    PointF pointFA = o50Var.a();
                    PointF pointFC2 = o50Var3.c();
                    PointF pointFC3 = o50Var.c();
                    if (!b54Var.d()) {
                        z = true;
                        if (i != 0 && i != listA.size() - 1) {
                            z = false;
                        }
                    }
                    if (pointFB.equals(pointFC) && pointFA.equals(pointFC) && !z) {
                        float f = pointFC.x;
                        float f2 = f - pointFC2.x;
                        float f3 = pointFC.y;
                        float f4 = f3 - pointFC2.y;
                        float f5 = pointFC3.x - f;
                        float f6 = pointFC3.y - f3;
                        list = listA;
                        b54 b54Var3 = b54VarJ;
                        float fHypot = (float) Math.hypot(f2, f4);
                        float fHypot2 = (float) Math.hypot(f5, f6);
                        float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                        float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                        float f7 = pointFC.x;
                        float f8 = ((pointFC2.x - f7) * fMin) + f7;
                        float f9 = pointFC.y;
                        float f10 = ((pointFC2.y - f9) * fMin) + f9;
                        float f11 = ((pointFC3.x - f7) * fMin2) + f7;
                        float f12 = ((pointFC3.y - f9) * fMin2) + f9;
                        float f13 = f8 - ((f8 - f7) * 0.5519f);
                        float f14 = f10 - ((f10 - f9) * 0.5519f);
                        float f15 = f11 - ((f11 - f7) * 0.5519f);
                        float f16 = f12 - ((f12 - f9) * 0.5519f);
                        o50 o50Var4 = (o50) listA2.get(g(i2 - 1, listA2.size()));
                        o50 o50Var5 = (o50) listA2.get(i2);
                        o50Var4.e(f8, f10);
                        o50Var4.f(f8, f10);
                        b54Var2 = b54Var3;
                        if (i == 0) {
                            b54Var2.f(f8, f10);
                        }
                        o50Var5.d(f13, f14);
                        o50 o50Var6 = (o50) listA2.get(i2 + 1);
                        o50Var5.e(f15, f16);
                        o50Var5.f(f11, f12);
                        o50Var6.d(f11, f12);
                        i2 += 2;
                    } else {
                        list = listA;
                        b54Var2 = b54VarJ;
                        o50 o50Var7 = (o50) listA2.get(g(i2 - 1, listA2.size()));
                        o50 o50Var8 = (o50) listA2.get(i2);
                        o50Var7.e(o50Var2.b().x, o50Var2.b().y);
                        o50Var7.f(o50Var2.c().x, o50Var2.c().y);
                        o50Var8.d(o50Var.a().x, o50Var.a().y);
                        i2++;
                    }
                    i++;
                    b54VarJ = b54Var2;
                    listA = list;
                }
                return b54VarJ;
            }
        }
        return b54Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.j54
    public void e(zh.b bVar) {
        this.c.a(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zh h() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
