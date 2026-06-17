package defpackage;

import defpackage.xi1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ks2 implements x50 {
    public static final x63 b = x63.d().f(new p81() { // from class: is2
        @Override // defpackage.p81
        public final Object apply(Object obj) {
            return Long.valueOf(((y50) obj).b);
        }
    }).a(x63.d().g().f(new p81() { // from class: js2
        @Override // defpackage.p81
        public final Object apply(Object obj) {
            return Long.valueOf(((y50) obj).c);
        }
    }));
    public final List a = new ArrayList();

    @Override // defpackage.x50
    public long a(long j) {
        int i = 0;
        long jMin = -9223372036854775807L;
        while (true) {
            if (i >= this.a.size()) {
                break;
            }
            long j2 = ((y50) this.a.get(i)).b;
            long j3 = ((y50) this.a.get(i)).d;
            if (j < j2) {
                jMin = jMin == -9223372036854775807L ? j2 : Math.min(jMin, j2);
            } else {
                if (j < j3) {
                    jMin = jMin == -9223372036854775807L ? j3 : Math.min(jMin, j3);
                }
                i++;
            }
        }
        if (jMin != -9223372036854775807L) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // defpackage.x50
    public boolean b(y50 y50Var, long j) {
        gg3.d(y50Var.b != -9223372036854775807L);
        gg3.d(y50Var.c != -9223372036854775807L);
        boolean z = y50Var.b <= j && j < y50Var.d;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (y50Var.b >= ((y50) this.a.get(size)).b) {
                this.a.add(size + 1, y50Var);
                return z;
            }
        }
        this.a.add(0, y50Var);
        return z;
    }

    @Override // defpackage.x50
    public xi1 c(long j) {
        if (!this.a.isEmpty()) {
            if (j >= ((y50) this.a.get(0)).b) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.a.size(); i++) {
                    y50 y50Var = (y50) this.a.get(i);
                    if (j >= y50Var.b && j < y50Var.d) {
                        arrayList.add(y50Var);
                    }
                    if (j < y50Var.b) {
                        break;
                    }
                }
                xi1 xi1VarE = xi1.E(b, arrayList);
                xi1.a aVarM = xi1.m();
                for (int i2 = 0; i2 < xi1VarE.size(); i2++) {
                    aVarM.j(((y50) xi1VarE.get(i2)).a);
                }
                return aVarM.k();
            }
        }
        return xi1.u();
    }

    @Override // defpackage.x50
    public void clear() {
        this.a.clear();
    }

    @Override // defpackage.x50
    public long d(long j) {
        if (this.a.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j < ((y50) this.a.get(0)).b) {
            return -9223372036854775807L;
        }
        long jMax = ((y50) this.a.get(0)).b;
        for (int i = 0; i < this.a.size(); i++) {
            long j2 = ((y50) this.a.get(i)).b;
            long j3 = ((y50) this.a.get(i)).d;
            if (j3 > j) {
                if (j2 > j) {
                    break;
                }
                jMax = Math.max(jMax, j2);
            } else {
                jMax = Math.max(jMax, j3);
            }
        }
        return jMax;
    }

    @Override // defpackage.x50
    public void e(long j) {
        int i = 0;
        while (i < this.a.size()) {
            long j2 = ((y50) this.a.get(i)).b;
            if (j > j2 && j > ((y50) this.a.get(i)).d) {
                this.a.remove(i);
                i--;
            } else if (j < j2) {
                return;
            }
            i++;
        }
    }
}
