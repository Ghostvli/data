package defpackage;

import android.net.Uri;
import defpackage.fg2;
import defpackage.no4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h74 extends no4 {
    public static final Object r = new Object();
    public static final fg2 s = new fg2.c().e("SinglePeriodTimeline").k(Uri.EMPTY).a();
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final long k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final Object o;
    public final fg2 p;
    public final fg2.g q;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h74(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, Object obj, fg2 fg2Var) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, false, obj, fg2Var, z3 ? fg2Var.d : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public int h(Object obj) {
        return r.equals(obj) ? 0 : -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public no4.b m(int i, no4.b bVar, boolean z) {
        gg3.o(i, 1);
        return bVar.u(null, z ? r : null, 0, this.h, -this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public int o() {
        return 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public Object s(int i) {
        gg3.o(i, 1);
        return r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r1
      0x002d: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v4 long) binds: [B:3:0x000c, B:5:0x0010, B:7:0x0016, B:12:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.no4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public no4.d u(int i, no4.d dVar, long j) {
        long j2;
        gg3.o(i, 1);
        long j3 = this.k;
        boolean z = this.m;
        if (!z || this.n || j == 0) {
            j2 = j3;
        } else {
            long j4 = this.i;
            if (j4 != -9223372036854775807L) {
                j3 += j;
                if (j3 > j4) {
                }
            }
            j2 = -9223372036854775807L;
        }
        return dVar.h(no4.d.q, this.p, this.o, this.e, this.f, this.g, this.l, z, this.q, j2, this.i, 0, 0, this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public int v() {
        return 1;
    }

    public h74(long j, boolean z, boolean z2, boolean z3, Object obj, fg2 fg2Var) {
        this(j, j, 0L, 0L, z, z2, z3, obj, fg2Var);
    }

    public h74(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, fg2 fg2Var, fg2.g gVar) {
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = j4;
        this.i = j5;
        this.j = j6;
        this.k = j7;
        this.l = z;
        this.m = z2;
        this.n = z3;
        this.o = obj;
        this.p = (fg2) gg3.q(fg2Var);
        this.q = gVar;
    }
}
