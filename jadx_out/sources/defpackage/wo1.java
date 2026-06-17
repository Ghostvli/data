package defpackage;

import android.graphics.Color;
import android.graphics.PointF;
import defpackage.no1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wo1 {
    public static final no1.a a = no1.a.a("x", "y");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[no1.b.values().length];
            a = iArr;
            try {
                iArr[no1.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[no1.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[no1.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(no1 no1Var, float f) {
        no1Var.c();
        float fV = (float) no1Var.v();
        float fV2 = (float) no1Var.v();
        while (no1Var.K() != no1.b.END_ARRAY) {
            no1Var.O();
        }
        no1Var.i();
        return new PointF(fV * f, fV2 * f);
    }

    public static PointF b(no1 no1Var, float f) {
        float fV = (float) no1Var.v();
        float fV2 = (float) no1Var.v();
        while (no1Var.t()) {
            no1Var.O();
        }
        return new PointF(fV * f, fV2 * f);
    }

    public static PointF c(no1 no1Var, float f) {
        no1Var.h();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (no1Var.t()) {
            int iM = no1Var.M(a);
            if (iM == 0) {
                fG = g(no1Var);
            } else if (iM != 1) {
                no1Var.N();
                no1Var.O();
            } else {
                fG2 = g(no1Var);
            }
        }
        no1Var.l();
        return new PointF(fG * f, fG2 * f);
    }

    public static int d(no1 no1Var) {
        no1Var.c();
        int iV = (int) (no1Var.v() * 255.0d);
        int iV2 = (int) (no1Var.v() * 255.0d);
        int iV3 = (int) (no1Var.v() * 255.0d);
        while (no1Var.t()) {
            no1Var.O();
        }
        no1Var.i();
        return Color.argb(255, iV, iV2, iV3);
    }

    public static PointF e(no1 no1Var, float f) {
        int i = a.a[no1Var.K().ordinal()];
        if (i == 1) {
            return b(no1Var, f);
        }
        if (i == 2) {
            return a(no1Var, f);
        }
        if (i == 3) {
            return c(no1Var, f);
        }
        nl.a("Unknown point starts with ", no1Var.K());
        return null;
    }

    public static List f(no1 no1Var, float f) {
        ArrayList arrayList = new ArrayList();
        no1Var.c();
        while (no1Var.K() == no1.b.BEGIN_ARRAY) {
            no1Var.c();
            arrayList.add(e(no1Var, f));
            no1Var.i();
        }
        no1Var.i();
        return arrayList;
    }

    public static float g(no1 no1Var) {
        no1.b bVarK = no1Var.K();
        int i = a.a[bVarK.ordinal()];
        if (i == 1) {
            return (float) no1Var.v();
        }
        if (i != 2) {
            c.a("Unknown value for token of type ", bVarK);
            return 0.0f;
        }
        no1Var.c();
        float fV = (float) no1Var.v();
        while (no1Var.t()) {
            no1Var.O();
        }
        no1Var.i();
        return fV;
    }
}
