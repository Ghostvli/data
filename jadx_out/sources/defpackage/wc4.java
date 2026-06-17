package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wc4 extends uc4 {
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final List h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final long b;
        public final long c;

        public b(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }
    }

    public wc4(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List list, boolean z5, long j4, int i, int i2, int i3) {
        this.a = j;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = j2;
        this.g = j3;
        this.h = Collections.unmodifiableList(list);
        this.i = z5;
        this.j = j4;
        this.k = i;
        this.l = i2;
        this.m = i3;
    }

    public static wc4 d(r73 r73Var, long j, yo4 yo4Var) {
        List list;
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int iQ;
        int iQ2;
        boolean z5;
        int i2;
        long jE;
        long jS = r73Var.S();
        boolean z6 = (r73Var.Q() & 128) != 0;
        List list2 = Collections.EMPTY_LIST;
        long jS2 = -9223372036854775807L;
        if (z6) {
            list = list2;
            j2 = -9223372036854775807L;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            i = 0;
            iQ = 0;
            iQ2 = 0;
        } else {
            int iQ3 = r73Var.Q();
            boolean z7 = (iQ3 & 128) != 0;
            boolean z8 = (iQ3 & 64) != 0;
            boolean z9 = (iQ3 & 32) != 0;
            boolean z10 = (iQ3 & 16) != 0;
            long jE2 = (!z8 || z10) ? -9223372036854775807L : jo4.e(r73Var, j);
            if (!z8) {
                int iQ4 = r73Var.Q();
                ArrayList arrayList = new ArrayList(iQ4);
                int i3 = 0;
                while (i3 < iQ4) {
                    int iQ5 = r73Var.Q();
                    if (z10) {
                        i2 = iQ4;
                        jE = -9223372036854775807L;
                    } else {
                        i2 = iQ4;
                        jE = jo4.e(r73Var, j);
                    }
                    arrayList.add(new b(iQ5, jE, yo4Var.b(jE)));
                    i3++;
                    iQ4 = i2;
                }
                list2 = arrayList;
            }
            if (z9) {
                long jQ = r73Var.Q();
                boolean z11 = (128 & jQ) != 0;
                jS2 = ((((jQ & 1) << 32) | r73Var.S()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
            }
            int iY = r73Var.Y();
            long j3 = jE2;
            j2 = jS2;
            jS2 = j3;
            iQ = r73Var.Q();
            iQ2 = r73Var.Q();
            i = iY;
            z4 = z5;
            z = z7;
            z2 = z8;
            list = list2;
            z3 = z10;
        }
        return new wc4(jS, z6, z, z2, z3, jS2, yo4Var.b(jS2), list, z4, j2, i, iQ, iQ2);
    }

    @Override // defpackage.uc4
    public String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.f + ", programSplicePlaybackPositionUs= " + this.g + " }";
    }
}
