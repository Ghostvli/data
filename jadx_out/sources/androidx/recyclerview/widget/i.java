package androidx.recyclerview.widget;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.e04;
import defpackage.gq4;
import defpackage.jl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {
    public static final ThreadLocal j = new ThreadLocal();
    public static Comparator k = new a();
    public long g;
    public long h;
    public ArrayList f = new ArrayList();
    public final ArrayList i = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.d;
            if ((recyclerView == null) != (cVar2.d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = cVar.a;
            if (z != cVar2.a) {
                return z ? -1 : 1;
            }
            int i = cVar2.b - cVar.b;
            if (i != 0) {
                return i;
            }
            int i2 = cVar.c - cVar2.c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements RecyclerView.q.c {
        public int a;
        public int b;
        public int[] c;
        public int d;

        @Override // androidx.recyclerview.widget.RecyclerView.q.c
        public void a(int i, int i2) {
            if (i < 0) {
                jl.a("Layout positions must be non-negative");
                return;
            }
            if (i2 < 0) {
                jl.a("Pixel distance must be non-negative");
                return;
            }
            int i3 = this.d;
            int i4 = i3 * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i3 * 4];
                this.c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.c;
            iArr4[i4] = i;
            iArr4[i4 + 1] = i2;
            this.d++;
        }

        public void b() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.q qVar = recyclerView.s;
            if (recyclerView.r == null || qVar == null || !qVar.Q0()) {
                return;
            }
            if (z) {
                if (!recyclerView.j.p()) {
                    qVar.Q(recyclerView.r.g(), this);
                }
            } else if (!recyclerView.v0()) {
                qVar.P(this.a, this.b, recyclerView.n0, this);
            }
            int i = this.d;
            if (i > qVar.m) {
                qVar.m = i;
                qVar.n = z;
                recyclerView.h.P();
            }
        }

        public boolean d(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i) {
        int iJ = recyclerView.k.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            RecyclerView.g0 g0VarO0 = RecyclerView.o0(recyclerView.k.i(i2));
            if (g0VarO0.h == i && !g0VarO0.u()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        if (RecyclerView.J0 && this.f.contains(recyclerView)) {
            e04.a("RecyclerView already present in worker list!");
        } else {
            this.f.add(recyclerView);
        }
    }

    public final void b() {
        c cVar;
        int size = this.f.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = (RecyclerView) this.f.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.m0.c(recyclerView, false);
                i += recyclerView.m0.d;
            }
        }
        this.i.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.m0;
                int iAbs = Math.abs(bVar.a) + Math.abs(bVar.b);
                for (int i5 = 0; i5 < bVar.d * 2; i5 += 2) {
                    if (i3 >= this.i.size()) {
                        cVar = new c();
                        this.i.add(cVar);
                    } else {
                        cVar = (c) this.i.get(i3);
                    }
                    int[] iArr = bVar.c;
                    int i6 = iArr[i5 + 1];
                    cVar.a = i6 <= iAbs;
                    cVar.b = iAbs;
                    cVar.c = i6;
                    cVar.d = recyclerView2;
                    cVar.e = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.i, k);
    }

    public final void c(c cVar, long j2) {
        RecyclerView.g0 g0VarI = i(cVar.d, cVar.e, cVar.a ? Long.MAX_VALUE : j2);
        if (g0VarI == null || g0VarI.g == null || !g0VarI.t() || g0VarI.u()) {
            return;
        }
        h((RecyclerView) g0VarI.g.get(), j2);
    }

    public final void d(long j2) {
        for (int i = 0; i < this.i.size(); i++) {
            c cVar = (c) this.i.get(i);
            if (cVar.d == null) {
                return;
            }
            c(cVar, j2);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.J0 && !this.f.contains(recyclerView)) {
                e04.a("attempting to post unregistered view!");
                return;
            } else if (this.g == 0) {
                this.g = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.m0.e(i, i2);
    }

    public void g(long j2) {
        b();
        d(j2);
    }

    public final void h(RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.J && recyclerView.k.j() != 0) {
            recyclerView.g1();
        }
        b bVar = recyclerView.m0;
        bVar.c(recyclerView, true);
        if (bVar.d != 0) {
            try {
                Trace.beginSection(j2 == Long.MAX_VALUE ? "RV Nested Prefetch" : "RV Nested Prefetch forced - needed next frame");
                recyclerView.n0.f(recyclerView.r);
                for (int i = 0; i < bVar.d * 2; i += 2) {
                    i(recyclerView, bVar.c[i], j2);
                }
            } finally {
                Trace.endSection();
            }
        }
    }

    public final RecyclerView.g0 i(RecyclerView recyclerView, int i, long j2) {
        if (e(recyclerView, i)) {
            return null;
        }
        RecyclerView.x xVar = recyclerView.h;
        if (j2 == Long.MAX_VALUE) {
            try {
                if (gq4.c()) {
                    Trace.beginSection("RV Prefetch forced - needed next frame");
                }
            } catch (Throwable th) {
                recyclerView.S0(false);
                Trace.endSection();
                throw th;
            }
        }
        recyclerView.Q0();
        RecyclerView.g0 g0VarN = xVar.N(i, false, j2);
        if (g0VarN != null) {
            if (!g0VarN.t() || g0VarN.u()) {
                xVar.a(g0VarN, false);
            } else {
                xVar.G(g0VarN.f);
            }
        }
        recyclerView.S0(false);
        Trace.endSection();
        return g0VarN;
    }

    public void j(RecyclerView recyclerView) {
        boolean zRemove = this.f.remove(recyclerView);
        if (!RecyclerView.J0 || zRemove) {
            return;
        }
        e04.a("RecyclerView removal failed!");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Trace.beginSection("RV Prefetch");
            if (!this.f.isEmpty()) {
                int size = this.f.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) this.f.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.h);
                }
            }
        } finally {
            this.g = 0L;
            Trace.endSection();
        }
    }
}
