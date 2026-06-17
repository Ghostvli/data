package androidx.media3.exoplayer;

import android.text.TextUtils;
import androidx.media3.exoplayer.i;
import defpackage.d04;
import defpackage.er4;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.i5;
import defpackage.ie3;
import defpackage.j5;
import defpackage.jq2;
import defpackage.jy0;
import defpackage.no4;
import defpackage.pb0;
import defpackage.xi1;
import defpackage.xz1;
import defpackage.zi1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class d implements i {
    public static final xi1 t = xi1.A("file", "content", "data", "android.resource", "rawresource", "asset");
    public final no4.d a;
    public final no4.b b;
    public final pb0 c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final long k;
    public final int l;
    public final boolean m;
    public final boolean n;
    public final long o;
    public final boolean p;
    public final zi1 q;
    public final ConcurrentHashMap r;
    public long s;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final HashMap a;
        public pb0 b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public boolean l;
        public boolean m;
        public int n;
        public boolean o;
        public boolean p;
        public Boolean q;

        public a() {
            HashMap map = new HashMap();
            this.a = map;
            map.put(ie3.d.a, 144179200);
            this.c = 50000;
            this.d = 1000;
            this.e = 50000;
            this.f = 50000;
            this.g = 1000;
            this.h = 1000;
            this.i = 2000;
            this.j = 1000;
            this.k = -1;
            this.l = false;
            this.m = true;
            this.n = 0;
            this.o = false;
        }

        public d a() {
            gg3.v(!this.p);
            this.p = true;
            if (this.b == null) {
                this.b = new pb0(true, 65536);
            }
            Boolean bool = this.q;
            if (bool != null && bool.booleanValue()) {
                this.d = this.c;
                this.f = this.e;
                this.h = this.g;
                this.j = this.i;
                this.m = this.l;
            }
            return new d(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.a);
        }

        public a b(int i, int i2, int i3, int i4) {
            gg3.v(!this.p);
            d.n(i3, 0, "bufferForPlaybackMs", "0");
            d.n(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
            d.n(i, i3, "minBufferMs", "bufferForPlaybackMs");
            d.n(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            d.n(i2, i, "maxBufferMs", "minBufferMs");
            this.c = i;
            this.e = i2;
            this.g = i3;
            this.i = i4;
            this.d = i;
            this.f = i2;
            this.h = i3;
            this.j = i4;
            if (this.q == null) {
                this.q = Boolean.TRUE;
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements j5 {
        public final HashMap a = new HashMap();
        public ie3 b;

        public b(ie3 ie3Var) {
            this.b = ie3Var;
        }

        @Override // defpackage.j5
        public synchronized void a(j5.a aVar) {
            d.this.c.a(aVar);
            while (aVar != null) {
                f(aVar.a());
                aVar = aVar.next();
            }
        }

        @Override // defpackage.j5
        public synchronized void b(i5 i5Var) {
            d.this.c.b(i5Var);
            f(i5Var);
        }

        @Override // defpackage.j5
        public synchronized i5 c() {
            i5 i5VarC;
            i5VarC = d.this.c.c();
            this.a.put(i5VarC, this.b);
            c cVar = (c) d.this.r.get(this.b);
            if (cVar != null) {
                cVar.c();
            }
            return i5VarC;
        }

        @Override // defpackage.j5
        public synchronized void d() {
            d.this.c.d();
        }

        @Override // defpackage.j5
        public synchronized int e() {
            return d.this.c.e();
        }

        public final void f(i5 i5Var) {
            c cVar = (c) d.this.r.get((ie3) gg3.q((ie3) this.a.remove(i5Var)));
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public int a = 1;
        public boolean b;
        public int c;
        public int d;

        public synchronized void a() {
            this.d--;
        }

        public synchronized int b() {
            return this.d;
        }

        public synchronized void c() {
            this.d++;
        }
    }

    public d(pb0 pb0Var, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, int i10, boolean z3, Map map) {
        n(i5, 0, "bufferForPlaybackMs", "0");
        n(i6, 0, "bufferForPlaybackForLocalPlaybackMs", "0");
        n(i7, 0, "bufferForPlaybackAfterRebufferMs", "0");
        n(i8, 0, "bufferForPlaybackAfterRebufferForLocalPlaybackMs", "0");
        n(i, i5, "minBufferMs", "bufferForPlaybackMs");
        n(i2, i6, "minBufferForLocalPlaybackMs", "bufferForPlaybackForLocalPlaybackMs");
        n(i, i7, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        n(i2, i8, "minBufferForLocalPlaybackMs", "bufferForPlaybackAfterRebufferForLocalPlaybackMs");
        n(i3, i, "maxBufferMs", "minBufferMs");
        n(i4, i2, "maxBufferForLocalPlaybackMs", "minBufferForLocalPlaybackMs");
        n(i10, 0, "backBufferDurationMs", "0");
        this.a = new no4.d();
        this.b = new no4.b();
        this.c = pb0Var;
        this.d = fy4.c1(i);
        this.e = fy4.c1(i2);
        this.f = fy4.c1(i3);
        this.g = fy4.c1(i4);
        this.h = fy4.c1(i5);
        this.i = fy4.c1(i6);
        this.j = fy4.c1(i7);
        this.k = fy4.c1(i8);
        this.l = i9;
        this.m = z;
        this.n = z2;
        this.o = fy4.c1(i10);
        this.p = z3;
        this.r = new ConcurrentHashMap();
        this.q = zi1.c(map);
        this.s = -1L;
    }

    public static void n(int i, int i2, String str, String str2) {
        gg3.m(i >= i2, "%s cannot be less than %s", str, str2);
    }

    public static int t(int i, boolean z) {
        switch (i) {
            case -2:
                return 0;
            case -1:
                return 13107200;
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return z ? 19660800 : 131072000;
            case 3:
                return 131072;
            case 4:
                return 26214400;
            case 5:
            case 6:
                return 131072;
            default:
                d04.a();
                return 0;
        }
    }

    public final boolean A(boolean z) {
        return z ? this.n : this.m;
    }

    public final void B(ie3 ie3Var) {
        c cVar = (c) this.r.get(ie3Var);
        if (cVar != null) {
            int i = cVar.a - 1;
            cVar.a = i;
            if (i == 0) {
                this.r.remove(ie3Var);
                D();
            }
        }
    }

    public final void C(ie3 ie3Var) {
        c cVar = (c) gg3.q((c) this.r.get(ie3Var));
        int iX = x(ie3Var);
        if (iX == -1) {
            iX = 13107200;
        }
        cVar.c = iX;
        cVar.b = false;
    }

    public final void D() {
        boolean zIsEmpty = this.r.isEmpty();
        pb0 pb0Var = this.c;
        if (zIsEmpty) {
            pb0Var.f();
        } else {
            pb0Var.g(q());
        }
    }

    @Override // androidx.media3.exoplayer.i
    public boolean a(i.a aVar) {
        boolean z = z(aVar);
        long jV0 = fy4.v0(aVar.e, aVar.f);
        long jR = aVar.h ? r(z) : s(z);
        long j = aVar.i;
        if (j != -9223372036854775807L) {
            jR = Math.min(j / 2, jR);
        }
        if (jR <= 0 || jV0 >= jR) {
            return true;
        }
        return !A(z) && y(aVar.a) >= w(aVar.a);
    }

    @Override // androidx.media3.exoplayer.i
    public boolean b(ie3 ie3Var, no4 no4Var, jq2.b bVar, long j) {
        Iterator it = this.r.values().iterator();
        while (it.hasNext()) {
            if (((c) it.next()).b) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.i
    public boolean c(i.a aVar) {
        ie3 ie3Var = aVar.a;
        c cVar = (c) gg3.q((c) this.r.get(ie3Var));
        boolean z = y(ie3Var) >= w(ie3Var);
        if (ie3Var.equals(ie3.d)) {
            return !z;
        }
        boolean z2 = z(aVar);
        long jV = v(z2);
        long jU = u(z2);
        float f = aVar.f;
        if (f > 1.0f) {
            jV = Math.min(fy4.p0(jV, f), jU);
        }
        long jMax = Math.max(jV, 500000L);
        long j = aVar.e;
        if (j < jMax) {
            boolean z3 = A(z2) || !z;
            cVar.b = z3;
            if (!z3 && aVar.e < 500000) {
                xz1.i("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= jU || z) {
            cVar.b = false;
        }
        return cVar.b;
    }

    @Override // androidx.media3.exoplayer.i
    public void d(ie3 ie3Var) {
        B(ie3Var);
        if (this.r.isEmpty()) {
            this.s = -1L;
        }
    }

    @Override // androidx.media3.exoplayer.i
    public void e(ie3 ie3Var) {
        B(ie3Var);
    }

    @Override // androidx.media3.exoplayer.i
    public void f(i.a aVar, er4 er4Var, jy0[] jy0VarArr) {
        int iX = x(aVar.a);
        c cVar = (c) gg3.q((c) this.r.get(aVar.a));
        if (iX == -1) {
            iX = o(aVar, jy0VarArr);
        }
        cVar.c = iX;
        D();
    }

    @Override // androidx.media3.exoplayer.i
    public boolean g(ie3 ie3Var) {
        return this.p;
    }

    @Override // androidx.media3.exoplayer.i
    public void h(ie3 ie3Var) {
        long id = Thread.currentThread().getId();
        long j = this.s;
        gg3.w(j == -1 || j == id, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.s = id;
        c cVar = (c) this.r.get(ie3Var);
        if (cVar == null) {
            this.r.put(ie3Var, new c());
        } else {
            cVar.a++;
        }
        C(ie3Var);
    }

    @Override // androidx.media3.exoplayer.i
    public j5 i(ie3 ie3Var) {
        return new b(ie3Var);
    }

    @Override // androidx.media3.exoplayer.i
    public long j(ie3 ie3Var) {
        return this.o;
    }

    public int o(i.a aVar, jy0[] jy0VarArr) {
        int iP = p(jy0VarArr);
        if (iP != -1) {
            return iP;
        }
        boolean z = z(aVar);
        int iT = 0;
        for (jy0 jy0Var : jy0VarArr) {
            if (jy0Var != null) {
                iT += t(jy0Var.c().c, z);
            }
        }
        return fy4.s(iT, 13107200, 210239488);
    }

    public int p(jy0[] jy0VarArr) {
        return -1;
    }

    public int q() {
        Iterator it = this.r.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((c) it.next()).c;
        }
        return i;
    }

    public final long r(boolean z) {
        return z ? this.k : this.j;
    }

    public final long s(boolean z) {
        return z ? this.i : this.h;
    }

    public final long u(boolean z) {
        return z ? this.g : this.f;
    }

    public final long v(boolean z) {
        return z ? this.e : this.d;
    }

    public final int w(ie3 ie3Var) {
        return ((c) gg3.q((c) this.r.get(ie3Var))).c;
    }

    public final int x(ie3 ie3Var) {
        Integer num = (Integer) this.q.get(ie3Var.a);
        return (num == null || num.intValue() == -1) ? this.l : num.intValue();
    }

    public final int y(ie3 ie3Var) {
        return ((c) gg3.q((c) this.r.get(ie3Var))).b() * this.c.e();
    }

    public final boolean z(i.a aVar) {
        fg2.h hVar = aVar.b.t(aVar.b.n(aVar.c.a, this.b).c, this.a).c.b;
        if (hVar == null) {
            return false;
        }
        String scheme = hVar.a.getScheme();
        return TextUtils.isEmpty(scheme) || t.contains(scheme);
    }

    public d() {
        this(new pb0(true, 65536), 50000, 1000, 50000, 50000, 1000, 1000, 2000, 1000, -1, false, true, 0, false);
    }

    public d(pb0 pb0Var, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, int i10, boolean z3) {
        this(pb0Var, i, i2, i3, i4, i5, i6, i7, i8, i9, z, z2, i10, z3, zi1.j());
    }
}
