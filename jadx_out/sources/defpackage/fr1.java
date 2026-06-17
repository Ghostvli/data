package defpackage;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.no1;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fr1 {
    public static mb4 b;
    public static final Interpolator a = new LinearInterpolator();
    public static no1.a c = no1.a.a("t", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "e", "o", "i", "h", "to", "ti");
    public static no1.a d = no1.a.a("x", "y");

    public static WeakReference a(int i) {
        WeakReference weakReference;
        synchronized (fr1.class) {
            weakReference = (WeakReference) g().d(i);
        }
        return weakReference;
    }

    public static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolatorA;
        pointF.x = ot2.b(pointF.x, -1.0f, 1.0f);
        pointF.y = ot2.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = ot2.b(pointF2.x, -1.0f, 1.0f);
        float fB = ot2.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        int i = uy4.i(pointF.x, pointF.y, pointF2.x, fB);
        WeakReference weakReferenceA = or1.e() ? null : a(i);
        Interpolator interpolator = weakReferenceA != null ? (Interpolator) weakReferenceA.get() : null;
        if (weakReferenceA != null && interpolator != null) {
            return interpolator;
        }
        try {
            interpolatorA = g93.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        } catch (IllegalArgumentException e) {
            interpolatorA = "The Path cannot loop back on itself.".equals(e.getMessage()) ? g93.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
        }
        if (!or1.e()) {
            try {
                h(i, new WeakReference(interpolatorA));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolatorA;
    }

    public static dr1 c(no1 no1Var, f12 f12Var, float f, cz4 cz4Var, boolean z, boolean z2) {
        return (z && z2) ? e(f12Var, no1Var, f, cz4Var) : z ? d(f12Var, no1Var, f, cz4Var) : f(no1Var, f, cz4Var);
    }

    public static dr1 d(f12 f12Var, no1 no1Var, float f, cz4 cz4Var) {
        Interpolator interpolatorB;
        Object obj;
        no1Var.h();
        PointF pointFE = null;
        Object objA = null;
        Object objA2 = null;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        float fV = 0.0f;
        boolean z = false;
        PointF pointFE4 = null;
        while (no1Var.t()) {
            switch (no1Var.M(c)) {
                case 0:
                    fV = (float) no1Var.v();
                    break;
                case 1:
                    objA2 = cz4Var.a(no1Var, f);
                    break;
                case 2:
                    objA = cz4Var.a(no1Var, f);
                    break;
                case 3:
                    pointFE = wo1.e(no1Var, 1.0f);
                    break;
                case 4:
                    pointFE4 = wo1.e(no1Var, 1.0f);
                    break;
                case 5:
                    z = no1Var.y() == 1;
                    break;
                case 6:
                    pointFE2 = wo1.e(no1Var, f);
                    break;
                case 7:
                    pointFE3 = wo1.e(no1Var, f);
                    break;
                default:
                    no1Var.O();
                    break;
            }
        }
        no1Var.l();
        if (z) {
            interpolatorB = a;
            obj = objA2;
        } else {
            interpolatorB = (pointFE == null || pointFE4 == null) ? a : b(pointFE, pointFE4);
            obj = objA;
        }
        dr1 dr1Var = new dr1(f12Var, objA2, obj, interpolatorB, fV, null);
        dr1Var.o = pointFE2;
        dr1Var.p = pointFE3;
        return dr1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.dr1 e(defpackage.f12 r21, defpackage.no1 r22, float r23, defpackage.cz4 r24) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fr1.e(f12, no1, float, cz4):dr1");
    }

    public static dr1 f(no1 no1Var, float f, cz4 cz4Var) {
        return new dr1(cz4Var.a(no1Var, f));
    }

    public static mb4 g() {
        if (b == null) {
            b = new mb4();
        }
        return b;
    }

    public static void h(int i, WeakReference weakReference) {
        synchronized (fr1.class) {
            b.g(i, weakReference);
        }
    }
}
