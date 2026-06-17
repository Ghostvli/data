package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zz3 {
    public static final zz3 c;
    public static final zz3 d;
    public static final zz3 e;
    public static final zz3 f;
    public static final zz3 g;
    public final long a;
    public final long b;

    static {
        zz3 zz3Var = new zz3(0L, 0L);
        c = zz3Var;
        d = new zz3(Long.MAX_VALUE, Long.MAX_VALUE);
        e = new zz3(Long.MAX_VALUE, 0L);
        f = new zz3(0L, Long.MAX_VALUE);
        g = zz3Var;
    }

    public zz3(long j, long j2) {
        gg3.d(j >= 0);
        gg3.d(j2 >= 0);
        this.a = j;
        this.b = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(long r8, long r10, long r12) {
        /*
            r7 = this;
            long r2 = r7.a
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto Lf
            long r4 = r7.b
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto Lf
            return r8
        Lf:
            r4 = -9223372036854775808
            r0 = r8
            long r8 = defpackage.fy4.K1(r0, r2, r4)
            long r2 = r7.b
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r2 = defpackage.fy4.f(r0, r2, r4)
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            r4 = 0
            r5 = 1
            if (r7 > 0) goto L2d
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 > 0) goto L2d
            r7 = r5
            goto L2e
        L2d:
            r7 = r4
        L2e:
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 > 0) goto L37
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 > 0) goto L37
            r4 = r5
        L37:
            if (r7 == 0) goto L4c
            if (r4 == 0) goto L4c
            long r7 = r10 - r0
            long r7 = java.lang.Math.abs(r7)
            long r0 = r12 - r0
            long r0 = java.lang.Math.abs(r0)
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 > 0) goto L51
            goto L4e
        L4c:
            if (r7 == 0) goto L4f
        L4e:
            return r10
        L4f:
            if (r4 == 0) goto L52
        L51:
            return r12
        L52:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zz3.a(long, long, long):long");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zz3.class == obj.getClass()) {
            zz3 zz3Var = (zz3) obj;
            if (this.a == zz3Var.a && this.b == zz3Var.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.a) * 31) + ((int) this.b);
    }
}
