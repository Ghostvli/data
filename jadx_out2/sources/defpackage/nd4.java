package defpackage;

import defpackage.kt3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class nd4 {
    public static final StackTraceElement a = new wa().a();
    public static final String b;
    public static final String c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        Object objB;
        Object objB2;
        try {
            kt3.a aVar = kt3.g;
            objB = kt3.b(hh.class.getCanonicalName());
        } catch (Throwable th) {
            kt3.a aVar2 = kt3.g;
            objB = kt3.b(lt3.a(th));
        }
        if (kt3.d(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        b = (String) objB;
        try {
            objB2 = kt3.b(nd4.class.getCanonicalName());
        } catch (Throwable th2) {
            kt3.a aVar3 = kt3.g;
            objB2 = kt3.b(lt3.a(th2));
        }
        if (kt3.d(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        c = (String) objB2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Throwable a(Throwable th) {
        return th;
    }
}
