package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fz3 {
    public static final fz3 j = new b().i();
    public final dj1 a;
    public final Double b;
    public final Double c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public Double b;
        public Double c;
        public dj1 a = dj1.x(1, 5);
        public boolean d = true;
        public boolean e = true;
        public boolean f = true;
        public boolean g = true;
        public boolean h = true;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public fz3 i() {
            return new fz3(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fz3(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = !bVar.e;
        this.f = bVar.e;
        this.i = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof fz3)) {
            return false;
        }
        fz3 fz3Var = (fz3) obj;
        return this.a.equals(fz3Var.a) && this.f == fz3Var.f && this.i == fz3Var.i && Objects.equals(this.b, fz3Var.b) && Objects.equals(this.c, fz3Var.c) && this.d == fz3Var.d && this.g == fz3Var.g && this.h == fz3Var.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c, Boolean.valueOf(this.d), Boolean.valueOf(this.f), Boolean.valueOf(this.i), Boolean.valueOf(this.g), Boolean.valueOf(this.h));
    }
}
