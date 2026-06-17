package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class uj3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends uj3 {
        public final Appendable a;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface a {
            void a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Appendable appendable) {
            this.a = appendable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.uj3
        public uj3 c(final char[] cArr, final int i, final int i2) {
            return j(new a() { // from class: wj3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // uj3.b.a
                public final void a() throws IOException {
                    this.a.a.append(new String(cArr, i, i2));
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(C)Luj3; */
        @Override // defpackage.uj3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b a(final char c) {
            return j(new a() { // from class: vj3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // uj3.b.a
                public final void a() throws IOException {
                    this.a.a.append(c);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/CharSequence;)Luj3; */
        @Override // defpackage.uj3
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b b(final CharSequence charSequence) {
            return j(new a() { // from class: xj3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // uj3.b.a
                public final void a() throws IOException {
                    this.a.a.append(charSequence);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final b j(a aVar) {
            try {
                aVar.a();
                return this;
            } catch (IOException e) {
                throw new q14(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends uj3 {
        public final StringBuilder a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(StringBuilder sb) {
            this.a = sb;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.uj3
        public uj3 c(char[] cArr, int i, int i2) {
            this.a.append(cArr, i, i2);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(C)Luj3; */
        @Override // defpackage.uj3
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public c a(char c) {
            this.a.append(c);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/CharSequence;)Luj3; */
        @Override // defpackage.uj3
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public c b(CharSequence charSequence) {
            this.a.append(charSequence);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return this.a.toString();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static uj3 d(Appendable appendable) {
        return appendable instanceof StringBuilder ? new c((StringBuilder) appendable) : new b(appendable);
    }

    public abstract uj3 a(char c2);

    public abstract uj3 b(CharSequence charSequence);

    public abstract uj3 c(char[] cArr, int i, int i2);
}
