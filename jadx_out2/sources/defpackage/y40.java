package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class y40 {
    public static final y40 f = new y40("DEFAULT", 0);
    public static final y40 g = new y40("LAZY", 1);
    public static final y40 h = new y40("ATOMIC", 2);
    public static final y40 i = new y40("UNDISPATCHED", 3);
    public static final /* synthetic */ y40[] j;
    public static final /* synthetic */ gt0 k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[y40.values().length];
            try {
                iArr[y40.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[y40.h.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[y40.i.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[y40.g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        y40[] y40VarArrA = a();
        j = y40VarArrA;
        k = ht0.a(y40VarArrA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y40(String str, int i2) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final /* synthetic */ y40[] a() {
        return new y40[]{f, g, h, i};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static y40 valueOf(String str) {
        return (y40) Enum.valueOf(y40.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static y40[] values() {
        return (y40[]) j.clone();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(Function2 function2, Object obj, f30 f30Var) {
        int i2 = a.a[ordinal()];
        if (i2 == 1) {
            vp.c(function2, obj, f30Var);
            return;
        }
        if (i2 == 2) {
            i30.a(function2, obj, f30Var);
        } else if (i2 == 3) {
            aw4.a(function2, obj, f30Var);
        } else if (i2 != 4) {
            throw new j33();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e() {
        return this == g;
    }
}
