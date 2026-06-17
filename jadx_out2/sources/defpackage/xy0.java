package defpackage;

import defpackage.i91;
import java.util.Collections;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xy0 {
    public static volatile xy0 b;
    public static final xy0 c = new xy0(true);
    public final Map a = Collections.EMPTY_MAP;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final Object a;
        public final int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return (System.identityHashCode(this.a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.b;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xy0(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xy0 b() {
        xy0 xy0VarA;
        if (s5.b) {
            return c;
        }
        xy0 xy0Var = b;
        if (xy0Var != null) {
            return xy0Var;
        }
        synchronized (xy0.class) {
            try {
                xy0VarA = b;
                if (xy0VarA == null) {
                    xy0VarA = wy0.a();
                    b = xy0VarA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xy0VarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i91.d a(rs2 rs2Var, int i) {
        return (i91.d) this.a.get(new a(rs2Var, i));
    }
}
