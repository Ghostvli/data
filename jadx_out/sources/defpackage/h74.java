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

    public h74(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, Object obj, fg2 fg2Var) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, false, obj, fg2Var, z3 ? fg2Var.d : null);
    }

    @Override // defpackage.no4
    public int h(Object obj) {
        return r.equals(obj) ? 0 : -1;
    }

    @Override // defpackage.no4
    public no4.b m(int i, no4.b bVar, boolean z) {
        gg3.o(i, 1);
        return bVar.u(null, z ? r : null, 0, this.h, -this.j);
    }

    @Override // defpackage.no4
    public int o() {
        return 1;
    }

    @Override // defpackage.no4
    public Object s(int i) {
        gg3.o(i, 1);
        return r;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r1
      0x002d: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v4 long) binds: [B:3:0x000c, B:5:0x0010, B:7:0x0016, B:12:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.no4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public no4.d u(int r25, no4.d r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 1
            r2 = r25
            defpackage.gg3.o(r2, r1)
            long r1 = r0.k
            boolean r14 = r0.m
            if (r14 == 0) goto L2d
            boolean r3 = r0.n
            if (r3 != 0) goto L2d
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2d
            long r3 = r0.i
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L26
        L23:
            r16 = r5
            goto L2f
        L26:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2d
            goto L23
        L2d:
            r16 = r1
        L2f:
            java.lang.Object r4 = no4.d.q
            fg2 r5 = r0.p
            java.lang.Object r6 = r0.o
            long r7 = r0.e
            long r9 = r0.f
            long r11 = r0.g
            boolean r13 = r0.l
            fg2$g r15 = r0.q
            long r1 = r0.i
            r21 = 0
            r18 = r1
            long r0 = r0.j
            r20 = 0
            r3 = r26
            r22 = r0
            no4$d r0 = r3.h(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h74.u(int, no4$d, long):no4$d");
    }

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
