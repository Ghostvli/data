package defpackage;

import android.net.Uri;
import defpackage.xy1;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pt implements xy1.e {
    public final long a = ty1.b();
    public final ja0 b;
    public final int c;
    public final t41 d;
    public final int e;
    public final Object f;
    public final long g;
    public final long h;
    public final ne4 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pt(aa0 aa0Var, ja0 ja0Var, int i, t41 t41Var, int i2, Object obj, long j, long j2) {
        this.i = new ne4(aa0Var);
        this.b = (ja0) gg3.q(ja0Var);
        this.c = i;
        this.d = t41Var;
        this.e = i2;
        this.f = obj;
        this.g = j;
        this.h = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long a() {
        return this.i.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long d() {
        return this.h - this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map e() {
        return this.i.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Uri f() {
        return this.i.t();
    }
}
