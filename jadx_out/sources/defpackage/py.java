package defpackage;

import androidx.media3.exoplayer.j;
import defpackage.xi1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class py implements i14 {
    public final xi1 f;
    public long g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements i14 {
        public final i14 f;
        public final xi1 g;

        public a(i14 i14Var, List list) {
            this.f = i14Var;
            this.g = xi1.p(list);
        }

        public xi1 a() {
            return this.g;
        }

        @Override // defpackage.i14
        public boolean b(j jVar) {
            return this.f.b(jVar);
        }

        @Override // defpackage.i14
        public long c() {
            return this.f.c();
        }

        @Override // defpackage.i14
        public long f() {
            return this.f.f();
        }

        @Override // defpackage.i14
        public void g(long j) {
            this.f.g(j);
        }

        @Override // defpackage.i14
        public boolean isLoading() {
            return this.f.isLoading();
        }
    }

    public py(List list, List list2) {
        xi1.a aVarM = xi1.m();
        gg3.d(list.size() == list2.size());
        for (int i = 0; i < list.size(); i++) {
            aVarM.a(new a((i14) list.get(i), (List) list2.get(i)));
        }
        this.f = aVarM.k();
        this.g = -9223372036854775807L;
    }

    @Override // defpackage.i14
    public boolean b(j jVar) {
        boolean zB;
        boolean z = false;
        do {
            long jC = c();
            if (jC == Long.MIN_VALUE) {
                return z;
            }
            zB = false;
            for (int i = 0; i < this.f.size(); i++) {
                long jC2 = ((a) this.f.get(i)).c();
                boolean z2 = jC2 != Long.MIN_VALUE && jC2 <= jVar.a;
                if (jC2 == jC || z2) {
                    zB |= ((a) this.f.get(i)).b(jVar);
                }
            }
            z |= zB;
        } while (zB);
        return z;
    }

    @Override // defpackage.i14
    public long c() {
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < this.f.size(); i++) {
            long jC = ((a) this.f.get(i)).c();
            if (jC != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jC);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // defpackage.i14
    public long f() {
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        for (int i = 0; i < this.f.size(); i++) {
            a aVar = (a) this.f.get(i);
            long jF = aVar.f();
            if ((aVar.a().contains(1) || aVar.a().contains(2) || aVar.a().contains(4)) && jF != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jF);
            }
            if (jF != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jF);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            this.g = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j = this.g;
        return j != -9223372036854775807L ? j : jMin2;
    }

    @Override // defpackage.i14
    public void g(long j) {
        for (int i = 0; i < this.f.size(); i++) {
            ((a) this.f.get(i)).g(j);
        }
    }

    @Override // defpackage.i14
    public boolean isLoading() {
        for (int i = 0; i < this.f.size(); i++) {
            if (((a) this.f.get(i)).isLoading()) {
                return true;
            }
        }
        return false;
    }
}
