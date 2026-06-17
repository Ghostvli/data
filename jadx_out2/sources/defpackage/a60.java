package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class a60 implements yh4 {
    public static final x63 h = x63.d().f(new p81() { // from class: z50
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.p81
        public final Object apply(Object obj) {
            return Long.valueOf(a60.g(((y50) obj).b));
        }
    });
    public final xi1 f;
    public final long[] g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a60(List list) {
        if (list.size() == 1) {
            y50 y50Var = (y50) km1.g(list);
            long jG = g(y50Var.b);
            long j = y50Var.c;
            xi1 xi1Var = y50Var.a;
            if (j == -9223372036854775807L) {
                this.f = xi1.w(xi1Var);
                this.g = new long[]{jG};
                return;
            } else {
                this.f = xi1.x(xi1Var, xi1.u());
                this.g = new long[]{jG, y50Var.c + jG};
                return;
            }
        }
        long[] jArr = new long[list.size() * 2];
        this.g = jArr;
        Arrays.fill(jArr, Long.MAX_VALUE);
        ArrayList arrayList = new ArrayList();
        xi1 xi1VarE = xi1.E(h, list);
        int i = 0;
        for (int i2 = 0; i2 < xi1VarE.size(); i2++) {
            y50 y50Var2 = (y50) xi1VarE.get(i2);
            long jG2 = g(y50Var2.b);
            long j2 = y50Var2.c + jG2;
            if (i != 0) {
                int i3 = i - 1;
                long j3 = this.g[i3];
                if (j3 < jG2) {
                    this.g[i] = jG2;
                    arrayList.add(y50Var2.a);
                    i++;
                } else if (j3 == jG2 && ((xi1) arrayList.get(i3)).isEmpty()) {
                    arrayList.set(i3, y50Var2.a);
                } else {
                    xz1.i("CuesWithTimingSubtitle", "Truncating unsupported overlapping cues.");
                    this.g[i3] = jG2;
                    arrayList.set(i3, y50Var2.a);
                }
            }
            if (y50Var2.c != -9223372036854775807L) {
                this.g[i] = j2;
                arrayList.add(xi1.u());
                i++;
            }
        }
        this.f = xi1.p(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long g(long j) {
        if (j == -9223372036854775807L) {
            return 0L;
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public int a(long j) {
        int iG = fy4.g(this.g, j, false, false);
        if (iG < this.f.size()) {
            return iG;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public long b(int i) {
        gg3.d(i < this.f.size());
        return this.g[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: e(J)Ljava/util/List; */
    @Override // defpackage.yh4
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public xi1 e(long j) {
        int iK = fy4.k(this.g, j, true, false);
        return iK == -1 ? xi1.u() : (xi1) this.f.get(iK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public int f() {
        return this.f.size();
    }
}
