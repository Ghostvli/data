package defpackage;

import android.content.Context;
import defpackage.bu3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xt3 {
    public static final xt3 a = new xt3();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final bu3.a a(Context context, Class cls, String str) {
        context.getClass();
        cls.getClass();
        if (str == null || wg4.c0(str)) {
            jl.a("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
            return null;
        }
        if (!il1.a(str, ":memory:")) {
            return new bu3.a(context, cls, str);
        }
        jl.a("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        return null;
    }
}
