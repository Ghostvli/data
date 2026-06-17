package j$.time.chrono;

import j$.time.temporal.ChronoUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements j$.time.temporal.o, Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = 57387258289L;
    public final l a;
    public final int b;
    public final int c;
    public final int d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        j$.desugar.sun.nio.fs.g.o(new Object[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h(l lVar, int i, int i2, int i3) {
        this.a = lVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.b == hVar.b && this.c == hVar.c && this.d == hVar.d && this.a.equals(hVar.a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int hashCode() {
        return this.a.hashCode() ^ (Integer.rotateLeft(this.d, 16) + (Integer.rotateLeft(this.c, 8) + this.b));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        if (this.b == 0 && this.c == 0 && this.d == 0) {
            return this.a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.toString());
        sb.append(" P");
        int i = this.b;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.c;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.d;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.temporal.o
    public final j$.time.temporal.l u(j$.time.temporal.l lVar) {
        l lVar2 = (l) lVar.b(j$.time.temporal.q.b);
        if (lVar2 != null && !this.a.equals(lVar2)) {
            j$.nio.file.j.f("Chronology mismatch, expected: ", this.a.q(), ", actual: ", lVar2.q());
            return null;
        }
        if (this.c == 0) {
            int i = this.b;
            if (i != 0) {
                lVar = lVar.d(i, ChronoUnit.YEARS);
            }
        } else {
            j$.time.temporal.s sVarF = this.a.F(j$.time.temporal.a.MONTH_OF_YEAR);
            long j = (sVarF.a == sVarF.b && sVarF.c == sVarF.d && sVarF.d()) ? (sVarF.d - sVarF.a) + 1 : -1L;
            int i2 = this.b;
            if (j > 0) {
                lVar = lVar.d((((long) i2) * j) + ((long) this.c), ChronoUnit.MONTHS);
            } else {
                if (i2 != 0) {
                    lVar = lVar.d(i2, ChronoUnit.YEARS);
                }
                lVar = lVar.d(this.c, ChronoUnit.MONTHS);
            }
        }
        int i3 = this.d;
        return i3 != 0 ? lVar.d(i3, ChronoUnit.DAYS) : lVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object writeReplace() {
        return new e0((byte) 9, this);
    }
}
