package defpackage;

import android.util.Range;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class m25 {
    public long a;
    public long b;
    public double c;
    public Range d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public m25(float f) {
        gg3.d(f > 0.0f);
        Range range = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d / ((double) f)));
        this.d = range;
        this.c = ((Double) range.getUpper()).doubleValue();
        this.a = -9223372036854775807L;
        this.b = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final double a(long j, long j2) {
        long j3 = this.a;
        if (j3 != -9223372036854775807L) {
            if (this.b != -9223372036854775807L && j != j3) {
                return (j2 - r4) / (j - j3);
            }
        }
        return ((Double) this.d.getUpper()).doubleValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(long j, long j2) {
        gg3.d(j != -9223372036854775807L);
        gg3.d(j2 != -9223372036854775807L);
        f(((Double) this.d.clamp(Double.valueOf(a(j, j2)))).doubleValue());
        this.a = j;
        this.b = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long c(long j) {
        if (this.a == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (long) (this.b + ((j - r0) * this.c));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d() {
        this.c = ((Double) this.d.getUpper()).doubleValue();
        this.a = -9223372036854775807L;
        this.b = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(float f) {
        gg3.d(f > 0.0f);
        this.d = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d / ((double) f)));
        d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(double d) {
        this.c = (this.c * 0.800000011920929d) + (d * 0.20000000298023224d);
    }
}
