package androidx.lifecycle;

import android.os.Bundle;
import defpackage.ix3;
import defpackage.nx3;
import defpackage.qx3;
import defpackage.we0;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static final a c = new a(null);
    public final Map a;
    public ix3 b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public q(Map map) {
        map.getClass();
        this.a = new LinkedHashMap();
        this.b = new ix3(map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final qx3.b a() {
        return this.b.b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: androidx.lifecycle.q.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final q a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                bundle = bundle2;
            }
            if (bundle == null) {
                return new q();
            }
            ClassLoader classLoader = q.class.getClassLoader();
            classLoader.getClass();
            bundle.setClassLoader(classLoader);
            return new q(nx3.g(nx3.a(bundle)));
        }

        public a() {
        }
    }

    public q() {
        this.a = new LinkedHashMap();
        this.b = new ix3(null, 1, null);
    }
}
