package defpackage;

import android.net.Uri;
import defpackage.aa0;
import defpackage.ao;
import defpackage.fo;
import defpackage.h01;
import defpackage.z90;
import java.io.File;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class go implements aa0 {
    public final ao a;
    public final aa0 b;
    public final aa0 c;
    public final aa0 d;
    public final lo e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public Uri i;
    public ja0 j;
    public ja0 k;
    public aa0 l;
    public long m;
    public long n;
    public long o;
    public no p;
    public boolean q;
    public boolean r;
    public long s;
    public long t;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements aa0.a {
        public ao a;
        public z90.a c;
        public boolean e;
        public aa0.a f;
        public int g;
        public int h;
        public aa0.a b = new h01.a();
        public lo d = lo.a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b()Laa0; */
        @Override // aa0.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public go b() {
            aa0.a aVar = this.f;
            return d(aVar != null ? aVar.b() : null, this.h, this.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final go d(aa0 aa0Var, int i, int i2) {
            z90 z90VarA;
            ao aoVar = (ao) gg3.q(this.a);
            if (this.e || aa0Var == null) {
                z90VarA = null;
            } else {
                z90.a aVar = this.c;
                z90VarA = aVar != null ? aVar.a() : new fo.b().b(aoVar).a();
            }
            return new go(aoVar, aa0Var, this.b.b(), z90VarA, this.d, i, null, i2, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c e(ao aoVar) {
            this.a = aoVar;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c f(z90.a aVar) {
            this.c = aVar;
            this.e = aVar == null;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c g(int i) {
            this.h = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c h(aa0.a aVar) {
            this.f = aVar;
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public go(ao aoVar, aa0 aa0Var, aa0 aa0Var2, z90 z90Var, lo loVar, int i, vg3 vg3Var, int i2, b bVar) {
        this.a = aoVar;
        this.b = aa0Var2;
        this.e = loVar == null ? lo.a : loVar;
        this.f = (i & 1) != 0;
        this.g = (i & 2) != 0;
        this.h = (i & 4) != 0;
        if (aa0Var != null) {
            this.d = aa0Var;
            this.c = z90Var != null ? new am4(aa0Var, z90Var) : null;
        } else {
            this.d = gb3.a;
            this.c = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Uri t(ao aoVar, String str, Uri uri) {
        Uri uriD = t20.d(aoVar.b(str));
        return uriD != null ? uriD : uri;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(int i) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B(ja0 ja0Var, boolean z) throws InterruptedIOException {
        no noVarE;
        long jMin;
        ja0 ja0VarA;
        aa0 aa0Var;
        String str = (String) fy4.l(ja0Var.i);
        if (this.r) {
            noVarE = null;
        } else {
            boolean z2 = this.f;
            ao aoVar = this.a;
            if (z2) {
                try {
                    noVarE = aoVar.e(str, this.n, this.o);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            } else {
                noVarE = aoVar.d(str, this.n, this.o);
            }
        }
        if (noVarE == null) {
            aa0Var = this.d;
            ja0VarA = ja0Var.a().h(this.n).g(this.o).a();
        } else if (noVarE.i) {
            Uri uriFromFile = Uri.fromFile((File) fy4.l(noVarE.j));
            long j = noVarE.g;
            long j2 = this.n - j;
            long jMin2 = noVarE.h - j2;
            long j3 = this.o;
            if (j3 != -1) {
                jMin2 = Math.min(jMin2, j3);
            }
            ja0VarA = ja0Var.a().i(uriFromFile).k(j).h(j2).g(jMin2).a();
            aa0Var = this.b;
        } else {
            if (noVarE.e()) {
                jMin = this.o;
            } else {
                jMin = noVarE.h;
                long j4 = this.o;
                if (j4 != -1) {
                    jMin = Math.min(jMin, j4);
                }
            }
            ja0VarA = ja0Var.a().h(this.n).g(jMin).a();
            aa0Var = this.c;
            if (aa0Var == null) {
                aa0Var = this.d;
                this.a.c(noVarE);
                noVarE = null;
            }
        }
        this.t = (this.r || aa0Var != this.d) ? Long.MAX_VALUE : this.n + 102400;
        if (z) {
            gg3.v(v());
            if (aa0Var == this.d) {
                return;
            }
            try {
                h();
            } catch (Throwable th) {
                if (((no) fy4.l(noVarE)).b()) {
                    this.a.c(noVarE);
                }
                throw th;
            }
        }
        if (noVarE != null && noVarE.b()) {
            this.p = noVarE;
        }
        this.l = aa0Var;
        this.k = ja0VarA;
        this.m = 0L;
        long jA = aa0Var.a(ja0VarA);
        u20 u20Var = new u20();
        if (ja0VarA.h == -1 && jA != -1) {
            this.o = jA;
            u20.g(u20Var, this.n + jA);
        }
        if (x()) {
            Uri uri = aa0Var.getUri();
            this.i = uri;
            u20.h(u20Var, ja0Var.a.equals(uri) ? null : this.i);
        }
        if (y()) {
            this.a.g(str, u20Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(String str) {
        this.o = 0L;
        if (y()) {
            u20 u20Var = new u20();
            u20.g(u20Var, this.n);
            this.a.g(str, u20Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int D(ja0 ja0Var) {
        if (this.g && this.q) {
            return 0;
        }
        return (this.h && ja0Var.h == -1) ? 1 : -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public long a(ja0 ja0Var) {
        try {
            String strB = this.e.b(ja0Var);
            ja0 ja0VarA = ja0Var.a().f(strB).a();
            this.j = ja0VarA;
            this.i = t(this.a, strB, ja0VarA.a);
            this.n = ja0Var.g;
            int iD = D(ja0Var);
            boolean z = iD != -1;
            this.r = z;
            if (z) {
                A(iD);
            }
            if (this.r) {
                this.o = -1L;
            } else {
                long jA = t20.a(this.a.b(strB));
                this.o = jA;
                if (jA != -1) {
                    long j = jA - ja0Var.g;
                    this.o = j;
                    if (j < 0) {
                        throw new ga0(2008);
                    }
                }
            }
            long jMin = ja0Var.h;
            if (jMin != -1) {
                long j2 = this.o;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.o = jMin;
            }
            long j3 = this.o;
            if (j3 > 0 || j3 == -1) {
                B(ja0VarA, false);
            }
            long j4 = ja0Var.h;
            return j4 != -1 ? j4 : this.o;
        } catch (Throwable th) {
            u(th);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public void close() {
        this.j = null;
        this.i = null;
        this.n = 0L;
        z();
        try {
            h();
        } catch (Throwable th) {
            u(th);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public void f(hs4 hs4Var) {
        gg3.q(hs4Var);
        this.b.f(hs4Var);
        this.d.f(hs4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public Uri getUri() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        aa0 aa0Var = this.l;
        if (aa0Var == null) {
            return;
        }
        try {
            aa0Var.close();
        } finally {
            this.k = null;
            this.l = null;
            no noVar = this.p;
            if (noVar != null) {
                this.a.c(noVar);
                this.p = null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public Map o() {
        return x() ? this.d.o() : Collections.EMPTY_MAP;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (r17.m < r13) goto L29;
     */
    @Override // defpackage.x90
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] bArr, int i, int i2) {
        long j;
        if (i2 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        ja0 ja0Var = (ja0) gg3.q(this.j);
        ja0 ja0Var2 = (ja0) gg3.q(this.k);
        try {
            if (this.n >= this.t) {
                B(ja0Var, true);
            }
            int i3 = ((aa0) gg3.q(this.l)).read(bArr, i, i2);
            if (i3 == -1) {
                if (x()) {
                    long j2 = ja0Var2.h;
                    if (j2 != -1) {
                        j = 0;
                    }
                    C((String) fy4.l(ja0Var.i));
                    return i3;
                }
                j = 0;
                long j3 = this.o;
                if (j3 <= j) {
                    if (j3 == -1) {
                    }
                }
                h();
                B(ja0Var, false);
                return read(bArr, i, i2);
            }
            if (w()) {
                this.s += (long) i3;
            }
            long j4 = i3;
            this.n += j4;
            this.m += j4;
            long j5 = this.o;
            if (j5 != -1) {
                this.o = j5 - j4;
                return i3;
            }
            return i3;
        } catch (Throwable th) {
            u(th);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(Throwable th) {
        if (w() || (th instanceof ao.a)) {
            this.q = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean v() {
        return this.l == this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w() {
        return this.l == this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean x() {
        return !w();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean y() {
        return this.l == this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z() {
    }
}
