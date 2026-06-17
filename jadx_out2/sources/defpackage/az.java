package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class az {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(az.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(az.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public az(az azVar) {
        this._prev$volatile = azVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() {
        b.set(this, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final az d() {
        az azVarH = h();
        while (azVarH != null && azVarH.k()) {
            azVarH = (az) b.get(azVarH);
        }
        return azVarH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final az e() {
        az azVarF;
        az azVarF2 = f();
        azVarF2.getClass();
        while (azVarF2.k() && (azVarF = azVarF2.f()) != null) {
            azVarF2 = azVarF;
        }
        return azVarF2;
    }

    /* JADX DEBUG: Class process forced to load method for inline: zy.a():qj4 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final az f() {
        Object objG = g();
        if (objG == zy.a) {
            return null;
        }
        return (az) objG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object g() {
        return a.get(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final az h() {
        return (az) b.get(this);
    }

    public abstract boolean k();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l() {
        return f() == null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m() {
        return z0.a(a, this, null, zy.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            az azVarD = d();
            az azVarE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            do {
                obj = atomicReferenceFieldUpdater.get(azVarE);
            } while (!z0.a(atomicReferenceFieldUpdater, azVarE, obj, ((az) obj) == null ? null : azVarD));
            if (azVarD != null) {
                a.set(azVarD, azVarE);
            }
            if (!azVarE.k() || azVarE.l()) {
                if (azVarD == null || !azVarD.k()) {
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o(az azVar) {
        return z0.a(a, this, null, azVar);
    }
}
