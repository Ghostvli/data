package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import defpackage.ag0;
import defpackage.bf1;
import defpackage.df1;
import defpackage.ja0;
import defpackage.rq2;
import defpackage.sy1;
import defpackage.t83;
import defpackage.we1;
import defpackage.xy1;
import defpackage.ze1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ag0 implements df1, xy1.b {
    public static final df1.a A = new df1.a() { // from class: zf0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // df1.a
        public final df1 a(oe1 oe1Var, sy1 sy1Var, cf1 cf1Var, ev evVar, xi4 xi4Var) {
            return new ag0(oe1Var, sy1Var, cf1Var, evVar, xi4Var);
        }
    };
    public final oe1 f;
    public final cf1 g;
    public final sy1 h;
    public final HashMap i;
    public final CopyOnWriteArrayList j;
    public final double k;
    public final xi4 l;
    public rq2.a m;
    public xy1 n;
    public Handler o;
    public df1.e p;
    public ze1 q;
    public r83 r;
    public xi1 s;
    public xi1 t;
    public xi1 u;
    public xi1 v;
    public Uri w;
    public we1 x;
    public boolean y;
    public long z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements df1.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // df1.b
        public void a() {
            ag0.this.j.remove(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final sy1.a b(Uri uri) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ef1 ef1Var = ((d) gg3.q((d) ag0.this.i.get(uri))).a;
            int iK = ef1Var.k();
            pw4 it = ef1Var.d().iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                if (ag0.this.d((Uri) it.next(), jElapsedRealtime)) {
                    i2++;
                }
            }
            int size = ag0.this.s.size();
            pw4 it2 = ag0.this.s.iterator();
            while (it2.hasNext()) {
                if (ag0.this.b((ef1) it2.next(), jElapsedRealtime)) {
                    i++;
                }
            }
            return new sy1.a(iK, i2, size, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // df1.b
        public boolean e(Uri uri, sy1.c cVar, boolean z) {
            d dVar;
            if (ag0.this.x != null) {
                return false;
            }
            sy1.b bVarB = ag0.this.h.b(b(uri), cVar);
            if (bVarB == null || (dVar = (d) ag0.this.i.get(uri)) == null) {
                return false;
            }
            return dVar.o(uri, bVarB.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements xy1.b {
        public final Uri f;
        public final String g;
        public final xy1 h;
        public final aa0 i;
        public we1 j;
        public long k;
        public long l;
        public long m;
        public long n;
        public boolean o;
        public IOException p;
        public boolean q;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Uri uri, String str) {
            this.f = uri;
            this.g = str;
            this.h = ag0.this.l != null ? new xy1((eq3) ag0.this.l.get()) : new xy1("DefaultHlsPlaylistTracker:MediaPlaylist");
            this.i = ag0.this.f.a(4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void a(c cVar, Uri uri) {
            cVar.o = false;
            cVar.q(uri);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void A(boolean z) {
            this.q = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h(long j) {
            this.n = SystemClock.elapsedRealtime() + j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Uri i() {
            we1 we1Var = this.j;
            if (we1Var != null) {
                we1.h hVar = we1Var.v;
                if (hVar.a != -9223372036854775807L || hVar.e) {
                    Uri.Builder builderBuildUpon = this.f.buildUpon();
                    we1 we1Var2 = this.j;
                    if (we1Var2.v.e) {
                        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(we1Var2.k + ((long) we1Var2.r.size())));
                        we1 we1Var3 = this.j;
                        if (we1Var3.n != -9223372036854775807L) {
                            List list = we1Var3.s;
                            int size = list.size();
                            if (!list.isEmpty() && ((we1.d) km1.d(list)).r) {
                                size--;
                            }
                            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    we1.h hVar2 = this.j.v;
                    if (hVar2.a != -9223372036854775807L) {
                        builderBuildUpon.appendQueryParameter("_HLS_skip", hVar2.b ? "v2" : "YES");
                    }
                    return builderBuildUpon.build();
                }
            }
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public we1 k() {
            return this.j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean m() {
            return this.q;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean n() {
            int i;
            if (this.j == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, fy4.S1(this.j.u));
            we1 we1Var = this.j;
            return we1Var.o || (i = we1Var.d) == 2 || i == 1 || this.k + jMax > jElapsedRealtime;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void o(boolean z) {
            r(z ? i() : this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void q(Uri uri) {
            t83.a aVarA = ag0.this.g.a(ag0.this.q, this.j);
            ja0 ja0VarA = new ja0.b().i(uri).b(1).a();
            ag0.G(ag0.this);
            t83 t83Var = new t83(this.i, ja0VarA, 4, aVarA);
            this.h.n(t83Var, this, ag0.this.h.d(t83Var.c));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void r(final Uri uri) {
            this.n = 0L;
            if (this.o || this.h.j() || this.h.i()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime >= this.m) {
                q(uri);
            } else {
                this.o = true;
                ag0.this.o.postDelayed(new Runnable() { // from class: bg0
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ag0.c.a(this.f, uri);
                    }
                }, this.m - jElapsedRealtime);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s() throws IOException {
            this.h.a();
            IOException iOException = this.p;
            if (iOException != null) {
                throw iOException;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: j(Lxy1$e;JJZ)V */
        @Override // xy1.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void j(t83 t83Var, long j, long j2, boolean z) {
            ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
            ag0.this.h.c(t83Var.a);
            ag0.this.m.l(ty1Var, 4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: l(Lxy1$e;JJ)V */
        @Override // xy1.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void l(t83 t83Var, long j, long j2) {
            af1 af1Var = (af1) t83Var.e();
            ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
            if (af1Var instanceof we1) {
                y((we1) af1Var, ty1Var);
                ag0.this.m.o(ty1Var, 4);
            } else {
                this.p = r83.c("Loaded playlist has unexpected type.", null);
                ag0.this.m.s(ty1Var, 4, this.p, true);
            }
            ag0.this.h.c(t83Var.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: v(Lxy1$e;JJLjava/io/IOException;I)Lxy1$c; */
        @Override // xy1.b
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public xy1.c v(t83 t83Var, long j, long j2, IOException iOException, int i) {
            xy1.c cVarH;
            ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
            boolean z = iOException instanceof bf1.b;
            if ((t83Var.f().getQueryParameter("_HLS_msn") != null) || z) {
                int i2 = iOException instanceof og1 ? ((og1) iOException).i : Integer.MAX_VALUE;
                if (z || i2 == 400 || i2 == 503) {
                    this.m = SystemClock.elapsedRealtime();
                    o(false);
                    ((rq2.a) fy4.l(ag0.this.m)).s(ty1Var, t83Var.c, iOException, true);
                    return xy1.f;
                }
            }
            sy1.c cVar = new sy1.c(ty1Var, new oh2(t83Var.c), iOException, i);
            if (ag0.this.a0(this.f, cVar, false)) {
                long jA = ag0.this.h.a(cVar);
                cVarH = jA != -9223372036854775807L ? xy1.h(false, jA) : xy1.g;
            } else {
                cVarH = xy1.f;
            }
            boolean zC = cVarH.c();
            ag0.this.m.s(ty1Var, t83Var.c, iOException, !zC);
            if (!zC) {
                ag0.this.h.c(t83Var.a);
            }
            return cVarH;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: p(Lxy1$e;JJI)V */
        @Override // xy1.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public void p(t83 t83Var, long j, long j2, int i) {
            ag0.this.m.u(i == 0 ? new ty1(t83Var.a, t83Var.b, j) : new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a()), t83Var.c, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void y(we1 we1Var, ty1 ty1Var) {
            boolean z;
            long j;
            we1 we1Var2 = this.j;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.k = jElapsedRealtime;
            we1 we1VarR = ag0.this.R(we1Var2, we1Var);
            this.j = we1VarR;
            IOException dVar = null;
            if (we1VarR != we1Var2) {
                this.p = null;
                this.l = jElapsedRealtime;
                ag0.this.f0(this.f, we1VarR);
            } else if (!we1VarR.o) {
                if (we1Var.k + ((long) we1Var.r.size()) < this.j.k) {
                    dVar = new df1.c(this.f);
                    z = true;
                } else {
                    z = false;
                    if (jElapsedRealtime - this.l > fy4.S1(r13.m) * ag0.this.k) {
                        dVar = new df1.d(this.f);
                    }
                }
                if (dVar != null) {
                    this.p = dVar;
                    ag0.this.a0(this.f, new sy1.c(ty1Var, new oh2(4), dVar, 1), z);
                }
            }
            we1 we1Var3 = this.j;
            if (!we1Var3.v.e) {
                j = we1Var3 != we1Var2 ? we1Var3.m : we1Var3.m / 2;
            } else if (we1Var3 == we1Var2) {
                long j2 = we1Var3.n;
                j = j2 != -9223372036854775807L ? j2 / 2 : we1Var3.m / 2;
            } else {
                j = 0;
            }
            this.m = (jElapsedRealtime + fy4.S1(j)) - ty1Var.f;
            if (this.j.o) {
                return;
            }
            if (this.f.equals(ag0.this.w) || this.q) {
                r(i());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void z() {
            this.h.l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d {
        public final ef1 a;
        public final Map b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(ef1 ef1Var) {
            this.a = ef1Var;
            this.b = n(ef1Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean A() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            for (c cVar : this.b.values()) {
                if (!cVar.g.equals(this.a.e()) && jElapsedRealtime > cVar.n) {
                    Uri uriF = this.a.f();
                    this.a.j(cVar.g);
                    if (uriF.equals(ag0.this.w)) {
                        ag0.this.Z(cVar.f);
                    }
                    c cVar2 = (c) gg3.q((c) this.b.get(uriF));
                    cVar.A(cVar2.m());
                    cVar2.A(false);
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Map n(ef1 ef1Var) {
            HashMap map = new HashMap();
            pw4 it = ef1Var.c().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Uri uri = (Uri) gg3.q(ef1Var.g(str));
                map.put(uri, new c(uri, str));
            }
            return map;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean o(Uri uri, long j) {
            gg3.v(this.b.containsKey(uri));
            ((c) gg3.q((c) this.b.get(uri))).h(j);
            if (A()) {
                return true;
            }
            return !(ag0.this.w == null || uri.equals(ag0.this.w)) || ag0.this.Y();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final we1 p(Uri uri) {
            gg3.v(this.b.containsKey(uri));
            return ((c) gg3.q((c) this.b.get(uri))).k();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean q(Uri uri) {
            gg3.v(this.b.containsKey(uri));
            return ((c) gg3.q((c) this.b.get(uri))).m();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean r(long j) {
            Iterator it = this.b.values().iterator();
            boolean z = true;
            while (it.hasNext()) {
                z &= j <= ((c) it.next()).n;
            }
            return z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean s(Uri uri, long j) {
            gg3.v(this.b.containsKey(uri));
            return j <= ((c) gg3.q((c) this.b.get(uri))).n;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean t(Uri uri) {
            gg3.v(this.b.containsKey(uri));
            return ((c) gg3.q((c) this.b.get(uri))).n();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void u(Uri uri, Uri uri2) {
            gg3.v(this.b.containsKey(uri));
            ((c) gg3.q((c) this.b.get(uri))).r(uri2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void v(Uri uri, boolean z) {
            gg3.v(this.b.containsKey(uri));
            ((c) gg3.q((c) this.b.get(uri))).o(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void w(Uri uri) throws IOException {
            gg3.v(this.b.containsKey(uri));
            ((c) gg3.q((c) this.b.get(uri))).s();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void x(Uri uri, we1 we1Var, ty1 ty1Var) {
            gg3.v(this.b.containsKey(uri));
            ((c) gg3.q((c) this.b.get(uri))).y(we1Var, ty1Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void y() {
            Iterator it = this.b.values().iterator();
            while (it.hasNext()) {
                ((c) it.next()).z();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void z(Uri uri, boolean z) {
            gg3.v(this.b.containsKey(uri));
            ((c) gg3.q((c) this.b.get(uri))).A(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ag0(oe1 oe1Var, sy1 sy1Var, cf1 cf1Var, ev evVar, double d2, xi4 xi4Var) {
        this.f = oe1Var;
        this.g = cf1Var;
        this.h = sy1Var;
        this.k = d2;
        this.l = xi4Var;
        this.j = new CopyOnWriteArrayList();
        this.i = new HashMap();
        this.z = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ ev G(ag0 ag0Var) {
        ag0Var.getClass();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static we1.f Q(we1 we1Var, we1 we1Var2) {
        int i = (int) (we1Var2.k - we1Var.k);
        List list = we1Var.r;
        if (i < list.size()) {
            return (we1.f) list.get(i);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O() {
        P(this.s);
        P(this.t);
        P(this.u);
        P(this.v);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P(List list) {
        for (int i = 0; i < list.size(); i++) {
            ef1 ef1Var = (ef1) list.get(i);
            d dVar = new d(ef1Var);
            pw4 it = ef1Var.d().iterator();
            while (it.hasNext()) {
                this.i.put((Uri) it.next(), dVar);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final we1 R(we1 we1Var, we1 we1Var2) {
        return !we1Var2.f(we1Var) ? we1Var2.o ? we1Var.d() : we1Var : we1Var2.c(T(we1Var, we1Var2), S(we1Var, we1Var2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int S(we1 we1Var, we1 we1Var2) {
        we1.f fVarQ;
        if (we1Var2.i) {
            return we1Var2.j;
        }
        we1 we1Var3 = this.x;
        int i = we1Var3 != null ? we1Var3.j : 0;
        return (we1Var == null || (fVarQ = Q(we1Var, we1Var2)) == null) ? i : (we1Var.j + fVarQ.i) - ((we1.f) we1Var2.r.get(0)).i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long T(we1 we1Var, we1 we1Var2) {
        if (we1Var2.p) {
            return we1Var2.h;
        }
        we1 we1Var3 = this.x;
        long j = we1Var3 != null ? we1Var3.h : 0L;
        if (we1Var != null) {
            int size = we1Var.r.size();
            we1.f fVarQ = Q(we1Var, we1Var2);
            if (fVarQ != null) {
                return we1Var.h + fVarQ.j;
            }
            if (size == we1Var2.k - we1Var.k) {
                return we1Var.e();
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: g(I)Ljava/util/List; */
    @Override // defpackage.df1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public xi1 g(int i) {
        if (i == 0) {
            return this.s;
        }
        if (i == 1) {
            return this.t;
        }
        if (i == 2) {
            return this.u;
        }
        if (i != 3) {
            return null;
        }
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Uri V(Uri uri) {
        we1.e eVar;
        we1 we1Var = this.x;
        if (we1Var == null || !we1Var.v.e || (eVar = (we1.e) we1Var.t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(eVar.b));
        int i = eVar.c;
        if (i != -1) {
            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
        }
        return builderBuildUpon.build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean W(Uri uri) {
        List list = this.q.e;
        for (int i = 0; i < list.size(); i++) {
            if (uri.equals(((ze1.b) list.get(i)).a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X(Uri uri) {
        d dVar = (d) gg3.q((d) this.i.get(uri));
        if (dVar.q(uri)) {
            return;
        }
        dVar.z(uri, true);
        we1 we1VarP = dVar.p(uri);
        if (we1VarP == null || we1VarP.o) {
            return;
        }
        dVar.v(uri, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Y() {
        xi1 xi1Var = this.s;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < xi1Var.size(); i++) {
            Uri uriF = ((ef1) xi1Var.get(i)).f();
            d dVar = (d) gg3.q((d) this.i.get(uriF));
            if (!dVar.s(uriF, jElapsedRealtime)) {
                this.w = uriF;
                dVar.u(uriF, V(uriF));
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Z(Uri uri) {
        if (uri.equals(this.w) || !W(uri)) {
            return;
        }
        we1 we1Var = this.x;
        if (we1Var == null || !we1Var.o) {
            this.w = uri;
            d dVar = (d) gg3.q((d) this.i.get(uri));
            we1 we1VarP = dVar.p(uri);
            if (we1VarP == null || !we1VarP.o) {
                dVar.u(uri, V(uri));
            } else {
                this.x = we1VarP;
                this.p.t(we1VarP);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public boolean a() {
        return this.y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean a0(Uri uri, sy1.c cVar, boolean z) {
        Iterator it = this.j.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= !((df1.b) it.next()).e(uri, cVar, z);
        }
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public boolean b(ef1 ef1Var, long j) {
        d dVar = (d) this.i.get(ef1Var.f());
        if (dVar != null) {
            return dVar.r(j);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Lxy1$e;JJZ)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void j(t83 t83Var, long j, long j2, boolean z) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        this.h.c(t83Var.a);
        this.m.l(ty1Var, 4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public boolean c(Uri uri) {
        d dVar = (d) this.i.get(uri);
        if (dVar == null) {
            return false;
        }
        return dVar.t(uri);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: l(Lxy1$e;JJ)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void l(t83 t83Var, long j, long j2) {
        af1 af1Var = (af1) t83Var.e();
        boolean z = af1Var instanceof we1;
        ze1 ze1VarE = z ? ze1.e(af1Var.a) : (ze1) af1Var;
        this.q = ze1VarE;
        try {
            this.s = ef1.b(ze1VarE.e);
            this.t = ef1.a(ze1VarE.f);
            this.u = ef1.a(ze1VarE.g);
            this.v = ef1.a(ze1VarE.h);
            this.w = ((ef1) this.s.get(0)).f();
            this.j.add(new b());
            O();
            ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
            d dVar = (d) gg3.q((d) this.i.get(this.w));
            if (z) {
                dVar.x(t83Var.f(), (we1) af1Var, ty1Var);
            } else {
                dVar.v(this.w, false);
            }
            this.h.c(t83Var.a);
            this.m.o(ty1Var, 4);
        } catch (r83 e) {
            this.r = e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public boolean d(Uri uri, long j) {
        d dVar = (d) this.i.get(uri);
        if (dVar != null) {
            return dVar.s(uri, j);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Lxy1$e;JJLjava/io/IOException;I)Lxy1$c; */
    @Override // xy1.b
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public xy1.c v(t83 t83Var, long j, long j2, IOException iOException, int i) {
        ty1 ty1Var = new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a());
        long jA = this.h.a(new sy1.c(ty1Var, new oh2(t83Var.c), iOException, i));
        boolean z = jA == -9223372036854775807L;
        this.m.s(ty1Var, t83Var.c, iOException, z);
        if (z) {
            this.h.c(t83Var.a);
        }
        return z ? xy1.g : xy1.h(false, jA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public void e(Uri uri) {
        d dVar = (d) this.i.get(uri);
        if (dVar != null) {
            dVar.z(uri, false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: p(Lxy1$e;JJI)V */
    @Override // xy1.b
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void p(t83 t83Var, long j, long j2, int i) {
        this.m.u(i == 0 ? new ty1(t83Var.a, t83Var.b, j) : new ty1(t83Var.a, t83Var.b, t83Var.f(), t83Var.d(), j, j2, t83Var.a()), t83Var.c, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public void f(Uri uri) throws IOException {
        d dVar = (d) this.i.get(uri);
        if (dVar != null) {
            dVar.w(uri);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f0(Uri uri, we1 we1Var) {
        if (uri.equals(this.w)) {
            if (this.x == null) {
                this.y = !we1Var.o;
                this.z = we1Var.h;
            }
            this.x = we1Var;
            this.p.t(we1Var);
        }
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((df1.b) it.next()).a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public void h(Uri uri, rq2.a aVar, df1.e eVar) {
        this.o = fy4.E();
        this.m = aVar;
        this.p = eVar;
        t83 t83Var = new t83(this.f.a(4), new ja0.b().i(uri).b(1).a(), 4, this.g.b());
        gg3.v(this.n == null);
        xy1 xy1Var = this.l != null ? new xy1((eq3) this.l.get()) : new xy1("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.n = xy1Var;
        xy1Var.n(t83Var, this, this.h.d(t83Var.c));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public long i() {
        return this.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public ze1 k() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public boolean m(Uri uri, long j) {
        d dVar = (d) this.i.get(uri);
        if (dVar != null) {
            return dVar.o(uri, j);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public void n() throws IOException {
        xy1 xy1Var = this.n;
        if (xy1Var != null) {
            xy1Var.a();
        }
        r83 r83Var = this.r;
        if (r83Var != null) {
            throw r83Var;
        }
        Uri uri = this.w;
        if (uri != null) {
            f(uri);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public void o(Uri uri) {
        d dVar = (d) this.i.get(uri);
        if (dVar != null) {
            dVar.v(uri, true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public ef1 q(Uri uri) {
        d dVar = (d) this.i.get(uri);
        if (dVar != null) {
            return dVar.a;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public we1 r(Uri uri, boolean z) {
        d dVar = (d) this.i.get(uri);
        if (dVar == null) {
            return null;
        }
        we1 we1VarP = dVar.p(uri);
        if (we1VarP != null && z) {
            Z(uri);
            X(uri);
        }
        return we1VarP;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public void s(df1.b bVar) {
        this.j.remove(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public void stop() {
        this.w = null;
        this.x = null;
        this.q = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.r = null;
        this.z = -9223372036854775807L;
        this.n.l();
        this.n = null;
        Iterator it = this.i.values().iterator();
        while (it.hasNext()) {
            ((d) it.next()).y();
        }
        this.o.removeCallbacksAndMessages(null);
        this.o = null;
        this.i.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.df1
    public void t(df1.b bVar) {
        gg3.q(bVar);
        this.j.add(bVar);
    }

    public ag0(oe1 oe1Var, sy1 sy1Var, cf1 cf1Var, ev evVar, xi4 xi4Var) {
        this(oe1Var, sy1Var, cf1Var, evVar, 3.5d, xi4Var);
    }
}
