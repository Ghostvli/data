package defpackage;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class is1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[ls1.values().length];
            try {
                iArr[ls1.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ls1.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ls1.h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cs1 a(ls1 ls1Var, Function0 function0) {
        ls1Var.getClass();
        function0.getClass();
        int i = a.a[ls1Var.ordinal()];
        if (i == 1) {
            return new bk4(function0, null, 2, null);
        }
        if (i == 2) {
            return new ax3(function0);
        }
        if (i == 3) {
            return new uw4(function0);
        }
        throw new j33();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cs1 b(Function0 function0) {
        function0.getClass();
        return new bk4(function0, null, 2, null);
    }
}
