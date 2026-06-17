package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.session.u;
import androidx.media3.session.y;
import defpackage.b72;
import defpackage.cz;
import defpackage.fm2;
import defpackage.fy4;
import defpackage.pi2;
import defpackage.xz1;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y extends b72 {
    public final fm2 n;
    public final v o;
    public final b p;

    public y(v vVar) {
        this.n = fm2.a(vVar.j0());
        this.o = vVar;
        this.p = new b(vVar);
    }

    public static /* synthetic */ void u(y yVar, AtomicReference atomicReference, u.g gVar, cz czVar) {
        atomicReference.set(yVar.o.L0(gVar));
        czVar.f();
    }

    @Override // defpackage.b72
    public b72.e h(String str, int i, Bundle bundle) {
        fm2.b bVarD = d();
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        final u.g gVarV = v(bVarD, bundle);
        final AtomicReference atomicReference = new AtomicReference();
        final cz czVar = new cz();
        fy4.o1(this.o.e0(), new Runnable() { // from class: nm2
            @Override // java.lang.Runnable
            public final void run() {
                y.u(this.f, atomicReference, gVarV, czVar);
            }
        });
        try {
            czVar.a();
            u.e eVar = (u.e) atomicReference.get();
            if (!eVar.a) {
                return null;
            }
            this.p.e(bVarD, gVarV, eVar.b, eVar.c);
            return a0.a;
        } catch (InterruptedException e) {
            xz1.e("MSSLegacyStub", "Couldn't get a result from onConnect", e);
            return null;
        }
    }

    public abstract u.g v(fm2.b bVar, Bundle bundle);

    public final b w() {
        return this.p;
    }

    public final fm2 x() {
        return this.n;
    }

    public void y(pi2.h hVar) {
        c(this.o.j0());
        onCreate();
        t(hVar);
    }
}
