package androidx.media3.exoplayer;

import defpackage.gg3;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final long a;
    public final float b;
    public final long c;

    public j(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a == jVar.a && this.b == jVar.b && this.c == jVar.c;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.a), Float.valueOf(this.b), Long.valueOf(this.c));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public long a;
        public float b;
        public long c;

        public b() {
            this.a = -9223372036854775807L;
            this.b = -3.4028235E38f;
            this.c = -9223372036854775807L;
        }

        public j d() {
            return new j(this);
        }

        public b e(long j) {
            gg3.d(j >= 0 || j == -9223372036854775807L);
            this.c = j;
            return this;
        }

        public b f(long j) {
            this.a = j;
            return this;
        }

        public b g(float f) {
            gg3.d(f > 0.0f || f == -3.4028235E38f);
            this.b = f;
            return this;
        }

        public b(j jVar) {
            this.a = jVar.a;
            this.b = jVar.b;
            this.c = jVar.c;
        }
    }
}
