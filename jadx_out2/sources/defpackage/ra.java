package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ra {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object[] a(Object[] objArr, int i) {
        objArr.getClass();
        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
        objNewInstance.getClass();
        return (Object[]) objNewInstance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void b(int i, int i2) {
        if (i <= i2) {
            return;
        }
        tg4.a("toIndex (", i, ") is greater than size (", i2);
    }
}
