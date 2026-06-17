package defpackage;

import defpackage.b21;
import defpackage.tj;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class y11 extends tj {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements tj.f {
        public final f21 a;
        public final int b;
        public final b21.a c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(f21 f21Var, int i) {
            this.a = f21Var;
            this.b = i;
            this.c = new b21.a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // tj.f
        public tj.e a(jz0 jz0Var, long j) {
            long position = jz0Var.getPosition();
            long jC = c(jz0Var);
            long jK = jz0Var.k();
            jz0Var.m(Math.max(6, this.a.c));
            long jC2 = c(jz0Var);
            return (jC > j || jC2 <= j) ? jC2 <= j ? tj.e.f(jC2, jz0Var.k()) : tj.e.d(jC, position) : tj.e.e(jK);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final long c(jz0 jz0Var) {
            while (jz0Var.k() < jz0Var.getLength() - 6 && !b21.i(jz0Var, this.a, this.b, this.c)) {
                jz0Var.m(1);
            }
            if (jz0Var.k() < jz0Var.getLength() - 6) {
                return this.c.a;
            }
            jz0Var.m((int) (jz0Var.getLength() - jz0Var.k()));
            return this.a.j;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y11(final f21 f21Var, int i, long j, long j2) {
        super(new tj.d() { // from class: x11
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // tj.d
            public final long a(long j3) {
                return f21Var.i(j3);
            }
        }, new b(f21Var, i), f21Var.f(), 0L, f21Var.j, j, j2, f21Var.d(), Math.max(6, f21Var.c));
        Objects.requireNonNull(f21Var);
    }
}
