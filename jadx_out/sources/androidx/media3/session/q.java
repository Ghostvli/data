package androidx.media3.session;

import android.graphics.Bitmap;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.j;
import androidx.media3.session.q;
import androidx.media3.session.u;
import defpackage.b72;
import defpackage.cz;
import defpackage.d24;
import defpackage.du2;
import defpackage.fg2;
import defpackage.fm2;
import defpackage.fy4;
import defpackage.gb;
import defpackage.gg3;
import defpackage.lu1;
import defpackage.p24;
import defpackage.ph2;
import defpackage.u43;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xz1;
import defpackage.y14;
import defpackage.z62;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class q extends y {
    public final r q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements u.f {
        public final fm2.b b;
        public final Object a = new Object();
        public final List c = new ArrayList();

        public a(fm2.b bVar) {
            this.b = bVar;
        }

        public static /* synthetic */ void M(a aVar, List list) {
            int i;
            int i2;
            int i3;
            int i4;
            aVar.getClass();
            for (int i5 = 0; i5 < list.size(); i5++) {
                c cVar = (c) list.get(i5);
                Bundle bundle = cVar.d;
                if (bundle != null) {
                    try {
                        bundle.setClassLoader(q.this.q.j0().getClassLoader());
                        i = cVar.d.getInt("android.media.browse.extra.PAGE", -1);
                        i2 = cVar.d.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                    } catch (BadParcelableException unused) {
                        cVar.e.g(null);
                        return;
                    }
                } else {
                    i = 0;
                    i2 = Integer.MAX_VALUE;
                }
                if (i < 0 || i2 < 1) {
                    i3 = 0;
                    i4 = Integer.MAX_VALUE;
                } else {
                    i3 = i;
                    i4 = i2;
                }
                q.a0(cVar.e, fy4.Q1(q.this.q.J1(cVar.a, cVar.c, i3, i4, i.q(q.this.q.j0(), cVar.d)), q.this.U()));
            }
        }

        @Override // androidx.media3.session.u.f
        public void H(int i, String str, int i2, MediaLibraryService.b bVar) {
            final ArrayList arrayList = new ArrayList();
            synchronized (this.a) {
                try {
                    for (int size = this.c.size() - 1; size >= 0; size--) {
                        c cVar = (c) this.c.get(size);
                        if (Objects.equals(this.b, cVar.b) && cVar.c.equals(str)) {
                            arrayList.add(cVar);
                            this.c.remove(size);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    fy4.o1(q.this.q.e0(), new Runnable() { // from class: ch2
                        @Override // java.lang.Runnable
                        public final void run() {
                            q.a.M(this.f, arrayList);
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void O(u.g gVar, String str, Bundle bundle, b72.k kVar) {
            synchronized (this.a) {
                this.c.add(new c(gVar, gVar.g(), str, bundle, kVar));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return Objects.equals(this.b, ((a) obj).b);
            }
            return false;
        }

        public int hashCode() {
            return u43.b(this.b);
        }

        @Override // androidx.media3.session.u.f
        public void s(int i, String str, int i2, MediaLibraryService.b bVar) {
            Bundle bundle = bVar != null ? bVar.a : null;
            q qVar = q.this;
            fm2.b bVar2 = this.b;
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            qVar.f(bVar2, str, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements u.j {
        public final r a;
        public final b72.k b;
        public lu1 c;

        public b(r rVar, b72.k kVar) {
            this.a = rVar;
            this.b = kVar;
        }

        public void a(lu1 lu1Var) {
            this.c = lu1Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final u.g a;
        public final fm2.b b;
        public final String c;
        public final Bundle d;
        public final b72.k e;

        public c(u.g gVar, fm2.b bVar, String str, Bundle bundle, b72.k kVar) {
            this.a = gVar;
            this.b = bVar;
            this.c = str;
            this.d = bundle;
            this.e = kVar;
        }
    }

    public q(r rVar) {
        super(rVar);
        this.q = rVar;
    }

    public static /* synthetic */ void A(q qVar, u.g gVar, String str) {
        if (qVar.w().r(gVar, 50002)) {
            X(qVar.q.M1(gVar, str));
        }
    }

    public static /* synthetic */ void B(lu1 lu1Var, b72.k kVar) {
        try {
            kVar.g((z62.g) lu1Var.get());
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            xz1.j("MLSLegacyStub", "Library operation failed", e);
            kVar.g(null);
        }
    }

    public static /* synthetic */ void C(q qVar, u.g gVar, b72.k kVar, String str, Bundle bundle) {
        if (!qVar.w().r(gVar, 50005)) {
            kVar.g(null);
            return;
        }
        ((a) gg3.q(gVar.c())).O(gVar, str, bundle, kVar);
        X(qVar.q.K1(gVar, str, i.q(qVar.q.j0(), bundle)));
    }

    public static /* synthetic */ void D(q qVar, AtomicInteger atomicInteger, xi1 xi1Var, List list, p24 p24Var) {
        qVar.getClass();
        if (atomicInteger.incrementAndGet() == xi1Var.size()) {
            qVar.W(list, xi1Var, p24Var);
        }
    }

    public static /* synthetic */ void E(q qVar, u.g gVar, b72.k kVar, Bundle bundle, String str) {
        u.g gVar2;
        String str2;
        MediaLibraryService.b bVar;
        MediaLibraryService.b bVar2 = null;
        if (!qVar.w().r(gVar, 50003)) {
            kVar.g(null);
            return;
        }
        if (bundle != null) {
            bundle.setClassLoader(qVar.q.j0().getClassLoader());
            try {
                int i = bundle.getInt("android.media.browse.extra.PAGE");
                int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE");
                MediaLibraryService.b bVarQ = i.q(qVar.q.j0(), bundle);
                if (i < 0 || i2 <= 0) {
                    gVar2 = gVar;
                    str2 = str;
                    bVar = bVarQ;
                } else {
                    try {
                        gVar2 = gVar;
                        try {
                            str2 = str;
                            try {
                                a0(kVar, fy4.Q1(qVar.q.G1(gVar2, str, i, i2, bVarQ), qVar.U()));
                                return;
                            } catch (BadParcelableException unused) {
                                bVar2 = bVarQ;
                                bVar = bVar2;
                                a0(kVar, fy4.Q1(qVar.q.G1(gVar2, str2, 0, Integer.MAX_VALUE, bVar), qVar.U()));
                            }
                        } catch (BadParcelableException unused2) {
                            str2 = str;
                        }
                    } catch (BadParcelableException unused3) {
                        gVar2 = gVar;
                        str2 = str;
                    }
                }
            } catch (BadParcelableException unused4) {
                gVar2 = gVar;
                str2 = str;
            }
        } else {
            gVar2 = gVar;
            str2 = str;
            bVar = bVar2;
        }
        a0(kVar, fy4.Q1(qVar.q.G1(gVar2, str2, 0, Integer.MAX_VALUE, bVar), qVar.U()));
    }

    public static /* synthetic */ void F(p24 p24Var, List list) {
        if (p24Var.isCancelled()) {
            S(list);
        }
    }

    public static /* synthetic */ void G(lu1 lu1Var, b72.k kVar) {
        try {
            kVar.g(((d24) gg3.r((d24) lu1Var.get(), "SessionResult must not be null")).b);
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            xz1.j("MLSLegacyStub", "Custom action failed", e);
            kVar.f(null);
        }
    }

    public static /* synthetic */ void H(p24 p24Var, lu1 lu1Var) {
        if (p24Var.isCancelled()) {
            lu1Var.cancel(false);
        }
    }

    public static /* synthetic */ void I(q qVar, u.g gVar, b72.k kVar, String str) {
        if (qVar.w().r(gVar, 50004)) {
            Z(kVar, fy4.Q1(qVar.q.H1(gVar, str), qVar.T()));
        } else {
            kVar.g(null);
        }
    }

    public static /* synthetic */ lu1 J(q qVar, j jVar) {
        Object obj;
        qVar.getClass();
        gg3.r(jVar, "LibraryResult must not be null");
        final p24 p24VarQ = p24.Q();
        if (jVar.a != 0 || (obj = jVar.c) == null) {
            p24VarQ.M(null);
            return p24VarQ;
        }
        final fg2 fg2Var = (fg2) obj;
        ph2 ph2Var = fg2Var.e;
        if (ph2Var.k == null) {
            p24VarQ.M(i.a(fg2Var, null));
            return p24VarQ;
        }
        final lu1 lu1VarC = qVar.q.g0().c(ph2Var.k);
        p24VarQ.g(new Runnable() { // from class: pg2
            @Override // java.lang.Runnable
            public final void run() {
                q.H(p24VarQ, lu1VarC);
            }
        }, du2.b());
        lu1VarC.g(new Runnable() { // from class: qg2
            @Override // java.lang.Runnable
            public final void run() {
                q.M(lu1VarC, p24VarQ, fg2Var);
            }
        }, du2.b());
        return p24VarQ;
    }

    public static /* synthetic */ void K(q qVar, String str, u.g gVar, b72.k kVar, Bundle bundle) {
        qVar.getClass();
        y14 y14Var = new y14(str, Bundle.EMPTY);
        if (!qVar.w().s(gVar, y14Var)) {
            kVar.f(null);
            return;
        }
        b bVar = new b(qVar.q, kVar);
        lu1 lu1VarM0 = qVar.q.M0(gVar, bVar, y14Var, bundle);
        bVar.a(lu1VarM0);
        Y(kVar, lu1VarM0);
    }

    public static /* synthetic */ lu1 L(final q qVar, j jVar) {
        Object obj;
        qVar.getClass();
        gg3.r(jVar, "LibraryResult must not be null");
        final p24 p24VarQ = p24.Q();
        if (jVar.a != 0 || (obj = jVar.c) == null) {
            p24VarQ.M(null);
            return p24VarQ;
        }
        final xi1 xi1Var = (xi1) obj;
        if (xi1Var.isEmpty()) {
            p24VarQ.M(new ArrayList());
            return p24VarQ;
        }
        final ArrayList arrayList = new ArrayList();
        p24VarQ.g(new Runnable() { // from class: rg2
            @Override // java.lang.Runnable
            public final void run() {
                q.F(p24VarQ, arrayList);
            }
        }, du2.b());
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Runnable runnable = new Runnable() { // from class: sg2
            @Override // java.lang.Runnable
            public final void run() {
                q.D(this.f, atomicInteger, xi1Var, arrayList, p24VarQ);
            }
        };
        for (int i = 0; i < xi1Var.size(); i++) {
            ph2 ph2Var = ((fg2) xi1Var.get(i)).e;
            if (ph2Var.k == null) {
                arrayList.add(null);
                runnable.run();
            } else {
                lu1 lu1VarC = qVar.q.g0().c(ph2Var.k);
                arrayList.add(lu1VarC);
                lu1VarC.g(runnable, du2.b());
            }
        }
        return p24VarQ;
    }

    public static /* synthetic */ void M(lu1 lu1Var, p24 p24Var, fg2 fg2Var) {
        Bitmap bitmap;
        try {
            bitmap = (Bitmap) x81.c(lu1Var);
        } catch (CancellationException | ExecutionException e) {
            xz1.c("MLSLegacyStub", "failed to get bitmap", e);
            bitmap = null;
        }
        p24Var.M(i.a(fg2Var, bitmap));
    }

    public static /* synthetic */ void N(lu1 lu1Var, b72.k kVar) {
        try {
            List list = (List) lu1Var.get();
            kVar.g(list == null ? null : a0.j(list, 262144));
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            xz1.j("MLSLegacyStub", "Library operation failed", e);
            kVar.g(null);
        }
    }

    public static /* synthetic */ void O(q qVar, AtomicReference atomicReference, u.g gVar, MediaLibraryService.b bVar, cz czVar) {
        atomicReference.set(qVar.q.I1(gVar, bVar));
        czVar.f();
    }

    public static void S(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                ((lu1) list.get(i)).cancel(false);
            }
        }
    }

    public static void X(Future future) {
    }

    public static void Y(final b72.k kVar, final lu1 lu1Var) {
        lu1Var.g(new Runnable() { // from class: og2
            @Override // java.lang.Runnable
            public final void run() {
                q.G(lu1Var, kVar);
            }
        }, du2.b());
    }

    public static void Z(final b72.k kVar, final lu1 lu1Var) {
        lu1Var.g(new Runnable() { // from class: zg2
            @Override // java.lang.Runnable
            public final void run() {
                q.B(lu1Var, kVar);
            }
        }, du2.b());
    }

    public static void a0(final b72.k kVar, final lu1 lu1Var) {
        lu1Var.g(new Runnable() { // from class: bh2
            @Override // java.lang.Runnable
            public final void run() {
                q.N(lu1Var, kVar);
            }
        }, du2.b());
    }

    public static /* synthetic */ void z(q qVar, u.g gVar, Bundle bundle, String str) {
        if (qVar.w().r(gVar, 50001)) {
            X(qVar.q.L1(gVar, str, i.q(qVar.q.j0(), bundle)));
        }
    }

    public final gb T() {
        return new gb() { // from class: ng2
            @Override // defpackage.gb
            public final lu1 apply(Object obj) {
                return q.J(this.a, (j) obj);
            }
        };
    }

    public final gb U() {
        return new gb() { // from class: ah2
            @Override // defpackage.gb
            public final lu1 apply(Object obj) {
                return q.L(this.a, (j) obj);
            }
        };
    }

    public final u.g V() {
        return w().k(d());
    }

    public final void W(List list, List list2, p24 p24Var) {
        Bitmap bitmap;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            lu1 lu1Var = (lu1) list.get(i);
            if (lu1Var != null) {
                try {
                    bitmap = (Bitmap) x81.c(lu1Var);
                } catch (CancellationException | ExecutionException e) {
                    xz1.c("MLSLegacyStub", "Failed to get bitmap", e);
                    bitmap = null;
                }
            } else {
                bitmap = null;
            }
            arrayList.add(i.a((fg2) list2.get(i), bitmap));
        }
        p24Var.M(arrayList);
    }

    @Override // defpackage.b72
    public void g(final String str, final Bundle bundle, final b72.k kVar) {
        final u.g gVarV = V();
        if (gVarV == null) {
            kVar.f(null);
        } else {
            kVar.a();
            fy4.o1(this.q.e0(), new Runnable() { // from class: ug2
                @Override // java.lang.Runnable
                public final void run() {
                    q.K(this.f, str, gVarV, kVar, bundle);
                }
            });
        }
    }

    @Override // androidx.media3.session.y, defpackage.b72
    public b72.e h(String str, int i, Bundle bundle) {
        final u.g gVarV;
        j jVar;
        if (super.h(str, i, bundle) == null || (gVarV = V()) == null || !w().r(gVarV, 50000)) {
            return null;
        }
        final MediaLibraryService.b bVarQ = i.q(this.q.j0(), bundle);
        final AtomicReference atomicReference = new AtomicReference();
        final cz czVar = new cz();
        fy4.o1(this.q.e0(), new Runnable() { // from class: mg2
            @Override // java.lang.Runnable
            public final void run() {
                q.O(this.f, atomicReference, gVarV, bVarQ, czVar);
            }
        });
        try {
            czVar.a();
            jVar = (j) gg3.r((j) ((lu1) atomicReference.get()).get(), "LibraryResult must not be null");
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            xz1.e("MLSLegacyStub", "Couldn't get a result from onGetLibraryRoot", e);
            jVar = null;
        }
        if (jVar == null || jVar.a != 0 || jVar.c == null) {
            if (jVar == null || jVar.a == 0) {
                return a0.a;
            }
            return null;
        }
        MediaLibraryService.b bVar = jVar.e;
        Bundle bundleT = bVar != null ? i.T(bVar) : new Bundle();
        ((Bundle) gg3.q(bundleT)).putBoolean("android.media.browse.SEARCH_SUPPORTED", w().r(gVarV, 50005));
        xi1 xi1VarH0 = this.q.h0();
        if (!xi1VarH0.isEmpty()) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < xi1VarH0.size(); i2++) {
                androidx.media3.session.a aVar = (androidx.media3.session.a) xi1VarH0.get(i2);
                y14 y14Var = aVar.a;
                if (y14Var != null && y14Var.a == 0) {
                    arrayList.add(i.d(aVar));
                }
            }
            if (!arrayList.isEmpty()) {
                bundleT.putParcelableArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ROOT_LIST", arrayList);
            }
        }
        return new b72.e(((fg2) jVar.c).a, bundleT);
    }

    @Override // defpackage.b72
    public void i(String str, b72.k kVar) {
        j(str, kVar, null);
    }

    @Override // defpackage.b72
    public void j(final String str, final b72.k kVar, final Bundle bundle) {
        final u.g gVarV = V();
        if (gVarV == null) {
            kVar.g(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            kVar.a();
            fy4.o1(this.q.e0(), new Runnable() { // from class: vg2
                @Override // java.lang.Runnable
                public final void run() {
                    q.E(this.f, gVarV, kVar, bundle, str);
                }
            });
        } else {
            xz1.i("MLSLegacyStub", "onLoadChildren(): Ignoring empty parentId from " + gVarV);
            kVar.g(null);
        }
    }

    @Override // defpackage.b72
    public void k(final String str, final b72.k kVar) {
        final u.g gVarV = V();
        if (gVarV == null) {
            kVar.g(null);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            kVar.a();
            fy4.o1(this.q.e0(), new Runnable() { // from class: wg2
                @Override // java.lang.Runnable
                public final void run() {
                    q.I(this.f, gVarV, kVar, str);
                }
            });
        } else {
            xz1.i("MLSLegacyStub", "Ignoring empty itemId from " + gVarV);
            kVar.g(null);
        }
    }

    @Override // defpackage.b72
    public void l(final String str, final Bundle bundle, final b72.k kVar) {
        final u.g gVarV = V();
        if (gVarV == null) {
            kVar.g(null);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xz1.i("MLSLegacyStub", "Ignoring empty query from " + gVarV);
            kVar.g(null);
            return;
        }
        if (gVarV.c() instanceof a) {
            kVar.a();
            fy4.o1(this.q.e0(), new Runnable() { // from class: xg2
                @Override // java.lang.Runnable
                public final void run() {
                    q.C(this.f, gVarV, kVar, str, bundle);
                }
            });
        }
    }

    @Override // defpackage.b72
    public void m(final String str, final Bundle bundle) {
        final u.g gVarV = V();
        if (gVarV == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            fy4.o1(this.q.e0(), new Runnable() { // from class: tg2
                @Override // java.lang.Runnable
                public final void run() {
                    q.z(this.f, gVarV, bundle, str);
                }
            });
            return;
        }
        xz1.i("MLSLegacyStub", "onSubscribe(): Ignoring empty id from " + gVarV);
    }

    @Override // defpackage.b72
    public void n(final String str) {
        final u.g gVarV = V();
        if (gVarV == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            fy4.o1(this.q.e0(), new Runnable() { // from class: yg2
                @Override // java.lang.Runnable
                public final void run() {
                    q.A(this.f, gVarV, str);
                }
            });
            return;
        }
        xz1.i("MLSLegacyStub", "onUnsubscribe(): Ignoring empty id from " + gVarV);
    }

    @Override // androidx.media3.session.y
    public u.g v(fm2.b bVar, Bundle bundle) {
        return new u.g(bVar, 0, 0, x().b(bVar), new a(bVar), bundle, i.b0(bundle), true);
    }
}
