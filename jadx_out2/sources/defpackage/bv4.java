package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import defpackage.j41;
import defpackage.k41;
import defpackage.ps3;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bv4 {
    public static final hv4 a;
    public static final f32 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends k41.c {
        public ps3.e a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(ps3.e eVar) {
            this.a = eVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // k41.c
        public void a(int i) {
            ps3.e eVar = this.a;
            if (eVar != null) {
                eVar.f(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // k41.c
        public void b(Typeface typeface) {
            ps3.e eVar = this.a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        dq4.a("TypefaceCompat static init");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new gv4();
        } else if (i >= 28) {
            a = new fv4();
        } else if (i >= 26) {
            a = new ev4();
        } else if (dv4.k()) {
            a = new dv4();
        } else {
            a = new cv4();
        }
        b = new f32(16);
        dq4.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        jl.a("Context cannot be null");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Typeface b(Context context, CancellationSignal cancellationSignal, k41.b[] bVarArr, int i) {
        dq4.a("TypefaceCompat.createFromFontInfo");
        try {
            return a.b(context, cancellationSignal, bVarArr, i);
        } finally {
            dq4.b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i) {
        dq4.a("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return a.c(context, cancellationSignal, list, i);
        } finally {
            dq4.b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Typeface d(Context context, j41.b bVar, Resources resources, int i, String str, int i2, int i3, ps3.e eVar, Handler handler, boolean z) {
        Typeface typefaceA;
        if (bVar instanceof j41.e) {
            j41.e eVar2 = (j41.e) bVar;
            Typeface typefaceH = h(eVar2.d());
            if (typefaceH != null) {
                if (eVar != null) {
                    eVar.d(typefaceH, handler);
                }
                return typefaceH;
            }
            typefaceA = k41.c(context, eVar2.a() != null ? av4.a(new Object[]{eVar2.c(), eVar2.a()}) : av4.a(new Object[]{eVar2.c()}), i3, !z ? eVar != null : eVar2.b() != 0, z ? eVar2.e() : -1, ps3.e.e(handler), new a(eVar));
        } else {
            typefaceA = a.a(context, (j41.c) bVar, resources, i3);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            b.e(f(resources, i, str, i2, i3), typefaceA);
        }
        return typefaceA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Typeface e(Context context, Resources resources, int i, String str, int i2, int i3) {
        Typeface typefaceE = a.e(context, resources, i, str, i3);
        if (typefaceE != null) {
            b.e(f(resources, i, str, i2, i3), typefaceE);
        }
        return typefaceE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String f(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Typeface g(Resources resources, int i, String str, int i2, int i3) {
        return (Typeface) b.d(f(resources, i, str, i2, i3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Typeface h(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }
}
