package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yc4 extends uc4 {
    public final List a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final long b;

        public b(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final long a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final long e;
        public final List f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        public c(long j, boolean z, boolean z2, boolean z3, List list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.a = j;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.f = Collections.unmodifiableList(list);
            this.e = j2;
            this.g = z4;
            this.h = j3;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        public static c b(r73 r73Var) {
            boolean z;
            ArrayList arrayList;
            boolean z2;
            boolean z3;
            long j;
            boolean z4;
            long j2;
            int i;
            int i2;
            int iQ;
            boolean z5;
            long jS;
            long jS2 = r73Var.S();
            boolean z6 = true;
            if ((r73Var.Q() & 128) != 0) {
                z = true;
            } else {
                z = true;
                z6 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (z6) {
                arrayList = arrayList2;
                z2 = false;
                z3 = false;
                j = -9223372036854775807L;
                z4 = false;
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
                iQ = 0;
            } else {
                int iQ2 = r73Var.Q();
                boolean z7 = (iQ2 & 128) != 0 ? z : false;
                boolean z8 = (iQ2 & 64) != 0 ? z : false;
                boolean z9 = (iQ2 & 32) != 0 ? z : false;
                long jS3 = z8 ? r73Var.S() : -9223372036854775807L;
                if (!z8) {
                    int iQ3 = r73Var.Q();
                    ArrayList arrayList3 = new ArrayList(iQ3);
                    int i3 = 0;
                    while (i3 < iQ3) {
                        arrayList3.add(new b(r73Var.Q(), r73Var.S()));
                        i3++;
                        iQ3 = iQ3;
                    }
                    arrayList2 = arrayList3;
                }
                if (z9) {
                    long jQ = r73Var.Q();
                    boolean z10 = (128 & jQ) != 0;
                    jS = ((((jQ & 1) << 32) | r73Var.S()) * 1000) / 90;
                    z5 = z10;
                } else {
                    z5 = false;
                    jS = -9223372036854775807L;
                }
                int iY = r73Var.Y();
                int iQ4 = r73Var.Q();
                boolean z11 = z7;
                z4 = z5;
                z2 = z11;
                iQ = r73Var.Q();
                long j3 = jS3;
                i = iY;
                i2 = iQ4;
                long j4 = jS;
                arrayList = arrayList2;
                z3 = z8;
                j = j3;
                j2 = j4;
            }
            return new c(jS2, z6, z2, z3, arrayList, j, z4, j2, i, i2, iQ);
        }
    }

    public yc4(List list) {
        this.a = Collections.unmodifiableList(list);
    }

    public static yc4 d(r73 r73Var) {
        int iQ = r73Var.Q();
        ArrayList arrayList = new ArrayList(iQ);
        for (int i = 0; i < iQ; i++) {
            arrayList.add(c.b(r73Var));
        }
        return new yc4(arrayList);
    }
}
