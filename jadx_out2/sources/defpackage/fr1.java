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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static WeakReference a(int i) {
        WeakReference weakReference;
        synchronized (fr1.class) {
            weakReference = (WeakReference) g().d(i);
        }
        return weakReference;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static dr1 c(no1 no1Var, f12 f12Var, float f, cz4 cz4Var, boolean z, boolean z2) {
        return (z && z2) ? e(f12Var, no1Var, f, cz4Var) : z ? d(f12Var, no1Var, f, cz4Var) : f(no1Var, f, cz4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static dr1 e(f12 f12Var, no1 no1Var, float f, cz4 cz4Var) {
        Interpolator interpolatorB;
        Interpolator interpolatorB2;
        Interpolator interpolatorB3;
        Object obj;
        Interpolator interpolator;
        PointF pointF;
        PointF pointF2;
        dr1 dr1Var;
        PointF pointF3;
        boolean z;
        float f2;
        no1Var.h();
        boolean z2 = false;
        PointF pointFE = null;
        PointF pointFE2 = null;
        PointF pointF4 = null;
        Object objA = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        float fV = 0.0f;
        Object objA2 = null;
        while (no1Var.t()) {
            switch (no1Var.M(c)) {
                case 0:
                    fV = (float) no1Var.v();
                    break;
                case 1:
                    objA = cz4Var.a(no1Var, f);
                    break;
                case 2:
                    objA2 = cz4Var.a(no1Var, f);
                    break;
                case 3:
                    boolean z3 = z2;
                    if (no1Var.K() == no1.b.BEGIN_OBJECT) {
                        no1Var.h();
                        float fV2 = 0.0f;
                        float fV3 = 0.0f;
                        float fV4 = 0.0f;
                        float fV5 = 0.0f;
                        while (no1Var.t()) {
                            int iM = no1Var.M(d);
                            if (iM == 0) {
                                pointF3 = pointF6;
                                no1.b bVarK = no1Var.K();
                                no1.b bVar = no1.b.NUMBER;
                                if (bVarK == bVar) {
                                    fV4 = (float) no1Var.v();
                                    fV2 = fV4;
                                } else {
                                    no1Var.c();
                                    fV2 = (float) no1Var.v();
                                    fV4 = no1Var.K() == bVar ? (float) no1Var.v() : fV2;
                                    no1Var.i();
                                }
                            } else if (iM != 1) {
                                no1Var.O();
                            } else {
                                no1.b bVarK2 = no1Var.K();
                                no1.b bVar2 = no1.b.NUMBER;
                                if (bVarK2 == bVar2) {
                                    pointF3 = pointF6;
                                    fV5 = (float) no1Var.v();
                                    fV3 = fV5;
                                } else {
                                    pointF3 = pointF6;
                                    no1Var.c();
                                    fV3 = (float) no1Var.v();
                                    fV5 = no1Var.K() == bVar2 ? (float) no1Var.v() : fV3;
                                    no1Var.i();
                                }
                            }
                            pointF6 = pointF3;
                        }
                        pointF4 = new PointF(fV2, fV3);
                        pointF5 = new PointF(fV4, fV5);
                        no1Var.l();
                    } else {
                        pointFE = wo1.e(no1Var, f);
                    }
                    z2 = z3;
                    break;
                case 4:
                    if (no1Var.K() != no1.b.BEGIN_OBJECT) {
                        pointFE2 = wo1.e(no1Var, f);
                    } else {
                        no1Var.h();
                        float f3 = 0.0f;
                        float f4 = 0.0f;
                        float fV6 = 0.0f;
                        float fV7 = 0.0f;
                        while (no1Var.t()) {
                            int iM2 = no1Var.M(d);
                            if (iM2 != 0) {
                                z = z2;
                                if (iM2 != 1) {
                                    no1Var.O();
                                } else {
                                    no1.b bVarK3 = no1Var.K();
                                    no1.b bVar3 = no1.b.NUMBER;
                                    if (bVarK3 == bVar3) {
                                        fV7 = (float) no1Var.v();
                                        f4 = fV7;
                                    } else {
                                        no1Var.c();
                                        PointF pointF8 = pointFE3;
                                        float fV8 = (float) no1Var.v();
                                        fV7 = no1Var.K() == bVar3 ? (float) no1Var.v() : fV8;
                                        no1Var.i();
                                        pointFE3 = pointF8;
                                        f4 = fV8;
                                    }
                                }
                            } else {
                                z = z2;
                                PointF pointF9 = pointFE3;
                                no1.b bVarK4 = no1Var.K();
                                no1.b bVar4 = no1.b.NUMBER;
                                if (bVarK4 == bVar4) {
                                    pointFE3 = pointF9;
                                    fV6 = (float) no1Var.v();
                                    f3 = fV6;
                                } else {
                                    pointFE3 = pointF9;
                                    no1Var.c();
                                    float fV9 = (float) no1Var.v();
                                    if (no1Var.K() == bVar4) {
                                        f2 = fV9;
                                        fV6 = (float) no1Var.v();
                                    } else {
                                        f2 = fV9;
                                        fV6 = f2;
                                    }
                                    no1Var.i();
                                    f3 = f2;
                                }
                            }
                            z2 = z;
                        }
                        PointF pointF10 = new PointF(f3, f4);
                        PointF pointF11 = new PointF(fV6, fV7);
                        no1Var.l();
                        pointF7 = pointF11;
                        pointF6 = pointF10;
                    }
                    break;
                case 5:
                    z2 = no1Var.y() == 1;
                    break;
                case 6:
                    pointFE3 = wo1.e(no1Var, f);
                    break;
                case 7:
                    pointFE4 = wo1.e(no1Var, f);
                    break;
                default:
                    no1Var.O();
                    break;
            }
        }
        boolean z4 = z2;
        PointF pointF12 = pointF6;
        no1Var.l();
        if (z4) {
            interpolator = a;
            obj = objA;
        } else {
            if (pointFE == null || pointFE2 == null) {
                if (pointF4 != null && pointF5 != null && pointF12 != null && pointF7 != null) {
                    interpolatorB2 = b(pointF4, pointF12);
                    interpolatorB3 = b(pointF5, pointF7);
                    obj = objA2;
                    interpolator = null;
                    if (interpolatorB2 != null || interpolatorB3 == null) {
                        pointF = pointFE3;
                        pointF2 = pointFE4;
                        dr1Var = new dr1(f12Var, objA, obj, interpolator, fV, null);
                    } else {
                        pointF2 = pointFE4;
                        pointF = pointFE3;
                        dr1Var = new dr1(f12Var, objA, obj, interpolatorB2, interpolatorB3, fV, null);
                    }
                    dr1Var.o = pointF;
                    dr1Var.p = pointF2;
                    return dr1Var;
                }
                interpolatorB = a;
            } else {
                interpolatorB = b(pointFE, pointFE2);
            }
            interpolator = interpolatorB;
            obj = objA2;
        }
        interpolatorB2 = null;
        interpolatorB3 = null;
        if (interpolatorB2 != null) {
            pointF = pointFE3;
            pointF2 = pointFE4;
            dr1Var = new dr1(f12Var, objA, obj, interpolator, fV, null);
        }
        dr1Var.o = pointF;
        dr1Var.p = pointF2;
        return dr1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static dr1 f(no1 no1Var, float f, cz4 cz4Var) {
        return new dr1(cz4Var.a(no1Var, f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static mb4 g() {
        if (b == null) {
            b = new mb4();
        }
        return b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(int i, WeakReference weakReference) {
        synchronized (fr1.class) {
            b.g(i, weakReference);
        }
    }
}
