package defpackage;

import android.graphics.Color;
import android.graphics.Rect;
import defpackage.no1;
import defpackage.yr1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zr1 {
    public static final no1.a a = no1.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");
    public static final no1.a b = no1.a.a("d", "a");
    public static final no1.a c = no1.a.a("ty", "nm");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[yr1.b.values().length];
            a = iArr;
            try {
                iArr[yr1.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[yr1.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yr1 a(no1 no1Var, f12 f12Var) {
        Float f;
        boolean z;
        float f2;
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        yr1.b bVar = yr1.b.NONE;
        pr1 pr1Var = pr1.NORMAL;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        no1Var.h();
        boolean z2 = false;
        yr1.b bVar2 = bVar;
        pr1 pr1Var2 = pr1Var;
        float fV = 0.0f;
        float f3 = 0.0f;
        float fV2 = 0.0f;
        float fV3 = 0.0f;
        float fV4 = 0.0f;
        String strF = null;
        s6 s6VarD = null;
        t6 t6VarA = null;
        j6 j6VarF = null;
        xk xkVarB = null;
        ep0 ep0VarB = null;
        long jY = 0;
        int iY = 0;
        int iY2 = 0;
        int color = 0;
        boolean zU = false;
        long jY2 = -1;
        float fV5 = 1.0f;
        String strF2 = "UNSET";
        String strF3 = null;
        x6 x6Var = null;
        yr1.a aVar = null;
        boolean z3 = false;
        while (no1Var.t()) {
            switch (no1Var.M(a)) {
                case 0:
                    strF2 = no1Var.F();
                    z2 = false;
                    break;
                case 1:
                    jY = no1Var.y();
                    z2 = false;
                    break;
                case 2:
                    strF = no1Var.F();
                    z2 = false;
                    break;
                case 3:
                    f2 = fV5;
                    int iY3 = no1Var.y();
                    aVar = yr1.a.UNKNOWN;
                    if (iY3 < aVar.ordinal()) {
                        aVar = yr1.a.values()[iY3];
                    }
                    fV5 = f2;
                    z2 = false;
                    break;
                case 4:
                    jY2 = no1Var.y();
                    z2 = false;
                    break;
                case 5:
                    iY = (int) (no1Var.y() * uy4.e());
                    z2 = false;
                    break;
                case 6:
                    iY2 = (int) (no1Var.y() * uy4.e());
                    z2 = false;
                    break;
                case 7:
                    color = Color.parseColor(no1Var.F());
                    z2 = false;
                    break;
                case 8:
                    x6Var = y6.h(no1Var, f12Var);
                    z2 = false;
                    break;
                case 9:
                    f2 = fV5;
                    int iY4 = no1Var.y();
                    if (iY4 >= yr1.b.values().length) {
                        f12Var.a("Unsupported matte type: " + iY4);
                    } else {
                        bVar2 = yr1.b.values()[iY4];
                        int i = a.a[bVar2.ordinal()];
                        if (i == 1) {
                            f12Var.a("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            f12Var.a("Unsupported matte type: Luma Inverted");
                        }
                        f12Var.r(1);
                    }
                    fV5 = f2;
                    z2 = false;
                    break;
                case 10:
                    f2 = fV5;
                    no1Var.c();
                    while (no1Var.t()) {
                        arrayList.add(g52.a(no1Var, f12Var));
                    }
                    f12Var.r(arrayList.size());
                    no1Var.i();
                    fV5 = f2;
                    z2 = false;
                    break;
                case 11:
                    f2 = fV5;
                    no1Var.c();
                    while (no1Var.t()) {
                        v20 v20VarA = w20.a(no1Var, f12Var);
                        if (v20VarA != null) {
                            arrayList2.add(v20VarA);
                        }
                    }
                    no1Var.i();
                    fV5 = f2;
                    z2 = false;
                    break;
                case 12:
                    f2 = fV5;
                    no1Var.h();
                    while (no1Var.t()) {
                        int iM = no1Var.M(b);
                        if (iM == 0) {
                            s6VarD = a7.d(no1Var, f12Var);
                        } else if (iM != 1) {
                            no1Var.N();
                            no1Var.O();
                        } else {
                            no1Var.c();
                            if (no1Var.t()) {
                                t6VarA = u6.a(no1Var, f12Var);
                            }
                            while (no1Var.t()) {
                                no1Var.O();
                            }
                            no1Var.i();
                        }
                    }
                    no1Var.l();
                    fV5 = f2;
                    z2 = false;
                    break;
                case 13:
                    f2 = fV5;
                    no1Var.c();
                    ArrayList arrayList3 = new ArrayList();
                    while (no1Var.t()) {
                        no1Var.h();
                        while (no1Var.t()) {
                            int iM2 = no1Var.M(c);
                            if (iM2 == 0) {
                                int iY5 = no1Var.y();
                                if (iY5 == 29) {
                                    xkVarB = yk.b(no1Var, f12Var);
                                } else if (iY5 == 25) {
                                    ep0VarB = new fp0().b(no1Var, f12Var);
                                }
                            } else if (iM2 != 1) {
                                no1Var.N();
                                no1Var.O();
                            } else {
                                arrayList3.add(no1Var.F());
                            }
                        }
                        no1Var.l();
                    }
                    no1Var.i();
                    f12Var.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    fV5 = f2;
                    z2 = false;
                    break;
                case 14:
                    fV5 = (float) no1Var.v();
                    z2 = false;
                    break;
                case 15:
                    fV4 = (float) no1Var.v();
                    z2 = false;
                    break;
                case 16:
                    f2 = fV5;
                    fV2 = (float) (no1Var.v() * ((double) uy4.e()));
                    fV5 = f2;
                    z2 = false;
                    break;
                case 17:
                    f2 = fV5;
                    fV3 = (float) (no1Var.v() * ((double) uy4.e()));
                    fV5 = f2;
                    z2 = false;
                    break;
                case 18:
                    fV = (float) no1Var.v();
                    break;
                case 19:
                    f3 = (float) no1Var.v();
                    break;
                case 20:
                    j6VarF = a7.f(no1Var, f12Var, z2);
                    break;
                case 21:
                    strF3 = no1Var.F();
                    break;
                case 22:
                    zU = no1Var.u();
                    break;
                case 23:
                    z3 = no1Var.y() != 1 ? z2 : true;
                    break;
                case 24:
                    int iY6 = no1Var.y();
                    if (iY6 < pr1.values().length) {
                        pr1Var2 = pr1.values()[iY6];
                    } else {
                        f12Var.a("Unsupported Blend Mode: " + iY6);
                        pr1Var2 = pr1.NORMAL;
                    }
                    break;
                default:
                    no1Var.N();
                    no1Var.O();
                    f2 = fV5;
                    fV5 = f2;
                    z2 = false;
                    break;
            }
        }
        float f4 = fV5;
        no1Var.l();
        ArrayList arrayList4 = new ArrayList();
        if (fV > 0.0f) {
            z = z3;
            f = fValueOf;
            arrayList4.add(new dr1(f12Var, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fV)));
        } else {
            f = fValueOf;
            z = z3;
        }
        if (f3 <= 0.0f) {
            f3 = f12Var.f();
        }
        arrayList4.add(new dr1(f12Var, fValueOf2, fValueOf2, null, fV, Float.valueOf(f3)));
        arrayList4.add(new dr1(f12Var, f, f, null, f3, Float.valueOf(Float.MAX_VALUE)));
        if (strF2.endsWith(".ai") || "ai".equals(strF3)) {
            f12Var.a("Convert your Illustrator layers to shape layers.");
        }
        if (z) {
            if (x6Var == null) {
                x6Var = new x6();
            }
            x6Var.p(z);
        }
        return new yr1(arrayList2, f12Var, strF2, jY, aVar, jY2, strF, arrayList, x6Var, iY, iY2, color, f4, fV4, fV2, fV3, s6VarD, t6VarA, arrayList4, bVar2, j6VarF, zU, xkVarB, ep0VarB, pr1Var2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yr1 b(f12 f12Var) {
        Rect rectB = f12Var.b();
        List list = Collections.EMPTY_LIST;
        return new yr1(list, f12Var, "__container", -1L, yr1.a.PRE_COMP, -1L, null, list, new x6(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, list, yr1.b.NONE, null, false, null, null, pr1.NORMAL);
    }
}
