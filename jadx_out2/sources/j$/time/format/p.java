package j$.time.format;

import j$.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends j {
    public static final LocalDate h = LocalDate.m0(2000, 1, 1);
    public final j$.time.chrono.b g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p(j$.time.temporal.p pVar, int i, int i2, j$.time.chrono.b bVar, int i3) {
        super(pVar, i, i2, f0.NOT_NEGATIVE, i3);
        this.g = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.j
    public final long a(y yVar, long j) {
        long jAbs = Math.abs(j);
        j$.time.chrono.b bVar = this.g;
        long jG = bVar != null ? j$.time.chrono.l.s(yVar.a).O(bVar).g(this.a) : 0;
        long[] jArr = j.f;
        if (j >= jG) {
            long j2 = jArr[this.b];
            if (j < jG + j2) {
                return jAbs % j2;
            }
        }
        return jAbs % jArr[this.c];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.j
    public final boolean b(w wVar) {
        if (wVar.c) {
            return super.b(wVar);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.j
    public final int c(final w wVar, long j, final int i, final int i2) {
        final p pVar;
        w wVar2;
        final long j2;
        int iG;
        long j3;
        j$.time.chrono.b bVar = this.g;
        if (bVar != null) {
            iG = wVar.d().O(bVar).g(this.a);
            pVar = this;
            j2 = j;
            Consumer consumer = new Consumer() { // from class: j$.time.format.o
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.c(wVar, j2, i, i2);
                }
            };
            wVar2 = wVar;
            if (wVar2.e == null) {
                wVar2.e = new ArrayList();
            }
            wVar2.e.add(consumer);
        } else {
            pVar = this;
            wVar2 = wVar;
            j2 = j;
            iG = 0;
        }
        int i3 = i2 - i;
        int i4 = pVar.b;
        if (i3 != i4 || j2 < 0) {
            j3 = j2;
        } else {
            long j4 = j.f[i4];
            long j5 = iG;
            long j6 = j5 - (j5 % j4);
            long j7 = iG > 0 ? j6 + j2 : j6 - j2;
            j3 = j7 < j5 ? j4 + j7 : j7;
        }
        return wVar2.g(pVar.a, j3, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.j
    public final j d() {
        if (this.e == -1) {
            return this;
        }
        return new p(this.a, this.b, this.c, this.g, -1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.j
    public final j e(int i) {
        return new p(this.a, this.b, this.c, this.g, this.e + i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.j
    public final String toString() {
        j$.time.chrono.b bVar = this.g;
        return "ReducedValue(" + this.a + "," + this.b + "," + this.c + "," + (bVar != null ? bVar : 0) + ")";
    }
}
