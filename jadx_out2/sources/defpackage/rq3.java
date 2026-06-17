package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rq3 implements x50 {
    public final ArrayList a = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x50
    public long a(long j) {
        if (this.a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j < ((y50) this.a.get(0)).b) {
            return ((y50) this.a.get(0)).b;
        }
        int i = 1;
        while (true) {
            int size = this.a.size();
            ArrayList arrayList = this.a;
            if (i >= size) {
                long j2 = ((y50) km1.d(arrayList)).d;
                if (j2 == -9223372036854775807L || j >= j2) {
                    return Long.MIN_VALUE;
                }
                return j2;
            }
            y50 y50Var = (y50) arrayList.get(i);
            if (j < y50Var.b) {
                long j3 = ((y50) this.a.get(i - 1)).d;
                return (j3 == -9223372036854775807L || j3 <= j || j3 >= y50Var.b) ? y50Var.b : j3;
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // defpackage.x50
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(y50 y50Var, long j) {
        boolean z;
        gg3.d(y50Var.b != -9223372036854775807L);
        if (y50Var.b <= j) {
            long j2 = y50Var.d;
            z = j2 == -9223372036854775807L || j < j2;
        }
        for (int size = this.a.size() - 1; size >= 0; size--) {
            long j3 = y50Var.b;
            long j4 = ((y50) this.a.get(size)).b;
            ArrayList arrayList = this.a;
            if (j3 >= j4) {
                arrayList.add(size + 1, y50Var);
                return z;
            }
            if (((y50) arrayList.get(size)).b <= j) {
                z = false;
            }
        }
        this.a.add(0, y50Var);
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x50
    public xi1 c(long j) {
        int iF = f(j);
        if (iF == 0) {
            return xi1.u();
        }
        y50 y50Var = (y50) this.a.get(iF - 1);
        long j2 = y50Var.d;
        return (j2 == -9223372036854775807L || j < j2) ? y50Var.a : xi1.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x50
    public void clear() {
        this.a.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x50
    public long d(long j) {
        if (this.a.isEmpty() || j < ((y50) this.a.get(0)).b) {
            return -9223372036854775807L;
        }
        int i = 1;
        while (true) {
            int size = this.a.size();
            ArrayList arrayList = this.a;
            if (i >= size) {
                y50 y50Var = (y50) km1.d(arrayList);
                long j2 = y50Var.d;
                return (j2 == -9223372036854775807L || j < j2) ? y50Var.b : j2;
            }
            long j3 = ((y50) arrayList.get(i)).b;
            if (j == j3) {
                return j3;
            }
            if (j < j3) {
                y50 y50Var2 = (y50) this.a.get(i - 1);
                long j4 = y50Var2.d;
                return (j4 == -9223372036854775807L || j4 > j) ? y50Var2.b : j4;
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x50
    public void e(long j) {
        int iF = f(j);
        if (iF == 0) {
            return;
        }
        long j2 = ((y50) this.a.get(iF - 1)).d;
        if (j2 == -9223372036854775807L || j2 >= j) {
            iF--;
        }
        this.a.subList(0, iF).clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int f(long j) {
        int i = 0;
        while (true) {
            int size = this.a.size();
            ArrayList arrayList = this.a;
            if (i >= size) {
                return arrayList.size();
            }
            if (j < ((y50) arrayList.get(i)).b) {
                return i;
            }
            i++;
        }
    }
}
