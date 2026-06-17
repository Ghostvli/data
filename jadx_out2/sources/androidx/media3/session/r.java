package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.r;
import androidx.media3.session.u;
import androidx.media3.session.v;
import defpackage.du2;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.hh2;
import defpackage.jk;
import defpackage.lu1;
import defpackage.p81;
import defpackage.ph2;
import defpackage.pi2;
import defpackage.rc1;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xz1;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class r extends v {
    public final MediaLibraryService.c J;
    public final MediaLibraryService.c.b K;
    public final rc1 L;
    public final rc1 M;
    public final int N;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r(MediaLibraryService.c cVar, Context context, String str, hd3 hd3Var, PendingIntent pendingIntent, xi1 xi1Var, xi1 xi1Var2, xi1 xi1Var3, MediaLibraryService.c.b bVar, Bundle bundle, Bundle bundle2, jk jkVar, boolean z, boolean z2, int i) {
        super(cVar, context, str, hd3Var, pendingIntent, xi1Var, xi1Var2, xi1Var3, bVar, bundle, bundle2, jkVar, z, z2, false);
        this.J = cVar;
        this.K = bVar;
        this.N = i;
        this.L = rc1.H();
        this.M = rc1.H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object O1(Future future) {
        gg3.v(future.isDone());
        try {
            return future.get();
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            xz1.j("MediaSessionImpl", "Library operation failed", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void P1(j jVar, int i) {
        if (jVar.a == 0) {
            List list = (List) gg3.q((xi1) jVar.c);
            if (list.size() <= i) {
                return;
            }
            throw new IllegalStateException("Invalid size=" + list.size() + ", pageSize=" + i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void o1(r rVar, lu1 lu1Var, u.g gVar) {
        rVar.getClass();
        j jVar = (j) O1(lu1Var);
        if (jVar != null) {
            rVar.C1(gVar, jVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void p1(r rVar, lu1 lu1Var, u.g gVar, int i) {
        rVar.getClass();
        j jVar = (j) O1(lu1Var);
        if (jVar != null) {
            rVar.C1(gVar, jVar);
            P1(jVar, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ j q1(MediaLibraryService.b bVar, Throwable th) {
        xz1.e("MediaSessionImpl", "Failed fetching recent media item at boot time.", th);
        return j.f(-1, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ j r1(MediaLibraryService.b bVar, u.i iVar) {
        if (iVar.a.isEmpty()) {
            return j.f(-2, bVar);
        }
        return j.i(xi1.w((fg2) iVar.a.get(Math.max(0, Math.min(iVar.b, iVar.a.size() - 1)))), bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void s1(r rVar, lu1 lu1Var, u.g gVar, int i) {
        rVar.getClass();
        j jVar = (j) O1(lu1Var);
        if (jVar != null) {
            rVar.C1(gVar, jVar);
            P1(jVar, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void u1(r rVar, lu1 lu1Var, u.g gVar) {
        rVar.getClass();
        j jVar = (j) O1(lu1Var);
        if (jVar != null) {
            rVar.C1(gVar, jVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void v1(r rVar, lu1 lu1Var, u.g gVar, String str) {
        rVar.getClass();
        j jVar = (j) O1(lu1Var);
        if (jVar == null || jVar.a != 0) {
            rVar.N1(gVar, str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void x1(r rVar, String str, int i, MediaLibraryService.b bVar, u.f fVar, int i2) {
        if (rVar.B1(fVar, str)) {
            fVar.s(i2, str, i, bVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean A1(int i) {
        return i == -102 || i == -105;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized boolean B1(u.f fVar, String str) {
        return this.M.c(fVar, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C1(u.g gVar, j jVar) {
        if (this.N == 0 || gVar.d() != 0) {
            return;
        }
        if (A1(jVar.a)) {
            r0().c1(jVar, this.N == 1);
        }
        if (jVar.a == 0) {
            r0().x0();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D1(u.g gVar, final String str, final int i, final MediaLibraryService.b bVar) {
        if (G0() && F0(gVar) && (gVar = z0()) == null) {
            return;
        }
        c0(gVar, new v.e() { // from class: fh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.v.e
            public final void a(u.f fVar, int i2) {
                r.x1(this.a, str, i, bVar, fVar, i2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.v
    public boolean E0(u.g gVar) {
        if (super.E0(gVar)) {
            return true;
        }
        q qVarY1 = y1();
        return qVarY1 != null && qVarY1.w().p(gVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E1(String str, int i, MediaLibraryService.b bVar) {
        List listE = this.J.e();
        for (int i2 = 0; i2 < listE.size(); i2++) {
            D1((u.g) listE.get(i2), str, i, bVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F1(u.g gVar, final String str, final int i, final MediaLibraryService.b bVar) {
        if (G0() && F0(gVar) && (gVar = z0()) == null) {
            return;
        }
        c0(gVar, new v.e() { // from class: dh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.v.e
            public final void a(u.f fVar, int i2) {
                fVar.H(i2, str, i, bVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lu1 G1(final u.g gVar, String str, int i, final int i2, MediaLibraryService.b bVar) {
        if (Objects.equals(str, "androidx.media3.session.recent.root")) {
            return !R() ? x81.e(j.e(-6)) : v0().getPlaybackState() == 1 ? z1(gVar, bVar) : x81.e(j.i(xi1.w(new fg2.c().e("androidx.media3.session.recent.item").f(new ph2.b().f0(Boolean.FALSE).g0(Boolean.TRUE).L()).a()), bVar));
        }
        final lu1 lu1VarOnGetChildren = this.K.onGetChildren(this.J, a1(gVar), str, i, i2, bVar);
        lu1VarOnGetChildren.g(new Runnable() { // from class: gh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                r.s1(this.f, lu1VarOnGetChildren, gVar, i2);
            }
        }, new hh2(this));
        return lu1VarOnGetChildren;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lu1 H1(final u.g gVar, String str) {
        final lu1 lu1VarOnGetItem = this.K.onGetItem(this.J, a1(gVar), str);
        lu1VarOnGetItem.g(new Runnable() { // from class: jh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                r.u1(this.f, lu1VarOnGetItem, gVar);
            }
        }, new hh2(this));
        return lu1VarOnGetItem;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lu1 I1(u.g gVar, MediaLibraryService.b bVar) {
        return (bVar != null && bVar.b && I0(gVar)) ? !R() ? x81.e(j.e(-6)) : x81.e(j.h(new fg2.c().e("androidx.media3.session.recent.root").f(new ph2.b().f0(Boolean.TRUE).g0(Boolean.FALSE).L()).a(), bVar)) : this.K.onGetLibraryRoot(this.J, a1(gVar), bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lu1 J1(final u.g gVar, String str, int i, final int i2, MediaLibraryService.b bVar) {
        final lu1 lu1VarOnGetSearchResult = this.K.onGetSearchResult(this.J, a1(gVar), str, i, i2, bVar);
        lu1VarOnGetSearchResult.g(new Runnable() { // from class: eh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                r.p1(this.f, lu1VarOnGetSearchResult, gVar, i2);
            }
        }, new hh2(this));
        return lu1VarOnGetSearchResult;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lu1 K1(final u.g gVar, String str, MediaLibraryService.b bVar) {
        final lu1 lu1VarOnSearch = this.K.onSearch(this.J, a1(gVar), str, bVar);
        lu1VarOnSearch.g(new Runnable() { // from class: kh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                r.o1(this.f, lu1VarOnSearch, gVar);
            }
        }, new hh2(this));
        return lu1VarOnSearch;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lu1 L1(final u.g gVar, final String str, MediaLibraryService.b bVar) {
        u.f fVar = (u.f) gg3.q(gVar.c());
        synchronized (this) {
            this.M.put(fVar, str);
            this.L.put(str, gVar);
        }
        final lu1 lu1Var = (lu1) gg3.r(this.K.onSubscribe(this.J, a1(gVar), str, bVar), "onSubscribe must return non-null future");
        lu1Var.g(new Runnable() { // from class: ih2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                r.v1(this.f, lu1Var, gVar, str);
            }
        }, new hh2(this));
        return lu1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lu1 M1(final u.g gVar, final String str) {
        lu1 lu1VarOnUnsubscribe = this.K.onUnsubscribe(this.J, a1(gVar), str);
        lu1VarOnUnsubscribe.g(new Runnable() { // from class: lh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.N1(gVar, str);
            }
        }, new hh2(this));
        return lu1VarOnUnsubscribe;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized void N1(u.g gVar, String str) {
        u.f fVar = (u.f) gg3.q(gVar.c());
        this.L.remove(str, gVar);
        this.M.remove(fVar, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.v
    public void O0(u.g gVar) {
        u.f fVar = (u.f) gg3.q(gVar.c());
        synchronized (this) {
            try {
                Iterator it = this.M.G(fVar).iterator();
                while (it.hasNext()) {
                    this.L.remove((String) it.next(), gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.O0(gVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.v
    public y U(pi2.h hVar) {
        q qVar = new q(this);
        qVar.y(hVar);
        return qVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y0(Runnable runnable) {
        fy4.o1(e0(), runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.v
    public List i0() {
        List listI0 = super.i0();
        q qVarY1 = y1();
        if (qVarY1 == null) {
            return listI0;
        }
        xi1 xi1VarJ = qVarY1.w().j();
        return xi1.n(listI0.size() + xi1VarJ.size()).j(listI0).j(xi1VarJ).k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public q y1() {
        return (q) super.m0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lu1 z1(u.g gVar, final MediaLibraryService.b bVar) {
        if (G0()) {
            gVar = (u.g) gg3.q(q0());
        }
        return x81.b(x81.g(this.K.onPlaybackResumption(this.J, gVar, false), new p81() { // from class: mh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return r.r1(bVar, (u.i) obj);
            }
        }, du2.b()), Throwable.class, new p81() { // from class: nh2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return r.q1(bVar, (Throwable) obj);
            }
        }, du2.b());
    }
}
