package defpackage;

import androidx.media3.exoplayer.j;
import defpackage.jq2;
import defpackage.mi2;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h52 implements mi2, mi2.a {
    public final jq2.b f;
    public final long g;
    public final j5 h;
    public jq2 i;
    public mi2 j;
    public mi2.a k;
    public a l;
    public boolean m;
    public long n = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(jq2.b bVar);

        void b(jq2.b bVar, IOException iOException);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h52(jq2.b bVar, j5 j5Var, long j) {
        this.f = bVar;
        this.h = j5Var;
        this.g = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(jq2.b bVar) {
        long jU = u(this.g);
        mi2 mi2VarD = ((jq2) gg3.q(this.i)).d(bVar, this.h, jU);
        this.j = mi2VarD;
        if (this.k != null) {
            mi2VarD.r(this, jU);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean b(j jVar) {
        mi2 mi2Var = this.j;
        return mi2Var != null && mi2Var.b(jVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long c() {
        return ((mi2) fy4.l(this.j)).c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long d(long j, zz3 zz3Var) {
        return ((mi2) fy4.l(this.j)).d(j, zz3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // mi2.a
    public void e(mi2 mi2Var) {
        ((mi2.a) fy4.l(this.k)).e(this);
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(this.f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public long f() {
        return ((mi2) fy4.l(this.j)).f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public void g(long j) {
        ((mi2) fy4.l(this.j)).g(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long h(long j) {
        mi2 mi2Var = this.j;
        if (mi2Var != null) {
            return mi2Var.h(j);
        }
        return Long.MIN_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2, defpackage.i14
    public boolean isLoading() {
        mi2 mi2Var = this.j;
        return mi2Var != null && mi2Var.isLoading();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j) {
        long j2 = this.n;
        if (j2 != -9223372036854775807L && j == this.g) {
            j = j2;
        }
        this.n = -9223372036854775807L;
        return ((mi2) fy4.l(this.j)).k(jy0VarArr, zArr, gx3VarArr, zArr2, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void m() throws IOException {
        try {
            mi2 mi2Var = this.j;
            if (mi2Var != null) {
                mi2Var.m();
                return;
            }
            jq2 jq2Var = this.i;
            if (jq2Var != null) {
                jq2Var.m();
            }
        } catch (IOException e) {
            a aVar = this.l;
            if (aVar == null) {
                throw e;
            }
            if (this.m) {
                return;
            }
            this.m = true;
            aVar.b(this.f, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long n(long j) {
        return ((mi2) fy4.l(this.j)).n(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long o() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long p() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public long q() {
        return ((mi2) fy4.l(this.j)).q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void r(mi2.a aVar, long j) {
        this.k = aVar;
        mi2 mi2Var = this.j;
        if (mi2Var != null) {
            mi2Var.r(this, u(this.g));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public er4 s() {
        return ((mi2) fy4.l(this.j)).s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mi2
    public void t(long j, boolean z) {
        ((mi2) fy4.l(this.j)).t(j, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long u(long j) {
        long j2 = this.n;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Li14;)V */
    @Override // i14.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void j(mi2 mi2Var) {
        ((mi2.a) fy4.l(this.k)).j(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w(long j) {
        this.n = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x() {
        if (this.j != null) {
            ((jq2) gg3.q(this.i)).s(this.j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y(jq2 jq2Var) {
        gg3.v(this.i == null);
        this.i = jq2Var;
    }
}
