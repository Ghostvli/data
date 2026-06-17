package defpackage;

import android.content.Context;
import android.os.Build;
import defpackage.fk4;
import defpackage.mb;
import defpackage.y72;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lg0 implements y72.b {
    public final Context b;
    public final xi4 c;
    public final xi4 d;
    public int e;
    public boolean f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lg0() {
        this.e = 0;
        this.f = true;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // y72.b
    public y72 a(y72.a aVar) {
        xi4 xi4Var;
        int i = this.e;
        if (i != 1 && (i != 0 || !c())) {
            return new fk4.b().a(aVar);
        }
        int iK = nt2.k(aVar.c.p);
        xz1.g("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + fy4.D0(iK));
        xi4 xi4Var2 = this.c;
        mb.b bVar = (xi4Var2 == null || (xi4Var = this.d) == null) ? new mb.b(iK) : new mb.b(xi4Var2, xi4Var);
        bVar.f(this.f);
        return bVar.a(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            return true;
        }
        Context context = this.b;
        return context != null && i >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen");
    }

    public lg0(Context context) {
        this(context, null, null);
    }

    public lg0(Context context, xi4 xi4Var, xi4 xi4Var2) {
        this.b = context;
        this.e = 0;
        this.f = true;
        this.c = xi4Var;
        this.d = xi4Var2;
    }
}
