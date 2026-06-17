package defpackage;

import android.os.Bundle;
import defpackage.hd3;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c24 {
    public static final hd3.e k;
    public static final c24 l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public final hd3.e a;
    public final boolean b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        hd3.e eVar = new hd3.e(null, 0, null, null, 0, 0L, 0L, -1, -1);
        k = eVar;
        l = new c24(eVar, false, -9223372036854775807L, -9223372036854775807L, 0L, 0, 0L, -9223372036854775807L, -9223372036854775807L, 0L);
        m = fy4.N0(0);
        n = fy4.N0(1);
        o = fy4.N0(2);
        p = fy4.N0(3);
        q = fy4.N0(4);
        r = fy4.N0(5);
        s = fy4.N0(6);
        t = fy4.N0(7);
        u = fy4.N0(8);
        v = fy4.N0(9);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c24(hd3.e eVar, boolean z, long j, long j2, long j3, int i, long j4, long j5, long j6, long j7) {
        gg3.d(z == (eVar.i != -1));
        this.a = eVar;
        this.b = z;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = i;
        this.g = j4;
        this.h = j5;
        this.i = j6;
        this.j = j7;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c24 b(Bundle bundle, int i) {
        Bundle bundle2 = bundle.getBundle(m);
        return new c24(bundle2 == null ? k : hd3.e.c(bundle2, i), bundle.getBoolean(n, false), bundle.getLong(o, -9223372036854775807L), bundle.getLong(p, -9223372036854775807L), bundle.getLong(q, 0L), bundle.getInt(r, 0), bundle.getLong(s, 0L), bundle.getLong(t, -9223372036854775807L), bundle.getLong(u, -9223372036854775807L), bundle.getLong(v, 0L));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public defpackage.c24 a(boolean r21, boolean r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            if (r1 == 0) goto Lb
            if (r2 == 0) goto Lb
            return r0
        Lb:
            c24 r3 = new c24
            hd3$e r4 = r0.a
            hd3$e r2 = r4.b(r1, r2)
            r4 = 0
            if (r1 == 0) goto L1e
            boolean r5 = r0.b
            if (r5 == 0) goto L1e
            r5 = 1
            r7 = r4
        L1c:
            r6 = r3
            goto L21
        L1e:
            r5 = r4
            r7 = r5
            goto L1c
        L21:
            long r3 = r0.c
            if (r1 == 0) goto L28
            long r10 = r0.d
            goto L2d
        L28:
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L2d:
            if (r1 == 0) goto L32
            long r14 = r0.e
            goto L34
        L32:
            r14 = 0
        L34:
            if (r1 == 0) goto L38
            int r7 = r0.f
        L38:
            if (r1 == 0) goto L3d
            long r8 = r0.g
            goto L3f
        L3d:
            r8 = 0
        L3f:
            if (r1 == 0) goto L44
            long r12 = r0.h
            goto L49
        L44:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L49:
            r22 = r2
            if (r1 == 0) goto L52
            long r1 = r0.i
            r16 = r1
            goto L57
        L52:
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L57:
            if (r21 == 0) goto L6a
            long r0 = r0.j
            r2 = r5
            r18 = r0
            r0 = r6
            r5 = r10
            r10 = r8
            r9 = r7
            r7 = r14
            r14 = r16
            r16 = r18
        L67:
            r1 = r22
            goto L75
        L6a:
            r2 = r5
            r0 = r6
            r5 = r10
            r10 = r8
            r9 = r7
            r7 = r14
            r14 = r16
            r16 = 0
            goto L67
        L75:
            r0.<init>(r1, r2, r3, r5, r7, r9, r10, r12, r14, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c24.a(boolean, boolean):c24");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle c(int i) {
        Bundle bundle = new Bundle();
        if (i < 3 || !k.a(this.a)) {
            bundle.putBundle(m, this.a.d(i));
        }
        boolean z = this.b;
        if (z) {
            bundle.putBoolean(n, z);
        }
        long j = this.c;
        if (j != -9223372036854775807L) {
            bundle.putLong(o, j);
        }
        long j2 = this.d;
        if (j2 != -9223372036854775807L) {
            bundle.putLong(p, j2);
        }
        if (i < 3 || this.e != 0) {
            bundle.putLong(q, this.e);
        }
        int i2 = this.f;
        if (i2 != 0) {
            bundle.putInt(r, i2);
        }
        long j3 = this.g;
        if (j3 != 0) {
            bundle.putLong(s, j3);
        }
        long j4 = this.h;
        if (j4 != -9223372036854775807L) {
            bundle.putLong(t, j4);
        }
        long j5 = this.i;
        if (j5 != -9223372036854775807L) {
            bundle.putLong(u, j5);
        }
        if (i >= 3 && this.j == 0) {
            return bundle;
        }
        bundle.putLong(v, this.j);
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c24.class == obj.getClass()) {
            c24 c24Var = (c24) obj;
            if (this.c == c24Var.c && this.a.equals(c24Var.a) && this.b == c24Var.b && this.d == c24Var.d && this.e == c24Var.e && this.f == c24Var.f && this.g == c24Var.g && this.h == c24Var.h && this.i == c24Var.i && this.j == c24Var.j) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(this.a, Boolean.valueOf(this.b));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "SessionPositionInfo {PositionInfo {mediaItemIndex=" + this.a.c + ", periodIndex=" + this.a.f + ", positionMs=" + this.a.g + ", contentPositionMs=" + this.a.h + ", adGroupIndex=" + this.a.i + ", adIndexInAdGroup=" + this.a.j + "}, isPlayingAd=" + this.b + ", eventTimeMs=" + this.c + ", durationMs=" + this.d + ", bufferedPositionMs=" + this.e + ", bufferedPercentage=" + this.f + ", totalBufferedDurationMs=" + this.g + ", currentLiveOffsetMs=" + this.h + ", contentDurationMs=" + this.i + ", contentBufferedPositionMs=" + this.j + "}";
    }
}
