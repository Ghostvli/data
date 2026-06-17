package defpackage;

import defpackage.xi1;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface ki4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        public static final a a = new C0089a();

        /* JADX INFO: renamed from: ki4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0089a implements a {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ki4.a
            public boolean a(t41 t41Var) {
                return false;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ki4.a
            public ki4 b(t41 t41Var) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ki4.a
            public int c(t41 t41Var) {
                return 1;
            }
        }

        boolean a(t41 t41Var);

        ki4 b(t41 t41Var);

        int c(t41 t41Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static final b c = new b(-9223372036854775807L, false);
        public final long a;
        public final boolean b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(long j, boolean z) {
            this.a = j;
            this.b = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static b b() {
            return c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static b c(long j) {
            return new b(j, true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default yh4 a(byte[] bArr, int i, int i2) {
        final xi1.a aVarM = xi1.m();
        b bVar = b.c;
        Objects.requireNonNull(aVarM);
        b(bArr, i, i2, bVar, new g20() { // from class: ji4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.g20
            public final void accept(Object obj) {
                aVarM.a((y50) obj);
            }
        });
        return new a60(aVarM.k());
    }

    void b(byte[] bArr, int i, int i2, b bVar, g20 g20Var);

    int c();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void reset() {
    }
}
